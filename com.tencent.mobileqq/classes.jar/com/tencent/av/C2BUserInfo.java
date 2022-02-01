package com.tencent.av;

import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.Cryptor;
import org.json.JSONObject;

public class C2BUserInfo
{
  public final String a = "uid";
  public final String b = "ukey";
  public final String c = "^%QAI$I+j{2HuP0L";
  public String d;
  public String e;
  
  public static C2BUserInfo a(String paramString)
  {
    C2BUserInfo localC2BUserInfo = new C2BUserInfo();
    if (localC2BUserInfo.a(paramString)) {
      return localC2BUserInfo;
    }
    return null;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      paramString = new JSONObject(new String(new Cryptor().decrypt(paramString, "^%QAI$I+j{2HuP0L".getBytes())));
      if (paramString.has("uid")) {
        this.d = paramString.getString("uid");
      }
      for (int i = 1; (i != 0) && (paramString.has("ukey")); i = 0)
      {
        this.e = paramString.getString("ukey");
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.C2BUserInfo
 * JD-Core Version:    0.7.0.1
 */