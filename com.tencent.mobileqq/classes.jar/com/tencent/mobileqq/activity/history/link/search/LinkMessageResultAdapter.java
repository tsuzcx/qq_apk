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
import com.tencent.mobileqq.troop.aioapp.GroupUtil;
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
  Object jdField_a_of_type_JavaLangObject = new Object();
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
  protected List<MessageItem> a;
  public Set<Long> a;
  private List<TroopLinkElement> c;
  
  public LinkMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  ChatHistorySearchData a(SessionInfo paramSessionInfo, String paramString)
  {
    paramSessionInfo = new ChatHistorySearchData();
    paramSessionInfo.mSearchData1 = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      TroopLinkElement localTroopLinkElement = (TroopLinkElement)localIterator.next();
      MessageForText localMessageForText = MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localTroopLinkElement.uin, "", 0, (byte)1, (byte)0, (short)0, localTroopLinkElement.description());
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
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new LinkMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
  }
  
  public void a(List<TroopLinkElement> paramList)
  {
    this.c = paramList;
  }
  
  public void a(List<MessageItem> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("setMessageItems loadType: ").append(paramInt1).append(", searchMode: ").append(paramInt2).append(", cloudGetCompleted: ").append(paramBoolean).append(", messageItems size: ");
      if (paramList == null)
      {
        i = 0;
        QLog.d("LinkMessageResultAdapter", 2, i);
      }
    }
    else
    {
      if ((paramInt1 != 1) || (paramInt2 != 0)) {
        break label98;
      }
      this.b = paramList;
    }
    label98:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        if ((paramInt1 == 2) && (paramInt2 == 0))
        {
          this.b.addAll(paramList);
          return;
        }
      } while ((paramInt1 != 4) || (paramList == null) || (paramList.size() == 0) || (paramInt2 != 1));
      if ((this.b.size() <= 0) || (paramList.size() <= 0)) {
        break label237;
      }
      localObject = (MessageItem)paramList.get(0);
      MessageItem localMessageItem = (MessageItem)this.b.get(this.b.size() - 1);
      if (((MessageItem)localObject).a.time <= localMessageItem.a.time) {
        break label237;
      }
    } while (!QLog.isColorLevel());
    QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label237:
    this.b.addAll(paramList);
  }
  
  public void a(List<MessageItem> paramList, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new LinkMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
  }
  
  public void a(List<MessageItem> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    BaseMessageResultAdapter.MessageHolder localMessageHolder;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559461, null);
      localMessageHolder = new BaseMessageResultAdapter.MessageHolder();
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131379538));
      localMessageHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365698));
      localMessageHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
      paramView.setTag(localMessageHolder);
    }
    for (;;)
    {
      Object localObject1 = localMessageItem.a;
      TroopLinkElement localTroopLinkElement = new TroopLinkElement();
      try
      {
        localObject1 = GroupUtil.a(((MessageRecord)localObject1).msgData);
        if (localObject1 == null) {
          break label331;
        }
        localTroopLinkElement = (TroopLinkElement)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          continue;
          localException.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850895));
        }
      }
      localObject2 = localTroopLinkElement.nickname;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localTroopLinkElement.uin;
      }
      localObject2 = localMessageItem.a(localTroopLinkElement.title, -11353092);
      localMessageHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject2);
      localObject2 = new Date(Long.parseLong(localTroopLinkElement.timeSecond) * 1000L);
      localObject2 = this.jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject2);
      localObject1 = String.format(HardCodeUtil.a(2131706145), new Object[] { localObject2, localObject1 });
      localMessageHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageItem.a((String)localObject1, -11353092));
      if (TextUtils.isEmpty(localTroopLinkElement.iconUrl)) {
        break;
      }
      LinkAdapter.a(localMessageHolder.jdField_a_of_type_AndroidWidgetImageView, localTroopLinkElement.iconUrl);
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localMessageHolder = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */