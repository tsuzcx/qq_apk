package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH;

public class AEEditorTextMaterialContentAdapter
  extends MaterialContentAdapter
{
  public AEEditorTextMaterialContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext, 1);
  }
  
  protected MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MaterialContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318607, paramViewGroup, false));
  }
  
  public void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    paramContentItemVH = TextMetaMaterialKt.c(paramMetaMaterial);
    AEReportUtils.a(this.a, paramContentItemVH, 3, paramMetaMaterial.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextMaterialContentAdapter
 * JD-Core Version:    0.7.0.1
 */