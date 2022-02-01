package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;

public class IDataProvider$StartInfo
{
  public IDataProvider.GroupId a;
  @Nullable
  public String b;
  @Nullable
  public String c;
  @Nullable
  public IDataProvider.GroupInfo d;
  
  public IDataProvider$StartInfo(@Nullable IDataProvider.GroupId paramGroupId, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.a = paramGroupId;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public IDataProvider$StartInfo(StartInfo paramStartInfo)
  {
    this.a = paramStartInfo.a;
    this.b = paramStartInfo.b;
    this.c = paramStartInfo.c;
    this.d = paramStartInfo.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartInfo{mGroupId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.StartInfo
 * JD-Core Version:    0.7.0.1
 */