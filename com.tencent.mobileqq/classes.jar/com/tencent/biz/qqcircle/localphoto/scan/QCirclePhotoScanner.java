package com.tencent.biz.qqcircle.localphoto.scan;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.gyailib.library.GYAISceneChain;
import com.gyailib.library.SDKDeviceConfig;
import com.gyailib.library.SDKModelConfig;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.api.IAEPhotoAIManager;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.biz.qqcircle.localphoto.scan.data.LocalPhotoInfo;
import com.tencent.biz.qqcircle.localphoto.scan.datamanager.QCircleScanPhotoInfoManager;
import com.tencent.biz.qqcircle.localphoto.scan.utils.Image2BitmapUtils;
import com.tencent.biz.qqcircle.localphoto.scan.utils.ScanExifHelper;
import com.tencent.biz.qqcircle.localphoto.scan.utils.ScanTagHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

public class QCirclePhotoScanner
  extends HandlerThread
{
  private static final String a = "QCirclePhotoScanner";
  private QCirclePhotoScanner.Status b = QCirclePhotoScanner.Status.CREATED;
  private Handler c;
  private final LocalPhotoCursor d;
  private LinkedList<LocalPhotoInfo> e;
  private int f;
  private ScanTagHelper g;
  private GYAISceneChain h;
  private PerformanceRecorder i;
  private byte[] j;
  
  public QCirclePhotoScanner(LocalPhotoCursor paramLocalPhotoCursor)
  {
    super(a);
    this.d = paramLocalPhotoCursor;
    start();
  }
  
  private boolean a(String paramString, QCirclePhotoScanner.StopReason paramStopReason)
  {
    LinkedList localLinkedList = this.e;
    if ((localLinkedList != null) && (localLinkedList.size() != 0)) {
      return true;
    }
    QLog.e(a, 1, String.format(Locale.CHINESE, "[%s] local photo is empty, mLocalPhotoInfoList is %s", new Object[] { paramString, this.e }));
    a(paramStopReason);
    return false;
  }
  
  private void c()
  {
    QLog.i(a, 1, "[prepareEnvironment]");
    if (this.b != QCirclePhotoScanner.Status.CREATED) {
      return;
    }
    QCirclePhotoScanner.InitGYSDKResult localInitGYSDKResult = d();
    if (localInitGYSDKResult == QCirclePhotoScanner.InitGYSDKResult.FAILED)
    {
      a(QCirclePhotoScanner.StopReason.ENV_FAILED);
      return;
    }
    if (localInitGYSDKResult == QCirclePhotoScanner.InitGYSDKResult.SUCCEED)
    {
      this.i = new PerformanceRecorder();
      this.j = new byte[8192];
      this.b = QCirclePhotoScanner.Status.READY;
      this.c.sendEmptyMessage(2);
    }
  }
  
  private QCirclePhotoScanner.InitGYSDKResult d()
  {
    try
    {
      if (this.h != null) {
        return QCirclePhotoScanner.InitGYSDKResult.IGNORE;
      }
      if (!i())
      {
        if (this.f < 2)
        {
          this.f += 1;
          this.c.sendEmptyMessageDelayed(1, 5000L);
        }
        return QCirclePhotoScanner.InitGYSDKResult.IGNORE;
      }
      if (!j()) {
        return QCirclePhotoScanner.InitGYSDKResult.FAILED;
      }
      Object localObject1 = new SDKDeviceConfig();
      ((SDKDeviceConfig)localObject1).setDevice("ARM");
      this.h = new GYAISceneChain();
      if (this.h.initInstance((SDKDeviceConfig)localObject1) != 0) {
        return QCirclePhotoScanner.InitGYSDKResult.FAILED;
      }
      localObject1 = new SDKModelConfig();
      Object localObject2 = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getLightModelDir();
      ((SDKModelConfig)localObject1).modelPaths = new HashMap();
      Map localMap = ((SDKModelConfig)localObject1).modelPaths;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("LightSceneClassify.bundle");
      localMap.put("scene-dir", localStringBuilder.toString());
      localMap = ((SDKModelConfig)localObject1).modelPaths;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("LightFaceModel.bundle");
      localMap.put("face-dir", localStringBuilder.toString());
      localMap = ((SDKModelConfig)localObject1).modelPaths;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("LightGenderModel.bundle");
      localMap.put("gender-dir", localStringBuilder.toString());
      int k = this.h.setupWithModel((SDKModelConfig)localObject1);
      if (k != 0)
      {
        this.h = null;
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init error code: ");
        ((StringBuilder)localObject2).append(k);
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        a(QCirclePhotoScanner.StopReason.ENV_FAILED);
        return QCirclePhotoScanner.InitGYSDKResult.FAILED;
      }
      this.g = new ScanTagHelper();
      this.g.a(this.h);
      return QCirclePhotoScanner.InitGYSDKResult.SUCCEED;
    }
    catch (Exception localException)
    {
      QLog.e(a, 1, "initGYAiSceneChain", localException);
    }
    return QCirclePhotoScanner.InitGYSDKResult.FAILED;
  }
  
  private void e()
  {
    QLog.i(a, 1, "[prepareLocalPhoto] in");
    long l = System.currentTimeMillis();
    this.b = QCirclePhotoScanner.Status.RUNNING;
    this.e = this.d.a();
    if (!a("prepareLocalPhoto", QCirclePhotoScanner.StopReason.EMPTY_LOCAL_PHOTO)) {
      return;
    }
    QLog.i(a, 1, String.format(Locale.CHINESE, "[prepareLocalPhoto] the count of local photo is %d", new Object[] { Integer.valueOf(this.e.size()) }));
    List localList = QCircleScanPhotoInfoManager.a().c();
    ListIterator localListIterator = this.e.listIterator();
    while (localListIterator.hasNext()) {
      if (localList.contains(Integer.valueOf(((LocalPhotoInfo)localListIterator.next()).a))) {
        localListIterator.remove();
      }
    }
    if (!a("prepareLocalPhoto", QCirclePhotoScanner.StopReason.EMPTY_LOCAL_PHOTO)) {
      return;
    }
    QLog.i(a, 1, String.format(Locale.CHINESE, "[prepareLocalPhoto] mLocalPhotoInfoList.size=%d, cost=%d", new Object[] { Integer.valueOf(this.e.size()), Long.valueOf(System.currentTimeMillis() - l) }));
    g();
  }
  
  private void f()
  {
    QLog.d(a, 4, "[processPhotoFromQueue] in");
    if (this.b != QCirclePhotoScanner.Status.RUNNING) {
      return;
    }
    if (!a("processPhotoFromQueue", QCirclePhotoScanner.StopReason.COMPLETED)) {
      return;
    }
    LocalPhotoInfo localLocalPhotoInfo = (LocalPhotoInfo)this.e.poll();
    if (QLog.isDevelopLevel()) {
      QLog.i(a, 4, String.format(Locale.CHINESE, "[processPhotoFromQueue] index=%d, %s", new Object[] { Integer.valueOf(this.i.a()), localLocalPhotoInfo }));
    }
    if (localLocalPhotoInfo == null)
    {
      g();
      return;
    }
    long l1 = System.currentTimeMillis();
    ScanExifHelper.a(localLocalPhotoInfo);
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 4, String.format(Locale.CHINESE, "[processPhotoFromQueue] scan exif cost=%d, %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1), localLocalPhotoInfo }));
    }
    this.i.a(QCirclePhotoScanner.Task.SCAN_EXIF, System.currentTimeMillis() - l1);
    long l2 = System.currentTimeMillis();
    Bitmap localBitmap = Image2BitmapUtils.a(localLocalPhotoInfo.b, 512, this.j);
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 4, String.format(Locale.CHINESE, "[processPhotoFromQueue] image to bitmap cost=%d, %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), localLocalPhotoInfo }));
    }
    this.i.a(QCirclePhotoScanner.Task.DECODE_IMAGE, System.currentTimeMillis() - l2);
    l2 = System.currentTimeMillis();
    boolean bool = this.g.a(localLocalPhotoInfo, localBitmap);
    if (QLog.isDevelopLevel()) {
      QLog.d(a, 4, String.format(Locale.CHINESE, "[processPhotoFromQueue] scan tag cost=%d, %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), localLocalPhotoInfo }));
    }
    this.i.a(QCirclePhotoScanner.Task.SCAN_TAG, System.currentTimeMillis() - l2);
    this.i.a(System.currentTimeMillis() - l1);
    QCircleScanPhotoInfoManager.a().a(localLocalPhotoInfo, false, bool, false);
    g();
  }
  
  private void g()
  {
    if (this.b == QCirclePhotoScanner.Status.RUNNING) {
      this.c.sendEmptyMessage(3);
    }
  }
  
  private void h()
  {
    QLog.i(a, 1, "[release] in");
    Object localObject = this.h;
    if (localObject != null)
    {
      ((GYAISceneChain)localObject).cleanupModelData();
      this.h = null;
    }
    localObject = this.e;
    if (localObject != null) {
      ((LinkedList)localObject).clear();
    }
    if (this.j != null) {
      this.j = null;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      quitSafely();
      return;
    }
    quit();
  }
  
  private boolean i()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(AEResInfo.AE_RES_BASE_PACKAGE);
    ((List)localObject).add(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    ((List)localObject).add(AEResInfo.LIGHT_RES_BUNDLE_GENDER);
    ((List)localObject).add(AEResInfo.LIGHT_RES_BUNDLE_SCENE);
    localObject = ((List)localObject).iterator();
    boolean bool = true;
    while (((Iterator)localObject).hasNext())
    {
      AEResInfo localAEResInfo = (AEResInfo)((Iterator)localObject).next();
      String str;
      StringBuilder localStringBuilder;
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isAEResExist(localAEResInfo))
      {
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isAIFilterResExist], resInfo=");
        localStringBuilder.append(localAEResInfo);
        localStringBuilder.append(" local file exists");
        QLog.i(str, 1, localStringBuilder.toString());
      }
      else
      {
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[isAIFilterResExist], resInfo=");
        localStringBuilder.append(localAEResInfo);
        localStringBuilder.append(" start download");
        QLog.i(str, 1, localStringBuilder.toString());
        ((IAEResUtil)QRoute.api(IAEResUtil.class)).tryDownloadLightAdditionBundle(QCircleApplication.APP, localAEResInfo.resPrefix);
        bool = false;
      }
    }
    if (!((IAEPhotoAIManager)QRoute.api(IAEPhotoAIManager.class)).isPhotoAIResExist())
    {
      ((IAEPhotoAIManager)QRoute.api(IAEPhotoAIManager.class)).downloadPhotoAIRes();
      QLog.i(a, 1, "[isAIFilterResExist], photo ai res not exist.");
      bool = false;
    }
    return bool;
  }
  
  private boolean j()
  {
    String str1 = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    String str2 = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initAEKit modelPath = ");
    localStringBuilder.append(str1);
    QLog.i(str2, 1, localStringBuilder.toString());
    AEModule.setContext(QCircleApplication.APP.getApplicationContext());
    FeatureManager.setModelDir(str1);
    FeatureManager.setSoDir(str1);
    FeatureManager.Features.YT_COMMON.setAuthMode(1);
    FeatureManager.loadBasicFeatures();
    if (!FeatureManager.Features.IMAGE_ALGO.init())
    {
      QLog.e(a, 1, "initLightSDK---features init fail");
      return false;
    }
    return true;
  }
  
  public void a()
  {
    int k = QCirclePhotoScanner.2.a[this.b.ordinal()];
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3) {
          return;
        }
        this.b = QCirclePhotoScanner.Status.RUNNING;
        this.c.sendEmptyMessage(3);
        return;
      }
      this.c.sendEmptyMessage(2);
      return;
    }
    this.c.sendEmptyMessage(1);
  }
  
  public void a(@NonNull QCirclePhotoScanner.StopReason paramStopReason)
  {
    if (this.b == QCirclePhotoScanner.Status.STOP) {
      return;
    }
    QLog.i(a, 1, String.format(Locale.CHINESE, "[stopScan] stopReason: %s, performance: %s", new Object[] { paramStopReason.name(), this.i }));
    this.b = QCirclePhotoScanner.Status.STOP;
    this.c.removeMessages(3);
    this.c.sendEmptyMessage(4);
    QCircleScanPhotoInfoManager.a().b();
  }
  
  public void b()
  {
    if (this.b != QCirclePhotoScanner.Status.STOP) {
      this.b = QCirclePhotoScanner.Status.SUSPENDED;
    }
  }
  
  protected void onLooperPrepared()
  {
    this.c = new Handler(getLooper(), new QCirclePhotoScanner.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.QCirclePhotoScanner
 * JD-Core Version:    0.7.0.1
 */