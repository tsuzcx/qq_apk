package com.tencent.biz.pubaccount.weishi_new.comment;

import android.content.Context;
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
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramEditable.length() > WsCommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131702369));
      localStringBuilder.append(WsCommentInputPopupWindow.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow));
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
          EmoWindow.a(WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).getContext(), (SpannableStringBuilder)localObject);
        }
      }
      if (localObject != null) {
        i = WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).getSelectionEnd();
      }
    }
    try
    {
      WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).setText((CharSequence)localObject);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label240:
      break label240;
    }
    WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).setText(paramEditable.toString());
    int i = paramEditable.toString().length();
    WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).setSelection(i);
    this.b = 0;
    this.jdField_a_of_type_Int = 0;
    WsCommentInputPopupWindow.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentInputPopupWindow).addTextChangedListener(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */