package com.tencent.av.utils;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

public class TagIndex
{
  public static int a(View paramView, int paramInt)
  {
    paramView = paramView.getTag(paramInt);
    if (paramView == null) {
      return 2147483647;
    }
    if ((paramView instanceof Integer)) {
      return ((Integer)paramView).intValue();
    }
    a("getInt", paramInt, paramView);
    return 2147483647;
  }
  
  static void a(String paramString, int paramInt, Object paramObject)
  {
    if (!AudioHelper.a()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(HardCodeUtil.a(2131912033));
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], object[");
    localStringBuilder.append(paramObject.getClass().getSimpleName());
    localStringBuilder.append("]");
    paramString = localStringBuilder.toString();
    QLog.w("TagIndex", 1, paramString, new Throwable("打印调用栈"));
    throw new ClassCastException(paramString);
  }
  
  public static String b(View paramView, int paramInt)
  {
    paramView = paramView.getTag(paramInt);
    if (paramView == null) {
      return null;
    }
    if ((paramView instanceof String)) {
      return (String)paramView;
    }
    a("getStr", paramInt, paramView);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TagIndex
 * JD-Core Version:    0.7.0.1
 */