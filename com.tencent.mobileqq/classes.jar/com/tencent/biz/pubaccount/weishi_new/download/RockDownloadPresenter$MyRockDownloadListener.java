package com.tencent.biz.pubaccount.weishi_new.download;

import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import mqq.util.WeakReference;

abstract class RockDownloadPresenter$MyRockDownloadListener
  extends RockDownloadListener
{
  WeakReference<RockDownloadPresenter> mRockDownloadPresenter;
  
  RockDownloadPresenter$MyRockDownloadListener(RockDownloadPresenter paramRockDownloadPresenter)
  {
    this.mRockDownloadPresenter = new WeakReference(paramRockDownloadPresenter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.RockDownloadPresenter.MyRockDownloadListener
 * JD-Core Version:    0.7.0.1
 */