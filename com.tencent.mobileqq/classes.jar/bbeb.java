import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class bbeb
  implements bdar
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  public String a;
  volatile boolean jdField_a_of_type_Boolean;
  public int b;
  public String b;
  volatile boolean b;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  
  bbeb(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = paramSVHwEncoder;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    bdbt.z = this.jdField_c_of_type_Int;
    bdbt.y = this.jdField_b_of_type_Int;
    Object localObject = new EncodeThread(null, new bbec(Looper.getMainLooper()), paramString, null, null);
    ((EncodeThread)localObject).run();
    localObject = ((EncodeThread)localObject).jdField_a_of_type_JavaLangString;
    bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.compressYUV2MP4", "[peak] videoFileDir = " + paramString + ",videoPath = " + (String)localObject + ",CodecParam.mRecordFrames = " + bdbt.z + ",CodecParam.mRecordTime = " + bdbt.y);
    return localObject;
  }
  
  public void a()
  {
    bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.cancelEncode", "[peak]  CompoundProcessor");
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      localRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.c();
  }
  
  public void a(int paramInt)
  {
    try
    {
      bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.rollBack", "[peak] delReason = " + paramInt);
      a(1, paramInt);
      a();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    bbeh localbbeh = bbeh.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("roll_back_reason", paramInt2);
    if (paramInt1 == 1) {
      localbbeh.a().a(this.jdField_a_of_type_JavaLangString);
    }
    localbbeh.a(101, paramInt1, localBundle);
    bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.cancelPreupload", "[peak] cancelType  = " + paramInt1 + ",cancleReason = " + paramInt2);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    bbeh localbbeh = bbeh.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("video_slice_path", paramString);
    localBundle.putInt("video_slice_index", paramInt1);
    localBundle.putInt("video_slice_width", paramInt2);
    localBundle.putInt("video_slice_height", paramInt3);
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localbbeh.a(100, -1, localBundle);
    bhnn.a(this.jdField_a_of_type_JavaLangString, "segment", "CompoundProcessor.svSegmentOK [peak] index = " + paramInt1 + ",path = " + paramString + ",width = " + paramInt2 + ",height = " + paramInt3);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramString, paramInt1, paramInt2, paramLong, paramInt3, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.notifySendBtnClicked", "already notified ,return ");
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = paramInt2;
        if (!this.jdField_b_of_type_Boolean)
        {
          a(121);
          bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.notifySendBtnClicked", "[peak] Thumb not ready,rollback ");
          paramString = bbeh.a();
          localBundle = new Bundle();
          localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
          localBundle.putInt("ab_test_video_duration", paramInt1);
          localBundle.putLong("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          localBundle.putLong("video_record_touch_up_time", paramLong);
          localBundle.putInt("video_record_touch_up_times", paramInt3);
          paramString.a(106, -1, localBundle);
          return;
        }
      }
      finally {}
      bdby.a().a().recordSubmit();
      paramString = bbeh.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("video_full_slice_sync_to_story", paramBoolean);
      paramString.a(105, -1, localBundle);
      bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.notifySendBtnClicked ", "[peak] thumb existed");
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      bbeh localbbeh = bbeh.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("video_thumb_path", paramString1);
      localBundle.putInt("video_thumb_width", paramInt1);
      localBundle.putInt("video_thumb_height", paramInt2);
      localBundle.putInt("video_busi_type", this.jdField_a_of_type_Int);
      localBundle.putString("video_thumb_md5", paramString2);
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localbbeh.a(104, -1, localBundle);
      bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.svThumbOK", "[peak] path = " + paramString1 + ",width = " + paramInt1 + ",height = " + paramInt2 + ",md5 = " + paramString2);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    bbeh localbbeh = bbeh.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("full_video_path", paramString);
    localBundle.putInt("video_slices_total_time_length", paramInt);
    localBundle.putLong("video_merge_mp4_time_cost", paramLong);
    localbbeh.a(103, -1, localBundle);
    bhnn.a(this.jdField_a_of_type_JavaLangString, "clicomp", "CompoundProcessor.svMergeOK[peak] path = " + paramString + ",totalTime = " + paramInt);
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  /* Error */
  public void b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	bbeb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 321
    //   9: new 99	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 323
    //   19: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 325
    //   29: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 122	bhnn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 235	bbeb:jdField_a_of_type_Boolean	Z
    //   46: ifne +26 -> 72
    //   49: aload_0
    //   50: iconst_1
    //   51: bipush 120
    //   53: invokevirtual 165	bbeb:a	(II)V
    //   56: aload_0
    //   57: getfield 68	bbeb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: ldc_w 321
    //   63: ldc_w 327
    //   66: invokestatic 122	bhnn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: iload_1
    //   73: iconst_m1
    //   74: if_icmpgt +29 -> 103
    //   77: iload_1
    //   78: bipush 233
    //   80: if_icmplt +23 -> 103
    //   83: aload_0
    //   84: iconst_2
    //   85: bipush 122
    //   87: invokevirtual 165	bbeb:a	(II)V
    //   90: aload_0
    //   91: getfield 68	bbeb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: ldc_w 321
    //   97: ldc_w 329
    //   100: invokestatic 122	bhnn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 307	bbeb:jdField_c_of_type_Boolean	Z
    //   107: ifne -38 -> 69
    //   110: new 331	com/tencent/mobileqq/richmedia/CompoundProcessor$1
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 334	com/tencent/mobileqq/richmedia/CompoundProcessor$1:<init>	(Lbbeb;)V
    //   118: bipush 8
    //   120: aconst_null
    //   121: iconst_1
    //   122: invokestatic 340	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   125: goto -56 -> 69
    //   128: astore_3
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	bbeb
    //   0	133	1	paramInt1	int
    //   0	133	2	paramInt2	int
    //   128	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	69	128	finally
    //   69	71	128	finally
    //   83	103	128	finally
    //   103	125	128	finally
    //   129	131	128	finally
  }
  
  public void c()
  {
    bbeh localbbeh = bbeh.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localbbeh.a(102, -1, localBundle);
    bhnn.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.svEncodeEnd ", "[peak]all encode end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeb
 * JD-Core Version:    0.7.0.1
 */