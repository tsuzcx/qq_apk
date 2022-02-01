package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

class AddRequestActivity$5
  implements ActionSheet.OnButtonClickListener
{
  AddRequestActivity$5(AddRequestActivity paramAddRequestActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
        this.b.q = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
        if (this.b.q != null)
        {
          paramInt = this.b.q.msg_type.get();
          l1 = this.b.q.msg_seq.get();
          long l2 = this.b.q.req_uin.get();
          int i = this.b.q.msg.sub_type.get();
          int j = this.b.q.msg.src_id.get();
          int k = this.b.q.msg.sub_src_id.get();
          int m = this.b.q.msg.group_msg_type.get();
          paramView = this.b.q.msg.actions.get();
          if ((paramView != null) && (1 < paramView.size()))
          {
            ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get()).blacklist.set(true);
            AddRequestActivity.a(this.b, true);
            this.b.app.getMsgHandler().B().a(paramInt, l1, l2, i, j, k, m, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
            AddRequestActivity.a(this.b, 2131916272, 1000L, false);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("shield, ");
            if (paramView != null) {
              paramInt = paramView.size();
            } else {
              paramInt = -1;
            }
            localStringBuilder.append(paramInt);
            QLog.d("Q.systemmsg.AddRequestActivity", 1, localStringBuilder.toString());
          }
        }
        else
        {
          QLog.d("Q.systemmsg.AddRequestActivity", 1, "shield");
        }
      }
      else
      {
        QQToast.makeText(this.b, 2131892104, 0).show(this.b.getTitleBarHeight());
      }
      ReportController.b(this.b.app, "CliOper", "", "", "Verification_msg", "Vfc_shield_clk", 0, 0, "", "", "", "");
      ReportController.b(this.b.app, "CliOper", "", "", "0X800AA45", "0X800AA45", 0, 0, "", "", "", "");
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.5
 * JD-Core Version:    0.7.0.1
 */