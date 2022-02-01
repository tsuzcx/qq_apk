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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class CmGameConnManager
  implements Handler.Callback, CmGameSocketConnection.CmGameSocketConnectionListener, INetInfoHandler
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private CmGameConnManager.GameConnInfo jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo;
  private CmGameSocketConnection jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public CmGameConnManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApplication(), this);
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "parse uin exception=", paramQQAppInterface);
    }
  }
  
  private byte[] a(short paramShort, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo == null)
    {
      QLog.w("[cmshow]CmGameConnManager", 1, "[encodeMsgStream] no conn info");
      return null;
    }
    Object localObject = new CmGameMsgTunnel.TunnelMsgStream();
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).platform.set(109L);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).osver.set(Build.VERSION.RELEASE);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).mqqver.set("8.7.0");
    if (!TextUtils.isEmpty(paramString)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).cmd.set(paramString);
    }
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).seq.set(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement());
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).distribute_ts.set(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.jdField_a_of_type_Long);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).src_uid.set(this.jdField_a_of_type_Long);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).dst_uid.set(paramLong);
    ((CmGameMsgTunnel.TunnelMsgStream)localObject).sign.set(this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.b);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      ((CmGameMsgTunnel.TunnelMsgStream)localObject).busi_buff.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    paramString = ((CmGameMsgTunnel.TunnelMsgStream)localObject).toByteArray();
    try
    {
      paramString = CmGameUtil.a(paramString, this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.jdField_a_of_type_JavaLangString);
      paramArrayOfByte = ByteBuffer.allocate(23);
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
      paramArrayOfByte.putInt(439041101);
      paramArrayOfByte.put((byte)1);
      paramArrayOfByte.putShort(paramShort);
      paramArrayOfByte.putInt(paramString.length);
      paramArrayOfByte.putInt(2);
      paramArrayOfByte.putLong(this.jdField_a_of_type_Long);
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
  
  private boolean b()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[createConnection]");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo;
    if (localObject == null)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[createConnection] no connection info");
      return false;
    }
    if ((((CmGameConnManager.GameConnInfo)localObject).jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      localObject = new CmGameSocketConnection.ConnectionParam();
      ((CmGameSocketConnection.ConnectionParam)localObject).jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.jdField_a_of_type_JavaUtilList;
      ((CmGameSocketConnection.ConnectionParam)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.jdField_a_of_type_Int;
      ((CmGameSocketConnection.ConnectionParam)localObject).b = 10000;
      ((CmGameSocketConnection.ConnectionParam)localObject).c = 3000;
      CmGameSocketConnection localCmGameSocketConnection = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection;
      if (localCmGameSocketConnection == null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection = new CmGameSocketConnection((CmGameSocketConnection.ConnectionParam)localObject);
      } else {
        localCmGameSocketConnection.a((CmGameSocketConnection.ConnectionParam)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection.a(this);
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection.a();
      return true;
    }
    QLog.e("[cmshow]CmGameConnManager", 1, "[createConnection] no connection host");
    return false;
  }
  
  private void f()
  {
    try
    {
      QLog.d("[cmshow]CmGameConnManager", 1, "[openConnection]");
      this.jdField_a_of_type_Boolean = true;
      if ((!a()) && (!this.b))
      {
        this.b = true;
        if (!NetworkUtil.isNetSupportHw(BaseApplicationImpl.getApplication().getApplicationContext()))
        {
          QLog.d("[cmshow]CmGameConnManager", 1, "[openConnection] network unavailable");
          this.b = false;
          return;
        }
        ((ApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b();
        return;
      }
      QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[openConnection] already connected or connecting, mIsConnecting=", Boolean.valueOf(this.b) });
      return;
    }
    finally {}
  }
  
  private void g()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      QLog.d("[cmshow]CmGameConnManager", 1, "[closeConnection]");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection.e();
        this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void h()
  {
    CmGameSocketConnection localCmGameSocketConnection = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection;
    if ((localCmGameSocketConnection != null) && (localCmGameSocketConnection.a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection.a(false);
    }
  }
  
  private void i()
  {
    try
    {
      QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[reconnect] mShouldKeepConnect=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
      h();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
        f();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[wakeup]");
    CmGameSocketConnection localCmGameSocketConnection = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection;
    if ((localCmGameSocketConnection != null) && (localCmGameSocketConnection.a())) {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection.b();
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
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo = paramGameConnInfo;
      bool = b();
    }
    else
    {
      bool = false;
    }
    if (!bool) {
      this.b = false;
    }
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    if (paramMsfSocketInputBuffer == null)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] buffer null");
      return;
    }
    int i = paramMsfSocketInputBuffer.getBufferlen();
    if (i <= 23)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] invalid buffer length");
      return;
    }
    Object localObject = ByteBuffer.wrap(paramMsfSocketInputBuffer.getBuffer(), 0, 23);
    int j = ((ByteBuffer)localObject).getInt();
    if (j != 439041101)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] invalid magic");
      return;
    }
    byte b1 = ((ByteBuffer)localObject).get();
    short s = ((ByteBuffer)localObject).getShort();
    int k = ((ByteBuffer)localObject).getInt();
    int m = ((ByteBuffer)localObject).getInt();
    long l = ((ByteBuffer)localObject).getLong();
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameConnManager", 2, new Object[] { "[receive] header, magic=", Integer.valueOf(j), ", protocolVersion=", Byte.valueOf(b1), ", type=", Short.valueOf(s), ", appid=", Integer.valueOf(m), ", bodyLength=", Integer.valueOf(k), ", srcUin=", Long.valueOf(l) });
    }
    if (s == 6)
    {
      QLog.e("[cmshow]CmGameConnManager", 1, "[receive] invalid key");
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
      paramMsfSocketInputBuffer = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(5);
      paramMsfSocketInputBuffer.obj = Boolean.valueOf(true);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(paramMsfSocketInputBuffer);
      return;
    }
    i -= 23;
    localObject = new byte[i];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 23, localObject, 0, i);
    try
    {
      paramMsfSocketInputBuffer = CmGameUtil.b((byte[])localObject, this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo.jdField_a_of_type_JavaLangString);
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
  
  public void a(String paramString)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onCmGamePageEnter] tag=", paramString, ", size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
      if (!a())
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
      }
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = NetworkUtil.isNetSupportHw(BaseApplicationImpl.getApplication().getApplicationContext());
    QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onDisconnect] shouldReconnect=", Boolean.valueOf(paramBoolean), ", networkAvailable=", Boolean.valueOf(bool) });
    if ((paramBoolean) && (bool)) {
      i();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGameConnManager", 2, new Object[] { "[updateMatchWebPageStatus] isAlive=", Boolean.valueOf(paramBoolean1), ", wakeup=", Boolean.valueOf(paramBoolean2) });
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(7);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(7, 130000L);
      a("page_tag_match");
      if ((a()) && (paramBoolean2)) {
        a();
      }
    }
    else
    {
      b("page_tag_match");
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(7);
    }
  }
  
  public boolean a()
  {
    CmGameSocketConnection localCmGameSocketConnection = this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameSocketConnection;
    return (localCmGameSocketConnection != null) && (localCmGameSocketConnection.a());
  }
  
  public byte[] a()
  {
    return a((short)1, "heartbeat", null);
  }
  
  public void b()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onGetConnInfoFailed] mShouldKeepConnect=", Boolean.valueOf(this.jdField_a_of_type_Boolean), ", mConnInfo=", this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo });
    boolean bool;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo != null)) {
      bool = b();
    } else {
      bool = false;
    }
    if (!bool) {
      this.b = false;
    }
  }
  
  public void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString);
      QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onCmGamePageLeave] tag=", paramString, ", size=", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(2, 2000L);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onConnectSuccess]");
    this.b = false;
  }
  
  public void d()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, new Object[] { "[onConnectFailed] mRetryCounter=", Integer.valueOf(this.jdField_a_of_type_Int), ", mShouldKeepConnect=", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    this.b = false;
    if (this.jdField_a_of_type_Boolean)
    {
      int i = this.jdField_a_of_type_Int;
      if (i <= 2)
      {
        this.jdField_a_of_type_Int = (i + 1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 10000L);
      }
    }
  }
  
  public void e()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onDestroy]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    g();
    AppNetConnInfo.unregisterNetInfoHandler(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6)
            {
              if (i != 7) {
                return false;
              }
              QLog.w("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_CHECK_MATCH_PAGE_REPORT_TIMEOUT");
              b("page_tag_match");
              return false;
            }
            QQToast.a(BaseApplicationImpl.getContext(), (String)paramMessage.obj, 0).a();
            return false;
          }
          QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT");
          if ((paramMessage.obj != null) && (((Boolean)paramMessage.obj).booleanValue()))
          {
            QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_RECONNECT, reset conn info");
            this.jdField_a_of_type_ComTencentMobileqqApolloGameCmGameConnManager$GameConnInfo = null;
          }
          i();
          return false;
        }
        QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_DISCONNECT");
        h();
        return false;
      }
      QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_CLOSE_CONNECTION");
      g();
      return false;
    }
    QLog.d("[cmshow]CmGameConnManager", 1, "[handleMessage] MSG_OPEN_CONNECTION");
    f();
    return false;
  }
  
  public void onNetMobile2None()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetMobile2None]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetMobile2Wifi]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetNone2Mobile]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetNone2Wifi]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetWifi2Mobile]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(5);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(5);
  }
  
  public void onNetWifi2None()
  {
    QLog.d("[cmshow]CmGameConnManager", 1, "[onNetWifi2None]");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(4);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.CmGameConnManager
 * JD-Core Version:    0.7.0.1
 */