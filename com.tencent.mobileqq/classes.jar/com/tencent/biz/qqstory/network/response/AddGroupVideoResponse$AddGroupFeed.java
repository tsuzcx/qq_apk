package com.tencent.biz.qqstory.network.response;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoStoryId;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tribe.async.utils.AssertUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddGroupVideoResponse$AddGroupFeed
{
  @NonNull
  public final String a;
  @NonNull
  public String b;
  @NonNull
  public final Map<String, String> c;
  
  public AddGroupVideoResponse$AddGroupFeed(@NonNull qqstory_group.GroupFeed paramGroupFeed)
  {
    this.a = paramGroupFeed.union_id.get().toStringUtf8();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramGroupFeed.story_id_list.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_group.VideoStoryId localVideoStoryId = (qqstory_group.VideoStoryId)localIterator.next();
      String str = localVideoStoryId.story_id.get().toStringUtf8();
      AssertUtils.assertTrue(TextUtils.isEmpty(str) ^ true);
      localHashMap.put(localVideoStoryId.vid.get().toStringUtf8(), str);
      this.b = localVideoStoryId.feed_id.get().toStringUtf8();
    }
    if (TextUtils.isEmpty(this.b)) {
      this.b = paramGroupFeed.feed_id.get().toStringUtf8();
    }
    this.c = Collections.unmodifiableMap(localHashMap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AddGroupFeed[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.AddGroupVideoResponse.AddGroupFeed
 * JD-Core Version:    0.7.0.1
 */