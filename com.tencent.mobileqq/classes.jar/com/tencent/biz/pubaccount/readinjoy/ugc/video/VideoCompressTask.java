package com.tencent.biz.pubaccount.readinjoy.ugc.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.HashMap;

public class VideoCompressTask
  extends AsyncTask<String, Void, Integer>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  VideoCompressTask.VideoCompressTaskListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener;
  private Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  private Long jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private Long jdField_c_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_c_of_type_JavaLangString;
  private Long jdField_d_of_type_JavaLangLong = Long.valueOf(0L);
  private String jdField_d_of_type_JavaLangString;
  
  public VideoCompressTask(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener = paramVideoCompressTaskListener;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int j = 1280;
    int i;
    if (paramInt1 <= paramInt2)
    {
      i = ReadInJoyConstants.jdField_a_of_type_Int;
      paramInt1 = ReadInJoyHelper.r(BaseApplicationImpl.getApplication().getRuntime());
      if (paramInt1 <= 0) {
        break label80;
      }
      i = paramInt1;
    }
    label80:
    for (;;)
    {
      if (paramInt2 >= 1280) {
        paramInt1 = j;
      }
      for (;;)
      {
        float f = i * 1.0F / 640.0F;
        return (int)(paramInt1 * f);
        paramInt2 = paramInt1;
        break;
        if (paramInt2 >= 960) {
          paramInt1 = 960;
        } else {
          paramInt1 = 640;
        }
      }
    }
  }
  
  @NonNull
  private Integer a(String paramString, long paramLong)
  {
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return Integer.valueOf(-1);
    }
    this.jdField_b_of_type_JavaLangString = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(i + 1));
    HashMap localHashMap = a(paramString, this.jdField_a_of_type_AndroidContentContext);
    if (localHashMap == null)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "dealAfterInit return for compressResult is null.");
      return Integer.valueOf(-1);
    }
    i = Integer.parseInt((String)localHashMap.get("ret"));
    this.jdField_b_of_type_JavaLangString = ((String)localHashMap.get("outputPath"));
    this.jdField_a_of_type_Int = Integer.parseInt((String)localHashMap.get("outWidth"));
    this.jdField_b_of_type_Int = Integer.parseInt((String)localHashMap.get("outHeight"));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, "Before Compress file:" + paramString + ", after Compress file:" + this.jdField_b_of_type_JavaLangString);
    }
    long l2 = System.currentTimeMillis();
    long l3 = new File(paramString).length();
    long l1 = 0L;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      l1 = new File(this.jdField_b_of_type_JavaLangString).length();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask，step: ShortVideoTrimmer compress ret = " + i + ", cost:" + (l2 - paramLong) + "ms, fileSourceSize=" + l3 + ", fileTargetSize=" + l1);
    }
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(l3);
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
    return Integer.valueOf(i);
  }
  
  @NonNull
  private Integer a(String paramString, File paramFile, VideoConverterConfig paramVideoConverterConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, "file:" + paramString + ", size:" + paramFile.length() + ", no need compress");
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if (paramVideoConverterConfig != null) {
      a(paramString, paramVideoConverterConfig);
    }
    return Integer.valueOf(0);
  }
  
  private HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str2 = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    int j = -1;
    VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(paramString);
    if (localVideoConverterConfig == null)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "compressPosition, config = null");
      return null;
    }
    a(localVideoConverterConfig, paramString);
    int i;
    if (localVideoConverterConfig.isNeedCompress)
    {
      i = j;
      long l1;
      if (Build.VERSION.SDK_INT >= 18)
      {
        localObject1 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject1).setDataSource(paramString);
        localObject2 = ((MediaMetadataRetriever)localObject1).extractMetadata(9);
        ((MediaMetadataRetriever)localObject1).release();
        l1 = 0L;
      }
      try
      {
        long l2 = Long.parseLong((String)localObject2);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int k;
          QLog.e("ReadInJoyUploadVideoCompressTask", 1, "compressPosition", localNumberFormatException);
          continue;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodec， compressRet:" + k);
            i = j;
          }
        }
      }
      Object localObject1 = new VideoCompressTask.HWCompressProcessor(this, str2, (int)(localVideoConverterConfig.srcBitrate * 1024L), (int)localVideoConverterConfig.srcFrameRate, 0L, l1);
      Object localObject2 = new VideoConverter(new VideoConverterLog());
      ((VideoConverter)localObject2).setCompressMode(1);
      k = ((VideoConverter)localObject2).startCompress(paramContext, paramString, (VideoConverter.Processor)localObject1, true);
      if (k == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
        }
        i = 0;
        j = i;
        localObject1 = str2;
        if (i != 0)
        {
          j = i;
          localObject1 = str2;
          if (!TextUtils.isEmpty(str2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
            }
            j = ShortVideoTrimmer.compressVideo(paramContext, paramString, str2, localVideoConverterConfig);
            localObject1 = str2;
          }
        }
        localHashMap.put("outputPath", localObject1);
        localHashMap.put("ret", String.valueOf(j));
        if (!a(localVideoConverterConfig, paramString)) {
          break label396;
        }
        localHashMap.put("outWidth", String.valueOf(localVideoConverterConfig.destHeight));
        localHashMap.put("outHeight", String.valueOf(localVideoConverterConfig.destWidth));
      }
    }
    for (;;)
    {
      return localHashMap;
      j = 0;
      String str1 = paramString;
      break;
      label396:
      localHashMap.put("outWidth", String.valueOf(localVideoConverterConfig.destWidth));
      localHashMap.put("outHeight", String.valueOf(localVideoConverterConfig.destHeight));
    }
  }
  
  private void a()
  {
    File localFile = new File(AppConstants.SDCARD_PATH + "shortvideo");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("video_size_before_compression", this.jdField_a_of_type_JavaLangLong.toString());
    localHashMap.put("source_video_bitrate", this.jdField_c_of_type_JavaLangLong.toString());
    localHashMap.put("target_video_bitrate", this.jdField_d_of_type_JavaLangLong.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = ReadInJoyUtils.a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoCompressVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return;
    }
  }
  
  private static void a(VideoConverterConfig paramVideoConverterConfig, String paramString)
  {
    if ((paramVideoConverterConfig != null) && (paramVideoConverterConfig.isNeedCompress))
    {
      long l = new File(paramString).length();
      int i = a(paramVideoConverterConfig.srcWidth, paramVideoConverterConfig.srcHeight);
      if ((l <= 52428800L) && (i > 0) && (paramVideoConverterConfig.srcBitrate * 1024L / i < 1.3D))
      {
        paramVideoConverterConfig.isNeedCompress = false;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, fileSize:" + l + ", no need compress!");
        }
      }
    }
  }
  
  private void a(String paramString, VideoConverterConfig paramVideoConverterConfig)
  {
    int j = 0;
    int i;
    if (("90".equals(paramVideoConverterConfig.rotate)) || ("270".equals(paramVideoConverterConfig.rotate))) {
      i = 1;
    }
    while (i != 0)
    {
      this.jdField_a_of_type_Int = paramVideoConverterConfig.srcHeight;
      this.jdField_b_of_type_Int = paramVideoConverterConfig.srcWidth;
      return;
      i = j;
      if ("0".equals(paramVideoConverterConfig.rotate))
      {
        paramString = ShortVideoTrimmer.getVideoProperty(paramString);
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.length == 5) {
            if (paramString[3] != 90)
            {
              i = j;
              if (paramString[3] != 270) {}
            }
            else
            {
              i = 1;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Int = paramVideoConverterConfig.srcWidth;
    this.jdField_b_of_type_Int = paramVideoConverterConfig.srcHeight;
  }
  
  private static boolean a(VideoConverterConfig paramVideoConverterConfig, String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (("90".equals(paramVideoConverterConfig.rotate)) || ("270".equals(paramVideoConverterConfig.rotate))) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!"0".equals(paramVideoConverterConfig.rotate));
          paramVideoConverterConfig = ShortVideoTrimmer.getVideoProperty(paramString);
          bool1 = bool2;
        } while (paramVideoConverterConfig == null);
        bool1 = bool2;
      } while (paramVideoConverterConfig.length != 5);
      if (paramVideoConverterConfig[3] == 90) {
        break;
      }
      bool1 = bool2;
    } while (paramVideoConverterConfig[3] != 270);
    return true;
  }
  
  private boolean a(boolean paramBoolean, VideoConverterConfig paramVideoConverterConfig)
  {
    int i = a(paramVideoConverterConfig.srcWidth, paramVideoConverterConfig.srcHeight);
    this.jdField_c_of_type_JavaLangLong = Long.valueOf(paramVideoConverterConfig.srcBitrate);
    this.jdField_d_of_type_JavaLangLong = Long.valueOf(i);
    boolean bool = paramBoolean;
    if (i > 0)
    {
      bool = paramBoolean;
      if (paramVideoConverterConfig.srcBitrate * 1024L / i > 1.3D) {
        bool = true;
      }
    }
    return bool;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    boolean bool = false;
    paramVarArgs = paramVarArgs[0];
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(0.0F);
    if ((TextUtils.isEmpty(paramVarArgs)) || (this.jdField_a_of_type_AndroidContentContext == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, "error params");
      }
      return Integer.valueOf(-1);
    }
    this.jdField_a_of_type_JavaLangString = paramVarArgs;
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(this.jdField_a_of_type_JavaLangString);
    if (localVideoConverterConfig != null) {
      bool = a(false, localVideoConverterConfig);
    }
    if ((localFile.exists()) && (localFile.length() <= 52428800L) && (!bool)) {
      return a(paramVarArgs, localFile, localVideoConverterConfig);
    }
    a();
    long l = System.currentTimeMillis();
    if (ShortVideoTrimmer.initVideoTrim(this.jdField_a_of_type_AndroidContentContext)) {
      return a(paramVarArgs, l);
    }
    return Integer.valueOf(-1);
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (isCancelled()) {
      return;
    }
    int i;
    if (paramInteger.intValue() != 0) {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, not support shortvideo so");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(1, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null, 0L);
        }
        i = 1004;
      }
    }
    for (;;)
    {
      a(i);
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, shortvideo so not ready");
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(2, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null, 0L);
        }
        i = 1004;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, compress failed, errorCode:" + paramInteger);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(3, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null, 0L);
        }
        i = 1004;
        continue;
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
        for (paramInteger = this.jdField_a_of_type_JavaLangString;; paramInteger = this.jdField_b_of_type_JavaLangString)
        {
          this.jdField_c_of_type_JavaLangString = paramInteger;
          paramInteger = MD5.getFileMd5(this.jdField_c_of_type_JavaLangString);
          if (paramInteger != null) {
            this.jdField_d_of_type_JavaLangString = new String(paramInteger);
          }
          long l = new File(this.jdField_c_of_type_JavaLangString).length();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, finalSize:" + l);
          }
          if (l <= 314572800L) {
            break label382;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(4, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangLong.longValue());
          }
          i = 1005;
          break;
        }
        label382:
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVideoVideoCompressTask$VideoCompressTaskListener.a(0, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaLangLong.longValue());
        }
        i = 0;
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.video.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */