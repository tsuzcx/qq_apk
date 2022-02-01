package com.tencent.biz.pubaccount.subscript;

import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class SubscriptUtil
{
  public static String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() < 5)) {
      localObject1 = (String)SubscriptConstants.a.get(paramString);
    } else if (paramString == null) {}
    try
    {
      localObject1 = String.valueOf(Integer.parseInt(paramString));
    }
    catch (Exception localException)
    {
      label43:
      Object localObject2;
      break label43;
    }
    Object localObject1 = (String)SubscriptConstants.a.get(paramString);
    break label61;
    localObject1 = paramString;
    label61:
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUin subscribeID[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]'s uin: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("SubscriptUtil", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptUtil
 * JD-Core Version:    0.7.0.1
 */