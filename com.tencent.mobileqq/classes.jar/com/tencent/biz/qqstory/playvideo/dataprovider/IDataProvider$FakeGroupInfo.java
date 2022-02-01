package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;

public class IDataProvider$FakeGroupInfo
  extends IDataProvider.GroupInfo
{
  public ErrorMessage a;
  
  public IDataProvider$FakeGroupInfo(IDataProvider.GroupId paramGroupId, @Nullable ErrorMessage paramErrorMessage)
  {
    super(paramGroupId);
    if (paramErrorMessage == null) {
      this.a = new ErrorMessage(97000001, "loading");
    } else {
      this.a = paramErrorMessage;
    }
    this.c = new ArrayList();
  }
  
  public boolean a()
  {
    return this.a.errorCode == 97000000;
  }
  
  public boolean b()
  {
    return (!a()) && (!c());
  }
  
  public boolean c()
  {
    return this.a.errorCode == 97000001;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fg{g=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", em=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.FakeGroupInfo
 * JD-Core Version:    0.7.0.1
 */