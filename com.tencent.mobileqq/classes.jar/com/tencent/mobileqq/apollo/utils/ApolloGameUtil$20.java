package com.tencent.mobileqq.apollo.utils;

import anvx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class ApolloGameUtil$20
  implements Runnable
{
  ApolloGameUtil$20(int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, anvx.a(2131699868), 0).a();
    case 1: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getApplication(), 2, anvx.a(2131699844), 0).a();
      return;
    case 2: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, anvx.a(2131699856), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2, anvx.a(2131699860), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.20
 * JD-Core Version:    0.7.0.1
 */