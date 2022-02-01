package com.tencent.acstat;

import com.tencent.acstat.common.StatCommonHelper;
import com.tencent.acstat.common.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class StatAccount
{
  public static final int CUSTOM_TYPE = 7;
  public static final int DEFAULT_TYPE = 0;
  public static final int EMAIL_TYPE = 6;
  public static final int PHONE_NUM_TYPE = 5;
  public static final int QQ_NUM_TYPE = 1;
  public static final int QQ_OPENID_TYPE = 3;
  public static final int WECHAT_ID_TYPE = 2;
  public static final int WECHAT_OPENID_TYPE = 4;
  private String a = "";
  private int b = 0;
  private String c = "";
  private String d = "";
  
  public StatAccount(String paramString)
  {
    this.a = paramString;
  }
  
  public StatAccount(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String getAccount()
  {
    return this.a;
  }
  
  public int getAccountType()
  {
    return this.b;
  }
  
  public String getExt()
  {
    return this.c;
  }
  
  public String getExt1()
  {
    return this.d;
  }
  
  public void setAccount(String paramString)
  {
    this.a = paramString;
  }
  
  public void setAccountType(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setExt(String paramString)
  {
    this.c = paramString;
  }
  
  public void setExt1(String paramString)
  {
    this.d = paramString;
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject = new JSONObject();
    if (StatCommonHelper.isStringValid(this.a)) {
      try
      {
        Util.jsonPut(localJSONObject, "a", this.a);
        localJSONObject.put("t", this.b);
        Util.jsonPut(localJSONObject, "e", this.c);
        Util.jsonPut(localJSONObject, "e1", this.d);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("StatAccount [account=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", accountType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", ext=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", ext1=");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.StatAccount
 * JD-Core Version:    0.7.0.1
 */