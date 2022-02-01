package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.aelight.camera.aeeditor.module.filter.AdapterUtil;
import java.util.List;

public class MaterialCategoryAdapter
  extends RecyclerView.Adapter<MaterialCategoryAdapter.CategoryItemVH>
{
  private RecyclerView a;
  private final List<MetaCategory> b;
  private final MaterialCategoryAdapter.ItemListener c;
  private int d = 0;
  
  public MaterialCategoryAdapter(List<MetaCategory> paramList, MaterialCategoryAdapter.ItemListener paramItemListener)
  {
    this.b = paramList;
    this.c = paramItemListener;
  }
  
  public MaterialCategoryAdapter.CategoryItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MaterialCategoryAdapter.CategoryItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064056482, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      AdapterUtil.a(this.a, this.d, paramInt);
    }
    this.d = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(MaterialCategoryAdapter.CategoryItemVH paramCategoryItemVH, int paramInt)
  {
    MetaCategory localMetaCategory = (MetaCategory)this.b.get(paramInt);
    this.c.a(paramInt, localMetaCategory);
    if (localMetaCategory != null) {
      paramCategoryItemVH.a.setText(localMetaCategory.name);
    }
    if (this.d == paramInt)
    {
      paramCategoryItemVH.a.setTextColor(paramCategoryItemVH.itemView.getContext().getResources().getColor(2131167030));
      paramCategoryItemVH.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    else
    {
      paramCategoryItemVH.a.setTextColor(paramCategoryItemVH.itemView.getContext().getResources().getColor(2131167032));
      paramCategoryItemVH.a.setTypeface(Typeface.defaultFromStyle(0));
    }
    paramCategoryItemVH.a.setOnClickListener(new MaterialCategoryAdapter.1(this, paramInt, localMetaCategory));
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.a = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */