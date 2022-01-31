import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bnnv
  extends bnnt
{
  private axvs jdField_a_of_type_Axvs;
  private axwb jdField_a_of_type_Axwb;
  
  public void a(DecodeConfig paramDecodeConfig, axvi paramaxvi, axvu paramaxvu, bnnu parambnnu)
  {
    try
    {
      this.jdField_a_of_type_Axwb = new axwb(this, paramaxvi.jdField_a_of_type_JavaLangString, paramaxvu);
      paramaxvi.jdField_a_of_type_Axwb = this.jdField_a_of_type_Axwb;
      this.jdField_a_of_type_Axvs = new axvs(paramDecodeConfig, this.jdField_a_of_type_Axwb);
      super.a(paramDecodeConfig, paramaxvi, paramaxvu, parambnnu);
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
    boolean bool2 = this.jdField_a_of_type_Axvw.a();
    if ((this.jdField_a_of_type_Axvs == null) || (this.jdField_a_of_type_Axvs.a())) {}
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
      if (this.jdField_a_of_type_Axvs != null) {
        this.jdField_a_of_type_Axvs.a();
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
    if (this.jdField_a_of_type_Axvs != null) {
      this.jdField_a_of_type_Axvs.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnv
 * JD-Core Version:    0.7.0.1
 */