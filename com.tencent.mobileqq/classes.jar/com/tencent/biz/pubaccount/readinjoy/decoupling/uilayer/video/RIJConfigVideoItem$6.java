package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.handlers.VideoHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class RIJConfigVideoItem$6
  implements View.OnClickListener
{
  RIJConfigVideoItem$6(Context paramContext, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    VideoHandler.b(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJConfigVideoItem.6
 * JD-Core Version:    0.7.0.1
 */