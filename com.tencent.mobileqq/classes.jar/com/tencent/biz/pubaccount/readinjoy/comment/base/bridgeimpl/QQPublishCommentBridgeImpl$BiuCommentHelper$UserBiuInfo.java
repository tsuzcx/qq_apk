package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.text.TextUtils;

class QQPublishCommentBridgeImpl$BiuCommentHelper$UserBiuInfo
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  
  public QQPublishCommentBridgeImpl$BiuCommentHelper$UserBiuInfo(QQPublishCommentBridgeImpl.BiuCommentHelper paramBiuCommentHelper, String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramBiuCommentHelper, paramString, paramLong, paramCharSequence, 0);
  }
  
  public QQPublishCommentBridgeImpl$BiuCommentHelper$UserBiuInfo(QQPublishCommentBridgeImpl.BiuCommentHelper paramBiuCommentHelper, String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    paramBiuCommentHelper = paramCharSequence;
    if (paramCharSequence == null) {
      paramBiuCommentHelper = "";
    }
    this.b = paramBiuCommentHelper;
    this.jdField_a_of_type_Int = paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo
 * JD-Core Version:    0.7.0.1
 */