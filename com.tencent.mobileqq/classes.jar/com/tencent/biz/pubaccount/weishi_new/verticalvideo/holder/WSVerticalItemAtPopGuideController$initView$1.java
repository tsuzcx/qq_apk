package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class WSVerticalItemAtPopGuideController$initView$1
  implements View.OnClickListener
{
  WSVerticalItemAtPopGuideController$initView$1(WSVerticalItemAtPopGuideController paramWSVerticalItemAtPopGuideController) {}
  
  public final void onClick(View paramView)
  {
    AbsWSVideoItemView localAbsWSVideoItemView = WSVerticalItemAtPopGuideController.a(this.a);
    if (localAbsWSVideoItemView != null)
    {
      ((WSVerticalVideoOperationRightItemView)localAbsWSVideoItemView).onClick(paramView);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemAtPopGuideController.initView.1
 * JD-Core Version:    0.7.0.1
 */