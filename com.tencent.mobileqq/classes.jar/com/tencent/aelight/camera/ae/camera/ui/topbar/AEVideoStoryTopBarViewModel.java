package com.tencent.aelight.camera.ae.camera.ui.topbar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AEVideoStoryTopBarViewModel
  extends ViewModel
{
  public final MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> a = new MutableLiveData();
  private MutableLiveData<AEVideoStoryTopBarViewModel.CountDownSetting> b = new MutableLiveData();
  private MutableLiveData<Boolean> c = new MutableLiveData();
  
  public MutableLiveData<AEVideoStoryTopBarViewModel.CountDownSetting> a()
  {
    return this.b;
  }
  
  public MutableLiveData<Boolean> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel
 * JD-Core Version:    0.7.0.1
 */