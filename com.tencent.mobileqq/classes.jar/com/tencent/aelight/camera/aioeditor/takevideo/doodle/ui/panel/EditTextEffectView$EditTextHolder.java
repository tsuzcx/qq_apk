package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.mobileqq.flashchat.OnHolderItemClickListener;
import com.tencent.qphone.base.util.QLog;

class EditTextEffectView$EditTextHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  DynamicTextConfigManager.DynamicTextConfigBean jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextConfigManager$DynamicTextConfigBean;
  QIMCommonLoadingView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  ImageView c;
  ImageView d;
  
  public EditTextEffectView$EditTextHolder(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366089));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366090));
    this.c = ((ImageView)paramView.findViewById(2131366092));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131366091);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131370387));
    this.d = ((ImageView)paramView.findViewById(2131368743));
    paramView.setOnClickListener(this);
    paramOnHolderItemClickListener = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramOnHolderItemClickListener.width = localMarginLayoutParams.width;
    paramOnHolderItemClickListener.height = localMarginLayoutParams.height;
    paramOnHolderItemClickListener.addRule(10);
    paramOnHolderItemClickListener.addRule(9);
    paramOnHolderItemClickListener.addRule(12);
    paramOnHolderItemClickListener.addRule(11);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setLayoutParams(paramOnHolderItemClickListener);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setBgCorner(QIMCommonLoadingView.a(7.0F, paramView.getContext()));
    localLayoutParams.width = localMarginLayoutParams.width;
    localLayoutParams.height = localMarginLayoutParams.height;
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    this.c.setLayoutParams(localLayoutParams);
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.getVisibility() != 0) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setProgress((int)paramFloat);
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.getMeasuredWidth();
    int j = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.getMeasuredHeight();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateProgress progress is: ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(" pos is: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(" width is: ");
      localStringBuilder.append(i);
      localStringBuilder.append("height is: ");
      localStringBuilder.append(j);
      QLog.i("DText", 2, localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.getVisibility() != 8) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setVisibility(8);
    }
    if (paramBoolean)
    {
      if (this.d.getVisibility() != 8) {
        this.d.setVisibility(8);
      }
    }
    else if (this.d.getVisibility() != 0) {
      this.d.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish download pos is: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.i("DText", 2, localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c.getVisibility() != 0) {
        this.c.setVisibility(0);
      }
    }
    else if (this.c.getVisibility() != 8) {
      this.c.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidViewView)
    {
      OnHolderItemClickListener localOnHolderItemClickListener = this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
      if (localOnHolderItemClickListener != null) {
        localOnHolderItemClickListener.a(paramView, getAdapterPosition(), -1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.EditTextEffectView.EditTextHolder
 * JD-Core Version:    0.7.0.1
 */