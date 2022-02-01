package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;

public class StickerRecViewModelFactory
  implements ViewModelProvider.Factory
{
  @NonNull
  public <T extends ViewModel> T create(@NonNull Class<T> paramClass)
  {
    paramClass = new StickerRecRepository();
    StickerRecViewModel localStickerRecViewModel = new StickerRecViewModel(paramClass);
    paramClass.a(localStickerRecViewModel);
    return localStickerRecViewModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewModelFactory
 * JD-Core Version:    0.7.0.1
 */