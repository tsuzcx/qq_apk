package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;

@QAPI(process={"all"})
public abstract interface IAELaunchMusicConfigManager
  extends QRouteApi
{
  public static final String JSON_KEY_H5_MUSIC_FROM = "is_from_story";
  
  public abstract MusicItemInfo getMusicItemById(int paramInt1, int paramInt2);
  
  public abstract void getSingleFullMusicInfo(String paramString, boolean paramBoolean, GetMusicInfoCallback paramGetMusicInfoCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IAELaunchMusicConfigManager
 * JD-Core Version:    0.7.0.1
 */