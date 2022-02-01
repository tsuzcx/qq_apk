package com.tencent.biz.qqstory.takevideo.label;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.XEditTextEx;
import com.tribe.async.dispatch.IEventReceiver;

public class QQStoryAddVideoLabelViewPart
  implements IEventReceiver
{
  public View.OnClickListener a;
  public final View a;
  public ImageButton a;
  public TextView a;
  public QQStoryAddVideoLabelViewPart.OnTextChangeListener a;
  public XEditTextEx a;
  public String a;
  
  public QQStoryAddVideoLabelViewPart(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(paramView);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131363430));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365172));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)paramView.findViewById(2131366173));
    paramView = new SpannableString(HardCodeUtil.a(2131710772));
    paramView.setSpan(new AbsoluteSizeSpan(14, true), 0, paramView.length(), 33);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(paramView);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(new QQStoryAddVideoLabelViewPart.EditTextWatcher(this));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(new QQStoryAddVideoLabelViewPart.1(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidViewView.getVisibility();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(paramOnClickListener);
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart
 * JD-Core Version:    0.7.0.1
 */