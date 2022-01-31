package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.tencent.qphone.base.util.QLog;
import zhs;

public class PcmPlayer
{
  private int jdField_a_of_type_Int = 44100;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PcmPlayer.PlayThread jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread;
  private String jdField_a_of_type_JavaLangString;
  private zhs jdField_a_of_type_Zhs;
  private int b;
  private int c = 2;
  private int d = 2;
  
  public PcmPlayer(Context paramContext, zhs paramzhs, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Zhs = paramzhs;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread != null) {}
    for (;;)
    {
      return;
      try
      {
        int i = AudioRecord.getMinBufferSize(this.jdField_a_of_type_Int, this.c, this.d);
        this.b = (this.jdField_a_of_type_Int / 1000 * 20 * this.d);
        this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_a_of_type_Int, this.c, this.d, i, 1);
        this.jdField_a_of_type_AndroidMediaAudioTrack.play();
        this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread = new PcmPlayer.PlayThread(this, null);
        this.jdField_a_of_type_ComTencentChirpPcmPlayer$PlayThread.start();
        if (this.jdField_a_of_type_Zhs != null)
        {
          this.jdField_a_of_type_Zhs.j();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("PcmPlayer", 1, "startPlay fail.", localException);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.chirp.PcmPlayer
 * JD-Core Version:    0.7.0.1
 */