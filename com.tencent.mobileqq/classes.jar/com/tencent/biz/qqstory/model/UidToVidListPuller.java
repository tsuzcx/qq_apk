package com.tencent.biz.qqstory.model;

import java.util.List;

public class UidToVidListPuller
{
  protected List<String> a;
  protected int b;
  protected UidToVidListPuller.OnFinishCallBack c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UidToVidListPuller{mUidList=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPullType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.UidToVidListPuller
 * JD-Core Version:    0.7.0.1
 */