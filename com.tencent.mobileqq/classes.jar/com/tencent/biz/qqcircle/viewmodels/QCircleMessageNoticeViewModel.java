package com.tencent.biz.qqcircle.viewmodels;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleMessageNoticeInfo;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class QCircleMessageNoticeViewModel
  extends QCircleBaseViewModel
{
  private MutableLiveData<QCircleMessageNoticeInfo> a = new MutableLiveData();
  private Observer<QCircleMessageNoticeInfo> b = new QCircleMessageNoticeViewModel.2(this);
  
  private void a(List<String> paramList, int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setNoticeTipValue ");
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", messageUnRead:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("jumpLink:");
    localStringBuilder.append(paramString2);
    QLog.d("QCircleMessageNoticeViewModel", 1, localStringBuilder.toString());
    paramList = new QCircleMessageNoticeInfo(paramList, paramInt, paramString1, paramString2);
    this.a.postValue(paramList);
  }
  
  private MutableLiveData<QCircleMessageNoticeInfo> b()
  {
    return this.a;
  }
  
  public String a()
  {
    return "QCircleMessageNoticeViewModel";
  }
  
  public void a(Context paramContext)
  {
    QLog.i("QCircleMessageNoticeViewModel", 1, "pullLastestInfo");
    RFThreadManager.execute(new QCircleMessageNoticeViewModel.1(this, paramContext), RFThreadManager.Normal);
  }
  
  public void a(BasePartFragment paramBasePartFragment)
  {
    b().observe(paramBasePartFragment, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel
 * JD-Core Version:    0.7.0.1
 */