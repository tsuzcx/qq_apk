import android.content.Context;
import com.tencent.biz.qqstory.utils.ffmpeg.resampling.SSRC;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class bobr
{
  private static String jdField_a_of_type_JavaLangString = "wx7d02f7e92ea2884d";
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private boolean jdField_a_of_type_Boolean;
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b(false);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b();
      VoiceTextRecognizer.getInstance().destroy();
    }
  }
  
  public void a(Context paramContext, AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    FeatureManager.Features.VOICE_TO_TEXT.init();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = paramAudioCapture;
    VoiceTextRecognizer.setWxVoiceRecognizerAppid(jdField_a_of_type_JavaLangString);
    VoiceTextRecognizer.getInstance().init(paramContext, false);
    VoiceTextRecognizer.getInstance().setVRErrorListener(new bobs(this));
    VoiceTextRecognizer.getInstance().start();
    paramAudioCapture.b(true);
    paramAudioCapture.c();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if ((this.jdField_a_of_type_Boolean) && (paramInt2 > 0))
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
      localByteArrayOutputStream = new ByteArrayOutputStream(Math.max((int)Math.ceil(paramInt2 * 16000 / this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a()), 1));
    }
    try
    {
      new SSRC(paramArrayOfByte, localByteArrayOutputStream, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.a(), 16000, 2, 2, 1, paramInt2, 0.0D, 0, true);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(arrayOfByte, arrayOfByte.length);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          paramArrayOfByte.close();
          localByteArrayOutputStream.close();
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
        localException = localException;
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobr
 * JD-Core Version:    0.7.0.1
 */