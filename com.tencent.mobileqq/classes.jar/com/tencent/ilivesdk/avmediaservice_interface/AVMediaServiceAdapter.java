package com.tencent.ilivesdk.avmediaservice_interface;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.downloader.DownLoaderInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.toast.ToastInterface;
import com.tencent.ilivesdk.beautyfilterservice_interface.BeautyFilterServiceInterface;

public abstract interface AVMediaServiceAdapter
{
  public abstract PushReceiver createPushReceiver();
  
  public abstract String getAVConfig();
  
  public abstract LoginServiceInterface getAccount();
  
  public abstract AppGeneralInfoService getAppInfo();
  
  public abstract BeautyFilterServiceInterface getBeautyFilterService();
  
  public abstract ChannelInterface getChannel();
  
  public abstract int getContentType();
  
  public abstract DataReportInterface getDataReporter();
  
  public abstract DownLoaderInterface getDownLoader();
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract NetworkStateInterface getNetWorkState();
  
  public abstract String getResolution();
  
  public abstract int getShield();
  
  public abstract ToastInterface getToast();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceAdapter
 * JD-Core Version:    0.7.0.1
 */