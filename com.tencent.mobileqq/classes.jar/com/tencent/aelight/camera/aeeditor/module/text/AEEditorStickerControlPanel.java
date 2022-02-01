package com.tencent.aelight.camera.aeeditor.module.text;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialCategoryAdapter;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AEEditorStickerControlPanel
  extends FrameLayout
{
  private GridLayoutManager jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Observer<Integer> jdField_a_of_type_AndroidxLifecycleObserver;
  private BottomSheetBehavior jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior;
  private AEEditorStickerControlPanel.TextStickerControlListener jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel$TextStickerControlListener;
  private AEEditorStickerMaterialContentAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter;
  private AEEditorStickerViewModel jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel;
  private MaterialCategoryAdapter jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter;
  private final List<MetaCategory> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final List<MetaMaterial> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  
  public AEEditorStickerControlPanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorStickerControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorStickerControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
    b();
  }
  
  private ApplyMaterialTask a()
  {
    return new AEEditorStickerControlPanel.5(this);
  }
  
  private void a(@NonNull Context paramContext)
  {
    View localView = View.inflate(paramContext, 2064318583, this);
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(2064122584);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerView.setNestedScrollingEnabled(false);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter = new MaterialCategoryAdapter(this.jdField_a_of_type_JavaUtilList, new AEEditorStickerControlPanel.1(this));
    localRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)localView.findViewById(2064122586));
    this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager = new GridLayoutManager(paramContext, 5);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addOnScrollListener(new AEEditorStickerControlPanel.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter = new AEEditorStickerMaterialContentAdapter(paramContext);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter.a(a());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter);
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior = BottomSheetBehavior.a(localView.findViewById(2064122355));
    this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior.a(new AEEditorStickerControlPanel.3(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidxLifecycleObserver = new AEEditorStickerControlPanel.4(this);
  }
  
  public List<MetaMaterial> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    BottomSheetBehavior localBottomSheetBehavior = this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.b() != 4)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialBottomsheetBottomSheetBehavior.d(4);
    }
  }
  
  public boolean a(String paramString)
  {
    AEEditorStickerMaterialContentAdapter localAEEditorStickerMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter;
    if (localAEEditorStickerMaterialContentAdapter != null) {
      return localAEEditorStickerMaterialContentAdapter.a(paramString);
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AEEditorStickerViewModel localAEEditorStickerViewModel = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel;
    if (localAEEditorStickerViewModel != null) {
      localAEEditorStickerViewModel.c().removeObserver(this.jdField_a_of_type_AndroidxLifecycleObserver);
    }
  }
  
  public void setIsImageMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter.b(this.jdField_a_of_type_Boolean);
  }
  
  public void setStickerCategories(List<MetaCategory> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_b_of_type_JavaUtilList.clear();
    paramList = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MetaCategory)paramList.next();
      localObject = TextMetaMaterialKt.a(((MetaCategory)localObject).id, ((MetaCategory)localObject).materials);
      this.jdField_b_of_type_JavaUtilList.addAll((Collection)localObject);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialCategoryAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter.notifyDataSetChanged();
  }
  
  public void setStickerControlPanelListener(AEEditorStickerControlPanel.TextStickerControlListener paramTextStickerControlListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerControlPanel$TextStickerControlListener = paramTextStickerControlListener;
  }
  
  public void setStickerViewModel(AEEditorStickerViewModel paramAEEditorStickerViewModel)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel = paramAEEditorStickerViewModel;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerViewModel.c().observeForever(this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    AEEditorStickerMaterialContentAdapter localAEEditorStickerMaterialContentAdapter = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleTextAEEditorStickerMaterialContentAdapter;
    if (localAEEditorStickerMaterialContentAdapter != null) {
      localAEEditorStickerMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel
 * JD-Core Version:    0.7.0.1
 */