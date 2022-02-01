package com.tencent.ilive.opensdk.linkmicinterface;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import java.util.Map;

public class LinkMicUserparams$LinkMicUserparamsBuilder
{
  private LinkMicUserparams linkMicUserparams = new LinkMicUserparams();
  
  public LinkMicUserparamsBuilder enableReceiveAudio(boolean paramBoolean)
  {
    this.linkMicUserparams.enableReceiveAudio = paramBoolean;
    return this;
  }
  
  public LinkMicUserparamsBuilder setLinkRoomSig(String paramString)
  {
    this.linkMicUserparams.linkRoomSig = paramString;
    return this;
  }
  
  public LinkMicUserparamsBuilder setParams(Map<String, Object> paramMap)
  {
    this.linkMicUserparams.params = paramMap;
    return this;
  }
  
  public LinkMicUserparamsBuilder setRenderRect(Rect paramRect)
  {
    this.linkMicUserparams.renderRect = paramRect;
    return this;
  }
  
  public LinkMicUserparamsBuilder setRoomId(long paramLong)
  {
    this.linkMicUserparams.roomId = paramLong;
    return this;
  }
  
  public LinkMicUserparamsBuilder setRootView(View paramView)
  {
    this.linkMicUserparams.rootView = paramView;
    return this;
  }
  
  public LinkMicUserparamsBuilder setSig(byte[] paramArrayOfByte)
  {
    this.linkMicUserparams.sig = paramArrayOfByte;
    return this;
  }
  
  public LinkMicUserparamsBuilder setToUid(String paramString)
  {
    this.linkMicUserparams.toUid = paramString;
    return this;
  }
  
  public LinkMicUserparamsBuilder setUid(String paramString)
  {
    this.linkMicUserparams.uid = paramString;
    return this;
  }
  
  public LinkMicUserparamsBuilder setVideoSourceBitmap(Bitmap paramBitmap)
  {
    this.linkMicUserparams.videoSourceBitmap = paramBitmap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.linkmicinterface.LinkMicUserparams.LinkMicUserparamsBuilder
 * JD-Core Version:    0.7.0.1
 */