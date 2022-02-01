import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bpps
  extends bppq
{
  private bbmw jdField_a_of_type_Bbmw;
  private bbnf jdField_a_of_type_Bbnf;
  
  public void a(DecodeConfig paramDecodeConfig, bbmm parambbmm, bbmy parambbmy, bppr parambppr)
  {
    try
    {
      this.jdField_a_of_type_Bbnf = new bbnf(this, parambbmm.jdField_a_of_type_JavaLangString, parambbmy);
      parambbmm.jdField_a_of_type_Bbnf = this.jdField_a_of_type_Bbnf;
      this.jdField_a_of_type_Bbmw = new bbmw(paramDecodeConfig, this.jdField_a_of_type_Bbnf);
      super.a(paramDecodeConfig, parambbmm, parambbmy, parambppr);
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
    boolean bool2 = this.jdField_a_of_type_Bbna.a();
    if ((this.jdField_a_of_type_Bbmw == null) || (this.jdField_a_of_type_Bbmw.a())) {}
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
      if (this.jdField_a_of_type_Bbmw != null) {
        this.jdField_a_of_type_Bbmw.a();
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
    if (this.jdField_a_of_type_Bbmw != null) {
      this.jdField_a_of_type_Bbmw.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpps
 * JD-Core Version:    0.7.0.1
 */