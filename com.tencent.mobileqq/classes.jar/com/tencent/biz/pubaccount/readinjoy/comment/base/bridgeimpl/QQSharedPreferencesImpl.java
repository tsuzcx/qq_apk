package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import com.tencent.tkd.comment.publisher.qq.bridge.QQSharedPreferenceBridge;
import cooperation.readinjoy.ReadInJoyHelper;

public class QQSharedPreferencesImpl
  implements QQSharedPreferenceBridge
{
  public <T> T getValue(String paramString, T paramT)
  {
    return ReadInJoyHelper.a(paramString, paramT);
  }
  
  public <T> void setValue(String paramString, T paramT)
  {
    ReadInJoyHelper.a(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQSharedPreferencesImpl
 * JD-Core Version:    0.7.0.1
 */