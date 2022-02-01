package com.tencent.biz.qqstory.utils.ffmpeg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vkm;
import xvv;
import ypi;
import yqs;

public class FFmpeg
{
  public static final String LOG_TAG = "Q.qqstory.ffmpeg.FFmpeg";
  public static final String MESSAGE_COPY_CMD_FAIL = "copy_fail";
  public static final String MESSAGE_COPY_CMD_SUCCESS = "copy_success";
  public static final String MESSAGE_INPUT_NULL = "input path is null";
  public static final String MESSAGE_TS_DONE = "TS file exists";
  protected static final long MINIMUM_TIMEOUT = 10000L;
  protected static final int RESULT_FIAL = 0;
  protected static final int RESULT_NOT_DONE = -9999;
  protected static final int RESULT_SUCCESS = 1;
  public static final String TAG = "Q.qqstory.ffmpeg.FFmpegCmd";
  protected static volatile FFmpeg instance;
  public final Context context;
  public FFmpegExecuteAsyncTask ffmpegExecuteAsyncTask;
  public ArrayList<FFmpegCommandUnit> mCmdQueue = new ArrayList();
  public FFmpegCommandUnit mCurrentCommandUnit;
  public String mCurrentTaskUni;
  public boolean mIsFFmpegingCloseScreen;
  protected boolean mIsWorkThreadCallback;
  public int mLastTaskResult = -9999;
  public BroadcastReceiver mScreenActionReceiver = new FFmpeg.7(this);
  protected long timeout = 9223372036854775807L;
  public ArrayList<String> tsFileList = new ArrayList();
  
  private FFmpeg(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.context.registerReceiver(this.mScreenActionReceiver, paramContext);
    Util.setFileExecutable(new File(FileUtils.getFFmpeg(this.context)));
  }
  
