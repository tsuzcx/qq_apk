package com.tencent.mobileqq.activity.history;

import agbe;
import aimd;
import akpu;
import android.text.TextUtils;
import apej;
import apvw;
import bbft;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

class ChatHistoryC2CLinkFragment$2
  implements Runnable
{
  ChatHistoryC2CLinkFragment$2(ChatHistoryC2CLinkFragment paramChatHistoryC2CLinkFragment, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject2;
    int i;
    int j;
    label144:
    Object localObject3;
    Object localObject4;
    if (this.a)
    {
      localObject1 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = this.this$0.jdField_c_of_type_JavaLangString;
      i = this.this$0.jdField_a_of_type_Int;
      j = ChatHistoryC2CLinkFragment.d();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, new int[] { -2011, -1000, -1035, -1049, -5008 }, j);
      if ((localObject1 != null) && (((List)localObject1).size() < ChatHistoryC2CLinkFragment.d())) {
        this.this$0.d = true;
      }
      localObject2 = new LinkedHashMap();
      if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
        break label833;
      }
      i = ((List)localObject1).size() - 1;
      if (i < 0) {
        break label833;
      }
      localObject3 = (MessageRecord)((List)localObject1).get(i);
      if (!aimd.a((MessageRecord)localObject3)) {
        break label677;
      }
      if (((MessageRecord)localObject3).shmsgseq < this.this$0.jdField_b_of_type_Long) {
        this.this$0.jdField_b_of_type_Long = ((MessageRecord)localObject3).shmsgseq;
      }
      if (((MessageRecord)localObject3).versionCode < this.this$0.jdField_b_of_type_Int) {
        this.this$0.jdField_b_of_type_Int = ((MessageRecord)localObject3).versionCode;
      }
      if ((((MessageRecord)localObject3).getId() > 0L) && (((MessageRecord)localObject3).getId() < this.this$0.jdField_a_of_type_Long)) {
        this.this$0.jdField_a_of_type_Long = ((MessageRecord)localObject3).getId();
      }
      if (((MessageRecord)localObject3).time < this.this$0.jdField_c_of_type_Long) {
        this.this$0.jdField_c_of_type_Long = ((MessageRecord)localObject3).time;
      }
      if (!(localObject3 instanceof MessageForStructing)) {
        break label617;
      }
      localObject4 = (MessageForStructing)localObject3;
      if ((((MessageForStructing)localObject4).structingMsg == null) || (!(((MessageForStructing)localObject4).structingMsg instanceof AbsShareMsg))) {
        break label617;
      }
      localObject4 = (AbsShareMsg)((MessageForStructing)localObject4).structingMsg;
      if ((((MessageRecord)localObject3).time < 1548460800L) || (!apej.a(((AbsShareMsg)localObject4).mMsgUrl))) {
        break label617;
      }
    }
    for (;;)
    {
      i -= 1;
      break label144;
      if (akpu.a(this.this$0.jdField_a_of_type_Int))
      {
        localObject1 = this.this$0;
        ((ChatHistoryC2CLinkFragment)localObject1).jdField_b_of_type_Long -= 1L;
        localObject1 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = this.this$0.jdField_c_of_type_JavaLangString;
        i = this.this$0.jdField_a_of_type_Int;
        l1 = this.this$0.jdField_a_of_type_Long;
        j = this.this$0.jdField_b_of_type_Int;
        l2 = this.this$0.jdField_b_of_type_Long;
        k = ChatHistoryC2CLinkFragment.d();
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { -2011, -1000, -1035, -1049, -5008 }, k);
        break;
      }
      localObject1 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localObject2 = this.this$0.jdField_c_of_type_JavaLangString;
      i = this.this$0.jdField_a_of_type_Int;
      long l1 = this.this$0.jdField_a_of_type_Long;
      j = this.this$0.jdField_b_of_type_Int;
      long l2 = this.this$0.jdField_c_of_type_Long;
      int k = ChatHistoryC2CLinkFragment.d();
      localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, i, l1, j, l2, new int[] { -2011, -1000, -1035, -1049, -5008 }, k);
      break;
      label617:
      localObject4 = apvw.a(((MessageRecord)localObject3).time * 1000L);
      if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
        ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
      }
      ((List)((LinkedHashMap)localObject2).get(localObject4)).add(localObject3);
      continue;
      label677:
      if ((((localObject3 instanceof MessageForText)) || ((localObject3 instanceof MessageForMixedMsg)) || ((localObject3 instanceof MessageForReplyText)) || ((localObject3 instanceof MessageForArkApp))) && (((MessageRecord)localObject3).time >= 1548460800L))
      {
        localObject4 = agbe.a((MessageRecord)localObject3);
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (bbft.b.matcher((CharSequence)localObject4).find()) && (ChatHistoryC2CLinkFragment.jdField_a_of_type_JavaUtilRegexPattern.matcher((CharSequence)localObject4).find()))
        {
          localObject4 = apvw.a(((MessageRecord)localObject3).time * 1000L);
          if (!((LinkedHashMap)localObject2).containsKey(localObject4)) {
            ((LinkedHashMap)localObject2).put(localObject4, new ArrayList());
          }
          localObject4 = (List)((LinkedHashMap)localObject2).get(localObject4);
          if (localObject4 != null) {
            ((List)localObject4).add(localObject3);
          }
        }
      }
    }
    label833:
    if (this.this$0.jdField_a_of_type_JavaUtilArrayList == null) {
      this.this$0.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.2
 * JD-Core Version:    0.7.0.1
 */