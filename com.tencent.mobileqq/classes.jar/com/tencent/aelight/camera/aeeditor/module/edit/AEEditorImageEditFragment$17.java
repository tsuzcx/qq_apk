package com.tencent.aelight.camera.aeeditor.module.edit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.tavcut.aekit.PreSegModel;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.weseevideo.composition.effectnode.WSSegmentManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.CropModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.ArrayList;
import java.util.List;

class AEEditorImageEditFragment$17
  implements Runnable
{
  AEEditorImageEditFragment$17(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    Object localObject1 = ((MediaModel)AEEditorImageEditFragment.a(this.this$0).getMediaModels().get(this.jdField_a_of_type_Int)).getMediaEffectModel().getPreSegModel();
    Object localObject2 = ((MediaModel)AEEditorImageEditFragment.a(this.this$0).getMediaModels().get(this.jdField_a_of_type_Int)).getMediaEffectModel().getCropModel();
    if (localObject1 != null)
    {
      localObject1 = WSSegmentManager.a((PreSegModel)localObject1, (CropModel)localObject2);
      localObject2 = WSSegmentManager.a;
      localObject2 = WSSegmentManager.a(this.jdField_a_of_type_Int, (String)localObject1);
      if (localObject2 != null)
      {
        localObject1 = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), ((Bitmap)localObject2).getConfig());
        ((Bitmap)localObject1).eraseColor(-1);
        new Canvas((Bitmap)localObject1).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
      }
      else
      {
        localObject1 = this.this$0;
        localObject1 = AEEditorImageEditFragment.a((AEEditorImageEditFragment)localObject1, (String)AEEditorImageEditFragment.a((AEEditorImageEditFragment)localObject1).get(this.jdField_a_of_type_Int), ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.this$0).get(this.jdField_a_of_type_Int)).a);
      }
    }
    else
    {
      localObject1 = this.this$0;
      localObject1 = AEEditorImageEditFragment.a((AEEditorImageEditFragment)localObject1, (String)AEEditorImageEditFragment.a((AEEditorImageEditFragment)localObject1).get(this.jdField_a_of_type_Int), ((AEEditorImageInfo)AEEditorImageEditFragment.a(this.this$0).get(this.jdField_a_of_type_Int)).a);
    }
    if (localObject1 == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "bitmap null error.");
      return;
    }
    AEEditorImageEditFragment.a(this.this$0, (Bitmap)localObject1, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.17
 * JD-Core Version:    0.7.0.1
 */