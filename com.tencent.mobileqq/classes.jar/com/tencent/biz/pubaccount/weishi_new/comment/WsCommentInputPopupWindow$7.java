package com.tencent.biz.pubaccount.weishi_new.comment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.biz.subscribe.comment.CommentEditText;
import com.tencent.biz.subscribe.comment.EmoWindow;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class WsCommentInputPopupWindow$7
  implements TextWatcher
{
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  WsCommentInputPopupWindow$7(WsCommentInputPopupWindow paramWsCommentInputPopupWindow) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).a();
    if (paramEditable == null) {
      return;
    }
    WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).removeTextChangedListener(this);
    if (paramEditable.length() > WsCommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.getContext(), HardCodeUtil.a(2131702235) + WsCommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow) + HardCodeUtil.a(2131702236), 0).a();
      paramEditable.delete(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
      WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).addTextChangedListener(this);
      return;
    }
    Object localObject1 = paramEditable.toString().substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.b);
    int i = ((String)localObject1).indexOf('/');
    if ((i >= 0) && (i < ((String)localObject1).length() - 1))
    {
      localObject1 = new SpannableStringBuilder(paramEditable.toString());
      EmoWindow.a(WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).getContext(), (SpannableStringBuilder)localObject1);
    }
    for (;;)
    {
      for (;;)
      {
        if (localObject1 != null) {
          i = WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).getSelectionEnd();
        }
        try
        {
          WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).setText((CharSequence)localObject1);
          WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).setSelection(i);
          this.b = 0;
          this.jdField_a_of_type_Int = 0;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).setText(paramEditable.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */