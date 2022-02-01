package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BaseMessageResultAdapter
  extends BaseAdapter
{
  private static final String jdField_b_of_type_JavaLangString = MessageResultAdapter.class.getSimpleName();
  protected Context a;
  public SessionInfo a;
  public QQAppInterface a;
  public ChatHistorySearchData a;
  public MqqWeakReferenceHandler a;
  public String a;
  public boolean a;
  Object jdField_b_of_type_JavaLangObject = new Object();
  protected List<MessageItem> b;
  
  public BaseMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = paramMqqWeakReferenceHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public ChatHistorySearchData a(ChatHistorySearchData paramChatHistorySearchData, ArrayList<MessageItem> paramArrayList)
  {
    if (paramChatHistorySearchData == null)
    {
      paramArrayList = paramChatHistorySearchData;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData == null");
        paramArrayList = paramChatHistorySearchData;
      }
    }
    do
    {
      do
      {
        return paramArrayList;
        if (paramChatHistorySearchData.mSearchData1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData1 == null");
          }
          paramChatHistorySearchData.offset = 0;
          return paramChatHistorySearchData;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.offset = " + paramChatHistorySearchData.offset);
        }
        int i = paramChatHistorySearchData.offset;
        while (i < paramChatHistorySearchData.mSearchData1.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(i);
          paramChatHistorySearchData.offset += 1;
          if (a(localMessageRecord)) {
            paramArrayList.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
          }
          i += 1;
        }
        if ((paramChatHistorySearchData.mSearchData2 != null) && (!paramChatHistorySearchData.mSearchData2.isEmpty())) {
          break;
        }
        paramArrayList = paramChatHistorySearchData;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData2 == null or empty");
      return paramChatHistorySearchData;
      paramChatHistorySearchData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatHistorySearchData.mSearchData2);
      paramArrayList = paramChatHistorySearchData;
    } while (paramChatHistorySearchData == null);
    paramChatHistorySearchData.offset = 0;
    return paramChatHistorySearchData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "loadMessageResult, keyword = " + paramString + ", loadType = " + paramInt);
    }
    if (paramString == null) {}
    do
    {
      return;
      if (paramInt != 2) {
        break;
      }
    } while ((this.jdField_a_of_type_Boolean) || (!paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)));
    for (;;)
    {
      ThreadManager.post(new BaseMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
      return;
      this.jdField_a_of_type_JavaLangString = paramString;
      MessageItem.a(paramString);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    MessageItem.a(paramString);
  }
  
  public void a(List<MessageItem> paramList, int paramInt)
  {
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilList = paramList;
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msg == null) || (paramMessageRecord.msg.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "isValidData, empty item");
      }
    }
    String str;
    do
    {
      return false;
      str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
      paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
    } while ((!str.contains(MessageItem.jdField_a_of_type_JavaLangString)) && (!paramMessageRecord.contains(MessageItem.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public ChatHistorySearchData b(ChatHistorySearchData paramChatHistorySearchData, ArrayList<MessageItem> paramArrayList)
  {
    int i = 0;
    for (;;)
    {
      if (i < 20)
      {
        if (paramChatHistorySearchData == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData == null");
          }
          return paramChatHistorySearchData;
        }
        if (paramChatHistorySearchData.mSearchData1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData1 == null");
          }
          paramChatHistorySearchData.offset = 0;
          return paramChatHistorySearchData;
        }
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.offset = " + paramChatHistorySearchData.offset);
        }
        int k = paramChatHistorySearchData.offset;
        while (k < paramChatHistorySearchData.mSearchData1.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(k);
          paramChatHistorySearchData.offset += 1;
          int j = i;
          if (a(localMessageRecord))
          {
            paramArrayList.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
            i += 1;
            j = i;
            if (i == 20)
            {
              if (QLog.isColorLevel()) {
                QLog.i(jdField_b_of_type_JavaLangString, 2, "getMessageRecords, one page, offset = " + paramChatHistorySearchData.offset);
              }
              return paramChatHistorySearchData;
            }
          }
          k += 1;
          i = j;
        }
        if ((paramChatHistorySearchData.mSearchData2 == null) || (paramChatHistorySearchData.mSearchData2.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData2 == null or empty");
          }
          return paramChatHistorySearchData;
        }
        paramChatHistorySearchData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatHistorySearchData.mSearchData2);
        if (paramChatHistorySearchData != null) {
          paramChatHistorySearchData.offset = 0;
        }
      }
      else
      {
        return paramChatHistorySearchData;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */