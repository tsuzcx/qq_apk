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
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "resortRecords cost time: " + (SystemClock.uptimeMillis() - l));
    }
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
        QLog.d("C2CMessageResultAdapter", 2, i);
      }
    }
    else
    {
      if ((paramInt1 != 1) || (paramInt2 != 0)) {
        break label103;
      }
      b(paramList);
      this.b = paramList;
    }
    label103:
    do
    {
      do
      {
        return;
        i = paramList.size();
        break;
        if ((paramInt1 == 2) && (paramInt2 == 0))
        {
          b(paramList);
          this.b.addAll(paramList);
          return;
        }
      } while ((paramInt1 != 4) || (paramList == null) || (paramList.size() == 0) || (paramInt2 != 1));
      b(paramList, paramBoolean);
      if ((this.b.size() <= 0) || (paramList.size() <= 0)) {
        break label253;
      }
      localObject = (MessageItem)paramList.get(0);
      MessageItem localMessageItem = (MessageItem)this.b.get(this.b.size() - 1);
      if (((MessageItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time <= localMessageItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time) {
        break label253;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
    return;
    label253:
    b(paramList);
    this.b.addAll(paramList);
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
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "mergeMsgsAtFirstTime: merge cloud and local msgs cloudGetCompleted: " + paramBoolean);
    }
    this.b.clear();
    b(paramList, paramBoolean);
    b(paramList);
    this.b.addAll(paramList);
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if ((paramMessageRecord == null) || (paramMessageRecord.msg == null) || (paramMessageRecord.msg.trim().length() == 0)) {
        if (QLog.isColorLevel()) {
          QLog.i("C2CMessageResultAdapter", 2, "isValidData, empty item");
        }
      }
      boolean bool1;
      boolean bool2;
      do
      {
        return false;
        String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
        paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
        bool1 = str.contains(MessageItem.jdField_a_of_type_JavaLangString);
        bool2 = paramMessageRecord.contains(MessageItem.jdField_a_of_type_JavaLangString);
      } while ((bool1) || (!bool2));
      return true;
    }
    return super.a(paramMessageRecord);
  }
  
  public void b(List<?> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTime();
    Object localObject = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Calendar localCalendar = ((MessageRoamManager)localObject).c();
    if (localCalendar != null) {
      l = ((Long)((MessageRoamManager)localObject).a(localCalendar).second).longValue();
    }
    int i = 0;
    int j = paramList.size();
    label73:
    if (i < j)
    {
      localObject = paramList.get(i);
      if (!(localObject instanceof MessageItem)) {
        break label154;
      }
      localObject = ((MessageItem)localObject).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    }
    for (;;)
    {
      label105:
      int k;
      if ((localObject != null) && (((MessageRecord)localObject).time > l))
      {
        paramList.remove(i);
        k = j - 1;
        j = i - 1;
        i = k;
      }
      for (;;)
      {
        k = j + 1;
        j = i;
        i = k;
        break label73;
        break;
        label154:
        if (!(localObject instanceof MessageRecord)) {
          break label183;
        }
        localObject = (MessageRecord)localObject;
        break label105;
        k = i;
        i = j;
        j = k;
      }
      label183:
      localObject = null;
    }
  }
  
  void b(List<MessageItem> paramList, boolean paramBoolean)
  {
    int k = 1;
    int m = 0;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems localSize: " + this.jdField_a_of_type_JavaUtilList.size() + ", cloudSize:" + paramList.size() + ", cloudCompleted:" + paramBoolean);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() == 0) || ((paramList.size() == 0) && (!paramBoolean))) {}
    do
    {
      return;
      localObject = new ArrayList();
      if (!paramBoolean) {
        break label519;
      }
      if (!this.b.isEmpty()) {
        break;
      }
      paramList.addAll(this.jdField_a_of_type_JavaUtilList);
      i = k;
      if (QLog.isColorLevel())
      {
        QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems completed and adapter is empty add all local");
        i = k;
      }
      if (((List)localObject).size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.removeAll((Collection)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems removed validItem size: " + ((List)localObject).size());
        }
      }
    } while (i == 0);
    Object localObject = new HashSet();
    int i = m;
    label230:
    if (i < paramList.size())
    {
      long l1 = ((MessageItem)paramList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      if (((Set)localObject).contains(Long.valueOf(l1)))
      {
        paramList.remove(i);
        i -= 1;
      }
      for (;;)
      {
        i += 1;
        break label230;
        l1 = ((MessageItem)this.b.get(this.b.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        int j = 0;
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
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems completed  merge local size: " + ((List)localObject).size());
        }
        j = i;
        if (paramList.size() < 20)
        {
          paramList.addAll(this.jdField_a_of_type_JavaUtilList);
          i = k;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems add all local local size: " + this.jdField_a_of_type_JavaUtilList.size());
          i = k;
          break;
          if (this.b.isEmpty())
          {
            l1 = ((MessageItem)paramList.get(paramList.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
            j = 0;
            i = 0;
            while (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              if (((MessageItem)this.jdField_a_of_type_JavaUtilList.get(j)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time >= l1)
              {
                ((List)localObject).add(this.jdField_a_of_type_JavaUtilList.get(j));
                i = 1;
              }
              j += 1;
            }
            paramList.addAll((Collection)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems uncompleted first screem merger local size: " + ((List)localObject).size());
            }
            break;
          }
          l1 = ((MessageItem)this.b.get(this.b.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          long l2 = ((MessageItem)paramList.get(paramList.size() - 1)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          j = 0;
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
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems uncompleted load more merger local size: " + ((List)localObject).size());
            j = i;
          }
        }
        i = j;
        break;
        ((Set)localObject).add(Long.valueOf(l1));
      }
    }
    label519:
    a(paramList);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
    MessageRecord localMessageRecord;
    String str;
    Object localObject;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559463, null);
      paramView = new BaseMessageResultAdapter.MessageHolder();
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)localView.findViewById(2131379092));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379094));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368603));
      paramView.b = ((TextView)localView.findViewById(2131370043));
      localView.setTag(paramView);
      localMessageRecord = localMessageItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageItem.a(localMessageRecord.msg, -11353092));
      if (!localMessageRecord.isSend()) {
        break label295;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      label168:
      if (!AnonymousChatHelper.a(localMessageRecord)) {
        break label307;
      }
      localObject = AnonymousChatHelper.a(localMessageRecord);
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697219) + ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_JavaLangString);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_Int)));
    }
    for (;;)
    {
      paramView.b.setText(localMessageItem.a(localMessageRecord.time));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label295:
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break label168;
      label307:
      if (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        int i = 2130844382;
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131698214);
        str = localMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
        if (!TextUtils.isEmpty(str))
        {
          i = QFileAssistantUtils.b(Integer.valueOf(str).intValue());
          localObject = QFileAssistantUtils.a(this.jdField_a_of_type_AndroidContentContext, Integer.valueOf(str).intValue());
        }
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
      }
      else
      {
        paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localMessageItem.a(str, -11353092));
        paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, (String)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */