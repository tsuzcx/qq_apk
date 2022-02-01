package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.shortvideo.util.HwVideoMerge;
import com.tencent.aelight.camera.qqstory.api.IHwVideoMerge;
import java.util.List;

public class HwVideoMergeImpl
  implements IHwVideoMerge
{
  public boolean ffmpegMergeMultiVideo(List<String> paramList, String paramString, int paramInt)
  {
    return HwVideoMerge.a(paramList, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.impl.HwVideoMergeImpl
 * JD-Core Version:    0.7.0.1
 */