package com.baseflow.permissionhandler;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PermissionUtils
{
  static int a(Activity paramActivity, String paramString, int paramInt)
  {
    if (paramInt == -1)
    {
      if ((Build.VERSION.SDK_INT >= 23) && (a(paramActivity, paramString))) {
        return 5;
      }
      return 0;
    }
    return 1;
  }
  
  static int a(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2133799037: 
      if (paramString.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
        i = 15;
      }
      break;
    case 2114579147: 
      if (paramString.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
        i = 26;
      }
      break;
    case 2024715147: 
      if (paramString.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
        i = 6;
      }
      break;
    case 1977429404: 
      if (paramString.equals("android.permission.READ_CONTACTS")) {
        i = 3;
      }
      break;
    case 1831139720: 
      if (paramString.equals("android.permission.RECORD_AUDIO")) {
        i = 9;
      }
      break;
    case 1780337063: 
      if (paramString.equals("android.permission.ACTIVITY_RECOGNITION")) {
        i = 27;
      }
      break;
    case 1365911975: 
      if (paramString.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
        i = 25;
      }
      break;
    case 1271781903: 
      if (paramString.equals("android.permission.GET_ACCOUNTS")) {
        i = 5;
      }
      break;
    case 784519842: 
      if (paramString.equals("android.permission.USE_SIP")) {
        i = 16;
      }
      break;
    case 610633091: 
      if (paramString.equals("android.permission.WRITE_CALL_LOG")) {
        i = 14;
      }
      break;
    case 603653886: 
      if (paramString.equals("android.permission.WRITE_CALENDAR")) {
        i = 1;
      }
      break;
    case 463403621: 
      if (paramString.equals("android.permission.CAMERA")) {
        i = 2;
      }
      break;
    case 214526995: 
      if (paramString.equals("android.permission.WRITE_CONTACTS")) {
        i = 4;
      }
      break;
    case 112197485: 
      if (paramString.equals("android.permission.CALL_PHONE")) {
        i = 12;
      }
      break;
    case 52602690: 
      if (paramString.equals("android.permission.SEND_SMS")) {
        i = 19;
      }
      break;
    case -5573545: 
      if (paramString.equals("android.permission.READ_PHONE_STATE")) {
        i = 10;
      }
      break;
    case -63024214: 
      if (paramString.equals("android.permission.ACCESS_COARSE_LOCATION")) {
        i = 7;
      }
      break;
    case -406040016: 
      if (paramString.equals("android.permission.READ_EXTERNAL_STORAGE")) {
        i = 24;
      }
      break;
    case -895673731: 
      if (paramString.equals("android.permission.RECEIVE_SMS")) {
        i = 20;
      }
      break;
    case -895679497: 
      if (paramString.equals("android.permission.RECEIVE_MMS")) {
        i = 23;
      }
      break;
    case -901151997: 
      if (paramString.equals("android.permission.BIND_CALL_REDIRECTION_SERVICE")) {
        i = 17;
      }
      break;
    case -1164582768: 
      if (paramString.equals("android.permission.READ_PHONE_NUMBERS")) {
        i = 11;
      }
      break;
    case -1238066820: 
      if (paramString.equals("android.permission.BODY_SENSORS")) {
        i = 18;
      }
      break;
    case -1479758289: 
      if (paramString.equals("android.permission.RECEIVE_WAP_PUSH")) {
        i = 22;
      }
      break;
    case -1888586689: 
      if (paramString.equals("android.permission.ACCESS_FINE_LOCATION")) {
        i = 8;
      }
      break;
    case -1921431796: 
      if (paramString.equals("android.permission.READ_CALL_LOG")) {
        i = 13;
      }
      break;
    case -1928411001: 
      if (paramString.equals("android.permission.READ_CALENDAR")) {
        i = 0;
      }
      break;
    case -2062386608: 
      if (paramString.equals("android.permission.READ_SMS")) {
        i = 21;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return 20;
    case 27: 
      return 19;
    case 26: 
      return 18;
    case 24: 
    case 25: 
      return 15;
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
      return 13;
    case 18: 
      return 12;
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
      return 8;
    case 9: 
      return 7;
    case 7: 
    case 8: 
      return 3;
    case 6: 
      return 4;
    case 3: 
    case 4: 
    case 5: 
      return 2;
    case 2: 
      return 1;
    }
    return 0;
  }
  
  static List<String> a(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str;
    switch (paramInt)
    {
    case 10: 
    default: 
      return localArrayList;
    case 19: 
      if ((Build.VERSION.SDK_INT < 29) || (!a(paramContext, localArrayList, "android.permission.ACTIVITY_RECOGNITION"))) {
        return localArrayList;
      }
      paramContext = "android.permission.ACTIVITY_RECOGNITION";
      break;
    case 18: 
      if ((Build.VERSION.SDK_INT < 29) || (!a(paramContext, localArrayList, "android.permission.ACCESS_MEDIA_LOCATION"))) {
        return localArrayList;
      }
      paramContext = "android.permission.ACCESS_MEDIA_LOCATION";
      break;
    case 16: 
      if ((Build.VERSION.SDK_INT < 23) || (!a(paramContext, localArrayList, "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS"))) {
        return localArrayList;
      }
      paramContext = "android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS";
      break;
    case 15: 
      if (a(paramContext, localArrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
        localArrayList.add("android.permission.READ_EXTERNAL_STORAGE");
      }
      if (!a(paramContext, localArrayList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
        return localArrayList;
      }
      paramContext = "android.permission.WRITE_EXTERNAL_STORAGE";
    case 13: 
    case 12: 
    case 8: 
    case 7: 
    case 14: 
    case 6: 
    case 9: 
    case 11: 
    case 17: 
    case 20: 
    case 4: 
    case 3: 
    case 5: 
    case 2: 
      for (;;)
      {
        localArrayList.add(paramContext);
        return localArrayList;
        if (a(paramContext, localArrayList, "android.permission.SEND_SMS")) {
          localArrayList.add("android.permission.SEND_SMS");
        }
        if (a(paramContext, localArrayList, "android.permission.RECEIVE_SMS")) {
          localArrayList.add("android.permission.RECEIVE_SMS");
        }
        if (a(paramContext, localArrayList, "android.permission.READ_SMS")) {
          localArrayList.add("android.permission.READ_SMS");
        }
        if (a(paramContext, localArrayList, "android.permission.RECEIVE_WAP_PUSH")) {
          localArrayList.add("android.permission.RECEIVE_WAP_PUSH");
        }
        if (!a(paramContext, localArrayList, "android.permission.RECEIVE_MMS")) {
          return localArrayList;
        }
        paramContext = "android.permission.RECEIVE_MMS";
        continue;
        if (Build.VERSION.SDK_INT < 20) {
          return localArrayList;
        }
        str = "android.permission.BODY_SENSORS";
        if (!a(paramContext, localArrayList, "android.permission.BODY_SENSORS")) {
          return localArrayList;
        }
        paramContext = str;
        break;
        if (a(paramContext, localArrayList, "android.permission.READ_PHONE_STATE")) {
          localArrayList.add("android.permission.READ_PHONE_STATE");
        }
        if ((Build.VERSION.SDK_INT > 29) && (a(paramContext, localArrayList, "android.permission.READ_PHONE_NUMBERS"))) {
          localArrayList.add("android.permission.READ_PHONE_NUMBERS");
        }
        if (a(paramContext, localArrayList, "android.permission.CALL_PHONE")) {
          localArrayList.add("android.permission.CALL_PHONE");
        }
        if (a(paramContext, localArrayList, "android.permission.READ_CALL_LOG")) {
          localArrayList.add("android.permission.READ_CALL_LOG");
        }
        if (a(paramContext, localArrayList, "android.permission.WRITE_CALL_LOG")) {
          localArrayList.add("android.permission.WRITE_CALL_LOG");
        }
        if (a(paramContext, localArrayList, "com.android.voicemail.permission.ADD_VOICEMAIL")) {
          localArrayList.add("com.android.voicemail.permission.ADD_VOICEMAIL");
        }
        if (a(paramContext, localArrayList, "android.permission.USE_SIP")) {
          localArrayList.add("android.permission.USE_SIP");
        }
        if ((Build.VERSION.SDK_INT >= 29) && (a(paramContext, localArrayList, "android.permission.BIND_CALL_REDIRECTION_SERVICE"))) {
          localArrayList.add("android.permission.BIND_CALL_REDIRECTION_SERVICE");
        }
        if ((Build.VERSION.SDK_INT < 26) || (!a(paramContext, localArrayList, "android.permission.ANSWER_PHONE_CALLS"))) {
          return localArrayList;
        }
        paramContext = "android.permission.ANSWER_PHONE_CALLS";
        continue;
        str = "android.permission.RECORD_AUDIO";
        if (!a(paramContext, localArrayList, "android.permission.RECORD_AUDIO")) {
          return localArrayList;
        }
        paramContext = str;
        break;
        return null;
        if ((Build.VERSION.SDK_INT >= 29) && (a(paramContext, localArrayList, "android.permission.ACCESS_BACKGROUND_LOCATION"))) {
          localArrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
        }
        if (a(paramContext, localArrayList, "android.permission.ACCESS_COARSE_LOCATION")) {
          localArrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        str = "android.permission.ACCESS_FINE_LOCATION";
        if (!a(paramContext, localArrayList, "android.permission.ACCESS_FINE_LOCATION")) {
          return localArrayList;
        }
        paramContext = str;
        break;
        if (a(paramContext, localArrayList, "android.permission.READ_CONTACTS")) {
          localArrayList.add("android.permission.READ_CONTACTS");
        }
        if (a(paramContext, localArrayList, "android.permission.WRITE_CONTACTS")) {
          localArrayList.add("android.permission.WRITE_CONTACTS");
        }
        if (!a(paramContext, localArrayList, "android.permission.GET_ACCOUNTS")) {
          return localArrayList;
        }
        paramContext = "android.permission.GET_ACCOUNTS";
      }
    case 1: 
      str = "android.permission.CAMERA";
      if (!a(paramContext, localArrayList, "android.permission.CAMERA")) {
        return localArrayList;
      }
      break;
    }
    for (paramContext = str;; paramContext = str)
    {
      localArrayList.add(paramContext);
      return localArrayList;
      if (a(paramContext, localArrayList, "android.permission.READ_CALENDAR")) {
        localArrayList.add("android.permission.READ_CALENDAR");
      }
      str = "android.permission.WRITE_CALENDAR";
      if (!a(paramContext, localArrayList, "android.permission.WRITE_CALENDAR")) {
        break;
      }
    }
    return localArrayList;
  }
  
  static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject = a(paramActivity, paramInt);
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a(paramActivity, (String)((Iterator)localObject).next());
      }
    }
  }
  
  static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("GENERIC_PREFERENCES", 0).edit();
    paramContext.putBoolean(paramString, true);
    paramContext.apply();
  }
  
  @RequiresApi(api=23)
  static boolean a(Activity paramActivity, String paramString)
  {
    if (paramActivity == null) {
      return false;
    }
    return b(paramActivity, paramString);
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("GENERIC_PREFERENCES", 0).getBoolean(paramString, false);
  }
  
  private static boolean a(Context paramContext, ArrayList<String> paramArrayList, String paramString)
  {
    if (paramArrayList != null) {}
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (((String)paramArrayList.next()).equals(paramString)) {
          return true;
        }
      }
      if (paramContext == null)
      {
        Log.d("permissions_handler", "Unable to detect current Activity or App Context.");
        return false;
      }
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4096);
      if (paramContext == null)
      {
        Log.d("permissions_handler", "Unable to get Package info, will not be able to determine permissions to request.");
        return false;
      }
      paramContext = new ArrayList(Arrays.asList(paramContext.requestedPermissions)).iterator();
      boolean bool;
      do
      {
        if (!paramContext.hasNext()) {
          break;
        }
        bool = ((String)paramContext.next()).equals(paramString);
      } while (!bool);
      return true;
    }
    catch (Exception paramContext)
    {
      label126:
      break label126;
    }
    Log.d("permissions_handler", "Unable to check manifest for permission: ", paramContext);
    return false;
  }
  
  @RequiresApi(api=23)
  static boolean b(Activity paramActivity, String paramString)
  {
    boolean bool1 = a(paramActivity, paramString);
    boolean bool2 = ActivityCompat.shouldShowRequestPermissionRationale(paramActivity, paramString);
    return (bool1) && (!bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.baseflow.permissionhandler.PermissionUtils
 * JD-Core Version:    0.7.0.1
 */