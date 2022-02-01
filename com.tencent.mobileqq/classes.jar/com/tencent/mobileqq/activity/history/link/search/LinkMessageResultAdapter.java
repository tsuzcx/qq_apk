package com.tencent.mobileqq.activity.history.link.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.link.LinkAdapter;
import com.tencent.mobileqq.activity.history.link.TroopLinkElement;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.MessageHolder;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.app.HardCodeUtil;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinkMessageResultAdapter
  extends BaseMessageResultAdapter
{
  Object a = new Object();
  protected List<MessageItem> b = new ArrayList();
  public Set<Long> c = new HashSet();
  private List<TroopLinkElement> m;
  private SimpleDateFormat n = new SimpleDateFormat("M月d日");
  
  public LinkMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
  }
  
  ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      MessageForText localMessageForText = MessageRecordFactory.a(this.h, this.h.getCurrentUin(), localTroopLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localTroopLinkElement.description());
      localMessageForText.msgData = GroupUtil.a(localTroopLinkElement);
      localMessageForText.shmsgseq = Long.parseLong(localTroopLinkElement.msgSeq);
      if (localMessageForText.msg.contains(paramString)) {
        paramSessionInfo.mSearchData1.add(localMessageForText);
      }
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
    ThreadManager.post(new LinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<TroopLinkElement> paramList)
  {
    this.m = paramList;
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
      QLog.d("LinkMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
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
            QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
          }
          return;
        }
      }
      this.d.addAll(paramList);
    }
  }
  
  public void a(List<MessageItem> paramList, String paramString, long paramLong)
  {
    this.b.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new LinkMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
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
        QLog.d("LinkMessageResultAdapter", 2, localStringBuilder.toString());
      }
      this.d.clear();
      this.d.addAll(paramList);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    BaseMessageResultAdapter.MessageHolder localMessageHolder;
    if (paramView == null)
    {
      paramView = View.inflate(this.e, 2131625301, null);
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
    Object localObject1 = localMessageItem.b;
    TroopLinkElement localTroopLinkElement = new TroopLinkElement();
    try
    {
      localObject1 = GroupUtil.a(((MessageRecord)localObject1).msgData);
      if (localObject1 != null) {
        localTroopLinkElement = (TroopLinkElement)localObject1;
      }
      Object localObject2 = localTroopLinkElement.nickname;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localTroopLinkElement.uin;
      }
      localObject2 = localMessageItem.a(localTroopLinkElement.title, -11353092);
      localMessageHolder.b.setText((CharSequence)localObject2);
      localObject2 = new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L);
      localObject2 = this.n.format((Date)localObject2);
      localObject1 = String.format(HardCodeUtil.a(2131904064), new Object[] { localObject2, localObject1 });
      localMessageHolder.c.setText(localMessageItem.a((String)localObject1, -11353092));
      if (!TextUtils.isEmpty(localTroopLinkElement.iconUrl)) {
        LinkAdapter.a(localMessageHolder.a, localTroopLinkElement.iconUrl);
      } else {
        localMessageHolder.a.setImageDrawable(this.e.getResources().getDrawable(2130852667));
      }
    }
    catch (Exception localException)
    {
      label310:
      break label310;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */