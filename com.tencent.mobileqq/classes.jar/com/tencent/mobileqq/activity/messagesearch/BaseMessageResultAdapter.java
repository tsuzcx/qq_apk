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
  protected SessionInfo a;
  protected QQAppInterface a;
  protected ChatHistorySearchData a;
  protected MqqWeakReferenceHandler a;
  protected String a;
  protected boolean a;
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
  
  protected ChatHistorySearchData a(ChatHistorySearchData paramChatHistorySearchData, ArrayList<MessageItem> paramArrayList)
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chatHistorySearchData.offset = ");
      localStringBuilder.append(paramChatHistorySearchData.offset);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    int i = paramChatHistorySearchData.offset;
    while (i < paramChatHistorySearchData.mSearchData1.size())
    {
      localObject = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(i);
      paramChatHistorySearchData.offset += 1;
      if (a((MessageRecord)localObject)) {
        paramArrayList.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject));
      }
      i += 1;
    }
    if ((paramChatHistorySearchData.mSearchData2 != null) && (!paramChatHistorySearchData.mSearchData2.isEmpty()))
    {
      paramChatHistorySearchData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatHistorySearchData.mSearchData2);
      if (paramChatHistorySearchData != null) {
        paramChatHistorySearchData.offset = 0;
      }
      return paramChatHistorySearchData;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData2 == null or empty");
    }
    return paramChatHistorySearchData;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMessageResult, keyword = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", loadType = ");
      localStringBuilder.append(paramInt);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    if (paramInt == 2)
    {
      if ((!this.jdField_a_of_type_Boolean) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))) {}
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      MessageItem.a(paramString);
      this.jdField_a_of_type_Boolean = false;
    }
    ThreadManager.post(new BaseMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    MessageItem.a(paramString);
  }
  
  public void a(List<MessageItem> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaUtilList = paramList;
      return;
    }
    if (paramInt == 2) {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if ((paramMessageRecord != null) && (paramMessageRecord.msg != null) && (paramMessageRecord.msg.trim().length() != 0))
    {
      String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
      paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
      if ((str.contains(MessageItem.jdField_a_of_type_JavaLangString)) || (paramMessageRecord.contains(MessageItem.jdField_a_of_type_JavaLangString))) {
        bool = true;
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "isValidData, empty item");
    }
    return false;
  }
  
  protected ChatHistorySearchData b(ChatHistorySearchData paramChatHistorySearchData, ArrayList<MessageItem> paramArrayList)
  {
    int j = 0;
    while (j < 20)
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
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("chatHistorySearchData.offset = ");
        localStringBuilder.append(paramChatHistorySearchData.offset);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      int k = paramChatHistorySearchData.offset;
      for (int i = j; k < paramChatHistorySearchData.mSearchData1.size(); i = j)
      {
        localObject = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(k);
        paramChatHistorySearchData.offset += 1;
        j = i;
        if (a((MessageRecord)localObject))
        {
          paramArrayList.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject));
          i += 1;
          j = i;
          if (i == 20)
          {
            if (QLog.isColorLevel())
            {
              paramArrayList = jdField_b_of_type_JavaLangString;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getMessageRecords, one page, offset = ");
              ((StringBuilder)localObject).append(paramChatHistorySearchData.offset);
              QLog.i(paramArrayList, 2, ((StringBuilder)localObject).toString());
            }
            return paramChatHistorySearchData;
          }
        }
        k += 1;
      }
      if ((paramChatHistorySearchData.mSearchData2 != null) && (!paramChatHistorySearchData.mSearchData2.isEmpty()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatHistorySearchData.mSearchData2);
        paramChatHistorySearchData = (ChatHistorySearchData)localObject;
        j = i;
        if (localObject != null)
        {
          ((ChatHistorySearchData)localObject).offset = 0;
          paramChatHistorySearchData = (ChatHistorySearchData)localObject;
          j = i;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData2 == null or empty");
      }
    }
    return paramChatHistorySearchData;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */