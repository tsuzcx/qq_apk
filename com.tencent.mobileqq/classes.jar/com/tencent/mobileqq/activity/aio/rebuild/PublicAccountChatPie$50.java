package com.tencent.mobileqq.activity.aio.rebuild;

import aerv;
import com.tencent.ark.ark;

public class PublicAccountChatPie$50
  implements Runnable
{
  public PublicAccountChatPie$50(aerv paramaerv) {}
  
  public void run()
  {
    try
    {
      ark.arkNotify("com.tencent.weather", "pubaccountPendantRefresh", "", "json");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.50
 * JD-Core Version:    0.7.0.1
 */