import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bnjj
  extends bnjh
{
  private axrj jdField_a_of_type_Axrj;
  private axrs jdField_a_of_type_Axrs;
  
  public void a(DecodeConfig paramDecodeConfig, axqz paramaxqz, axrl paramaxrl, bnji parambnji)
  {
    try
    {
      this.jdField_a_of_type_Axrs = new axrs(this, paramaxqz.jdField_a_of_type_JavaLangString, paramaxrl);
      paramaxqz.jdField_a_of_type_Axrs = this.jdField_a_of_type_Axrs;
      this.jdField_a_of_type_Axrj = new axrj(paramDecodeConfig, this.jdField_a_of_type_Axrs);
      super.a(paramDecodeConfig, paramaxqz, paramaxrl, parambnji);
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
    boolean bool2 = this.jdField_a_of_type_Axrn.a();
    if ((this.jdField_a_of_type_Axrj == null) || (this.jdField_a_of_type_Axrj.a())) {}
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
      if (this.jdField_a_of_type_Axrj != null) {
        this.jdField_a_of_type_Axrj.a();
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
    if (this.jdField_a_of_type_Axrj != null) {
      this.jdField_a_of_type_Axrj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjj
 * JD-Core Version:    0.7.0.1
 */