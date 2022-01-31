package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.EffectSupportManager;
import com.tencent.av.doodle.DoodleToolbar;
import com.tencent.av.gameplay.QavGPDownloadManager;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.av.ui.redbag.AVRedBagConfig.Info;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.AVRedBagMgr.Event;
import com.tencent.av.ui.redbag.RedBagReport;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgr;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jvr;
import jvs;
import jvt;
import jvu;
import jvv;
import jvw;
import jvz;
import jwa;
import jwb;
import jwc;
import jwd;

public class EffectSettingUi
  extends RelativeLayout
{
  public static Runnable a;
  public int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jvr(this);
  public SparseArray a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new jvu(this);
  public ViewGroup a;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public VideoAppInterface a;
  public EffectSettingBtn a;
  public AVRedBagMgr.Event a;
  public WeakReference a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  
  public EffectSettingUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramAVActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$Event = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 2, "EffectSettingUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localBaseToolbar != null) && (localBaseToolbar.isAvailable()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EffectSettingUi", 4, String.format("checkAbility 期望的按钮可用, effectBtnID[%s]", new Object[] { Integer.valueOf(paramInt1) }));
      }
      b(true);
      return paramInt1;
    }
    paramInt1 = a(paramInt2);
    if ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1) != null)
    {
      b(true);
      return paramInt1;
    }
    b(false);
    return paramInt1;
  }
  
  private BaseToolbar a(boolean paramBoolean, Class paramClass)
  {
    paramClass = BaseToolbar.createToolbar(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramClass);
    paramClass.initBtn(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramBoolean, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramClass.getEffectBtnId(), paramClass);
    paramClass.updateBtnStatus();
    return paramClass;
  }
  
  public static void a(VideoAppInterface paramVideoAppInterface)
  {
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface.a(new Object[] { Integer.valueOf(125) });
      b(paramVideoAppInterface);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if (localBaseToolbar != null)
    {
      localBaseToolbar.performClick();
      return true;
    }
    return false;
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    paramVideoAppInterface = paramVideoAppInterface.a();
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.a().d;
      int j = paramVideoAppInterface.a().F;
      boolean bool = paramVideoAppInterface.a().f;
      if (3 == j) {
        return (!paramBoolean) || ((i == 2) && (bool));
      }
    }
    return false;
  }
  
  public static boolean a(AVActivity paramAVActivity)
  {
    boolean bool2 = false;
    paramAVActivity = paramAVActivity.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool1 = bool2;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.a().d;
      bool1 = bool2;
      if (2 == paramAVActivity.a().F)
      {
        bool1 = bool2;
        if (i == 4) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void b(VideoAppInterface paramVideoAppInterface)
  {
    if (AudioHelper.a(1) == 1)
    {
      AudioHelper.a("工具栏不消失");
      if (jdField_a_of_type_JavaLangRunnable == null)
      {
        jdField_a_of_type_JavaLangRunnable = new jvv(paramVideoAppInterface);
        paramVideoAppInterface.a().postDelayed(jdField_a_of_type_JavaLangRunnable, 3000L);
      }
    }
    while (jdField_a_of_type_JavaLangRunnable == null) {
      return;
    }
    paramVideoAppInterface.a().removeCallbacks(jdField_a_of_type_JavaLangRunnable);
    jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b(AVActivity paramAVActivity)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    paramAVActivity = paramAVActivity.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool1 = bool3;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.a().d;
      bool1 = bool3;
      if (1 == paramAVActivity.a().F) {
        if (i != 4) {
          break label48;
        }
      }
    }
    label48:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null) {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.c();
    }
    setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    if (paramBoolean)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, a().getDisplayMetrics().widthPixels, 0.0F, 0.0F);
      localTranslateAnimation.setFillAfter(false);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new jvs(this));
      startAnimation(localTranslateAnimation);
      localTranslateAnimation = new TranslateAnimation(-a().getDisplayMetrics().widthPixels, 0.0F, 0.0F, 0.0F);
      localTranslateAnimation.setFillAfter(false);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setAnimationListener(new jvt(this));
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
      }
    }
    a(Integer.valueOf(6105), Integer.valueOf(2131365946));
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EffectSettingUi", 2, "[red dot] updateRedDot All");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).updateRedDot();
        i += 1;
      }
    }
  }
  
  private void k()
  {
    if (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false)) {}
    do
    {
      do
      {
        return;
      } while ((!RedBagUtil.a()) || ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(7) != null));
      b();
      AVRedBagConfig.Info localInfo = RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      if ((localInfo != null) && (localInfo.jdField_a_of_type_Boolean))
      {
        c();
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("EffectSettingUi", 4, "先不创建红包固定按钮");
  }
  
  private void l()
  {
    boolean bool1 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    boolean bool2 = ((EffectSupportManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(2, "ptu_so");
    AVLog.c("EffectSettingUi", "initBtn:" + bool1 + "|" + bool2);
    boolean bool3 = ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(bool2, EffectToolbar.class);
    a(bool1, FaceToolbar.class);
    a(bool1, DoodleToolbar.class);
    a(true, BeautyToolbar.class);
    a(true, VoiceChangeToolbar.class);
    if ((bool1) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      a(bool1, ZimuToolbar.class);
      j();
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoController != null) {
        setSelectedBtn(localVideoController.a().W);
      }
      d();
      return;
    }
  }
  
  private void m()
  {
    if (UITools.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface))
    {
      BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(2);
      if ((localBaseToolbar != null) && (localBaseToolbar.mEffectBtn != null) && (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn == null)) {
        this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn = new EffectSettingBtn(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidWidgetRelativeLayout, localBaseToolbar.mEffectBtn);
      }
    }
  }
  
  private void n()
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365947);
    ViewTreeObserver localViewTreeObserver = localHorizontalScrollView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new jvz(this, localViewTreeObserver, localHorizontalScrollView));
  }
  
  private void o()
  {
    Button localButton = (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365946);
    localButton.setOnClickListener(new jwa(this));
    if (AudioHelper.a(0) == 1) {
      localButton.setBackgroundColor(Color.argb(100, 0, 0, 0));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
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
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f();
  }
  
  Resources a()
  {
    return ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
  }
  
  void a()
  {
    e();
  }
  
  public void a(int paramInt)
  {
    QLog.w("EffectSettingUi", 1, "exitSubEffectPanel, ExitID[" + paramInt + "], mCurSelectedId[" + this.jdField_a_of_type_Int + "], isShown[" + isShown() + "]");
    int i;
    if (this.jdField_a_of_type_Int == paramInt)
    {
      i = a(-1, paramInt);
      if (!isShown()) {
        break label99;
      }
      if (i > paramInt) {
        a(true);
      }
    }
    else
    {
      return;
    }
    a(i, paramInt);
    return;
    label99:
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localBaseToolbar != null) {
      localBaseToolbar.hideToolbar();
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localBaseToolbar != null) {
      localBaseToolbar.setEffectBtnVisibility(paramBoolean);
    }
  }
  
  public void a(Integer paramInteger, Object paramObject)
  {
    AVLog.c("EffectSettingUi", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("EffectSettingUi", 1, "updateBtnStatus[" + paramString + "], reselect[" + paramBoolean + "], mCurSelectedId[" + this.jdField_a_of_type_Int + "], isShown[" + isShown() + "]");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).updateBtnStatus();
      i += 1;
    }
    if (paramBoolean)
    {
      paramString = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
      if (paramString != null) {
        paramString.hideToolbar();
      }
      this.jdField_a_of_type_Int = -1;
    }
    if (isShown()) {
      a(this.jdField_a_of_type_Int, -1);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(124) });
  }
  
  boolean a()
  {
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.g()) {
      return false;
    }
    a(true);
    return true;
  }
  
  boolean a(int paramInt)
  {
    return (this.jdField_a_of_type_Int == paramInt) && (isShown());
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int i = this.jdField_a_of_type_Int;
    if (localBaseToolbar != null) {}
    for (boolean bool = localBaseToolbar.tryShowToolbar(this.jdField_b_of_type_AndroidWidgetRelativeLayout, i, paramBoolean);; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EffectSettingUi", 2, "onEffectBtnClick lastSelectedId: " + i + ", viewId: " + paramInt + ", showToolbar: " + bool);
      }
      Object localObject;
      if (bool) {
        if (i != paramInt)
        {
          localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          this.jdField_a_of_type_Int = paramInt;
          if (localObject != null) {
            ((BaseToolbar)localObject).hideToolbar();
          }
          ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).m();
          localObject = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365947);
          if (paramInt != 1) {
            break label194;
          }
        }
      }
      label277:
      label300:
      for (;;)
      {
        if (localBaseToolbar != null)
        {
          localBaseToolbar.onButtonClick(i, paramBoolean, bool);
          if (bool) {
            localBaseToolbar.clearRedDot();
          }
        }
        return bool;
        label194:
        if (paramInt == 7)
        {
          ((HorizontalScrollView)localObject).fullScroll(66);
          continue;
          if (paramInt == 1)
          {
            if (!a((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
              break label277;
            }
            MultiVideoRichActionReportCollection.a("0X8007F27");
          }
          for (;;)
          {
            if (!QLog.isDevelopLevel()) {
              break label300;
            }
            QLog.d("EffectSettingUi", 4, String.format("按钮点击失败, lastSelectedId[%s], newSelectId[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }));
            break;
            if (b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
              MultiVideoRichActionReportCollection.a("0X8007F2D");
            }
          }
        }
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$Event != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$Event = new jvw(this);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "listenAVRedBagEvent");
    }
    RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(new WeakReference(this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$Event));
  }
  
  boolean b(int paramInt)
  {
    k();
    int i = this.jdField_a_of_type_Int;
    if (paramInt != -1) {
      i = paramInt;
    }
    i = a(i, -1);
    QLog.w("EffectSettingUi", 1, "show, EffectBtnID 原[" + this.jdField_a_of_type_Int + "], 期望[" + paramInt + "], 最终[" + i + "]");
    this.jdField_a_of_type_Int = -1;
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131429592), 1).a();
      AVEffectReport.a();
      return isShown();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(123), Integer.valueOf(2) });
    GestureMgr.a().b();
    QavGPDownloadManager.a().b();
    i();
    AVEffectReport.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().F, a());
    Object localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localObject != null) {
      ((BaseToolbar)localObject).performClick();
    }
    setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    localObject = new TranslateAnimation(a().getDisplayMetrics().widthPixels, 0.0F, 0.0F, 0.0F);
    ((TranslateAnimation)localObject).setFillAfter(false);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new jwc(this));
    startAnimation((Animation)localObject);
    localObject = new TranslateAnimation(0.0F, -a().getDisplayMetrics().widthPixels, 0.0F, 0.0F);
    ((TranslateAnimation)localObject).setFillAfter(false);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new jwd(this));
    this.jdField_a_of_type_AndroidViewViewGroup.startAnimation((Animation)localObject);
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    RedBagReport.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(7));
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if ((localObject != null) && (((SessionInfo)localObject).c()) && (((SessionInfo)localObject).d == 2)) {
      ReportController.b(null, "dc00898", "", "", "0X8008AD5", "0X8008AD5", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      int i;
      boolean bool1;
      boolean bool2;
      do
      {
        do
        {
          return;
        } while (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false));
        i = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().j();
        if (i == VideoController.v) {
          break;
        }
        bool1 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext(), false);
        bool2 = PtvFilterSoLoad.a();
        QLog.d("EffectSettingUi", 1, "createRedBagBtn, ptu的so没加载成功, loadPTuSoStatus[" + i + "], ptuSo[" + bool1 + "], ptuSoVersion[" + bool2 + "]");
      } while ((i != VideoController.u) || (!bool1) || (!bool2));
    } while ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(7) != null);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "创建红包入口");
    }
    a(true, RedbagToolbar.class);
    d();
    RedBagUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).b("EffectSettingUi");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    Resources localResources = ((AVActivity)localObject).getResources();
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365947);
    if (localHorizontalScrollView.getTag() == null)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, 等待onGlobalLayout");
      return;
    }
    int j = ((AVActivity)localObject).getWindow().getDecorView().getWidth() - AIOUtils.a(60.0F, localResources);
    if (j == 0)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, window没有高度");
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getMeasuredWidth();
    if (k < j)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, 无需处理2, winShowW[" + j + "], btnsW[" + k + "]");
      return;
    }
    int m = (int)localResources.getDimension(2131560057);
    int n = k - j;
    if (n < m / 2)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, 无需处理3, hideW[" + n + "], halfBtnW[" + m / 2 + "]");
      return;
    }
    int i1 = n % m;
    int i2 = n / m;
    int i = m / 2 - i1;
    if (i2 > 0) {
      if (i1 >= m / 2) {
        break label411;
      }
    }
    label411:
    for (i = m / 2 - i1;; i = m / 2 + m - i1)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, winW[" + ((AVActivity)localObject).getWindow().getDecorView().getWidth() + "], winShowW[" + j + "], btnsW[" + k + "], qav_effect_btn_width[" + m + "], hideW[" + n + "], oneHideW[" + i1 + "], move[" + i + "]");
      localObject = (RelativeLayout.LayoutParams)localHorizontalScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, 0, 0);
      localHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {}
    do
    {
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d("EffectSettingUi", 2, "onCreate");
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2130969279, this).findViewById(2131365944));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new jwb(this));
      Object localObject = (ViewGroup)getParent();
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewGroup)localObject).findViewById(2131365392));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365949));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365948));
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2, null);
      n();
      l();
      o();
      m();
      f();
      if (AudioHelper.a(0) == 1)
      {
        setBackgroundColor(-256);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-65281);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16711936);
        ((ViewGroup)localObject).setBackgroundColor(Color.argb(255, 255, 255, 255));
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(Color.argb(127, 0, 0, 0));
        findViewById(2131365945).setBackgroundColor(-1);
      }
      localObject = new IntentFilter("com.tencent.redpoint.broadcast.push.av");
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("EffectSettingUi", 2, "[red dot] register red dot receiver");
  }
  
  void f()
  {
    int i;
    if (AudioHelper.a(3) == 1)
    {
      AudioHelper.a("创建更多的按钮，测试滚动");
      i = 100;
      if ((i < 105) && ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i) == null)) {}
    }
    else
    {
      return;
    }
    Object localObject = a(true, RedbagToolbar.class);
    ((BaseToolbar)localObject).updateBtnStatus();
    if (AudioHelper.a(0) == 1)
    {
      localObject = ((BaseToolbar)localObject).mEffectBtn;
      if (i % 2 != 0) {
        break label86;
      }
    }
    label86:
    for (int j = -65536;; j = -16711936)
    {
      ((ImageButton)localObject).setBackgroundColor(j);
      i += 1;
      break;
    }
  }
  
  void g()
  {
    h();
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagMgr$Event = null;
    if (this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn != null)
    {
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn.d();
      this.jdField_a_of_type_ComTencentAvUiEffectSettingBtn = null;
    }
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    if (this.jdField_b_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    URLDrawable.clearMemoryCache();
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e)
    {
      VideoController localVideoController = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvVideoController;
      if ((localVideoController != null) && (localVideoController.a().g != 0) && (localVideoController.a().g != 7)) {
        localVideoController.a().W = this.jdField_a_of_type_Int;
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  void h()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).destroy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  void i()
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
    if (localBaseToolbar != null) {
      localBaseToolbar.updateBtnStatus();
    }
    boolean bool1 = ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    boolean bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    a(3, bool2);
    a(2, bool2);
    if ((bool1) && (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      a(6, bool1);
      a(7, bool2);
      return;
    }
  }
  
  public boolean isShown()
  {
    return getVisibility() == 0;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if ((j != 1073741824) && (j != 0))
    {
      paramInt2 = i;
      if (j != -2147483648) {}
    }
    else
    {
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = AIOUtils.a(218.0F, getResources());
      }
      if (i > this.jdField_b_of_type_Int) {
        break label77;
      }
    }
    label77:
    for (paramInt2 = i;; paramInt2 = this.jdField_b_of_type_Int)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, j));
      return;
    }
  }
  
  public void setSelectedBtn(int paramInt)
  {
    a(paramInt, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi
 * JD-Core Version:    0.7.0.1
 */