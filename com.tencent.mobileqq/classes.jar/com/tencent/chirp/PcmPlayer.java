package com.tencent.chirp;

import android.content.Context;
import android.media.AudioRecord;
import android.media.AudioTrack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;

public class PcmPlayer
{
  private AudioTrack a;
  private int b = 44100;
  private int c = 0;
  private int d = 2;
  private int e = 2;
  private String f;
  private PcmPlayer.PlayThread g;
  private Context h;
  private PcmPlayer.QQPlayerListener i;
  
  public PcmPlayer(Context paramContext, PcmPlayer.QQPlayerListener paramQQPlayerListener, int paramInt, String paramString)
  {
    this.h = paramContext;
    this.i = paramQQPlayerListener;
    this.b = paramInt;
    this.f = paramString;
  }
  
  public void a()
  {
    if (this.g != null) {
      return;
    }
    try
    {
      int j = AudioRecord.getMinBufferSize(this.b, this.d, this.e);
      this.c = (this.b / 1000 * 20 * this.e);
      this.a = new ReportAudioTrack(3, this.b, this.d, this.e, j, 1);
      this.a.play();
      this.g = new PcmPlayer.PlayThread(this, null);
      this.g.start();
      if (this.i != null)
      {
        this.i.n();
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
    PcmPlayer.PlayThread localPlayThread = this.g;
    if (localPlayThread != null) {
      localPlayThread.a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.chirp.PcmPlayer
 * JD-Core Version:    0.7.0.1
 */