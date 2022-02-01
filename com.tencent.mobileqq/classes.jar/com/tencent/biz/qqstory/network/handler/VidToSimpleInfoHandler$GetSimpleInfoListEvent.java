package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import java.util.ArrayList;
import java.util.List;

public class VidToSimpleInfoHandler$GetSimpleInfoListEvent
  extends BaseEvent
{
  public String a;
  public List<VideoCollectionItem.FakeVideoUIItem> b = new ArrayList();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" collectionId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("mSimpleInfoList.size=");
    localStringBuilder.append(this.b.size());
    localStringBuilder.append("mSimpleInfoList=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.VidToSimpleInfoHandler.GetSimpleInfoListEvent
 * JD-Core Version:    0.7.0.1
 */