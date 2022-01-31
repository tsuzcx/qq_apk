package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FavEmoRoamingObserver
  implements BusinessObserver
{
  public void a(List paramList) {}
  
  public void a(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramObject == null);
      a(((Boolean)paramObject).booleanValue());
      return;
      if (paramObject == null) {
        break;
      }
      try
      {
        a((ArrayList)paramObject);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("FavEmoRoamingObserver", 2, paramObject.toString());
    return;
    a(new ArrayList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FavEmoRoamingObserver
 * JD-Core Version:    0.7.0.1
 */