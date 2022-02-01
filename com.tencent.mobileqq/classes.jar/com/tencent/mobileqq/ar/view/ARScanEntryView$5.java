package com.tencent.mobileqq.ar.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.qphone.base.util.QLog;

class ARScanEntryView$5
  extends ArMapObserver
{
  ARScanEntryView$5(ARScanEntryView paramARScanEntryView) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong)
  {
    SharedPreferences localSharedPreferences = ArMapUtil.a(this.a.C);
    long l = localSharedPreferences.getLong("key_ar_act_id", 0L);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetARRedDotInfo redSwitch = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",actID = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",savedActID = ");
      localStringBuilder.append(l);
      QLog.d("AREngine_ARScanEntryView", 2, localStringBuilder.toString());
    }
    localSharedPreferences.edit().putLong("key_ar_act_id", paramLong).commit();
    if (!this.a.J)
    {
      QLog.d("AREngine_ARScanEntryView", 1, "onGetARRedDotInfo,not deal redhot message when pause");
      return;
    }
    paramBoolean = localSharedPreferences.getBoolean("key_show_reddot", false);
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      if ((paramLong > l) || ((paramBoolean) && (paramLong == l)))
      {
        ARScanEntryView.d(this.a).post(new ARScanEntryView.5.1(this));
        localSharedPreferences.edit().putBoolean("key_show_reddot", true).commit();
        ARScanEntryView.a(this.a, true);
      }
      if (paramLong < l)
      {
        ARScanEntryView.a(this.a, false);
        ARScanEntryView.d(this.a).post(new ARScanEntryView.5.2(this));
        localSharedPreferences.edit().putBoolean("key_show_reddot", false).commit();
      }
    }
    else
    {
      ARScanEntryView.a(this.a, false);
      ARScanEntryView.d(this.a).post(new ARScanEntryView.5.3(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.5
 * JD-Core Version:    0.7.0.1
 */