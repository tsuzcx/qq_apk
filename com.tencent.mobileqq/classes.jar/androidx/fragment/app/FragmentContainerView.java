package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.R.styleable;
import java.util.ArrayList;

public final class FragmentContainerView
  extends FrameLayout
{
  private ArrayList<View> mDisappearingFragmentChildren;
  private boolean mDrawDisappearingViewsFirst = true;
  private ArrayList<View> mTransitioningFragmentViews;
  
  public FragmentContainerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FragmentContainerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FragmentContainerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {
      return;
    }
    throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to be instantiated from XML.");
  }
  
  FragmentContainerView(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, @NonNull FragmentManager paramFragmentManager)
  {
    super(paramContext, paramAttributeSet);
    String str = paramAttributeSet.getClassAttribute();
    Object localObject2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FragmentContainerView);
    Object localObject1 = str;
    if (str == null) {
      localObject1 = ((TypedArray)localObject2).getString(R.styleable.FragmentContainerView_android_name);
    }
    str = ((TypedArray)localObject2).getString(R.styleable.FragmentContainerView_android_tag);
    ((TypedArray)localObject2).recycle();
    int i = getId();
    localObject2 = paramFragmentManager.findFragmentById(i);
    if ((localObject1 != null) && (localObject2 == null))
    {
      if (i <= 0)
      {
        if (str != null)
        {
          paramContext = new StringBuilder();
          paramContext.append(" with tag ");
          paramContext.append(str);
          paramContext = paramContext.toString();
        }
        else
        {
          paramContext = "";
        }
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append("FragmentContainerView must have an android:id to add Fragment ");
        paramAttributeSet.append((String)localObject1);
        paramAttributeSet.append(paramContext);
        throw new IllegalStateException(paramAttributeSet.toString());
      }
      localObject1 = paramFragmentManager.getFragmentFactory().instantiate(paramContext.getClassLoader(), (String)localObject1);
      ((Fragment)localObject1).onInflate(paramContext, paramAttributeSet, null);
      paramFragmentManager.beginTransaction().setReorderingAllowed(true).add(this, (Fragment)localObject1, str).commitNowAllowingStateLoss();
    }
  }
  
  private void addDisappearingFragmentView(@NonNull View paramView)
  {
    if (paramView.getAnimation() == null)
    {
      ArrayList localArrayList = this.mTransitioningFragmentViews;
      if ((localArrayList == null) || (!localArrayList.contains(paramView))) {}
    }
    else
    {
      if (this.mDisappearingFragmentChildren == null) {
        this.mDisappearingFragmentChildren = new ArrayList();
      }
      this.mDisappearingFragmentChildren.add(paramView);
    }
  }
  
  public void addView(@NonNull View paramView, int paramInt, @Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    if (FragmentManager.getViewFragment(paramView) != null)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  protected boolean addViewInLayout(@NonNull View paramView, int paramInt, @Nullable ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if (FragmentManager.getViewFragment(paramView) != null) {
      return super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
    paramLayoutParams.append(paramView);
    paramLayoutParams.append(" is not associated with a Fragment.");
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  protected void dispatchDraw(@NonNull Canvas paramCanvas)
  {
    if ((this.mDrawDisappearingViewsFirst) && (this.mDisappearingFragmentChildren != null))
    {
      int i = 0;
      while (i < this.mDisappearingFragmentChildren.size())
      {
        super.drawChild(paramCanvas, (View)this.mDisappearingFragmentChildren.get(i), getDrawingTime());
        i += 1;
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected boolean drawChild(@NonNull Canvas paramCanvas, @NonNull View paramView, long paramLong)
  {
    if (this.mDrawDisappearingViewsFirst)
    {
      ArrayList localArrayList = this.mDisappearingFragmentChildren;
      if ((localArrayList != null) && (localArrayList.size() > 0) && (this.mDisappearingFragmentChildren.contains(paramView))) {
        return false;
      }
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void endViewTransition(@NonNull View paramView)
  {
    ArrayList localArrayList = this.mTransitioningFragmentViews;
    if (localArrayList != null)
    {
      localArrayList.remove(paramView);
      localArrayList = this.mDisappearingFragmentChildren;
      if ((localArrayList != null) && (localArrayList.remove(paramView))) {
        this.mDrawDisappearingViewsFirst = true;
      }
    }
    super.endViewTransition(paramView);
  }
  
  @NonNull
  @RequiresApi(20)
  public WindowInsets onApplyWindowInsets(@NonNull WindowInsets paramWindowInsets)
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).dispatchApplyWindowInsets(new WindowInsets(paramWindowInsets));
      i += 1;
    }
    return paramWindowInsets;
  }
  
  public void removeAllViewsInLayout()
  {
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      addDisappearingFragmentView(getChildAt(i));
      i -= 1;
    }
    super.removeAllViewsInLayout();
  }
  
  protected void removeDetachedView(@NonNull View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      addDisappearingFragmentView(paramView);
    }
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeView(@NonNull View paramView)
  {
    addDisappearingFragmentView(paramView);
    super.removeView(paramView);
  }
  
  public void removeViewAt(int paramInt)
  {
    addDisappearingFragmentView(getChildAt(paramInt));
    super.removeViewAt(paramInt);
  }
  
  public void removeViewInLayout(@NonNull View paramView)
  {
    addDisappearingFragmentView(paramView);
    super.removeViewInLayout(paramView);
  }
  
  public void removeViews(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      addDisappearingFragmentView(getChildAt(i));
      i += 1;
    }
    super.removeViews(paramInt1, paramInt2);
  }
  
  public void removeViewsInLayout(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      addDisappearingFragmentView(getChildAt(i));
      i += 1;
    }
    super.removeViewsInLayout(paramInt1, paramInt2);
  }
  
  void setDrawDisappearingViewsLast(boolean paramBoolean)
  {
    this.mDrawDisappearingViewsFirst = paramBoolean;
  }
  
  public void setLayoutTransition(@Nullable LayoutTransition paramLayoutTransition)
  {
    if (Build.VERSION.SDK_INT < 18)
    {
      super.setLayoutTransition(paramLayoutTransition);
      return;
    }
    throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
  }
  
  public void startViewTransition(@NonNull View paramView)
  {
    if (paramView.getParent() == this)
    {
      if (this.mTransitioningFragmentViews == null) {
        this.mTransitioningFragmentViews = new ArrayList();
      }
      this.mTransitioningFragmentViews.add(paramView);
    }
    super.startViewTransition(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentContainerView
 * JD-Core Version:    0.7.0.1
 */