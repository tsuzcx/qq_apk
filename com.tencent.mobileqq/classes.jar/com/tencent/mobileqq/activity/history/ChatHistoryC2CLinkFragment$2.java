package com.tencent.mobileqq.activity.history;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.history.helper.ContentHelper;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.Patterns;
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
    int i;
    int j;
    if (this.a)
    {
      localObject1 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      str = this.this$0.jdField_c_of_type_JavaLangString;
      i = this.this$0.jdField_a_of_type_Int;
      j = ChatHistoryC2CLinkFragment.d();
      localObject1 = ((QQMessageFacade)localObject1).a(str, i, new int[] { -2011, -1000, -1035, -1049, -5008 }, j);
    }
    else
    {
      long l1;
      long l2;
      int k;
      if (UinTypeUtil.g(this.this$0.jdField_a_of_type_Int))
      {
        localObject1 = this.this$0;
        ((ChatHistoryC2CLinkFragment)localObject1).jdField_b_of_type_Long -= 1L;
        localObject1 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        str = this.this$0.jdField_c_of_type_JavaLangString;
        i = this.this$0.jdField_a_of_type_Int;
        l1 = this.this$0.jdField_a_of_type_Long;
        j = this.this$0.jdField_b_of_type_Int;
        l2 = this.this$0.jdField_b_of_type_Long;
        k = ChatHistoryC2CLinkFragment.d();
        localObject1 = ((QQMessageFacade)localObject1).a(str, i, l1, j, l2, new int[] { -2011, -1000, -1035, -1049, -5008 }, k);
      }
      else
      {
        localObject1 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
        str = this.this$0.jdField_c_of_type_JavaLangString;
        i = this.this$0.jdField_a_of_type_Int;
        l1 = this.this$0.jdField_a_of_type_Long;
        j = this.this$0.jdField_b_of_type_Int;
        l2 = this.this$0.jdField_c_of_type_Long;
        k = ChatHistoryC2CLinkFragment.d();
        localObject1 = ((QQMessageFacade)localObject1).a(str, i, l1, j, l2, new int[] { -2011, -1000, -1035, -1049, -5008 }, k);
      }
    }
    boolean bool = QLog.isColorLevel();
    String str = "ChatHistoryStruct";
    if (bool)
    {
      bool = this.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" msgList:");
      if (localObject1 != null) {
        i = ((List)localObject1).size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject2).append(i);
      QLog.d("ChatHistoryStruct", 2, new Object[] { "isInited:", Boolean.valueOf(bool), ((StringBuilder)localObject2).toString() });
    }
    if ((localObject1 != null) && (((List)localObject1).size() == 0)) {
      this.this$0.d = true;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.putAll(ChatHistoryC2CLinkFragment.a(this.this$0));
    Object localObject2 = str;
    if (localObject1 != null)
    {
      localObject2 = str;
      if (!((List)localObject1).isEmpty())
      {
        i = ((List)localObject1).size() - 1;
        for (;;)
        {
          localObject2 = str;
          if (i < 0) {
            break;
          }
          localObject2 = (MessageRecord)((List)localObject1).get(i);
          Object localObject3;
          if (ChatHistoryStructAdapter.a((MessageRecord)localObject2))
          {
            if (((MessageRecord)localObject2).shmsgseq < this.this$0.jdField_b_of_type_Long) {
              this.this$0.jdField_b_of_type_Long = ((MessageRecord)localObject2).shmsgseq;
            }
            if (((MessageRecord)localObject2).versionCode < this.this$0.jdField_b_of_type_Int) {
              this.this$0.jdField_b_of_type_Int = ((MessageRecord)localObject2).versionCode;
            }
            if ((((MessageRecord)localObject2).getId() > 0L) && (((MessageRecord)localObject2).getId() < this.this$0.jdField_a_of_type_Long)) {
              this.this$0.jdField_a_of_type_Long = ((MessageRecord)localObject2).getId();
            }
            if (((MessageRecord)localObject2).time < this.this$0.jdField_c_of_type_Long) {
              this.this$0.jdField_c_of_type_Long = ((MessageRecord)localObject2).time;
            }
            if ((localObject2 instanceof MessageForStructing))
            {
              localObject3 = (MessageForStructing)localObject2;
              if ((((MessageForStructing)localObject3).structingMsg != null) && ((((MessageForStructing)localObject3).structingMsg instanceof AbsShareMsg)))
              {
                localObject3 = (AbsShareMsg)((MessageForStructing)localObject3).structingMsg;
                if ((((MessageRecord)localObject2).time >= 1548460800L) && (FMConstants.a(((AbsShareMsg)localObject3).mMsgUrl))) {
                  break label974;
                }
              }
            }
            localObject3 = QfileTimeUtils.a(((MessageRecord)localObject2).time * 1000L);
            if (!localLinkedHashMap.containsKey(localObject3)) {
              localLinkedHashMap.put(localObject3, new ArrayList());
            }
            ((List)localLinkedHashMap.get(localObject3)).add(localObject2);
          }
          else if ((((localObject2 instanceof MessageForText)) || ((localObject2 instanceof MessageForMixedMsg)) || ((localObject2 instanceof MessageForReplyText)) || ((localObject2 instanceof MessageForArkApp))) && (((MessageRecord)localObject2).time >= 1548460800L))
          {
            localObject3 = ContentHelper.a((MessageRecord)localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              if (((MessageRecord)localObject2).time < this.this$0.jdField_c_of_type_Long) {
                this.this$0.jdField_c_of_type_Long = ((MessageRecord)localObject2).time;
              }
              if ((Patterns.b.matcher((CharSequence)localObject3).find()) && (ChatHistoryC2CLinkFragment.jdField_a_of_type_JavaUtilRegexPattern.matcher((CharSequence)localObject3).find()))
              {
                localObject3 = QfileTimeUtils.a(((MessageRecord)localObject2).time * 1000L);
                if (!localLinkedHashMap.containsKey(localObject3)) {
                  localLinkedHashMap.put(localObject3, new ArrayList());
                }
                localObject3 = (List)localLinkedHashMap.get(localObject3);
                if (localObject3 != null) {
                  ((List)localObject3).add(localObject2);
                }
              }
            }
          }
          label974:
          i -= 1;
        }
      }
    }
    if (this.this$0.jdField_a_of_type_JavaUtilArrayList == null) {
      this.this$0.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
    Object localObject1 = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (!this.this$0.jdField_a_of_type_JavaUtilArrayList.contains(str)) {
        this.this$0.jdField_a_of_type_JavaUtilArrayList.add(str);
      }
      this.this$0.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localLinkedHashMap.get(str));
    }
    ChatHistoryC2CLinkFragment.a(this.this$0, localLinkedHashMap);
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
    if (QLog.isColorLevel())
    {
      i = 0;
      j = this.this$0.jdField_a_of_type_JavaUtilArrayList.size();
      if (ChatHistoryC2CLinkFragment.a(this.this$0) != null) {
        i = ChatHistoryC2CLinkFragment.a(this.this$0).size();
      }
      QLog.d((String)localObject2, 2, new Object[] { "initEntity, size: ", Integer.valueOf(j), " dataMap:", Integer.valueOf(i) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CLinkFragment.2
 * JD-Core Version:    0.7.0.1
 */