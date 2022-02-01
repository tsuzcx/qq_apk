package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class IDataProvider$Data
{
  public ErrorMessage a;
  public boolean b;
  public List<IDataProvider.GroupInfo> c = new ArrayList();
  public boolean d;
  public ErrorMessage e;
  public boolean f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Data{upErrorMessage=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isUpEnd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mGroupInfoList=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isDownEnd=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isFastData=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", downErrorMessage=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.Data
 * JD-Core Version:    0.7.0.1
 */