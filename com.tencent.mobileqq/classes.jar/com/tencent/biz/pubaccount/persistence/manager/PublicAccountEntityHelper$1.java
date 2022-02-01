package com.tencent.biz.pubaccount.persistence.manager;

class PublicAccountEntityHelper$1
  implements Runnable
{
  PublicAccountEntityHelper$1(PublicAccountEntityHelper paramPublicAccountEntityHelper, PublicAccountEntityManagerFactory paramPublicAccountEntityManagerFactory) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.persistence.manager.PublicAccountEntityHelper.1
 * JD-Core Version:    0.7.0.1
 */