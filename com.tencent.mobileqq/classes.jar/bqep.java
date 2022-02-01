import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bqep
  extends bqen
{
  private batt jdField_a_of_type_Batt;
  private bauc jdField_a_of_type_Bauc;
  
  public void a(DecodeConfig paramDecodeConfig, batj parambatj, batv parambatv, bqeo parambqeo)
  {
    try
    {
      this.jdField_a_of_type_Bauc = new bauc(this, parambatj.jdField_a_of_type_JavaLangString, parambatv);
      parambatj.jdField_a_of_type_Bauc = this.jdField_a_of_type_Bauc;
      this.jdField_a_of_type_Batt = new batt(paramDecodeConfig, this.jdField_a_of_type_Bauc);
      super.a(paramDecodeConfig, parambatj, parambatv, parambqeo);
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
    boolean bool2 = this.jdField_a_of_type_Batx.a();
    if ((this.jdField_a_of_type_Batt == null) || (this.jdField_a_of_type_Batt.a())) {}
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
      if (this.jdField_a_of_type_Batt != null) {
        this.jdField_a_of_type_Batt.a();
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
    if (this.jdField_a_of_type_Batt != null) {
      this.jdField_a_of_type_Batt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqep
 * JD-Core Version:    0.7.0.1
 */