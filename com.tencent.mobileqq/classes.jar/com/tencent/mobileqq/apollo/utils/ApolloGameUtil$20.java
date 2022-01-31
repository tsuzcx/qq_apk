package com.tencent.mobileqq.apollo.utils;

import ajya;
import bcql;
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
      bcql.a(BaseApplicationImpl.getApplication(), 1, ajya.a(2131700369), 0).a();
    case 1: 
      return;
    case 0: 
      bcql.a(BaseApplicationImpl.getApplication(), 2, ajya.a(2131700345), 0).a();
      return;
    case 2: 
      bcql.a(BaseApplicationImpl.getApplication(), 1, ajya.a(2131700357), 0).a();
      return;
    }
    bcql.a(BaseApplicationImpl.getApplication(), 2, ajya.a(2131700361), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameUtil.20
 * JD-Core Version:    0.7.0.1
 */