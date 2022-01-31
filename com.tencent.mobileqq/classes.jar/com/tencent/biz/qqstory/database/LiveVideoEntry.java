package com.tencent.biz.qqstory.database;

import aukm;
import auma;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.LiveVideoDes;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class LiveVideoEntry
  extends aukm
{
  public String coverUrl;
  public int fromId;
  @auma
  public int roomId;
  public long startTime;
  public String unionId;
  
  public static LiveVideoEntry convertFrom(String paramString, qqstory_struct.LiveVideoDes paramLiveVideoDes)
  {
    if (paramLiveVideoDes == null) {
      return null;
    }
    LiveVideoEntry localLiveVideoEntry = new LiveVideoEntry();
    localLiveVideoEntry.unionId = paramString;
    localLiveVideoEntry.roomId = paramLiveVideoDes.room_id.get();
    localLiveVideoEntry.startTime = paramLiveVideoDes.start_time.get();
    localLiveVideoEntry.fromId = paramLiveVideoDes.from_id.get();
    localLiveVideoEntry.coverUrl = paramLiveVideoDes.cover_url.get().toStringUtf8();
    return localLiveVideoEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.LiveVideoEntry
 * JD-Core Version:    0.7.0.1
 */