package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import pcx;

public class PcmPlayer
{
  private int jdField_a_of_type_Int = 44100;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private PcmPlayer.QQPlayerListener jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener;
  private String jdField_a_of_type_JavaLangString;
  private pcx jdField_a_of_type_Pcx;
  private int b;
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
    if (this.jdField_a_of_type_Pcx != null) {}
    do
    {
      return;
      int i = AudioRecord.getMinBufferSize(this.jdField_a_of_type_Int, this.c, this.d);
      this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.jdField_a_of_type_Int, this.c, this.d, i, 1);
      this.b = (this.jdField_a_of_type_Int / 1000 * 20 * this.d);
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.jdField_a_of_type_Pcx = new pcx(this, null);
      this.jdField_a_of_type_Pcx.start();
    } while (this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener == null);
    this.jdField_a_of_type_ComTencentChirpPcmPlayer$QQPlayerListener.j();
  }
  
  public void b()
  {
    pcx localpcx = this.jdField_a_of_type_Pcx;
    if (localpcx != null) {
      localpcx.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.chirp.PcmPlayer
 * JD-Core Version:    0.7.0.1
 */