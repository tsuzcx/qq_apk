package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.util.CaptureFreqMonitorItem;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class EncodeVideoTask
  extends AsyncTask<Void, Void, Integer>
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  public static ConcurrentHashMap<Long, EncodeVideoTask> a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public PublishVideoEntry a;
  private EncodeVideoTask.EncodeProcessListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener = new EncodeVideoTask.2(this);
  private EncodeVideoTask.ResultListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener;
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  public MessageForShortVideo a;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
  }
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean1, EncodeVideoTask.ThumbInfo paramThumbInfo, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo = paramThumbInfo;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    if (paramThumbInfo != null) {
      this.jdField_b_of_type_JavaLangString = paramThumbInfo.jdField_a_of_type_JavaLangString;
    }
    this.jdField_d_of_type_Boolean = paramBoolean2;
  }
  
  public EncodeVideoTask(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.busiType == 1) && (paramQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      paramMessageForShortVideo.videoFileStatus = 998;
    }
    try
    {
      paramMessageForShortVideo.serial();
      paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "encodeVideoTask uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("EncodeVideoTask", 2, "CompressTask Init", paramQQAppInterface);
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, 0);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong <= 0L) {}
    label121:
    label125:
    for (;;)
    {
      return;
      String str = "";
      HashMap localHashMap;
      if (paramInt1 == 1)
      {
        str = "actShortVideoGenerateSource";
        if (paramInt2 == 0) {
          break label121;
        }
        localHashMap = new HashMap();
        localHashMap.put("hcState", String.valueOf(paramInt2));
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label125;
        }
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, str, true, paramLong, 0L, localHashMap, "");
        return;
        if (paramInt1 == 2)
        {
          str = "actShortVideoGenerateAudio";
          break;
        }
        if (paramInt1 == 3)
        {
          str = "actShortVideoGeneratePic";
          break;
        }
        if (paramInt1 == 4)
        {
          str = "actMediaCodecMergeEdit";
          break;
        }
        if (paramInt1 != 5) {
          break;
        }
        str = "actMediaCodecMergeSelfAudio";
        break;
        localHashMap = null;
      }
    }
  }
  
  private static void b(String paramString, PublishVideoEntry paramPublishVideoEntry, EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    String str = ShortVideoUtils.getMergeVideoPath(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.isFFmpegCommandRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      EncodeVideoTask.VideoSaveAlumCallBack localVideoSaveAlumCallBack = new EncodeVideoTask.VideoSaveAlumCallBack(paramPublishVideoEntry, paramString, str, paramEncodeProcessListener);
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.setCurrentTaskUni(str);
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.watermark(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localVideoSaveAlumCallBack);
      return;
    }
    catch (Exception paramString)
    {
      paramEncodeProcessListener.a(-12);
      QLog.e("EncodeVideoTask", 2, "generate files save alum:", paramString);
    }
  }
  
  protected Integer a()
  {
    long l = System.currentTimeMillis();
    if (CaptureFreqMonitor.jdField_c_of_type_Boolean) {
      CaptureFreqMonitor.g.b();
    }
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      }
      return Integer.valueOf(-62);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = localPublishVideoEntry;
    if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeId:" + this.jdField_a_of_type_JavaLangString + ", EntryId:" + localPublishVideoEntry.fakeVid);
      }
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-62);
    }
    String str = ShortVideoUtils.getMergeVideoPath(new File(localPublishVideoEntry.mLocalRawVideoDir).getParentFile());
    new VideoCompositeHelper().a(localPublishVideoEntry, str, false, true, new EncodeVideoTask.1(this, localPublishVideoEntry, str, l));
    return Integer.valueOf(0);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return c(paramVarArgs);
    }
    return b(paramVarArgs);
  }
  
  public void a(int paramInt, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    if ((paramPublishVideoEntry != null) && (paramPublishVideoEntry.publishState == 0)) {}
    label336:
    label339:
    for (;;)
    {
      return;
      if (paramPublishVideoEntry != null)
      {
        paramPublishVideoEntry.publishState = 0;
        QQStoryContext.a().a().createEntityManager().update(paramPublishVideoEntry);
      }
      boolean bool;
      if (paramInt == 0)
      {
        bool = true;
        if (paramInt != 0) {
          break label99;
        }
      }
      label99:
      for (String str = "1";; str = "0")
      {
        StoryReportor.a("AIOMergeVideoSuc", bool, 0L, new String[] { str });
        if (paramInt == 0) {
          break label107;
        }
        StoryReportor.a("AIOMergeVideoError", true, 0L, new String[] { String.valueOf(paramInt) });
        return;
        bool = false;
        break;
      }
      label107:
      if (paramLong == 0L)
      {
        paramLong = 0L;
        if ((paramPublishVideoEntry == null) || (!paramPublishVideoEntry.isPicture)) {
          break label336;
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if ((!CaptureFreqMonitor.jdField_c_of_type_Boolean) || (paramInt != 0) || (!CaptureFreqMonitor.g.a())) {
          break label339;
        }
        long l1 = CaptureFreqMonitor.g.a[0];
        long l2 = CaptureFreqMonitor.g.a[1];
        long l3 = CaptureFreqMonitor.g.a[2];
        long l4 = CaptureFreqMonitor.g.a[3];
        long l5 = CaptureFreqMonitor.g.a[4];
        if ((StoryReportor.a(paramLong, 0L, 120000L)) && (StoryReportor.a(l1, 0L, 120000L)) && (StoryReportor.a(l2, 0L, 120000L)) && (StoryReportor.a(l3, 0L, 10000L)) && (StoryReportor.a(l4, 0L, 120000L)) && (StoryReportor.a(l5, 0L, 120000L))) {
          StoryReportor.a("AIOMergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        CaptureFreqMonitor.g.c();
        return;
        paramLong = System.currentTimeMillis() - paramLong;
        break;
      }
    }
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
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    if (paramInteger.intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(null, "actMediaCodecEncodeSuccessRate", bool, 0L, 0L, localHashMap, "");
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
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isCancel = true;
      }
      this.f = true;
      boolean bool = HwVideoMerge.destroyRunningProcess();
      FFmpegUtils.killRunningProcesses();
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "shortVideoCancel, cancelMerge:" + bool);
      }
      return true;
    }
    return false;
  }
  
  protected Integer b(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(-61, null, null, null, 0L);
      return Integer.valueOf(-61);
    }
    long l = SystemClock.uptimeMillis();
    int i = HardCoderManager.a().a(0, 1, 1, Process.myTid(), 8000, 603, 1L, Process.myTid(), "video", true);
    int j = a().intValue();
    if (j != 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(j, null, null, null, 0L);
    }
    if (i != 0) {
      HardCoderManager.a().a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, new Object[] { "encode cost=" + (SystemClock.uptimeMillis() - l), " ret:", Integer.valueOf(j) });
    }
    return Integer.valueOf(j);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
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
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRecordTime = (int)localPublishVideoEntry.recordTime;
    com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mRecordFrames = localPublishVideoEntry.recordFrames;
    if (localPublishVideoEntry.saveMode != 0) {
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mSaveMode = localPublishVideoEntry.saveMode;
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
      com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.mAdjustSpecialSpeed = i;
      if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {
        break label385;
      }
      i = 1;
      if (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)) {
        break label390;
      }
      j = 1;
      localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
      localObject1 = ShortVideoUtils.getTempVideoPath((File)localObject2);
      paramVarArgs = (Void[])localObject1;
      if (i == 0)
      {
        paramVarArgs = (Void[])localObject1;
        if (j == 0) {
          paramVarArgs = ShortVideoUtils.getMergeVideoPath((File)localObject2);
        }
      }
      l = System.currentTimeMillis();
      localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
      ((EncodeThread)localObject1).setEnableHardEncode(false);
      ((EncodeThread)localObject1).setEnableDeleteCache(false);
      ((EncodeThread)localObject1).setMuteVoice(localPublishVideoEntry.isMuteRecordVoice);
      if (localPublishVideoEntry.mMosaicMask != null) {
        ((EncodeThread)localObject1).setMosaicMask(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
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
        localObject1 = ShortVideoUtils.getTempAudioPath((File)localObject2);
        l = ShortVideoUtils.getDurationOfVideo(paramVarArgs);
        localObject2 = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((EncodeVideoTask.ResponseCallBack)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener);
        FFmpegUtils.combinBackgroundMusic(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l, (String)localObject1, (ExecuteBinResponseCallback)localObject2);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(localPublishVideoEntry, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask
 * JD-Core Version:    0.7.0.1
 */