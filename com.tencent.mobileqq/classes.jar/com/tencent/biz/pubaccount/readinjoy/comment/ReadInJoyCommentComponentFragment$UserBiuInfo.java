package com.tencent.biz.pubaccount.readinjoy.comment;

import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuEditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyCommentComponentFragment$UserBiuInfo
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  
  public ReadInJoyCommentComponentFragment$UserBiuInfo(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramReadInJoyCommentComponentFragment, paramString, paramLong, paramCharSequence, 0);
  }
  
  public ReadInJoyCommentComponentFragment$UserBiuInfo(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    paramReadInJoyCommentComponentFragment = paramCharSequence;
    if (paramCharSequence == null) {
      paramReadInJoyCommentComponentFragment = "";
    }
    this.b = paramReadInJoyCommentComponentFragment;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangCharSequence = BiuNicknameSpan.a(ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_JavaLangString, true));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) {
        break label79;
      }
      this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentComponentFragment", 2, "nick name is " + this.jdField_a_of_type_JavaLangCharSequence);
      }
      return;
      label79:
      if ((int)Math.ceil(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.a.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString())) <= 0) {
        this.jdField_a_of_type_JavaLangCharSequence = this.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public String toString()
  {
    int i = 0;
    if (!TextUtils.isEmpty(this.b)) {
      i = this.b.length();
    }
    return "UserBiuInfo {uin=" + this.jdField_a_of_type_JavaLangString + ", nickName=" + this.jdField_a_of_type_JavaLangCharSequence + ", comment=" + this.b + ", length=" + i + ", feedid=" + this.jdField_a_of_type_Long + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */