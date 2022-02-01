package com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/biz/pubaccount/readinjoy/ugc/selecttopic/SelectTopicFragment$handleVideoAddToTopicResult$1$1"}, k=3, mv={1, 1, 16})
final class SelectTopicFragment$handleVideoAddToTopicResult$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  SelectTopicFragment$handleVideoAddToTopicResult$$inlined$apply$lambda$1(FragmentActivity paramFragmentActivity, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    String str = RIJUgcUtils.a() + this.jdField_a_of_type_Int;
    ViolaAccessHelper.a((Context)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "", str, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selecttopic.SelectTopicFragment.handleVideoAddToTopicResult..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */