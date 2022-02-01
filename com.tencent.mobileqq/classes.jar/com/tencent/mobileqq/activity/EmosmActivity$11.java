package com.tencent.mobileqq.activity;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class EmosmActivity$11
  implements QueryCallback<List<EmoticonPackage>>
{
  EmosmActivity$11(EmosmActivity paramEmosmActivity) {}
  
  public void a(List<EmoticonPackage> paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (((EmoticonPackage)paramList.get(i)).jobType == 3) {
        break label48;
      }
      i += 1;
    }
    i = -1;
    label48:
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    int k;
    if (1 == this.a.mLaunchMode)
    {
      if (i == -1)
      {
        paramList = this.a.mEPDatas.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(((EmoticonPackage)paramList.next()).epId);
        }
      }
      localObject1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (EmoticonPackage)paramList.next();
        if (((EmoticonPackage)localObject2).jobType == 3) {
          ((ArrayList)localObject1).add(((EmoticonPackage)localObject2).epId);
        }
      }
      if (i >= this.a.mEPDatas.size())
      {
        paramList = this.a.mEPDatas.iterator();
        while (paramList.hasNext()) {
          localArrayList.add(((EmoticonPackage)paramList.next()).epId);
        }
        localArrayList.addAll((Collection)localObject1);
      }
      else
      {
        k = this.a.mEPDatas.size();
        j = 0;
        while (j < k)
        {
          paramList = (EmoticonPackage)this.a.mEPDatas.get(j);
          if (j == i) {
            localArrayList.addAll((Collection)localObject1);
          }
          localArrayList.add(paramList.epId);
          j += 1;
        }
      }
    }
    else if (2 == this.a.mLaunchMode)
    {
      k = paramList.size();
      j = 0;
      while (j < k)
      {
        localObject1 = (EmoticonPackage)paramList.get(j);
        if (j == i)
        {
          localObject2 = this.a.mEPDatas.iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
          }
        }
        if (((EmoticonPackage)localObject1).jobType != 3) {
          localArrayList.add(((EmoticonPackage)localObject1).epId);
        }
        j += 1;
      }
    }
    this.a.mDBManager.reconstructAllTabEmoticonPackage(localArrayList, 0);
    paramList = (EmoticonHandler)this.a.app.getBusinessHandler(EmoticonHandler.a);
    if (paramList != null) {
      paramList.a(localArrayList, true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.11
 * JD-Core Version:    0.7.0.1
 */