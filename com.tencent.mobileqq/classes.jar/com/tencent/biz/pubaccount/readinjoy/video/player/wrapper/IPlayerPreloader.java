package com.tencent.biz.pubaccount.readinjoy.video.player.wrapper;

import com.tencent.superplayer.api.SuperPlayerDownOption;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "", "destory", "", "isVideoCached", "", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/PlayerVideoInfo;", "setPreDownloadListener", "listener", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader$Listener;", "startPreDownload", "videoDurationMs", "", "superPlayerDownOption", "Lcom/tencent/superplayer/api/SuperPlayerDownOption;", "preloadDurationMs", "stopPreDownload", "Companion", "Listener", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayerPreloader
{
  public static final IPlayerPreloader.Companion a = IPlayerPreloader.Companion.a;
  
  public abstract int a(@NotNull PlayerVideoInfo paramPlayerVideoInfo);
  
  public abstract void a();
  
  public abstract void a(@Nullable IPlayerPreloader.Listener paramListener);
  
  public abstract void a(@NotNull PlayerVideoInfo paramPlayerVideoInfo, long paramLong, @NotNull SuperPlayerDownOption paramSuperPlayerDownOption);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerPreloader
 * JD-Core Version:    0.7.0.1
 */