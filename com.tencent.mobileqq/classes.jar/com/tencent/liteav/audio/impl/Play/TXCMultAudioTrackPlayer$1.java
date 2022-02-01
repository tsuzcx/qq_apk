package com.tencent.liteav.audio.impl.Play;

import android.media.AudioTrack;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.Arrays;

class TXCMultAudioTrackPlayer$1
  extends TXCMultAudioTrackPlayer.AudioTrackThread
{
  TXCMultAudioTrackPlayer$1(TXCMultAudioTrackPlayer paramTXCMultAudioTrackPlayer, String paramString)
  {
    super(paramTXCMultAudioTrackPlayer, paramString);
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (TXCMultAudioTrackPlayer.access$100(this.this$0) != 1) {
          break label508;
        }
        i = 2;
        if (TXCMultAudioTrackPlayer.access$200(this.this$0) != 8) {
          break label513;
        }
        j = 3;
        int k = AudioTrack.getMinBufferSize(TXCMultAudioTrackPlayer.access$300(this.this$0), i, j);
        AudioTrack localAudioTrack = new AudioTrack(3, TXCMultAudioTrackPlayer.access$300(this.this$0), i, j, k, 1);
        Object localObject1 = TXCMultAudioTrackPlayer.access$400();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("create audio track, samplerate:");
        ((StringBuilder)localObject2).append(TXCMultAudioTrackPlayer.access$300(this.this$0));
        ((StringBuilder)localObject2).append(", channels:");
        ((StringBuilder)localObject2).append(TXCMultAudioTrackPlayer.access$100(this.this$0));
        ((StringBuilder)localObject2).append(", bits:");
        ((StringBuilder)localObject2).append(TXCMultAudioTrackPlayer.access$200(this.this$0));
        ((StringBuilder)localObject2).append(" mMinBufferLength:");
        ((StringBuilder)localObject2).append(k);
        TXCLog.i((String)localObject1, ((StringBuilder)localObject2).toString());
        try
        {
          localAudioTrack.play();
          TXCMultAudioTrackPlayer.access$502(this.this$0, true);
          localObject1 = this.this$0;
          ((TXCMultAudioTrackPlayer)localObject1).setAudioMode(TXCMultAudioTrackPlayer.access$600((TXCMultAudioTrackPlayer)localObject1), TXCMultAudioTrackPlayer.access$700(this.this$0));
          i = 100;
          j = 0;
          if (this.mIsLooping)
          {
            localObject1 = TXCMultAudioTrackPlayer.access$800(this.this$0);
            if ((localObject1 != null) && (localObject1.length > 0))
            {
              TXCAudioEngine.onCorePlayPcmData((byte[])localObject1, 0L, TXCMultAudioTrackPlayer.access$300(this.this$0), TXCMultAudioTrackPlayer.access$100(this.this$0));
              if (TXCMultAudioTrackPlayer.access$900(this.this$0)) {
                Arrays.fill((byte[])localObject1, (byte)0);
              }
              int m = i;
              k = j;
              if (i != 0)
              {
                m = i;
                k = j;
                if (j < 800)
                {
                  localObject2 = new short[localObject1.length / 2];
                  ByteBuffer.wrap((byte[])localObject1).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject2);
                  k = 0;
                  if (k < localObject2.length)
                  {
                    localObject2[k] = ((short)(localObject2[k] / i));
                    k += 1;
                    continue;
                  }
                  ByteBuffer.wrap((byte[])localObject1).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put((short[])localObject2);
                  k = j + localObject1.length / (TXCMultAudioTrackPlayer.access$300(this.this$0) * 2 / 1000);
                  m = i * (800 - k) / 800;
                }
              }
              localAudioTrack.write((byte[])localObject1, 0, localObject1.length);
              i = m;
              j = k;
              continue;
            }
          }
        }
        catch (Exception localException2)
        {
          TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "start play failed.", localException2);
          return;
        }
      }
      catch (Exception localException3)
      {
        TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "create AudioTrack failed.", localException3);
        return;
      }
      try
      {
        sleep(5L);
      }
      catch (InterruptedException localInterruptedException) {}
      try
      {
        localAudioTrack.pause();
        localAudioTrack.flush();
        localAudioTrack.stop();
        localAudioTrack.release();
      }
      catch (Exception localException1)
      {
        TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "stop AudioTrack failed.", localException1);
      }
      TXCLog.e(TXCMultAudioTrackPlayer.access$400(), "mult-player thread stop finish!");
      return;
      continue;
      label508:
      int i = 3;
      continue;
      label513:
      int j = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer.1
 * JD-Core Version:    0.7.0.1
 */