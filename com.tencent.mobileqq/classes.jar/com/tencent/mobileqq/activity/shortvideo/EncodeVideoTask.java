package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QZoneVideoCompressor;
import java.io.File;
import java.util.HashMap;
import ycs;
import ycu;

public class EncodeVideoTask
  extends AsyncTask
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener;
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  private String jdField_a_of_type_JavaLangString;
  private ycu jdField_a_of_type_Ycu = new ycs(this);
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
  }
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean1, EncodeVideoTask.ThumbInfo paramThumbInfo, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo = paramThumbInfo;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    if (paramThumbInfo != null) {
      this.jdField_b_of_type_JavaLangString = paramThumbInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    System.currentTimeMillis();
    return new MergeEditVideo().a(paramString1, paramString2, new MergeEditVideo.EditParam(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry));
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      String str = "";
      if (paramInt == 1) {
        str = "actShortVideoGenerateSource";
      }
      while (!TextUtils.isEmpty(str))
      {
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, str, true, paramLong, 0L, null, "");
        return;
        if (paramInt == 2) {
          str = "actShortVideoGenerateAudio";
        } else if (paramInt == 3) {
          str = "actShortVideoGeneratePic";
        } else if (paramInt == 4) {
          str = "actMediaCodecMergeEdit";
        } else if (paramInt == 5) {
          str = "actMediaCodecMergeSelfAudio";
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "" + paramString);
    }
  }
  
  private int b(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    int i = 0;
    if ((paramPublishVideoEntry == null) || (paramPublishVideoEntry.videoMaxrate <= 0)) {
      i = -1;
    }
    do
    {
      for (;;)
      {
        return i;
        double d1 = paramPublishVideoEntry.recordTime / 1000.0D;
        int j = paramPublishVideoEntry.videoMaxrate;
        try
        {
          j = QZoneVideoCompressor.a(new String[] { "-threads", "1", "-ss", "0.0", "-accurate_seek", "-i", paramString1, "-t", String.valueOf(d1), "-vf", "null", "-metadata:s", "rotate=0", "-acodec", "aac", "-vcodec", "libx264", "-movflags", "faststart", "-preset", "veryfast", "-tune", "psnr", "-profile:v", "high", "-level", "3.0", "-b:v", String.valueOf(j), "-y", paramString2 });
          return j;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("EncodeVideoTask", 2, "TrimNative.trim: ", paramString1);
            return 0;
          }
        }
        catch (Error paramString1) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("EncodeVideoTask", 2, "TrimNative.trim: error", paramString1);
    return 0;
  }
  
  private static void b(String paramString, PublishVideoEntry paramPublishVideoEntry, ycu paramycu)
  {
    String str = ShortVideoUtils.a(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.a(BaseApplicationImpl.getApplication());
    }
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      EncodeVideoTask.VideoSaveAlumCallBack localVideoSaveAlumCallBack = new EncodeVideoTask.VideoSaveAlumCallBack(paramPublishVideoEntry, paramString, str, paramycu);
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(str);
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localVideoSaveAlumCallBack);
      return;
    }
    catch (Exception paramString)
    {
      paramycu.a(-12);
      QLog.e("EncodeVideoTask", 2, "generate files save alum:", paramString);
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return c(paramVarArgs);
    }
    return b(paramVarArgs);
  }
  
  public void a(EncodeVideoTask.ResultListener paramResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = paramResultListener;
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInteger.intValue()));
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
    if (paramInteger.intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(null, "actMediaCodecEncodeSuccessRate", bool, 0L, 0L, localHashMap, "");
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EncodeVideoTask", 2, "onPostExecute result:" + paramInteger);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener.a(paramInteger.intValue());
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected Integer b(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(-1);
    }
    long l1 = System.currentTimeMillis();
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      a("[NewVersion]configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      return Integer.valueOf(-2);
    }
    if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir))
    {
      QLog.e("EncodeVideoTask", 2, "[NewVersion]configure param error, fakeId:" + this.jdField_a_of_type_JavaLangString + ", EntryId:" + localPublishVideoEntry.fakeVid);
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-2);
    }
    File localFile = new File(localPublishVideoEntry.mLocalRawVideoDir);
    Object localObject2 = localFile.getParentFile();
    String str3 = ShortVideoUtils.a((File)localObject2);
    String str2 = ((File)localObject2).getAbsolutePath() + File.separator + "mc_video.mp4";
    Object localObject1 = ((File)localObject2).getAbsolutePath() + File.separator + "mc_audio.mp4";
    if (!FileUtils.b(str2))
    {
      a("[NewVersion]video file empty, path=" + str2);
      return Integer.valueOf(-3);
    }
    long l2 = System.currentTimeMillis();
    String str1 = str2 + "_merge_video_x.mp4";
    int i = a(str2, str1, localPublishVideoEntry);
    if (i != 0) {
      if (i == -1)
      {
        paramVarArgs = new File(str1);
        if (paramVarArgs.exists()) {
          paramVarArgs.delete();
        }
        if (this.jdField_c_of_type_Boolean)
        {
          paramVarArgs = str1;
          if (b(str2, str1, localPublishVideoEntry) != 0)
          {
            a("[NewVersion]adjustBitrate: errcode=" + i);
            return Integer.valueOf(-4);
          }
        }
        else
        {
          paramVarArgs = str2;
        }
        if ((TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) || (!FileUtils.a(localPublishVideoEntry.backgroundMusicPath))) {
          break label631;
        }
      }
    }
    label631:
    for (i = 1;; i = 0)
    {
      for (;;)
      {
        l2 = System.currentTimeMillis();
        if ((localPublishVideoEntry.isMuteRecordVoice) || (i != 0)) {
          localObject1 = null;
        }
        int j = HwVideoMerge.a(paramVarArgs, (String)localObject1, str3, 0);
        a("[NewVersion]HwVideoMerge.merge cost:" + (System.currentTimeMillis() - l2) / 1000.0D);
        a(System.currentTimeMillis() - l2, 5);
        if (j == 0) {
          break label636;
        }
        a("[NewVersion]HwVideoMerge->merge: errcode=" + j);
        return Integer.valueOf(-5);
        a("[NewVersion]videoSynthesis: errcode=" + i);
        return Integer.valueOf(-4);
        a(System.currentTimeMillis() - l2, 4);
        paramVarArgs = str1;
        if (!this.jdField_d_of_type_Boolean) {
          break;
        }
        try
        {
          localObject2 = ShortVideoUtils.a((File)localObject2, "qz_origin_");
          paramVarArgs = str1;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          HwVideoMerge.a(str2, (String)localObject1, (String)localObject2, 0);
          paramVarArgs = str1;
        }
        catch (Throwable paramVarArgs)
        {
          a("[NewVersion]merge video audio error");
          paramVarArgs = str1;
        }
      }
      break;
    }
    label636:
    if (i != 0) {}
    for (;;)
    {
      try
      {
        l2 = System.currentTimeMillis();
        paramVarArgs = ShortVideoUtils.d(localFile);
        localObject1 = new File(paramVarArgs).getParentFile();
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        long l3 = ShortVideoUtils.b(str3);
        localObject1 = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, str3, paramVarArgs);
        ((EncodeVideoTask.ResponseCallBack)localObject1).a(this.jdField_a_of_type_Ycu);
        FFmpegUtils.b(this.jdField_a_of_type_AndroidContentContext, str3, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l3, paramVarArgs, (ExecuteBinResponseCallback)localObject1);
        a("[NewVersion]FFmpegUtils.combinBackgroundMusic cost:" + (System.currentTimeMillis() - l2) / 1000.0D);
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
        continue;
      }
      a("[NewVersion] doInBackground cost:" + (System.currentTimeMillis() - l1) / 1000.0D);
      return Integer.valueOf(0);
      this.jdField_a_of_type_Ycu.a(localPublishVideoEntry, str3);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected Integer c(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(-1);
    }
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      }
      return Integer.valueOf(-2);
    }
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.y = (int)localPublishVideoEntry.recordTime;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.z = localPublishVideoEntry.recordFrames;
    if (localPublishVideoEntry.saveMode != 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.J = localPublishVideoEntry.saveMode;
    }
    int i;
    label131:
    int j;
    Object localObject2;
    Object localObject1;
    long l;
    if (localPublishVideoEntry.businessId == 2)
    {
      i = 0;
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.D = i;
      if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {
        break label385;
      }
      i = 1;
      if (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)) {
        break label390;
      }
      j = 1;
      localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
      localObject1 = ShortVideoUtils.b((File)localObject2);
      paramVarArgs = (Void[])localObject1;
      if (i == 0)
      {
        paramVarArgs = (Void[])localObject1;
        if (j == 0) {
          paramVarArgs = ShortVideoUtils.a((File)localObject2);
        }
      }
      l = System.currentTimeMillis();
      localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
      ((EncodeThread)localObject1).a(false);
      ((EncodeThread)localObject1).b(false);
      ((EncodeThread)localObject1).d(localPublishVideoEntry.isMuteRecordVoice);
      if (localPublishVideoEntry.mMosaicMask != null) {
        ((EncodeThread)localObject1).a(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
      }
      ((EncodeThread)localObject1).run();
      a(System.currentTimeMillis() - l, 1);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|first step cost:" + (System.currentTimeMillis() - l) / 1000.0D);
      }
      if (i == 0) {
        break label415;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ShortVideoUtils.d((File)localObject2);
        l = ShortVideoUtils.b(paramVarArgs);
        localObject2 = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((EncodeVideoTask.ResponseCallBack)localObject2).a(this.jdField_a_of_type_Ycu);
        FFmpegUtils.b(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l, (String)localObject1, (ExecuteBinResponseCallback)localObject2);
        return Integer.valueOf(0);
        i = 1;
        break;
        label385:
        i = 0;
        break label131;
        label390:
        j = 0;
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
        continue;
      }
      label415:
      this.jdField_a_of_type_Ycu.a(localPublishVideoEntry, paramVarArgs);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask
 * JD-Core Version:    0.7.0.1
 */