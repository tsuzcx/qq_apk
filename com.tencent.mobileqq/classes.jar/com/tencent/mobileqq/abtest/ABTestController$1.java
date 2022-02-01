package com.tencent.mobileqq.abtest;

import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import com.tencent.mtt.abtestsdk.listener.GetExperimentListener;
import java.util.Iterator;
import java.util.List;

class ABTestController$1
  implements GetExperimentListener
{
  ABTestController$1(ABTestController paramABTestController) {}
  
  public void getExperimentFailed(int paramInt, String paramString)
  {
    ABTestController.a("ABTestController", "abtest api load exp failed, i:" + paramInt + ", s:" + paramString);
  }
  
  public void getExperimentSucceed(List<RomaExpEntity> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      ABTestController.a("ABTestController", "load exp failed, list empty");
    }
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        RomaExpEntity localRomaExpEntity = (RomaExpEntity)localIterator.next();
        if (localRomaExpEntity != null)
        {
          ABTestController.a("ABTestController", localRomaExpEntity.toString());
          String str = localRomaExpEntity.getExpName();
          paramList = str;
          if (TextUtils.isEmpty(str)) {
            paramList = localRomaExpEntity.getLayerCode();
          }
          if (!TextUtils.isEmpty(paramList))
          {
            paramList = ABTestConfiguration.a(paramList);
            if (paramList != null) {
              paramList.a(localRomaExpEntity);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.abtest.ABTestController.1
 * JD-Core Version:    0.7.0.1
 */