package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.qqstory.api.GetMusicInfoCallback;
import com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

public class AELaunchMusicConfigManagerImpl
  implements IAELaunchMusicConfigManager
{
  public MusicItemInfo getMusicItemById(int paramInt1, int paramInt2)
  {
    return ((QIMMusicConfigManager)QIMManager.a(2)).a(paramInt1, paramInt2);
  }
  
  public void getSingleFullMusicInfo(String paramString, boolean paramBoolean, GetMusicInfoCallback paramGetMusicInfoCallback)
  {
    ((QIMMusicConfigManager)QIMManager.a(2)).a(paramString, paramBoolean, paramGetMusicInfoCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.AELaunchMusicConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */