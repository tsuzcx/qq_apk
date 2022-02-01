package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.util.SparseArray;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.tavcut.util.Util;
import com.tencent.qcircle.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class AEEditorImageTemplatePanel$5$1$1
  implements OnRenderFinishListener
{
  AEEditorImageTemplatePanel$5$1$1(AEEditorImageTemplatePanel.5.1 param1) {}
  
  public void onRenderFinish()
  {
    try
    {
      AEEditorImageTemplatePanel.d(this.a.b.this$0, AEEditorImageTemplatePanel.c(this.a.b.this$0).getCurrentIndex(), this.a.a, this.a.b.a);
      AEEditorImageTemplatePanel.e(this.a.b.this$0, AEEditorImageTemplatePanel.c(this.a.b.this$0).getCurrentIndex(), this.a.a, this.a.b.a);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.a.b.this$0.setSelectedIndex(this.a.b.c, true);
    this.a.b.this$0.b.put(AEEditorImageTemplatePanel.c(this.a.b.this$0).getCurrentIndex(), this.a.b.a.id);
    AEEditorImageTemplatePanel.a(this.a.b.this$0, true);
    Object localObject1 = AEEditorImageTemplatePanel.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Pic template apply success, timecost:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.a.b.b);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = (MediaModel)AEEditorImageTemplatePanel.c(this.a.b.this$0).getMediaModels().get(AEEditorImageTemplatePanel.c(this.a.b.this$0).getCurrentIndex());
    AEEditorImageTemplatePanel.e(this.a.b.this$0).put(Integer.valueOf(AEEditorImageTemplatePanel.c(this.a.b.this$0).getCurrentIndex()), Util.md5(((MediaModel)localObject1).toString()));
    localObject1 = ((MediaModel)localObject1).getMediaEffectModel().getStickerModelList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StickerModel)((Iterator)localObject1).next();
        AEEditorImageTemplatePanel.f(this.a.b.this$0).d(((StickerModel)localObject2).getUniqueId());
        AEEditorImageTemplatePanel.h(this.a.b.this$0).d(((StickerModel)localObject2).getUniqueId());
      }
    }
    localObject2 = AEQCircleReport.a();
    if (this.a.b.a == null) {
      localObject1 = "";
    } else {
      localObject1 = this.a.b.a.id;
    }
    ((AEQCircleReport)localObject2).a((String)localObject1, QCircleConstants.y, "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.5.1.1
 * JD-Core Version:    0.7.0.1
 */