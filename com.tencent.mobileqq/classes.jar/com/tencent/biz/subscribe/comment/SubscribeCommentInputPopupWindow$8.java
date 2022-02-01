package com.tencent.biz.subscribe.comment;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import com.tencent.biz.subscribe.widget.textview.RichTextParser;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.RichSpannableStringBuilder;
import com.tencent.biz.subscribe.widget.textview.RichTextParser.TextImageSpanConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class SubscribeCommentInputPopupWindow$8
  implements TextWatcher
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  SubscribeCommentInputPopupWindow$8(SubscribeCommentInputPopupWindow paramSubscribeCommentInputPopupWindow) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    RichTextParser.TextImageSpanConfig localTextImageSpanConfig = null;
    if (paramEditable == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a.removeTextChangedListener(this);
    String str = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = str.indexOf('/');
    Object localObject = localTextImageSpanConfig;
    if (i >= 0)
    {
      localObject = localTextImageSpanConfig;
      if (i < str.length() - 1)
      {
        localObject = new RichTextParser.RichSpannableStringBuilder(paramEditable.toString());
        localTextImageSpanConfig = new RichTextParser.TextImageSpanConfig();
        localTextImageSpanConfig.jdField_a_of_type_Float = ((int)(22.0D * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5D));
        localTextImageSpanConfig.jdField_a_of_type_Int = 0;
        localTextImageSpanConfig.jdField_a_of_type_JavaLangCharSequence = paramEditable.toString();
        RichTextParser.a(localTextImageSpanConfig, str, null, (RichTextParser.RichSpannableStringBuilder)localObject, null, false);
      }
    }
    if (localObject != null) {
      i = this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a.getSelectionEnd();
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a.setSelection(i);
      this.b = 0;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a.addTextChangedListener(this);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentBizSubscribeCommentSubscribeCommentInputPopupWindow.a.setText(paramEditable.toString());
        i = paramEditable.toString().length();
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.SubscribeCommentInputPopupWindow.8
 * JD-Core Version:    0.7.0.1
 */