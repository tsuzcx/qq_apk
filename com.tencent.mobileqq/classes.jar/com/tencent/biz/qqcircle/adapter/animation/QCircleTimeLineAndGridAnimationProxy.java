package com.tencent.biz.qqcircle.adapter.animation;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.richframework.widget.SquareImageView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceHolderAnimationInterface;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.ChangeInfo;
import com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.MoveInfo;

public class QCircleTimeLineAndGridAnimationProxy
  implements EnhanceHolderAnimationInterface
{
  private RecyclerView.ViewHolder a;
  
  public QCircleTimeLineAndGridAnimationProxy(RecyclerView.ViewHolder paramViewHolder)
  {
    this.a = paramViewHolder;
  }
  
  private View a(View paramView)
  {
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(2131445217);
    View localView = paramView.findViewById(2131441643);
    paramView = localView;
    if (localRecyclerView.getVisibility() == 0)
    {
      paramView = localView;
      if (localRecyclerView.getChildCount() > 0) {
        paramView = localRecyclerView.getChildAt(0);
      }
    }
    return paramView;
  }
  
  private boolean b(EnhanceItemAnimator.ChangeInfo paramChangeInfo)
  {
    paramChangeInfo = paramChangeInfo.b;
    ViewCompat.setTranslationX(paramChangeInfo.itemView, 0.0F);
    ViewCompat.setTranslationY(paramChangeInfo.itemView, 0.0F);
    ViewCompat.setScaleX(paramChangeInfo.itemView, 1.0F);
    ViewCompat.setScaleY(paramChangeInfo.itemView, 1.0F);
    ViewCompat.setAlpha(paramChangeInfo.itemView, 0.0F);
    return true;
  }
  
  private boolean c(EnhanceItemAnimator.ChangeInfo paramChangeInfo)
  {
    RecyclerView.ViewHolder localViewHolder1 = paramChangeInfo.a;
    RecyclerView.ViewHolder localViewHolder2 = paramChangeInfo.b;
    int i = paramChangeInfo.c;
    i = paramChangeInfo.d;
    int k = paramChangeInfo.e;
    int j = paramChangeInfo.f;
    paramChangeInfo = (FrameLayout)localViewHolder1.itemView.findViewById(2131433261);
    View localView = a(localViewHolder1.itemView);
    SquareImageView localSquareImageView = (SquareImageView)localViewHolder2.itemView.findViewById(2131436376);
    float f1 = ViewCompat.getTranslationX(localViewHolder1.itemView);
    float f2 = ViewCompat.getTranslationY(localViewHolder1.itemView);
    if ((localView != null) && (localSquareImageView != null))
    {
      float f3 = localView.getWidth() * 1.0F / localSquareImageView.getWidth();
      float f4 = localView.getHeight() * 1.0F / localSquareImageView.getHeight();
      float f5 = paramChangeInfo.getLeft();
      float f6 = (f3 - 1.0F) * localViewHolder2.itemView.getWidth() / 2.0F;
      float f7 = (f4 - 1.0F) * localViewHolder2.itemView.getHeight() / 2.0F;
      k = (int)(k - f5 - f6 - f1);
      i = (int)(j - i - f7 - f2);
      ViewCompat.setScaleX(localViewHolder2.itemView, f3);
      ViewCompat.setScaleY(localViewHolder2.itemView, f4);
      ViewCompat.setTranslationX(localViewHolder2.itemView, -k);
      ViewCompat.setTranslationY(localViewHolder2.itemView, -i);
    }
    return true;
  }
  
  public ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder paramViewHolder)
  {
    return null;
  }
  
  public ViewPropertyAnimatorCompat a(EnhanceItemAnimator.ChangeInfo paramChangeInfo, long paramLong, boolean paramBoolean)
  {
    RecyclerView.ViewHolder localViewHolder = paramChangeInfo.a;
    Object localObject = paramChangeInfo.b;
    if ((localViewHolder != null) && (localObject != null))
    {
      if (((localViewHolder.itemView instanceof QCircleTimeLineFeedItemView)) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof QCircleGridFeedItemView)))
      {
        if (paramBoolean)
        {
          paramChangeInfo = ViewCompat.animate(localViewHolder.itemView).setDuration(300L);
          paramChangeInfo.translationX(0.0F);
          paramChangeInfo.translationY(0.0F);
          paramChangeInfo.scaleY(1.0F);
          paramChangeInfo.scaleX(1.0F);
          paramChangeInfo.alpha(0.0F);
          return paramChangeInfo;
        }
        paramChangeInfo = ViewCompat.animate(((RecyclerView.ViewHolder)localObject).itemView).setDuration(300L);
        paramChangeInfo.setInterpolator(new AccelerateDecelerateInterpolator());
        paramChangeInfo.translationX(0.0F);
        paramChangeInfo.translationY(0.0F);
        paramChangeInfo.scaleY(1.0F);
        paramChangeInfo.scaleX(1.0F);
        paramChangeInfo.alpha(1.0F);
        return paramChangeInfo;
      }
      if (((localViewHolder.itemView instanceof QCircleGridFeedItemView)) && ((((RecyclerView.ViewHolder)localObject).itemView instanceof QCircleTimeLineFeedItemView))) {
        if (paramBoolean)
        {
          int j = paramChangeInfo.c;
          int i = paramChangeInfo.d;
          int k = paramChangeInfo.e;
          k = paramChangeInfo.f;
          paramChangeInfo = (SquareImageView)localViewHolder.itemView.findViewById(2131436376);
          FrameLayout localFrameLayout = (FrameLayout)((RecyclerView.ViewHolder)localObject).itemView.findViewById(2131433261);
          localObject = a(((RecyclerView.ViewHolder)localObject).itemView);
          float f1 = ViewCompat.getTranslationX(localViewHolder.itemView);
          float f2 = ViewCompat.getTranslationY(localViewHolder.itemView);
          if ((localObject != null) && (paramChangeInfo != null))
          {
            float f3 = ((View)localObject).getWidth() * 1.0F / paramChangeInfo.getWidth();
            float f4 = ((View)localObject).getHeight() * 1.0F / paramChangeInfo.getHeight();
            float f5 = localFrameLayout.getLeft();
            float f6 = (f3 - 1.0F) * localViewHolder.itemView.getWidth() / 2.0F;
            float f7 = (f4 - 1.0F) * localViewHolder.itemView.getHeight() / 2.0F;
            j = (int)(f5 - j + f6 - f1);
            i = (int)(k - i + f7 - f2);
            paramChangeInfo = ViewCompat.animate(localViewHolder.itemView).setDuration(300L);
            paramChangeInfo.setInterpolator(new DecelerateInterpolator());
            paramChangeInfo.translationX(j);
            paramChangeInfo.translationY(i);
            paramChangeInfo.scaleY(f4);
            paramChangeInfo.scaleX(f3);
            paramChangeInfo.alpha(1.0F);
            return paramChangeInfo;
          }
        }
        else
        {
          paramChangeInfo = ViewCompat.animate(((RecyclerView.ViewHolder)localObject).itemView).setDuration(250L);
          paramChangeInfo.setInterpolator(new AccelerateInterpolator());
          paramChangeInfo.translationX(0.0F);
          paramChangeInfo.translationY(0.0F);
          paramChangeInfo.scaleY(1.0F);
          paramChangeInfo.scaleX(1.0F);
          paramChangeInfo.alpha(1.0F);
          return paramChangeInfo;
        }
      }
      return null;
    }
    return null;
  }
  
  public ViewPropertyAnimatorCompat a(EnhanceItemAnimator.MoveInfo paramMoveInfo, long paramLong)
  {
    paramMoveInfo = ViewCompat.animate(paramMoveInfo.a.itemView).setDuration(300L);
    paramMoveInfo.setInterpolator(new AccelerateDecelerateInterpolator());
    return paramMoveInfo;
  }
  
  public boolean a(EnhanceItemAnimator.ChangeInfo paramChangeInfo)
  {
    RecyclerView.ViewHolder localViewHolder1 = paramChangeInfo.a;
    RecyclerView.ViewHolder localViewHolder2 = paramChangeInfo.b;
    if ((this.a == localViewHolder2) && ((localViewHolder2.itemView instanceof QCircleGridFeedItemView)) && ((localViewHolder1.itemView instanceof QCircleTimeLineFeedItemView))) {
      return c(paramChangeInfo);
    }
    if ((this.a == localViewHolder2) && ((localViewHolder2.itemView instanceof QCircleTimeLineFeedItemView)) && ((localViewHolder1.itemView instanceof QCircleGridFeedItemView))) {
      return b(paramChangeInfo);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.animation.QCircleTimeLineAndGridAnimationProxy
 * JD-Core Version:    0.7.0.1
 */