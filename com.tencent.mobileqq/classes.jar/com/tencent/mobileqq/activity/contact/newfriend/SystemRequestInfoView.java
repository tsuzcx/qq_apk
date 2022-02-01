package com.tencent.mobileqq.activity.contact.newfriend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemRequestInfoView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  public long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  Button jdField_a_of_type_AndroidWidgetButton;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new SystemRequestInfoView.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  byte[] jdField_a_of_type_ArrayOfByte;
  private final int jdField_b_of_type_Int = 1017;
  private long jdField_b_of_type_Long;
  Button jdField_b_of_type_AndroidWidgetButton;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long;
  Button jdField_c_of_type_AndroidWidgetButton;
  
  public SystemRequestInfoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SystemRequestInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getContext(), a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new SystemRequestInfoView.2(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public boolean a()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    boolean bool = NetworkUtil.isNetSupport(getContext());
    int k = 0;
    int m = 0;
    int j = 0;
    if (!bool)
    {
      QQToast.a(getContext(), getResources().getString(2131694422), 0).b(a());
    }
    else
    {
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
      int i = -1;
      long l1;
      long l2;
      int n;
      int i1;
      int i2;
      Object localObject2;
      if (paramView == localObject1)
      {
        if (this.jdField_a_of_type_Int == -1011) {
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).confirmContactFriend(0, Long.parseLong(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
        }
        for (;;)
        {
          i = 1;
          break label455;
          l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
          localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
          if (localObject1 == null) {
            break label443;
          }
          k = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
          l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
          m = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
          n = ((structmsg.StructMsg)localObject1).msg.src_id.get();
          i1 = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
          i2 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
          localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break;
          }
          localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
          ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
          ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
          structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
          localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
          localAddFrdSNInfo.uint32_set_sn.set(0);
          ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(k, l1, l2, m, n, i1, i2, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("agree, ");
        if (localObject2 != null) {
          i = ((List)localObject2).size();
        }
        ((StringBuilder)localObject1).append(i);
        QLog.d("SystemRequestInfoView", 1, ((StringBuilder)localObject1).toString());
        i = j;
        break label455;
        label443:
        QLog.d("SystemRequestInfoView", 1, "agree");
        i = j;
        label455:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673B", "0X800673B", 0, 0, "", "", "", "");
      }
      else if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
        this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
        localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
        if (localObject1 != null)
        {
          j = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
          l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
          m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
          n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
          i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
          i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
          localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
          if ((localObject1 != null) && (1 < ((List)localObject1).size()))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a().a(j, l1, l2, m, n, i1, i2, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject1).get(1)).action_info.get(), 1, null, false);
            i = 1;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("refuse, ");
            if (localObject1 != null) {
              i = ((List)localObject1).size();
            }
            ((StringBuilder)localObject2).append(i);
            QLog.d("SystemRequestInfoView", 1, ((StringBuilder)localObject2).toString());
            i = k;
          }
        }
        else
        {
          QLog.d("SystemRequestInfoView", 1, "refuse");
          i = k;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673A", "0X800673A", 0, 0, "", "", "", "");
      }
      else
      {
        i = m;
        if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
        {
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentIntent);
          ((Intent)localObject1).setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddRequestActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject1, 1018);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673D", "0X800673D", 0, 0, "", "", "", "");
          i = m;
        }
      }
      if (i != 0) {
        a(2131718766);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView
 * JD-Core Version:    0.7.0.1
 */