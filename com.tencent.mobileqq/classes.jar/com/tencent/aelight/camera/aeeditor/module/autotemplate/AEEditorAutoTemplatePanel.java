package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.manage.AEditorMaterialManager;
import com.tencent.aelight.camera.aeeditor.manage.AEditorMaterialManager.RecommendListener;
import com.tencent.aelight.camera.aeeditor.module.MetaMaterialKt;
import com.tencent.aelight.camera.aeeditor.module.filter.AEEditorResourceManager;
import com.tencent.aelight.camera.aeeditor.view.classifier.MaterialClassifierView;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast.IToastValidListener;
import dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AEEditorAutoTemplatePanel
  extends FrameLayout
  implements AEditorMaterialManager.RecommendListener
{
  private int jdField_a_of_type_Int;
  private final MutableLiveData<AEAutoTemplateRet> jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private Observer<List<MetaCategory>> jdField_a_of_type_AndroidxLifecycleObserver;
  private AEAutoTemplateAdapterMaterial jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial;
  private MaterialClassifierView jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
  private String jdField_a_of_type_JavaLangString;
  private final List<MetaCategory> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private final MutableLiveData<Boolean> jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  private final List<MetaMaterial> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  
  public AEEditorAutoTemplatePanel(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorAutoTemplatePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorAutoTemplatePanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView = ((MaterialClassifierView)View.inflate(paramContext, 2064318552, this).findViewById(2064122044));
    this.jdField_a_of_type_AndroidxLifecycleObserver = new AEEditorAutoTemplatePanel.1(this);
    AEEditorResourceManager.a().d().observeForever(this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedIndexByMaterialId, mSelectMaterialId=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    AEQLog.b("AEEditorAutoTemplatePanel", localStringBuilder.toString());
    if (!this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial.a(this.jdField_a_of_type_JavaLangString, paramBoolean)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial.b(-1);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial = new AEAutoTemplateAdapterMaterial(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial.a(new AEEditorAutoTemplatePanel.2(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setup(this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setCategoryItemListener(new AEEditorAutoTemplatePanel.3(this));
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setOnClearButtonClickListener(new AEEditorAutoTemplatePanel.4(this));
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ((MetaCategory)this.jdField_a_of_type_JavaUtilList.get(0)).materials = AEditorMaterialManager.a().a;
      this.jdField_b_of_type_JavaUtilList.clear();
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MetaCategory localMetaCategory = (MetaCategory)((Iterator)localObject).next();
        if (localMetaCategory.materials != null)
        {
          Iterator localIterator = localMetaCategory.materials.iterator();
          while (localIterator.hasNext())
          {
            MetaMaterial localMetaMaterial = (MetaMaterial)localIterator.next();
            if (localMetaMaterial != null)
            {
              MetaMaterialKt.a(localMetaMaterial, localMetaCategory.id);
              MetaMaterialKt.a(localMetaMaterial, false);
              MetaMaterialKt.b(localMetaMaterial, false);
              this.jdField_b_of_type_JavaUtilList.add(localMetaMaterial);
            }
          }
        }
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial;
      if (localObject != null)
      {
        ((AEAutoTemplateAdapterMaterial)localObject).a(AEditorMaterialManager.a().a.size());
        a(false);
      }
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView;
      if (localObject != null) {
        ((MaterialClassifierView)localObject).a();
      }
    }
  }
  
  public MutableLiveData<AEAutoTemplateRet> a()
  {
    return this.jdField_a_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEEditorAutoTemplatePanel.5(this));
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == paramInt) && (this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      MetaMaterial localMetaMaterial = (MetaMaterial)this.jdField_b_of_type_JavaUtilList.get(0);
      if (localMetaMaterial != null) {
        this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial.a(localMetaMaterial.id);
      }
    }
  }
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramMetaMaterial.id;
    a(true);
  }
  
  public boolean a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    AEAutoTemplateAdapterMaterial localAEAutoTemplateAdapterMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial;
    if (localAEAutoTemplateAdapterMaterial != null) {
      return localAEAutoTemplateAdapterMaterial.a(paramString);
    }
    return false;
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.jdField_b_of_type_AndroidxLifecycleMutableLiveData;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new AEEditorAutoTemplatePanel.6(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      f();
      AEditorMaterialManager.a().a(new WeakReference(this));
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(new AEAutoTemplateRet(5L, null));
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierMaterialClassifierView.setClearButtonEnable(false);
      AEAutoTemplateAdapterMaterial localAEAutoTemplateAdapterMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial;
      if (localAEAutoTemplateAdapterMaterial != null) {
        localAEAutoTemplateAdapterMaterial.b(-1);
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial.a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AEEditorResourceManager.a().d().removeObserver(this.jdField_a_of_type_AndroidxLifecycleObserver);
  }
  
  public void setEntrance(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setHasTemplate(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    AEAutoTemplateAdapterMaterial localAEAutoTemplateAdapterMaterial = this.jdField_a_of_type_ComTencentAelightCameraAeeditorModuleAutotemplateAEAutoTemplateAdapterMaterial;
    if (localAEAutoTemplateAdapterMaterial != null) {
      localAEAutoTemplateAdapterMaterial.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel
 * JD-Core Version:    0.7.0.1
 */