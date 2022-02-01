package com.tencent.mobileqq.apollo.api.player;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
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
  
  public abstract void setAction(CMSAction paramCMSAction);
  
  public abstract void setGetGifFrameCallback(IGetGifFrameCallback paramIGetGifFrameCallback);
  
  public abstract void setLoadingView(Drawable paramDrawable);
  
  public abstract void setMessageForApollo(MessageForApollo paramMessageForApollo, int paramInt);
  
  public abstract void setParams(ApolloPlayerParams paramApolloPlayerParams);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.IApolloBrickPlayer
 * JD-Core Version:    0.7.0.1
 */