import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.dataline.mpfile.MpfileTaskInfo;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.DatalineProxyService;
import cooperation.qqdataline.ipc.DatalineRemoteManager.1;
import cooperation.qqdataline.ipc.DatalineRemoteManager.11;
import cooperation.qqdataline.ipc.DatalineRemoteManager.2;
import cooperation.qqdataline.ipc.DatalineRemoteManager.7;
import cooperation.qqdataline.ipc.DatalineRemoteManager.8;
import cooperation.qqdataline.ipc.DatalineRemoteManager.9;
import cooperation.qqdataline.ipc.MessageRecordParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;

public class bfhb
  implements Observer
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new bfhg(this);
  bafb jdField_a_of_type_Bafb;
  public bfhh a;
  public QQAppInterface a;
  public ArrayList<Bundle> a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public bfhb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    h();
  }
  
  private Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      return null;
      str = paramBundle.getString("notify_cmd");
      if (this.jdField_a_of_type_Bfhh == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "mDatalineService not started strNotifyCmd:" + str);
        }
        b();
        return null;
      }
      g();
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "sendRemoteNotify send success strNotifyCmd:" + str);
        }
        paramBundle = this.jdField_a_of_type_Bfhh.a("com.qqdataline.action.notify", paramBundle);
        if (paramBundle != null) {
          paramBundle.setClassLoader(getClass().getClassLoader());
        }
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "sendRemoteNotify send failed strNotifyCmd:" + str);
    return null;
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = "";
    if (paramBundle != null) {
      localObject = paramBundle.getString("notify_cmd");
    }
    if (((String)localObject).equals("onReceiveRegisterProxySvcPack"))
    {
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!paramBundle.hasNext()) {
          break;
        }
        localObject = (Bundle)paramBundle.next();
      } while (!((Bundle)localObject).getString("notify_cmd").equals("onReceiveRegisterProxySvcPack"));
    }
    do
    {
      do
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
        return;
        while (!((String)localObject).equals("UpdateUnreadMsgsNum")) {}
        paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      } while (!paramBundle.hasNext());
      localObject = (Bundle)paramBundle.next();
    } while (!((Bundle)localObject).getString("notify_cmd").equals("UpdateUnreadMsgsNum"));
    this.jdField_a_of_type_JavaUtilArrayList.remove(localObject);
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    Object localObject = "";
    if (paramBundle != null) {
      localObject = paramBundle.getString("notify_cmd");
    }
    if (this.jdField_a_of_type_Bfhh == null) {
      if (((String)localObject).equals("onReceive")) {
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + (String)localObject + " no need cached");
        }
      }
    }
    do
    {
      return;
      if (paramBoolean) {
        b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + (String)localObject + " cached");
      }
      localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new DatalineRemoteManager.8(this, paramBundle));
        return;
      }
      a(paramBundle);
      this.jdField_a_of_type_JavaUtilArrayList.add(paramBundle);
      return;
      g();
      if (paramBundle != null) {}
      try
      {
        paramBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send success strNotifyCmd:" + (String)localObject);
        }
        this.jdField_a_of_type_Bfhh.a("com.qqdataline.action.notify", paramBundle);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send failed strNotifyCmd:" + (String)localObject);
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 2) {
      bfgt.a("0X800672B");
    }
    Object localObject;
    for (;;)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("notify_cmd", "authWifiphoto");
      ((Bundle)localObject).putInt("authresult", paramInt);
      localObject = a((Bundle)localObject);
      if (localObject != null) {
        break;
      }
      return false;
      if (paramInt == 1)
      {
        bfgt.a("0X800672C");
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
          if (localObject != null)
          {
            Message localMessage = ((MqqHandler)localObject).obtainMessage(1134022);
            localMessage.arg1 = 0;
            ((MqqHandler)localObject).sendMessage(localMessage);
          }
          localObject = new Intent();
          ((Intent)localObject).setAction("com.tencent.dataline.wifiphoto.ACTION_WIFIPHOTO_REFUSE_AUTH");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
        }
      }
    }
    return ((Bundle)localObject).getBoolean("result");
  }
  
  private Bundle b(Bundle paramBundle)
  {
    Object localObject1 = null;
    Object localObject2 = paramBundle.getString("invoke_cmd");
    long l1;
    int i;
    int j;
    if (((String)localObject2).equals("DatalineHandler_sendC2CMessage_ToService"))
    {
      l1 = paramBundle.getLong("uCookie");
      localObject1 = paramBundle.getString("toUin");
      i = paramBundle.getInt("c2cCmd");
      j = paramBundle.getInt("subCmd");
      int k = paramBundle.getInt("datalineCmd");
      localObject2 = paramBundle.getByteArray("bodyContent");
      long l2 = paramBundle.getLong("nSessionId");
      paramBundle = new Bundle();
      paramBundle.putParcelable("ToServiceMsg", ((ajgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a(l1, (String)localObject1, i, j, k, (byte[])localObject2, l2));
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return paramBundle;
            if (((String)localObject2).equals("BusinessHandler_sendPbReq"))
            {
              ((ajgm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).sendPbReq((ToServiceMsg)paramBundle.getParcelable("ToServiceMsg"));
              return null;
            }
            if (!((String)localObject2).equals("DataLineMsgProxy_getInitMpfileTaskRecordList")) {
              break;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
            paramBundle = (Bundle)localObject1;
          } while (localObject2 == null);
          localObject2 = ((akeq)localObject2).a();
          paramBundle = (Bundle)localObject1;
        } while (((List)localObject2).size() <= 0);
        paramBundle = new MessageRecordParcel[((List)localObject2).size()];
        i = 0;
        while (i < paramBundle.length)
        {
          paramBundle[i] = new MessageRecordParcel((MessageRecord)((List)localObject2).get(i));
          i += 1;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putParcelableArray("result", paramBundle);
        return localObject1;
        if (((String)localObject2).equals("DataLineMPfile_browserMpfileInfo"))
        {
          a((MpfileTaskInfo)paramBundle.getParcelable("taskInfo"), paramBundle.getLong("din"));
          return null;
        }
        if (!((String)localObject2).equals("DataLineWifiphoto_showWifiphotoBar")) {
          break;
        }
        i = paramBundle.getInt("what");
        j = paramBundle.getInt("status");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
        paramBundle = (Bundle)localObject1;
      } while (localObject2 == null);
      paramBundle = ((MqqHandler)localObject2).obtainMessage(i);
      paramBundle.arg1 = j;
      ((MqqHandler)localObject2).sendMessage(paramBundle);
      return null;
      if (((String)localObject2).equals("DataLineMsgProxy_add_DataLineMsgRecord"))
      {
        a((DataLineMsgRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).a(), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_add_MpfileTaskRecord"))
      {
        a((MpfileTaskRecord)((MessageRecordParcel)paramBundle.getParcelable("Entity")).a(), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_update"))
      {
        a(paramBundle.getString("tableName"), (ContentValues)paramBundle.getParcelable("value"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
        return null;
      }
      if (((String)localObject2).equals("DataLineMsgProxy_delete"))
      {
        a(paramBundle.getString("tableName"), paramBundle.getString("whereClause"), paramBundle.getStringArray("whereArgs"), null);
        return null;
      }
      boolean bool;
      if (((String)localObject2).equals("RouterHandler_datalineSendCCMsg"))
      {
        bool = RouterHandler.a(paramBundle.getLong("din"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", bool);
        return paramBundle;
      }
      if (((String)localObject2).equals("RouterHandler_datalineSendCSMsg"))
      {
        bool = RouterHandler.a(paramBundle.getInt("nUserCmd"), paramBundle.getInt("nCookie"), paramBundle.getByteArray("buffer"));
        paramBundle = new Bundle();
        paramBundle.putBoolean("result", bool);
        return paramBundle;
      }
      if (((String)localObject2).equals("RouterHandler_getSelfDeviceUin"))
      {
        l1 = RouterHandler.a();
        paramBundle = new Bundle();
        paramBundle.putLong("result", l1);
        return paramBundle;
      }
      if (((String)localObject2).equals("DatalineHandler_saveFileManagerEntity"))
      {
        localObject1 = paramBundle.getString("strFilePath");
        i = paramBundle.getInt("nOpType");
        l1 = paramBundle.getLong("sCurDIN");
        paramBundle = apck.a((String)localObject1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(-1L, (String)localObject2, 6000);
        localFileManagerEntity.nOpType = i;
        localFileManagerEntity.fileSize = apck.a((String)localObject1);
        localFileManagerEntity.isReaded = true;
        localFileManagerEntity.peerUin = ((String)localObject2);
        if (l1 == 0L) {}
        for (localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131628834);; localFileManagerEntity.peerNick = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131628846))
        {
          localFileManagerEntity.setFilePath((String)localObject1);
          localFileManagerEntity.srvTime = (awao.a() * 1000L);
          localFileManagerEntity.fileName = paramBundle;
          localFileManagerEntity.setCloudType(3);
          localFileManagerEntity.bSend = false;
          localFileManagerEntity.status = 1;
          localFileManagerEntity.fProgress = 1.0F;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity);
          return null;
        }
      }
      if (((String)localObject2).equals("DatalineHandler_showWifiphotoActivity"))
      {
        j();
        return null;
      }
      if (((String)localObject2).equals("BusinessHandler_makeSureProxyServiceStart"))
      {
        b();
        return null;
      }
      if (((String)localObject2).equals("DatalineHandler_showWifiphotoAuthDlg"))
      {
        c();
        return null;
      }
      if (((String)localObject2).equals("DatalineHandler_dismissReqAuthDlg"))
      {
        d();
        return null;
      }
      paramBundle = (Bundle)localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("DatalineRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
    return null;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Bfhh == null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "mDatalineService start service");
      }
      DatalineProxyService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentServiceConnection);
    }
  }
  
  private void c()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.1(this));
      return;
    }
    e();
  }
  
  private void d()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new DatalineRemoteManager.2(this));
      return;
    }
    f();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bafb != null) {
      return;
    }
    if (!BaseActivity.mAppForground)
    {
      a(3);
      return;
    }
    if (BaseActivity.sTopActivity == null)
    {
      a(3);
      return;
    }
    a(0);
    this.b = false;
    this.jdField_a_of_type_Bafb = babr.a(BaseActivity.sTopActivity, 230, ajjy.a(2131636972), ajjy.a(2131636976), 2131628983, 2131655020, new bfhd(this), new bfhe(this));
    this.jdField_a_of_type_Bafb.setOnDismissListener(new bfhf(this));
    TextView localTextView = (TextView)this.jdField_a_of_type_Bafb.findViewById(2131299579);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localTextView.setLayoutParams(localLayoutParams);
    localTextView.setMinHeight(azvv.a(BaseActivity.sTopActivity, 35.0F));
    localTextView.setGravity(17);
    this.jdField_a_of_type_Bafb.show();
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    for (;;)
    {
      return;
      Object localObject1 = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject1).getThread())
      {
        new Handler((Looper)localObject1).post(new DatalineRemoteManager.9(this));
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
          this.jdField_a_of_type_Bfhh.a("com.qqdataline.action.notify", localBundle);
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject1 = localObject2;
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + (String)localObject2);
        }
        catch (RemoteException localRemoteException)
        {
          localRemoteException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + (String)localObject1);
        }
      }
    }
  }
  
  private void h()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.register(new bfhc(this, "dataline.remotecall"));
  }
  
  private void i()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
      }
    }
    while (!localPluginCommunicationHandler.containsCmd("dataline.remotecall")) {
      return;
    }
    localPluginCommunicationHandler.unregister("dataline.remotecall");
  }
  
  private void j()
  {
    Object localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread()) {
      new Handler((Looper)localObject).post(new DatalineRemoteManager.11(this));
    }
    while (BaseActivity.sTopActivity == null) {
      return;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("string_from", true);
    ((Bundle)localObject).putBoolean("string_uin", false);
    ((Bundle)localObject).putLong("device_din", 0L);
    ((Bundle)localObject).putInt("sTitleID", 0);
    bfgz.a(BaseActivity.sTopActivity, (Bundle)localObject, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2130771997, 0);
  }
  
  public long a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "startConnectPC");
    localBundle.putInt("MPFPBtype", paramInt);
    localBundle = a(localBundle);
    if (localBundle == null) {
      return -1L;
    }
    return localBundle.getLong("result");
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTask");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    paramString1 = a(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public long a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3, long paramLong4, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "addMpFileDownloadTaskWithBuildConn");
    localBundle.putLong("taskId", paramLong1);
    localBundle.putLong("din", paramLong2);
    localBundle.putString("fileId", paramString1);
    localBundle.putString("fileName", paramString2);
    localBundle.putLong("totalSize", paramLong3);
    localBundle.putLong("startPCSessionID", paramLong4);
    localBundle.putInt("PC_Version", paramInt);
    paramString1 = a(localBundle);
    if (paramString1 == null) {
      return -1L;
    }
    return paramString1.getLong("result");
  }
  
  public long a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "setMpFileDownloadPwd");
    localBundle.putString("pwd", paramString);
    paramString = a(localBundle);
    if (paramString == null) {
      return -1L;
    }
    return paramString.getLong("result");
  }
  
  public bfha a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileServerInfo");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    bfha localbfha = new bfha();
    localbfha.jdField_a_of_type_JavaLangString = localBundle.getString("ServerInfo.serverIp");
    localbfha.jdField_a_of_type_Int = localBundle.getInt("ServerInfo.serverPort");
    return localbfha;
  }
  
  public MpfileTaskInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileDownloadTask");
    localBundle.putString("fileId", paramString);
    paramString = a(localBundle);
    if (paramString == null) {
      return null;
    }
    return (MpfileTaskInfo)paramString.getParcelable("result");
  }
  
  public String a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileThumbSaveFolder");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    i();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceiveRegisterProxySvcPack");
    localBundle.putInt("iPcOnlineStatus", paramInt1);
    localBundle.putInt("iIsSupportDataLine", paramInt2);
    localBundle.putInt("iIsSupportPrintable", paramInt3);
    localBundle.putInt("iIsSupportViewPCFile", paramInt4);
    localBundle.putLong("iPcVersion", paramLong);
    a(localBundle, false);
  }
  
  public void a(atmo paramatmo, akes paramakes)
  {
    if ((paramatmo instanceof DataLineMsgRecord)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramatmo, paramakes);
    }
    while (!(paramatmo instanceof MpfileTaskRecord)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((MpfileTaskRecord)paramatmo);
  }
  
  public void a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = apck.a(paramMpfileTaskInfo, paramLong);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    if (apck.b(localFileManagerEntity.getFilePath())) {
      localForwardFileInfo.b(10000);
    }
    for (;;)
    {
      localForwardFileInfo.d(7);
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
      localForwardFileInfo.c(paramMpfileTaskInfo.jdField_d_of_type_Long);
      localForwardFileInfo.d(paramMpfileTaskInfo.b);
      localForwardFileInfo.a(paramMpfileTaskInfo.e);
      paramMpfileTaskInfo = Looper.getMainLooper();
      if (Thread.currentThread() == paramMpfileTaskInfo.getThread()) {
        break;
      }
      new Handler(paramMpfileTaskInfo).post(new DatalineRemoteManager.7(this, localFileManagerEntity, localForwardFileInfo));
      return;
      localForwardFileInfo.b(10009);
    }
    paramMpfileTaskInfo = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), FileBrowserActivity.class);
    paramMpfileTaskInfo.addFlags(268435456);
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(localFileManagerEntity.nSessionId));
      paramMpfileTaskInfo.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    paramMpfileTaskInfo.putExtra("fileinfo", localForwardFileInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().startActivity(paramMpfileTaskInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "onReceive");
    if (paramToServiceMsg != null) {
      localBundle.putParcelable("ToServiceMsg", paramToServiceMsg);
    }
    if (paramFromServiceMsg != null) {
      localBundle.putParcelable("FromServiceMsg", paramFromServiceMsg);
    }
    if (paramArrayOfByte != null) {
      localBundle.putByteArray("data", paramArrayOfByte);
    }
    a(localBundle, true);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "cancelMpfile");
    localBundle.putString("strDataLineMPFileID", paramString);
    a(localBundle);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, akes paramakes)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramakes);
    }
    while (!paramString1.equals(MpfileTaskRecord.tableName())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramContentValues, paramString2, paramArrayOfString, paramakes);
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, akes paramakes)
  {
    if (paramString1.equals(DataLineMsgRecord.tableName())) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0).a(paramString1, paramString2, paramArrayOfString, paramakes);
    }
    while (!paramString1.equals(MpfileTaskRecord.tableName())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString1, paramString2, paramArrayOfString, paramakes);
  }
  
  public void a(msg_comm.Msg paramMsg)
  {
    paramMsg = paramMsg.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "handleDataLinePushMsg_210");
    localBundle.putByteArray("msgBytes", paramMsg);
    a(localBundle, true);
  }
  
  public void a(msg_comm.Msg paramMsg, SubMsgType0x7.MsgBody paramMsgBody)
  {
    paramMsg = paramMsg.toByteArray();
    paramMsgBody = paramMsgBody.toByteArray();
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "DoCCPush");
    localBundle.putByteArray("msgBytes", paramMsg);
    localBundle.putByteArray("ccBytes", paramMsgBody);
    a(localBundle, true);
  }
  
  public boolean a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getIsNeedReCreateConnection");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("result");
  }
  
  public String b()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("notify_cmd", "getMpFileSaveFolder");
    localBundle = a(localBundle);
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString("result");
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (paramObservable != null)
    {
      int i = paramObservable.b();
      paramObservable = new Bundle();
      paramObservable.putString("notify_cmd", "UpdateUnreadMsgsNum");
      paramObservable.putInt("unread", i);
      a(paramObservable, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfhb
 * JD-Core Version:    0.7.0.1
 */