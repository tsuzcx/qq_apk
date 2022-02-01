package com.tencent.biz.pubaccount.api;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import mqq.app.AppService;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IPublicAccountH5Manager
  extends QRouteApi
{
  public static final String C2B_FIRE_PTT_DIR = "c2bPTT/";
  
  public abstract void cancleAllTask();
  
  public abstract void downloadPtt(Bundle paramBundle);
  
  public abstract void init(AppService paramAppService, AppInterface paramAppInterface);
  
  public abstract void startDownloadPic(Bundle paramBundle);
  
  public abstract void startUploadPic(Bundle paramBundle);
  
  public abstract void uploadPtt(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountH5Manager
 * JD-Core Version:    0.7.0.1
 */