package com.tencent.biz.qqstory.base.videoupload;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import com.tencent.mobileqq.shortvideo.util.PicToVideoConverter;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import neo;
import nep;
import neq;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
public class VideoCompositeHelper
{
  public static String a = "Q.qqstory.publish.upload.VideoCompositeHelper";
  
  static
  {
    try
    {
      SLog.b(a, "LoadExtractedShortVideoSo :soLoadStatus=" + VideoEnvironment.a());
      int i = VideoEnvironment.a("AVCodec", null, true);
      SLog.b(a, "LoadExtractedShortVideoSo :code=" + i);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString)
  {
    CodecParam.y = (int)paramPublishVideoEntry.recordTime;
    CodecParam.z = paramPublishVideoEntry.recordFrames;
    CodecParam.J = paramPublishVideoEntry.saveMode;
    CodecParam.x = 0;
    CodecParam.E = 0;
    CodecParam.r = paramPublishVideoEntry.videoMaxrate;
    CodecParam.s = paramPublishVideoEntry.videoMinrate;
    CodecParam.K = 0;
    if (paramPublishVideoEntry.businessId == 2) {}
    for (i = 0;; i = 1)
    {
      CodecParam.D = i;
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
        SLog.d(a, "version = %d", new Object[] { Integer.valueOf(k) });
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
        SLog.b(a, "this is part video encode start %d end %d, audio start %d end %d", Long.valueOf(l1), Long.valueOf(l6), Long.valueOf(l5), Long.valueOf(l2));
        l4 = l6;
        l6 = l2;
        if ((paramPublishVideoEntry.hwEncodeRecordVideo) || (TextUtils.isEmpty(paramPublishVideoEntry.mIFrameVideoPath)) || (!com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mIFrameVideoPath, paramString))) {
          break label677;
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
        SLog.d(a, "EncodeLocalVideo: Change need rotation. inputVideoPath = " + paramString + " rotateFilePath = " + (String)localObject);
        com.tencent.biz.qqstory.utils.FileUtils.b((String)localObject, paramString);
      }
      k = VideoEnvironment.b();
      if (k <= 28) {
        break label625;
      }
      SLog.d(a, "version is %d", new Object[] { Integer.valueOf(k) });
      l2 = com.tencent.biz.qqstory.utils.FileUtils.c(paramString);
      SLog.b(a, "file size %d, file %s", Long.valueOf(l2), paramString);
      k = i;
      if (l2 > 2097152L)
      {
        k = i;
        if (j == 0)
        {
          k = i;
          if (com.tencent.biz.qqstory.utils.FileUtils.g(paramString))
          {
            CodecParam.K = 1;
            i = CodecParam.r;
            CodecParam.r = 1677720;
            k = a(paramPublishVideoEntry.mLocalRawVideoDir, l1, l4, l5, l6, paramPublishVideoEntry.mMosaicMask, paramPublishVideoEntry.mMosaicSize, paramPublishVideoEntry.isMuteRecordVoice, paramString);
            l1 = com.tencent.biz.qqstory.utils.FileUtils.c(paramString);
            SLog.d(a, "fix bitrate file size %d, orig bitrate:%d, file %s", new Object[] { Long.valueOf(l1), Integer.valueOf(i), paramString });
            CodecParam.K = 0;
            CodecParam.r = i;
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
        SLog.d(a, "EncodeLocalVideo: Change need rotation. inputVideoPath=%s  rotateFilePath=%s", new Object[] { paramString1, paramPublishVideoEntry });
        com.tencent.biz.qqstory.utils.FileUtils.b(paramPublishVideoEntry, paramString3);
      }
    }
    else
    {
      return paramInt1;
    }
    SLog.e(a, "EncodeLocalVideo: not rotate retcode =" + paramInt2);
    return paramInt1;
  }
  
  private int a(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean)
  {
    String str = paramPublishVideoEntry.videoUploadTempDir + "hwtemp.mp4";
    int i = b(paramPublishVideoEntry, paramString, paramBoolean);
    if (i != 0) {}
    for (;;)
    {
      return i;
      i = a(paramString, str);
      if (i == 0)
      {
        SLog.d(a, "set moov in front of file success. targetMergedTempMp4 = " + str);
        com.tencent.biz.qqstory.utils.FileUtils.b(str, paramString);
      }
      while (AudioHelper.a())
      {
        i = VideoCompositeManager.a(paramString);
        if (i != 0) {
          break label187;
        }
        SLog.d(a, "isHuaweiGreen: reEncodeVideoWithFFMpeg succeed. output path = " + paramString);
        return i;
        SLog.d(a, "set moov in front of file fail %d", new Object[] { Integer.valueOf(i) });
        SLog.b(a, "set moov in front of file failed targetFile = " + paramString);
        i = 0;
      }
    }
    label187:
    SLog.e(a, "isHuaweiGreen: reEncodeVideoWithFFMpeg failed. errorCode = " + i);
    return i;
  }
  
  private int a(String paramString, int paramInt)
  {
    SLog.d(a, "[improve_video_clear] encode video file is too big, so need to compress to:" + paramInt);
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    long l1 = 0L;
    str = paramString + ".temp.mp4";
    for (;;)
    {
      try
      {
        FFmpegUtils.a(paramString, str, paramInt, new nep(localObject1, localAtomicInteger, 1));
      }
      catch (IOException localIOException)
      {
        SLog.d(a, "Wait encode video exception:" + localIOException);
        paramInt = 943001;
        continue;
      }
      catch (FFmpegCommandAlreadyRunningException localFFmpegCommandAlreadyRunningException)
      {
        SLog.d(a, "Wait encode video exception:" + localFFmpegCommandAlreadyRunningException);
        paramInt = 943002;
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
        SLog.d(a, "Wait encode video exception:" + localInterruptedException);
        paramInt = 943003;
        continue;
        com.tencent.mobileqq.utils.FileUtils.d(str);
        int i = 0;
        continue;
      }
      try
      {
        localObject1.wait(180000L);
        paramInt = localAtomicInteger.get();
        if (paramInt == 0)
        {
          com.tencent.mobileqq.utils.FileUtils.d(paramString);
          com.tencent.mobileqq.utils.FileUtils.c(str, paramString);
          l1 = com.tencent.biz.qqstory.utils.FileUtils.a(paramString);
          i = VideoUtils.c(paramString);
          SLog.d(a, "[improve_video_clear] ffmpeg compress encode video file size to:" + l1 + " video bitrate to:" + i);
          l2 = System.currentTimeMillis() - l2;
          SLog.d(a, "[improve_video_clear] ffmpeg compress file result=" + paramInt + " cost time=" + l2);
          StoryReportor.b("video_improve", "compress_video_2", 0, paramInt, new String[] { String.valueOf(i), String.valueOf(l2), String.valueOf(l1) });
          return paramInt;
        }
      }
      finally {}
    }
  }
  
  private static int a(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    int m = ((Integer)localStoryConfigManager.b("key_encode_crf", Integer.valueOf(23))).intValue();
    int i = CodecParam.t;
    int j = CodecParam.u;
    int k = CodecParam.v;
    int n = ((Integer)localStoryConfigManager.b("key_encode_qmax", Integer.valueOf(CodecParam.t))).intValue();
    int i1 = ((Integer)localStoryConfigManager.b("key_encode_qmin", Integer.valueOf(CodecParam.u))).intValue();
    int i2 = ((Integer)localStoryConfigManager.b("key_encode_qdiff", Integer.valueOf(CodecParam.v))).intValue();
    CodecParam.C = m;
    CodecParam.t = 35;
    CodecParam.u = i1;
    CodecParam.v = i2;
    SLog.d(a, "story encode param crf=%d, qmax=%d->%d, qmin=%d->%d, qdiff=>%d->%d", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2) });
    try
    {
      paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
      paramString1.a(false);
      paramString1.b(false);
      paramString1.d(paramBoolean);
      paramString1.a(paramLong1, paramLong2, paramLong3, paramLong4);
      if (paramArrayOfByte != null) {
        paramString1.a(paramArrayOfByte, paramInt);
      }
      paramString1.run();
      paramInt = paramString1.a;
      return paramInt;
    }
    finally
    {
      CodecParam.C = 23;
      CodecParam.t = i;
      CodecParam.u = j;
      CodecParam.v = k;
    }
  }
  
