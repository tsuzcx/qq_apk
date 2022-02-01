package com.tencent.component.network.downloader.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.Base64;
import com.tencent.component.network.utils.NetworkUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
  public static boolean checkUrl(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (NetworkUtils.isNetworkUrl(paramString));
  }
  
  public static Object convertToObject(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new ObjectInputStream(paramString).readObject();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      QDLog.e("Utils", "", paramString);
      return null;
    }
    catch (IOException paramString)
    {
      QDLog.e("Utils", "", paramString);
      return null;
    }
    catch (StreamCorruptedException paramString)
    {
      QDLog.e("Utils", "", paramString);
    }
    return null;
  }
  
  public static String convertToString(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramObject);
      paramObject = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
      return paramObject;
    }
    catch (IOException paramObject)
    {
      QDLog.e("Utils", "", paramObject);
    }
    return null;
  }
  
  public static int count(String paramString, char paramChar)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    int m = paramString.length();
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (paramChar == paramString.charAt(i)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getRunningAppProcesses();
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == i)
          {
            paramContext = localRunningAppProcessInfo.processName;
            return paramContext;
          }
        }
      }
      return null;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String getDomin(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str1 = null;
    if (bool) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      String str2 = paramString;
      str1 = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        int i = paramString.indexOf(":");
        str2 = paramString;
        if (i >= 0)
        {
          str2 = paramString;
          str1 = paramString;
          if (i < paramString.length())
          {
            str1 = paramString;
            str2 = paramString.substring(0, i);
          }
        }
      }
      return str2;
    }
    catch (MalformedURLException paramString) {}
    return str1;
  }
  
  public static String getDominWithPort(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    return null;
  }
  
  public static int getPort(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = -1;
    if (bool) {
      return -1;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      int i = j;
      if (!TextUtils.isEmpty(paramString))
      {
        int k = paramString.indexOf(":");
        i = j;
        if (k >= 0)
        {
          int m = paramString.length();
          i = j;
          if (k < m) {
            i = Integer.valueOf(paramString.substring(k + 1)).intValue();
          }
        }
      }
      return i;
    }
    catch (MalformedURLException|Exception paramString) {}
    return -1;
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    paramContext = getCurrentProcessName(paramContext);
    if (paramContext == null) {
      return true;
    }
    return !paramContext.contains(":");
  }
  
  public static boolean isPortValid(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 65535);
  }
  
  public static byte[] marshall(Parcelable paramParcelable)
  {
    Object localObject2 = null;
    if (paramParcelable == null) {
      return null;
    }
    Object localObject1 = localObject2;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localObject2;
      paramParcelable.writeToParcel(localParcel, 0);
      localObject1 = localObject2;
      paramParcelable = localParcel.marshall();
      localObject1 = paramParcelable;
      localParcel.recycle();
      return paramParcelable;
    }
    catch (Exception paramParcelable) {}
    return localObject1;
  }
  
  public static boolean match(Pattern paramPattern, String paramString)
  {
    if (paramPattern != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        boolean bool = paramPattern.matcher(paramString).matches();
        return bool;
      }
      catch (Exception paramPattern)
      {
        QDLog.e("Utils", "", paramPattern);
      }
    }
    return false;
  }
  
  public static Parcel unmarshall(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    if (paramArrayOfByte == null) {
      return localParcel;
    }
    try
    {
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      return localParcel;
    }
    catch (Exception paramArrayOfByte) {}
    return localParcel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.Utils
 * JD-Core Version:    0.7.0.1
 */