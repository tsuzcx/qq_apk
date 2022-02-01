package com.tencent.aelight.camera.qqstory.api;

import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

@QAPI(process={"all"})
public abstract interface IQimMusicPlayer
  extends QRouteApi
{
  public abstract boolean checkMusicCanPlay(MusicItemInfo paramMusicItemInfo);
  
  public abstract void clearMusic();
  
  public abstract boolean requestDownLoadMusicInfo(MusicItemInfo paramMusicItemInfo, MusicDownloadListener paramMusicDownloadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer
 * JD-Core Version:    0.7.0.1
 */