package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.aelight.camera.aeeditor.module.autotemplate.FrameExtractor;
import com.tencent.aelight.camera.aeeditor.module.autotemplate.FrameExtractor.MediaWithType;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.ArrayList;
import java.util.List;

class MultiVideoAIFilterProxy$1
  implements Runnable
{
  MultiVideoAIFilterProxy$1(MultiVideoAIFilterProxy paramMultiVideoAIFilterProxy, List paramList, Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback) {}
  
  public void run()
  {
    if (this.this$0.g != null)
    {
      AEQLog.a(MultiVideoAIFilterProxy.f(), "getVideoFrame start");
      Object localObject1 = new ArrayList();
      int i = 0;
      while (i < this.this$0.g.getMediaModel().getMediaResourceModel().getVideos().size())
      {
        localObject2 = (MediaClipModel)this.this$0.g.getMediaModel().getMediaResourceModel().getVideos().get(i);
        if (((MediaClipModel)localObject2).getResource().getPath() != null) {
          ((List)localObject1).add(new FrameExtractor.MediaWithType(((MediaClipModel)localObject2).getResource().getPath(), ((MediaClipModel)localObject2).getResource().getType(), ((MediaClipModel)localObject2).getResource().getSourceTimeDuration()));
        }
        i += 1;
      }
      Object localObject2 = new FrameExtractor();
      this.this$0.b = ((FrameExtractor)localObject2).a((List)localObject1, this.a, 250);
      AEQLog.a(MultiVideoAIFilterProxy.f(), "getVideoFrame end");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get covers num =");
      ((StringBuilder)localObject1).append(this.this$0.b.size());
      Logger.i("Cover", ((StringBuilder)localObject1).toString());
      localObject1 = this.this$0;
      ((MultiVideoAIFilterProxy)localObject1).a = ((MultiVideoAIFilterProxy)localObject1).b.size();
      localObject1 = this.this$0;
      ((MultiVideoAIFilterProxy)localObject1).a(this.b, ((MultiVideoAIFilterProxy)localObject1).b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.MultiVideoAIFilterProxy.1
 * JD-Core Version:    0.7.0.1
 */