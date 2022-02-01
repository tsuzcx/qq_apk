package com.tencent.mobileqq.activity;

import abwz;
import aczu;
import alij;
import asle;
import atbg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class ChatHistoryStructMsgView$2
  implements Runnable
{
  public ChatHistoryStructMsgView$2(aczu paramaczu, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2;
    int i;
    int j;
    label120:
    Object localObject3;
    Object localObject4;
    if (this.a)
    {
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      localObject2 = this.this$0.jdField_b_of_type_JavaLangString;
      i = this.this$0.jdField_a_of_type_Int;
      j = aczu.a();
      localObject1 = ((QQMessageFacade)localObject1).getAllMessages((String)localObject2, i, new int[] { -2011 }, j);
      if ((localObject1 != null) && (((List)localObject1).size() < aczu.a())) {
        this.this$0.jdField_b_of_type_Boolean = true;
      }
      localObject2 = new LinkedHashMap();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label605;
      }
      i = ((List)localObject1).size() - 1;
      if (i < 0) {
        break label605;
      }
      localObject3 = (MessageRecord)((List)localObject1).get(i);
      if (alij.a((MessageRecord)localObject3))
      {
        if (((MessageRecord)localObject3).shmsgseq < this.this$0.jdField_b_of_type_Long) {
          this.this$0.jdField_b_of_type_Long = ((MessageRecord)localObject3).shmsgseq;
        }
        if (((MessageRecord)localObject3).versionCode < this.this$0.jdField_b_of_type_Int) {
          this.this$0.jdField_b_of_type_Int = ((MessageRecord)localObject3).versionCode;
        }
        if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.this$0.jdField_a_of_type_Long)) {
          this.this$0.jdField_a_of_type_Long = ((MessageRecord)localObject3).getId();
        }
        if (((MessageRecord)localObject3).time < this.this$0.c) {
          this.this$0.c = ((MessageRecord)localObject3).time;
        }
        if (!(localObject3 instanceof MessageForStructing)) {
          break label545;
        }
        localObject4 = (MessageForStructing)localObject3;
        if ((((MessageForStructing)localObject4).structingMsg == null) || (!(((MessageForStructing)localObject4).structingMsg instanceof AbsShareMsg))) {
          break label545;
        }
        localObject4 = (AbsShareMsg)((MessageForStructing)localObject4).structingMsg;
        if ((((MessageRecord)localObject3).time < 1548460800L) || (!asle.a(((AbsShareMsg)localObject4).mMsgUrl))) {
          break label545;
        }
      }
    }
    for (;;)
    {
      i -= 1;
      break label120;
      if (abwz.a(this.this$0.jdField_a_of_type_Int))
      {
        localObject1 = this.this$0;
        ((aczu)localObject1).jdField_b_of_type_Long -= 1L;
        localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        localObject2 = this.this$0.jdField_b_of_type_JavaLangString;
        i = this.this$0.jdField_a_of_type_Int;
        l1 = this.this$0.jdField_a_of_type_Long;
        j = this.this$0.jdField_b_of_type_Int;
        l2 = this.this$0.jdField_b_of_type_Long;
        k = aczu.a();
        localObject1 = ((QQMessageFacade)localObject1).getMessagesFromDB((String)localObject2, i, l1, j, l2, new int[] { -2011 }, k);
        break;
      }
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      localObject2 = this.this$0.jdField_b_of_type_JavaLangString;
      i = this.this$0.jdField_a_of_type_Int;
      long l1 = this.this$0.jdField_a_of_type_Long;
      j = this.this$0.jdField_b_of_type_Int;
      long l2 = this.this$0.c;
      int k = aczu.a();
      localObject1 = ((QQMessageFacade)localObject1).getMessagesFromDB((String)localObject2, i, l1, j, l2, new int[] { -2011 }, k);
      break;
      label545:
      localObject4 = atbg.a(((MessageRecord)localObject3).time * 1000L);
      if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
        ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
      }
      ((List)((LinkedHashMap)localObject2).get(localObject4)).add(localObject3);
    }
    label605:
    if (this.this$0.jdField_a_of_type_JavaUtilArrayList == null) {
      this.this$0.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    Object localObject1 = ((LinkedHashMap)localObject2).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (String)((Iterator)localObject1).next();
      if (!this.this$0.jdField_a_of_type_JavaUtilArrayList.contains(localObject3)) {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.add(localObject3);
      }
      this.this$0.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)((LinkedHashMap)localObject2).get(localObject3));
    }
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryStruct", 2, "initEntity, size: " + this.this$0.jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryStructMsgView.2
 * JD-Core Version:    0.7.0.1
 */