package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.aelight.camera.ae.data.AEMaterialCategory;
import com.tencent.aelight.camera.api.IAEFilterManagerHolder;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.editor.MetaMaterialKt;
import com.tencent.mobileqq.wink.editor.filter.FilterMetaMaterialKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AEFlashSHOWFilterViewModel
  extends ViewModel
{
  private MediatorLiveData<MetaMaterial> a = new MediatorLiveData();
  private MediatorLiveData<AEFlashSHOWFilterViewModel.FilterSeekBarData> b = new MediatorLiveData();
  private MutableLiveData<AEFlashSHOWFilterViewModel.FilterMaterialData> c = new MutableLiveData();
  private AEFlashShowFilterDataManager d = (AEFlashShowFilterDataManager)AEQIMManager.a(4);
  private AEFlashShowMaterialManager e = (AEFlashShowMaterialManager)AEQIMManager.a(3);
  
  public AEFlashSHOWFilterViewModel()
  {
    d();
  }
  
  private int c(MetaMaterial paramMetaMaterial)
  {
    return FilterMetaMaterialKt.l(paramMetaMaterial);
  }
  
  private void d()
  {
    this.e.b(false);
    this.e.a(new AEFlashSHOWFilterViewModel.1(this), 116);
    this.b.addSource(this.a, new AEFlashSHOWFilterViewModel.2(this));
  }
  
  public LiveData<MetaMaterial> a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (this.a.getValue() != null)
    {
      FilterMetaMaterialKt.a((MetaMaterial)this.a.getValue(), paramInt);
      this.d.a(((MetaMaterial)this.a.getValue()).id, new AEFlashShowFilterDataManager.FilterData(paramInt));
    }
  }
  
  public void a(int paramInt, MetaMaterial paramMetaMaterial)
  {
    this.a.postValue(paramMetaMaterial);
    this.d.a(paramMetaMaterial);
  }
  
  public void a(MetaMaterial paramMetaMaterial)
  {
    if ((!((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).isAEFilterManagerEmpty()) && (paramMetaMaterial != null))
    {
      paramMetaMaterial = FilterMetaMaterialKt.k(paramMetaMaterial);
      ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).setIsAfterUpdateMaterial(false);
      ((IAEFilterManagerHolder)QRoute.api(IAEFilterManagerHolder.class)).updateLutGL(paramMetaMaterial);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    Object localObject1 = this.e.g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("### updateData: filter list size:");
    ((StringBuilder)localObject2).append(((List)localObject1).size());
    ((StringBuilder)localObject2).append(" ,totalList = ");
    ((StringBuilder)localObject2).append(localObject1.toString());
    AEQLog.b("AEFlashSHOWFilterViewModel", ((StringBuilder)localObject2).toString());
    localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AEMaterialCategory)((Iterator)localObject2).next();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("category id:");
      ((StringBuilder)localObject4).append(((AEMaterialCategory)localObject3).b);
      ((StringBuilder)localObject4).append(" ,name = ");
      ((StringBuilder)localObject4).append(((AEMaterialCategory)localObject3).d);
      AEQLog.b("AEFlashSHOWFilterViewModel", ((StringBuilder)localObject4).toString());
    }
    if (((List)localObject1).size() == 0) {
      return;
    }
    localObject1 = (AEMaterialCategory)((List)localObject1).get(0);
    if (((AEMaterialCategory)localObject1).h != null)
    {
      if (((AEMaterialCategory)localObject1).h.size() == 0) {
        return;
      }
      localObject2 = new ArrayList();
      localObject3 = ((AEMaterialCategory)localObject1).h.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (MetaCategory)((Iterator)localObject3).next();
        if (((MetaCategory)localObject4).materials != null)
        {
          Iterator localIterator = ((MetaCategory)localObject4).materials.iterator();
          while (localIterator.hasNext())
          {
            MetaMaterial localMetaMaterial = (MetaMaterial)localIterator.next();
            MetaMaterialKt.b(localMetaMaterial, ((MetaCategory)localObject4).id);
            MetaMaterialKt.a(localMetaMaterial, (String)localMetaMaterial.additionalFields.get("filter_name"));
            FilterMetaMaterialKt.a(localMetaMaterial, localMetaMaterial.id);
            if (paramBoolean.booleanValue()) {
              FilterMetaMaterialKt.a(localMetaMaterial, FilterMetaMaterialKt.b(localMetaMaterial));
            }
          }
          int i = 0;
          while (i < ((MetaCategory)localObject4).materials.size())
          {
            if (((MetaCategory)localObject4).materials.get(i) != null)
            {
              int j = AEFlashSHOWFilterViewModel.3.a[FilterMetaMaterialKt.e((MetaMaterial)localObject4.materials.get(i)).ordinal()];
              if (j != 1)
              {
                if (j != 2)
                {
                  if (j == 3)
                  {
                    MetaMaterialKt.a((MetaMaterial)((MetaCategory)localObject4).materials.get(i), true);
                    MetaMaterialKt.b((MetaMaterial)((MetaCategory)localObject4).materials.get(i), true);
                  }
                }
                else
                {
                  MetaMaterialKt.a((MetaMaterial)((MetaCategory)localObject4).materials.get(i), false);
                  MetaMaterialKt.b((MetaMaterial)((MetaCategory)localObject4).materials.get(i), false);
                }
              }
              else
              {
                MetaMaterialKt.a((MetaMaterial)((MetaCategory)localObject4).materials.get(i), false);
                MetaMaterialKt.b((MetaMaterial)((MetaCategory)localObject4).materials.get(i), false);
              }
            }
            i += 1;
          }
          ((List)localObject2).addAll(((MetaCategory)localObject4).materials);
        }
      }
      this.c.postValue(new AEFlashSHOWFilterViewModel.FilterMaterialData(this, ((AEMaterialCategory)localObject1).h, (List)localObject2));
    }
  }
  
  public LiveData<AEFlashSHOWFilterViewModel.FilterSeekBarData> b()
  {
    return this.b;
  }
  
  public AEFlashSHOWFilterViewModel.FilterSeekBarData b(MetaMaterial paramMetaMaterial)
  {
    return new AEFlashSHOWFilterViewModel.FilterSeekBarData(this, paramMetaMaterial);
  }
  
  public MutableLiveData<AEFlashSHOWFilterViewModel.FilterMaterialData> c()
  {
    return this.c;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    this.d.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashSHOWFilterViewModel
 * JD-Core Version:    0.7.0.1
 */