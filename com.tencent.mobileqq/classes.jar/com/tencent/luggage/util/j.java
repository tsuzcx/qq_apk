package com.tencent.luggage.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class j
{
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setMessage(paramString1).setTitle(paramString2).setCancelable(paramBoolean).setPositiveButton(paramString3, paramOnClickListener1).setNegativeButton(paramString4, paramOnClickListener2);
    paramContext.show();
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    a(paramContext, paramString1, paramString2, paramContext.getString(2131892416), paramContext.getString(2131892415), paramBoolean, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static boolean a(Activity paramActivity, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if ((Build.VERSION.SDK_INT < 23) && (!"MNC".equals(Build.VERSION.CODENAME))) {
      return true;
    }
    try
    {
      int i = ContextCompat.checkSelfPermission(paramActivity, paramString1);
      if (i == 0) {
        return true;
      }
      if (!af.c(paramString3))
      {
        a(paramActivity, paramString3, paramString2, false, new j.1(paramActivity, paramString1, paramInt), null);
        return false;
      }
      ActivityCompat.requestPermissions(paramActivity, new String[] { paramString1 }, paramInt);
      return false;
    }
    catch (Exception paramActivity)
    {
      o.b("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramActivity });
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      int i = ContextCompat.checkSelfPermission(paramContext, paramString);
      if (i != 0) {
        return false;
      }
      String str = null;
      if (paramString.equals("android.permission.READ_CONTACTS")) {
        str = "android.permission.WRITE_CONTACTS";
      } else if (paramString.equals("android.permission.WRITE_CONTACTS")) {
        str = "android.permission.READ_CONTACTS";
      }
      if (!af.c(str)) {
        try
        {
          i = ContextCompat.checkSelfPermission(paramContext, str);
        }
        catch (Exception paramContext)
        {
          o.b("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", new Object[] { paramContext });
          return false;
        }
      }
      return i == 0;
    }
    catch (Exception paramContext)
    {
      o.b("Luggage.PermissionUtil", "check mpermission exception:%s.", new Object[] { paramContext });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.j
 * JD-Core Version:    0.7.0.1
 */