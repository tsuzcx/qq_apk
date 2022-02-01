package com.tencent.aelight.camera.ae.gif;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.data.AEGifCategoryWrapper;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEDownloadStateWrapper;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFStickerAdapter;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.Iterator;
import java.util.List;

class AEGIFStickerListPart$5
  implements Observer<AEDownloadStateWrapper>
{
  AEGIFStickerListPart$5(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable AEDownloadStateWrapper paramAEDownloadStateWrapper)
  {
    if (paramAEDownloadStateWrapper == null) {
      return;
    }
    boolean bool = AEGIFStickerListPart.g(this.a);
    if (bool) {
      AEGIFStickerListPart.a(this.a, null);
    }
    Object localObject1 = AEGIFStickerListPart.h(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AEMaterialWrapper)((Iterator)localObject1).next();
      if (((AEMaterialWrapper)localObject2).a.equals(paramAEDownloadStateWrapper.a.id))
      {
        if (((AEMaterialWrapper)localObject2).f != paramAEDownloadStateWrapper.b)
        {
          ((AEMaterialWrapper)localObject2).f = paramAEDownloadStateWrapper.b;
          AEGIFStickerListPart.i(this.a).a((AEMaterialWrapper)localObject2, bool);
        }
        if ((((AEMaterialWrapper)localObject2).f == 2) && (((AEMaterialWrapper)localObject2).a.equals(AEGIFStickerListPart.j(this.a))) && (!bool)) {
          AEGIFStickerListPart.k(this.a).b((AEMaterialWrapper)localObject2);
        }
      }
    }
    Object localObject2 = AEGIFStickerListPart.l(this.a).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (AEGifCategoryWrapper)((Iterator)localObject2).next();
      if ((localObject1 != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)))
      {
        Iterator localIterator = ((AEGifCategoryWrapper)localObject1).materialWrapperList.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (AEMaterialWrapper)localIterator.next();
          if ((localObject1 != null) && (!TextUtils.isEmpty(((AEMaterialWrapper)localObject1).a)) && (((AEMaterialWrapper)localObject1).a.equals(paramAEDownloadStateWrapper.a.id))) {
            break label277;
          }
        }
        localObject1 = null;
        label277:
        if (localObject1 != null) {
          if (((AEMaterialWrapper)localObject1).f != paramAEDownloadStateWrapper.b) {
            ((AEMaterialWrapper)localObject1).f = paramAEDownloadStateWrapper.b;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.5
 * JD-Core Version:    0.7.0.1
 */