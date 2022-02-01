package com.qq.im.poi;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;

public class LbsPackObserver
  implements BusinessObserver
{
  public void a(double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleChangeMapViewAngle= ");
      localStringBuilder.append(paramDouble1);
      localStringBuilder.append("|");
      localStringBuilder.append(paramDouble2);
      QLog.d("LbsPack", 2, localStringBuilder.toString());
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetLBSPoiList, isSuccess  = ");
      paramBundle.append(paramBoolean);
      QLog.d("LbsPack", 2, paramBundle.toString());
    }
  }
  
  public void b(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onGetRedPackPage, isSuccess  = ");
      paramBundle.append(paramBoolean);
      QLog.d("LbsPack", 2, paramBundle.toString());
    }
  }
  
  public void c(boolean paramBoolean, Bundle paramBundle) {}
  
  public void d(boolean paramBoolean, Bundle paramBundle) {}
  
  public void e(boolean paramBoolean, Bundle paramBundle) {}
  
  public void f(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LbsPack", 2, new Object[] { "onUpdata, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    default: 
    case 7: 
      ArrayList localArrayList = null;
      paramInt = -1;
      if (paramBundle != null)
      {
        localArrayList = paramBundle.getStringArrayList("key_lbs_template_ids");
        paramInt = paramBundle.getInt("key_lbs_template_cookie", -1);
      }
      a(paramInt, paramBoolean, localArrayList);
      return;
    case 6: 
      if (paramBundle != null)
      {
        a(paramBundle.getDouble("latitude"), paramBundle.getDouble("longitude"));
        return;
      }
      break;
    case 5: 
      a(paramBoolean, paramBundle);
      return;
    case 4: 
      b(paramBoolean, paramBundle);
      return;
    case 3: 
      f(paramBoolean, paramBundle);
      return;
    case 2: 
      e(paramBoolean, paramBundle);
      return;
    case 1: 
      d(paramBoolean, paramBundle);
      return;
    case 0: 
      c(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.im.poi.LbsPackObserver
 * JD-Core Version:    0.7.0.1
 */