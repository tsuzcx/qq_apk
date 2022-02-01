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
  private int jdField_a_of_type_Int = 0;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final MaterialCategoryAdapter.ItemListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter$ItemListener;
  private final List<MetaCategory> jdField_a_of_type_JavaUtilList;
  
  public MaterialCategoryAdapter(List<MetaCategory> paramList, MaterialCategoryAdapter.ItemListener paramItemListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter$ItemListener = paramItemListener;
  }
  
  public MaterialCategoryAdapter.CategoryItemVH a(ViewGroup paramViewGroup, int paramInt)
  {
    return new MaterialCategoryAdapter.CategoryItemVH(LayoutInflater.from(paramViewGroup.getContext()).inflate(2064318604, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0) {
      AdapterUtil.a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_Int, paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(MaterialCategoryAdapter.CategoryItemVH paramCategoryItemVH, int paramInt)
  {
    MetaCategory localMetaCategory = (MetaCategory)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter$ItemListener.a(paramInt, localMetaCategory);
    if (localMetaCategory != null) {
      paramCategoryItemVH.a.setText(localMetaCategory.name);
    }
    if (this.jdField_a_of_type_Int == paramInt)
    {
      paramCategoryItemVH.a.setTextColor(paramCategoryItemVH.itemView.getContext().getResources().getColor(2131166293));
      paramCategoryItemVH.a.setTypeface(Typeface.defaultFromStyle(1));
    }
    else
    {
      paramCategoryItemVH.a.setTextColor(paramCategoryItemVH.itemView.getContext().getResources().getColor(2131166295));
      paramCategoryItemVH.a.setTypeface(Typeface.defaultFromStyle(0));
    }
    paramCategoryItemVH.a.setOnClickListener(new MaterialCategoryAdapter.1(this, paramInt, localMetaCategory));
  }
  
  public int getItemCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */