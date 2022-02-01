package com.tencent.falco.base.floatwindow.permission.romutils;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;

public class VivoRomUtils
  extends BaseRomUtils
{
  private static int a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    Uri localUri = Uri.parse("content://com.vivo.permissionmanager.provider.permission/float_window_apps");
    paramContext = paramContext.getContentResolver().query(localUri, null, "pkgname = ?", new String[] { str }, null);
    if (paramContext != null)
    {
      if (paramContext.moveToFirst())
      {
        int i = paramContext.getInt(paramContext.getColumnIndex("currentmode"));
        paramContext.close();
        return i;
      }
      paramContext.close();
    }
    return 1;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setFlags(268435456);
      localIntent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
      localIntent.putExtra("packagename", paramContext.getPackageName());
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getPackageName();
      Uri localUri = Uri.parse("content://com.iqoo.secure.provider.secureprovider/allowfloatwindowapp");
      localObject = paramContext.getContentResolver().query(localUri, null, "pkgname = ?", new String[] { localObject }, null);
      if (localObject != null)
      {
        ((Cursor)localObject).getColumnNames();
        if (((Cursor)localObject).moveToFirst())
        {
          int i = ((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("currentlmode"));
          ((Cursor)localObject).close();
          return i == 0;
        }
        ((Cursor)localObject).close();
        return a(paramContext) == 0;
      }
      return a(paramContext) == 0;
    }
    throw new IllegalArgumentException("context is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.permission.romutils.VivoRomUtils
 * JD-Core Version:    0.7.0.1
 */