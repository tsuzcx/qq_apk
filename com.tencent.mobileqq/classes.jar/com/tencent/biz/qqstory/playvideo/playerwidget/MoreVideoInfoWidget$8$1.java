package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.StoryProtocolObserver;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoDelete;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

class MoreVideoInfoWidget$8$1
  extends ProtoUtils.StoryProtocolObserver
{
  MoreVideoInfoWidget$8$1(MoreVideoInfoWidget.8 param8) {}
  
  public qqstory_struct.ErrorInfo a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.d.d.E();
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramBundle = this.d.d.i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("troop story delete result, code=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d(paramBundle, 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = this.d.d.p.c;
        localObject = new qqstory_group.RspGroupVideoDelete();
        ((qqstory_group.RspGroupVideoDelete)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (qqstory_struct.ErrorInfo)((qqstory_group.RspGroupVideoDelete)localObject).result.get();
        this.d.c.a(paramBundle, 0, this.d.b);
        this.d.c.a(paramBundle, 1, this.d.b);
        localObject = new DeleteStoryVideoEvent(new ErrorMessage(), this.d.b.mVid, false);
        ((DeleteStoryVideoEvent)localObject).b = this.d.b.mOwnerUid;
        ((DeleteStoryVideoEvent)localObject).d = paramBundle;
        ((DeleteStoryVideoEvent)localObject).h = false;
        ((DeleteStoryVideoEvent)localObject).c = this.d.d.D();
        ((DeleteStoryVideoEvent)localObject).e = this.d.b.mVideoIndex;
        if (((DeleteStoryVideoEvent)localObject).e == 0L) {
          ((DeleteStoryVideoEvent)localObject).e = this.d.b.mCreateTime;
        }
        Bosses.get().scheduleJobDelayed(new MoreVideoInfoWidget.8.1.1(this, this.d.d.i, (DeleteStoryVideoEvent)localObject), 400);
        return paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.d.d.i, 2, "parse RspGroupVideoDelete error", paramArrayOfByte);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.MoreVideoInfoWidget.8.1
 * JD-Core Version:    0.7.0.1
 */