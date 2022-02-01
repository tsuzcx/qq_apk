package com.tencent.aelight.camera.ae;

import android.support.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.BaseApplicationImpl;

public class AEViewModelProviders
{
  public static ViewModelProvider a(@NonNull ViewModelStoreOwner paramViewModelStoreOwner)
  {
    return new ViewModelProvider(paramViewModelStoreOwner, ViewModelProvider.AndroidViewModelFactory.getInstance(BaseApplicationImpl.getApplication()));
  }
  
  public static ViewModelProvider a(@NonNull ViewModelStoreOwner paramViewModelStoreOwner, ViewModelProvider.Factory paramFactory)
  {
    return new ViewModelProvider(paramViewModelStoreOwner, paramFactory);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEViewModelProviders
 * JD-Core Version:    0.7.0.1
 */