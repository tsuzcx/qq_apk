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
  private RecyclerView a;
  private GridLayoutManager b;
  private MaterialCategoryAdapter c;
  private AEEditorStickerMaterialContentAdapter d;
  private BottomSheetBehavior e;
  private AEEditorStickerControlPanel.TextStickerControlListener f;
  private AEEditorStickerViewModel g;
  private final List<MetaCategory> h = new ArrayList();
  private final List<MetaMaterial> i = new ArrayList();
  private Observer<Integer> j;
  private boolean k;
  private boolean l;
  
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
  
  private void a(@NonNull Context paramContext)
  {
    View localView = View.inflate(paramContext, 2064056455, this);
    RecyclerView localRecyclerView = (RecyclerView)localView.findViewById(2063991401);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramContext, 0, false));
    localRecyclerView.setNestedScrollingEnabled(false);
    this.c = new MaterialCategoryAdapter(this.h, new AEEditorStickerControlPanel.1(this));
    localRecyclerView.setAdapter(this.c);
    this.a = ((RecyclerView)localView.findViewById(2063991403));
    this.b = new GridLayoutManager(paramContext, 5);
    this.a.setLayoutManager(this.b);
    this.a.addOnScrollListener(new AEEditorStickerControlPanel.2(this));
    this.d = new AEEditorStickerMaterialContentAdapter(paramContext);
    this.d.a(c());
    this.d.a(this.i);
    this.a.setAdapter(this.d);
    this.e = BottomSheetBehavior.b(localView.findViewById(2063991228));
    this.e.b(new AEEditorStickerControlPanel.3(this));
  }
  
  private void b()
  {
    this.j = new AEEditorStickerControlPanel.4(this);
  }
  
  private ApplyMaterialTask c()
  {
    return new AEEditorStickerControlPanel.5(this);
  }
  
  public void a()
  {
    BottomSheetBehavior localBottomSheetBehavior = this.e;
    if ((localBottomSheetBehavior != null) && (localBottomSheetBehavior.d() != 4)) {
      this.e.d(4);
    }
  }
  
  public boolean a(String paramString)
  {
    AEEditorStickerMaterialContentAdapter localAEEditorStickerMaterialContentAdapter = this.d;
    if (localAEEditorStickerMaterialContentAdapter != null) {
      return localAEEditorStickerMaterialContentAdapter.a(paramString);
    }
    return false;
  }
  
  public List<MetaMaterial> getStickerMaterials()
  {
    return this.i;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AEEditorStickerViewModel localAEEditorStickerViewModel = this.g;
    if (localAEEditorStickerViewModel != null) {
      localAEEditorStickerViewModel.e().removeObserver(this.j);
    }
  }
  
  public void setIsImageMode(boolean paramBoolean)
  {
    this.k = paramBoolean;
    this.d.b(this.k);
  }
  
  public void setStickerCategories(List<MetaCategory> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.h.clear();
    this.h.addAll(paramList);
    this.i.clear();
    paramList = this.h.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (MetaCategory)paramList.next();
      localObject = TextMetaMaterialKt.a(((MetaCategory)localObject).id, ((MetaCategory)localObject).materials);
      this.i.addAll((Collection)localObject);
    }
    this.g.a(this.i);
    this.c.notifyDataSetChanged();
    this.d.notifyDataSetChanged();
  }
  
  public void setStickerControlPanelListener(AEEditorStickerControlPanel.TextStickerControlListener paramTextStickerControlListener)
  {
    this.f = paramTextStickerControlListener;
  }
  
  public void setStickerViewModel(AEEditorStickerViewModel paramAEEditorStickerViewModel)
  {
    this.g = paramAEEditorStickerViewModel;
    this.g.e().observeForever(this.j);
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    AEEditorStickerMaterialContentAdapter localAEEditorStickerMaterialContentAdapter = this.d;
    if (localAEEditorStickerMaterialContentAdapter != null) {
      localAEEditorStickerMaterialContentAdapter.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorStickerControlPanel
 * JD-Core Version:    0.7.0.1
 */