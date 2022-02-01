package com.tencent.avgame.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;

public class AvGameEntranceUtil
{
  public static String a = "AvGameEntranceUtil";
  
  public static long a(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transStringToLong parse err ");
      localStringBuilder.append(paramString.toString());
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return 0L;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    if (paramInt != 114) {
      switch (paramInt)
      {
      default: 
        return null;
      case 105: 
        return paramContext.getResources().getString(2131887267);
      case 104: 
        return paramContext.getResources().getString(2131887266);
      }
    }
    return paramContext.getResources().getString(2131887268);
  }
  
  public static String a(boolean paramBoolean, Context paramContext, int paramInt, long paramLong, String paramString)
  {
    if (paramBoolean)
    {
      if (paramInt != 112) {
        switch (paramInt)
        {
        default: 
          if ((!TextUtils.isEmpty(paramString)) && (!a(paramInt))) {
            break;
          }
          return paramContext.getResources().getString(2131887404);
        case 120: 
          return paramContext.getResources().getString(2131887231);
        case 119: 
          return paramContext.getResources().getString(2131887224);
        case 117: 
          return String.format(paramContext.getResources().getString(2131887223), new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong * 1000L)) });
        case 116: 
          return paramContext.getResources().getString(2131887229);
        case 115: 
          return paramContext.getResources().getString(2131887228);
        }
      } else {
        return paramContext.getResources().getString(2131887230);
      }
    }
    else if (paramInt != 112)
    {
      if (paramInt != 114) {
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            if ((!TextUtils.isEmpty(paramString)) && (!a(paramInt))) {
              break;
            }
            return paramContext.getResources().getString(2131887412);
          case 119: 
            return paramContext.getResources().getString(2131887224);
          case 117: 
            return String.format(paramContext.getResources().getString(2131887223), new Object[] { new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong * 1000L)) });
          case 116: 
            return paramContext.getResources().getString(2131887229);
          }
          break;
        case 104: 
        case 105: 
          return paramContext.getResources().getString(2131887402);
        }
      } else {
        return paramContext.getResources().getString(2131887414);
      }
    }
    else {
      paramString = paramContext.getResources().getString(2131887230);
    }
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      paramContext = DialogUtil.a(paramContext, 230);
      paramContext.setMessage(paramString).setPositiveButton(2131887410, new AvGameEntranceUtil.1());
      paramContext.show();
      return;
    }
    QLog.e(a, 2, "showErrorDialog CONTEXT NULL");
  }
  
  public static boolean a()
  {
    if (b()) {
      return true;
    }
    return AvGameMachineLevelUtils.a() != 0;
  }
  
  private static boolean a(int paramInt)
  {
    if ((paramInt <= 120) && (paramInt >= 100)) {
      return true;
    }
    return paramInt == 1;
  }
  
  public static boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.util.AvGameEntranceUtil
 * JD-Core Version:    0.7.0.1
 */