  private void detectMediaInfoVolume(String paramString, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString);
    localArrayList.add("-filter_complex");
    localArrayList.add("volumedetect");
    localArrayList.add("-c:v");
    localArrayList.add("copy");
    localArrayList.add("-f");
    localArrayList.add("null");
    localArrayList.add("/dev/null");
    execute((String[])localArrayList.toArray(new String[0]), paramExecuteBinResponseCallback);
  }
  
  private void getAudioFromMP4(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vn");
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static FFmpeg getInstance(Context paramContext)
  {
    return getInstance(paramContext, false);
  }
  
  public static FFmpeg getInstance(Context paramContext, boolean paramBoolean)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new FFmpeg(paramContext);
      }
      instance.mIsWorkThreadCallback = paramBoolean;
      return instance;
    }
    finally {}
  }
  
  private void getVideoFromMP4(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-an");
    localArrayList.add("-vcodec");
    localArrayList.add("copy");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  private void mixAudio(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    localArrayList.add("[0:a]volume=" + paramFloat1 + "[a0];[1:a]volume=" + paramFloat2 + "[a1];[a0][a1]amix=inputs=2:duration=first:dropout_transition=3");
    localArrayList.add("-strict");
    localArrayList.add("-2");
    localArrayList.add("-vn");
    localArrayList.add(paramString3);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static FFmpeg newInstance(Context paramContext, boolean paramBoolean)
  {
    paramContext = new FFmpeg(paramContext);
    paramContext.mIsWorkThreadCallback = paramBoolean;
    return paramContext;
  }
  
  private String parseCmdStringByMillSecond(int paramInt)
  {
    return String.format("%02d:%02d:%02d.%03d", new Object[] { Integer.valueOf((int)Math.floor(paramInt / 3600000)), Integer.valueOf((int)Math.floor(paramInt % 3600000) / 60000), Integer.valueOf((int)Math.floor(paramInt % 60000 / 1000)), Integer.valueOf((int)Math.floor(paramInt % 1000)) });
  }
  
  public void changeOrientationInVideo(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-metadata:s:v");
    localArrayList.add("rotate=" + paramString2);
    localArrayList.add("-codec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void changeOrientationInVideoByTranspose(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    int i = Integer.valueOf(paramString2).intValue();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    switch (i % 360)
    {
    default: 
      xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "unSupport orientation:%s", new Object[] { paramString2 });
      return;
    case 0: 
      xvv.b("Q.qqstory.ffmpeg.FFmpegCmd", "no need rotate.");
      return;
    case 90: 
      localArrayList.add("transpose=1");
    }
    for (;;)
    {
      localArrayList.add("-c:a");
      localArrayList.add("copy");
      localArrayList.add(new File(paramString3).getCanonicalPath());
      execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return;
      localArrayList.add("transpose=1,transpose=1");
      continue;
      localArrayList.add("transpose=1,transpose=1,transpose=1");
    }
  }
  
  public boolean checkSameTask(String paramString)
  {
    return (this.mCurrentTaskUni != null) && (paramString != null) && (paramString.equals(this.mCurrentTaskUni));
  }
  
  public void clipAudio(String paramString1, String paramString2, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio arguments: \n inAudio" + paramString1 + "\n outAudio:" + paramString2 + "\n start:" + paramInt1 + "\n duration:" + paramInt2);
    if (!ypi.c(paramString1))
    {
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramFFmpegExecuteResponseCallback.onFailure(String.valueOf(941001));
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return;
    }
    String str1 = parseCmdStringByMillSecond(paramInt1);
    String str2 = parseCmdStringByMillSecond(paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-ss");
    localArrayList.add(str1);
    localArrayList.add("-t");
    localArrayList.add(str2);
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add("-vn");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void cmdFFmpegQueue(ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    this.mCmdQueue = paramArrayList;
    if (this.mCmdQueue.size() <= 0) {
      return;
    }
    paramArrayList = (FFmpegCommandUnit)this.mCmdQueue.remove(0);
    ArrayList localArrayList = paramArrayList.arguments;
    String[] arrayOfString = paramArrayList.cmd;
    FFmpeg.6 local6 = new FFmpeg.6(this, paramArrayList.callback, arrayOfString, this.mCmdQueue);
    if (arrayOfString != null)
    {
      execute(arrayOfString, local6);
      return;
    }
    switch (paramArrayList.cmdType)
    {
    default: 
      return;
    case 1: 
      watermark((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Integer)localArrayList.get(3)).intValue(), ((Integer)localArrayList.get(4)).intValue(), local6);
      return;
    case 3: 
      clipAudio((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), local6);
      return;
    case 4: 
      combineAudioAndVideo((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), (String)localArrayList.get(3), ((Boolean)localArrayList.get(4)).booleanValue(), ((Integer)localArrayList.get(5)).intValue(), local6);
      return;
    case 2: 
      concatMedia((List)localArrayList.get(0), (String)localArrayList.get(1), local6, ((Boolean)localArrayList.get(2)).booleanValue());
      return;
    case 7: 
      concatMediaByTs((List)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 8: 
      concatDifferentCodingMedia((List)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 5: 
      mp4Tots((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 6: 
      concatTsOutput((List)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 9: 
      convertPicToVideo((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 10: 
      hflip((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 11: 
      compressVideo((String)localArrayList.get(0), ((Integer)localArrayList.get(1)).intValue(), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), ((Boolean)localArrayList.get(4)).booleanValue(), (String)localArrayList.get(5), local6);
      return;
    case 12: 
      changeOrientationInVideoByTranspose((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), local6);
      return;
    case 13: 
      setTimestamp((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), local6);
      return;
    case 14: 
      emptyFFmengCmd((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 15: 
      combineDoodle((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), local6);
      return;
    case 16: 
      convertMp4ToMp3((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 17: 
      mixAudio((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Float)localArrayList.get(3)).floatValue(), ((Float)localArrayList.get(4)).floatValue(), local6);
      return;
    case 21: 
      transcodeM4a((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 18: 
      getAudioFromMP4((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 19: 
      getVideoFromMP4((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 20: 
      convertPicToVideoWithTime((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), local6);
      return;
    }
    detectMediaInfoVolume((String)localArrayList.get(0), local6);
  }
  
  public Clip combineAudioAndVideo(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    paramString4 = new Clip(paramString4);
    paramString4.videoCodec = paramString3;
    return combineAudioAndVideo(paramString1, paramString2, paramBoolean, paramString4, paramInt, paramFFmpegExecuteResponseCallback);
  }
  
  public Clip combineAudioAndVideo(String paramString1, String paramString2, boolean paramBoolean, Clip paramClip, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "combineAudioAndVideo arguments: \n inVideo" + paramString1 + "\n inAudio:" + paramString2 + "\n outMedia:" + paramClip);
    if (!ypi.c(paramString1))
    {
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inVideo file is not exist");
      paramFFmpegExecuteResponseCallback.onFailure(String.valueOf(941002));
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return paramClip;
    }
    if (!ypi.c(paramString2))
    {
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramFFmpegExecuteResponseCallback.onFailure(String.valueOf(941002));
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return paramClip;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    String str;
    long l1;
    if (paramBoolean)
    {
      paramString1 = new MediaMetadataRetriever();
      paramString1.setDataSource(paramString2);
      str = paramString1.extractMetadata(9);
      paramString1.release();
      l1 = paramInt;
    }
    label828:
    label839:
    try
    {
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label211:
      int i;
      StringBuilder localStringBuilder;
      label459:
      break label211;
    }
    i = (int)Math.ceil(paramInt / (float)l1);
    if (i > 1)
    {
      paramString1 = new File(paramString2).getCanonicalPath();
      str = new File(paramString2).getParent() + "/catAudioFile.txt";
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < i)
      {
        if (paramInt > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("file '").append(paramString1).append("'");
        paramInt += 1;
      }
      com.tencent.mobileqq.utils.FileUtils.writeFile(str, localStringBuilder.toString());
      localArrayList.add("-f");
      localArrayList.add("concat");
      localArrayList.add("-safe");
      localArrayList.add("0");
      localArrayList.add("-i");
      localArrayList.add(str);
      localArrayList.add("-map_chapters");
      localArrayList.add("-1");
      localArrayList.add("-strict");
      localArrayList.add("-2");
      localArrayList.add("-vcodec");
      if (paramClip.videoCodec == null) {
        break label828;
      }
      localArrayList.add(paramClip.videoCodec);
      localArrayList.add("-acodec");
      if (paramClip.audioCodec == null) {
        break label839;
      }
      localArrayList.add(paramClip.audioCodec);
    }
    for (;;)
    {
      FFmpegUtils.getAuidoType(paramString2);
      localArrayList.add("-bsf:a");
      localArrayList.add("aac_adtstoasc");
      if (paramClip.videoBitrate != -1)
      {
        localArrayList.add("-b:v");
        localArrayList.add(paramClip.videoBitrate + "k");
      }
      if (paramClip.videoFps != null)
      {
        localArrayList.add("-r");
        localArrayList.add(paramClip.videoFps);
      }
      if (paramClip.audioBitrate != -1)
      {
        localArrayList.add("-b:a");
        localArrayList.add(paramClip.audioBitrate + "k");
      }
      if (paramClip.width > 0)
      {
        localArrayList.add("-s");
        localArrayList.add(paramClip.width + "x" + paramClip.height);
      }
      if (paramClip.format != null)
      {
        localArrayList.add("-f");
        localArrayList.add(paramClip.format);
      }
      paramString1 = new File(paramClip.path);
      if (paramBoolean) {
        localArrayList.add("-shortest");
      }
      localArrayList.add(paramString1.getCanonicalPath());
      execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return paramClip;
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      break;
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      break;
      localArrayList.add("copy");
      break label459;
      localArrayList.add("aac");
    }
  }
  
  public void combineDoodle(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    localArrayList.add("[1:v]scale=iw:ih[s];[0:v][s]overlay=0:0");
    localArrayList.add(paramString3);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void compressVideo(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = yqs.a(paramString1);
    if (localObject == null)
    {
      paramFFmpegExecuteResponseCallback.onFailure("input path is null");
      paramFFmpegExecuteResponseCallback.onFinish(false);
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", "compressVideo input path is null");
      return;
    }
    int k = localObject[1];
    int n = localObject[2];
    int m = -1;
    int i = -1;
    int j;
    if ((k > 960) || (n > 960))
    {
      if (n >= k) {
        break label638;
      }
      i = 540;
      j = 540 * k / n;
    }
    for (;;)
    {
      if (k <= n)
      {
        j = 540;
        i = 540 * n / k;
      }
      k = i;
      if (i % 2 != 0) {
        k = i + 1;
      }
      i = j;
      m = k;
      if (j % 2 != 0)
      {
        i = j + 1;
        m = k;
      }
      k = 1;
      long l = ypi.a(paramString1);
      j = k;
      if (l != -1L)
      {
        j = k;
        if (l < 2202009.6000000001D) {
          j = 0;
        }
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add("-y");
      if (paramInt2 != 0)
      {
        ((ArrayList)localObject).add("-ss");
        ((ArrayList)localObject).add(String.valueOf(paramInt1 / 1000) + "." + String.valueOf(paramInt1 % 1000));
        ((ArrayList)localObject).add("-accurate_seek");
      }
      ((ArrayList)localObject).add("-i");
      ((ArrayList)localObject).add(new File(paramString1).getCanonicalPath());
      if (paramInt2 != 0)
      {
        ((ArrayList)localObject).add("-t");
        ((ArrayList)localObject).add(String.valueOf(paramInt2 / 1000) + "." + String.valueOf(paramInt2 % 1000));
      }
      if ((i > 0) && (m > 0))
      {
        ((ArrayList)localObject).add("-vf");
        ((ArrayList)localObject).add("scale=" + i + ":" + m);
      }
      if (paramBoolean) {
        ((ArrayList)localObject).add("-an");
      }
      for (;;)
      {
        ((ArrayList)localObject).add("-vcodec");
        ((ArrayList)localObject).add("libx264");
        if (j != 0)
        {
          ((ArrayList)localObject).add("-b:v");
          ((ArrayList)localObject).add("" + paramInt3);
        }
        ((ArrayList)localObject).add("-bufsize");
        ((ArrayList)localObject).add("800k");
        ((ArrayList)localObject).add("-r");
        ((ArrayList)localObject).add("25");
        ((ArrayList)localObject).add("-metadata");
        ((ArrayList)localObject).add("title=" + System.currentTimeMillis());
        ((ArrayList)localObject).add("-movflags");
        ((ArrayList)localObject).add("faststart");
        ((ArrayList)localObject).add(new File(paramString2).getCanonicalPath());
        execute((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
        return;
        ((ArrayList)localObject).add("-acodec");
        ((ArrayList)localObject).add("aac");
      }
      label638:
      j = k;
      i = n;
    }
  }
  
  public void concatDifferentCodingMedia(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatDifferentCodingMedia arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add("-i");
      localArrayList.add(new File((String)paramList.get(i)).getCanonicalPath());
      localStringBuilder.append("[" + i + ":0]");
      localStringBuilder.append(" ");
      localStringBuilder.append("[" + i + ":1]");
      localStringBuilder.append(" ");
      i += 1;
    }
    localStringBuilder.append("concat=n=" + paramList.size() + ":v=1:a=1 [v] [a]");
    localArrayList.add("-filter_complex");
    localArrayList.add(localStringBuilder.toString());
    localArrayList.add("-map");
    localArrayList.add("[v]");
    localArrayList.add("-map");
    localArrayList.add("[a]");
    localArrayList.add(new File(paramString).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void concatMedia(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, boolean paramBoolean)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMedia arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    new File(paramString);
    File localFile = new File(vkm.k + "temp.txt");
    if (localFile.exists()) {
      localFile.delete();
    }
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    localFile.createNewFile();
    for (;;)
    {
      try
      {
        localBufferedWriter = new BufferedWriter(new FileWriter(localFile, true));
        int i = 0;
        if (paramString == null) {
          break label365;
        }
      }
      finally
      {
        try
        {
          if (i < paramList.size())
          {
            localBufferedWriter.write("file '" + new File((String)paramList.get(i)).getCanonicalPath() + "'");
            localBufferedWriter.newLine();
            i += 1;
            continue;
          }
          localBufferedWriter.flush();
          if (localBufferedWriter != null) {
            localBufferedWriter.close();
          }
          paramList = new ArrayList();
          paramList.add("-y");
          paramList.add("-f");
          paramList.add("concat");
          paramList.add("-i");
          paramList.add(localFile.getCanonicalPath());
          if (!paramBoolean) {
            break label367;
          }
          paramList.add("-c:v");
          paramList.add("libx264");
          paramList.add("-bsf:a");
          paramList.add("aac_adtstoasc");
          paramList.add(new File(paramString).getCanonicalPath());
          execute((String[])paramList.toArray(new String[0]), new FFmpeg.2(this, paramFFmpegExecuteResponseCallback, localFile));
          return;
        }
        finally
        {
          for (;;)
          {
            BufferedWriter localBufferedWriter;
            paramString = localBufferedWriter;
          }
        }
        paramList = finally;
        paramString = null;
      }
      paramString.close();
      label365:
      throw paramList;
      label367:
      paramList.add("-c");
      paramList.add("copy");
    }
  }
  
  public void concatMediaByTs(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      Object localObject2 = new File((String)localObject1).getName().split("\\.");
      localObject2 = vkm.k + localObject2[0] + ".ts";
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).getParentFile().exists()) {
        ((File)localObject3).getParentFile().mkdirs();
      }
      localObject3 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject3).cmdType = 5;
      ((FFmpegCommandUnit)localObject3).arguments = new FFmpeg.3(this, (String)localObject1, (String)localObject2);
      ((FFmpegCommandUnit)localObject3).callback = new FFmpeg.4(this, paramFFmpegExecuteResponseCallback);
      localArrayList.add(localObject3);
      i += 1;
    }
    paramList = new FFmpegCommandUnit();
    Object localObject1 = this.tsFileList;
    paramList.cmdType = 2;
    paramList.arguments = new FFmpeg.5(this, (ArrayList)localObject1, paramString);
    paramList.callback = paramFFmpegExecuteResponseCallback;
    localArrayList.add(paramList);
    cmdFFmpegQueue(localArrayList);
  }
  
  public void concatTsOutput(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\"concat:");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      i += 1;
    }
    localStringBuffer.append("\"");
    this.tsFileList = new ArrayList();
    paramList = new ArrayList();
    paramList.add("-y");
    paramList.add("-i");
    paramList.add(new String(localStringBuffer));
    paramList.add("-c");
    paramList.add("copy");
    paramList.add("-bsf:a");
    paramList.add("aac_adtstoasc");
    paramList.add(paramString);
    execute((String[])paramList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void convertMp4ToMp3(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vn");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "extractAudioFromMp4 args: %s", new Object[] { Arrays.toString(paramString1) });
    execute(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void convertPicToVideo(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "convertPicToVideo args: %s", new Object[] { Arrays.toString(paramString1) });
    execute(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void convertPicToVideoWithTime(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-loop");
    localArrayList.add("1");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-pix_fmt");
    localArrayList.add("yuv420p");
    localArrayList.add("-t");
    localArrayList.add(paramString3);
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "convertPicToVideoWithTime args: %s", new Object[] { Arrays.toString(paramString1) });
    execute(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void emptyFFmengCmd(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "fake ffmeng command. arguments: \n inMedia:" + paramString1 + "\n outMedia:" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramFFmpegExecuteResponseCallback.onFailure("input path is null");
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", "fake ffmeng command. input path is null");
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return;
    }
    boolean bool = ypi.a(this.context, paramString1, paramString2);
    if (bool) {
      paramFFmpegExecuteResponseCallback.onSuccess("copy_success");
    }
    for (;;)
    {
      paramFFmpegExecuteResponseCallback.onFinish(bool);
      xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "copy video to album result is " + bool);
      return;
      paramFFmpegExecuteResponseCallback.onFailure("copy_fail");
    }
  }
  
  public void execute(String[] paramArrayOfString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    if ((this.ffmpegExecuteAsyncTask != null) && (!this.ffmpegExecuteAsyncTask.isProcessCompleted()))
    {
      xvv.e("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg command is already running");
      throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
    }
    if (paramArrayOfString.length != 0)
    {
      Object localObject = paramArrayOfString[(paramArrayOfString.length - 1)];
      this.mCurrentCommandUnit = new FFmpegCommandUnit(paramArrayOfString, (String)localObject, paramFFmpegExecuteResponseCallback);
      int i = ((String)localObject).lastIndexOf("/");
      if ((i > -1) && (i < ((String)localObject).length() - 1))
      {
        localObject = new File(((String)localObject).substring(0, i + 1));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
      }
      paramFFmpegExecuteResponseCallback = new FFmpeg.1(this, paramFFmpegExecuteResponseCallback);
      paramArrayOfString = (String[])Util.concatenate((String[])Util.concatenate(new String[] { FileUtils.getFFmpeg(this.context) }, paramArrayOfString), new String[] { FileUtils.getAVCodecSoFilePath(this.context) });
      this.ffmpegExecuteAsyncTask = new FFmpegExecuteAsyncTask(this.context, paramArrayOfString, this.timeout, this.mIsWorkThreadCallback, paramFFmpegExecuteResponseCallback);
      this.ffmpegExecuteAsyncTask.execute(new Void[0]);
      xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "command execute: " + TextUtils.join(" ", paramArrayOfString));
      return;
    }
    throw new IllegalArgumentException("shell command cannot be empty");
  }
  
  public void hflip(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("transpose=1");
    localArrayList.add("-metadata:s:v");
    localArrayList.add("rotate=0");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void insertFFmpegQueue(ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    killRunningProcesses(false);
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "[insertFFmpegQueue][old] " + TextUtils.join(" ", paramArrayList.toArray()));
    if (this.mCurrentCommandUnit != null) {
      this.mCmdQueue.add(0, this.mCurrentCommandUnit);
    }
    this.mCmdQueue.addAll(0, paramArrayList);
    cmdFFmpegQueue(this.mCmdQueue);
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "[insertFFmpegQueue][new] " + TextUtils.join(" ", paramArrayList.toArray()));
  }
  
  public boolean isFFmpegCommandRunning()
  {
    return (this.ffmpegExecuteAsyncTask != null) && (!this.ffmpegExecuteAsyncTask.isProcessCompleted());
  }
  
  public void killRunningProcesses(boolean paramBoolean)
  {
    if ((this.ffmpegExecuteAsyncTask != null) && (!this.ffmpegExecuteAsyncTask.isProcessCompleted()))
    {
      Util.killFFmpegProcess(this.ffmpegExecuteAsyncTask);
      this.ffmpegExecuteAsyncTask = null;
      this.mLastTaskResult = -9999;
      if (this.mCurrentCommandUnit != null)
      {
        if (this.mCurrentCommandUnit.output != null)
        {
          File localFile = new File(this.mCurrentCommandUnit.output);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        if ((paramBoolean) && (this.mCurrentCommandUnit.callback != null))
        {
          this.mCurrentCommandUnit.callback.onFailure("FFmpeg任务被强制Kill掉");
          this.mCurrentCommandUnit.callback.onFinish(false);
          xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
      xvv.b("Q.qqstory.ffmpeg.FFmpegCmd", "KillFFmpeg!");
    }
  }
  
  public void killRunningProcessesForShortVideo(boolean paramBoolean)
  {
    if ((this.ffmpegExecuteAsyncTask != null) && (!this.ffmpegExecuteAsyncTask.isProcessCompleted()))
    {
      Util.killFFmpegProcess(this.ffmpegExecuteAsyncTask);
      this.ffmpegExecuteAsyncTask = null;
      this.mLastTaskResult = -9999;
      if (this.mCurrentCommandUnit != null)
      {
        if (this.mCurrentCommandUnit.output != null)
        {
          File localFile = new File(this.mCurrentCommandUnit.output);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        if (this.mCurrentCommandUnit.callback != null)
        {
          this.mCurrentCommandUnit.callback.onFailure("FFmpeg任务被强制Kill掉");
          this.mCurrentCommandUnit.callback.onFinish(false);
          xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
      xvv.b("Q.qqstory.ffmpeg.FFmpegCmd", "KillFFmpeg!");
    }
  }
  
  public void mp4Tots(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "mp4Tots arguments: \n input:" + paramString1 + "\n outputPath:" + paramString2);
    this.tsFileList.add(paramString2);
    if (ypi.c(paramString2))
    {
      paramFFmpegExecuteResponseCallback.onSuccess("TS file exists");
      paramFFmpegExecuteResponseCallback.onFinish(true);
      xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "TS file exists");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-c");
    localArrayList.add("copy");
    localArrayList.add("-bsf:v");
    localArrayList.add("h264_mp4toannexb");
    localArrayList.add("-f");
    localArrayList.add("mpegts");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void setCurrentTaskUni(String paramString)
  {
    this.mCurrentTaskUni = paramString;
  }
  
  public void setFFMpegCanExe()
  {
    Util.setFileExecutable(new File(FileUtils.getFFmpeg(this.context)));
  }
  
  public void setTimestamp(String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    paramString1 = new StringBuilder();
    paramString1.append("dev=").append(DeviceInfoUtil.getDeviceModel()).append("/").append("os=").append(DeviceInfoUtil.getDeviceOSVersion()).append("/").append("appVer=").append(AppSetting.a());
    localArrayList.add("-metadata");
    localArrayList.add("comment=" + paramString1.toString());
    if (paramInt != -1)
    {
      localArrayList.add("-metadata:s:v:0");
      localArrayList.add("rotate=" + paramInt);
    }
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-codec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void transcodeM4a(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-ab");
    localArrayList.add("96k");
    localArrayList.add("-ar");
    localArrayList.add("44100");
    localArrayList.add("-ac");
    localArrayList.add("1");
    localArrayList.add("-vn");
    localArrayList.add("-acodec");
    localArrayList.add("aac");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void watermark(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermark arguments: \n inImage" + paramString1 + "\n inMedia:" + paramString2 + "\n outMedia:" + paramString3 + "\n videoWidth:" + paramInt1 + "\n videoHeight:" + paramInt2);
    if ((paramString2 == null) || (paramString3 == null))
    {
      paramFFmpegExecuteResponseCallback.onFailure("input path is null");
      paramFFmpegExecuteResponseCallback.onFinish(false);
      xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermark input path is null");
      return;
    }
    if (paramString1 == null)
    {
      boolean bool = ypi.a(this.context, paramString2, paramString3);
      if (bool) {
        paramFFmpegExecuteResponseCallback.onSuccess("copy_success");
      }
      for (;;)
      {
        paramFFmpegExecuteResponseCallback.onFinish(bool);
        xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermark inImage == null, copy to DCIM result is " + bool);
        return;
        paramFFmpegExecuteResponseCallback.onFailure("copy_fail");
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("movie=" + paramString1 + " [watermark]; [watermark]scale=" + paramInt1 + ":" + paramInt2 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out] ");
    localArrayList.add("-max_muxing_queue_size");
    localArrayList.add("9999");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void watermarkWithRotation(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermarkWithRotation arguments: \n inImage" + paramString1 + "\n inMedia:" + paramString2 + "\n outMedia:" + paramString3 + "\n videoWidth:" + paramInt1 + "\n videoHeight:" + paramInt2);
    if ((paramString2 == null) || (paramString3 == null))
    {
      paramFFmpegExecuteResponseCallback.onFailure("input path is null");
      xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermarkWithRotation input path is null");
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return;
    }
    if (paramString1 == null)
    {
      boolean bool = ypi.a(this.context, paramString2, paramString3);
      if (bool) {
        paramFFmpegExecuteResponseCallback.onSuccess("copy_success");
      }
      for (;;)
      {
        paramFFmpegExecuteResponseCallback.onFinish(bool);
        xvv.d("Q.qqstory.ffmpeg.FFmpegCmd", "watermarkWithRotation inImage == null, copy to DCIM result is " + bool);
        return;
        paramFFmpegExecuteResponseCallback.onFailure("copy_fail");
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("[in]transpose=1 [in]; movie=" + paramString1 + " [watermark]; [watermark]scale=" + paramInt1 + ":" + paramInt2 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out]");
    localArrayList.add("-metadata:s:v");
    localArrayList.add("rotate=0");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg
 * JD-Core Version:    0.7.0.1
 */