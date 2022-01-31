import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodeConfig;
import com.tencent.qphone.base.util.QLog;

public class bkxz
  extends bkxx
{
  private avzk jdField_a_of_type_Avzk;
  private avzt jdField_a_of_type_Avzt;
  
  public void a(DecodeConfig paramDecodeConfig, avza paramavza, avzm paramavzm, bkxy parambkxy)
  {
    try
    {
      this.jdField_a_of_type_Avzt = new avzt(this, paramavza.jdField_a_of_type_JavaLangString, paramavzm);
      paramavza.jdField_a_of_type_Avzt = this.jdField_a_of_type_Avzt;
      this.jdField_a_of_type_Avzk = new avzk(paramDecodeConfig, this.jdField_a_of_type_Avzt);
      super.a(paramDecodeConfig, paramavza, paramavzm, parambkxy);
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
    boolean bool2 = this.jdField_a_of_type_Avzo.a();
    if ((this.jdField_a_of_type_Avzk == null) || (this.jdField_a_of_type_Avzk.a())) {}
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
      if (this.jdField_a_of_type_Avzk != null) {
        this.jdField_a_of_type_Avzk.a();
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
    if (this.jdField_a_of_type_Avzk != null) {
      this.jdField_a_of_type_Avzk.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkxz
 * JD-Core Version:    0.7.0.1
 */