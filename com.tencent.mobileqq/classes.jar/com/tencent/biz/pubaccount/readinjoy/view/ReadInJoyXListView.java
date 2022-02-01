package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import blcj;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import olh;
import pno;
import pqg;
import pqx;
import qfw;
import qvp;
import rmu;
import rns;
import syp;
import syr;
import szj;
import tax;
import tbt;
import tbv;
import tnd;
import tne;
import tnf;
import tni;
import uro;
import uuq;

public class ReadInJoyXListView
  extends ReadInJoyBaseListView
  implements tax
{
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ThreadLocal<Integer> jdField_a_of_type_JavaLangThreadLocal = new tbt(this);
  private syr jdField_a_of_type_Syr;
  private tnd jdField_a_of_type_Tnd;
  private tne jdField_a_of_type_Tne;
  public float[] a;
  public long b;
  public float[] b;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  private boolean f;
  public int g;
  private boolean g;
  public int h;
  private boolean h;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = true;
  private int j = -1;
  
  public ReadInJoyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfFloat = new float[2];
    this.jdField_b_of_type_ArrayOfFloat = new float[2];
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfFloat = new float[2];
    this.jdField_b_of_type_ArrayOfFloat = new float[2];
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(214);
    if (localAladdinConfig != null)
    {
      int k = localAladdinConfig.getIntegerFromString("feeds_loading", 0);
      QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], isOpen = " + k);
      if (k == 0)
      {
        QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], do not switch layer type.");
        return;
      }
    }
    pno.b().post(new ReadInJoyXListView.3(this, paramBoolean));
  }
  
  private void d(int paramInt)
  {
    int m = 0;
    if ((this.jdField_f_of_type_Boolean) || (this.jdField_h_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_JavaLangThreadLocal.set(Integer.valueOf(paramInt));
    int k;
    if (rmu.b(getContext(), 0) != null)
    {
      k = 1;
      label42:
      if ((!(this.jdField_a_of_type_Tnd instanceof ReadInJoySkinAnimManager)) || ((paramInt != 2) && (paramInt != 3)) || (this.jdField_d_of_type_Int != 0) || (k == 0)) {
        break label223;
      }
      k = 1;
      label75:
      if (k == 0) {
        break label234;
      }
      this.jdField_a_of_type_Tnd.a();
      if (!rns.a()) {
        break label228;
      }
      int n = Aladdin.getConfig(189).getIntegerFromString("banner_refresh_length", 0);
      if (n > 0)
      {
        float f1 = DeviceInfoUtil.getDispalyDpi() / 160.0F;
        setOverScrollHeight((int)(n * f1));
        m = k;
      }
      label133:
      k = m;
      if (QLog.isColorLevel())
      {
        QLog.d("ReadInJoyXListView", 2, "changeRefreshAreaHeight with refreshType：" + paramInt);
        k = m;
      }
    }
    label223:
    label228:
    label234:
    for (;;)
    {
      showOverScrollHeader();
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Tnd != null)) {
        this.jdField_a_of_type_Tnd.a();
      }
      if ((this.jdField_a_of_type_Tnd == null) || (k == 0)) {
        break;
      }
      setOverScrollHeight(this.jdField_a_of_type_Tnd.a());
      return;
      k = 0;
      break label42;
      k = 0;
      break label75;
      m = k;
      break label133;
    }
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      if (this.mFirstPosition == 0)
      {
        QLog.d("ReadInJoyXListView", 2, "scroll2Top : stop on top,refresh ! from : " + paramInt);
        d(1);
        this.jdField_g_of_type_Boolean = false;
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyXListView", 2, "scroll2Top : not on top, jump to top and refresh. from : " + paramInt);
    if (paramInt != 3)
    {
      this.jdField_g_of_type_Boolean = false;
      if ((getAdapter() instanceof blcj)) {
        setAdapter(((blcj)getAdapter()).getWrappedAdapter());
      }
      for (;;)
      {
        d(1);
        return;
        setAdapter(getAdapter());
      }
    }
    f();
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Tnd != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Tnd.a(this);
      setOverScrollHeader(this.jdField_a_of_type_Tnd.a(this));
      setOverScrollListener(this);
      setOverScrollHeight(this.jdField_a_of_type_Tnd.a());
      if ((this.jdField_a_of_type_Tnd instanceof ReadInJoySkinAnimManager)) {
        setOverscrollHeader(new ColorDrawable(Color.parseColor("#F7F7F7")));
      }
    }
    else
    {
      return;
    }
    setOverscrollHeader(new ColorDrawable(-1));
  }
  
  public int a()
  {
    return this.mTouchMode;
  }
  
  public tnd a(int paramInt)
  {
    if (this.j == paramInt) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_Tnd != null) && ((this.jdField_a_of_type_Tnd instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_Tnd.d();
    }
    this.jdField_a_of_type_Tnd = tni.a(getContext(), paramInt);
    if (this.jdField_a_of_type_Tne != null) {
      this.jdField_a_of_type_Tnd.a(this.jdField_a_of_type_Tne);
    }
    if (this.jdField_d_of_type_Boolean) {
      g();
    }
    return this.jdField_a_of_type_Tnd;
  }
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Tnd == null) || (paramView != this.jdField_a_of_type_Tnd.a(this)) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Tnd.a(paramInt2, this.jdField_f_of_type_Boolean);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyXListView);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(1, false);
    paramContext.recycle();
    this.jdField_f_of_type_Int = ((int)DeviceInfoUtil.getPortraitHeight());
    this.jdField_i_of_type_Int = getLayerType();
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Tnd == null) || (paramView != this.jdField_a_of_type_Tnd.a(this)) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Tnd.a(paramInt, this.mTouchMode);
  }
  
  public void a(String paramString)
  {
    this.c = true;
    if (!TextUtils.isEmpty(paramString)) {
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        setFooterView(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      return;
    }
    removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void a(tnf paramtnf)
  {
    if (this.jdField_a_of_type_Tnd != null) {
      this.jdField_a_of_type_Tnd.a(paramtnf);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_Tnd != null) && (this.jdField_f_of_type_Boolean))
    {
      a(Aladdin.getConfig(222).getIntegerFromString("refresh_bar_animation_total_time", 1000));
      this.jdField_a_of_type_Tnd.a(paramBoolean, paramString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadInJoyXListView", 1, new Object[] { "beginRefresh, refreshType = ", Integer.valueOf(paramInt), ", mIsTopRefreshing = ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    post(new ReadInJoyXListView.2(this, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      e(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Tnd != null)
    {
      this.jdField_a_of_type_Tnd.d();
      this.jdField_a_of_type_Tnd = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    smoothScrollBy(0, 0);
    setSelection(0);
    d(paramInt);
    QLog.d("ReadInJoyXListView", 2, "scroll2TopAndRefresh needScroll : " + true);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Tnd != null) && ((this.jdField_a_of_type_Tnd instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_Tnd).e();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_g_of_type_Int = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
      this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      continue;
      this.jdField_h_of_type_Int = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.jdField_b_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
      this.jdField_b_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (uro.a.c())
      {
        int k = (int)Math.abs(this.jdField_b_of_type_ArrayOfFloat[0] - this.jdField_a_of_type_ArrayOfFloat[0]);
        int m = (int)Math.abs(this.jdField_b_of_type_ArrayOfFloat[1] - this.jdField_a_of_type_ArrayOfFloat[1]);
        pqg localpqg = new pqg();
        localpqg.b("downX", String.valueOf(this.jdField_a_of_type_ArrayOfFloat[0])).b("downY", String.valueOf(this.jdField_a_of_type_ArrayOfFloat[1])).b("upX", String.valueOf(this.jdField_b_of_type_ArrayOfFloat[0])).b("upY", String.valueOf(this.jdField_b_of_type_ArrayOfFloat[1])).b("xOffsetRate", String.valueOf(k * 100 / ViewUtils.getScreenWidth())).b("yOffsetRate", String.valueOf(m * 100 / ViewUtils.getScreenHeight())).b("duration", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
        olh.a("0X800AFD1", localpqg.a());
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Tnd != null) && ((this.jdField_a_of_type_Tnd instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_Tnd).f();
    }
  }
  
  public void f()
  {
    c(1);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Tnd != null) && (this.jdField_f_of_type_Boolean)) {
      a(0L);
    }
  }
  
  public void i()
  {
    c(false);
    springBackOverScrollHeaderView();
    if (this.jdField_a_of_type_Szj != null) {
      this.jdField_a_of_type_Szj.b();
    }
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Tnd != null) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Tnd.b();
    }
  }
  
  public void initPaddingManual()
  {
    super.initPaddingManual();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 2, "initPaddingManual  mPaddingTop=" + getPaddingTop() + ",mListPadding.top=" + this.mListPadding.top);
    }
    if ((this.mListPadding.top == 0) && (getPaddingTop() > 0)) {
      this.mListPadding.top = getPaddingTop();
    }
    if ((this.mListPadding.bottom == 0) && (getPaddingBottom() > 0)) {
      this.mListPadding.bottom = getPaddingBottom();
    }
    if ((this.mListPadding.left == 0) && (getPaddingLeft() > 0)) {
      this.mListPadding.left = getPaddingLeft();
    }
    if ((this.mListPadding.right == 0) && (getPaddingRight() > 0)) {
      this.mListPadding.right = getPaddingRight();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_h_of_type_Boolean = true;
    setOverScrollHeight(0);
  }
  
  public void onAttachChildView(View paramView)
  {
    if (((paramView instanceof syp)) && (!((syp)paramView).a()))
    {
      ((syp)paramView).setIsResume(true);
      ((syp)paramView).a();
    }
    if ((paramView instanceof ProteusItemView))
    {
      paramView = (ProteusItemView)paramView;
      if ((paramView.a().a() != null) && (paramView.a().a().a() != null) && (paramView.a().a().a().mResolvedFeedType == 123) && (this.jdField_a_of_type_Syr != null)) {
        this.jdField_a_of_type_Syr.a();
      }
    }
  }
  
  public void onDetachChildView(View paramView)
  {
    if (((paramView instanceof syp)) && (((syp)paramView).a()))
    {
      ((syp)paramView).setIsResume(false);
      ((syp)paramView).b();
    }
    if ((paramView instanceof ProteusItemView))
    {
      paramView = (ProteusItemView)paramView;
      if ((paramView.a().a() != null) && (paramView.a().a().a() != null) && (paramView.a().a().a().mResolvedFeedType == 123) && (this.jdField_a_of_type_Syr != null)) {
        this.jdField_a_of_type_Syr.b();
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new tbv(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      uuq.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE", null);
      uuq.a(null, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW");
      this.jdField_i_of_type_Boolean = false;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 == 0)
    {
      paramAbsListView = getChildAt(0);
      if ((paramAbsListView == null) || (paramAbsListView.getTop() < 0)) {}
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      e(3);
      if (!(getContext() instanceof ReadInJoyNewFeedsActivity)) {
        break label38;
      }
      ((ReadInJoyNewFeedsActivity)getContext()).g(8);
    }
    label38:
    do
    {
      do
      {
        return;
      } while (!(getContext() instanceof SplashActivity));
      paramAbsListView = pqx.a(getContext());
    } while (paramAbsListView == null);
    paramAbsListView.a(8);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      QLog.d("ReadInJoyXListView", 2, "scroll2Top catch user touch event!");
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.jdField_a_of_type_Tnd != null) && (this.jdField_a_of_type_Tnd.a(paramMotionEvent)))
    {
      return true;
      this.jdField_e_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY() - this.jdField_e_of_type_Int);
      continue;
      FrameHelperActivity.c(true);
      if ((this.jdField_a_of_type_Tnd != null) && ((this.jdField_a_of_type_Tnd instanceof ReadInJoySkinAnimManager)) && (((ReadInJoySkinAnimManager)this.jdField_a_of_type_Tnd).a())) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Tnd == null) || (paramView != this.jdField_a_of_type_Tnd.a(this)) || (this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Tnd.a(100, false);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    do
    {
      return true;
      paramInt = ((Integer)this.jdField_a_of_type_JavaLangThreadLocal.get()).intValue();
      this.jdField_a_of_type_JavaLangThreadLocal.set(Integer.valueOf(0));
    } while ((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Tnd == null) || (paramView != this.jdField_a_of_type_Tnd.a(this)));
    if (!this.jdField_e_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_Tnd;
      if (paramInt == 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      paramView.a(bool);
      if (this.jdField_a_of_type_Szj == null) {
        break;
      }
      c(true);
      this.jdField_a_of_type_Szj.a(this, paramInt);
      return true;
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Tnd != null) && (paramView == this.jdField_a_of_type_Tnd.a(this)) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Tnd.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      e(1);
    }
  }
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    g();
  }
  
  public void setNoteCardLifeCycle(syr paramsyr)
  {
    this.jdField_a_of_type_Syr = paramsyr;
  }
  
  public void setRefreshPullDistanceListener(tne paramtne)
  {
    this.jdField_a_of_type_Tne = paramtne;
    if (this.jdField_a_of_type_Tnd != null) {
      this.jdField_a_of_type_Tnd.a(paramtne);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView
 * JD-Core Version:    0.7.0.1
 */