package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;

public final class MemoryPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected String b;
  protected String c;
  
  public MemoryPlayingListSync(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    this.c = paramString1;
    this.b = paramString3;
  }
  
  protected int a()
  {
    return 20;
  }
  
  protected VidToVideoInfoPuller a()
  {
    return new VidToVideoInfoPuller(this.a, this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.MemoryPlayingListSync
 * JD-Core Version:    0.7.0.1
 */