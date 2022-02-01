package com.tencent.mobileqq.ar.arengine;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDebugReport;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ArCloudNativeSoLoader;
import com.tencent.mobileqq.ar.ScanEntranceReport;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class ARCloudControl
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static boolean jdField_k_of_type_Boolean = false;
  private static boolean jdField_l_of_type_Boolean = false;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  ARCloudFileUpload jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
  private ARCloudControl.ARCloudControlCallback jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback = null;
  ARCloudImageSelect jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect;
  ARCloudPretreatmentManager jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager;
  private ARCloudRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
  ArLBSActivity jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity;
  SosoInterfaceOnLocationListener jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new ARCloudControl.7(this, 0, true, true, 3000L, true, false, "QQARScan");
  String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean = false;
  int jdField_d_of_type_Int;
  long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean = true;
  int jdField_e_of_type_Int;
  long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean = true;
  int jdField_f_of_type_Int;
  long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  int jdField_g_of_type_Int = 10000;
  long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  int jdField_h_of_type_Int;
  long jdField_h_of_type_Long;
  private boolean jdField_h_of_type_Boolean;
  int jdField_i_of_type_Int;
  long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  int jdField_j_of_type_Int = -1;
  long jdField_j_of_type_Long;
  private boolean jdField_j_of_type_Boolean = true;
  long jdField_k_of_type_Long = 0L;
  private long jdField_l_of_type_Long;
  private long jdField_m_of_type_Long;
  private boolean jdField_m_of_type_Boolean;
  private long n;
  
  public static void a()
  {
    Object localObject2 = BaseApplicationImpl.sApplication;
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject1 = ((Context)localObject2).getApplicationInfo().nativeLibraryDir + "/";
      localObject1 = (String)localObject1 + "libARCloud.so";
      localObject2 = ((Context)localObject2).getFilesDir() + "libARCloud.so";
      if (!new File((String)localObject1).exists()) {
        break label172;
      }
    }
    for (;;)
    {
      if (!((String)localObject1).equals(""))
      {
        try
        {
          System.load((String)localObject1);
          QLog.i("AREngine_ARCloudControl", 1, "load " + (String)localObject1 + " successfully!");
          jdField_k_of_type_Boolean = true;
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          label172:
          QLog.i("AREngine_ARCloudControl", 1, "load " + (String)localObject1 + " failed! " + localUnsatisfiedLinkError.getMessage());
        }
        localObject1 = ((Context)localObject2).getApplicationInfo().dataDir + "/lib/";
        break;
        if (!new File((String)localObject2).exists()) {
          break label248;
        }
        localObject1 = localObject2;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("AREngine_ARCloudControl", 2, "loadSo suc");
      }
      jdField_k_of_type_Boolean = false;
      return;
      label248:
      localObject1 = "";
    }
  }
  
  private void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation.");
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = paramARCloudRecogResult;
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, new ARCloudControl.8(this));
      localMessage.what = 2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_g_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqArModelArLBSActivity = ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. not grant");
        ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).requestPermissions(new ARCloudControl.9(this), 1, new String[] { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      QLog.d("AREngine_ARCloudControl", 1, "checkSelfPermission. grant");
      grant();
      return;
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
  }
  
  private void a(ARCloudReqInfo paramARCloudReqInfo)
  {
    QLog.i("AREngine_ARCloudControl", 1, "[DEBUG_SCAN_yt_face] requestToUploadImg. : ");
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null)
    {
      this.jdField_d_of_type_Boolean = true;
      this.jdField_h_of_type_Int += 1;
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        }
        Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, new ARCloudControl.5(this));
        localMessage.what = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_g_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a(paramARCloudReqInfo, new ARCloudControl.6(this, l1, paramARCloudReqInfo));
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    a(paramRunnable, 0L);
  }
  
  private void a(Runnable paramRunnable, long paramLong)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
      }
      return;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocationInternal.");
    System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null)
    {
      this.jdField_j_of_type_Boolean = true;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        }
        Message localMessage = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, new ARCloudControl.10(this));
        localMessage.what = 2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, this.jdField_g_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a(paramString, paramInt1, paramInt2, new ARCloudControl.11(this));
    }
  }
  
  private void a(byte[] paramArrayOfByte, ArrayList<ARRecognition> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager != null)
    {
      ARCloudReqInfo localARCloudReqInfo = new ARCloudReqInfo();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager.a(paramArrayOfByte, paramArrayList, new ARCloudControl.4(this, localARCloudReqInfo), this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  public static boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudControl", 2, "loadNativeLibrary" + jdField_l_of_type_Boolean + ", loadSoSuccess=" + jdField_k_of_type_Boolean);
        }
        if (jdField_l_of_type_Boolean)
        {
          bool = jdField_k_of_type_Boolean;
          return bool;
        }
        if (ArCloudNativeSoLoader.a(ArCloudNativeSoLoader.a()))
        {
          jdField_l_of_type_Boolean = true;
          try
          {
            if (ArCloudNativeSoLoader.a(ArCloudNativeSoLoader.a()) != 0) {
              break label167;
            }
            jdField_k_of_type_Boolean = bool;
          }
          catch (Throwable localThrowable)
          {
            jdField_k_of_type_Boolean = false;
            QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. err msg = " + localThrowable.getMessage());
            continue;
          }
          QLog.d("AREngine_ARCloudControl", 1, "loadArNativeSo");
          bool = jdField_k_of_type_Boolean;
          continue;
        }
        QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. ARCloud so is not exist!");
      }
      finally {}
      bool = jdField_k_of_type_Boolean;
      continue;
      label167:
      bool = false;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    QLog.i("AREngine_ARCloudControl", 1, "saveTmpPreviewData should nerver be called ");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramArrayOfByte.length)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
      this.jdField_m_of_type_Boolean = true;
      if (this.n <= 0L) {
        this.n = System.currentTimeMillis();
      }
    }
  }
  
  private void i()
  {
    QLog.i("AREngine_ARCloudControl", 1, "startUploadThread.");
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ARCloudEnginePreprocessThread", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return;
    }
  }
  
  private void j()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stopUploadThread.");
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      return;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_m_of_type_Boolean = false;
    this.n = 0L;
  }
  
  private void l()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stopUploadingImg.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    }
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_k_of_type_Long == 0L) {
      this.jdField_k_of_type_Long = System.currentTimeMillis();
    }
    long l1;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect != null))
    {
      l1 = System.currentTimeMillis();
      bool1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a(paramArrayOfByte);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.c(bool1);
      QLog.i("AREngine_ARCloudControl", 1, "isSameSceneWithBestImg = " + bool1 + " cost time:" + (System.currentTimeMillis() - l1) + "ms");
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect == null)) {
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      QLog.i("AREngine_ARCloudControl", 1, "selectImage start");
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "firstTimeStart" }));
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_l_of_type_Long == 0L) {
        this.jdField_l_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_i_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new ARCloudControl.1(this));
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.b();
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a(paramArrayOfByte, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if ((bool1) && (this.jdField_m_of_type_Long == 0L)) {
      this.jdField_m_of_type_Long = System.currentTimeMillis();
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback != null)
    {
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.a();
      l1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.a();
      if ((bool1) && (!this.jdField_m_of_type_Boolean) && (bool2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudControl", 2, "selectImage save tmp preview data");
        }
        b(paramArrayOfByte);
        i1 = 0;
        bool1 = false;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.a(bool1);
      }
    }
    for (;;)
    {
      if (!bool1)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
        if ((bool1) && (this.jdField_m_of_type_Boolean) && (System.currentTimeMillis() < this.n + l1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudControl", 2, "selectImage update tmp preview data");
          }
          b(paramArrayOfByte);
          i1 = 0;
          bool1 = false;
          break;
        }
        if ((bool1) || (!this.jdField_m_of_type_Boolean) || (System.currentTimeMillis() < l1 + this.n)) {
          break label675;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ARCloudControl", 2, "selectImage use tmp preview data");
        }
        paramArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        k();
        i1 = 1;
        bool1 = true;
        break;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long) }) + ":select result is " + bool1);
      this.jdField_f_of_type_Long = (System.currentTimeMillis() - this.jdField_k_of_type_Long);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_i_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new ARCloudControl.2(this));
      }
      if (i1 != 0) {}
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.b(true);
        }
        if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback != null))
        {
          l1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.b();
          ScanEntranceReport.a().a(l1, this.jdField_l_of_type_Long, this.jdField_m_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.jdField_c_of_type_Int);
          ARDebugReport.a().a(l1, this.jdField_m_of_type_Long);
          this.jdField_f_of_type_Boolean = true;
        }
        a(new ARCloudControl.3(this, paramArrayOfByte));
        return;
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a();
      }
      label675:
      i1 = 0;
      break;
      i1 = 0;
    }
  }
  
  public boolean a(ARCloudControl.ARCloudControlCallback paramARCloudControlCallback, AppInterface paramAppInterface, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, ARCommonConfigInfo paramARCommonConfigInfo)
  {
    long l2 = System.currentTimeMillis();
    jdField_k_of_type_Boolean = a();
    ARReport.a().b(System.currentTimeMillis() - l2, jdField_k_of_type_Boolean);
    if (!jdField_k_of_type_Boolean) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect = new ARCloudImageSelect(ARCloudImageSelect.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager = new ARCloudPretreatmentManager();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a(BaseApplicationImpl.getContext().getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager.a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_f_of_type_Int = paramInt3;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback = paramARCloudControlCallback;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload = new ARCloudFileUpload(paramAppInterface, true);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) {}
    for (long l1 = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions);; l1 = 0L)
    {
      this.jdField_a_of_type_Long = l1;
      this.jdField_e_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      ARReport.a().c(System.currentTimeMillis() - l2, jdField_k_of_type_Boolean);
      return true;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    i();
    k();
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    g();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    QLog.i("AREngine_ARCloudControl", 1, String.format("selectImage total time cost:start Time is %s", new Object[] { "resume" }));
    this.jdField_e_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    i();
    k();
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Long = System.currentTimeMillis();
    h();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    j();
    l();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user denied = ");
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
  }
  
  public void e()
  {
    QLog.i("AREngine_ARCloudControl", 1, "stop.");
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    j();
    l();
  }
  
  public void f()
  {
    QLog.i("AREngine_ARCloudControl", 1, "uninit");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager.b();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback = null;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.b();
    }
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  public void g()
  {
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = -1;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("AREngine_ARCloudControl", 1, "CheckPermission user grant = ");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
  }
  
  public void h()
  {
    QLog.d("AREngine_ARCloudControl", 2, "arCloudReport mResult:" + this.jdField_j_of_type_Int);
    ARReport.a().a(this.jdField_f_of_type_Long, this.jdField_g_of_type_Long, this.jdField_h_of_type_Long, this.jdField_h_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_i_of_type_Int, this.jdField_i_of_type_Long, this.jdField_j_of_type_Long, this.jdField_e_of_type_Long - this.jdField_b_of_type_Long, this.jdField_j_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl
 * JD-Core Version:    0.7.0.1
 */