package com.tencent.biz.pubaccount.readinjoy.video.videoconverter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import java.io.File;

public class VideoCompressTask
  extends AsyncTask<String, Void, Integer>
{
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoCompressTask.VideoCompressTaskListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener;
  private VideoMediaInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo;
  private VideoConverter jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = 0L;
  private VideoMediaInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public VideoCompressTask(Context paramContext, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener = paramVideoCompressTaskListener;
  }
  
  private int a(Context paramContext, String paramString1, VideoMediaInfo paramVideoMediaInfo, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
    }
    paramVideoMediaInfo = new VideoCompressTask.HWCompressProcessor(this, paramString2, (int)(paramVideoMediaInfo.jdField_b_of_type_Long * 1024L), (int)paramVideoMediaInfo.jdField_a_of_type_Long, 0L, paramVideoMediaInfo.c);
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter = new VideoConverter(new VideoConverterLog());
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.setCompressMode(1);
    int i = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.startCompress(paramContext, paramString1, paramVideoMediaInfo, true);
    if ((i == 0) || (i == -1002))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
      }
      return 0;
    }
    if (i == -3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec, api not support");
      }
      return -2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodec");
    }
    return -4;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener.a(0.0F);
    if (TextUtils.isEmpty(paramVarArgs))
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, error params:" + paramVarArgs);
      return Integer.valueOf(-1);
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, sdk version too low: " + Build.VERSION.SDK_INT);
      return Integer.valueOf(-2);
    }
    this.jdField_a_of_type_JavaLangString = paramVarArgs;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo = VideoMediaInfo.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo == null)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, retrive mSourceMediaInfo failed! ");
      return Integer.valueOf(-3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: retrive mSourceMediaInfo = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo);
    }
    if (!VideoConvertUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo))
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, no need compress! ");
      return Integer.valueOf(-5);
    }
    long l1 = System.currentTimeMillis();
    File localFile = new File(VideoConvertUtil.a());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf(".");
    if (i == -1)
    {
      QLog.d("VideoCompressTask", 1, "CompressTask failed, error params:" + paramVarArgs);
      return Integer.valueOf(-1);
    }
    this.jdField_b_of_type_JavaLangString = VideoConvertUtil.a(paramVarArgs, paramVarArgs.substring(i + 1));
    i = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo, this.jdField_b_of_type_JavaLangString);
    if (i == 0) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo = VideoMediaInfo.a(this.jdField_b_of_type_JavaLangString);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask run finish! compress ret = " + i + ", cost:" + (l2 - l1) + "ms, mTargetMdeiaInfo=" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo);
    }
    return Integer.valueOf(i);
  }
  
  public void a()
  {
    cancel(false);
    if (this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter != null) {
      this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.cancelCompress();
    }
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 2;
    super.onPostExecute(paramInteger);
    if (isCancelled()) {}
    label260:
    for (;;)
    {
      return;
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoCompressTask", 2, "CompressTask, compress failed, errorCode:" + paramInteger);
        }
        if (paramInteger.intValue() != -2) {}
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener == null) {
          break label260;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo);
        return;
        if (paramInteger.intValue() == -3)
        {
          i = 3;
        }
        else
        {
          if (paramInteger.intValue() == -5)
          {
            i = 1;
            continue;
            this.jdField_b_of_type_Long = System.currentTimeMillis();
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {}
            for (paramInteger = this.jdField_a_of_type_JavaLangString;; paramInteger = this.jdField_b_of_type_JavaLangString)
            {
              this.c = paramInteger;
              long l = new File(this.c).length();
              if (QLog.isColorLevel()) {
                QLog.d("VideoCompressTask", 2, "CompressTask, finalSize:" + l);
              }
              if (l <= VideoConvertUtil.b()) {
                break label231;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener.a(5, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo);
              return;
            }
            label231:
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoCompressTask$VideoCompressTaskListener.a(0, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyVideoVideoconverterVideoMediaInfo);
            return;
          }
          i = 4;
        }
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videoconverter.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */