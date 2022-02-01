package com.tencent.aelight.camera.aioeditor;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
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
    if (paramBoolean)
    {
      if (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0) {
        return;
      }
      int i = 0;
      while (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
      {
        paramBaseRequest = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
        if (paramBaseRequest != null)
        {
          int j = ((Integer)SmartMusicAdapter.b(this.b).get(paramBaseRequest.strSongMid.get())).intValue();
          if ((j >= 0) && (j < SmartMusicAdapter.c(this.b).size()))
          {
            VsMusicItemInfo localVsMusicItemInfo = (VsMusicItemInfo)SmartMusicAdapter.c(this.b).get(j);
            if (localVsMusicItemInfo.mSongMid.equals(paramBaseRequest.strSongMid.get()))
            {
              localVsMusicItemInfo.a(paramBaseRequest);
              localVsMusicItemInfo.d = true;
              if (!StringUtil.isEmpty(paramString)) {
                localVsMusicItemInfo.e = paramString;
              }
            }
          }
        }
        i += 1;
      }
      this.b.c().post(new SmartMusicAdapter.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.SmartMusicAdapter.2
 * JD-Core Version:    0.7.0.1
 */