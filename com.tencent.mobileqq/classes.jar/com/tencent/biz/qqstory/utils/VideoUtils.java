package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.IOException;
import java.util.ArrayList;

public class VideoUtils
{
  @TargetApi(17)
  public static int a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    String str2;
    String str3;
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      String str1 = localMediaMetadataRetriever.extractMetadata(24);
      str2 = localMediaMetadataRetriever.extractMetadata(18);
      str3 = localMediaMetadataRetriever.extractMetadata(19);
      localMediaMetadataRetriever.release();
      paramString = str1;
      if (str1 == null) {
        paramString = "0";
      }
      if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)))
      {
        SLog.d("Q.qqstory.publish.VideoUtils", "cannot get metadata from video. rotation = " + paramString + " width = " + str2 + " height = " + str3);
        return -1;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      SLog.b("Q.qqstory.publish.VideoUtils", "media exception", paramString);
      return -1;
    }
    int i = Integer.valueOf(paramString).intValue();
    int j = Integer.valueOf(str2).intValue();
    int k = Integer.valueOf(str3).intValue();
    boolean bool2 = false;
    boolean bool1;
    if ((i == 90) || (i == 270))
    {
      bool1 = bool2;
      if (j < k) {
        bool1 = true;
      }
    }
    for (;;)
    {
      SLog.d("Q.qqstory.publish.VideoUtils", "getVideoToPortraitRotation. neeRotate = " + bool1 + " orgRotation = " + i + " return = " + (i + 90) % 360);
      if (!bool1) {
        break;
      }
      return (i + 90) % 360;
      if (i != 0)
      {
        bool1 = bool2;
        if (i != 180) {}
      }
      else
      {
        bool1 = bool2;
        if (j > k) {
          bool1 = true;
        }
      }
    }
    return -1;
  }
  
  @TargetApi(16)
  public static ArrayList a(String paramString, long paramLong)
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        i = 0;
        if (i >= localMediaExtractor.getTrackCount()) {
          break label348;
        }
        paramString = localMediaExtractor.getTrackFormat(i);
        if (!paramString.getString("mime").startsWith("video/")) {
          break label165;
        }
        if (paramString.containsKey("durationUs"))
        {
          l1 = paramString.getLong("durationUs") / 1000L;
          localMediaExtractor.selectTrack(i);
          SLog.b("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() find it video index = " + i);
          if (i >= 0) {
            break label172;
          }
          SLog.e("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() Can not find video track index.");
          localMediaExtractor.release();
          return null;
        }
      }
      catch (IOException localIOException)
      {
        SLog.c("Q.qqstory.publish.VideoUtils", "Open file error in getClosetKeyFramePosArray() file = " + paramString, localIOException);
        localMediaExtractor.release();
        return null;
      }
      SLog.e("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() Can not find duration.");
      localMediaExtractor.release();
      return null;
      label165:
      i += 1;
      continue;
      label172:
      long l2 = 0L;
      paramString = new ArrayList();
      localMediaExtractor.seekTo(l2 * 1000L, 2);
      l2 = localMediaExtractor.getSampleTime() / 1000L;
      if (l1 - l2 < paramLong)
      {
        paramString.add(new VideoUtils.VideoKeyFrameFragment(l2, l1 - l2));
        i = 0;
        label237:
        if (i >= paramString.size()) {
          break label341;
        }
        if (i != paramString.size() - 1) {
          break label302;
        }
      }
      label302:
      for (((VideoUtils.VideoKeyFrameFragment)paramString.get(i)).b = (l1 - l2);; ((VideoUtils.VideoKeyFrameFragment)paramString.get(i)).b = (((VideoUtils.VideoKeyFrameFragment)paramString.get(i + 1)).a - ((VideoUtils.VideoKeyFrameFragment)paramString.get(i)).a))
      {
        i += 1;
        break label237;
        paramString.add(new VideoUtils.VideoKeyFrameFragment(l2, paramLong));
        l2 += paramLong;
        break;
      }
      label341:
      localMediaExtractor.release();
      return paramString;
      label348:
      long l1 = 0L;
      int i = -1;
    }
  }
  
  public static void a(StoryVideoItem paramStoryVideoItem)
  {
    int i = paramStoryVideoItem.mVideoWidth;
    int j = paramStoryVideoItem.mVideoHeight;
    paramStoryVideoItem.mVideoWidth = Math.min(j, i);
    paramStoryVideoItem.mVideoHeight = Math.max(j, i);
  }
  
  public static boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramLocalMediaInfo.mediaWidth > paramLocalMediaInfo.mediaHeight)
    {
      if (paramLocalMediaInfo.rotation % 180 != 0) {}
    }
    else {
      while ((paramLocalMediaInfo.rotation == 90) || (paramLocalMediaInfo.rotation == 270)) {
        return true;
      }
    }
    return false;
  }
  
  @TargetApi(10)
  public static int[] a(String paramString)
  {
    localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      String str1 = localMediaMetadataRetriever.extractMetadata(24);
      String str2 = localMediaMetadataRetriever.extractMetadata(18);
      String str3 = localMediaMetadataRetriever.extractMetadata(19);
      int[] arrayOfInt = new int[3];
      paramString = str1;
      if (str1 == null) {
        paramString = "0";
      }
      arrayOfInt[0] = Integer.valueOf(paramString).intValue();
      arrayOfInt[1] = Integer.valueOf(str2).intValue();
      arrayOfInt[2] = Integer.valueOf(str3).intValue();
      try
      {
        localMediaMetadataRetriever.release();
        return arrayOfInt;
      }
      catch (RuntimeException paramString)
      {
        SLog.d("Q.qqstory.publish.VideoUtils", "retriever.release error" + paramString);
        return arrayOfInt;
      }
      try
      {
        localMediaMetadataRetriever.release();
        throw paramString;
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          SLog.d("Q.qqstory.publish.VideoUtils", "retriever.release error" + localRuntimeException);
        }
      }
    }
    catch (Exception paramString)
    {
      paramString = paramString;
      SLog.b("Q.qqstory.publish.VideoUtils", "exception", paramString);
      try
      {
        localMediaMetadataRetriever.release();
        return null;
      }
      catch (RuntimeException paramString)
      {
        SLog.d("Q.qqstory.publish.VideoUtils", "retriever.release error" + paramString);
        return null;
      }
    }
    finally {}
  }
  
  @TargetApi(17)
  public static int b(String paramString)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(24);
      localMediaMetadataRetriever.release();
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      SLog.b("Q.qqstory.publish.VideoUtils", "exception", paramString);
    }
    return -1;
  }
  
  public static int c(String paramString)
  {
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(20);
      localMediaMetadataRetriever.release();
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      SLog.b("Q.qqstory.publish.VideoUtils", "exception", paramString);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.VideoUtils
 * JD-Core Version:    0.7.0.1
 */