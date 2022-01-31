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
import bdgk;
import bhxm;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import ors;
import pgd;
import psy;
import qiu;
import qjs;
import rpv;
import rpx;
import rru;
import rug;
import rvh;
import rvj;
import sgm;
import sgn;
import sgo;
import sgr;
import syp;

public class ReadInJoyXListView
  extends ReadInJoyBaseListView
  implements rug
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ThreadLocal<Integer> jdField_a_of_type_JavaLangThreadLocal = new rvh(this);
  private rpx jdField_a_of_type_Rpx;
  private sgm jdField_a_of_type_Sgm;
  private sgn jdField_a_of_type_Sgn;
  public float[] a;
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
    ors.b().post(new ReadInJoyXListView.3(this, paramBoolean));
  }
  
  private void d(int paramInt)
  {
    int m = 0;
    if ((this.jdField_f_of_type_Boolean) || (this.jdField_h_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_JavaLangThreadLocal.set(Integer.valueOf(paramInt));
    int k;
    if (qiu.b(getContext(), 0) != null)
    {
      k = 1;
      label42:
      if ((!(this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager)) || ((paramInt != 2) && (paramInt != 3)) || (this.jdField_d_of_type_Int != 0) || (k == 0)) {
        break label223;
      }
      k = 1;
      label75:
      if (k == 0) {
        break label234;
      }
      this.jdField_a_of_type_Sgm.a();
      if (!qjs.a()) {
        break label228;
      }
      int n = Aladdin.getConfig(189).getIntegerFromString("banner_refresh_length", 0);
      if (n > 0)
      {
        float f1 = bdgk.d() / 160.0F;
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
      if ((!this.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Sgm != null)) {
        this.jdField_a_of_type_Sgm.a();
      }
      if ((this.jdField_a_of_type_Sgm == null) || (k == 0)) {
        break;
      }
      setOverScrollHeight(this.jdField_a_of_type_Sgm.a());
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
      if ((getAdapter() instanceof bhxm)) {
        setAdapter(((bhxm)getAdapter()).getWrappedAdapter());
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
    if ((this.jdField_a_of_type_Sgm != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Sgm.a(this);
      setOverScrollHeader(this.jdField_a_of_type_Sgm.a(this));
      setOverScrollListener(this);
      setOverScrollHeight(this.jdField_a_of_type_Sgm.a());
      if ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager)) {
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
  
  public sgm a(int paramInt)
  {
    if (this.j == paramInt) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 1, "setAnimType animType = " + paramInt);
    }
    if ((this.jdField_a_of_type_Sgm != null) && ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager))) {
      this.jdField_a_of_type_Sgm.d();
    }
    this.jdField_a_of_type_Sgm = sgr.a(getContext(), paramInt);
    if (this.jdField_a_of_type_Sgn != null) {
      this.jdField_a_of_type_Sgm.a(this.jdField_a_of_type_Sgn);
    }
    if (this.jdField_d_of_type_Boolean) {
      g();
    }
    return this.jdField_a_of_type_Sgm;
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Sgm == null) || (paramView != this.jdField_a_of_type_Sgm.a(this)) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Sgm.a(paramInt2, this.jdField_f_of_type_Boolean);
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ReadInJoyXListView);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(1, false);
    paramContext.recycle();
    this.jdField_f_of_type_Int = ((int)bdgk.j());
    this.jdField_i_of_type_Int = getLayerType();
  }
  
  public void a(View paramView, ListView paramListView, int paramInt)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Sgm == null) || (paramView != this.jdField_a_of_type_Sgm.a(this)) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Sgm.a(paramInt, this.mTouchMode);
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
  
  public void a(sgo paramsgo)
  {
    if (this.jdField_a_of_type_Sgm != null) {
      this.jdField_a_of_type_Sgm.a(paramsgo);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_Sgm != null) && (this.jdField_f_of_type_Boolean))
    {
      a(Aladdin.getConfig(222).getIntegerFromString("refresh_bar_animation_total_time", 1000));
      this.jdField_a_of_type_Sgm.a(paramBoolean, paramString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    do
    {
      return true;
      paramInt = ((Integer)this.jdField_a_of_type_JavaLangThreadLocal.get()).intValue();
      this.jdField_a_of_type_JavaLangThreadLocal.set(Integer.valueOf(0));
    } while ((this.jdField_f_of_type_Boolean) || (this.jdField_a_of_type_Sgm == null) || (paramView != this.jdField_a_of_type_Sgm.a(this)));
    if (!this.jdField_e_of_type_Boolean)
    {
      paramView = this.jdField_a_of_type_Sgm;
      if (paramInt == 0) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      paramView.a(bool);
      if (this.jdField_a_of_type_Rru == null) {
        break;
      }
      c(true);
      this.jdField_a_of_type_Rru.a(this, paramInt);
      return true;
    }
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadInJoyXListView", 1, new Object[] { "beginRefresh, refreshType = ", Integer.valueOf(paramInt), ", mIsTopRefreshing = ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    post(new ReadInJoyXListView.2(this, paramInt));
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {}
    while ((this.jdField_a_of_type_Sgm == null) || (paramView != this.jdField_a_of_type_Sgm.a(this)) || (this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Sgm.a(100, false);
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      e(2);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Sgm != null)
    {
      this.jdField_a_of_type_Sgm.d();
      this.jdField_a_of_type_Sgm = null;
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
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this)) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Sgm.c();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_Sgm != null) && ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_Sgm).e();
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
      continue;
      this.jdField_h_of_type_Int = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.jdField_b_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
      this.jdField_b_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_Sgm != null) && ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager))) {
      ((ReadInJoySkinAnimManager)this.jdField_a_of_type_Sgm).f();
    }
  }
  
  public void f()
  {
    c(1);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Sgm != null) && (this.jdField_f_of_type_Boolean)) {
      a(0L);
    }
  }
  
  public void i()
  {
    c(false);
    springBackOverScrollHeaderView();
    if (this.jdField_a_of_type_Rru != null) {
      this.jdField_a_of_type_Rru.b();
    }
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_Sgm != null) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_Sgm.b();
    }
  }
  
  public void initPaddingManual()
  {
    super.initPaddingManual();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyXListView", 2, "initPaddingManual  mPaddingTop=" + this.mPaddingTop + ",mListPadding.top=" + this.mListPadding.top);
    }
    if ((this.mListPadding.top == 0) && (this.mPaddingTop > 0)) {
      this.mListPadding.top = this.mPaddingTop;
    }
    if ((this.mListPadding.bottom == 0) && (this.mPaddingBottom > 0)) {
      this.mListPadding.bottom = this.mPaddingBottom;
    }
    if ((this.mListPadding.left == 0) && (this.mPaddingLeft > 0)) {
      this.mListPadding.left = this.mPaddingLeft;
    }
    if ((this.mListPadding.right == 0) && (this.mPaddingRight > 0)) {
      this.mListPadding.right = this.mPaddingRight;
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
    if (((paramView instanceof rpv)) && (!((rpv)paramView).a()))
    {
      ((rpv)paramView).setIsResume(true);
      ((rpv)paramView).a();
    }
    if ((paramView instanceof ProteusItemView))
    {
      paramView = (ProteusItemView)paramView;
      if ((paramView.a().a() != null) && (paramView.a().a().a() != null) && (paramView.a().a().a().mResolvedFeedType == 123) && (this.jdField_a_of_type_Rpx != null)) {
        this.jdField_a_of_type_Rpx.a();
      }
    }
  }
  
  public void onDetachChildView(View paramView)
  {
    if (((paramView instanceof rpv)) && (((rpv)paramView).a()))
    {
      ((rpv)paramView).setIsResume(false);
      ((rpv)paramView).b();
    }
    if ((paramView instanceof ProteusItemView))
    {
      paramView = (ProteusItemView)paramView;
      if ((paramView.a().a() != null) && (paramView.a().a().a() != null) && (paramView.a().a().a().mResolvedFeedType == 123) && (this.jdField_a_of_type_Rpx != null)) {
        this.jdField_a_of_type_Rpx.b();
      }
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new rvj(this));
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      syp.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE", null);
      syp.a(null, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW");
      this.jdField_i_of_type_Boolean = false;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
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
      paramAbsListView = ors.a(getContext());
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
    while ((this.jdField_a_of_type_Sgm != null) && (this.jdField_a_of_type_Sgm.a(paramMotionEvent)))
    {
      return true;
      this.jdField_e_of_type_Int = ((int)paramMotionEvent.getRawY());
      continue;
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY() - this.jdField_e_of_type_Int);
      continue;
      FrameHelperActivity.c(true);
      if ((this.jdField_a_of_type_Sgm != null) && ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager)) && (((ReadInJoySkinAnimManager)this.jdField_a_of_type_Sgm).a())) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
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
  
  public void setNoteCardLifeCycle(rpx paramrpx)
  {
    this.jdField_a_of_type_Rpx = paramrpx;
  }
  
  public void setRefreshPullDistanceListener(sgn paramsgn)
  {
    this.jdField_a_of_type_Sgn = paramsgn;
    if (this.jdField_a_of_type_Sgm != null) {
      this.jdField_a_of_type_Sgm.a(paramsgn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView
 * JD-Core Version:    0.7.0.1
 */