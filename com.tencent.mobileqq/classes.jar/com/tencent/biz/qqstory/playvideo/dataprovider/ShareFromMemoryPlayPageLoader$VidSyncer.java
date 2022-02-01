package com.tencent.biz.qqstory.playvideo.dataprovider;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;
import java.util.ArrayList;
import java.util.List;

class ShareFromMemoryPlayPageLoader$VidSyncer
  implements IGroupPageLoader.IVidFullSyncer
{
  IDataProvider.GroupId a;
  private List<String> c = new ArrayList();
  private int d;
  
  public ShareFromMemoryPlayPageLoader$VidSyncer(ShareFromMemoryPlayPageLoader paramShareFromMemoryPlayPageLoader, IDataProvider.GroupId paramGroupId)
  {
    this.a = paramGroupId;
  }
  
  public void a(IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    this.c.clear();
    a(ShareFromMemoryPlayPageLoader.a(this.b), paramCallBack);
  }
  
  protected void a(String paramString, IGroupPageLoader.IVidFullSyncer.CallBack paramCallBack)
  {
    GetCollectionVideoListRequest localGetCollectionVideoListRequest = new GetCollectionVideoListRequest();
    localGetCollectionVideoListRequest.g = ShareFromMemoryPlayPageLoader.b(this.b).uid;
    if (ShareFromMemoryPlayPageLoader.b(this.b).collectionKey != null) {
      localGetCollectionVideoListRequest.j = VideoCollectionEntry.getCollectionId(ShareFromMemoryPlayPageLoader.b(this.b).collectionKey);
    }
    localGetCollectionVideoListRequest.h = paramString;
    localGetCollectionVideoListRequest.i = 20;
    localGetCollectionVideoListRequest.k = ShareFromMemoryPlayPageLoader.b(this.b).shareTimeZone;
    localGetCollectionVideoListRequest.l = ShareFromMemoryPlayPageLoader.b(this.b).feedId;
    localGetCollectionVideoListRequest.m = ShareFromMemoryPlayPageLoader.b(this.b).identify;
    localGetCollectionVideoListRequest.n = ShareFromMemoryPlayPageLoader.b(this.b).videoListOrder;
    CmdTaskManger.a().a(localGetCollectionVideoListRequest, new ShareFromMemoryPlayPageLoader.VidSyncer.1(this, paramCallBack));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.ShareFromMemoryPlayPageLoader.VidSyncer
 * JD-Core Version:    0.7.0.1
 */