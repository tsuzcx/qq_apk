package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;

public class NotificationElement
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "";
  private String b = "";
  private String c = "";
  private String d;
  
  public NotificationElement() {}
  
  public NotificationElement(Intent paramIntent, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public Intent a()
  {
    return this.jdField_a_of_type_AndroidContentIntent;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public String a()
  {
    return this.d;
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public void c(String paramString)
  {
    this.b = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.c = paramString;
  }
  
  @NonNull
  public String toString()
  {
    Bundle localBundle;
    if (a() != null) {
      localBundle = a().getExtras();
    } else {
      localBundle = null;
    }
    String str;
    if (a() != null) {
      str = String.valueOf(a().getHeight());
    } else {
      str = "using default bitmap";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotificationElement{contentIntentExtras=");
    localStringBuilder.append(localBundle);
    localStringBuilder.append(", ticker='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentTitle='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notificationContentText='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", notificationIconBitmap=");
    localStringBuilder.append(str);
    localStringBuilder.append(", briefOfMessage='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.NotificationElement
 * JD-Core Version:    0.7.0.1
 */