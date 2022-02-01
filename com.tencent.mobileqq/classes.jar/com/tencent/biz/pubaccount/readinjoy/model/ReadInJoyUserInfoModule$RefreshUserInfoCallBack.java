package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;

public abstract interface ReadInJoyUserInfoModule$RefreshUserInfoCallBack
{
  public abstract void onLoadUserInfoFailed(String paramString1, String paramString2);
  
  public abstract void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack
 * JD-Core Version:    0.7.0.1
 */