package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import bdeu;
import bdgc;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class TroopMemberListInnerFrame$5
  implements Runnable
{
  TroopMemberListInnerFrame$5(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, List paramList, int paramInt1, int paramInt2, String paramString1, String paramString2, TroopInfo paramTroopInfo, Map paramMap, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int).iterator();
    int i = 0;
    TroopMemberInfo localTroopMemberInfo;
    if (localIterator.hasNext())
    {
      localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
      if (!this.jdField_a_of_type_JavaLangString.equals(this.this$0.jdField_b_of_type_JavaLangString)) {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread, curTroopUin != mTroopUin, return, " + this.jdField_a_of_type_JavaLangString + "," + this.this$0.jdField_b_of_type_JavaLangString);
        }
      }
    }
    label321:
    do
    {
      for (;;)
      {
        return;
        if (((!this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.p) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.u)) && (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(localTroopMemberInfo.memberuin)))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo = localTroopMemberInfo;
          break;
        }
        if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d.contains(localTroopMemberInfo.memberuin)) || (!bdeu.d(localTroopMemberInfo.memberuin))) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.this$0.jdField_b_of_type_Int == 2) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(localTroopMemberInfo.memberuin)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(localTroopMemberInfo.memberuin)))
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.d.add(localTroopMemberInfo.memberuin);
          break;
        }
        localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.a(bdgc.h(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
        String str;
        if ((localTroopMemberInfo.displayedNamePinyinFirst == null) || (localTroopMemberInfo.displayedNamePinyinFirst.length() == 0))
        {
          str = "#";
          int j = str.charAt(0);
          if (((65 > j) || (j > 90)) && ((97 > j) || (j > 122))) {
            break label441;
          }
          str = str.toUpperCase();
        }
        synchronized (this.jdField_a_of_type_JavaUtilMap)
        {
          if (this.jdField_a_of_type_JavaUtilMap.get(str) == null) {
            this.jdField_a_of_type_JavaUtilMap.put(str, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilMap.get(str)).add(localTroopMemberInfo);
          i += 1;
          break;
          str = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
          break label321;
          str = "#";
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", curTroopUin=" + this.jdField_a_of_type_JavaLangString);
      }
    } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndDecrement() > 1);
    label441:
    Message localMessage = this.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
    localMessage.arg1 = i;
    localMessage.obj = new Object[] { this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString };
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */