package com.tencent.mobileqq.activity.history.tendoc;

import agbl;
import agdi;
import agdj;
import ager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import axaq;
import azjv;
import bfmt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class TenDocMessageResultAdapter
  extends agdi
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private List<TencentDocItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public TenDocMessageResultAdapter(Context paramContext, bfmt parambfmt, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambfmt, paramSessionInfo, paramQQAppInterface);
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
        MessageForText localMessageForText = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.selfuin, localMessageRecord.frienduin, localMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (byte)1, (byte)0, (short)0, localTencentDocItem.mSearchWords);
        localMessageForText.msgData = azjv.a(localTencentDocItem);
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
  
  public void a(List<ager> paramList, int paramInt)
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
    Object localObject1 = (ager)getItem(paramInt);
    Object localObject2;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559214, paramViewGroup, false);
      paramViewGroup = new agdj();
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131377444));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365042));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      paramView.setTag(paramViewGroup);
      localObject2 = ((ager)localObject1).a;
      QLog.d("TenDocMessageResultAdapter", 4, "get view mr: " + localObject2);
      if (localObject2 != null) {
        break label130;
      }
    }
    label130:
    do
    {
      return paramView;
      paramViewGroup = (agdj)paramView.getTag();
      break;
      localObject2 = TencentDocItem.decodeFromMsgData(((MessageRecord)localObject2).msgData);
      QLog.d("TenDocMessageResultAdapter", 4, "get view doc item: " + localObject2);
    } while (localObject2 == null);
    CharSequence localCharSequence = ((ager)localObject1).a(((TencentDocItem)localObject2).mTitle, -11353092);
    localObject1 = ((ager)localObject1).a(((TencentDocItem)localObject2).mDescription, -11353092);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localCharSequence);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    agbl.a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, ((TencentDocItem)localObject2).mIcon);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */