package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class SeparateForward
  implements Handler.Callback
{
  public QQProgressDialog a;
  public WeakReference<QBaseActivity> b;
  public QQAppInterface c;
  public int d;
  TroopObserver e = new SeparateForward.2(this);
  private final WeakReferenceHandler f = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private int g;
  private String h;
  private String i;
  private FriendListObserver j = new SeparateForward.1(this);
  
  public SeparateForward(QBaseActivity paramQBaseActivity, int paramInt)
  {
    this.b = new WeakReference(paramQBaseActivity);
    this.d = paramInt;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.c = ((QQAppInterface)localAppRuntime);
    }
    paramQBaseActivity = paramQBaseActivity.getIntent();
    this.g = paramQBaseActivity.getIntExtra("uintype", -1);
    this.h = paramQBaseActivity.getStringExtra("uin");
  }
  
  public void a()
  {
    this.c.addObserver(this.j);
    this.c.addObserver(this.e);
  }
  
  public void a(Intent paramIntent)
  {
    if (StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.b = paramIntent.getStringExtra("uin");
    localSessionInfo.c = paramIntent.getStringExtra("troop_uin");
    paramIntent = MultiMsgManager.a();
    paramIntent.a(this.c, localSessionInfo, paramIntent.c);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    Object localObject = (QBaseActivity)this.b.get();
    if (localObject == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = MultiMsgUtil.a(this.c, (ArrayList)paramList);
    MultiMsgManager.a().b(paramList);
    if (this.a == null) {
      this.a = new QQProgressDialog((Context)localObject, ((QBaseActivity)localObject).getTitleBarHeight());
    }
    this.a.c(2131896471);
    this.a.show();
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if (!localArrayList.contains(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage.senderuin);
      }
    }
    MultiMsgManager.a().c.clear();
    MultiMsgManager.a().c.addAll(paramList);
    int k = this.g;
    if (k == 1) {
      ((ITroopMemberInfoHandler)this.c.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(this.h, localArrayList, false, null);
    } else if ((k != 0) && (k != 3000))
    {
      if (k == 10014)
      {
        a(new HashMap(), MultiMsgManager.a().c);
        paramList = this.a;
        if (paramList != null)
        {
          if (!paramList.isShowing()) {
            return;
          }
          paramList = this.a;
          if (paramList != null) {
            paramList.dismiss();
          }
        }
      }
    }
    else {
      ((FriendListHandler)this.c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(localArrayList);
    }
    paramList = this.f.obtainMessage(1);
    paramList.arg1 = localArrayList.size();
    this.f.sendMessageDelayed(paramList, 30000L);
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    QBaseActivity localQBaseActivity = (QBaseActivity)this.b.get();
    if (localQBaseActivity == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    int k = this.g;
    String str;
    if (k == 0) {
      str = ContactUtils.a(this.c, this.h);
    } else if ((k != 1) && (k != 3000)) {
      str = " ";
    } else {
      str = this.i;
    }
    paramMap = ChatActivityFacade.a(localQBaseActivity, str, paramArrayList, paramMap, true);
    if (paramMap == null) {
      return;
    }
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    paramArrayList.putExtra("forward_msg_from_together", 1);
    paramArrayList.putExtra("forwardDirect", true);
    ForwardBaseOption.a(localQBaseActivity, paramArrayList, this.d);
  }
  
  public void b()
  {
    this.c.removeObserver(this.j);
    this.c.removeObserver(this.e);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = (QBaseActivity)this.b.get();
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (paramMessage != null))
    {
      localQQProgressDialog.dismiss();
      QQToast.makeText(paramMessage, 2131896473, 0).show(paramMessage.getResources().getDimensionPixelSize(2131299920));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SeparateForward
 * JD-Core Version:    0.7.0.1
 */