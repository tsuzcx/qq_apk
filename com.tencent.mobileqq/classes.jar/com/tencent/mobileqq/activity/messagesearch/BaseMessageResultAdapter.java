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
  private static final String a = MessageResultAdapter.class.getSimpleName();
  protected List<MessageItem> d = new ArrayList();
  protected Context e;
  protected MqqWeakReferenceHandler f;
  protected SessionInfo g;
  protected QQAppInterface h;
  protected String i;
  protected boolean j = true;
  protected ChatHistorySearchData k;
  Object l = new Object();
  
  public BaseMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.e = paramContext;
    this.f = paramMqqWeakReferenceHandler;
    this.g = paramSessionInfo;
    this.h = paramQQAppInterface;
  }
  
  protected ChatHistorySearchData a(ChatHistorySearchData paramChatHistorySearchData, ArrayList<MessageItem> paramArrayList)
  {
    if (paramChatHistorySearchData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "chatHistorySearchData == null");
      }
      return paramChatHistorySearchData;
    }
    if (paramChatHistorySearchData.mSearchData1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "chatHistorySearchData.mSearchData1 == null");
      }
      paramChatHistorySearchData.offset = 0;
      return paramChatHistorySearchData;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chatHistorySearchData.offset = ");
      localStringBuilder.append(paramChatHistorySearchData.offset);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    int m = paramChatHistorySearchData.offset;
    while (m < paramChatHistorySearchData.mSearchData1.size())
    {
      localObject = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(m);
      paramChatHistorySearchData.offset += 1;
      if (a((MessageRecord)localObject)) {
        paramArrayList.add(new MessageItem(this.h, (MessageRecord)localObject));
      }
      m += 1;
    }
    if ((paramChatHistorySearchData.mSearchData2 != null) && (!paramChatHistorySearchData.mSearchData2.isEmpty()))
    {
      paramChatHistorySearchData = this.h.getMessageFacade().b(this.g.b, this.g.a, paramChatHistorySearchData.mSearchData2);
      if (paramChatHistorySearchData != null) {
        paramChatHistorySearchData.offset = 0;
      }
      return paramChatHistorySearchData;
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "chatHistorySearchData.mSearchData2 == null or empty");
    }
    return paramChatHistorySearchData;
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
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
      if ((!this.j) && (paramString.equalsIgnoreCase(this.i))) {}
    }
    else
    {
      this.i = paramString;
      MessageItem.a(paramString);
      this.j = false;
    }
    ThreadManager.post(new BaseMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
    MessageItem.a(paramString);
  }
  
  public void a(List<MessageItem> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      this.d = paramList;
      return;
    }
    if (paramInt == 2) {
      this.d.addAll(paramList);
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if ((paramMessageRecord != null) && (paramMessageRecord.msg != null) && (paramMessageRecord.msg.trim().length() != 0))
    {
      String str = ContactUtils.a(this.h, this.g, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
      paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
      if ((str.contains(MessageItem.a)) || (paramMessageRecord.contains(MessageItem.a))) {
        bool = true;
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "isValidData, empty item");
    }
    return false;
  }
  
  protected ChatHistorySearchData b(ChatHistorySearchData paramChatHistorySearchData, ArrayList<MessageItem> paramArrayList)
  {
    int n = 0;
    while (n < 20)
    {
      if (paramChatHistorySearchData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "chatHistorySearchData == null");
        }
        return paramChatHistorySearchData;
      }
      if (paramChatHistorySearchData.mSearchData1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "chatHistorySearchData.mSearchData1 == null");
        }
        paramChatHistorySearchData.offset = 0;
        return paramChatHistorySearchData;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("chatHistorySearchData.offset = ");
        localStringBuilder.append(paramChatHistorySearchData.offset);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      int i1 = paramChatHistorySearchData.offset;
      for (int m = n; i1 < paramChatHistorySearchData.mSearchData1.size(); m = n)
      {
        localObject = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(i1);
        paramChatHistorySearchData.offset += 1;
        n = m;
        if (a((MessageRecord)localObject))
        {
          paramArrayList.add(new MessageItem(this.h, (MessageRecord)localObject));
          m += 1;
          n = m;
          if (m == 20)
          {
            if (QLog.isColorLevel())
            {
              paramArrayList = a;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getMessageRecords, one page, offset = ");
              ((StringBuilder)localObject).append(paramChatHistorySearchData.offset);
              QLog.i(paramArrayList, 2, ((StringBuilder)localObject).toString());
            }
            return paramChatHistorySearchData;
          }
        }
        i1 += 1;
      }
      if ((paramChatHistorySearchData.mSearchData2 != null) && (!paramChatHistorySearchData.mSearchData2.isEmpty()))
      {
        localObject = this.h.getMessageFacade().b(this.g.b, this.g.a, paramChatHistorySearchData.mSearchData2);
        paramChatHistorySearchData = (ChatHistorySearchData)localObject;
        n = m;
        if (localObject != null)
        {
          ((ChatHistorySearchData)localObject).offset = 0;
          paramChatHistorySearchData = (ChatHistorySearchData)localObject;
          n = m;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i(a, 2, "chatHistorySearchData.mSearchData2 == null or empty");
      }
    }
    return paramChatHistorySearchData;
  }
  
  public String b()
  {
    return this.i;
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
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