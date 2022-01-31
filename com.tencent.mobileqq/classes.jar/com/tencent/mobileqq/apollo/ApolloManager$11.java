package com.tencent.mobileqq.apollo;

import aifg;
import aiju;
import aijv;
import aitw;
import baot;
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
  public ApolloManager$11(aifg paramaifg, List paramList) {}
  
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
        Object localObject3 = localApolloBaseInfo.getApolloDress();
        StringBuilder localStringBuilder;
        int j;
        long l;
        int[] arrayOfInt;
        Object localObject2;
        if (localObject3 != null)
        {
          localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((aiju)localObject3).toString());
          }
          j = -1;
          l = this.this$0.a(1, ((aiju)localObject3).jdField_a_of_type_Int) / 1000L;
          i = j;
          if (l != ((aiju)localObject3).jdField_a_of_type_Long)
          {
            i = j;
            if (!localArrayList1.contains(Integer.valueOf(((aiju)localObject3).jdField_a_of_type_Int)))
            {
              j = ((aiju)localObject3).jdField_a_of_type_Int;
              localArrayList1.add(Integer.valueOf(((aiju)localObject3).jdField_a_of_type_Int));
              i = j;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\nrole id: ").append(((aiju)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiju)localObject3).jdField_a_of_type_Long);
                i = j;
              }
            }
          }
          arrayOfInt = null;
          localObject1 = arrayOfInt;
          if (((aiju)localObject3).jdField_a_of_type_JavaUtilHashMap != null)
          {
            localObject2 = new ArrayList();
            localObject1 = ((aiju)localObject3).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject3 = (aijv)((Map.Entry)((Iterator)localObject1).next()).getValue();
              l = this.this$0.a(2, ((aijv)localObject3).jdField_a_of_type_Int) / 1000L;
              if ((l != ((aijv)localObject3).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int))))
              {
                ((ArrayList)localObject2).add(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int));
                localArrayList2.add(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int));
                if (QLog.isColorLevel()) {
                  localStringBuilder.append("\ndress id: ").append(((aijv)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aijv)localObject3).jdField_a_of_type_Long);
                }
              }
            }
            localObject1 = localApolloBaseInfo.getApolloPetDress();
            if ((localObject1 != null) && (((aiju)localObject1).jdField_a_of_type_JavaUtilHashMap != null))
            {
              localObject1 = ((aiju)localObject1).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (aijv)((Map.Entry)((Iterator)localObject1).next()).getValue();
                l = this.this$0.a(2, ((aijv)localObject3).jdField_a_of_type_Int) / 1000L;
                if ((l != ((aijv)localObject3).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int))))
                {
                  ((ArrayList)localObject2).add(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int));
                  localArrayList2.add(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int));
                  if (QLog.isColorLevel()) {
                    localStringBuilder.append("\npet dress id: ").append(((aijv)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aijv)localObject3).jdField_a_of_type_Long);
                  }
                }
              }
            }
            localObject1 = arrayOfInt;
            if (((ArrayList)localObject2).size() > 0)
            {
              arrayOfInt = new int[((ArrayList)localObject2).size()];
              localObject2 = ((ArrayList)localObject2).iterator();
              j = 0;
              for (;;)
              {
                localObject1 = arrayOfInt;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                arrayOfInt[j] = ((Integer)((Iterator)localObject2).next()).intValue();
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
          localObject3 = localApolloBaseInfo.getApolloDress3D();
          k = i;
          if (localObject3 == null) {
            break label1270;
          }
          localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("3d updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((aiju)localObject3).toString());
          }
          k = -1;
          l = this.this$0.a(1, ((aiju)localObject3).jdField_a_of_type_Int) / 1000L;
          j = k;
          if (l != ((aiju)localObject3).jdField_a_of_type_Long)
          {
            j = k;
            if (!localArrayList1.contains(Integer.valueOf(((aiju)localObject3).jdField_a_of_type_Int)))
            {
              k = ((aiju)localObject3).jdField_a_of_type_Int;
              localArrayList1.add(Integer.valueOf(((aiju)localObject3).jdField_a_of_type_Int));
              j = k;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\n3d role id: ").append(((aiju)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aiju)localObject3).jdField_a_of_type_Long);
                j = k;
              }
            }
          }
          arrayOfInt = null;
          localObject1 = arrayOfInt;
          if (((aiju)localObject3).jdField_a_of_type_JavaUtilHashMap == null) {
            break label1223;
          }
          localObject2 = new ArrayList();
          localObject1 = ((aiju)localObject3).jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (aijv)((Map.Entry)((Iterator)localObject1).next()).getValue();
            l = this.this$0.a(2, ((aijv)localObject3).jdField_a_of_type_Int) / 1000L;
            if ((l != ((aijv)localObject3).jdField_a_of_type_Long) && (!localArrayList2.contains(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int))))
            {
              ((ArrayList)localObject2).add(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int));
              localArrayList2.add(Integer.valueOf(((aijv)localObject3).jdField_a_of_type_Int));
              if (QLog.isColorLevel()) {
                localStringBuilder.append("\n3d dress id: ").append(((aijv)localObject3).jdField_a_of_type_Int).append(", local TS: ").append(l).append(", svr TS: ").append(((aijv)localObject3).jdField_a_of_type_Long);
              }
            }
          }
          label1108:
          aitw.a(this.this$0.a, localApolloBaseInfo.uin, this.this$0.a(), i, (int[])localObject1, -1, -1, true);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\ndown load dress");
          }
          i = 0;
        }
        Object localObject1 = arrayOfInt;
        if (((ArrayList)localObject2).size() > 0)
        {
          arrayOfInt = new int[((ArrayList)localObject2).size()];
          localObject2 = ((ArrayList)localObject2).iterator();
          k = 0;
          for (;;)
          {
            localObject1 = arrayOfInt;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            arrayOfInt[k] = ((Integer)((Iterator)localObject2).next()).intValue();
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
          ((baot)this.this$0.a.a(71)).notifyUI(2, true, localObject1);
          break;
          aitw.a(this.this$0.a, localApolloBaseInfo.uin, this.this$0.a(), j, (int[])localObject1, -1, -1, true);
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