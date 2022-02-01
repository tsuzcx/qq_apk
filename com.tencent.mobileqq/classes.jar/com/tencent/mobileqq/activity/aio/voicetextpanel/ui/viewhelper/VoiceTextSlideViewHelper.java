package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextEditScrollerView;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;

public class VoiceTextSlideViewHelper
{
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private VoiceTextEditScrollerView jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView;
  private VoiceTextPanel jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.getTop();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a());
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setMaxHeight(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.getTop(), paramInt1, paramInt2, paramInt3, 0, 200, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.a(paramInt4, paramInt2, paramInt3 - paramInt1, paramInt3, 1, 100, this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setPanelActionDownPos(paramInt2, paramInt4);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 - paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.layout(paramInt1, 0, paramInt3, paramInt5);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setMaskClick(true);
    }
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = paramVoiceTextPanel;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramVoiceTextPanel.findViewById(2131368336));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramVoiceTextPanel.findViewById(2131371065));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnTouchListener(new VoiceTextSlideViewHelper.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView = ((VoiceTextEditScrollerView)paramVoiceTextPanel.findViewById(2131365294));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setSlideEnable(paramBoolean);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setSlideEnable(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDrawable(2130839617));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setSlideEnable(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDrawable(2130850432));
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.getContext().getResources().getDrawable(2130850432));
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextEditScrollerView.setListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSlideViewHelper
 * JD-Core Version:    0.7.0.1
 */