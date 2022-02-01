package com.tencent.mobileqq.apollo.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

final class ApolloGameUtil$19
  implements Runnable
{
  ApolloGameUtil$19(int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, HardCodeUtil.a(2131700446), 0).a();
    case 1: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getApplication(), 2, HardCodeUtil.a(2131700422), 0).a();
      return;
    case 2: 
      QQToast.a(BaseApplicationImpl.getApplication(), 1, HardCodeUtil.a(2131700434), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 2, HardCodeUtil.a(2131700438), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.19
 * JD-Core Version:    0.7.0.1
 */