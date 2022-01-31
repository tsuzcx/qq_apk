package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class StrangerObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, PBRepeatMessageField paramPBRepeatMessageField) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  public void b(boolean paramBoolean, List paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 4) {
      a(paramBoolean, (PBRepeatMessageField)paramObject);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        a(paramBoolean, (List)paramObject);
        return;
      }
    } while (paramInt != 3);
    b(paramBoolean, (List)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.StrangerObserver
 * JD-Core Version:    0.7.0.1
 */