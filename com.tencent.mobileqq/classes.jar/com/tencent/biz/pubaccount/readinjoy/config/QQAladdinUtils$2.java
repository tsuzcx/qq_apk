package com.tencent.biz.pubaccount.readinjoy.config;

import com.tencent.aladdin.config.utils.SpUtils.IAladdinSpOperator;
import cooperation.readinjoy.ReadInJoyHelper;

final class QQAladdinUtils$2
  implements SpUtils.IAladdinSpOperator
{
  public <T> T getSpValue(String paramString, T paramT, boolean paramBoolean)
  {
    return ReadInJoyHelper.a(paramString, paramT, paramBoolean);
  }
  
  public <T> void updateSpValue(String paramString, T paramT, boolean paramBoolean)
  {
    ReadInJoyHelper.a(paramString, paramT, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.QQAladdinUtils.2
 * JD-Core Version:    0.7.0.1
 */