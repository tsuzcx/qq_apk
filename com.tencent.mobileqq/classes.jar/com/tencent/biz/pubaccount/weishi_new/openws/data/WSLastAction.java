package com.tencent.biz.pubaccount.weishi_new.openws.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSLastAction
{
  private int a;
  private long b;
  
  public static WSLastAction a(@Nullable String paramString)
  {
    WSLastAction localWSLastAction = new WSLastAction();
    if (TextUtils.isEmpty(paramString)) {
      return localWSLastAction;
    }
    paramString = paramString.split(",");
    if (paramString.length != 2) {
      return localWSLastAction;
    }
    localWSLastAction.a(WeishiUtils.a(paramString[0], 0));
    localWSLastAction.a(WeishiUtils.a(paramString[1], 0L));
    return localWSLastAction;
  }
  
  public static String a(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public long b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.data.WSLastAction
 * JD-Core Version:    0.7.0.1
 */