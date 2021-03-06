package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModel;", "Landroidx/lifecycle/ViewModel;", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "cosmeticsViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsViewModel;", "filterViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEFilterProviderViewModel;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEFilterProviderViewModel;)V", "_aiBeautyToggle", "Landroidx/lifecycle/MutableLiveData;", "", "_seekBarOpDataLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/SeekBarOpDataWrapper;", "_seekBarShowLiveData", "_selectedPanelTabIndex", "", "aiBeautyToggle", "Landroidx/lifecycle/LiveData;", "getAiBeautyToggle", "()Landroidx/lifecycle/LiveData;", "seekBarOpDataLiveData", "getSeekBarOpDataLiveData", "seekBarShowLiveData", "getSeekBarShowLiveData", "selectedPanelTabIndex", "getSelectedPanelTabIndex", "notifySeekBarValueChange", "", "model", "", "progress", "refreshCurrentSelectEffect", "setSelectedPanelTab", "index", "toggleAiBeauty", "on", "updateVideoMaterialAbility", "ability", "material", "Lcom/tencent/aelight/camera/ae/data/AEMaterialMetaData;", "Companion", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEProviderViewModel
  extends ViewModel
{
  public static final AEProviderViewModel.Companion a = new AEProviderViewModel.Companion(null);
  private static boolean m = true;
  private static boolean n = true;
  private static boolean o = true;
  private static final Map<String, Integer> p;
  private static final Map<String, Integer> q;
  private static final Map<BeautyRealConfig.TYPE, Integer> r = (Map)new LinkedHashMap();
  private static final Map<BeautyRealConfig.TYPE, Integer> s = (Map)new LinkedHashMap();
  private static final Map<String, Integer> t = (Map)new LinkedHashMap();
  private static final Map<String, Integer> u = (Map)new LinkedHashMap();
  private static final Map<String, Integer> v = (Map)new LinkedHashMap();
  private final MutableLiveData<Integer> b;
  @NotNull
  private final LiveData<Integer> c;
  private final MutableLiveData<Boolean> d;
  @NotNull
  private final LiveData<Boolean> e;
  private final MediatorLiveData<SeekBarOpDataWrapper> f;
  @NotNull
  private final LiveData<SeekBarOpDataWrapper> g;
  private final MediatorLiveData<Boolean> h;
  @NotNull
  private final LiveData<Boolean> i;
  private final AEBeautyProviderViewModel j;
  private final AECosmeticsViewModel k;
  private final AEFilterProviderViewModel l;
  
  static
  {
    Object localObject1 = Integer.valueOf(60);
    Pair localPair1 = TuplesKt.to("??????", localObject1);
    Pair localPair2 = TuplesKt.to("??????", localObject1);
    Object localObject2 = TuplesKt.to("????????????", localObject1);
    Pair localPair3 = TuplesKt.to("??????", localObject1);
    Pair localPair4 = TuplesKt.to("?????????", localObject1);
    Integer localInteger = Integer.valueOf(80);
    p = MapsKt.mapOf(new Pair[] { localPair1, localPair2, localObject2, localPair3, localPair4, TuplesKt.to("??????", localInteger), TuplesKt.to("?????????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("????????????", localInteger), TuplesKt.to("??????", localObject1), TuplesKt.to("????????????", localObject1), TuplesKt.to("??????", localObject1), TuplesKt.to("??????", localObject1), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", Integer.valueOf(70)), TuplesKt.to("??????", localInteger) });
    localObject1 = TuplesKt.to("??????", localInteger);
    localPair1 = TuplesKt.to("??????", localInteger);
    localPair2 = TuplesKt.to("??????", localInteger);
    localObject2 = Integer.valueOf(100);
    q = MapsKt.mapOf(new Pair[] { localObject1, localPair1, localPair2, TuplesKt.to("??????", localObject2), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", Integer.valueOf(65)), TuplesKt.to("??????", localObject2), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localObject2), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localObject2), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("?????????", localInteger), TuplesKt.to("?????????", localInteger), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localObject2), TuplesKt.to("??????", localInteger), TuplesKt.to("??????", localObject2) });
  }
  
  public AEProviderViewModel(@NotNull AEBeautyProviderViewModel paramAEBeautyProviderViewModel, @NotNull AECosmeticsViewModel paramAECosmeticsViewModel, @NotNull AEFilterProviderViewModel paramAEFilterProviderViewModel)
  {
    this.j = paramAEBeautyProviderViewModel;
    this.k = paramAECosmeticsViewModel;
    this.l = paramAEFilterProviderViewModel;
    this.b = new MutableLiveData(Integer.valueOf(0));
    paramAEBeautyProviderViewModel = this.b;
    if (paramAEBeautyProviderViewModel != null)
    {
      this.c = ((LiveData)paramAEBeautyProviderViewModel);
      this.d = new MutableLiveData();
      paramAEBeautyProviderViewModel = this.d;
      if (paramAEBeautyProviderViewModel != null)
      {
        this.e = ((LiveData)paramAEBeautyProviderViewModel);
        paramAEBeautyProviderViewModel = new MediatorLiveData();
        paramAEBeautyProviderViewModel.addSource(this.l.a(), (Observer)new AEProviderViewModel._seekBarOpDataLiveData.1.1(paramAEBeautyProviderViewModel));
        paramAEBeautyProviderViewModel.addSource(this.k.b(), (Observer)new AEProviderViewModel._seekBarOpDataLiveData.1.2(paramAEBeautyProviderViewModel));
        paramAEBeautyProviderViewModel.addSource(this.j.e(), (Observer)new AEProviderViewModel._seekBarOpDataLiveData.1.3(paramAEBeautyProviderViewModel));
        paramAEBeautyProviderViewModel.addSource(this.j.g(), (Observer)new AEProviderViewModel..special..inlined.apply.lambda.1(paramAEBeautyProviderViewModel, this));
        paramAEBeautyProviderViewModel.addSource(this.j.a(), (Observer)new AEProviderViewModel..special..inlined.apply.lambda.2(paramAEBeautyProviderViewModel, this));
        paramAEBeautyProviderViewModel.addSource((LiveData)this.b, (Observer)new AEProviderViewModel..special..inlined.apply.lambda.3(paramAEBeautyProviderViewModel, this));
        this.f = paramAEBeautyProviderViewModel;
        paramAEBeautyProviderViewModel = this.f;
        if (paramAEBeautyProviderViewModel != null)
        {
          this.g = ((LiveData)paramAEBeautyProviderViewModel);
          paramAEBeautyProviderViewModel = new MediatorLiveData();
          paramAEBeautyProviderViewModel.addSource((LiveData)this.f, (Observer)new AEProviderViewModel..special..inlined.apply.lambda.4(paramAEBeautyProviderViewModel, this));
          paramAEBeautyProviderViewModel.addSource((LiveData)this.j.h(), (Observer)new AEProviderViewModel._seekBarShowLiveData.1.2(paramAEBeautyProviderViewModel));
          this.h = paramAEBeautyProviderViewModel;
          paramAEBeautyProviderViewModel = this.h;
          if (paramAEBeautyProviderViewModel != null)
          {
            this.i = ((LiveData)paramAEBeautyProviderViewModel);
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<com.tencent.aelight.camera.ae.camera.ui.panel.SeekBarOpDataWrapper>");
      }
      throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Boolean>");
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.lifecycle.LiveData<kotlin.Int>");
  }
  
  @JvmStatic
  public static final int a(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    return a.a(paramAEBeautyConfigModel);
  }
  
  @JvmStatic
  public static final int a(@NotNull Object paramObject)
  {
    return a.b(paramObject);
  }
  
  @JvmStatic
  public static final int a(@NotNull String paramString)
  {
    return a.a(paramString);
  }
  
  @JvmStatic
  public static final int b(@NotNull Object paramObject)
  {
    return a.c(paramObject);
  }
  
  @JvmStatic
  @Nullable
  public static final AEBeautySecondaryConfigModel b(@NotNull AEBeautyConfigModel paramAEBeautyConfigModel)
  {
    return a.b(paramAEBeautyConfigModel);
  }
  
  @JvmStatic
  public static final void b(@NotNull Object paramObject, int paramInt)
  {
    a.a(paramObject, paramInt);
  }
  
  @JvmStatic
  public static final int c(@NotNull Object paramObject)
  {
    return a.d(paramObject);
  }
  
  @JvmStatic
  public static final void c(@NotNull Object paramObject, int paramInt)
  {
    a.c(paramObject, paramInt);
  }
  
  @JvmStatic
  public static final int d(@NotNull Object paramObject)
  {
    return a.e(paramObject);
  }
  
  public final void a()
  {
    Integer localInteger = (Integer)this.b.getValue();
    if ((localInteger != null) && (localInteger.intValue() == 0))
    {
      this.l.b();
      return;
    }
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      this.j.f();
      return;
    }
    if (localInteger == null) {
      return;
    }
    if (localInteger.intValue() == 2) {
      this.k.c();
    }
  }
  
  public final void a(int paramInt)
  {
    this.b.postValue(Integer.valueOf(paramInt));
  }
  
  public final void a(int paramInt, @Nullable AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.k.a(paramAEMaterialMetaData);
    this.j.a(paramInt, paramAEMaterialMetaData);
  }
  
  public final void a(@NotNull Object paramObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "model");
    if ((paramObject instanceof AEBeautyConfigModel))
    {
      AEBeautyConfigModel localAEBeautyConfigModel = (AEBeautyConfigModel)paramObject;
      if (localAEBeautyConfigModel.i().isEmpty())
      {
        this.j.j().postValue(paramObject);
        return;
      }
      paramObject = a.b(localAEBeautyConfigModel);
      if (paramObject != null) {
        a(paramObject, paramInt);
      }
    }
    else if ((paramObject instanceof AEBeautySecondaryConfigModel))
    {
      this.j.k().postValue(paramObject);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d.postValue(Boolean.valueOf(paramBoolean));
  }
  
  @NotNull
  public final LiveData<Integer> b()
  {
    return this.c;
  }
  
  @NotNull
  public final LiveData<Boolean> c()
  {
    return this.e;
  }
  
  @NotNull
  public final LiveData<SeekBarOpDataWrapper> d()
  {
    return this.g;
  }
  
  @NotNull
  public final LiveData<Boolean> e()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModel
 * JD-Core Version:    0.7.0.1
 */