package com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class BarrageHandler$BarrageObserver
  implements BusinessObserver
{
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null) {
      try
      {
        a(paramBoolean, (Bundle)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("BarrageHandler", 2, "onGetBarrageList Error: " + paramObject.getMessage());
        return;
      }
    }
    a(false, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.videonew.barrage.BarrageHandler.BarrageObserver
 * JD-Core Version:    0.7.0.1
 */