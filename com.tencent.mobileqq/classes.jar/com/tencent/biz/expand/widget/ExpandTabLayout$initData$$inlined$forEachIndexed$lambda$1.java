package com.tencent.biz.expand.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/biz/expand/widget/ExpandTabLayout$initData$2$1"}, k=3, mv={1, 1, 16})
final class ExpandTabLayout$initData$$inlined$forEachIndexed$lambda$1
  implements View.OnClickListener
{
  ExpandTabLayout$initData$$inlined$forEachIndexed$lambda$1(int paramInt, ExpandTabLayout paramExpandTabLayout, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public final void onClick(View paramView)
  {
    ExpandTabLayout.OnTabClickListener localOnTabClickListener = this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout.a();
    if (localOnTabClickListener != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizExpandWidgetExpandTabLayout.a().get(this.jdField_a_of_type_Int);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "tabs[i]");
      localOnTabClickListener.a((ExpandTabLayout.Tab)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.widget.ExpandTabLayout.initData..inlined.forEachIndexed.lambda.1
 * JD-Core Version:    0.7.0.1
 */