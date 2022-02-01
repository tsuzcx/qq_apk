package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.activity.messagesearch.MessageItem;
import com.tencent.mobileqq.activity.messagesearch.TroopAllMessageSearchDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import mqq.os.MqqHandler;

public class AIOSearchBarHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private BaseChatPie a;
  private TroopAllMessageSearchDialog b;
  private C2CMessageSearchDialog c;
  private MessageRoamManager d;
  private boolean e;
  
  AIOSearchBarHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    paramBaseChatPie = this.a;
    boolean bool;
    if ((!(paramBaseChatPie instanceof FriendChatPie)) && (!(paramBaseChatPie instanceof TroopChatPie))) {
      bool = false;
    } else {
      bool = true;
    }
    this.e = bool;
  }
  
  private void a()
  {
    Object localObject = this.a.aX().getIntent().getExtras();
    if (localObject == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.b = ((Bundle)localObject).getString("uin");
    localSessionInfo.a = ((Bundle)localObject).getInt("uintype");
    localSessionInfo.c = ((Bundle)localObject).getString("troop_uin");
    localSessionInfo.H = new ChatBackground();
    localSessionInfo.r = ChatTextSizeSettingActivity.a(this.a.aX());
    localObject = this.a;
    if ((localObject instanceof FriendChatPie))
    {
      this.c = new C2CMessageSearchDialog(((BaseChatPie)localObject).aX(), this.a.d, localSessionInfo, this.d.I());
      this.c.show();
      this.c.b.setOnItemLongClickListener(null);
      this.c.b.setOnItemClickListener(new AIOSearchBarHelper.2(this));
      return;
    }
    this.b = new TroopAllMessageSearchDialog(((BaseChatPie)localObject).aX(), this.a.d, localSessionInfo, this.d.I());
    this.b.show();
    this.b.b.setOnItemLongClickListener(null);
    this.b.b.setOnItemClickListener(new AIOSearchBarHelper.3(this));
  }
  
  private void a(MessageItem paramMessageItem)
  {
    paramMessageItem = paramMessageItem.b;
    if ((paramMessageItem instanceof ChatMessage))
    {
      MultiMsgManager.a().b((ChatMessage)paramMessageItem, true);
      this.a.V.notifyDataSetChanged();
    }
    if (this.a.aX().getIntent().getExtras() == null) {
      return;
    }
    long l1 = paramMessageItem.time;
    int i = paramMessageItem.istroop;
    long l2 = paramMessageItem.shmsgseq;
    if (i == 1) {
      l1 = l2;
    }
    this.a.a(l1);
  }
  
  public String getTag()
  {
    return "AIOSearchBarHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131436209) && (this.e))
    {
      ReportController.b(this.a.d, "dc00898", "", "", "0X800A416", "0X800A416", 0, 0, "", "", "", "");
      a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (this.e)
    {
      Object localObject;
      if (paramInt != 4)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          localObject = this.d;
          if (localObject != null) {
            ((MessageRoamManager)localObject).c(hashCode());
          }
          localObject = this.b;
          if ((localObject != null) && (((TroopAllMessageSearchDialog)localObject).isShowing()))
          {
            this.b.dismiss();
            this.b = null;
          }
          localObject = this.c;
          if ((localObject != null) && (((C2CMessageSearchDialog)localObject).isShowing()))
          {
            this.c.dismiss();
            this.c = null;
          }
        }
        else
        {
          this.a.v.setOnClickListener(this);
        }
      }
      else
      {
        localObject = this.a.aX().getIntent().getExtras();
        if (localObject == null) {
          return;
        }
        this.d = ((MessageRoamManager)this.a.d.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
        ThreadManager.getFileThreadHandler().post(new AIOSearchBarHelper.1(this, (Bundle)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOSearchBarHelper
 * JD-Core Version:    0.7.0.1
 */