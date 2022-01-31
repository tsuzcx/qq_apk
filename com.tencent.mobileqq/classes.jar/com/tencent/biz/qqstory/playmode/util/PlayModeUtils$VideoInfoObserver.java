package com.tencent.biz.qqstory.playmode.util;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetVideoFullInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl;
import com.tencent.biz.qqstory.network.request.GetVideoFullInfoListRequest;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class PlayModeUtils$VideoInfoObserver
  extends ProtoUtils.StoryProtocolObserver
{
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    long l = paramBundle.getLong("key_for_start_time");
    l = System.currentTimeMillis() - l;
    Object localObject1 = new qqstory_service.RspBatchGetVideoFullInfoList();
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      a(paramInt, null, null);
      StoryReportor.b("story_net", GetVideoFullInfoListRequest.a, 0, paramInt, new String[] { "", l + "", StoryReportor.a(BaseApplication.getContext()) });
      return null;
    }
    for (;;)
    {
      try
      {
        ((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).result.get();
        Object localObject2 = (qqstory_struct.StoryVideoFullInfo)((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).video_list.get(0);
        paramBundle = paramArrayOfByte.error_desc.get().toStringUtf8();
        paramInt = paramArrayOfByte.error_code.get();
        if (paramInt == 0)
        {
          paramBundle = new StoryVideoItem();
          paramBundle.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject2);
          paramBundle.mInteractStatus = ((qqstory_service.RspBatchGetVideoFullInfoList)localObject1).interact_status.get();
          if (paramBundle.mErrorCode == 0) {
            ((StoryManager)SuperManager.a(5)).a(paramBundle.mVid, paramBundle);
          }
          localObject2 = ((qqstory_struct.StoryVideoFullInfo)localObject2).compressed_video.get();
          if (localObject2 != null)
          {
            localObject1 = new ArrayList(((List)localObject2).size());
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext())
            {
              qqstory_struct.VideoUrl localVideoUrl = (qqstory_struct.VideoUrl)((Iterator)localObject2).next();
              VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
              localVideoUrlEntry.vid = paramBundle.mVid;
              localVideoUrlEntry.videoUrlLevel = localVideoUrl.video_level.get();
              localVideoUrlEntry.videoUrl = localVideoUrl.video_url.get();
              ((List)localObject1).add(localVideoUrlEntry);
              continue;
            }
          }
        }
        a(paramInt, paramBundle, null);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getVideoInfo - onResult, InvalidProtocolBufferMicroException, e:" + paramArrayOfByte.getMessage());
        }
        a(-1, null, null);
        return null;
        ((DownloadUrlManager)SuperManager.a(28)).b((List)localObject1);
        a(paramInt, null, paramBundle);
        StoryReportor.b("story_net", GetVideoFullInfoListRequest.a, 0, paramInt, new String[] { "", l + "", StoryReportor.a(BaseApplication.getContext()) });
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.player.PlayModeUtils", 2, "getVideoInfo - onResult, other exception, e:" + paramArrayOfByte.getMessage());
        }
        a(-1, null, null);
        return null;
      }
    }
  }
  
  public abstract void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.VideoInfoObserver
 * JD-Core Version:    0.7.0.1
 */