package com.tencent.mobileqq.ar.ARRecord.worldcup;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FFmpegVideoProcessor
{
  private int a(String paramString, String[] paramArrayOfString)
  {
    long l = System.currentTimeMillis();
    a(new File(a()));
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(a());
    ((ArrayList)localObject).addAll(Arrays.asList(paramArrayOfString));
    ((ArrayList)localObject).add(b());
    localObject = new ProcessBuilder((List)localObject).redirectErrorStream(true).start();
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(((Process)localObject).getInputStream()));
    while (localBufferedReader.readLine() != null) {}
    int i = ((Process)localObject).waitFor();
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record.ffmpeg", 2, String.format("execute finish, key: %s, ret: %s, cost:%s, cmd: %s", new Object[] { paramString, Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l), Arrays.toString(paramArrayOfString) }));
    }
    return i;
  }
  
  private String a()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (String str = "trim_process_pie";; str = "trim_process_pic") {
      return ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext()) + str;
    }
  }
  
  private boolean a(File paramFile)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFile == null) || (!paramFile.exists())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramFile.canExecute());
      bool1 = bool2;
    } while (paramFile.setExecutable(true));
    return false;
  }
  
  private String b()
  {
    String str = ShortVideoSoLoad.getShortVideoSoPath(BaseApplicationImpl.getContext()) + VideoEnvironment.a();
    boolean bool = new File(str).exists();
    QLog.d("Q.worldcup.record.ffmpeg", 2, "getShortVideoSoFullPath, file isExist: " + bool);
    if (VideoProcessor.b)
    {
      VideoProcessor.b = false;
      HashMap localHashMap = new HashMap();
      StatisticCollector.a(BaseApplicationImpl.getContext()).a("", "worldcup_shortvideo_so_exist", bool, 0L, 1L, localHashMap, "");
    }
    return str;
  }
  
  public int a(String paramString1, String paramString2)
  {
    return a("convertToTs_" + System.currentTimeMillis(), new String[] { "-i", paramString1, "-c", "copy", "-bsf:v", "h264_mp4toannexb", "-f", "mpegts", paramString2 });
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("-y");
      localArrayList.add("-framerate");
      localArrayList.add("1");
      localArrayList.add("-i");
      localArrayList.add(new File(paramString1).getCanonicalPath());
      localArrayList.add("-vcodec");
      localArrayList.add("libx264");
      localArrayList.add("-bufsize");
      localArrayList.add("800k");
      localArrayList.add("-movflags");
      localArrayList.add("faststart");
      localArrayList.add("-r");
      localArrayList.add("25");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      paramString1 = (String[])localArrayList.toArray(new String[0]);
      int i = a("picToVideo_" + System.currentTimeMillis(), paramString1);
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.worldcup.record.ffmpeg", 2, String.format("picToVideo| ret:%s, cmd:[%s]", new Object[] { Integer.valueOf(i), Arrays.toString(paramString1) }));
        }
        return bool;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.e("Q.worldcup.record.ffmpeg", 1, "picToVideo| exp: " + paramString1.getMessage());
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    long l = System.currentTimeMillis();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("-y");
      localArrayList.add("-i");
      localArrayList.add(new File(paramString1).getCanonicalPath());
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      localArrayList.add("-strict");
      localArrayList.add("-2");
      localArrayList.add("-vcodec");
      localArrayList.add("copy");
      localArrayList.add("-acodec");
      localArrayList.add("aac");
      localArrayList.add("-y");
      localArrayList.add("-t");
      localArrayList.add(String.valueOf(paramLong / 1000L + 1L));
      localArrayList.add(new File(paramString3).getCanonicalPath());
      i = a("addAudio_" + System.currentTimeMillis(), (String[])localArrayList.toArray(new String[0]));
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.worldcup.record.ffmpeg", 2, String.format("addAudio, ret = %s, cost: %s", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong - l) }));
      }
      if (i == 0) {
        return true;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int i = -1001;
        paramString1.printStackTrace();
        QLog.e("Q.worldcup.record.ffmpeg", 2, "addAudio, exp: " + paramString1.getMessage());
      }
    }
    return false;
  }
  
  public boolean a(ArrayList paramArrayList, String paramString)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("-y");
      StringBuilder localStringBuilder = new StringBuilder();
      i = 0;
      while (i < paramArrayList.size())
      {
        localArrayList.add("-i");
        localArrayList.add(new File((String)paramArrayList.get(i)).getCanonicalPath());
        localStringBuilder.append("[" + i + ":v]");
        localStringBuilder.append(" ");
        i += 1;
      }
      localStringBuilder.append("concat=n=" + paramArrayList.size() + ":v=1 [v]");
      localArrayList.add("-filter_complex");
      localArrayList.add(localStringBuilder.toString());
      localArrayList.add("-map");
      localArrayList.add("[v]");
      localArrayList.add(new File(paramString).getCanonicalPath());
      i = a("concat_videos_" + System.currentTimeMillis(), (String[])localArrayList.toArray(new String[0]));
    }
    catch (Exception paramArrayList)
    {
      for (;;)
      {
        long l2;
        paramArrayList.printStackTrace();
        int i = -1001;
        QLog.e("Q.worldcup.record.ffmpeg", 1, String.format("mergeDiffCodingVideos| exp: %s", new Object[] { paramArrayList.getMessage() }));
      }
    }
    l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record.ffmpeg", 2, String.format("mergeDiffCodingVideos| ret = %s, cost: %s", new Object[] { Integer.valueOf(i), Long.valueOf(l2 - l1) }));
    }
    return i == 0;
  }
  
  public boolean b(ArrayList paramArrayList, String paramString)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    String str1;
    while (paramArrayList.hasNext())
    {
      str1 = (String)paramArrayList.next();
      try
      {
        String str2 = str1.replace(".mp4", ".ts");
        if (!FileUtil.a(str2)) {
          break label110;
        }
        localArrayList.add(str2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.e("Q.worldcup.record.ffmpeg", 1, String.format("convertToTs path:%s, exp:%s", new Object[] { str1, localException.getMessage() }));
      }
      continue;
      label110:
      if (a(str1, localException) == 0) {
        localArrayList.add(localException);
      }
    }
    if (localArrayList.size() > 0)
    {
      paramArrayList = new StringBuilder("concat:");
      int i = 0;
      while (i < localArrayList.size())
      {
        paramArrayList.append((String)localArrayList.get(i));
        if (i != localArrayList.size() - 1) {
          paramArrayList.append("|");
        }
        i += 1;
      }
      paramArrayList = paramArrayList.toString();
      str1 = "mergeVideosWithTs" + System.currentTimeMillis();
      for (;;)
      {
        try
        {
          i = a(str1, new String[] { "-i", paramArrayList, "-c", "copy", "-bsf:a", "aac_adtstoasc", paramString });
          if (i != 0) {
            continue;
          }
          bool1 = true;
        }
        catch (Exception paramArrayList)
        {
          paramArrayList.printStackTrace();
          QLog.e("Q.worldcup.record.ffmpeg", 1, String.format("concat videos with ts exp: %s", new Object[] { paramArrayList.getMessage() }));
          boolean bool1 = false;
          continue;
        }
        paramArrayList = localArrayList.iterator();
        bool2 = bool1;
        if (!paramArrayList.hasNext()) {
          break label419;
        }
        paramString = (String)paramArrayList.next();
        if ((!paramString.contains("cover")) && (!paramString.contains("game")))
        {
          new File(paramString).delete();
          if (QLog.isColorLevel())
          {
            QLog.d("Q.worldcup.record.ffmpeg", 2, String.format("delete temp ts file: %s", new Object[] { paramString }));
            continue;
            bool1 = false;
          }
        }
      }
    }
    boolean bool2 = false;
    label419:
    if (QLog.isColorLevel()) {
      QLog.d("Q.worldcup.record.ffmpeg", 2, String.format("concatVideosWithTs| cost: %sms, isSuc: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool2) }));
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.worldcup.FFmpegVideoProcessor
 * JD-Core Version:    0.7.0.1
 */