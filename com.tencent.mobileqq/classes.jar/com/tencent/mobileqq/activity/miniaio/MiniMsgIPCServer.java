package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class MiniMsgIPCServer
  extends QIPCModule
  implements Handler.Callback
{
  private static MiniMsgIPCServer jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private MiniMsgIPCServer.MiniProcInfo jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
  private boolean jdField_a_of_type_Boolean = false;
  private MiniMsgIPCServer.MiniProcInfo b;
  private MiniMsgIPCServer.MiniProcInfo c;
  
  private MiniMsgIPCServer()
  {
    super("MiniMsgIPCServer");
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("mini_msg", 0);
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  public static MiniMsgIPCServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer == null) {
          jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer = new MiniMsgIPCServer();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer;
  }
  
  public static void a(int paramInt)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      ((MiniMsgHandler)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.MINIMSG_HANDLER)).a(Integer.valueOf(paramInt));
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    String str = paramBundle.getString("preview");
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).performUploadArkShareImage(str, new MiniMsgIPCServer.1(this, paramBundle, paramInt));
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "actionMiniCreateUpdatableMsgCallback", paramBundle, null);
    }
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((l2 > l1) && (l2 - l1 < 5000L)) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
    QQAppInterface localQQAppInterface = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
    if ((localQQAppInterface != null) && (localMiniProcInfo != null))
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      paramBundle = localQQAppInterface.getMessageFacade();
      int i;
      if (paramBundle != null) {
        i = paramBundle.c();
      } else {
        i = 0;
      }
      localBundle.putInt("param_cmd", 0);
      localBundle.putInt("param_proc_badge_count", i);
      paramBundle = new EIPCResult();
      paramBundle.data = localBundle;
      callbackResult(paramInt, paramBundle);
      localBundle.putInt("param_proc_badge_count", i);
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_sync_unreadcount", localBundle, null);
      if (this.c != null) {
        QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "action_sync_unreadcount", localBundle, null);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("doNotifyUnreadState unread = ");
        paramBundle.append(i);
        QLog.d("MiniMsgIPCServer", 2, paramBundle.toString());
      }
    }
  }
  
  private void b(Bundle paramBundle)
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "actionMiniReportEvent", paramBundle, null);
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo != null)
    {
      String str1 = paramBundle.getString("param_proc_name");
      String str2 = paramBundle.getString("param_proc_modulename");
      paramBundle.getString("param_proc_businame");
      if ((str1 != null) && (str1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo.a())) && (str2 != null) && (str2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo.b()))) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private void d(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("param_proc_name");
    String str1 = paramBundle.getString("param_proc_modulename");
    int i = paramBundle.getInt("param_proc_businame");
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo = new MiniMsgIPCServer.MiniProcInfo(str2, str1);
    this.b = new MiniMsgIPCServer.MiniProcInfo(str2, "aio_client_module");
    if (("mini_app_client_module".equals(str1) | "mini_sdk_client_module".equals(str1))) {
      this.c = new MiniMsgIPCServer.MiniProcInfo(str2, str1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo.a = i;
    this.jdField_a_of_type_Boolean = true;
    boolean bool = paramBundle.getBoolean("param_proc_first_start", false);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append(str2);
      paramBundle.append("doOnProcForeGround isFirst = ");
      paramBundle.append(bool);
      QLog.d("MiniMsgIPCServer", 2, paramBundle.toString());
      paramBundle = new StringBuilder();
      paramBundle.append("moduleName:");
      paramBundle.append(str1);
      QLog.d("MiniMsgIPCServer", 2, paramBundle.toString());
    }
    if (bool) {
      a();
    }
  }
  
  private void e()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "actionMiniDirectShareFailCallback", null, null);
    }
  }
  
  private void e(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("param_proc_uin");
    int j = paramBundle.getInt("param_proc_uin_type");
    paramBundle = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.b;
    if ((paramBundle != null) && (localMiniProcInfo != null))
    {
      paramBundle = paramBundle.getMessageFacade();
      int i;
      if (paramBundle != null) {
        i = paramBundle.a(j, str);
      } else {
        i = 0;
      }
      paramBundle = new Bundle();
      paramBundle.putString("param_proc_uin", str);
      paramBundle.putInt("param_proc_uin_type", j);
      paramBundle.putInt("param_proc_single_con_badge_count", i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doNotifySingleConUnreadState uin = ");
        localStringBuilder.append(str);
        localStringBuilder.append("; unread = ");
        localStringBuilder.append(i);
        QLog.d("mini_msg_IPCServer", 2, localStringBuilder.toString());
      }
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_sync_single_con_unread_count", paramBundle, null);
      if (this.c != null) {
        QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "action_sync_single_con_unread_count", paramBundle, null);
      }
    }
  }
  
  private void f()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "actionMiniDirectShareSucCallback", null, null);
    }
  }
  
  private void g()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "actionMiniShareSucCallback", null, null);
    }
  }
  
  private void h()
  {
    if (this.c != null) {
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "actionMiniShareFailCallback", null, null);
    }
  }
  
  private void i()
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    if ((l2 > l1) && (l2 - l1 < 5000L)) {
      return;
    }
    this.jdField_a_of_type_Long = l1;
    Object localObject = null;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
    if ((localObject != null) && (localMiniProcInfo != null))
    {
      localObject = ((QQAppInterface)localObject).getMessageFacade();
      int i;
      if (localObject != null) {
        i = ((QQMessageFacade)localObject).c();
      } else {
        i = 0;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_proc_badge_count", i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doNotifyUnreadState unread = ");
        localStringBuilder.append(i);
        QLog.d("mini_msg_IPCServer", 2, localStringBuilder.toString());
      }
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_sync_unreadcount", (Bundle)localObject, null);
      if (this.c != null) {
        QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(this.c), MiniMsgIPCServer.MiniProcInfo.b(this.c), "action_sync_unreadcount", (Bundle)localObject, null);
      }
    }
  }
  
  private void j()
  {
    Object localObject;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject = null;
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
    if ((localObject != null) && (localMiniProcInfo != null))
    {
      localObject = new Bundle();
      if (QLog.isColorLevel()) {
        QLog.d("mini_msg_IPCServer", 2, "doNotifyGoToConversation  ");
      }
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_mini_msgtab_notify_to_conversation", (Bundle)localObject, null);
    }
  }
  
  private void k()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
    Object localObject = ((QQAppInterface)localObject).getMessageFacade();
    int i;
    if (localObject != null) {
      i = ((QQMessageFacade)localObject).c();
    } else {
      i = 0;
    }
    if (localMiniProcInfo != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_proc_badge_count", i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doNotifyUnreadState unread = ");
        localStringBuilder.append(i);
        QLog.d("MiniMsgIPCServer", 2, localStringBuilder.toString());
      }
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_msg_tab_back_refresh", (Bundle)localObject, null);
    }
  }
  
  private void l()
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
    Object localObject = ((QQAppInterface)localObject).getMessageFacade();
    int i;
    if (localObject != null) {
      i = ((QQMessageFacade)localObject).c();
    } else {
      i = 0;
    }
    if (localMiniProcInfo != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_proc_badge_count", i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyGetUnread unread = ");
        localStringBuilder.append(i);
        QLog.d("mini_msg_IPCServer", 2, localStringBuilder.toString());
      }
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_get_unread", (Bundle)localObject, null);
    }
  }
  
  public MiniMsgIPCServer.MiniProcInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  void a(String paramString, int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_proc_uin", paramString);
    localBundle.putInt("param_proc_uin_type", paramInt);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void c()
  {
    j();
  }
  
  public void d()
  {
    Object localObject;
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      localObject = null;
    }
    MiniMsgIPCServer.MiniProcInfo localMiniProcInfo = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer$MiniProcInfo;
    if ((localObject != null) && (localMiniProcInfo != null))
    {
      localObject = new Bundle();
      if (QLog.isColorLevel()) {
        QLog.d("MiniMsgIPCServer", 2, "notifyFromMiniAIOToAIO ");
      }
      QIPCServerHelper.getInstance().callClient(MiniMsgIPCServer.MiniProcInfo.a(localMiniProcInfo), MiniMsgIPCServer.MiniProcInfo.b(localMiniProcInfo), "action_mini_aio_to_aio", (Bundle)localObject, null);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 15: 
      a(paramMessage.arg1, (Bundle)paramMessage.obj);
      break;
    case 14: 
      a((Bundle)paramMessage.obj);
      break;
    case 13: 
      e();
      break;
    case 12: 
      f();
      break;
    case 11: 
      e(paramMessage.getData());
      break;
    case 10: 
      b((Bundle)paramMessage.obj);
      break;
    case 9: 
      j();
      break;
    case 8: 
      l();
      break;
    case 7: 
      h();
      break;
    case 6: 
      g();
      break;
    case 5: 
      k();
      break;
    case 4: 
      if (MiniMsgTabServerInitStep.jdField_a_of_type_Boolean)
      {
        b(paramMessage.arg1, (Bundle)paramMessage.obj);
      }
      else if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("isAfterActionB = ");
        paramMessage.append(MiniMsgTabServerInitStep.jdField_a_of_type_Boolean);
        QLog.d("MiniMsgIPCServer", 2, paramMessage.toString());
      }
      break;
    case 3: 
      if (MiniMsgTabServerInitStep.jdField_a_of_type_Boolean)
      {
        i();
      }
      else if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("isAfterActionB = ");
        paramMessage.append(MiniMsgTabServerInitStep.jdField_a_of_type_Boolean);
        QLog.d("MiniMsgIPCServer", 2, paramMessage.toString());
      }
      break;
    case 2: 
      c((Bundle)paramMessage.obj);
      break;
    case 1: 
      d((Bundle)paramMessage.obj);
    }
    return true;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ((QLog.isColorLevel()) && (paramBundle != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MiniMsgIPCServer : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt);
      QLog.d("MiniMsgIPCServer", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    Object localObject = Message.obtain();
    ((Message)localObject).obj = paramBundle;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equalsIgnoreCase("cmd_proc_foregound"))
      {
        ((Message)localObject).what = 1;
      }
      else if (paramString.equalsIgnoreCase("cmd_proc_backgound"))
      {
        ((Message)localObject).what = 2;
      }
      else if (paramString.equalsIgnoreCase("cmd_refresh_mini_badge"))
      {
        ((Message)localObject).what = 4;
        ((Message)localObject).arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_msg_tab_back_refresh"))
      {
        ((Message)localObject).what = 8;
        ((Message)localObject).arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_suc"))
      {
        ((Message)localObject).what = 6;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_fail"))
      {
        ((Message)localObject).what = 7;
      }
      else if (paramString.equalsIgnoreCase("cmd_get_unread"))
      {
        ((Message)localObject).what = 8;
        ((Message)localObject).arg1 = paramInt;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_clear_business"))
      {
        if (paramBundle != null) {
          a(paramBundle.getInt("PARAM_CMD_BUSIID"));
        }
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_report_event"))
      {
        ((Message)localObject).what = 10;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_direct_share_suc"))
      {
        ((Message)localObject).what = 12;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_direct_share_fail"))
      {
        ((Message)localObject).what = 13;
      }
      else if (paramString.equals("cmd_mini_create_updatable_msg_callback"))
      {
        ((Message)localObject).what = 14;
      }
      else if (paramString.equalsIgnoreCase("cmd_mini_share_upload_image"))
      {
        ((Message)localObject).what = 15;
        ((Message)localObject).arg1 = paramInt;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgIPCServer
 * JD-Core Version:    0.7.0.1
 */