package com.tencent.mobileqq.apollo.meme.api;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.apollo.meme.ApolloPlayerParams;
import com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloBrickPlayer
  extends QRouteApi
{
  public abstract void destroy();
  
  public abstract View getView();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void setAction(MemeAction paramMemeAction);
  
  public abstract void setGetGifFrameCallback(IGetGifFrameCallback paramIGetGifFrameCallback);
  
  public abstract void setLoadingView(Drawable paramDrawable);
  
  public abstract void setMessageForApollo(Object paramObject, int paramInt);
  
  public abstract void setParams(ApolloPlayerParams paramApolloPlayerParams);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.IApolloBrickPlayer
 * JD-Core Version:    0.7.0.1
 */