package com.tencent.aelight.camera.aioeditor.takevideo.localmedia.baoutils.media;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;

public class VideoUtils
{
  @TargetApi(16)
  public static int a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    while (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if (str.startsWith("video/"))
      {
        paramMediaExtractor = new StringBuilder();
        paramMediaExtractor.append("Extractor selected track ");
        paramMediaExtractor.append(i);
        paramMediaExtractor.append(" (");
        paramMediaExtractor.append(str);
        paramMediaExtractor.append("): ");
        paramMediaExtractor.append(localMediaFormat);
        Log.d("VideoUtils", paramMediaExtractor.toString());
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.localmedia.baoutils.media.VideoUtils
 * JD-Core Version:    0.7.0.1
 */