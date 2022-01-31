package com.tencent.image;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
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
    label126:
    long l2;
    try
    {
      NativeVideoImage.access$302(this.this$0, false);
      if (this.this$0.mAudioTrack == null) {
        this.this$0.initAudioTrack();
      }
      l1 = System.currentTimeMillis();
      if (this.this$0.mAudioTrack == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "mAudioTrack == null, return.. ");
        }
        if (this.this$0.mAudioTrack == null) {}
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          long l1;
          this.this$0.mAudioTrack.stop();
          if (this.this$0.mAudioTrack == null) {
            continue;
          }
          this.this$0.mAudioTrack.release();
          localObject4 = this.this$0;
        }
        catch (IllegalStateException localIllegalStateException2)
        {
          QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException2);
          if (this.this$0.mAudioTrack == null) {
            continue;
          }
          this.this$0.mAudioTrack.release();
          localNativeVideoImage2 = this.this$0;
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
        ((NativeVideoImage)localObject4).mAudioTrack = null;
        if (this.this$0.mRequireAudioFocus) {
          AudioUtils.abandonAudioFoucus();
        }
        NativeVideoImage.access$302(this.this$0, true);
        if (QLog.isColorLevel())
        {
          localObject4 = NativeVideoImage.TAG_AUDIO;
          continue;
          localObject12 = finally;
          throw localObject12;
        }
      }
    }
    finally
    {
      for (;;)
      {
        if (this.this$0.mAudioTrack != null) {}
        try
        {
          this.this$0.mAudioTrack.stop();
          if (this.this$0.mAudioTrack == null) {
            break label1087;
          }
          this.this$0.mAudioTrack.release();
          localObject4 = this.this$0;
        }
        catch (IllegalStateException localIllegalStateException1)
        {
          for (;;)
          {
            QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException1);
            if (this.this$0.mAudioTrack != null)
            {
              this.this$0.mAudioTrack.release();
              localNativeVideoImage1 = this.this$0;
            }
          }
        }
        finally
        {
          if (this.this$0.mAudioTrack == null) {
            break;
          }
          this.this$0.mAudioTrack.release();
          this.this$0.mAudioTrack = null;
        }
        ((NativeVideoImage)localObject4).mAudioTrack = null;
        if (this.this$0.mRequireAudioFocus) {
          AudioUtils.abandonAudioFoucus();
        }
        NativeVideoImage.access$302(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
        }
        throw localObject13;
        i = 0;
        break label1625;
        NativeVideoImage.access$602(this.this$0, i);
        break label1625;
        l2 = i;
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
          while (!NativeVideoImage.access$800(this.this$0))
          {
            if (QLog.isColorLevel()) {
              QLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode begin to wait....");
            }
            NativeVideoImage.access$700(this.this$0).wait();
            if (QLog.isColorLevel()) {
              QLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode finish wait....");
            }
          }
        }
      }
    }
    try
    {
      this.this$0.mAudioTrack.stop();
      if (this.this$0.mAudioTrack == null) {
        break label132;
      }
      this.this$0.mAudioTrack.release();
      ??? = this.this$0;
    }
    catch (IllegalStateException localIllegalStateException3)
    {
      QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException3);
      if (this.this$0.mAudioTrack == null) {
        break label132;
      }
      this.this$0.mAudioTrack.release();
      localNativeVideoImage3 = this.this$0;
      break label126;
    }
    finally
    {
      if (this.this$0.mAudioTrack == null) {
        break label1469;
      }
      this.this$0.mAudioTrack.release();
      this.this$0.mAudioTrack = null;
    }
    ((NativeVideoImage)???).mAudioTrack = null;
    label132:
    if (this.this$0.mRequireAudioFocus) {
      AudioUtils.abandonAudioFoucus();
    }
    NativeVideoImage.access$302(this.this$0, true);
    if (QLog.isColorLevel()) {
      ??? = NativeVideoImage.TAG_AUDIO;
    }
    label412:
    label698:
    long l4;
    for (;;)
    {
      QLog.d((String)???, 2, "PlayAudioThread run over");
      label662:
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
                  if (QLog.isColorLevel()) {
                    QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "begin wait ===> ");
                  }
                  if (this.this$0.mRequireAudioFocus) {
                    AudioUtils.abandonAudioFoucus();
                  }
                  AbstractVideoImage.sPauseLock.wait();
                  if (QLog.isColorLevel()) {
                    QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + " wait end <=== ");
                  }
                  if (this.this$0.mRequireAudioFocus) {
                    AudioUtils.requesetAudioFoucus();
                  }
                }
                catch (Exception localException2) {}
              }
              if (this.this$0.mPlayAudioFrame) {
                break label698;
              }
              if (QLog.isColorLevel()) {
                QLog.i(NativeVideoImage.TAG_AUDIO, 2, "mPlayAudioFrame is false, so quit audio decode... ");
              }
              if (this.this$0.mAudioTrack != null) {}
              try
              {
                this.this$0.mAudioTrack.stop();
                if (this.this$0.mAudioTrack == null) {
                  break label412;
                }
                this.this$0.mAudioTrack.release();
                ??? = this.this$0;
              }
              catch (IllegalStateException localIllegalStateException5)
              {
                for (;;)
                {
                  int i;
                  QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException5);
                  if (this.this$0.mAudioTrack != null)
                  {
                    this.this$0.mAudioTrack.release();
                    localNativeVideoImage5 = this.this$0;
                  }
                }
              }
              finally
              {
                if (this.this$0.mAudioTrack == null) {
                  break label1619;
                }
                this.this$0.mAudioTrack.release();
                this.this$0.mAudioTrack = null;
              }
              ((NativeVideoImage)???).mAudioTrack = null;
              if (this.this$0.mRequireAudioFocus) {
                AudioUtils.abandonAudioFoucus();
              }
              NativeVideoImage.access$302(this.this$0, true);
              if (!QLog.isColorLevel()) {
                continue;
              }
              ??? = NativeVideoImage.TAG_AUDIO;
            }
            l1 = l2;
          }
          catch (AVideoException localAVideoException)
          {
            l2 = System.currentTimeMillis();
            if (l1 - l2 <= 300000L) {
              break label1622;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          l1 = l2;
          if (this.this$0.debug)
          {
            QLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame ", localAVideoException);
            l1 = l2;
          }
        }
        i = localAVideoException.mErrCode;
        if ((i != -116) && (i != -110)) {
          break label1244;
        }
        if (QLog.isColorLevel()) {
          QLog.d(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, AudioDecode end...");
        }
        if (this.this$0.mPlayAudioOnceFinished) {
          break label1166;
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
          if (this.this$0.mAudioTrack == null) {
            break label662;
          }
          this.this$0.mAudioTrack.release();
          ??? = this.this$0;
        }
        catch (IllegalStateException localIllegalStateException4)
        {
          for (;;)
          {
            QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException4);
            if (this.this$0.mAudioTrack != null)
            {
              this.this$0.mAudioTrack.release();
              localNativeVideoImage4 = this.this$0;
            }
          }
        }
        finally
        {
          if (this.this$0.mAudioTrack == null) {
            break label1544;
          }
          this.this$0.mAudioTrack.release();
          this.this$0.mAudioTrack = null;
        }
        ((NativeVideoImage)???).mAudioTrack = null;
        if (this.this$0.mRequireAudioFocus) {
          AudioUtils.abandonAudioFoucus();
        }
        NativeVideoImage.access$302(this.this$0, true);
      } while (!QLog.isColorLevel());
      ??? = NativeVideoImage.TAG_AUDIO;
      continue;
      if (QLog.isColorLevel()) {
        QLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame: before <<<=== ");
      }
      l4 = System.currentTimeMillis();
    }
    for (;;)
    {
      AbstractAVDecode localAbstractAVDecode;
      long l3;
      Object localObject1;
      Object localObject4;
      label1087:
      label1244:
      NativeVideoImage localNativeVideoImage1;
      label1166:
      NativeVideoImage localNativeVideoImage2;
      NativeVideoImage localNativeVideoImage3;
      label1469:
      NativeVideoImage localNativeVideoImage4;
      label1544:
      NativeVideoImage localNativeVideoImage5;
      label1619:
      label1622:
      break;
      label1625:
      l4 = l2 - l4;
      long l5 = l3 - l2;
      if (l4 < 1L) {
        if (l5 < 1L) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.PlayAudioThread
 * JD-Core Version:    0.7.0.1
 */