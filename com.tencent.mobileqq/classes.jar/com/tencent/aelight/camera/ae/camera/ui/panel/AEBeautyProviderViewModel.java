package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "VIDEO_NAME_DIEJIA", "", "_beautyConfigSetLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyConfigModel;", "_beautySecondarySelectedLiveData", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautySecondarySelectedWrapper;", "_beautySelectedLiveData", "beautyAdjustChangedLiveData", "getBeautyAdjustChangedLiveData", "()Landroidx/lifecycle/MutableLiveData;", "beautyConfigSetLiveData", "Landroidx/lifecycle/LiveData;", "getBeautyConfigSetLiveData", "()Landroidx/lifecycle/LiveData;", "beautyConfigSetOnCreateLiveData", "Landroidx/lifecycle/MediatorLiveData;", "getBeautyConfigSetOnCreateLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "beautySecondaryAdjustChangedLiveData", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautySecondaryConfigModel;", "getBeautySecondaryAdjustChangedLiveData", "beautySecondarySelectedLiveData", "getBeautySecondarySelectedLiveData", "beautySelectedLiveData", "getBeautySelectedLiveData", "secondaryBeautyListOpenLiveData", "", "getSecondaryBeautyListOpenLiveData", "videoAbility", "", "clearBeautyConfigList", "", "beautyConfigList", "clearBeautyValue", "initBeautyConfigModel", "isBeautyItemEnable", "config", "enableMakeup", "enableMesh", "refreshBeautyValue", "refreshSelectEffect", "resetBeautyConfigList", "resetBeautyValue", "setBeautyConfigSetLiveData", "value", "setSelectedPrimaryBeautyConfig", "setSelectedSecondaryBeautyConfig", "updateVideoAbility", "ability", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEBeautyProviderViewModel
  extends ViewModel
{
  private int a;
  private final String b = "video_diejia_";
  private final MutableLiveData<List<AEBeautyConfigModel>> c = new MutableLiveData();
  @NotNull
  private final LiveData<List<AEBeautyConfigModel>> d;
  private final MutableLiveData<AEBeautyConfigModel> e;
  @NotNull
  private final LiveData<AEBeautyConfigModel> f;
  private final MutableLiveData<BeautySecondarySelectedWrapper> g;
  @NotNull
  private final LiveData<BeautySecondarySelectedWrapper> h;
  @NotNull
  private final MutableLiveData<Boolean> i;
  @NotNull
  private final MediatorLiveData<List<AEBeautyConfigModel>> j;
  @NotNull
  private final MutableLiveData<AEBeautyConfigModel> k;
  @NotNull
  private final MutableLiveData<AEBeautySecondaryConfigModel> l;
  
  public AEBeautyProviderViewModel()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      this.d = ((LiveData)localObject);
      this.e = new MutableLiveData();
      localObject = this.e;
      if (localObject != null)
      {
        this.f = ((LiveData)localObject);
        this.g = new MutableLiveData();
        localObject = this.g;
        if (localObject != null)
        {
          this.h = ((LiveData)localObject);
          this.i = new MutableLiveData(Boolean.valueOf(false));
          localObject = new MediatorLiveData();
          ((MediatorLiveData)localObject).addSource(this.d, (Observer)new AEBeautyProviderViewModel.beautyConfigSetOnCreateLiveData.1.1((MediatorLiveData)localObject));
          this.j = ((MediatorLiveData)localObject);
          this.k = new MutableLiveData();
          this.l = new MutableLiveData();
          AsyncTask.THREAD_POOL_EXECUTOR.execute((Runnable)new AEBeautyProviderViewModel.1(this));
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.BeautySecondarySelectedWrapper>");
      }
      throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel>");
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.collections.List<com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel>>");
  }
  
  private final void a(List<? extends AEBeautyConfigModel> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEBeautyConfigModel)paramList.next();
      if (((AEBeautyConfigModel)localObject).i().isEmpty())
      {
        AEProviderViewModel.a.c(localObject, ((AEBeautyConfigModel)localObject).e());
        AEProviderViewModel.a.a(localObject, ((AEBeautyConfigModel)localObject).e());
      }
      else
      {
        AEProviderViewModel.a.a((AEBeautyConfigModel)localObject, ((AEBeautyConfigModel)localObject).j());
        AEProviderViewModel.a.d((AEBeautyConfigModel)localObject);
        localObject = ((Iterable)((AEBeautyConfigModel)localObject).i()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEBeautySecondaryConfigModel localAEBeautySecondaryConfigModel = (AEBeautySecondaryConfigModel)((Iterator)localObject).next();
          AEProviderViewModel.a.c(localAEBeautySecondaryConfigModel, localAEBeautySecondaryConfigModel.i());
          AEProviderViewModel.a.a(localAEBeautySecondaryConfigModel, localAEBeautySecondaryConfigModel.i());
        }
      }
    }
  }
  
  private final boolean a(AEBeautyConfigModel paramAEBeautyConfigModel, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && ((paramAEBeautyConfigModel.a() == BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA.getType()) || (paramAEBeautyConfigModel.a() == BeautyItem.FACE_FEATURE_REDCHEEK.getType()) || (paramAEBeautyConfigModel.a() == BeautyItem.FACE_FEATURE_SOFT.getType()))) {
      return false;
    }
    return (!paramBoolean2) || ((paramAEBeautyConfigModel.a() != BeautyItem.EYE.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.CHEEKBONE_THIN.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.NOSE.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.MOUTH_SHAPE.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.FOREHEAD.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.BASICFACE.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.FACE_SMALLER.getType()) && (paramAEBeautyConfigModel.a() != BeautyItem.FACE_THIN.getType()));
  }
  
  private final void b(List<? extends AEBeautyConfigModel> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (AEBeautyConfigModel)paramList.next();
      if (((AEBeautyConfigModel)localObject).i().isEmpty())
      {
        AEProviderViewModel.a.c(localObject, 0);
        AEProviderViewModel.a.a(localObject, 0);
      }
      else
      {
        AEProviderViewModel.a.a((AEBeautyConfigModel)localObject, ((AEBeautyConfigModel)localObject).j());
        AEProviderViewModel.a.d((AEBeautyConfigModel)localObject);
        localObject = ((Iterable)((AEBeautyConfigModel)localObject).i()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          AEBeautySecondaryConfigModel localAEBeautySecondaryConfigModel = (AEBeautySecondaryConfigModel)((Iterator)localObject).next();
          AEProviderViewModel.a.c(localAEBeautySecondaryConfigModel, 0);
          AEProviderViewModel.a.a(localAEBeautySecondaryConfigModel, 0);
        }
      }
    }
  }
  
  @NotNull
  public final LiveData<List<AEBeautyConfigModel>> a()
  {
    return this.d;
  }
  
  public final void a(int paramInt, @Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.a = paramInt;
    boolean bool1 = true;
    boolean bool2;
    if ((paramInt & 0x1) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((paramInt & 0x2) == 0) {
      bool1 = false;
    }
    if (paramAEMaterialMetaData != null)
    {
      paramAEMaterialMetaData = paramAEMaterialMetaData.t;
      if (paramAEMaterialMetaData != null) {}
    }
    else
    {
      paramAEMaterialMetaData = "";
    }
    if (StringsKt.startsWith$default(paramAEMaterialMetaData, this.b, false, 2, null)) {
      bool1 = false;
    }
    paramAEMaterialMetaData = (List)this.c.getValue();
    if (paramAEMaterialMetaData != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramAEMaterialMetaData, "_beautyConfigSetLiveData.value ?: return");
      paramAEMaterialMetaData = ((Iterable)paramAEMaterialMetaData).iterator();
      while (paramAEMaterialMetaData.hasNext())
      {
        AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)paramAEMaterialMetaData.next();
        localAEBeautyConfigModel.a(a(localAEBeautyConfigModel, bool2, bool1));
        Iterator localIterator = ((Iterable)localAEBeautyConfigModel.i()).iterator();
        while (localIterator.hasNext()) {
          ((AEBeautySecondaryConfigModel)localIterator.next()).a(localAEBeautyConfigModel.h());
        }
      }
    }
  }
  
  public final void a(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautyConfigModel, "value");
    this.e.postValue(paramAEBeautyConfigModel);
  }
  
  public final void a(@NotNull AEBeautySecondaryConfigModel paramAEBeautySecondaryConfigModel)
  {
    Intrinsics.checkParameterIsNotNull(paramAEBeautySecondaryConfigModel, "value");
    AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)this.f.getValue();
    if (localAEBeautyConfigModel != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localAEBeautyConfigModel, "beautySelectedLiveData.value ?: return");
      Object localObject = localAEBeautyConfigModel.i();
      int m = 0;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AEBeautySecondaryConfigModel localAEBeautySecondaryConfigModel = (AEBeautySecondaryConfigModel)((Iterator)localObject).next();
        if (Intrinsics.areEqual(paramAEBeautySecondaryConfigModel.c(), localAEBeautySecondaryConfigModel.c())) {
          break label95;
        }
        m += 1;
      }
      m = -1;
      label95:
      if (m >= 0)
      {
        this.g.postValue(new BeautySecondarySelectedWrapper(localAEBeautyConfigModel, paramAEBeautySecondaryConfigModel, m));
        AEProviderViewModel.a.a(localAEBeautyConfigModel, m);
        AEProviderViewModel.a.d(localAEBeautyConfigModel);
      }
    }
  }
  
  public final void b()
  {
    Object localObject1 = (List)this.c.getValue();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "_beautyConfigSetLiveData.value ?: return");
      a((List)localObject1);
      this.c.postValue(localObject1);
      if (DYAEEffectItemExtKt.a(this.e.getValue()))
      {
        Object localObject3 = (List)this.c.getValue();
        localObject1 = null;
        Object localObject2 = null;
        if (localObject3 != null)
        {
          localObject3 = ((Iterable)localObject3).iterator();
          int m;
          do
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = ((Iterator)localObject3).next();
            AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)localObject1;
            if ((!DYAEEffectItemExtKt.a(localAEBeautyConfigModel)) && (localAEBeautyConfigModel.k() != BeautyItem.RESET)) {
              m = 1;
            } else {
              m = 0;
            }
          } while (m == 0);
          localObject1 = (AEBeautyConfigModel)localObject1;
        }
        if (localObject1 != null) {
          this.e.postValue(localObject1);
        }
      }
    }
  }
  
  public final void c()
  {
    List localList = (List)this.c.getValue();
    if (localList != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localList, "_beautyConfigSetLiveData.value ?: return");
      b(localList);
      this.c.postValue(localList);
      this.e.postValue(CollectionsKt.firstOrNull(localList));
    }
  }
  
  public final void d()
  {
    List localList = (List)this.c.getValue();
    if (localList != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localList, "_beautyConfigSetLiveData.value ?: return");
      this.c.postValue(localList);
    }
  }
  
  @NotNull
  public final LiveData<AEBeautyConfigModel> e()
  {
    return this.f;
  }
  
  public final void f()
  {
    AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)this.e.getValue();
    if (localAEBeautyConfigModel != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localAEBeautyConfigModel, "_beautySelectedLiveData.value ?: return");
      a(localAEBeautyConfigModel);
    }
  }
  
  @NotNull
  public final LiveData<BeautySecondarySelectedWrapper> g()
  {
    return this.h;
  }
  
  @NotNull
  public final MutableLiveData<Boolean> h()
  {
    return this.i;
  }
  
  @NotNull
  public final MediatorLiveData<List<AEBeautyConfigModel>> i()
  {
    return this.j;
  }
  
  @NotNull
  public final MutableLiveData<AEBeautyConfigModel> j()
  {
    return this.k;
  }
  
  @NotNull
  public final MutableLiveData<AEBeautySecondaryConfigModel> k()
  {
    return this.l;
  }
  
  @NotNull
  public final List<AEBeautyConfigModel> l()
  {
    List localList = (List)new ArrayList();
    localList.add(new AEBeautyConfigModel(BeautyItem.NONE));
    localList.add(new AEBeautyConfigModel(BeautyItem.RESET));
    localList.add(new AEBeautyConfigModel(BeautyItem.SKIN));
    localList.add(new AEBeautyConfigModel(BeautyItem.BASICFACE));
    localList.add(new AEBeautyConfigModel(BeautyItem.EYE));
    localList.add(new AEBeautyConfigModel(BeautyItem.LUT_CLEAR_ALPHA));
    localList.add(new AEBeautyConfigModel(BeautyItem.LUT_FOUNDATION_ALPHA));
    localList.add(new AEBeautyConfigModel(BeautyItem.FACE_SMALLER));
    localList.add(new AEBeautyConfigModel(BeautyItem.FACE_THIN));
    localList.add(new AEBeautyConfigModel(BeautyItem.CHEEKBONE_THIN));
    localList.add(new AEBeautyConfigModel(BeautyItem.NOSE));
    localList.add(new AEBeautyConfigModel(BeautyItem.MOUTH_SHAPE));
    localList.add(new AEBeautyConfigModel(BeautyItem.FOREHEAD));
    if (AEOfflineConfig.getPhonePerfLevel() >= 3)
    {
      localList.add(new AEBeautyConfigModel(BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA));
      localList.add(new AEBeautyConfigModel(BeautyItem.FACE_FEATURE_REDCHEEK));
      localList.add(new AEBeautyConfigModel(BeautyItem.FACE_FEATURE_SOFT));
      localList.add(new AEBeautyConfigModel(BeautyItem.TOOTH_WHITEN));
      localList.add(new AEBeautyConfigModel(BeautyItem.REMOVE_POUNCH));
      localList.add(new AEBeautyConfigModel(BeautyItem.REMOVE_WRINKLES2));
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyProviderViewModel
 * JD-Core Version:    0.7.0.1
 */