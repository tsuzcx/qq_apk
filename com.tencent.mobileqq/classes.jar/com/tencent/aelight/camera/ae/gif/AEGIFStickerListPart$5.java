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
    boolean bool = AEGIFStickerListPart.a(this.a);
    if (bool) {
      AEGIFStickerListPart.a(this.a, null);
    }
    Object localObject1 = AEGIFStickerListPart.a(this.a).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AEMaterialWrapper)((Iterator)localObject1).next();
      if (((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(paramAEDownloadStateWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))
      {
        if (((AEMaterialWrapper)localObject2).jdField_a_of_type_Int != paramAEDownloadStateWrapper.jdField_a_of_type_Int)
        {
          ((AEMaterialWrapper)localObject2).jdField_a_of_type_Int = paramAEDownloadStateWrapper.jdField_a_of_type_Int;
          AEGIFStickerListPart.a(this.a).a((AEMaterialWrapper)localObject2, bool);
        }
        if ((((AEMaterialWrapper)localObject2).jdField_a_of_type_Int == 2) && (((AEMaterialWrapper)localObject2).jdField_a_of_type_JavaLangString.equals(AEGIFStickerListPart.b(this.a))) && (!bool)) {
          AEGIFStickerListPart.a(this.a).b((AEMaterialWrapper)localObject2);
        }
      }
    }
    Object localObject2 = AEGIFStickerListPart.b(this.a).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (AEGifCategoryWrapper)((Iterator)localObject2).next();
      if ((localObject1 != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)))
      {
        Iterator localIterator = ((AEGifCategoryWrapper)localObject1).materialWrapperList.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (AEMaterialWrapper)localIterator.next();
          if ((localObject1 != null) && (!TextUtils.isEmpty(((AEMaterialWrapper)localObject1).jdField_a_of_type_JavaLangString)) && (((AEMaterialWrapper)localObject1).jdField_a_of_type_JavaLangString.equals(paramAEDownloadStateWrapper.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial.id))) {
            break label277;
          }
        }
        localObject1 = null;
        label277:
        if (localObject1 != null) {
          if (((AEMaterialWrapper)localObject1).jdField_a_of_type_Int != paramAEDownloadStateWrapper.jdField_a_of_type_Int) {
            ((AEMaterialWrapper)localObject1).jdField_a_of_type_Int = paramAEDownloadStateWrapper.jdField_a_of_type_Int;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.AEGIFStickerListPart.5
 * JD-Core Version:    0.7.0.1
 */