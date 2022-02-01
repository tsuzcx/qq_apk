package com.tencent.aelight.camera.ae;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.ae.cmshow.AECMShowLoadingView;
import com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController;
import com.tencent.aelight.camera.ae.cmshow.AECMShowRequestController.Callback;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.FaceRectData;
import com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.ScanViewListener;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAECameraForCMShow;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAECMShow;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class AECMShowCameraUnit
  extends AEPituCameraUnit
  implements AECMShowRequestController.Callback, AECMShowFaceScanView.ScanViewListener
{
  long E = -1L;
  long F = 0L;
  CmShowDataWrapper G;
  volatile boolean H = false;
  private PTFaceAttr aA;
  private float aB = 1.0F;
  private boolean aC = false;
  private long aD = 0L;
  private long aE = 0L;
  private long aF = 0L;
  private int aG = 1000;
  private List<AEResInfo> aH = new ArrayList();
  private Button ap;
  private ImageView aq;
  private ImageView ar;
  private AECMShowFaceScanView as;
  private AECMShowLoadingView at;
  private TextView au;
  private String av = "";
  private AECMShowRequestController aw = new AECMShowRequestController(1, this);
  private AECMShowFaceScanView.FaceRectData ax;
  private volatile boolean ay = false;
  private volatile boolean az = false;
  
  public AECMShowCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    aM();
    aO();
  }
  
  private void a(AEFilterManager paramAEFilterManager)
  {
    this.aA = paramAEFilterManager.getFaceAttr();
    paramAEFilterManager = this.aA;
    if (paramAEFilterManager == null) {
      return;
    }
    paramAEFilterManager = paramAEFilterManager.getAllFacePoints();
    if ((paramAEFilterManager != null) && (paramAEFilterManager.size() != 0))
    {
      this.F = 0L;
      this.E = -1L;
    }
    else if (this.E == -1L)
    {
      this.E = System.currentTimeMillis();
    }
    else
    {
      this.F = (System.currentTimeMillis() - this.E);
    }
    aS();
  }
  
  private void aM()
  {
    this.aH.clear();
    this.aH.add(AEResInfo.LIGHT_RES_BUNDLE_3DMM);
  }
  
  private void aN()
  {
    this.az = true;
    this.aG = 1001;
    this.as.a(1003, null);
    a("triggerState1", "1");
    this.h.queueEvent(new AECMShowCameraUnit.1(this));
  }
  
  private void aO()
  {
    ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.2(this));
  }
  
  private AECMShowFaceScanView.FaceRectData aP()
  {
    Object localObject = this.aA;
    if ((localObject != null) && (((PTFaceAttr)localObject).getAllFacePoints() != null) && (this.aA.getAllFacePoints().size() != 0))
    {
      localObject = new AECMShowFaceScanView.FaceRectData();
      RectF localRectF = new RectF();
      List localList = FaceChangeUtils.getMaxFacePoints(this.aA.getAllFacePoints(), this.aB);
      PointF localPointF1 = (PointF)localList.get(0);
      PointF localPointF2 = (PointF)localList.get(18);
      PointF localPointF3 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF1.y + localPointF2.y) / 2.0F);
      float f1 = TAVStickerUtil.getDistance(localPointF3, (PointF)localList.get(9));
      float f2 = TAVStickerUtil.getDistance(localPointF1, localPointF2) / 2.0F;
      localRectF.left = (localPointF3.x - f2);
      localRectF.right = (localPointF3.x + f2);
      localRectF.top = (localPointF3.y - f1);
      localRectF.bottom = (localPointF3.y + f1);
      ((AECMShowFaceScanView.FaceRectData)localObject).a(localRectF);
      f1 = localPointF2.y;
      f2 = localPointF1.y;
      float f3 = localPointF2.x;
      float f4 = localPointF1.x;
      ((AECMShowFaceScanView.FaceRectData)localObject).a((float)Math.toDegrees(Math.atan2(f1 - f2, f3 - f4)));
      return localObject;
    }
    return aQ();
  }
  
  private AECMShowFaceScanView.FaceRectData aQ()
  {
    if (this.ax == null) {
      this.ax = aR();
    }
    return this.ax;
  }
  
  private AECMShowFaceScanView.FaceRectData aR()
  {
    AECMShowFaceScanView.FaceRectData localFaceRectData = new AECMShowFaceScanView.FaceRectData();
    RectF localRectF = new RectF();
    int i = UIUtils.a(s(), 65.0F);
    localRectF.left = i;
    localRectF.right = (UIUtils.c(s()) - i);
    i = (int)(localRectF.width() / 0.786047F);
    float f1 = UIUtils.d(s()) / 2.0F;
    float f2 = i / 2.0F;
    localRectF.top = ((int)(f1 - f2));
    localRectF.bottom = ((int)(UIUtils.d(s()) / 2.0F + f2));
    localFaceRectData.a(localRectF);
    localFaceRectData.a((int)(localRectF.width() * localRectF.height()));
    return localFaceRectData;
  }
  
  private void aS()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.3(this));
  }
  
  private void aT()
  {
    AEBaseDataReporter.a().aM();
    s().setResult(0);
    s().finish();
  }
  
  private void aU()
  {
    int i = ((Integer)this.aq.getTag()).intValue();
    if (i != 4)
    {
      if (i != 5)
      {
        ba();
        return;
      }
      ba();
      return;
    }
    AEBaseDataReporter.a().aU();
    aV();
  }
  
  private void aV()
  {
    this.p = null;
    this.G = null;
    aX();
    aZ();
  }
  
  private void aW()
  {
    int i = ((Integer)this.ap.getTag()).intValue();
    if (i != 1)
    {
      if (i != 2)
      {
        aY();
        return;
      }
      AEBaseDataReporter.a().aV();
      aV();
      return;
    }
    AEBaseDataReporter.a().aT();
    N();
  }
  
  private void aX()
  {
    this.h.setMaterial(null);
    this.h.setMaterial(this.av);
  }
  
  private void aY()
  {
    this.az = true;
    AEBaseDataReporter.a().aL();
    if (this.h.captureByCameraProxy())
    {
      I();
      return;
    }
    H();
  }
  
  private void aZ()
  {
    this.az = false;
    this.aG = 1000;
    AEBaseDataReporter.a().aI();
    if (this.aE > 0L) {
      AEBaseDataReporter.a().g(System.currentTimeMillis() - this.aE);
    } else if (this.aF > 0L) {
      AEBaseDataReporter.a().a(0, System.currentTimeMillis() - this.aF);
    }
    this.aD = System.currentTimeMillis();
    this.aE = 0L;
    this.aF = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.8(this));
  }
  
  private void ba()
  {
    AEBaseDataReporter.a().aJ();
    Intent localIntent = new Intent(s(), NewPhotoListActivity.class);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 6);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("enter_from", 53);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationAECameraForCMShow.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationAECMShow.a);
    s().startActivityForResult(localIntent, 10006);
  }
  
  private void bb()
  {
    AEQLog.b(this.a, "sendMakeFaceRequests");
    if ((this.p != null) && (!StringUtil.isEmpty(this.p.filePath)))
    {
      a("triggerState1", "1");
      Bitmap localBitmap = BitmapFactory.decodeFile(this.p.filePath);
      ThreadManager.getSubThreadHandler().post(new AECMShowCameraUnit.9(this, localBitmap));
      return;
    }
    AEQLog.d(this.a, "sendMakeFaceRequests: 拍摄结果异常");
  }
  
  protected void N()
  {
    Intent localIntent = new Intent();
    CmShowDataWrapper localCmShowDataWrapper = this.G;
    if (localCmShowDataWrapper != null) {
      localIntent.putExtra("cms_face_data", localCmShowDataWrapper);
    }
    s().setResult(-1, localIntent);
    s().finish();
  }
  
  public void O()
  {
    Iterator localIterator = this.aH.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AEResInfo)localIterator.next();
      String str1 = AEResUtil.f((AEResInfo)localObject);
      localObject = ((AEResInfo)localObject).agentType;
      if ((this.h != null) && (!StringUtil.isEmpty(str1)))
      {
        String str2 = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cmShowSetKapuModel][refreshBundle] bundlePath =");
        localStringBuilder.append(str1);
        QLog.d(str2, 2, localStringBuilder.toString());
        str2 = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cmShowSetKapuModel][refreshBundle] agentType =");
        localStringBuilder.append((String)localObject);
        QLog.d(str2, 2, localStringBuilder.toString());
        this.h.setBundlePath(str1, (String)localObject);
      }
    }
  }
  
  protected void P()
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.4(this));
  }
  
  protected void Q()
  {
    this.aG = 1001;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.5(this));
  }
  
  protected void R()
  {
    this.aG = 1001;
    AEBaseDataReporter.a().aS();
    this.aE = System.currentTimeMillis();
    this.aF = 0L;
    this.aD = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.6(this));
  }
  
  protected void S()
  {
    O();
  }
  
  public void T()
  {
    if (this.aD > 0L)
    {
      AEBaseDataReporter.a().e(System.currentTimeMillis() - this.aD);
      this.aD = 0L;
    }
    Q();
    bb();
  }
  
  public void U() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.aB = (paramInt1 * 1.0F / paramInt3);
  }
  
  protected void a(int paramInt, AEFilterManager paramAEFilterManager)
  {
    if (this.I == null) {
      this.I = paramAEFilterManager;
    }
    a(paramAEFilterManager);
  }
  
  public void a(int paramInt, @Nullable CmShowDataWrapper paramCmShowDataWrapper)
  {
    this.az = true;
    if ((this.I != null) && (paramCmShowDataWrapper != null))
    {
      this.G = paramCmShowDataWrapper;
      if (paramInt == 1)
      {
        ThreadManager.getUIHandler().post(new AECMShowCameraUnit.12(this, paramCmShowDataWrapper));
        return;
      }
      c(paramInt);
      return;
    }
    c(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    if ((paramIntent != null) && (paramIntent.hasExtra("KEY_CMSHOW_DATA")))
    {
      this.G = ((CmShowDataWrapper)paramIntent.getSerializableExtra("KEY_CMSHOW_DATA"));
      N();
    }
  }
  
  protected void a(String paramString1, String paramString2)
  {
    AEQLog.a(this.a, "invokeTriggerState");
    this.h.queueEvent(new AECMShowCameraUnit.10(this, paramString1, paramString2));
  }
  
  protected void c(int paramInt)
  {
    this.aG = 1001;
    AEBaseDataReporter.a().e(0);
    this.aF = System.currentTimeMillis();
    this.aE = 0L;
    this.aD = 0L;
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.7(this, paramInt));
  }
  
  public void d(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowCameraUnit.11(this, paramInt));
  }
  
  public View j()
  {
    this.g = s().getLayoutInflater().inflate(n(), null, false);
    this.S = new VideoStoryCapturePartManager(this.b.getActivity(), this.g, this);
    this.aC = false;
    p();
    aH();
    x();
    return this.g;
  }
  
  public void l()
  {
    super.l();
    this.aC = true;
    if (this.aD > 0L) {
      AEBaseDataReporter.a().e(System.currentTimeMillis() - this.aD);
    } else if (this.aE > 0L) {
      AEBaseDataReporter.a().g(System.currentTimeMillis() - this.aE);
    } else if (this.aF > 0L) {
      AEBaseDataReporter.a().a(0, System.currentTimeMillis() - this.aF);
    }
    AECMShowRequestController localAECMShowRequestController = this.aw;
    if (localAECMShowRequestController != null)
    {
      localAECMShowRequestController.b();
      this.aw = null;
    }
  }
  
  public void m()
  {
    super.m();
  }
  
  protected int n()
  {
    return 2064056346;
  }
  
  public void onAEKitInited()
  {
    super.onAEKitInited();
    this.ay = true;
    this.h.setPauseFilterChainWhenCapture(false);
    if (!StringUtil.isEmpty(this.av))
    {
      this.h.setMaterial(this.av);
      this.H = true;
      AEQLog.a(this.a, "[cmShowFirstFrame] onAEKitInited: 完成设置素材");
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2063990916)
    {
      if (i != 2063991171)
      {
        if (i != 2063991177) {
          return;
        }
        aT();
        return;
      }
      aU();
      return;
    }
    aW();
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    super.onPhotoCaptured(paramAEPhotoCaptureResult);
    paramAEPhotoCaptureResult = new StringBuilder();
    paramAEPhotoCaptureResult.append("onPhotoCaptured: 厘米秀 拍摄完成 ---");
    paramAEPhotoCaptureResult.append(Thread.currentThread());
    Log.d("cmjoy_request", paramAEPhotoCaptureResult.toString());
    P();
    if (this.I != null)
    {
      a("shoot", "1");
      this.as.a(1001, aP());
    }
  }
  
  public void onSetFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    super.onSetFilterProcess(paramAEFilterProcessTex);
    if (this.aw == null) {
      this.aw = new AECMShowRequestController(1, this);
    }
    if (this.aC) {
      this.as.a(1003, null);
    }
  }
  
  protected void p()
  {
    this.m = ((LinearLayout)this.g.findViewById(2063990908));
    this.n = ((RelativeLayout)this.g.findViewById(2063990907));
    this.h = ((AECameraGLSurfaceView)this.g.findViewById(2063990947));
    this.ap = ((Button)this.g.findViewById(2063990916));
    this.ap.setTag(Integer.valueOf(3));
    this.aq = ((ImageView)this.g.findViewById(2063991171));
    this.aq.setTag(Integer.valueOf(5));
    this.ar = ((ImageView)this.g.findViewById(2063991177));
    this.as = ((AECMShowFaceScanView)this.g.findViewById(2063991063));
    this.au = ((TextView)this.g.findViewById(2063991572));
    this.at = ((AECMShowLoadingView)this.g.findViewById(2063990970));
    this.ar.setOnClickListener(this);
    this.aq.setOnClickListener(this);
    this.ap.setOnClickListener(this);
    this.as.setListener(this);
  }
  
  public void reportFirstFrameShown()
  {
    super.reportFirstFrameShown();
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cmShowFirstFrame]:  revisible = ");
    localStringBuilder.append(this.aC);
    AEQLog.a(str, localStringBuilder.toString());
    if ((this.p != null) && (this.G != null) && (this.aC))
    {
      AEQLog.a(this.a, "[cmShowFirstFrame]: 还原捏脸结果");
      aN();
    }
    else if (this.aC)
    {
      AEQLog.a(this.a, "[cmShowFirstFrame]: 重置素材");
      aX();
      aZ();
    }
    else
    {
      AEQLog.a(this.a, "[cmShowFirstFrame]: 首次打开");
      this.aD = System.currentTimeMillis();
    }
    this.aC = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit
 * JD-Core Version:    0.7.0.1
 */