package com.tencent.biz.pubaccount.readinjoy.reward;

import bmhv;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import sse;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "popupWindow", "Lcom/tencent/biz/pubaccount/readinjoy/video/discovery/BubblePopupWindow;", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJRewardVideoTipsManager$showRewardSuccessTips$1$1
  extends Lambda
  implements Function1<sse, Unit>
{
  public RIJRewardVideoTipsManager$showRewardSuccessTips$1$1(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    super(1);
  }
  
  public final void invoke(@Nullable sse paramsse)
  {
    if (bmhv.d()) {
      if (paramsse != null) {
        paramsse.d(21);
      }
    }
    do
    {
      return;
      if (paramsse != null) {
        paramsse.d(83);
      }
    } while (paramsse == null);
    paramsse.a(this.$it.getWidth() / 2 - ViewUtils.dip2px(2.0F), 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager.showRewardSuccessTips.1.1
 * JD-Core Version:    0.7.0.1
 */