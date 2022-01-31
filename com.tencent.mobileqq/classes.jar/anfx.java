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
import com.tencent.mobileqq.ar.ARRecognition;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArLBSActivity;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.ar.model.ArWebInfo;
import com.tencent.mobileqq.ar.model.QQARSession.1;
import com.tencent.mobileqq.ar.model.QQARSession.10;
import com.tencent.mobileqq.ar.model.QQARSession.11;
import com.tencent.mobileqq.ar.model.QQARSession.12;
import com.tencent.mobileqq.ar.model.QQARSession.13;
import com.tencent.mobileqq.ar.model.QQARSession.14;
import com.tencent.mobileqq.ar.model.QQARSession.15;
import com.tencent.mobileqq.ar.model.QQARSession.16;
import com.tencent.mobileqq.ar.model.QQARSession.17;
import com.tencent.mobileqq.ar.model.QQARSession.18;
import com.tencent.mobileqq.ar.model.QQARSession.2;
import com.tencent.mobileqq.ar.model.QQARSession.20;
import com.tencent.mobileqq.ar.model.QQARSession.21;
import com.tencent.mobileqq.ar.model.QQARSession.22;
import com.tencent.mobileqq.ar.model.QQARSession.23;
import com.tencent.mobileqq.ar.model.QQARSession.24;
import com.tencent.mobileqq.ar.model.QQARSession.25;
import com.tencent.mobileqq.ar.model.QQARSession.26;
import com.tencent.mobileqq.ar.model.QQARSession.27;
import com.tencent.mobileqq.ar.model.QQARSession.28;
import com.tencent.mobileqq.ar.model.QQARSession.3;
import com.tencent.mobileqq.ar.model.QQARSession.4;
import com.tencent.mobileqq.ar.model.QQARSession.5;
import com.tencent.mobileqq.ar.model.QQARSession.6;
import com.tencent.mobileqq.ar.model.QQARSession.7;
import com.tencent.mobileqq.ar.model.QQARSession.8;
import com.tencent.mobileqq.ar.model.QQARSession.9;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class anfx
  extends anfl
  implements amvi, amwm, anas, ancb, andg, Camera.PreviewCallback
{
  private static anfx jdField_a_of_type_Anfx;
  public static boolean a;
  private static boolean w = true;
  public long a;
  private amtj jdField_a_of_type_Amtj;
  private amwk jdField_a_of_type_Amwk;
  private anam jdField_a_of_type_Anam;
  private anbm jdField_a_of_type_Anbm;
  private anby jdField_a_of_type_Anby;
  public anca a;
  private ancg jdField_a_of_type_Ancg;
  private ancq jdField_a_of_type_Ancq;
  private anct jdField_a_of_type_Anct;
  private andc jdField_a_of_type_Andc;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ange jdField_a_of_type_Ange;
  private ARNativeBridge jdField_a_of_type_ComTencentMobileqqArARNativeBridge;
  private ARCommonConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
  ARScanStarFaceConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = null;
  public ArCloudConfigInfo a;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private String jdField_a_of_type_JavaLangString = "0";
  private ArrayList<ArCloudConfigInfo> jdField_a_of_type_JavaUtilArrayList;
  private long jdField_b_of_type_Long = 0L;
  private ancg jdField_b_of_type_Ancg;
  private ancq jdField_b_of_type_Ancq;
  public ArCloudConfigInfo b;
  private ArrayList<Runnable> jdField_b_of_type_JavaUtilArrayList;
  public boolean b;
  int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private ArCloudConfigInfo jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  public boolean c;
  private int jdField_d_of_type_Int = 5;
  private final long jdField_d_of_type_Long = 5L;
  private ArCloudConfigInfo jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 5;
  private final long jdField_e_of_type_Long = 2183L;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 5;
  private long jdField_f_of_type_Long = 0L;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 5;
  private long jdField_g_of_type_Long = 0L;
  private volatile boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 5;
  private long jdField_h_of_type_Long = 0L;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 5;
  private long jdField_i_of_type_Long;
  private final boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private long jdField_j_of_type_Long;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private long jdField_k_of_type_Long;
  private boolean jdField_k_of_type_Boolean = true;
  private int jdField_l_of_type_Int;
  private long jdField_l_of_type_Long;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private long jdField_m_of_type_Long;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int = 17;
  private long jdField_n_of_type_Long;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private long jdField_o_of_type_Long;
  private volatile boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private long jdField_p_of_type_Long;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private long jdField_q_of_type_Long;
  private boolean jdField_q_of_type_Boolean;
  private volatile int jdField_r_of_type_Int = 0;
  private long jdField_r_of_type_Long;
  private boolean jdField_r_of_type_Boolean;
  private long jdField_s_of_type_Long;
  private boolean jdField_s_of_type_Boolean = true;
  private long jdField_t_of_type_Long;
  private boolean jdField_t_of_type_Boolean = true;
  private long jdField_u_of_type_Long;
  private boolean jdField_u_of_type_Boolean = true;
  private long jdField_v_of_type_Long;
  private boolean jdField_v_of_type_Boolean;
  
  public anfx()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 4096L;
    this.jdField_b_of_type_Int = 1;
    w = false;
    anft.a().b(this);
  }
  
  private void A()
  {
    if (this.jdField_r_of_type_Int != 1) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Anca != null) {
        this.jdField_a_of_type_Anca.c();
      }
    } while (this.jdField_a_of_type_Amtj == null);
    this.jdField_a_of_type_Amtj.d();
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
  
  public static amvl a(ArCloudConfigInfo paramArCloudConfigInfo, boolean paramBoolean, long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
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
      localObject1 = andq.b(paramArCloudConfigInfo);
      localObject2 = andq.c(paramArCloudConfigInfo);
      localObject3 = andq.d(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      localObject4 = amwp.a(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.e);
      paramArCloudConfigInfo = new amvx(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, (String)localObject2, (String)localObject1, (String)localObject3, (amzd)localObject4, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", resPath = " + paramArCloudConfigInfo.c + ", luaPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", musicPath = " + paramArCloudConfigInfo.jdField_d_of_type_JavaLangString + ", recogType = " + paramLong);
      return paramArCloudConfigInfo;
    }
    int i2;
    int i1;
    if ((paramArCloudConfigInfo.jdField_d_of_type_Int == 2) || (paramArCloudConfigInfo.jdField_d_of_type_Int == 3))
    {
      if (!bhtb.d())
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. NOT IceScreamSandwich.");
        return null;
      }
      if (amwp.a())
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. isRubbishDeviceNeedsSoftwareDecode.");
        return null;
      }
      localObject2 = andq.e(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. video path empty or file not exist.");
        return null;
      }
      localObject1 = new amwo(paramArCloudConfigInfo);
      i2 = amwp.a((amwo)localObject1);
      i1 = i2;
      if (i2 == 0) {
        i1 = 2147483647;
      }
      localObject1 = amwp.a((amwo)localObject1);
      i2 = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (anff)((Pair)localObject1).second;
      localObject1 = null;
      if (!paramArCloudConfigInfo.d()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.jdField_c_of_type_Int != 2))) {
          break label649;
        }
      }
      label649:
      for (localObject1 = amwp.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, angf.jdField_a_of_type_Int, angf.jdField_b_of_type_Int, paramArCloudConfigInfo.j());; localObject1 = amwp.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, angf.jdField_a_of_type_Int, angf.jdField_b_of_type_Int))
      {
        paramArCloudConfigInfo = new amwg(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, i2, (anff)localObject3, (amzd)localObject1, (String)localObject2, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", renderType = " + paramArCloudConfigInfo.jdField_d_of_type_Int + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_Anff + ", videoPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_Amzd + ", videoPlayCount = " + i1 + ", recogType = " + paramLong);
        return paramArCloudConfigInfo;
      }
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 4)
    {
      localObject1 = new amwo(paramArCloudConfigInfo);
      i2 = amwp.a((amwo)localObject1);
      i1 = i2;
      if (i2 == 0) {
        i1 = 2147483647;
      }
      localObject1 = amwp.a((amwo)localObject1);
      i2 = ((Integer)((Pair)localObject1).first).intValue();
      localObject3 = (anff)((Pair)localObject1).second;
      localObject1 = null;
      if (!paramArCloudConfigInfo.d()) {
        if (((!paramBoolean) || ((paramLong != 2L) && (paramLong != 2048L))) && ((paramLong != 1L) || (paramArCloudConfigInfo.jdField_c_of_type_Int != 2))) {
          break label1119;
        }
      }
      label1119:
      for (localObject1 = amwp.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, angf.jdField_a_of_type_Int, angf.jdField_b_of_type_Int, paramArCloudConfigInfo.j());; localObject1 = amwp.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString, angf.jdField_a_of_type_Int, angf.jdField_b_of_type_Int))
      {
        localObject2 = "";
        long l1 = 0L;
        localObject4 = angh.a(((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long + "|" + ((ArVideoResourceInfo)paramArCloudConfigInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_d_of_type_JavaLangString);
        if (localObject4 != null)
        {
          l1 = ((Long)((Pair)localObject4).first).longValue();
          localObject2 = (String)((Pair)localObject4).second;
        }
        paramBoolean = amwp.a();
        paramArCloudConfigInfo = new amwj(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, i2, (anff)localObject3, (amzd)localObject1, (String)localObject2, l1, paramBoolean, i1, paramInt, paramFloat1, paramFloat2, paramFloat3);
        paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", arType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", trackMode = " + paramArCloudConfigInfo.jdField_b_of_type_Int + ", renderType = " + paramArCloudConfigInfo.jdField_d_of_type_Int + ", keyingParams = " + paramArCloudConfigInfo.jdField_a_of_type_Anff + ", videoUrl = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", videoSize = " + paramArCloudConfigInfo.jdField_b_of_type_Long + ", layout = " + paramArCloudConfigInfo.jdField_a_of_type_Amzd + ", isSoftDecode = " + paramArCloudConfigInfo.jdField_a_of_type_Boolean + ", videoPlayCount = " + i1 + ", recogType = " + paramLong);
        return paramArCloudConfigInfo;
      }
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 5)
    {
      if (amwp.a())
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
      paramArCloudConfigInfo = new amwc(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      paramArCloudConfigInfo.jdField_a_of_type_Long = paramLong;
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 100)
    {
      localObject1 = andq.a(paramArCloudConfigInfo);
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
      {
        QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo failed. resource path empty or file not exist.");
        return null;
      }
      paramArCloudConfigInfo = new amwb(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.jdField_a_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, 1, "", (String)localObject1, "", paramArCloudConfigInfo, paramInt, paramFloat1, paramFloat2, paramFloat3);
      QLog.i("AREngine_QQARSession", 1, "getARRenderResourceInfo. key = " + paramArCloudConfigInfo.jdField_a_of_type_JavaLangString + ", resType = " + paramArCloudConfigInfo.jdField_a_of_type_Int + ", resPath = " + paramArCloudConfigInfo.c + ", luaPath = " + paramArCloudConfigInfo.jdField_b_of_type_JavaLangString + ", musicPath = " + paramArCloudConfigInfo.jdField_d_of_type_JavaLangString);
      return paramArCloudConfigInfo;
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 7)
    {
      localObject1 = andq.c(paramArCloudConfigInfo);
      localObject2 = andq.b(paramArCloudConfigInfo);
      return new amvy(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2);
    }
    if (paramArCloudConfigInfo.jdField_d_of_type_Int == 8)
    {
      localObject1 = andq.b(paramArCloudConfigInfo);
      localObject2 = andq.a(paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_b_of_type_JavaLangString);
      localObject3 = paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_a_of_type_JavaUtilArrayList;
      boolean bool = paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_a_of_type_Boolean;
      if (paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_b_of_type_Int == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        i1 = paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_d_of_type_Int;
        i2 = paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_c_of_type_Int;
        return new amvs(paramArCloudConfigInfo.jdField_b_of_type_JavaLangString, paramArCloudConfigInfo.jdField_d_of_type_Int, paramArCloudConfigInfo.jdField_c_of_type_Int, paramInt, paramFloat1, paramFloat2, paramFloat3, (String)localObject1, (String)localObject2, (ArrayList)localObject3, Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), i1, i2);
      }
    }
    return null;
  }
  
  public static anfx a()
  {
    if (jdField_a_of_type_Anfx == null) {
      jdField_a_of_type_Anfx = new anfx();
    }
    return jdField_a_of_type_Anfx;
  }
  
  private void a(anau paramanau, ArLBSActivity paramArLBSActivity)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
      this.jdField_a_of_type_Anby.a(paramanau, paramArLBSActivity);
    }
  }
  
  private void a(anax paramanax)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult start.");
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangRunnable = new QQARSession.10(this);
    if (!this.jdField_a_of_type_Andc.a(paramanax, this, false, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudMarkerRecogResult end. download preprocess failed.");
      this.jdField_l_of_type_Boolean = false;
      w();
      return;
    }
    b(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(anbc paramanbc)
  {
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult start.");
    this.jdField_a_of_type_JavaLangRunnable = new QQARSession.11(this);
    if (!this.jdField_a_of_type_Andc.a(paramanbc, this, false, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult end. download preprocess failed.");
      m();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processYouTuCloudObjectClassifyResult post task for handle timeout");
    b(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(anbo paramanbo)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult start.");
    this.jdField_a_of_type_Anca.a(paramanbo);
    b(4L);
    this.jdField_r_of_type_Boolean = true;
    QLog.i("AREngine_QQARSession", 1, "processCloudFaceRecogResult end.");
  }
  
  private void a(anbu paramanbu)
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult start.");
    this.jdField_a_of_type_JavaLangRunnable = new QQARSession.13(this);
    if (!this.jdField_a_of_type_Andc.a(paramanbu, this, false, this.jdField_a_of_type_JavaLangString))
    {
      QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult end. download preprocess failed.");
      o();
      return;
    }
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult post task for handle timeout");
    b(this.jdField_a_of_type_JavaLangRunnable, 30000L);
  }
  
  private void a(ancg paramancg1, ancg paramancg2)
  {
    if ((QLog.isColorLevel()) && (ancc.jdField_a_of_type_Boolean)) {
      QLog.d("AREngine_QQARSession", 2, "ARFaceTest processLocalFaceRecogResult. curLocalFaceRecogResult = " + paramancg1);
    }
    if (this.jdField_a_of_type_Ange != null) {
      this.jdField_a_of_type_Ange.b(paramancg1.jdField_a_of_type_Long);
    }
    if (this.jdField_a_of_type_Ange != null) {
      this.jdField_a_of_type_Ange.a();
    }
    a(null, paramancg1);
  }
  
  private void a(ancj paramancj)
  {
    QLog.i("AREngine_QQARSession", 1, "processLocalGestureCircleRecogResult");
    if (this.jdField_a_of_type_Amtj != null) {
      this.jdField_a_of_type_Amtj.a(paramancj, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_j_of_type_Int, this.jdField_k_of_type_Int);
    }
  }
  
  private void a(ancq paramancq1, ancq paramancq2)
  {
    if (paramancq1.jdField_a_of_type_Int != 2) {
      if (paramancq1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.f())
      {
        if (this.jdField_a_of_type_Ange != null) {
          this.jdField_a_of_type_Ange.b(paramancq1.jdField_a_of_type_Long);
        }
        if (this.jdField_a_of_type_Ange != null) {
          this.jdField_a_of_type_Ange.a();
        }
        this.jdField_k_of_type_Long = 0L;
        this.jdField_l_of_type_Long = 0L;
        if (paramancq1.jdField_a_of_type_Int == 0) {
          a(1L, paramancq1.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, paramancq1.jdField_b_of_type_Int, paramancq1.jdField_a_of_type_Float, paramancq1.jdField_b_of_type_Float, paramancq1.c);
        }
        a(new amvk(paramancq1.jdField_b_of_type_Int, paramancq1.jdField_a_of_type_Float, paramancq1.jdField_b_of_type_Float, paramancq1.c, paramancq1.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_Anca.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int)));
        this.jdField_q_of_type_Boolean = true;
      }
    }
    do
    {
      do
      {
        return;
        if ((paramancq2 != null) && (paramancq2.jdField_a_of_type_Int != 2)) {
          this.jdField_k_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_l_of_type_Long = System.currentTimeMillis();
      } while (this.jdField_k_of_type_Long <= 0L);
      if (d())
      {
        paramancq2 = new float[16];
        a(new amvk(paramancq1.jdField_b_of_type_Int, 0.0F, 0.0F, 0.0F, paramancq2, this.jdField_a_of_type_Anca.a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int)));
      }
    } while (this.jdField_l_of_type_Long - this.jdField_k_of_type_Long <= 1500L);
    this.jdField_k_of_type_Long = 0L;
    amup.a().b(1);
    k();
  }
  
  private void a(anct paramanct)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult start.");
    if (paramanct.a() == -1)
    {
      n();
      return;
    }
    if (paramanct.a() == 1)
    {
      b(paramanct);
      return;
    }
    int i1;
    if (this.jdField_a_of_type_Anct == null) {
      i1 = 1;
    }
    while ((this.jdField_a_of_type_Anam != null) && (i1 != 0))
    {
      this.jdField_a_of_type_Anam.b(true);
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal setCompareSameSceneFlag.");
      return;
      if (!paramanct.a(this.jdField_a_of_type_Anct)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    b(paramanct);
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (b() != null) {
      b().c(paramRunnable);
    }
  }
  
  private boolean a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    amvl localamvl1 = a(paramArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
    if (localamvl1 == null) {
      return false;
    }
    QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType = " + paramLong + ", key = " + localamvl1.jdField_a_of_type_JavaLangString + ", resType = " + localamvl1.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Ange != null)
    {
      this.jdField_h_of_type_Long = paramLong;
      this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      amvl localamvl2 = a(this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, false, paramLong, paramInt, paramFloat1, paramFloat2, paramFloat3);
      if ((localamvl2 != null) && (localamvl2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localamvl1.jdField_a_of_type_JavaLangString))) {
        return true;
      }
      if ((localamvl2 == null) || (localamvl2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localamvl1.jdField_a_of_type_JavaLangString))) {
        break label337;
      }
      this.jdField_a_of_type_Ange.d();
      this.jdField_a_of_type_Ange.a(localamvl1);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ange != null) {
        this.jdField_a_of_type_Ange.a();
      }
      anft.a().a();
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null))
      {
        if ((!paramArCloudConfigInfo.a()) && (paramArCloudConfigInfo.f())) {
          amup.a().a(3);
        }
        paramArCloudConfigInfo = new amwo(paramArCloudConfigInfo);
        this.jdField_a_of_type_Anby.a(paramLong, true, paramArCloudConfigInfo);
      }
      this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
      if (this.jdField_o_of_type_Int == 0)
      {
        this.jdField_p_of_type_Long = System.currentTimeMillis();
        this.jdField_o_of_type_Int = ((int)(this.jdField_p_of_type_Long - this.jdField_o_of_type_Long));
      }
      if ((this.jdField_p_of_type_Int == 0) && (this.jdField_a_of_type_Anbm != null))
      {
        this.jdField_r_of_type_Long = System.currentTimeMillis();
        this.jdField_p_of_type_Int = ((int)(this.jdField_r_of_type_Long - this.jdField_q_of_type_Long));
      }
      return true;
      label337:
      this.jdField_a_of_type_Ange.a(localamvl1);
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    QLog.i("AREngine_QQARSession", 1, "startSensorTrack. isForExternalTrack = " + paramBoolean);
    this.jdField_p_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Amwk != null) {
      this.jdField_a_of_type_Amwk.a();
    }
    return true;
  }
  
  public static anfx b()
  {
    return jdField_a_of_type_Anfx;
  }
  
  private void b(anct paramanct)
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResultInternal start.");
    if (paramanct.a() == 1)
    {
      azqs.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_Anct != null) {
        e(false);
      }
      this.jdField_a_of_type_JavaLangRunnable = new QQARSession.12(this);
      if (!this.jdField_a_of_type_Andc.a(paramanct, this, false, this.jdField_a_of_type_JavaLangString))
      {
        QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult end. download preprocess failed.");
        n();
      }
    }
    ancu localancu;
    do
    {
      return;
      QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult post task for handle timeout");
      b(this.jdField_a_of_type_JavaLangRunnable, 30000L);
      return;
      azqs.b(null, "dc00898", "", "", "0X8008999", "0X8008999", 0, 0, "0", "", "", "");
      localancu = paramanct.a();
      if (localancu != null)
      {
        this.jdField_a_of_type_Anct = paramanct;
        a(null, localancu);
        u();
      }
    } while ((localancu != null) && (localancu.jdField_a_of_type_Boolean));
    n();
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (b() != null) {
      b().d(paramRunnable);
    }
  }
  
  public static void b(Runnable paramRunnable, long paramLong)
  {
    if (b() != null) {
      b().c(paramRunnable, paramLong);
    }
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
              break label107;
            }
            QLog.i("AREngine_QQARSession", 1, "removeTask. task = " + this.jdField_b_of_type_JavaUtilArrayList.get(i1));
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
  
  private void d(boolean paramBoolean)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
      this.jdField_a_of_type_Anby.b(paramBoolean);
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
      if (this.jdField_a_of_type_Anby != null) {
        this.jdField_a_of_type_Anby.a(paramInt);
      }
      return;
      this.jdField_a_of_type_Int = 5;
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Anct = null;
    ancu.jdField_a_of_type_Ancu.jdField_b_of_type_Boolean = paramBoolean;
    a(null, ancu.jdField_a_of_type_Ancu);
  }
  
  private void e(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    long l2 = System.currentTimeMillis() - this.jdField_s_of_type_Long;
    if (l2 >= 1000L) {}
    for (long l1 = 0L;; l1 = 1000L - l2)
    {
      QLog.i("AREngine_QQARSession", 1, String.format("onARObjectClassifyDownloadComplete result=%s timeCost=%s timeDelay=%s", new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(l2), Long.valueOf(l1) }));
      b(new QQARSession.16(this, paramBoolean, paramArCloudConfigInfo), l1);
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
      b(new QQARSession.18(this, paramBoolean, paramArCloudConfigInfo), l1);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
      return;
    }
  }
  
  public static boolean f()
  {
    return w;
  }
  
  private boolean g()
  {
    boolean bool = false;
    QLog.i("AREngine_QQARSession", 2, "startRenderManager.");
    if (this.jdField_a_of_type_Ange != null)
    {
      this.jdField_a_of_type_Ange.a(0, this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge);
      this.jdField_a_of_type_Ange.a(8, this.jdField_a_of_type_Amtj);
      bool = true;
    }
    return bool;
  }
  
  private boolean h()
  {
    QLog.i("AREngine_QQARSession", 2, "startLocalRecog.");
    if (this.jdField_a_of_type_Anca != null)
    {
      if (!this.jdField_a_of_type_Anca.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_f_of_type_Long, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo, this)) {
        return false;
      }
      return this.jdField_a_of_type_Anca.a();
    }
    return false;
  }
  
  private boolean i()
  {
    QLog.i("AREngine_QQARSession", 2, "startCloudRecog.");
    if (this.jdField_a_of_type_Anam != null)
    {
      this.jdField_a_of_type_Anam.a(this.jdField_l_of_type_Int, this.jdField_m_of_type_Int, this.jdField_n_of_type_Int);
      this.jdField_a_of_type_Anam.b();
      return true;
    }
    return false;
  }
  
  private boolean j()
  {
    QLog.i("AREngine_QQARSession", 2, "stopLocalRecog.");
    if (this.jdField_a_of_type_Anca != null) {
      this.jdField_a_of_type_Anca.a();
    }
    return true;
  }
  
  private boolean k()
  {
    QLog.i("AREngine_QQARSession", 2, "stopCloudRecog.");
    if (this.jdField_a_of_type_Anam != null) {
      this.jdField_a_of_type_Anam.e();
    }
    return true;
  }
  
  private boolean l()
  {
    return false;
  }
  
  public static void r()
  {
    jdField_a_of_type_Anfx = null;
    w = true;
  }
  
  public static void s()
  {
    if (b() != null) {
      b().B();
    }
  }
  
  private void t()
  {
    QLog.d("AREngine_QQARSession", 1, "pauseCloudRecog.");
    if (this.jdField_a_of_type_Anam != null) {
      this.jdField_a_of_type_Anam.d();
    }
  }
  
  private void u()
  {
    QLog.d("AREngine_QQARSession", 1, "resumeCloudRecog.");
    if (this.jdField_p_of_type_Int == 0) {
      this.jdField_q_of_type_Long = 0L;
    }
    this.jdField_a_of_type_Anbm = null;
    this.jdField_l_of_type_Boolean = false;
    if (this.jdField_a_of_type_Anam != null) {
      this.jdField_a_of_type_Anam.c();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Amwk != null)
    {
      this.jdField_a_of_type_Amwk.e();
      this.jdField_a_of_type_Amwk = null;
    }
    if (this.jdField_a_of_type_Anca != null)
    {
      this.jdField_a_of_type_Anca.b();
      this.jdField_a_of_type_Anca = null;
    }
    if (this.jdField_a_of_type_Anam != null)
    {
      this.jdField_a_of_type_Anam.f();
      this.jdField_a_of_type_Anam = null;
    }
    if (this.jdField_a_of_type_Andc != null)
    {
      this.jdField_a_of_type_Andc.c();
      this.jdField_a_of_type_Andc = null;
    }
    if (this.jdField_a_of_type_Ange != null) {
      this.jdField_a_of_type_Ange = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_r_of_type_Int = 0;
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
    this.jdField_q_of_type_Boolean = false;
  }
  
  private void x()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessCloudFaceRecogResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      y();
      this.jdField_r_of_type_Boolean = false;
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
    this.jdField_p_of_type_Boolean = false;
    if (this.jdField_a_of_type_Amwk != null) {
      this.jdField_a_of_type_Amwk.d();
    }
  }
  
  public int a()
  {
    a(new QQARSession.1(this));
    return 0;
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ARCommonConfigInfo paramARCommonConfigInfo, ArConfigInfo paramArConfigInfo, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, anby paramanby, Activity paramActivity, amtj paramamtj, ange paramange)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("initAR isEnableARCloudFromSettings=%s isEnableARCloudFromH5=%s isTestMode=%s commonConfig=%s markerConfig=%s faceConfig=%s arEngineCallback=%s mIsArInited=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean4), paramARCommonConfigInfo, paramArConfigInfo, paramARScanStarFaceConfigInfo, paramanby, Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
    if (this.jdField_f_of_type_Boolean) {
      return 0;
    }
    if (paramARCommonConfigInfo == null)
    {
      this.jdField_f_of_type_Boolean = false;
      QLog.i("AREngine_QQARSession", 1, "initAR fail! commonConfig is null.");
      if (paramanby != null) {
        paramanby.a(3);
      }
      return 3;
    }
    jdField_a_of_type_Boolean = paramBoolean4;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = paramARCommonConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArAidlARScanStarFaceConfigInfo = paramARScanStarFaceConfigInfo;
    this.jdField_a_of_type_Anby = paramanby;
    this.jdField_h_of_type_Boolean = paramARCommonConfigInfo.isEnableARCloud();
    this.jdField_b_of_type_Long = ARRecognition.b(paramARCommonConfigInfo.recognitions);
    this.jdField_c_of_type_Long = ARRecognition.a(paramARCommonConfigInfo.recognitions);
    if (this.jdField_h_of_type_Boolean)
    {
      paramBoolean4 = true;
      this.jdField_j_of_type_Boolean = paramBoolean4;
      if (!paramBoolean2) {
        this.jdField_j_of_type_Boolean = false;
      }
      if (paramBoolean1) {
        this.jdField_j_of_type_Boolean = true;
      }
      if (!paramBoolean3) {
        break label361;
      }
      this.jdField_c_of_type_Boolean = true;
      this.jdField_j_of_type_Boolean = false;
    }
    label361:
    for (this.jdField_f_of_type_Long = 4096L;; this.jdField_f_of_type_Long = (this.jdField_b_of_type_Long & 0x5))
    {
      this.jdField_g_of_type_Long = (this.jdField_c_of_type_Long & 0x887);
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions == null) {
        break label376;
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
    label376:
    this.jdField_d_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L);
    this.jdField_e_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2L);
    this.jdField_f_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 4L);
    this.jdField_g_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L);
    this.jdField_h_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 128L);
    this.jdField_i_of_type_Int = ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 2048L);
    QLog.i("AREngine_QQARSession", 1, "initAR mIsEnableARCloudFromConfig=" + this.jdField_h_of_type_Boolean + " mLocalRecogTypeFromConfig=" + this.jdField_b_of_type_Long + " mCloudRecogTypeFromConfig=" + this.jdField_c_of_type_Long + " mIsEnableARCloudFromClientSupport=" + true + " mLocalRecogTypeFromClientSupport=" + 5L + " mCloudRecogTypeFromClientSupport=" + 2183L + " mIsEnableARCloud=" + this.jdField_j_of_type_Boolean + " mLocalRecogType=" + this.jdField_f_of_type_Long + " mCloudRecogType=" + this.jdField_g_of_type_Long + " mMarkerRecogPriority=" + this.jdField_d_of_type_Int + " mObjectClassifyPriority=" + this.jdField_e_of_type_Int + " mFaceRecogPriority=" + this.jdField_f_of_type_Int + " mPreOcrRecogPriority=" + this.jdField_g_of_type_Int + " mSceneRecogPriority=" + this.jdField_i_of_type_Int);
    QLog.i("AREngine_QQARSession", 1, "Build.MODEL = " + Build.MODEL);
    this.jdField_a_of_type_Ange = paramange;
    this.jdField_a_of_type_Amtj = paramamtj;
    this.jdField_a_of_type_Andc = new andc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext);
    if ((this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime > 0L)) {
      this.jdField_a_of_type_Andc.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.aRCloudCacheExpireTime * 60L * 1000L, jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Andc.a();
      if ((this.jdField_f_of_type_Long != 0L) && (this.jdField_a_of_type_Anca == null)) {
        this.jdField_a_of_type_Anca = new anca();
      }
      if ((!this.jdField_j_of_type_Boolean) || (this.jdField_a_of_type_Anam != null)) {
        break;
      }
      this.jdField_a_of_type_Anam = new anam();
      if (this.jdField_a_of_type_Anam.a(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramActivity, 900000000, 900000000, 0, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo)) {
        break;
      }
      QLog.i("AREngine_QQARSession", 1, "initAR fail! ARCloud init ar so fail.");
      this.jdField_a_of_type_Anam = null;
      this.jdField_f_of_type_Boolean = false;
      if (paramanby != null) {
        paramanby.a(8);
      }
      return 8;
      this.jdField_a_of_type_Andc.a(86400000L, jdField_a_of_type_Boolean);
    }
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.mARCloudUploadDelayTime;
  }
  
  public ArrayList<String> a()
  {
    if (this.jdField_a_of_type_Anam != null) {
      return this.jdField_a_of_type_Anam.a();
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
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
      this.jdField_a_of_type_Anby.a(2, paramInt);
    }
  }
  
  public void a(int paramInt, anbm paramanbm)
  {
    if (this.jdField_c_of_type_Boolean) {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete mIsForbiddenLocalMarkAndCloudRecg:do nothing but return ");
    }
    for (;;)
    {
      return;
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. retCode = " + paramInt + ", recogResult = " + paramanbm + ":time is:" + (System.currentTimeMillis() - this.jdField_t_of_type_Long));
      this.jdField_t_of_type_Long = System.currentTimeMillis();
      if ((paramInt == 0) && (this.jdField_u_of_type_Boolean))
      {
        this.jdField_u_of_type_Boolean = false;
        azqs.b(null, "dc00898", "", "", "0X80085AE", "0X80085AE", 0, 0, "", "", "", "");
      }
      if (((this.jdField_a_of_type_Anbm == null) || (this.jdField_a_of_type_Anct != null)) && ((this.jdField_a_of_type_Ancq == null) || (this.jdField_a_of_type_Ancq.jdField_a_of_type_Int == 2)) && ((this.jdField_a_of_type_Ancg == null) || (this.jdField_a_of_type_Ancg.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) && (!d())) {
        break;
      }
      if ((this.jdField_a_of_type_Anbm != null) && (this.jdField_a_of_type_Anct == null)) {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurCloudRecogResult != null.");
      }
      while (this.jdField_a_of_type_Anam != null)
      {
        this.jdField_a_of_type_Anam.a(true);
        return;
        if ((this.jdField_a_of_type_Ancq != null) && (this.jdField_a_of_type_Ancq.jdField_a_of_type_Int != 2)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalMarkerRecogResult.state != ARConstants.AR_TRACK_STATE_LOST.");
        } else if ((this.jdField_a_of_type_Ancg != null) && (this.jdField_a_of_type_Ancg.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. mCurLocalFaceRecogResult.faceDatas.size() > 0.");
        } else if (d()) {
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. isModelRenderStarted().");
        }
      }
    }
    int i1;
    boolean bool;
    Object localObject;
    if ((this.jdField_a_of_type_Anbm == null) && (this.jdField_a_of_type_Anct != null))
    {
      QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult sucess");
      i1 = 0;
      if ((paramInt != 0) || (paramanbm == null)) {
        break label1070;
      }
      if ((!anax.a(paramanbm.jdField_a_of_type_Anax)) && (!anbc.a(paramanbm.jdField_a_of_type_Anbc)) && (!anct.a(paramanbm.jdField_a_of_type_Anct)) && (!anbo.a(paramanbm.jdField_a_of_type_Anbo)))
      {
        paramInt = i1;
        if (!anbu.a(paramanbm.jdField_a_of_type_Anbu)) {}
      }
      else
      {
        paramInt = 1;
      }
      bool = anbe.a(paramanbm.jdField_a_of_type_Anbe);
      i1 = paramInt;
      if (bool)
      {
        i1 = paramInt;
        if (paramInt != 0)
        {
          i1 = paramInt;
          if (ARRecognition.a(paramanbm, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 64L))
          {
            i1 = 0;
            QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard other recog result as OCR preRecog has high priority");
          }
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("onARCloudUploadImgComplete result:  marker{success: ").append(anax.a(paramanbm.jdField_a_of_type_Anax)).append(", priority: ").append(this.jdField_d_of_type_Int).append("}");
        localStringBuilder1.append("  object{success: ").append(anbc.a(paramanbm.jdField_a_of_type_Anbc)).append(", priority: ").append(this.jdField_e_of_type_Int).append("}");
        localStringBuilder1.append("  face{success: ").append(anbo.a(paramanbm.jdField_a_of_type_Anbo)).append(", priority: ").append(this.jdField_f_of_type_Int).append("}");
        localStringBuilder1.append("  pre ocr{success: ").append(anbe.a(paramanbm.jdField_a_of_type_Anbe)).append(", priority: ").append(this.jdField_g_of_type_Int).append("}");
        StringBuilder localStringBuilder2 = localStringBuilder1.append(" \n mig-object{success: ").append(anct.a(paramanbm.jdField_a_of_type_Anct)).append(", priority: ").append(this.jdField_h_of_type_Int).append("}name:");
        if (paramanbm.jdField_a_of_type_Anct == null) {
          break label900;
        }
        localObject = paramanbm.jdField_a_of_type_Anct.toString();
        label666:
        localStringBuilder2.append((String)localObject);
        localStringBuilder1.append("  scene{success: ").append(anbu.a(paramanbm.jdField_a_of_type_Anbu)).append(", priority: ").append(this.jdField_i_of_type_Int).append("}");
        QLog.i("AREngine_QQARSession", 2, localStringBuilder1.toString());
      }
    }
    for (;;)
    {
      if ((i1 != 0) && (!this.jdField_v_of_type_Boolean))
      {
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete first recognize success.");
        this.jdField_v_of_type_Boolean = true;
      }
      if ((bool) && (i1 == 0))
      {
        this.jdField_m_of_type_Boolean = true;
        a(new QQARSession.5(this));
      }
      for (;;)
      {
        if (i1 != 0) {
          break label939;
        }
        if (this.jdField_a_of_type_Anct != null)
        {
          e(true);
          if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (!this.jdField_o_of_type_Boolean)) {
            n();
          }
        }
        if ((!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) && ((this.jdField_f_of_type_Long & 1L) != 0L))
        {
          t();
          b(1L);
        }
        if (this.jdField_a_of_type_Anam != null) {
          this.jdField_a_of_type_Anam.a(true);
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. cloud recog failed.");
        return;
        if ((this.jdField_a_of_type_Anbm == null) || (this.jdField_a_of_type_Anct == null)) {
          break;
        }
        QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. deal mCurMIGObjectClassifyResult error happen");
        break;
        label900:
        localObject = "";
        break label666;
        if ((!bool) && (this.jdField_m_of_type_Boolean))
        {
          this.jdField_m_of_type_Boolean = false;
          a(new QQARSession.6(this));
        }
      }
      label939:
      if (i1 != 0)
      {
        localObject = anbm.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramanbm);
        if ((anbm.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramanbm)) && (((anau)localObject).jdField_a_of_type_Int != 1))
        {
          a(new QQARSession.7(this, (anau)localObject, anbm.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, paramanbm)));
          if (this.jdField_a_of_type_Anam != null) {
            this.jdField_a_of_type_Anam.a(true);
          }
          QLog.i("AREngine_QQARSession", 1, "onARCloudUploadImgComplete. discard this recog result. lbs location failed.");
          return;
        }
      }
      t();
      this.jdField_i_of_type_Long = 0L;
      this.jdField_j_of_type_Long = 0L;
      a(new QQARSession.8(this, paramanbm));
      if (this.jdField_a_of_type_Anam == null) {
        break;
      }
      this.jdField_a_of_type_Anam.a(true);
      return;
      label1070:
      i1 = 0;
      bool = false;
    }
  }
  
  public void a(long paramLong)
  {
    QLog.d("AREngine_QQARSession", 1, "pauseLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_Anca != null) {
      this.jdField_a_of_type_Anca.a(paramLong);
    }
  }
  
  public void a(long paramLong, ancs paramancs)
  {
    if (this.jdField_r_of_type_Int == 1)
    {
      if (paramancs.jdField_b_of_type_Long != 4096L) {
        return;
      }
      a((ancj)paramancs);
      return;
    }
    ancr localancr = new ancr();
    if ((1L & paramLong) != 0L) {
      localancr.jdField_a_of_type_Ancq = ((ancq)paramancs);
    }
    if ((0x4 & paramLong) != 0L) {
      localancr.jdField_a_of_type_Ancg = ((ancg)paramancs);
    }
    a(localancr, null);
  }
  
  public void a(long paramLong, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    a(new QQARSession.2(this, paramLong, paramArCloudConfigInfo), 500L);
  }
  
  public void a(amvk paramamvk)
  {
    a(paramamvk, null);
  }
  
  public void a(amvm paramamvm, ancs paramancs)
  {
    if ((paramancs != null) && (paramancs.jdField_b_of_type_Long == 4L)) {
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
        this.jdField_a_of_type_Anby.a(paramancs.jdField_b_of_type_Long, 0, null, paramancs);
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
            if ((paramancs == null) || (paramancs.jdField_b_of_type_Long != 128L)) {
              break;
            }
          } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Anby == null));
          this.jdField_a_of_type_Anby.a(paramancs.jdField_b_of_type_Long, 0, null, paramancs);
          return;
          if (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
            break label211;
          }
          if (this.jdField_a_of_type_Ange != null) {
            this.jdField_a_of_type_Ange.a();
          }
          if ((!this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.g()) || (!this.jdField_p_of_type_Boolean)) {
            break;
          }
        } while ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int != 2) || (this.jdField_a_of_type_Anby == null));
        this.jdField_a_of_type_Anby.a(this.jdField_h_of_type_Long, this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_c_of_type_Int, paramamvm, null);
        return;
      } while (this.jdField_a_of_type_Ange == null);
      this.jdField_a_of_type_Ange.a(paramamvm);
      return;
    } while (this.jdField_a_of_type_Ange == null);
    this.jdField_a_of_type_Ange.a(paramamvm);
  }
  
  /* Error */
  public void a(ancr paramancr, anbm paramanbm)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 532	anfx:jdField_e_of_type_Boolean	Z
    //   6: ifeq +13 -> 19
    //   9: aload_0
    //   10: getfield 533	anfx:jdField_a_of_type_Int	I
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
    //   27: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: aload_1
    //   35: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   38: putfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   41: aload_1
    //   42: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   45: ifnull +11 -> 56
    //   48: aload_0
    //   49: aload_1
    //   50: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   53: putfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   56: aload_2
    //   57: ifnull +8 -> 65
    //   60: aload_0
    //   61: aload_2
    //   62: putfield 508	anfx:jdField_a_of_type_Anbm	Lanbm;
    //   65: aload_0
    //   66: getfield 93	anfx:jdField_f_of_type_Long	J
    //   69: lconst_0
    //   70: lcmp
    //   71: ifeq +1510 -> 1581
    //   74: aload_0
    //   75: getfield 95	anfx:jdField_g_of_type_Long	J
    //   78: lconst_0
    //   79: lcmp
    //   80: ifeq +1501 -> 1581
    //   83: aload_1
    //   84: ifnull +590 -> 674
    //   87: aload_1
    //   88: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   91: ifnull +583 -> 674
    //   94: aload_1
    //   95: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   98: getfield 646	ancq:jdField_a_of_type_Int	I
    //   101: istore_3
    //   102: iload_3
    //   103: ifne +227 -> 330
    //   106: aconst_null
    //   107: ldc_w 1271
    //   110: ldc_w 396
    //   113: ldc_w 396
    //   116: ldc_w 1273
    //   119: ldc_w 1273
    //   122: iconst_0
    //   123: iconst_0
    //   124: aload_1
    //   125: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   128: getfield 648	ancq:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   131: getfield 457	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   134: ldc_w 799
    //   137: ldc_w 396
    //   140: ldc_w 396
    //   143: invokestatic 804	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   150: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   153: lconst_1
    //   154: invokestatic 970	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;J)Z
    //   157: ifne +323 -> 480
    //   160: aload_1
    //   161: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   164: getfield 648	ancq:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   167: astore_2
    //   168: ldc 168
    //   170: iconst_1
    //   171: new 170	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 1275
    //   181: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_2
    //   185: invokevirtual 650	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   188: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: ldc_w 1277
    //   194: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_2
    //   198: invokevirtual 1264	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   201: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: ldc_w 1279
    //   207: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 1281	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:h	()Z
    //   214: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   217: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_0
    //   224: getfield 532	anfx:jdField_e_of_type_Boolean	Z
    //   227: ifeq +36 -> 263
    //   230: aload_0
    //   231: getfield 533	anfx:jdField_a_of_type_Int	I
    //   234: iconst_2
    //   235: if_icmpne +28 -> 263
    //   238: aload_0
    //   239: getfield 511	anfx:jdField_a_of_type_Anby	Lanby;
    //   242: ifnull +21 -> 263
    //   245: aload_0
    //   246: getfield 511	anfx:jdField_a_of_type_Anby	Lanby;
    //   249: lconst_1
    //   250: new 317	amwo
    //   253: dup
    //   254: aload_2
    //   255: invokespecial 320	amwo:<init>	(Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;)V
    //   258: invokeinterface 1284 4 0
    //   263: aload_2
    //   264: invokevirtual 343	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:d	()Z
    //   267: ifne +269 -> 536
    //   270: aload_2
    //   271: invokevirtual 650	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   274: ifeq +213 -> 487
    //   277: aload_0
    //   278: lconst_1
    //   279: invokevirtual 972	anfx:a	(J)V
    //   282: aload_0
    //   283: lconst_1
    //   284: aload_2
    //   285: aload_1
    //   286: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   289: getfield 656	ancq:jdField_b_of_type_Int	I
    //   292: aload_1
    //   293: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   296: getfield 659	ancq:jdField_a_of_type_Float	F
    //   299: aload_1
    //   300: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   303: getfield 661	ancq:jdField_b_of_type_Float	F
    //   306: aload_1
    //   307: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   310: getfield 663	ancq:c	F
    //   313: invokespecial 666	anfx:a	(JLcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;IFFF)Z
    //   316: pop
    //   317: aload_2
    //   318: invokevirtual 358	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:j	()Z
    //   321: ifeq +9 -> 330
    //   324: aload_0
    //   325: iconst_0
    //   326: invokespecial 844	anfx:a	(Z)Z
    //   329: pop
    //   330: aload_1
    //   331: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   334: getfield 646	ancq:jdField_a_of_type_Int	I
    //   337: iconst_2
    //   338: if_icmpeq +16 -> 354
    //   341: aload_1
    //   342: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   345: getfield 648	ancq:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   348: invokevirtual 343	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:d	()Z
    //   351: ifeq +36 -> 387
    //   354: aload_0
    //   355: aload_1
    //   356: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   359: aload_0
    //   360: getfield 1286	anfx:jdField_b_of_type_Ancq	Lancq;
    //   363: invokespecial 1288	anfx:a	(Lancq;Lancq;)V
    //   366: aload_1
    //   367: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   370: getfield 646	ancq:jdField_a_of_type_Int	I
    //   373: iconst_2
    //   374: if_icmpeq +211 -> 585
    //   377: aload_0
    //   378: lconst_0
    //   379: putfield 218	anfx:jdField_i_of_type_Long	J
    //   382: aload_0
    //   383: lconst_0
    //   384: putfield 791	anfx:jdField_j_of_type_Long	J
    //   387: aload_1
    //   388: ifnull -369 -> 19
    //   391: aload_1
    //   392: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   395: ifnull +1353 -> 1748
    //   398: aload_0
    //   399: aload_1
    //   400: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   403: putfield 1286	anfx:jdField_b_of_type_Ancq	Lancq;
    //   406: aload_1
    //   407: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   410: getfield 648	ancq:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   413: ifnull -394 -> 19
    //   416: aload_1
    //   417: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   420: getfield 648	ancq:jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ArCloudConfigInfo;
    //   423: invokevirtual 343	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:d	()Z
    //   426: ifne -407 -> 19
    //   429: aload_0
    //   430: aconst_null
    //   431: putfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   434: aload_0
    //   435: aconst_null
    //   436: putfield 1286	anfx:jdField_b_of_type_Ancq	Lancq;
    //   439: goto -420 -> 19
    //   442: astore_1
    //   443: aload_0
    //   444: monitorexit
    //   445: aload_1
    //   446: athrow
    //   447: astore_2
    //   448: ldc 168
    //   450: iconst_1
    //   451: new 170	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 1290
    //   461: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_2
    //   465: invokevirtual 1293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   468: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -331 -> 146
    //   480: aload_0
    //   481: invokespecial 846	anfx:t	()V
    //   484: goto -324 -> 160
    //   487: aload_2
    //   488: invokevirtual 1281	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:h	()Z
    //   491: ifne +10 -> 501
    //   494: aload_2
    //   495: invokevirtual 1264	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   498: ifeq +31 -> 529
    //   501: aload_2
    //   502: invokevirtual 1264	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   505: ifeq -175 -> 330
    //   508: aload_0
    //   509: lconst_1
    //   510: invokevirtual 972	anfx:a	(J)V
    //   513: aload_2
    //   514: invokevirtual 358	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:j	()Z
    //   517: ifeq -187 -> 330
    //   520: aload_0
    //   521: iconst_1
    //   522: invokespecial 844	anfx:a	(Z)Z
    //   525: pop
    //   526: goto -196 -> 330
    //   529: aload_0
    //   530: invokespecial 556	anfx:w	()V
    //   533: goto -203 -> 330
    //   536: aload_2
    //   537: invokevirtual 650	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:f	()Z
    //   540: ifne -210 -> 330
    //   543: aload_2
    //   544: invokevirtual 1281	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:h	()Z
    //   547: ifne +10 -> 557
    //   550: aload_2
    //   551: invokevirtual 1264	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   554: ifeq -224 -> 330
    //   557: aload_2
    //   558: invokevirtual 1264	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:g	()Z
    //   561: ifeq -231 -> 330
    //   564: aload_0
    //   565: lconst_1
    //   566: invokevirtual 972	anfx:a	(J)V
    //   569: aload_2
    //   570: invokevirtual 358	com/tencent/mobileqq/ar/aidl/ArCloudConfigInfo:j	()Z
    //   573: ifeq -243 -> 330
    //   576: aload_0
    //   577: iconst_1
    //   578: invokespecial 844	anfx:a	(Z)Z
    //   581: pop
    //   582: goto -252 -> 330
    //   585: aload_0
    //   586: getfield 508	anfx:jdField_a_of_type_Anbm	Lanbm;
    //   589: ifnull +23 -> 612
    //   592: aload_0
    //   593: getfield 542	anfx:jdField_l_of_type_Boolean	Z
    //   596: ifeq +16 -> 612
    //   599: aload_0
    //   600: lconst_0
    //   601: putfield 218	anfx:jdField_i_of_type_Long	J
    //   604: aload_0
    //   605: lconst_0
    //   606: putfield 791	anfx:jdField_j_of_type_Long	J
    //   609: goto -222 -> 387
    //   612: aload_0
    //   613: getfield 218	anfx:jdField_i_of_type_Long	J
    //   616: lconst_0
    //   617: lcmp
    //   618: ifne +10 -> 628
    //   621: aload_0
    //   622: invokestatic 687	java/lang/System:currentTimeMillis	()J
    //   625: putfield 218	anfx:jdField_i_of_type_Long	J
    //   628: aload_0
    //   629: invokestatic 687	java/lang/System:currentTimeMillis	()J
    //   632: putfield 791	anfx:jdField_j_of_type_Long	J
    //   635: aload_0
    //   636: getfield 218	anfx:jdField_i_of_type_Long	J
    //   639: lconst_0
    //   640: lcmp
    //   641: ifle -254 -> 387
    //   644: aload_0
    //   645: getfield 791	anfx:jdField_j_of_type_Long	J
    //   648: aload_0
    //   649: getfield 218	anfx:jdField_i_of_type_Long	J
    //   652: lsub
    //   653: ldc2_w 689
    //   656: lcmp
    //   657: ifle -270 -> 387
    //   660: aload_0
    //   661: ldc2_w 1294
    //   664: putfield 218	anfx:jdField_i_of_type_Long	J
    //   667: aload_0
    //   668: invokespecial 556	anfx:w	()V
    //   671: goto -284 -> 387
    //   674: aload_1
    //   675: ifnull +385 -> 1060
    //   678: aload_1
    //   679: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   682: ifnull +378 -> 1060
    //   685: aload_0
    //   686: aload_0
    //   687: getfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   690: aload_0
    //   691: getfield 1297	anfx:jdField_b_of_type_Ancg	Lancg;
    //   694: invokespecial 1299	anfx:a	(Lancg;Lancg;)V
    //   697: iconst_0
    //   698: istore 5
    //   700: iconst_0
    //   701: istore 4
    //   703: aload_0
    //   704: getfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   707: getfield 1111	ancg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   710: invokevirtual 183	java/util/ArrayList:size	()I
    //   713: istore_3
    //   714: iload_3
    //   715: ifle +48 -> 763
    //   718: aload_0
    //   719: getfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   722: getfield 1111	ancg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   725: invokevirtual 442	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   728: astore_2
    //   729: iload 4
    //   731: istore 5
    //   733: aload_2
    //   734: invokeinterface 447 1 0
    //   739: ifeq +24 -> 763
    //   742: aload_2
    //   743: invokeinterface 451 1 0
    //   748: checkcast 1301	amxp
    //   751: getfield 1302	amxp:jdField_e_of_type_Boolean	Z
    //   754: ifne +1012 -> 1766
    //   757: iconst_1
    //   758: istore 4
    //   760: goto +1006 -> 1766
    //   763: invokestatic 610	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   766: ifeq +46 -> 812
    //   769: getstatic 613	ancc:jdField_a_of_type_Boolean	Z
    //   772: ifeq +40 -> 812
    //   775: ldc 168
    //   777: iconst_2
    //   778: new 170	java/lang/StringBuilder
    //   781: dup
    //   782: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   785: ldc_w 1304
    //   788: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: iload_3
    //   792: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: ldc_w 1306
    //   798: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: iload 5
    //   803: invokevirtual 438	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   806: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 617	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: iload 5
    //   814: ifeq +99 -> 913
    //   817: aconst_null
    //   818: ldc_w 1271
    //   821: ldc_w 396
    //   824: ldc_w 396
    //   827: ldc_w 1273
    //   830: ldc_w 1273
    //   833: iconst_0
    //   834: iconst_0
    //   835: aload_1
    //   836: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   839: getfield 1111	ancg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   842: iconst_0
    //   843: invokevirtual 199	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   846: checkcast 1301	amxp
    //   849: getfield 1307	amxp:jdField_a_of_type_Int	I
    //   852: invokestatic 1310	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   855: ldc_w 1312
    //   858: ldc_w 396
    //   861: ldc_w 396
    //   864: invokestatic 804	azqs:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload_0
    //   868: lconst_0
    //   869: putfield 1314	anfx:jdField_m_of_type_Long	J
    //   872: aload_0
    //   873: lconst_0
    //   874: putfield 1316	anfx:jdField_n_of_type_Long	J
    //   877: goto -490 -> 387
    //   880: astore_2
    //   881: ldc 168
    //   883: iconst_1
    //   884: new 170	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 1290
    //   894: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload_2
    //   898: invokevirtual 1293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   901: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: goto -43 -> 867
    //   913: ldc2_w 1317
    //   916: lstore 6
    //   918: invokestatic 1319	ancc:a	()Z
    //   921: ifeq +8 -> 929
    //   924: ldc2_w 1320
    //   927: lstore 6
    //   929: aload_0
    //   930: getfield 1314	anfx:jdField_m_of_type_Long	J
    //   933: lconst_0
    //   934: lcmp
    //   935: ifne +10 -> 945
    //   938: aload_0
    //   939: invokestatic 687	java/lang/System:currentTimeMillis	()J
    //   942: putfield 1314	anfx:jdField_m_of_type_Long	J
    //   945: aload_0
    //   946: invokestatic 687	java/lang/System:currentTimeMillis	()J
    //   949: putfield 1316	anfx:jdField_n_of_type_Long	J
    //   952: aload_0
    //   953: getfield 1314	anfx:jdField_m_of_type_Long	J
    //   956: lconst_0
    //   957: lcmp
    //   958: ifle -571 -> 387
    //   961: aload_0
    //   962: getfield 1316	anfx:jdField_n_of_type_Long	J
    //   965: aload_0
    //   966: getfield 1314	anfx:jdField_m_of_type_Long	J
    //   969: lsub
    //   970: lload 6
    //   972: lcmp
    //   973: ifle -586 -> 387
    //   976: invokestatic 610	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   979: ifeq +30 -> 1009
    //   982: ldc 168
    //   984: iconst_2
    //   985: new 170	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 1323
    //   995: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: lload 6
    //   1000: invokevirtual 301	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 617	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1009: aload_0
    //   1010: ldc2_w 583
    //   1013: invokevirtual 972	anfx:a	(J)V
    //   1016: aload_0
    //   1017: ldc2_w 1294
    //   1020: putfield 1314	anfx:jdField_m_of_type_Long	J
    //   1023: aload_0
    //   1024: getfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   1027: iconst_1
    //   1028: putfield 1324	ancg:jdField_a_of_type_Boolean	Z
    //   1031: aload_0
    //   1032: aload_0
    //   1033: getfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   1036: aload_0
    //   1037: getfield 1297	anfx:jdField_b_of_type_Ancg	Lancg;
    //   1040: invokespecial 1299	anfx:a	(Lancg;Lancg;)V
    //   1043: aload_0
    //   1044: aconst_null
    //   1045: putfield 1110	anfx:jdField_a_of_type_Ancg	Lancg;
    //   1048: aload_0
    //   1049: aconst_null
    //   1050: putfield 1297	anfx:jdField_b_of_type_Ancg	Lancg;
    //   1053: aload_0
    //   1054: invokespecial 1326	anfx:x	()V
    //   1057: goto -670 -> 387
    //   1060: aload_2
    //   1061: ifnull -674 -> 387
    //   1064: aload_0
    //   1065: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1068: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1071: aload_2
    //   1072: invokestatic 1329	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;Lanbm;)Lamuj;
    //   1075: astore 8
    //   1077: aload 8
    //   1079: getfield 1332	amuj:jdField_a_of_type_Long	J
    //   1082: lstore 6
    //   1084: aload 8
    //   1086: getfield 1333	amuj:jdField_a_of_type_Boolean	Z
    //   1089: istore 4
    //   1091: aload_0
    //   1092: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1095: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1098: lload 6
    //   1100: invokestatic 970	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;J)Z
    //   1103: istore 5
    //   1105: aload_0
    //   1106: getfield 514	anfx:jdField_a_of_type_Anct	Lanct;
    //   1109: ifnull +34 -> 1143
    //   1112: lload 6
    //   1114: ldc2_w 1013
    //   1117: lcmp
    //   1118: ifeq +25 -> 1143
    //   1121: aload_0
    //   1122: iconst_0
    //   1123: invokespecial 806	anfx:e	(Z)V
    //   1126: aload_0
    //   1127: getfield 1335	anfx:jdField_n_of_type_Boolean	Z
    //   1130: ifeq +13 -> 1143
    //   1133: aload_0
    //   1134: lconst_1
    //   1135: invokevirtual 587	anfx:b	(J)V
    //   1138: aload_0
    //   1139: iconst_0
    //   1140: putfield 1335	anfx:jdField_n_of_type_Boolean	Z
    //   1143: lload 6
    //   1145: lconst_0
    //   1146: lcmp
    //   1147: ifeq -760 -> 387
    //   1150: lload 6
    //   1152: ldc2_w 583
    //   1155: lcmp
    //   1156: ifne +81 -> 1237
    //   1159: iload 5
    //   1161: ifeq +14 -> 1175
    //   1164: aload_0
    //   1165: aload_2
    //   1166: getfield 1148	anbm:jdField_a_of_type_Anbo	Lanbo;
    //   1169: invokespecial 1337	anfx:a	(Lanbo;)V
    //   1172: goto -785 -> 387
    //   1175: aload_0
    //   1176: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1179: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1182: ldc2_w 1338
    //   1185: lconst_1
    //   1186: invokestatic 1342	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1189: ifeq +14 -> 1203
    //   1192: aload_0
    //   1193: aload_2
    //   1194: getfield 1148	anbm:jdField_a_of_type_Anbo	Lanbo;
    //   1197: invokespecial 1337	anfx:a	(Lanbo;)V
    //   1200: goto -813 -> 387
    //   1203: aload_0
    //   1204: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1207: ifnull +14 -> 1221
    //   1210: aload_0
    //   1211: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1214: getfield 646	ancq:jdField_a_of_type_Int	I
    //   1217: iconst_2
    //   1218: if_icmpne -831 -> 387
    //   1221: aload_0
    //   1222: lconst_1
    //   1223: invokevirtual 972	anfx:a	(J)V
    //   1226: aload_0
    //   1227: aload_2
    //   1228: getfield 1148	anbm:jdField_a_of_type_Anbo	Lanbo;
    //   1231: invokespecial 1337	anfx:a	(Lanbo;)V
    //   1234: goto -847 -> 387
    //   1237: lload 6
    //   1239: ldc2_w 344
    //   1242: lcmp
    //   1243: ifne +81 -> 1324
    //   1246: iload 5
    //   1248: ifeq +14 -> 1262
    //   1251: aload_0
    //   1252: aload_2
    //   1253: getfield 1136	anbm:jdField_a_of_type_Anbc	Lanbc;
    //   1256: invokespecial 1344	anfx:a	(Lanbc;)V
    //   1259: goto -872 -> 387
    //   1262: aload_0
    //   1263: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1266: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1269: ldc2_w 344
    //   1272: lconst_1
    //   1273: invokestatic 1342	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1276: ifeq +14 -> 1290
    //   1279: aload_0
    //   1280: aload_2
    //   1281: getfield 1136	anbm:jdField_a_of_type_Anbc	Lanbc;
    //   1284: invokespecial 1344	anfx:a	(Lanbc;)V
    //   1287: goto -900 -> 387
    //   1290: aload_0
    //   1291: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1294: ifnull +14 -> 1308
    //   1297: aload_0
    //   1298: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1301: getfield 646	ancq:jdField_a_of_type_Int	I
    //   1304: iconst_2
    //   1305: if_icmpne -918 -> 387
    //   1308: aload_0
    //   1309: lconst_1
    //   1310: invokevirtual 972	anfx:a	(J)V
    //   1313: aload_0
    //   1314: aload_2
    //   1315: getfield 1136	anbm:jdField_a_of_type_Anbc	Lanbc;
    //   1318: invokespecial 1344	anfx:a	(Lanbc;)V
    //   1321: goto -934 -> 387
    //   1324: lload 6
    //   1326: ldc2_w 1013
    //   1329: lcmp
    //   1330: ifne +120 -> 1450
    //   1333: iload 5
    //   1335: ifeq +14 -> 1349
    //   1338: aload_0
    //   1339: aload_2
    //   1340: getfield 1142	anbm:jdField_a_of_type_Anct	Lanct;
    //   1343: invokespecial 1346	anfx:a	(Lanct;)V
    //   1346: goto -959 -> 387
    //   1349: aload_0
    //   1350: getfield 842	anfx:jdField_o_of_type_Boolean	Z
    //   1353: ifeq +30 -> 1383
    //   1356: aload_0
    //   1357: getfield 514	anfx:jdField_a_of_type_Anct	Lanct;
    //   1360: ifnull +8 -> 1368
    //   1363: aload_0
    //   1364: iconst_0
    //   1365: invokespecial 806	anfx:e	(Z)V
    //   1368: aload_0
    //   1369: getfield 1335	anfx:jdField_n_of_type_Boolean	Z
    //   1372: ifeq -1353 -> 19
    //   1375: aload_0
    //   1376: iconst_0
    //   1377: putfield 1335	anfx:jdField_n_of_type_Boolean	Z
    //   1380: goto -1361 -> 19
    //   1383: aload_0
    //   1384: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1387: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1390: ldc2_w 1013
    //   1393: lconst_1
    //   1394: invokestatic 1342	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1397: ifeq +14 -> 1411
    //   1400: aload_0
    //   1401: aload_2
    //   1402: getfield 1142	anbm:jdField_a_of_type_Anct	Lanct;
    //   1405: invokespecial 1346	anfx:a	(Lanct;)V
    //   1408: goto -1021 -> 387
    //   1411: aload_0
    //   1412: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1415: ifnull +14 -> 1429
    //   1418: aload_0
    //   1419: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1422: getfield 646	ancq:jdField_a_of_type_Int	I
    //   1425: iconst_2
    //   1426: if_icmpne -1039 -> 387
    //   1429: aload_0
    //   1430: lconst_1
    //   1431: invokevirtual 972	anfx:a	(J)V
    //   1434: aload_0
    //   1435: iconst_1
    //   1436: putfield 1335	anfx:jdField_n_of_type_Boolean	Z
    //   1439: aload_0
    //   1440: aload_2
    //   1441: getfield 1142	anbm:jdField_a_of_type_Anct	Lanct;
    //   1444: invokespecial 1346	anfx:a	(Lanct;)V
    //   1447: goto -1060 -> 387
    //   1450: lload 6
    //   1452: lconst_1
    //   1453: lcmp
    //   1454: ifne +40 -> 1494
    //   1457: iload 5
    //   1459: ifeq +14 -> 1473
    //   1462: aload_0
    //   1463: aload_2
    //   1464: getfield 1128	anbm:jdField_a_of_type_Anax	Lanax;
    //   1467: invokespecial 1348	anfx:a	(Lanax;)V
    //   1470: goto -1083 -> 387
    //   1473: iload 4
    //   1475: ifeq +8 -> 1483
    //   1478: aload_0
    //   1479: lconst_1
    //   1480: invokevirtual 587	anfx:b	(J)V
    //   1483: aload_0
    //   1484: aload_2
    //   1485: getfield 1128	anbm:jdField_a_of_type_Anax	Lanax;
    //   1488: invokespecial 1348	anfx:a	(Lanax;)V
    //   1491: goto -1104 -> 387
    //   1494: lload 6
    //   1496: ldc2_w 346
    //   1499: lcmp
    //   1500: ifne -1113 -> 387
    //   1503: iload 5
    //   1505: ifeq +14 -> 1519
    //   1508: aload_0
    //   1509: aload_2
    //   1510: getfield 1154	anbm:jdField_a_of_type_Anbu	Lanbu;
    //   1513: invokespecial 1350	anfx:a	(Lanbu;)V
    //   1516: goto -1129 -> 387
    //   1519: aload_0
    //   1520: getfield 960	anfx:jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo	Lcom/tencent/mobileqq/ar/aidl/ARCommonConfigInfo;
    //   1523: getfield 965	com/tencent/mobileqq/ar/aidl/ARCommonConfigInfo:recognitions	Ljava/util/ArrayList;
    //   1526: ldc2_w 346
    //   1529: lconst_1
    //   1530: invokestatic 1342	com/tencent/mobileqq/ar/ARRecognition:a	(Ljava/util/ArrayList;JJ)Z
    //   1533: ifeq +14 -> 1547
    //   1536: aload_0
    //   1537: aload_2
    //   1538: getfield 1154	anbm:jdField_a_of_type_Anbu	Lanbu;
    //   1541: invokespecial 1350	anfx:a	(Lanbu;)V
    //   1544: goto -1157 -> 387
    //   1547: aload_0
    //   1548: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1551: ifnull +14 -> 1565
    //   1554: aload_0
    //   1555: getfield 1108	anfx:jdField_a_of_type_Ancq	Lancq;
    //   1558: getfield 646	ancq:jdField_a_of_type_Int	I
    //   1561: iconst_2
    //   1562: if_icmpne -1175 -> 387
    //   1565: aload_0
    //   1566: lconst_1
    //   1567: invokevirtual 972	anfx:a	(J)V
    //   1570: aload_0
    //   1571: aload_2
    //   1572: getfield 1154	anbm:jdField_a_of_type_Anbu	Lanbu;
    //   1575: invokespecial 1350	anfx:a	(Lanbu;)V
    //   1578: goto -1191 -> 387
    //   1581: aload_0
    //   1582: getfield 93	anfx:jdField_f_of_type_Long	J
    //   1585: lconst_0
    //   1586: lcmp
    //   1587: ifeq +51 -> 1638
    //   1590: aload_1
    //   1591: ifnull -1572 -> 19
    //   1594: aload_1
    //   1595: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   1598: ifnull +18 -> 1616
    //   1601: aload_0
    //   1602: aload_1
    //   1603: getfield 1245	ancr:jdField_a_of_type_Ancq	Lancq;
    //   1606: aload_0
    //   1607: getfield 1286	anfx:jdField_b_of_type_Ancq	Lancq;
    //   1610: invokespecial 1288	anfx:a	(Lancq;Lancq;)V
    //   1613: goto -1226 -> 387
    //   1616: aload_1
    //   1617: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   1620: ifnull -1233 -> 387
    //   1623: aload_0
    //   1624: aload_1
    //   1625: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   1628: aload_0
    //   1629: getfield 1297	anfx:jdField_b_of_type_Ancg	Lancg;
    //   1632: invokespecial 1299	anfx:a	(Lancg;Lancg;)V
    //   1635: goto -1248 -> 387
    //   1638: aload_0
    //   1639: getfield 95	anfx:jdField_g_of_type_Long	J
    //   1642: lconst_0
    //   1643: lcmp
    //   1644: ifeq -1257 -> 387
    //   1647: aload_2
    //   1648: ifnull -1629 -> 19
    //   1651: aload_2
    //   1652: getfield 1136	anbm:jdField_a_of_type_Anbc	Lanbc;
    //   1655: invokestatic 1141	anbc:a	(Lanbc;)Z
    //   1658: ifeq +14 -> 1672
    //   1661: aload_0
    //   1662: aload_2
    //   1663: getfield 1136	anbm:jdField_a_of_type_Anbc	Lanbc;
    //   1666: invokespecial 1344	anfx:a	(Lanbc;)V
    //   1669: goto -1282 -> 387
    //   1672: aload_2
    //   1673: getfield 1142	anbm:jdField_a_of_type_Anct	Lanct;
    //   1676: invokestatic 1145	anct:a	(Lanaz;)Z
    //   1679: ifeq +14 -> 1693
    //   1682: aload_0
    //   1683: aload_2
    //   1684: getfield 1142	anbm:jdField_a_of_type_Anct	Lanct;
    //   1687: invokespecial 1346	anfx:a	(Lanct;)V
    //   1690: goto -1303 -> 387
    //   1693: aload_2
    //   1694: getfield 1128	anbm:jdField_a_of_type_Anax	Lanax;
    //   1697: invokestatic 1133	anax:a	(Lanax;)Z
    //   1700: ifeq +10 -> 1710
    //   1703: aload_0
    //   1704: invokespecial 556	anfx:w	()V
    //   1707: goto -1320 -> 387
    //   1710: aload_2
    //   1711: getfield 1148	anbm:jdField_a_of_type_Anbo	Lanbo;
    //   1714: invokestatic 1151	anbo:a	(Lanbo;)Z
    //   1717: ifeq +10 -> 1727
    //   1720: aload_0
    //   1721: invokespecial 1326	anfx:x	()V
    //   1724: goto -1337 -> 387
    //   1727: aload_2
    //   1728: getfield 1154	anbm:jdField_a_of_type_Anbu	Lanbu;
    //   1731: invokestatic 1159	anbu:a	(Lanbu;)Z
    //   1734: ifeq -1347 -> 387
    //   1737: aload_0
    //   1738: aload_2
    //   1739: getfield 1154	anbm:jdField_a_of_type_Anbu	Lanbu;
    //   1742: invokespecial 1350	anfx:a	(Lanbu;)V
    //   1745: goto -1358 -> 387
    //   1748: aload_1
    //   1749: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   1752: ifnull -1733 -> 19
    //   1755: aload_0
    //   1756: aload_1
    //   1757: getfield 1246	ancr:jdField_a_of_type_Ancg	Lancg;
    //   1760: putfield 1297	anfx:jdField_b_of_type_Ancg	Lancg;
    //   1763: goto -1744 -> 19
    //   1766: goto -1037 -> 729
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1769	0	this	anfx
    //   0	1769	1	paramancr	ancr
    //   0	1769	2	paramanbm	anbm
    //   13	779	3	i1	int
    //   701	773	4	bool1	boolean
    //   698	806	5	bool2	boolean
    //   916	579	6	l1	long
    //   1075	10	8	localamuj	amuj
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
    //   1727	1745	442	finally
    //   1748	1763	442	finally
    //   106	146	447	java/lang/Exception
    //   817	867	880	java/lang/Exception
  }
  
  public void a(Context arg1, AppInterface paramAppInterface)
  {
    super.a(???, paramAppInterface);
    System.currentTimeMillis();
    QLog.d("AREngine_QQARSession", 1, String.format("init context=%s appInterface=%s mIsInited=%s", new Object[] { ???, paramAppInterface, Boolean.valueOf(this.jdField_e_of_type_Boolean) }));
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Amwk = new amwk();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("AREngineThread", 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      }
      this.jdField_e_of_type_Boolean = true;
      return;
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_QQARSession", 2, "onCommonCallbackFromManager, resourceInfo=" + paramArCloudConfigInfo + ", action=" + paramInt1 + ", result=" + paramInt2 + " ,data=" + paramObject);
    }
    a(new QQARSession.26(this, paramArCloudConfigInfo, paramInt1, paramInt2, paramObject));
  }
  
  public void a(ArVideoResourceInfo paramArVideoResourceInfo, amvj paramamvj)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onMultiARAnimationInteraction.");
    a(new QQARSession.25(this, paramArVideoResourceInfo, paramamvj));
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Int == 2)) {
      b(paramRunnable, paramLong);
    }
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
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int != 2)) {}
  }
  
  public void a(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.i("AREngine_QQARSession", 1, String.format("onARMarkerAllDownloadComplete result=%s config=%s", new Object[] { Boolean.valueOf(paramBoolean), paramArCloudConfigInfo }));
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.f()))
    {
      this.jdField_a_of_type_Anby.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_c_of_type_Int = 1;
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      return;
    }
    d(paramBoolean, paramArCloudConfigInfo);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    if (this.jdField_a_of_type_Ange != null) {
      this.jdField_a_of_type_Ange.a(0, paramArrayOfFloat);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(anct paramanct)
  {
    return (this.jdField_a_of_type_Anct == null) || (!this.jdField_a_of_type_Anct.a(paramanct));
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
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
      this.jdField_a_of_type_Anby.a(2, paramInt);
    }
  }
  
  public void b(long paramLong)
  {
    QLog.d("AREngine_QQARSession", 1, "resumeLocalRecog. recogType = " + paramLong);
    if (this.jdField_a_of_type_Anca != null)
    {
      if ((1L & paramLong) != 0L)
      {
        this.jdField_a_of_type_Ancq = null;
        this.jdField_b_of_type_Ancq = null;
        this.jdField_i_of_type_Long = 0L;
        this.jdField_j_of_type_Long = 0L;
        this.jdField_k_of_type_Long = 0L;
        this.jdField_l_of_type_Long = 0L;
      }
      if ((0x4 & paramLong) != 0L)
      {
        this.jdField_a_of_type_Ancg = null;
        this.jdField_b_of_type_Ancg = null;
        this.jdField_m_of_type_Long = 0L;
        this.jdField_n_of_type_Long = 0L;
      }
      this.jdField_a_of_type_Anca.b(paramLong);
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
    if ((paramBoolean) && (this.jdField_t_of_type_Boolean))
    {
      this.jdField_t_of_type_Boolean = false;
      azqs.b(null, "dc00898", "", "", "0X80085AD", "0X80085AD", 0, 0, "", "", "", "");
    }
  }
  
  public void b(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.f()))
    {
      this.jdField_a_of_type_Anby.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      this.jdField_c_of_type_Int = 2;
      return;
    }
    e(paramBoolean, paramArCloudConfigInfo);
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int c()
  {
    QLog.d("AREngine_QQARSession", 1, "start startInternal. mCurEngineState = " + this.jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_Int != 0) || (!anft.a().b())) {
      return -1;
    }
    this.jdField_o_of_type_Int = 0;
    this.jdField_o_of_type_Long = System.currentTimeMillis();
    this.jdField_p_of_type_Long = 0L;
    this.jdField_p_of_type_Int = 0;
    this.jdField_q_of_type_Long = 0L;
    this.jdField_r_of_type_Long = 0L;
    this.jdField_l_of_type_Int = anft.a().a();
    this.jdField_m_of_type_Int = anft.a().b();
    this.jdField_n_of_type_Int = anft.a().c();
    this.jdField_k_of_type_Int = angf.jdField_b_of_type_Int;
    this.jdField_j_of_type_Int = angf.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = new ARNativeBridge();
    if (!this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge.isLoadSoSuccess())
    {
      QLog.d("AREngine_QQARSession", 1, "startAR internal fail");
      this.jdField_a_of_type_ComTencentMobileqqArARNativeBridge = null;
      this.jdField_f_of_type_Boolean = false;
      e(6);
      return 6;
    }
    g();
    this.jdField_a_of_type_Amwk.a(this.jdField_a_of_type_AndroidContentContext, this);
    if ((this.jdField_a_of_type_Anca != null) && (!h()))
    {
      e(7);
      return 7;
    }
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(5L);
    }
    while ((this.jdField_a_of_type_Anam != null) && (!i()))
    {
      e(3);
      return 3;
      a(4L);
      b(1L);
    }
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Ange.a(this);
    e(0);
    return 0;
  }
  
  public void c()
  {
    QLog.i("AREngine_QQARSession", 1, "onARCloudUploadStart.");
    this.jdField_q_of_type_Int += 1;
  }
  
  public void c(int paramInt)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
      this.jdField_a_of_type_Anby.a(2, paramInt);
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    QLog.i("AREngine_QQARSession", 1, "onRenderManagerCallback. onARAnimationPlayInterrupt. key = " + paramString + ", remainPlayCount = " + paramInt);
    a(new QQARSession.23(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Anbm != null) && (this.jdField_a_of_type_Anbm.jdField_a_of_type_Anct != null)) {
      a(new QQARSession.9(this, paramBoolean));
    }
  }
  
  public void c(boolean paramBoolean, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if ((paramBoolean) && (paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo != null) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) && (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)) && (!paramArCloudConfigInfo.f()))
    {
      this.jdField_a_of_type_Anby.a(0, paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
      this.jdField_c_of_type_Int = 2;
      return;
    }
    f(paramBoolean, paramArCloudConfigInfo);
  }
  
  public boolean c()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void d()
  {
    QLog.i("AREngine_QQARSession", 1, "onARMarkerAllDownloadStart.");
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Anby != null)) {
      this.jdField_a_of_type_Anby.a(0, 4);
    }
  }
  
  public void d(int paramInt)
  {
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus on workMode=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 1) && (this.jdField_r_of_type_Int != paramInt)) {
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
      b(new QQARSession.14(this, paramBoolean, paramArCloudConfigInfo), l1);
      return;
    }
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null;
  }
  
  public void e()
  {
    QLog.i("AREngine_QQARSession", 1, "onARObjectClassifyDownloadStart.");
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    a(new QQARSession.15(this));
  }
  
  public boolean e()
  {
    QLog.i("AREngine_QQARSession", 1, "stopInternal.");
    this.jdField_d_of_type_Boolean = true;
    z();
    j();
    k();
    this.jdField_a_of_type_Ancq = null;
    this.jdField_b_of_type_Ancq = null;
    this.jdField_a_of_type_Ancg = null;
    this.jdField_b_of_type_Ancg = null;
    this.jdField_a_of_type_Anbm = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    return true;
  }
  
  public void f()
  {
    QLog.i("AREngine_QQARSession", 1, "onARSceneRecogDownloadStart.");
    this.jdField_s_of_type_Long = System.currentTimeMillis();
    a(new QQARSession.17(this));
  }
  
  public void g()
  {
    QLog.d("AREngine_QQARSession", 1, "ARengine status resume now start. + mCurrentSessionStatus:=" + this.jdField_a_of_type_Int);
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 4) || (this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 2)) {
      return;
    }
    this.jdField_a_of_type_Ange.a(this);
    a(this.jdField_p_of_type_Boolean);
    this.jdField_a_of_type_Ancq = null;
    this.jdField_b_of_type_Ancq = null;
    this.jdField_a_of_type_Ancg = null;
    this.jdField_b_of_type_Ancg = null;
    this.jdField_a_of_type_Anbm = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_Anct = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_r_of_type_Int == 1))
    {
      b(4096L);
      this.jdField_a_of_type_Anca.a(true, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 2;
      return;
    }
    u();
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {
      a(5L);
    }
    for (;;)
    {
      this.jdField_g_of_type_Boolean = true;
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
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_Int != 2)) {
      return;
    }
    z();
    k();
    t();
    if ((this.jdField_a_of_type_Anca != null) && (!this.jdField_a_of_type_Anca.a(4L))) {}
    for (boolean bool = true;; bool = false)
    {
      a(5L);
      if ((bool) && (this.jdField_a_of_type_Anby != null)) {
        this.jdField_a_of_type_Anby.a(bool);
      }
      this.jdField_o_of_type_Boolean = true;
      if (this.jdField_a_of_type_Anct != null) {
        e(true);
      }
      this.jdField_r_of_type_Boolean = false;
      A();
      if ((this.jdField_a_of_type_Anca != null) && (this.jdField_r_of_type_Int == 1))
      {
        a(4096L);
        this.jdField_a_of_type_Anca.a(false, this.jdField_l_of_type_Int, this.jdField_m_of_type_Int);
      }
      if (this.jdField_a_of_type_Andc != null) {
        this.jdField_a_of_type_Andc.b();
      }
      this.jdField_g_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Ange.a(null);
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
    s();
    a(new QQARSession.3(this));
  }
  
  public void j()
  {
    QLog.i("AREngine_QQARSession", 1, "uninit start. mIsInited = " + this.jdField_e_of_type_Boolean);
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    anft.a().c(this);
    a(new QQARSession.4(this));
  }
  
  public void k()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRender.");
    if ((this.jdField_a_of_type_Ange != null) && (this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null))
    {
      this.jdField_a_of_type_Ange.d();
      if (anft.a().b()) {
        anft.a().a(this.jdField_j_of_type_Int, this.jdField_k_of_type_Int);
      }
      if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Anby != null) && ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4)))
      {
        amwo localamwo = new amwo(this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        this.jdField_a_of_type_Anby.a(this.jdField_h_of_type_Long, false, localamwo);
      }
    }
    this.jdField_h_of_type_Long = 0L;
    this.jdField_c_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
    this.jdField_d_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public void l()
  {
    QLog.d("AREngine_QQARSession", 1, "stopModelRenderOnly.");
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_Ange != null)) {
      this.jdField_a_of_type_Ange.d();
    }
  }
  
  public void m()
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
  
  public void n()
  {
    QLog.i("AREngine_QQARSession", 1, "onProcessMigCloudObjectClassifyResultComplete.");
    if (!ARRecognition.a(this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo.recognitions, 1L)) {}
    for (;;)
    {
      this.jdField_a_of_type_Anct = null;
      y();
      return;
      b(1L);
      this.jdField_n_of_type_Boolean = false;
    }
  }
  
  public void o()
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
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Ange != null))
    {
      if ((!this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Int != 2)) {
        break label371;
      }
      this.jdField_a_of_type_Ange.a(this.jdField_a_of_type_Ange.a() + 1L);
      if ((this.jdField_a_of_type_Anca == null) || ((this.jdField_a_of_type_Anca.a(1L)) && (this.jdField_a_of_type_Anca.a(4L)) && (this.jdField_a_of_type_Anca.a(4096L))) || (l())) {
        break label334;
      }
      if ((this.jdField_r_of_type_Int == 0) || ((this.jdField_r_of_type_Int == 1) && (this.jdField_a_of_type_Amtj.a() == 0) && (this.jdField_a_of_type_Amtj.b()))) {
        this.jdField_a_of_type_Anca.a(this.jdField_a_of_type_Ange.a(), paramArrayOfByte);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label209;
      }
      this.jdField_a_of_type_Ange.b(this.jdField_a_of_type_Ange.a());
      if (this.jdField_a_of_type_Ange != null) {
        this.jdField_a_of_type_Ange.a();
      }
    }
    label209:
    label371:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Anam != null) {
          this.jdField_a_of_type_Anam.a(paramArrayOfByte);
        }
        return;
        if (((!this.jdField_a_of_type_Anca.a(1L)) && (this.jdField_a_of_type_Ancq != null) && (this.jdField_a_of_type_Ancq.jdField_a_of_type_Int == 2)) || ((!this.jdField_a_of_type_Anca.a(4L)) && (this.jdField_a_of_type_Ancg != null) && (this.jdField_a_of_type_Ancg.jdField_a_of_type_JavaUtilArrayList.size() == 0)) || ((!this.jdField_a_of_type_Anca.a(4L)) && (this.jdField_a_of_type_Anca.b(4L))))
        {
          this.jdField_a_of_type_Ange.b(this.jdField_a_of_type_Ange.a());
          if (this.jdField_a_of_type_Ange != null)
          {
            this.jdField_a_of_type_Ange.a();
            continue;
            this.jdField_a_of_type_Ange.b(this.jdField_a_of_type_Ange.a());
            if (this.jdField_a_of_type_Ange != null) {
              this.jdField_a_of_type_Ange.a();
            }
          }
        }
      }
      this.jdField_a_of_type_Ange.a(this.jdField_a_of_type_Ange.a() + 1L);
      this.jdField_a_of_type_Ange.b(this.jdField_a_of_type_Ange.a());
    } while (this.jdField_a_of_type_Ange == null);
    label334:
    this.jdField_a_of_type_Ange.a();
  }
  
  public void p()
  {
    QLog.d("AREngine_QQARSession", 1, "engine notifyRenderReady ");
    if (this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo == null) || (!this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_b_of_type_Boolean) || (!this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArWebInfo.jdField_a_of_type_JavaLangString)));
      if (this.jdField_c_of_type_Int == 1)
      {
        d(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
        return;
      }
    } while (this.jdField_c_of_type_Int != 2);
    e(true, this.jdField_b_of_type_ComTencentMobileqqArAidlArCloudConfigInfo);
  }
  
  public void q()
  {
    QLog.d("AREngine_QQARSession", 1, String.format("CloseAREngineRecoglizeFunction  ", new Object[0]));
    a(new QQARSession.27(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfx
 * JD-Core Version:    0.7.0.1
 */