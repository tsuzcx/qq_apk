package com.tencent.biz.qqcircle.immersive.personal.bean;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils;

public class QFSPersonalInfoLiveData
  extends MutableLiveData<QFSPersonalInfo>
  implements QFSPersonalInfo.OnParseFinishListener
{
  public void a(QFSPersonalInfo paramQFSPersonalInfo)
  {
    if (QFSThreadUtils.b())
    {
      b(paramQFSPersonalInfo);
      return;
    }
    postValue(paramQFSPersonalInfo);
  }
  
  public void b(QFSPersonalInfo paramQFSPersonalInfo)
  {
    paramQFSPersonalInfo.a(this);
    super.setValue(paramQFSPersonalInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfoLiveData
 * JD-Core Version:    0.7.0.1
 */