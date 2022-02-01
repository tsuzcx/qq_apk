package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R.styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class CoordinatorLayout$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int anchorGravity = 0;
  public int dodgeInsetEdges = 0;
  public int gravity = 0;
  public int insetEdge = 0;
  public int keyline = -1;
  View mAnchorDirectChild;
  int mAnchorId = -1;
  View mAnchorView;
  CoordinatorLayout.Behavior mBehavior;
  boolean mBehaviorResolved = false;
  Object mBehaviorTag;
  private boolean mDidAcceptNestedScrollNonTouch;
  private boolean mDidAcceptNestedScrollTouch;
  private boolean mDidBlockInteraction;
  private boolean mDidChangeAfterNestedScroll;
  int mInsetOffsetX;
  int mInsetOffsetY;
  final Rect mLastChildRect = new Rect();
  
  public CoordinatorLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  CoordinatorLayout$LayoutParams(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CoordinatorLayout_Layout);
    this.gravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
    this.mAnchorId = localTypedArray.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
    this.anchorGravity = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
    this.keyline = localTypedArray.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
    this.insetEdge = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
    this.dodgeInsetEdges = localTypedArray.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
    this.mBehaviorResolved = localTypedArray.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
    if (this.mBehaviorResolved) {
      this.mBehavior = CoordinatorLayout.parseBehavior(paramContext, paramAttributeSet, localTypedArray.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
    }
    localTypedArray.recycle();
    paramContext = this.mBehavior;
    if (paramContext != null) {
      paramContext.onAttachedToLayoutParams(this);
    }
  }
  
  public CoordinatorLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public CoordinatorLayout$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public CoordinatorLayout$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  private void resolveAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
  {
    this.mAnchorView = paramCoordinatorLayout.findViewById(this.mAnchorId);
    View localView = this.mAnchorView;
    if (localView != null)
    {
      if (localView == paramCoordinatorLayout)
      {
        if (paramCoordinatorLayout.isInEditMode())
        {
          this.mAnchorDirectChild = null;
          this.mAnchorView = null;
          return;
        }
        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
      }
      for (localObject = localView.getParent(); (localObject != paramCoordinatorLayout) && (localObject != null); localObject = ((ViewParent)localObject).getParent())
      {
        if (localObject == paramView)
        {
          if (paramCoordinatorLayout.isInEditMode())
          {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
          }
          throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        }
        if ((localObject instanceof View)) {
          localView = (View)localObject;
        }
      }
      this.mAnchorDirectChild = localView;
      return;
    }
    if (paramCoordinatorLayout.isInEditMode())
    {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Could not find CoordinatorLayout descendant view with id ");
    ((StringBuilder)localObject).append(paramCoordinatorLayout.getResources().getResourceName(this.mAnchorId));
    ((StringBuilder)localObject).append(" to anchor view ");
    ((StringBuilder)localObject).append(paramView);
    paramView = new IllegalStateException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw paramView;
    }
  }
  
  private boolean shouldDodge(View paramView, int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).insetEdge, paramInt);
    return (i != 0) && ((GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, paramInt) & i) == i);
  }
  
  private boolean verifyAnchorView(View paramView, CoordinatorLayout paramCoordinatorLayout)
  {
    if (this.mAnchorView.getId() != this.mAnchorId) {
      return false;
    }
    View localView = this.mAnchorView;
    ViewParent localViewParent = localView.getParent();
    while (localViewParent != paramCoordinatorLayout) {
      if ((localViewParent != null) && (localViewParent != paramView))
      {
        if ((localViewParent instanceof View)) {
          localView = (View)localViewParent;
        }
        localViewParent = localViewParent.getParent();
      }
      else
      {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
        return false;
      }
    }
    this.mAnchorDirectChild = localView;
    return true;
  }
  
  boolean checkAnchorChanged()
  {
    return (this.mAnchorView == null) && (this.mAnchorId != -1);
  }
  
  boolean dependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    if ((paramView2 != this.mAnchorDirectChild) && (!shouldDodge(paramView2, ViewCompat.getLayoutDirection(paramCoordinatorLayout))))
    {
      CoordinatorLayout.Behavior localBehavior = this.mBehavior;
      if ((localBehavior == null) || (!localBehavior.layoutDependsOn(paramCoordinatorLayout, paramView1, paramView2))) {
        return false;
      }
    }
    return true;
  }
  
  boolean didBlockInteraction()
  {
    if (this.mBehavior == null) {
      this.mDidBlockInteraction = false;
    }
    return this.mDidBlockInteraction;
  }
  
  View findAnchorView(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    if (this.mAnchorId == -1)
    {
      this.mAnchorDirectChild = null;
      this.mAnchorView = null;
      return null;
    }
    if ((this.mAnchorView == null) || (!verifyAnchorView(paramView, paramCoordinatorLayout))) {
      resolveAnchorView(paramView, paramCoordinatorLayout);
    }
    return this.mAnchorView;
  }
  
  @IdRes
  public int getAnchorId()
  {
    return this.mAnchorId;
  }
  
  @Nullable
  public CoordinatorLayout.Behavior getBehavior()
  {
    return this.mBehavior;
  }
  
  boolean getChangedAfterNestedScroll()
  {
    return this.mDidChangeAfterNestedScroll;
  }
  
  Rect getLastChildRect()
  {
    return this.mLastChildRect;
  }
  
  void invalidateAnchor()
  {
    this.mAnchorDirectChild = null;
    this.mAnchorView = null;
  }
  
  boolean isBlockingInteractionBelow(CoordinatorLayout paramCoordinatorLayout, View paramView)
  {
    boolean bool2 = this.mDidBlockInteraction;
    if (bool2) {
      return true;
    }
    CoordinatorLayout.Behavior localBehavior = this.mBehavior;
    boolean bool1;
    if (localBehavior != null) {
      bool1 = localBehavior.blocksInteractionBelow(paramCoordinatorLayout, paramView);
    } else {
      bool1 = false;
    }
    bool1 |= bool2;
    this.mDidBlockInteraction = bool1;
    return bool1;
  }
  
  boolean isNestedScrollAccepted(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return false;
      }
      return this.mDidAcceptNestedScrollNonTouch;
    }
    return this.mDidAcceptNestedScrollTouch;
  }
  
  void resetChangedAfterNestedScroll()
  {
    this.mDidChangeAfterNestedScroll = false;
  }
  
  void resetNestedScroll(int paramInt)
  {
    setNestedScrollAccepted(paramInt, false);
  }
  
  void resetTouchBehaviorTracking()
  {
    this.mDidBlockInteraction = false;
  }
  
  public void setAnchorId(@IdRes int paramInt)
  {
    invalidateAnchor();
    this.mAnchorId = paramInt;
  }
  
  public void setBehavior(@Nullable CoordinatorLayout.Behavior paramBehavior)
  {
    CoordinatorLayout.Behavior localBehavior = this.mBehavior;
    if (localBehavior != paramBehavior)
    {
      if (localBehavior != null) {
        localBehavior.onDetachedFromLayoutParams();
      }
      this.mBehavior = paramBehavior;
      this.mBehaviorTag = null;
      this.mBehaviorResolved = true;
      if (paramBehavior != null) {
        paramBehavior.onAttachedToLayoutParams(this);
      }
    }
  }
  
  void setChangedAfterNestedScroll(boolean paramBoolean)
  {
    this.mDidChangeAfterNestedScroll = paramBoolean;
  }
  
  void setLastChildRect(Rect paramRect)
  {
    this.mLastChildRect.set(paramRect);
  }
  
  void setNestedScrollAccepted(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.mDidAcceptNestedScrollNonTouch = paramBoolean;
      return;
    }
    this.mDidAcceptNestedScrollTouch = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */