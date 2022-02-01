package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSFetchDataModuleFactory
{
  public static IFetchDataModule a()
  {
    if (WeishiUtils.b(13)) {
      return new WSFetchPreloadDataModule();
    }
    if (WeishiUtils.g() != null) {
      return new WSFetchPushDataModule();
    }
    return new WSFetchLocalDataModule();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchDataModuleFactory
 * JD-Core Version:    0.7.0.1
 */