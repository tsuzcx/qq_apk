package com.tencent.aelight.camera.ae.camera.ui.topbar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AEVideoStoryTopBarViewModel
  extends ViewModel
{
  public final MutableLiveData<AEVideoStoryTopBarViewModel.Ratio> a = new MutableLiveData();
  private final MutableLiveData<Boolean> b = new MutableLiveData();
  private MutableLiveData<AEVideoStoryTopBarViewModel.CountDownSetting> c = new MutableLiveData();
  private MutableLiveData<Boolean> d = new MutableLiveData();
  private MutableLiveData<Boolean> e = new MutableLiveData();
  private final MutableLiveData<Integer> f = new MutableLiveData();
  
  public MutableLiveData<Boolean> a()
  {
    return this.b;
  }
  
  public void a(boolean paramBoolean)
  {
    MutableLiveData localMutableLiveData = this.f;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localMutableLiveData.postValue(Integer.valueOf(i));
  }
  
  public MutableLiveData<AEVideoStoryTopBarViewModel.CountDownSetting> b()
  {
    return this.c;
  }
  
  public MutableLiveData<Boolean> c()
  {
    return this.d;
  }
  
  public MutableLiveData<Boolean> d()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel
 * JD-Core Version:    0.7.0.1
 */