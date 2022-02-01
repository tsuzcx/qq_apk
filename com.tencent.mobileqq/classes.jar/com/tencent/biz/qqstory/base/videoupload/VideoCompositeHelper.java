package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo.RetCode;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.shortvideo.util.PicToVideoConverter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.sveffects.SvEffectSdkInitor.QQSpecialAVFilterResource;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.music.QimMusicPlayer;
import dov.com.qq.im.capture.util.CaptureFreqMonitor;
import dov.com.qq.im.capture.util.CaptureFreqMonitorItem;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class VideoCompositeHelper
{
  public static String a;
  private boolean a;
  private boolean b = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.qqstory.publish.upload.VideoCompositeHelper";
    try
    {
      int i = VideoEnvironment.loadAVCodecSo();
      SLog.b(jdField_a_of_type_JavaLangString, "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry)
  {
    VideoStoryPicToVideo.RetCode localRetCode = new VideoStoryPicToVideo.RetCode(940006, "");
    String str = paramPublishVideoEntry.getStringExtra("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", "");
    if ((str.isEmpty()) || (!com.tencent.biz.qqstory.utils.FileUtils.c(str))) {
      return localRetCode.a();
    }
    com.tencent.biz.qqstory.utils.FileUtils.f(paramPublishVideoEntry.mLocalRawVideoDir);
    int n = paramPublishVideoEntry.backgroundMusicDuration / 1000;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(str, localOptions);
    int i = ScreenUtil.SCREEN_WIDTH;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = CaptureUtil.a(i);
    int m = CaptureUtil.a((int)(k / f));
    int j = k;
    i = m;
    if (m > MergeEditVideo.a)
    {
      j = CaptureUtil.a((int)(k * MergeEditVideo.a / m));
      i = MergeEditVideo.a;
    }
    VideoStoryPicToVideo.a().a(str, paramPublishVideoEntry.mLocalRawVideoDir, String.valueOf(n), j, i, false, 0, new VideoCompositeHelper.2(this, localRetCode, paramPublishVideoEntry));
    b("convertImageToVideo ");
    return localRetCode.a();
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    CodecParam.mRecordTime = (int)paramPublishVideoEntry.recordTime;
    CodecParam.mRecordFrames = paramPublishVideoEntry.recordFrames;
    CodecParam.mSaveMode = paramPublishVideoEntry.saveMode;
    CodecParam.mIsSmooth = 0;
    CodecParam.mEnableTotalTimeAdjust = 0;
    CodecParam.mMaxrate = paramPublishVideoEntry.videoMaxrate;
    CodecParam.mMinrate = paramPublishVideoEntry.videoMinrate;
    CodecParam.mBitrateMode = 0;
    if (paramPublishVideoEntry.businessId == 2) {}
    for (i = 0;; i = 1)
    {
      CodecParam.mAdjustSpecialSpeed = i;
      l8 = -1L;
      l7 = -1L;
      l3 = -1L;
      l2 = -1L;
      l1 = l8;
      l4 = l7;
      l5 = l3;
      l6 = l2;
      if (paramPublishVideoEntry.hasFragments)
      {
        l1 = l8;
        l4 = l7;
        l5 = l3;
        l6 = l2;
        if (TextUtils.isEmpty(paramPublishVideoEntry.fragments)) {}
      }
      try
      {
        localObject = new JSONObject(paramPublishVideoEntry.fragments);
        l1 = ((JSONObject)localObject).optLong("vfFrameIndexStart", -1L);
      }
      catch (JSONException localJSONException1)
      {
        label285:
        int k;
        for (;;)
        {
          Object localObject;
          l6 = l3;
          l5 = l7;
          l1 = l8;
          localJSONException1.printStackTrace();
          l4 = l5;
          l5 = l6;
          l6 = l2;
        }
        SLog.d(jdField_a_of_type_JavaLangString, "version = %d", new Object[] { Integer.valueOf(k) });
        return i;
      }
      try
      {
        l6 = ((JSONObject)localObject).optLong("vfFrameIndexEnd", -1L);
        l4 = l3;
        l3 = l2;
      }
      catch (JSONException localJSONException2)
      {
        l5 = l7;
        l6 = l3;
        break;
      }
      try
      {
        l5 = ((JSONObject)localObject).optLong("afTimeStart", -1L);
        l4 = l5;
        l3 = l2;
        l2 = ((JSONObject)localObject).optLong("afTimeEnd", -1L);
        l4 = l5;
        l3 = l2;
        SLog.b(jdField_a_of_type_JavaLangString, "this is part video encode start %d end %d, audio start %d end %d", Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l2));
        l4 = l6;
        l6 = l2;
        if ((paramPublishVideoEntry.hwEncodeRecordVideo) || (TextUtils.isEmpty(paramPublishVideoEntry.mIFrameVideoPath)) || (!com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mIFrameVideoPath, paramString))) {
          break label685;
        }
        j = 1;
        i = 0;
      }
      catch (JSONException localJSONException3)
      {
        l5 = l6;
        l6 = l4;
        l2 = l3;
        break;
        i = -1;
        j = 0;
        break label285;
      }
      if (j == 0) {
        i = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
      }
      localObject = new File(paramString);
      localObject = paramPublishVideoEntry.videoUploadTempDir + "rotate_" + ((File)localObject).getName();
      if (b(paramString, (String)localObject) == 0)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: Change need rotation. inputVideoPath = " + paramString + " rotateFilePath = " + (String)localObject);
        com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject, paramString);
      }
      k = VideoEnvironment.getAVCodecVersion();
      if (k <= 28) {
        break label632;
      }
      SLog.d(jdField_a_of_type_JavaLangString, "version is %d", new Object[] { Integer.valueOf(k) });
      l2 = com.tencent.biz.qqstory.utils.FileUtils.c(paramString);
      SLog.b(jdField_a_of_type_JavaLangString, "file size %d, file %s", Long.valueOf(l2), paramString);
      k = i;
      if (l2 > 2097152L)
      {
        k = i;
        if (j == 0)
        {
          k = i;
          if (com.tencent.biz.qqstory.utils.FileUtils.g(paramString))
          {
            CodecParam.mBitrateMode = 1;
            i = CodecParam.mMaxrate;
            CodecParam.mMaxrate = 1677720;
            k = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
            l1 = com.tencent.biz.qqstory.utils.FileUtils.c(paramString);
            SLog.d(jdField_a_of_type_JavaLangString, "fix bitrate file size %d, orig bitrate:%d, file %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), paramString });
            CodecParam.mBitrateMode = 0;
            CodecParam.mMaxrate = i;
          }
        }
      }
      return k;
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, int paramInt4)
  {
    paramInt1 = b(paramPublishVideoEntry, paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramBoolean, paramInt4);
    if ((paramInt1 == 0) && (paramPublishVideoEntry.videoNeedRotate))
    {
      paramString2 = new File(paramString3);
      paramPublishVideoEntry = paramPublishVideoEntry.videoUploadTempDir + "rotate_" + paramString2.getName();
      paramInt2 = b(paramString3, paramPublishVideoEntry);
      if (paramInt2 == 0)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: Change need rotation. inputVideoPath=%s  rotateFilePath=%s", new Object[] { paramString1, paramPublishVideoEntry });
        com.tencent.biz.qqstory.utils.FileUtils.b(paramPublishVideoEntry, paramString3);
      }
    }
    else
    {
      return paramInt1;
    }
    SLog.e(jdField_a_of_type_JavaLangString, "EncodeLocalVideo: not rotate retcode =" + paramInt2);
    return paramInt1;
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    int j = 0;
    String str = paramPublishVideoEntry.videoUploadTempDir + "hwtemp.mp4";
    int i = b(paramPublishVideoEntry, paramString, paramBoolean);
    if (i != 0) {
      j = i;
    }
    label182:
    do
    {
      return j;
      if (paramPublishVideoEntry.isCancel)
      {
        com.tencent.biz.qqstory.utils.FileUtils.g(paramString);
        return -19;
      }
      l = System.currentTimeMillis();
      int k = -1;
      i = k;
      if (paramPublishVideoEntry.isLocalPublish)
      {
        i = k;
        if (paramPublishVideoEntry.businessId == 14)
        {
          i = k;
          if (paramPublishVideoEntry.getBooleanExtra("KEY_VIDEO_STORY_CAMERA_TYPE", false)) {
            i = 0;
          }
        }
      }
      i = a(paramString, str, i);
      if (CaptureFreqMonitor.c) {
        CaptureFreqMonitor.g.a(2, System.currentTimeMillis() - l);
      }
      if (i != 0) {
        break;
      }
      SLog.d(jdField_a_of_type_JavaLangString, "set moov in front of file success. targetMergedTempMp4 = " + str);
      com.tencent.biz.qqstory.utils.FileUtils.b(str, paramString);
      j = i;
    } while (!AudioHelper.a());
    long l = System.currentTimeMillis();
    if (!paramPublishVideoEntry.isCancel) {
      i = VideoCompositeManager.a(paramString);
    }
    if (paramPublishVideoEntry.isCancel) {
      i = -22;
    }
    if (i == 0) {
      SLog.d(jdField_a_of_type_JavaLangString, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
    }
    for (;;)
    {
      j = i;
      if (!CaptureFreqMonitor.c) {
        break;
      }
      CaptureFreqMonitor.g.a(3, System.currentTimeMillis() - l);
      return i;
      SLog.d(jdField_a_of_type_JavaLangString, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
      SLog.b(jdField_a_of_type_JavaLangString, "set moov in front of file failed targetFile = " + paramString);
      i = j;
      break label182;
      SLog.e(jdField_a_of_type_JavaLangString, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
    }
  }
  
  private static int a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    int m = ((Integer)localStoryConfigManager.b("key_encode_crf", Integer.valueOf(23))).intValue();
    int i = CodecParam.mQmax;
    int j = CodecParam.mQmin;
    int k = CodecParam.mMaxQdiff;
    int n = ((Integer)localStoryConfigManager.b("key_encode_qmax", Integer.valueOf(CodecParam.mQmax))).intValue();
    int i1 = ((Integer)localStoryConfigManager.b("key_encode_qmin", Integer.valueOf(CodecParam.mQmin))).intValue();
    int i2 = ((Integer)localStoryConfigManager.b("key_encode_qdiff", Integer.valueOf(CodecParam.mMaxQdiff))).intValue();
    CodecParam.mCRFValue = m;
    CodecParam.mQmax = 35;
    CodecParam.mQmin = i1;
    CodecParam.mMaxQdiff = i2;
    SLog.d(jdField_a_of_type_JavaLangString, "story encode param crf=%d, qmax=%d->%d, qmin=%d->%d, qdiff=>%d->%d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2) });
    try
    {
      paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
      paramString1.setEnableHardEncode(false);
      paramString1.setEnableDeleteCache(false);
      paramString1.setMuteVoice(paramBoolean);
      paramString1.setPartEncodeInfo(paramLong1, paramLong2, paramLong3, paramLong4);
      if (paramArrayOfByte != null) {
        paramString1.setMosaicMask(paramArrayOfByte, paramInt);
      }
      paramString1.run();
      paramInt = paramString1.errorCode;
      return paramInt;
    }
    finally
    {
      CodecParam.mCRFValue = 23;
      CodecParam.mQmax = i;
      CodecParam.mQmin = j;
      CodecParam.mMaxQdiff = k;
    }
  }
  
  private static int a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, -1);
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(953005);
    long l = System.currentTimeMillis();
    SLog.b(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp start!");
    try
    {
      FFmpegUtils.setTimestamp(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramInt, new VideoCompositeHelper.FFMPEGResponseCallback(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        SLog.a(jdField_a_of_type_JavaLangString, "setMoovAndTimeStamp end, take time:%d", Long.valueOf(System.currentTimeMillis() - l));
        paramInt = localAtomicInteger.get();
        return paramInt;
      }
      finally {}
      return 953004;
    }
    catch (IOException paramString1)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
      return 945002;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
      return 953003;
    }
    catch (InterruptedException paramString1)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramString1);
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    SLog.d(jdField_a_of_type_JavaLangString, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    Object localObject = new MergeEditVideo.EditParam(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    ((MergeEditVideo.EditParam)localObject).b(paramPublishVideoEntry.hwBitrateMode);
    if (paramBoolean) {
      ((MergeEditVideo.EditParam)localObject).a();
    }
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      ((MergeEditVideo.EditParam)localObject).c(8);
      SLog.b(jdField_a_of_type_JavaLangString, "codec high profile is enable when story video encode");
    }
    if (StoryConfigManager.e())
    {
      SLog.d(jdField_a_of_type_JavaLangString, "story debug mode is enable");
      localObject = (StoryConfigManager)SuperManager.a(10);
      i = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
      int j = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
      paramBoolean = ((Boolean)((StoryConfigManager)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
      MergeEditVideo.EditParam localEditParam = new MergeEditVideo.EditParam(i * 1000, paramPublishVideoEntry);
      localEditParam.a();
      localEditParam.b(j);
      localObject = localEditParam;
      if (paramBoolean)
      {
        localEditParam.c(8);
        localObject = localEditParam;
      }
    }
    int i = new MergeEditVideo().a(paramString1, paramString2, (MergeEditVideo.EditParam)localObject, paramPublishVideoEntry);
    l = SystemClock.elapsedRealtime() - l;
    SLog.d(jdField_a_of_type_JavaLangString, "[videoSynthesis]generate files|first step cost:" + l / 1000.0D);
    if (CaptureFreqMonitor.c) {
      CaptureFreqMonitor.g.a(0, l);
    }
    return i;
  }
  
  public static long a(String paramString)
  {
    if (!com.tencent.biz.qqstory.utils.FileUtils.b(paramString)) {}
    while (Build.VERSION.SDK_INT < 10) {
      return 0L;
    }
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  private VideoCompositeHelper.RetCode a(PublishVideoEntry paramPublishVideoEntry)
  {
    VideoCompositeHelper.RetCode localRetCode = new VideoCompositeHelper.RetCode(-1, "");
    String str1 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_download_url", "");
    String str2 = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_music_mid_id", "");
    if (StringUtil.a(str1))
    {
      localRetCode.a(0);
      localRetCode.a("don't need to download Music");
      return localRetCode;
    }
    str2 = SvEffectSdkInitor.QQSpecialAVFilterResource.jdField_a_of_type_JavaLangString + str2 + FFmpegUtils.getAuidoType(str1);
    paramPublishVideoEntry.backgroundMusicPath = str2;
    if (FileUtil.checkFileExist(str2))
    {
      localRetCode.a(0);
      localRetCode.a("needDownloadMusic and the file exist");
      return localRetCode;
    }
    QimMusicPlayer localQimMusicPlayer = (QimMusicPlayer)QIMManager.a().c(8);
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.setPath(str2);
    localMusicItemInfo.mUrl = str1;
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramPublishVideoEntry.getStringExtra("vs_publish_entry_json_key_song_name", "unknown name");
    if (!localQimMusicPlayer.a(localMusicItemInfo, new VideoCompositeHelper.3(this, paramPublishVideoEntry, localRetCode, str1)))
    {
      localRetCode.a(-1);
      localRetCode.a("needDownloadMusic cant startDownload maybe path is null or the music has downloaded");
      return localRetCode;
    }
    b("needAndStartDownloadMusic");
    return localRetCode;
  }
  
  @NonNull
  public static PublishVideoEntry a(String paramString)
  {
    Object localObject1 = new QQStoryEntityManagerFactory(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    ((QQStoryEntityManagerFactory)localObject1).verifyAuthentication();
    Object localObject2 = ((QQStoryEntityManagerFactory)localObject1).createEntityManager();
    localObject1 = new PublishVideoEntry();
    localObject2 = a((EntityManager)localObject2, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { paramString });
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((List)localObject2).size() > 0) {
        paramString = (PublishVideoEntry)((List)localObject2).get(0);
      }
    }
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = new PublishVideoEntry();
    }
    return localObject1;
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry.businessId == 2)
    {
      SLog.b(jdField_a_of_type_JavaLangString, "deleteVideoCache ignore because business id is qq");
      return;
    }
    if ((!paramPublishVideoEntry.isLocalPublish) && (!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      if (paramPublishVideoEntry.hasFragments) {
        break label139;
      }
      b(paramPublishVideoEntry);
    }
    for (;;)
    {
      if (paramPublishVideoEntry.isPicture) {
        QQStoryContext.a().a().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
      }
      com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.videoUploadTempDir);
      SLog.d(jdField_a_of_type_JavaLangString, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
      return;
      label139:
      a(paramPublishVideoEntry.fakeVid, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC);
      if (b(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        SLog.d(jdField_a_of_type_JavaLangString, "groupId=%s all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
        b(paramPublishVideoEntry);
      }
      else
      {
        SLog.d(jdField_a_of_type_JavaLangString, "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
      }
    }
  }
  
  private void a(PublishVideoEntry paramPublishVideoEntry, int paramInt, String paramString1, String paramString2)
  {
    if (EncodeVideoUtil.a(paramString1, paramString2, paramPublishVideoEntry) != 0)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "adjustBitrate: errcode" + paramInt);
      File localFile = new File(paramString2);
      if (localFile.exists()) {
        localFile.delete();
      }
      com.tencent.biz.qqstory.utils.FileUtils.c(paramString1, paramString2);
      paramPublishVideoEntry.useSrcFile = true;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      notifyAll();
      SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " notifyAll() ");
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(String paramString)
  {
    // Byte code:
    //   0: new 600	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$RetCode
    //   3: dup
    //   4: iconst_m1
    //   5: ldc_w 823
    //   8: invokespecial 601	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$RetCode:<init>	(ILjava/lang/String;)V
    //   11: astore 4
    //   13: getstatic 19	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: ldc_w 825
    //   19: invokestatic 821	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: getstatic 579	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 16
    //   27: if_icmpge +15 -> 42
    //   30: aload 4
    //   32: invokevirtual 826	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$RetCode:a	()I
    //   35: ifne +5 -> 40
    //   38: iconst_1
    //   39: ireturn
    //   40: iconst_0
    //   41: ireturn
    //   42: new 828	android/media/MediaExtractor
    //   45: dup
    //   46: invokespecial 829	android/media/MediaExtractor:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: aload_1
    //   52: invokevirtual 830	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   55: iconst_0
    //   56: istore_2
    //   57: iload_2
    //   58: aload_3
    //   59: invokevirtual 833	android/media/MediaExtractor:getTrackCount	()I
    //   62: if_icmpge +29 -> 91
    //   65: aload_3
    //   66: iload_2
    //   67: invokevirtual 837	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   70: ldc_w 839
    //   73: invokevirtual 844	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: ldc_w 846
    //   79: invokevirtual 849	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   82: ifeq +23 -> 105
    //   85: aload 4
    //   87: iconst_0
    //   88: invokevirtual 611	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$RetCode:a	(I)V
    //   91: aload_3
    //   92: invokevirtual 850	android/media/MediaExtractor:release	()V
    //   95: aload 4
    //   97: invokevirtual 826	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$RetCode:a	()I
    //   100: ifeq -62 -> 38
    //   103: iconst_0
    //   104: ireturn
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -52 -> 57
    //   112: astore_1
    //   113: aload_1
    //   114: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   117: aload_3
    //   118: invokevirtual 850	android/media/MediaExtractor:release	()V
    //   121: iconst_1
    //   122: ireturn
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 850	android/media/MediaExtractor:release	()V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	VideoCompositeHelper
    //   0	130	1	paramString	String
    //   56	53	2	i	int
    //   49	76	3	localMediaExtractor	android.media.MediaExtractor
    //   11	85	4	localRetCode	VideoCompositeHelper.RetCode
    // Exception table:
    //   from	to	target	type
    //   50	55	112	java/io/IOException
    //   57	91	112	java/io/IOException
    //   50	55	123	finally
    //   57	91	123	finally
    //   113	117	123	finally
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramString = a(paramString);
    paramString.videoProcessState = paramInt;
    return localEntityManager.update(paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    if (Build.VERSION.SDK_INT < 18) {}
    for (boolean bool = false; bool; bool = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("boolean_enable_hw_encode_pic_to_video", Boolean.valueOf(true))).booleanValue())
    {
      int j = new PicToVideoConverter().a(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
      int i = j;
      if (j != 0)
      {
        i = j;
        if (j != 942014)
        {
          SLog.d(jdField_a_of_type_JavaLangString, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
          i = c(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
        }
      }
      return i;
    }
    return c(paramPublishVideoEntry.mLocalRawVideoDir, paramString);
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, int paramInt4)
  {
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString1)) {
      return 940007;
    }
    Object localObject = new File(paramString1);
    paramString2 = paramString2 + "compressed_" + ((File)localObject).getName();
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("HUAWEI NXT-AL10")) && (!Build.MODEL.equalsIgnoreCase("HUAWEI MT7-TL00"))) {
      bool = true;
    }
    for (;;)
    {
      if (!bool)
      {
        SLog.e(jdField_a_of_type_JavaLangString, "encode local video incompatible: model = " + Build.MODEL + " compatible = " + bool);
        label123:
        paramPublishVideoEntry = new Object();
        paramString2 = new AtomicInteger(942009);
      }
      try
      {
        FFmpegUtils.compressLocalVideo(BaseApplicationImpl.getApplication(), paramString1, paramInt1, paramInt2 - paramInt1, paramInt3, paramBoolean, paramString3, new VideoCompositeHelper.FFMPEGResponseCallback(paramPublishVideoEntry, paramString2, 1));
        try
        {
          paramPublishVideoEntry.wait(180000L);
          paramInt1 = paramString2.get();
          return paramInt1;
        }
        finally {}
      }
      catch (IOException paramPublishVideoEntry)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
        return 943001;
        bool = false;
        continue;
        localObject = BaseApplicationImpl.getApplication().getApplicationContext();
        paramPublishVideoEntry = new VideoCompositeHelper.HWCompressProcessor(paramPublishVideoEntry, paramString2, paramInt3, paramInt1, paramInt2, paramBoolean, true, paramInt4);
        VideoConverter localVideoConverter = new VideoConverter(new VideoConverterLog());
        localVideoConverter.setCompressMode(1);
        if (localVideoConverter.startCompress((Context)localObject, paramString1, paramPublishVideoEntry, true) != 0) {
          break label123;
        }
        if (a(paramString2, paramString3) == 0) {
          com.tencent.biz.qqstory.utils.FileUtils.g(paramString2);
        }
        for (;;)
        {
          return 0;
          com.tencent.biz.qqstory.utils.FileUtils.b(paramString2, paramString3);
        }
      }
      catch (FFmpegCommandAlreadyRunningException paramPublishVideoEntry)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
        return 943002;
      }
      catch (InterruptedException paramPublishVideoEntry)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + paramPublishVideoEntry);
      }
    }
    return 943003;
  }
  
  private int b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    String str2 = paramPublishVideoEntry.mLocalRawVideoDir;
    boolean bool = paramPublishVideoEntry.getBooleanExtra("enable_flow_decode", true);
    String str1;
    if (paramPublishVideoEntry.businessId != 1)
    {
      str1 = str2;
      if (bool) {}
    }
    else
    {
      str1 = str2;
      if (paramPublishVideoEntry.saveMode == 5) {
        str1 = paramPublishVideoEntry.mIFrameVideoPath;
      }
    }
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(str1)) {
      return 940007;
    }
    str2 = paramPublishVideoEntry.videoUploadTempDir + "_merge_video_x.mp4";
    String str3 = paramPublishVideoEntry.videoUploadTempDir + "_merged_video_x.mp4";
    long l1 = SystemClock.elapsedRealtime();
    int i = 0;
    if (!paramPublishVideoEntry.isCancel) {
      i = a(str1, str2, paramPublishVideoEntry, paramBoolean);
    }
    if (paramPublishVideoEntry.isCancel) {
      i = -15;
    }
    Object localObject;
    if (i != 0) {
      if (i == -1)
      {
        localObject = new File(str2);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        if (this.jdField_a_of_type_Boolean)
        {
          a(paramPublishVideoEntry, i, str1, str2);
          i = 0;
        }
      }
    }
    for (;;)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
      long l2 = a(paramPublishVideoEntry.mLocalRawVideoDir);
      l1 = SystemClock.elapsedRealtime();
      int j;
      if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.backgroundMusicPath))) {
        j = 1;
      }
      AudioEncoder.AudioData localAudioData;
      for (;;)
      {
        if ((!paramPublishVideoEntry.isMuteRecordVoice) && ((j == 0) || (paramPublishVideoEntry.isMixOriginal)) && (!TextUtils.isEmpty(paramPublishVideoEntry.mAudioFilePath)) && (!paramPublishVideoEntry.isLocalPublish))
        {
          if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.mAudioFilePath))
          {
            SLog.d(jdField_a_of_type_JavaLangString, "audio not exist");
            com.tencent.biz.qqstory.utils.FileUtils.b(str2, paramString);
            return 0;
            com.tencent.biz.qqstory.utils.FileUtils.c(str1, str2);
            paramPublishVideoEntry.useSrcFile = true;
            break;
            return i;
            j = 0;
            continue;
          }
          SLog.d(jdField_a_of_type_JavaLangString, "trim audio");
          localObject = paramPublishVideoEntry.videoUploadTempDir + l1 + "_segment_mc_audio";
          if (!paramPublishVideoEntry.isCancel) {
            i = AudioDataUtil.a(paramPublishVideoEntry.mAudioFilePath, (String)localObject, paramPublishVideoEntry.videoRangeStart * 1.0F / (float)l2, paramPublishVideoEntry.videoRangeEnd * 1.0F / (float)l2);
          }
          if (paramPublishVideoEntry.isCancel) {
            return -17;
          }
          if (i != 0)
          {
            SLog.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            StoryReportor.b("publish_story", "clip_audio", 1, i, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            com.tencent.biz.qqstory.utils.FileUtils.b(str2, paramString);
            return 0;
          }
          j = AudioEncoder.a((String)localObject);
          if (j != 0)
          {
            SLog.d(jdField_a_of_type_JavaLangString, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            StoryReportor.b("publish_story", "clip_audio", 1, j, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            com.tencent.biz.qqstory.utils.FileUtils.b(str2, paramString);
            return 0;
          }
          SLog.d(jdField_a_of_type_JavaLangString, "audio to mp4");
          str1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          if (paramPublishVideoEntry.saveMode <= 5)
          {
            i = paramPublishVideoEntry.saveMode;
            localAudioData = AudioEncoder.a(null, null, i);
            localAudioData.b = str1;
            localAudioData.jdField_a_of_type_JavaLangString = ((String)localObject);
            if (paramPublishVideoEntry.isCancel) {
              break label1045;
            }
          }
        }
      }
      label1045:
      for (i = AudioEncoder.a(localAudioData);; i = j)
      {
        if (paramPublishVideoEntry.isCancel) {
          i = -21;
        }
        if (i != 0)
        {
          com.tencent.biz.qqstory.utils.FileUtils.g(str1);
          SLog.d(jdField_a_of_type_JavaLangString, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
          i = 0;
          break;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        SLog.d(jdField_a_of_type_JavaLangString, "video audio mp4");
        l2 = SystemClock.elapsedRealtime();
        com.tencent.biz.qqstory.utils.FileUtils.g(str3);
        if (!paramPublishVideoEntry.isCancel) {
          i = HwVideoMerge.merge(str2, str1, str3, 0);
        }
        if (paramPublishVideoEntry.isCancel)
        {
          com.tencent.biz.qqstory.utils.FileUtils.g(str1);
          com.tencent.biz.qqstory.utils.FileUtils.g(str3);
          return -18;
        }
        SLog.d(jdField_a_of_type_JavaLangString, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        if (i != 0)
        {
          SLog.d(jdField_a_of_type_JavaLangString, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
          return i;
        }
        l1 = SystemClock.elapsedRealtime() - l1;
        SLog.a(jdField_a_of_type_JavaLangString, "mediacodec encode audio time cost=%s", Long.valueOf(l1));
        if (CaptureFreqMonitor.c) {
          CaptureFreqMonitor.g.a(1, l1);
        }
        for (paramPublishVideoEntry = str3;; paramPublishVideoEntry = str2)
        {
          com.tencent.biz.qqstory.utils.FileUtils.b(paramPublishVideoEntry, paramString);
          return i;
        }
      }
    }
  }
  
  /* Error */
  private int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 53	java/lang/Object:<init>	()V
    //   12: astore 6
    //   14: new 469	java/util/concurrent/atomic/AtomicInteger
    //   17: dup
    //   18: iconst_m1
    //   19: invokespecial 473	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   22: astore 7
    //   24: aload_1
    //   25: invokestatic 1031	com/tencent/biz/qqstory/utils/VideoUtils:a	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: iload_3
    //   30: iconst_m1
    //   31: if_icmpne +7 -> 38
    //   34: ldc_w 1032
    //   37: ireturn
    //   38: getstatic 19	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: ldc_w 1034
    //   44: invokestatic 48	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 481	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: invokevirtual 910	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   53: aload_1
    //   54: iload_3
    //   55: invokestatic 136	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: aload_2
    //   59: new 483	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$FFMPEGResponseCallback
    //   62: dup
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_4
    //   68: invokespecial 486	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper$FFMPEGResponseCallback:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   71: invokestatic 1038	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:changeOrientationInVideo	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   74: aload 6
    //   76: monitorenter
    //   77: aload 6
    //   79: ldc2_w 493
    //   82: invokevirtual 498	java/lang/Object:wait	(J)V
    //   85: getstatic 19	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   88: new 27	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 1040
    //   98: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   104: lload 4
    //   106: lsub
    //   107: invokevirtual 962	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 48	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 7
    //   118: invokevirtual 506	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   121: istore_3
    //   122: aload 6
    //   124: monitorexit
    //   125: iload_3
    //   126: ireturn
    //   127: astore_1
    //   128: aload 6
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: getstatic 19	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   137: new 27	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 1042
    //   147: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 282	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 1043
    //   163: ireturn
    //   164: astore_1
    //   165: getstatic 19	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: new 27	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 1045
    //   178: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 511	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 282	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: monitorexit
    //   194: ldc_w 1046
    //   197: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	VideoCompositeHelper
    //   0	198	1	paramString1	String
    //   0	198	2	paramString2	String
    //   28	98	3	i	int
    //   3	102	4	l	long
    //   12	180	6	localObject	Object
    //   22	95	7	localAtomicInteger	AtomicInteger
    // Exception table:
    //   from	to	target	type
    //   77	85	127	finally
    //   85	125	127	finally
    //   128	131	127	finally
    //   165	194	127	finally
    //   47	74	133	java/lang/Exception
    //   77	85	164	java/lang/InterruptedException
  }
  
  private int b(String paramString1, String paramString2, int paramInt)
  {
    SLog.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] encode video file is too big, so need to compress to:" + paramInt);
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    long l1 = 0L;
    str = paramString2 + ".temp.mp4";
    for (;;)
    {
      try
      {
        SLog.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate!");
        FFmpegUtils.compressVideoWithBitrate(paramString2, str, paramInt, new VideoCompositeHelper.FFMPEGResponseCallback(localObject1, localAtomicInteger, 1));
      }
      catch (IOException localIOException)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localIOException);
        paramInt = 943001;
        continue;
      }
      catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localFFmpegCommandAlreadyRunningException);
        paramInt = 943002;
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait encode video exception:" + localInterruptedException);
        paramInt = 943003;
        continue;
        com.tencent.mobileqq.utils.FileUtils.e(str);
        int i = 0;
        continue;
      }
      try
      {
        localObject1.wait(180000L);
        paramInt = localAtomicInteger.get();
        SLog.c(jdField_a_of_type_JavaLangString, "compressVideoWithBitrate end!");
        if (paramInt == 0)
        {
          com.tencent.mobileqq.utils.FileUtils.e(paramString2);
          com.tencent.mobileqq.utils.FileUtils.c(str, paramString2);
          l1 = com.tencent.biz.qqstory.utils.FileUtils.a(paramString2);
          i = VideoUtils.c(paramString2);
          SLog.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " [improve_video_clear] ffmpeg compress encode video file size to:" + l1 + " video bitrate to:" + i);
          l2 = System.currentTimeMillis() - l2;
          SLog.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramString1 + " compressVideoByFFMPEG end errorCode:" + paramInt + " cost time=" + l2);
          StoryReportor.b("video_improve", "compress_video_2", 0, paramInt, new String[] { String.valueOf(i), String.valueOf(l2), String.valueOf(l1) });
          return paramInt;
        }
      }
      finally {}
    }
  }
  
  private static void b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
    {
      com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.mLocalRawVideoDir);
      SLog.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry);
    SLog.d(jdField_a_of_type_JavaLangString, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
  }
  
  private void b(String paramString)
  {
    try
    {
      SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " wait() ");
      wait(340000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  | " + paramString + " wait InterruptedException");
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    paramString = a(QQStoryContext.a().a().createEntityManager(), PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getGroupIdNoArgs(), new String[] { paramString });
    if (paramString == null) {
      return false;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      if (((PublishVideoEntry)paramString.next()).videoProcessState < paramInt) {
        return false;
      }
    }
    return true;
  }
  
  private int c(String paramString1, String paramString2)
  {
    int i = 0;
    SLog.d(jdField_a_of_type_JavaLangString, "encodePicToVideoWithFFmpeg");
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramString1)) {
      i = 940007;
    }
    Object localObject;
    AtomicInteger localAtomicInteger;
    String str;
    for (;;)
    {
      return i;
      localObject = new Object();
      localAtomicInteger = new AtomicInteger(942010);
      try
      {
        FFmpegUtils.convertPicToVideo(BaseApplicationImpl.getApplication(), paramString1, paramString2, new VideoCompositeHelper.FFMPEGResponseCallback(localObject, localAtomicInteger, 2));
        try
        {
          localObject.wait(300000L);
          int j = localAtomicInteger.get();
          if (j == 0) {
            continue;
          }
          SLog.d(jdField_a_of_type_JavaLangString, "Compress pic to video failed, trying to compress small pic. encodeRequest.get() = %d", new Object[] { Integer.valueOf(localAtomicInteger.get()) });
          str = paramString1 + ".small.jpeg";
          i = d(paramString1, str);
          if (i != 0)
          {
            SLog.e(jdField_a_of_type_JavaLangString, "resizeToSmallBitmap failed. nRetCode = " + i);
            return i;
          }
        }
        finally {}
        localAtomicInteger.set(942010);
      }
      catch (IOException paramString1)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942001;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942002;
      }
      catch (InterruptedException paramString1)
      {
        SLog.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
        return 942003;
      }
    }
    try
    {
      FFmpegUtils.convertPicToVideo(BaseApplicationImpl.getApplication(), str, paramString2, new VideoCompositeHelper.FFMPEGResponseCallback(localObject, localAtomicInteger, 2));
      try
      {
        localObject.wait(300000L);
        SLog.d(jdField_a_of_type_JavaLangString, "convertPicToVideo end");
        i = localAtomicInteger.get();
        return i;
      }
      finally {}
      return 942003;
    }
    catch (IOException paramString1)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
      return 942001;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
      return 942002;
    }
    catch (InterruptedException paramString1)
    {
      SLog.d(jdField_a_of_type_JavaLangString, "Wait convert pic exception:" + paramString1);
    }
  }
  
  private int d(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = BitmapManager.a(paramString1);
    int i;
    if (paramString1 == null)
    {
      SLog.e(jdField_a_of_type_JavaLangString, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
      i = 942007;
    }
    do
    {
      do
      {
        return i;
        i = paramString1.getHeight();
        int m = paramString1.getWidth();
        int k = i * 540 / m;
        i = k;
        if (k % 2 != 0) {
          i = k + 1;
        }
        if (m <= 540)
        {
          SLog.e(jdField_a_of_type_JavaLangString, "No need resize. srcWidth < destWidth, srcWidth = " + m + " destWidth = " + 540);
          return 942006;
        }
        Bitmap localBitmap = BitmapUtils.b(paramString1, 540, i, false, false);
        if (localBitmap == null)
        {
          SLog.e(jdField_a_of_type_JavaLangString, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
          return 942005;
        }
        if (!BitmapUtils.a(localBitmap, paramString2))
        {
          SLog.e(jdField_a_of_type_JavaLangString, "compressToFile in resizeToSmallBitmap failed");
          return 942008;
        }
        if ((localBitmap != null) && (!localBitmap.isRecycled())) {
          localBitmap.recycle();
        }
        i = j;
      } while (paramString1 == null);
      i = j;
    } while (paramString1.isRecycled());
    paramString1.recycle();
    return 0;
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    boolean bool = false;
    SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " start mergeMusic");
    if ((TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) || (MergeEditVideo.a(paramPublishVideoEntry)) || ((paramPublishVideoEntry.useSrcFile) && (!paramPublishVideoEntry.isMuteRecordVoice) && (!paramPublishVideoEntry.isMixOriginal))) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.tencent.biz.qqstory.utils.FileUtils.b(paramString1, paramString2);
      SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " noMerge end");
      paramVideoCompositeCallBack.a(0, "", paramString2);
      return;
    }
    VideoCompositeHelper.RetCode localRetCode = a(paramPublishVideoEntry);
    if ((localRetCode.a() != 0) || (!com.tencent.biz.qqstory.utils.FileUtils.b(paramPublishVideoEntry.backgroundMusicPath)))
    {
      SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " needAndStartDownloadMusic failed code:" + localRetCode.a() + ",msg:" + localRetCode.a());
      paramVideoCompositeCallBack.a(941000, localRetCode.a(), "");
      return;
    }
    long l = a(paramString1);
    if (l > 0L)
    {
      SLog.b(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " duration > 0 need to modify video duration from %d to %d", Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
      paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
    }
    if ((!paramPublishVideoEntry.isLocalPublish) || (a(paramString1))) {
      bool = true;
    }
    SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " detect mp4 whether has original Audio:" + bool);
    try
    {
      if ((paramPublishVideoEntry.isMixOriginal) && (bool))
      {
        SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " mixOriginalAndBackgroundMusic start");
        FFmpegUtils.mixOriginalAndBackgroundMusic(BaseApplicationImpl.getApplication(), paramString1, paramString2, paramPublishVideoEntry, paramBoolean, new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack));
        return;
      }
    }
    catch (Exception paramString2)
    {
      SLog.b(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " combine audio throw exception:", paramString2);
      com.tencent.biz.qqstory.utils.FileUtils.g(paramString1);
      paramVideoCompositeCallBack.a(941000, "combine audio exception", "");
      return;
    }
    if ((paramPublishVideoEntry.isLocalPublish) && (paramPublishVideoEntry.isPicture))
    {
      FFmpegUtils.combinBackgroundMusicWithVideCodecH264(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack));
      return;
    }
    SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "  recordVideo combinBackgroundMusic start");
    FFmpegUtils.combinBackgroundMusic(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new VideoCompositeHelper.MusicCallBack(paramString1, paramString2, paramVideoCompositeCallBack));
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    AssertUtils.a(paramPublishVideoEntry);
    AssertUtils.a(paramString);
    AssertUtils.a(paramVideoCompositeCallBack);
    SLog.d(jdField_a_of_type_JavaLangString, "composite create thread");
    ThreadManager.newFreeThread(new VideoCompositeHelper.1(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, paramVideoCompositeCallBack), "StoryVideoComposite", 5).start();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow]  doComposite from:" + paramPublishVideoEntry.businessId + "| fakeid:" + paramPublishVideoEntry.fakeVid + " doComposite start");
    paramPublishVideoEntry.isMixOriginal = paramPublishVideoEntry.getBooleanExtra("isMixOriginal", false);
    Object localObject = new File(QQStoryConstant.g);
    ((File)localObject).mkdirs();
    String str = localObject + File.separator + com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir) + ".mp4";
    int i;
    if ((paramPublishVideoEntry.isPicture) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
    {
      SLog.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodePicToVideo start");
      i = b(paramPublishVideoEntry, str);
      if ((i != 942014) && (i != 942007)) {
        break label1071;
      }
      localObject = "outOfMemory file info:" + BitmapUtils.a(paramPublishVideoEntry.mLocalRawVideoDir);
      SLog.d(jdField_a_of_type_JavaLangString, "memory info:%s", new Object[] { MagnifierSDK.a().a().c() });
    }
    for (;;)
    {
      long l1;
      int j;
      if (i != 0)
      {
        SLog.e(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + "[improve_video_clear] mediaCodec encode video failed:" + i);
        paramVideoCompositeCallBack.a(i, (String)localObject, paramString);
        return;
        if (QLog.isColorLevel()) {
          SLog.a(jdField_a_of_type_JavaLangString, "[improve_video_clear] record video (local file is %s)size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(VideoUtils.c(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
        }
        if ((paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
        {
          SLog.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeLocalVideo start");
          i = a(paramPublishVideoEntry, paramPublishVideoEntry.mLocalRawVideoDir, paramPublishVideoEntry.videoRangeStart, paramPublishVideoEntry.videoRangeEnd, paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry.videoUploadTempDir, str, paramPublishVideoEntry.isMuteRecordVoice, paramPublishVideoEntry.businessId);
          l1 = com.tencent.biz.qqstory.utils.FileUtils.a(str);
          int k = VideoUtils.c(str);
          SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " encode video info file size:" + l1 + " bitrate=" + k + " and upload limit=" + StoryConfigManager.c());
          if (paramPublishVideoEntry.businessId == 1)
          {
            if (StoryConfigManager.c())
            {
              j = 1;
              label533:
              StoryReportor.b("video_improve", "encode_video", j, i, new String[] { String.valueOf(k), String.valueOf(paramPublishVideoEntry.videoDuration), String.valueOf(l1) });
            }
          }
          else
          {
            long l2 = System.currentTimeMillis();
            j = i;
            if (i == 0)
            {
              j = i;
              if (paramPublishVideoEntry.videoDuration > 0L)
              {
                j = i;
                if (l1 > StoryConfigManager.c() / 10000 * paramPublishVideoEntry.videoDuration)
                {
                  i = StoryConfigManager.d();
                  j = b(paramPublishVideoEntry.fakeVid, str, i);
                  if (paramPublishVideoEntry.isCancel)
                  {
                    com.tencent.biz.qqstory.utils.FileUtils.g(str);
                    j = -20;
                  }
                }
              }
            }
            if (CaptureFreqMonitor.c) {
              CaptureFreqMonitor.g.a(4, System.currentTimeMillis() - l2);
            }
            i = j;
            localObject = "";
          }
        }
        else if (paramPublishVideoEntry.hwEncodeRecordVideo)
        {
          if ((!paramPublishVideoEntry.isLocalPublish) || (!paramPublishVideoEntry.getBooleanExtra("KEY_FROM_PIC_TO_VIDEO", false)) || (StringUtil.a(paramPublishVideoEntry.backgroundMusicPath))) {
            break label1065;
          }
          l1 = System.currentTimeMillis();
          SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo start");
          j = a(paramPublishVideoEntry);
          SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " convertImageToVideo end errorCode:" + j + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        }
      }
      for (;;)
      {
        i = j;
        if (j != 0) {
          break;
        }
        SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo start");
        l1 = System.currentTimeMillis();
        if (!paramPublishVideoEntry.isCancel) {
          j = a(paramPublishVideoEntry, str, paramBoolean1);
        }
        i = j;
        if (paramPublishVideoEntry.isCancel)
        {
          com.tencent.biz.qqstory.utils.FileUtils.g(str);
          i = -14;
        }
        SLog.c(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " hwEncodeRecordVideo end errorCode:" + i + " cost:" + (System.currentTimeMillis() - l1) + "ms");
        break;
        SLog.d(jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + paramPublishVideoEntry.fakeVid + " not hwEncode and encodeRecordVideoForAFVF start");
        j = a(paramPublishVideoEntry, str);
        i = j;
        if (j == 0) {
          break;
        }
        i = -13;
        break;
        j = 0;
        break label533;
        a(paramPublishVideoEntry, str, paramString, paramBoolean2, paramVideoCompositeCallBack);
        return;
        label1065:
        j = 0;
      }
      label1071:
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper
 * JD-Core Version:    0.7.0.1
 */