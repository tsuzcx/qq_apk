package com.tencent.biz.qqstory.playvideo.player;

import java.io.File;
import org.json.JSONObject;

public abstract interface IVideoView$OnDownloadListener
{
  public abstract void a(String paramString, File paramFile, int paramInt, JSONObject paramJSONObject);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, File paramFile);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.IVideoView.OnDownloadListener
 * JD-Core Version:    0.7.0.1
 */