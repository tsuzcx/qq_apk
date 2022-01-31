package com.tencent.mobileqq.activity.richmedia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.nearby.now.send.SmallVideoSendFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment.MediaCodecEditCallback;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.ptvfilter.test.PerformenceDataTag;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils;
import com.tencent.mobileqq.shortvideo.util.MediaMetadataUtils.MetaData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.concurrent.atomic.AtomicLong;

public class MediaCodecSendTask
  extends AsyncTask
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MediaCodecSendTask.VideoSendPublicParam jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam;
  AIOEffectsCameraCaptureFragment.MediaCodecEditCallback jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$MediaCodecEditCallback;
  private MediaMetadataUtils.MetaData jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData = new MediaMetadataUtils.MetaData();
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  public MediaCodecSendTask(MediaCodecSendTask.VideoSendPublicParam paramVideoSendPublicParam)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam = paramVideoSendPublicParam;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    this.jdField_e_of_type_JavaLangString = ("MediaCodecSendTask_[mSessionId=" + this.jdField_a_of_type_Long + "]");
  }
  
  public MediaCodecSendTask(MediaCodecSendTask.VideoSendPublicParam paramVideoSendPublicParam, AIOEffectsCameraCaptureFragment.MediaCodecEditCallback paramMediaCodecEditCallback)
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam = paramVideoSendPublicParam;
    this.jdField_a_of_type_Long = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.getAndIncrement();
    this.jdField_e_of_type_JavaLangString = ("MediaCodecSendTask_[mSessionId=" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$MediaCodecEditCallback = paramMediaCodecEditCallback;
  }
  
  private int a()
  {
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_JavaLangString;
    a("cacheDir=" + this.jdField_a_of_type_JavaLangString, null);
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_JavaLangString))
    {
      a("video file empty! path=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_JavaLangString, null);
      return -300;
    }
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_JavaLangString))
    {
      a("thumb file empty! path=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_JavaLangString, null);
      return -301;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent();
    this.jdField_b_of_type_Int = localIntent.getIntExtra("param_entrance", 0);
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("bless_ptv_mp4_path");
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("fake_id");
    int i = MediaMetadataUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData);
    if (i != 0)
    {
      a("MediaMetadataUtils: errcode=" + i, null);
      return i;
    }
    this.jdField_a_of_type_Int = ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[3] + 500) / 1000);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_Int <= 0))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[2];
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[0];
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[1];
      if ((i == 90) || (i == 270))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilMediaMetadataUtils$MetaData.a[0];
      }
    }
    return b();
  }
  
  private void a()
  {
    a("cancleProgressDailog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null)
      {
        this.jdField_a_of_type_AndroidAppProgressDialog.cancel();
        this.jdField_a_of_type_AndroidAppProgressDialog = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(Context paramContext, int paramInt)
  {
    a("showProgressDialog", null);
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        a();
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131624515);
        this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppProgressDialog.show();
        this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969181);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363381));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      a("showProgressDialog", paramContext);
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.d(this.jdField_e_of_type_JavaLangString, 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d(this.jdField_e_of_type_JavaLangString, 2, "[@] " + paramString);
  }
  
  /* Error */
  private int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   4: getfield 93	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   7: aload_0
    //   8: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   11: getfield 215	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_a_of_type_Double	D
    //   14: aload_0
    //   15: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   18: getfield 217	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_b_of_type_Double	D
    //   21: invokestatic 222	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;DD)Z
    //   24: pop
    //   25: new 224	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   33: getfield 93	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokespecial 227	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: new 229	java/io/FileInputStream
    //   43: dup
    //   44: aload_0
    //   45: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   48: getfield 93	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: aload_0
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 233	java/io/File:length	()J
    //   61: invokestatic 239	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   64: invokestatic 245	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   67: putfield 247	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 250	java/io/FileInputStream:close	()V
    //   78: aload_0
    //   79: getfield 247	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   82: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifeq +23 -> 108
    //   88: aload_0
    //   89: ldc_w 258
    //   92: aconst_null
    //   93: invokespecial 81	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: sipush -302
    //   99: ireturn
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 261	java/io/IOException:printStackTrace	()V
    //   105: goto -27 -> 78
    //   108: aload_0
    //   109: getfield 247	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   112: ldc_w 263
    //   115: invokestatic 268	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   123: getfield 93	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   126: aload_1
    //   127: invokestatic 271	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +13 -> 143
    //   133: aload_0
    //   134: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   137: aload_1
    //   138: putfield 93	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   141: iconst_0
    //   142: ireturn
    //   143: aload_1
    //   144: invokestatic 88	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   147: ifne -6 -> 141
    //   150: aload_0
    //   151: new 51	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 273
    //   161: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 43	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam	Lcom/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam;
    //   168: getfield 93	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask$VideoSendPublicParam:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   171: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 275
    //   177: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_1
    //   181: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aconst_null
    //   188: invokespecial 81	com/tencent/mobileqq/activity/richmedia/MediaCodecSendTask:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: sipush -301
    //   194: ireturn
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -128 -> 70
    //   201: astore_2
    //   202: goto -132 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	MediaCodecSendTask
    //   54	21	1	localFileInputStream	java.io.FileInputStream
    //   100	2	1	localIOException	java.io.IOException
    //   118	63	1	str	String
    //   195	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	1	1	localObject	Object
    //   39	19	2	localFile	File
    //   201	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   74	78	100	java/io/IOException
    //   40	55	195	java/io/FileNotFoundException
    //   55	70	201	java/io/FileNotFoundException
  }
  
  private void b(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("PhotoConst.IS_VIDEO_RECORDED", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_Int);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_Int);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int * 1000);
    paramIntent.putExtra("need_process", true);
    paramIntent.putExtra("PhotoConst.VIDEO_TYPE", 0);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_k_of_type_JavaLangString);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_e_of_type_Boolean);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_Boolean);
    Bundle localBundle = new Bundle();
    localBundle.putInt("sv_encode_max_bitrate", CodecParam.r);
    localBundle.putInt("sv_encode_min_bitrate", CodecParam.s);
    localBundle.putInt("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("encode_video_params", localBundle);
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    long l1 = System.currentTimeMillis();
    int i = a();
    if (i != 0) {
      return Integer.valueOf(i);
    }
    paramVarArgs = this.jdField_a_of_type_JavaLangString + File.separator + "mc_audio.mp4";
    Object localObject = AudioEncoder.a(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_Int);
    ((AudioEncoder.AudioData)localObject).jdField_b_of_type_JavaLangString = paramVarArgs;
    ((AudioEncoder.AudioData)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_b_of_type_JavaLangString;
    i = AudioEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_b_of_type_JavaLangString);
    if (i != 0) {
      a("checkSourceAudioIsOK: errcode=" + i, null);
    }
    do
    {
      paramVarArgs = new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_b_of_type_JavaLangString);
      if (paramVarArgs.exists()) {
        paramVarArgs.delete();
      }
      paramVarArgs = this.jdField_a_of_type_JavaLangString + File.separator + "mc_video.mp4";
      localObject = new File(paramVarArgs);
      if (((File)localObject).exists())
      {
        ((File)localObject).delete();
        a(" mc_video.mp4 exists  Path=" + paramVarArgs, null);
      }
      if (new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_JavaLangString).renameTo((File)localObject)) {
        break;
      }
      a(" renameTo mc_video.mp4 dstPath=" + paramVarArgs + " srcPath" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_JavaLangString, null);
      return Integer.valueOf(-303);
      long l2 = System.currentTimeMillis();
      i = AudioEncoder.a((AudioEncoder.AudioData)localObject);
      a("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l2) / 1000.0D, null);
    } while (i == 0);
    a("AudioEncoder.encodeSafely: errcode=" + i, null);
    return Integer.valueOf(i);
    a("doInBackground total:time=" + (System.currentTimeMillis() - l1) / 1000.0D, null);
    return Integer.valueOf(0);
  }
  
  void a(Intent paramIntent)
  {
    paramIntent.putExtra("mediacodec_encode_enable", true);
    paramIntent.putExtra("file_video_source_dir", this.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_path", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_JavaLangString);
    paramIntent.putExtra("thumbfile_send_width", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_Int);
    paramIntent.putExtra("thumbfile_send_height", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_Int);
    paramIntent.putExtra("thumbfile_md5", this.jdField_b_of_type_JavaLangString);
    paramIntent.putExtra("file_send_duration", this.jdField_a_of_type_Int);
    paramIntent.putExtra("sv_total_record_time", this.jdField_a_of_type_Int);
    paramIntent.putExtra("video_mood_content", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_g_of_type_JavaLangString);
    paramIntent.putExtra("video_mood_priv", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_e_of_type_Int);
    paramIntent.putExtra("video_mood_privUinList", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList);
    paramIntent.putExtra("enable_edit_video", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_Boolean);
    paramIntent.putExtra("video_topic_id", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_j_of_type_JavaLangString);
    paramIntent.putExtra("video_topic_sync_qzone", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_b_of_type_Boolean);
    paramIntent.putExtra("video_new_fake_vid", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_k_of_type_JavaLangString);
    paramIntent.putExtra("video_is_generate_gif", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_e_of_type_Boolean);
    paramIntent.putExtra("video_mood_timer_delete", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_Boolean);
    paramIntent.putExtra("qzone_video_sync_to_qqstory", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_g_of_type_Boolean);
    paramIntent.putExtra("video_sync_to_story", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_c_of_type_Boolean);
    paramIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_Int);
    paramIntent.putExtra("extra_key_font_format_type", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_g_of_type_Int);
    paramIntent.putExtra("extra_key_font_url", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_h_of_type_JavaLangString);
    paramIntent.putExtra("extra_key_super_font_id", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_h_of_type_Int);
    paramIntent.putExtra("extra_key_super_font_info", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_i_of_type_JavaLangString);
    paramIntent.putExtra("sv_encode_max_bitrate", CodecParam.r);
    paramIntent.putExtra("sv_encode_min_bitrate", CodecParam.s);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_j_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_i_of_type_Int > 0)) {
      PerformenceDataTag.a("sv_filter_mediacodec_fps", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_i_of_type_Int * 1000 / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_j_of_type_Int);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("forward_source_to_qzone");
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("forward_source_to_qzone", str);
    }
  }
  
  protected void a(Integer paramInteger)
  {
    a();
    int i = 0;
    if (paramInteger.intValue() == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_k_of_type_Int == 3)
      {
        paramInteger = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent());
        b(paramInteger);
        paramInteger.setFlags(536870912);
        QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, "", paramInteger, -1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_k_of_type_Int == 5)
      {
        paramInteger = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent());
        b(paramInteger);
        paramInteger.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, PhotoListActivity.class);
        paramInteger.addFlags(603979776);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_k_of_type_Int == 6)
      {
        paramInteger = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent());
        PublishParam localPublishParam = (PublishParam)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
        String str1 = localPublishParam.jdField_b_of_type_JavaLangString;
        String str2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_f_of_type_JavaLangString;
        String str3 = localPublishParam.jdField_d_of_type_JavaLangString;
        String str4 = localPublishParam.jdField_e_of_type_JavaLangString;
        String str5 = localPublishParam.jdField_f_of_type_JavaLangString;
        String str6 = localPublishParam.jdField_g_of_type_JavaLangString;
        i = localPublishParam.jdField_a_of_type_Int;
        int j = localPublishParam.jdField_b_of_type_Int;
        long l = localPublishParam.jdField_a_of_type_Long;
        int k = localPublishParam.jdField_c_of_type_Int;
        int m = localPublishParam.jdField_d_of_type_Int;
        int n = localPublishParam.jdField_f_of_type_Int;
        int i1 = localPublishParam.jdField_g_of_type_Int;
        String str7 = localPublishParam.jdField_h_of_type_JavaLangString;
        String str8 = localPublishParam.jdField_i_of_type_JavaLangString;
        int i2 = localPublishParam.jdField_h_of_type_Int;
        int i3 = localPublishParam.jdField_i_of_type_Int;
        int i4 = localPublishParam.jdField_j_of_type_Int;
        String str9 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_JavaLangString + File.separator + "mc_video.mp4";
        String str10 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_JavaLangString + File.separator + "mc_audio.mp4";
        String str11 = localPublishParam.jdField_l_of_type_JavaLangString;
        String str12 = localPublishParam.jdField_m_of_type_JavaLangString;
        int i5 = localPublishParam.jdField_k_of_type_Int;
        if (localPublishParam.jdField_l_of_type_Int == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localPublishParam = new PublishParam(str1, str2, str3, str4, str5, str6, i, j, l, k, m, 1, n, i1, str7, str8, i2, i3, i4, str9, str10, str11, str12, i5, bool, localPublishParam.jdField_m_of_type_Int, localPublishParam.n);
          paramInteger.putExtra(PublishParam.jdField_a_of_type_JavaLangString, localPublishParam);
          paramInteger.setFlags(536870912);
          PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, paramInteger, SmallVideoSendFragment.class);
          return;
        }
      }
      paramInteger = new Intent();
      a(paramInteger);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, paramInteger);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.finish();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = null;
        return;
      }
      paramInteger.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_JavaLangString);
      paramInteger.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_b_of_type_Int);
      paramInteger.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_e_of_type_JavaLangString);
      paramInteger.putExtra("file_send_business_type", 2);
      a("onPostExecute(), MediaCodecSendTask is to start  SendVideoActivity,mVideoCacheDir = " + this.jdField_a_of_type_JavaLangString, null);
      paramInteger.putExtra("ab_test_send_btn_click_time", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getIntent().getLongExtra("ab_test_send_btn_click_time", 0L));
      paramInteger.putExtra("param_key_redbag_type", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_l_of_type_Int);
      paramInteger.putExtra("special_video_type", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_m_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_d_of_type_JavaLangString.equals(MessageForBlessPTV.BLESS_REQ_UIN)))
      {
        paramInteger.putExtra("bless_ptv_mp4_path", this.jdField_c_of_type_JavaLangString);
        paramInteger.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, BlessSelectMemberActivity.class);
        paramInteger.putExtra("param_type", 9003);
        paramInteger.putExtra("param_only_friends", true);
        paramInteger.putExtra("param_donot_need_contacts", true);
        paramInteger.putExtra("param_title", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getString(2131438235));
        paramInteger.putExtra("param_done_button_wording", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getString(2131432400));
        paramInteger.putExtra("param_exit_animation", 1);
        paramInteger.putExtra("param_entrance", this.jdField_b_of_type_Int);
        paramInteger.putExtra("param_blesstype", 2);
        paramInteger.putExtra("encode_type", 1);
        paramInteger.putExtra("fake_id", this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.startActivityForResult(paramInteger, 10007);
        i = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$MediaCodecEditCallback == null) {
          break label1092;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureFragmentAIOEffectsCameraCaptureFragment$MediaCodecEditCallback.a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = null;
      return;
      paramInteger.setClass(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, SendVideoActivity.class);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.startActivity(paramInteger);
      break;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, "视频处理错误,短视频发送失败", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_e_of_type_JavaLangString, 2, "" + paramInteger);
      }
      a("onPostExecute(), MediaCodecSendTask error = " + paramInteger, null);
      break;
      label1092:
      if (i == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
  }
  
  protected void onPreExecute()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaMediaCodecSendTask$VideoSendPublicParam.jdField_a_of_type_AndroidAppActivity, 2131436128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask
 * JD-Core Version:    0.7.0.1
 */