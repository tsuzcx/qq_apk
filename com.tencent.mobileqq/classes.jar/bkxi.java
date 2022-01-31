import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bkxi
  extends bkxg
{
  private avzi jdField_a_of_type_Avzi;
  private avzr jdField_a_of_type_Avzr;
  
  public void a(DecodeConfig paramDecodeConfig, avyy paramavyy, avzk paramavzk, bkxh parambkxh)
  {
    try
    {
      this.jdField_a_of_type_Avzr = new avzr(this, paramavyy.jdField_a_of_type_JavaLangString, paramavzk);
      paramavyy.jdField_a_of_type_Avzr = this.jdField_a_of_type_Avzr;
      this.jdField_a_of_type_Avzi = new avzi(paramDecodeConfig, this.jdField_a_of_type_Avzr);
      super.a(paramDecodeConfig, paramavyy, paramavzk, parambkxh);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Mp4ReEncoderWithAudio", 1, "startEncode,", localException);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = this.jdField_a_of_type_Avzm.a();
    if ((this.jdField_a_of_type_Avzi == null) || (this.jdField_a_of_type_Avzi.a())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Mp4ReEncoderWithAudio", 2, new Object[] { "startEncode,", Boolean.valueOf(bool2), " ", Boolean.valueOf(bool1) });
      }
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void onDecodeFinish()
  {
    super.onDecodeFinish();
    try
    {
      if (this.jdField_a_of_type_Avzi != null) {
        this.jdField_a_of_type_Avzi.a();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    super.onFrameAvailable(paramSurfaceTexture);
    if (this.jdField_a_of_type_Avzi != null) {
      this.jdField_a_of_type_Avzi.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxi
 * JD-Core Version:    0.7.0.1
 */