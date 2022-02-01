package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R.attr;
import androidx.appcompat.R.styleable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

abstract class AbsActionBarView
  extends ViewGroup
{
  private static final int FADE_DURATION = 200;
  protected ActionMenuPresenter mActionMenuPresenter;
  protected int mContentHeight;
  private boolean mEatingHover;
  private boolean mEatingTouch;
  protected ActionMenuView mMenuView;
  protected final Context mPopupContext;
  protected final AbsActionBarView.VisibilityAnimListener mVisAnimListener = new AbsActionBarView.VisibilityAnimListener(this);
  protected ViewPropertyAnimatorCompat mVisibilityAnim;
  
  AbsActionBarView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  AbsActionBarView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsActionBarView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.mPopupContext = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.mPopupContext = paramContext;
  }
  
  protected static int next(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  public void animateToVisibility(int paramInt)
  {
    setupAnimatorToVisibility(paramInt, 200L).start();
  }
  
  public boolean canShowOverflowMenu()
  {
    return (isOverflowReserved()) && (getVisibility() == 0);
  }
  
  public void dismissPopupMenus()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      localActionMenuPresenter.dismissPopupMenus();
    }
  }
  
  public int getAnimatedVisibility()
  {
    if (this.mVisibilityAnim != null) {
      return this.mVisAnimListener.mFinalVisibility;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.mContentHeight;
  }
  
  public boolean hideOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.hideOverflowMenu();
    }
    return false;
  }
  
  public boolean isOverflowMenuShowPending()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.isOverflowMenuShowPending();
    }
    return false;
  }
  
  public boolean isOverflowMenuShowing()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.isOverflowMenuShowing();
    }
    return false;
  }
  
  public boolean isOverflowReserved()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    return (localActionMenuPresenter != null) && (localActionMenuPresenter.isOverflowReserved());
  }
  
  protected int measureChildView(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(((TypedArray)localObject).getLayoutDimension(R.styleable.ActionBar_height, 0));
    ((TypedArray)localObject).recycle();
    localObject = this.mActionMenuPresenter;
    if (localObject != null) {
      ((ActionMenuPresenter)localObject).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.mEatingHover = false;
    }
    if (!this.mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.mEatingHover = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.mEatingHover = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.mEatingTouch = false;
    }
    if (!this.mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.mEatingTouch = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.mEatingTouch = false;
    }
    return true;
  }
  
  protected int positionChild(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    } else {
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
    paramInt1 = i;
    if (paramBoolean) {
      paramInt1 = -i;
    }
    return paramInt1;
  }
  
  public void postShowOverflowMenu()
  {
    post(new AbsActionBarView.1(this));
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = this.mVisibilityAnim;
      if (localViewPropertyAnimatorCompat != null) {
        localViewPropertyAnimatorCompat.cancel();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int paramInt, long paramLong)
  {
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = this.mVisibilityAnim;
    if (localViewPropertyAnimatorCompat != null) {
      localViewPropertyAnimatorCompat.cancel();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localViewPropertyAnimatorCompat = ViewCompat.animate(this).alpha(1.0F);
      localViewPropertyAnimatorCompat.setDuration(paramLong);
      localViewPropertyAnimatorCompat.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat, paramInt));
      return localViewPropertyAnimatorCompat;
    }
    localViewPropertyAnimatorCompat = ViewCompat.animate(this).alpha(0.0F);
    localViewPropertyAnimatorCompat.setDuration(paramLong);
    localViewPropertyAnimatorCompat.setListener(this.mVisAnimListener.withFinalVisibility(localViewPropertyAnimatorCompat, paramInt));
    return localViewPropertyAnimatorCompat;
  }
  
  public boolean showOverflowMenu()
  {
    ActionMenuPresenter localActionMenuPresenter = this.mActionMenuPresenter;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AbsActionBarView
 * JD-Core Version:    0.7.0.1
 */