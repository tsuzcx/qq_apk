package com.tencent.biz.qqstory.shareGroup.infocard.model;

import com.tencent.biz.qqstory.network.BatchNetHandler;
import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.network.handler.VidToShareGroupVideoInfoHandler;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import java.util.List;

public class ShareGroupDataPuller
  extends MemoryDataPuller
{
  protected final String a;
  protected final int b;
  
  public ShareGroupDataPuller(String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramString2);
    this.a = paramString1;
    this.b = paramInt;
  }
  
  protected BatchNetHandler a(String paramString, List<String> paramList)
  {
    return new VidToShareGroupVideoInfoHandler(paramString, paramList);
  }
  
  protected INetPageLoader a()
  {
    return new ShareGroupDateListPageLoader(this.a, this.b, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDataPuller
 * JD-Core Version:    0.7.0.1
 */