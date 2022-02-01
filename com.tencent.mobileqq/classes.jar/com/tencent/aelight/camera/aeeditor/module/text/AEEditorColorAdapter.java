package com.tencent.aelight.camera.aeeditor.module.text;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import java.util.List;

public class AEEditorColorAdapter
  extends RecyclerView.Adapter<AEEditorColorAdapter.VH>
{
  private final List<Integer> a;
  private final AEEditorColorAdapter.ColorClickListener b;
  private String c;
  private String d = "";
  private int e = -1;
  
  public AEEditorColorAdapter(String paramString, List<Integer> paramList, AEEditorColorAdapter.ColorClickListener paramColorClickListener)
  {
    this.c = paramString;
    this.a = paramList;
    this.b = paramColorClickListener;
  }
  
  private int b(int paramInt)
  {
    if (paramInt < this.a.size()) {
      return ((Integer)this.a.get(paramInt)).intValue();
    }
    return 0;
  }
  
  private void b(AEEditorColorAdapter.VH paramVH, int paramInt)
  {
    if (this.e == paramInt)
    {
      paramVH.b.setVisibility(0);
      return;
    }
    paramVH.b.setVisibility(8);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public AEEditorColorAdapter.VH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new AEEditorColorAdapter.VH(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056427, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    if (paramInt >= 0) {
      this.b.a(this.c, b(paramInt), paramInt, this.d);
    }
  }
  
  public void a(AEEditorColorAdapter.VH paramVH, int paramInt)
  {
    paramVH.a.setImageDrawable(AEEditorColorSelectorView.a(paramVH.a, false, b(paramInt)));
    paramVH.a.setOnClickListener(new AEEditorColorAdapter.1(this, paramInt, paramVH));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramVH.itemView.getLayoutParams();
    if (paramInt == 0) {
      localMarginLayoutParams.leftMargin = localMarginLayoutParams.rightMargin;
    } else {
      localMarginLayoutParams.leftMargin = 0;
    }
    paramVH.itemView.setLayoutParams(localMarginLayoutParams);
    b(paramVH, paramInt);
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public int getItemCount()
  {
    return this.a.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorColorAdapter
 * JD-Core Version:    0.7.0.1
 */