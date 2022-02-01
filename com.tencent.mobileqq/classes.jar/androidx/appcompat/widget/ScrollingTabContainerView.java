package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.HorizontalScrollView;
import android.widget.Spinner;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar.Tab;
import androidx.appcompat.view.ActionBarPolicy;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final int FADE_DURATION = 200;
  private static final String TAG = "ScrollingTabContainerView";
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private ScrollingTabContainerView.TabClickListener mTabClickListener;
  LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private Spinner mTabSpinner;
  protected final ScrollingTabContainerView.VisibilityAnimListener mVisAnimListener = new ScrollingTabContainerView.VisibilityAnimListener(this);
  protected ViewPropertyAnimator mVisibilityAnim;
  
  public ScrollingTabContainerView(Context paramContext)
  {
    super(paramContext);
    setHorizontalScrollBarEnabled(false);
    paramContext = ActionBarPolicy.get(paramContext);
    setContentHeight(paramContext.getTabContainerHeight());
    this.mStackedTabMaxWidth = paramContext.getStackedTabMaxWidth();
    this.mTabLayout = createTabLayout();
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
  }
  
  private Spinner createSpinner()
  {
    AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, 2131034129);
    localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    localAppCompatSpinner.setOnItemSelectedListener(this);
    return localAppCompatSpinner;
  }
  
  private LinearLayoutCompat createTabLayout()
  {
    LinearLayoutCompat localLinearLayoutCompat = new LinearLayoutCompat(getContext(), null, 2131034123);
    localLinearLayoutCompat.setMeasureWithLargestChildEnabled(true);
    localLinearLayoutCompat.setGravity(17);
    localLinearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
    return localLinearLayoutCompat;
  }
  
  private boolean isCollapsed()
  {
    Spinner localSpinner = this.mTabSpinner;
    return (localSpinner != null) && (localSpinner.getParent() == this);
  }
  
  private void performCollapse()
  {
    if (isCollapsed()) {
      return;
    }
    if (this.mTabSpinner == null) {
      this.mTabSpinner = createSpinner();
    }
    removeView(this.mTabLayout);
    addView(this.mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
    if (this.mTabSpinner.getAdapter() == null) {
      this.mTabSpinner.setAdapter(new ScrollingTabContainerView.TabAdapter(this));
    }
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null)
    {
      removeCallbacks(localRunnable);
      this.mTabSelector = null;
    }
    this.mTabSpinner.setSelection(this.mSelectedTabIndex);
  }
  
  private boolean performExpand()
  {
    if (!isCollapsed()) {
      return false;
    }
    removeView(this.mTabSpinner);
    addView(this.mTabLayout, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(this.mTabSpinner.getSelectedItemPosition());
    return false;
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    paramTab = createTabView(paramTab, false);
    this.mTabLayout.addView(paramTab, paramInt, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramTab.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    paramTab = createTabView(paramTab, false);
    this.mTabLayout.addView(paramTab, new LinearLayoutCompat.LayoutParams(0, -1, 1.0F));
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (paramBoolean) {
      paramTab.setSelected(true);
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void animateToTab(int paramInt)
  {
    View localView = this.mTabLayout.getChildAt(paramInt);
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
    this.mTabSelector = new ScrollingTabContainerView.1(this, localView);
    post(this.mTabSelector);
  }
  
  public void animateToVisibility(int paramInt)
  {
    ViewPropertyAnimator localViewPropertyAnimator = this.mVisibilityAnim;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localViewPropertyAnimator = animate().alpha(1.0F);
      localViewPropertyAnimator.setDuration(200L);
      localViewPropertyAnimator.setInterpolator(sAlphaInterpolator);
      localViewPropertyAnimator.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimator, paramInt));
      localViewPropertyAnimator.start();
      return;
    }
    localViewPropertyAnimator = animate().alpha(0.0F);
    localViewPropertyAnimator.setDuration(200L);
    localViewPropertyAnimator.setInterpolator(sAlphaInterpolator);
    localViewPropertyAnimator.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimator, paramInt));
    localViewPropertyAnimator.start();
  }
  
  ScrollingTabContainerView.TabView createTabView(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    paramTab = new ScrollingTabContainerView.TabView(this, getContext(), paramTab, paramBoolean);
    if (paramBoolean)
    {
      paramTab.setBackgroundDrawable(null);
      paramTab.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContentHeight));
      return paramTab;
    }
    paramTab.setFocusable(true);
    if (this.mTabClickListener == null) {
      this.mTabClickListener = new ScrollingTabContainerView.TabClickListener(this);
    }
    paramTab.setOnClickListener(this.mTabClickListener);
    return paramTab;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null) {
      post(localRunnable);
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = ActionBarPolicy.get(getContext());
    setContentHeight(paramConfiguration.getTabContainerHeight());
    this.mStackedTabMaxWidth = paramConfiguration.getStackedTabMaxWidth();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Runnable localRunnable = this.mTabSelector;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((ScrollingTabContainerView.TabView)paramView).getTab().select();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = 1;
    boolean bool;
    if (i == 1073741824) {
      bool = true;
    } else {
      bool = false;
    }
    setFillViewport(bool);
    int j = this.mTabLayout.getChildCount();
    if ((j > 1) && ((i == 1073741824) || (i == -2147483648)))
    {
      if (j > 2) {
        this.mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      } else {
        this.mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      }
      this.mMaxTabWidth = Math.min(this.mMaxTabWidth, this.mStackedTabMaxWidth);
    }
    else
    {
      this.mMaxTabWidth = -1;
    }
    i = View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824);
    if ((bool) || (!this.mAllowCollapse)) {
      paramInt2 = 0;
    }
    if (paramInt2 != 0)
    {
      this.mTabLayout.measure(0, i);
      if (this.mTabLayout.getMeasuredWidth() > View.MeasureSpec.getSize(paramInt1)) {
        performCollapse();
      } else {
        performExpand();
      }
    }
    else
    {
      performExpand();
    }
    paramInt2 = getMeasuredWidth();
    super.onMeasure(paramInt1, i);
    paramInt1 = getMeasuredWidth();
    if ((bool) && (paramInt2 != paramInt1)) {
      setTabSelected(this.mSelectedTabIndex);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void removeAllTabs()
  {
    this.mTabLayout.removeAllViews();
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mTabLayout.removeViewAt(paramInt);
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
  
  public void setAllowCollapse(boolean paramBoolean)
  {
    this.mAllowCollapse = paramBoolean;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setTabSelected(int paramInt)
  {
    this.mSelectedTabIndex = paramInt;
    int j = this.mTabLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = this.mTabLayout.getChildAt(i);
      boolean bool;
      if (i == paramInt) {
        bool = true;
      } else {
        bool = false;
      }
      ((View)localObject).setSelected(bool);
      if (bool) {
        animateToTab(paramInt);
      }
      i += 1;
    }
    Object localObject = this.mTabSpinner;
    if ((localObject != null) && (paramInt >= 0)) {
      ((Spinner)localObject).setSelection(paramInt);
    }
  }
  
  public void updateTab(int paramInt)
  {
    ((ScrollingTabContainerView.TabView)this.mTabLayout.getChildAt(paramInt)).update();
    Spinner localSpinner = this.mTabSpinner;
    if (localSpinner != null) {
      ((ScrollingTabContainerView.TabAdapter)localSpinner.getAdapter()).notifyDataSetChanged();
    }
    if (this.mAllowCollapse) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ScrollingTabContainerView
 * JD-Core Version:    0.7.0.1
 */