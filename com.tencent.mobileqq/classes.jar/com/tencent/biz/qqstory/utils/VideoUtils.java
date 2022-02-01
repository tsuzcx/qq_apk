package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Pair;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.IOException;
import java.util.ArrayList;

public class VideoUtils
{
  public static int a(int paramInt)
  {
    int j = paramInt % 16;
    int i = paramInt;
    if (j != 0)
    {
      if (j < 8) {
        return paramInt - j;
      }
      i = paramInt + (16 - j);
    }
    return i;
  }
  
  @TargetApi(17)
  public static int a(String paramString)
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
  
  @TargetApi(16)
  public static ArrayList<VideoUtils.VideoKeyFrameFragment> a(String paramString, long paramLong)
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    try
    {
      localMediaExtractor.setDataSource(paramString);
      int k = -1;
      int j = 0;
      int i = 0;
      long l2;
      for (;;)
      {
        int m = localMediaExtractor.getTrackCount();
        l2 = 0L;
        if (i >= m) {
          break;
        }
        paramString = localMediaExtractor.getTrackFormat(i);
        if (paramString.getString("mime").startsWith("video/"))
        {
          if (paramString.containsKey("durationUs"))
          {
            l1 = paramString.getLong("durationUs") / 1000L;
            localMediaExtractor.selectTrack(i);
            paramString = new StringBuilder();
            paramString.append("getClosetKeyFramePosArray() find it video index = ");
            paramString.append(i);
            SLog.b("Q.qqstory.publish.VideoUtils", paramString.toString());
            break label147;
          }
          SLog.e("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() Can not find duration.");
          localMediaExtractor.release();
          return null;
        }
        i += 1;
      }
      long l1 = 0L;
      i = k;
      label147:
      if (i < 0)
      {
        SLog.e("Q.qqstory.publish.VideoUtils", "getClosetKeyFramePosArray() Can not find video track index.");
        localMediaExtractor.release();
        return null;
      }
      paramString = new ArrayList();
      for (;;)
      {
        localMediaExtractor.seekTo(l2 * 1000L, 2);
        l2 = localMediaExtractor.getSampleTime() / 1000L;
        long l3 = l1 - l2;
        if (l3 < paramLong)
        {
          paramString.add(new VideoUtils.VideoKeyFrameFragment(l2, l3));
          i = j;
          while (i < paramString.size())
          {
            if (i == paramString.size() - 1) {
              ((VideoUtils.VideoKeyFrameFragment)paramString.get(i)).b = l3;
            } else {
              ((VideoUtils.VideoKeyFrameFragment)paramString.get(i)).b = (((VideoUtils.VideoKeyFrameFragment)paramString.get(i + 1)).a - ((VideoUtils.VideoKeyFrameFragment)paramString.get(i)).a);
            }
            i += 1;
          }
          localMediaExtractor.release();
          return paramString;
        }
        paramString.add(new VideoUtils.VideoKeyFrameFragment(l2, paramLong));
        l2 += paramLong;
      }
      StringBuilder localStringBuilder;
      return null;
    }
    catch (IOException localIOException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Open file error in getClosetKeyFramePosArray() file = ");
      localStringBuilder.append(paramString);
      SLog.c("Q.qqstory.publish.VideoUtils", localStringBuilder.toString(), localIOException);
      localMediaExtractor.release();
    }
  }
  
  public static boolean a()
  {
    return (Build.MODEL.equals("MI 4LTE")) || (Build.MODEL.equals("GT-I9502")) || (Build.MODEL.equals("NX513J")) || (Build.MODEL.equals("MI 4W")) || (Build.MODEL.toUpperCase().contains("M612")) || (Build.MODEL.toUpperCase().contains("M5S"));
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = paramInt3;
    float f1 = paramInt1;
    float f3 = f2 / f1;
    float f4 = paramInt4;
    f2 = paramInt2;
    f3 = Math.min(f3, f4 / f2);
    paramInt1 = (int)(f1 * f3);
    paramInt2 = (int)(f2 * f3);
    return (paramInt1 < paramInt3) || (paramInt2 < paramInt4);
  }
  
  public static boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = paramLocalMediaInfo.mediaWidth;
    int j = paramLocalMediaInfo.mediaHeight;
    boolean bool = true;
    if (i >= j)
    {
      if (paramLocalMediaInfo.rotation % 180 == 0) {
        return true;
      }
    }
    else
    {
      if (paramLocalMediaInfo.rotation == 90) {
        return bool;
      }
      if (paramLocalMediaInfo.rotation == 270) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public static int b(String paramString)
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
  
  public static Pair<Integer, Integer> b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = (int)(paramInt1 * paramInt4 / paramInt3);
    return new Pair(Integer.valueOf(a(paramInt1)), Integer.valueOf(a(paramInt2)));
  }
  
  public static boolean b()
  {
    return (!Build.MODEL.equals("MI 9 SE")) && (!Build.MODEL.equals("MI 9")) && (!Build.MODEL.equals("MI 8 UD")) && (!Build.MODEL.equals("MI 8")) && (!Build.MODEL.equals("NEX")) && (!Build.MODEL.equals("NEXS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.VideoUtils
 * JD-Core Version:    0.7.0.1
 */