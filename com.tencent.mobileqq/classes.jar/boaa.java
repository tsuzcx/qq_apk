import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class boaa
  extends bnzy
{
  private bagh jdField_a_of_type_Bagh;
  private bagq jdField_a_of_type_Bagq;
  
  public void a(DecodeConfig paramDecodeConfig, bafx parambafx, bagj parambagj, bnzz parambnzz)
  {
    try
    {
      this.jdField_a_of_type_Bagq = new bagq(this, parambafx.jdField_a_of_type_JavaLangString, parambagj);
      parambafx.jdField_a_of_type_Bagq = this.jdField_a_of_type_Bagq;
      this.jdField_a_of_type_Bagh = new bagh(paramDecodeConfig, this.jdField_a_of_type_Bagq);
      super.a(paramDecodeConfig, parambafx, parambagj, parambnzz);
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
    boolean bool2 = this.jdField_a_of_type_Bagl.a();
    if ((this.jdField_a_of_type_Bagh == null) || (this.jdField_a_of_type_Bagh.a())) {}
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
      if (this.jdField_a_of_type_Bagh != null) {
        this.jdField_a_of_type_Bagh.a();
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
    if (this.jdField_a_of_type_Bagh != null) {
      this.jdField_a_of_type_Bagh.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boaa
 * JD-Core Version:    0.7.0.1
 */