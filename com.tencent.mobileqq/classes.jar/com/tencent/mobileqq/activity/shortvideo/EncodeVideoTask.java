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
  public static ConcurrentHashMap<Long, EncodeVideoTask> a = new ConcurrentHashMap();
  private static FFmpeg w;
  public PublishVideoEntry b;
  public MessageForShortVideo c;
  public boolean d = false;
  private boolean e = true;
  private Context f;
  private String g;
  private boolean h;
  private ResultListener i;
  private EncodeVideoTask.ThumbInfo j;
  private boolean k;
  private String l;
  private String m;
  private byte[] n;
  private String o;
  private byte[] p;
  private String q;
  private int r;
  private int s;
  private boolean t;
  private boolean u = false;
  private EncodeVideoTask.EncodeProcessListener v = new EncodeVideoTask.2(this);
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
  }
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean1, EncodeVideoTask.ThumbInfo paramThumbInfo, boolean paramBoolean2)
  {
    this.f = paramContext;
    this.g = paramString;
    this.j = paramThumbInfo;
    this.h = paramBoolean1;
    if (paramThumbInfo != null) {
      this.l = paramThumbInfo.a;
    }
    this.k = paramBoolean2;
  }
  
  public EncodeVideoTask(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.busiType == 1) && (paramQQAppInterface != null))
    {
      this.c = paramMessageForShortVideo;
      paramMessageForShortVideo.videoFileStatus = 998;
      try
      {
        paramMessageForShortVideo.serial();
        paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("encodeVideoTask uniseq:");
          paramQQAppInterface.append(this.c.uniseq);
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
    if (w == null) {
      w = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    if (w.isFFmpegCommandRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      EncodeVideoTask.VideoSaveAlumCallBack localVideoSaveAlumCallBack = new EncodeVideoTask.VideoSaveAlumCallBack(paramPublishVideoEntry, paramString, str, paramEncodeProcessListener);
      w.setCurrentTaskUni(str);
      w.watermark(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localVideoSaveAlumCallBack);
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
    long l1 = System.currentTimeMillis();
    if (CaptureFreqMonitor.d) {
      CaptureFreqMonitor.f.c();
    }
    Object localObject1 = VideoCompositeHelper.a(this.g);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[StoryEncodeType]configure param error, fakeVid:");
        ((StringBuilder)localObject1).append(this.g);
        QLog.i("EncodeVideoTask", 2, ((StringBuilder)localObject1).toString());
      }
      return Integer.valueOf(-62);
    }
    this.b = ((PublishVideoEntry)localObject1);
    if (TextUtils.isEmpty(((PublishVideoEntry)localObject1).mLocalRawVideoDir))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[StoryEncodeType]configure param error, fakeId:");
        ((StringBuilder)localObject2).append(this.g);
        ((StringBuilder)localObject2).append(", EntryId:");
        ((StringBuilder)localObject2).append(((PublishVideoEntry)localObject1).fakeVid);
        QLog.i("EncodeVideoTask", 2, ((StringBuilder)localObject2).toString());
      }
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-62);
    }
    Object localObject2 = ShortVideoUtils.getMergeVideoPath(new File(((PublishVideoEntry)localObject1).mLocalRawVideoDir).getParentFile());
    new VideoCompositeHelper().a((PublishVideoEntry)localObject1, (String)localObject2, false, true, new EncodeVideoTask.1(this, (PublishVideoEntry)localObject1, (String)localObject2, l1));
    return Integer.valueOf(0);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (!this.h) {
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
      QQStoryContext.a().d().createEntityManager().update(paramPublishVideoEntry);
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
    if ((CaptureFreqMonitor.d) && (paramInt == 0) && (CaptureFreqMonitor.f.b()))
    {
      l1 = CaptureFreqMonitor.f.b[0];
      long l2 = CaptureFreqMonitor.f.b[1];
      long l3 = CaptureFreqMonitor.f.b[2];
      long l4 = CaptureFreqMonitor.f.b[3];
      long l5 = CaptureFreqMonitor.f.b[4];
      if ((StoryReportor.a(paramLong, 0L, 120000L)) && (StoryReportor.a(l1, 0L, 120000L)) && (StoryReportor.a(l2, 0L, 120000L)) && (StoryReportor.a(l3, 0L, 10000L)) && (StoryReportor.a(l4, 0L, 120000L)) && (StoryReportor.a(l5, 0L, 120000L))) {
        StoryReportor.a("AIOMergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
      }
      CaptureFreqMonitor.f.d();
    }
  }
  
  public void a(ResultListener paramResultListener)
  {
    this.i = paramResultListener;
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
      this.i.a(paramInteger.intValue());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected Integer b(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.g))
    {
      this.v.a(-61, null, null, null, 0L);
      return Integer.valueOf(-61);
    }
    long l1 = SystemClock.uptimeMillis();
    int i1 = HardCoderManager.getInstance().start(0, 1, 1, Process.myTid(), 8000, 603, 1L, Process.myTid(), "video", true);
    int i2 = a().intValue();
    if (i2 != 0) {
      this.v.a(i2, null, null, null, 0L);
    }
    if (i1 != 0) {
      HardCoderManager.getInstance().stop(i1);
    }
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("encode cost=");
      paramVarArgs.append(SystemClock.uptimeMillis() - l1);
      QLog.d("EncodeVideoTask", 2, new Object[] { paramVarArgs.toString(), " ret:", Integer.valueOf(i2) });
    }
    return Integer.valueOf(i2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public boolean b()
  {
    if (!this.d)
    {
      Object localObject = this.b;
      if (localObject != null) {
        ((PublishVideoEntry)localObject).isCancel = true;
      }
      this.u = true;
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
  
  protected Integer c(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.g)) {
      return Integer.valueOf(-1);
    }
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.g);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("configure param error, fakeVid:");
        paramVarArgs.append(this.g);
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
      i1 = 0;
    } else {
      i1 = 1;
    }
    com.tencent.mobileqq.editor.composite.CodecParam.mAdjustSpecialSpeed = i1;
    int i1 = TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath) ^ true;
    boolean bool = TextUtils.isEmpty(localPublishVideoEntry.doodlePath);
    Object localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
    Object localObject1 = ShortVideoUtils.getTempVideoPath((File)localObject2);
    paramVarArgs = (Void[])localObject1;
    if (i1 == 0)
    {
      paramVarArgs = (Void[])localObject1;
      if (!(bool ^ true)) {
        paramVarArgs = ShortVideoUtils.getMergeVideoPath((File)localObject2);
      }
    }
    long l1 = System.currentTimeMillis();
    localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
    ((EncodeThread)localObject1).setEnableHardEncode(false);
    ((EncodeThread)localObject1).setEnableDeleteCache(false);
    ((EncodeThread)localObject1).setMuteVoice(localPublishVideoEntry.isMuteRecordVoice);
    if (localPublishVideoEntry.mMosaicMask != null) {
      ((EncodeThread)localObject1).setMosaicMask(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
    }
    ((EncodeThread)localObject1).run();
    a(System.currentTimeMillis() - l1, 1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("generate files|first step cost:");
      double d1 = System.currentTimeMillis() - l1;
      Double.isNaN(d1);
      ((StringBuilder)localObject1).append(d1 / 1000.0D);
      QLog.d("EncodeVideoTask", 2, ((StringBuilder)localObject1).toString());
    }
    if (i1 != 0)
    {
      try
      {
        localObject1 = ShortVideoUtils.getTempAudioPath((File)localObject2);
        l1 = ShortVideoUtils.getDurationOfVideo(paramVarArgs);
        localObject2 = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((EncodeVideoTask.ResponseCallBack)localObject2).a(this.v);
        FFmpegUtils.combinBackgroundMusic(this.f, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l1, (String)localObject1, (ExecuteBinResponseCallback)localObject2);
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
      this.v.a(localPublishVideoEntry, paramVarArgs);
    }
    label442:
    return Integer.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask
 * JD-Core Version:    0.7.0.1
 */