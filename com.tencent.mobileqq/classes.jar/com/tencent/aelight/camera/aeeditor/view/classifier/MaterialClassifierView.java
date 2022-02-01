package com.tencent.aelight.camera.aeeditor.view.classifier;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.List;

public class MaterialClassifierView
  extends LinearLayout
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private MaterialCategoryAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter;
  private MaterialClassifierView.CategoryItemListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView$CategoryItemListener;
  private MaterialContentAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter;
  private List<MetaCategory> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private RecyclerView jdField_b_of_type_AndroidSupportV7WidgetRecyclerView;
  private List<MetaMaterial> jdField_b_of_type_JavaUtilList;
  
  public MaterialClassifierView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialClassifierView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MaterialClassifierView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2064056464);
    int i = DisplayUtil.a(getContext(), 11.0F);
    int j = DisplayUtil.a(getContext(), 6.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setPadding(i, j, i, j);
    Object localObject = new LinearLayout.LayoutParams(DisplayUtil.a(getContext(), 42.0F), DisplayUtil.a(getContext(), 32.0F));
    ((LinearLayout.LayoutParams)localObject).setMargins(DisplayUtil.a(getContext(), 14.0F), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    localObject = (SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator();
    if (localObject != null) {
      ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    }
    localObject = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, (ViewGroup.LayoutParams)localObject);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new LinearLayout.LayoutParams(-1, DisplayUtil.a(getContext(), 32.0F)));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = new RecyclerView(getContext());
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setAutoMeasureEnabled(false);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    localObject = (SimpleItemAnimator)this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator();
    if (localObject != null) {
      ((SimpleItemAnimator)localObject).setSupportsChangeAnimations(false);
    }
    addView(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView, new LinearLayout.LayoutParams(-1, -2));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new MaterialClassifierView.1(this));
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter;
    if (localObject != null) {
      ((MaterialCategoryAdapter)localObject).notifyDataSetChanged();
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter;
    if (localObject != null) {
      ((MaterialContentAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  public void setCategoryItemListener(MaterialClassifierView.CategoryItemListener paramCategoryItemListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView$CategoryItemListener = paramCategoryItemListener;
  }
  
  public void setCategoryLayoutVisibility(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((LinearLayout)localObject).setVisibility(i);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getLayoutParams();
    if (localObject != null)
    {
      if (paramBoolean) {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 0.0F);
      } else {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = DisplayUtil.a(getContext(), 18.0F);
      }
      this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setClearButtonEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    int i;
    if (paramBoolean) {
      i = 2064056463;
    } else {
      i = 2064056464;
    }
    localImageView.setImageResource(i);
  }
  
  public void setOnClearButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setup(MaterialContentAdapter paramMaterialContentAdapter, @NonNull List<MetaCategory> paramList, @NonNull List<MetaMaterial> paramList1)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter = paramMaterialContentAdapter;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_JavaUtilList = paramList1;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter = new MaterialCategoryAdapter(paramList, new MaterialClassifierView.2(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialContentAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView
 * JD-Core Version:    0.7.0.1
 */