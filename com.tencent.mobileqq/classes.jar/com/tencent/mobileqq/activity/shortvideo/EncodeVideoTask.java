package com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.editor.composite.VideoCompositeHelper;
import com.tencent.mobileqq.editor.composite.step.HwVideoMerge;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.monitor.CaptureFreqMonitor;
import com.tencent.mobileqq.monitor.CaptureFreqMonitorItem;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class EncodeVideoTask
  extends AsyncTask<Void, Void, Integer>
{
  private static FFmpeg jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg;
  public static ConcurrentHashMap<Long, EncodeVideoTask> a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private EncodeVideoTask.EncodeProcessListener jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener = new EncodeVideoTask.2(this);
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  public MessageForShortVideo a;
  public PublishVideoEntry a;
  private ResultListener jdField_a_of_type_ComTencentMobileqqShortvideoResultListener;
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
      try
      {
        paramMessageForShortVideo.serial();
        paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("encodeVideoTask uniseq:");
          paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          QLog.i("EncodeVideoTask", 2, paramQQAppInterface.toString());
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("EncodeVideoTask", 2, "CompressTask Init", paramQQAppInterface);
      }
    }
  }
  
  public static void a(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, 0);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong <= 0L) {
      return;
    }
    String str;
    if (paramInt1 == 1) {
      str = "actShortVideoGenerateSource";
    }
    for (;;)
    {
      break;
      if (paramInt1 == 2) {
        str = "actShortVideoGenerateAudio";
      } else if (paramInt1 == 3) {
        str = "actShortVideoGeneratePic";
      } else if (paramInt1 == 4) {
        str = "actMediaCodecMergeEdit";
      } else if (paramInt1 == 5) {
        str = "actMediaCodecMergeSelfAudio";
      } else {
        str = "";
      }
    }
    HashMap localHashMap = null;
    if (paramInt2 != 0)
    {
      localHashMap = new HashMap();
      localHashMap.put("hcState", String.valueOf(paramInt2));
    }
    if (!TextUtils.isEmpty(str)) {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, str, true, paramLong, 0L, localHashMap, "");
    }
  }
  
  private static void b(String paramString, PublishVideoEntry paramPublishVideoEntry, EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    String str = ShortVideoUtils.getMergeVideoPath(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg == null) {
      jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    if (jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.isFFmpegCommandRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      EncodeVideoTask.VideoSaveAlumCallBack localVideoSaveAlumCallBack = new EncodeVideoTask.VideoSaveAlumCallBack(paramPublishVideoEntry, paramString, str, paramEncodeProcessListener);
      jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.setCurrentTaskUni(str);
      jdField_a_of_type_ComTencentMobileqqVideocodecFfmpegFFmpeg.watermark(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localVideoSaveAlumCallBack);
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
    if (CaptureFreqMonitor.jdField_b_of_type_Boolean) {
      CaptureFreqMonitor.c.b();
    }
    Object localObject1 = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[StoryEncodeType]configure param error, fakeVid:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.i("EncodeVideoTask", 2, ((StringBuilder)localObject1).toString());
      }
      return Integer.valueOf(-62);
    }
    this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry = ((PublishVideoEntry)localObject1);
    if (TextUtils.isEmpty(((PublishVideoEntry)localObject1).mLocalRawVideoDir))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[StoryEncodeType]configure param error, fakeId:");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(", EntryId:");
        ((StringBuilder)localObject2).append(((PublishVideoEntry)localObject1).fakeVid);
        QLog.i("EncodeVideoTask", 2, ((StringBuilder)localObject2).toString());
      }
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-62);
    }
    Object localObject2 = ShortVideoUtils.getMergeVideoPath(new File(((PublishVideoEntry)localObject1).mLocalRawVideoDir).getParentFile());
    new VideoCompositeHelper().a((PublishVideoEntry)localObject1, (String)localObject2, false, true, new EncodeVideoTask.1(this, (PublishVideoEntry)localObject1, (String)localObject2, l));
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
    if ((paramPublishVideoEntry != null) && (paramPublishVideoEntry.publishState == 0)) {
      return;
    }
    if (paramPublishVideoEntry != null)
    {
      paramPublishVideoEntry.publishState = 0;
      QQStoryContext.a().a().createEntityManager().update(paramPublishVideoEntry);
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    String str;
    if (paramInt == 0) {
      str = "1";
    } else {
      str = "0";
    }
    long l1 = 0L;
    StoryReportor.a("AIOMergeVideoSuc", bool, 0L, new String[] { str });
    if (paramInt != 0)
    {
      StoryReportor.a("AIOMergeVideoError", true, 0L, new String[] { String.valueOf(paramInt) });
      return;
    }
    if (paramLong == 0L) {
      paramLong = l1;
    } else {
      paramLong = System.currentTimeMillis() - paramLong;
    }
    if ((paramPublishVideoEntry != null) && (paramPublishVideoEntry.isPicture)) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if ((CaptureFreqMonitor.jdField_b_of_type_Boolean) && (paramInt == 0) && (CaptureFreqMonitor.c.a()))
    {
      l1 = CaptureFreqMonitor.c.a[0];
      long l2 = CaptureFreqMonitor.c.a[1];
      long l3 = CaptureFreqMonitor.c.a[2];
      long l4 = CaptureFreqMonitor.c.a[3];
      long l5 = CaptureFreqMonitor.c.a[4];
      if ((StoryReportor.a(paramLong, 0L, 120000L)) && (StoryReportor.a(l1, 0L, 120000L)) && (StoryReportor.a(l2, 0L, 120000L)) && (StoryReportor.a(l3, 0L, 10000L)) && (StoryReportor.a(l4, 0L, 120000L)) && (StoryReportor.a(l5, 0L, 120000L))) {
        StoryReportor.a("AIOMergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
      }
      CaptureFreqMonitor.c.c();
    }
  }
  
  public void a(ResultListener paramResultListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoResultListener = paramResultListener;
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInteger.intValue()));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplicationImpl.getContext());
    boolean bool;
    if (paramInteger.intValue() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(null, "actMediaCodecEncodeSuccessRate", bool, 0L, 0L, (HashMap)localObject, "");
    if (paramInteger.intValue() != 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPostExecute result:");
        ((StringBuilder)localObject).append(paramInteger);
        QLog.d("EncodeVideoTask", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoResultListener.a(paramInteger.intValue());
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqEditorDatabasePublishVideoEntry;
      if (localObject != null) {
        ((PublishVideoEntry)localObject).isCancel = true;
      }
      this.f = true;
      boolean bool = HwVideoMerge.destroyRunningProcess();
      FFmpegUtils.killRunningProcesses();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("shortVideoCancel, cancelMerge:");
        ((StringBuilder)localObject).append(bool);
        QLog.i("EncodeVideoTask", 2, ((StringBuilder)localObject).toString());
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
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("encode cost=");
      paramVarArgs.append(SystemClock.uptimeMillis() - l);
      QLog.d("EncodeVideoTask", 2, new Object[] { paramVarArgs.toString(), " ret:", Integer.valueOf(j) });
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
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("configure param error, fakeVid:");
        paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
        QLog.i("EncodeVideoTask", 2, paramVarArgs.toString());
      }
      return Integer.valueOf(-2);
    }
    com.tencent.mobileqq.editor.composite.CodecParam.mRecordTime = (int)localPublishVideoEntry.recordTime;
    com.tencent.mobileqq.editor.composite.CodecParam.mRecordFrames = localPublishVideoEntry.recordFrames;
    if (localPublishVideoEntry.saveMode != 0) {
      com.tencent.mobileqq.editor.composite.CodecParam.mSaveMode = localPublishVideoEntry.saveMode;
    }
    if (localPublishVideoEntry.businessId == 2) {
      i = 0;
    } else {
      i = 1;
    }
    com.tencent.mobileqq.editor.composite.CodecParam.mAdjustSpecialSpeed = i;
    int i = TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath) ^ true;
    boolean bool = TextUtils.isEmpty(localPublishVideoEntry.doodlePath);
    Object localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
    Object localObject1 = ShortVideoUtils.getTempVideoPath((File)localObject2);
    paramVarArgs = (Void[])localObject1;
    if (i == 0)
    {
      paramVarArgs = (Void[])localObject1;
      if (!(bool ^ true)) {
        paramVarArgs = ShortVideoUtils.getMergeVideoPath((File)localObject2);
      }
    }
    long l = System.currentTimeMillis();
    localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
    ((EncodeThread)localObject1).setEnableHardEncode(false);
    ((EncodeThread)localObject1).setEnableDeleteCache(false);
    ((EncodeThread)localObject1).setMuteVoice(localPublishVideoEntry.isMuteRecordVoice);
    if (localPublishVideoEntry.mMosaicMask != null) {
      ((EncodeThread)localObject1).setMosaicMask(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
    }
    ((EncodeThread)localObject1).run();
    a(System.currentTimeMillis() - l, 1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("generate files|first step cost:");
      double d1 = System.currentTimeMillis() - l;
      Double.isNaN(d1);
      ((StringBuilder)localObject1).append(d1 / 1000.0D);
      QLog.d("EncodeVideoTask", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      try
      {
        localObject1 = ShortVideoUtils.getTempAudioPath((File)localObject2);
        l = ShortVideoUtils.getDurationOfVideo(paramVarArgs);
        localObject2 = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((EncodeVideoTask.ResponseCallBack)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener);
        FFmpegUtils.combinBackgroundMusic(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l, (String)localObject1, (ExecuteBinResponseCallback)localObject2);
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          break label442;
        }
      }
      QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoEncodeVideoTask$EncodeProcessListener.a(localPublishVideoEntry, paramVarArgs);
    }
    label442:
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask
 * JD-Core Version:    0.7.0.1
 */