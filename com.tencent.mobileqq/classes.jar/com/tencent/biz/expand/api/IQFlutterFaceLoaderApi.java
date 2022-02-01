package com.tencent.biz.expand.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQFlutterFaceLoaderApi
  extends QRouteApi
{
  public abstract void addFaceObserver(IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver);
  
  public abstract void clearCache();
  
  public abstract Pair<Bitmap, Boolean> getBitmap(ApiDecodeRequest paramApiDecodeRequest);
  
  public abstract void onDestroy();
  
  public abstract void removeFaceObserver(IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver);
  
  public abstract void setContext(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.IQFlutterFaceLoaderApi
 * JD-Core Version:    0.7.0.1
 */