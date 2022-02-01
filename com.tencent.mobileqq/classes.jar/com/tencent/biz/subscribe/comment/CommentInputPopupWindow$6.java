package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class CommentInputPopupWindow$6
  implements TextWatcher
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).removeTextChangedListener(this);
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramEditable.length() > CommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow))
    {
      localObject = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131702369));
      localStringBuilder.append(CommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow));
      localStringBuilder.append(HardCodeUtil.a(2131702370));
      QQToast.a((Context)localObject, localStringBuilder.toString(), 0).a();
      i = this.jdField_a_of_type_Int;
      paramEditable.delete(i, this.b + i);
    }
    else
    {
      localStringBuilder = null;
      localObject = paramEditable.toString();
      i = this.jdField_a_of_type_Int;
      String str = ((String)localObject).substring(i, this.b + i);
      i = str.indexOf('/');
      localObject = localStringBuilder;
      if (i >= 0)
      {
        localObject = localStringBuilder;
        if (i < str.length() - 1)
        {
          localObject = new SpannableStringBuilder(paramEditable.toString());
          EmoWindow.a(CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).getContext(), (SpannableStringBuilder)localObject);
        }
      }
      if (localObject != null) {
        i = CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).getSelectionEnd();
      }
    }
    try
    {
      CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).setText((CharSequence)localObject);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label230:
      break label230;
    }
    CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).setText(paramEditable.toString());
    int i = paramEditable.toString().length();
    CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).setSelection(i);
    this.b = 0;
    this.jdField_a_of_type_Int = 0;
    CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).addTextChangedListener(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.6
 * JD-Core Version:    0.7.0.1
 */