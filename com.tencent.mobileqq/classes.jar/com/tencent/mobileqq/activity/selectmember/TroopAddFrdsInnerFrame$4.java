package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bbbd;
import bbcl;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class TroopAddFrdsInnerFrame$4
  implements Runnable
{
  TroopAddFrdsInnerFrame$4(TroopAddFrdsInnerFrame paramTroopAddFrdsInnerFrame, List paramList1, int paramInt1, int paramInt2, String paramString1, String paramString2, Map paramMap, List paramList2, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    int i = 0;
    for (;;)
    {
      TroopMemberInfo localTroopMemberInfo;
      if (localIterator.hasNext())
      {
        localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
        if (!this.jdField_a_of_type_JavaLangString.equals(this.this$0.jdField_b_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread, curTroopUin != mTroopUin, return, " + this.jdField_a_of_type_JavaLangString + "," + this.this$0.jdField_b_of_type_JavaLangString);
          }
          label127:
          return;
        }
        if (((!this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(localTroopMemberInfo.memberuin))) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d.contains(localTroopMemberInfo.memberuin)) || (!bbbd.d(localTroopMemberInfo.memberuin))) {
          continue;
        }
      }
      try
      {
        for (;;)
        {
          for (;;)
          {
            long l = Long.valueOf(localTroopMemberInfo.memberuin).longValue();
            if (l < 0L) {
              break;
            }
            localObject1 = null;
            if (this.this$0.f == TroopAddFrdsInnerFrame.d)
            {
              localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(bbcl.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
              if ((localTroopMemberInfo.displayedNamePinyinFirst == null) || (localTroopMemberInfo.displayedNamePinyinFirst.length() == 0))
              {
                localObject1 = "#";
                label274:
                int j = ((String)localObject1).charAt(0);
                if (((65 > j) || (j > 90)) && ((97 > j) || (j > 122))) {
                  break label439;
                }
                localObject1 = ((String)localObject1).toUpperCase();
                label312:
                if ((localTroopMemberInfo.commonFrdCnt == -2147483648) && (!localTroopMemberInfo.memberuin.equals(this.jdField_b_of_type_JavaLangString))) {
                  localArrayList.add(localTroopMemberInfo.memberuin);
                }
              }
            }
            synchronized (this.jdField_a_of_type_JavaUtilMap)
            {
              if (this.jdField_a_of_type_JavaUtilMap.get(localObject1) == null) {
                this.jdField_a_of_type_JavaUtilMap.put(localObject1, new ArrayList());
              }
              ((List)this.jdField_a_of_type_JavaUtilMap.get(localObject1)).add(localTroopMemberInfo);
              i += 1;
              break;
              localObject1 = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
              break label274;
              label439:
              localObject1 = "#";
              break label312;
              if (this.this$0.f != TroopAddFrdsInnerFrame.e) {
                break label312;
              }
              if ((!TextUtils.isEmpty(TroopAddFrdsInnerFrame.a(this.this$0))) && (TroopAddFrdsInnerFrame.a(this.this$0).equalsIgnoreCase(localTroopMemberInfo.memberuin)))
              {
                localTroopMemberInfo.addState = 1;
                localObject1 = "" + localTroopMemberInfo.addState;
                break label312;
              }
              localTroopMemberInfo.addState = TroopAddFrdsInnerFrame.a(this.this$0, localTroopMemberInfo.memberuin);
            }
          }
          synchronized (this.jdField_b_of_type_JavaUtilList)
          {
            this.jdField_b_of_type_JavaUtilList.addAll(localArrayList);
            if (QLog.isColorLevel()) {
              QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", curTroopUin=" + this.jdField_a_of_type_JavaLangString);
            }
            if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement() > 1) {
              break label127;
            }
            ??? = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
            ((Message)???).arg1 = i;
            ((Message)???).obj = new Object[] { this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString };
            this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)???);
            if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
              break label127;
            }
            ??? = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
            ((Message)???).obj = this.jdField_b_of_type_JavaUtilList;
            this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
            return;
          }
        }
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.4
 * JD-Core Version:    0.7.0.1
 */