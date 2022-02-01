package com.tencent.aelight.camera.ae.camera.ui.panel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEProviderViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "beautyViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;", "cosmeticsViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsViewModel;", "filterViewModel", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEFilterProviderViewModel;", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEBeautyProviderViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AECosmeticsViewModel;Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEFilterProviderViewModel;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEProviderViewModelFactory
  implements ViewModelProvider.Factory
{
  private final AEBeautyProviderViewModel a;
  private final AECosmeticsViewModel b;
  private final AEFilterProviderViewModel c;
  
  public AEProviderViewModelFactory(@NotNull AEBeautyProviderViewModel paramAEBeautyProviderViewModel, @NotNull AECosmeticsViewModel paramAECosmeticsViewModel, @NotNull AEFilterProviderViewModel paramAEFilterProviderViewModel)
  {
    this.a = paramAEBeautyProviderViewModel;
    this.b = paramAECosmeticsViewModel;
    this.c = paramAEFilterProviderViewModel;
  }
  
  public <T extends ViewModel> T create(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "modelClass");
    if (paramClass.isAssignableFrom(AEProviderViewModel.class)) {
      return (ViewModel)new AEProviderViewModel(this.a, this.b, this.c);
    }
    throw ((Throwable)new IllegalArgumentException("ViewModel Not Found"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEProviderViewModelFactory
 * JD-Core Version:    0.7.0.1
 */