package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ReportHandler
  extends BusinessHandler
{
  public static String a = "Add_friend_to_desktop|";
  public static String b = "Click_desktop_friend|";
  private String c = "FuMeiTiCeSu|";
  
  ReportHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PLUG|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|internal|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|PB|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("||");
    return localStringBuilder.toString();
  }
  
  public void a(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("data")))
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("CliLogSvc.UploadReq");
      localToServiceMsg.extraData.putAll(paramBundle);
      super.send(localToServiceMsg);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("CliLogSvc.UploadReq");
    localToServiceMsg.extraData.putStringArray("data", paramArrayOfString);
    super.send(localToServiceMsg);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReportHandler
 * JD-Core Version:    0.7.0.1
 */