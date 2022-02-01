package com.tencent.av.wtogether.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.filemanager.data.TroopFileSearchItemData;
import java.util.List;

public class WatchTogetherObserver
  implements BusinessObserver
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      if (paramObject != null)
      {
        paramObject = (Object[])paramObject;
        a(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
        return;
      }
      a(0, null);
      return;
    }
    paramObject = (Object[])paramObject;
    a((String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (List)paramObject[4]);
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<TroopFileSearchItemData> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.observer.WatchTogetherObserver
 * JD-Core Version:    0.7.0.1
 */