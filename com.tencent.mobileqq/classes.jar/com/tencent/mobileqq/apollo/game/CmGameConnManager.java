package com.tencent.mobileqq.apollo.game;

import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.apollo.CmGameMsgTunnel.TunnelMsgStream;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class CmGameConnManager
  implements Handler.Callback, CmGameSocketConnection.CmGameSocketConnectionListener, INetInfoHandler
{
  private QQAppInterface a;
  private WeakReferenceHandler b = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private CmGameConnManager.GameConnInfo c;
  private CmGameSocketConnection d;
  private long e;
  private AtomicInteger f = new AtomicInteger(0);
  private int g;
  private volatile boolean h;
  private volatile boolean i;
  
  public CmGameConnManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
    try
    {
      this.e = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "parse uin exception=", paramQQAppInterface);
    }
  }
  
  private byte[] a(short paramShort, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.c == null)
    {
      QLog.w("[cmshow]CmGameConnManager", 1, "[encodeMsgStream] no conn info");
      return null;
    }
    Object localObject = new CmGameMsgTunnel.TunnelMsgStream();
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).platform.set(109L);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).osver.set(Build.VERSION.RELEASE);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).mqqver.set("8.8.17");
    if (!TextUtils.isEmpty(paramString)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).cmd.set(paramString);
    }
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).seq.set(this.f.getAndIncrement());
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).distribute_ts.set(this.c.d);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).src_uid.set(this.e);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).dst_uid.set(paramLong);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).sign.set(this.c.e);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).busi_buff.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString = ((CmGameMsgTunnel.TunnelMsgStream)localObject).toByteArray();
    try
    {
      paramString = CmGameUtil.a(paramString, this.c.c);
      paramArrayOfByte = ByteBuffer.allocate(23);
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
      paramArrayOfByte.putInt(439041101);
      paramArrayOfByte.put((byte)1);
      paramArrayOfByte.putShort(paramShort);
      paramArrayOfByte.putInt(paramString.length);
      paramArrayOfByte.putInt(2);
      paramArrayOfByte.putLong(this.e);
      paramArrayOfByte = paramArrayOfByte.array();
      localObject = new byte[paramString.length + 23];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, paramArrayOfByte.length);
      System.arraycopy(paramString, 0, localObject, 23, paramString.length);
      return localObject;
    }
    catch (Exception paramString)
    {
      label287:
      break label287;
    }
    QLog.w("[cmshow]CmGameConnManager", 1, "[encodeMsgStream] encrypt exception");
    return null;
  }
  
  private byte[] a(short paramShort, String paramString, byte[] paramArrayOfByte)
  {
    return a(paramShort, paramString, 0L, paramArrayOfByte);
  }
  
  private void g()
  {
    try
    {
      QLog.d("[cmshow]CmGameConnManager", 1, "[openConnection]");
      this.h = true;
      if ((!a()) && (!this.i))
      {
        this.i = true;
        if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getApplication().getApplicationContext()))
        {
          QLog.d("[cmshow]CmGameConnManager", 1, "[openConnection] network unavailable");
          this.i = false;
          return;
        }
        ((ApolloExtensionHandler)this.a.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).c();
        return;
      }
      QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[openConnection] already connected or connecting, mIsConnecting=", Boolean.valueOf(this.i) });
      return;
    }
    finally {}
  }
  
  private void h()
  {
    try
    {
      this.h = false;
      this.g = 0;
      QLog.d("[cmshow]CmGameConnManager", 1, "[closeConnection]");
      if (this.d != null)
      {
        this.d.e();
        this.d = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean i()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[createConnection]");
    Object localObject = this.c;
    if (localObject == null)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[createConnection] no connection info");
      return false;
    }
    if ((((CmGameConnManager.GameConnInfo)localObject).a != null) && (this.c.a.size() != 0))
    {
      localObject = new CmGameSocketConnection.ConnectionParam();
      ((CmGameSocketConnection.ConnectionParam)localObject).a = this.c.a;
      ((CmGameSocketConnection.ConnectionParam)localObject).b = this.c.b;
      ((CmGameSocketConnection.ConnectionParam)localObject).c = 10000;
      ((CmGameSocketConnection.ConnectionParam)localObject).d = 3000;
      CmGameSocketConnection localCmGameSocketConnection = this.d;
      if (localCmGameSocketConnection == null) {
        this.d = new CmGameSocketConnection((CmGameSocketConnection.ConnectionParam)localObject);
      } else {
        localCmGameSocketConnection.a((CmGameSocketConnection.ConnectionParam)localObject);
      }
      this.d.a(this);
      this.d.a();
      return true;
    }
    QLog.e("[cmshow]CmGameConnManager", 1, "[createConnection] no connection host");
    return false;
  }
  
  private void j()
  {
    CmGameSocketConnection localCmGameSocketConnection = this.d;
    if ((localCmGameSocketConnection != null) && (localCmGameSocketConnection.b())) {
      this.d.a(false);
    }
  }
  
  private void k()
  {
    try
    {
      QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[reconnect] mShouldKeepConnect=", Boolean.valueOf(this.h) });
      j();
      if (this.h)
      {
        this.f.set(0);
        g();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(CmGameConnManager.GameConnInfo paramGameConnInfo)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onGetConnInfoSuccess]");
    if (paramGameConnInfo == null)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[onGetConnInfoSuccess] gameConnInfo null");
      return;
    }
    boolean bool;
    if (this.h)
    {
      this.c = paramGameConnInfo;
      bool = i();
    }
    else
    {
      bool = false;
    }
    if (!bool) {
      this.i = false;
    }
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    if (paramMsfSocketInputBuffer == null)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] buffer null");
      return;
    }
    int j = paramMsfSocketInputBuffer.getBufferlen();
    if (j <= 23)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] invalid buffer length");
      return;
    }
    Object localObject = ByteBuffer.wrap(paramMsfSocketInputBuffer.getBuffer(), 0, 23);
    int k = ((ByteBuffer)localObject).getInt();
    if (k != 439041101)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] invalid magic");
      return;
    }
    byte b1 = ((ByteBuffer)localObject).get();
    short s = ((ByteBuffer)localObject).getShort();
    int m = ((ByteBuffer)localObject).getInt();
    int n = ((ByteBuffer)localObject).getInt();
    long l = ((ByteBuffer)localObject).getLong();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameConnManager", 2, new Object[] { "[receive] header, magic=", Integer.valueOf(k), ", protocolVersion=", Byte.valueOf(b1), ", type=", Short.valueOf(s), ", appid=", Integer.valueOf(n), ", bodyLength=", Integer.valueOf(m), ", srcUin=", Long.valueOf(l) });
    }
    if (s == 6)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] invalid key");
      this.b.removeMessages(5);
      paramMsfSocketInputBuffer = this.b.obtainMessage(5);
      paramMsfSocketInputBuffer.obj = Boolean.valueOf(true);
      this.b.sendMessage(paramMsfSocketInputBuffer);
      return;
    }
    j -= 23;
    localObject = new byte[j];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 23, localObject, 0, j);
    try
    {
      paramMsfSocketInputBuffer = CmGameUtil.b((byte[])localObject, this.c.c);
      localObject = new CmGameMsgTunnel.TunnelMsgStream();
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).mergeFrom(paramMsfSocketInputBuffer);
      if (s == 2)
      {
        QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[receive] error, code=", Integer.valueOf(((CmGameMsgTunnel.TunnelMsgStream)localObject).ret.get()) });
        return;
      }
      QLog.e("[cmshow]CmGameConnManager", 1, new Object[] { "[receive] stream type not support yet, streamType=", Short.valueOf(s) });
      return;
    }
    catch (Exception paramMsfSocketInputBuffer)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] get pb failed, e=", paramMsfSocketInputBuffer);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = NetworkUtil.isNetSupportHw(BaseApplicationImpl.getApplication().getApplicationContext());
    QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onDisconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", networkAvailable=", Boolean.valueOf(bool) });
    if ((paramBoolean) && (bool)) {
      k();
    }
  }
  
  public boolean a()
  {
    CmGameSocketConnection localCmGameSocketConnection = this.d;
    return (localCmGameSocketConnection != null) && (localCmGameSocketConnection.b());
  }
  
  public void b()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onGetConnInfoFailed] mShouldKeepConnect=", Boolean.valueOf(this.h), ", mConnInfo=", this.c });
    boolean bool;
    if ((this.h) && (this.c != null)) {
      bool = i();
    } else {
      bool = false;
    }
    if (!bool) {
      this.i = false;
    }
  }
  
  public void c()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onConnectSuccess]");
    this.i = false;
  }
  
  public void d()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onConnectFailed] mRetryCounter=", Integer.valueOf(this.g), ", mShouldKeepConnect=", Boolean.valueOf(this.h) });
    this.i = false;
    if (this.h)
    {
      int j = this.g;
      if (j <= 2)
      {
        this.g = (j + 1);
        this.b.removeMessages(1);
        this.b.sendEmptyMessageDelayed(1, 10000L);
      }
    }
  }
  
  public byte[] e()
  {
    return a((short)1, "heartbeat", null);
  }
  
  public void f()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onDestroy]");
    this.b.removeCallbacksAndMessages(null);
    h();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    if (j != 1)
    {
      if (j != 4)
      {
        if (j != 5)
        {
          if (j != 6) {
            return false;
          }
          QQToast.makeText(BaseApplicationImpl.getContext(), (String)paramMessage.obj, 0).show();
          return false;
        }
        QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT");
        if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue()))
        {
          QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT, reset conn info");
          this.c = null;
        }
        k();
        return false;
      }
      QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_DISCONNECT");
      j();
      return false;
    }
    QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_OPEN_CONNECTION");
    g();
    return false;
  }
  
  public void onNetMobile2None()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetMobile2None]");
    this.b.removeMessages(4);
    this.b.sendEmptyMessage(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetMobile2Wifi]");
    this.b.removeMessages(5);
    this.b.sendEmptyMessage(5);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetNone2Mobile]");
    this.b.removeMessages(5);
    this.b.sendEmptyMessage(5);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetNone2Wifi]");
    this.b.removeMessages(5);
    this.b.sendEmptyMessage(5);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetWifi2Mobile]");
    this.b.removeMessages(5);
    this.b.sendEmptyMessage(5);
  }
  
  public void onNetWifi2None()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetWifi2None]");
    this.b.removeMessages(4);
    this.b.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameConnManager
 * JD-Core Version:    0.7.0.1
 */