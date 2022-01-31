import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bjgx
  extends bjgv
{
  private auzp jdField_a_of_type_Auzp;
  private auzy jdField_a_of_type_Auzy;
  
  public void a(DecodeConfig paramDecodeConfig, auzf paramauzf, auzr paramauzr, bjgw parambjgw)
  {
    try
    {
      this.jdField_a_of_type_Auzy = new auzy(this, paramauzf.jdField_a_of_type_JavaLangString, paramauzr);
      paramauzf.jdField_a_of_type_Auzy = this.jdField_a_of_type_Auzy;
      this.jdField_a_of_type_Auzp = new auzp(paramDecodeConfig, this.jdField_a_of_type_Auzy);
      super.a(paramDecodeConfig, paramauzf, paramauzr, parambjgw);
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
    boolean bool2 = this.jdField_a_of_type_Auzt.a();
    if ((this.jdField_a_of_type_Auzp == null) || (this.jdField_a_of_type_Auzp.a())) {}
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
      if (this.jdField_a_of_type_Auzp != null) {
        this.jdField_a_of_type_Auzp.a();
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
    if (this.jdField_a_of_type_Auzp != null) {
      this.jdField_a_of_type_Auzp.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjgx
 * JD-Core Version:    0.7.0.1
 */