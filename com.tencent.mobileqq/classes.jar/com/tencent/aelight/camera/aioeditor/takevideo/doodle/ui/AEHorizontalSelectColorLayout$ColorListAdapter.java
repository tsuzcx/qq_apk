package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;

class AEHorizontalSelectColorLayout$ColorListAdapter
  extends RecyclerView.Adapter<AEHorizontalSelectColorLayout.ColorVH>
{
  private int jdField_a_of_type_Int;
  private AEHorizontalSelectColorLayout.IColorSelectListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$IColorSelectListener;
  private List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int b = 0;
  private int c;
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(AEHorizontalSelectColorLayout.IColorSelectListener paramIColorSelectListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiAEHorizontalSelectColorLayout$IColorSelectListener = paramIColorSelectListener;
  }
  
  private void a(List<Integer> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public AEHorizontalSelectColorLayout.ColorVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEHorizontalSelectColorLayout.ColorVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558511, paramViewGroup, false), null);
  }
  
  public void a(AEHorizontalSelectColorLayout.ColorVH paramColorVH, int paramInt)
  {
    int i = this.b;
    if (paramInt < i)
    {
      AEHorizontalSelectColorLayout.ColorVH.a(paramColorVH).setBackgroundResource(2130837736);
    }
    else
    {
      i = ((Integer)this.jdField_a_of_type_JavaUtilList.get(paramInt - i)).intValue();
      AEHorizontalSelectColorLayout.ColorVH.a(paramColorVH).mutate();
      AEHorizontalSelectColorLayout.ColorVH.a(paramColorVH).setColor(i);
      AEHorizontalSelectColorLayout.ColorVH.a(paramColorVH).setBackgroundDrawable(AEHorizontalSelectColorLayout.ColorVH.a(paramColorVH));
    }
    ImageView localImageView = AEHorizontalSelectColorLayout.ColorVH.b(paramColorVH);
    if (paramInt == this.jdField_a_of_type_Int) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
    i = this.b;
    if ((paramInt >= i) && (paramInt == this.jdField_a_of_type_Int)) {
      this.c = (paramInt - i);
    }
    paramColorVH.itemView.setOnClickListener(new AEHorizontalSelectColorLayout.ColorListAdapter.1(this, paramColorVH));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.AEHorizontalSelectColorLayout.ColorListAdapter
 * JD-Core Version:    0.7.0.1
 */