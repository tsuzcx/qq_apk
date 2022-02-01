package com.tencent.av;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.DeviceSharpController;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.SeqUtil;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.avcore.netchannel.INetChannel;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class QavChannelProxy
  extends AbstractNetChannel
  implements INetChannel, INetChannelCallback
{
  public int a = -1;
  public String b = null;
  public int c = 0;
  public DeviceSharpController d = null;
  private BaseVideoAppInterface e;
  private QavChannelProxy.IChannelCallback f;
  
  public QavChannelProxy(QavChannelProxy.IChannelCallback paramIChannelCallback)
  {
    this.f = paramIChannelCallback;
  }
  
  private void e()
  {
    QavChannelProxy.IChannelCallback localIChannelCallback = this.f;
    if (localIChannelCallback != null) {
      localIChannelCallback.c();
    }
  }
  
  public void a()
  {
    if (this.d != null) {
      ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).smartDeviceReportAccept();
    }
  }
  
  public void a(long paramLong)
  {
    if (this.e == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send0x265 --> Send 0x265 openId = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("QavNetChannel", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(Long.valueOf(paramLong));
    NewIntent localNewIntent = new NewIntent(this.e.getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
    localNewIntent.putExtra("reqType", 15);
    localNewIntent.putExtra("tinyid_list", (Serializable)localObject);
    a(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = new NewIntent(((BaseVideoAppInterface)localObject).getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
    ((NewIntent)localObject).putExtra("ver", (byte)0);
    ((NewIntent)localObject).putExtra("type", (byte)1);
    ((NewIntent)localObject).putExtra("selfuin", paramLong1);
    ((NewIntent)localObject).putExtra("groupuin", paramLong2);
    ((NewIntent)localObject).putExtra("groupcode", paramLong3);
    ((NewIntent)localObject).putExtra("reqType", 12);
    a((NewIntent)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = new NewIntent(((BaseVideoAppInterface)localObject).getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
    ((NewIntent)localObject).putExtra("ver", (byte)0);
    ((NewIntent)localObject).putExtra("type", (byte)1);
    ((NewIntent)localObject).putExtra("selfuin", paramBoolean);
    ((NewIntent)localObject).putExtra("groupuin", paramLong1);
    ((NewIntent)localObject).putExtra("groupcode", paramLong2);
    ((NewIntent)localObject).putExtra("reqType", 13);
    a((NewIntent)localObject);
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = paramBundle.getString("fromUin");
    this.c = ((int)(System.currentTimeMillis() / 1000L));
  }
  
  public void a(BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    this.e = paramBaseVideoAppInterface;
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.e == null) {
      return;
    }
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendMultiVideoMsg, cmsCmd[");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("]");
      QLog.w("QavNetChannel", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(this.e.getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
    ((NewIntent)localObject).putExtra("ver", (byte)0);
    ((NewIntent)localObject).putExtra("type", (byte)1);
    ((NewIntent)localObject).putExtra("cscmd", (short)(int)paramLong2);
    ((NewIntent)localObject).putExtra("selfuin", CharacterUtil.b(paramString));
    ((NewIntent)localObject).putExtra("toUin", paramLong1);
    ((NewIntent)localObject).putExtra("vMsg", paramArrayOfByte);
    ((NewIntent)localObject).putExtra("reqType", 8);
    SeqUtil.a((Intent)localObject, l);
    a((NewIntent)localObject);
  }
  
  void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.e == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong == 0L) {
        return;
      }
      SessionInfo localSessionInfo = SessionMgr.a().b();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendSharpMsg selfUin: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", toUin: ");
        ((StringBuilder)localObject).append(CharacterUtil.a(paramLong));
        ((StringBuilder)localObject).append(", uinType = ");
        ((StringBuilder)localObject).append(localSessionInfo.p);
        QLog.d("QavNetChannel", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new NewIntent(this.e.getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
      if (localSessionInfo.p == 25) {
        ((NewIntent)localObject).putExtra("reqType", 18);
      } else {
        ((NewIntent)localObject).putExtra("reqType", 4);
      }
      ReportController.b(null, "CliOper", "", "", "0X80088AF", "0X80088AF", 0, 0, "", "", "", "");
      ((NewIntent)localObject).putExtra("selfuin", CharacterUtil.b(paramString));
      ((NewIntent)localObject).putExtra("toUin", paramLong);
      ((NewIntent)localObject).putExtra("vMsg", paramArrayOfByte);
      a((NewIntent)localObject);
    }
  }
  
  void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.e == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendVideoConfigReqMsg: buf[2] = ");
        ((StringBuilder)localObject).append(paramArrayOfByte[2]);
        QLog.d("QavNetChannel", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new NewIntent(this.e.getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
      ((NewIntent)localObject).putExtra("reqType", 3);
      ((NewIntent)localObject).putExtra("selfuin", paramString1);
      ((NewIntent)localObject).putExtra("toUin", VideoPackageUtils.a(paramString2));
      ((NewIntent)localObject).putExtra("vMsg", paramArrayOfByte);
      a((NewIntent)localObject);
    }
  }
  
  public void a(ArrayList<Long> paramArrayList)
  {
    if (this.e == null) {
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      NewIntent localNewIntent = new NewIntent(this.e.getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
      localNewIntent.putExtra("reqType", 15);
      localNewIntent.putExtra("tinyid_list", paramArrayList);
      a(localNewIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "send0x265 --> tinyIDList is null Or size is 0");
    }
  }
  
  public void a(NewIntent paramNewIntent)
  {
    BaseVideoAppInterface localBaseVideoAppInterface = this.e;
    if (localBaseVideoAppInterface == null) {
      return;
    }
    try
    {
      localBaseVideoAppInterface.startServlet(paramNewIntent);
      return;
    }
    catch (Exception paramNewIntent)
    {
      QLog.w("QavNetChannel", 1, "sendMsg, Exception", paramNewIntent);
    }
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  public boolean a(String paramString)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = this.c;
    String str = this.b;
    return (str != null) && (paramString != null) && (str.equals(paramString)) && (i - j < 3);
  }
  
  public void b()
  {
    this.b = null;
    this.c = 0;
  }
  
  public void b(String paramString)
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    if (this.d == null)
    {
      this.d = new DeviceSharpController(this, (BaseVideoAppInterface)localObject);
      SessionMgr.a().b().p = 9500;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initDeviceSharp, device: ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", from: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QavNetChannel", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearDeviceSharp, device: ");
    localStringBuilder.append(this.d);
    QLog.i("QavNetChannel", 1, localStringBuilder.toString());
    if (this.d != null) {
      this.d = null;
    }
  }
  
  public boolean d()
  {
    return this.d != null;
  }
  
  public void receiveDeviceMsg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (this.e == null) {
        return;
      }
      paramBundle = paramBundle.getByteArray("buffer");
      if (paramBundle == null) {
        return;
      }
      if (this.d == null) {
        ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).smartDeviceReportReceive();
      }
      b("receiveDeviceMsg");
      if (QLog.isColorLevel()) {
        QLog.d("smartdevice::sharp", 2, "recv broadcast : receive sharp msg");
      }
      receiveSharpVideoCall(Long.valueOf(this.e.getCurrentAccountUin()).longValue(), paramBundle, null);
    }
  }
  
  public void receiveMultiVideoAck(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoAck buf=%s", new Object[] { paramBundle }));
    }
    e();
    QavChannelProxy.IChannelCallback localIChannelCallback = this.f;
    if (localIChannelCallback != null) {
      localIChannelCallback.b();
    }
    ThreadManager.executeOnSubThread(new QavChannelProxy.1(this, paramBundle));
  }
  
  public void receiveMultiVideoMsg(Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("buffer");
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoMsg buf=%s", new Object[] { paramBundle }));
    }
    e();
    QavChannelProxy.IChannelCallback localIChannelCallback = this.f;
    if (localIChannelCallback != null) {
      localIChannelCallback.b();
    }
    receiveMultiVideoMsg(1, paramBundle);
  }
  
  public void receiveMultiVideoOfflineMsg(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveMultiVideoOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    e();
    QavChannelProxy.IChannelCallback localIChannelCallback = this.f;
    if ((localIChannelCallback != null) && (localIChannelCallback.a())) {
      return;
    }
    paramBundle = paramBundle.getByteArray("buffer");
    localIChannelCallback = this.f;
    if (localIChannelCallback != null) {
      localIChannelCallback.b();
    }
    receiveMultiVideoMsg(3, paramBundle);
  }
  
  public void receiveSharpVideoAck(Bundle paramBundle)
  {
    if (this.e == null) {
      return;
    }
    e();
    paramBundle = paramBundle.getByteArray("buffer");
    int i = receiveSharpVideoAck(Long.valueOf(this.e.getCurrentAccountUin()).longValue(), paramBundle, null);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receiveSharpVideoAck: result = ");
      paramBundle.append(i);
      QLog.d("QavNetChannel", 2, paramBundle.toString());
    }
  }
  
  public void receiveSharpVideoMsg(Bundle paramBundle)
  {
    if (this.e == null) {
      return;
    }
    e();
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    String str = paramBundle.getString("fromUin");
    boolean bool = paramBundle.getBoolean("isFriend");
    int i = receiveSharpVideoCall(Long.valueOf(this.e.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receiveSharpVideoMsg: selfUin = ");
      paramBundle.append(this.e.getCurrentAccountUin());
      paramBundle.append(", fromUin = ");
      paramBundle.append(str);
      paramBundle.append(", result = ");
      paramBundle.append(i);
      paramBundle.append(",isFriend:");
      paramBundle.append(bool);
      QLog.d("QavNetChannel", 2, paramBundle.toString());
    }
    this.a = 0;
    paramBundle = SessionMgr.a().b();
    if ((paramBundle.p == 1006) && (!paramBundle.B) && (!TextUtils.equals(str, this.e.getCurrentAccountUin())))
    {
      paramBundle.u = str;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("receiveSharpVideoMsg: CONTACT_STRANGER_FRIEND  peerUin = ");
        paramBundle.append(str);
        QLog.d("QavNetChannel", 2, paramBundle.toString());
      }
    }
  }
  
  public void receiveSharpVideoOfflineMsg(Bundle paramBundle)
  {
    if (this.e == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, String.format("receiveSharpVideoOfflineMsg data=%s", new Object[] { paramBundle }));
    }
    e();
    byte[] arrayOfByte = paramBundle.getByteArray("buffer");
    boolean bool = paramBundle.getBoolean("isRequest");
    a(paramBundle);
    long l = paramBundle.getLong("msf_timestamp");
    paramBundle = paramBundle.getString("fromUin");
    QavChannelProxy.IChannelCallback localIChannelCallback = this.f;
    if (localIChannelCallback != null) {
      localIChannelCallback.a(paramBundle, l);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("quaReport --> receiveSharpVideoOfflineMsg msf_timestamp = ");
    paramBundle.append(l);
    QLog.d("QavNetChannel", 1, paramBundle.toString());
    int i = receiveSharpVideoCall(Long.valueOf(this.e.getCurrentAccountUin()).longValue(), arrayOfByte, null);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receiveSharpVideoCall result: ");
      paramBundle.append(i);
      paramBundle.append(", buf.length: ");
      paramBundle.append(arrayOfByte.length);
      QLog.d("QavNetChannel", 2, paramBundle.toString());
    }
    if ((bool) && (this.a == -1)) {
      this.a = 1;
    }
  }
  
  public void receiveVideoConfig(Bundle paramBundle) {}
  
  public void sendGetGatewayMsg()
  {
    if (this.e == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavNetChannel", 2, "sendGetGatewayMsg");
    }
    NewIntent localNewIntent = new NewIntent(this.e.getApplication(), ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getVideoServletClass());
    localNewIntent.putExtra("reqType", 7);
    a(localNewIntent);
  }
  
  public void sendGetVideoConfig(byte[] paramArrayOfByte)
  {
    if (this.e == null) {
      return;
    }
    SessionInfo localSessionInfo = SessionMgr.a().b();
    a(this.e.getCurrentAccountUin(), localSessionInfo.s, paramArrayOfByte);
  }
  
  public void sendLogReportMsg(long paramLong, byte[] paramArrayOfByte) {}
  
  public void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    BaseVideoAppInterface localBaseVideoAppInterface = this.e;
    if (localBaseVideoAppInterface == null) {
      return;
    }
    a(localBaseVideoAppInterface.getCurrentAccountUin(), paramLong1, paramLong2, paramArrayOfByte);
  }
  
  public void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.e == null) {
      return;
    }
    VideoPackageUtils.a(paramArrayOfByte);
    DeviceSharpController localDeviceSharpController = this.d;
    if (localDeviceSharpController == null)
    {
      ReportController.b(null, "CliOper", "", "", "0X80088AE", "0X80088AE", 0, 0, "", "", "", "");
      a(this.e.getCurrentAccountUin(), paramLong, paramArrayOfByte);
      return;
    }
    localDeviceSharpController.b(paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.QavChannelProxy
 * JD-Core Version:    0.7.0.1
 */