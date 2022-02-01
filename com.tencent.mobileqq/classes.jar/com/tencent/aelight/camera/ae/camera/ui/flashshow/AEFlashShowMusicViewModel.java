package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMusicViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "musicState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/aelight/camera/ae/camera/ui/flashshow/AEFlashShowMusicState;", "getMusicState", "()Landroidx/lifecycle/MutableLiveData;", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AEFlashShowMusicViewModel
  extends ViewModel
{
  @NotNull
  private final MutableLiveData<AEFlashShowMusicState> a = new MutableLiveData();
  
  @NotNull
  public final MutableLiveData<AEFlashShowMusicState> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowMusicViewModel
 * JD-Core Version:    0.7.0.1
 */