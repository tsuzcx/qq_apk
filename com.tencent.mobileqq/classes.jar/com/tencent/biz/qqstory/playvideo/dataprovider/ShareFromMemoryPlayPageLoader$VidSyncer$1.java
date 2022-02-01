package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class ShareFromMemoryPlayPageLoader$VidSyncer$1
  implements CmdTaskManger.CommandCallback<GetCollectionVideoListRequest, GetCollectionVideoListResponse>
{
  ShareFromMemoryPlayPageLoader$VidSyncer$1(ShareFromMemoryPlayPageLoader.VidSyncer paramVidSyncer, IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack) {}
  
  public void a(@NonNull GetCollectionVideoListRequest paramGetCollectionVideoListRequest, @Nullable GetCollectionVideoListResponse paramGetCollectionVideoListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetCollectionVideoListResponse != null) && (!paramErrorMessage.isFail()))
    {
      paramGetCollectionVideoListResponse.g = ((StoryManager)SuperManager.a(5)).a(paramGetCollectionVideoListResponse.g);
      paramGetCollectionVideoListRequest = paramGetCollectionVideoListResponse.g.iterator();
      while (paramGetCollectionVideoListRequest.hasNext()) {
        ((StoryVideoItem)paramGetCollectionVideoListRequest.next()).mOwnerUid = ShareFromMemoryPlayPageLoader.b(this.b.b).uid;
      }
      ((DownloadUrlManager)SuperManager.a(28)).a(paramGetCollectionVideoListResponse.h);
      paramGetCollectionVideoListRequest = paramGetCollectionVideoListResponse.g.iterator();
      while (paramGetCollectionVideoListRequest.hasNext())
      {
        paramErrorMessage = (StoryVideoItem)paramGetCollectionVideoListRequest.next();
        ShareFromMemoryPlayPageLoader.VidSyncer.a(this.b).add(paramErrorMessage.mVid);
      }
      if ((!paramGetCollectionVideoListResponse.e) && (paramGetCollectionVideoListResponse.g.size() != 0))
      {
        ShareFromMemoryPlayPageLoader.VidSyncer.b(this.b);
        if (ShareFromMemoryPlayPageLoader.VidSyncer.c(this.b) > 50)
        {
          this.a.a(new ErrorMessage(940001, "too much times"), Collections.singletonList(this.b.a));
          return;
        }
        this.b.a(paramGetCollectionVideoListResponse.b, this.a);
        return;
      }
      paramGetCollectionVideoListRequest = new IDataProvider.GroupInfo(this.b.a);
      paramGetCollectionVideoListRequest.c = ShareFromMemoryPlayPageLoader.VidSyncer.a(this.b);
      paramGetCollectionVideoListRequest.a(ShareFromMemoryPlayPageLoader.b(this.b.b).feedId);
      this.a.a(Collections.singletonList(paramGetCollectionVideoListRequest), true);
      return;
    }
    this.a.a(paramErrorMessage, Collections.singletonList(this.b.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader.VidSyncer.1
 * JD-Core Version:    0.7.0.1
 */