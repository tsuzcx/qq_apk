package com.tencent.av;

import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.Cryptor;
import org.json.JSONObject;

public class C2BUserInfo
{
  public String a;
  public String b;
  
  public static C2BUserInfo a(String paramString)
  {
    C2BUserInfo localC2BUserInfo = new C2BUserInfo();
    if (localC2BUserInfo.b(paramString)) {
      return localC2BUserInfo;
    }
    return null;
  }
  
  private boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = Base64Util.decode(paramString, 0);
        paramString = new JSONObject(new String(new Cryptor().decrypt(paramString, "^%QAI$I+j{2HuP0L".getBytes())));
        if (!paramString.has("uid")) {
          break label93;
        }
        this.a = paramString.getString("uid");
        i = 1;
        if ((i != 0) && (paramString.has("ukey")))
        {
          this.b = paramString.getString("ukey");
          return true;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      return false;
      label93:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.C2BUserInfo
 * JD-Core Version:    0.7.0.1
 */