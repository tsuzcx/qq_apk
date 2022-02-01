package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;

public class PcmPlayer
{
  private int jdField_a_of_type_Int = 44100;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PcmPlayer.PlayThread jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread;
  private PcmPlayer.QQPlayerListener jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener;
  private String jdField_a_of_type_JavaLangString;
  private int b = 0;
  private int c = 2;
  private int d = 2;
  
  public PcmPlayer(Context paramContext, PcmPlayer.QQPlayerListener paramQQPlayerListener, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener = paramQQPlayerListener;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread != null) {
      return;
    }
    try
    {
      int i = AudioRecord.getMinBufferSize(this.jdField_a_of_type_Int, this.c, this.d);
      this.b = (this.jdField_a_of_type_Int / 1000 * 20 * this.d);
      this.jdField_a_of_type_AndroidMediaAudioTrack = new ReportAudioTrack(3, this.jdField_a_of_type_Int, this.c, this.d, i, 1);
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread = new PcmPlayer.PlayThread(this, null);
      this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread.start();
      if (this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener != null)
      {
        this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener.l();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("PcmPlayer", 1, "startPlay fail.", localException);
    }
  }
  
  public void b()
  {
    PcmPlayer.PlayThread localPlayThread = this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread;
    if (localPlayThread != null) {
      localPlayThread.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.chirp.PcmPlayer
 * JD-Core Version:    0.7.0.1
 */