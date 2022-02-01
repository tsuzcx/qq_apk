package com.tencent.image;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.video.decode.AVideoException;
import com.tencent.video.decode.AbstractAVDecode;

class NativeVideoImage$PlayAudioThread
  extends Thread
{
  static final int LIMIT_TIME_USED = 1;
  
  public NativeVideoImage$PlayAudioThread(NativeVideoImage paramNativeVideoImage, String paramString)
  {
    setName(paramString + "-" + getId());
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        NativeVideoImage.access$302(this.this$0, false);
        if (this.this$0.mAudioTrack == null) {
          this.this$0.initAudioTrack();
        }
        l1 = System.currentTimeMillis();
        if (this.this$0.mAudioTrack != null) {
          continue;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "mAudioTrack == null, return.. ");
        }
        if (this.this$0.mAudioTrack == null) {}
      }
      catch (Exception localException1)
      {
        try
        {
          long l1;
          this.this$0.mAudioTrack.stop();
        }
        catch (IllegalStateException localIllegalStateException4)
        {
          URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException4);
          if (this.this$0.mAudioTrack == null) {
            continue;
          }
          this.this$0.mAudioTrack.release();
          this.this$0.mAudioTrack = null;
          continue;
        }
        finally
        {
          if (this.this$0.mAudioTrack == null) {
            continue;
          }
          this.this$0.mAudioTrack.release();
          this.this$0.mAudioTrack = null;
        }
        if (!this.this$0.mRequireAudioFocus) {
          continue;
        }
        AudioUtils.abandonAudioFoucus();
        NativeVideoImage.access$302(this.this$0, true);
        if (!URLDrawable.depImp.mLog.isColorLevel()) {
          continue;
        }
        URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
        return;
        localObject12 = finally;
        throw localObject12;
      }
      finally
      {
        long l3;
        if (this.this$0.mAudioTrack == null) {
          continue;
        }
        try
        {
          this.this$0.mAudioTrack.stop();
        }
        catch (IllegalStateException localIllegalStateException5)
        {
          URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException5);
          if (this.this$0.mAudioTrack == null) {
            continue;
          }
          this.this$0.mAudioTrack.release();
          this.this$0.mAudioTrack = null;
          continue;
        }
        finally
        {
          if (this.this$0.mAudioTrack == null) {
            continue;
          }
          this.this$0.mAudioTrack.release();
          this.this$0.mAudioTrack = null;
        }
        if (!this.this$0.mRequireAudioFocus) {
          continue;
        }
        AudioUtils.abandonAudioFoucus();
        NativeVideoImage.access$302(this.this$0, true);
        if (!URLDrawable.depImp.mLog.isColorLevel()) {
          continue;
        }
        URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
        throw localObject5;
        i = 0;
        continue;
        NativeVideoImage.access$602(this.this$0, i);
        continue;
        long l2 = i;
        try
        {
          Thread.sleep(l2);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
        continue;
        synchronized (NativeVideoImage.access$700(this.this$0))
        {
          if (!NativeVideoImage.access$800(this.this$0))
          {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode begin to wait....");
            }
            NativeVideoImage.access$700(this.this$0).wait();
            if (!URLDrawable.depImp.mLog.isColorLevel()) {
              continue;
            }
            URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode finish wait....");
          }
        }
        continue;
        continue;
        long l4 = l2 - l4;
        long l5 = l3 - l2;
        if (l4 >= 1L) {
          continue;
        }
        if (l5 < 1L) {
          continue;
        }
        continue;
      }
      try
      {
        this.this$0.mAudioTrack.stop();
      }
      catch (IllegalStateException localIllegalStateException1)
      {
        URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException1);
        if (this.this$0.mAudioTrack == null) {
          continue;
        }
        this.this$0.mAudioTrack.release();
        this.this$0.mAudioTrack = null;
      }
      finally
      {
        if (this.this$0.mAudioTrack == null) {
          continue;
        }
        this.this$0.mAudioTrack.release();
        this.this$0.mAudioTrack = null;
      }
    }
    if (this.this$0.mRequireAudioFocus) {
      AudioUtils.abandonAudioFoucus();
    }
    NativeVideoImage.access$302(this.this$0, true);
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
    }
    do
    {
      for (;;)
      {
        return;
        this.this$0.mAudioTrack.play();
        try
        {
          synchronized (AbstractVideoImage.sPauseLock)
          {
            while (AbstractVideoImage.sPaused)
            {
              boolean bool = this.this$0.mSupportGlobalPause;
              if (!bool) {
                break;
              }
              try
              {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                  URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "begin wait ===> ");
                }
                if (this.this$0.mRequireAudioFocus) {
                  AudioUtils.abandonAudioFoucus();
                }
                AbstractVideoImage.sPauseLock.wait();
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                  URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + " wait end <=== ");
                }
                if (this.this$0.mRequireAudioFocus) {
                  AudioUtils.requesetAudioFoucus();
                }
              }
              catch (Exception localException2) {}
            }
            if (this.this$0.mPlayAudioFrame) {
              break label915;
            }
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "mPlayAudioFrame is false, so quit audio decode... ");
            }
            if (this.this$0.mAudioTrack != null) {}
            try
            {
              this.this$0.mAudioTrack.stop();
            }
            catch (IllegalStateException localIllegalStateException3)
            {
              for (;;)
              {
                int i;
                AbstractAVDecode localAbstractAVDecode;
                Object localObject1;
                URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException3);
                if (this.this$0.mAudioTrack != null)
                {
                  this.this$0.mAudioTrack.release();
                  this.this$0.mAudioTrack = null;
                }
              }
            }
            finally
            {
              if (this.this$0.mAudioTrack == null) {
                break label1740;
              }
              this.this$0.mAudioTrack.release();
              this.this$0.mAudioTrack = null;
            }
            if (this.this$0.mRequireAudioFocus) {
              AudioUtils.abandonAudioFoucus();
            }
            NativeVideoImage.access$302(this.this$0, true);
            if (!URLDrawable.depImp.mLog.isColorLevel()) {
              continue;
            }
            URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
            return;
          }
          l1 = l2;
        }
        catch (AVideoException localAVideoException)
        {
          l2 = System.currentTimeMillis();
          if (l1 - l2 <= 300000L) {
            break label1913;
          }
        }
      }
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        l1 = l2;
        if (this.this$0.debug)
        {
          URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame ", localAVideoException);
          l1 = l2;
        }
      }
      i = localAVideoException.mErrCode;
      if ((i != -116) && (i != -110)) {
        break label1655;
      }
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, AudioDecode end...");
      }
      if (this.this$0.mPlayAudioOnceFinished) {
        break label1545;
      }
      this.this$0.mPlayAudioOnceFinished = true;
      ??? = this.this$0.mVideoParams;
      this.this$0.mPlayAudioFrame = false;
      ((VideoDrawable.VideoDrawableParams)???).mPlayAudioFrame = false;
      this.this$0.mOption.ignore_audio = true;
      NativeVideoImage.sUIHandler.post(new NativeVideoImage.PlayAudioThread.1(this));
      if (this.this$0.mAudioTrack != null) {}
      try
      {
        this.this$0.mAudioTrack.stop();
      }
      catch (IllegalStateException localIllegalStateException2)
      {
        for (;;)
        {
          URLDrawable.depImp.mLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException2);
          if (this.this$0.mAudioTrack != null)
          {
            this.this$0.mAudioTrack.release();
            this.this$0.mAudioTrack = null;
          }
        }
      }
      finally
      {
        if (this.this$0.mAudioTrack == null) {
          break label1542;
        }
        this.this$0.mAudioTrack.release();
        this.this$0.mAudioTrack = null;
      }
      if (this.this$0.mRequireAudioFocus) {
        AudioUtils.abandonAudioFoucus();
      }
      NativeVideoImage.access$302(this.this$0, true);
    } while (!URLDrawable.depImp.mLog.isColorLevel());
    URLDrawable.depImp.mLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
    return;
    label915:
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame: before <<<=== ");
    }
    l4 = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.PlayAudioThread
 * JD-Core Version:    0.7.0.1
 */