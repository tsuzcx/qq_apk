package com.tencent.biz.videostory.widget.view.smartmusicview;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;
import java.util.List;

class SmartMusicAdapter$2
  implements VSDispatchObserver.onVSRspCallBack<CLIENT.StBatchGetMusicInfoRsp>
{
  SmartMusicAdapter$2(SmartMusicAdapter paramSmartMusicAdapter, boolean paramBoolean) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
    {
      paramBaseRequest = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
      int j;
      if (paramBaseRequest != null)
      {
        j = ((Integer)SmartMusicAdapter.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter).get(paramBaseRequest.strSongMid.get())).intValue();
        if ((j >= 0) && (j < SmartMusicAdapter.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter).size())) {
          break label106;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label106:
        VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)SmartMusicAdapter.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter).get(j);
        if (localVsMusicItemInfo.mSongMid.equals(paramBaseRequest.strSongMid.get()))
        {
          localVsMusicItemInfo.a(paramBaseRequest);
          localVsMusicItemInfo.jdField_a_of_type_Boolean = true;
          if (!StringUtil.a(paramString)) {
            localVsMusicItemInfo.c = paramString;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewSmartMusicAdapter.a().post(new SmartMusicAdapter.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicAdapter.2
 * JD-Core Version:    0.7.0.1
 */