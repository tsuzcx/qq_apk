package com.tencent.biz.qqstory.network.handler;

import android.os.Bundle;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.biz.qqstory.support.logging.SLog;
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
import com.tribe.async.dispatch.Dispatchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nfo;

public class GetHotSortVideoHandler$GetHotSortVideoResponse
  extends LegoResponseBase
{
  qqstory_group.RspGetGroupHotRankVideo jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo;
  boolean jdField_a_of_type_Boolean = false;
  
  public GetHotSortVideoHandler$GetHotSortVideoResponse(GetHotSortVideoHandler paramGetHotSortVideoHandler, qqstory_group.RspGetGroupHotRankVideo paramRspGetGroupHotRankVideo, boolean paramBoolean)
  {
    super(paramRspGetGroupHotRankVideo.result);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo = paramRspGetGroupHotRankVideo;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public GetHotSortVideoHandler$GetHotSortVideoResponse(GetHotSortVideoHandler paramGetHotSortVideoHandler, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler;
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.is_end.get() == 1) {}
    GetHotSortVideoHandler.GetVideoByHotSortEvent localGetVideoByHotSortEvent;
    for (boolean bool = true;; bool = false)
    {
      ((GetHotSortVideoHandler)localObject).jdField_a_of_type_Boolean = bool;
      GetHotSortVideoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.next_cookie.get().toStringUtf8());
      GetHotSortVideoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler, this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.seq.get());
      localObject = new ArrayList();
      localGetVideoByHotSortEvent = new GetHotSortVideoHandler.GetVideoByHotSortEvent();
      localGetVideoByHotSortEvent.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler.jdField_a_of_type_Boolean;
      localGetVideoByHotSortEvent.b = this.jdField_a_of_type_Boolean;
      if ((!this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.has()) || (this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.size() <= 0)) {
        break label203;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_group$RspGetGroupHotRankVideo.video_card_list.get().iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(HotSortVideoEntry.convertFrom((qqstory_group.HotVideoCard)localIterator.next()));
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      ThreadManager.post(new nfo(this, (ArrayList)localObject, localGetVideoByHotSortEvent), 5, null, true);
      return;
      label203:
      SLog.e("GetHotSortVideoHandler", "GetHotSortVideoResponse Success but video_card_list is empty。");
    }
    localGetVideoByHotSortEvent.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    Dispatchers.get().dispatch(localGetVideoByHotSortEvent);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    paramBundle = new GetHotSortVideoHandler.GetVideoByHotSortEvent();
    paramBundle.c = true;
    Dispatchers.get().dispatch(paramBundle);
    QQToast.a(BaseApplication.getContext(), 1, "拉取失败，请稍后再试", 0).a();
    if (QLog.isColorLevel()) {
      QLog.e("GetHotSortVideoHandler", 2, "GetUserIconListResponse onNetError errorCode " + paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    GetHotSortVideoHandler.GetVideoByHotSortEvent localGetVideoByHotSortEvent = new GetHotSortVideoHandler.GetVideoByHotSortEvent();
    localGetVideoByHotSortEvent.c = true;
    Dispatchers.get().dispatch(localGetVideoByHotSortEvent);
    QQToast.a(BaseApplication.getContext(), 1, "拉取失败，请稍后再试", 0).a();
    if (QLog.isColorLevel()) {
      QLog.e("GetHotSortVideoHandler", 2, "GetUserIconListResponse errorCode:" + paramInt + " errorMsg:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse
 * JD-Core Version:    0.7.0.1
 */