package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
import ueu;

public class AudioPlayback
{
  public static long a;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 8192;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private AudioPlayback.AudioThread jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread;
  protected ueu a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private float jdField_b_of_type_Float = 1.0F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int e = 0;
  private int f = 3;
  
  static
  {
    jdField_a_of_type_Long = -9223372036854775808L;
  }
  
  public AudioPlayback()
  {
    this.jdField_a_of_type_Ueu = new ueu();
  }
  
  @TargetApi(16)
  private boolean a(MediaFormat paramMediaFormat)
  {
    return (this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("channel-count") != paramMediaFormat.getInteger("channel-count")) || (this.jdField_a_of_type_AndroidMediaMediaFormat.getInteger("sample-rate") != paramMediaFormat.getInteger("sample-rate")) || (!this.jdField_a_of_type_AndroidMediaMediaFormat.getString("mime").equals(paramMediaFormat.getString("mime")));
  }
  
  private void b(boolean paramBoolean)
  {
    if (a())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.interrupt();
      }
      this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
      this.jdField_a_of_type_AndroidMediaAudioTrack.release();
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack = null;
  }
  
  private long d()
  {
    return ((0xFFFFFFFF & this.jdField_a_of_type_AndroidMediaAudioTrack.getPlaybackHeadPosition()) / this.jdField_c_of_type_Int * 1000000.0D);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public long a()
  {
    return (ueu.a(this.jdField_a_of_type_Ueu) / this.jdField_b_of_type_Int / this.jdField_c_of_type_Int * 1000000.0D);
  }
  
  public void a()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.a(false);
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(float paramFloat)
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidMediaAudioTrack.setPlaybackRate((int)(this.jdField_c_of_type_Int * paramFloat));
      return;
    }
    throw new IllegalStateException();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    if (this.jdField_a_of_type_AndroidMediaAudioTrack != null) {
      this.jdField_a_of_type_AndroidMediaAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (a()) {
      throw new IllegalStateException("cannot set session id on an initialized audio track");
    }
    this.e = paramInt;
  }
  
  @TargetApi(16)
  public void a(MediaFormat paramMediaFormat)
  {
    Log.d("AudioPlayback", "init");
    boolean bool;
    label44:
    int j;
    int i;
    if (a())
    {
      if (!a(paramMediaFormat))
      {
        this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
        return;
      }
      bool = b();
      b();
      b(false);
      this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      j = paramMediaFormat.getInteger("channel-count");
      this.jdField_b_of_type_Int = (2 * j);
      this.jdField_c_of_type_Int = paramMediaFormat.getInteger("sample-rate");
      switch (j)
      {
      case 3: 
      case 5: 
      case 7: 
      default: 
        i = 1;
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Int = (j * this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(this.f, this.jdField_c_of_type_Int, i, 2, this.jdField_d_of_type_Int, 1, this.e);
      this.e = this.jdField_a_of_type_AndroidMediaAudioTrack.getAudioSessionId();
      this.f = this.jdField_a_of_type_AndroidMediaAudioTrack.getStreamType();
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      this.jdField_c_of_type_Long = jdField_a_of_type_Long;
      if (!bool) {
        break;
      }
      a();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread = new AudioPlayback.AudioThread(this);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.start();
      bool = false;
      break label44;
      i = 4;
      continue;
      i = 12;
      continue;
      i = 204;
      continue;
      i = 252;
      continue;
      i = 1020;
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = paramByteBuffer.remaining();
    if (this.jdField_a_of_type_Int < i)
    {
      Log.d("AudioPlayback", "incoming frame chunk size increased to " + i);
      this.jdField_a_of_type_Int = i;
      a(this.jdField_a_of_type_AndroidMediaMediaFormat);
    }
    if (this.jdField_c_of_type_Long == jdField_a_of_type_Long)
    {
      this.jdField_c_of_type_Long = paramLong;
      this.jdField_d_of_type_Long = 0L;
      long l = d();
      if (l > 0L)
      {
        this.jdField_c_of_type_Long -= l;
        Log.d("AudioPlayback", "playback head not reset");
      }
    }
    this.jdField_a_of_type_Ueu.a(paramByteBuffer, paramLong);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (a())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.a(true);
      this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
      if (paramBoolean) {
        c();
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidMediaAudioTrack != null;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public long b()
  {
    return (this.jdField_d_of_type_Int / this.jdField_b_of_type_Int / this.jdField_c_of_type_Int * 1000000.0D);
  }
  
  public void b()
  {
    a(true);
  }
  
  protected void b(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = paramByteBuffer.remaining();
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length < i)) {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
    }
    paramByteBuffer.get(this.jdField_a_of_type_ArrayOfByte, 0, i);
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_a_of_type_ArrayOfByte, 0, i);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_AndroidMediaAudioTrack.getPlayState() == 3;
  }
  
  public long c()
  {
    if (this.jdField_c_of_type_Long == jdField_a_of_type_Long) {
      return jdField_a_of_type_Long;
    }
    long l = d();
    if (l < this.jdField_d_of_type_Long)
    {
      Log.d("AudioPlayback", "playback head has wrapped");
      this.jdField_c_of_type_Long += (-1.0D / this.jdField_c_of_type_Int * 1000000.0D);
    }
    this.jdField_d_of_type_Long = l;
    return l + this.jdField_c_of_type_Long;
  }
  
  public void c()
  {
    if (a())
    {
      boolean bool = b();
      if (bool) {
        this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
      }
      this.jdField_a_of_type_AndroidMediaAudioTrack.flush();
      this.jdField_a_of_type_Ueu.a();
      this.jdField_c_of_type_Long = jdField_a_of_type_Long;
      if (bool) {
        this.jdField_a_of_type_AndroidMediaAudioTrack.play();
      }
      return;
    }
    throw new IllegalStateException();
  }
  
  public void d()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback
 * JD-Core Version:    0.7.0.1
 */