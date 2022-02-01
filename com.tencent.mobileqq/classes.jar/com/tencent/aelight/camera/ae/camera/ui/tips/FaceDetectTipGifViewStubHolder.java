package com.tencent.aelight.camera.ae.camera.ui.tips;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.ui.BaseViewStubHolder;

public class FaceDetectTipGifViewStubHolder
  extends BaseViewStubHolder
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public FaceDetectTipGifViewStubHolder(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064122177);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122178));
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2064515324);
  }
  
  public void c()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.tips.FaceDetectTipGifViewStubHolder
 * JD-Core Version:    0.7.0.1
 */