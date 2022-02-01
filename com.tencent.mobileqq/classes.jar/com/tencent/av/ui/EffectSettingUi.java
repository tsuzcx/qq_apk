package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.ptu.PtuResChecker;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class EffectSettingUi
  extends QavMenuBaseView
{
  int jdField_a_of_type_Int = -1;
  SparseArray<BaseToolbar> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new EffectSettingUi.1(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  EffectSettingBtn jdField_a_of_type_ComTencentAvUiEffectSettingBtn;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  WeakReference<AVActivity> jdField_a_of_type_JavaLangRefWeakReference = null;
  boolean jdField_a_of_type_Boolean = false;
  RelativeLayout b;
  RelativeLayout c;
  
  public EffectSettingUi(Context paramContext)
  {
    super(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EffectSettingUi");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    if ((paramContext instanceof AVActivity)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((AVActivity)paramContext);
    }
    setId(2131368398);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localBaseToolbar != null) && (localBaseToolbar.isAvailable()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 4, String.format("checkAbility 期望的按钮可用, effectBtnID[%s]", new Object[] { Integer.valueOf(paramInt1) }));
      }
      a(true);
      return paramInt1;
    }
    paramInt1 = a(paramInt2);
    if ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1) != null)
    {
      a(true);
      return paramInt1;
    }
    a(false);
    return paramInt1;
  }
  
  private BaseToolbar a(boolean paramBoolean, Class<? extends BaseToolbar> paramClass)
  {
    paramClass = BaseToolbar.createToolbar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramClass);
    paramClass.initBtn(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramClass.getEffectBtnId(), paramClass);
    paramClass.updateBtnStatus();
    return paramClass;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface, long paramLong)
  {
    if (paramVideoAppInterface != null) {
      paramVideoAppInterface.a(new Object[] { Integer.valueOf(125), Long.valueOf(paramLong) });
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i = a(paramInt1, paramInt2);
    Object localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    boolean bool;
    if (localObject != null)
    {
      ((BaseToolbar)localObject).performClick();
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reSelectBtn, effectBtnID[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], ignoreID[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], selectid[");
      localStringBuilder.append(i);
      localStringBuilder.append("], ret[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    paramVideoAppInterface = paramVideoAppInterface.a();
    boolean bool1 = true;
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.a().d;
      int j = paramVideoAppInterface.a().E;
      boolean bool2 = paramVideoAppInterface.a().j;
      if (3 == j)
      {
        if (!paramBoolean) {
          break label61;
        }
        if ((i == 2) && (bool2)) {
          return true;
        }
      }
    }
    bool1 = false;
    label61:
    return bool1;
  }
  
  public static boolean a(AVActivity paramAVActivity)
  {
    paramAVActivity = paramAVActivity.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.a().d;
      bool1 = bool2;
      if (2 == paramAVActivity.a().E)
      {
        bool1 = bool2;
        if (i == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(AVActivity paramAVActivity)
  {
    paramAVActivity = paramAVActivity.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.a().d;
      bool1 = bool2;
      if (1 == paramAVActivity.a().E)
      {
        bool1 = bool2;
        if (i == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void d(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    boolean bool1 = true;
    boolean bool2 = a((VideoAppInterface)localObject, true);
    boolean bool3 = PtuResChecker.a().a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initBtn:");
    localStringBuilder.append(bool2);
    localStringBuilder.append("|");
    localStringBuilder.append(bool3);
    AVLog.printColorLog((String)localObject, localStringBuilder.toString());
    boolean bool4 = ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(bool3, EffectToolbar.class);
    a(bool2, FaceToolbar.class);
    a(bool2, ((IDoodleApi)QRoute.api(IDoodleApi.class)).getDoodleToolbarClass());
    a(true, BeautyToolbar.class);
    a(true, VoiceChangeToolbar.class);
    if ((!bool2) || (!bool4)) {
      bool1 = false;
    }
    a(bool1, ZimuToolbar.class);
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if ((this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i) instanceof FaceToolbar))
      {
        if (((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch != null) {
          break;
        }
        ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch = AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtn, 3);
        if (((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch == null) {
          break;
        }
        int j = (int)UITools.b(getContext(), ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtn.getPaddingRight());
        int k = (int)UITools.b(getContext(), ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtn.getPaddingTop());
        ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch.a(0, j, k, 0).a();
        break;
      }
      i += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localObject != null) {
      setSelectedBtn(((VideoController)localObject).a().U);
    }
    b();
  }
  
  private void e()
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368279);
    ViewTreeObserver localViewTreeObserver = localHorizontalScrollView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new EffectSettingUi.2(this, localViewTreeObserver, localHorizontalScrollView));
  }
  
  private void f()
  {
    Button localButton = (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373326);
    localButton.setOnClickListener(new EffectSettingUi.3(this));
    if (AudioHelper.a(0) == 1) {
      localButton.setBackgroundColor(Color.argb(100, 0, 0, 0));
    }
  }
  
  int a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localBaseToolbar != null) && (localBaseToolbar.getEffectBtnId() != paramInt) && (localBaseToolbar.isAvailable())) {
        return localBaseToolbar.getEffectBtnId();
      }
      i += 1;
    }
    return -1;
  }
  
  long a()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) && (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() != null)) {
      return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f();
    }
    return 0L;
  }
  
  public void a()
  {
    long l = AudioHelper.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exitSubEffectPanel, cur[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    int i = this.jdField_a_of_type_Int;
    if (i != -1)
    {
      localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localObject != null) {
        ((BaseToolbar)localObject).hideToolbar(l);
      }
      setCurSelectedId(-1, "exitSubEffectPanel");
    }
  }
  
  public void a(int paramInt)
  {
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitSubEffectPanel, ExitID[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mCurSelectedId[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], isShown[");
    localStringBuilder.append(isShown());
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_Int == paramInt)
    {
      int i = a(-1, paramInt);
      if (isShown())
      {
        if (i > paramInt)
        {
          b(l, true);
          return;
        }
        a(i, paramInt);
        return;
      }
      localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
      if (localObject != null) {
        ((BaseToolbar)localObject).hideToolbar(l);
      }
      setCurSelectedId(-1, "exitSubEffectPanel");
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localBaseToolbar != null) {
      localBaseToolbar.setEffectBtnVisibility(paramBoolean);
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initUI, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    setGravity(80);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559691, this).findViewById(2131373384));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new EffectSettingUi.4(this));
    Object localObject = (ViewGroup)getParent();
    this.c = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373641));
    this.b = ((RelativeLayout)findViewById(2131373388));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.b.findViewById(2131370087));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2, null);
    e();
    d(paramLong);
    f();
    if (AudioHelper.a(0) == 1)
    {
      setBackgroundColor(-256);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-65281);
      this.c.setBackgroundColor(-16711936);
      ((ViewGroup)localObject).setBackgroundColor(-1);
      findViewById(2131373388).setBackgroundColor(-7829368);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    a(-1013L);
  }
  
  void a(Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (paramBoolean.booleanValue())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramInt1);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(paramInt2);
    }
  }
  
  boolean a()
  {
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.i()) {
      return false;
    }
    b(-1012L, true);
    return true;
  }
  
  boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (isShown());
  }
  
  boolean a(long paramLong, int paramInt)
  {
    c();
    int i = this.jdField_a_of_type_Int;
    if (paramInt != -1) {
      i = paramInt;
    }
    i = a(i, -1);
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("show, EffectBtnID 原[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], 期望[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], 最终[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695353), 1).a();
      AVEffectReport.a();
      return isShown();
    }
    GestureMgr.a().b();
    AVEffectReport.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().E, a());
    localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localObject != null) {
      ((BaseToolbar)localObject).performClick();
    }
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if ((localObject != null) && (((SessionInfo)localObject).f()) && (((SessionInfo)localObject).d == 2)) {
      ReportController.b(null, "dc00898", "", "", "0X8008AD5", "0X8008AD5", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  boolean a(long paramLong, int paramInt, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int k = this.jdField_a_of_type_Int;
    int j = 1;
    boolean bool;
    if (localBaseToolbar != null) {
      bool = localBaseToolbar.tryShowToolbar(paramLong, this.c, k, paramBoolean);
    } else {
      bool = true;
    }
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tryShowToolbar, SelectedId[");
    localStringBuilder.append(k);
    localStringBuilder.append("->");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], bFromPerformClick[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("], showToolbar[");
    localStringBuilder.append(bool);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (bool)
    {
      int i = j;
      if (k != paramInt)
      {
        localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        setCurSelectedId(paramInt, "tryShowToolbar");
        if ((localObject != null) && (this.jdField_a_of_type_Int != k)) {
          ((BaseToolbar)localObject).hideToolbar(paramLong);
        }
        ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(paramLong);
        localObject = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368279);
        i = j;
      }
      while (i <= 7)
      {
        localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if ((localObject != null) && (i != paramInt) && (((BaseToolbar)localObject).isAvailable()))
        {
          ((BaseToolbar)localObject).hideToolbar(paramLong);
          if (QLog.isColorLevel())
          {
            localObject = this.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("tryShowToolbar, check fail, id[");
            localStringBuilder.append(i);
            localStringBuilder.append("]");
            QLog.i((String)localObject, 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    if (paramInt == 1) {
      if (a((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        MultiVideoRichActionReportCollection.a("0X8007F27");
      } else if (b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        MultiVideoRichActionReportCollection.a("0X8007F2D");
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, String.format("按钮点击失败, lastSelectedId[%s], newSelectId[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) }));
    }
    if (localBaseToolbar != null)
    {
      localBaseToolbar.onButtonClick(k, paramBoolean, bool);
      if ((bool) && ((localBaseToolbar instanceof FaceToolbar)) && (localBaseToolbar.mEffectBtnRedTouch != null))
      {
        AVRedTouchUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localBaseToolbar.mEffectBtnRedTouch, 3);
        localBaseToolbar.mEffectBtnRedTouch = null;
      }
    }
    return bool;
  }
  
  void b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (AVActivity)((WeakReference)localObject1).get();
    if (localObject2 == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      return;
    }
    Object localObject3 = ((AVActivity)localObject2).getResources();
    localObject1 = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368279);
    if (((HorizontalScrollView)localObject1).getTag() == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "adjustScrollView, 等待onGlobalLayout");
      return;
    }
    int k = ((AVActivity)localObject2).getWindow().getDecorView().getWidth() - AIOUtils.b(60.0F, (Resources)localObject3);
    if (k == 0)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "adjustScrollView, window没有高度");
      return;
    }
    int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
    if (m < k)
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("adjustScrollView, 无需处理2, winShowW[");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("], btnsW[");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    int n = (int)((Resources)localObject3).getDimension(2131297760);
    int i1 = m - k;
    int i3 = n / 2;
    if (i1 < i3)
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("adjustScrollView, 无需处理3, hideW[");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("], halfBtnW[");
      ((StringBuilder)localObject2).append(i3);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    int i2 = i1 % n;
    int i4 = i1 / n;
    int j = i3 - i2;
    int i = j;
    if (i4 > 0) {
      if (i2 < i3) {
        i = j;
      } else {
        i = i3 + n - i2;
      }
    }
    localObject3 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adjustScrollView, winW[");
    localStringBuilder.append(((AVActivity)localObject2).getWindow().getDecorView().getWidth());
    localStringBuilder.append("], winShowW[");
    localStringBuilder.append(k);
    localStringBuilder.append("], btnsW[");
    localStringBuilder.append(m);
    localStringBuilder.append("], qav_effect_btn_width[");
    localStringBuilder.append(n);
    localStringBuilder.append("], hideW[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], oneHideW[");
    localStringBuilder.append(i2);
    localStringBuilder.append("], move[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w((String)localObject3, 1, localStringBuilder.toString());
    localObject2 = (RelativeLayout.LayoutParams)((HorizontalScrollView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, 0, 0, 0);
    ((HorizontalScrollView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
  
  public void b(long paramLong)
  {
    c(paramLong);
    Object localObject = this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn;
    if (localObject != null)
    {
      ((EffectSettingBtn)localObject).c();
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    URLDrawable.clearMemoryCache();
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e)
    {
      localObject = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvVideoController;
      if ((localObject != null) && (((VideoController)localObject).a().f != 0) && (((VideoController)localObject).a().f != 7)) {
        ((VideoController)localObject).a().U = this.jdField_a_of_type_Int;
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    super.b(paramLong);
  }
  
  void b(long paramLong, boolean paramBoolean)
  {
    EffectSettingBtn localEffectSettingBtn = this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn;
    if (localEffectSettingBtn != null) {
      localEffectSettingBtn.b();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(100), Long.valueOf(paramLong) });
  }
  
  void c()
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().j;
    boolean bool2 = false;
    if (!bool1)
    {
      a(5, true);
      a(3, false);
      a(2, false);
      a(6, false);
      a(7, false);
      a(1, false);
      a(4, false);
      return;
    }
    boolean bool3 = EffectsRenderController.b();
    Object localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
    if (localObject != null) {
      ((BaseToolbar)localObject).updateBtnStatus();
    }
    a(5, true);
    a(1, bool3);
    a(4, bool3);
    boolean bool4 = ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    boolean bool5 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    if ((bool5) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(3, bool1);
    if ((bool5) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(2, bool1);
    if ((bool4) && (bool5) && (bool3)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(6, bool1);
    bool1 = bool2;
    if (bool5)
    {
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
    }
    a(7, bool1);
    if (QLog.isDevelopLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBtnUi, enableAE[");
      localStringBuilder.append(bool3);
      localStringBuilder.append("], isShowZimu[");
      localStringBuilder.append(bool4);
      localStringBuilder.append("], visibility[");
      localStringBuilder.append(bool5);
      localStringBuilder.append("]");
      QLog.i((String)localObject, 4, localStringBuilder.toString());
    }
  }
  
  void c(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).destroy(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public boolean isShown()
  {
    return getVisibility() == 0;
  }
  
  public void setCurSelectedId(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurSelectedId, [");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("--->");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Int != paramInt) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void setSelectedBtn(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    a(paramInt, -1);
    setCurSelectedId(paramInt, "setSelectedBtn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi
 * JD-Core Version:    0.7.0.1
 */