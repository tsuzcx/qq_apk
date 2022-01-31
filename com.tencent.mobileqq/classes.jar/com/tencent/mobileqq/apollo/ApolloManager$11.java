package com.tencent.mobileqq.apollo;

import airx;
import aiwl;
import aiwm;
import aizu;
import ajhu;
import bbrd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ApolloManager$11
  implements Runnable
{
  public ApolloManager$11(airx paramairx, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(8);
    ArrayList localArrayList2 = new ArrayList(16);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ApolloBaseInfo localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
      if ((this.this$0.a != null) && (localApolloBaseInfo != null))
      {
        int i = 0;
        Object localObject4 = localApolloBaseInfo.getApolloDress();
        StringBuilder localStringBuilder;
        int j;
        long l;
        Object localObject2;
        Object localObject3;
        if (localObject4 != null)
        {
          localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((aiwl)localObject4).toString());
          }
          j = -1;
          l = this.this$0.a(1, ((aiwl)localObject4).jdField_a_of_type_Int) / 1000L;
          i = j;
          if (l != ((aiwl)localObject4).jdField_a_of_type_Long)
          {
            i = j;
            if (!localArrayList1.contains(Integer.valueOf(((aiwl)localObject4).jdField_a_of_type_Int)))
            {
              j = ((aiwl)localObject4).jdField_a_of_type_Int;
              localArrayList1.add(Integer.valueOf(((aiwl)localObject4).jdField_a_of_type_Int));
              i = j;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\nrole id: ").append(((aiwl)localObject4).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiwl)localObject4).jdField_a_of_type_Long);
                i = j;
              }
            }
          }
          localObject2 = null;
          localObject1 = localObject2;
          if (((aiwl)localObject4).jdField_a_of_type_JavaUtilHashMap != null)
          {
            localObject3 = new ArrayList();
            localObject1 = ((aiwl)localObject4).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject4 = (aiwm)((Map.Entry)((Iterator)localObject1).next()).getValue();
              l = this.this$0.a(2, ((aiwm)localObject4).jdField_a_of_type_Int) / 1000L;
              if ((l != ((aiwm)localObject4).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int))))
              {
                ((ArrayList)localObject3).add(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int));
                localArrayList2.add(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int));
                if (QLog.isColorLevel()) {
                  localStringBuilder.append("\ndress id: ").append(((aiwm)localObject4).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiwm)localObject4).jdField_a_of_type_Long);
                }
              }
            }
            localObject1 = localApolloBaseInfo.getApolloPetDress();
            if ((localObject1 != null) && (((aiwl)localObject1).jdField_a_of_type_JavaUtilHashMap != null))
            {
              localObject1 = ((aiwl)localObject1).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject4 = (aiwm)((Map.Entry)((Iterator)localObject1).next()).getValue();
                l = this.this$0.a(2, ((aiwm)localObject4).jdField_a_of_type_Int) / 1000L;
                if ((l != ((aiwm)localObject4).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int))))
                {
                  ((ArrayList)localObject3).add(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int));
                  localArrayList2.add(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int));
                  if (QLog.isColorLevel()) {
                    localStringBuilder.append("\npet dress id: ").append(((aiwm)localObject4).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiwm)localObject4).jdField_a_of_type_Long);
                  }
                }
              }
            }
            localObject1 = localObject2;
            if (((ArrayList)localObject3).size() > 0)
            {
              localObject2 = new int[((ArrayList)localObject3).size()];
              localObject3 = ((ArrayList)localObject3).iterator();
              j = 0;
              for (;;)
              {
                localObject1 = localObject2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject2[j] = ((Integer)((Iterator)localObject3).next()).intValue();
                j += 1;
              }
            }
          }
          if ((i != -1) || ((localObject1 != null) && (localObject1.length != 0))) {
            break label1108;
          }
          i = 1;
          localStringBuilder.append("\nlocal dress is OK");
        }
        int k;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, localStringBuilder.toString());
          }
          localObject4 = localApolloBaseInfo.getApolloDress3D();
          k = i;
          if (localObject4 == null) {
            break label1270;
          }
          localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("3d updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((aiwl)localObject4).toString());
          }
          k = -1;
          l = this.this$0.a(1, ((aiwl)localObject4).jdField_a_of_type_Int) / 1000L;
          j = k;
          if (l != ((aiwl)localObject4).jdField_a_of_type_Long)
          {
            j = k;
            if (!localArrayList1.contains(Integer.valueOf(((aiwl)localObject4).jdField_a_of_type_Int)))
            {
              k = ((aiwl)localObject4).jdField_a_of_type_Int;
              localArrayList1.add(Integer.valueOf(((aiwl)localObject4).jdField_a_of_type_Int));
              j = k;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\n3d role id: ").append(((aiwl)localObject4).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiwl)localObject4).jdField_a_of_type_Long);
                j = k;
              }
            }
          }
          localObject2 = null;
          localObject1 = localObject2;
          if (((aiwl)localObject4).jdField_a_of_type_JavaUtilHashMap == null) {
            break label1223;
          }
          localObject3 = new ArrayList();
          localObject1 = ((aiwl)localObject4).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (aiwm)((Map.Entry)((Iterator)localObject1).next()).getValue();
            l = this.this$0.a(2, ((aiwm)localObject4).jdField_a_of_type_Int) / 1000L;
            if ((l != ((aiwm)localObject4).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int))))
            {
              ((ArrayList)localObject3).add(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int));
              localArrayList2.add(Integer.valueOf(((aiwm)localObject4).jdField_a_of_type_Int));
              if (QLog.isColorLevel()) {
                localStringBuilder.append("\n3d dress id: ").append(((aiwm)localObject4).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiwm)localObject4).jdField_a_of_type_Long);
              }
            }
          }
          label1108:
          ajhu.a(this.this$0.a, localApolloBaseInfo.uin, this.this$0.a(), i, (int[])localObject1, -1, -1, true);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\ndown load dress");
          }
          i = 0;
        }
        Object localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0)
        {
          localObject2 = new int[((ArrayList)localObject3).size()];
          localObject3 = ((ArrayList)localObject3).iterator();
          k = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2[k] = ((Integer)((Iterator)localObject3).next()).intValue();
            k += 1;
          }
        }
        label1223:
        if ((j == -1) && ((localObject1 == null) || (localObject1.length == 0)))
        {
          j = 1;
          localStringBuilder.append("\nlocal dress is OK");
        }
        for (;;)
        {
          k = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 2, localStringBuilder.toString());
            k = j;
          }
          label1270:
          if (k == 0) {
            break;
          }
          localObject1 = new ArrayList(1);
          ((ArrayList)localObject1).add(localApolloBaseInfo.uin);
          localObject2 = (bbrd)this.this$0.a.a(71);
          ((bbrd)localObject2).notifyUI(2, true, localObject1);
          aizu.a().a((ArrayList)localObject1);
          ((bbrd)localObject2).a(localApolloBaseInfo.uin, localApolloBaseInfo);
          break;
          ajhu.a(this.this$0.a, localApolloBaseInfo.uin, this.this$0.a(), j, (int[])localObject1, -1, -1, true);
          j = i;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("\n3d download dress");
            j = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.11
 * JD-Core Version:    0.7.0.1
 */