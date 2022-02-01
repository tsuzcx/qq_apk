package com.tencent.mobileqq.app;

import com.tencent.mobileqq.addon.DiyPendantEntity;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.addon.DiyPendantSticker;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

class SVIPHandler$2$1
  implements BusinessObserver
{
  SVIPHandler$2$1(SVIPHandler.2 param2, DiyPendantFetcher paramDiyPendantFetcher) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (paramObject.size() > 0)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            Iterator localIterator = ((DiyPendantEntity)paramObject.next()).getStickerInfoList().iterator();
            while (localIterator.hasNext())
            {
              Object localObject = (DiyPendantSticker)localIterator.next();
              localObject = this.a.a((DiyPendantSticker)localObject);
              this.a.h.add(localObject);
            }
          }
          this.a.c();
          return;
        }
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SVIPHandler", 2, paramObject.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPHandler.2.1
 * JD-Core Version:    0.7.0.1
 */