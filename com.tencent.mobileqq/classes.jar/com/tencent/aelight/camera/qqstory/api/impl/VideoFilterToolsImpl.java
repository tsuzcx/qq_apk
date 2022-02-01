package com.tencent.aelight.camera.qqstory.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;

public class VideoFilterToolsImpl
  implements IVideoFilterTools
{
  public String getCommonPrefix()
  {
    return VideoFilterTools.a;
  }
  
  public int getQQShortVideoFilterConfigVersion(Context paramContext)
  {
    return VideoFilterTools.d(paramContext);
  }
  
  public void handleQQShortVideoCommonConfig(String paramString)
  {
    VideoFilterTools.e(paramString);
  }
  
  public void updateQQShortVideoFilterConfig(Context paramContext, String paramString)
  {
    VideoFilterTools.a(paramContext, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.VideoFilterToolsImpl
 * JD-Core Version:    0.7.0.1
 */