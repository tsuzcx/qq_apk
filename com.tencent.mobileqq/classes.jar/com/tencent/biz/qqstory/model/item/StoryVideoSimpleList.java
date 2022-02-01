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
      SLog.e("Q.qqstory.home.StoryVideoSimpleList", "<init> error:" + paramStoryVideoSimpleInfoEntity);
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
    this.unionId = ((StoryVideoSimpleList)paramObject).unionId;
    this.vid = ((StoryVideoSimpleList)paramObject).vid;
    this.videoCover = ((StoryVideoSimpleList)paramObject).videoCover;
  }
  
  public StoryVideoSimpleInfoEntity cover2Entity()
  {
    StoryVideoSimpleInfoEntity localStoryVideoSimpleInfoEntity = new StoryVideoSimpleInfoEntity();
    localStoryVideoSimpleInfoEntity.unionId = this.unionId;
    qqstory_struct.FriendStoryDes localFriendStoryDes = new qqstory_struct.FriendStoryDes();
    ArrayList localArrayList = new ArrayList(getCount());
    int i = 0;
    if (i < getCount())
    {
      qqstory_struct.StoryVideoSimpleInfo localStoryVideoSimpleInfo = new qqstory_struct.StoryVideoSimpleInfo();
      if ((this.videoCover.length > i) && (!TextUtils.isEmpty(this.videoCover[i])))
      {
        localStoryVideoSimpleInfo.video_cover.set(ByteStringMicro.copyFromUtf8(this.videoCover[i]));
        label94:
        if ((this.vid.length <= i) || (TextUtils.isEmpty(this.vid[i]))) {
          break label176;
        }
        localStoryVideoSimpleInfo.vid.set(ByteStringMicro.copyFromUtf8(this.vid[i]));
        localArrayList.add(localStoryVideoSimpleInfo);
      }
      for (;;)
      {
        i += 1;
        break;
        SLog.e("Q.qqstory.home.StoryVideoSimpleList", "cover2Entity error video cover is null:" + i);
        break label94;
        label176:
        SLog.e("Q.qqstory.home.StoryVideoSimpleList", "cover2Entity error vid is null:" + i);
      }
    }
    localFriendStoryDes.simple_info_list.set(localArrayList);
    localStoryVideoSimpleInfoEntity.data = localFriendStoryDes.toByteArray();
    return localStoryVideoSimpleInfoEntity;
  }
  
  public int getCount()
  {
    if (this.vid == null) {
      return 0;
    }
    return this.vid.length;
  }
  
  public String toString()
  {
    return "StoryVideoSimpleList{unionId='" + this.unionId + '\'' + ", vid=" + Arrays.toString(this.vid) + ", videoCover=" + Arrays.toString(this.videoCover) + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.StoryVideoSimpleList
 * JD-Core Version:    0.7.0.1
 */