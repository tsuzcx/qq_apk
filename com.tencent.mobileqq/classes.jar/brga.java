import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class brga
  extends brfy
{
  private bbmm jdField_a_of_type_Bbmm;
  private bbmv jdField_a_of_type_Bbmv;
  
  public void a(DecodeConfig paramDecodeConfig, bbmc parambbmc, bbmo parambbmo, brfz parambrfz)
  {
    try
    {
      this.jdField_a_of_type_Bbmv = new bbmv(this, parambbmc.jdField_a_of_type_JavaLangString, parambbmo);
      parambbmc.jdField_a_of_type_Bbmv = this.jdField_a_of_type_Bbmv;
      this.jdField_a_of_type_Bbmm = new bbmm(paramDecodeConfig, this.jdField_a_of_type_Bbmv);
      super.a(paramDecodeConfig, parambbmc, parambbmo, parambrfz);
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
    boolean bool2 = this.jdField_a_of_type_Bbmq.a();
    if ((this.jdField_a_of_type_Bbmm == null) || (this.jdField_a_of_type_Bbmm.a())) {}
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
      if (this.jdField_a_of_type_Bbmm != null) {
        this.jdField_a_of_type_Bbmm.a();
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
    if (this.jdField_a_of_type_Bbmm != null) {
      this.jdField_a_of_type_Bbmm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brga
 * JD-Core Version:    0.7.0.1
 */