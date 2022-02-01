package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.utils.ExtractPCMFromFile;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.mobileqq.videocodec.mediacodec.Mp4ReEncoder;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EncodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VideoToVideo
  extends ToVideoConverter
{
  long a;
  private Mp4ReEncoder b;
  private final Object c = new Object();
  
  private void a(DecodeConfig paramDecodeConfig, EncodeConfig paramEncodeConfig, int paramInt)
  {
    if (paramInt != 0)
    {
      paramEncodeConfig.m = paramInt;
      paramEncodeConfig.l = 0;
    }
    paramInt = Math.min(paramEncodeConfig.c, paramEncodeConfig.d);
    int i = Math.max(paramEncodeConfig.c, paramEncodeConfig.d);
    paramEncodeConfig.c = paramInt;
    paramEncodeConfig.d = i;
    paramDecodeConfig.width = paramEncodeConfig.c;
    paramDecodeConfig.height = paramEncodeConfig.d;
  }
  
  private boolean c(SlideShowProcessor.ConvertContext paramConvertContext)
  {
    if (paramConvertContext.g) {
      return false;
    }
    return paramConvertContext.h;
  }
  
  public void a(SlideShowProcessor.ConvertContext paramConvertContext)
  {
    if (paramConvertContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "error currContext is null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[runLocalVideo2Video]run begin, taskid:");
      ((StringBuilder)localObject1).append(paramConvertContext.k);
      ((StringBuilder)localObject1).append(" run:");
      ((StringBuilder)localObject1).append(paramConvertContext.j);
      QLog.d("VideoToVideo", 2, ((StringBuilder)localObject1).toString());
    }
    if (a(paramConvertContext))
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramConvertContext.a, null, null, paramConvertContext.e, paramConvertContext);
      return;
    }
    Object localObject1 = new File(Image2Video.b);
    if (!((File)localObject1).exists())
    {
      bool = ((File)localObject1).mkdirs();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("runLocalVideo2Video, createDir:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject1).toString());
      }
    }
    Object localObject2 = new File(paramConvertContext.a).getName();
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = ((String)localObject2).replace(".", "_");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".mp4");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Image2Video.b);
    ((StringBuilder)localObject2).append((String)localObject1);
    this.f = ((StringBuilder)localObject2).toString();
    FileUtils.k(this.f);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.f);
    ((StringBuilder)localObject1).append(".dat");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (FileUtils.i((String)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("before,getPCMFromFile[Have audio File]:  ");
        ((StringBuilder)localObject2).append(paramConvertContext.k);
        ((StringBuilder)localObject2).append(" audioPath: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" audioFileSize=");
        ((StringBuilder)localObject2).append(FileUtil.f((String)localObject1));
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new ExtractPCMFromFile();
      l1 = System.currentTimeMillis();
      ((ExtractPCMFromFile)localObject2).a(paramConvertContext.a, paramConvertContext.e);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("run,getMetaDataFromFile:  ");
        ((StringBuilder)localObject2).append(paramConvertContext.k);
        ((StringBuilder)localObject2).append(" cost=");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((StringBuilder)localObject2).append(" ms audioTrack: ");
        ((StringBuilder)localObject2).append(paramConvertContext.e.m);
        ((StringBuilder)localObject2).append(" mSampleRate: ");
        ((StringBuilder)localObject2).append(paramConvertContext.e.n);
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject2 = "VideoToVideo";
      Object localObject3 = new ExtractPCMFromFile();
      LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = paramConvertContext.a;
      localLocalMediaInfo.mDuration = paramConvertContext.e.h;
      l1 = System.currentTimeMillis();
      bool = ((ExtractPCMFromFile)localObject3).a(localLocalMediaInfo, 0, (int)paramConvertContext.e.h, (String)localObject1, paramConvertContext.e);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("run,getPCMFromFile:  ");
        ((StringBuilder)localObject3).append(paramConvertContext.k);
        ((StringBuilder)localObject3).append(" cost=");
        ((StringBuilder)localObject3).append(l2 - l1);
        ((StringBuilder)localObject3).append(" ms audioTrack: ");
        ((StringBuilder)localObject3).append(paramConvertContext.e.m);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      if (paramConvertContext.e.m)
      {
        if ((!bool) || (!FileUtils.i((String)localObject1)))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("run,getPCMFromFile: failed ");
            ((StringBuilder)localObject3).append(paramConvertContext.k);
            ((StringBuilder)localObject3).append(" path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" success=");
            ((StringBuilder)localObject3).append(bool);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          FileUtils.k((String)localObject1);
          StoryReportor.a("actVideo2VideoResult", new String[] { "8" });
          a(8, paramConvertContext.a, null, null, paramConvertContext.e, paramConvertContext);
        }
      }
      else
      {
        FileUtils.k((String)localObject1);
        ExtractPCMFromFile.a((String)localObject1, (int)paramConvertContext.e.h);
        if (!FileUtils.i((String)localObject1))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("run[video convert],createSilentPCMFile: failed ");
            ((StringBuilder)localObject3).append(paramConvertContext.k);
            ((StringBuilder)localObject3).append(" path=");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
          }
          StoryReportor.a("actVideo2VideoResult", new String[] { "8" });
          a(8, paramConvertContext.a, null, null, paramConvertContext.e, paramConvertContext);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("After,getPCMFromFile: hasAudioTrack= ");
        ((StringBuilder)localObject3).append(paramConvertContext.e.m);
        ((StringBuilder)localObject3).append(" path=");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" success=");
        ((StringBuilder)localObject3).append(bool);
        ((StringBuilder)localObject3).append(" audioFileSize=");
        ((StringBuilder)localObject3).append(FileUtil.f((String)localObject1));
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    this.g = ((String)localObject1);
    if (a(paramConvertContext))
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramConvertContext.a, null, null, paramConvertContext.e, paramConvertContext);
      return;
    }
    paramConvertContext.e.k = this.f;
    if (a(paramConvertContext))
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramConvertContext.a, null, null, paramConvertContext.e, paramConvertContext);
      return;
    }
    long l1 = System.currentTimeMillis();
    boolean bool = a(paramConvertContext.e, paramConvertContext);
    long l2 = System.currentTimeMillis();
    if (a(paramConvertContext))
    {
      StoryReportor.a("actVideo2VideoResult", new String[] { "9" });
      a(9, paramConvertContext.a, null, null, paramConvertContext.e, paramConvertContext);
      return;
    }
    long l3 = System.currentTimeMillis();
    long l4 = this.a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(l3 - l4);
    ((StringBuilder)localObject1).append("");
    StoryReportor.a("actVideo2VideoTime", new String[] { ((StringBuilder)localObject1).toString() });
    if ((bool) && (FileUtil.d(this.f)))
    {
      l3 = FileUtil.f(this.f);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("runLocalVideo2Video, file exist, size:");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(" file:");
        ((StringBuilder)localObject1).append(this.f);
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject1).toString());
      }
      this.d = 0;
      StoryReportor.a("actVideo2VideoResult", new String[] { "0" });
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("runLocalVideo2Video, [failed]file not exist:");
        ((StringBuilder)localObject1).append(paramConvertContext.k);
        ((StringBuilder)localObject1).append(" file:");
        ((StringBuilder)localObject1).append(this.f);
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject1).toString());
      }
      this.d = 7;
      StoryReportor.a("actVideo2VideoResult", new String[] { "7" });
      FileUtils.k(this.f);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("runLocalVideo2Video, taskid:");
      ((StringBuilder)localObject1).append(paramConvertContext.k);
      ((StringBuilder)localObject1).append(" run:");
      ((StringBuilder)localObject1).append(paramConvertContext.j);
      ((StringBuilder)localObject1).append(" cost:");
      ((StringBuilder)localObject1).append(l2 - l1);
      ((StringBuilder)localObject1).append(" ms successVideo:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("VideoToVideo", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramConvertContext.j) {
      a(this.d, paramConvertContext.a, this.f, null, paramConvertContext.e, paramConvertContext);
    }
  }
  
  /* Error */
  public boolean a(SlideItemInfo paramSlideItemInfo, SlideShowProcessor.ConvertContext paramConvertContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +769 -> 770
    //   4: aload_1
    //   5: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   8: ifnonnull +6 -> 14
    //   11: goto +759 -> 770
    //   14: aload_0
    //   15: new 290	com/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder
    //   18: dup
    //   19: invokespecial 291	com/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder:<init>	()V
    //   22: putfield 293	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:b	Lcom/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder;
    //   25: new 295	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 296	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore 11
    //   34: aload 11
    //   36: aload_1
    //   37: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   40: getfield 224	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   43: invokevirtual 299	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   46: aload_1
    //   47: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   50: aload 11
    //   52: bipush 19
    //   54: invokevirtual 303	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   57: invokestatic 309	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: putfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   63: aload_1
    //   64: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   67: aload 11
    //   69: bipush 18
    //   71: invokevirtual 303	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   74: invokestatic 309	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   77: putfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   80: aload_1
    //   81: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   84: aload 11
    //   86: bipush 24
    //   88: invokevirtual 303	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   91: invokestatic 309	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: putfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   97: goto +20 -> 117
    //   100: astore_1
    //   101: goto +662 -> 763
    //   104: astore 12
    //   106: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +8 -> 117
    //   112: aload 12
    //   114: invokevirtual 321	java/lang/Exception:printStackTrace	()V
    //   117: aload 11
    //   119: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   122: aload_1
    //   123: getfield 326	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:i	J
    //   126: lstore 6
    //   128: aload_1
    //   129: getfield 328	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:j	J
    //   132: lstore 8
    //   134: aload_1
    //   135: getfield 329	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:f	Ljava/lang/String;
    //   138: astore 11
    //   140: aload_1
    //   141: getfield 253	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:k	Ljava/lang/String;
    //   144: astore 12
    //   146: aload_1
    //   147: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   150: getfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   153: istore_3
    //   154: aload_1
    //   155: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   158: getfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   161: istore_3
    //   162: aload_0
    //   163: aload_1
    //   164: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   167: invokevirtual 332	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:b	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)I
    //   170: istore 5
    //   172: new 24	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig
    //   175: dup
    //   176: aload 12
    //   178: sipush 720
    //   181: sipush 1280
    //   184: getstatic 337	com/tencent/mobileqq/editor/composite/CodecParam:mMaxrate	I
    //   187: iconst_1
    //   188: iconst_0
    //   189: aload_1
    //   190: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   193: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   196: invokespecial 340	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:<init>	(Ljava/lang/String;IIIIZI)V
    //   199: astore 13
    //   201: aload 13
    //   203: sipush 720
    //   206: putfield 33	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:c	I
    //   209: aload 13
    //   211: sipush 1280
    //   214: putfield 36	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:d	I
    //   217: aload_1
    //   218: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   221: astore 14
    //   223: aload 14
    //   225: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   228: bipush 90
    //   230: if_icmpeq +26 -> 256
    //   233: aload 14
    //   235: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   238: sipush 270
    //   241: if_icmpne +6 -> 247
    //   244: goto +12 -> 256
    //   247: aload 14
    //   249: getfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   252: istore_3
    //   253: goto +9 -> 262
    //   256: aload 14
    //   258: getfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   261: istore_3
    //   262: aload 14
    //   264: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   267: bipush 90
    //   269: if_icmpeq +27 -> 296
    //   272: aload 14
    //   274: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   277: sipush 270
    //   280: if_icmpne +6 -> 286
    //   283: goto +13 -> 296
    //   286: aload 14
    //   288: getfield 312	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaHeight	I
    //   291: istore 4
    //   293: goto +10 -> 303
    //   296: aload 14
    //   298: getfield 315	com/tencent/mobileqq/activity/photo/LocalMediaInfo:mediaWidth	I
    //   301: istore 4
    //   303: iload_3
    //   304: i2f
    //   305: iload 4
    //   307: i2f
    //   308: fdiv
    //   309: ldc_w 341
    //   312: fcmpl
    //   313: iflt +24 -> 337
    //   316: iload_3
    //   317: iload 4
    //   319: sipush 720
    //   322: sipush 1280
    //   325: invokestatic 346	com/tencent/biz/qqstory/utils/VideoUtils:a	(IIII)Z
    //   328: ifeq +9 -> 337
    //   331: aload 13
    //   333: iconst_1
    //   334: putfield 349	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:r	Z
    //   337: new 47	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig
    //   340: dup
    //   341: aload_1
    //   342: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   345: getfield 224	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   348: iconst_0
    //   349: iconst_0
    //   350: iconst_1
    //   351: aload_1
    //   352: getfield 326	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:i	J
    //   355: aload_1
    //   356: getfield 328	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:j	J
    //   359: invokespecial 352	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:<init>	(Ljava/lang/String;IZZJJ)V
    //   362: astore 14
    //   364: aload_0
    //   365: aload 14
    //   367: aload 13
    //   369: iload 5
    //   371: invokespecial 354	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;I)V
    //   374: aload 14
    //   376: iconst_1
    //   377: putfield 357	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLocal	Z
    //   380: aload 14
    //   382: aload_1
    //   383: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   386: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   389: putfield 360	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:adjustRotation	I
    //   392: aload 14
    //   394: aload_0
    //   395: aload_1
    //   396: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   399: invokevirtual 363	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:a	(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)Z
    //   402: putfield 366	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   405: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +153 -> 561
    //   411: new 79	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   418: astore 15
    //   420: aload 15
    //   422: ldc_w 368
    //   425: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 15
    //   431: aload 11
    //   433: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 15
    //   439: ldc_w 370
    //   442: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 15
    //   448: aload 12
    //   450: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 15
    //   456: ldc_w 372
    //   459: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 15
    //   465: lload 6
    //   467: invokevirtual 92	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 15
    //   473: ldc_w 374
    //   476: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 15
    //   482: lload 8
    //   484: invokevirtual 92	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 15
    //   490: ldc_w 376
    //   493: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload 15
    //   499: aload_1
    //   500: getfield 288	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:a	Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   503: getfield 318	com/tencent/mobileqq/activity/photo/LocalMediaInfo:rotation	I
    //   506: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 15
    //   512: ldc_w 378
    //   515: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 15
    //   521: aload 13
    //   523: getfield 28	com/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig:m	I
    //   526: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 15
    //   532: ldc_w 380
    //   535: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: pop
    //   539: aload 15
    //   541: aload 14
    //   543: getfield 366	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:isLandscape	Z
    //   546: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: ldc 72
    //   552: iconst_2
    //   553: aload 15
    //   555: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload_0
    //   562: getfield 293	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:b	Lcom/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder;
    //   565: aload 14
    //   567: aload 13
    //   569: new 382	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo$1
    //   572: dup
    //   573: aload_0
    //   574: aload_2
    //   575: invokespecial 385	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo$1:<init>	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo;Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   578: aconst_null
    //   579: invokevirtual 388	com/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/encoder/EncodeConfig;Lcom/tencent/mobileqq/videocodec/mediacodec/recorder/HWEncodeListener;Lcom/tencent/mobileqq/videocodec/mediacodec/Mp4ReEncoder$EncodeFilterRender;)V
    //   582: aload_0
    //   583: getfield 19	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:c	Ljava/lang/Object;
    //   586: astore_1
    //   587: aload_1
    //   588: monitorenter
    //   589: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq +80 -> 672
    //   595: new 79	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   602: astore 11
    //   604: aload 11
    //   606: ldc_w 390
    //   609: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload 11
    //   615: aload_2
    //   616: getfield 60	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:g	Z
    //   619: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 11
    //   625: ldc_w 392
    //   628: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 11
    //   634: aload_2
    //   635: getfield 63	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:h	Z
    //   638: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload 11
    //   644: ldc_w 394
    //   647: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 11
    //   653: aload_2
    //   654: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:f	Z
    //   657: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: ldc 72
    //   663: iconst_2
    //   664: aload 11
    //   666: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: aload_2
    //   673: getfield 60	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:g	Z
    //   676: ifne +31 -> 707
    //   679: aload_2
    //   680: getfield 63	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:h	Z
    //   683: ifne +24 -> 707
    //   686: aload_2
    //   687: getfield 396	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:f	Z
    //   690: istore 10
    //   692: iload 10
    //   694: ifne +13 -> 707
    //   697: aload_0
    //   698: getfield 19	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:c	Ljava/lang/Object;
    //   701: invokevirtual 399	java/lang/Object:wait	()V
    //   704: goto -32 -> 672
    //   707: aload_1
    //   708: monitorexit
    //   709: aload_0
    //   710: aload_2
    //   711: invokespecial 401	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:c	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)Z
    //   714: istore 10
    //   716: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +36 -> 755
    //   722: new 79	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   729: astore_1
    //   730: aload_1
    //   731: ldc_w 403
    //   734: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_1
    //   739: iload 10
    //   741: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: ldc 72
    //   747: iconst_2
    //   748: aload_1
    //   749: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokestatic 77	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   755: iload 10
    //   757: ireturn
    //   758: astore_2
    //   759: aload_1
    //   760: monitorexit
    //   761: aload_2
    //   762: athrow
    //   763: aload 11
    //   765: invokevirtual 324	android/media/MediaMetadataRetriever:release	()V
    //   768: aload_1
    //   769: athrow
    //   770: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   773: ifeq +12 -> 785
    //   776: ldc 72
    //   778: iconst_2
    //   779: ldc_w 405
    //   782: invokestatic 407	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: iconst_0
    //   786: ireturn
    //   787: astore 11
    //   789: goto -117 -> 672
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	792	0	this	VideoToVideo
    //   0	792	1	paramSlideItemInfo	SlideItemInfo
    //   0	792	2	paramConvertContext	SlideShowProcessor.ConvertContext
    //   153	164	3	i	int
    //   291	27	4	j	int
    //   170	200	5	k	int
    //   126	340	6	l1	long
    //   132	351	8	l2	long
    //   690	66	10	bool	boolean
    //   32	732	11	localObject1	Object
    //   787	1	11	localInterruptedException	java.lang.InterruptedException
    //   104	9	12	localException	java.lang.Exception
    //   144	305	12	str	String
    //   199	369	13	localEncodeConfig	EncodeConfig
    //   221	345	14	localObject2	Object
    //   418	136	15	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	97	100	finally
    //   106	117	100	finally
    //   34	97	104	java/lang/Exception
    //   589	672	758	finally
    //   672	692	758	finally
    //   697	704	758	finally
    //   707	709	758	finally
    //   759	761	758	finally
    //   697	704	787	java/lang/InterruptedException
  }
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    int i = paramLocalMediaInfo.mediaWidth;
    int j = paramLocalMediaInfo.mediaHeight;
    boolean bool = true;
    if (i > j)
    {
      if (paramLocalMediaInfo.rotation % 180 == 0) {
        return true;
      }
    }
    else
    {
      if (paramLocalMediaInfo.rotation == 90) {
        break label55;
      }
      if (paramLocalMediaInfo.rotation == 270) {
        return true;
      }
    }
    bool = false;
    label55:
    return bool;
  }
  
  public int b(LocalMediaInfo paramLocalMediaInfo)
  {
    if (a(paramLocalMediaInfo)) {
      return paramLocalMediaInfo.rotation + 90;
    }
    return paramLocalMediaInfo.rotation;
  }
  
  public void b(SlideShowProcessor.ConvertContext paramConvertContext)
  {
    ??? = this.b;
    if (??? != null) {
      ((Mp4ReEncoder)???).a();
    }
    synchronized (this.c)
    {
      paramConvertContext.g = true;
      this.c.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoToVideo
 * JD-Core Version:    0.7.0.1
 */