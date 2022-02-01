package com.tencent.biz.pubaccount.readinjoy.video.player.wrapper;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerFactory;", "", "createMediaPlayer", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "createPlayerVideoView", "context", "Landroid/content/Context;", "isUseTextureView", "", "createPreloader", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayerPreloader;", "obtainMediaPlayer", "token", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IPlayerFactory
{
  @NotNull
  public abstract IPlayer a(@Nullable IVideoView paramIVideoView);
  
  @Nullable
  public abstract IPlayer a(@NotNull String paramString);
  
  @NotNull
  public abstract IPlayerPreloader a();
  
  @NotNull
  public abstract IVideoView a(@NotNull Context paramContext, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayerFactory
 * JD-Core Version:    0.7.0.1
 */