package com.tencent.aelight.camera.ae.biz.circle.helper;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter;
import com.tencent.aelight.camera.ae.biz.circle.adapter.PicPreviewMoveAdapter.PicAddViewHolder;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper.Callback;
import java.util.ArrayList;

public class PicDragHelperCallback
  extends ItemTouchHelper.Callback
{
  private float jdField_a_of_type_Float = 1.2F;
  private int jdField_a_of_type_Int = -1;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private PicPreviewMoveAdapter jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter;
  private PicDragHelperCallback.DragListener jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$DragListener;
  private PicDragHelperCallback.ScaleProperty jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$ScaleProperty = new PicDragHelperCallback.ScaleProperty("scale");
  private boolean jdField_a_of_type_Boolean = false;
  private float b = 1.0F;
  private float c = 0.86F;
  private float d = 0.3F;
  private float e = this.jdField_a_of_type_Float;
  
  public PicDragHelperCallback(@NonNull PicPreviewMoveAdapter paramPicPreviewMoveAdapter, View paramView)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter = paramPicPreviewMoveAdapter;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void a(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ObjectAnimator))
    {
      ((ObjectAnimator)localObject).cancel();
      paramView.setTag(null);
    }
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, long paramLong)
  {
    if ((paramView.getTag() instanceof ObjectAnimator)) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$ScaleProperty, new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(paramLong);
    localObjectAnimator.start();
    paramView.setTag(localObjectAnimator);
  }
  
  private boolean a(View paramView)
  {
    paramView = paramView.getTag();
    return ((paramView instanceof ObjectAnimator)) && (((ObjectAnimator)paramView).isRunning());
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.e = this.jdField_a_of_type_Float;
  }
  
  public void a(PicDragHelperCallback.DragListener paramDragListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$DragListener = paramDragListener;
  }
  
  public void b(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void clearView(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    a(paramViewHolder.itemView);
    a(paramViewHolder.itemView, this.jdField_a_of_type_Float, 1.0F, 150L);
    paramViewHolder.itemView.setAlpha(1.0F);
    super.clearView(paramRecyclerView, paramViewHolder);
  }
  
  public long getAnimationDuration(RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return 0L;
    }
    return super.getAnimationDuration(paramRecyclerView, paramInt, paramFloat1, paramFloat2);
  }
  
  public int getMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof PicPreviewMoveAdapter.PicAddViewHolder)) {
      return 0;
    }
    return makeMovementFlags(15, 0);
  }
  
  public boolean isItemViewSwipeEnabled()
  {
    return false;
  }
  
  public boolean isLongPressDragEnabled()
  {
    return true;
  }
  
  public void onChildDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (!a(paramViewHolder.itemView)))
    {
      int i = this.jdField_a_of_type_AndroidViewView.getWidth();
      int j = this.jdField_a_of_type_AndroidViewView.getHeight();
      Object localObject = new int[2];
      this.jdField_a_of_type_AndroidViewView.getLocationInWindow((int[])localObject);
      boolean bool2 = false;
      int k = localObject[0];
      int m = localObject[1];
      int i3 = paramViewHolder.itemView.getWidth();
      int i2 = paramViewHolder.itemView.getHeight();
      localObject = new int[2];
      paramViewHolder.itemView.getLocationInWindow((int[])localObject);
      int i1 = localObject[0];
      int n = localObject[1];
      float f1 = i3;
      float f2 = this.e;
      i3 = (int)(f1 * f2);
      i2 = (int)(i2 * f2);
      i1 += i3 / 2;
      n += i2 / 2;
      boolean bool1;
      if ((n > m) && (n < m + j) && (i1 > k) && (i1 < k + i)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool1 != this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null) {
          if (bool1)
          {
            this.e = this.c;
            a(paramViewHolder.itemView);
            a(paramViewHolder.itemView, this.jdField_a_of_type_Float, this.c, 150L);
            paramViewHolder.itemView.setAlpha(this.d);
          }
          else
          {
            this.e = this.jdField_a_of_type_Float;
            a(paramViewHolder.itemView);
            a(paramViewHolder.itemView, this.c, this.jdField_a_of_type_Float, 150L);
            paramViewHolder.itemView.setAlpha(this.b);
          }
        }
        localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$DragListener;
        if (localObject != null)
        {
          if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
            bool2 = true;
          }
          ((PicDragHelperCallback.DragListener)localObject).a(bool1, bool2);
        }
      }
      this.jdField_a_of_type_Boolean = bool1;
      super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
      return;
    }
    super.onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, paramBoolean);
  }
  
  public boolean onMove(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2)
  {
    if (paramViewHolder1.getItemViewType() != paramViewHolder2.getItemViewType()) {
      return false;
    }
    if ((paramViewHolder2 instanceof PicPreviewMoveAdapter.PicAddViewHolder)) {
      return false;
    }
    paramRecyclerView = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter.a();
    if (paramRecyclerView != null)
    {
      if (paramRecyclerView.size() < 2) {
        return false;
      }
      int i = paramViewHolder1.getAdapterPosition();
      int j = paramViewHolder2.getAdapterPosition();
      this.jdField_a_of_type_Int = j;
      paramRecyclerView.add(j, paramRecyclerView.remove(i));
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter.notifyItemMoved(i, j);
      return true;
    }
    return false;
  }
  
  public void onSelectedChanged(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      a(paramViewHolder.itemView);
      a(paramViewHolder.itemView, 1.0F, this.jdField_a_of_type_Float, 200L);
      paramViewHolder.itemView.setAlpha(this.b);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$DragListener;
      if (localObject != null) {
        ((PicDragHelperCallback.DragListener)localObject).a();
      }
      this.jdField_a_of_type_Int = paramViewHolder.getAdapterPosition();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectedChanged delPos:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      Log.d("jiabin", ((StringBuilder)localObject).toString());
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleHelperPicDragHelperCallback$DragListener;
      if (localObject != null) {
        ((PicDragHelperCallback.DragListener)localObject).a(this.jdField_a_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= 0))
      {
        localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
        if (localObject != null)
        {
          ((RecyclerView.ViewHolder)localObject).itemView.setVisibility(4);
          this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterPicPreviewMoveAdapter.a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Boolean = false;
        }
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = null;
    }
    super.onSelectedChanged(paramViewHolder, paramInt);
  }
  
  public void onSwiped(RecyclerView.ViewHolder paramViewHolder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.helper.PicDragHelperCallback
 * JD-Core Version:    0.7.0.1
 */