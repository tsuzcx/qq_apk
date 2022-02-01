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
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject2).getApplicationInfo().nativeLibraryDir);
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((Context)localObject2).getApplicationInfo().dataDir);
      ((StringBuilder)localObject1).append("/lib/");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("libARCloud.so");
    Object localObject1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Context)localObject2).getFilesDir());
    localStringBuilder.append("libARCloud.so");
    localObject2 = localStringBuilder.toString();
    if (!new File((String)localObject1).exists()) {
      if (new File((String)localObject2).exists()) {
        localObject1 = localObject2;
      } else {
        localObject1 = "";
      }
    }
    if (!((String)localObject1).equals("")) {
      try
      {
        System.load((String)localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("load ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" successfully!");
        QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject2).toString());
        jdField_k_of_type_Boolean = true;
        return;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" failed! ");
        localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
        QLog.i("AREngine_ARCloudControl", 1, localStringBuilder.toString());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("AREngine_ARCloudControl", 2, "loadSo suc");
    }
    jdField_k_of_type_Boolean = false;
  }
  
  private void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    QLog.i("AREngine_ARCloudControl", 1, "requestToCheckLBSLocation.");
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = paramARCloudRecogResult;
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      if (((Handler)localObject).hasMessages(2)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, new ARCloudControl.8(this));
      ((Message)localObject).what = 2;
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, this.jdField_g_of_type_Int);
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
      Object localObject = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject != null)
      {
        if (((Handler)localObject).hasMessages(2)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        }
        localObject = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, new ARCloudControl.10(this));
        ((Message)localObject).what = 2;
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, this.jdField_g_of_type_Int);
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
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("loadNativeLibrary");
          localStringBuilder1.append(jdField_l_of_type_Boolean);
          localStringBuilder1.append(", loadSoSuccess=");
          localStringBuilder1.append(jdField_k_of_type_Boolean);
          QLog.d("AREngine_ARCloudControl", 2, localStringBuilder1.toString());
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
              break label190;
            }
            bool = true;
            jdField_k_of_type_Boolean = bool;
          }
          catch (Throwable localThrowable)
          {
            jdField_k_of_type_Boolean = false;
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("load ARCloud so failed. err msg = ");
            localStringBuilder2.append(localThrowable.getMessage());
            QLog.i("AREngine_ARCloudControl", 1, localStringBuilder2.toString());
          }
          QLog.d("AREngine_ARCloudControl", 1, "loadArNativeSo");
          bool = jdField_k_of_type_Boolean;
          return bool;
        }
        else
        {
          QLog.i("AREngine_ARCloudControl", 1, "load ARCloud so failed. ARCloud so is not exist!");
          bool = jdField_k_of_type_Boolean;
          return bool;
        }
      }
      finally {}
      label190:
      boolean bool = false;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    QLog.i("AREngine_ARCloudControl", 1, "saveTmpPreviewData should nerver be called ");
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if ((arrayOfByte == null) || (arrayOfByte.length != paramArrayOfByte.length)) {
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
    ARCloudFileUpload localARCloudFileUpload = this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
    if (localARCloudFileUpload != null) {
      localARCloudFileUpload.a();
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
    boolean bool1;
    Object localObject;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect != null))
    {
      l1 = System.currentTimeMillis();
      bool1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a(paramArrayOfByte);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.c(bool1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isSameSceneWithBestImg = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" cost time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject).append("ms");
      QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect == null) {
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback;
      if (localObject != null) {
        ((ARCloudControl.ARCloudControlCallback)localObject).b();
      }
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a(paramArrayOfByte, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      if ((bool2) && (this.jdField_m_of_type_Long == 0L)) {
        this.jdField_m_of_type_Long = System.currentTimeMillis();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback;
      int i1;
      if (localObject != null)
      {
        bool1 = ((ARCloudControl.ARCloudControlCallback)localObject).a();
        l1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.a();
        if ((bool2) && (!this.jdField_m_of_type_Boolean) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudControl", 2, "selectImage save tmp preview data");
          }
          b(paramArrayOfByte);
        }
        for (;;)
        {
          bool1 = false;
          break label476;
          if ((!bool2) || (!this.jdField_m_of_type_Boolean) || (System.currentTimeMillis() >= this.n + l1)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARCloudControl", 2, "selectImage update tmp preview data");
          }
          b(paramArrayOfByte);
        }
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          if (this.jdField_m_of_type_Boolean)
          {
            bool1 = bool2;
            if (System.currentTimeMillis() >= this.n + l1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARCloudControl", 2, "selectImage use tmp preview data");
              }
              paramArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
              k();
              bool1 = true;
              i1 = 1;
              break label478;
            }
          }
        }
        label476:
        i1 = 0;
        label478:
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback.a(bool1);
      }
      else
      {
        i1 = 0;
        bool1 = bool2;
      }
      if (!bool1)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("selectImage total time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long) }));
      ((StringBuilder)localObject).append(":select result is ");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("AREngine_ARCloudControl", 1, ((StringBuilder)localObject).toString());
      this.jdField_f_of_type_Long = (System.currentTimeMillis() - this.jdField_k_of_type_Long);
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_i_of_type_Boolean) {
        ThreadManager.getUIHandler().post(new ARCloudControl.2(this));
      }
      if (i1 == 0) {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.a();
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback;
      if (localObject != null) {
        ((ARCloudControl.ARCloudControlCallback)localObject).b(true);
      }
      if (!this.jdField_f_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback;
        if (localObject != null)
        {
          l1 = ((ARCloudControl.ARCloudControlCallback)localObject).b();
          ScanEntranceReport.a().a(l1, this.jdField_l_of_type_Long, this.jdField_m_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect.jdField_c_of_type_Int);
          ARDebugReport.a().a(l1, this.jdField_m_of_type_Long);
          this.jdField_f_of_type_Boolean = true;
        }
      }
      a(new ARCloudControl.3(this, paramArrayOfByte));
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
    paramARCloudControlCallback = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    long l1;
    if (paramARCloudControlCallback != null) {
      l1 = ARRecognition.a(paramARCloudControlCallback.recognitions);
    } else {
      l1 = 0L;
    }
    this.jdField_a_of_type_Long = l1;
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ARReport.a().c(System.currentTimeMillis() - l2, jdField_k_of_type_Boolean);
    return true;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect;
    if (localObject != null)
    {
      ((ARCloudImageSelect)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudImageSelect = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager;
    if (localObject != null)
    {
      ((ARCloudPretreatmentManager)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPretreatmentManager = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl$ARCloudControlCallback = null;
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
    if (localObject != null) {
      ((ARCloudFileUpload)localObject).b();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arCloudReport mResult:");
    localStringBuilder.append(this.jdField_j_of_type_Int);
    QLog.d("AREngine_ARCloudControl", 2, localStringBuilder.toString());
    ARReport.a().a(this.jdField_f_of_type_Long, this.jdField_g_of_type_Long, this.jdField_h_of_type_Long, this.jdField_h_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_i_of_type_Int, this.jdField_i_of_type_Long, this.jdField_j_of_type_Long, this.jdField_e_of_type_Long - this.jdField_b_of_type_Long, this.jdField_j_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCloudControl
 * JD-Core Version:    0.7.0.1
 */