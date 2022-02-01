package com.tencent.mobileqq.ar.model;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMarkerTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARTransferResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.GeneralARResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.Interactive3DResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.MultiFragmentAnimARResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.NormalVideoARResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderableInfo;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager;
import com.tencent.mobileqq.ar.ARRenderModel.SensorTrackManager.ARSensorTrackCallback;
import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.ARVideoUtil;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo.ARVideoLayout;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudControl;
import com.tencent.mobileqq.ar.arengine.ARCloudControl.ARCloudControlCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARCloudPreOcrResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogRspFaceResult;
import com.tencent.mobileqq.ar.arengine.ARCloudSceneRecogResult;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.mobileqq.ar.arengine.AREngineCallbackFromUI;
import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.mobileqq.ar.arengine.ARLocalControl.ARLocalRecogCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalFaceRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalRecogResultBase;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult;
import com.tencent.mobileqq.ar.arengine.ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager.ARMarkerResourceCallback;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class QQARSession
  extends AbstractSession
  implements Camera.PreviewCallback, ARRenderManagerCallBack, SensorTrackManager.ARSensorTrackCallback, ARCloudControl.ARCloudControlCallback, AREngineCallbackFromUI, ARLocalControl.ARLocalRecogCallback, ARMarkerResourceManager.ARMarkerResourceCallback
{
  private static QQARSession jdField_a_of_type_ComTencentMobileqqArModelQQARSession = null;
  public static boolean a;
  private static boolean jdField_e_of_type_Boolean = true;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge = null;
  private ARTransferDoorLogicManager jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
  private SensorTrackManager jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager = null;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = null;
  ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = null;
  public ArCloudConfigInfo a;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = null;
  private ARCloudControl jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = null;
  private ARCloudRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
  private AREngineCallback jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback = null;
  public ARLocalControl a;
  private ARLocalFaceRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
  private ARLocalMarkerRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
  private ARMIGObjectClassifyResult jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
  private ARMarkerResourceManager jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager = null;
  private UniformGLRenderManager jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  private String jdField_a_of_type_JavaLangString = "0";
  private ArrayList<ArCloudConfigInfo> jdField_a_of_type_JavaUtilArrayList = null;
  private final long jdField_b_of_type_Long = 5L;
  ArCloudConfigInfo jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private ARLocalFaceRecogResult jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
  private ARLocalMarkerRecogResult jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
  private ArrayList<Runnable> jdField_b_of_type_JavaUtilArrayList = null;
  public boolean b;
  private final long jdField_c_of_type_Long = 2183L;
  private ArCloudConfigInfo jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  public boolean c;
  private long jdField_d_of_type_Long = 0L;
  private ArCloudConfigInfo jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  boolean jdField_d_of_type_Boolean = false;
  int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = 0L;
  private int jdField_f_of_type_Int = 5;
  private long jdField_f_of_type_Long = 0L;
  private final boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 5;
  private long jdField_g_of_type_Long = 0L;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 5;
  private long jdField_h_of_type_Long = 0L;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 5;
  private long jdField_i_of_type_Long = 0L;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = 5;
  private long jdField_j_of_type_Long = 0L;
  private volatile boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = 5;
  private long jdField_k_of_type_Long = 0L;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int = 0;
  private long jdField_l_of_type_Long = 0L;
  private boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = 0;
  private long jdField_m_of_type_Long = 0L;
  private boolean jdField_m_of_type_Boolean = true;
  private int jdField_n_of_type_Int = 0;
  private long jdField_n_of_type_Long = 0L;
  private boolean jdField_n_of_type_Boolean = false;
  private int jdField_o_of_type_Int = 0;
  private long jdField_o_of_type_Long = 0L;
  private boolean jdField_o_of_type_Boolean = false;
  private int jdField_p_of_type_Int = 17;
  private long jdField_p_of_type_Long = 0L;
  private boolean jdField_p_of_type_Boolean = false;
  private int jdField_q_of_type_Int = 0;
  private long jdField_q_of_type_Long = 0L;
  private volatile boolean jdField_q_of_type_Boolean = false;
  private int jdField_r_of_type_Int = 0;
  private long jdField_r_of_type_Long = 0L;
  private boolean jdField_r_of_type_Boolean = false;
  private int jdField_s_of_type_Int = 0;
  private long jdField_s_of_type_Long;
  private boolean jdField_s_of_type_Boolean;
  private volatile int jdField_t_of_type_Int = 0;
  private long jdField_t_of_type_Long = 0L;
  private boolean jdField_t_of_type_Boolean;
  private long jdField_u_of_type_Long = 0L;
  private boolean jdField_u_of_type_Boolean = true;
  private long jdField_v_of_type_Long = 0L;
  private boolean jdField_v_of_type_Boolean = true;
  private boolean w = true;
  private boolean x;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public QQARSession()
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl = null;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 4096L;
    this.jdField_b_of_type_Int = 1;
    jdField_e_of_type_Boolean = false;
    CameraProxy.a().b(this);
  }
  
  private void A()
  {
    if (this.jdField_t_of_type_Int != 1) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.c();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager == null);
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.d();
  }
  
  private void B()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        QLog.i("AREngine_QQARSession", 1, "removeAllTask. task count = " + this.jdField_b_of_type_JavaUtilArrayList.size());
        int i1 = 0;
        while (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks((Runnable)this.jdField_b_of_type_JavaUtilArrayList.get(i1));
          i1 += 1;
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
  }
  
  public static ARRenderResourceInfo a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean, long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramArCloudConfigInfo == null) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 0)
    {
      localObject1 = ARResouceDir.b(paramArCloudConfigInfo);
      localObject2 = ARResouceDir.c(paramArCloudConfigInfo);
      localObject3 = ARResouceDir.d(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      localObject4 = ARVideoUtil.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.e);
      paramArCloudConfigInfo = new GeneralARResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, (String)localObject2, (String)localObject1, (String)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject4, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", resPath = " + paramArCloudConfigInfo.c + ", luaPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", musicPath = " + paramArCloudConfigInfo.jdField_d_of_type_JavaLangString + ", recogType = " + paramLong);
      return paramArCloudConfigInfo;
    }
    int i2;
    int i1;
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 2) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 3))
    {
      if (!VersionUtils.d())
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. NOT IceScreamSandwich.");
        return null;
      }
      if (ARVideoUtil.a())
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
        return null;
      }
      localObject2 = ARResouceDir.e(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
        return null;
      }
      localObject1 = new ARTarget(paramArCloudConfigInfo);
      i2 = ARVideoUtil.a((ARTarget)localObject1);
      i1 = i2;
      if (i2 == 0) {
        i1 = 2147483647;
      }
      localObject1 = ARVideoUtil.a((ARTarget)localObject1);
      i2 = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (KeyingParams)((Pair)localObject1).second;
      localObject1 = null;
      if (!paramArCloudConfigInfo.d()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.c != 2))) {
          break label656;
        }
      }
      label656:
      for (localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int, paramArCloudConfigInfo.j());; localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int))
      {
        paramArCloudConfigInfo = new NormalVideoARResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", renderType = " + paramArCloudConfigInfo.jdField_d_of_type_Int + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams + ", videoPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout + ", videoPlayCount = " + i1 + ", recogType = " + paramLong);
        return paramArCloudConfigInfo;
      }
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 4)
    {
      localObject1 = new ARTarget(paramArCloudConfigInfo);
      i2 = ARVideoUtil.a((ARTarget)localObject1);
      i1 = i2;
      if (i2 == 0) {
        i1 = 2147483647;
      }
      localObject1 = ARVideoUtil.a((ARTarget)localObject1);
      i2 = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (KeyingParams)((Pair)localObject1).second;
      localObject1 = null;
      if (!paramArCloudConfigInfo.d()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.c != 2))) {
          break label1127;
        }
      }
      label1127:
      for (localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int, paramArCloudConfigInfo.j());; localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int))
      {
        localObject2 = "";
        long l1 = 0L;
        localObject4 = AROnlineVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "|" + ((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString);
        if (localObject4 != null)
        {
          l1 = ((Long)((Pair)localObject4).first).longValue();
          localObject2 = (String)((Pair)localObject4).second;
        }
        paramBoolean = ARVideoUtil.a();
        paramArCloudConfigInfo = new OnlineVideoARRenderableInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, l1, paramBoolean, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", renderType = " + paramArCloudConfigInfo.jdField_d_of_type_Int + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams + ", videoUrl = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", videoSize = " + paramArCloudConfigInfo.jdField_b_of_type_Long + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout + ", isSoftDecode = " + paramArCloudConfigInfo.jdField_a_of_type_Boolean + ", videoPlayCount = " + i1 + ", recogType = " + paramLong);
        return paramArCloudConfigInfo;
      }
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 5)
    {
      if (ARVideoUtil.a())
      {
        localObject1 = paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArVideoResourceInfo)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((((ArVideoResourceInfo)localObject2).jdField_d_of_type_Int == 2) || (((ArVideoResourceInfo)localObject2).jdField_d_of_type_Int == 3)))
          {
            QLog.i("AREngine_QQARSession", 1, "getMultiFragmentAnimARResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
            return null;
          }
        }
      }
      paramArCloudConfigInfo = new MultiFragmentAnimARResourceInfo(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 100)
    {
      localObject1 = ARResouceDir.a(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      paramArCloudConfigInfo = new Interactive3DResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, 1, "", (String)localObject1, "", paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", resType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", resPath = " + paramArCloudConfigInfo.c + ", luaPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", musicPath = " + paramArCloudConfigInfo.jdField_d_of_type_JavaLangString);
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 7)
    {
      localObject1 = ARResouceDir.c(paramArCloudConfigInfo);
      localObject2 = ARResouceDir.b(paramArCloudConfigInfo);
      return new GreetingCardResourceInfo(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2);
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 8)
    {
      localObject1 = ARResouceDir.b(paramArCloudConfigInfo);
      localObject2 = ARResouceDir.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString);
      localObject3 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_JavaUtilArrayList;
      boolean bool = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Boolean;
      if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_Int == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        i1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_d_of_type_Int;
        i2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c;
        return new ARTransferResourceInfo(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2, (ArrayList)localObject3, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), i1, i2);
      }
    }
    return null;
  }
  
  public static QQARSession a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArModelQQARSession == null) {
      jdField_a_of_type_ComTencentMobileqqArModelQQARSession = new QQARSession();
    }
    return jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
  }
  
  private void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramARCloudLBSLocationCheckResult, paramArLBSActivity);
    }
  }
  
  private void a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult start.");
    this.jdField_n_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new QQARSession.10(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARCloudMarkerRecogResult, this, false, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. download preprocess failed.");
      this.jdField_n_of_type_Boolean = false;
      w();
      return;
    }
    a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ARCloudObjectClassifyResult paramARCloudObjectClassifyResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult start.");
    this.jdField_a_of_type_JavaLangRunnable = new QQARSession.11(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARCloudObjectClassifyResult, this, false, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult end. download preprocess failed.");
      o();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult post task for handle timeout");
    a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult start.");
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(paramARCloudRecogRspFaceResult);
    b(4L);
    this.jdField_t_of_type_Boolean = true;
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult end.");
  }
  
  private void a(ARCloudSceneRecogResult paramARCloudSceneRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult start.");
    this.jdField_a_of_type_JavaLangRunnable = new QQARSession.13(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARCloudSceneRecogResult, this, false, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult end. download preprocess failed.");
      q();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
    a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ARLocalFaceRecogResult paramARLocalFaceRecogResult1, ARLocalFaceRecogResult paramARLocalFaceRecogResult2)
  {
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
      QLog.d("AREngine_QQARSession", 2, "ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = " + paramARLocalFaceRecogResult1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.b(paramARLocalFaceRecogResult1.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
    }
    a(null, paramARLocalFaceRecogResult1);
  }
  
  private void a(ARLocalGestureCircleRecogResult paramARLocalGestureCircleRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processLocalGestureCircleRecogResult");
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a(paramARLocalGestureCircleRecogResult, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
    }
  }
  
  private void a(ARLocalMarkerRecogResult paramARLocalMarkerRecogResult1, ARLocalMarkerRecogResult paramARLocalMarkerRecogResult2)
  {
    if (paramARLocalMarkerRecogResult1.jdField_a_of_type_Int != 2) {
      if (paramARLocalMarkerRecogResult1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.b(paramARLocalMarkerRecogResult1.jdField_a_of_type_Long);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
        }
        this.jdField_k_of_type_Long = 0L;
        this.jdField_l_of_type_Long = 0L;
        if (paramARLocalMarkerRecogResult1.jdField_a_of_type_Int == 0) {
          a(1L, paramARLocalMarkerRecogResult1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, paramARLocalMarkerRecogResult1.jdField_a_of_type_Float, paramARLocalMarkerRecogResult1.jdField_b_of_type_Float, paramARLocalMarkerRecogResult1.c);
        }
        a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, paramARLocalMarkerRecogResult1.jdField_a_of_type_Float, paramARLocalMarkerRecogResult1.jdField_b_of_type_Float, paramARLocalMarkerRecogResult1.c, paramARLocalMarkerRecogResult1.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int)));
        this.jdField_s_of_type_Boolean = true;
      }
    }
    do
    {
      do
      {
        return;
        if ((paramARLocalMarkerRecogResult2 != null) && (paramARLocalMarkerRecogResult2.jdField_a_of_type_Int != 2)) {
          this.jdField_k_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_l_of_type_Long = System.currentTimeMillis();
      } while (this.jdField_k_of_type_Long <= 0L);
      if (e())
      {
        paramARLocalMarkerRecogResult2 = new float[16];
        a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, 0.0F, 0.0F, 0.0F, paramARLocalMarkerRecogResult2, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int)));
      }
    } while (this.jdField_l_of_type_Long - this.jdField_k_of_type_Long <= 1500L);
    this.jdField_k_of_type_Long = 0L;
    ARVideoRecordUIControllerImpl.a().b(1);
    m();
  }
  
  private void a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult start.");
    if (paramARMIGObjectClassifyResult.a() == -1)
    {
      p();
      return;
    }
    if (paramARMIGObjectClassifyResult.a() == 1)
    {
      b(paramARMIGObjectClassifyResult);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) || (!paramARMIGObjectClassifyResult.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult))) {}
    for (int i1 = 1; (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) && (i1 != 0); i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.b(true);
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal setCompareSameSceneFlag.");
      return;
    }
    b(paramARMIGObjectClassifyResult);
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (b() != null) {
      b().c(paramRunnable);
    }
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (b() != null) {
      b().c(paramRunnable, paramLong);
    }
  }
  
  private boolean a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ARRenderResourceInfo localARRenderResourceInfo1 = a(paramArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    if (localARRenderResourceInfo1 == null) {
      return false;
    }
    QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType = " + paramLong + ", key = " + localARRenderResourceInfo1.jdField_a_of_type_JavaLangString + ", resType = " + localARRenderResourceInfo1.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)
    {
      this.jdField_h_of_type_Long = paramLong;
      this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      ARRenderResourceInfo localARRenderResourceInfo2 = a(this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      if ((localARRenderResourceInfo2 != null) && (localARRenderResourceInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localARRenderResourceInfo1.jdField_a_of_type_JavaLangString))) {
        return true;
      }
      if ((localARRenderResourceInfo2 == null) || (localARRenderResourceInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localARRenderResourceInfo1.jdField_a_of_type_JavaLangString))) {
        break label338;
      }
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.d();
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(localARRenderResourceInfo1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
      }
      CameraProxy.a().a();
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null))
      {
        if ((!paramArCloudConfigInfo.a()) && (paramArCloudConfigInfo.f())) {
          ARVideoRecordUIControllerImpl.a().a(3);
        }
        paramArCloudConfigInfo = new ARTarget(paramArCloudConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramLong, true, paramArCloudConfigInfo);
      }
      this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      if (this.jdField_q_of_type_Int == 0)
      {
        this.jdField_p_of_type_Long = System.currentTimeMillis();
        this.jdField_q_of_type_Int = ((int)(this.jdField_p_of_type_Long - this.jdField_o_of_type_Long));
      }
      if ((this.jdField_r_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null))
      {
        this.jdField_r_of_type_Long = System.currentTimeMillis();
        this.jdField_r_of_type_Int = ((int)(this.jdField_r_of_type_Long - this.jdField_q_of_type_Long));
      }
      return true;
      label338:
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(localARRenderResourceInfo1);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    QLog.i("AREngine_QQARSession", 1, "startSensorTrack. isForExternalTrack = " + paramBoolean);
    this.jdField_r_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.a();
    }
    return true;
  }
  
  public static QQARSession b()
  {
    return jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
  }
  
  private void b(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal start.");
    if (paramARMIGObjectClassifyResult.a() == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null) {
        e(false);
      }
      this.jdField_a_of_type_JavaLangRunnable = new QQARSession.12(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARMIGObjectClassifyResult, this, false, this.jdField_a_of_type_JavaLangString))
      {
        QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult end. download preprocess failed.");
        p();
      }
    }
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult localARMigObjectClassifyExternalRenderResult;
    do
    {
      return;
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
      a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
      localARMigObjectClassifyExternalRenderResult = paramARMIGObjectClassifyResult.a();
      if (localARMigObjectClassifyExternalRenderResult != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = paramARMIGObjectClassifyResult;
        a(null, localARMigObjectClassifyExternalRenderResult);
        u();
      }
    } while ((localARMigObjectClassifyExternalRenderResult != null) && (localARMigObjectClassifyExternalRenderResult.jdField_a_of_type_Boolean));
    p();
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (b() != null) {
      b().d(paramRunnable);
    }
  }
  
  public static boolean b()
  {
    return jdField_e_of_type_Boolean;
  }
  
  private void c(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
        this.jdField_b_of_type_JavaUtilArrayList.add(paramRunnable);
      }
      return;
    }
  }
  
  private void c(Runnable paramRunnable, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
        this.jdField_b_of_type_JavaUtilArrayList.add(paramRunnable);
      }
      return;
    }
  }
  
  private void d(Runnable paramRunnable)
  {
    for (;;)
    {
      int i1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_b_of_type_JavaUtilArrayList != null))
        {
          i1 = 0;
          if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
          {
            if (!paramRunnable.equals(this.jdField_b_of_type_JavaUtilArrayList.get(i1))) {
              break label108;
            }
            QLog.i("AREngine_QQARSession", 1, "removeTask. task = " + this.jdField_b_of_type_JavaUtilArrayList.get(i1));
            this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
          }
        }
        return;
      }
      label108:
      i1 += 1;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.b(paramBoolean);
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_Int = 2;
    }
    for (;;)
    {
      QLog.d("AREngine_QQARSession", 1, "start end. mCurEngineState = " + this.jdField_a_of_type_Int);
      QLog.d("AREngine_QQARSession", 1, "onStartComplete. retCode = " + paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramInt);
      }
      return;
      this.jdField_a_of_type_Int = 5;
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ARMigObjectClassifyExternalRenderResult.jdField_b_of_type_Boolean = paramBoolean;
    a(null, ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ARMigObjectClassifyExternalRenderResult);
  }
  
  private void e(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_s_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      a(new QQARSession.16(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
      return;
    }
  }
  
  private void f(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_s_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARSceneRecogDownloadCompleteInteral result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      a(new QQARSession.18(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
      return;
    }
  }
  
  private boolean g()
  {
    boolean bool = false;
    QLog.i("AREngine_QQARSession", 2, "startRenderManager.");
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(0, this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge);
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(8, this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager);
      bool = true;
    }
    return bool;
  }
  
  private boolean h()
  {
    QLog.i("AREngine_QQARSession", 2, "startLocalRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_f_of_type_Long, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this)) {
        return false;
      }
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a();
    }
    return false;
  }
  
  private boolean i()
  {
    QLog.i("AREngine_QQARSession", 2, "startCloudRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_p_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.b();
      return true;
    }
    return false;
  }
  
  private boolean j()
  {
    QLog.i("AREngine_QQARSession", 2, "stopLocalRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a();
    }
    return true;
  }
  
  public static void k()
  {
    jdField_a_of_type_ComTencentMobileqqArModelQQARSession = null;
    jdField_e_of_type_Boolean = true;
  }
  
  private boolean k()
  {
    QLog.i("AREngine_QQARSession", 2, "stopCloudRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.e();
    }
    return true;
  }
  
  public static void l()
  {
    if (b() != null) {
      b().B();
    }
  }
  
  private boolean l()
  {
    return false;
  }
  
  private void t()
  {
    QLog.d("AREngine_QQARSession", 1, "pauseCloudRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.d();
    }
  }
  
  private void u()
  {
    QLog.d("AREngine_QQARSession", 1, "resumeCloudRecog.");
    if (this.jdField_r_of_type_Int == 0) {
      this.jdField_q_of_type_Long = 0L;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    this.jdField_n_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.c();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.e();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.b();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.f();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.c();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_t_of_type_Int = 0;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        if (this.jdField_a_of_type_AndroidOsHandler != null) {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        }
        this.jdField_a_of_type_AndroidOsHandler = null;
        if (Build.VERSION.SDK_INT >= 18) {
          this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
        }
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        this.jdField_b_of_type_JavaUtilArrayList = null;
      }
      return;
    }
  }
  
  private void w()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudMarkerRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(1L);
    }
    y();
    this.jdField_s_of_type_Boolean = false;
  }
  
  private void x()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudFaceRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      y();
      this.jdField_t_of_type_Boolean = false;
      return;
      b(1L);
    }
  }
  
  private void y()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudRecogResult end.");
    u();
  }
  
  private void z()
  {
    QLog.i("AREngine_QQARSession", 1, "stopSensorTrack.");
    this.jdField_r_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.d();
    }
  }
  
  public int a()
  {
    a(new QQARSession.1(this));
    return 0;
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ARCommonConfigInfo paramARCommonConfigInfo, ArConfigInfo paramArConfigInfo, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, AREngineCallback paramAREngineCallback, Activity paramActivity, ARTransferDoorLogicManager paramARTransferDoorLogicManager, UniformGLRenderManager paramUniformGLRenderManager)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("initAR isEnableARCloudFromSettings=%s isEnableARCloudFromH5=%s isTestMode=%s commonConfig=%s markerConfig=%s faceConfig=%s arEngineCallback=%s mIsArInited=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4), paramARCommonConfigInfo, paramArConfigInfo, paramARScanStarFaceConfigInfo, paramAREngineCallback, Boolean.valueOf(this.jdField_h_of_type_Boolean) }));
    if (this.jdField_h_of_type_Boolean) {
      return 0;
    }
    if (paramARCommonConfigInfo == null)
    {
      this.jdField_h_of_type_Boolean = false;
      QLog.i("AREngine_QQARSession", 1, "initAR fail! commonConfig is null.");
      if (paramAREngineCallback != null) {
        paramAREngineCallback.a(3);
      }
      return 3;
    }
    jdField_a_of_type_Boolean = paramBoolean4;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback = paramAREngineCallback;
    this.jdField_k_of_type_Boolean = paramARCommonConfigInfo.isEnableARCloud();
    this.jdField_d_of_type_Long = ARRecognition.b(paramARCommonConfigInfo.recognitions);
    this.jdField_e_of_type_Long = ARRecognition.a(paramARCommonConfigInfo.recognitions);
    if (this.jdField_k_of_type_Boolean)
    {
      paramBoolean4 = true;
      this.jdField_l_of_type_Boolean = paramBoolean4;
      if (!paramBoolean2) {
        this.jdField_l_of_type_Boolean = false;
      }
      if (paramBoolean1) {
        this.jdField_l_of_type_Boolean = true;
      }
      if (!paramBoolean3) {
        break label363;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_l_of_type_Boolean = false;
    }
    label363:
    for (this.jdField_f_of_type_Long = 4096L;; this.jdField_f_of_type_Long = (this.jdField_d_of_type_Long & 0x5))
    {
      this.jdField_g_of_type_Long = (this.jdField_e_of_type_Long & 0x887);
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions == null) {
        break label378;
      }
      int i2;
      for (int i1 = 0; i1 < this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.size(); i1 = i2 + 1)
      {
        long l1 = 1 << (int)((ARRecognition)this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.get(i1)).jdField_a_of_type_Long;
        i2 = i1;
        if ((this.jdField_f_of_type_Long & l1) == 0L)
        {
          i2 = i1;
          if ((l1 & this.jdField_g_of_type_Long) == 0L)
          {
            this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.remove(i1);
            i2 = i1 - 1;
          }
        }
      }
      paramBoolean4 = false;
      break;
    }
    label378:
    this.jdField_f_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L);
    this.jdField_g_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2L);
    this.jdField_h_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 4L);
    this.jdField_i_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L);
    this.jdField_j_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 128L);
    this.jdField_k_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2048L);
    QLog.i("AREngine_QQARSession", 1, "initAR mIsEnableARCloudFromConfig=" + this.jdField_k_of_type_Boolean + " mLocalRecogTypeFromConfig=" + this.jdField_d_of_type_Long + " mCloudRecogTypeFromConfig=" + this.jdField_e_of_type_Long + " mIsEnableARCloudFromClientSupport=" + true + " mLocalRecogTypeFromClientSupport=" + 5L + " mCloudRecogTypeFromClientSupport=" + 2183L + " mIsEnableARCloud=" + this.jdField_l_of_type_Boolean + " mLocalRecogType=" + this.jdField_f_of_type_Long + " mCloudRecogType=" + this.jdField_g_of_type_Long + " mMarkerRecogPriority=" + this.jdField_f_of_type_Int + " mObjectClassifyPriority=" + this.jdField_g_of_type_Int + " mFaceRecogPriority=" + this.jdField_h_of_type_Int + " mPreOcrRecogPriority=" + this.jdField_i_of_type_Int + " mSceneRecogPriority=" + this.jdField_k_of_type_Int);
    QLog.i("AREngine_QQARSession", 1, "Build.MODEL = " + Build.MODEL);
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager = paramUniformGLRenderManager;
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager = paramARTransferDoorLogicManager;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager = new ARMarkerResourceManager(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime > 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime * 60L * 1000L, jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a();
      if ((this.jdField_f_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl == null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl = new ARLocalControl();
      }
      if ((!this.jdField_l_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = new ARCloudControl();
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramActivity, 900000000, 900000000, 0, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo)) {
        break;
      }
      QLog.i("AREngine_QQARSession", 1, "initAR fail! ARCloud init ar so fail.");
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = null;
      this.jdField_h_of_type_Boolean = false;
      if (paramAREngineCallback != null) {
        paramAREngineCallback.a(8);
      }
      return 8;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(86400000L, jdField_a_of_type_Boolean);
    }
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARCloudUploadDelayTime;
  }
  
  public ArrayList<String> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a();
    }
    return null;
  }
  
  public void a()
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderReadyStatus ready");
    a(new QQARSession.20(this));
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong) {}
  
  public void a(int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadProgress. progress = " + paramInt);
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(2, paramInt);
    }
  }
  
  public void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (this.jdField_c_of_type_Boolean) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete mIsForbiddenLocalMarkAndCloudRecg:do nothing but return ");
    }
    for (;;)
    {
      return;
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. retCode = " + paramInt + ", recogResult = " + paramARCloudRecogResult + ":time is:" + (System.currentTimeMillis() - this.jdField_t_of_type_Long));
      this.jdField_t_of_type_Long = System.currentTimeMillis();
      if ((paramInt == 0) && (this.w))
      {
        this.w = false;
        ReportController.b(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)) && ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2)) && ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) && (!e())) {
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null)) {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
      }
      while (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int != 2)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
        } else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
        } else if (e()) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
        }
      }
    }
    int i1;
    boolean bool;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
      i1 = 0;
      if ((paramInt != 0) || (paramARCloudRecogResult == null)) {
        break label1083;
      }
      if ((!ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)) && (!ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)) && (!ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)) && (!ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)))
      {
        paramInt = i1;
        if (!ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult)) {}
      }
      else
      {
        paramInt = 1;
      }
      bool = ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult);
      i1 = paramInt;
      if (bool)
      {
        i1 = paramInt;
        if (paramInt != 0)
        {
          i1 = paramInt;
          if (ARRecognition.a(paramARCloudRecogResult, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L))
          {
            i1 = 0;
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
          }
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onARCloudUploadImgComplete result:  marker{success: ").append(ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)).append(", priority: ").append(this.jdField_f_of_type_Int).append("}");
        localStringBuilder1.append("  object{success: ").append(ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)).append(", priority: ").append(this.jdField_g_of_type_Int).append("}");
        localStringBuilder1.append("  face{success: ").append(ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)).append(", priority: ").append(this.jdField_h_of_type_Int).append("}");
        localStringBuilder1.append("  pre ocr{success: ").append(ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult)).append(", priority: ").append(this.jdField_i_of_type_Int).append("}");
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" \n mig-object{success: ").append(ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)).append(", priority: ").append(this.jdField_j_of_type_Int).append("}name:");
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) {
          break label912;
        }
        localObject = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.toString();
        label674:
        localStringBuilder2.append((String)localObject);
        localStringBuilder1.append("  scene{success: ").append(ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult)).append(", priority: ").append(this.jdField_k_of_type_Int).append("}");
        QLog.i("AREngine_QQARSession", 2, localStringBuilder1.toString());
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (!this.x))
      {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete first recognize success.");
        this.x = true;
      }
      if ((bool) && (i1 == 0))
      {
        this.jdField_o_of_type_Boolean = true;
        a(new QQARSession.5(this));
      }
      for (;;)
      {
        if (i1 != 0) {
          break label951;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)
        {
          e(true);
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (!this.jdField_q_of_type_Boolean)) {
            p();
          }
        }
        if ((!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) && ((this.jdField_f_of_type_Long & 1L) != 0L))
        {
          t();
          b(1L);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null)) {
          break;
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
        break;
        label912:
        localObject = "";
        break label674;
        if ((!bool) && (this.jdField_o_of_type_Boolean))
        {
          this.jdField_o_of_type_Boolean = false;
          a(new QQARSession.6(this));
        }
      }
      label951:
      if (i1 != 0)
      {
        localObject = ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult);
        if ((ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult)) && (((ARCloudLBSLocationCheckResult)localObject).jdField_a_of_type_Int != 1))
        {
          a(new QQARSession.7(this, (ARCloudLBSLocationCheckResult)localObject, ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult)));
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
          }
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
          return;
        }
      }
      t();
      this.jdField_i_of_type_Long = 0L;
      this.jdField_j_of_type_Long = 0L;
      a(new QQARSession.8(this, paramARCloudRecogResult));
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
      return;
      label1083:
      i1 = 0;
      bool = false;
    }
  }
  
  public void a(long paramLong)
  {
    QLog.d("AREngine_QQARSession", 1, "pauseLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(paramLong);
    }
  }
  
  public void a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    b(new QQARSession.2(this, paramLong, paramArCloudConfigInfo), 500L);
  }
  
  public void a(long paramLong, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    if (this.jdField_t_of_type_Int == 1)
    {
      if (paramARLocalRecogResultBase.jdField_b_of_type_Long != 4096L) {
        return;
      }
      a((ARLocalGestureCircleRecogResult)paramARLocalRecogResultBase);
      return;
    }
    ARLocalRecogResult localARLocalRecogResult = new ARLocalRecogResult();
    if ((1L & paramLong) != 0L) {
      localARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = ((ARLocalMarkerRecogResult)paramARLocalRecogResultBase);
    }
    if ((0x4 & paramLong) != 0L) {
      localARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = ((ARLocalFaceRecogResult)paramARLocalRecogResultBase);
    }
    a(localARLocalRecogResult, null);
  }
  
  public void a(Context arg1, AppInterface paramAppInterface)
  {
    super.a(???, paramAppInterface);
    System.currentTimeMillis();
    QLog.d("AREngine_QQARSession", 1, String.format("init context=%s appInterface=%s mIsInited=%s", new Object[] { ???, paramAppInterface, Boolean.valueOf(this.jdField_g_of_type_Boolean) }));
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager = new SensorTrackManager();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AREngineThread", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_g_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(ARRenderMarkerTrackInfo paramARRenderMarkerTrackInfo)
  {
    a(paramARRenderMarkerTrackInfo, null);
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    if ((paramARLocalRecogResultBase != null) && (paramARLocalRecogResultBase.jdField_b_of_type_Long == 4L)) {
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramARLocalRecogResultBase.jdField_b_of_type_Long, 0, null, paramARLocalRecogResultBase);
      }
    }
    label211:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramARLocalRecogResultBase == null) || (paramARLocalRecogResultBase.jdField_b_of_type_Long != 128L)) {
              break;
            }
          } while ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback == null));
          this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramARLocalRecogResultBase.jdField_b_of_type_Long, 0, null, paramARLocalRecogResultBase);
          return;
          if (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
            break label211;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
            this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
          }
          if ((!this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) || (!this.jdField_r_of_type_Boolean)) {
            break;
          }
        } while ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback == null));
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(this.jdField_h_of_type_Long, this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.c, paramARRenderTrackInfo, null);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager == null);
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(paramARRenderTrackInfo);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager == null);
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(paramARRenderTrackInfo);
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QQARSession", 2, "onCommonCallbackFromManager, resourceInfo=" + paramArCloudConfigInfo + ", action=" + paramInt1 + ", result=" + paramInt2 + " ,data=" + paramObject);
    }
    a(new QQARSession.26(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  /* Error */
  public void a(ARLocalRecogResult paramARLocalRecogResult, ARCloudRecogResult paramARCloudRecogResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 110	com/tencent/mobileqq/ar/model/QQARSession:jdField_g_of_type_Boolean	Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: getfield 621	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_Int	I
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_2
    //   16: if_icmpeq +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_1
    //   23: ifnull +33 -> 56
    //   26: aload_1
    //   27: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   38: putfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   41: aload_1
    //   42: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   45: ifnull +11 -> 56
    //   48: aload_0
    //   49: aload_1
    //   50: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   53: putfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   56: aload_2
    //   57: ifnull +8 -> 65
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 191	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogResult;
    //   65: aload_0
    //   66: getfield 130	com/tencent/mobileqq/ar/model/QQARSession:jdField_f_of_type_Long	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq +1515 -> 1586
    //   74: aload_0
    //   75: getfield 132	com/tencent/mobileqq/ar/model/QQARSession:jdField_g_of_type_Long	J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifeq +1506 -> 1586
    //   83: aload_1
    //   84: ifnull +592 -> 676
    //   87: aload_1
    //   88: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   91: ifnull +585 -> 676
    //   94: aload_1
    //   95: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   98: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   101: istore_3
    //   102: iload_3
    //   103: ifne +228 -> 331
    //   106: aconst_null
    //   107: ldc_w 1333
    //   110: ldc_w 501
    //   113: ldc_w 501
    //   116: ldc_w 1335
    //   119: ldc_w 1335
    //   122: iconst_0
    //   123: iconst_0
    //   124: aload_1
    //   125: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   128: getfield 725	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   131: getfield 561	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   134: ldc_w 851
    //   137: ldc_w 501
    //   140: ldc_w 501
    //   143: invokestatic 856	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   150: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   153: lconst_1
    //   154: invokestatic 1007	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;J)Z
    //   157: ifne +325 -> 482
    //   160: aload_1
    //   161: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   164: getfield 725	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   167: astore_2
    //   168: ldc_w 277
    //   171: iconst_1
    //   172: new 279	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 1337
    //   182: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_2
    //   186: invokevirtual 727	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   189: invokevirtual 542	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   192: ldc_w 1339
    //   195: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_2
    //   199: invokevirtual 1312	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   202: invokevirtual 542	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   205: ldc_w 1341
    //   208: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_2
    //   212: invokevirtual 1343	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:h	()Z
    //   215: invokevirtual 542	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   218: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: getfield 110	com/tencent/mobileqq/ar/model/QQARSession:jdField_g_of_type_Boolean	Z
    //   228: ifeq +36 -> 264
    //   231: aload_0
    //   232: getfield 621	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_Int	I
    //   235: iconst_2
    //   236: if_icmpne +28 -> 264
    //   239: aload_0
    //   240: getfield 120	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback	Lcom/tencent/mobileqq/ar/arengine/AREngineCallback;
    //   243: ifnull +21 -> 264
    //   246: aload_0
    //   247: getfield 120	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback	Lcom/tencent/mobileqq/ar/arengine/AREngineCallback;
    //   250: lconst_1
    //   251: new 423	com/tencent/mobileqq/ar/ARTarget
    //   254: dup
    //   255: aload_2
    //   256: invokespecial 426	com/tencent/mobileqq/ar/ARTarget:<init>	(Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   259: invokeinterface 1346 4 0
    //   264: aload_2
    //   265: invokevirtual 449	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:d	()Z
    //   268: ifne +270 -> 538
    //   271: aload_2
    //   272: invokevirtual 727	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   275: ifeq +214 -> 489
    //   278: aload_0
    //   279: lconst_1
    //   280: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   283: aload_0
    //   284: lconst_1
    //   285: aload_2
    //   286: aload_1
    //   287: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   290: getfield 729	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_b_of_type_Int	I
    //   293: aload_1
    //   294: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   297: getfield 732	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Float	F
    //   300: aload_1
    //   301: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   304: getfield 734	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_b_of_type_Float	F
    //   307: aload_1
    //   308: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   311: getfield 736	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:c	F
    //   314: invokespecial 739	com/tencent/mobileqq/ar/model/QQARSession:a	(JLcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;IFFF)Z
    //   317: pop
    //   318: aload_2
    //   319: invokevirtual 463	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:j	()Z
    //   322: ifeq +9 -> 331
    //   325: aload_0
    //   326: iconst_0
    //   327: invokespecial 892	com/tencent/mobileqq/ar/model/QQARSession:a	(Z)Z
    //   330: pop
    //   331: aload_1
    //   332: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   335: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   338: iconst_2
    //   339: if_icmpeq +16 -> 355
    //   342: aload_1
    //   343: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   346: getfield 725	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   349: invokevirtual 449	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:d	()Z
    //   352: ifeq +36 -> 388
    //   355: aload_0
    //   356: aload_1
    //   357: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   360: aload_0
    //   361: getfield 185	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   364: invokespecial 1348	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;)V
    //   367: aload_1
    //   368: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   371: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   374: iconst_2
    //   375: if_icmpeq +212 -> 587
    //   378: aload_0
    //   379: lconst_0
    //   380: putfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   383: aload_0
    //   384: lconst_0
    //   385: putfield 211	com/tencent/mobileqq/ar/model/QQARSession:jdField_j_of_type_Long	J
    //   388: aload_1
    //   389: ifnull -370 -> 19
    //   392: aload_1
    //   393: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   396: ifnull +1357 -> 1753
    //   399: aload_0
    //   400: aload_1
    //   401: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   404: putfield 185	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   407: aload_1
    //   408: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   411: getfield 725	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   414: ifnull -395 -> 19
    //   417: aload_1
    //   418: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   421: getfield 725	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   424: invokevirtual 449	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:d	()Z
    //   427: ifne -408 -> 19
    //   430: aload_0
    //   431: aconst_null
    //   432: putfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   435: aload_0
    //   436: aconst_null
    //   437: putfield 185	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   440: goto -421 -> 19
    //   443: astore_1
    //   444: aload_0
    //   445: monitorexit
    //   446: aload_1
    //   447: athrow
    //   448: astore_2
    //   449: ldc_w 277
    //   452: iconst_1
    //   453: new 279	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 1350
    //   463: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_2
    //   467: invokevirtual 1353	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   470: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: goto -333 -> 146
    //   482: aload_0
    //   483: invokespecial 894	com/tencent/mobileqq/ar/model/QQARSession:t	()V
    //   486: goto -326 -> 160
    //   489: aload_2
    //   490: invokevirtual 1343	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:h	()Z
    //   493: ifne +10 -> 503
    //   496: aload_2
    //   497: invokevirtual 1312	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   500: ifeq +31 -> 531
    //   503: aload_2
    //   504: invokevirtual 1312	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   507: ifeq -176 -> 331
    //   510: aload_0
    //   511: lconst_1
    //   512: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   515: aload_2
    //   516: invokevirtual 463	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:j	()Z
    //   519: ifeq -188 -> 331
    //   522: aload_0
    //   523: iconst_1
    //   524: invokespecial 892	com/tencent/mobileqq/ar/model/QQARSession:a	(Z)Z
    //   527: pop
    //   528: goto -197 -> 331
    //   531: aload_0
    //   532: invokespecial 642	com/tencent/mobileqq/ar/model/QQARSession:w	()V
    //   535: goto -204 -> 331
    //   538: aload_2
    //   539: invokevirtual 727	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   542: ifne -211 -> 331
    //   545: aload_2
    //   546: invokevirtual 1343	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:h	()Z
    //   549: ifne +10 -> 559
    //   552: aload_2
    //   553: invokevirtual 1312	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   556: ifeq -225 -> 331
    //   559: aload_2
    //   560: invokevirtual 1312	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   563: ifeq -232 -> 331
    //   566: aload_0
    //   567: lconst_1
    //   568: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   571: aload_2
    //   572: invokevirtual 463	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:j	()Z
    //   575: ifeq -244 -> 331
    //   578: aload_0
    //   579: iconst_1
    //   580: invokespecial 892	com/tencent/mobileqq/ar/model/QQARSession:a	(Z)Z
    //   583: pop
    //   584: goto -253 -> 331
    //   587: aload_0
    //   588: getfield 191	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogResult;
    //   591: ifnull +23 -> 614
    //   594: aload_0
    //   595: getfield 193	com/tencent/mobileqq/ar/model/QQARSession:jdField_n_of_type_Boolean	Z
    //   598: ifeq +16 -> 614
    //   601: aload_0
    //   602: lconst_0
    //   603: putfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   606: aload_0
    //   607: lconst_0
    //   608: putfield 211	com/tencent/mobileqq/ar/model/QQARSession:jdField_j_of_type_Long	J
    //   611: goto -223 -> 388
    //   614: aload_0
    //   615: getfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   618: lconst_0
    //   619: lcmp
    //   620: ifne +10 -> 630
    //   623: aload_0
    //   624: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   627: putfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   630: aload_0
    //   631: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   634: putfield 211	com/tencent/mobileqq/ar/model/QQARSession:jdField_j_of_type_Long	J
    //   637: aload_0
    //   638: getfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   641: lconst_0
    //   642: lcmp
    //   643: ifle -255 -> 388
    //   646: aload_0
    //   647: getfield 211	com/tencent/mobileqq/ar/model/QQARSession:jdField_j_of_type_Long	J
    //   650: aload_0
    //   651: getfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   654: lsub
    //   655: ldc2_w 763
    //   658: lcmp
    //   659: ifle -271 -> 388
    //   662: aload_0
    //   663: ldc2_w 1354
    //   666: putfield 209	com/tencent/mobileqq/ar/model/QQARSession:jdField_i_of_type_Long	J
    //   669: aload_0
    //   670: invokespecial 642	com/tencent/mobileqq/ar/model/QQARSession:w	()V
    //   673: goto -285 -> 388
    //   676: aload_1
    //   677: ifnull +388 -> 1065
    //   680: aload_1
    //   681: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   684: ifnull +381 -> 1065
    //   687: aload_0
    //   688: aload_0
    //   689: getfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   692: aload_0
    //   693: getfield 189	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   696: invokespecial 1357	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;)V
    //   699: iconst_0
    //   700: istore 5
    //   702: iconst_0
    //   703: istore 4
    //   705: aload_0
    //   706: getfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   709: getfield 1136	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   712: invokevirtual 292	java/util/ArrayList:size	()I
    //   715: istore_3
    //   716: iload_3
    //   717: ifle +48 -> 765
    //   720: aload_0
    //   721: getfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   724: getfield 1136	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   727: invokevirtual 546	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   730: astore_2
    //   731: iload 4
    //   733: istore 5
    //   735: aload_2
    //   736: invokeinterface 551 1 0
    //   741: ifeq +24 -> 765
    //   744: aload_2
    //   745: invokeinterface 555 1 0
    //   750: checkcast 1359	com/tencent/mobileqq/ar/DrawView2$FaceData
    //   753: getfield 1360	com/tencent/mobileqq/ar/DrawView2$FaceData:jdField_e_of_type_Boolean	Z
    //   756: ifne +1015 -> 1771
    //   759: iconst_1
    //   760: istore 4
    //   762: goto +1009 -> 1771
    //   765: invokestatic 696	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +47 -> 815
    //   771: getstatic 699	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecog:jdField_a_of_type_Boolean	Z
    //   774: ifeq +41 -> 815
    //   777: ldc_w 277
    //   780: iconst_2
    //   781: new 279	java/lang/StringBuilder
    //   784: dup
    //   785: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   788: ldc_w 1362
    //   791: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: iload_3
    //   795: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   798: ldc_w 1364
    //   801: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: iload 5
    //   806: invokevirtual 542	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   809: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 703	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: iload 5
    //   817: ifeq +100 -> 917
    //   820: aconst_null
    //   821: ldc_w 1333
    //   824: ldc_w 501
    //   827: ldc_w 501
    //   830: ldc_w 1335
    //   833: ldc_w 1335
    //   836: iconst_0
    //   837: iconst_0
    //   838: aload_1
    //   839: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   842: getfield 1136	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   845: iconst_0
    //   846: invokevirtual 308	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   849: checkcast 1359	com/tencent/mobileqq/ar/DrawView2$FaceData
    //   852: getfield 1365	com/tencent/mobileqq/ar/DrawView2$FaceData:jdField_a_of_type_Int	I
    //   855: invokestatic 1368	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   858: ldc_w 1370
    //   861: ldc_w 501
    //   864: ldc_w 501
    //   867: invokestatic 856	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload_0
    //   871: lconst_0
    //   872: putfield 219	com/tencent/mobileqq/ar/model/QQARSession:jdField_m_of_type_Long	J
    //   875: aload_0
    //   876: lconst_0
    //   877: putfield 221	com/tencent/mobileqq/ar/model/QQARSession:jdField_n_of_type_Long	J
    //   880: goto -492 -> 388
    //   883: astore_2
    //   884: ldc_w 277
    //   887: iconst_1
    //   888: new 279	java/lang/StringBuilder
    //   891: dup
    //   892: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   895: ldc_w 1350
    //   898: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload_2
    //   902: invokevirtual 1353	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   905: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 304	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: goto -44 -> 870
    //   917: ldc2_w 1371
    //   920: lstore 6
    //   922: invokestatic 1373	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecog:a	()Z
    //   925: ifeq +8 -> 933
    //   928: ldc2_w 1374
    //   931: lstore 6
    //   933: aload_0
    //   934: getfield 219	com/tencent/mobileqq/ar/model/QQARSession:jdField_m_of_type_Long	J
    //   937: lconst_0
    //   938: lcmp
    //   939: ifne +10 -> 949
    //   942: aload_0
    //   943: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   946: putfield 219	com/tencent/mobileqq/ar/model/QQARSession:jdField_m_of_type_Long	J
    //   949: aload_0
    //   950: invokestatic 760	java/lang/System:currentTimeMillis	()J
    //   953: putfield 221	com/tencent/mobileqq/ar/model/QQARSession:jdField_n_of_type_Long	J
    //   956: aload_0
    //   957: getfield 219	com/tencent/mobileqq/ar/model/QQARSession:jdField_m_of_type_Long	J
    //   960: lconst_0
    //   961: lcmp
    //   962: ifle -574 -> 388
    //   965: aload_0
    //   966: getfield 221	com/tencent/mobileqq/ar/model/QQARSession:jdField_n_of_type_Long	J
    //   969: aload_0
    //   970: getfield 219	com/tencent/mobileqq/ar/model/QQARSession:jdField_m_of_type_Long	J
    //   973: lsub
    //   974: lload 6
    //   976: lcmp
    //   977: ifle -589 -> 388
    //   980: invokestatic 696	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   983: ifeq +31 -> 1014
    //   986: ldc_w 277
    //   989: iconst_2
    //   990: new 279	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 280	java/lang/StringBuilder:<init>	()V
    //   997: ldc_w 1377
    //   1000: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: lload 6
    //   1005: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 299	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokestatic 703	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1014: aload_0
    //   1015: ldc2_w 669
    //   1018: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   1021: aload_0
    //   1022: ldc2_w 1354
    //   1025: putfield 219	com/tencent/mobileqq/ar/model/QQARSession:jdField_m_of_type_Long	J
    //   1028: aload_0
    //   1029: getfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1032: iconst_1
    //   1033: putfield 1378	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_Boolean	Z
    //   1036: aload_0
    //   1037: aload_0
    //   1038: getfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1041: aload_0
    //   1042: getfield 189	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1045: invokespecial 1357	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;)V
    //   1048: aload_0
    //   1049: aconst_null
    //   1050: putfield 187	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1053: aload_0
    //   1054: aconst_null
    //   1055: putfield 189	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1058: aload_0
    //   1059: invokespecial 1380	com/tencent/mobileqq/ar/model/QQARSession:x	()V
    //   1062: goto -674 -> 388
    //   1065: aload_2
    //   1066: ifnull -678 -> 388
    //   1069: aload_0
    //   1070: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1073: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1076: aload_2
    //   1077: invokestatic 1383	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogResult;)Lcom/tencent/mobileqq/ar/ARRecognition$RecognitionResult;
    //   1080: astore 8
    //   1082: aload 8
    //   1084: getfield 1386	com/tencent/mobileqq/ar/ARRecognition$RecognitionResult:jdField_a_of_type_Long	J
    //   1087: lstore 6
    //   1089: aload 8
    //   1091: getfield 1387	com/tencent/mobileqq/ar/ARRecognition$RecognitionResult:jdField_a_of_type_Boolean	Z
    //   1094: istore 4
    //   1096: aload_0
    //   1097: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1100: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1103: lload 6
    //   1105: invokestatic 1007	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;J)Z
    //   1108: istore 5
    //   1110: aload_0
    //   1111: getfield 197	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1114: ifnull +34 -> 1148
    //   1117: lload 6
    //   1119: ldc2_w 1044
    //   1122: lcmp
    //   1123: ifeq +25 -> 1148
    //   1126: aload_0
    //   1127: iconst_0
    //   1128: invokespecial 858	com/tencent/mobileqq/ar/model/QQARSession:e	(Z)V
    //   1131: aload_0
    //   1132: getfield 199	com/tencent/mobileqq/ar/model/QQARSession:jdField_p_of_type_Boolean	Z
    //   1135: ifeq +13 -> 1148
    //   1138: aload_0
    //   1139: lconst_1
    //   1140: invokevirtual 673	com/tencent/mobileqq/ar/model/QQARSession:b	(J)V
    //   1143: aload_0
    //   1144: iconst_0
    //   1145: putfield 199	com/tencent/mobileqq/ar/model/QQARSession:jdField_p_of_type_Boolean	Z
    //   1148: lload 6
    //   1150: lconst_0
    //   1151: lcmp
    //   1152: ifeq -764 -> 388
    //   1155: lload 6
    //   1157: ldc2_w 669
    //   1160: lcmp
    //   1161: ifne +81 -> 1242
    //   1164: iload 5
    //   1166: ifeq +14 -> 1180
    //   1169: aload_0
    //   1170: aload_2
    //   1171: getfield 1173	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1174: invokespecial 1389	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)V
    //   1177: goto -789 -> 388
    //   1180: aload_0
    //   1181: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1184: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1187: ldc2_w 1390
    //   1190: lconst_1
    //   1191: invokestatic 1394	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1194: ifeq +14 -> 1208
    //   1197: aload_0
    //   1198: aload_2
    //   1199: getfield 1173	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1202: invokespecial 1389	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)V
    //   1205: goto -817 -> 388
    //   1208: aload_0
    //   1209: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1212: ifnull +14 -> 1226
    //   1215: aload_0
    //   1216: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1219: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1222: iconst_2
    //   1223: if_icmpne -835 -> 388
    //   1226: aload_0
    //   1227: lconst_1
    //   1228: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   1231: aload_0
    //   1232: aload_2
    //   1233: getfield 1173	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1236: invokespecial 1389	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)V
    //   1239: goto -851 -> 388
    //   1242: lload 6
    //   1244: ldc2_w 450
    //   1247: lcmp
    //   1248: ifne +81 -> 1329
    //   1251: iload 5
    //   1253: ifeq +14 -> 1267
    //   1256: aload_0
    //   1257: aload_2
    //   1258: getfield 1161	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1261: invokespecial 1396	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1264: goto -876 -> 388
    //   1267: aload_0
    //   1268: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1271: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1274: ldc2_w 450
    //   1277: lconst_1
    //   1278: invokestatic 1394	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1281: ifeq +14 -> 1295
    //   1284: aload_0
    //   1285: aload_2
    //   1286: getfield 1161	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1289: invokespecial 1396	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1292: goto -904 -> 388
    //   1295: aload_0
    //   1296: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1299: ifnull +14 -> 1313
    //   1302: aload_0
    //   1303: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1306: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1309: iconst_2
    //   1310: if_icmpne -922 -> 388
    //   1313: aload_0
    //   1314: lconst_1
    //   1315: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   1318: aload_0
    //   1319: aload_2
    //   1320: getfield 1161	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1323: invokespecial 1396	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1326: goto -938 -> 388
    //   1329: lload 6
    //   1331: ldc2_w 1044
    //   1334: lcmp
    //   1335: ifne +120 -> 1455
    //   1338: iload 5
    //   1340: ifeq +14 -> 1354
    //   1343: aload_0
    //   1344: aload_2
    //   1345: getfield 1167	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1348: invokespecial 1398	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1351: goto -963 -> 388
    //   1354: aload_0
    //   1355: getfield 201	com/tencent/mobileqq/ar/model/QQARSession:jdField_q_of_type_Boolean	Z
    //   1358: ifeq +30 -> 1388
    //   1361: aload_0
    //   1362: getfield 197	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1365: ifnull +8 -> 1373
    //   1368: aload_0
    //   1369: iconst_0
    //   1370: invokespecial 858	com/tencent/mobileqq/ar/model/QQARSession:e	(Z)V
    //   1373: aload_0
    //   1374: getfield 199	com/tencent/mobileqq/ar/model/QQARSession:jdField_p_of_type_Boolean	Z
    //   1377: ifeq -1358 -> 19
    //   1380: aload_0
    //   1381: iconst_0
    //   1382: putfield 199	com/tencent/mobileqq/ar/model/QQARSession:jdField_p_of_type_Boolean	Z
    //   1385: goto -1366 -> 19
    //   1388: aload_0
    //   1389: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1392: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1395: ldc2_w 1044
    //   1398: lconst_1
    //   1399: invokestatic 1394	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1402: ifeq +14 -> 1416
    //   1405: aload_0
    //   1406: aload_2
    //   1407: getfield 1167	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1410: invokespecial 1398	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1413: goto -1025 -> 388
    //   1416: aload_0
    //   1417: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1420: ifnull +14 -> 1434
    //   1423: aload_0
    //   1424: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1427: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1430: iconst_2
    //   1431: if_icmpne -1043 -> 388
    //   1434: aload_0
    //   1435: lconst_1
    //   1436: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   1439: aload_0
    //   1440: iconst_1
    //   1441: putfield 199	com/tencent/mobileqq/ar/model/QQARSession:jdField_p_of_type_Boolean	Z
    //   1444: aload_0
    //   1445: aload_2
    //   1446: getfield 1167	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1449: invokespecial 1398	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1452: goto -1064 -> 388
    //   1455: lload 6
    //   1457: lconst_1
    //   1458: lcmp
    //   1459: ifne +40 -> 1499
    //   1462: iload 5
    //   1464: ifeq +14 -> 1478
    //   1467: aload_0
    //   1468: aload_2
    //   1469: getfield 1153	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;
    //   1472: invokespecial 1400	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;)V
    //   1475: goto -1087 -> 388
    //   1478: iload 4
    //   1480: ifeq +8 -> 1488
    //   1483: aload_0
    //   1484: lconst_1
    //   1485: invokevirtual 673	com/tencent/mobileqq/ar/model/QQARSession:b	(J)V
    //   1488: aload_0
    //   1489: aload_2
    //   1490: getfield 1153	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;
    //   1493: invokespecial 1400	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;)V
    //   1496: goto -1108 -> 388
    //   1499: lload 6
    //   1501: ldc2_w 452
    //   1504: lcmp
    //   1505: ifne -1117 -> 388
    //   1508: iload 5
    //   1510: ifeq +14 -> 1524
    //   1513: aload_0
    //   1514: aload_2
    //   1515: getfield 1179	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1518: invokespecial 1402	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1521: goto -1133 -> 388
    //   1524: aload_0
    //   1525: getfield 116	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1528: getfield 1002	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1531: ldc2_w 452
    //   1534: lconst_1
    //   1535: invokestatic 1394	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1538: ifeq +14 -> 1552
    //   1541: aload_0
    //   1542: aload_2
    //   1543: getfield 1179	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1546: invokespecial 1402	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1549: goto -1161 -> 388
    //   1552: aload_0
    //   1553: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1556: ifnull +14 -> 1570
    //   1559: aload_0
    //   1560: getfield 183	com/tencent/mobileqq/ar/model/QQARSession:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1563: getfield 724	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1566: iconst_2
    //   1567: if_icmpne -1179 -> 388
    //   1570: aload_0
    //   1571: lconst_1
    //   1572: invokevirtual 1009	com/tencent/mobileqq/ar/model/QQARSession:a	(J)V
    //   1575: aload_0
    //   1576: aload_2
    //   1577: getfield 1179	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1580: invokespecial 1402	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1583: goto -1195 -> 388
    //   1586: aload_0
    //   1587: getfield 130	com/tencent/mobileqq/ar/model/QQARSession:jdField_f_of_type_Long	J
    //   1590: lconst_0
    //   1591: lcmp
    //   1592: ifeq +51 -> 1643
    //   1595: aload_1
    //   1596: ifnull -1577 -> 19
    //   1599: aload_1
    //   1600: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1603: ifnull +18 -> 1621
    //   1606: aload_0
    //   1607: aload_1
    //   1608: getfield 1278	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1611: aload_0
    //   1612: getfield 185	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1615: invokespecial 1348	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;)V
    //   1618: goto -1230 -> 388
    //   1621: aload_1
    //   1622: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1625: ifnull -1237 -> 388
    //   1628: aload_0
    //   1629: aload_1
    //   1630: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1633: aload_0
    //   1634: getfield 189	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1637: invokespecial 1357	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;)V
    //   1640: goto -1252 -> 388
    //   1643: aload_0
    //   1644: getfield 132	com/tencent/mobileqq/ar/model/QQARSession:jdField_g_of_type_Long	J
    //   1647: lconst_0
    //   1648: lcmp
    //   1649: ifeq -1261 -> 388
    //   1652: aload_2
    //   1653: ifnull -1634 -> 19
    //   1656: aload_2
    //   1657: getfield 1161	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1660: invokestatic 1166	com/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)Z
    //   1663: ifeq +14 -> 1677
    //   1666: aload_0
    //   1667: aload_2
    //   1668: getfield 1161	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1671: invokespecial 1396	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1674: goto -1286 -> 388
    //   1677: aload_2
    //   1678: getfield 1167	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1681: invokestatic 1170	com/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyBaseResult;)Z
    //   1684: ifeq +14 -> 1698
    //   1687: aload_0
    //   1688: aload_2
    //   1689: getfield 1167	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1692: invokespecial 1398	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1695: goto -1307 -> 388
    //   1698: aload_2
    //   1699: getfield 1153	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;
    //   1702: invokestatic 1158	com/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;)Z
    //   1705: ifeq +10 -> 1715
    //   1708: aload_0
    //   1709: invokespecial 642	com/tencent/mobileqq/ar/model/QQARSession:w	()V
    //   1712: goto -1324 -> 388
    //   1715: aload_2
    //   1716: getfield 1173	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1719: invokestatic 1176	com/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)Z
    //   1722: ifeq +10 -> 1732
    //   1725: aload_0
    //   1726: invokespecial 1380	com/tencent/mobileqq/ar/model/QQARSession:x	()V
    //   1729: goto -1341 -> 388
    //   1732: aload_2
    //   1733: getfield 1179	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1736: invokestatic 1184	com/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)Z
    //   1739: ifeq -1351 -> 388
    //   1742: aload_0
    //   1743: aload_2
    //   1744: getfield 1179	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1747: invokespecial 1402	com/tencent/mobileqq/ar/model/QQARSession:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1750: goto -1362 -> 388
    //   1753: aload_1
    //   1754: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1757: ifnull -1738 -> 19
    //   1760: aload_0
    //   1761: aload_1
    //   1762: getfield 1279	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1765: putfield 189	com/tencent/mobileqq/ar/model/QQARSession:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1768: goto -1749 -> 19
    //   1771: goto -1040 -> 731
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1774	0	this	QQARSession
    //   0	1774	1	paramARLocalRecogResult	ARLocalRecogResult
    //   0	1774	2	paramARCloudRecogResult	ARCloudRecogResult
    //   13	782	3	i1	int
    //   703	776	4	bool1	boolean
    //   700	809	5	bool2	boolean
    //   920	580	6	l1	long
    //   1080	10	8	localRecognitionResult	com.tencent.mobileqq.ar.ARRecognition.RecognitionResult
    // Exception table:
    //   from	to	target	type
    //   2	14	443	finally
    //   26	41	443	finally
    //   41	56	443	finally
    //   60	65	443	finally
    //   65	83	443	finally
    //   87	102	443	finally
    //   106	146	443	finally
    //   146	160	443	finally
    //   160	264	443	finally
    //   264	331	443	finally
    //   331	355	443	finally
    //   355	388	443	finally
    //   392	440	443	finally
    //   449	479	443	finally
    //   482	486	443	finally
    //   489	503	443	finally
    //   503	528	443	finally
    //   531	535	443	finally
    //   538	559	443	finally
    //   559	584	443	finally
    //   587	611	443	finally
    //   614	630	443	finally
    //   630	673	443	finally
    //   680	699	443	finally
    //   705	716	443	finally
    //   720	731	443	finally
    //   735	759	443	finally
    //   765	815	443	finally
    //   820	870	443	finally
    //   870	880	443	finally
    //   884	914	443	finally
    //   922	928	443	finally
    //   933	949	443	finally
    //   949	1014	443	finally
    //   1014	1062	443	finally
    //   1069	1117	443	finally
    //   1126	1148	443	finally
    //   1169	1177	443	finally
    //   1180	1205	443	finally
    //   1208	1226	443	finally
    //   1226	1239	443	finally
    //   1256	1264	443	finally
    //   1267	1292	443	finally
    //   1295	1313	443	finally
    //   1313	1326	443	finally
    //   1343	1351	443	finally
    //   1354	1373	443	finally
    //   1373	1385	443	finally
    //   1388	1413	443	finally
    //   1416	1434	443	finally
    //   1434	1452	443	finally
    //   1467	1475	443	finally
    //   1483	1488	443	finally
    //   1488	1496	443	finally
    //   1513	1521	443	finally
    //   1524	1549	443	finally
    //   1552	1570	443	finally
    //   1570	1583	443	finally
    //   1586	1595	443	finally
    //   1599	1618	443	finally
    //   1621	1640	443	finally
    //   1643	1652	443	finally
    //   1656	1674	443	finally
    //   1677	1695	443	finally
    //   1698	1712	443	finally
    //   1715	1729	443	finally
    //   1732	1750	443	finally
    //   1753	1768	443	finally
    //   106	146	448	java/lang/Exception
    //   820	870	883	java/lang/Exception
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
    a(new QQARSession.25(this, paramArVideoResourceInfo, paramARRenderMangerInnerCallback));
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationStart. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new QQARSession.21(this, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudSelectImageComplete. result = " + paramBoolean);
      if (this.jdField_q_of_type_Long == 0L) {
        this.jdField_q_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_u_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_u_of_type_Long;
        if (l1 > 0L) {
          this.jdField_v_of_type_Long = (l1 + this.jdField_v_of_type_Long);
        }
        this.jdField_u_of_type_Long = 0L;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerResourceDownloadComplete. result = " + paramBoolean + " type  " + paramInt);
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int != 2)) {}
  }
  
  public void a(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadComplete result=%s config=%s", new Object[] { Boolean.valueOf(paramBoolean), paramArCloudConfigInfo }));
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_e_of_type_Int = 1;
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      return;
    }
    d(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(0, paramArrayOfFloat);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.a(paramARMIGObjectClassifyResult));
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      onPreviewFrame(paramArrayOfByte, null);
      return true;
    }
    return false;
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ScanTorchActivity)) {
      return ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).a();
    }
    return 0L;
  }
  
  public void b()
  {
    if (this.jdField_u_of_type_Long == 0L) {
      this.jdField_u_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(2, paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    QLog.d("AREngine_QQARSession", 1, "resumeLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
    {
      if ((1L & paramLong) != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
        this.jdField_i_of_type_Long = 0L;
        this.jdField_j_of_type_Long = 0L;
        this.jdField_k_of_type_Long = 0L;
        this.jdField_l_of_type_Long = 0L;
      }
      if ((0x4 & paramLong) != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
        this.jdField_m_of_type_Long = 0L;
        this.jdField_n_of_type_Long = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.b(paramLong);
    }
  }
  
  public void b(Runnable paramRunnable, long paramLong)
  {
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int == 2)) {
      a(paramRunnable, paramLong);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationComplete. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new QQARSession.22(this, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudPretreatComplete. result = " + paramBoolean);
    if ((paramBoolean) && (this.jdField_v_of_type_Boolean))
    {
      this.jdField_v_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X80085AD", "0X80085AD", 0, 0, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      this.jdField_e_of_type_Int = 2;
      return;
    }
    e(paramBoolean, paramArCloudConfigInfo);
  }
  
  public int c()
  {
    QLog.d("AREngine_QQARSession", 1, "start startInternal. mCurEngineState = " + this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Int != 0) || (!CameraProxy.a().b())) {
      return -1;
    }
    this.jdField_q_of_type_Int = 0;
    this.jdField_o_of_type_Long = System.currentTimeMillis();
    this.jdField_p_of_type_Long = 0L;
    this.jdField_r_of_type_Int = 0;
    this.jdField_q_of_type_Long = 0L;
    this.jdField_r_of_type_Long = 0L;
    this.jdField_n_of_type_Int = CameraProxy.a().a();
    this.jdField_o_of_type_Int = CameraProxy.a().b();
    this.jdField_p_of_type_Int = CameraProxy.a().c();
    this.jdField_m_of_type_Int = UniformGLRenderManagerImpl.jdField_b_of_type_Int;
    this.jdField_l_of_type_Int = UniformGLRenderManagerImpl.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = new ARNativeBridge();
    if (!this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.isLoadSoSuccess())
    {
      QLog.d("AREngine_QQARSession", 1, "startAR internal fail");
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = null;
      this.jdField_h_of_type_Boolean = false;
      e(6);
      return 6;
    }
    g();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.a(this.jdField_a_of_type_AndroidContentContext, this);
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) && (!h()))
    {
      e(7);
      return 7;
    }
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(5L);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) && (!i()))
    {
      e(3);
      return 3;
      a(4L);
      b(1L);
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this);
    e(0);
    return 0;
  }
  
  public void c()
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudUploadStart.");
    this.jdField_s_of_type_Int += 1;
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(2, paramInt);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayInterrupt. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new QQARSession.23(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)) {
      a(new QQARSession.9(this, paramBoolean));
    }
  }
  
  public void c(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.f()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      this.jdField_e_of_type_Int = 2;
      return;
    }
    f(paramBoolean, paramArCloudConfigInfo);
  }
  
  public boolean c()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void d()
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadStart.");
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, 4);
    }
  }
  
  public void d(int paramInt)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus on workMode=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 1) && (this.jdField_t_of_type_Int != paramInt)) {
      a(new QQARSession.28(this));
    }
  }
  
  public void d(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayError. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new QQARSession.24(this, paramInt));
  }
  
  public void d(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_s_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadCompleteInternal result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      a(new QQARSession.14(this, paramBoolean, paramArCloudConfigInfo), l1);
      return;
    }
  }
  
  public boolean d()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public void e()
  {
    QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadStart.");
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    a(new QQARSession.15(this));
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null;
  }
  
  public void f()
  {
    QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadStart.");
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    a(new QQARSession.17(this));
  }
  
  public boolean f()
  {
    QLog.i("AREngine_QQARSession", 1, "stopInternal.");
    this.jdField_d_of_type_Boolean = true;
    z();
    j();
    k();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    return true;
  }
  
  public void g()
  {
    QLog.d("AREngine_QQARSession", 1, "ARengine status resume now start. + mCurrentSessionStatus:=" + this.jdField_a_of_type_Int);
    if ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 2)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this);
    a(this.jdField_r_of_type_Boolean);
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_t_of_type_Int == 1))
    {
      b(4096L);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(true, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
      this.jdField_j_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 2;
      return;
    }
    u();
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(5L);
    }
    for (;;)
    {
      this.jdField_j_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 2;
      QLog.d("AREngine_QQARSession", 1, "ARengine status resume now end.");
      return;
      a(4L);
      b(1L);
    }
  }
  
  public void h()
  {
    QLog.i("AREngine_QQARSession", 1, "ARengine status  pause. now ");
    if ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    z();
    m();
    t();
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L))) {}
    for (boolean bool = true;; bool = false)
    {
      a(5L);
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(bool);
      }
      this.jdField_q_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null) {
        e(true);
      }
      this.jdField_t_of_type_Boolean = false;
      A();
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) && (this.jdField_t_of_type_Int == 1))
      {
        a(4096L);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(false, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.b();
      }
      this.jdField_j_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(null);
      return;
    }
  }
  
  public void i()
  {
    QLog.i("AREngine_QQARSession", 1, "stop start. mCurEngineState = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 5) {
      return;
    }
    this.jdField_a_of_type_Int = 4;
    this.jdField_d_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    l();
    a(new QQARSession.3(this));
  }
  
  public void j()
  {
    QLog.i("AREngine_QQARSession", 1, "uninit start. mIsInited = " + this.jdField_g_of_type_Boolean);
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    CameraProxy.a().c(this);
    a(new QQARSession.4(this));
  }
  
  public void m()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRender.");
    if ((this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) && (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.d();
      if (CameraProxy.a().b()) {
        CameraProxy.a().a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4)))
      {
        ARTarget localARTarget = new ARTarget(this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(this.jdField_h_of_type_Long, false, localARTarget);
      }
    }
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public void n()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRenderOnly.");
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.d();
    }
  }
  
  public void o()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudObjectClassifyResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      y();
      return;
      b(1L);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null))
    {
      if ((!this.jdField_h_of_type_Boolean) || (this.jdField_a_of_type_Int != 2)) {
        break label371;
      }
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a() + 1L);
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl == null) || ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(1L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4096L))) || (l())) {
        break label334;
      }
      if ((this.jdField_t_of_type_Int == 0) || ((this.jdField_t_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a() == 0) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.b()))) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(), paramArrayOfByte);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label209;
      }
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a());
      if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
      }
    }
    label209:
    label371:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(paramArrayOfByte);
        }
        return;
        if (((!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(1L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2)) || ((!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size() == 0)) || ((!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.b(4L))))
        {
          this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a());
          if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
            continue;
            this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a());
            if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null) {
              this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
            }
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a() + 1L);
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a());
    } while (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager == null);
    label334:
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a();
  }
  
  public void p()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessMigCloudObjectClassifyResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
      y();
      return;
      b(1L);
      this.jdField_p_of_type_Boolean = false;
    }
  }
  
  public void q()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudSceneRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      y();
      return;
      b(1L);
    }
  }
  
  public void r()
  {
    QLog.d("AREngine_QQARSession", 1, "engine notifyRenderReady ");
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) || (!this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)));
      if (this.jdField_e_of_type_Int == 1)
      {
        d(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        return;
      }
    } while (this.jdField_e_of_type_Int != 2);
    e(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
  }
  
  public void s()
  {
    QLog.d("AREngine_QQARSession", 1, String.format("CloseAREngineRecoglizeFunction  ", new Object[0]));
    a(new QQARSession.27(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession
 * JD-Core Version:    0.7.0.1
 */