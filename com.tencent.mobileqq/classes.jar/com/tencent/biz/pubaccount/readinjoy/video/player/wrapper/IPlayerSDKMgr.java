package com.tencent.biz.pubaccount.readinjoy.video.player.wrapper;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKMgr;", "", "initSDK", "", "installPlugin", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerSDKEventListener;", "isInstalled", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayerSDKMgr
{
  public abstract void a();
  
  public abstract void a(@NotNull IPlayerSDKEventListener paramIPlayerSDKEventListener);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerSDKMgr
 * JD-Core Version:    0.7.0.1
 */