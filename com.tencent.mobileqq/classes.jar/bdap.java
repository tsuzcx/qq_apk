import android.media.MediaFormat;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder.HwEncode;
import com.tencent.qphone.base.util.QLog;

public class bdap
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public boolean a;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  public boolean b;
  public boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  
  public bdap(SVHwEncoder.HwEncode paramHwEncode) {}
  
  public void a()
  {
    a("releaseMuxer[resetValidData]");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
    this.g = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public void a(MediaFormat paramMediaFormat)
  {
    if ((paramMediaFormat.containsKey("csd-0")) && (paramMediaFormat.containsKey("csd-1"))) {
      this.d = true;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVHwEncoder", 2, paramString + ": mHasKeyFrame=" + this.jdField_a_of_type_Boolean + " mVideoFirst=" + this.jdField_b_of_type_Boolean + " mFirstIsKey=" + this.c + " mVideoConfigOK=" + this.d + " mAudioConfigOK=" + this.e + " mVideoMuxeredframeCount=" + SVHwEncoder.HwEncode.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode) + " mAudioMuxeredframeCount=" + SVHwEncoder.HwEncode.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode) + " mVideoOrderError=" + this.f + " mAudioOrderError=" + this.g + " mVideoOrderErrorCnt=" + this.jdField_a_of_type_Int + " mAudioOrderErrorCnt=" + this.jdField_b_of_type_Int);
    }
  }
  
  boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0.a("releaseMuxer[audioSpecOK]", "mNeedEncodeAudio=" + SVHwEncoder.HwEncode.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode) + " mAudioConfigOK=" + this.e);
    if (SVHwEncoder.HwEncode.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode)) {
      return this.e;
    }
    return true;
  }
  
  public boolean a(long paramLong, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Long <= paramLong) {
        break label83;
      }
      this.f = true;
      this.jdField_a_of_type_Int += 1;
    }
    label83:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      this.jdField_a_of_type_Long = paramLong;
      return paramBoolean;
      if (this.jdField_b_of_type_Long > paramLong)
      {
        this.g = true;
        this.jdField_b_of_type_Int += 1;
      }
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        this.jdField_b_of_type_Long = paramLong;
        return paramBoolean;
      }
    }
  }
  
  public void b(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat.containsKey("csd-0")) {
      this.e = true;
    }
  }
  
  boolean b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode.this$0.a("releaseMuxer[videoSpecOK]", "mNeedEncodeVideo=" + SVHwEncoder.HwEncode.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode) + " mVideoConfigOK=" + this.d);
    return (!SVHwEncoder.HwEncode.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder$HwEncode)) || ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c) && (this.d) && (!this.f));
  }
  
  public boolean c()
  {
    return (a()) && (b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdap
 * JD-Core Version:    0.7.0.1
 */