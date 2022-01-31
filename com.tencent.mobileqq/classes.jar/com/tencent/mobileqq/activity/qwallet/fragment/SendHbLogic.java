package com.tencent.mobileqq.activity.qwallet.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class SendHbLogic
{
  private SendHbActivity a;
  
  public SendHbLogic(SendHbActivity paramSendHbActivity)
  {
    this.a = paramSendHbActivity;
  }
  
  public static double a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt < 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString1))) {
      return 0.0D;
    }
    try
    {
      double d = new BigDecimal(paramString1).divide(new BigDecimal(paramString2), paramInt, 4).doubleValue();
      return d;
    }
    catch (Exception paramString1) {}
    return 0.0D;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(a(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      try
      {
        String str = a(paramString, "100", 2, paramBoolean);
        return str;
      }
      catch (Exception localException) {}
    }
    try
    {
      localException.printStackTrace();
      try
      {
        paramString = b(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "0";
      }
      if (paramInt == 1) {
        return new DecimalFormat("#0.00").format(paramString);
      }
      return "";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = new DecimalFormat("#0.00").format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1) {}
    return "0";
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      return "0";
    }
    paramString1 = new BigDecimal(paramString1);
    paramString2 = new BigDecimal(paramString2);
    if (paramBoolean) {
      return new DecimalFormat("#0.00").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
    }
    return new DecimalFormat("#0.##").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || (!paramString.matches("\\-?[0-9]+"))) {
      throw new Exception("金额格式有误");
    }
    int i;
    if (paramString.charAt(0) == '-')
    {
      paramString = paramString.substring(1);
      i = 1;
    }
    for (;;)
    {
      if ((paramString.startsWith("0")) && (paramString.length() > 1))
      {
        paramString = paramString.substring(1);
      }
      else
      {
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramString.length() == 1) {
          localStringBuffer.append("0.0").append(paramString);
        }
        while (i == 1)
        {
          return "-" + localStringBuffer.toString();
          if (paramString.length() == 2) {
            localStringBuffer.append("0.").append(paramString);
          } else {
            localStringBuffer.append(paramString.substring(0, paramString.length() - 2)).append(".").append(paramString.substring(paramString.length() - 2));
          }
        }
        return localStringBuffer.toString();
        i = 0;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    try
    {
      localJSONObject.put("userId", paramString2);
      localJSONObject.put("viewTag", "qrcodeHb");
      localJSONObject.put("comeForm", 1);
      paramString2 = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        paramString2.putOpt("qrToken", paramString1);
      }
      paramString2.putOpt("comeFrom", Integer.valueOf(1));
      localJSONObject.put("extra_data", paramString2.toString());
      paramString1 = new Bundle();
      paramString1.putString("json", localJSONObject.toString());
      paramString1.putString("callbackSn", "0");
      paramString1.putLong("vacreport_key_seq", this.a.jdField_a_of_type_Long);
      PayBridgeActivity.a(this.a, 5, paramString1);
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(Map paramMap)
  {
    Object localObject = new JSONObject(paramMap);
    paramMap = this.a.b();
    paramMap.put("extra_data", ((JSONObject)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("json", new JSONObject(paramMap).toString());
    ((Bundle)localObject).putString("callbackSn", "0");
    ((Bundle)localObject).putLong("vacreport_key_seq", this.a.jdField_a_of_type_Long);
    PayBridgeActivity.a(this.a, 5, (Bundle)localObject);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject = this.a.a();
    paramJSONObject.put("channel", this.a.jdField_a_of_type_Int + "");
    paramJSONObject.put("bus_type", "1");
    paramJSONObject.put("type", "1");
    a(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.SendHbLogic
 * JD-Core Version:    0.7.0.1
 */