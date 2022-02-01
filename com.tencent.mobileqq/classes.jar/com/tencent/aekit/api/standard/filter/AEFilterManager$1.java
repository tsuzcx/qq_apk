package com.tencent.aekit.api.standard.filter;

import android.media.AudioTrack;
import android.support.annotation.RequiresApi;
import com.tencent.ttpic.baseutils.log.LogUtils;
import org.light.AudioFrame;
import org.light.AudioOutput;

class AEFilterManager$1
  implements Runnable
{
  AEFilterManager$1(AEFilterManager paramAEFilterManager) {}
  
  @RequiresApi(api=21)
  public void run()
  {
    try
    {
      if (AEFilterManager.access$000(this.this$0) != null)
      {
        for (AudioFrame localAudioFrame = AEFilterManager.access$000(this.this$0).copyNextSample(); localAudioFrame != null; localAudioFrame = AEFilterManager.access$000(this.this$0).copyNextSample())
        {
          AEFilterManager.access$100(this.this$0).play();
          AEFilterManager.access$100(this.this$0).write(localAudioFrame.data, (int)localAudioFrame.length, 0);
        }
        if ((AEFilterManager.access$100(this.this$0) != null) && (AEFilterManager.access$100(this.this$0).getState() == 1)) {
          AEFilterManager.access$100(this.this$0).stop();
        }
      }
      else
      {
        LogUtils.e("AEFilterManager", "audioReader is null!");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFilterManager.1
 * JD-Core Version:    0.7.0.1
 */