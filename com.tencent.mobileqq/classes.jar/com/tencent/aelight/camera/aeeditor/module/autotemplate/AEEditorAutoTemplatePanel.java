package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class AEEditorAutoTemplatePanel
  extends FrameLayout
  implements AEditorMaterialManager.RecommendListener
{
  private final MutableLiveData<AEAutoTemplateRet> a = new MutableLiveData();
  private final MutableLiveData<Boolean> b = new MutableLiveData();
  private MaterialClassifierView c;
  private AEAutoTemplateAdapterMaterial d;
  private boolean e;
  private String f;
  private MetaMaterial g;
  private Boolean h;
  private final List<MetaCategory> i;
  private final List<MetaMaterial> j;
  private boolean k;
  private Observer<List<MetaCategory>> l;
  private int m;
  private int n;
  private boolean o;
  private Boolean p;
  
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
    paramAttributeSet = Boolean.valueOf(false);
    this.e = false;
    this.h = paramAttributeSet;
    this.i = new ArrayList();
    this.j = new ArrayList();
    this.k = false;
    this.m = -1;
    this.o = false;
    this.p = paramAttributeSet;
    a(paramContext);
  }
  
  private void a(@NonNull Context paramContext)
  {
    this.c = ((MaterialClassifierView)View.inflate(paramContext, 2064056424, this).findViewById(2063990967));
    this.l = new AEEditorAutoTemplatePanel.1(this);
    AEEditorResourceManager.a().g().observeForever(this.l);
  }
  
  private void g()
  {
    this.d = new AEAutoTemplateAdapterMaterial(getContext());
    this.d.a(new AEEditorAutoTemplatePanel.2(this));
    this.c.setup(this.d, this.i, this.j);
    this.c.setCategoryItemListener(new AEEditorAutoTemplatePanel.3(this));
    this.c.setOnClearButtonClickListener(new AEEditorAutoTemplatePanel.4(this));
  }
  
  private void h()
  {
    Object localObject = this.i;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ((MetaCategory)this.i.get(0)).materials = AEditorMaterialManager.a().a;
      if ((!i().booleanValue()) && (((MetaCategory)this.i.get(0)).materials != null))
      {
        ((MetaCategory)this.i.get(0)).materials.add(this.g);
        this.h = Boolean.valueOf(true);
      }
      this.j.clear();
      localObject = this.i.iterator();
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
              this.j.add(localMetaMaterial);
            }
          }
        }
      }
      localObject = this.d;
      if (localObject != null)
      {
        ((AEAutoTemplateAdapterMaterial)localObject).a(AEditorMaterialManager.a().a.size());
        setSelectedIndexByMaterialId(false);
      }
      localObject = this.c;
      if (localObject != null) {
        ((MaterialClassifierView)localObject).a();
      }
    }
  }
  
  private Boolean i()
  {
    Object localObject1 = this.g;
    Boolean localBoolean = Boolean.valueOf(true);
    if (localObject1 == null) {
      return localBoolean;
    }
    MetaMaterial localMetaMaterial;
    do
    {
      localObject1 = this.i.iterator();
      Object localObject2;
      while (!((Iterator)localObject2).hasNext())
      {
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MetaCategory)((Iterator)localObject1).next();
        } while (((MetaCategory)localObject2).materials == null);
        localObject2 = ((MetaCategory)localObject2).materials.iterator();
      }
      localMetaMaterial = (MetaMaterial)((Iterator)localObject2).next();
    } while ((localMetaMaterial == null) || (!localMetaMaterial.id.equals(this.g.id)));
    return localBoolean;
    return Boolean.valueOf(false);
  }
  
  private void setSelectedIndexByMaterialId(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSelectedIndexByMaterialId, mSelectMaterialId=");
    localStringBuilder.append(this.f);
    AEQLog.b("AEEditorAutoTemplatePanel", localStringBuilder.toString());
    if (this.d.a(this.m, this.f).booleanValue())
    {
      this.d.a(this.m, paramBoolean);
      return;
    }
    if (!this.d.a(this.f, paramBoolean)) {
      this.d.b(-1);
    }
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new AEEditorAutoTemplatePanel.5(this));
  }
  
  public void a(int paramInt)
  {
    if ((this.n == paramInt) && (this.d != null) && (this.j.size() > 0) && (!this.o))
    {
      MetaMaterial localMetaMaterial = (MetaMaterial)this.j.get(0);
      if (localMetaMaterial != null) {
        this.d.a(localMetaMaterial.id);
      }
    }
  }
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    this.g = paramMetaMaterial;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.d.a(paramString);
    }
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new AEEditorAutoTemplatePanel.6(this));
  }
  
  public void b(MetaMaterial paramMetaMaterial)
  {
    if (paramMetaMaterial == null) {
      return;
    }
    this.f = paramMetaMaterial.id;
    if (this.p.booleanValue())
    {
      this.p = Boolean.valueOf(false);
      setSelectedIndexByMaterialId(false);
      return;
    }
    setSelectedIndexByMaterialId(true);
  }
  
  public boolean b(String paramString)
  {
    this.f = paramString;
    if (this.d != null)
    {
      this.p = Boolean.valueOf(true);
      this.o = true;
      return this.d.a(paramString);
    }
    return false;
  }
  
  public void c()
  {
    if (!this.e)
    {
      g();
      AEditorMaterialManager.a().a(new WeakReference(this));
      this.e = true;
    }
  }
  
  public void d()
  {
    if (this.k)
    {
      this.a.postValue(new AEAutoTemplateRet(5, null));
      this.c.setClearButtonEnable(false);
      AEAutoTemplateAdapterMaterial localAEAutoTemplateAdapterMaterial = this.d;
      if (localAEAutoTemplateAdapterMaterial != null) {
        localAEAutoTemplateAdapterMaterial.b(-1);
      }
    }
  }
  
  public void e()
  {
    if ((this.h.booleanValue()) && (this.i.size() > 0) && (((MetaCategory)this.i.get(0)).materials != null) && (((MetaCategory)this.i.get(0)).materials.size() > 0))
    {
      this.h = Boolean.valueOf(false);
      ((MetaCategory)this.i.get(0)).materials.remove(((MetaCategory)this.i.get(0)).materials.size() - 1);
    }
  }
  
  public void f()
  {
    this.d.a();
  }
  
  public MutableLiveData<AEAutoTemplateRet> getAutoTemplateRetLiveData()
  {
    return this.a;
  }
  
  public MutableLiveData<Boolean> getRecommendReloadLiveData()
  {
    return this.b;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    AEEditorResourceManager.a().g().removeObserver(this.l);
  }
  
  public void setEntrance(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void setHasTemplate(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setSchemeStatus(Boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setToastValidListener(QQToast.IToastValidListener paramIToastValidListener)
  {
    AEAutoTemplateAdapterMaterial localAEAutoTemplateAdapterMaterial = this.d;
    if (localAEAutoTemplateAdapterMaterial != null) {
      localAEAutoTemplateAdapterMaterial.a(paramIToastValidListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel
 * JD-Core Version:    0.7.0.1
 */