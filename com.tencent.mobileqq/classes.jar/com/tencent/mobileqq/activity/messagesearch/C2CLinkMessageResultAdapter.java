package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.LinkAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C2CLinkMessageResultAdapter
  extends BaseMessageResultAdapter
{
  Object a = new Object();
  protected List<MessageItem> b = new ArrayList();
  public Set<Long> c = new HashSet();
  private ArrayList<C2CLinkElement> m = new ArrayList();
  private SimpleDateFormat n = new SimpleDateFormat("M月d日");
  private FriendsManager o;
  
  public C2CLinkMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
    this.o = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
  }
  
  public C2CLinkElement a(int paramInt)
  {
    Object localObject = ((MessageItem)getItem(paramInt)).b;
    try
    {
      localObject = GroupUtil.a(((MessageRecord)localObject).msgData);
      if (localObject != null)
      {
        localObject = (C2CLinkElement)localObject;
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("C2CLinkMessageResultAdapter", 2, new Object[] { "getLinkElement, e:", localException.toString() });
    }
    return null;
  }
  
  ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    paramString = this.m.iterator();
    while (paramString.hasNext())
    {
      C2CLinkElement localC2CLinkElement = (C2CLinkElement)paramString.next();
      MessageForText localMessageForText = MessageRecordFactory.a(this.h, this.h.getCurrentUin(), localC2CLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localC2CLinkElement.description());
      localMessageForText.msgData = GroupUtil.a(localC2CLinkElement);
      localMessageForText.senderuin = localC2CLinkElement.sendUin;
      localMessageForText.issend = localC2CLinkElement.isSend;
      paramSessionInfo.mSearchData1.add(localMessageForText);
    }
    paramSessionInfo.mSearchData2 = new ArrayList();
    return paramSessionInfo;
  }
  
  public void a()
  {
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new C2CLinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<Object> paramList)
  {
    this.m.clear();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      localObject = C2CLinkElement.parseFrom(this.h, localObject, this.o, this.n, i);
      if (localObject != null) {
        this.m.add(localObject);
      }
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void a(List<MessageItem> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setMessageItems loadType: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", searchMode: ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", cloudGetCompleted: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", messageItems size: ");
      int i;
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("C2CLinkMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      this.d = paramList;
      return;
    }
    if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      this.d.addAll(paramList);
      return;
    }
    if ((paramInt1 == 4) && (paramList != null) && (paramList.size() != 0))
    {
      if (paramInt2 != 1) {
        return;
      }
      if ((this.d.size() > 0) && (paramList.size() > 0))
      {
        localObject = (MessageItem)paramList.get(0);
        MessageItem localMessageItem = (MessageItem)this.d.get(this.d.size() - 1);
        if (((MessageItem)localObject).b.time > localMessageItem.b.time)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CLinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
          }
          return;
        }
      }
      this.d.addAll(paramList);
    }
  }
  
  public void a(List<MessageItem> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: ");
        localStringBuilder.append(paramBoolean);
        QLog.d("C2CLinkMessageResultAdapter", 2, localStringBuilder.toString());
      }
      this.d.clear();
      this.d.addAll(paramList);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    C2CLinkElement localC2CLinkElement = null;
    BaseMessageResultAdapter.MessageHolder localMessageHolder;
    if (paramView == null)
    {
      paramView = View.inflate(this.e, 2131625296, null);
      localMessageHolder = new BaseMessageResultAdapter.MessageHolder();
      localMessageHolder.b = ((ColorNickTextView)paramView.findViewById(2131447587));
      localMessageHolder.c = ((TextView)paramView.findViewById(2131431754));
      localMessageHolder.a = ((ImageView)paramView.findViewById(2131435219));
      paramView.setTag(localMessageHolder);
    }
    else
    {
      localMessageHolder = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
    }
    Object localObject = localMessageItem.b;
    try
    {
      localObject = GroupUtil.a(((MessageRecord)localObject).msgData);
      if (localObject != null) {
        localC2CLinkElement = (C2CLinkElement)localObject;
      }
      if (localC2CLinkElement != null)
      {
        localObject = localMessageItem.a(localC2CLinkElement.title, -11353092);
        localMessageHolder.b.setText((CharSequence)localObject);
        localMessageHolder.c.setText(localMessageItem.a(localC2CLinkElement.timeSecond, -11353092));
        LinkAdapter.a(localMessageHolder.a, localC2CLinkElement.iconUrl);
      }
    }
    catch (Exception localException)
    {
      label194:
      break label194;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */