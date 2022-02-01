package com.tencent.mobileqq.activity.history.tendoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.LinkAdapter;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.MessageHolder;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.app.QQAppInterface;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class TenDocMessageResultAdapter
  extends BaseMessageResultAdapter
{
  private List<TencentDocItem> a = new ArrayList();
  private LayoutInflater b;
  private Runnable c;
  
  public TenDocMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
    this.b = LayoutInflater.from(paramContext);
  }
  
  private ChatHistorySearchData e()
  {
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      TencentDocItem localTencentDocItem = (TencentDocItem)localIterator.next();
      MessageRecord localMessageRecord = localTencentDocItem.mRecord;
      if (localMessageRecord != null)
      {
        MessageForText localMessageForText = MessageRecordFactory.a(this.h, localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, this.g.a, (byte)1, (byte)0, (short)0, localTencentDocItem.mSearchWords);
        localMessageForText.msgData = GroupUtil.a(localTencentDocItem);
        localMessageForText.shmsgseq = localMessageRecord.shmsgseq;
        localMessageForText.msgseq = localMessageRecord.msgseq;
        localMessageForText.time = localMessageRecord.time;
        localMessageForText.senderuin = localMessageRecord.senderuin;
        localChatHistorySearchData.mSearchData1.add(localMessageForText);
      }
    }
    localChatHistorySearchData.mSearchData2 = new ArrayList();
    return localChatHistorySearchData;
  }
  
  public void a()
  {
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Runnable localRunnable = this.c;
    if (localRunnable != null) {
      ThreadManager.removeJobFromThreadPool(localRunnable, 16);
    }
    this.c = new TenDocMessageResultAdapter.LoadRunnable(this, paramInt, paramString, paramLong);
    ThreadManager.getSubThreadHandler().post(this.c);
  }
  
  public void a(List<TencentDocItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.a = paramList;
    notifyDataSetChanged();
  }
  
  public void a(List<MessageItem> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set MessageItems: ");
        localStringBuilder.append(paramList.size());
        QLog.d("TenDocMessageResultAdapter", 2, localStringBuilder.toString());
      }
      this.d.clear();
      this.d.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (MessageItem)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.b.inflate(2131625301, paramViewGroup, false);
      paramView = new BaseMessageResultAdapter.MessageHolder();
      paramView.b = ((ColorNickTextView)localView.findViewById(2131447587));
      paramView.c = ((TextView)localView.findViewById(2131431754));
      paramView.a = ((ImageView)localView.findViewById(2131435219));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = ((MessageItem)localObject2).b;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("get view mr: ");
    ((StringBuilder)localObject3).append(localObject1);
    QLog.d("TenDocMessageResultAdapter", 4, ((StringBuilder)localObject3).toString());
    if (localObject1 != null)
    {
      localObject1 = TencentDocItem.decodeFromMsgData(((MessageRecord)localObject1).msgData);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("get view doc item: ");
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("TenDocMessageResultAdapter", 4, ((StringBuilder)localObject3).toString());
      if (localObject1 != null)
      {
        localObject3 = ((MessageItem)localObject2).a(((TencentDocItem)localObject1).mTitle, -11353092);
        localObject2 = ((MessageItem)localObject2).a(((TencentDocItem)localObject1).mDescription, -11353092);
        paramView.b.setText((CharSequence)localObject3);
        paramView.c.setText((CharSequence)localObject2);
        LinkAdapter.a(paramView.a, ((TencentDocItem)localObject1).mIcon);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */