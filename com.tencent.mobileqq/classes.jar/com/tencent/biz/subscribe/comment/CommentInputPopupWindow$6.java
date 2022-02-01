package com.tencent.biz.subscribe.comment;

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
    if (paramEditable.length() > CommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow.getContext(), HardCodeUtil.a(2131702235) + CommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow) + HardCodeUtil.a(2131702236), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      EmoWindow.a(CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).getSelectionEnd();
        }
        try
        {
          CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).setText((CharSequence)localObject1);
          CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            CommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentInputPopupWindow).setText(paramEditable.toString());
            i = paramEditable.toString().length();
          }
        }
      }
      Object localObject2 = null;
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
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.6
 * JD-Core Version:    0.7.0.1
 */