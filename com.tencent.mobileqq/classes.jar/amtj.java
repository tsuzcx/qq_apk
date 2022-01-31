import android.graphics.PointF;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.1;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.10;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.11;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.12;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.13;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.2;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.3;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.4;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.5;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.6;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.7;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.8;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.9;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class amtj
  implements amtb
{
  public static final String a;
  public int a;
  private long jdField_a_of_type_Long;
  private amta jdField_a_of_type_Amta;
  private amtk jdField_a_of_type_Amtk;
  volatile amtm jdField_a_of_type_Amtm = null;
  private amtn jdField_a_of_type_Amtn;
  private ancj jdField_a_of_type_Ancj = new ancj();
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ArCloudConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
  public ARScanEntryView a;
  public WeakReference<anfx> a;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  public final int c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  public final int d;
  private String d;
  public final int e = 4;
  public final int f = 5;
  public final int g = 6;
  private volatile int h = -1;
  private int i;
  private int j = 15;
  
  static
  {
    jdField_a_of_type_JavaLangString = amtj.class.getSimpleName();
  }
  
  public amtj()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 1;
    this.jdField_c_of_type_Int = 2;
    this.jdField_d_of_type_Int = 3;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Amtn != null) {
      this.jdField_a_of_type_Amtn.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Amtk = null;
    f();
    this.h = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    QLog.d(jdField_a_of_type_JavaLangString, 2, "setGamePlayMode mode " + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "setRecogRes");
    if (this.jdField_a_of_type_Amtk != null)
    {
      this.jdField_a_of_type_Amtk.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "setRecogRes failed.");
  }
  
  public void a(amtk paramamtk)
  {
    if (paramamtk != null)
    {
      this.jdField_a_of_type_Amtk = paramamtk;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_Amtk.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Amtk.b();
      if (!this.jdField_a_of_type_Amtk.c()) {
        break label75;
      }
    }
    label75:
    for (int k = 1;; k = 2)
    {
      this.jdField_a_of_type_Int = k;
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_Amtk.a();
      return;
    }
  }
  
  public void a(ancj paramancj, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "processInternalGestureRecogResult");
    if (!b()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "processInternalGestureRecogResult into Error status");
    }
    this.jdField_a_of_type_Ancj = paramancj;
    int k = 1;
    if (this.jdField_a_of_type_Long > 0L) {
      k = 0;
    }
    int m;
    boolean bool;
    if ((this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_d_of_type_Int == 0) && (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int > 0))
    {
      f();
      if (k != 0)
      {
        c(4);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "processInternalGestureRecogResult start draw circle");
      }
      paramancj = ARLocalGestureCircleRecog.a(paramInt1, paramInt2, paramInt3, paramInt4, new PointF(this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Anck.b, this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Anck.c));
      m = (int)(this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Anck.jdField_a_of_type_Float / paramInt2 * paramInt3);
      int n = (int)paramancj.x;
      int i1 = (int)paramancj.y;
      if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Anck.jdField_a_of_type_Boolean)
      {
        k = 1;
        a(m, n, i1, k);
        b(1);
        amup.a().a(6);
        this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.g = 0;
      }
    }
    else
    {
      if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int <= this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_d_of_type_Int) {
        break label547;
      }
      m = 0;
      if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancm.jdField_d_of_type_Int != 1) {
        break label478;
      }
      if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_d_of_type_Int != 0) {
        break label457;
      }
      k = 0;
      m = 1;
      bool = true;
    }
    for (;;)
    {
      label291:
      if (m != 0)
      {
        if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancm.jdField_d_of_type_Int != 1) {
          break label779;
        }
        paramancj = new int[this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int - k];
        int[] arrayOfInt1 = new int[this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int - k];
        int[] arrayOfInt2 = new int[this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int - k];
        paramInt2 = k;
        for (;;)
        {
          if (paramInt2 < this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int)
          {
            PointF localPointF = ARLocalGestureCircleRecog.a(paramInt1, paramInt1, paramInt3, paramInt4, this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_ArrayOfAndroidGraphicsPointF[paramInt2]);
            paramancj[(paramInt2 - k)] = ((int)localPointF.x);
            arrayOfInt1[(paramInt2 - k)] = ((int)localPointF.y);
            arrayOfInt2[(paramInt2 - k)] = this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_ArrayOfInt[paramInt2];
            paramInt2 += 1;
            continue;
            k = -1;
            break;
            label457:
            k = this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_d_of_type_Int;
            m = 1;
            bool = false;
            break label291;
            label478:
            if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int >= 1) {
              m = 1;
            }
            if (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_d_of_type_Int < 1)
            {
              bool = true;
              k = 0;
              break label291;
            }
            bool = false;
            k = this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_d_of_type_Int;
            break label291;
          }
        }
        a(paramancj, arrayOfInt1, arrayOfInt2, bool);
      }
    }
    for (;;)
    {
      label547:
      if ((this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Int == -1) && (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_b_of_type_Int != -1) && (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_c_of_type_Int > 0))
      {
        this.jdField_c_of_type_Boolean = true;
        d();
        c(3);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((anfx)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(new ARTransferDoorLogicManager.2(this), 1000L);
        }
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "zoomOutWorldCupSparks curent state " + this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.jdField_b_of_type_Int != 0))
      {
        c(5);
        b(2);
        ThreadManager.getSubThreadHandler().post(new ARTransferDoorLogicManager.3(this));
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          ((anfx)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(new ARTransferDoorLogicManager.4(this), 1500L);
        }
      }
      return;
      label779:
      this.i = 0;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = false;
        paramancj = new ARTransferDoorLogicManager.1(this, paramInt1, paramInt2, paramInt3, paramInt4);
        QLog.i(jdField_a_of_type_JavaLangString, 1, "DrawCircle. resume. mDrawCirclePuase = " + this.jdField_c_of_type_Boolean + ", genIdx = " + this.jdField_a_of_type_Ancj.jdField_a_of_type_Ancl.g);
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (!this.jdField_c_of_type_Boolean)) {
          ((anfx)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramancj, this.j);
        }
      }
    }
  }
  
  public void a(anfx paramanfx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramanfx);
  }
  
  public void a(AppInterface paramAppInterface, ScanTorchActivity paramScanTorchActivity, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    this.jdField_a_of_type_Amta = new amta(paramScanTorchActivity);
    this.jdField_a_of_type_Amta.a(this);
    if ((this.jdField_a_of_type_Amtk != null) && (paramRelativeLayout != null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "init " + paramRelativeLayout.getChildCount());
      this.jdField_a_of_type_Amtk.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_Amtn = new amtn(paramScanTorchActivity);
      return;
    }
    paramAppInterface = jdField_a_of_type_JavaLangString;
    paramRelativeLayout = new StringBuilder().append("init ");
    if (this.jdField_a_of_type_Amtk != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d(paramAppInterface, 2, bool);
      break;
    }
  }
  
  public void a(ArCloudConfigInfo paramArCloudConfigInfo)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "startRenderTransferGame config " + paramArCloudConfigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = paramArCloudConfigInfo;
    }
    ArCloudConfigInfo localArCloudConfigInfo = paramArCloudConfigInfo;
    if (paramArCloudConfigInfo == null)
    {
      localArCloudConfigInfo = paramArCloudConfigInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo != null)
      {
        localArCloudConfigInfo = paramArCloudConfigInfo;
        if (a()) {
          localArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
        }
      }
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((anfx)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(4096L, localArCloudConfigInfo);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b();
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Amtk != null) && (this.jdField_a_of_type_Int == 1)) {
        if (this.jdField_a_of_type_Amtk.b())
        {
          c(6);
          this.jdField_a_of_type_Amtk.a();
          this.h = -1;
        }
      }
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onPhonePoseChaned standBy SUCCESS with mode: " + this.jdField_a_of_type_Int + "-mCurrentPoseStatus:" + this.h);
        return;
        this.h = 0;
        continue;
        if ((this.jdField_a_of_type_Amtk != null) && (this.jdField_a_of_type_Int == 2))
        {
          c(2);
          this.h = 0;
        }
        else if (this.jdField_a_of_type_Amtk == null)
        {
          c(2);
          this.h = 0;
        }
      }
    }
    if ((this.jdField_a_of_type_Amtk != null) && (this.jdField_a_of_type_Amtk.b()) && (this.jdField_a_of_type_Int == 1)) {
      c(1);
    }
    for (;;)
    {
      this.h = 1;
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onPhonePoseChaned standBy FAIL with mode: " + this.jdField_a_of_type_Int + "-mCurrentPoseStatus:" + this.h);
      return;
      if (this.jdField_a_of_type_Int == 2) {
        c(1);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "updateUITipsMessage " + paramBoolean + ";" + paramString);
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
    if ((this.jdField_a_of_type_Amtk != null) && (this.jdField_a_of_type_Amtk.a()))
    {
      this.jdField_a_of_type_Amtk.a(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3, paramBoolean);
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "insertWorldCupSpark failed.");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Amtk != null) {
      return this.jdField_a_of_type_Amtk.a();
    }
    return 0;
  }
  
  public void b()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnResume");
    if (this.jdField_a_of_type_Int == 1) {}
  }
  
  public void b(int paramInt)
  {
    boolean bool = true;
    QLog.d(jdField_a_of_type_JavaLangString, 2, "switchGameStatus " + paramInt);
    if (this.jdField_a_of_type_Amtk != null)
    {
      this.jdField_a_of_type_Amtk.a(paramInt);
      return;
    }
    String str = jdField_a_of_type_JavaLangString;
    if ("switchGameStatus " + paramInt + "|" + this.jdField_a_of_type_Amtk != null) {}
    for (;;)
    {
      QLog.d(str, 2, new Object[] { Boolean.valueOf(bool) });
      return;
      bool = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.5(this, paramBoolean));
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Amtk == null) {}
    int k;
    do
    {
      return true;
      k = b();
    } while ((k == 0) || (k == 1));
    return false;
  }
  
  public void c()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "notifyEnterIntoTransferDoorStatus");
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((anfx)this.jdField_a_of_type_JavaLangRefWeakReference.get()).d(1);
    }
  }
  
  public void c(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "OnARTransferStatusChanged status changeTo " + paramInt);
    if ((this.jdField_a_of_type_MqqOsMqqHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView == null) || ((this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView != null) && (!this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.a()))) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.8(this));
      return;
    case 2: 
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.9(this));
      return;
    case 3: 
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.10(this));
      return;
    case 4: 
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.11(this));
      return;
    case 5: 
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.12(this));
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ARTransferDoorLogicManager.13(this));
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
    this.jdField_a_of_type_Amta.a();
    this.h = -1;
  }
  
  public void f()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "stopPhonePoseDetect");
    this.jdField_a_of_type_Amta.b();
  }
  
  public void g()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnPause");
    if (this.jdField_a_of_type_Amtk == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "doOnPause but do nothing here");
      return;
    }
    if (this.jdField_a_of_type_Amtn != null) {
      this.jdField_a_of_type_Amtn.b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    c(6);
    f();
    this.h = -1;
  }
  
  public void h()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "ARWorldGC ARWorldCupGameLogicManager uninit");
    this.jdField_a_of_type_Amtk = null;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_Amtm = null;
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Amtn = null;
    if (this.jdField_a_of_type_Amta != null)
    {
      this.jdField_a_of_type_Amta.b();
      this.jdField_a_of_type_Amta = null;
    }
    this.h = -1;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo = null;
  }
  
  public void i()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "zoomOutWorldCupSparks .");
    if (this.jdField_a_of_type_Amtk != null)
    {
      this.jdField_a_of_type_Amtk.b();
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "zoomOutWorldCupSparks failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtj
 * JD-Core Version:    0.7.0.1
 */