package com.tencent.biz.qqstory.playvideo.player.mediaplayer;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
import java.nio.ByteBuffer;

class AudioPlayback
{
  public static long a = -9223372036854775808L;
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 8192;
  private AudioTrack jdField_a_of_type_AndroidMediaAudioTrack;
  private MediaFormat jdField_a_of_type_AndroidMediaMediaFormat;
  private AudioPlayback.AudioThread jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread;
  protected AudioPlayback.BufferQueue a;
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
  
  public AudioPlayback()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$BufferQueue = new AudioPlayback.BufferQueue();
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
    double d1 = this.jdField_a_of_type_AndroidMediaAudioTrack.getPlaybackHeadPosition() & 0xFFFFFFFF;
    double d2 = this.jdField_c_of_type_Int;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 / d2 * 1000000.0D);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public long a()
  {
    double d1 = AudioPlayback.BufferQueue.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$BufferQueue) / this.jdField_b_of_type_Int;
    double d2 = this.jdField_c_of_type_Int;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 / d2 * 1000000.0D);
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
    AudioTrack localAudioTrack = this.jdField_a_of_type_AndroidMediaAudioTrack;
    if (localAudioTrack != null) {
      localAudioTrack.setStereoVolume(paramFloat1, paramFloat2);
    }
  }
  
  public void a(int paramInt)
  {
    if (!a())
    {
      this.e = paramInt;
      return;
    }
    throw new IllegalStateException("cannot set session id on an initialized audio track");
  }
  
  @TargetApi(16)
  public void a(MediaFormat paramMediaFormat)
  {
    Log.d("AudioPlayback", "init");
    boolean bool;
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
    }
    else
    {
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread = new AudioPlayback.AudioThread(this);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.a(true);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$AudioThread.start();
      bool = false;
    }
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    int j = paramMediaFormat.getInteger("channel-count");
    this.jdField_b_of_type_Int = (j * 2);
    this.jdField_c_of_type_Int = paramMediaFormat.getInteger("sample-rate");
    int i;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 4)
        {
          if (j != 6)
          {
            if (j != 8) {
              i = 1;
            } else {
              i = 1020;
            }
          }
          else {
            i = 252;
          }
        }
        else {
          i = 204;
        }
      }
      else {
        i = 12;
      }
    }
    else {
      i = 4;
    }
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_Int * j);
    this.jdField_a_of_type_AndroidMediaAudioTrack = new ReportAudioTrack(this.f, this.jdField_c_of_type_Int, i, 2, this.jdField_d_of_type_Int, 1, this.e);
    this.e = this.jdField_a_of_type_AndroidMediaAudioTrack.getAudioSessionId();
    this.f = this.jdField_a_of_type_AndroidMediaAudioTrack.getStreamType();
    a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    this.jdField_c_of_type_Long = jdField_a_of_type_Long;
    if (bool) {
      a();
    }
  }
  
  public void a(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = paramByteBuffer.remaining();
    if (this.jdField_a_of_type_Int < i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("incoming frame chunk size increased to ");
      localStringBuilder.append(i);
      Log.d("AudioPlayback", localStringBuilder.toString());
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
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$BufferQueue.a(paramByteBuffer, paramLong);
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
    double d1 = this.jdField_d_of_type_Int / this.jdField_b_of_type_Int;
    double d2 = this.jdField_c_of_type_Int;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (d1 / d2 * 1000000.0D);
  }
  
  public void b()
  {
    a(true);
  }
  
  protected void b(ByteBuffer paramByteBuffer, long paramLong)
  {
    int i = paramByteBuffer.remaining();
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if ((arrayOfByte == null) || (arrayOfByte.length < i)) {
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
    long l1 = this.jdField_c_of_type_Long;
    long l2 = jdField_a_of_type_Long;
    if (l1 == l2) {
      return l2;
    }
    l1 = d();
    if (l1 < this.jdField_d_of_type_Long)
    {
      Log.d("AudioPlayback", "playback head has wrapped");
      l2 = this.jdField_c_of_type_Long;
      double d1 = this.jdField_c_of_type_Int;
      Double.isNaN(d1);
      this.jdField_c_of_type_Long = (l2 + (-1.0D / d1 * 1000000.0D));
    }
    this.jdField_d_of_type_Long = l1;
    return this.jdField_c_of_type_Long + l1;
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
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerMediaplayerAudioPlayback$BufferQueue.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.mediaplayer.AudioPlayback
 * JD-Core Version:    0.7.0.1
 */