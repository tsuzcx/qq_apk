import android.annotation.TargetApi;
import android.app.Activity;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.segment.SegmentManager.1;
import com.tencent.mobileqq.richmedia.segment.SegmentManager.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

@TargetApi(18)
public class bbor
  extends bbop
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private MediaMuxer jdField_a_of_type_AndroidMediaMediaMuxer;
  public bbfs a;
  private bboq jdField_a_of_type_Bboq;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public CameraCaptureView a;
  private ArrayList<bboq> jdField_a_of_type_JavaUtilArrayList;
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
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private final boolean jdField_f_of_type_Boolean;
  private long g;
  private long h;
  
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
  
  private void a(String paramString, MediaFormat paramMediaFormat)
  {
    ThreadManagerV2.executeOnFileThread(new SegmentManager.1(this, paramString, paramMediaFormat));
  }
  
  private void c()
  {
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_JavaLangString != null) && (this.jdField_f_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
      {
        this.jdField_c_of_type_Boolean = true;
        Bundle localBundle = a();
        this.jdField_a_of_type_Bbfs.a(201, -1, localBundle);
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
      this.jdField_a_of_type_Bbfs.a(208, -1, localBundle);
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
  
  public void a(bboq parambboq, boolean paramBoolean, MediaFormat paramMediaFormat)
  {
    int i = parambboq.a();
    long l = parambboq.a();
    String str = parambboq.a();
    if (QLog.isColorLevel()) {
      QLog.d("SegmentManager", 2, "onEncodeVideoSegment:" + parambboq);
    }
    int j = paramMediaFormat.getInteger("width");
    int k = paramMediaFormat.getInteger("height");
    parambboq = a();
    parambboq.putString("video_slice_path", str);
    parambboq.putInt("video_slice_index", i);
    parambboq.putInt("video_slice_width", j);
    parambboq.putInt("video_slice_height", k);
    parambboq.putLong("video_slice_timestamp", l);
    this.jdField_a_of_type_Bbfs.a(200, -1, parambboq);
    if (i == 0) {
      a(str, paramMediaFormat);
    }
    if (paramBoolean)
    {
      this.h = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      parambboq = a();
      this.jdField_a_of_type_Bbfs.a(204, -1, parambboq);
      c();
    }
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
    this.jdField_a_of_type_Bbfs.a(206, -1, localBundle);
    a();
    ((Activity)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.getContext()).finish();
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
        this.jdField_a_of_type_Bboq = new bboq(d(), i);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bboq);
        if (QLog.isColorLevel()) {
          QLog.d("SegmentManager", 2, "Muxer_Start :" + this.jdField_a_of_type_Bboq);
        }
        this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_Bboq.a(), 0);
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
    paramMessage = (bbmp)paramMessage.obj;
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
        a(this.jdField_a_of_type_Bboq, false, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
        this.jdField_a_of_type_Bboq = new bboq(d(), i);
        this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bboq);
        this.jdField_a_of_type_AndroidMediaMediaMuxer = new MediaMuxer(this.jdField_a_of_type_Bboq.a(), 0);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
        this.jdField_a_of_type_AndroidMediaMediaMuxer.start();
      }
      this.jdField_a_of_type_Bboq.a(paramMessage);
      this.jdField_a_of_type_AndroidMediaMediaMuxer.writeSampleData(this.jdField_a_of_type_Int, paramMessage.jdField_a_of_type_JavaNioByteBuffer, paramMessage.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("SegmentManager", 2, "Muxer_Stop :" + this.jdField_a_of_type_Bboq);
      }
      this.jdField_a_of_type_AndroidMediaMediaMuxer.release();
      a(this.jdField_a_of_type_Bboq, true, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a());
      return true;
      return true;
      boolean bool = true;
      continue;
      label506:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbor
 * JD-Core Version:    0.7.0.1
 */