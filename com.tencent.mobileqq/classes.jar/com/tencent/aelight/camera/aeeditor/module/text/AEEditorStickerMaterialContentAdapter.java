package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.ContentItemVH;
import com.tencent.mobileqq.util.DisplayUtil;

public class AEEditorStickerMaterialContentAdapter
  extends MaterialContentAdapter
{
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  
  public AEEditorStickerMaterialContentAdapter(@NonNull Context paramContext)
  {
    super(paramContext, 1, 2);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    float f1 = (localDisplayMetrics.widthPixels / localDisplayMetrics.density - 24.0F) / 375.0F;
    this.b = DisplayUtil.a(paramContext, 84.0F * f1);
    this.c = DisplayUtil.a(paramContext, 64.0F * f1);
    this.e = DisplayUtil.a(paramContext, 6.0F * f1);
    this.d = DisplayUtil.a(paramContext, -10.0F * f1);
    this.f = DisplayUtil.a(paramContext, f1 * 155.0F);
    this.g = DisplayUtil.a(paramContext, -8.0F);
  }
  
  protected MaterialContentAdapter.ContentItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new MaterialContentAdapter.ContentItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056487, paramViewGroup, false));
    Object localObject = paramViewGroup.itemView.findViewById(2063991388).getLayoutParams();
    int i = this.c;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    localObject = (RecyclerView.LayoutParams)paramViewGroup.itemView.getLayoutParams();
    i = this.b;
    ((RecyclerView.LayoutParams)localObject).width = i;
    ((RecyclerView.LayoutParams)localObject).height = i;
    i = paramInt & 0xF;
    if (i == 1)
    {
      ((RecyclerView.LayoutParams)localObject).topMargin = this.d;
      ((RecyclerView.LayoutParams)localObject).bottomMargin = this.g;
    }
    else if (i == 3)
    {
      ((RecyclerView.LayoutParams)localObject).topMargin = 0;
      ((RecyclerView.LayoutParams)localObject).bottomMargin = this.f;
    }
    else
    {
      ((RecyclerView.LayoutParams)localObject).topMargin = 0;
      ((RecyclerView.LayoutParams)localObject).bottomMargin = this.g;
    }
    paramInt &= 0xF0;
    if (paramInt == 16)
    {
      ((RecyclerView.LayoutParams)localObject).leftMargin = this.e;
      ((RecyclerView.LayoutParams)localObject).rightMargin = 0;
      return paramViewGroup;
    }
    if (paramInt == 48)
    {
      ((RecyclerView.LayoutParams)localObject).leftMargin = 0;
      ((RecyclerView.LayoutParams)localObject).rightMargin = this.e;
      return paramViewGroup;
    }
    ((RecyclerView.LayoutParams)localObject).leftMargin = 0;
    ((RecyclerView.LayoutParams)localObject).rightMargin = 0;
    return paramViewGroup;
  }
  
  public void a(MaterialContentAdapter.ContentItemVH paramContentItemVH, int paramInt, @NonNull MetaMaterial paramMetaMaterial)
  {
    super.a(paramContentItemVH, paramInt, paramMetaMaterial);
    AEReportUtils.f(this.a, paramMetaMaterial.id);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i;
    if (paramInt < 5)
    {
      i = 1;
    }
    else
    {
      i = (int)Math.ceil(getItemCount() * 1.0F / 5.0F);
      if ((int)Math.ceil((paramInt + 1) * 1.0F / 5.0F) == i) {
        i = 3;
      } else {
        i = 2;
      }
    }
    if (paramInt % 5 == 0) {
      return i | 0x10;
    }
    if ((paramInt + 1) % 5 == 0) {
      return i | 0x30;
    }
    return i | 0x20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerMaterialContentAdapter
 * JD-Core Version:    0.7.0.1
 */