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
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import wgz;
import wha;

public class SystemRequestInfoView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  public long a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  Button jdField_a_of_type_AndroidWidgetButton;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new wgz(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QQProgressDialog a;
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
    return getResources().getDimensionPixelSize(2131558448);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getContext(), a());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new wha(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      bool = true;
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(getContext())) {
      QQToast.a(getContext(), getResources().getString(2131433196), 0).b(a());
    }
    label835:
    for (;;)
    {
      return;
      int k = 0;
      int j = 0;
      int i = 0;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        if (this.jdField_a_of_type_Int == -1011)
        {
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(0, Long.parseLong(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
          i = 1;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673B", "0X800673B", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label835;
        }
        a(2131434436);
        return;
        long l1 = FriendSystemMsgController.a().b();
        paramView = FriendSystemMsgController.a().a(Long.valueOf(l1));
        long l2;
        int m;
        int n;
        Object localObject;
        if (paramView != null)
        {
          i = paramView.msg_type.get();
          l1 = paramView.msg_seq.get();
          l2 = paramView.req_uin.get();
          j = paramView.msg.sub_type.get();
          k = paramView.msg.src_id.get();
          m = paramView.msg.sub_src_id.get();
          n = paramView.msg.group_msg_type.get();
          localObject = paramView.msg.actions.get();
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject).addFrdSNInfo.set(localAddFrdSNInfo);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject, 0, paramView, false);
            i = 1;
            break;
          }
          paramView = new StringBuilder().append("agree, ");
          if (localObject != null) {}
          for (i = ((List)localObject).size();; i = -1)
          {
            QLog.d("SystemRequestInfoView", 1, i);
            i = 0;
            break;
          }
        }
        QLog.d("SystemRequestInfoView", 1, "agree");
        break;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          l1 = FriendSystemMsgController.a().b();
          this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = FriendSystemMsgController.a().a(Long.valueOf(l1));
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
          {
            i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
            l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
            l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
            k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
            n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
            int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
            paramView = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((paramView != null) && (1 < paramView.size()))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
              i = 1;
            }
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673A", "0X800673A", 0, 0, "", "", "", "");
            break;
            localObject = new StringBuilder().append("refuse, ");
            if (paramView != null) {}
            for (i = paramView.size();; i = -1)
            {
              QLog.d("SystemRequestInfoView", 1, i);
              i = j;
              break;
            }
            QLog.d("SystemRequestInfoView", 1, "refuse");
            i = j;
          }
        }
        i = k;
        if (paramView == this.jdField_c_of_type_AndroidWidgetButton)
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentIntent);
          paramView.setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddRequestActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult(paramView, 1018);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673D", "0X800673D", 0, 0, "", "", "", "");
          i = k;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView
 * JD-Core Version:    0.7.0.1
 */