package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import pje;
import ppe;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJUserInfoUtil$requestUserInfo$runnable$1
  implements Runnable
{
  public RIJUserInfoUtil$requestUserInfo$runnable$1(int paramInt, List paramList) {}
  
  public final void run()
  {
    if (!pje.a(pje.a)) {
      QLog.i("RIJUserInfoUtil", 1, "[requestUserInfo] switch is off.");
    }
    ArrayList localArrayList;
    Object localObject1;
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int != 0)
      {
        QLog.i("RIJUserInfoUtil", 1, "[requestUserInfo] channelId is not recommend, channelId = " + this.jdField_a_of_type_Int);
        return;
      }
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        QLog.i("RIJUserInfoUtil", 1, "[requestUserInfo] articleInfoList is empty.");
        return;
      }
      localArrayList = new ArrayList();
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      Object localObject2;
      label224:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ArticleInfo)((Iterator)localObject1).next();
        if (!ppe.f((ArticleInfo)localObject2))
        {
          pje.a(pje.a, localArrayList, ((ArticleInfo)localObject2).mSubscribeID);
          Object localObject3 = ((ArticleInfo)localObject2).mSubArtilceList;
          if (localObject3 != null)
          {
            if (!((Collection)localObject3).isEmpty()) {}
            for (i = 1;; i = 0)
            {
              if (i != 1) {
                break label224;
              }
              localObject2 = ((ArticleInfo)localObject2).mSubArtilceList.iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (ArticleInfo)((Iterator)localObject2).next();
                pje.a(pje.a, localArrayList, ((ArticleInfo)localObject3).mSubscribeID);
              }
              break;
            }
          }
        }
      }
      if (!((Collection)localArrayList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[requestUserInfo] uinList: ");
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next()).append(", ");
        }
      }
    }
    QLog.i("RIJUserInfoUtil", 1, ((StringBuilder)localObject1).toString());
    ReadInJoyUserInfoModule.a((List)localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.RIJUserInfoUtil.requestUserInfo.runnable.1
 * JD-Core Version:    0.7.0.1
 */