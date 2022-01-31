package com.tencent.mobileqq.ar.arengine;

import aaav;
import aaaw;
import aaax;
import aaay;
import aaaz;
import aaba;
import aabb;
import aabc;
import aabd;
import aabe;
import aabg;
import aabh;
import aabi;
import aabk;
import aabl;
import aabn;
import aabo;
import aabp;
import aabq;
import aabr;
import aabs;
import aabt;
import aabu;
import aabv;
import aabw;
import aabx;
import aaby;
import aabz;
import aaca;
import aacb;
import aacc;
import aacd;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.ViewConfiguration;
import com.hiar.sdk.utils.GlUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARGLSurfaceView.ARGLSurfaceViewCallback;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.ARBaseRender;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManager;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerCallBack;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderManagerImpl;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMangerInnerCallback;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderMarkerTrackInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderResourceInfo;
import com.tencent.mobileqq.ar.ARRenderModel.ARRenderTrackInfo;
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
import com.tencent.mobileqq.ar.keying.KeyingParams;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;

@TargetApi(14)
public class AREngine
  implements Camera.PreviewCallback, SurfaceHolder.Callback, ARGLSurfaceView.ARGLSurfaceViewCallback, ARRenderManagerCallBack, SensorTrackManager.ARSensorTrackCallback, ARCamera.AutoFocusListener, ARCloudControl.ARCloudControlCallback, AREngineCallbackFromUI, ARLocalControl.ARLocalRecogCallback, ARMarkerResourceManager.ARMarkerResourceCallback
{
  private static boolean A = true;
  private static AREngine jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
  public static boolean a;
  private boolean B;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARRenderManager jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager;
  private SensorTrackManager jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
  private ARTarget jdField_a_of_type_ComTencentMobileqqArARTarget;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = null;
  public ArCloudConfigInfo a;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  public ARCamera a;
  private ARCloudControl jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl;
  private ARCloudRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult;
  private AREngineCallback jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback;
  public ARLocalControl a;
  private ARLocalFaceRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
  private ARLocalMarkerRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
  private ARMIGObjectClassifyResult jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult;
  private ARMarkerResourceManager jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager;
  private QRRecognizerController jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString = "0";
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 5;
  private long jdField_b_of_type_Long = 0L;
  private Handler jdField_b_of_type_AndroidOsHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  public ArCloudConfigInfo b;
  private ARLocalFaceRecogResult jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult;
  private ARLocalMarkerRecogResult jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Runnable jdField_b_of_type_JavaLangRunnable = new aabw(this);
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 5;
  private final long jdField_c_of_type_Long = 5L;
  private ArCloudConfigInfo jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private Runnable jdField_c_of_type_JavaLangRunnable = new aabx(this);
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 5;
  private final long jdField_d_of_type_Long = 2247L;
  private ArCloudConfigInfo jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 5;
  private long jdField_e_of_type_Long = 0L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 5;
  private long jdField_f_of_type_Long = 0L;
  private volatile boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 5;
  private long jdField_g_of_type_Long = 0L;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 0;
  private long jdField_h_of_type_Long;
  private final boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = 0;
  private long jdField_i_of_type_Long;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  private boolean jdField_j_of_type_Boolean = true;
  private int jdField_k_of_type_Int = 300;
  private long jdField_k_of_type_Long;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private long jdField_l_of_type_Long;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private long jdField_m_of_type_Long;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private long jdField_n_of_type_Long;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private long jdField_o_of_type_Long;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int = 17;
  private long jdField_p_of_type_Long;
  private volatile boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int = -1;
  private long jdField_q_of_type_Long;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int;
  private long jdField_r_of_type_Long;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private long jdField_s_of_type_Long;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private long jdField_t_of_type_Long;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int;
  private long jdField_u_of_type_Long;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private long jdField_v_of_type_Long;
  private boolean jdField_v_of_type_Boolean = true;
  private long jdField_w_of_type_Long;
  private boolean jdField_w_of_type_Boolean = true;
  private boolean x = true;
  private boolean y;
  private boolean z;
  
  private AREngine()
  {
    A = false;
  }
  
  private void A()
  {
    QLog.i("AREngine_AREngine", 1, "onProcessCloudMarkerRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(1L);
    }
    C();
    this.jdField_t_of_type_Boolean = false;
  }
  
  private void B()
  {
    QLog.i("AREngine_AREngine", 1, "onProcessCloudFaceRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      C();
      this.jdField_u_of_type_Boolean = false;
      return;
      b(1L);
    }
  }
  
  private void C()
  {
    QLog.i("AREngine_AREngine", 1, "processCloudRecogResult end.");
    z();
  }
  
  private void D()
  {
    QLog.i("AREngine_AREngine", 1, "stopSensorTrack.");
    this.jdField_q_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.d();
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
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      localObject4 = ARVideoUtil.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.e);
      paramArCloudConfigInfo = new GeneralARResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, (String)localObject2, (String)localObject1, (String)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject4, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", resPath = " + paramArCloudConfigInfo.c + ", luaPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", musicPath = " + paramArCloudConfigInfo.jdField_d_of_type_JavaLangString + ", recogType = " + paramLong);
      return paramArCloudConfigInfo;
    }
    int i2;
    int i1;
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 2) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 3))
    {
      if (!VersionUtils.d())
      {
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo failed. NOT IceScreamSandwich.");
        return null;
      }
      if (ARVideoUtil.a())
      {
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
        return null;
      }
      localObject2 = ARResouceDir.e(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
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
      if (!paramArCloudConfigInfo.c()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.jdField_c_of_type_Int != 2))) {
          break label650;
        }
      }
      label650:
      for (localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, ARRenderManagerImpl.jdField_a_of_type_Int, ARRenderManagerImpl.jdField_b_of_type_Int, paramArCloudConfigInfo.i());; localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, ARRenderManagerImpl.jdField_a_of_type_Int, ARRenderManagerImpl.jdField_b_of_type_Int))
      {
        paramArCloudConfigInfo = new NormalVideoARResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", renderType = " + paramArCloudConfigInfo.jdField_d_of_type_Int + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams + ", videoPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout + ", videoPlayCount = " + i1 + ", recogType = " + paramLong);
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
      if (!paramArCloudConfigInfo.c()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.jdField_c_of_type_Int != 2))) {
          break label1120;
        }
      }
      label1120:
      for (localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, ARRenderManagerImpl.jdField_a_of_type_Int, ARRenderManagerImpl.jdField_b_of_type_Int, paramArCloudConfigInfo.i());; localObject1 = ARVideoUtil.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, ARRenderManagerImpl.jdField_a_of_type_Int, ARRenderManagerImpl.jdField_b_of_type_Int))
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
        paramArCloudConfigInfo = new OnlineVideoARRenderableInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, i2, (KeyingParams)localObject3, (ArCloudConfigInfo.ARVideoLayout)localObject1, (String)localObject2, l1, paramBoolean, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", renderType = " + paramArCloudConfigInfo.jdField_d_of_type_Int + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArKeyingKeyingParams + ", videoUrl = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", videoSize = " + paramArCloudConfigInfo.jdField_b_of_type_Long + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo$ARVideoLayout + ", isSoftDecode = " + paramArCloudConfigInfo.jdField_a_of_type_Boolean + ", videoPlayCount = " + i1 + ", recogType = " + paramLong);
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
            QLog.i("AREngine_AREngine", 1, "getMultiFragmentAnimARResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
            return null;
          }
        }
      }
      paramArCloudConfigInfo = new MultiFragmentAnimARResourceInfo(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 100)
    {
      localObject1 = ARResouceDir.a(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
      {
        QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      paramArCloudConfigInfo = new Interactive3DResourceInfo(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, 1, "", (String)localObject1, "", paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      QLog.i("AREngine_AREngine", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", resType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", resPath = " + paramArCloudConfigInfo.c + ", luaPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", musicPath = " + paramArCloudConfigInfo.jdField_d_of_type_JavaLangString);
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 7)
    {
      localObject1 = ARResouceDir.c(paramArCloudConfigInfo);
      localObject2 = ARResouceDir.b(paramArCloudConfigInfo);
      return new GreetingCardResourceInfo(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2);
    }
    return null;
  }
  
  public static AREngine a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArArengineAREngine == null) {
      jdField_a_of_type_ComTencentMobileqqArArengineAREngine = new AREngine();
    }
    return jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
  }
  
  private void a(ArCloudConfigInfo paramArCloudConfigInfo, String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_AREngine", 2, "onJoinBinHaiActSuccess configInfo: " + paramArCloudConfigInfo + "　actId：" + paramString);
        }
        boolean bool = this.B;
        if (bool) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
        }
        paramArCloudConfigInfo = new ARTarget(paramArCloudConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArARTarget = paramArCloudConfigInfo;
        c(false);
        if (a(32L, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.b();
          }
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
            this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(32L, paramArCloudConfigInfo);
          }
        }
        else
        {
          s();
        }
      }
      finally {}
    }
  }
  
  private void a(ARCloudLBSLocationCheckResult paramARCloudLBSLocationCheckResult, ArLBSActivity paramArLBSActivity)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramARCloudLBSLocationCheckResult, paramArLBSActivity);
    }
  }
  
  private void a(ARCloudMarkerRecogResult paramARCloudMarkerRecogResult)
  {
    QLog.i("AREngine_AREngine", 1, "processCloudMarkerRecogResult start.");
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new aaba(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARCloudMarkerRecogResult, this, this.z, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_AREngine", 1, "processCloudMarkerRecogResult end. download preprocess failed.");
      this.jdField_m_of_type_Boolean = false;
      A();
      return;
    }
    a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ARCloudObjectClassifyResult paramARCloudObjectClassifyResult)
  {
    QLog.i("AREngine_AREngine", 1, "processYouTuCloudObjectClassifyResult start.");
    this.jdField_a_of_type_JavaLangRunnable = new aabb(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARCloudObjectClassifyResult, this, this.z, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_AREngine", 1, "processYouTuCloudObjectClassifyResult end. download preprocess failed.");
      l();
      return;
    }
    QLog.i("AREngine_AREngine", 1, "processYouTuCloudObjectClassifyResult post task for handle timeout");
    a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ARCloudRecogRspFaceResult paramARCloudRecogRspFaceResult)
  {
    QLog.i("AREngine_AREngine", 1, "processCloudFaceRecogResult start.");
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(paramARCloudRecogRspFaceResult);
    b(4L);
    this.jdField_u_of_type_Boolean = true;
    QLog.i("AREngine_AREngine", 1, "processCloudFaceRecogResult end.");
  }
  
  private void a(ARCloudSceneRecogResult paramARCloudSceneRecogResult)
  {
    QLog.i("AREngine_AREngine", 1, "processCloudSceneRecogResult start.");
    this.jdField_a_of_type_JavaLangRunnable = new aabd(this);
    if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARCloudSceneRecogResult, this, this.z, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_AREngine", 1, "processCloudSceneRecogResult end. download preprocess failed.");
      n();
      return;
    }
    QLog.i("AREngine_AREngine", 1, "processCloudSceneRecogResult post task for handle timeout");
    a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ARLocalFaceRecogResult paramARLocalFaceRecogResult1, ARLocalFaceRecogResult paramARLocalFaceRecogResult2)
  {
    if ((QLog.isColorLevel()) && (ARLocalFaceRecog.jdField_a_of_type_Boolean)) {
      QLog.d("AREngine_AREngine", 2, "ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = " + paramARLocalFaceRecogResult1);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.b(paramARLocalFaceRecogResult1.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
    }
    a(null, paramARLocalFaceRecogResult1);
  }
  
  private void a(ARLocalMarkerRecogResult paramARLocalMarkerRecogResult1, ARLocalMarkerRecogResult paramARLocalMarkerRecogResult2)
  {
    if (paramARLocalMarkerRecogResult1.jdField_a_of_type_Int != 2) {
      if (paramARLocalMarkerRecogResult1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.e())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.b(paramARLocalMarkerRecogResult1.jdField_a_of_type_Long);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
        }
        this.jdField_j_of_type_Long = 0L;
        this.jdField_k_of_type_Long = 0L;
        if (paramARLocalMarkerRecogResult1.jdField_a_of_type_Int == 0) {
          a(1L, paramARLocalMarkerRecogResult1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, paramARLocalMarkerRecogResult1.jdField_a_of_type_Float, paramARLocalMarkerRecogResult1.jdField_b_of_type_Float, paramARLocalMarkerRecogResult1.c);
        }
        a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, paramARLocalMarkerRecogResult1.jdField_a_of_type_Float, paramARLocalMarkerRecogResult1.jdField_b_of_type_Float, paramARLocalMarkerRecogResult1.c, paramARLocalMarkerRecogResult1.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int)));
        this.jdField_t_of_type_Boolean = true;
      }
    }
    do
    {
      do
      {
        return;
        if ((paramARLocalMarkerRecogResult2 != null) && (paramARLocalMarkerRecogResult2.jdField_a_of_type_Int != 2)) {
          this.jdField_j_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_k_of_type_Long = System.currentTimeMillis();
      } while (this.jdField_j_of_type_Long <= 0L);
      if (k())
      {
        paramARLocalMarkerRecogResult2 = new float[16];
        a(new ARRenderMarkerTrackInfo(paramARLocalMarkerRecogResult1.jdField_b_of_type_Int, 0.0F, 0.0F, 0.0F, paramARLocalMarkerRecogResult2, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int)));
      }
    } while (this.jdField_k_of_type_Long - this.jdField_j_of_type_Long <= 1500L);
    this.jdField_j_of_type_Long = 0L;
    ARVideoRecordUIControllerImpl.a().b(1);
    j();
  }
  
  private void a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    QLog.i("AREngine_AREngine", 1, "processMIGCloudObjectClassifyResult start.");
    if (paramARMIGObjectClassifyResult.a() == -1)
    {
      m();
      return;
    }
    if (paramARMIGObjectClassifyResult.a() == 1)
    {
      b(paramARMIGObjectClassifyResult);
      return;
    }
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) {
      i1 = 1;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) && (i1 != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.b(true);
      QLog.i("AREngine_AREngine", 1, "processMIGCloudObjectClassifyResultInternal setCompareSameSceneFlag.");
      return;
      if (!paramARMIGObjectClassifyResult.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    b(paramARMIGObjectClassifyResult);
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (b() != null) {
      b().d(paramRunnable);
    }
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    if (b() != null) {
      b().b(paramRunnable, paramLong);
    }
  }
  
  private boolean a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ARRenderResourceInfo localARRenderResourceInfo1 = a(paramArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    if (localARRenderResourceInfo1 == null) {
      return false;
    }
    QLog.i("AREngine_AREngine", 1, "startModelRender. recogType = " + paramLong + ", key = " + localARRenderResourceInfo1.jdField_a_of_type_JavaLangString + ", resType = " + localARRenderResourceInfo1.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null)
    {
      this.jdField_g_of_type_Long = paramLong;
      this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      ARRenderResourceInfo localARRenderResourceInfo2 = a(this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      if ((localARRenderResourceInfo2 != null) && (localARRenderResourceInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localARRenderResourceInfo1.jdField_a_of_type_JavaLangString))) {
        return true;
      }
      if ((localARRenderResourceInfo2 == null) || (localARRenderResourceInfo2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localARRenderResourceInfo1.jdField_a_of_type_JavaLangString))) {
        break label350;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.d();
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(localARRenderResourceInfo1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) && (this.jdField_l_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.b();
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null))
      {
        if ((!paramArCloudConfigInfo.a()) && (paramArCloudConfigInfo.e())) {
          ARVideoRecordUIControllerImpl.a().a(3);
        }
        paramArCloudConfigInfo = new ARTarget(paramArCloudConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramLong, true, paramArCloudConfigInfo);
      }
      this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      if (this.jdField_r_of_type_Int == 0)
      {
        this.jdField_o_of_type_Long = System.currentTimeMillis();
        this.jdField_r_of_type_Int = ((int)(this.jdField_o_of_type_Long - this.jdField_n_of_type_Long));
      }
      if ((this.jdField_s_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null))
      {
        this.jdField_q_of_type_Long = System.currentTimeMillis();
        this.jdField_s_of_type_Int = ((int)(this.jdField_q_of_type_Long - this.jdField_p_of_type_Long));
      }
      return true;
      label350:
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(localARRenderResourceInfo1);
    }
  }
  
  public static AREngine b()
  {
    return jdField_a_of_type_ComTencentMobileqqArArengineAREngine;
  }
  
  private void b(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    QLog.i("AREngine_AREngine", 1, "processMIGCloudObjectClassifyResultInternal start.");
    if (paramARMIGObjectClassifyResult.a() == 1)
    {
      ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null) {
        i(false);
      }
      this.jdField_a_of_type_JavaLangRunnable = new aabc(this);
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(paramARMIGObjectClassifyResult, this, this.z, this.jdField_a_of_type_JavaLangString))
      {
        QLog.i("AREngine_AREngine", 1, "processMIGCloudObjectClassifyResult end. download preprocess failed.");
        m();
      }
    }
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult localARMigObjectClassifyExternalRenderResult;
    do
    {
      return;
      QLog.i("AREngine_AREngine", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
      a(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
      ReportController.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
      localARMigObjectClassifyExternalRenderResult = paramARMIGObjectClassifyResult.a();
      if (localARMigObjectClassifyExternalRenderResult != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = paramARMIGObjectClassifyResult;
        a(null, localARMigObjectClassifyExternalRenderResult);
        z();
      }
    } while ((localARMigObjectClassifyExternalRenderResult != null) && (localARMigObjectClassifyExternalRenderResult.jdField_a_of_type_Boolean));
    m();
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (b() != null) {
      b().e(paramRunnable);
    }
  }
  
  private void b(Runnable paramRunnable, long paramLong)
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
  
  public static boolean b()
  {
    return A;
  }
  
  public static void c(Runnable paramRunnable)
  {
    if (b() != null) {
      b().f(paramRunnable);
    }
  }
  
  private boolean c(boolean paramBoolean)
  {
    QLog.i("AREngine_AREngine", 1, "startSensorTrack. isForExternalTrack = " + paramBoolean);
    this.jdField_q_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.a();
    }
    return true;
  }
  
  public static void d()
  {
    jdField_a_of_type_ComTencentMobileqqArArengineAREngine = null;
    A = true;
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_h_of_type_Int = 2;
    }
    for (;;)
    {
      QLog.i("AREngine_AREngine", 1, "start end. mCurEngineState = " + this.jdField_h_of_type_Int);
      QLog.i("AREngine_AREngine", 1, "onStartComplete. retCode = " + paramInt);
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.c(paramInt);
      }
      return;
      this.jdField_h_of_type_Int = 0;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  private void d(Runnable paramRunnable)
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
  
  public static void e()
  {
    if (b() != null) {
      b().u();
    }
  }
  
  private void e(Runnable paramRunnable)
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
              break label107;
            }
            QLog.i("AREngine_AREngine", 1, "removeTask. task = " + this.jdField_b_of_type_JavaUtilArrayList.get(i1));
            this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramRunnable);
          }
        }
        return;
      }
      label107:
      i1 += 1;
    }
  }
  
  private void e(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_r_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_AREngine", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      a(new aabi(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
      return;
    }
  }
  
  private void f(Runnable paramRunnable)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  private void f(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_r_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_AREngine", 1, String.format("onARSceneRecogDownloadCompleteInteral result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      a(new aabl(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
      return;
    }
  }
  
  private void h(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.b(paramBoolean);
    }
  }
  
  private void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
    ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ARMigObjectClassifyExternalRenderResult.jdField_b_of_type_Boolean = paramBoolean;
    a(null, ARMIGObjectClassifyResult.ARMigObjectClassifyExternalRenderResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult$ARMigObjectClassifyExternalRenderResult);
  }
  
  private boolean l()
  {
    QLog.i("AREngine_AREngine", 1, "startAfterCameraOpened start. mCurEngineState = " + this.jdField_h_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager.a(this.jdField_a_of_type_AndroidContentContext, this);
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) && (!n()))
    {
      d(7);
      return false;
    }
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(5L);
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) && (!o()))
    {
      d(3);
      return false;
      a(4L);
      b(1L);
    }
    d(0);
    return true;
  }
  
  private boolean m()
  {
    QLog.i("AREngine_AREngine", 2, "startRenderManager.");
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(0, this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge);
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a();
  }
  
  private boolean n()
  {
    QLog.i("AREngine_AREngine", 2, "startLocalRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
    {
      if (this.z)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos != null)) {
          this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.mArCloudConfigInfos.clear();
        }
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_e_of_type_Long, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this)) {
        return false;
      }
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a();
    }
    return false;
  }
  
  private boolean o()
  {
    QLog.i("AREngine_AREngine", 2, "startCloudRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_p_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.b();
      return true;
    }
    return false;
  }
  
  private boolean p()
  {
    QLog.i("AREngine_AREngine", 2, "stopLocalRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a();
    }
    return true;
  }
  
  private boolean q()
  {
    QLog.i("AREngine_AREngine", 2, "stopCloudRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.e();
    }
    return true;
  }
  
  private boolean r()
  {
    QLog.i("AREngine_AREngine", 2, "stopRenderManager.");
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a();
    }
    return true;
  }
  
  private boolean s()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.y)
    {
      bool1 = bool2;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof ScanTorchActivity))
      {
        long l1 = ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).a();
        bool1 = bool2;
        if (l1 > 0L) {
          if (System.currentTimeMillis() >= l1 + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARLocalStartDelay) {
            break label81;
          }
        }
      }
    }
    label81:
    for (bool1 = true;; bool1 = false)
    {
      if ((QLog.isColorLevel()) && (bool1)) {
        QLog.i("AREngine_AREngine", 2, "isARLocalInStartDelay in start delay.");
      }
      return bool1;
    }
  }
  
  private void u()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_b_of_type_JavaUtilArrayList != null))
      {
        QLog.i("AREngine_AREngine", 1, "removeAllTask. task count = " + this.jdField_b_of_type_JavaUtilArrayList.size());
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
  
  private void v()
  {
    f(new aaav(this));
  }
  
  private void w()
  {
    QLog.i("AREngine_AREngine", 2, "startPreviewAfterSurfaceCtreated.");
    if ((this.jdField_i_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera == null) || (this.jdField_l_of_type_Boolean)) {
      QLog.i("AREngine_AREngine", 2, String.format("cancel to start preview. mCurCameraState=%s mARCamera=%s mIsCameraPreviewing=%s", new Object[] { Integer.valueOf(this.jdField_i_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera, Boolean.valueOf(this.jdField_l_of_type_Boolean) }));
    }
    do
    {
      return;
      this.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a();
      this.jdField_o_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.b();
      this.jdField_p_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.c();
      this.jdField_q_of_type_Int = GlUtil.a(36197);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_q_of_type_Int);
      QLog.i("AREngine_AREngine", 1, "mTextureId = " + this.jdField_q_of_type_Int + ", realImageFormat = " + this.jdField_p_of_type_Int + ", realImageWidth = " + this.jdField_n_of_type_Int + ", realImageHeight = " + this.jdField_o_of_type_Int);
      this.jdField_l_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this);
      if (!this.jdField_l_of_type_Boolean) {
        break;
      }
      QLog.i("AREngine_AREngine", 2, "start preview successfully. mCurCameraState = " + this.jdField_i_of_type_Int);
      if ((this.jdField_l_of_type_Int > 0) && (this.jdField_l_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_q_of_type_Int, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      QLog.i("AREngine_AREngine", 2, "openCamera end. mIsCameraPreviewing = " + this.jdField_l_of_type_Boolean);
    } while (this.jdField_h_of_type_Int != 1);
    a(new aabh(this));
    return;
    QLog.i("AREngine_AREngine", 2, "start preview failed. mCurCameraState = " + this.jdField_i_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a();
    this.jdField_i_of_type_Int = 0;
    d(2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("ar_model", Build.MODEL);
    localHashMap.put("ar_type", "2");
    localHashMap.put("ar_reason", String.valueOf(-4));
    StatisticCollector.a(BaseApplication.getContext()).a("", "AndroidARException", true, 0L, 0L, localHashMap, "", true);
  }
  
  /* Error */
  private void x()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 216	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager	Lcom/tencent/mobileqq/ar/ARRenderModel/SensorTrackManager;
    //   4: ifnull +15 -> 19
    //   7: aload_0
    //   8: getfield 216	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager	Lcom/tencent/mobileqq/ar/ARRenderModel/SensorTrackManager;
    //   11: invokevirtual 1117	com/tencent/mobileqq/ar/ARRenderModel/SensorTrackManager:e	()V
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 216	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager	Lcom/tencent/mobileqq/ar/ARRenderModel/SensorTrackManager;
    //   19: aload_0
    //   20: getfield 628	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl	Lcom/tencent/mobileqq/ar/arengine/ARLocalControl;
    //   23: ifnull +15 -> 38
    //   26: aload_0
    //   27: getfield 628	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl	Lcom/tencent/mobileqq/ar/arengine/ARLocalControl;
    //   30: invokevirtual 1118	com/tencent/mobileqq/ar/arengine/ARLocalControl:b	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 628	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl	Lcom/tencent/mobileqq/ar/arengine/ARLocalControl;
    //   38: aload_0
    //   39: getfield 752	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl	Lcom/tencent/mobileqq/ar/arengine/ARCloudControl;
    //   42: ifnull +15 -> 57
    //   45: aload_0
    //   46: getfield 752	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl	Lcom/tencent/mobileqq/ar/arengine/ARCloudControl;
    //   49: invokevirtual 1120	com/tencent/mobileqq/ar/arengine/ARCloudControl:f	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 752	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl	Lcom/tencent/mobileqq/ar/arengine/ARCloudControl;
    //   57: aload_0
    //   58: getfield 531	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager	Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;
    //   61: ifnull +15 -> 76
    //   64: aload_0
    //   65: getfield 531	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager	Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;
    //   68: invokevirtual 1121	com/tencent/mobileqq/ar/arengine/ARMarkerResourceManager:b	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 531	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager	Lcom/tencent/mobileqq/ar/arengine/ARMarkerResourceManager;
    //   76: aload_0
    //   77: getfield 229	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderManager;
    //   80: ifnull +17 -> 97
    //   83: aload_0
    //   84: getfield 229	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderManager;
    //   87: invokeinterface 1122 1 0
    //   92: aload_0
    //   93: aconst_null
    //   94: putfield 229	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager	Lcom/tencent/mobileqq/ar/ARRenderModel/ARRenderManager;
    //   97: aload_0
    //   98: iconst_m1
    //   99: putfield 144	com/tencent/mobileqq/ar/arengine/AREngine:jdField_q_of_type_Int	I
    //   102: aload_0
    //   103: iconst_0
    //   104: putfield 811	com/tencent/mobileqq/ar/arengine/AREngine:jdField_k_of_type_Boolean	Z
    //   107: aload_0
    //   108: getfield 1046	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   111: ifnull +15 -> 126
    //   114: aload_0
    //   115: getfield 1046	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   118: invokevirtual 1125	android/graphics/SurfaceTexture:release	()V
    //   121: aload_0
    //   122: aconst_null
    //   123: putfield 1046	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidGraphicsSurfaceTexture	Landroid/graphics/SurfaceTexture;
    //   126: aload_0
    //   127: getfield 138	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Int	I
    //   130: ifeq +86 -> 216
    //   133: ldc 172
    //   135: iconst_2
    //   136: ldc_w 1127
    //   139: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: iconst_0
    //   143: istore_1
    //   144: aload_0
    //   145: getfield 138	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Int	I
    //   148: ifeq +59 -> 207
    //   151: iload_1
    //   152: iconst_1
    //   153: iadd
    //   154: istore_1
    //   155: iload_1
    //   156: bipush 20
    //   158: if_icmpge +49 -> 207
    //   161: ldc2_w 1128
    //   164: invokestatic 1134	java/lang/Thread:sleep	(J)V
    //   167: goto -23 -> 144
    //   170: astore_2
    //   171: aload_2
    //   172: invokevirtual 1137	java/lang/Exception:printStackTrace	()V
    //   175: ldc 172
    //   177: iconst_1
    //   178: new 286	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 1139
    //   188: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_2
    //   192: invokevirtual 1142	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   195: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: goto -60 -> 144
    //   207: ldc 172
    //   209: iconst_2
    //   210: ldc_w 1144
    //   213: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_0
    //   217: iconst_0
    //   218: putfield 790	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Boolean	Z
    //   221: aload_0
    //   222: iconst_0
    //   223: putfield 138	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Int	I
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield 815	com/tencent/mobileqq/ar/arengine/AREngine:jdField_j_of_type_Int	I
    //   231: aload_0
    //   232: aconst_null
    //   233: putfield 963	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARNativeBridge	Lcom/tencent/mobileqq/ar/ARNativeBridge;
    //   236: aload_0
    //   237: aconst_null
    //   238: putfield 549	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView	Lcom/tencent/mobileqq/ar/ARGLSurfaceView;
    //   241: aload_0
    //   242: getfield 132	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   245: astore_2
    //   246: aload_2
    //   247: monitorenter
    //   248: aload_0
    //   249: getfield 1146	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   252: ifnull +58 -> 310
    //   255: aload_0
    //   256: getfield 851	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   259: ifnull +11 -> 270
    //   262: aload_0
    //   263: getfield 851	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   266: aconst_null
    //   267: invokevirtual 1150	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   270: aload_0
    //   271: aconst_null
    //   272: putfield 851	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   275: aload_0
    //   276: getfield 1146	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   279: invokevirtual 1155	android/os/HandlerThread:quit	()Z
    //   282: pop
    //   283: aload_0
    //   284: getfield 1146	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   287: invokevirtual 1158	android/os/HandlerThread:interrupt	()V
    //   290: aload_0
    //   291: getfield 1146	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   294: ldc2_w 1159
    //   297: invokevirtual 1163	android/os/HandlerThread:join	(J)V
    //   300: aload_0
    //   301: aconst_null
    //   302: putfield 1146	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   305: aload_0
    //   306: aconst_null
    //   307: putfield 859	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   310: aload_2
    //   311: monitorexit
    //   312: aload_0
    //   313: getfield 134	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   316: astore_2
    //   317: aload_2
    //   318: monitorenter
    //   319: aload_0
    //   320: getfield 1165	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   323: ifnull +53 -> 376
    //   326: aload_0
    //   327: getfield 934	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   330: ifnull +11 -> 341
    //   333: aload_0
    //   334: getfield 934	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   337: aconst_null
    //   338: invokevirtual 1150	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   341: aload_0
    //   342: aconst_null
    //   343: putfield 934	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   346: aload_0
    //   347: getfield 1165	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   350: invokevirtual 1155	android/os/HandlerThread:quit	()Z
    //   353: pop
    //   354: aload_0
    //   355: getfield 1165	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   358: invokevirtual 1158	android/os/HandlerThread:interrupt	()V
    //   361: aload_0
    //   362: getfield 1165	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   365: ldc2_w 1159
    //   368: invokevirtual 1163	android/os/HandlerThread:join	(J)V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 1165	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_AndroidOsHandlerThread	Landroid/os/HandlerThread;
    //   376: aload_2
    //   377: monitorexit
    //   378: return
    //   379: astore_3
    //   380: aload_3
    //   381: invokevirtual 1137	java/lang/Exception:printStackTrace	()V
    //   384: ldc 172
    //   386: iconst_1
    //   387: new 286	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 1167
    //   397: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_3
    //   401: invokevirtual 1142	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 1169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: goto -113 -> 300
    //   416: astore_3
    //   417: aload_2
    //   418: monitorexit
    //   419: aload_3
    //   420: athrow
    //   421: astore_3
    //   422: aload_3
    //   423: invokevirtual 1137	java/lang/Exception:printStackTrace	()V
    //   426: ldc 172
    //   428: iconst_1
    //   429: new 286	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 1171
    //   439: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_3
    //   443: invokevirtual 1142	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   446: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 1169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: goto -84 -> 371
    //   458: astore_3
    //   459: aload_2
    //   460: monitorexit
    //   461: aload_3
    //   462: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	AREngine
    //   143	16	1	i1	int
    //   170	22	2	localException1	Exception
    //   379	22	3	localException2	Exception
    //   416	4	3	localObject2	Object
    //   421	22	3	localException3	Exception
    //   458	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   161	167	170	java/lang/Exception
    //   290	300	379	java/lang/Exception
    //   248	270	416	finally
    //   270	290	416	finally
    //   290	300	416	finally
    //   300	310	416	finally
    //   310	312	416	finally
    //   380	413	416	finally
    //   417	419	416	finally
    //   361	371	421	java/lang/Exception
    //   319	341	458	finally
    //   341	361	458	finally
    //   361	371	458	finally
    //   371	376	458	finally
    //   376	378	458	finally
    //   422	455	458	finally
    //   459	461	458	finally
  }
  
  private void y()
  {
    QLog.i("AREngine_AREngine", 1, "pauseCloudRecog.");
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.d();
    }
  }
  
  private void z()
  {
    QLog.i("AREngine_AREngine", 1, "resumeCloudRecog.");
    if (this.jdField_s_of_type_Int == 0) {
      this.jdField_p_of_type_Long = 0L;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    this.jdField_m_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.c();
    }
  }
  
  public int a()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public int a(Context arg1, AppInterface paramAppInterface)
  {
    long l1 = System.currentTimeMillis();
    QLog.d("AREngine_AREngine", 1, String.format("init context=%s appInterface=%s mIsInited=%s", new Object[] { ???, paramAppInterface, Boolean.valueOf(this.jdField_c_of_type_Boolean) }));
    if (this.jdField_c_of_type_Boolean) {
      return 0;
    }
    this.jdField_a_of_type_AndroidContentContext = ???;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera = new ARCamera();
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = new ARGLSurfaceView(this.jdField_a_of_type_AndroidContentContext, this, this);
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager = new ARRenderManagerImpl();
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, this.jdField_a_of_type_AndroidContentContext, this);
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderer(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager);
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderMode(0);
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
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
        {
          this.jdField_b_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ARCameraThread", 0);
          this.jdField_b_of_type_AndroidOsHandlerThread.start();
          this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper());
        }
        this.jdField_c_of_type_Boolean = true;
        if (Build.MODEL.equalsIgnoreCase("Redmi Note 3"))
        {
          this.jdField_k_of_type_Int = 500;
          this.jdField_j_of_type_Int = 0;
          this.jdField_i_of_type_Int = 0;
          QLog.d("AREngine_AREngine", 1, String.format("init time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
          return 0;
          paramAppInterface = finally;
          throw paramAppInterface;
        }
      }
      this.jdField_k_of_type_Int = 300;
    }
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ARCommonConfigInfo paramARCommonConfigInfo, ArConfigInfo paramArConfigInfo, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, AREngineCallback paramAREngineCallback)
  {
    QLog.d("AREngine_AREngine", 1, String.format("initAR isEnableARCloudFromSettings=%s isEnableARCloudFromH5=%s isTestMode=%s commonConfig=%s markerConfig=%s faceConfig=%s arEngineCallback=%s mIsArInited=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), paramARCommonConfigInfo, paramArConfigInfo, paramARScanStarFaceConfigInfo, paramAREngineCallback, Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
    if (this.jdField_d_of_type_Boolean) {
      return 0;
    }
    if (paramARCommonConfigInfo == null)
    {
      this.jdField_d_of_type_Boolean = false;
      QLog.i("AREngine_AREngine", 1, "initAR fail! commonConfig is null.");
      if (paramAREngineCallback != null) {
        paramAREngineCallback.c(3);
      }
      return 3;
    }
    jdField_a_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback = paramAREngineCallback;
    this.jdField_g_of_type_Boolean = paramARCommonConfigInfo.isEnableARCloud();
    this.jdField_a_of_type_Long = ARRecognition.b(paramARCommonConfigInfo.recognitions);
    this.jdField_b_of_type_Long = ARRecognition.a(paramARCommonConfigInfo.recognitions);
    if (this.jdField_g_of_type_Boolean) {}
    for (paramBoolean3 = true;; paramBoolean3 = false)
    {
      this.jdField_i_of_type_Boolean = paramBoolean3;
      if (!paramBoolean2) {
        this.jdField_i_of_type_Boolean = false;
      }
      if (paramBoolean1) {
        this.jdField_i_of_type_Boolean = true;
      }
      this.jdField_e_of_type_Long = (this.jdField_a_of_type_Long & 0x5);
      this.jdField_f_of_type_Long = (this.jdField_b_of_type_Long & 0x8C7);
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions == null) {
        break;
      }
      int i2;
      for (int i1 = 0; i1 < this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.size(); i1 = i2 + 1)
      {
        long l1 = 1 << (int)((ARRecognition)this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.get(i1)).jdField_a_of_type_Long;
        i2 = i1;
        if ((this.jdField_e_of_type_Long & l1) == 0L)
        {
          i2 = i1;
          if ((l1 & this.jdField_f_of_type_Long) == 0L)
          {
            this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions.remove(i1);
            i2 = i1 - 1;
          }
        }
      }
    }
    this.jdField_b_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L);
    this.jdField_c_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2L);
    this.jdField_d_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 4L);
    this.jdField_e_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L);
    this.jdField_f_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 128L);
    this.jdField_g_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2048L);
    QLog.i("AREngine_AREngine", 1, "initAR mIsEnableARCloudFromConfig=" + this.jdField_g_of_type_Boolean + " mLocalRecogTypeFromConfig=" + this.jdField_a_of_type_Long + " mCloudRecogTypeFromConfig=" + this.jdField_b_of_type_Long + " mIsEnableARCloudFromClientSupport=" + true + " mLocalRecogTypeFromClientSupport=" + 5L + " mCloudRecogTypeFromClientSupport=" + 2247L + " mIsEnableARCloud=" + this.jdField_i_of_type_Boolean + " mLocalRecogType=" + this.jdField_e_of_type_Long + " mCloudRecogType=" + this.jdField_f_of_type_Long + " mMarkerRecogPriority=" + this.jdField_b_of_type_Int + " mObjectClassifyPriority=" + this.jdField_c_of_type_Int + " mFaceRecogPriority=" + this.jdField_d_of_type_Int + " mPreOcrRecogPriority=" + this.jdField_e_of_type_Int + " mSceneRecogPriority=" + this.jdField_g_of_type_Int);
    QLog.i("AREngine_AREngine", 1, "Build.MODEL = " + Build.MODEL);
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = new ARNativeBridge();
    if (!this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.isLoadSoSuccess())
    {
      QLog.i("AREngine_AREngine", 1, "initAR fail! ARNativeBridge init fail.");
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = null;
      this.jdField_d_of_type_Boolean = false;
      if (paramAREngineCallback != null) {
        paramAREngineCallback.c(6);
      }
      return 6;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.mAttached = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
    m();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager = new ARMarkerResourceManager(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime > 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime * 60L * 1000L, jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a();
      if ((this.jdField_e_of_type_Long != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl == null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl = new ARLocalControl();
      }
      if ((!this.jdField_i_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = new ARCloudControl();
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, 900000000, 900000000, 0, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo)) {
        break;
      }
      QLog.i("AREngine_AREngine", 1, "initAR fail! ARCloud init fail.");
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl = null;
      this.jdField_d_of_type_Boolean = false;
      if (paramAREngineCallback != null) {
        paramAREngineCallback.c(8);
      }
      return 8;
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a(86400000L, jdField_a_of_type_Boolean);
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_h_of_type_Int = 0;
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARCloudUploadDelayTime;
  }
  
  public GLSurfaceView a()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
  }
  
  public ARRenderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager;
  }
  
  public SensorTrackManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelSensorTrackManager;
  }
  
  public String a()
  {
    String str = null;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      str = OcrImageUtil.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_p_of_type_Int, 0, 0);
    }
    return str;
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a();
    }
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    QLog.i("AREngine_AREngine", 1, "onARMarkerAllDownloadProgress. progress = " + paramInt);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(2, paramInt);
    }
  }
  
  public void a(int paramInt, ARCloudRecogResult paramARCloudRecogResult)
  {
    QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. retCode = " + paramInt + ", recogResult = " + paramARCloudRecogResult + ":time is:" + (System.currentTimeMillis() - this.jdField_s_of_type_Long));
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    if ((paramInt == 0) && (this.x))
    {
      this.x = false;
      ReportController.b(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null)) || ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int != 2)) || ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size() > 0)) || (k()))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null)) {
        QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
        }
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int != 2)) {
          QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
        } else if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
        } else if (k()) {
          QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
        }
      }
    }
    int i1;
    boolean bool;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null))
    {
      QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
      i1 = 0;
      if ((paramInt != 0) || (paramARCloudRecogResult == null)) {
        break label1053;
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
            QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
          }
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onARCloudUploadImgComplete result:  marker{success: ").append(ARCloudMarkerRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult)).append(", priority: ").append(this.jdField_b_of_type_Int).append("}");
        localStringBuilder1.append("  object{success: ").append(ARCloudObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult)).append(", priority: ").append(this.jdField_c_of_type_Int).append("}");
        localStringBuilder1.append("  face{success: ").append(ARCloudRecogRspFaceResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult)).append(", priority: ").append(this.jdField_d_of_type_Int).append("}");
        localStringBuilder1.append("  pre ocr{success: ").append(ARCloudPreOcrResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudPreOcrResult)).append(", priority: ").append(this.jdField_e_of_type_Int).append("}");
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" \n mig-object{success: ").append(ARMIGObjectClassifyResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult)).append(", priority: ").append(this.jdField_f_of_type_Int).append("}name:");
        if (paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) {
          break label883;
        }
        localObject = paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.toString();
        label649:
        localStringBuilder2.append((String)localObject);
        localStringBuilder1.append("  scene{success: ").append(ARCloudSceneRecogResult.a(paramARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult)).append(", priority: ").append(this.jdField_g_of_type_Int).append("}");
        QLog.i("AREngine_AREngine", 2, localStringBuilder1.toString());
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (!this.y))
      {
        QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete first recognize success.");
        this.y = true;
      }
      if ((bool) && (i1 == 0))
      {
        this.jdField_n_of_type_Boolean = true;
        a(new aacd(this));
      }
      for (;;)
      {
        if (i1 != 0) {
          break label922;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)
        {
          i(true);
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (!this.jdField_p_of_type_Boolean)) {
            m();
          }
        }
        if ((!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) && ((this.jdField_e_of_type_Long & 1L) != 0L))
        {
          y();
          b(1L);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
        }
        QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult == null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null)) {
          break;
        }
        QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
        break;
        label883:
        localObject = "";
        break label649;
        if ((!bool) && (this.jdField_n_of_type_Boolean))
        {
          this.jdField_n_of_type_Boolean = false;
          a(new aaaw(this));
        }
      }
      label922:
      if (i1 != 0)
      {
        localObject = ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult);
        if ((ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult)) && (((ARCloudLBSLocationCheckResult)localObject).jdField_a_of_type_Int != 1))
        {
          a(new aaax(this, (ARCloudLBSLocationCheckResult)localObject, ARCloudRecogResult.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramARCloudRecogResult)));
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
            this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
          }
          QLog.i("AREngine_AREngine", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
          return;
        }
      }
      y();
      this.jdField_h_of_type_Long = 0L;
      this.jdField_i_of_type_Long = 0L;
      a(new aaay(this, paramARCloudRecogResult));
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(true);
      return;
      label1053:
      i1 = 0;
      bool = false;
    }
  }
  
  public void a(long paramLong)
  {
    QLog.i("AREngine_AREngine", 1, "pauseLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(paramLong);
    }
  }
  
  public void a(long paramLong, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    ARLocalRecogResult localARLocalRecogResult = new ARLocalRecogResult();
    if ((1L & paramLong) != 0L) {
      localARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = ((ARLocalMarkerRecogResult)paramARLocalRecogResultBase);
    }
    if ((0x4 & paramLong) != 0L) {
      localARLocalRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = ((ARLocalFaceRecogResult)paramARLocalRecogResultBase);
    }
    a(localARLocalRecogResult, null);
  }
  
  public void a(Rect paramRect, QRRecognizerListener paramQRRecognizerListener)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController = new QRRecognizerController(paramRect);
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController.a();
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController.a(paramQRRecognizerListener);
      this.jdField_e_of_type_Boolean = true;
    }
  }
  
  public void a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_Boolean)) {}
    label288:
    for (;;)
    {
      return;
      if ((this.jdField_j_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) && (this.jdField_l_of_type_Boolean) && (!this.jdField_t_of_type_Boolean) && (!this.jdField_u_of_type_Boolean) && (!k()) && (!this.jdField_m_of_type_Boolean)) {
        switch (paramMotionEvent.getAction())
        {
        }
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager instanceof ARRenderManagerImpl)) {
          break label288;
        }
        Object localObject = (ARRenderManagerImpl)this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager;
        if (((ARRenderManagerImpl)localObject).jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender == null) {
          break;
        }
        ((ARRenderManagerImpl)localObject).jdField_a_of_type_ComTencentMobileqqArARRenderModelARBaseRender.a(paramMotionEvent);
        return;
        this.jdField_t_of_type_Int = ((int)paramFloat1);
        this.jdField_u_of_type_Int = ((int)paramFloat2);
        this.jdField_t_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_u_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_u_of_type_Long > ViewConfiguration.getDoubleTapTimeout()))
        {
          this.jdField_u_of_type_Long = 0L;
          continue;
          if ((this.jdField_t_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_t_of_type_Long <= ViewConfiguration.getTapTimeout()))
          {
            localObject = ThreadManager.getUIHandler();
            if (this.jdField_u_of_type_Long > 0L)
            {
              ((MqqHandler)localObject).removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
              ((MqqHandler)localObject).post(this.jdField_c_of_type_JavaLangRunnable);
            }
            for (;;)
            {
              this.jdField_u_of_type_Long = System.currentTimeMillis();
              break;
              ((MqqHandler)localObject).postDelayed(this.jdField_b_of_type_JavaLangRunnable, ViewConfiguration.getDoubleTapTimeout());
            }
            this.jdField_t_of_type_Long = 0L;
            this.jdField_u_of_type_Long = 0L;
          }
        }
      }
    }
  }
  
  public void a(ARRenderMarkerTrackInfo paramARRenderMarkerTrackInfo)
  {
    a(paramARRenderMarkerTrackInfo, null);
  }
  
  public void a(ARRenderTrackInfo paramARRenderTrackInfo, ARLocalRecogResultBase paramARLocalRecogResultBase)
  {
    if ((paramARLocalRecogResultBase != null) && (paramARLocalRecogResultBase.jdField_b_of_type_Long == 4L)) {
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramARLocalRecogResultBase.jdField_b_of_type_Long, 0, null, paramARLocalRecogResultBase);
      }
    }
    label209:
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
          } while ((!this.jdField_c_of_type_Boolean) || (this.jdField_h_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback == null));
          this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(paramARLocalRecogResultBase.jdField_b_of_type_Long, 0, null, paramARLocalRecogResultBase);
          return;
          if (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
            break label209;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
            this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
          }
          if ((!this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f()) || (!this.jdField_q_of_type_Boolean)) {
            break;
          }
        } while ((!this.jdField_c_of_type_Boolean) || (this.jdField_h_of_type_Int != 2) || (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback == null));
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(this.jdField_g_of_type_Long, this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_c_of_type_Int, paramARRenderTrackInfo, null);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager == null);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(paramARRenderTrackInfo);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager == null);
    this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(paramARRenderTrackInfo);
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!paramArCloudConfigInfo.c())
    {
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(1L, new ARTarget(paramArCloudConfigInfo));
      }
      if (!paramArCloudConfigInfo.e()) {
        break label170;
      }
      if (paramArCloudConfigInfo.e()) {
        ARVideoRecordUIControllerImpl.a().a(1);
      }
      a(1L);
      a(1L, paramArCloudConfigInfo, 0, 0.0F, 0.0F, 0.0F);
      if (paramArCloudConfigInfo.i()) {
        c(false);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
      {
        this.jdField_h_of_type_Long = 0L;
        this.jdField_i_of_type_Long = 0L;
      }
      QLog.i("AREngine_AREngine", 1, "processCloudMarkerRecogResult end. isNeedInternalRender = " + paramArCloudConfigInfo.e() + ", isNeedExternalRender = " + paramArCloudConfigInfo.f() + ", isNeedWaitUserOperation = " + paramArCloudConfigInfo.g());
      return;
      label170:
      if ((paramArCloudConfigInfo.g()) || (paramArCloudConfigInfo.f()))
      {
        if (paramArCloudConfigInfo.f())
        {
          a(1L);
          if (paramArCloudConfigInfo.i()) {
            c(true);
          }
        }
      }
      else {
        A();
      }
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_AREngine", 2, "onCommonCallbackFromManager, resourceInfo=" + paramArCloudConfigInfo + ", action=" + paramInt1 + ", result=" + paramInt2 + " ,data=" + paramObject);
    }
    a(new aabt(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  /* Error */
  public void a(ARLocalRecogResult paramARLocalRecogResult, ARCloudRecogResult paramARCloudRecogResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 574	com/tencent/mobileqq/ar/arengine/AREngine:jdField_c_of_type_Boolean	Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: getfield 136	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Int	I
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
    //   27: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   38: putfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   41: aload_1
    //   42: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   45: ifnull +11 -> 56
    //   48: aload_0
    //   49: aload_1
    //   50: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   53: putfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   56: aload_2
    //   57: ifnull +8 -> 65
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 518	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogResult;
    //   65: aload_0
    //   66: getfield 114	com/tencent/mobileqq/ar/arengine/AREngine:jdField_e_of_type_Long	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq +1510 -> 1581
    //   74: aload_0
    //   75: getfield 116	com/tencent/mobileqq/ar/arengine/AREngine:jdField_f_of_type_Long	J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifeq +1501 -> 1581
    //   83: aload_1
    //   84: ifnull +590 -> 674
    //   87: aload_1
    //   88: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   91: ifnull +583 -> 674
    //   94: aload_1
    //   95: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   98: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   101: istore_3
    //   102: iload_3
    //   103: ifne +227 -> 330
    //   106: aconst_null
    //   107: ldc_w 1566
    //   110: ldc_w 428
    //   113: ldc_w 428
    //   116: ldc_w 1568
    //   119: ldc_w 1568
    //   122: iconst_0
    //   123: iconst_0
    //   124: aload_1
    //   125: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   128: getfield 691	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   131: getfield 489	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   134: ldc_w 829
    //   137: ldc_w 428
    //   140: ldc_w 428
    //   143: invokestatic 834	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   150: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   153: lconst_1
    //   154: invokestatic 191	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;J)Z
    //   157: ifne +323 -> 480
    //   160: aload_1
    //   161: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   164: getfield 691	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   167: astore_2
    //   168: ldc 172
    //   170: iconst_1
    //   171: new 286	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 1570
    //   181: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 693	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:e	()Z
    //   188: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: ldc_w 1546
    //   194: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 1539	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   201: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: ldc_w 1548
    //   207: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 1550	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   214: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   217: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 574	com/tencent/mobileqq/ar/arengine/AREngine:jdField_c_of_type_Boolean	Z
    //   227: ifeq +36 -> 263
    //   230: aload_0
    //   231: getfield 136	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Int	I
    //   234: iconst_2
    //   235: if_icmpne +28 -> 263
    //   238: aload_0
    //   239: getfield 525	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback	Lcom/tencent/mobileqq/ar/arengine/AREngineCallback;
    //   242: ifnull +21 -> 263
    //   245: aload_0
    //   246: getfield 525	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback	Lcom/tencent/mobileqq/ar/arengine/AREngineCallback;
    //   249: lconst_1
    //   250: new 341	com/tencent/mobileqq/ar/ARTarget
    //   253: dup
    //   254: aload_2
    //   255: invokespecial 344	com/tencent/mobileqq/ar/ARTarget:<init>	(Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   258: invokeinterface 579 4 0
    //   263: aload_2
    //   264: invokevirtual 369	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:c	()Z
    //   267: ifne +269 -> 536
    //   270: aload_2
    //   271: invokevirtual 693	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:e	()Z
    //   274: ifeq +213 -> 487
    //   277: aload_0
    //   278: lconst_1
    //   279: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   282: aload_0
    //   283: lconst_1
    //   284: aload_2
    //   285: aload_1
    //   286: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   289: getfield 699	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_b_of_type_Int	I
    //   292: aload_1
    //   293: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   296: getfield 702	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Float	F
    //   299: aload_1
    //   300: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   303: getfield 704	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_b_of_type_Float	F
    //   306: aload_1
    //   307: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   310: getfield 706	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:c	F
    //   313: invokespecial 566	com/tencent/mobileqq/ar/arengine/AREngine:a	(JLcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;IFFF)Z
    //   316: pop
    //   317: aload_2
    //   318: invokevirtual 390	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:i	()Z
    //   321: ifeq +9 -> 330
    //   324: aload_0
    //   325: iconst_0
    //   326: invokespecial 559	com/tencent/mobileqq/ar/arengine/AREngine:c	(Z)Z
    //   329: pop
    //   330: aload_1
    //   331: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   334: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   337: iconst_2
    //   338: if_icmpeq +16 -> 354
    //   341: aload_1
    //   342: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   345: getfield 691	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   348: invokevirtual 369	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:c	()Z
    //   351: ifeq +36 -> 387
    //   354: aload_0
    //   355: aload_1
    //   356: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   359: aload_0
    //   360: getfield 1572	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   363: invokespecial 1574	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;)V
    //   366: aload_1
    //   367: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   370: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   373: iconst_2
    //   374: if_icmpeq +211 -> 585
    //   377: aload_0
    //   378: lconst_0
    //   379: putfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   382: aload_0
    //   383: lconst_0
    //   384: putfield 817	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Long	J
    //   387: aload_1
    //   388: ifnull -369 -> 19
    //   391: aload_1
    //   392: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   395: ifnull +1349 -> 1744
    //   398: aload_0
    //   399: aload_1
    //   400: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   403: putfield 1572	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   406: aload_1
    //   407: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   410: getfield 691	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   413: ifnull -394 -> 19
    //   416: aload_1
    //   417: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   420: getfield 691	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   423: invokevirtual 369	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:c	()Z
    //   426: ifne -407 -> 19
    //   429: aload_0
    //   430: aconst_null
    //   431: putfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   434: aload_0
    //   435: aconst_null
    //   436: putfield 1572	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   439: goto -420 -> 19
    //   442: astore_1
    //   443: aload_0
    //   444: monitorexit
    //   445: aload_1
    //   446: athrow
    //   447: astore_2
    //   448: ldc 172
    //   450: iconst_1
    //   451: new 286	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 1576
    //   461: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_2
    //   465: invokevirtual 1142	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -331 -> 146
    //   480: aload_0
    //   481: invokespecial 1439	com/tencent/mobileqq/ar/arengine/AREngine:y	()V
    //   484: goto -324 -> 160
    //   487: aload_2
    //   488: invokevirtual 1550	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   491: ifne +10 -> 501
    //   494: aload_2
    //   495: invokevirtual 1539	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   498: ifeq +31 -> 529
    //   501: aload_2
    //   502: invokevirtual 1539	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   505: ifeq -175 -> 330
    //   508: aload_0
    //   509: lconst_1
    //   510: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   513: aload_2
    //   514: invokevirtual 390	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:i	()Z
    //   517: ifeq -187 -> 330
    //   520: aload_0
    //   521: iconst_1
    //   522: invokespecial 559	com/tencent/mobileqq/ar/arengine/AREngine:c	(Z)Z
    //   525: pop
    //   526: goto -196 -> 330
    //   529: aload_0
    //   530: invokespecial 603	com/tencent/mobileqq/ar/arengine/AREngine:A	()V
    //   533: goto -203 -> 330
    //   536: aload_2
    //   537: invokevirtual 693	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:e	()Z
    //   540: ifne -210 -> 330
    //   543: aload_2
    //   544: invokevirtual 1550	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   547: ifne +10 -> 557
    //   550: aload_2
    //   551: invokevirtual 1539	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   554: ifeq -224 -> 330
    //   557: aload_2
    //   558: invokevirtual 1539	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   561: ifeq -231 -> 330
    //   564: aload_0
    //   565: lconst_1
    //   566: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   569: aload_2
    //   570: invokevirtual 390	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:i	()Z
    //   573: ifeq -243 -> 330
    //   576: aload_0
    //   577: iconst_1
    //   578: invokespecial 559	com/tencent/mobileqq/ar/arengine/AREngine:c	(Z)Z
    //   581: pop
    //   582: goto -252 -> 330
    //   585: aload_0
    //   586: getfield 518	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogResult;
    //   589: ifnull +23 -> 612
    //   592: aload_0
    //   593: getfield 589	com/tencent/mobileqq/ar/arengine/AREngine:jdField_m_of_type_Boolean	Z
    //   596: ifeq +16 -> 612
    //   599: aload_0
    //   600: lconst_0
    //   601: putfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   604: aload_0
    //   605: lconst_0
    //   606: putfield 817	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Long	J
    //   609: goto -222 -> 387
    //   612: aload_0
    //   613: getfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   616: lconst_0
    //   617: lcmp
    //   618: ifne +10 -> 628
    //   621: aload_0
    //   622: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   625: putfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   628: aload_0
    //   629: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   632: putfield 817	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Long	J
    //   635: aload_0
    //   636: getfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   639: lconst_0
    //   640: lcmp
    //   641: ifle -254 -> 387
    //   644: aload_0
    //   645: getfield 817	com/tencent/mobileqq/ar/arengine/AREngine:jdField_i_of_type_Long	J
    //   648: aload_0
    //   649: getfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   652: lsub
    //   653: ldc2_w 732
    //   656: lcmp
    //   657: ifle -270 -> 387
    //   660: aload_0
    //   661: ldc2_w 1577
    //   664: putfield 226	com/tencent/mobileqq/ar/arengine/AREngine:jdField_h_of_type_Long	J
    //   667: aload_0
    //   668: invokespecial 603	com/tencent/mobileqq/ar/arengine/AREngine:A	()V
    //   671: goto -284 -> 387
    //   674: aload_1
    //   675: ifnull +385 -> 1060
    //   678: aload_1
    //   679: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   682: ifnull +378 -> 1060
    //   685: aload_0
    //   686: aload_0
    //   687: getfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   690: aload_0
    //   691: getfield 1580	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   694: invokespecial 1582	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;)V
    //   697: iconst_0
    //   698: istore 5
    //   700: iconst_0
    //   701: istore 4
    //   703: aload_0
    //   704: getfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   707: getfield 1350	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   710: invokevirtual 890	java/util/ArrayList:size	()I
    //   713: istore_3
    //   714: iload_3
    //   715: ifle +48 -> 763
    //   718: aload_0
    //   719: getfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   722: getfield 1350	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   725: invokevirtual 474	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   728: astore_2
    //   729: iload 4
    //   731: istore 5
    //   733: aload_2
    //   734: invokeinterface 479 1 0
    //   739: ifeq +24 -> 763
    //   742: aload_2
    //   743: invokeinterface 483 1 0
    //   748: checkcast 1584	com/tencent/mobileqq/ar/DrawView2$FaceData
    //   751: getfield 1585	com/tencent/mobileqq/ar/DrawView2$FaceData:jdField_e_of_type_Boolean	Z
    //   754: ifne +1008 -> 1762
    //   757: iconst_1
    //   758: istore 4
    //   760: goto +1002 -> 1762
    //   763: invokestatic 539	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +46 -> 812
    //   769: getstatic 675	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecog:jdField_a_of_type_Boolean	Z
    //   772: ifeq +40 -> 812
    //   775: ldc 172
    //   777: iconst_2
    //   778: new 286	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   785: ldc_w 1587
    //   788: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: iload_3
    //   792: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: ldc_w 1589
    //   798: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: iload 5
    //   803: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   806: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 545	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iload 5
    //   814: ifeq +99 -> 913
    //   817: aconst_null
    //   818: ldc_w 1566
    //   821: ldc_w 428
    //   824: ldc_w 428
    //   827: ldc_w 1568
    //   830: ldc_w 1568
    //   833: iconst_0
    //   834: iconst_0
    //   835: aload_1
    //   836: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   839: getfield 1350	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   842: iconst_0
    //   843: invokevirtual 381	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   846: checkcast 1584	com/tencent/mobileqq/ar/DrawView2$FaceData
    //   849: getfield 1590	com/tencent/mobileqq/ar/DrawView2$FaceData:jdField_a_of_type_Int	I
    //   852: invokestatic 1098	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   855: ldc_w 1592
    //   858: ldc_w 428
    //   861: ldc_w 428
    //   864: invokestatic 834	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload_0
    //   868: lconst_0
    //   869: putfield 1594	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Long	J
    //   872: aload_0
    //   873: lconst_0
    //   874: putfield 1596	com/tencent/mobileqq/ar/arengine/AREngine:jdField_m_of_type_Long	J
    //   877: goto -490 -> 387
    //   880: astore_2
    //   881: ldc 172
    //   883: iconst_1
    //   884: new 286	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 1576
    //   894: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload_2
    //   898: invokevirtual 1142	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   901: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 179	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -43 -> 867
    //   913: ldc2_w 1597
    //   916: lstore 6
    //   918: invokestatic 1599	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecog:a	()Z
    //   921: ifeq +8 -> 929
    //   924: ldc2_w 1600
    //   927: lstore 6
    //   929: aload_0
    //   930: getfield 1594	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Long	J
    //   933: lconst_0
    //   934: lcmp
    //   935: ifne +10 -> 945
    //   938: aload_0
    //   939: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   942: putfield 1594	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Long	J
    //   945: aload_0
    //   946: invokestatic 729	java/lang/System:currentTimeMillis	()J
    //   949: putfield 1596	com/tencent/mobileqq/ar/arengine/AREngine:jdField_m_of_type_Long	J
    //   952: aload_0
    //   953: getfield 1594	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Long	J
    //   956: lconst_0
    //   957: lcmp
    //   958: ifle -571 -> 387
    //   961: aload_0
    //   962: getfield 1596	com/tencent/mobileqq/ar/arengine/AREngine:jdField_m_of_type_Long	J
    //   965: aload_0
    //   966: getfield 1594	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Long	J
    //   969: lsub
    //   970: lload 6
    //   972: lcmp
    //   973: ifle -586 -> 387
    //   976: invokestatic 539	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq +30 -> 1009
    //   982: ldc 172
    //   984: iconst_2
    //   985: new 286	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 1603
    //   995: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: lload 6
    //   1000: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 545	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: aload_0
    //   1010: ldc2_w 634
    //   1013: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   1016: aload_0
    //   1017: ldc2_w 1577
    //   1020: putfield 1594	com/tencent/mobileqq/ar/arengine/AREngine:jdField_l_of_type_Long	J
    //   1023: aload_0
    //   1024: getfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1027: iconst_1
    //   1028: putfield 1497	com/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult:jdField_a_of_type_Boolean	Z
    //   1031: aload_0
    //   1032: aload_0
    //   1033: getfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1036: aload_0
    //   1037: getfield 1580	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1040: invokespecial 1582	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;)V
    //   1043: aload_0
    //   1044: aconst_null
    //   1045: putfield 1349	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1048: aload_0
    //   1049: aconst_null
    //   1050: putfield 1580	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1053: aload_0
    //   1054: invokespecial 1605	com/tencent/mobileqq/ar/arengine/AREngine:B	()V
    //   1057: goto -670 -> 387
    //   1060: aload_2
    //   1061: ifnull -674 -> 387
    //   1064: aload_0
    //   1065: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1068: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1071: aload_2
    //   1072: invokestatic 1608	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogResult;)Lcom/tencent/mobileqq/ar/ARRecognition$RecognitionResult;
    //   1075: astore 8
    //   1077: aload 8
    //   1079: getfield 1611	com/tencent/mobileqq/ar/ARRecognition$RecognitionResult:jdField_a_of_type_Long	J
    //   1082: lstore 6
    //   1084: aload 8
    //   1086: getfield 1612	com/tencent/mobileqq/ar/ARRecognition$RecognitionResult:jdField_a_of_type_Boolean	Z
    //   1089: istore 4
    //   1091: aload_0
    //   1092: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1095: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1098: lload 6
    //   1100: invokestatic 191	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;J)Z
    //   1103: istore 5
    //   1105: aload_0
    //   1106: getfield 528	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1109: ifnull +34 -> 1143
    //   1112: lload 6
    //   1114: ldc2_w 1249
    //   1117: lcmp
    //   1118: ifeq +25 -> 1143
    //   1121: aload_0
    //   1122: iconst_0
    //   1123: invokespecial 821	com/tencent/mobileqq/ar/arengine/AREngine:i	(Z)V
    //   1126: aload_0
    //   1127: getfield 1614	com/tencent/mobileqq/ar/arengine/AREngine:jdField_o_of_type_Boolean	Z
    //   1130: ifeq +13 -> 1143
    //   1133: aload_0
    //   1134: lconst_1
    //   1135: invokevirtual 205	com/tencent/mobileqq/ar/arengine/AREngine:b	(J)V
    //   1138: aload_0
    //   1139: iconst_0
    //   1140: putfield 1614	com/tencent/mobileqq/ar/arengine/AREngine:jdField_o_of_type_Boolean	Z
    //   1143: lload 6
    //   1145: lconst_0
    //   1146: lcmp
    //   1147: ifeq -760 -> 387
    //   1150: lload 6
    //   1152: ldc2_w 634
    //   1155: lcmp
    //   1156: ifne +81 -> 1237
    //   1159: iload 5
    //   1161: ifeq +14 -> 1175
    //   1164: aload_0
    //   1165: aload_2
    //   1166: getfield 1387	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1169: invokespecial 1616	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)V
    //   1172: goto -785 -> 387
    //   1175: aload_0
    //   1176: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1179: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1182: ldc2_w 1617
    //   1185: lconst_1
    //   1186: invokestatic 1621	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1189: ifeq +14 -> 1203
    //   1192: aload_0
    //   1193: aload_2
    //   1194: getfield 1387	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1197: invokespecial 1616	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)V
    //   1200: goto -813 -> 387
    //   1203: aload_0
    //   1204: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1207: ifnull +14 -> 1221
    //   1210: aload_0
    //   1211: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1214: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1217: iconst_2
    //   1218: if_icmpne -831 -> 387
    //   1221: aload_0
    //   1222: lconst_1
    //   1223: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   1226: aload_0
    //   1227: aload_2
    //   1228: getfield 1387	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1231: invokespecial 1616	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)V
    //   1234: goto -847 -> 387
    //   1237: lload 6
    //   1239: ldc2_w 370
    //   1242: lcmp
    //   1243: ifne +81 -> 1324
    //   1246: iload 5
    //   1248: ifeq +14 -> 1262
    //   1251: aload_0
    //   1252: aload_2
    //   1253: getfield 1375	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1256: invokespecial 1623	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1259: goto -872 -> 387
    //   1262: aload_0
    //   1263: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1266: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1269: ldc2_w 370
    //   1272: lconst_1
    //   1273: invokestatic 1621	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1276: ifeq +14 -> 1290
    //   1279: aload_0
    //   1280: aload_2
    //   1281: getfield 1375	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1284: invokespecial 1623	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1287: goto -900 -> 387
    //   1290: aload_0
    //   1291: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1294: ifnull +14 -> 1308
    //   1297: aload_0
    //   1298: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1301: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1304: iconst_2
    //   1305: if_icmpne -918 -> 387
    //   1308: aload_0
    //   1309: lconst_1
    //   1310: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   1313: aload_0
    //   1314: aload_2
    //   1315: getfield 1375	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1318: invokespecial 1623	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1321: goto -934 -> 387
    //   1324: lload 6
    //   1326: ldc2_w 1249
    //   1329: lcmp
    //   1330: ifne +120 -> 1450
    //   1333: iload 5
    //   1335: ifeq +14 -> 1349
    //   1338: aload_0
    //   1339: aload_2
    //   1340: getfield 1381	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1343: invokespecial 1625	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1346: goto -959 -> 387
    //   1349: aload_0
    //   1350: getfield 930	com/tencent/mobileqq/ar/arengine/AREngine:jdField_p_of_type_Boolean	Z
    //   1353: ifeq +30 -> 1383
    //   1356: aload_0
    //   1357: getfield 528	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1360: ifnull +8 -> 1368
    //   1363: aload_0
    //   1364: iconst_0
    //   1365: invokespecial 821	com/tencent/mobileqq/ar/arengine/AREngine:i	(Z)V
    //   1368: aload_0
    //   1369: getfield 1614	com/tencent/mobileqq/ar/arengine/AREngine:jdField_o_of_type_Boolean	Z
    //   1372: ifeq -1353 -> 19
    //   1375: aload_0
    //   1376: iconst_0
    //   1377: putfield 1614	com/tencent/mobileqq/ar/arengine/AREngine:jdField_o_of_type_Boolean	Z
    //   1380: goto -1361 -> 19
    //   1383: aload_0
    //   1384: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1387: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1390: ldc2_w 1249
    //   1393: lconst_1
    //   1394: invokestatic 1621	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1397: ifeq +14 -> 1411
    //   1400: aload_0
    //   1401: aload_2
    //   1402: getfield 1381	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1405: invokespecial 1625	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1408: goto -1021 -> 387
    //   1411: aload_0
    //   1412: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1415: ifnull +14 -> 1429
    //   1418: aload_0
    //   1419: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1422: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1425: iconst_2
    //   1426: if_icmpne -1039 -> 387
    //   1429: aload_0
    //   1430: lconst_1
    //   1431: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   1434: aload_0
    //   1435: iconst_1
    //   1436: putfield 1614	com/tencent/mobileqq/ar/arengine/AREngine:jdField_o_of_type_Boolean	Z
    //   1439: aload_0
    //   1440: aload_2
    //   1441: getfield 1381	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1444: invokespecial 1625	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1447: goto -1060 -> 387
    //   1450: lload 6
    //   1452: lconst_1
    //   1453: lcmp
    //   1454: ifne +40 -> 1494
    //   1457: iload 5
    //   1459: ifeq +14 -> 1473
    //   1462: aload_0
    //   1463: aload_2
    //   1464: getfield 1367	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;
    //   1467: invokespecial 1627	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;)V
    //   1470: goto -1083 -> 387
    //   1473: iload 4
    //   1475: ifeq +8 -> 1483
    //   1478: aload_0
    //   1479: lconst_1
    //   1480: invokevirtual 205	com/tencent/mobileqq/ar/arengine/AREngine:b	(J)V
    //   1483: aload_0
    //   1484: aload_2
    //   1485: getfield 1367	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;
    //   1488: invokespecial 1627	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;)V
    //   1491: goto -1104 -> 387
    //   1494: lload 6
    //   1496: ldc2_w 372
    //   1499: lcmp
    //   1500: ifne -1113 -> 387
    //   1503: iload 5
    //   1505: ifeq +14 -> 1519
    //   1508: aload_0
    //   1509: aload_2
    //   1510: getfield 1393	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1513: invokespecial 1629	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1516: goto -1129 -> 387
    //   1519: aload_0
    //   1520: getfield 181	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1523: getfield 186	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1526: ldc2_w 372
    //   1529: lconst_1
    //   1530: invokestatic 1621	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1533: ifeq +14 -> 1547
    //   1536: aload_0
    //   1537: aload_2
    //   1538: getfield 1393	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1541: invokespecial 1629	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1544: goto -1157 -> 387
    //   1547: aload_0
    //   1548: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1551: ifnull +14 -> 1565
    //   1554: aload_0
    //   1555: getfield 1347	com/tencent/mobileqq/ar/arengine/AREngine:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1558: getfield 690	com/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult:jdField_a_of_type_Int	I
    //   1561: iconst_2
    //   1562: if_icmpne -1175 -> 387
    //   1565: aload_0
    //   1566: lconst_1
    //   1567: invokevirtual 194	com/tencent/mobileqq/ar/arengine/AREngine:a	(J)V
    //   1570: aload_0
    //   1571: aload_2
    //   1572: getfield 1393	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1575: invokespecial 1629	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)V
    //   1578: goto -1191 -> 387
    //   1581: aload_0
    //   1582: getfield 114	com/tencent/mobileqq/ar/arengine/AREngine:jdField_e_of_type_Long	J
    //   1585: lconst_0
    //   1586: lcmp
    //   1587: ifeq +51 -> 1638
    //   1590: aload_1
    //   1591: ifnull -1572 -> 19
    //   1594: aload_1
    //   1595: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1598: ifnull +18 -> 1616
    //   1601: aload_0
    //   1602: aload_1
    //   1603: getfield 1477	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1606: aload_0
    //   1607: getfield 1572	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;
    //   1610: invokespecial 1574	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalMarkerRecogResult;)V
    //   1613: goto -1226 -> 387
    //   1616: aload_1
    //   1617: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1620: ifnull -1233 -> 387
    //   1623: aload_0
    //   1624: aload_1
    //   1625: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1628: aload_0
    //   1629: getfield 1580	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1632: invokespecial 1582	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;)V
    //   1635: goto -1248 -> 387
    //   1638: aload_0
    //   1639: getfield 116	com/tencent/mobileqq/ar/arengine/AREngine:jdField_f_of_type_Long	J
    //   1642: lconst_0
    //   1643: lcmp
    //   1644: ifeq -1257 -> 387
    //   1647: aload_2
    //   1648: ifnull -1629 -> 19
    //   1651: aload_2
    //   1652: getfield 1375	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1655: invokestatic 1380	com/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)Z
    //   1658: ifeq +14 -> 1672
    //   1661: aload_0
    //   1662: aload_2
    //   1663: getfield 1375	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;
    //   1666: invokespecial 1623	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyResult;)V
    //   1669: goto -1282 -> 387
    //   1672: aload_2
    //   1673: getfield 1381	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1676: invokestatic 1384	com/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudObjectClassifyBaseResult;)Z
    //   1679: ifeq +14 -> 1693
    //   1682: aload_0
    //   1683: aload_2
    //   1684: getfield 1381	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult	Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;
    //   1687: invokespecial 1625	com/tencent/mobileqq/ar/arengine/AREngine:a	(Lcom/tencent/mobileqq/ar/arengine/ARMIGObjectClassifyResult;)V
    //   1690: goto -1303 -> 387
    //   1693: aload_2
    //   1694: getfield 1367	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudMarkerRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;
    //   1697: invokestatic 1372	com/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudMarkerRecogResult;)Z
    //   1700: ifeq +10 -> 1710
    //   1703: aload_0
    //   1704: invokespecial 603	com/tencent/mobileqq/ar/arengine/AREngine:A	()V
    //   1707: goto -1320 -> 387
    //   1710: aload_2
    //   1711: getfield 1387	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogRspFaceResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;
    //   1714: invokestatic 1390	com/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudRecogRspFaceResult;)Z
    //   1717: ifeq +10 -> 1727
    //   1720: aload_0
    //   1721: invokespecial 1605	com/tencent/mobileqq/ar/arengine/AREngine:B	()V
    //   1724: goto -1337 -> 387
    //   1727: aload_2
    //   1728: getfield 1393	com/tencent/mobileqq/ar/arengine/ARCloudRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARCloudSceneRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;
    //   1731: invokestatic 1398	com/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudSceneRecogResult;)Z
    //   1734: ifeq -1347 -> 387
    //   1737: aload_0
    //   1738: invokevirtual 650	com/tencent/mobileqq/ar/arengine/AREngine:n	()V
    //   1741: goto -1354 -> 387
    //   1744: aload_1
    //   1745: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1748: ifnull -1729 -> 19
    //   1751: aload_0
    //   1752: aload_1
    //   1753: getfield 1478	com/tencent/mobileqq/ar/arengine/ARLocalRecogResult:jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1756: putfield 1580	com/tencent/mobileqq/ar/arengine/AREngine:jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult	Lcom/tencent/mobileqq/ar/arengine/ARLocalFaceRecogResult;
    //   1759: goto -1740 -> 19
    //   1762: goto -1033 -> 729
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1765	0	this	AREngine
    //   0	1765	1	paramARLocalRecogResult	ARLocalRecogResult
    //   0	1765	2	paramARCloudRecogResult	ARCloudRecogResult
    //   13	779	3	i1	int
    //   701	773	4	bool1	boolean
    //   698	806	5	bool2	boolean
    //   916	579	6	l1	long
    //   1075	10	8	localRecognitionResult	com.tencent.mobileqq.ar.ARRecognition.RecognitionResult
    // Exception table:
    //   from	to	target	type
    //   2	14	442	finally
    //   26	41	442	finally
    //   41	56	442	finally
    //   60	65	442	finally
    //   65	83	442	finally
    //   87	102	442	finally
    //   106	146	442	finally
    //   146	160	442	finally
    //   160	263	442	finally
    //   263	330	442	finally
    //   330	354	442	finally
    //   354	387	442	finally
    //   391	439	442	finally
    //   448	477	442	finally
    //   480	484	442	finally
    //   487	501	442	finally
    //   501	526	442	finally
    //   529	533	442	finally
    //   536	557	442	finally
    //   557	582	442	finally
    //   585	609	442	finally
    //   612	628	442	finally
    //   628	671	442	finally
    //   678	697	442	finally
    //   703	714	442	finally
    //   718	729	442	finally
    //   733	757	442	finally
    //   763	812	442	finally
    //   817	867	442	finally
    //   867	877	442	finally
    //   881	910	442	finally
    //   918	924	442	finally
    //   929	945	442	finally
    //   945	1009	442	finally
    //   1009	1057	442	finally
    //   1064	1112	442	finally
    //   1121	1143	442	finally
    //   1164	1172	442	finally
    //   1175	1200	442	finally
    //   1203	1221	442	finally
    //   1221	1234	442	finally
    //   1251	1259	442	finally
    //   1262	1287	442	finally
    //   1290	1308	442	finally
    //   1308	1321	442	finally
    //   1338	1346	442	finally
    //   1349	1368	442	finally
    //   1368	1380	442	finally
    //   1383	1408	442	finally
    //   1411	1429	442	finally
    //   1429	1447	442	finally
    //   1462	1470	442	finally
    //   1478	1483	442	finally
    //   1483	1491	442	finally
    //   1508	1516	442	finally
    //   1519	1544	442	finally
    //   1547	1565	442	finally
    //   1565	1578	442	finally
    //   1581	1590	442	finally
    //   1594	1613	442	finally
    //   1616	1635	442	finally
    //   1638	1647	442	finally
    //   1651	1669	442	finally
    //   1672	1690	442	finally
    //   1693	1707	442	finally
    //   1710	1724	442	finally
    //   1727	1741	442	finally
    //   1744	1759	442	finally
    //   106	146	447	java/lang/Exception
    //   817	867	880	java/lang/Exception
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, ARRenderMangerInnerCallback paramARRenderMangerInnerCallback)
  {
    QLog.i("AREngine_AREngine", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
    a(new aabs(this, paramArVideoResourceInfo, paramARRenderMangerInnerCallback));
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.i("AREngine_AREngine", 1, "onRenderManagerCallback. onARAnimationStart. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new aabo(this, paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController != null) && (this.jdField_s_of_type_Boolean) && ((!this.jdField_d_of_type_Boolean) || ((!this.jdField_t_of_type_Boolean) && (!this.jdField_u_of_type_Boolean) && (!k())))) {
      this.jdField_r_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_AREngine", 1, "onARMarkerResourceDownloadComplete. result = " + paramBoolean + " type  " + paramInt);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int != 2)) {}
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    QLog.d("AREngine_AREngine", 1, String.format("switchDarknessCheck on=%s delay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) }));
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController.a(paramBoolean, paramLong);
    }
  }
  
  public void a(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_AREngine", 1, String.format("onARMarkerAllDownloadComplete result=%s config=%s", new Object[] { Boolean.valueOf(paramBoolean), paramArCloudConfigInfo }));
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Int = 1;
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      return;
    }
    b(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.i("AREngine_AREngine", 2, "setARRelationShip isFromARRelationShipH5: " + paramBoolean + " ARRelationShipTaskId:" + paramString);
    this.z = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(0, paramArrayOfFloat);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ScanTorchActivity))
    {
      long l1 = ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).a();
      if (l1 > 0L) {
        return System.currentTimeMillis() < l1 + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARCloudUploadCheckTime;
      }
    }
    return false;
  }
  
  public boolean a(ARMIGObjectClassifyResult paramARMIGObjectClassifyResult)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult == null) || (!this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult.a(paramARMIGObjectClassifyResult));
  }
  
  public boolean a(boolean paramBoolean)
  {
    QLog.i("AREngine_AREngine", 2, "closeCamera start. mCurCameraState = " + this.jdField_i_of_type_Int + ", stopPreviewRender = " + paramBoolean);
    if (this.jdField_i_of_type_Int == 0) {}
    while (this.jdField_i_of_type_Int == 3) {
      return true;
    }
    if (this.jdField_i_of_type_Int == 1) {}
    this.jdField_i_of_type_Int = 3;
    this.jdField_j_of_type_Int = 10;
    f(new aabu(this, paramBoolean));
    return true;
  }
  
  public boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    QLog.i("AREngine_AREngine", 2, "enableCameraPreviewScanLine. isEnable = " + paramBoolean + ", startY = " + paramFloat1 + ", endY = " + paramFloat2);
    if (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(paramBoolean, paramFloat1, paramFloat2);
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_v_of_type_Int;
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
    if (this.jdField_v_of_type_Long == 0L) {
      this.jdField_v_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(2, paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    QLog.i("AREngine_AREngine", 1, "resumeLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null)
    {
      if ((1L & paramLong) != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
        this.jdField_h_of_type_Long = 0L;
        this.jdField_i_of_type_Long = 0L;
        this.jdField_j_of_type_Long = 0L;
        this.jdField_k_of_type_Long = 0L;
      }
      if ((0x4 & paramLong) != 0L)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
        this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
        this.jdField_l_of_type_Long = 0L;
        this.jdField_m_of_type_Long = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.b(paramLong);
    }
  }
  
  public void b(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_AREngine", 2, "onCommonCallbackFromUI, info=" + paramArCloudConfigInfo + ", action=" + paramInt1 + ", result=" + paramInt2 + ", data=" + paramObject);
    }
    a(new aabv(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  public void b(String paramString, int paramInt)
  {
    QLog.i("AREngine_AREngine", 1, "onRenderManagerCallback. onARAnimationComplete. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new aabp(this, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("AREngine_AREngine", 1, "onARCloudSelectImageComplete. result = " + paramBoolean);
      if (this.jdField_p_of_type_Long == 0L) {
        this.jdField_p_of_type_Long = System.currentTimeMillis();
      }
      if (this.jdField_v_of_type_Long > 0L)
      {
        long l1 = System.currentTimeMillis() - this.jdField_v_of_type_Long;
        if (l1 > 0L) {
          this.jdField_w_of_type_Long = (l1 + this.jdField_w_of_type_Long);
        }
        this.jdField_v_of_type_Long = 0L;
      }
    }
  }
  
  public void b(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_r_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_AREngine", 1, String.format("onARMarkerAllDownloadCompleteInternal result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      a(new aabe(this, paramBoolean, paramArCloudConfigInfo), l1);
      return;
    }
  }
  
  public boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    QLog.d("AREngine_AREngine", 1, String.format("switchFlashLight on=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) {}
    try
    {
      bool = this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(paramBoolean);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("AREngine_AREngine", 1, "switchFlashLight fail.", localException);
    }
    return false;
  }
  
  public long c()
  {
    long l1 = 0L;
    if (this.jdField_v_of_type_Int > 0) {
      l1 = this.jdField_w_of_type_Long / this.jdField_v_of_type_Int;
    }
    return l1;
  }
  
  public void c()
  {
    QLog.i("AREngine_AREngine", 1, "onARCloudUploadStart.");
    this.jdField_v_of_type_Int += 1;
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(2, paramInt);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    QLog.i("AREngine_AREngine", 1, "onRenderManagerCallback. onARAnimationPlayInterrupt. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new aabq(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.i("AREngine_AREngine", 1, "onARCloudPretreatComplete. result = " + paramBoolean);
    if ((paramBoolean) && (this.jdField_w_of_type_Boolean))
    {
      this.jdField_w_of_type_Boolean = false;
      ReportController.b(null, "dc00898", "", "", "0X80085AD", "0X80085AD", 0, 0, "", "", "", "");
    }
  }
  
  public void c(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      this.jdField_a_of_type_Int = 2;
      return;
    }
    e(paramBoolean, paramArCloudConfigInfo);
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d(String paramString, int paramInt)
  {
    QLog.i("AREngine_AREngine", 1, "onRenderManagerCallback. onARAnimationPlayError. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new aabr(this, paramInt));
  }
  
  public void d(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null)) {
      a(new aaaz(this, paramBoolean));
    }
  }
  
  public void d(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.e()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      this.jdField_a_of_type_Int = 2;
      return;
    }
    f(paramBoolean, paramArCloudConfigInfo);
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void e(boolean paramBoolean)
  {
    a(new aabn(this));
  }
  
  public boolean e()
  {
    QLog.i("AREngine_AREngine", 2, "openCamera start. mCurCameraState = " + this.jdField_i_of_type_Int);
    if (this.jdField_i_of_type_Int == 2) {
      return true;
    }
    if (this.jdField_i_of_type_Int == 1)
    {
      this.jdField_j_of_type_Int = 0;
      return true;
    }
    if (this.jdField_i_of_type_Int == 3) {}
    this.jdField_i_of_type_Int = 1;
    this.jdField_j_of_type_Int = 0;
    v();
    return true;
  }
  
  public void f()
  {
    QLog.i("AREngine_AREngine", 1, "dataReport. mDataReportFirstRenderModelTimeLen = " + this.jdField_r_of_type_Int + ", mDataReportFirstRenderModelStartTime = " + this.jdField_n_of_type_Long + ", mDataReportFirstRenderModelEndTime = " + this.jdField_o_of_type_Long + ", mDataReportFirstCloudRecogAndRenderModelTimeLen = " + this.jdField_s_of_type_Int + ", mDataReportFirstCloudRecogAndRenderModelStartTime = " + this.jdField_p_of_type_Long + ", mDataReportFirstCloudRecogAndRenderModelEndTime = " + this.jdField_q_of_type_Long);
    ARReport.a().a(this.jdField_r_of_type_Int, this.jdField_s_of_type_Int);
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public boolean f()
  {
    QLog.i("AREngine_AREngine", 1, "start start. mCurEngineState = " + this.jdField_h_of_type_Int);
    if (this.jdField_h_of_type_Int == 2) {}
    do
    {
      return true;
      if ((this.jdField_h_of_type_Int == 1) || (this.jdField_h_of_type_Int == 3)) {
        return false;
      }
      this.jdField_h_of_type_Int = 1;
      this.jdField_r_of_type_Int = 0;
      this.jdField_n_of_type_Long = System.currentTimeMillis();
      this.jdField_o_of_type_Long = 0L;
      this.jdField_s_of_type_Int = 0;
      this.jdField_p_of_type_Long = 0L;
      this.jdField_q_of_type_Long = 0L;
    } while (!this.jdField_l_of_type_Boolean);
    a(new aaby(this));
    return true;
  }
  
  public void g()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.i("AREngine_AREngine", 1, "pauseQR");
    this.jdField_s_of_type_Boolean = false;
  }
  
  public void g(boolean paramBoolean)
  {
    a(paramBoolean, 0L);
  }
  
  public boolean g()
  {
    QLog.i("AREngine_AREngine", 1, "pause.");
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_h_of_type_Int != 2)) {
      return false;
    }
    j();
    y();
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L))) {}
    for (boolean bool = true;; bool = false)
    {
      a(5L);
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(bool);
      }
      this.jdField_p_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult != null) {
        i(true);
      }
      this.jdField_u_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARMarkerResourceManager.a();
      }
      this.jdField_f_of_type_Boolean = false;
      return true;
    }
  }
  
  public void h()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    QLog.i("AREngine_AREngine", 1, "resumeQR");
    this.jdField_s_of_type_Boolean = true;
  }
  
  public boolean h()
  {
    QLog.i("AREngine_AREngine", 1, "resume.");
    if ((!this.jdField_c_of_type_Boolean) || (this.jdField_h_of_type_Int != 2)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_m_of_type_Long = 0L;
    z();
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(5L);
    }
    for (;;)
    {
      this.jdField_f_of_type_Boolean = true;
      return true;
      a(4L);
      b(1L);
    }
  }
  
  public void i()
  {
    QLog.i("AREngine_AREngine", 1, "uninit start. mIsInited = " + this.jdField_c_of_type_Boolean);
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      a(new aaca(this));
    } while (this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController == null);
    this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController.b();
    this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController = null;
  }
  
  public boolean i()
  {
    QLog.i("AREngine_AREngine", 1, "stop start. mCurEngineState = " + this.jdField_h_of_type_Int);
    if (this.jdField_h_of_type_Int == 0) {
      return true;
    }
    this.jdField_h_of_type_Int = 3;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      b(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    e();
    a(new aabz(this));
    return true;
  }
  
  public void j()
  {
    QLog.i("AREngine_AREngine", 1, "stopModelRender.");
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null) && (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.d();
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) && (this.jdField_l_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null) && ((this.jdField_h_of_type_Int == 2) || (this.jdField_h_of_type_Int == 3)))
      {
        ARTarget localARTarget = new ARTarget(this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(this.jdField_g_of_type_Long, false, localARTarget);
      }
    }
    this.jdField_g_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public boolean j()
  {
    QLog.i("AREngine_AREngine", 1, "stopInternal.");
    this.jdField_b_of_type_Boolean = true;
    f();
    D();
    r();
    p();
    q();
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_b_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult = null;
    this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudRecogResult = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_m_of_type_Long = 0L;
    return true;
  }
  
  public void k()
  {
    QLog.i("AREngine_AREngine", 1, "stopModelRenderOnly.");
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.d();
    }
  }
  
  public boolean k()
  {
    return this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null;
  }
  
  public void l()
  {
    QLog.i("AREngine_AREngine", 1, "onProcessCloudObjectClassifyResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      C();
      return;
      b(1L);
    }
  }
  
  public void m()
  {
    QLog.i("AREngine_AREngine", 1, "onProcessMigCloudObjectClassifyResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARMIGObjectClassifyResult = null;
      C();
      return;
      b(1L);
      this.jdField_o_of_type_Boolean = false;
    }
  }
  
  public void n()
  {
    QLog.i("AREngine_AREngine", 1, "onProcessCloudSceneRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      C();
      return;
      b(1L);
    }
  }
  
  public void o()
  {
    QLog.i("AREngine_AREngine", 1, "onARMarkerAllDownloadStart.");
    this.jdField_r_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_h_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(0, 4);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController != null) && (this.jdField_s_of_type_Boolean) && (!this.z) && ((!this.jdField_d_of_type_Boolean) || ((!this.jdField_t_of_type_Boolean) && (!this.jdField_u_of_type_Boolean) && (!k()))))
      {
        if (!this.jdField_r_of_type_Boolean) {
          break label321;
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController.a(paramArrayOfByte, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, true);
      }
      this.jdField_r_of_type_Boolean = false;
      if ((!this.jdField_d_of_type_Boolean) || (this.jdField_h_of_type_Int != 2)) {
        break label376;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a() + 1L);
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl == null) || ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(1L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L))) || (s())) {
        break label341;
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(), paramArrayOfByte);
      if (((!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(1L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecogResult.jdField_a_of_type_Int == 2)) || ((!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult != null) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalFaceRecogResult.jdField_a_of_type_JavaUtilArrayList.size() == 0)) || ((!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.a(4L)) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalControl.b(4L))))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a());
        if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
        }
      }
      label295:
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudControl.a(paramArrayOfByte);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      paramCamera.addCallbackBuffer(paramArrayOfByte);
      return;
      label321:
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerController.a(paramArrayOfByte, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, false);
      break;
      label341:
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a());
      if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView == null) {
        break label295;
      }
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
      break label295;
      label376:
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a() + 1L);
      this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.b(this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a());
      if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
      }
    }
  }
  
  public void p()
  {
    QLog.d("AREngine_AREngine", 1, "engine notifyRenderReady ");
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) || (!this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)));
      if (this.jdField_a_of_type_Int == 1)
      {
        b(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        return;
      }
    } while (this.jdField_a_of_type_Int != 2);
    e(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
  }
  
  public void q()
  {
    QLog.i("AREngine_AREngine", 1, "onARObjectClassifyDownloadStart.");
    this.jdField_r_of_type_Long = System.currentTimeMillis();
    a(new aabg(this));
  }
  
  public void r()
  {
    QLog.i("AREngine_AREngine", 1, "onARSceneRecogDownloadStart.");
    this.jdField_r_of_type_Long = System.currentTimeMillis();
    a(new aabk(this));
  }
  
  public void s()
  {
    QLog.i("AREngine_AREngine", 1, "stopBinHaiActivity  mHasBinHaiActStarted:" + this.B + " mCurEngineState" + this.jdField_h_of_type_Int);
    if (this.B)
    {
      this.B = false;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback != null) && ((this.jdField_h_of_type_Int == 2) || (this.jdField_h_of_type_Int == 3)))
      {
        QLog.i("AREngine_AREngine", 1, "clearNoFeatureTrackArAnim in AR_RECOG_STATE_LOST");
        this.jdField_a_of_type_ComTencentMobileqqArArengineAREngineCallback.a(32L, false, this.jdField_a_of_type_ComTencentMobileqqArARTarget);
      }
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqArARTarget = null;
    D();
    A();
    h();
    h();
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.i("AREngine_AREngine", 1, "surfaceChanged. holder = " + paramSurfaceHolder + ", format = " + paramInt1 + ", width = " + paramInt2 + ", height = " + paramInt3);
    paramInt1 = this.jdField_l_of_type_Int;
    paramInt2 = this.jdField_m_of_type_Int;
    this.jdField_l_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getWidth();
    this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getHeight();
    this.jdField_k_of_type_Boolean = true;
    if (this.jdField_i_of_type_Int == 2)
    {
      if (!this.jdField_l_of_type_Boolean) {
        break label206;
      }
      if (((paramInt1 != this.jdField_l_of_type_Int) || (paramInt2 != this.jdField_m_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelARRenderManager.a(this.jdField_q_of_type_Int, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.jdField_n_of_type_Int, this.jdField_o_of_type_Int, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera != null) && (this.jdField_l_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARCamera.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      a(new aacc(this));
      return;
      label206:
      QLog.i("AREngine_AREngine", 2, "continue to start preview after SurfaceCreated.");
      f(new aacb(this));
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    QLog.i("AREngine_AREngine", 1, "surfaceCreated. holder = " + paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    QLog.i("AREngine_AREngine", 1, "surfaceDestroyed. holder = " + paramSurfaceHolder);
    this.jdField_k_of_type_Boolean = false;
  }
  
  public void t()
  {
    this.jdField_v_of_type_Int = 0;
    this.jdField_v_of_type_Long = 0L;
    this.jdField_w_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.AREngine
 * JD-Core Version:    0.7.0.1
 */