package com.tencent.mobileqq.activity.history.tendoc;

import ajwl;
import akbp;
import akbq;
import akcy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bcsa;
import bfce;
import bkyc;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class TenDocMessageResultAdapter
  extends akbp
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<TencentDocItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public TenDocMessageResultAdapter(Context paramContext, bkyc parambkyc, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambkyc, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private ChatHistorySearchData a()
  {
    ChatHistorySearchData localChatHistorySearchData = new ChatHistorySearchData();
    localChatHistorySearchData.mSearchData1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TencentDocItem localTencentDocItem = (TencentDocItem)localIterator.next();
      MessageRecord localMessageRecord = localTencentDocItem.mRecord;
      if (localMessageRecord != null)
      {
        MessageForText localMessageForText = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, (byte)1, (byte)0, (short)0, localTencentDocItem.mSearchWords);
        localMessageForText.msgData = bfce.a(localTencentDocItem);
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
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
    }
    this.jdField_a_of_type_JavaLangRunnable = new TenDocMessageResultAdapter.LoadRunnable(this, paramInt, paramString, paramLong);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(List<TencentDocItem> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(List<akcy> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TenDocMessageResultAdapter", 2, "set MessageItems: " + paramList.size());
    }
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = (akcy)getItem(paramInt);
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559394, paramViewGroup, false);
      paramView = new akbq();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131379104));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365537));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368381));
      localView.setTag(paramView);
      localObject1 = ((akcy)localObject2).a;
      QLog.d("TenDocMessageResultAdapter", 4, "get view mr: " + localObject1);
      if (localObject1 != null) {
        break label158;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (akbq)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
      break;
      label158:
      localObject1 = TencentDocItem.decodeFromMsgData(((MessageRecord)localObject1).msgData);
      QLog.d("TenDocMessageResultAdapter", 4, "get view doc item: " + localObject1);
      if (localObject1 != null)
      {
        CharSequence localCharSequence = ((akcy)localObject2).a(((TencentDocItem)localObject1).mTitle, -11353092);
        localObject2 = ((akcy)localObject2).a(((TencentDocItem)localObject1).mDescription, -11353092);
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localCharSequence);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
        ajwl.a(paramView.jdField_a_of_type_AndroidWidgetImageView, ((TencentDocItem)localObject1).mIcon);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */