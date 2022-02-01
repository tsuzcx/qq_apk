package com.tencent.biz.pubaccount.util.api;

import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.net.URL;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountGifPlayTimeHttpDownloader
  extends QRouteApi
{
  public static final String PROTOCOL_GIF_PLAY_ACCOUNT = "pubaccountimage_gifplaytime";
  
  public abstract ProtocolDownloader getHttpDownloader();
  
  public abstract URL getPubURL(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountGifPlayTimeHttpDownloader
 * JD-Core Version:    0.7.0.1
 */