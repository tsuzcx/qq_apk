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
    return "PLUG|" + paramString1 + "|" + paramString2 + "|internal|" + paramString3 + "|PB|" + paramString4 + "||";
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String[] paramArrayOfString)
  {
    ToServiceMsg localToServiceMsg = a("CliLogSvc.UploadReq");
    localToServiceMsg.extraData.putStringArray("data", paramArrayOfString);
    super.a(localToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ReportHandler
 * JD-Core Version:    0.7.0.1
 */