package com.tencent.ilivesdk.giftservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import org.json.JSONObject;

public abstract interface GiftServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract long getAccountUin();
  
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract ChannelInterface getChannel();
  
  public abstract DataReportInterface getDataReport();
  
  public abstract DownLoaderInterface getDownLoader();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract LoginServiceInterface getLoginService();
  
  public abstract long getRoomId();
  
  public abstract ToastInterface getToastInterface();
  
  public abstract JSONObject updateGiftLogoFormatKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter
 * JD-Core Version:    0.7.0.1
 */