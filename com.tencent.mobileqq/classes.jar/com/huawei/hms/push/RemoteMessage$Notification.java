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
  private final long[] A;
  private final String B;
  private final String a;
  private final String b;
  private final String[] c;
  private final String d;
  private final String e;
  private final String[] f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final Uri n;
  private final int o;
  private final String p;
  private final int q;
  private final int r;
  private final int s;
  private final int[] t;
  private final String u;
  private final int v;
  private final String w;
  private final int x;
  private final String y;
  private final String z;
  
  private RemoteMessage$Notification(Bundle paramBundle)
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
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (localObject = Uri.parse((String)localObject);; localObject = null)
    {
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
      return;
    }
  }
  
  private Integer a(String paramString)
  {
    Integer localInteger = null;
    if (paramString != null) {}
    try
    {
      localInteger = Integer.valueOf(paramString);
      return localInteger;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      HMSLog.w("RemoteMessage", "NumberFormatException: get " + paramString + " failed.");
    }
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
    if (this.f == null) {
      return null;
    }
    return (String[])this.f.clone();
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
    if (this.p == null) {
      return null;
    }
    return Uri.parse(this.p);
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
    if (this.t == null) {
      return null;
    }
    return (int[])this.t.clone();
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
    if (this.c == null) {
      return null;
    }
    return (String[])this.c.clone();
  }
  
  public String getTitleLocalizationKey()
  {
    return this.b;
  }
  
  public long[] getVibrateConfig()
  {
    if (this.A == null) {
      return null;
    }
    return (long[])this.A.clone();
  }
  
  public Integer getVisibility()
  {
    return a(this.B);
  }
  
  public Long getWhen()
  {
    Long localLong = null;
    if (!TextUtils.isEmpty(this.u)) {}
    try
    {
      long l1 = DateUtil.parseUtcToMillisecond(this.u);
      localLong = Long.valueOf(l1);
      return localLong;
    }
    catch (ParseException localParseException)
    {
      HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
      return null;
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
      HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
    }
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