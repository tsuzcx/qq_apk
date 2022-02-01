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
  protected List<MessageItem> a = new ArrayList();
  public Set<Long> b = new HashSet();
  
  public C2CMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramMqqWeakReferenceHandler, paramSessionInfo, paramQQAppInterface);
  }
  
  public void a()
  {
    this.d.clear();
    notifyDataSetChanged();
  }
  
  void a(String paramString, long paramLong)
  {
    this.a.clear();
    this.b.clear();
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
      this.d = paramList;
      return;
    }
    if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      b(paramList);
      this.d.addAll(paramList);
      return;
    }
    if ((paramInt1 == 4) && (paramList != null) && (paramList.size() != 0))
    {
      if (paramInt2 != 1) {
        return;
      }
      b(paramList, paramBoolean);
      if ((this.d.size() > 0) && (paramList.size() > 0))
      {
        localObject = (MessageItem)paramList.get(0);
        MessageItem localMessageItem = (MessageItem)this.d.get(this.d.size() - 1);
        if (((MessageItem)localObject).b.time > localMessageItem.b.time)
        {
          if (QLog.isColorLevel()) {
            QLog.e("C2CMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
          }
          return;
        }
      }
      b(paramList);
      this.d.addAll(paramList);
    }
  }
  
  void a(List<MessageItem> paramList, String paramString, long paramLong)
  {
    this.a.clear();
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
      this.d.clear();
      b(paramList, paramBoolean);
      b(paramList);
      this.d.addAll(paramList);
    }
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    if (QFileAssistantUtils.a(this.g.b))
    {
      boolean bool2 = false;
      if ((paramMessageRecord != null) && (paramMessageRecord.msg != null) && (paramMessageRecord.msg.trim().length() != 0))
      {
        String str = ContactUtils.a(this.h, this.g, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
        paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
        boolean bool3 = str.contains(MessageItem.a);
        boolean bool4 = paramMessageRecord.contains(MessageItem.a);
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
      Object localObject1 = (MessageRoamManager)this.h.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      Object localObject2 = ((MessageRoamManager)localObject1).g();
      if (localObject2 != null) {
        l = ((Long)((MessageRoamManager)localObject1).f((Calendar)localObject2).second).longValue();
      }
      int i = 0;
      int j;
      for (int k = paramList.size(); i < k; k = j)
      {
        localObject2 = paramList.get(i);
        localObject1 = null;
        if ((localObject2 instanceof MessageItem)) {
          localObject1 = ((MessageItem)localObject2).b;
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
      ((StringBuilder)localObject).append(this.a.size());
      ((StringBuilder)localObject).append(", cloudSize:");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append(", cloudCompleted:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("C2CMessageResultAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.size() != 0)
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
        if (this.d.isEmpty())
        {
          paramList.addAll(this.a);
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageResultAdapter", 2, "mergeMessageItems completed and adapter is empty add all local");
          }
        }
        for (;;)
        {
          i = 1;
          break;
          l1 = ((MessageItem)this.d.get(this.d.size() - 1)).b.time;
          j = 0;
          i = 0;
          while (j < this.a.size())
          {
            if (((MessageItem)this.a.get(j)).b.time < l1)
            {
              ((List)localObject).add(this.a.get(j));
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
          paramList.addAll(this.a);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mergeMessageItems add all local local size: ");
            localStringBuilder.append(this.a.size());
            QLog.d("C2CMessageResultAdapter", 2, localStringBuilder.toString());
          }
        }
      }
      if (this.d.isEmpty())
      {
        l1 = ((MessageItem)paramList.get(paramList.size() - 1)).b.time;
        i = 0;
        j = 0;
        while (i < this.a.size())
        {
          if (((MessageItem)this.a.get(i)).b.time >= l1)
          {
            ((List)localObject).add(this.a.get(i));
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
        l1 = ((MessageItem)this.d.get(this.d.size() - 1)).b.time;
        long l2 = ((MessageItem)paramList.get(paramList.size() - 1)).b.time;
        j = 0;
        int k;
        for (i = 0; j < this.a.size(); i = k)
        {
          long l3 = ((MessageItem)this.a.get(j)).b.time;
          k = i;
          if (l2 <= l3)
          {
            k = i;
            if (l3 < l1)
            {
              ((List)localObject).add(this.a.get(j));
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
        this.a.removeAll((Collection)localObject);
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
          l1 = ((MessageItem)paramList.get(i)).b.shmsgseq;
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
      localView = View.inflate(this.e, 2131625303, null);
      paramView = new BaseMessageResultAdapter.MessageHolder();
      paramView.b = ((ColorNickTextView)localView.findViewById(2131447063));
      paramView.c = ((TextView)localView.findViewById(2131447065));
      paramView.a = ((ImageView)localView.findViewById(2131435219));
      paramView.d = ((TextView)localView.findViewById(2131436844));
      localView.setTag(paramView);
    }
    else
    {
      localObject1 = (BaseMessageResultAdapter.MessageHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    MessageRecord localMessageRecord = localMessageItem.b;
    Object localObject2 = ContactUtils.a(this.h, this.g, localMessageRecord.isSend(), localMessageRecord.senderuin);
    paramView.c.setText(localMessageItem.a(localMessageRecord.msg, -11353092));
    if (localMessageRecord.isSend()) {
      localObject1 = this.h.getCurrentAccountUin();
    } else {
      localObject1 = this.g.b;
    }
    if (AnonymousChatHelper.c(localMessageRecord))
    {
      localObject1 = AnonymousChatHelper.g(localMessageRecord);
      localObject2 = paramView.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e.getResources().getString(2131895011));
      localStringBuilder.append(((AnonymousChatHelper.AnonymousExtInfo)localObject1).c);
      ((ColorNickTextView)localObject2).setText(localStringBuilder.toString());
      paramView.a.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject1).d)));
    }
    else if (QFileAssistantUtils.a(this.g.b))
    {
      int i = 2130845605;
      localObject1 = this.e.getString(2131896179);
      localObject2 = localMessageRecord.getExtInfoFromExtStr("dataline_msg_device_type");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = QFileAssistantUtils.a(Integer.valueOf((String)localObject2).intValue());
        localObject1 = QFileAssistantUtils.a(this.e, Integer.valueOf((String)localObject2).intValue());
      }
      paramView.b.setText((CharSequence)localObject1);
      paramView.a.setBackgroundDrawable(this.e.getResources().getDrawable(i));
    }
    else
    {
      paramView.b.setText(localMessageItem.a((String)localObject2, -11353092));
      paramView.a.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.h, 1, (String)localObject1));
    }
    paramView.d.setText(localMessageItem.a(localMessageRecord.time));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */