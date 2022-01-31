package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

public class SVIPObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 101: 
      do
      {
        return;
        if ((paramObject instanceof Integer))
        {
          a(((Integer)paramObject).intValue());
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.e("SVIPObserver", 2, "NOTIFY_TYPE_SVIP_BUBBLE_CHANGE param error");
      return;
    case 100: 
      a();
      return;
    case 102: 
      a(paramBoolean, paramObject);
      return;
    }
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPObserver
 * JD-Core Version:    0.7.0.1
 */