package com.tencent.av.ui;

import aepi;
import alud;
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
import azgg;
import azqk;
import azqs;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.doodle.DoodleToolbar;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import lek;
import lid;
import llg;
import loz;
import lro;
import lsa;
import lvt;
import lyc;
import meb;
import mfp;
import mfs;
import mft;
import mfu;
import mfv;
import mfw;
import mrs;
import mrt;
import mry;
import mso;
import msp;
import mww;

public class EffectSettingUi
  extends RelativeLayout
{
  public int a;
  SparseArray<BaseToolbar> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new mfs(this);
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  public VideoAppInterface a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public WeakReference<AVActivity> a;
  public mfp a;
  public mry a;
  boolean jdField_a_of_type_Boolean = false;
  RelativeLayout b;
  RelativeLayout c;
  
  public EffectSettingUi(VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    super(paramAVActivity);
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Mry = null;
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 2, "EffectSettingUi");
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAVActivity);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    setId(2131367870);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    if ((localBaseToolbar != null) && (localBaseToolbar.isAvailable()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("EffectSettingUi", 4, String.format("checkAbility 期望的按钮可用, effectBtnID[%s]", new Object[] { Integer.valueOf(paramInt1) }));
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
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localBaseToolbar != null) {
      localBaseToolbar.performClick();
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("EffectSettingUi", 1, "reSelectBtn, effectBtnID[" + paramInt1 + "], ignoreID[" + paramInt2 + "], selectid[" + i + "], ret[" + bool + "]");
      }
      return bool;
    }
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface, boolean paramBoolean)
  {
    paramVideoAppInterface = paramVideoAppInterface.a();
    if (paramVideoAppInterface != null)
    {
      int i = paramVideoAppInterface.a().d;
      int j = paramVideoAppInterface.a().E;
      boolean bool = paramVideoAppInterface.a().j;
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
    boolean bool2 = true;
    boolean bool3 = false;
    paramAVActivity = paramAVActivity.jdField_a_of_type_ComTencentAvVideoController;
    boolean bool1 = bool3;
    if (paramAVActivity != null)
    {
      int i = paramAVActivity.a().d;
      bool1 = bool3;
      if (1 == paramAVActivity.a().E) {
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
  
  private void e(long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, true);
    boolean bool3 = llg.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (lro.b()) {
      lro.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    lek.c("EffectSettingUi", "initBtn:" + bool2 + "|" + bool3);
    boolean bool4 = ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    a(bool3, EffectToolbar.class);
    a(bool2, FaceToolbar.class);
    a(bool2, DoodleToolbar.class);
    a(true, BeautyToolbar.class);
    a(true, VoiceChangeToolbar.class);
    int i;
    if ((bool2) && (bool4))
    {
      a(bool1, ZimuToolbar.class);
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        if (!(this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i) instanceof FaceToolbar)) {
          break label359;
        }
        if (((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch == null)
        {
          ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch = lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtn, 3);
          if (((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch != null)
          {
            int j = (int)mww.b(getContext(), ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtn.getPaddingRight());
            int k = (int)mww.b(getContext(), ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtn.getPaddingTop());
            ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).mEffectBtnRedTouch.a(0, j, k, 0).a();
          }
        }
      }
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoController != null) {
        setSelectedBtn(localVideoController.a().X);
      }
      c();
      return;
      bool1 = false;
      break;
      label359:
      i += 1;
    }
  }
  
  private void f()
  {
    if (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false)) {}
    do
    {
      do
      {
        return;
      } while ((!msp.a()) || ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(7) != null));
      a();
      mrs localmrs = msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a();
      if ((localmrs != null) && (localmrs.jdField_a_of_type_Boolean))
      {
        b();
        return;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("EffectSettingUi", 4, "先不创建红包固定按钮");
  }
  
  private void g()
  {
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367759);
    ViewTreeObserver localViewTreeObserver = localHorizontalScrollView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new mfu(this, localViewTreeObserver, localHorizontalScrollView));
  }
  
  private void h()
  {
    Button localButton = (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372572);
    localButton.setOnClickListener(new mfv(this));
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
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a() == null)) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Mry != null) {
      return;
    }
    this.jdField_a_of_type_Mry = new mft(this);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "listenAVRedBagEvent");
    }
    msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(new WeakReference(this.jdField_a_of_type_Mry));
  }
  
  public void a(int paramInt)
  {
    long l = AudioHelper.b();
    QLog.w("EffectSettingUi", 1, "exitSubEffectPanel, ExitID[" + paramInt + "], mCurSelectedId[" + this.jdField_a_of_type_Int + "], isShown[" + isShown() + "], seq[" + l + "]");
    int i;
    if (this.jdField_a_of_type_Int == paramInt)
    {
      i = a(-1, paramInt);
      if (!isShown()) {
        break label113;
      }
      if (i > paramInt) {
        b(l, true);
      }
    }
    else
    {
      return;
    }
    a(i, paramInt);
    return;
    label113:
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (localBaseToolbar != null) {
      localBaseToolbar.hideToolbar(l);
    }
    setCurSelectedId(-1, "exitSubEffectPanel");
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
    b(paramLong);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("EffectSettingUi", 1, "updateBtnStatus, reselect[" + paramBoolean + "], mCurSelectedId[" + this.jdField_a_of_type_Int + "], isShown[" + isShown() + "], seq[" + paramLong + "]");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).updateBtnStatus();
      i += 1;
    }
    if (paramBoolean)
    {
      BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
      if (localBaseToolbar != null) {
        localBaseToolbar.hideToolbar(paramLong);
      }
      setCurSelectedId(-1, "updateBtnStatus");
    }
    if (isShown()) {
      a(this.jdField_a_of_type_Int, -1);
    }
  }
  
  void a(Boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      if (paramBoolean.booleanValue()) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(paramInt1);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(paramInt2);
  }
  
  boolean a()
  {
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvUiVideoControlUI.h()) {
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
    f();
    e();
    int i = this.jdField_a_of_type_Int;
    if (paramInt != -1) {
      i = paramInt;
    }
    i = a(i, -1);
    QLog.w("EffectSettingUi", 1, "show, EffectBtnID 原[" + this.jdField_a_of_type_Int + "], 期望[" + paramInt + "], 最终[" + i + "], seq[" + paramLong + "]");
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131695826), 1).a();
      meb.a();
      return isShown();
    }
    azgg.a().b();
    loz.a().c();
    meb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().E, a());
    Object localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if (localObject != null) {
      ((BaseToolbar)localObject).performClick();
    }
    mso.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(7));
    localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
    if ((localObject != null) && (((lid)localObject).g()) && (((lid)localObject).d == 2)) {
      azqs.b(null, "dc00898", "", "", "0X8008AD5", "0X8008AD5", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public boolean a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int j = 1;
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramLong);
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    int k = this.jdField_a_of_type_Int;
    if (localBaseToolbar != null) {}
    for (boolean bool = localBaseToolbar.tryShowToolbar(paramLong, this.c, k, paramBoolean);; bool = true)
    {
      QLog.w("EffectSettingUi", 1, "tryShowToolbar, SelectedId[" + k + "->" + paramInt + "], bFromPerformClick[" + paramBoolean + "], showToolbar[" + bool + "], seq[" + paramLong + "]");
      if (bool)
      {
        int i = j;
        Object localObject;
        if (k != paramInt)
        {
          localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(k);
          setCurSelectedId(paramInt, "tryShowToolbar");
          if ((localObject != null) && (this.jdField_a_of_type_Int != k)) {
            ((BaseToolbar)localObject).hideToolbar(paramLong);
          }
          if (this.jdField_a_of_type_Int == 7) {
            lvt.a().a(8);
          }
          if (k == 7) {
            lvt.a().b(8);
          }
          ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).g(paramLong);
          localObject = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367759);
          if (paramInt == 1) {
            i = j;
          }
        }
        else
        {
          if (i > 7) {
            break label437;
          }
          localObject = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
          if ((localObject != null) && (i != paramInt)) {
            break label318;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          i = j;
          if (paramInt != 7) {
            break;
          }
          ((HorizontalScrollView)localObject).fullScroll(66);
          i = j;
          break;
          label318:
          if (((BaseToolbar)localObject).isAvailable())
          {
            ((BaseToolbar)localObject).hideToolbar(paramLong);
            if (QLog.isColorLevel()) {
              QLog.i("EffectSettingUi", 2, "tryShowToolbar, check fail, id[" + i + "]");
            }
          }
        }
      }
      else if (paramInt == 1)
      {
        if (!a((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
          break label496;
        }
        azqk.a("0X8007F27");
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("EffectSettingUi", 4, String.format("按钮点击失败, lastSelectedId[%s], newSelectId[%s]", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) }));
        }
        label437:
        if (localBaseToolbar != null)
        {
          localBaseToolbar.onButtonClick(k, paramBoolean, bool);
          if ((bool) && ((localBaseToolbar instanceof FaceToolbar)) && (localBaseToolbar.mEffectBtnRedTouch != null))
          {
            lyc.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, localBaseToolbar.mEffectBtnRedTouch, 3);
            localBaseToolbar.mEffectBtnRedTouch = null;
          }
        }
        return bool;
        label496:
        if (b((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
          azqk.a("0X8007F2D");
        }
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while (!a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, false));
      if (!lsa.e())
      {
        QLog.d("EffectSettingUi", 1, "createRedBagBtn, ptu的so没加载成功, soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "], ptuSoVersion[" + GraphicRenderMgr.ptuSoVersion + "]");
        return;
      }
    } while ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(7) != null);
    if (QLog.isDevelopLevel()) {
      QLog.d("EffectSettingUi", 4, "创建红包入口");
    }
    a(true, RedbagToolbar.class);
    c();
    msp.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).b("EffectSettingUi");
  }
  
  void b(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("EffectSettingUi", 1, "initUI, seq[" + paramLong + "]");
    }
    setGravity(80);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getLayoutInflater().inflate(2131559558, this).findViewById(2131372631));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new mfw(this));
    ViewGroup localViewGroup = (ViewGroup)getParent();
    this.c = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372904));
    this.b = ((RelativeLayout)findViewById(2131372635));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.b.findViewById(2131369499));
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2, null);
    g();
    e(paramLong);
    h();
    d();
    if (AudioHelper.a(0) == 1)
    {
      setBackgroundColor(-256);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-65281);
      this.c.setBackgroundColor(-16711936);
      localViewGroup.setBackgroundColor(-1);
      findViewById(2131372635).setBackgroundColor(-7829368);
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Mfp != null) {
      this.jdField_a_of_type_Mfp.b();
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(6105), Integer.valueOf(100), Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null));
    Resources localResources = ((AVActivity)localObject).getResources();
    HorizontalScrollView localHorizontalScrollView = (HorizontalScrollView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367759);
    if (localHorizontalScrollView.getTag() == null)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, 等待onGlobalLayout");
      return;
    }
    int j = ((AVActivity)localObject).getWindow().getDecorView().getWidth() - aepi.a(60.0F, localResources);
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
    int m = (int)localResources.getDimension(2131297555);
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
        break label408;
      }
    }
    label408:
    for (i = m / 2 - i1;; i = m / 2 + m - i1)
    {
      QLog.w("EffectSettingUi", 1, "adjustScrollView, winW[" + ((AVActivity)localObject).getWindow().getDecorView().getWidth() + "], winShowW[" + j + "], btnsW[" + k + "], qav_effect_btn_width[" + m + "], hideW[" + n + "], oneHideW[" + i1 + "], move[" + i + "]");
      localObject = (RelativeLayout.LayoutParams)localHorizontalScrollView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).setMargins(i, 0, 0, 0);
      localHorizontalScrollView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  void c(long paramLong)
  {
    d(paramLong);
    this.jdField_a_of_type_Mry = null;
    if (this.jdField_a_of_type_Mfp != null)
    {
      this.jdField_a_of_type_Mfp.c();
      this.jdField_a_of_type_Mfp = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    URLDrawable.clearMemoryCache();
    if (!((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e)
    {
      VideoController localVideoController = ((AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentAvVideoController;
      if ((localVideoController != null) && (localVideoController.a().g != 0) && (localVideoController.a().g != 7)) {
        localVideoController.a().X = this.jdField_a_of_type_Int;
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  }
  
  void d()
  {
    int i;
    if (AudioHelper.a(3) == 1)
    {
      AudioHelper.a(alud.a(2131704381));
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
        break label89;
      }
    }
    label89:
    for (int j = -65536;; j = -16711936)
    {
      ((Button)localObject).setBackgroundColor(j);
      i += 1;
      break;
    }
  }
  
  void d(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      ((BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).destroy(paramLong, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      i += 1;
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  void e()
  {
    if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().j)
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
    BaseToolbar localBaseToolbar = (BaseToolbar)this.jdField_a_of_type_AndroidUtilSparseArray.get(1);
    if (localBaseToolbar != null) {
      localBaseToolbar.updateBtnStatus();
    }
    a(1, true);
    a(5, true);
    a(4, true);
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
  
  public void setCurSelectedId(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectSettingUi", 2, "setCurSelectedId, [" + this.jdField_a_of_type_Int + "--->" + paramInt + "], from[" + paramString + "]");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.EffectSettingUi
 * JD-Core Version:    0.7.0.1
 */