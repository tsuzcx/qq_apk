package com.tencent.biz.qqcircle.publish.preview.itemtouchhelper;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

class ItemTouchHelper$3
  extends ItemTouchHelper.RecoverAnimation
{
  ItemTouchHelper$3(ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder1, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt3, RecyclerView.ViewHolder paramViewHolder2)
  {
    super(paramItemTouchHelper, paramViewHolder1, paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (this.n) {
      return;
    }
    if (this.a <= 0)
    {
      this.c.l.b(this.c.p, this.b);
    }
    else
    {
      this.c.a.add(this.b.itemView);
      this.k = true;
      int i = this.a;
      if (i > 0) {
        this.c.a(this, i);
      }
    }
    if (this.c.s == this.b.itemView) {
      this.c.a(this.b.itemView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.preview.itemtouchhelper.ItemTouchHelper.3
 * JD-Core Version:    0.7.0.1
 */