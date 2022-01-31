import android.media.MediaFormat;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;

class aopy
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  
  aopy(aopu paramaopu) {}
  
  void a()
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
  
  void a(MediaFormat paramMediaFormat)
  {
    if ((paramMediaFormat.containsKey("csd-0")) && (paramMediaFormat.containsKey("csd-1"))) {
      this.d = true;
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVHwEncoder", 2, paramString + ": mHasKeyFrame=" + this.jdField_a_of_type_Boolean + " mVideoFirst=" + this.jdField_b_of_type_Boolean + " mFirstIsKey=" + this.c + " mVideoConfigOK=" + this.d + " mAudioConfigOK=" + this.e + " mVideoMuxeredframeCount=" + aopu.a(this.jdField_a_of_type_Aopu) + " mAudioMuxeredframeCount=" + aopu.b(this.jdField_a_of_type_Aopu) + " mVideoOrderError=" + this.f + " mAudioOrderError=" + this.g + " mVideoOrderErrorCnt=" + this.jdField_a_of_type_Int + " mAudioOrderErrorCnt=" + this.jdField_b_of_type_Int);
    }
  }
  
  boolean a()
  {
    this.jdField_a_of_type_Aopu.a.a("releaseMuxer[audioSpecOK]", "mNeedEncodeAudio=" + aopu.a(this.jdField_a_of_type_Aopu) + " mAudioConfigOK=" + this.e);
    if (aopu.a(this.jdField_a_of_type_Aopu)) {
      return this.e;
    }
    return true;
  }
  
  boolean a(long paramLong, boolean paramBoolean)
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
  
  void b(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat.containsKey("csd-0")) {
      this.e = true;
    }
  }
  
  boolean b()
  {
    this.jdField_a_of_type_Aopu.a.a("releaseMuxer[videoSpecOK]", "mNeedEncodeVideo=" + aopu.b(this.jdField_a_of_type_Aopu) + " mVideoConfigOK=" + this.d);
    return (!aopu.b(this.jdField_a_of_type_Aopu)) || ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.c) && (this.d) && (!this.f));
  }
  
  boolean c()
  {
    return (a()) && (b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aopy
 * JD-Core Version:    0.7.0.1
 */