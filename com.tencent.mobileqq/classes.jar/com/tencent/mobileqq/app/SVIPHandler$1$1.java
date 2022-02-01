package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.bubble.BubbleDiyEntity;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

class SVIPHandler$1$1
  implements BusinessObserver
{
  SVIPHandler$1$1(SVIPHandler.1 param1, BubbleDiyFetcher paramBubbleDiyFetcher) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    try
    {
      String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler$1.this$0.b());
      if ((paramObject instanceof List))
      {
        paramObject = (List)paramObject;
        if (paramObject.size() > 0)
        {
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            Object localObject1 = (BubbleDiyEntity)paramObject.next();
            paramBoolean = TextUtils.isEmpty(((BubbleDiyEntity)localObject1).topLeftId);
            Object localObject2;
            if (!paramBoolean)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("BubbleDiyFetcher_");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append("_TL_");
              ((StringBuilder)localObject2).append(((BubbleDiyEntity)localObject1).topLeftId);
              localObject2 = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b.add(localObject2);
            }
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject1).topRightId))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("BubbleDiyFetcher_");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append("_TR_");
              ((StringBuilder)localObject2).append(((BubbleDiyEntity)localObject1).topRightId);
              localObject2 = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b.add(localObject2);
            }
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject1).bottomRightId))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("BubbleDiyFetcher_");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append("_BR_");
              ((StringBuilder)localObject2).append(((BubbleDiyEntity)localObject1).bottomRightId);
              localObject2 = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b.add(localObject2);
            }
            if (!TextUtils.isEmpty(((BubbleDiyEntity)localObject1).bottomLeftId))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("BubbleDiyFetcher_");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append("_BL_");
              ((StringBuilder)localObject2).append(((BubbleDiyEntity)localObject1).bottomLeftId);
              localObject1 = ((StringBuilder)localObject2).toString();
              this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b.add(localObject1);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleDiyFetcher.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.SVIPHandler.1.1
 * JD-Core Version:    0.7.0.1
 */