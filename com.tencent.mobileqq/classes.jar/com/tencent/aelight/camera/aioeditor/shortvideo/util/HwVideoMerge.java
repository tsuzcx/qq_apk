package com.tencent.aelight.camera.aioeditor.shortvideo.util;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TargetApi(18)
public class HwVideoMerge
{
  private String a;
  private String b;
  private MediaExtractor c;
  private MediaExtractor d;
  private int e;
  private int f;
  private MediaMuxer g;
  private HwVideoMerge.SampaleData h = new HwVideoMerge.SampaleData(null);
  
  public HwVideoMerge(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private int a()
  {
    this.h.a.position(0);
    if (this.c.readSampleData(this.h.a, 0) <= 0)
    {
      b();
      return -5;
    }
    this.h.a.position(0);
    if (this.d.readSampleData(this.h.a, 0) <= 0)
    {
      b();
      return -6;
    }
    return 0;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", paramString2 })));
  }
  
  public static final int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return b(paramString1, paramString2, paramString3, paramInt);
  }
  
  private static int a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject1 = FileFFmpegUtils.a(VideoEnvironment.getContext());
      Object localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists())
      {
        boolean bool = ((File)localObject2).setExecutable(true, true);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[@] ffmpegProcess [setExecutable] code=");
        ((StringBuilder)localObject2).append(bool);
        b(((StringBuilder)localObject2).toString(), null);
        paramList.add(0, localObject1);
        paramList.add(1, "-d");
        paramList.add(2, "-y");
        paramList.add(3, "-loglevel");
        paramList.add(4, "quiet");
        paramList.add(FileFFmpegUtils.b(VideoEnvironment.getContext()));
        localObject1 = new HwVideoMerge.LogStream(null);
        localObject2 = new ProcessBuilder(new String[0]);
        ((ProcessBuilder)localObject2).redirectErrorStream(true);
        ((ProcessBuilder)localObject2).command(paramList);
        try
        {
          paramList = ((ProcessBuilder)localObject2).start();
          ((HwVideoMerge.LogStream)localObject1).a = paramList;
          ((HwVideoMerge.LogStream)localObject1).a();
          try
          {
            paramList.waitFor();
          }
          catch (InterruptedException localInterruptedException)
          {
            b("[@] IOException log:", localInterruptedException);
          }
          int i = paramList.exitValue();
          if (i != 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[@] process.exitValue:errcode=");
            localStringBuilder.append(i);
            b(localStringBuilder.toString(), null);
          }
          ((HwVideoMerge.LogStream)localObject1).b();
          if (paramList != null) {
            paramList.destroy();
          }
          return i;
        }
        catch (IOException paramList)
        {
          b("[@] IOException log:", paramList);
          return -11;
        }
      }
      return -12;
    }
    return -9;
  }
  
  private boolean a(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static boolean a(List<String> paramList, String paramString, int paramInt)
  {
    Object localObject1 = "concat:";
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject3 = (String)paramList.get(i);
      Object localObject2 = localObject1;
      if (i > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("|");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = ((String)localObject3).replace(".mp4", ".ts");
      int j = b((String)localObject3, (String)localObject1);
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("ffmpegMp4toTs fail, err: ");
          paramList.append(j);
          QLog.e("HwVideoMerge", 2, paramList.toString());
        }
        return false;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      i += 1;
    }
    paramList = paramString.replace(".mp4", ".ts");
    i = a((String)localObject1, paramList);
    if (i != 0)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("ffmpegMergeTs fail, err: ");
        paramList.append(i);
        QLog.e("HwVideoMerge", 2, paramList.toString());
      }
      return false;
    }
    if (paramInt == 90)
    {
      i = 270;
    }
    else
    {
      i = paramInt;
      if (paramInt == 270) {
        i = 90;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("rotate=");
    ((StringBuilder)localObject1).append(i);
    paramInt = a(new ArrayList(Arrays.asList(new String[] { "-i", paramList, "-metadata:s", ((StringBuilder)localObject1).toString(), "-vcodec", "copy", "-acodec", "copy", "-absf", "aac_adtstoasc", paramString })));
    if (paramInt != 0)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("ffmpegTstoMp4 fail, err: ");
        paramList.append(paramInt);
        QLog.e("HwVideoMerge", 2, paramList.toString());
      }
      return false;
    }
    return true;
  }
  
  private static int b(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        QLog.e("HwVideoMerge", 2, localException, new Object[0]);
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (IllegalArgumentException|NumberFormatException paramString) {}
    return paramInt;
  }
  
  private static int b(String paramString1, String paramString2)
  {
    return a(new ArrayList(Arrays.asList(new String[] { "-i", paramString1, "-c", "copy", "-bsf:v", "h264_mp4toannexb", "-f", "mpegts", paramString2 })));
  }
  
  public static final int b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new HwVideoMerge(paramString1, paramString2).a(null, paramInt);
    int i;
    if ((j != -2) && (j != -4) && (j != -6))
    {
      i = j;
      if (j == -9) {
        return c(paramString1, paramString2, paramString3, paramInt);
      }
    }
    else
    {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        return 0;
      }
      i = -10;
    }
    return i;
  }
  
  private final MediaExtractor b(String paramString)
  {
    if (a(paramString))
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int i = localMediaExtractor.getTrackCount();
        if (i != 1)
        {
          localMediaExtractor.release();
          try
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("createExtractor:invalid media file:numTracks=");
            localStringBuilder1.append(i);
            localStringBuilder1.append(" path=");
            localStringBuilder1.append(paramString);
            b(localStringBuilder1.toString(), null);
            return null;
          }
          catch (IOException localIOException1)
          {
            localMediaExtractor = null;
          }
        }
        else
        {
          return localMediaExtractor;
        }
      }
      catch (IOException localIOException2)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("createExtractor path:");
        localStringBuilder2.append(paramString);
        b(localStringBuilder2.toString(), localIOException2);
        localMediaExtractor.release();
      }
    }
    return null;
  }
  
  private void b()
  {
    MediaExtractor localMediaExtractor = this.c;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.c = null;
    }
    localMediaExtractor = this.d;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.d = null;
    }
  }
  
  private static void b(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null)
      {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
        return;
      }
      QLog.d("HwVideoMerge", 2, paramString);
    }
  }
  
  private static int c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    String str = FileFFmpegUtils.a(VideoEnvironment.getContext());
    Object localObject = new File(str);
    if (((File)localObject).exists())
    {
      boolean bool = ((File)localObject).setExecutable(true, true);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[@] ffmpegProcess [setExecutable] code=");
      ((StringBuilder)localObject).append(bool);
      b(((StringBuilder)localObject).toString(), null);
      b(paramString1, paramInt);
      localObject = new ArrayList();
      ((List)localObject).add(str);
      ((List)localObject).add("-d");
      ((List)localObject).add("-y");
      ((List)localObject).add("-loglevel");
      ((List)localObject).add("quiet");
      ((List)localObject).add("-i");
      ((List)localObject).add(paramString1);
      ((List)localObject).add("-i");
      ((List)localObject).add(paramString2);
      ((List)localObject).add("-vcodec");
      ((List)localObject).add("copy");
      ((List)localObject).add("-acodec");
      ((List)localObject).add("copy");
      ((List)localObject).add(paramString3);
      ((List)localObject).add(FileFFmpegUtils.b(VideoEnvironment.getContext()));
      paramString1 = new HwVideoMerge.LogStream(null);
      paramString2 = new ProcessBuilder(new String[0]);
      paramString2.redirectErrorStream(true);
      paramString2.command((List)localObject);
      try
      {
        paramString2 = paramString2.start();
        paramString1.a = paramString2;
        paramString1.a();
        try
        {
          paramString2.waitFor();
        }
        catch (InterruptedException localInterruptedException)
        {
          b("[@] IOException log:", localInterruptedException);
        }
        paramInt = paramString2.exitValue();
        if (paramInt != 0)
        {
          paramString3 = new File(paramString3);
          if (paramString3.exists()) {
            paramString3.delete();
          }
          paramString3 = new StringBuilder();
          paramString3.append("[@] process.exitValue:errcode=");
          paramString3.append(paramInt);
          b(paramString3.toString(), null);
        }
        paramString1.b();
        if (paramString2 != null) {
          paramString2.destroy();
        }
        return paramInt;
      }
      catch (IOException paramString1)
      {
        b("[@] IOException log:", paramString1);
        return -11;
      }
    }
    return -12;
  }
  
  public int a(String paramString, int paramInt)
  {
    this.c = b(this.a);
    if (this.c == null) {
      return -1;
    }
    this.d = b(this.b);
    if (this.d == null)
    {
      b();
      return -2;
    }
    MediaFormat localMediaFormat = this.c.getTrackFormat(0);
    Object localObject = localMediaFormat.getString("mime");
    this.e = localMediaFormat.getInteger("width");
    this.f = localMediaFormat.getInteger("height");
    int i;
    if (((String)localObject).startsWith("video/"))
    {
      this.c.selectTrack(0);
      localObject = this.d.getTrackFormat(0);
      if (((MediaFormat)localObject).getString("mime").startsWith("audio/"))
      {
        this.d.selectTrack(0);
        this.h.a(this.e, this.f);
        i = a();
        if (i != 0) {
          return i;
        }
        if (!a(paramString))
        {
          b();
          return -9;
        }
      }
    }
    try
    {
      if (new File(paramString).exists())
      {
        b();
        return -8;
      }
      this.g = new MediaMuxer(paramString, 0);
      paramInt = b(this.a, paramInt);
      this.g.setOrientationHint(paramInt);
      this.h.c = this.g.addTrack(localMediaFormat);
      this.h.d = this.g.addTrack((MediaFormat)localObject);
      return i;
    }
    catch (IOException paramString)
    {
      label271:
      break label271;
    }
    this.g = null;
    b();
    return -7;
    b();
    return -4;
    b();
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.HwVideoMerge
 * JD-Core Version:    0.7.0.1
 */