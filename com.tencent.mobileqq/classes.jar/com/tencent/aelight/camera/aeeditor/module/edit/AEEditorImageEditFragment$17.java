package com.tencent.aelight.camera.aeeditor.module.edit;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.data.AEEditorImageInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.tavcut.session.TAVCutImageSession;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSSegmentManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.CropModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.ArrayList;
import java.util.List;

class AEEditorImageEditFragment$17
  implements Runnable
{
  AEEditorImageEditFragment$17(AEEditorImageEditFragment paramAEEditorImageEditFragment, int paramInt1, int paramInt2, MetaMaterial paramMetaMaterial) {}
  
  public void run()
  {
    Object localObject1 = ((MediaModel)AEEditorImageEditFragment.f(this.this$0).getMediaModels().get(this.a)).getMediaEffectModel().getPreSegModel();
    Object localObject2 = ((MediaModel)AEEditorImageEditFragment.f(this.this$0).getMediaModels().get(this.a)).getMediaEffectModel().getCropModel();
    Bitmap localBitmap = null;
    if (localObject1 != null)
    {
      localObject1 = WSSegmentManager.getCacheName((PreSegModel)localObject1, (CropModel)localObject2);
      localObject2 = WSSegmentManager.INSTANCE;
      Object localObject3 = WSSegmentManager.get(this.a, (String)localObject1);
      if (localObject3 != null)
      {
        localObject1 = ((Bitmap)localObject3).copy(Bitmap.Config.RGB_565, true);
        localObject2 = ((Bitmap)localObject3).copy(Bitmap.Config.ARGB_8888, true);
        localBitmap = Bitmap.createBitmap(((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight(), Bitmap.Config.RGB_565);
        localObject3 = new ColorMatrix();
        ((ColorMatrix)localObject3).getArray()[0] = 0.0F;
        ((ColorMatrix)localObject3).getArray()[3] = 1.0F;
        ((ColorMatrix)localObject3).getArray()[6] = 0.0F;
        ((ColorMatrix)localObject3).getArray()[8] = 1.0F;
        ((ColorMatrix)localObject3).getArray()[12] = 0.0F;
        ((ColorMatrix)localObject3).getArray()[13] = 1.0F;
        ((ColorMatrix)localObject3).getArray()[18] = 0.0F;
        ((ColorMatrix)localObject3).getArray()[19] = 255.0F;
        localBitmap.eraseColor(-16777216);
        Paint localPaint = new Paint();
        localPaint.setColorFilter(new ColorMatrixColorFilter((ColorMatrix)localObject3));
        new Canvas(localBitmap).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, localPaint);
      }
      else
      {
        localObject1 = this.this$0;
        localObject1 = AEEditorImageEditFragment.a((AEEditorImageEditFragment)localObject1, (String)AEEditorImageEditFragment.r((AEEditorImageEditFragment)localObject1).get(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.d(this.this$0).get(this.a)).d);
      }
    }
    else
    {
      localObject1 = this.this$0;
      localObject1 = AEEditorImageEditFragment.a((AEEditorImageEditFragment)localObject1, (String)AEEditorImageEditFragment.r((AEEditorImageEditFragment)localObject1).get(this.a), ((AEEditorImageInfo)AEEditorImageEditFragment.d(this.this$0).get(this.a)).d);
    }
    if (localObject1 == null)
    {
      AEQLog.d("AEEditorImageEditFragment", "bitmap null error.");
      return;
    }
    AEEditorImageEditFragment.a(this.this$0, (Bitmap)localObject1, localBitmap, this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorImageEditFragment.17
 * JD-Core Version:    0.7.0.1
 */