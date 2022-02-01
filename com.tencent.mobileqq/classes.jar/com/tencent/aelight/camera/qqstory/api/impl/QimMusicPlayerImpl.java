package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.qqstory.api.IQimMusicPlayer;
import com.tencent.aelight.camera.struct.editor.MusicDownloadListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

public class QimMusicPlayerImpl
  implements IQimMusicPlayer
{
  public boolean checkMusicCanPlay(MusicItemInfo paramMusicItemInfo)
  {
    return ((QimMusicPlayer)QIMManager.a().d(8)).b(paramMusicItemInfo);
  }
  
  public void clearMusic()
  {
    ((QimMusicPlayer)QIMManager.a().d(8)).e();
  }
  
  public boolean requestDownLoadMusicInfo(MusicItemInfo paramMusicItemInfo, MusicDownloadListener paramMusicDownloadListener)
  {
    return ((QimMusicPlayer)QIMManager.a().d(8)).a(paramMusicItemInfo, paramMusicDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.QimMusicPlayerImpl
 * JD-Core Version:    0.7.0.1
 */