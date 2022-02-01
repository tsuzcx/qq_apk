package com.tencent.mobileqq.activity.home.impl;

import android.view.View;
import com.tencent.mobileqq.activity.home.IFrameControllerInterface;
import com.tencent.mobileqq.app.FrameFragment.DragViewPunctureClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TabFrameControllerImpl$ABotDragClickListener
  extends FrameFragment.DragViewPunctureClickListener
{
  public View a;
  public String a;
  public boolean a;
  
  public TabFrameControllerImpl$ABotDragClickListener(View paramView, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    TabFrameControllerImpl.sFrameControllerInjectInterface.a(this);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.ABotDragClickListener
 * JD-Core Version:    0.7.0.1
 */