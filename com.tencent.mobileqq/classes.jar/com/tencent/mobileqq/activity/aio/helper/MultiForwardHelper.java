package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.Map;
import mqq.os.MqqHandler;

public class MultiForwardHelper
  implements ILifeCycleHelper
{
  public AIOShareActionSheet a;
  private QQAppInterface b;
  private Context c;
  private Activity d;
  private BaseChatPie e;
  private SessionInfo f;
  
  public MultiForwardHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.e;
    this.d = paramBaseChatPie.f;
    this.e = paramBaseChatPie;
    this.f = paramBaseChatPie.ah;
  }
  
  private void a(List<ChatMessage> paramList)
  {
    MultiMsgManager.a().b(paramList);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("multiForwardSperate|checklist.size = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject).toString());
    }
    if (paramList.size() == 0) {
      return;
    }
    MultiMsgManager.a().c.clear();
    MultiMsgManager.a().c.addAll(paramList);
    MultiMsgManager.a().d.clear();
    MultiMsgManager.a().d.put(this.b.getCurrentUin(), this.b.getCurrentNickname());
    a(MultiMsgManager.a().d, MultiMsgManager.a().c, 1);
    int i = this.f.a;
    Object localObject = "0X80078B8";
    paramList = (List<ChatMessage>)localObject;
    if (i != 0)
    {
      if (i == 1) {
        break label169;
      }
      if (i == 3000) {
        break label163;
      }
      paramList = (List<ChatMessage>)localObject;
    }
    for (;;)
    {
      break;
      label163:
      paramList = "0X80078B9";
      continue;
      label169:
      paramList = "0X80078BA";
    }
    ReportController.b(this.b, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
  }
  
  private void b(List<ChatMessage> paramList)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.d, null);
    localActionSheet.addButton(this.d.getString(2131892033));
    localActionSheet.addButton(this.d.getString(2131892034));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new MultiForwardHelper.1(this, paramList, localActionSheet));
    localActionSheet.show();
  }
  
  public void a()
  {
    if (this.a == null)
    {
      QQAppInterface localQQAppInterface = this.b;
      Context localContext = this.c;
      Activity localActivity = this.d;
      BaseChatPie localBaseChatPie = this.e;
      this.a = new AIOShareActionSheet(localQQAppInterface, localContext, localActivity, localBaseChatPie, localBaseChatPie.j());
    }
    this.a.b();
  }
  
  public void a(ChatAdapter1 paramChatAdapter1, boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(this.c))
    {
      QQToast.makeText(this.b.getApp(), 2131889169, 0).show(this.e.A());
      return;
    }
    paramChatAdapter1 = MultiMsgManager.a().i();
    paramChatAdapter1 = MultiMsgUtil.a(this.b, (ArrayList)paramChatAdapter1);
    if (paramChatAdapter1 != null)
    {
      if (paramChatAdapter1.size() == 0) {
        return;
      }
      if (paramBoolean)
      {
        a(paramChatAdapter1, 2);
        return;
      }
      b(paramChatAdapter1);
    }
  }
  
  public void a(List<ChatMessage> paramList, int paramInt)
  {
    if (!NetworkUtil.isNetSupport(this.c))
    {
      QQToast.makeText(this.b.getApp(), 2131889169, 0).show(this.e.A());
      return;
    }
    MultiMsgManager.a().b(paramList);
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("multiForwardTogether|checklist.size = ");
      ((StringBuilder)localObject1).append(paramList.size());
      QLog.d("MultiMsg_TAG", 4, ((StringBuilder)localObject1).toString());
    }
    if (paramList.size() == 0) {
      return;
    }
    this.e.e(2131896471);
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    String str;
    while (paramList.hasNext())
    {
      localObject2 = (ChatMessage)paramList.next();
      if ((localObject2 instanceof MessageForWriteTogether))
      {
        str = MultiMsgUtil.a(this.b, (MessageRecord)localObject2);
        localObject2 = (ChatMessage)this.b.getMultiMessageProxy().a((MessageRecord)localObject2, str, false);
        if (((ChatMessage)localObject2).senderuin.equals(this.b.getCurrentAccountUin())) {
          ((ISVIPHandler)this.b.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((MessageRecord)localObject2);
        }
        ((ChatMessage)localObject2).setStatus(1000);
        ((ChatMessage)localObject2).msgData = ((ChatMessage)localObject2).msg.getBytes();
        ((ArrayList)localObject1).add(localObject2);
      }
      else
      {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    paramList = new ArrayList();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      str = MsgProxyUtils.d((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    MultiMsgManager.a().c.clear();
    MultiMsgManager.a().c.addAll((Collection)localObject1);
    MultiMsgManager.a().e = paramInt;
    if (this.f.a == 1) {
      ((ITroopMemberInfoHandler)this.b.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(this.f.b, paramList, false, null);
    } else if ((this.f.a != 0) && (this.f.a != 3000) && (this.f.a != 1000) && (this.f.a != 1004))
    {
      if (this.f.a == 10014) {
        ((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).guildAIOMultiActionHelperPullNickName(this.e, this.f.c, paramList);
      }
    }
    else {
      ((FriendListHandler)this.b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(paramList);
    }
    localObject1 = this.e.j();
    localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
    ((Message)localObject2).arg1 = paramList.size();
    ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
    paramInt = this.f.a;
    localObject1 = "0X80078BB";
    paramList = (List<ChatMessage>)localObject1;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        break label575;
      }
      if (paramInt == 3000) {
        break label568;
      }
      paramList = (List<ChatMessage>)localObject1;
    }
    for (;;)
    {
      break;
      label568:
      paramList = "0X80078BC";
      continue;
      label575:
      paramList = "0X80078BD";
    }
    ReportController.b(this.b, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramInt == 4)
    {
      localObject1 = this.a;
      if (localObject1 != null) {
        ((AIOShareActionSheet)localObject1).b(paramMap, paramArrayList);
      }
      return;
    }
    if (paramInt == 3)
    {
      localObject1 = this.a;
      if (localObject1 != null) {
        ((AIOShareActionSheet)localObject1).a(paramMap, paramArrayList);
      }
      return;
    }
    if (this.f.a == 0) {
      localObject1 = ContactUtils.a(this.b, this.f.b);
    } else if ((this.f.a != 1) && (this.f.a != 3000)) {
      localObject1 = " ";
    } else {
      localObject1 = this.f.e;
    }
    Object localObject2 = this.c;
    boolean bool;
    if (paramInt != 1) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject1 = ChatActivityFacade.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
    if (localObject1 == null) {
      return;
    }
    if (paramInt == 2)
    {
      MultiMsgManager.a().a(this.b, this.f.b, this.f.a, this.f.c, (AbsStructMsg)localObject1, 0L, false, paramInt);
      return;
    }
    ((AbsShareMsg)localObject1).mMsg_A_ActionData = null;
    paramMap = new Intent();
    paramMap.putExtra("forward_type", -3);
    paramMap.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    paramMap.putExtra("is_need_show_sources", false);
    paramMap.putExtra("forward_msg_from_together", paramInt);
    paramMap.putExtra("forward_source_uin", this.f.c);
    localObject1 = new boolean[paramArrayList.size()];
    localObject2 = new int[paramArrayList.size()];
    String[] arrayOfString1 = new String[paramArrayList.size()];
    String[] arrayOfString2 = new String[paramArrayList.size()];
    int i = 0;
    int j = 0;
    while (i < paramArrayList.size())
    {
      Object localObject3 = (ChatMessage)paramArrayList.get(i);
      if ((paramInt == 1) && ((localObject3 instanceof MessageForWriteTogether)))
      {
        localObject1[i] = 1;
        localObject3 = (MessageForWriteTogether)localObject3;
        localObject2[i] = ((MessageForWriteTogether)localObject3).baseRev;
        arrayOfString1[i] = ((MessageForWriteTogether)localObject3).padId;
        arrayOfString2[i] = ((MessageForWriteTogether)localObject3).token;
        j += 1;
      }
      else
      {
        localObject1[i] = 0;
        localObject2[i] = 0;
        arrayOfString1[i] = "";
        arrayOfString2[i] = "";
      }
      i += 1;
    }
    paramMap.putExtra("forward_is_write_together", (boolean[])localObject1);
    paramMap.putExtra("forward_write_together_base_rev", (int[])localObject2);
    paramMap.putExtra("forward_write_together_pad_id", arrayOfString1);
    paramMap.putExtra("forward_write_together_token", arrayOfString2);
    paramMap.putExtra("forward_write_together_number", j);
    ForwardBaseOption.a(this.d, paramMap, 21);
  }
  
  public String getTag()
  {
    return "MultiForwardHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 15) {
      return;
    }
    AIOShareActionSheet localAIOShareActionSheet = this.a;
    if (localAIOShareActionSheet != null)
    {
      localAIOShareActionSheet.c();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper
 * JD-Core Version:    0.7.0.1
 */