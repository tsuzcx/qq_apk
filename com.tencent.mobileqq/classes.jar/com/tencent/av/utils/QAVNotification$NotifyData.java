package com.tencent.av.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;

class QAVNotification$NotifyData
{
  String a;
  String b;
  Bitmap c;
  String d;
  String e;
  int f;
  int g;
  int h;
  boolean i = false;
  
  private QAVNotification$NotifyData(QAVNotification paramQAVNotification)
  {
    a(null);
  }
  
  QAVNotification$NotifyData(QAVNotification paramQAVNotification, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBitmap;
    this.d = paramString3;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.e = paramString4;
  }
  
  private void a(NotifyData paramNotifyData)
  {
    if (paramNotifyData != null)
    {
      this.a = paramNotifyData.a;
      this.f = paramNotifyData.f;
      this.d = paramNotifyData.d;
      this.b = paramNotifyData.b;
      this.e = paramNotifyData.e;
      this.g = paramNotifyData.g;
      this.h = paramNotifyData.h;
      this.i = paramNotifyData.i;
      return;
    }
    this.a = "";
    this.f = 0;
    this.d = "";
    this.b = "";
    this.e = "";
    this.g = 0;
    this.h = 0;
    this.i = false;
  }
  
  private boolean a()
  {
    int k = this.f;
    return (k == 47) || (k == 42) || (k == 48) || (k == 44);
  }
  
  private boolean b(NotifyData paramNotifyData)
  {
    return (paramNotifyData != null) && ((!TextUtils.equals(this.a, paramNotifyData.a)) || ((this.f != paramNotifyData.f) && (paramNotifyData.a())));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NotifyData{sessionId[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("], id[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], type[");
    localStringBuilder.append(this.f);
    localStringBuilder.append("], uinType[");
    localStringBuilder.append(this.g);
    localStringBuilder.append("], name[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("], extraName[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], head[");
    boolean bool;
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], isHide[");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QAVNotification.NotifyData
 * JD-Core Version:    0.7.0.1
 */