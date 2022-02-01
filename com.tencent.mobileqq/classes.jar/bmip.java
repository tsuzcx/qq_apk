import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost.3;
import cooperation.smartdevice.ipc.SmartDeviceIPCHost.4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class bmip
  implements Observer
{
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bmir(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new bmiq(this, Looper.getMainLooper());
  public bmim a;
  public QQAppInterface a;
  public ArrayList<Bundle> a;
  public boolean a;
  
  public bmip(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    }
    for (;;)
    {
      c();
      d();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost() construct!!!!! error: app == null");
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bmim == null) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service now");
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 300000L);
      absy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Host", 0, 0, 0);
      bmij.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void e()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    do
    {
      do
      {
        return;
      } while (!localPluginCommunicationHandler.containsCmd("com.qqsmartdevice.remotecall"));
      localPluginCommunicationHandler.unregister("com.qqsmartdevice.remotecall");
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::unregisterRemoteCommand unregister CMD:com.qqsmartdevice.remotecall");
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = null;
    }
    for (;;)
    {
      return paramBundle;
      String str = paramBundle.getString("notify_cmd");
      if ((this.jdField_a_of_type_Bmim == null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        boolean bool = paramBundle.getBoolean("forceStart", false);
        paramBundle = (abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
        if ((bool) || ((paramBundle != null) && (paramBundle.a())))
        {
          QLog.d("SmartDeviceIPCHost", 1, "start plugin service when send " + str);
          d();
        }
        return null;
      }
      b();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        Bundle localBundle = this.jdField_a_of_type_Bmim.a("com.qqsmartdevice.action.notify", paramBundle);
        paramBundle = localBundle;
        if (localBundle != null)
        {
          localBundle.setClassLoader(getClass().getClassLoader());
          return localBundle;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "plugin service transfer failed strNotifyCmd:" + str);
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnDestory");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    e();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "params is null");
      }
    }
    Object localObject;
    do
    {
      boolean bool;
      abgm localabgm;
      do
      {
        return;
        localObject = paramBundle.getString("notify_cmd");
        if ((this.jdField_a_of_type_Bmim != null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "plugin service not started strNotifyCmd:" + (String)localObject + " cached");
        }
        bool = paramBundle.getBoolean("forceStart", false);
        localabgm = (abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      } while ((!bool) && ((localabgm == null) || (!localabgm.a())));
      QLog.d("SmartDeviceIPCHost", 1, "start plugin service when post " + (String)localObject);
      d();
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new SmartDeviceIPCHost.3(this, paramBundle));
        return;
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
      b();
      return;
      b();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        this.jdField_a_of_type_Bmim.a("com.qqsmartdevice.action.notify", paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("SmartDeviceIPCHost", 2, " plugin service transfer failed strNotifyCmd:" + (String)localObject);
  }
  
  public Bundle b(Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("invoke_cmd");
    if ((QLog.isColorLevel()) && (!"invokeCmdGetFaceBitmap".equals(localObject))) {
      QLog.i("SmartDeviceIPCHost", 2, "SmartDeviceIPCHost::OnRemoteInvoke strNotifyCmd:" + (String)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return null;
    }
    if (((String)localObject).compareToIgnoreCase("invokeCmdOpenChatMsgActivity") == 0)
    {
      ((abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramBundle);
      return null;
    }
    if (((String)localObject).equals("SmartDeviceHandler_makeSureProxyServiceStart"))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEFILE_HANDLER);
      if (this.jdField_a_of_type_Bmim != null)
      {
        absy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Remote", 0, 1, 0);
        return null;
      }
      this.jdField_a_of_type_Boolean = false;
      QLog.d("SmartDeviceIPCHost", 1, "try to start service again");
      d();
      absy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Net_Start_Service_Remote", 0, 0, 0);
      return null;
    }
    if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoChat") == 0)
    {
      if (!paramBundle.containsKey("devSubCode")) {
        break label733;
      }
      localObject = new HashMap();
      ((Map)localObject).put("devSubCode", paramBundle.getString("devSubCode"));
    }
    for (;;)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), 9500, paramBundle.getString("din"), paramBundle.getString("devName"), "", paramBundle.getBoolean("onlyAudio", false), paramBundle.getString("tinyid"), true, false, null, "from_internal", (Map)localObject);
      return null;
      if (((String)localObject).compareToIgnoreCase("invokeCmdStartVideoMessage") == 0)
      {
        abht.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramBundle.getString("din"), paramBundle.getString("videoPath"));
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetBuddyName") == 0)
      {
        paramBundle = paramBundle.getString("Uin");
        paramBundle = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, true);
        localObject = new Bundle();
        ((Bundle)localObject).putString("BuddyName", paramBundle);
        return localObject;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdTransFileController") == 0)
      {
        ((abgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b(paramBundle);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetLockState") == 0)
      {
        i = asll.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication());
        paramBundle = new Bundle();
        paramBundle.putInt("LockState", i);
        return paramBundle;
      }
      if (((String)localObject).compareToIgnoreCase("qfind_localnotify") == 0)
      {
        long l = paramBundle.getLong("din");
        paramBundle = paramBundle.getString("msg");
        localObject = (MessageForText)bcsa.a(-1000);
        ((MessageForText)localObject).msgtype = -1000;
        ((MessageForText)localObject).istroop = 9501;
        ((MessageForText)localObject).issend = 0;
        ((MessageForText)localObject).isread = false;
        ((MessageForText)localObject).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ((MessageForText)localObject).senderuin = (l + "");
        ((MessageForText)localObject).frienduin = (l + "");
        ((MessageForText)localObject).msg = paramBundle;
        ((MessageForText)localObject).time = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a((MessageRecord)localObject);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("init_msgHandler") == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
        return null;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetFaceBitmap") == 0)
      {
        paramBundle = paramBundle.getString("uin");
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramBundle, true);
        localObject = new Bundle();
        ((Bundle)localObject).putParcelable("face_bitmap", paramBundle);
        return localObject;
      }
      if (((String)localObject).compareToIgnoreCase("invokeCmdGetUnreadMsgNum") != 0) {
        break;
      }
      paramBundle = paramBundle.getString("din");
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramBundle, 9501);
      paramBundle = new Bundle();
      paramBundle.putInt("unread", i);
      return paramBundle;
      label733:
      localObject = null;
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_Bmim == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject1).getThread())
      {
        new Handler((Looper)localObject1).post(new SmartDeviceIPCHost.4(this));
        return;
      }
      while (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        Bundle localBundle = (Bundle)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        localObject1 = "";
        Object localObject2 = localObject1;
        if (localBundle != null) {}
        try
        {
          localObject2 = localBundle.getString("notify_cmd");
          localObject1 = localObject2;
          localBundle.setClassLoader(getClass().getClassLoader());
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject2;
            QLog.d("SmartDeviceIPCHost", 2, "qq->plugin main thread doPostCachedMsg strNotifyCmd:" + (String)localObject2 + " thread:" + Thread.currentThread());
          }
          localObject1 = localObject2;
          this.jdField_a_of_type_Bmim.a("com.qqsmartdevice.action.notify", localBundle);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("SmartDeviceIPCHost", 2, "mSmartDeviceService.transfer failed strNotifyCmd:" + (String)localObject1);
        }
      }
    }
  }
  
  public void c()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmartDeviceIPCHost", 2, "PluginCommunicationHandler.getInstance failed");
      }
      return;
    }
    localPluginCommunicationHandler.register(new bmis(this, "com.qqsmartdevice.remotecall"));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((paramObservable.istroop == 9501) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramObservable.frienduin, 9501) > 0))
      {
        paramObservable = new Bundle();
        paramObservable.putString("notify_cmd", "updateUnreadMsgsNum");
        a(paramObservable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmip
 * JD-Core Version:    0.7.0.1
 */