package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.util.SparseArray;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerViewModel;
import com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextViewModel;
import com.tencent.aelight.camera.aeeditor.util.AEQCircleReport;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.util.Util;
import com.tencent.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class AEEditorImageTemplatePanel$5$1$1
  implements OnRenderFinishListener
{
  AEEditorImageTemplatePanel$5$1$1(AEEditorImageTemplatePanel.5.1 param1) {}
  
  public void a()
  {
    this.a.a.this$0.setSelectedIndex(this.a.a.jdField_a_of_type_Int, true);
    this.a.a.this$0.jdField_a_of_type_AndroidUtilSparseArray.put(AEEditorImageTemplatePanel.a(this.a.a.this$0).getCurrentIndex(), this.a.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id);
    AEEditorImageTemplatePanel.a(this.a.a.this$0, true);
    Object localObject1 = AEEditorImageTemplatePanel.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Pic template apply success, timecost:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - this.a.a.jdField_a_of_type_Long);
    AEQLog.b((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = (MediaModel)AEEditorImageTemplatePanel.a(this.a.a.this$0).getMediaModels().get(AEEditorImageTemplatePanel.a(this.a.a.this$0).getCurrentIndex());
    AEEditorImageTemplatePanel.b(this.a.a.this$0).put(Integer.valueOf(AEEditorImageTemplatePanel.a(this.a.a.this$0).getCurrentIndex()), Util.md5(((MediaModel)localObject1).toString()));
    localObject1 = ((MediaModel)localObject1).getMediaEffectModel().getStickerModelList();
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (StickerModel)((Iterator)localObject1).next();
        AEEditorImageTemplatePanel.a(this.a.a.this$0).b(((StickerModel)localObject2).getUniqueId());
        AEEditorImageTemplatePanel.a(this.a.a.this$0).b(((StickerModel)localObject2).getUniqueId());
      }
    }
    localObject2 = AEQCircleReport.a();
    if (this.a.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial == null) {
      localObject1 = "";
    } else {
      localObject1 = this.a.a.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id;
    }
    ((AEQCircleReport)localObject2).a((String)localObject1, QCircleConstants.KEY_PIC, "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.AEEditorImageTemplatePanel.5.1.1
 * JD-Core Version:    0.7.0.1
 */