package com.tencent.mobileqq.apollo.utils;

import ajyc;
import bcpw;
import com.tencent.common.app.BaseApplicationImpl;

final class ApolloGameUtil$20
  implements Runnable
{
  ApolloGameUtil$20(int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
      bcpw.a(BaseApplicationImpl.getApplication(), 1, ajyc.a(2131700358), 0).a();
    case 1: 
      return;
    case 0: 
      bcpw.a(BaseApplicationImpl.getApplication(), 2, ajyc.a(2131700334), 0).a();
      return;
    case 2: 
      bcpw.a(BaseApplicationImpl.getApplication(), 1, ajyc.a(2131700346), 0).a();
      return;
    }
    bcpw.a(BaseApplicationImpl.getApplication(), 2, ajyc.a(2131700350), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.20
 * JD-Core Version:    0.7.0.1
 */