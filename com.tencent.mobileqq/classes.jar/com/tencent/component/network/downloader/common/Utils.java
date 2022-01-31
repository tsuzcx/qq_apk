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
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0));
      try
      {
        paramString = new ObjectInputStream(paramString);
        if (paramString != null)
        {
          paramString = paramString.readObject();
          return paramString;
        }
      }
      catch (StreamCorruptedException paramString)
      {
        QDLog.e("Utils", "", paramString);
        return null;
      }
      catch (IOException paramString)
      {
        QDLog.e("Utils", "", paramString);
        return null;
      }
      catch (ClassNotFoundException paramString)
      {
        QDLog.e("Utils", "", paramString);
      }
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
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      if (localObjectOutputStream == null) {
        break label59;
      }
      localObjectOutputStream.writeObject(paramObject);
      paramObject = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
    }
    catch (IOException paramObject)
    {
      for (;;)
      {
        QDLog.e("Utils", "", paramObject);
        paramObject = null;
      }
    }
    return paramObject;
  }
  
  public static int count(String paramString, char paramChar)
  {
    int i = 0;
    int k = 0;
    if (paramString == null) {
      return k;
    }
    int m = paramString.length();
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramChar == paramString.charAt(j)) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
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
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static String getDomin(String paramString)
  {
    String str2 = null;
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    for (;;)
    {
      return paramString;
      str1 = str2;
      try
      {
        str2 = new URL(paramString).getAuthority();
        paramString = str2;
        str1 = str2;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          int i = str2.indexOf(":");
          paramString = str2;
          if (i >= 0)
          {
            paramString = str2;
            str1 = str2;
            if (i < str2.length())
            {
              str1 = str2;
              paramString = str2.substring(0, i);
              return paramString;
            }
          }
        }
      }
      catch (MalformedURLException paramString) {}
    }
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
  
  /* Error */
  public static int getPort(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_m1
    //   8: ireturn
    //   9: new 153	java/net/URL
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 156	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: invokevirtual 160	java/net/URL:getAuthority	()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne -18 -> 7
    //   28: aload_0
    //   29: ldc 162
    //   31: invokevirtual 166	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   34: istore_1
    //   35: iload_1
    //   36: iflt -29 -> 7
    //   39: aload_0
    //   40: invokevirtual 93	java/lang/String:length	()I
    //   43: istore_2
    //   44: iload_1
    //   45: iload_2
    //   46: if_icmpge -39 -> 7
    //   49: aload_0
    //   50: iload_1
    //   51: iconst_1
    //   52: iadd
    //   53: invokevirtual 177	java/lang/String:substring	(I)Ljava/lang/String;
    //   56: invokestatic 183	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   59: invokevirtual 186	java/lang/Integer:intValue	()I
    //   62: istore_1
    //   63: iload_1
    //   64: ireturn
    //   65: astore_0
    //   66: iconst_m1
    //   67: ireturn
    //   68: astore_0
    //   69: iconst_m1
    //   70: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramString	String
    //   34	30	1	i	int
    //   43	4	2	j	int
    // Exception table:
    //   from	to	target	type
    //   9	35	65	java/net/MalformedURLException
    //   39	44	65	java/net/MalformedURLException
    //   49	63	65	java/net/MalformedURLException
    //   49	63	68	java/lang/Exception
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    paramContext = getCurrentProcessName(paramContext);
    if (paramContext == null) {}
    while (!paramContext.contains(":")) {
      return true;
    }
    return false;
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
    if ((paramPattern == null) || (TextUtils.isEmpty(paramString))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.common.Utils
 * JD-Core Version:    0.7.0.1
 */