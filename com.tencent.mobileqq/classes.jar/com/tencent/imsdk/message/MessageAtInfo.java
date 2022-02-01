package com.tencent.imsdk.message;

import android.text.TextUtils;
import java.io.Serializable;

public class MessageAtInfo
  implements Serializable
{
  public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
  private int atAll;
  private String atUserID;
  
  public String getAtUserID()
  {
    if (this.atAll != 0) {
      this.atUserID = "__kImSDK_MesssageAtALL__";
    }
    return this.atUserID;
  }
  
  public void setAtUserID(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramString.equals("__kImSDK_MesssageAtALL__"))
    {
      this.atAll = 1;
      return;
    }
    this.atUserID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.MessageAtInfo
 * JD-Core Version:    0.7.0.1
 */