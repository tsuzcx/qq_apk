package com.tencent.av;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.core.DeviceSharpController;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.SeqUtil;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.avcore.netchannel.INetChannel;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class QavChannelProxy
  extends AbstractNetChannel
  implements INetChannel, INetChannelCallback
{
  public int a;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  public DeviceSharpController a;
  public String a;
  public int b = 0;
  
  public QavChannelProxy(VideoController paramVideoController)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController = null;
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    VideoProcessExitMonitor localVideoProcessExitMonitor;
    do
    {
      return;
      localVideoProcessExitMonitor = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    } while (localVideoProcessExitMonitor == null);
    localVideoProcessExitMonitor.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
      SmartDeviceReport.a(null, "Usr_TV_Video", 4, 0, 0);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "send0x265 --> Send 0x265 openId = " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", localArrayList);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramLong1);
    localNewIntent.putExtra("groupuin", paramLong2);
    localNewIntent.putExtra("groupcode", paramLong3);
    localNewIntent.putExtra("reqType", 12);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("selfuin", paramBoolean);
    localNewIntent.putExtra("groupuin", paramLong1);
    localNewIntent.putExtra("groupcode", paramLong2);
    localNewIntent.putExtra("reqType", 13);
    a(localNewIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("fromUin");
    this.b = ((int)(System.currentTimeMillis() / 1000L));
  }
  
  public void a(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController = new DeviceSharpController(this, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    SessionMgr.a().a().j = 9500;
    QLog.i("QavNetChannel", 1, "initDeviceSharp, device: " + this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController + ", from: " + paramString);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("QavNetChannel", 1, "sendMultiVideoMsg, cmsCmd[" + paramLong2 + "], seq[" + l + "]");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("ver", (byte)0);
    localNewIntent.putExtra("type", (byte)1);
    localNewIntent.putExtra("cscmd", (short)(int)paramLong2);
    localNewIntent.putExtra("selfuin", CharacterUtil.a(paramString));
    localNewIntent.putExtra("toUin", paramLong1);
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    localNewIntent.putExtra("reqType", 8);
    SeqUtil.a(localNewIntent, l);
    a(localNewIntent);
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    while ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendSharpMsg selfUin: " + paramString + ", toUin: " + CharacterUtil.a(paramLong) + ", uinType = " + localSessionInfo.j);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    if (localSessionInfo.j == 25) {
      localNewIntent.putExtra("reqType", 18);
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      localNewIntent.putExtra("selfuin", CharacterUtil.a(paramString));
      localNewIntent.putExtra("toUin", paramLong);
      localNewIntent.putExtra("vMsg", paramArrayOfByte);
      a(localNewIntent);
      return;
      localNewIntent.putExtra("reqType", 4);
    }
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    while ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendVideoConfigReqMsg: buf[2] = " + paramArrayOfByte[2]);
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 3);
    localNewIntent.putExtra("selfuin", paramString1);
    localNewIntent.putExtra("toUin", VideoPackageUtils.a(paramString2));
    localNewIntent.putExtra("vMsg", paramArrayOfByte);
    a(localNewIntent);
  }
  
  public void a(ArrayList<Long> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      return;
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QavNetChannel", 2, "send0x265 --> tinyIDList is null Or size is 0");
    return;
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", paramArrayList);
    a(localNewIntent);
  }
  
  public void a(NewIntent paramNewIntent)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      QLog.w("QavNetChannel", 1, "sendMsg, Exception", paramNewIntent);
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null;
  }
  
  public boolean a(String paramString)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = this.b;
    return (this.jdField_a_of_type_JavaLangString != null) && (paramString != null) && (this.jdField_a_of_type_JavaLangString.equals(paramString)) && (i - j < 3);
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.b = 0;
  }
  
  public void c()
  {
    QLog.i("QavNetChannel", 1, "clearDeviceSharp, device: " + this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController);
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController != null) {
      this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController = null;
    }
  }
  
  public void receiveDeviceMsg(Bundle paramBundle)
  {
    if ((paramBundle == null) || (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null)) {}
    do
    {
      return;
      paramBundle = paramBundle.getByteArray("buffer");
    } while (paramBundle == null);
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null) {
      SmartDeviceReport.a(null, "Usr_TV_Video", 2, 0, 0);
    }
    a("receiveDeviceMsg");
    if (QLog.isColorLevel()) {
      QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
    }
    receiveSharpVideoCall(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramBundle, null);
  }
  
  public void receiveMultiVideoAck(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoAck buf=%s", new Object[] { paramBundle }));
    }
    d();
    this.jdField_a_of_type_ComTencentAvVideoController.H();
    ThreadManager.executeOnSubThread(new QavChannelProxy.1(this, paramBundle));
  }
  
  public void receiveMultiVideoMsg(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoMsg buf=%s", new Object[] { paramBundle }));
    }
    d();
    this.jdField_a_of_type_ComTencentAvVideoController.H();
    receiveMultiVideoMsg(1, paramBundle);
  }
  
  public void receiveMultiVideoOfflineMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    d();
    if (this.jdField_a_of_type_ComTencentAvVideoController.d) {
      return;
    }
    paramBundle = paramBundle.getByteArray("buffer");
    this.jdField_a_of_type_ComTencentAvVideoController.H();
    receiveMultiVideoMsg(3, paramBundle);
  }
  
  public void receiveSharpVideoAck(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    int i;
    do
    {
      return;
      d();
      paramBundle = paramBundle.getByteArray("buffer");
      i = receiveSharpVideoAck(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), paramBundle, null);
    } while (!QLog.isColorLevel());
    QLog.d("QavNetChannel", 2, "receiveSharpVideoAck: result = " + i);
  }
  
  public void receiveSharpVideoMsg(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    String str;
    do
    {
      do
      {
        return;
        d();
        byte[] arrayOfByte = paramBundle.getByteArray("buffer");
        str = paramBundle.getString("fromUin");
        boolean bool = paramBundle.getBoolean("isFriend");
        int i = receiveSharpVideoCall(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
        if (QLog.isColorLevel()) {
          QLog.d("QavNetChannel", 2, "receiveSharpVideoMsg: selfUin = " + this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin() + ", fromUin = " + str + ", result = " + i + ",isFriend:" + bool);
        }
        this.jdField_a_of_type_Int = 0;
        paramBundle = SessionMgr.a().a();
      } while ((paramBundle.j != 1006) || (paramBundle.e) || (TextUtils.equals(str, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())));
      paramBundle.f = str;
    } while (!QLog.isColorLevel());
    QLog.d("QavNetChannel", 2, "receiveSharpVideoMsg: CONTACT_STRANGER_FRIEND  peerUin = " + str);
  }
  
  public void receiveSharpVideoOfflineMsg(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QavNetChannel", 2, String.format("receiveSharpVideoOfflineMsg data=%s", new Object[] { paramBundle }));
      }
      d();
      byte[] arrayOfByte = paramBundle.getByteArray("buffer");
      bool = paramBundle.getBoolean("isRequest");
      a(paramBundle);
      long l = paramBundle.getLong("msf_timestamp");
      paramBundle = paramBundle.getString("fromUin");
      this.jdField_a_of_type_ComTencentAvVideoController.a(paramBundle, l);
      QLog.d("QavNetChannel", 1, "quaReport --> receiveSharpVideoOfflineMsg msf_timestamp = " + l);
      int i = receiveSharpVideoCall(Long.valueOf(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()).longValue(), arrayOfByte, null);
      if (QLog.isColorLevel()) {
        QLog.d("QavNetChannel", 2, "receiveSharpVideoCall result: " + i + ", buf.length: " + arrayOfByte.length);
      }
    } while ((!bool) || (this.jdField_a_of_type_Int != -1));
    this.jdField_a_of_type_Int = 1;
  }
  
  public void receiveVideoConfig(Bundle paramBundle) {}
  
  public void sendGetGatewayMsg()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendGetGatewayMsg");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void sendGetVideoConfig(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().a();
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), localSessionInfo.d, paramArrayOfByte);
  }
  
  public void sendLogReportMsg(long paramLong, byte[] paramArrayOfByte) {}
  
  public void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {
      return;
    }
    VideoPackageUtils.a(paramArrayOfByte);
    if (this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController == null)
    {
      ReportController.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController.b(paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.QavChannelProxy
 * JD-Core Version:    0.7.0.1
 */