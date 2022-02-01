package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.database.PromoteTaskEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class PromoteTaskItem
{
  public long a;
  public int b;
  public String c;
  public String d;
  public long e;
  public long f;
  public long g;
  public long h;
  
  public static PromoteTaskItem a(qqstory_service.PromoteTask paramPromoteTask)
  {
    PromoteTaskItem localPromoteTaskItem = new PromoteTaskItem();
    localPromoteTaskItem.a = paramPromoteTask.uint64_taskid.get();
    localPromoteTaskItem.b = paramPromoteTask.uint32_promote_type.get();
    localPromoteTaskItem.c = paramPromoteTask.bytes_union_id.get().toStringUtf8();
    localPromoteTaskItem.d = paramPromoteTask.bytes_feed_id.get().toStringUtf8();
    localPromoteTaskItem.e = paramPromoteTask.uint64_limit_count.get();
    localPromoteTaskItem.f = paramPromoteTask.uint64_minimal_video_count.get();
    localPromoteTaskItem.g = paramPromoteTask.uint64_expire_time.get();
    return localPromoteTaskItem;
  }
  
  public PromoteTaskEntry a()
  {
    PromoteTaskEntry localPromoteTaskEntry = new PromoteTaskEntry();
    localPromoteTaskEntry.taskId = this.a;
    localPromoteTaskEntry.type = this.b;
    localPromoteTaskEntry.unionId = this.c;
    localPromoteTaskEntry.feedId = this.d;
    localPromoteTaskEntry.limitPromoteCount = this.e;
    localPromoteTaskEntry.minimalVideoCount = this.f;
    localPromoteTaskEntry.expireTime = this.g;
    localPromoteTaskEntry.promoteCount = this.h;
    return localPromoteTaskEntry;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PromoteTaskItem{taskId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", limitPromoteCount=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", minimalVideoCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", expireTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", promoteCount=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.PromoteTaskItem
 * JD-Core Version:    0.7.0.1
 */