package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH;

public class AEAutoTemplateAdapterMaterial
  extends MaterialContentAdapter
{
  private int a = 0;
  
  public AEAutoTemplateAdapterMaterial(@NonNull Context paramContext)
  {
    super(paramContext, 2);
    b(false);
  }
  
  protected MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MaterialContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318605, paramViewGroup, false));
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    if (!TextUtils.isEmpty(paramMetaMaterial.id)) {
      AEReportUtils.d(paramMetaMaterial.id);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    notifyItemRangeChanged(0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEAutoTemplateAdapterMaterial
 * JD-Core Version:    0.7.0.1
 */