package com.tencent.aelight.camera.ae.play;

import android.text.TextUtils;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.videoshelf.model.VideoShelfEngine;
import java.io.File;
import java.util.Timer;

class AEVideoShelfPreviewFragment$5
  implements Runnable
{
  AEVideoShelfPreviewFragment$5(AEVideoShelfPreviewFragment paramAEVideoShelfPreviewFragment, long paramLong) {}
  
  public void run()
  {
    if (AEVideoShelfPreviewFragment.access$300(this.this$0))
    {
      Object localObject1 = AEVideoShelfPreviewFragment.access$100(this.this$0).getOutputVideoPath();
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject2).delete();
          localObject2 = AEVideoShelfPreviewFragment.access$200();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onCompletion---delete temp silent file because user cancel generation: ");
          localStringBuilder.append((String)localObject1);
          AEQLog.b((String)localObject2, localStringBuilder.toString());
        }
      }
      if (!TextUtils.isEmpty(AEVideoShelfPreviewFragment.access$500(this.this$0)))
      {
        localObject1 = new File(AEVideoShelfPreviewFragment.access$500(this.this$0));
        if (((File)localObject1).exists())
        {
          ((File)localObject1).delete();
          localObject1 = AEVideoShelfPreviewFragment.access$200();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onCompletion---delete final file because user cancel generation: ");
          ((StringBuilder)localObject2).append(AEVideoShelfPreviewFragment.access$500(this.this$0));
          AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
        }
      }
      AEVideoShelfPreviewFragment.access$602(this.this$0, false);
      return;
    }
    if ((int)AEVideoShelfPreviewFragment.access$700(this.this$0) < 100)
    {
      AEVideoShelfPreviewFragment.access$800(this.this$0, 100);
      new Timer().schedule(new AEVideoShelfPreviewFragment.5.1(this), 0L);
    }
    else
    {
      AEVideoShelfPreviewFragment.access$900(this.this$0);
    }
    AEVideoShelfPreviewFragment.access$702(this.this$0, 0.0D);
    AEVideoShelfPreviewFragment.access$1002(this.this$0, 0.0D);
    if (AEVideoShelfPreviewFragment.access$1100(this.this$0))
    {
      AEVideoShelfPreviewFragment.access$1102(this.this$0, false);
      AEVideoShelfPreviewFragment.keepScreenOn(this.this$0.getBaseActivity(), false);
    }
    AEVideoShelfPreviewFragment.access$1200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AEVideoShelfPreviewFragment.5
 * JD-Core Version:    0.7.0.1
 */