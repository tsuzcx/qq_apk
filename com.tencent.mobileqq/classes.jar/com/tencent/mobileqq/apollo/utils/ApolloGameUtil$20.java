package com.tencent.mobileqq.apollo.utils;

import alpo;
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
      QQToast.a(BaseApplicationImpl.getApplication(), 1, alpo.a(2131700738), 0).a();
    case 1: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getApplication(), 2, alpo.a(2131700714), 0).a();
      return;
    case 2: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, alpo.a(2131700726), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2, alpo.a(2131700730), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.20
 * JD-Core Version:    0.7.0.1
 */