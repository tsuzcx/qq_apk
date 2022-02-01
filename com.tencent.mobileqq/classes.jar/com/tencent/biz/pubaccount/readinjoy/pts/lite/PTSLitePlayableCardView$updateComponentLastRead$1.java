package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ListenerBuilder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.OnLastReadRefreshListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "retData", "", "", "", "", "onEvent"}, k=3, mv={1, 1, 16})
final class PTSLitePlayableCardView$updateComponentLastRead$1
  implements FeedItemCell.CellListener
{
  PTSLitePlayableCardView$updateComponentLastRead$1(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public final void a(View paramView, Map<String, Object> paramMap)
  {
    paramView = this.a.a();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "adapter.listenerBuilder");
    paramView = paramView.a();
    if (paramView != null) {
      paramView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLitePlayableCardView.updateComponentLastRead.1
 * JD-Core Version:    0.7.0.1
 */