package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.takevideo.ShortVideoForwardManager;
import com.tencent.aelight.camera.qqstory.api.IShortVideoManager;

public class ShortVideoManagerImpl
  implements IShortVideoManager
{
  public String parseLinkFromRedTouchBuffer(String paramString1, String paramString2)
  {
    return ShortVideoForwardManager.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.ShortVideoManagerImpl
 * JD-Core Version:    0.7.0.1
 */