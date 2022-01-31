import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.segment.SegmentManager.1;
import com.tencent.mobileqq.richmedia.segment.SegmentManager.2;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

@TargetApi(18)
public class awbf
  extends awbd
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  public avrg a;
  private awbe jdField_a_of_type_Awbe;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public CameraCaptureView a;
  private ArrayList<awbe> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, String> a;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private final boolean jdField_f_of_type_Boolean;
  private long g;
  private long h;
  
  public awbf(CameraCaptureView paramCameraCaptureView, long paramLong)
  {
    super(paramLong);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
    this.jdField_a_of_type_Avrg = avrg.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getContext()).getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO"));
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManagerV2.getFileThreadLooper(), this);
    this.jdField_f_of_type_Boolean = true;
    QLog.d("SegmentManager", 1, "SegmentManager,mSegmentMode:" + this.jdField_f_of_type_Boolean);
  }
  
  private Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (this.jdField_f_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("video_segment_mode", i);
      localBundle.putLong("vidoe_record_uniseq", this.jdField_a_of_type_Long);
      localBundle.putBoolean("video_segment_capture_success", this.jdField_d_of_type_Boolean);
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return localBundle;
    }
  }
  
  private void a(MediaFormat paramMediaFormat)
  {
    try
    {
      if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = true;
        ThreadManagerV2.excute(new SegmentManager.2(this, paramMediaFormat), 64, null, true);
      }
      return;
    }
    finally
    {
      paramMediaFormat = finally;
      throw paramMediaFormat;
    }
  }
  
  private void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_f_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        Bundle localBundle = a();
        this.jdField_a_of_type_Avrg.a(201, -1, localBundle);
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "sendAudioFinishedMsg");
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String paramString, MediaFormat paramMediaFormat)
  {
    ThreadManagerV2.executeOnFileThread(new SegmentManager.1(this, paramString, paramMediaFormat));
  }
  
  public void a()
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_AndroidMediaMediaMuxer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      this.jdField_a_of_type_AndroidMediaMediaMuxer = null;
      Bundle localBundle = a();
      this.jdField_a_of_type_Avrg.a(208, -1, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "cancelTask");
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
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put("param_audio_error", String.valueOf(-6));
    long l;
    axkh localaxkh;
    if (this.jdField_e_of_type_JavaLangString != null)
    {
      l = SystemClock.uptimeMillis();
      localaxkh = new axkh();
      localaxkh.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localaxkh.jdField_b_of_type_JavaLangString = c();
      localaxkh.jdField_a_of_type_Int = 0;
      localaxkh.d = paramInt;
      localaxkh.c = axim.n;
      if (axim.p != 2) {
        break label178;
      }
      localaxkh.jdField_b_of_type_Int = 16;
      if (axim.o != 16) {
        break label188;
      }
      localaxkh.e = 1;
      label101:
      paramInt = AudioEncoder.a(this.jdField_e_of_type_JavaLangString);
      if (paramInt == 0) {
        break label197;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "onEncodeAudioError checkSourceAudioIsOK  failed:" + paramInt);
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_audio_error", String.valueOf(paramInt));
    }
    for (;;)
    {
      this.jdField_c_of_type_JavaLangString = "AUDIO_PROBLEM";
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
      return;
      label178:
      localaxkh.jdField_b_of_type_Int = 8;
      break;
      label188:
      localaxkh.e = 2;
      break label101;
      label197:
      paramInt = AudioEncoder.a(localaxkh);
      if (paramInt == 0) {
        break label256;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_audio_error", String.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "AudioEncoder.encodeSafely failed:" + paramInt);
      }
    }
    label256:
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeAudioError encodeSafely succ,  cost :" + (SystemClock.uptimeMillis() - l));
    }
    a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), c());
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    this.jdField_d_of_type_Long = (paramLong2 - paramLong1);
    this.jdField_e_of_type_Long = paramLong2;
    Bundle localBundle = a();
    localBundle.putLong("video_duration", this.jdField_d_of_type_Long);
    localBundle.putLong("video_start_time", paramLong2);
    this.jdField_a_of_type_Avrg.a(207, -1, localBundle);
    arqn.c();
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "confirmTask");
    }
  }
  
  public void a(MediaFormat paramMediaFormat, String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeAudio:" + this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    c();
    a(paramMediaFormat);
  }
  
  public void a(awbe paramawbe, boolean paramBoolean, MediaFormat paramMediaFormat)
  {
    int i = paramawbe.a();
    long l = paramawbe.a();
    String str = paramawbe.a();
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeVideoSegment:" + paramawbe);
    }
    int j = paramMediaFormat.getInteger("width");
    int k = paramMediaFormat.getInteger("height");
    paramawbe = a();
    paramawbe.putString("video_slice_path", str);
    paramawbe.putInt("video_slice_index", i);
    paramawbe.putInt("video_slice_width", j);
    paramawbe.putInt("video_slice_height", k);
    paramawbe.putLong("video_slice_timestamp", l);
    this.jdField_a_of_type_Avrg.a(200, -1, paramawbe);
    if (i == 0) {
      c(str, paramMediaFormat);
    }
    if (paramBoolean)
    {
      this.h = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      paramawbe = a();
      this.jdField_a_of_type_Avrg.a(204, -1, paramawbe);
      c();
    }
  }
  
  public void a(String paramString, MediaFormat paramMediaFormat)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeVideo:" + paramString + " mSegmentMode:" + this.jdField_f_of_type_Boolean + " mSegmentEncodeSuc:" + this.jdField_d_of_type_Boolean + " mThumbPath:" + this.jdField_d_of_type_JavaLangString);
    }
    this.g = System.currentTimeMillis();
    if (!this.jdField_f_of_type_Boolean) {
      c(paramString, paramMediaFormat);
    }
    for (;;)
    {
      a(paramMediaFormat);
      return;
      if ((!this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_JavaLangString == null)) {
        c(paramString, paramMediaFormat);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    if (!this.jdField_f_of_type_Boolean) {}
    do
    {
      return false;
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = paramLong;
      }
      this.jdField_c_of_type_Long = paramLong;
    } while ((this.jdField_c_of_type_Long - this.jdField_b_of_type_Long < 1500000L) || (!paramBoolean));
    this.jdField_b_of_type_Long = 0L;
    return true;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onError");
    }
    Bundle localBundle = a();
    this.jdField_a_of_type_Avrg.a(206, -1, localBundle);
    a();
    ((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getContext()).finish();
  }
  
  public void b(String paramString, MediaFormat paramMediaFormat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeAudioPCM:" + paramString);
    }
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (!this.jdField_d_of_type_Boolean) {}
    while (this.jdField_e_of_type_Boolean) {
      return true;
    }
    int i;
    try
    {
      switch (paramMessage.what)
      {
      case 1: 
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_Awbe = new awbe(d(), i);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Awbe);
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "Muxer_Start :" + this.jdField_a_of_type_Awbe);
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_Awbe.a(), 0);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack((MediaFormat)paramMessage.obj);
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
        return true;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "onSegmentEncodeError");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_segment_fail_flag", "1");
      this.jdField_d_of_type_Boolean = false;
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
      return true;
    }
    paramMessage = (avzd)paramMessage.obj;
    MediaCodec.BufferInfo localBufferInfo = paramMessage.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo;
    if (localBufferInfo.flags != 1) {
      if (localBufferInfo.flags != 1) {
        break label506;
      }
    }
    for (;;)
    {
      long l = localBufferInfo.presentationTimeUs;
      if (a(l, bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "Muxer_Data needSegment timeStamp:" + l);
        }
        this.jdField_b_of_type_Long = 0L;
        this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
        a(this.jdField_a_of_type_Awbe, false, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_Awbe = new awbe(d(), i);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Awbe);
        this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_Awbe.a(), 0);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
      }
      this.jdField_a_of_type_Awbe.a(paramMessage);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, paramMessage.jdField_a_of_type_JavaNioByteBuffer, paramMessage.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "Muxer_Stop :" + this.jdField_a_of_type_Awbe);
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      a(this.jdField_a_of_type_Awbe, true, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
      return true;
      return true;
      boolean bool = true;
      continue;
      label506:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awbf
 * JD-Core Version:    0.7.0.1
 */