package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
class GhostViewPort
  extends ViewGroup
  implements GhostView
{
  @Nullable
  private Matrix mMatrix;
  private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new GhostViewPort.1(this);
  int mReferences;
  ViewGroup mStartParent;
  View mStartView;
  final View mView;
  
  GhostViewPort(View paramView)
  {
    super(paramView.getContext());
    this.mView = paramView;
    setWillNotDraw(false);
    setLayerType(2, null);
  }
  
  static GhostViewPort addGhost(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    if ((paramView.getParent() instanceof ViewGroup))
    {
      GhostViewHolder localGhostViewHolder1 = GhostViewHolder.getHolder(paramViewGroup);
      GhostViewPort localGhostViewPort = getGhostView(paramView);
      int j = 0;
      Object localObject = localGhostViewPort;
      int i = j;
      if (localGhostViewPort != null)
      {
        GhostViewHolder localGhostViewHolder2 = (GhostViewHolder)localGhostViewPort.getParent();
        localObject = localGhostViewPort;
        i = j;
        if (localGhostViewHolder2 != localGhostViewHolder1)
        {
          i = localGhostViewPort.mReferences;
          localGhostViewHolder2.removeView(localGhostViewPort);
          localObject = null;
        }
      }
      if (localObject == null)
      {
        localObject = paramMatrix;
        if (paramMatrix == null)
        {
          localObject = new Matrix();
          calculateMatrix(paramView, paramViewGroup, (Matrix)localObject);
        }
        paramMatrix = new GhostViewPort(paramView);
        paramMatrix.setMatrix((Matrix)localObject);
        if (localGhostViewHolder1 == null)
        {
          paramView = new GhostViewHolder(paramViewGroup);
        }
        else
        {
          localGhostViewHolder1.popToOverlayTop();
          paramView = localGhostViewHolder1;
        }
        copySize(paramViewGroup, paramView);
        copySize(paramViewGroup, paramMatrix);
        paramView.addGhostView(paramMatrix);
        paramMatrix.mReferences = i;
        paramView = paramMatrix;
      }
      else
      {
        paramView = (View)localObject;
        if (paramMatrix != null)
        {
          ((GhostViewPort)localObject).setMatrix(paramMatrix);
          paramView = (View)localObject;
        }
      }
      paramView.mReferences += 1;
      return paramView;
    }
    throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
  }
  
  static void calculateMatrix(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    paramView = (ViewGroup)paramView.getParent();
    paramMatrix.reset();
    ViewUtils.transformMatrixToGlobal(paramView, paramMatrix);
    paramMatrix.preTranslate(-paramView.getScrollX(), -paramView.getScrollY());
    ViewUtils.transformMatrixToLocal(paramViewGroup, paramMatrix);
  }
  
  static void copySize(View paramView1, View paramView2)
  {
    ViewUtils.setLeftTopRightBottom(paramView2, paramView2.getLeft(), paramView2.getTop(), paramView2.getLeft() + paramView1.getWidth(), paramView2.getTop() + paramView1.getHeight());
  }
  
  static GhostViewPort getGhostView(View paramView)
  {
    return (GhostViewPort)paramView.getTag(R.id.ghost_view);
  }
  
  static void removeGhost(View paramView)
  {
    paramView = getGhostView(paramView);
    if (paramView != null)
    {
      paramView.mReferences -= 1;
      if (paramView.mReferences <= 0) {
        ((GhostViewHolder)paramView.getParent()).removeView(paramView);
      }
    }
  }
  
  static void setGhostView(@NonNull View paramView, @Nullable GhostViewPort paramGhostViewPort)
  {
    paramView.setTag(R.id.ghost_view, paramGhostViewPort);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setGhostView(this.mView, this);
    this.mView.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    ViewUtils.setTransitionVisibility(this.mView, 4);
    if (this.mView.getParent() != null) {
      ((View)this.mView.getParent()).invalidate();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.mView.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
    ViewUtils.setTransitionVisibility(this.mView, 0);
    setGhostView(this.mView, null);
    if (this.mView.getParent() != null) {
      ((View)this.mView.getParent()).invalidate();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    CanvasUtils.enableZ(paramCanvas, true);
    paramCanvas.setMatrix(this.mMatrix);
    ViewUtils.setTransitionVisibility(this.mView, 0);
    this.mView.invalidate();
    ViewUtils.setTransitionVisibility(this.mView, 4);
    drawChild(paramCanvas, this.mView, getDrawingTime());
    CanvasUtils.enableZ(paramCanvas, false);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void reserveEndViewTransition(ViewGroup paramViewGroup, View paramView)
  {
    this.mStartParent = paramViewGroup;
    this.mStartView = paramView;
  }
  
  void setMatrix(@NonNull Matrix paramMatrix)
  {
    this.mMatrix = paramMatrix;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getGhostView(this.mView) == this)
    {
      if (paramInt == 0) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
      ViewUtils.setTransitionVisibility(this.mView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.GhostViewPort
 * JD-Core Version:    0.7.0.1
 */