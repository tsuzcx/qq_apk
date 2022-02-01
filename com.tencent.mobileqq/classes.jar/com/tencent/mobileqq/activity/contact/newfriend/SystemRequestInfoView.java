package com.tencent.mobileqq.activity.contact.newfriend;

import ajao;
import ajap;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import anqd;
import aogd;
import bcst;
import bdgm;
import bgnt;
import biau;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
  private anqd jdField_a_of_type_Anqd = new ajao(this);
  public biau a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    return getResources().getDimensionPixelSize(2131298998);
  }
  
  void a(int paramInt)
  {
    if (this.jdField_a_of_type_Biau == null)
    {
      this.jdField_a_of_type_Biau = new biau(getContext(), a());
      this.jdField_a_of_type_Biau.setOnDismissListener(new ajap(this));
      this.jdField_a_of_type_Biau.c(paramInt);
      this.jdField_a_of_type_Biau.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Biau.setCancelable(false);
      this.jdField_a_of_type_Biau.show();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Biau != null)
    {
      bool = true;
      this.jdField_a_of_type_Biau.cancel();
      this.jdField_a_of_type_Biau = null;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if (!bgnt.d(getContext())) {
      QQToast.a(getContext(), getResources().getString(2131693946), 0).b(a());
    }
    label866:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int k = 0;
      int j = 0;
      int i = 0;
      if (paramView == this.jdField_a_of_type_AndroidWidgetButton) {
        if (this.jdField_a_of_type_Int == -1011)
        {
          ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(0, Long.parseLong(this.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfByte, (byte)0, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
          i = 1;
          label113:
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673B", "0X800673B", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label866;
        }
        a(2131717771);
        break;
        long l1 = bdgm.a().b();
        Object localObject1 = bdgm.a().a(Long.valueOf(l1));
        long l2;
        int m;
        int n;
        Object localObject2;
        if (localObject1 != null)
        {
          i = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
          l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
          j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
          k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
          m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
          n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
          localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
            i = 1;
            break label113;
          }
          localObject1 = new StringBuilder().append("agree, ");
          if (localObject2 != null) {}
          for (i = ((List)localObject2).size();; i = -1)
          {
            QLog.d("SystemRequestInfoView", 1, i);
            i = 0;
            break;
          }
        }
        QLog.d("SystemRequestInfoView", 1, "agree");
        break label113;
        if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
        {
          l1 = bdgm.a().b();
          this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = bdgm.a().a(Long.valueOf(l1));
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
          {
            i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
            l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
            l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
            k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
            n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
            int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((localObject1 != null) && (1 < ((List)localObject1).size()))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(i, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject1).get(1)).action_info.get(), 1, null, false);
              i = 1;
            }
          }
          for (;;)
          {
            bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673A", "0X800673A", 0, 0, "", "", "", "");
            break;
            localObject2 = new StringBuilder().append("refuse, ");
            if (localObject1 != null) {}
            for (i = ((List)localObject1).size();; i = -1)
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
          localObject1 = new Intent(this.jdField_a_of_type_AndroidContentIntent);
          ((Intent)localObject1).setClass(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AddRequestActivity.class);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivityForResult((Intent)localObject1, 1018);
          bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800673D", "0X800673D", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView
 * JD-Core Version:    0.7.0.1
 */