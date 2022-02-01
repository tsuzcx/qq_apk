package com.tencent.biz.qqstory.takevideo.label;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.EmoticonUtils;

public class QQStoryAddVideoLabelViewPart$EditTextWatcher
  implements TextWatcher
{
  public QQStoryAddVideoLabelViewPart$EditTextWatcher(QQStoryAddVideoLabelViewPart paramQQStoryAddVideoLabelViewPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = EmoticonUtils.a(paramEditable.toString(), 30);
    if (str.length() < paramEditable.length()) {
      paramEditable.replace(0, paramEditable.length(), str);
    }
    this.a.jdField_a_of_type_JavaLangString = paramEditable.toString();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = paramCharSequence.toString();
    this.a.jdField_a_of_type_JavaLangString = paramCharSequence;
    SLog.b("Q.qqstory.record.label.QQStoryAddVideoLabelView", "keyword = " + this.a.jdField_a_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart$OnTextChangeListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart$OnTextChangeListener.a(this.a.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart.EditTextWatcher
 * JD-Core Version:    0.7.0.1
 */