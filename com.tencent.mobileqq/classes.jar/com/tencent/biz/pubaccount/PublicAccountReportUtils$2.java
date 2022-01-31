package com.tencent.biz.pubaccount;

import odm;
import ohp;
import org.json.JSONObject;

public final class PublicAccountReportUtils$2
  implements Runnable
{
  public PublicAccountReportUtils$2(String paramString) {}
  
  public void run()
  {
    try
    {
      int j = new JSONObject(this.a).getInt("channel_id");
      int i = 2;
      if (odm.c(j)) {
        i = 0;
      }
      ohp.e(i);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountReportUtils.2
 * JD-Core Version:    0.7.0.1
 */