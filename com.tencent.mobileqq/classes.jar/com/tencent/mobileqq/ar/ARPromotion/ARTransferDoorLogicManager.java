package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.PointF;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircle;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARGestureResult;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ARTransferDoorLogicManager
  implements ARPhonePoseDetectManager.PhonePoseDetectListener
{
  public static final String a = "ARTransferDoorLogicManager";
  public final int a;
  private long jdField_a_of_type_Long = 0L;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ARPhonePoseDetectManager jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager;
  private ARTransferDoorLogicManager.RenderProxy jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
  volatile ARTransferDoorVideoInfo.PlayGuideShowInfo jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorVideoInfo$PlayGuideShowInfo = null;
  private ARTransferPromotionUIContainer jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferPromotionUIContainer;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  private ARLocalGestureCircleRecogResult jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult = new ARLocalGestureCircleRecogResult();
  public ARScanEntryView a;
  public WeakReference<QQARSession> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean = false;
  public final int b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  public final int c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  public final int d;
  private String d;
  public final int e = 5;
  public final int f = 6;
  public int g = 1;
  private volatile int h = -1;
  private int i = 0;
  private int j = 15;
  
  public ARTransferDoorLogicManager()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 2;
    this.jdField_c_of_type_Int = 3;
    this.jdField_d_of_type_Int = 4;
    this.jdField_d_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a()
  {
    ARTransferPromotionUIContainer localARTransferPromotionUIContainer = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferPromotionUIContainer;
    if (localARTransferPromotionUIContainer != null) {
      localARTransferPromotionUIContainer.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy = null;
    f();
    this.h = -1;
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setGamePlayMode mode ");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "setRecogRes");
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    if (localRenderProxy != null)
    {
      localRenderProxy.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "setRecogRes failed.");
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager = new ARPhonePoseDetectManager(paramScanTorchActivity);
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager.a(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy != null) && (paramRelativeLayout != null))
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init ");
      localStringBuilder.append(paramRelativeLayout.getChildCount());
      QLog.d(paramAppInterface, 2, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    else
    {
      paramAppInterface = jdField_a_of_type_JavaLangString;
      paramRelativeLayout = new StringBuilder();
      paramRelativeLayout.append("init ");
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy != null) {
        bool = true;
      } else {
        bool = false;
      }
      paramRelativeLayout.append(bool);
      QLog.d(paramAppInterface, 2, paramRelativeLayout.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferPromotionUIContainer = new ARTransferPromotionUIContainer(paramScanTorchActivity);
  }
  
  public void a(ARTransferDoorLogicManager.RenderProxy paramRenderProxy)
  {
    if (paramRenderProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy = paramRenderProxy;
      paramRenderProxy = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (paramRenderProxy != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.a(paramRenderProxy);
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.b();
      int k;
      if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.c()) {
        k = 1;
      } else {
        k = 2;
      }
      this.g = k;
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.a();
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRenderTransferGame config ");
    localStringBuilder.append(paramArCloudConfigInfo);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
    }
    localObject = paramArCloudConfigInfo;
    if (paramArCloudConfigInfo == null)
    {
      localObject = paramArCloudConfigInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)
      {
        localObject = paramArCloudConfigInfo;
        if (a()) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        }
      }
    }
    paramArCloudConfigInfo = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((paramArCloudConfigInfo != null) && (paramArCloudConfigInfo.get() != null)) {
      ((QQARSession)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(4096L, (ArCloudConfigInfo)localObject);
    }
  }
  
  public void a(ARLocalGestureCircleRecogResult paramARLocalGestureCircleRecogResult, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "processInternalGestureRecogResult");
    if (!b()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processInternalGestureRecogResult into Error status");
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult = paramARLocalGestureCircleRecogResult;
    int k;
    if (this.jdField_a_of_type_Long > 0L) {
      k = 0;
    } else {
      k = 1;
    }
    int m;
    int n;
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int > 0))
    {
      f();
      if (k != 0)
      {
        c(4);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processInternalGestureRecogResult start draw circle");
      }
      paramARLocalGestureCircleRecogResult = ARLocalGestureCircleRecog.a(paramInt1, paramInt2, paramInt3, paramInt4, new PointF(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.b, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.c));
      m = (int)(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Float / paramInt2 * paramInt3);
      n = (int)paramARLocalGestureCircleRecogResult.x;
      int i1 = (int)paramARLocalGestureCircleRecogResult.y;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircle.jdField_a_of_type_Boolean) {
        k = 1;
      } else {
        k = -1;
      }
      a(m, n, i1, k);
      b(1);
      ARVideoRecordUIControllerImpl.a().a(6);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.g = 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_d_of_type_Int)
    {
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_d_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_d_of_type_Int == 0)
        {
          k = 1;
          n = 0;
          bool = true;
          m = k;
          k = n;
        }
        else
        {
          k = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_d_of_type_Int;
          m = 1;
        }
      }
      else {
        for (;;)
        {
          bool = false;
          break label392;
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int >= 1) {
            k = 1;
          } else {
            k = 0;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_d_of_type_Int < 1) {
            break;
          }
          n = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_d_of_type_Int;
          m = k;
          k = n;
        }
      }
      label392:
      if (m != 0)
      {
        Object localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARGestureResult.jdField_d_of_type_Int == 1)
        {
          paramARLocalGestureCircleRecogResult = new int[this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - k];
          localObject1 = new int[this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - k];
          localObject2 = new int[this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int - k];
          paramInt2 = k;
          while (paramInt2 < this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int)
          {
            PointF localPointF = ARLocalGestureCircleRecog.a(paramInt1, paramInt1, paramInt3, paramInt4, this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[paramInt2]);
            m = paramInt2 - k;
            paramARLocalGestureCircleRecogResult[m] = ((int)localPointF.x);
            localObject1[m] = ((int)localPointF.y);
            localObject2[m] = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_ArrayOfInt[paramInt2];
            paramInt2 += 1;
          }
          a(paramARLocalGestureCircleRecogResult, (int[])localObject1, (int[])localObject2, bool);
        }
        else
        {
          this.i = 0;
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = false;
            paramARLocalGestureCircleRecogResult = new ARTransferDoorLogicManager.1(this, paramInt1, paramInt2, paramInt3, paramInt4);
            localObject1 = jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("DrawCircle. resume. mDrawCirclePuase = ");
            ((StringBuilder)localObject2).append(this.jdField_c_of_type_Boolean);
            ((StringBuilder)localObject2).append(", genIdx = ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.g);
            QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
            localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
            if ((localObject1 != null) && (((WeakReference)localObject1).get() != null) && (!this.jdField_c_of_type_Boolean)) {
              ((QQARSession)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(paramARLocalGestureCircleRecogResult, this.j);
            }
          }
        }
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_c_of_type_Int > 0))
    {
      this.jdField_c_of_type_Boolean = true;
      d();
      c(3);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramARLocalGestureCircleRecogResult = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramARLocalGestureCircleRecogResult != null) && (paramARLocalGestureCircleRecogResult.get() != null)) {
        ((QQARSession)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(new ARTransferDoorLogicManager.2(this), 1000L);
      }
    }
    paramARLocalGestureCircleRecogResult = jdField_a_of_type_JavaLangString;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("zoomOutWorldCupSparks curent state ");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int);
    QLog.i(paramARLocalGestureCircleRecogResult, 1, ((StringBuilder)localObject1).toString());
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecogResult$ARCircleResult.jdField_b_of_type_Int != 0))
    {
      c(5);
      b(2);
      ThreadManager.getSubThreadHandler().post(new ARTransferDoorLogicManager.3(this));
      paramARLocalGestureCircleRecogResult = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((paramARLocalGestureCircleRecogResult != null) && (paramARLocalGestureCircleRecogResult.get() != null)) {
        ((QQARSession)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(new ARTransferDoorLogicManager.4(this), 1500L);
      }
    }
  }
  
  public void a(QQARSession paramQQARSession)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQARSession);
  }
  
  public void a(boolean paramBoolean)
  {
    b();
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
      if ((localObject != null) && (this.g == 1))
      {
        if (((ARTransferDoorLogicManager.RenderProxy)localObject).b())
        {
          c(6);
          this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.a();
          this.h = -1;
        }
        else
        {
          this.h = 0;
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy != null) && (this.g == 2))
      {
        c(2);
        this.h = 0;
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy == null)
      {
        c(2);
        this.h = 0;
      }
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPhonePoseChaned standBy SUCCESS with mode: ");
      localStringBuilder.append(this.g);
      localStringBuilder.append("-mCurrentPoseStatus:");
      localStringBuilder.append(this.h);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    if ((localObject != null) && (((ARTransferDoorLogicManager.RenderProxy)localObject).b()) && (this.g == 1)) {
      c(1);
    } else if (this.g == 2) {
      c(1);
    }
    this.h = 1;
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPhonePoseChaned standBy FAIL with mode: ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("-mCurrentPoseStatus:");
    localStringBuilder.append(this.h);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateUITipsMessage ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(";");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    if ((this.jdField_a_of_type_Boolean == paramBoolean) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.6(this, paramString));
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.7(this));
  }
  
  public void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, boolean paramBoolean)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "insertWorldCupSpark start.");
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    if ((localRenderProxy != null) && (localRenderProxy.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramBoolean);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "insertWorldCupSpark failed.");
  }
  
  public boolean a()
  {
    return this.g == 2;
  }
  
  public int b()
  {
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    if (localRenderProxy != null) {
      return localRenderProxy.a();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnResume");
    if (this.g == 1) {}
  }
  
  public void b(int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchGameStatus ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    if (localObject != null)
    {
      ((ARTransferDoorLogicManager.RenderProxy)localObject).a(paramInt);
      return;
    }
    localObject = jdField_a_of_type_JavaLangString;
    boolean bool = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchGameStatus ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy);
    if (localStringBuilder.toString() == null) {
      bool = false;
    }
    QLog.d((String)localObject, 2, new Object[] { Boolean.valueOf(bool) });
  }
  
  public void b(boolean paramBoolean)
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.post(new ARTransferDoorLogicManager.5(this, paramBoolean));
    }
  }
  
  public boolean b()
  {
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    boolean bool = true;
    if (localRenderProxy == null) {
      return true;
    }
    int k = b();
    if (k != 0)
    {
      if (k == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyEnterIntoTransferDoorStatus");
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((QQARSession)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d(1);
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnARTransferStatusChanged status changeTo ");
    localStringBuilder.append(paramInt);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView;
      if (localObject != null)
      {
        if ((localObject != null) && (!((ARScanEntryView)localObject).j_())) {
          return;
        }
        switch (paramInt)
        {
        default: 
          return;
        case 6: 
          this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.13(this));
          return;
        case 5: 
          this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.12(this));
          return;
        case 4: 
          this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.11(this));
          return;
        case 3: 
          this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.10(this));
          return;
        case 2: 
          this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.9(this));
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.8(this));
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Boolean = true;
    this.i = 0;
    this.j = 15;
  }
  
  public void e()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "startPhonePoseDetect");
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager.a();
    this.h = -1;
  }
  
  public void f()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "stopPhonePoseDetect");
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager.b();
  }
  
  public void g()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnPause");
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnPause but do nothing here");
      return;
    }
    ARTransferPromotionUIContainer localARTransferPromotionUIContainer = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferPromotionUIContainer;
    if (localARTransferPromotionUIContainer != null) {
      localARTransferPromotionUIContainer.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    c(6);
    f();
    this.h = -1;
  }
  
  public void h()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ARWorldGC ARWorldCupGameLogicManager uninit");
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy = null;
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null)
    {
      ((RelativeLayout)localObject).setOnTouchListener(null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorVideoInfo$PlayGuideShowInfo = null;
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferPromotionUIContainer = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager;
    if (localObject != null)
    {
      ((ARPhonePoseDetectManager)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionARPhonePoseDetectManager = null;
    }
    this.h = -1;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public void i()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "zoomOutWorldCupSparks .");
    ARTransferDoorLogicManager.RenderProxy localRenderProxy = this.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorLogicManager$RenderProxy;
    if (localRenderProxy != null)
    {
      localRenderProxy.b();
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "zoomOutWorldCupSparks failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager
 * JD-Core Version:    0.7.0.1
 */