package com.tencent.mobileqq.app.hiddenchat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class HiddenChatUtil
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PrefHiddenChat");
    localStringBuilder.append(paramString);
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static void a(String paramString, Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramContext = a(paramContext, paramString).edit();
      paramContext.putBoolean("show_unread_msg", paramBoolean);
      paramContext.commit();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("setHiddenSession ac[");
        paramContext.append(paramString);
        paramContext.append("], open[");
        paramContext.append(paramBoolean);
        paramContext.append("]");
        QLog.i("HiddenChatUtil", 2, paramContext.toString());
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return true;
      }
      paramContext = a(paramContext, paramString1);
      boolean bool1 = paramContext.getBoolean("show_video_msg", false);
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramContext = paramContext.getString("KeyHiddenChatList", "");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(";");
        localObject = ((StringBuilder)localObject).toString();
        if ((TextUtils.isEmpty(paramContext)) || (!paramContext.contains((CharSequence)localObject))) {
          bool1 = true;
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("HiddenChatUtil", 2, String.format("isShowVideoMsg ac[%s], uin[%s], type[%s], show[%s], cur[%s], list[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool1), localObject, paramContext }));
          bool2 = bool1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("HiddenChatUtil", 2, String.format("isShowVideoMsg ac[%s], uin[%s], type[%s], show[%s]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt), Boolean.valueOf(bool2) }));
      }
      return bool2;
    }
    return true;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      return a(paramContext, paramString).getBoolean("show_unread_msg", true);
    }
    return true;
  }
  
  public static void b(String paramString, Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      paramContext = a(paramContext, paramString).edit();
      paramContext.putBoolean("show_video_msg", paramBoolean);
      paramContext.commit();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("setVideoMsg ac[");
        paramContext.append(paramString);
        paramContext.append("], open[");
        paramContext.append(paramBoolean);
        paramContext.append("]");
        QLog.i("HiddenChatUtil", 2, paramContext.toString());
      }
    }
  }
  
  public static boolean b(String paramString, Context paramContext)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString))) {
      return a(paramContext, paramString).getBoolean("show_video_msg", false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil
 * JD-Core Version:    0.7.0.1
 */