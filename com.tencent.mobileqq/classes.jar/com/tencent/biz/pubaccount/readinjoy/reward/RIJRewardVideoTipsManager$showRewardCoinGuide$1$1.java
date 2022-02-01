package com.tencent.biz.pubaccount.readinjoy.reward;

import android.view.ViewGroup;
import bmhv;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import sse;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "popupWindow", "Lcom/tencent/biz/pubaccount/readinjoy/video/discovery/BubblePopupWindow;", "invoke"}, k=3, mv={1, 1, 16})
public final class RIJRewardVideoTipsManager$showRewardCoinGuide$1$1
  extends Lambda
  implements Function1<sse, Unit>
{
  public RIJRewardVideoTipsManager$showRewardCoinGuide$1$1(ViewGroup paramViewGroup)
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
        paramsse.d(85);
      }
    } while (paramsse == null);
    paramsse.a(0, this.$it.getWidth() / 2 + ViewUtils.dip2px(3.0F), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardVideoTipsManager.showRewardCoinGuide.1.1
 * JD-Core Version:    0.7.0.1
 */