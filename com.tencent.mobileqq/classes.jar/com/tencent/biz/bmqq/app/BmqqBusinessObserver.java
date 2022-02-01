package com.tencent.biz.bmqq.app;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;

public class BmqqBusinessObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, BmqqUserSimpleInfo paramBmqqUserSimpleInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, (BmqqUserSimpleInfo)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.bmqq.app.BmqqBusinessObserver
 * JD-Core Version:    0.7.0.1
 */