package com.tencent.biz.pubaccount.imagecollection.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountImageCollectionUtils
  extends QRouteApi
{
  public abstract boolean openPublicAccountImageCollectionMainActivity(Activity paramActivity, Intent paramIntent, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils
 * JD-Core Version:    0.7.0.1
 */