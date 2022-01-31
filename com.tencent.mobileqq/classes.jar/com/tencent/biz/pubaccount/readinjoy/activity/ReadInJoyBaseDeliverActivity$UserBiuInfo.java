package com.tencent.biz.pubaccount.readinjoy.activity;

import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyBaseDeliverActivity$UserBiuInfo
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public int b;
  public CharSequence b;
  public int c;
  public int d;
  
  public ReadInJoyBaseDeliverActivity$UserBiuInfo(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramReadInJoyBaseDeliverActivity, paramString, paramLong, paramCharSequence, 0);
  }
  
  public ReadInJoyBaseDeliverActivity$UserBiuInfo(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    paramReadInJoyBaseDeliverActivity = paramCharSequence;
    if (paramCharSequence == null) {
      paramReadInJoyBaseDeliverActivity = "";
    }
    this.b = paramReadInJoyBaseDeliverActivity;
    this.d = paramInt;
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
        QLog.d("ReadInJoyBaseDeliverActivity", 2, "nick name is " + this.jdField_a_of_type_JavaLangCharSequence);
      }
      return;
      label79:
      if ((int)Math.ceil(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyBaseDeliverActivity.a.getPaint().measureText(this.jdField_a_of_type_JavaLangCharSequence.toString())) <= 0) {
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */