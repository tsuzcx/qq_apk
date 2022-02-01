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
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class MultiForwardHelper
  implements ILifeCycleHelper
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public AIOShareActionSheet a;
  
  public MultiForwardHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_AndroidAppActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  private void a(List<ChatMessage> paramList)
  {
    MultiMsgManager.a().b(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg_TAG", 4, "multiForwardSperate|checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    MultiMsgManager.a().b.clear();
    MultiMsgManager.a().b.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    a(MultiMsgManager.a().b, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, 1);
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramList = "0X80078B8";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      paramList = "0X80078B8";
      continue;
      paramList = "0X80078B9";
      continue;
      paramList = "0X80078BA";
    }
  }
  
  private void b(List<ChatMessage> paramList)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localActionSheet.addButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694394));
    localActionSheet.addButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694395));
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new MultiForwardHelper.1(this, paramList, localActionSheet));
    localActionSheet.show();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet = new AIOShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.b();
  }
  
  public void a(ChatAdapter1 paramChatAdapter1, boolean paramBoolean)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    do
    {
      return;
      paramChatAdapter1 = MultiMsgManager.a().a();
      paramChatAdapter1 = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramChatAdapter1);
    } while ((paramChatAdapter1 == null) || (paramChatAdapter1.size() == 0));
    if (paramBoolean)
    {
      a(paramChatAdapter1, 2);
      return;
    }
    b(paramChatAdapter1);
  }
  
  public void a(List<ChatMessage> paramList, int paramInt)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131692257, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a());
    }
    do
    {
      return;
      MultiMsgManager.a().b(paramList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e(2131698459);
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    String str;
    while (paramList.hasNext())
    {
      localObject2 = (ChatMessage)paramList.next();
      if ((localObject2 instanceof MessageForWriteTogether))
      {
        str = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2);
        localObject2 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject2, str, false);
        if (((ChatMessage)localObject2).senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a((MessageRecord)localObject2);
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
      str = MsgProxyUtils.a((ChatMessage)((Iterator)localObject2).next());
      if (!paramList.contains(str)) {
        paramList.add(str);
      }
    }
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject1);
    MultiMsgManager.a().jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramList, false, null);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
      localObject2 = ((MqqHandler)localObject1).obtainMessage(24);
      ((Message)localObject2).arg1 = paramList.size();
      ((MqqHandler)localObject1).sendMessageDelayed((Message)localObject2, 30000L);
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        paramList = "0X80078BB";
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break;
      }
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(paramList);
      break;
      paramList = "0X80078BB";
      continue;
      paramList = "0X80078BC";
      continue;
      paramList = "0X80078BD";
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList, int paramInt)
  {
    if (paramInt == 4) {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet != null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.b(paramMap, paramArrayList);
      }
    }
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet == null);
    this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a(paramMap, paramArrayList);
    return;
    Object localObject1 = " ";
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      label75:
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt == 1) {
        break label185;
      }
    }
    label185:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ChatActivityFacade.a((Context)localObject2, (String)localObject1, paramArrayList, paramMap, bool);
      if (localObject1 == null) {
        break;
      }
      if (paramInt != 2) {
        break label191;
      }
      MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, (AbsStructMsg)localObject1, 0L, false, paramInt);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label75;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
      break label75;
    }
    label191:
    ((AbsShareMsg)localObject1).mMsg_A_ActionData = null;
    paramMap = new Intent();
    paramMap.putExtra("forward_type", -3);
    paramMap.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    paramMap.putExtra("is_need_show_sources", false);
    paramMap.putExtra("forward_msg_from_together", paramInt);
    paramMap.putExtra("forward_source_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    localObject1 = new boolean[paramArrayList.size()];
    Object localObject2 = new int[paramArrayList.size()];
    String[] arrayOfString1 = new String[paramArrayList.size()];
    String[] arrayOfString2 = new String[paramArrayList.size()];
    int j = 0;
    int i = 0;
    if (j < paramArrayList.size())
    {
      ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(j);
      if ((paramInt == 1) && ((localChatMessage instanceof MessageForWriteTogether)))
      {
        localObject1[j] = 1;
        localObject2[j] = ((MessageForWriteTogether)localChatMessage).baseRev;
        arrayOfString1[j] = ((MessageForWriteTogether)localChatMessage).padId;
        arrayOfString2[j] = ((MessageForWriteTogether)localChatMessage).token;
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        localObject1[j] = 0;
        localObject2[j] = 0;
        arrayOfString1[j] = "";
        arrayOfString2[j] = "";
      }
    }
    paramMap.putExtra("forward_is_write_together", (boolean[])localObject1);
    paramMap.putExtra("forward_write_together_base_rev", (int[])localObject2);
    paramMap.putExtra("forward_write_together_pad_id", arrayOfString1);
    paramMap.putExtra("forward_write_together_token", arrayOfString2);
    paramMap.putExtra("forward_write_together_number", i);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, paramMap, 21);
  }
  
  public String getTag()
  {
    return "MultiForwardHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet == null);
    this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.c();
    this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper
 * JD-Core Version:    0.7.0.1
 */