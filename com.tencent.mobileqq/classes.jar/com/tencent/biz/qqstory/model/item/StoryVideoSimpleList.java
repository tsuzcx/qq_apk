package com.tencent.biz.qqstory.model.item;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.StoryVideoSimpleInfoEntity;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FriendStoryDes;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoSimpleInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoryVideoSimpleList
  extends BaseUIItem
  implements Copyable
{
  public String unionId;
  public String[] vid;
  public String[] videoCover;
  
  public StoryVideoSimpleList(StoryVideoSimpleInfoEntity paramStoryVideoSimpleInfoEntity)
  {
    this.unionId = paramStoryVideoSimpleInfoEntity.unionId;
    Object localObject = new qqstory_struct.FriendStoryDes();
    try
    {
      ((qqstory_struct.FriendStoryDes)localObject).mergeFrom(paramStoryVideoSimpleInfoEntity.data);
      paramStoryVideoSimpleInfoEntity = ((qqstory_struct.FriendStoryDes)localObject).simple_info_list.get();
      this.vid = new String[paramStoryVideoSimpleInfoEntity.size()];
      this.videoCover = new String[paramStoryVideoSimpleInfoEntity.size()];
      int i = 0;
      while (i < paramStoryVideoSimpleInfoEntity.size())
      {
        localObject = (qqstory_struct.StoryVideoSimpleInfo)paramStoryVideoSimpleInfoEntity.get(i);
        this.vid[i] = ((qqstory_struct.StoryVideoSimpleInfo)localObject).vid.get().toStringUtf8();
        this.videoCover[i] = ((qqstory_struct.StoryVideoSimpleInfo)localObject).video_cover.get().toStringUtf8();
        i += 1;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramStoryVideoSimpleInfoEntity)
    {
      paramStoryVideoSimpleInfoEntity.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<init> error:");
      ((StringBuilder)localObject).append(paramStoryVideoSimpleInfoEntity);
      SLog.e("Q.qqstory.home.StoryVideoSimpleList", ((StringBuilder)localObject).toString());
    }
  }
  
  public StoryVideoSimpleList(String paramString, qqstory_struct.FriendStoryDes paramFriendStoryDes)
  {
    this.unionId = paramString;
    paramString = paramFriendStoryDes.simple_info_list.get();
    this.vid = new String[paramString.size()];
    this.videoCover = new String[paramString.size()];
    int i = 0;
    while (i < paramString.size())
    {
      paramFriendStoryDes = (qqstory_struct.StoryVideoSimpleInfo)paramString.get(i);
      this.vid[i] = paramFriendStoryDes.vid.get().toStringUtf8();
      this.videoCover[i] = paramFriendStoryDes.video_cover.get().toStringUtf8();
      i += 1;
    }
  }
  
  public void copy(Object paramObject)
  {
    paramObject = (StoryVideoSimpleList)paramObject;
    this.unionId = paramObject.unionId;
    this.vid = paramObject.vid;
    this.videoCover = paramObject.videoCover;
  }
  
  public StoryVideoSimpleInfoEntity cover2Entity()
  {
    StoryVideoSimpleInfoEntity localStoryVideoSimpleInfoEntity = new StoryVideoSimpleInfoEntity();
    localStoryVideoSimpleInfoEntity.unionId = this.unionId;
    qqstory_struct.FriendStoryDes localFriendStoryDes = new qqstory_struct.FriendStoryDes();
    ArrayList localArrayList = new ArrayList(getCount());
    int i = 0;
    while (i < getCount())
    {
      Object localObject1 = new qqstory_struct.StoryVideoSimpleInfo();
      Object localObject2 = this.videoCover;
      if ((localObject2.length > i) && (!TextUtils.isEmpty(localObject2[i])))
      {
        ((qqstory_struct.StoryVideoSimpleInfo)localObject1).video_cover.set(ByteStringMicro.copyFromUtf8(this.videoCover[i]));
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cover2Entity error video cover is null:");
        ((StringBuilder)localObject2).append(i);
        SLog.e("Q.qqstory.home.StoryVideoSimpleList", ((StringBuilder)localObject2).toString());
      }
      localObject2 = this.vid;
      if ((localObject2.length > i) && (!TextUtils.isEmpty(localObject2[i])))
      {
        ((qqstory_struct.StoryVideoSimpleInfo)localObject1).vid.set(ByteStringMicro.copyFromUtf8(this.vid[i]));
        localArrayList.add(localObject1);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("cover2Entity error vid is null:");
        ((StringBuilder)localObject1).append(i);
        SLog.e("Q.qqstory.home.StoryVideoSimpleList", ((StringBuilder)localObject1).toString());
      }
      i += 1;
    }
    localFriendStoryDes.simple_info_list.set(localArrayList);
    localStoryVideoSimpleInfoEntity.data = localFriendStoryDes.toByteArray();
    return localStoryVideoSimpleInfoEntity;
  }
  
  public int getCount()
  {
    String[] arrayOfString = this.vid;
    if (arrayOfString == null) {
      return 0;
    }
    return arrayOfString.length;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryVideoSimpleList{unionId='");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", vid=");
    localStringBuilder.append(Arrays.toString(this.vid));
    localStringBuilder.append(", videoCover=");
    localStringBuilder.append(Arrays.toString(this.videoCover));
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryVideoSimpleList
 * JD-Core Version:    0.7.0.1
 */