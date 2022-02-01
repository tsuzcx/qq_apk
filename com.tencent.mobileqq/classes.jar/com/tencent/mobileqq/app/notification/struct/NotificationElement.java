package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class NotificationElement
{
  private Intent a;
  private String b = "";
  private String c = "";
  private String d = "";
  private Bitmap e;
  private String f;
  
  public NotificationElement() {}
  
  public NotificationElement(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    this.a = paramIntent;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramBitmap;
  }
  
  public String a()
  {
    return this.f;
  }
  
  public void a(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.e = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public Intent b()
  {
    return this.a;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public Bitmap f()
  {
    return this.e;
  }
  
  @NonNull
  public String toString()
  {
    Bundle localBundle;
    if (b() != null) {
      localBundle = b().getExtras();
    } else {
      localBundle = null;
    }
    String str;
    if (f() != null) {
      str = String.valueOf(f().getHeight());
    } else {
      str = "using default bitmap";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotificationElement{contentIntentExtras=");
    localStringBuilder.append(localBundle);
    localStringBuilder.append(", ticker='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentTitle='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notificationContentText='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notificationIconBitmap=");
    localStringBuilder.append(str);
    localStringBuilder.append(", briefOfMessage='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.NotificationElement
 * JD-Core Version:    0.7.0.1
 */