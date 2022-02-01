package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil;

class MaterialClassifierView$2
  implements MaterialCategoryAdapter.ItemListener
{
  MaterialClassifierView$2(MaterialClassifierView paramMaterialClassifierView) {}
  
  public void a(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (MaterialClassifierView.a(this.a) != null) {
      MaterialClassifierView.a(this.a).a(paramInt, paramMetaCategory);
    }
  }
  
  public void b(int paramInt, @Nullable MetaCategory paramMetaCategory)
  {
    if (MaterialClassifierView.a(this.a) != null) {
      MaterialClassifierView.a(this.a).b(paramInt, paramMetaCategory);
    }
    MaterialClassifierView.a(this.a, true);
    paramInt = MetaMaterialKt.b(MaterialClassifierView.a(this.a), MaterialClassifierView.b(this.a), paramInt);
    AdapterUtil.b(MaterialClassifierView.a(this.a), MaterialClassifierView.a(this.a).a(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView.2
 * JD-Core Version:    0.7.0.1
 */