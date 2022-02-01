package com.tencent.aelight.camera.aeeditor.module.imagetemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH;

public class TemplateMaterialContentAdapter
  extends MaterialContentAdapter
{
  public TemplateMaterialContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext, 2);
    b(true);
  }
  
  protected MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MaterialContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056483, paramViewGroup, false));
  }
  
  public void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    AEReportUtils.f(paramMetaMaterial.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.imagetemplate.TemplateMaterialContentAdapter
 * JD-Core Version:    0.7.0.1
 */