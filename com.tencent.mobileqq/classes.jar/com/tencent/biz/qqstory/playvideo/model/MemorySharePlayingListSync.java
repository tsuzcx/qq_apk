package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.network.request.GetCollectionVideoListRequest;
import com.tencent.biz.qqstory.support.logging.SLog;

public class MemorySharePlayingListSync
  extends BasePagePlayingListSync
{
  protected String j;
  protected String k;
  protected int l;
  protected String m;
  protected int n;
  protected int o;
  
  protected void a() {}
  
  protected void b()
  {
    this.e = true;
    GetCollectionVideoListRequest localGetCollectionVideoListRequest = new GetCollectionVideoListRequest();
    localGetCollectionVideoListRequest.g = this.k;
    String str = this.j;
    if (str != null) {
      localGetCollectionVideoListRequest.j = VideoCollectionEntry.getCollectionId(str);
    }
    localGetCollectionVideoListRequest.h = this.c;
    localGetCollectionVideoListRequest.i = 20;
    localGetCollectionVideoListRequest.k = this.l;
    str = this.m;
    localGetCollectionVideoListRequest.l = str;
    int i = this.n;
    localGetCollectionVideoListRequest.m = i;
    localGetCollectionVideoListRequest.n = this.o;
    SLog.d("Q.qqstory.player.MemorySharePlayingListSync", "loadCollectionVideo with timezone. uid=%s feedid=%s identify=%d collectionId=%s timeZoneOffset=%d", new Object[] { this.k, str, Integer.valueOf(i), this.j, Integer.valueOf(localGetCollectionVideoListRequest.k) });
    CmdTaskManger.a().a(localGetCollectionVideoListRequest, new MemorySharePlayingListSync.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemorySharePlayingListSync
 * JD-Core Version:    0.7.0.1
 */