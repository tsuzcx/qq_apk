package com.tencent.mobileqq.activity.shortvideo;

import acjp;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import bahf;
import bmxe;
import bmxf;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import xwa;

public class EncodeVideoTask
  extends AsyncTask<Void, Void, Integer>
{
  public static final int FROM_AUDIO = 2;
  public static final int FROM_PIC = 3;
  public static final int FROM_SOURCE = 1;
  public static final int MEDIACODEC_AUDIO = 5;
  public static final int MEDIACODEC_PIC = 4;
  public static final int RESULT_ERROR_NO_SOURCE = -3;
  public static final int RESULT_ERROR_NO_THUMB = -8;
  public static final int RESULT_ERROR_NO_VIDEO_FILE = -9;
  public static final int RESULT_ERROR_THUMB_ERR = -6;
  public static final int RESULT_ERROR_THUMB_RENAME_ERR = -7;
  public static final int RESULT_ERROR_VIDEO_MD5 = -10;
  public static final int RESULT_FAIL_INIT = -1;
  public static final int RESULT_FAIL_INIT_STORY = -61;
  public static final int RESULT_FAIL_MERGE = -5;
  public static final int RESULT_FAIL_MERGE_BG_MUSIC = -11;
  public static final int RESULT_FAIL_MERGE_DOOBLE = -12;
  public static final int RESULT_FAIL_OLD_COMPOSITE = -14;
  public static final int RESULT_FAIL_UNKNOWN = -15;
  public static final int RESULT_FAIL_UNKNOWN_EDIT_SOURCE = -13;
  public static final int RESULT_FAIL_VIDEO_MERGE = -4;
  public static final int RESULT_NO_ENTITY = -2;
  public static final int RESULT_NO_ENTITY_STORY = -62;
  public static final int RESULT_SUCESS = 0;
  private static final String TAG = "EncodeVideoTask";
  public static ConcurrentHashMap<Long, EncodeVideoTask> mEncodeList = new ConcurrentHashMap();
  private static FFmpeg mFFmpeg;
  private Context context;
  private String fakeVid;
  private boolean isAdjustBitrate;
  private boolean isCanceled;
  public boolean isEncodeFinish;
  private boolean isFromQzone;
  private boolean mEnableClearCache = true;
  public MessageForShortVideo mMsg;
  public PublishVideoEntry mPublishEntry;
  private int mThumbHeight;
  private byte[] mThumbMd5;
  private String mThumbMd5String;
  private String mThumbPath;
  private int mThumbWidth;
  private byte[] mVideoMd5;
  private String mVideoMd5String;
  private String mVideoPath;
  private int mVideoTime;
  private EncodeVideoTask.EncodeProcessListener processListerner = new EncodeVideoTask.2(this);
  private EncodeVideoTask.ResultListener resultListener;
  private boolean supportMediaCodec;
  private EncodeVideoTask.ThumbInfo thumbInfo;
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
  }
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean1, EncodeVideoTask.ThumbInfo paramThumbInfo, boolean paramBoolean2)
  {
    this.context = paramContext;
    this.fakeVid = paramString;
    this.thumbInfo = paramThumbInfo;
    this.supportMediaCodec = paramBoolean1;
    if (paramThumbInfo != null) {
      this.mThumbPath = paramThumbInfo.path;
    }
    this.isAdjustBitrate = paramBoolean2;
  }
  
  public EncodeVideoTask(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean, EncodeVideoTask.ThumbInfo paramThumbInfo, MessageForShortVideo paramMessageForShortVideo)
  {
    this(paramContext, paramString, paramBoolean, paramThumbInfo, false);
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.busiType == 1) && (paramQQAppInterface != null))
    {
      this.mMsg = paramMessageForShortVideo;
      paramMessageForShortVideo.videoFileStatus = 998;
    }
    try
    {
      paramMessageForShortVideo.serial();
      paramQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "encodeVideoTask uniseq:" + this.mMsg.uniseq);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("EncodeVideoTask", 2, "CompressTask Init", paramQQAppInterface);
    }
  }
  
  public static void generateTimeReport(long paramLong, int paramInt)
  {
    generateTimeReport(paramLong, paramInt, 0);
  }
  
  public static void generateTimeReport(long paramLong, int paramInt1, int paramInt2)
  {
    if (paramLong <= 0L) {}
    label129:
    label133:
    for (;;)
    {
      return;
      String str = "";
      HashMap localHashMap;
      if (paramInt1 == 1)
      {
        str = "actShortVideoGenerateSource";
        if (paramInt2 == 0) {
          break label129;
        }
        localHashMap = new HashMap();
        localHashMap.put("hcState", String.valueOf(paramInt2));
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str)) {
          break label133;
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
  
  private void logMsg(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "" + paramString);
    }
  }
  
  private static void watermarkVideoToAlum(String paramString, PublishVideoEntry paramPublishVideoEntry, EncodeVideoTask.EncodeProcessListener paramEncodeProcessListener)
  {
    String str = ShortVideoUtils.getMergeVideoPath(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (mFFmpeg == null) {
      mFFmpeg = FFmpeg.getInstance(BaseApplicationImpl.getApplication());
    }
    if (mFFmpeg.isFFmpegCommandRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      EncodeVideoTask.VideoSaveAlumCallBack localVideoSaveAlumCallBack = new EncodeVideoTask.VideoSaveAlumCallBack(paramPublishVideoEntry, paramString, str, paramEncodeProcessListener);
      mFFmpeg.setCurrentTaskUni(str);
      mFFmpeg.watermark(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localVideoSaveAlumCallBack);
      return;
    }
    catch (Exception paramString)
    {
      paramEncodeProcessListener.onError(-12);
      QLog.e("EncodeVideoTask", 2, "generate files save alum:", paramString);
    }
  }
  
  public boolean cancel()
  {
    if (!this.isEncodeFinish)
    {
      this.mPublishEntry.isCancel = true;
      this.isCanceled = true;
      boolean bool = HwVideoMerge.destroyRunningProcess();
      FFmpegUtils.killRunningProcesses();
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "shortVideoCancel, cancelMerge:" + bool);
      }
      return true;
    }
    return false;
  }
  
  protected Integer doInBackground(Void... paramVarArgs)
  {
    if (!this.supportMediaCodec) {
      return doInBackground_OldVersion(paramVarArgs);
    }
    return doInBackground_NewVersion(paramVarArgs);
  }
  
  protected Integer doInBackground_NewVersion(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.fakeVid))
    {
      this.processListerner.onStoryMergeCompleted(-61, null, null, null, 0L);
      return Integer.valueOf(-61);
    }
    long l = SystemClock.uptimeMillis();
    int i = acjp.a().a(0, 1, 1, Process.myTid(), 8000, 603, 1L, Process.myTid(), "video", true);
    int j = realDoForHC_StoryEncodeType().intValue();
    if (j != 0) {
      this.processListerner.onStoryMergeCompleted(j, null, null, null, 0L);
    }
    if (i != 0) {
      acjp.a().a(i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EncodeVideoTask", 2, new Object[] { "encode cost=" + (SystemClock.uptimeMillis() - l), " ret:", Integer.valueOf(j) });
    }
    return Integer.valueOf(j);
  }
  
  protected Integer doInBackground_OldVersion(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.fakeVid)) {
      return Integer.valueOf(-1);
    }
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.getPublishVideoEntry(this.fakeVid);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "configure param error, fakeVid:" + this.fakeVid);
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
      generateTimeReport(System.currentTimeMillis() - l, 1);
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
        ((EncodeVideoTask.ResponseCallBack)localObject2).setProcessListener(this.processListerner);
        FFmpegUtils.combinBackgroundMusic(this.context, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l, (String)localObject1, (ExecuteBinResponseCallback)localObject2);
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
      this.processListerner.onNext(localPublishVideoEntry, paramVarArgs);
    }
  }
  
  public void handleReportEvent(int paramInt, PublishVideoEntry paramPublishVideoEntry, long paramLong)
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
        xwa.a("AIOMergeVideoSuc", bool, 0L, new String[] { str });
        if (paramInt == 0) {
          break label107;
        }
        xwa.a("AIOMergeVideoError", true, 0L, new String[] { String.valueOf(paramInt) });
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
        if ((!bmxe.c) || (paramInt != 0) || (!bmxe.g.a())) {
          break label339;
        }
        long l1 = bmxe.g.a[0];
        long l2 = bmxe.g.a[1];
        long l3 = bmxe.g.a[2];
        long l4 = bmxe.g.a[3];
        long l5 = bmxe.g.a[4];
        if ((xwa.a(paramLong, 0L, 120000L)) && (xwa.a(l1, 0L, 120000L)) && (xwa.a(l2, 0L, 120000L)) && (xwa.a(l3, 0L, 10000L)) && (xwa.a(l4, 0L, 120000L)) && (xwa.a(l5, 0L, 120000L))) {
          xwa.a("AIOMergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        bmxe.g.c();
        return;
        paramLong = System.currentTimeMillis() - paramLong;
        break;
      }
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
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
        this.resultListener.onError(paramInteger.intValue());
      }
      return;
    }
  }
  
  protected Integer realDoForHC_StoryEncodeType()
  {
    long l = System.currentTimeMillis();
    if (bmxe.c) {
      bmxe.g.b();
    }
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.getPublishVideoEntry(this.fakeVid);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeVid:" + this.fakeVid);
      }
      return Integer.valueOf(-62);
    }
    this.mPublishEntry = localPublishVideoEntry;
    if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir))
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "[StoryEncodeType]configure param error, fakeId:" + this.fakeVid + ", EntryId:" + localPublishVideoEntry.fakeVid);
      }
      bahf.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-62);
    }
    String str = ShortVideoUtils.getMergeVideoPath(new File(localPublishVideoEntry.mLocalRawVideoDir).getParentFile());
    new VideoCompositeHelper().composite(localPublishVideoEntry, str, false, true, new EncodeVideoTask.1(this, localPublishVideoEntry, str, l));
    return Integer.valueOf(0);
  }
  
  public void setFromQzone(boolean paramBoolean)
  {
    this.isFromQzone = paramBoolean;
  }
  
  public void setResultListener(EncodeVideoTask.ResultListener paramResultListener)
  {
    this.resultListener = paramResultListener;
  }
  
  public void setmEnableClearCache(boolean paramBoolean)
  {
    this.mEnableClearCache = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask
 * JD-Core Version:    0.7.0.1
 */