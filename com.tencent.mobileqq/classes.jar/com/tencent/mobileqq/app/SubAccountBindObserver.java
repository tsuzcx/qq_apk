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
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      b(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    case 1: 
      c(paramBoolean, (SubAccountBackProtocData)paramObject);
      return;
    }
    a(paramBoolean, (SubAccountBackProtocData)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SubAccountBindObserver
 * JD-Core Version:    0.7.0.1
 */