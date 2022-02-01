package com.tencent.mobileqq.app;

import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;

public class SubAccountBindObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        a(paramBoolean, (SubAccountBackProtocData)paramObject);
        return;
      }
      c(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    }
    b(paramBoolean, (SubAccountBackProtocData)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SubAccountBindObserver
 * JD-Core Version:    0.7.0.1
 */