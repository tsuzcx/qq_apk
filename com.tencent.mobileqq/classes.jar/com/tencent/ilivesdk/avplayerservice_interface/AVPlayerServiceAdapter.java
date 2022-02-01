package com.tencent.ilivesdk.avplayerservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;

public abstract interface AVPlayerServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract AVMediaServiceInterface getAVMediaService();
  
  public abstract LoginServiceInterface getAccount();
  
  public abstract long getAnchorUin();
  
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract MediaPlayerInterface getMediaPlayerInterface();
  
  public abstract NetworkStateInterface getNetWorkState();
  
  public abstract String getNickName();
  
  public abstract long getRoomId();
  
  public abstract int getRoomType();
  
  public abstract ToastInterface getToast();
  
  public abstract boolean isHoldPlayerLog();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter
 * JD-Core Version:    0.7.0.1
 */