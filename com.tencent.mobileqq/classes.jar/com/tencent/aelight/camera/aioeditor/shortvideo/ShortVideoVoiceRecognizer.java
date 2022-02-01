package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.Context;
import com.tencent.biz.qqstory.utils.ffmpeg.resampling.SSRC;
import com.tencent.mobileqq.videocodec.audio.AudioCapture;
import com.tencent.ttpic.openapi.initializer.Voice2TextInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.voicechanger.common.audio.VoiceTextRecognizer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ShortVideoVoiceRecognizer
{
  private static String jdField_a_of_type_JavaLangString = "wx7d02f7e92ea2884d";
  private AudioCapture jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture;
  private boolean jdField_a_of_type_Boolean;
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.b(false);
      this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.b();
      VoiceTextRecognizer.getInstance().destroy();
    }
  }
  
  public void a(Context paramContext, AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
    FeatureManager.Features.VOICE_TO_TEXT.init();
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture = paramAudioCapture;
    VoiceTextRecognizer.setWxVoiceRecognizerAppid(jdField_a_of_type_JavaLangString);
    VoiceTextRecognizer.getInstance().init(paramContext, false);
    VoiceTextRecognizer.getInstance().setVRErrorListener(new ShortVideoVoiceRecognizer.1(this));
    VoiceTextRecognizer.getInstance().start();
    paramAudioCapture.b(true);
    paramAudioCapture.e();
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt2 > 0))
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(Math.max((int)Math.ceil(paramInt2 * 16000 / this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.a()), 1));
      try
      {
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioCapture.a();
        try
        {
          new SSRC(localByteArrayInputStream, localByteArrayOutputStream, paramInt1, 16000, 2, 2, 1, paramInt2, 0.0D, 0, true);
        }
        catch (Exception paramArrayOfByte) {}
        paramArrayOfByte.printStackTrace();
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      VoiceTextRecognizer.getInstance().recognizeFromPCMBuffer(paramArrayOfByte, paramArrayOfByte.length);
      try
      {
        localByteArrayInputStream.close();
        localByteArrayOutputStream.close();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoVoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */