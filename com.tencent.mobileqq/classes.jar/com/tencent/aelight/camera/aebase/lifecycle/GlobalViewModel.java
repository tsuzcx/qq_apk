package com.tencent.aelight.camera.aebase.lifecycle;

import android.support.annotation.CallSuper;
import androidx.lifecycle.ViewModel;

public class GlobalViewModel
  extends ViewModel
{
  @CallSuper
  public void onCleared()
  {
    super.onCleared();
    GlobalViewModelFactory.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.lifecycle.GlobalViewModel
 * JD-Core Version:    0.7.0.1
 */