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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

public class SeparateForward
  implements Handler.Callback
{
  public int a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new SeparateForward.1(this);
  public QQAppInterface a;
  TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new SeparateForward.2(this);
  public QQProgressDialog a;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private String jdField_a_of_type_JavaLangString;
  public WeakReference<BaseActivity> a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public SeparateForward(BaseActivity paramBaseActivity, int paramInt)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_Int = paramInt;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
    }
    paramBaseActivity = paramBaseActivity.getIntent();
    this.jdField_b_of_type_Int = paramBaseActivity.getIntExtra("uintype", -1);
    this.jdField_a_of_type_JavaLangString = paramBaseActivity.getStringExtra("uin");
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public void a(Intent paramIntent)
  {
    if (StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes")) == null) {
      return;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", 0);
    localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    localSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    paramIntent = MultiMsgManager.a();
    paramIntent.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramIntent.a);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    Object localObject = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = MultiMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)paramList);
    MultiMsgManager.a().b(paramList);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((BaseActivity)localObject).getTitleBarHeight());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131698459);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject).next();
      if (!localArrayList.contains(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage.senderuin);
      }
    }
    MultiMsgManager.a().a.clear();
    MultiMsgManager.a().a.addAll(paramList);
    if (this.jdField_b_of_type_Int == 1) {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(this.jdField_a_of_type_JavaLangString, localArrayList, false, null);
    }
    for (;;)
    {
      paramList = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(1);
      paramList.arg1 = localArrayList.size();
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessageDelayed(paramList, 30000L);
      return;
      if ((this.jdField_b_of_type_Int == 0) || (this.jdField_b_of_type_Int == 3000)) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendNickByBatch(localArrayList);
      }
    }
  }
  
  public void a(Map<String, String> paramMap, ArrayList<ChatMessage> paramArrayList)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localBaseActivity == null)
    {
      QLog.e("SeparateForward", 1, "sendMultiMsg, activity recyled");
      return;
    }
    String str = " ";
    if (this.jdField_b_of_type_Int == 0) {}
    for (str = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);; str = this.jdField_b_of_type_JavaLangString) {
      do
      {
        paramMap = ChatActivityFacade.a(localBaseActivity, str, paramArrayList, paramMap, true);
        if (paramMap == null) {
          break;
        }
        paramMap.mMsg_A_ActionData = null;
        paramArrayList = new Intent();
        paramArrayList.putExtra("forward_type", -3);
        paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
        paramArrayList.putExtra("is_need_show_sources", false);
        paramArrayList.putExtra("forward_msg_from_together", 1);
        paramArrayList.putExtra("forwardDirect", true);
        ForwardBaseOption.a(localBaseActivity, paramArrayList, this.jdField_a_of_type_Int);
        return;
      } while ((this.jdField_b_of_type_Int != 1) && (this.jdField_b_of_type_Int != 3000));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      paramMessage = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (paramMessage == null));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(paramMessage, 2131698461, 0).b(paramMessage.getResources().getDimensionPixelSize(2131299166));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.SeparateForward
 * JD-Core Version:    0.7.0.1
 */