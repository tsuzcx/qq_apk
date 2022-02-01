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
  
  public void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mViewDelegate == null :" + StrangerIntimateView.a(this.a));
      }
    } while (StrangerIntimateView.a(this.a));
    paramObject = null;
    if ((paramBoolean) && (paramHashMap != null))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.valueOf(this.a.jdField_a_of_type_JavaLangString).longValue();
        l1 = l2;
      }
      catch (NumberFormatException paramObject)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err ");
        }
      }
    }
    for (paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));; paramHashMap = paramObject)
    {
      if (paramHashMap == null) {
        break label272;
      }
      paramObject = StrangerIntimateView.a(this.a).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      StrangerIntimateView.a(this.a).removeMessages(0);
      StrangerIntimateView.a(this.a).sendMessage(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mode: " + this.a.jdField_a_of_type_ComTencentMobileqqMulticardMultiCardCustomViewDelegate.a());
      break;
      QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    }
    label272:
    paramHashMap = StrangerIntimateView.a(this.a).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693477);
    StrangerIntimateView.a(this.a).sendMessage(paramHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.StrangerIntimateView.5
 * JD-Core Version:    0.7.0.1
 */