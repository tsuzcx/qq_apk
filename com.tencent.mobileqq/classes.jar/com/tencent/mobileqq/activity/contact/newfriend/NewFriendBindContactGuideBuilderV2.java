package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendBindContactGuideMsgV2;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.JumpSettingAction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfBean;
import com.tencent.mobileqq.config.business.NewFriendContactGuideConfBean.UIElement;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NewFriendBindContactGuideBuilderV2
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendBindContactGuideMsgV2 a;
  
  public NewFriendBindContactGuideBuilderV2(Context paramContext, QQAppInterface paramQQAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramQQAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2 = ((NewFriendBindContactGuideMsgV2)paramNewFriendMessage);
  }
  
  private void c()
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new NewFriendBindContactGuideBuilderV2.2(this));
  }
  
  private void d()
  {
    NewFriendBindContactGuideBuilderV2.3 local3 = new NewFriendBindContactGuideBuilderV2.3(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this.jdField_a_of_type_AndroidContentContext, new DenyRunnable.JumpSettingAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    PermissionChecker.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, local3, localDenyRunnable);
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    String str3;
    String str2;
    String str1;
    if ((paramView == null) || (!(paramView.getTag() instanceof NewFriendBindContactGuideBuilderV2.MyHolder)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561665, null);
      localObject = new NewFriendBindContactGuideBuilderV2.MyHolder(null);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131361948));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379432));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378719));
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131364815));
      paramView.setTag(localObject);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_Boolean) {
        break label278;
      }
      str3 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean.a.a;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean.a.b;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean.a.c;
      label149:
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(str3);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setText(str1);
      paramView.setOnClickListener(this);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
      ((NewFriendBindContactGuideBuilderV2.MyHolder)localObject).jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(paramView, false);
      localObject = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_Boolean) {
        break label326;
      }
      if (!((NewFriendManager)localObject).d)
      {
        ((NewFriendManager)localObject).d = true;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1D", "0X8009F1D", 0, 0, "", "", "", "");
      }
    }
    label278:
    label326:
    while (((NewFriendManager)localObject).e)
    {
      return paramView;
      localObject = (NewFriendBindContactGuideBuilderV2.MyHolder)paramView.getTag();
      break;
      str3 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean.b.a;
      str2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean.b.b;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_ComTencentMobileqqConfigBusinessNewFriendContactGuideConfBean.b.c;
      break label149;
    }
    ((NewFriendManager)localObject).e = true;
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1F", "0X8009F1F", 0, 0, "", "", "", "");
    return paramView;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendBindContactGuideBuilderV2", 2, "uploadContact");
    }
    ThreadManager.excute(new NewFriendBindContactGuideBuilderV2.1(this), 16, null, false);
    ContactBindedActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 15, 2, null);
    c();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364815)
    {
      ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a();
      c();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131361948) || (i == 2131363665)) {
        if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
        {
          BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
          QQToast.a(localBaseApplication, 1, 2131694510, 0).b(localBaseApplication.getResources().getDimensionPixelSize(2131299166));
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendMsgNewFriendBindContactGuideMsgV2.jdField_a_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F20", "0X8009F20", 0, 0, "", "", "", "");
          b();
        }
        else
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009F1E", "0X8009F1E", 0, 0, "", "", "", "");
          d();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendBindContactGuideBuilderV2
 * JD-Core Version:    0.7.0.1
 */