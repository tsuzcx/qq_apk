package com.tencent.aelight.camera.download.old.api;

import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class AEOldResInfo
{
  public static final AEOldResInfo a = new AEOldResInfo(-1, "215Config");
  public static final AEOldResInfo b = new AEOldResInfo(0, "AEBasePackage", "old_qq_android_native_short_filter_", 850003, 8500);
  public static final AEOldResInfo[] c = { a, b };
  public static final AEOldResInfo[] d = a();
  public final int e;
  public final String f;
  public final String g;
  public final int h;
  public final int i;
  public final boolean j;
  public boolean k = true;
  
  private AEOldResInfo(int paramInt, String paramString)
  {
    this.e = paramInt;
    this.f = paramString;
    this.g = null;
    this.h = -1;
    this.i = -1;
    this.j = false;
  }
  
  private AEOldResInfo(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramInt2;
    this.i = paramInt3;
    this.j = true;
  }
  
  private static AEOldResInfo[] a()
  {
    LinkedList localLinkedList = new LinkedList();
    AEOldResInfo[] arrayOfAEOldResInfo = c;
    int n = arrayOfAEOldResInfo.length;
    int m = 0;
    while (m < n)
    {
      AEOldResInfo localAEOldResInfo = arrayOfAEOldResInfo[m];
      if (localAEOldResInfo.j) {
        localLinkedList.add(localAEOldResInfo);
      }
      m += 1;
    }
    return (AEOldResInfo[])localLinkedList.toArray(new AEOldResInfo[0]);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{index:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", description:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", resPrefix:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", resVersionLimit:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", resVersion:");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isPackage:");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.AEOldResInfo
 * JD-Core Version:    0.7.0.1
 */