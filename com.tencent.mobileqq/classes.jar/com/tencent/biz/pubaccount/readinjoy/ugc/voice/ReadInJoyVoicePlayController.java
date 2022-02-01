package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class ReadInJoyVoicePlayController
{
  private static ReadInJoyVoicePlayController jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVoiceReadInJoyVoicePlayController;
  public static final String a;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private SocializeFeedsInfo.UGCVoiceInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadInJoyVoicePlayController.3(this);
  private WeakReference<ReadInJoyVoicePlayController.IPlayCallback> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyVoicePlayController.class.getSimpleName();
  }
  
  public static ReadInJoyVoicePlayController a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVoiceReadInJoyVoicePlayController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVoiceReadInJoyVoicePlayController == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVoiceReadInJoyVoicePlayController = new ReadInJoyVoicePlayController();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcVoiceReadInJoyVoicePlayController;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.isPlaying = false;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          ReadInJoyVoicePlayController.IPlayCallback localIPlayCallback = (ReadInJoyVoicePlayController.IPlayCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if (localIPlayCallback != null)
          {
            localIPlayCallback.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo);
            a(false, "ugc voice play");
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(ReadInJoyVoicePlayController.IPlayCallback paramIPlayCallback, SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    a();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIPlayCallback);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo = paramUGCVoiceInfo;
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new ReadInJoyVoicePlayController.1(this));
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new ReadInJoyVoicePlayController.2(this));
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramUGCVoiceInfo.voiceUrl);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException paramIPlayCallback)
    {
      paramIPlayCallback.printStackTrace();
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 31	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_Boolean	Z
    //   7: aload_0
    //   8: getfield 44	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: ifnull +81 -> 92
    //   14: aload_0
    //   15: getfield 51	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   18: ifnull +74 -> 92
    //   21: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +38 -> 62
    //   27: getstatic 25	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: iconst_2
    //   31: new 164	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   38: ldc 167
    //   40: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 174	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc 176
    //   49: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 44	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   66: aload_0
    //   67: getfield 51	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   70: invokevirtual 187	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   73: aload_0
    //   74: getfield 31	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_Boolean	Z
    //   77: ifeq +18 -> 95
    //   80: aload_0
    //   81: getfield 44	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   84: aload_0
    //   85: getfield 51	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   88: invokevirtual 191	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   91: pop
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: aload_0
    //   96: getfield 44	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 51	com/tencent/biz/pubaccount/readinjoy/ugc/voice/ReadInJoyVoicePlayController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   103: ldc2_w 192
    //   106: invokevirtual 197	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   109: pop
    //   110: goto -18 -> 92
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	ReadInJoyVoicePlayController
    //   0	118	1	paramBoolean	boolean
    //   0	118	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	62	113	finally
    //   62	92	113	finally
    //   95	110	113	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController
 * JD-Core Version:    0.7.0.1
 */