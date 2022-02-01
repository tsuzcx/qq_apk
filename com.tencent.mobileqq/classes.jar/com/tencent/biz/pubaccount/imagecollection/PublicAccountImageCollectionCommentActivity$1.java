package com.tencent.biz.pubaccount.imagecollection;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;

class PublicAccountImageCollectionCommentActivity$1
  implements TextWatcher
{
  PublicAccountImageCollectionCommentActivity$1(PublicAccountImageCollectionCommentActivity paramPublicAccountImageCollectionCommentActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    PublicAccountImageCollectionCommentActivity.a(this.a, paramEditable.toString());
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (paramCharSequence.length() - paramInt2 + paramInt3 > 100))
    {
      paramCharSequence = this.a;
      QQToast.a(paramCharSequence, 0, paramCharSequence.getString(2131695202), 0).b(this.a.getTitleBarHeight());
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionCommentActivity.1
 * JD-Core Version:    0.7.0.1
 */