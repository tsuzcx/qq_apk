package com.tencent.biz.pubaccount.persistence.manager;

import ogo;

public class PublicAccountEntityHelper$1
  implements Runnable
{
  public PublicAccountEntityHelper$1(ogo paramogo, PublicAccountEntityManagerFactory paramPublicAccountEntityManagerFactory) {}
  
  public void run()
  {
    try
    {
      this.a.verifyAuthentication();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper.1
 * JD-Core Version:    0.7.0.1
 */