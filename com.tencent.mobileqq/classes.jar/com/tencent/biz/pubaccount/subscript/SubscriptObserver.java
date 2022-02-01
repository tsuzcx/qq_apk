package com.tencent.biz.pubaccount.subscript;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;

public class SubscriptObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, ArrayList<ReadInJoyArticle> paramArrayList) {}
  
  protected void a(boolean paramBoolean, List<SubscriptRecommendAccountInfo> paramList) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (paramObject == null) {}
    }
    try
    {
      a(paramBoolean, (ArrayList)paramObject);
      return;
    }
    catch (Exception paramObject) {}
    a(false, new ArrayList(0));
    return;
    if (paramObject != null)
    {
      a(paramBoolean, (ArrayList)paramObject);
      return;
    }
    a(false, new ArrayList(0));
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptObserver
 * JD-Core Version:    0.7.0.1
 */