  private static int a(String paramString1, String paramString2)
  {
    Object localObject = new Object();
    AtomicInteger localAtomicInteger = new AtomicInteger(-1);
    long l = System.currentTimeMillis();
    SLog.d(a, "Set time stamp to video. ");
    try
    {
      FFmpegUtils.a(BaseApplicationImpl.getApplication(), paramString1, paramString2, new nep(localObject, localAtomicInteger, 3));
      try
      {
        localObject.wait(180000L);
        SLog.d(a, "end set moov and time stamp, take time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        int i = localAtomicInteger.get();
        return i;
      }
      finally {}
      return 953004;
    }
    catch (IOException paramString1)
    {
      SLog.d(a, "Wait encode video exception:" + paramString1);
      return 945002;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      SLog.d(a, "Wait encode video exception:" + paramString1);
      return 953003;
    }
    catch (InterruptedException paramString1)
    {
      SLog.d(a, "Wait encode video exception:" + paramString1);
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    SLog.d(a, "videoSynthesis start");
    long l = SystemClock.elapsedRealtime();
    Object localObject = new com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    if (paramBoolean) {
      ((com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject).a();
    }
    ((com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject).b(paramPublishVideoEntry.hwBitrateMode);
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      ((com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject).c(8);
      SLog.b(a, "codec high profile is enable when story video encode");
    }
    if (StoryConfigManager.d())
    {
      SLog.d(a, "story debug mode is enable");
      localObject = (StoryConfigManager)SuperManager.a(10);
      i = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
      int j = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
      paramBoolean = ((Boolean)((StoryConfigManager)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
      paramPublishVideoEntry = new com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam(i * 1000, paramPublishVideoEntry);
      paramPublishVideoEntry.a();
      paramPublishVideoEntry.b(j);
      localObject = paramPublishVideoEntry;
      if (paramBoolean)
      {
        paramPublishVideoEntry.c(8);
        localObject = paramPublishVideoEntry;
      }
    }
    int i = new com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo().a(paramString1, paramString2, (com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject);
    SLog.d(a, "[videoSynthesis]generate files|first step cost:" + (SystemClock.elapsedRealtime() - l) / 1000.0D);
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
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("RAM Info:all=");
    Object localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.0");
    try
    {
      long l1 = DeviceInfoUtil.e() / 1024L / 1024L;
      long l2 = DeviceInfoUtil.f() / 1024L / 1024L;
      Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
      float f2 = -1.0F;
      float f1 = f2;
      if (arrayOfMemoryInfo != null)
      {
        f1 = f2;
        if (arrayOfMemoryInfo.length > 0) {
          f1 = arrayOfMemoryInfo[0].getTotalPss() / 1024.0F;
        }
      }
      f2 = (float)Runtime.getRuntime().freeMemory() / 1024.0F / 1024.0F;
      float f3 = (float)Runtime.getRuntime().totalMemory() / 1024.0F / 1024.0F;
      float f4 = (float)Runtime.getRuntime().maxMemory() / 1024.0F / 1024.0F;
      localStringBuilder.append(l1).append("M,avaiable:").append(l2).append("M used:").append(((DecimalFormat)localObject).format(f1)).append("M freeMemory:").append(f2).append("M,appTotalMemory:").append(f3).append("M,maxMemory:").append(f4).append("M, ImgCache:").append(BaseApplicationImpl.sImageCache.size() / 1024 / 1024).append("M,SkinCache:").append(SkinEngine.dumpDrawableCacheMemSize() / 1024L / 1024L).append("M,LeakMonitor=").append(MemoryReporter.a().jdField_a_of_type_Boolean);
      localObject = (ArrayList)MemoryReporter.jdField_a_of_type_JavaUtilArrayList.clone();
      if (((ArrayList)localObject).size() > 0)
      {
        localStringBuilder.append(",Leaked=[");
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          localStringBuilder.append((String)((Iterator)localObject).next());
          localStringBuilder.append(",");
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable) {}
    for (;;)
    {
      localStringBuilder.append("]");
    }
  }
  
  public static List a(EntityManager paramEntityManager, Class paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public static void a(PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramPublishVideoEntry.businessId == 2)
    {
      SLog.b(a, "deleteVideoCache ignore because business id is qq");
      return;
    }
    if ((!paramPublishVideoEntry.isLocalPublish) && (!TextUtils.isEmpty(paramPublishVideoEntry.mLocalRawVideoDir)) && (!paramPublishVideoEntry.mLocalRawVideoDir.contains(Environment.DIRECTORY_DCIM)))
    {
      if (paramPublishVideoEntry.hasFragments) {
        break label193;
      }
      b(paramPublishVideoEntry);
    }
    for (;;)
    {
      if (paramPublishVideoEntry.isPicture) {
        QQStoryContext.a().a().sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
      }
      com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.videoUploadTempDir);
      SLog.d(a, "delete file:%s", new Object[] { paramPublishVideoEntry.videoUploadTempDir });
      if ((!StoryDepends.a()) || (!paramPublishVideoEntry.getBooleanExtra("split_music", false))) {
        break;
      }
      com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.backgroundMusicPath);
      SLog.d(a, "delete music file :" + paramPublishVideoEntry.backgroundMusicPath);
      return;
      label193:
      a(paramPublishVideoEntry.fakeVid, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC);
      if (b(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_UPLOAD_SUC))
      {
        SLog.d(a, "groupId=%s all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
        b(paramPublishVideoEntry);
      }
      else
      {
        SLog.d(a, "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
      }
    }
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramString = a(paramString);
    paramString.videoProcessState = paramInt;
    return localEntityManager.a(paramString);
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
          SLog.d(a, "convert picture to video by mediaCodec error. use ffmepg to convert again.");
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
    File localFile = new File(paramString1);
    paramString2 = paramString2 + "compressed_" + localFile.getName();
    boolean bool;
    if ((!Build.MODEL.equalsIgnoreCase("HUAWEI NXT-AL10")) && (!Build.MODEL.equalsIgnoreCase("HUAWEI MT7-TL00")))
    {
      bool = true;
      if (!bool) {
        SLog.e(a, "encode local video incompatible: model = " + Build.MODEL + " compatible = " + bool);
      }
      paramPublishVideoEntry = new VideoCompositeHelper.HWCompressProcessor(paramPublishVideoEntry, paramString2, paramInt3, paramInt1, paramInt2, paramBoolean, true, paramInt4);
      VideoConverter localVideoConverter = new VideoConverter();
      if ((!bool) || (!localVideoConverter.a(localFile, paramPublishVideoEntry, true)) || (paramPublishVideoEntry.a != null)) {
        break label214;
      }
      if (a(paramString2, paramString3) != 0) {
        break label203;
      }
      com.tencent.biz.qqstory.utils.FileUtils.g(paramString2);
    }
    for (;;)
    {
      return 0;
      bool = false;
      break;
      label203:
      com.tencent.biz.qqstory.utils.FileUtils.b(paramString2, paramString3);
    }
    label214:
    paramPublishVideoEntry = new Object();
    paramString2 = new AtomicInteger(-1);
    try
    {
      FFmpegUtils.a(BaseApplicationImpl.getApplication(), paramString1, paramInt1, paramInt2 - paramInt1, paramInt3, paramBoolean, paramString3, new nep(paramPublishVideoEntry, paramString2, 1));
      try
      {
        paramPublishVideoEntry.wait(180000L);
        paramInt1 = paramString2.get();
        return paramInt1;
      }
      finally {}
      return 943003;
    }
    catch (IOException paramPublishVideoEntry)
    {
      SLog.d(a, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943001;
    }
    catch (FFmpegCommandAlreadyRunningException paramPublishVideoEntry)
    {
      SLog.d(a, "Wait encode video exception:" + paramPublishVideoEntry);
      return 943002;
    }
    catch (InterruptedException paramPublishVideoEntry)
    {
      SLog.d(a, "Wait encode video exception:" + paramPublishVideoEntry);
    }
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
    int j;
    if (!com.tencent.biz.qqstory.utils.FileUtils.c(str1)) {
      j = 940007;
    }
    String str3;
    long l1;
    do
    {
      return j;
      str2 = paramPublishVideoEntry.videoUploadTempDir + "_merge_video_x.mp4";
      str3 = paramPublishVideoEntry.videoUploadTempDir + "_merged_video_x.mp4";
      l1 = SystemClock.elapsedRealtime();
      if (paramPublishVideoEntry.businessId != 1) {
        break;
      }
      i = b(str1, str2, paramPublishVideoEntry, paramBoolean);
      if (i == 0) {
        break label907;
      }
      j = i;
    } while (i != -1);
    Object localObject = new File(str2);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    com.tencent.biz.qqstory.utils.FileUtils.c(str1, str2);
    int i = 0;
    label907:
    for (;;)
    {
      SLog.d(a, "hwEncodeRecordVideo mediaCodec trim video cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l1) });
      long l2 = a(paramPublishVideoEntry.mLocalRawVideoDir);
      l1 = SystemClock.elapsedRealtime();
      if ((!TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath)) && (com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.backgroundMusicPath))) {
        j = 1;
      }
      for (;;)
      {
        if ((!paramPublishVideoEntry.isMuteRecordVoice) && (j == 0) && (!TextUtils.isEmpty(paramPublishVideoEntry.mAudioFilePath)))
        {
          if (!com.tencent.biz.qqstory.utils.FileUtils.c(paramPublishVideoEntry.mAudioFilePath))
          {
            com.tencent.biz.qqstory.utils.FileUtils.b(str2, paramString);
            return 0;
            i = a(str1, str2, paramPublishVideoEntry, paramBoolean);
            break;
            j = 0;
            continue;
          }
          SLog.d(a, "trim audio");
          localObject = paramPublishVideoEntry.videoUploadTempDir + l1 + "_segment_mc_audio";
          i = AudioDataUtil.a(paramPublishVideoEntry.mAudioFilePath, (String)localObject, paramPublishVideoEntry.videoRangeStart * 1.0F / (float)l2, paramPublishVideoEntry.videoRangeEnd * 1.0F / (float)l2);
          if (i != 0)
          {
            SLog.d(a, "mediacodec AudioEncoder.clipAudioFile: errcode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            StoryReportor.b("publish_story", "clip_audio", 1, i, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            com.tencent.biz.qqstory.utils.FileUtils.b(str2, paramString);
            return 0;
          }
          i = AudioEncoder.a((String)localObject);
          if (i != 0)
          {
            SLog.d(a, "checkSourceAudioIsOK: errorCode=%s, rangeStart=%s, rangeEnd=%s, duration=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramPublishVideoEntry.videoRangeStart), Integer.valueOf(paramPublishVideoEntry.videoRangeEnd), Long.valueOf(l2) });
            StoryReportor.b("publish_story", "clip_audio", 1, i, new String[] { "rangeStart=" + paramPublishVideoEntry.videoRangeStart + " rangeEnd=" + paramPublishVideoEntry.videoRangeEnd + " duration=" + l2 });
            com.tencent.biz.qqstory.utils.FileUtils.b(str2, paramString);
            return 0;
          }
          SLog.d(a, "audio to mp4");
          str1 = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          if (paramPublishVideoEntry.saveMode <= 5) {}
          for (i = paramPublishVideoEntry.saveMode;; i = 0)
          {
            paramPublishVideoEntry = AudioEncoder.a(null, null, i);
            paramPublishVideoEntry.b = str1;
            paramPublishVideoEntry.a = ((String)localObject);
            i = AudioEncoder.a(paramPublishVideoEntry);
            if (i == 0) {
              break;
            }
            SLog.d(a, "mediacodec AudioEncoder.encodeSafely: errorCode=%s", new Object[] { Integer.valueOf(i) });
            return i;
          }
          paramPublishVideoEntry = new File((String)localObject);
          if (paramPublishVideoEntry.exists()) {
            paramPublishVideoEntry.delete();
          }
          SLog.d(a, "video audio mp4");
          l2 = SystemClock.elapsedRealtime();
          com.tencent.biz.qqstory.utils.FileUtils.g(str3);
          i = HwVideoMerge.a(str2, str1, str3, 0);
          SLog.d(a, "[HwVideoMerge.merge]cost=%s", new Object[] { Long.valueOf(SystemClock.elapsedRealtime() - l2) });
          if (i != 0)
          {
            SLog.d(a, "HwVideoMerge->merge: errorCode=%s", new Object[] { Integer.valueOf(i) });
            return i;
          }
          SLog.a(a, "mediacodec encode audio time cost=%s", Long.valueOf(SystemClock.elapsedRealtime() - l1));
        }
      }
      for (paramPublishVideoEntry = str3;; paramPublishVideoEntry = str2)
      {
        com.tencent.biz.qqstory.utils.FileUtils.b(paramPublishVideoEntry, paramString);
        return i;
      }
    }
  }
  
  /* Error */
  private int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 4	java/lang/Object
    //   8: dup
    //   9: invokespecial 58	java/lang/Object:<init>	()V
    //   12: astore 6
    //   14: new 294	java/util/concurrent/atomic/AtomicInteger
    //   17: dup
    //   18: iconst_m1
    //   19: invokespecial 297	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   22: astore 7
    //   24: aload_1
    //   25: invokestatic 956	com/tencent/biz/qqstory/utils/VideoUtils:a	(Ljava/lang/String;)I
    //   28: istore_3
    //   29: iload_3
    //   30: iconst_m1
    //   31: if_icmpne +7 -> 38
    //   34: ldc_w 957
    //   37: ireturn
    //   38: getstatic 17	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:a	Ljava/lang/String;
    //   41: ldc_w 959
    //   44: invokestatic 46	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: invokestatic 443	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: invokevirtual 963	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   53: aload_1
    //   54: iload_3
    //   55: invokestatic 350	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: aload_2
    //   59: new 301	nep
    //   62: dup
    //   63: aload 6
    //   65: aload 7
    //   67: iconst_4
    //   68: invokespecial 304	nep:<init>	(Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicInteger;I)V
    //   71: invokestatic 966	com/tencent/biz/qqstory/utils/ffmpeg/FFmpegUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/qqstory/utils/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   74: aload 6
    //   76: monitorenter
    //   77: aload 6
    //   79: ldc2_w 310
    //   82: invokevirtual 315	java/lang/Object:wait	(J)V
    //   85: getstatic 17	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:a	Ljava/lang/String;
    //   88: new 19	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 968
    //   98: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokestatic 292	java/lang/System:currentTimeMillis	()J
    //   104: lload 4
    //   106: lsub
    //   107: invokevirtual 335	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 46	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 7
    //   118: invokevirtual 318	java/util/concurrent/atomic/AtomicInteger:get	()I
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
    //   134: getstatic 17	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:a	Ljava/lang/String;
    //   137: new 19	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   144: ldc_w 970
    //   147: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 202	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: ldc_w 971
    //   163: ireturn
    //   164: astore_1
    //   165: getstatic 17	com/tencent/biz/qqstory/base/videoupload/VideoCompositeHelper:a	Ljava/lang/String;
    //   168: new 19	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   175: ldc_w 973
    //   178: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload_1
    //   182: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 202	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 6
    //   193: monitorexit
    //   194: ldc_w 974
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
  
  private int b(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    SLog.d(a, "videoSynthesisForStory start");
    long l = SystemClock.elapsedRealtime();
    Object localObject = new dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam(paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry);
    if (paramBoolean) {
      ((dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject).a();
    }
    ((dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject).b(paramPublishVideoEntry.hwBitrateMode);
    if (paramPublishVideoEntry.isNeedHighProfile)
    {
      ((dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject).c(8);
      SLog.b(a, "codec high profile is enable when story video encode");
    }
    if (StoryConfigManager.d())
    {
      SLog.d(a, "story debug mode is enable");
      localObject = (StoryConfigManager)SuperManager.a(10);
      i = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
      int j = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(-1))).intValue();
      paramBoolean = ((Boolean)((StoryConfigManager)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
      dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam localEditParam = new dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam(i * 1000, paramPublishVideoEntry);
      localEditParam.a();
      localEditParam.b(j);
      localObject = localEditParam;
      if (paramBoolean)
      {
        localEditParam.c(8);
        localObject = localEditParam;
      }
    }
    int i = new dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo().a(paramString1, paramString2, (dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam)localObject, paramPublishVideoEntry);
    SLog.d(a, "[videoSynthesis]generate files|first step cost:" + (SystemClock.elapsedRealtime() - l) / 1000.0D);
    return i;
  }
  
  private static void b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory())
    {
      com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry.mLocalRawVideoDir);
      SLog.d(a, "delete filePath: %s", new Object[] { paramPublishVideoEntry.mLocalRawVideoDir });
      return;
    }
    int i = paramPublishVideoEntry.mLocalRawVideoDir.lastIndexOf("/");
    paramPublishVideoEntry = paramPublishVideoEntry.mLocalRawVideoDir.substring(0, i);
    com.tencent.biz.qqstory.utils.FileUtils.d(paramPublishVideoEntry);
    SLog.d(a, "delete filePath: %s", new Object[] { paramPublishVideoEntry });
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
    SLog.d(a, "encodePicToVideoWithFFmpeg");
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
        FFmpegUtils.b(BaseApplicationImpl.getApplication(), paramString1, paramString2, new nep(localObject, localAtomicInteger, 2));
        try
        {
          localObject.wait(300000L);
          int j = localAtomicInteger.get();
          if (j == 0) {
            continue;
          }
          SLog.d(a, "Compress pic to video failed, trying to compress small pic. encodeRequest.get() = %d", new Object[] { Integer.valueOf(localAtomicInteger.get()) });
          str = paramString1 + ".small.jpeg";
          i = d(paramString1, str);
          if (i != 0)
          {
            SLog.e(a, "resizeToSmallBitmap failed. nRetCode = " + i);
            return i;
          }
        }
        finally {}
        localAtomicInteger.set(942010);
      }
      catch (IOException paramString1)
      {
        SLog.d(a, "Wait convert pic exception:" + paramString1);
        return 942001;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        SLog.d(a, "Wait convert pic exception:" + paramString1);
        return 942002;
      }
      catch (InterruptedException paramString1)
      {
        SLog.d(a, "Wait convert pic exception:" + paramString1);
        return 942003;
      }
    }
    try
    {
      FFmpegUtils.b(BaseApplicationImpl.getApplication(), str, paramString2, new nep(localObject, localAtomicInteger, 2));
      try
      {
        localObject.wait(300000L);
        SLog.d(a, "convertPicToVideo end");
        i = localAtomicInteger.get();
        return i;
      }
      finally {}
      return 942003;
    }
    catch (IOException paramString1)
    {
      SLog.d(a, "Wait convert pic exception:" + paramString1);
      return 942001;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      SLog.d(a, "Wait convert pic exception:" + paramString1);
      return 942002;
    }
    catch (InterruptedException paramString1)
    {
      SLog.d(a, "Wait convert pic exception:" + paramString1);
    }
  }
  
  private int d(String paramString1, String paramString2)
  {
    int j = 0;
    paramString1 = BitmapManager.a(paramString1);
    int i;
    if (paramString1 == null)
    {
      SLog.e(a, "BitmapManager.decodeFile in resizeToSmallBitmap failed");
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
          SLog.e(a, "No need resize. srcWidth < destWidth, srcWidth = " + m + " destWidth = " + 540);
          return 942006;
        }
        Bitmap localBitmap = BitmapUtils.a(paramString1, 540, i, false, false);
        if (localBitmap == null)
        {
          SLog.e(a, "resizeAndFillBitmapEdge in resizeToSmallBitmap failed");
          return 942005;
        }
        if (!BitmapUtils.a(localBitmap, paramString2))
        {
          SLog.e(a, "compressToFile in resizeToSmallBitmap failed");
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
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, @NonNull VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    if (paramPublishVideoEntry.businessId == 1)
    {
      a(paramPublishVideoEntry, paramString, false, true, paramVideoCompositeCallBack);
      return;
    }
    a(paramPublishVideoEntry, paramString, true, true, paramVideoCompositeCallBack);
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String paramString1, String paramString2, boolean paramBoolean, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    if (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath))
    {
      com.tencent.biz.qqstory.utils.FileUtils.b(paramString1, paramString2);
      paramVideoCompositeCallBack.a(0, "", paramString2);
      return;
    }
    long l = a(paramString1);
    if (l > 0L)
    {
      SLog.b(a, "modify video duration from %d to %d", Integer.valueOf(paramPublishVideoEntry.backgroundMusicDuration), Long.valueOf(l));
      paramPublishVideoEntry.backgroundMusicDuration = ((int)Math.min(paramPublishVideoEntry.backgroundMusicDuration, l));
    }
    try
    {
      if ((paramPublishVideoEntry.isLocalPublish) && (paramPublishVideoEntry.isPicture))
      {
        FFmpegUtils.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, new neq(paramString1, paramString2, paramVideoCompositeCallBack));
        return;
      }
    }
    catch (Exception paramPublishVideoEntry)
    {
      SLog.b(a, "combine audio throw exception:", paramPublishVideoEntry);
      com.tencent.biz.qqstory.utils.FileUtils.g(paramString1);
      paramVideoCompositeCallBack.a(941000, "combine audio exception", "");
      return;
    }
    FFmpegUtils.a(BaseApplicationImpl.getApplication(), paramString1, paramPublishVideoEntry.backgroundMusicPath, paramPublishVideoEntry.backgroundMusicOffset, paramPublishVideoEntry.backgroundMusicDuration, paramString2, paramBoolean, new neq(paramString1, paramString2, paramVideoCompositeCallBack));
  }
  
  public void a(@NonNull PublishVideoEntry paramPublishVideoEntry, @NonNull String paramString, boolean paramBoolean1, boolean paramBoolean2, @NonNull VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    AssertUtils.a(paramPublishVideoEntry);
    AssertUtils.a(paramString);
    AssertUtils.a(paramVideoCompositeCallBack);
    SLog.d(a, "composite create thread");
    ThreadManager.newFreeThread(new neo(this, paramPublishVideoEntry, paramString, paramBoolean1, paramBoolean2, paramVideoCompositeCallBack), "StoryVideoComposite", 5).start();
  }
  
  public void b(PublishVideoEntry paramPublishVideoEntry, String paramString, boolean paramBoolean1, boolean paramBoolean2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    SLog.d(a, "doComposite from:" + paramPublishVideoEntry.businessId);
    Object localObject = new File(QQStoryConstant.e);
    ((File)localObject).mkdirs();
    String str = localObject + File.separator + com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir) + ".mp4";
    int i;
    if ((paramPublishVideoEntry.isPicture) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
    {
      i = b(paramPublishVideoEntry, str);
      if ((i != 942014) && (i != 942007)) {
        break label573;
      }
      localObject = "outOfMemory file info:" + BitmapUtils.a(paramPublishVideoEntry.mLocalRawVideoDir);
      SLog.d(a, "memory info:%s", new Object[] { a() });
    }
    for (;;)
    {
      if (i != 0)
      {
        SLog.e(a, "[improve_video_clear] mediaCodec encode video failed:" + i);
        paramVideoCompositeCallBack.a(i, (String)localObject, paramString);
        return;
        if (QLog.isColorLevel()) {
          SLog.a(a, "[improve_video_clear] record video (local file is %s)size=%s, bitrate=%s and need to encode to bitrate=%s", Boolean.valueOf(paramPublishVideoEntry.isLocalPublish), Long.valueOf(com.tencent.biz.qqstory.utils.FileUtils.a(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(VideoUtils.c(paramPublishVideoEntry.mLocalRawVideoDir)), Integer.valueOf(paramPublishVideoEntry.videoMaxrate));
        }
        label317:
        long l;
        int k;
        if ((paramPublishVideoEntry.isLocalPublish) && (!paramPublishVideoEntry.hwEncodeRecordVideo))
        {
          i = a(paramPublishVideoEntry, paramPublishVideoEntry.mLocalRawVideoDir, paramPublishVideoEntry.videoRangeStart, paramPublishVideoEntry.videoRangeEnd, paramPublishVideoEntry.videoMaxrate, paramPublishVideoEntry.videoUploadTempDir, str, paramPublishVideoEntry.isMuteRecordVoice, paramPublishVideoEntry.businessId);
          l = com.tencent.biz.qqstory.utils.FileUtils.a(str);
          k = VideoUtils.c(str);
          SLog.d(a, "[improve_video_clear] encode video file size:" + l + " bitrate=" + k + " and upload limit=" + StoryConfigManager.c());
          if (paramPublishVideoEntry.businessId != 1) {
            break label565;
          }
          if (!StoryConfigManager.b()) {
            break label546;
          }
        }
        label546:
        for (int j = 1;; j = 0)
        {
          StoryReportor.b("video_improve", "encode_video", j, i, new String[] { String.valueOf(k), String.valueOf(paramPublishVideoEntry.videoDuration), String.valueOf(l) });
          if ((i != 0) || (paramPublishVideoEntry.videoDuration <= 0L) || (l <= StoryConfigManager.c() / 10000 * paramPublishVideoEntry.videoDuration)) {
            break label565;
          }
          i = a(str, StoryConfigManager.d());
          localObject = "";
          break;
          if (paramPublishVideoEntry.hwEncodeRecordVideo)
          {
            i = a(paramPublishVideoEntry, str, paramBoolean1);
            SLog.d(a, "hwEncodeRecordVideo end, errorCode:%d", new Object[] { Integer.valueOf(i) });
            break label317;
          }
          i = a(paramPublishVideoEntry, str);
          break label317;
        }
      }
      else
      {
        a(paramPublishVideoEntry, str, paramString, paramBoolean2, paramVideoCompositeCallBack);
        return;
      }
      label565:
      localObject = "";
      continue;
      label573:
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper
 * JD-Core Version:    0.7.0.1
 */