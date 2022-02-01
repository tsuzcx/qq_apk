package com.tencent.mobileqq.activity.aio.intimate;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.mobileqq.multicard.MultiCardCustomViewDelegate;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class StrangerIntimateView$5
  extends IntimateInfoObserver
{
  StrangerIntimateView$5(StrangerIntimateView paramStrangerIntimateView) {}
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate == null)
    {
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("onGetGroupIntimateInfos, mViewDelegate == null :");
        paramObject.append(StrangerIntimateView.a(this.a));
        QLog.d("intimate_relationship", 2, paramObject.toString());
      }
      if (!StrangerIntimateView.a(this.a)) {}
    }
    else if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onGetGroupIntimateInfos, mode: ");
      paramObject.append(this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      QLog.d("intimate_relationship", 2, paramObject.toString());
    }
    paramObject = null;
    long l1;
    if ((paramBoolean) && (paramHashMap != null)) {
      l1 = 0L;
    }
    try
    {
      long l2 = Long.valueOf(this.a.jdField_a_of_type_JavaLangString).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramObject)
    {
      label198:
      break label198;
    }
    QLog.e("intimate_relationship", 2, "valueOf string err ");
    paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));
    break label232;
    QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    paramHashMap = paramObject;
    label232:
    if (paramHashMap != null)
    {
      paramObject = StrangerIntimateView.a(this.a).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      StrangerIntimateView.a(this.a).removeMessages(0);
      StrangerIntimateView.a(this.a).sendMessage(paramObject);
      return;
    }
    paramHashMap = StrangerIntimateView.a(this.a).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693432);
    StrangerIntimateView.a(this.a).sendMessage(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.5
 * JD-Core Version:    0.7.0.1
 */