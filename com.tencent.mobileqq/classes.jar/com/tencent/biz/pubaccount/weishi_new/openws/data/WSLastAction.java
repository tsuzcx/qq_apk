package com.tencent.biz.pubaccount.weishi_new.openws.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSLastAction
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
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
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.data.WSLastAction
 * JD-Core Version:    0.7.0.1
 */