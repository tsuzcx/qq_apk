package com.tencent.biz.qqstory.network.handler;

import android.os.Bundle;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetHotSortVideoHandler$GetHotSortVideoResponse
  extends LegoResponseBase
{
  qqstory_group.RspGetGroupHotRankVideo a;
  boolean b = false;
  
  public GetHotSortVideoHandler$GetHotSortVideoResponse(GetHotSortVideoHandler paramGetHotSortVideoHandler, qqstory_group.RspGetGroupHotRankVideo paramRspGetGroupHotRankVideo, boolean paramBoolean)
  {
    super(paramRspGetGroupHotRankVideo.result);
    this.a = paramRspGetGroupHotRankVideo;
    this.b = paramBoolean;
  }
  
  public GetHotSortVideoHandler$GetHotSortVideoResponse(GetHotSortVideoHandler paramGetHotSortVideoHandler, boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a()
  {
    Object localObject = this.c;
    boolean bool;
    if (this.a.is_end.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((GetHotSortVideoHandler)localObject).a = bool;
    GetHotSortVideoHandler.a(this.c, this.a.next_cookie.get().toStringUtf8());
    GetHotSortVideoHandler.a(this.c, this.a.seq.get());
    localObject = new ArrayList();
    GetHotSortVideoHandler.GetVideoByHotSortEvent localGetVideoByHotSortEvent = new GetHotSortVideoHandler.GetVideoByHotSortEvent();
    localGetVideoByHotSortEvent.b = this.c.a;
    localGetVideoByHotSortEvent.c = this.b;
    if ((this.a.video_card_list.has()) && (this.a.video_card_list.size() > 0))
    {
      Iterator localIterator = this.a.video_card_list.get().iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(HotSortVideoEntry.convertFrom((qqstory_group.HotVideoCard)localIterator.next()));
      }
      if (!this.b) {
        ThreadManager.post(new GetHotSortVideoHandler.GetHotSortVideoResponse.1(this, (ArrayList)localObject, localGetVideoByHotSortEvent), 5, null, true);
      }
    }
    else
    {
      SLog.e("GetHotSortVideoHandler", "GetHotSortVideoResponse Success but video_card_list is empty。");
    }
    localGetVideoByHotSortEvent.a = ((ArrayList)localObject);
    StoryDispatcher.a().dispatch(localGetVideoByHotSortEvent);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = new GetHotSortVideoHandler.GetVideoByHotSortEvent();
    paramBundle.d = true;
    StoryDispatcher.a().dispatch(paramBundle);
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131903235), 0).show();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("GetUserIconListResponse onNetError errorCode ");
      paramBundle.append(paramInt);
      QLog.e("GetHotSortVideoHandler", 2, paramBundle.toString());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new GetHotSortVideoHandler.GetVideoByHotSortEvent();
    ((GetHotSortVideoHandler.GetVideoByHotSortEvent)localObject).d = true;
    StoryDispatcher.a().dispatch((Dispatcher.Dispatchable)localObject);
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131903234), 0).show();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GetUserIconListResponse errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" errorMsg:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("GetHotSortVideoHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse
 * JD-Core Version:    0.7.0.1
 */