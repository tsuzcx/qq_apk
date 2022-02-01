package com.tencent.biz.qqcircle.publish.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;

public class QCircleShareViewModel
  extends BaseViewModel
{
  public MutableLiveData<Boolean> a = new MutableLiveData();
  public boolean b;
  
  public String a()
  {
    return "[QcirclePublish]QCircleShareViewModel";
  }
  
  public void b()
  {
    this.b ^= true;
    this.a.postValue(Boolean.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.viewmodel.QCircleShareViewModel
 * JD-Core Version:    0.7.0.1
 */