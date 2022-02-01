package com.tencent.mobileqq.activity.history.link.search;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageResultAdapter.MessageHolder;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TroopAllMessageResultAdapter
  extends BaseMessageResultAdapter
{
  Object jdField_a_of_type_JavaLangObject = new Object();
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("M月d日");
  protected List<MessageItem> a;
  public Set<Long> a;
  
  public TroopAllMessageResultAdapter(Context paramContext, MqqWeakReferenceHandler paramMqqWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
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
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    ThreadManager.post(new TroopAllMessageResultAdapter.1(this, paramString, paramInt, paramLong), 8, null, false);
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
      this.b = paramList;
      return;
    }
    if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      this.b.addAll(paramList);
      return;
    }
    if ((paramInt1 == 4) && (paramList != null) && (paramList.size() != 0))
    {
      if (paramInt2 != 1) {
        return;
      }
      if ((this.b.size() > 0) && (paramList.size() > 0))
      {
        localObject = (MessageItem)paramList.get(0);
        MessageItem localMessageItem = (MessageItem)this.b.get(this.b.size() - 1);
        if (((MessageItem)localObject).a.time > localMessageItem.a.time)
        {
          if (QLog.isColorLevel()) {
            QLog.e("LinkMessageResultAdapter", 2, "setMessageItems: error firstItem time > lastItem time");
          }
          return;
        }
      }
      this.b.addAll(paramList);
    }
  }
  
  public void a(List<MessageItem> paramList, String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("LinkMessageResultAdapter", 2, "displayCloudMessages...");
    }
    ThreadManager.post(new TroopAllMessageResultAdapter.2(this, paramString, paramLong, paramList), 8, null, false);
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
      this.b.clear();
      this.b.addAll(paramList);
    }
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
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
    Object localObject1 = localMessageItem.a;
    Object localObject2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, ((MessageRecord)localObject1).isSend(), ((MessageRecord)localObject1).senderuin);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageItem.a(((MessageRecord)localObject1).msg, -11353092));
    Object localObject3;
    if (((MessageRecord)localObject1).isSend()) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    } else {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    }
    if (AnonymousChatHelper.a((MessageRecord)localObject1))
    {
      localObject2 = AnonymousChatHelper.a((MessageRecord)localObject1);
      localObject3 = paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697238));
      localStringBuilder.append(((AnonymousChatHelper.AnonymousExtInfo)localObject2).jdField_b_of_type_JavaLangString);
      ((ColorNickTextView)localObject3).setText(localStringBuilder.toString());
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(((AnonymousChatHelper.AnonymousExtInfo)localObject2).jdField_b_of_type_Int)));
    }
    else
    {
      paramView.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText(localMessageItem.a((String)localObject2, -11353092));
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((MessageRecord)localObject1).senderuin));
    }
    paramView.b.setText(localMessageItem.a(((MessageRecord)localObject1).time));
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.link.search.TroopAllMessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */