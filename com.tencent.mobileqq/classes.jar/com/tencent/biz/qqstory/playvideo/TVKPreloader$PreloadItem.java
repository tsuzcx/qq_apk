package com.tencent.biz.qqstory.playvideo;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;

public class TVKPreloader$PreloadItem
{
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  @NonNull
  public final String c;
  public final String d;
  
  public TVKPreloader$PreloadItem(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null))
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      return;
    }
    SLog.e("Q.qqstory.playernew.TVKPreloader", "vid=%s, videoUrl=%s, localPath=%s", new Object[] { paramString1, paramString2, paramString3 });
    throw new IllegalArgumentException("vid, videoUrl, localPath should not be null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (PreloadItem)paramObject;
      if (!this.a.equals(paramObject.a)) {
        return false;
      }
      if (!this.b.equals(paramObject.b)) {
        return false;
      }
      String str = this.d;
      if (str != null) {
        return str.equals(paramObject.d);
      }
      return paramObject.d == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = this.a.hashCode();
    int k = this.b.hashCode();
    String str = this.d;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PreloadItem{vid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", debugMsg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem
 * JD-Core Version:    0.7.0.1
 */