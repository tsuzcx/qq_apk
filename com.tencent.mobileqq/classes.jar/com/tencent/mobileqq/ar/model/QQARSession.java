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
import com.tencent.mobileqq.ar.ARRecognition.RecognitionResult;
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
import com.tencent.mobileqq.ar.DrawView2.FaceData;
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
  private static QQARSession jdField_a_of_type_ComTencentMobileqqArModelQQARSession;
  public static boolean a = false;
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
  private final long jdField_b_of_type_Long = 1L;
  ArCloudConfigInfo jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private ARLocalFaceRecogResult jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
  private ARLocalMarkerRecogResult jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
  private ArrayList<Runnable> jdField_b_of_type_JavaUtilArrayList = null;
  public boolean b;
  private final long jdField_c_of_type_Long = 2179L;
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
    if (this.jdField_t_of_type_Int != 1) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
    if (localObject != null) {
      ((ARLocalControl)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localObject != null) {
      ((ARTransferDoorLogicManager)localObject).d();
    }
  }
  
  private void B()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeAllTask. task count = ");
        localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.size());
        QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
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
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static ARRenderResourceInfo a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean, long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramArCloudConfigInfo == null) {
      return null;
    }
    Object localObject1;
    Object localObject3;
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 0)
    {
      localObject1 = ARResouceDir.b(paramArCloudConfigInfo);
      localObject2 = ARResouceDir.c(paramArCloudConfigInfo);
      localObject3 = ARResouceDir.d(paramArCloudConfigInfo);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
      {
        ArCloudConfigInfo.ARVideoLayout localARVideoLayout = ARVideoUtil.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.e);
        paramArCloudConfigInfo = new GeneralARResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, (String)localObject2, (String)localObject1, (String)localObject3, localARVideoLayout, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", arType = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", trackMode = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_Int);
        ((StringBuilder)localObject1).append(", resPath = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.c);
        ((StringBuilder)localObject1).append(", luaPath = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", musicPath = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", recogType = ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
        return paramArCloudConfigInfo;
      }
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
      return null;
    }
    int i1 = paramArCloudConfigInfo.jdField_d_of_type_Int;
    boolean bool1 = false;
    int i2;
    if ((i1 != 2) && (paramArCloudConfigInfo.jdField_d_of_type_Int != 3))
    {
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
        if (!paramArCloudConfigInfo.d())
        {
          if (((paramBoolean) && ((paramLong == 2L) || (paramLong == 2048L))) || ((paramLong == 1L) && (paramArCloudConfigInfo.c == 2))) {
            localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int, paramArCloudConfigInfo.j());
          } else {
            localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int);
          }
        }
        else {
          localObject1 = null;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString);
        localObject2 = AROnlineVideoUtil.a(((StringBuilder)localObject2).toString());
        long l1;
        if (localObject2 != null)
        {
          l1 = ((Long)((Pair)localObject2).first).longValue();
          localObject2 = (String)((Pair)localObject2).second;
        }
        else
        {
          localObject2 = "";
          l1 = 0L;
        }
        paramBoolean = ARVideoUtil.a();
        paramArCloudConfigInfo = new OnlineVideoARRenderableInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, l1, paramBoolean, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", arType = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append(", trackMode = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_Int);
        ((StringBuilder)localObject1).append(", renderType = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
        ((StringBuilder)localObject1).append(", keyingParams = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams);
        ((StringBuilder)localObject1).append(", videoUrl = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(", videoSize = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(", layout = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout);
        ((StringBuilder)localObject1).append(", isSoftDecode = ");
        ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_Boolean);
        ((StringBuilder)localObject1).append(", videoPlayCount = ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(", recogType = ");
        ((StringBuilder)localObject1).append(paramLong);
        QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
        return paramArCloudConfigInfo;
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
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists()))
        {
          paramArCloudConfigInfo = new Interactive3DResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, 1, "", (String)localObject1, "", paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(", resType = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_Int);
          ((StringBuilder)localObject1).append(", resPath = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.c);
          ((StringBuilder)localObject1).append(", luaPath = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString);
          ((StringBuilder)localObject1).append(", musicPath = ");
          ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_d_of_type_JavaLangString);
          QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
          return paramArCloudConfigInfo;
        }
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
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
        boolean bool2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Boolean;
        paramBoolean = bool1;
        if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_Int == 1) {
          paramBoolean = true;
        }
        i1 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_d_of_type_Int;
        i2 = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.c;
        return new ARTransferResourceInfo(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2, (ArrayList)localObject3, Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean), i1, i2);
      }
      return null;
    }
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
    Object localObject2 = ARResouceDir.e(paramArCloudConfigInfo);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
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
      if (!paramArCloudConfigInfo.d())
      {
        if (((paramBoolean) && ((paramLong == 2L) || (paramLong == 2048L))) || ((paramLong == 1L) && (paramArCloudConfigInfo.c == 2))) {
          localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int, paramArCloudConfigInfo.j());
        } else {
          localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, UniformGLRenderManagerImpl.jdField_a_of_type_Int, UniformGLRenderManagerImpl.jdField_b_of_type_Int);
        }
      }
      else {
        localObject1 = null;
      }
      paramArCloudConfigInfo = new NormalVideoARResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.c, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getARRenderResourceInfo. key = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", arType = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(", trackMode = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_Int);
      ((StringBuilder)localObject1).append(", renderType = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_d_of_type_Int);
      ((StringBuilder)localObject1).append(", keyingParams = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams);
      ((StringBuilder)localObject1).append(", videoPath = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(", layout = ");
      ((StringBuilder)localObject1).append(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout);
      ((StringBuilder)localObject1).append(", videoPlayCount = ");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", recogType = ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject1).toString());
      return paramArCloudConfigInfo;
    }
    QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
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
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      AREngineCallback localAREngineCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(paramARCloudLBSLocationCheckResult, paramArLBSActivity);
      }
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
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
    {
      paramARLocalFaceRecogResult2 = new StringBuilder();
      paramARLocalFaceRecogResult2.append("ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = ");
      paramARLocalFaceRecogResult2.append(paramARLocalFaceRecogResult1);
      QLog.d("AREngine_QQARSession", 2, paramARLocalFaceRecogResult2.toString());
    }
    paramARLocalFaceRecogResult2 = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (paramARLocalFaceRecogResult2 != null) {
      paramARLocalFaceRecogResult2.b(paramARLocalFaceRecogResult1.jdField_a_of_type_Long);
    }
    paramARLocalFaceRecogResult2 = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (paramARLocalFaceRecogResult2 != null) {
      paramARLocalFaceRecogResult2.a();
    }
    a(null, paramARLocalFaceRecogResult1);
  }
  
  private void a(ARLocalGestureCircleRecogResult paramARLocalGestureCircleRecogResult)
  {
    QLog.i("AREngine_QQARSession", 1, "processLocalGestureCircleRecogResult");
    ARTransferDoorLogicManager localARTransferDoorLogicManager = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager;
    if (localARTransferDoorLogicManager != null) {
      localARTransferDoorLogicManager.a(paramARLocalGestureCircleRecogResult, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
    }
  }
  
  private void a(ARLocalMarkerRecogResult paramARLocalMarkerRecogResult1, ARLocalMarkerRecogResult paramARLocalMarkerRecogResult2)
  {
    if (paramARLocalMarkerRecogResult1.jdField_a_of_type_Int != 2)
    {
      if (paramARLocalMarkerRecogResult1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
      {
        paramARLocalMarkerRecogResult2 = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        if (paramARLocalMarkerRecogResult2 != null) {
          paramARLocalMarkerRecogResult2.b(paramARLocalMarkerRecogResult1.jdField_a_of_type_Long);
        }
        paramARLocalMarkerRecogResult2 = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        if (paramARLocalMarkerRecogResult2 != null) {
          paramARLocalMarkerRecogResult2.a();
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
    else
    {
      if ((paramARLocalMarkerRecogResult2 != null) && (paramARLocalMarkerRecogResult2.jdField_a_of_type_Int != 2)) {
        this.jdField_k_of_type_Long = System.currentTimeMillis();
      }
      this.jdField_l_of_type_Long = System.currentTimeMillis();
      if (this.jdField_k_of_type_Long > 0L)
      {
        if (e())
        {
          paramARLocalMarkerRecogResult2 = new float[16];
          a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, 0.0F, 0.0F, 0.0F, paramARLocalMarkerRecogResult2, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int)));
        }
        if (this.jdField_l_of_type_Long - this.jdField_k_of_type_Long > 1500L)
        {
          this.jdField_k_of_type_Long = 0L;
          ARVideoRecordUIControllerImpl.a().b(1);
          m();
        }
      }
    }
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult;
    int i1;
    if ((localObject != null) && (paramARMIGObjectClassifyResult.a((ARMIGObjectClassifyResult)localObject))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if ((localObject != null) && (i1 != 0))
    {
      ((ARCloudControl)localObject).b(true);
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
    Object localObject1 = a(paramArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startModelRender. recogType = ");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(", key = ");
    ((StringBuilder)localObject2).append(((ARRenderResourceInfo)localObject1).jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(", resType = ");
    ((StringBuilder)localObject2).append(((ARRenderResourceInfo)localObject1).jdField_a_of_type_Int);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)
    {
      this.jdField_h_of_type_Long = paramLong;
      this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      localObject2 = a(this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      if ((localObject2 != null) && (((ARRenderResourceInfo)localObject2).jdField_a_of_type_JavaLangString.equalsIgnoreCase(((ARRenderResourceInfo)localObject1).jdField_a_of_type_JavaLangString))) {
        return true;
      }
      if ((localObject2 != null) && (!((ARRenderResourceInfo)localObject2).jdField_a_of_type_JavaLangString.equalsIgnoreCase(((ARRenderResourceInfo)localObject1).jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.d();
        this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a((ARRenderResourceInfo)localObject1);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a((ARRenderResourceInfo)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
      if (localObject1 != null) {
        ((UniformGLRenderManager)localObject1).a();
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
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startSensorTrack. isForExternalTrack = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    this.jdField_r_of_type_Boolean = paramBoolean;
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
    if (localObject != null) {
      ((SensorTrackManager)localObject).a();
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
        return;
      }
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
      a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult localARMigObjectClassifyExternalRenderResult = paramARMIGObjectClassifyResult.a();
    if (localARMigObjectClassifyExternalRenderResult != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = paramARMIGObjectClassifyResult;
      a(null, localARMigObjectClassifyExternalRenderResult);
      u();
    }
    if ((localARMigObjectClassifyExternalRenderResult == null) || (!localARMigObjectClassifyExternalRenderResult.jdField_a_of_type_Boolean)) {
      p();
    }
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
    int i1;
    label127:
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        i1 = 0;
        if (i1 < this.jdField_b_of_type_JavaUtilArrayList.size())
        {
          if (!paramRunnable.equals(this.jdField_b_of_type_JavaUtilArrayList.get(i1))) {
            break label127;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("removeTask. task = ");
          localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.get(i1));
          QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
          this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
        }
      }
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      AREngineCallback localAREngineCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
      if (localAREngineCallback != null) {
        localAREngineCallback.b(paramBoolean);
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_Int = 2;
    }
    else
    {
      this.jdField_a_of_type_Int = 5;
      this.jdField_h_of_type_Boolean = false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start end. mCurEngineState = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onStartComplete. retCode = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
    if (localObject != null) {
      ((AREngineCallback)localObject).a(paramInt);
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
    long l1;
    if (l2 >= 1000L) {
      l1 = 0L;
    } else {
      l1 = 1000L - l2;
    }
    QLog.i("AREngine_QQARSession", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
    a(new QQARSession.16(this, paramBoolean, paramArCloudConfigInfo), l1);
    this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  private void f(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_s_of_type_Long;
    long l1;
    if (l2 >= 1000L) {
      l1 = 0L;
    } else {
      l1 = 1000L - l2;
    }
    QLog.i("AREngine_QQARSession", 1, String.format("onARSceneRecogDownloadCompleteInteral result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
    a(new QQARSession.18(this, paramBoolean, paramArCloudConfigInfo), l1);
    this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  private boolean g()
  {
    QLog.i("AREngine_QQARSession", 2, "startRenderManager.");
    UniformGLRenderManager localUniformGLRenderManager = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (localUniformGLRenderManager != null)
    {
      localUniformGLRenderManager.a(0, this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge);
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(8, this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager);
      return true;
    }
    return false;
  }
  
  private boolean h()
  {
    QLog.i("AREngine_QQARSession", 2, "startLocalRecog.");
    ARLocalControl localARLocalControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
    boolean bool = false;
    if (localARLocalControl != null)
    {
      if (!localARLocalControl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_f_of_type_Long, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this)) {
        return false;
      }
      bool = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a();
    }
    return bool;
  }
  
  private boolean i()
  {
    QLog.i("AREngine_QQARSession", 2, "startCloudRecog.");
    ARCloudControl localARCloudControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (localARCloudControl != null)
    {
      localARCloudControl.a(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_p_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.b();
      return true;
    }
    return false;
  }
  
  private boolean j()
  {
    QLog.i("AREngine_QQARSession", 2, "stopLocalRecog.");
    ARLocalControl localARLocalControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
    if (localARLocalControl != null) {
      localARLocalControl.a();
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
    ARCloudControl localARCloudControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (localARCloudControl != null) {
      localARCloudControl.e();
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
    ARCloudControl localARCloudControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (localARCloudControl != null) {
      localARCloudControl.d();
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
    ARCloudControl localARCloudControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (localARCloudControl != null) {
      localARCloudControl.c();
    }
  }
  
  private void v()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
    if (??? != null)
    {
      ((SensorTrackManager)???).e();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager = null;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
    if (??? != null)
    {
      ((ARLocalControl)???).b();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl = null;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (??? != null)
    {
      ((ARCloudControl)???).f();
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = null;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
    if (??? != null)
    {
      ((ARMarkerResourceManager)???).c();
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
    if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      b(1L);
    }
    y();
    this.jdField_t_of_type_Boolean = false;
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
    SensorTrackManager localSensorTrackManager = this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
    if (localSensorTrackManager != null) {
      localSensorTrackManager.d();
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
    this.jdField_l_of_type_Boolean = this.jdField_k_of_type_Boolean;
    if (!paramBoolean2) {
      this.jdField_l_of_type_Boolean = false;
    }
    if (paramBoolean1) {
      this.jdField_l_of_type_Boolean = true;
    }
    if (paramBoolean3)
    {
      this.jdField_c_of_type_Boolean = true;
      this.jdField_l_of_type_Boolean = false;
      this.jdField_f_of_type_Long = 4096L;
    }
    else
    {
      this.jdField_f_of_type_Long = (this.jdField_d_of_type_Long & 1L);
    }
    this.jdField_g_of_type_Long = (this.jdField_e_of_type_Long & 0x883);
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions != null)
    {
      int i2;
      for (int i1 = 0; i1 < this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.size(); i1 = i2 + 1)
      {
        long l1 = 1 << (int)((ARRecognition)this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.get(i1)).jdField_a_of_type_Long;
        i2 = i1;
        if ((this.jdField_f_of_type_Long & l1) == 0L)
        {
          i2 = i1;
          if ((this.jdField_g_of_type_Long & l1) == 0L)
          {
            this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.remove(i1);
            i2 = i1 - 1;
          }
        }
      }
    }
    this.jdField_f_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L);
    this.jdField_g_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2L);
    this.jdField_h_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 4L);
    this.jdField_i_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L);
    this.jdField_j_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 128L);
    this.jdField_k_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2048L);
    paramARCommonConfigInfo = new StringBuilder();
    paramARCommonConfigInfo.append("initAR mIsEnableARCloudFromConfig=");
    paramARCommonConfigInfo.append(this.jdField_k_of_type_Boolean);
    paramARCommonConfigInfo.append(" mLocalRecogTypeFromConfig=");
    paramARCommonConfigInfo.append(this.jdField_d_of_type_Long);
    paramARCommonConfigInfo.append(" mCloudRecogTypeFromConfig=");
    paramARCommonConfigInfo.append(this.jdField_e_of_type_Long);
    paramARCommonConfigInfo.append(" mIsEnableARCloudFromClientSupport=");
    paramARCommonConfigInfo.append(true);
    paramARCommonConfigInfo.append(" mLocalRecogTypeFromClientSupport=");
    paramARCommonConfigInfo.append(1L);
    paramARCommonConfigInfo.append(" mCloudRecogTypeFromClientSupport=");
    paramARCommonConfigInfo.append(2179L);
    paramARCommonConfigInfo.append(" mIsEnableARCloud=");
    paramARCommonConfigInfo.append(this.jdField_l_of_type_Boolean);
    paramARCommonConfigInfo.append(" mLocalRecogType=");
    paramARCommonConfigInfo.append(this.jdField_f_of_type_Long);
    paramARCommonConfigInfo.append(" mCloudRecogType=");
    paramARCommonConfigInfo.append(this.jdField_g_of_type_Long);
    paramARCommonConfigInfo.append(" mMarkerRecogPriority=");
    paramARCommonConfigInfo.append(this.jdField_f_of_type_Int);
    paramARCommonConfigInfo.append(" mObjectClassifyPriority=");
    paramARCommonConfigInfo.append(this.jdField_g_of_type_Int);
    paramARCommonConfigInfo.append(" mFaceRecogPriority=");
    paramARCommonConfigInfo.append(this.jdField_h_of_type_Int);
    paramARCommonConfigInfo.append(" mPreOcrRecogPriority=");
    paramARCommonConfigInfo.append(this.jdField_i_of_type_Int);
    paramARCommonConfigInfo.append(" mSceneRecogPriority=");
    paramARCommonConfigInfo.append(this.jdField_k_of_type_Int);
    QLog.i("AREngine_QQARSession", 1, paramARCommonConfigInfo.toString());
    paramARCommonConfigInfo = new StringBuilder();
    paramARCommonConfigInfo.append("Build.MODEL = ");
    paramARCommonConfigInfo.append(Build.MODEL);
    QLog.i("AREngine_QQARSession", 1, paramARCommonConfigInfo.toString());
    this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager = paramUniformGLRenderManager;
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager = paramARTransferDoorLogicManager;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager = new ARMarkerResourceManager(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext);
    paramARCommonConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
    if ((paramARCommonConfigInfo != null) && (paramARCommonConfigInfo.aRCloudCacheExpireTime > 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime * 60L * 1000L, jdField_a_of_type_Boolean);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(86400000L, jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a();
    if ((this.jdField_f_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl == null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl = new ARLocalControl();
    }
    if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = new ARCloudControl();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramActivity, 900000000, 900000000, 0, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo))
      {
        QLog.i("AREngine_QQARSession", 1, "initAR fail! ARCloud init ar so fail.");
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = null;
        this.jdField_h_of_type_Boolean = false;
        if (paramAREngineCallback != null)
        {
          paramAREngineCallback.a(8);
          return 8;
        }
        return 8;
      }
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
    ARCloudControl localARCloudControl = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (localARCloudControl != null) {
      return localARCloudControl.a();
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onARMarkerAllDownloadProgress. progress = ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
      if (localObject != null) {
        ((AREngineCallback)localObject).a(2, paramInt);
      }
    }
  }
  
  public void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete mIsForbiddenLocalMarkAndCloudRecg:do nothing but return ");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onARCloudUploadImgComplete. retCode = ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", recogResult = ");
    ((StringBuilder)localObject).append(paramARCloudRecogResult);
    ((StringBuilder)localObject).append(":time is:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_t_of_type_Long);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    this.jdField_t_of_type_Long = System.currentTimeMillis();
    if ((paramInt == 0) && (this.w))
    {
      this.w = false;
      ReportController.b(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
      if ((localObject == null) || (((ARLocalMarkerRecogResult)localObject).jdField_a_of_type_Int == 2))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
        if (((localObject == null) || (((ARLocalFaceRecogResult)localObject).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) && (!e())) {
          break label334;
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
    }
    else
    {
      paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
      if ((paramARCloudRecogResult != null) && (paramARCloudRecogResult.jdField_a_of_type_Int != 2))
      {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
      }
      else
      {
        paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
        if ((paramARCloudRecogResult != null) && (paramARCloudRecogResult.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
        } else if (e()) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
        }
      }
    }
    paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (paramARCloudRecogResult != null) {
      paramARCloudRecogResult.a(true);
    }
    return;
    label334:
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
    } else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
    }
    int i1;
    boolean bool1;
    if ((paramInt == 0) && (paramARCloudRecogResult != null))
    {
      if ((!ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)) && (!ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)) && (!ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)) && (!ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)) && (!ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      boolean bool2 = ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult);
      paramInt = i1;
      if (bool2)
      {
        paramInt = i1;
        if (i1 != 0)
        {
          paramInt = i1;
          if (ARRecognition.a(paramARCloudRecogResult, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L))
          {
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
            paramInt = 0;
          }
        }
      }
      i1 = paramInt;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onARCloudUploadImgComplete result:  marker{success: ");
        localStringBuilder.append(ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.jdField_f_of_type_Int);
        localStringBuilder.append("}");
        localStringBuilder.append("  object{success: ");
        localStringBuilder.append(ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.jdField_g_of_type_Int);
        localStringBuilder.append("}");
        localStringBuilder.append("  face{success: ");
        localStringBuilder.append(ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.jdField_h_of_type_Int);
        localStringBuilder.append("}");
        localStringBuilder.append("  pre ocr{success: ");
        localStringBuilder.append(ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.jdField_i_of_type_Int);
        localStringBuilder.append("}");
        localStringBuilder.append(" \n mig-object{success: ");
        localStringBuilder.append(ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.jdField_j_of_type_Int);
        localStringBuilder.append("}name:");
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null) {
          localObject = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.toString();
        } else {
          localObject = "";
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("  scene{success: ");
        localStringBuilder.append(ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult));
        localStringBuilder.append(", priority: ");
        localStringBuilder.append(this.jdField_k_of_type_Int);
        localStringBuilder.append("}");
        QLog.i("AREngine_QQARSession", 2, localStringBuilder.toString());
        i1 = paramInt;
        bool1 = bool2;
      }
    }
    else
    {
      i1 = 0;
      bool1 = false;
    }
    if ((i1 != 0) && (!this.x))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete first recognize success.");
      this.x = true;
    }
    if ((bool1) && (i1 == 0))
    {
      this.jdField_o_of_type_Boolean = true;
      a(new QQARSession.5(this));
    }
    else if ((!bool1) && (this.jdField_o_of_type_Boolean))
    {
      this.jdField_o_of_type_Boolean = false;
      a(new QQARSession.6(this));
    }
    if (i1 == 0)
    {
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
      paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
      if (paramARCloudRecogResult != null) {
        paramARCloudRecogResult.a(true);
      }
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
      return;
    }
    if (i1 != 0)
    {
      localObject = ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult);
      if ((ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult)) && (((ARCloudLBSLocationCheckResult)localObject).jdField_a_of_type_Int != 1))
      {
        a(new QQARSession.7(this, (ARCloudLBSLocationCheckResult)localObject, ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult)));
        paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
        if (paramARCloudRecogResult != null) {
          paramARCloudRecogResult.a(true);
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
        return;
      }
    }
    t();
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    a(new QQARSession.8(this, paramARCloudRecogResult));
    paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
    if (paramARCloudRecogResult != null) {
      paramARCloudRecogResult.a(true);
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pauseLocalRecog. recogType = ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
    if (localObject != null) {
      ((ARLocalControl)localObject).a(paramLong);
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
    if ((paramLong & 0x4) != 0L) {
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
    if ((paramARLocalRecogResultBase != null) && (paramARLocalRecogResultBase.jdField_b_of_type_Long == 4L))
    {
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
      {
        paramARRenderTrackInfo = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
        if (paramARRenderTrackInfo != null) {
          paramARRenderTrackInfo.a(paramARLocalRecogResultBase.jdField_b_of_type_Long, 0, null, paramARLocalRecogResultBase);
        }
      }
    }
    else if ((paramARLocalRecogResultBase != null) && (paramARLocalRecogResultBase.jdField_b_of_type_Long == 128L))
    {
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
      {
        paramARRenderTrackInfo = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
        if (paramARRenderTrackInfo != null) {
          paramARRenderTrackInfo.a(paramARLocalRecogResultBase.jdField_b_of_type_Long, 0, null, paramARLocalRecogResultBase);
        }
      }
    }
    else if (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)
    {
      paramARLocalRecogResultBase = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
      if (paramARLocalRecogResultBase != null) {
        paramARLocalRecogResultBase.a();
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) && (this.jdField_r_of_type_Boolean))
      {
        if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
        {
          paramARLocalRecogResultBase = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
          if (paramARLocalRecogResultBase != null) {
            paramARLocalRecogResultBase.a(this.jdField_h_of_type_Long, this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.c, paramARRenderTrackInfo, null);
          }
        }
      }
      else
      {
        paramARLocalRecogResultBase = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        if (paramARLocalRecogResultBase != null) {
          paramARLocalRecogResultBase.a(paramARRenderTrackInfo);
        }
      }
    }
    else
    {
      paramARLocalRecogResultBase = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
      if (paramARLocalRecogResultBase != null) {
        paramARLocalRecogResultBase.a(paramARRenderTrackInfo);
      }
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCommonCallbackFromManager, resourceInfo=");
      localStringBuilder.append(paramArCloudConfigInfo);
      localStringBuilder.append(", action=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", result=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" ,data=");
      localStringBuilder.append(paramObject);
      QLog.d("AREngine_QQARSession", 2, localStringBuilder.toString());
    }
    a(new QQARSession.26(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  public void a(ARLocalRecogResult paramARLocalRecogResult, ARCloudRecogResult paramARCloudRecogResult)
  {
    try
    {
      if ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Int != 2)) {
        break label1847;
      }
      if (paramARLocalRecogResult != null)
      {
        if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
        }
        if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
        }
      }
      if (paramARCloudRecogResult != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = paramARCloudRecogResult;
      }
      if ((this.jdField_f_of_type_Long == 0L) || (this.jdField_g_of_type_Long == 0L)) {
        break label1596;
      }
      if ((paramARLocalRecogResult != null) && (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null))
      {
        i1 = paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int;
        if (i1 == 0)
        {
          try
          {
            ReportController.b(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_b_of_type_JavaLangString, "1", "", "");
          }
          catch (Exception paramARCloudRecogResult)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("0X80081DE. error = ");
            ((StringBuilder)localObject).append(paramARCloudRecogResult.getMessage());
            QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
          }
          if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
            t();
          }
          paramARCloudRecogResult = paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("localRecogResult. isNeedInternalRender = ");
          ((StringBuilder)localObject).append(paramARCloudRecogResult.f());
          ((StringBuilder)localObject).append(", isNeedExternalRender = ");
          ((StringBuilder)localObject).append(paramARCloudRecogResult.g());
          ((StringBuilder)localObject).append(", isNeedWaitUserOperation = ");
          ((StringBuilder)localObject).append(paramARCloudRecogResult.h());
          QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
            this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(1L, new ARTarget(paramARCloudRecogResult));
          }
          if (!paramARCloudRecogResult.d())
          {
            if (paramARCloudRecogResult.f())
            {
              a(1L);
              a(1L, paramARCloudRecogResult, paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_b_of_type_Int, paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Float, paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_b_of_type_Float, paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.c);
              if (paramARCloudRecogResult.j()) {
                a(false);
              }
            }
            else if ((!paramARCloudRecogResult.h()) && (!paramARCloudRecogResult.g()))
            {
              w();
            }
            else if (paramARCloudRecogResult.g())
            {
              a(1L);
              if (paramARCloudRecogResult.j()) {
                a(true);
              }
            }
          }
          else if ((!paramARCloudRecogResult.f()) && ((paramARCloudRecogResult.h()) || (paramARCloudRecogResult.g())) && (paramARCloudRecogResult.g()))
          {
            a(1L);
            if (paramARCloudRecogResult.j()) {
              a(true);
            }
          }
        }
        if ((paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int != 2) && (!paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d())) {
          break label1774;
        }
        a(paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult, this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult);
        if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int != 2)
        {
          this.jdField_i_of_type_Long = 0L;
          this.jdField_j_of_type_Long = 0L;
          break label1774;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_n_of_type_Boolean))
        {
          this.jdField_i_of_type_Long = 0L;
          this.jdField_j_of_type_Long = 0L;
          break label1774;
        }
        if (this.jdField_i_of_type_Long == 0L) {
          this.jdField_i_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_j_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_i_of_type_Long <= 0L) || (this.jdField_j_of_type_Long - this.jdField_i_of_type_Long <= 1500L)) {
          break label1774;
        }
        this.jdField_i_of_type_Long = -1L;
        w();
        break label1774;
      }
      if ((paramARLocalRecogResult == null) || (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult == null)) {
        break label1067;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult, this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult);
      i1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size();
      if (i1 <= 0) {
        break label1861;
      }
      paramARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.iterator();
      bool1 = false;
      for (;;)
      {
        bool2 = bool1;
        if (!paramARCloudRecogResult.hasNext()) {
          break;
        }
        if (!((DrawView2.FaceData)paramARCloudRecogResult.next()).jdField_e_of_type_Boolean) {
          bool1 = true;
        }
      }
    }
    finally
    {
      for (;;)
      {
        int i1;
        Object localObject;
        boolean bool1;
        long l1;
        label1067:
        label1847:
        for (;;)
        {
          label1596:
          label1774:
          throw paramARLocalRecogResult;
        }
        label1861:
        boolean bool2 = false;
        continue;
        label1867:
        if (l1 != 0L) {}
      }
    }
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean))
    {
      paramARCloudRecogResult = new StringBuilder();
      paramARCloudRecogResult.append("[ScanStarFace]onARRecogComplete faceDataSize = ");
      paramARCloudRecogResult.append(i1);
      paramARCloudRecogResult.append(",hasRealFace = ");
      paramARCloudRecogResult.append(bool2);
      QLog.d("AREngine_QQARSession", 2, paramARCloudRecogResult.toString());
    }
    if (bool2)
    {
      try
      {
        ReportController.b(null, "CliOper", "", "", "0X80081DE", "0X80081DE", 0, 0, String.valueOf(((DrawView2.FaceData)paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int), "3", "", "");
      }
      catch (Exception paramARCloudRecogResult)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0X80081DE. error = ");
        ((StringBuilder)localObject).append(paramARCloudRecogResult.getMessage());
        QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
      }
      this.jdField_m_of_type_Long = 0L;
      this.jdField_n_of_type_Long = 0L;
    }
    else
    {
      l1 = 3000L;
      if (ARLocalFaceRecog.a()) {
        l1 = 4500L;
      }
      if (this.jdField_m_of_type_Long == 0L) {
        this.jdField_m_of_type_Long = System.currentTimeMillis();
      }
      this.jdField_n_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_m_of_type_Long > 0L) && (this.jdField_n_of_type_Long - this.jdField_m_of_type_Long > l1))
      {
        if (QLog.isColorLevel())
        {
          paramARCloudRecogResult = new StringBuilder();
          paramARCloudRecogResult.append("[ScanStarFace]onARRecogComplete stop Local Face Recog,lost all faces more than ");
          paramARCloudRecogResult.append(l1);
          QLog.d("AREngine_QQARSession", 2, paramARCloudRecogResult.toString());
        }
        a(4L);
        this.jdField_m_of_type_Long = -1L;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_Boolean = true;
        a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult, this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult);
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
        x();
        break label1774;
        if (paramARCloudRecogResult != null)
        {
          localObject = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult);
          l1 = ((ARRecognition.RecognitionResult)localObject).jdField_a_of_type_Long;
          bool1 = ((ARRecognition.RecognitionResult)localObject).jdField_a_of_type_Boolean;
          bool2 = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, l1);
          if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) || (l1 == 128L)) {
            break label1867;
          }
          e(false);
          if (!this.jdField_p_of_type_Boolean) {
            break label1867;
          }
          b(1L);
          this.jdField_p_of_type_Boolean = false;
          break label1867;
          if (l1 == 4L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
            }
            else if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 8L, 1L))
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2))
            {
              a(1L);
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult);
            }
          }
          else if (l1 == 2L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
            }
            else if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2L, 1L))
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2))
            {
              a(1L);
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
            }
          }
          else if (l1 == 128L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult);
            }
            else
            {
              if (this.jdField_q_of_type_Boolean)
              {
                if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null) {
                  e(false);
                }
                if (this.jdField_p_of_type_Boolean) {
                  this.jdField_p_of_type_Boolean = false;
                }
                return;
              }
              if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 128L, 1L))
              {
                a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult);
              }
              else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2))
              {
                a(1L);
                this.jdField_p_of_type_Boolean = true;
                a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult);
              }
            }
          }
          else if (l1 == 1L)
          {
            if (bool2)
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
            }
            else
            {
              if (bool1) {
                b(1L);
              }
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult);
            }
          }
          else if (l1 == 2048L) {
            if (bool2)
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
            }
            else if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2048L, 1L))
            {
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2))
            {
              a(1L);
              a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
              break label1774;
              l1 = this.jdField_f_of_type_Long;
              if (l1 != 0L)
              {
                if (paramARLocalRecogResult == null) {
                  return;
                }
                if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) {
                  a(paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult, this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult);
                } else if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) {
                  a(paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult, this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult);
                }
              }
              else
              {
                l1 = this.jdField_g_of_type_Long;
                if (l1 != 0L)
                {
                  if (paramARCloudRecogResult == null) {
                    return;
                  }
                  if (ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)) {
                    a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult);
                  } else if (ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)) {
                    a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult);
                  } else if (ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)) {
                    w();
                  } else if (ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)) {
                    x();
                  } else if (ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult)) {
                    a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (paramARLocalRecogResult != null) {
      if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
        if ((paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null) && (!paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.d()))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
          this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
        }
      }
      else if (paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = paramARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
      }
    }
    return;
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
    a(new QQARSession.25(this, paramArVideoResourceInfo, paramARRenderMangerInnerCallback));
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationStart. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.21(this, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onARCloudSelectImageComplete. result = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
      if (this.jdField_q_of_type_Long == 0L) {
        this.jdField_q_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_u_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_u_of_type_Long;
        if (l1 > 0L) {
          this.jdField_v_of_type_Long += l1;
        }
        this.jdField_u_of_type_Long = 0L;
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    paramArCloudConfigInfo = new StringBuilder();
    paramArCloudConfigInfo.append("onARMarkerResourceDownloadComplete. result = ");
    paramArCloudConfigInfo.append(paramBoolean);
    paramArCloudConfigInfo.append(" type  ");
    paramArCloudConfigInfo.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, paramArCloudConfigInfo.toString());
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
    UniformGLRenderManager localUniformGLRenderManager = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if (localUniformGLRenderManager != null) {
      localUniformGLRenderManager.a(0, paramArrayOfFloat);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    ARMIGObjectClassifyResult localARMIGObjectClassifyResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult;
    if (localARMIGObjectClassifyResult != null) {
      return localARMIGObjectClassifyResult.a(paramARMIGObjectClassifyResult) ^ true;
    }
    return true;
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
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      AREngineCallback localAREngineCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(2, paramInt);
      }
    }
  }
  
  public void b(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resumeLocalRecog. recogType = ");
    localStringBuilder.append(paramLong);
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationComplete. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.22(this, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onARCloudPretreatComplete. result = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start startInternal. mCurEngineState = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
    if ((this.jdField_a_of_type_Int == 0) && (CameraProxy.a().b()))
    {
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
      if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L))
      {
        a(5L);
      }
      else
      {
        a(4L);
        b(1L);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) && (!i()))
      {
        e(3);
        return 3;
      }
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(this);
      e(0);
      return 0;
    }
    return -1;
  }
  
  public void c()
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudUploadStart.");
    this.jdField_s_of_type_Int += 1;
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      AREngineCallback localAREngineCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(2, paramInt);
      }
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationPlayInterrupt. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.23(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    ARCloudRecogResult localARCloudRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult;
    if ((localARCloudRecogResult != null) && (localARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)) {
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
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      AREngineCallback localAREngineCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
      if (localAREngineCallback != null) {
        localAREngineCallback.a(0, 4);
      }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRenderManagerCallback. onARAnimationPlayError. key = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", remainPlayCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    a(new QQARSession.24(this, paramInt));
  }
  
  public void d(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_s_of_type_Long;
    long l1;
    if (l2 >= 1000L) {
      l1 = 0L;
    } else {
      l1 = 1000L - l2;
    }
    QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadCompleteInternal result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
    a(new QQARSession.14(this, paramBoolean, paramArCloudConfigInfo), l1);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARengine status resume now start. + mCurrentSessionStatus:=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 4) && (this.jdField_a_of_type_Int != 5))
    {
      if (this.jdField_a_of_type_Int == 2) {
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
      if ((!this.jdField_c_of_type_Boolean) && (this.jdField_t_of_type_Int != 1))
      {
        u();
        if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L))
        {
          a(5L);
        }
        else
        {
          a(4L);
          b(1L);
        }
        this.jdField_j_of_type_Boolean = true;
        this.jdField_a_of_type_Int = 2;
        QLog.d("AREngine_QQARSession", 1, "ARengine status resume now end.");
        return;
      }
      b(4096L);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(true, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
      this.jdField_j_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void h()
  {
    QLog.i("AREngine_QQARSession", 1, "ARengine status  pause. now ");
    if (this.jdField_g_of_type_Boolean)
    {
      if (this.jdField_a_of_type_Int != 2) {
        return;
      }
      z();
      m();
      t();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
      boolean bool;
      if ((localObject != null) && (!((ARLocalControl)localObject).a(4L))) {
        bool = true;
      } else {
        bool = false;
      }
      a(5L);
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
        if (localObject != null) {
          ((AREngineCallback)localObject).a(bool);
        }
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
      if (localObject != null) {
        ((ARMarkerResourceManager)localObject).b();
      }
      this.jdField_j_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(null);
    }
  }
  
  public void i()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stop start. mCurEngineState = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    if (this.jdField_a_of_type_Int == 5) {
      return;
    }
    this.jdField_a_of_type_Int = 4;
    this.jdField_d_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null)
    {
      b((Runnable)localObject);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    l();
    a(new QQARSession.3(this));
  }
  
  public void j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uninit start. mIsInited = ");
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    QLog.i("AREngine_QQARSession", 1, localStringBuilder.toString());
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    CameraProxy.a().c(this);
    a(new QQARSession.4(this));
  }
  
  public void m()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRender.");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
    if ((localObject != null) && (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null))
    {
      ((UniformGLRenderManager)localObject).d();
      if (CameraProxy.a().b()) {
        CameraProxy.a().a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4)))
      {
        localObject = new ARTarget(this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(this.jdField_h_of_type_Long, false, (ARTarget)localObject);
      }
    }
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public void n()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRenderOnly.");
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
    {
      UniformGLRenderManager localUniformGLRenderManager = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
      if (localUniformGLRenderManager != null) {
        localUniformGLRenderManager.d();
      }
    }
  }
  
  public void o()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudObjectClassifyResultComplete.");
    if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      b(1L);
    }
    y();
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager != null)) {
      if ((this.jdField_h_of_type_Boolean) && (this.jdField_a_of_type_Int == 2))
      {
        paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        paramCamera.a(paramCamera.a() + 1L);
        paramCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl;
        if ((paramCamera != null) && ((!paramCamera.a(1L)) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4096L))) && (!l()))
        {
          if ((this.jdField_t_of_type_Int == 0) || ((this.jdField_t_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.a() == 0) && (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager.b()))) {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager.a(), paramArrayOfByte);
          }
          if (this.jdField_c_of_type_Boolean)
          {
            paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
            paramCamera.b(paramCamera.a());
            paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
            if (paramCamera != null) {
              paramCamera.a();
            }
          }
          else
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(1L))
            {
              paramCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
              if ((paramCamera != null) && (paramCamera.jdField_a_of_type_Int == 2)) {}
            }
            else if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L))
            {
              paramCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
              if ((paramCamera != null) && (paramCamera.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {}
            }
            else
            {
              if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.b(4L))) {
                break label345;
              }
            }
            paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
            paramCamera.b(paramCamera.a());
            paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
            if (paramCamera != null) {
              paramCamera.a();
            }
          }
        }
        else
        {
          paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
          paramCamera.b(paramCamera.a());
          paramCamera = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
          if (paramCamera != null) {
            paramCamera.a();
          }
        }
        label345:
        paramCamera = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
        if (paramCamera != null) {
          paramCamera.a(paramArrayOfByte);
        }
      }
      else
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        paramArrayOfByte.a(paramArrayOfByte.a() + 1L);
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        paramArrayOfByte.b(paramArrayOfByte.a());
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqArModelUniformGLRenderManager;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.a();
        }
      }
    }
  }
  
  public void p()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessMigCloudObjectClassifyResultComplete.");
    if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L))
    {
      b(1L);
      this.jdField_p_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
    y();
  }
  
  public void q()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudSceneRecogResultComplete.");
    if (ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      b(1L);
    }
    y();
  }
  
  public void r()
  {
    QLog.d("AREngine_QQARSession", 1, "engine notifyRenderReady ");
    ArCloudConfigInfo localArCloudConfigInfo = this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
    if (localArCloudConfigInfo == null) {
      return;
    }
    if ((localArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)))
    {
      int i1 = this.jdField_e_of_type_Int;
      if (i1 == 1)
      {
        d(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        return;
      }
      if (i1 == 2) {
        e(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
      }
    }
  }
  
  public void s()
  {
    QLog.d("AREngine_QQARSession", 1, String.format("CloseAREngineRecoglizeFunction  ", new Object[0]));
    a(new QQARSession.27(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession
 * JD-Core Version:    0.7.0.1
 */