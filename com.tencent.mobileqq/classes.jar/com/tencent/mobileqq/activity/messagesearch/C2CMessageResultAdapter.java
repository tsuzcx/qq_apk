package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import mqq.os.MqqHandler;

public class C2CMessageResultAdapter
  extends BaseMessageResultAdapter
{
  protected List<MessageItem> a;
  public Set<Long> a;
  
  public C2CMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
  }
  
  public void a()
  {
    this.b.clear();
    notifyDataSetChanged();
  }
  
  void a(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.getSubThreadHandler().post(new C2CMessageResultAdapter.2(this, paramString, paramLong));
  }
  
  void a(List<MessageItem> paramList)
  {
    long l = SystemClock.uptimeMillis();
    if (paramList.size() > 0) {
      Collections.sort(paramList, new C2CMessageResultAdapter.3(this));
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("resortRecords cost time: ");
      paramList.append(SystemClock.uptimeMillis() - l);
      QLog.d("C2CMessageResultAdapter", 2, paramList.toString());
    }
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
      QLog.d("C2CMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 == 1) && (paramInt2 == 0))
    {
      b(paramList);
      this.b = paramList;
      return;
    }
    if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      b(paramList);
      this.b.addAll(paramList);
      return;
    }
    if ((paramInt1 == 4) && (paramList != null) && (paramList.size() != 0))
    {
      if (paramInt2 != 1) {
        return;
      }
      b(paramList, paramBoolean);
      if ((this.b.size() > 0) && (paramList.size() > 0))
      {
        localObject = (MessageItem)paramList.get(0);
        MessageItem localMessageItem = (MessageItem)this.b.get(this.b.size() - 1);
        if (((MessageItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time > localMessageItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
          }
          return;
        }
      }
      b(paramList);
      this.b.addAll(paramList);
    }
  }
  
  void a(List<MessageItem> paramList, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new C2CMessageResultAdapter.1(this, paramString, paramLong, paramList), 8, null, false);
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
        QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
      }
      this.b.clear();
      b(paramList, paramBoolean);
      b(paramList);
      this.b.addAll(paramList);
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      boolean bool2 = false;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg != null) && (paramMessageRecord.msg.trim().length() != 0))
      {
        String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
        paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
        boolean bool3 = str.contains(MessageItem.jdField_a_of_type_JavaLangString);
        boolean bool4 = paramMessageRecord.contains(MessageItem.jdField_a_of_type_JavaLangString);
        boolean bool1 = bool2;
        if (!bool3)
        {
          bool1 = bool2;
          if (bool4) {
            bool1 = true;
          }
        }
        return bool1;
      }
      if (QLog.isColorLevel()) {
        QLog.i("C2CMessageResultAdapter", 2, "isValidData, empty item");
      }
      return false;
    }
    return super.a(paramMessageRecord);
  }
  
  public void b(List<?> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      long l = NetConnInfoCenter.getServerTime();
      Object localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      Object localObject2 = ((MessageRoamManager)localObject1).c();
      if (localObject2 != null) {
        l = ((Long)((MessageRoamManager)localObject1).a((Calendar)localObject2).second).longValue();
      }
      int i = 0;
      int j;
      for (int k = paramList.size(); i < k; k = j)
      {
        localObject2 = paramList.get(i);
        localObject1 = null;
        if ((localObject2 instanceof MessageItem)) {
          localObject1 = ((MessageItem)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        } else if ((localObject2 instanceof MessageRecord)) {
          localObject1 = (MessageRecord)localObject2;
        }
        int m = i;
        j = k;
        if (localObject1 != null)
        {
          m = i;
          j = k;
          if (((MessageRecord)localObject1).time > l)
          {
            paramList.remove(i);
            j = k - 1;
            m = i - 1;
          }
        }
        i = m + 1;
      }
    }
  }
  
  void b(List<MessageItem> paramList, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mergeMessageItems localSize: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      ((StringBuilder)localObject).append(", cloudSize:");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append(", cloudCompleted:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("C2CMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_JavaUtilList.size() != 0)
    {
      if ((paramList.size() == 0) && (!paramBoolean)) {
        return;
      }
      localObject = new ArrayList();
      int m = 0;
      int i;
      long l1;
      int j;
      StringBuilder localStringBuilder;
      if (paramBoolean)
      {
        if (this.b.isEmpty())
        {
          paramList.addAll(this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems completed and adapter is empty add all local");
          }
        }
        for (;;)
        {
          i = 1;
          break;
          l1 = ((MessageItem)this.b.get(this.b.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          j = 0;
          i = 0;
          while (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            if (((MessageItem)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time < l1)
            {
              ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(j));
              i = 1;
            }
            j += 1;
          }
          paramList.addAll((Collection)localObject);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mergeMessageItems completed  merge local size: ");
            localStringBuilder.append(((List)localObject).size());
            QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
          }
          if (paramList.size() >= 20) {
            break;
          }
          paramList.addAll(this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mergeMessageItems add all local local size: ");
            localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
            QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
          }
        }
      }
      if (this.b.isEmpty())
      {
        l1 = ((MessageItem)paramList.get(paramList.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        i = 0;
        j = 0;
        while (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          if (((MessageItem)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time >= l1)
          {
            ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(i));
            j = 1;
          }
          i += 1;
        }
        paramList.addAll((Collection)localObject);
        i = j;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mergeMessageItems uncompleted first screem merger local size: ");
          localStringBuilder.append(((List)localObject).size());
          QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
          i = j;
        }
      }
      else
      {
        l1 = ((MessageItem)this.b.get(this.b.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        long l2 = ((MessageItem)paramList.get(paramList.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        j = 0;
        int k;
        for (i = 0; j < this.jdField_a_of_type_JavaUtilList.size(); i = k)
        {
          long l3 = ((MessageItem)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          k = i;
          if (l2 <= l3)
          {
            k = i;
            if (l3 < l1)
            {
              ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(j));
              k = 1;
            }
          }
          j += 1;
        }
        paramList.addAll((Collection)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mergeMessageItems uncompleted load more merger local size: ");
          localStringBuilder.append(((List)localObject).size());
          QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
        }
      }
      if (((List)localObject).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.removeAll((Collection)localObject);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("mergeMessageItems removed validItem size: ");
          localStringBuilder.append(((List)localObject).size());
          QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
        }
      }
      if (i != 0)
      {
        localObject = new HashSet();
        i = m;
        while (i < paramList.size())
        {
          l1 = ((MessageItem)paramList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
          if (((Set)localObject).contains(Long.valueOf(l1)))
          {
            paramList.remove(i);
            i -= 1;
          }
          else
          {
            ((Set)localObject).add(Long.valueOf(l1));
          }
          i += 1;
        }
        a(paramList);
      }
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
    Object localObject1;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559337, null);
      paramView = new BaseMessageResultAdapter.MessageHolder();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131378461));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378463));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368343));
      paramView.b = ((TextView)localView.findViewById(2131369727));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    MessageRecord localMessageRecord = localMessageItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    Object localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageItem.a(localMessageRecord.msg, -11353092));
    if (localMessageRecord.isSend()) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    } else {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    if (AnonymousChatHelper.a(localMessageRecord))
    {
      localObject1 = AnonymousChatHelper.a(localMessageRecord);
      localObject2 = paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697238));
      localStringBuilder.append(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString);
      ((ColorNickTextView)localObject2).setText(localStringBuilder.toString());
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_Int)));
    }
    else if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      int i = 2130844288;
      localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131698278);
      localObject2 = localMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = QFileAssistantUtils.a(Integer.valueOf((String)localObject2).intValue());
        localObject1 = QFileAssistantUtils.a(this.jdField_a_of_type_AndroidContentContext, Integer.valueOf((String)localObject2).intValue());
      }
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject1);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localMessageItem.a((String)localObject2, -11353092));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject1));
    }
    paramView.b.setText(localMessageItem.a(localMessageRecord.time));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */