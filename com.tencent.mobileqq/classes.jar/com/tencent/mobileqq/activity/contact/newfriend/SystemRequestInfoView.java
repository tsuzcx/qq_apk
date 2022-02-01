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
  int a;
  byte[] b;
  public long c;
  public String d;
  Button e;
  Button f;
  Button g;
  QQProgressDialog h;
  private final int i = 1017;
  private long j;
  private long k;
  private String l;
  private structmsg.StructMsg m;
  private QQAppInterface n;
  private BaseActivity o;
  private Intent p;
  private MessageObserver q = new SystemRequestInfoView.1(this);
  
  public SystemRequestInfoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SystemRequestInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  void a(int paramInt)
  {
    if (this.h == null)
    {
      this.h = new QQProgressDialog(getContext(), getTitleBarHeight());
      this.h.setOnDismissListener(new SystemRequestInfoView.2(this));
      this.h.c(paramInt);
      this.h.setCanceledOnTouchOutside(false);
      this.h.setCancelable(false);
      this.h.show();
    }
  }
  
  public boolean a()
  {
    QQProgressDialog localQQProgressDialog = this.h;
    if (localQQProgressDialog != null)
    {
      localQQProgressDialog.cancel();
      this.h = null;
      return true;
    }
    return false;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public void onClick(View paramView)
  {
    boolean bool = NetworkUtil.isNetSupport(getContext());
    int i3 = 0;
    int i4 = 0;
    int i2 = 0;
    if (!bool)
    {
      QQToast.makeText(getContext(), getResources().getString(2131892102), 0).show(getTitleBarHeight());
    }
    else
    {
      Object localObject1 = this.e;
      int i1 = -1;
      long l1;
      long l2;
      int i5;
      int i6;
      int i7;
      Object localObject2;
      if (paramView == localObject1)
      {
        if (this.a == -1011) {
          ((FriendListHandler)this.n.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).confirmContactFriend(0, Long.parseLong(this.l), this.c, this.b, (byte)0, this.d, this.k, this.j);
        }
        for (;;)
        {
          i1 = 1;
          break label456;
          l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
          localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
          if (localObject1 == null) {
            break label444;
          }
          i3 = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
          l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
          i4 = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
          i5 = ((structmsg.StructMsg)localObject1).msg.src_id.get();
          i6 = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
          i7 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
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
          this.n.getMsgHandler().B().a(i3, l1, l2, i4, i5, i6, i7, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("agree, ");
        if (localObject2 != null) {
          i1 = ((List)localObject2).size();
        }
        ((StringBuilder)localObject1).append(i1);
        QLog.d("SystemRequestInfoView", 1, ((StringBuilder)localObject1).toString());
        i1 = i2;
        break label456;
        label444:
        QLog.d("SystemRequestInfoView", 1, "agree");
        i1 = i2;
        label456:
        ReportController.b(this.n, "CliOper", "", "", "0X800673B", "0X800673B", 0, 0, "", "", "", "");
      }
      else if (paramView == this.f)
      {
        l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
        this.m = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
        localObject1 = this.m;
        if (localObject1 != null)
        {
          i2 = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = this.m.msg_seq.get();
          l2 = this.m.req_uin.get();
          i4 = this.m.msg.sub_type.get();
          i5 = this.m.msg.src_id.get();
          i6 = this.m.msg.sub_src_id.get();
          i7 = this.m.msg.group_msg_type.get();
          localObject1 = this.m.msg.actions.get();
          if ((localObject1 != null) && (1 < ((List)localObject1).size()))
          {
            this.n.getMsgHandler().B().a(i2, l1, l2, i4, i5, i6, i7, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject1).get(1)).action_info.get(), 1, null, false);
            i1 = 1;
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("refuse, ");
            if (localObject1 != null) {
              i1 = ((List)localObject1).size();
            }
            ((StringBuilder)localObject2).append(i1);
            QLog.d("SystemRequestInfoView", 1, ((StringBuilder)localObject2).toString());
            i1 = i3;
          }
        }
        else
        {
          QLog.d("SystemRequestInfoView", 1, "refuse");
          i1 = i3;
        }
        ReportController.b(this.n, "CliOper", "", "", "0X800673A", "0X800673A", 0, 0, "", "", "", "");
      }
      else
      {
        i1 = i4;
        if (paramView == this.g)
        {
          localObject1 = new Intent(this.p);
          ((Intent)localObject1).setClass(this.o, AddRequestActivity.class);
          this.o.startActivityForResult((Intent)localObject1, 1018);
          ReportController.b(this.n, "CliOper", "", "", "0X800673D", "0X800673D", 0, 0, "", "", "", "");
          i1 = i4;
        }
      }
      if (i1 != 0) {
        a(2131916272);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView
 * JD-Core Version:    0.7.0.1
 */