package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.text.ParseException;

public class RemoteMessage$Notification
  implements Serializable
{
  public final long[] A;
  public final String B;
  public final String a;
  public final String b;
  public final String[] c;
  public final String d;
  public final String e;
  public final String[] f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  public final String k;
  public final String l;
  public final String m;
  public final Uri n;
  public final int o;
  public final String p;
  public final int q;
  public final int r;
  public final int s;
  public final int[] t;
  public final String u;
  public final int v;
  public final String w;
  public final int x;
  public final String y;
  public final String z;
  
  public RemoteMessage$Notification(Bundle paramBundle)
  {
    this.a = paramBundle.getString("notifyTitle");
    this.d = paramBundle.getString("content");
    this.b = paramBundle.getString("title_loc_key");
    this.e = paramBundle.getString("body_loc_key");
    this.c = paramBundle.getStringArray("title_loc_args");
    this.f = paramBundle.getStringArray("body_loc_args");
    this.g = paramBundle.getString("icon");
    this.j = paramBundle.getString("color");
    this.h = paramBundle.getString("sound");
    this.i = paramBundle.getString("tag");
    this.m = paramBundle.getString("channelId");
    this.k = paramBundle.getString("acn");
    this.l = paramBundle.getString("intentUri");
    this.o = paramBundle.getInt("notifyId");
    Object localObject = paramBundle.getString("url");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      localObject = Uri.parse((String)localObject);
    } else {
      localObject = null;
    }
    this.n = ((Uri)localObject);
    this.p = paramBundle.getString("notifyIcon");
    this.q = paramBundle.getInt("defaultLightSettings");
    this.r = paramBundle.getInt("defaultSound");
    this.s = paramBundle.getInt("defaultVibrateTimings");
    this.t = paramBundle.getIntArray("lightSettings");
    this.u = paramBundle.getString("when");
    this.v = paramBundle.getInt("localOnly");
    this.w = paramBundle.getString("badgeSetNum", null);
    this.x = paramBundle.getInt("autoCancel");
    this.y = paramBundle.getString("priority", null);
    this.z = paramBundle.getString("ticker");
    this.A = paramBundle.getLongArray("vibrateTimings");
    this.B = paramBundle.getString("visibility", null);
  }
  
  public final Integer a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      localObject = Integer.valueOf(paramString);
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Object localObject;
      label11:
      break label11;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NumberFormatException: get ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" failed.");
    HMSLog.w("RemoteMessage", ((StringBuilder)localObject).toString());
    return null;
  }
  
  public Integer getBadgeNumber()
  {
    return a(this.w);
  }
  
  public String getBody()
  {
    return this.d;
  }
  
  public String[] getBodyLocalizationArgs()
  {
    String[] arrayOfString = this.f;
    if (arrayOfString == null) {
      return new String[0];
    }
    return (String[])arrayOfString.clone();
  }
  
  public String getBodyLocalizationKey()
  {
    return this.e;
  }
  
  public String getChannelId()
  {
    return this.m;
  }
  
  public String getClickAction()
  {
    return this.k;
  }
  
  public String getColor()
  {
    return this.j;
  }
  
  public String getIcon()
  {
    return this.g;
  }
  
  public Uri getImageUrl()
  {
    String str = this.p;
    if (str == null) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public Integer getImportance()
  {
    return a(this.y);
  }
  
  public String getIntentUri()
  {
    return this.l;
  }
  
  public int[] getLightSettings()
  {
    int[] arrayOfInt = this.t;
    if (arrayOfInt == null) {
      return new int[0];
    }
    return (int[])arrayOfInt.clone();
  }
  
  public Uri getLink()
  {
    return this.n;
  }
  
  public int getNotifyId()
  {
    return this.o;
  }
  
  public String getSound()
  {
    return this.h;
  }
  
  public String getTag()
  {
    return this.i;
  }
  
  public String getTicker()
  {
    return this.z;
  }
  
  public String getTitle()
  {
    return this.a;
  }
  
  public String[] getTitleLocalizationArgs()
  {
    String[] arrayOfString = this.c;
    if (arrayOfString == null) {
      return new String[0];
    }
    return (String[])arrayOfString.clone();
  }
  
  public String getTitleLocalizationKey()
  {
    return this.b;
  }
  
  public long[] getVibrateConfig()
  {
    long[] arrayOfLong = this.A;
    if (arrayOfLong == null) {
      return new long[0];
    }
    return (long[])arrayOfLong.clone();
  }
  
  public Integer getVisibility()
  {
    return a(this.B);
  }
  
  public Long getWhen()
  {
    if (!TextUtils.isEmpty(this.u)) {}
    try
    {
      long l1 = DateUtil.parseUtcToMillisecond(this.u);
      return Long.valueOf(l1);
    }
    catch (ParseException localParseException)
    {
      break label34;
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
      label23:
      break label23;
    }
    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
    break label42;
    label34:
    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
    label42:
    return null;
  }
  
  public boolean isAutoCancel()
  {
    return this.x == 1;
  }
  
  public boolean isDefaultLight()
  {
    return this.q == 1;
  }
  
  public boolean isDefaultSound()
  {
    return this.r == 1;
  }
  
  public boolean isDefaultVibrate()
  {
    return this.s == 1;
  }
  
  public boolean isLocalOnly()
  {
    return this.v == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.push.RemoteMessage.Notification
 * JD-Core Version:    0.7.0.1
 */