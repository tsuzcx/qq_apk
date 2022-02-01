package com.tencent.mobileqq.activity.framebusiness;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl;
import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class RIJInjectImpl$1
  extends FrameFragment.DragViewPunctureClickListener
{
  RIJInjectImpl$1(FrameFragment paramFrameFragment, TabFrameControllerImpl paramTabFrameControllerImpl) {}
  
  public void onClick(View paramView)
  {
    Frame localFrame = this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a();
    RIJXTabFrameUtils.a.a(localFrame);
    ReadInJoyLogicEngine.a().l();
    RIJInjectImpl.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeImplTabFrameControllerImpl, (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.jdField_a_of_type_JavaUtilHashMap);
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.RIJInjectImpl.1
 * JD-Core Version:    0.7.0.1
 */