import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mobileqq.activity.history.ChatHistoryAuthDevForRoamMsgFragment;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class apac
  extends BusinessHandler
{
  public int a;
  public SparseArray<apad> a;
  
  public apac(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      localObject = new oidb_sso.OIDBSSOPkg();
      int i;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.roammsg", 2, "handle_oidb_0x42e_3 ret = " + i);
          }
          if (i == 0) {
            a(paramFromServiceMsg, paramToServiceMsg, paramObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 error: ", paramToServiceMsg);
        }
        paramObject.a(16, null);
        return;
      }
      a(paramFromServiceMsg, i, paramObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("handle_oidb_0x42e_3 error: ");
      if (paramFromServiceMsg == null) {
        break label210;
      }
    }
    label210:
    for (paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode());; paramToServiceMsg = "null")
    {
      QLog.d("Q.roammsg", 2, paramToServiceMsg);
      paramObject.a(16, null);
      return;
    }
  }
  
  private void a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, int paramInt, anzc paramanzc)
  {
    int i = 0;
    paramOIDBSSOPkg = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    int j = paramOIDBSSOPkg.length;
    if (1 <= j) {
      i = (short)paramOIDBSSOPkg[0];
    }
    if (i + 1 <= j) {}
    for (paramOIDBSSOPkg = PkgTools.getUTFString(paramOIDBSSOPkg, 1, i);; paramOIDBSSOPkg = null)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handle_oidb_0x42e_3 ret = ").append(paramInt).append(", ");
        if (paramOIDBSSOPkg == null) {
          break label103;
        }
      }
      for (;;)
      {
        QLog.d("Q.roammsg", 2, paramOIDBSSOPkg);
        paramanzc.a(16, null);
        return;
        label103:
        paramOIDBSSOPkg = "null";
      }
    }
  }
  
  private void a(oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, ToServiceMsg paramToServiceMsg, anzc paramanzc)
  {
    paramOIDBSSOPkg = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    int i3 = paramOIDBSSOPkg.length;
    long l = 0L;
    int i = 0;
    int j = 0;
    if (4 <= i3) {
      l = PkgTools.getLongData(paramOIDBSSOPkg, 0);
    }
    if (6 <= i3) {}
    for (int m = PkgTools.getShortData(paramOIDBSSOPkg, 4);; m = 0)
    {
      if (8 <= i3) {}
      for (int n = PkgTools.getShortData(paramOIDBSSOPkg, 6);; n = 0)
      {
        if (10 <= i3) {
          i = PkgTools.getShortData(paramOIDBSSOPkg, 8);
        }
        if (12 <= i3) {
          j = PkgTools.getShortData(paramOIDBSSOPkg, 10);
        }
        if ((i == 0) && (j == 0) && (m == 0) && (n == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 : wYearEnd = wMonthEnd = wYearStart = wMonthStart = 0");
          }
          paramanzc.a(2002);
          paramanzc.a(17, null);
          return;
        }
        int i4 = (i - m) * 12 + (j - n) + 1;
        long[] arrayOfLong = new long[i4];
        int i1 = 12;
        int k = 0;
        while (k < i4)
        {
          i2 = i1;
          if (i1 + 4 <= i3)
          {
            arrayOfLong[k] = PkgTools.getLongData(paramOIDBSSOPkg, i1);
            i2 = i1 + 4;
          }
          k += 1;
          i1 = i2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 Begin: " + m + "-" + n + ", End: " + i + "-" + j + " : dwIndexes = " + Arrays.toString(arrayOfLong));
        }
        int i6 = paramToServiceMsg.extraData.getInt("EndRoamYearKey");
        int i7 = paramToServiceMsg.extraData.getInt("EndRoamMonthKey");
        i4 = paramToServiceMsg.extraData.getInt("EndRoamDayKey");
        paramanzc.a().d();
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg", 2, "handle_oidb_0x42e_3 : clearRoamDateSerIndex...");
        }
        int i2 = j;
        k = i;
        i1 = 0;
        for (;;)
        {
          int i5 = 31;
          i3 = i5;
          if (k == i6)
          {
            i3 = i5;
            if (i2 == i7) {
              i3 = i4;
            }
          }
          paramanzc.a().a(l, k, i2, (int)arrayOfLong[i1], i3);
          if (i2 - 1 > 0)
          {
            i3 = i2 - 1;
            i2 = k;
            k = i3;
          }
          while ((i2 < m) || ((i2 == m) && (k < n)))
          {
            paramanzc.b(i6, i7, i4);
            paramanzc.a().a(String.valueOf(l), m, n, i, j);
            paramanzc.m();
            paramanzc.c();
            paramanzc.a(2003);
            paramanzc.a(18, null);
            return;
            i2 = 12;
            i3 = k - 1;
            k = i2;
            i2 = i3;
          }
          i3 = k;
          i1 += 1;
          k = i2;
          i2 = i3;
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    int j = 0;
    int k = paramToServiceMsg.extraData.getShort("authMode");
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "handle_roam_message_auth_mode retCode: " + i + ", mode: " + k);
    }
    if (1000 == i)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
        }
      }
      i = j;
      if (paramToServiceMsg != null)
      {
        i = j;
        if (paramToServiceMsg.uint32_result.has())
        {
          j = paramToServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.roammsg", 2, "handle_roam_message_auth_mode ret=" + j + ", authMode: " + k);
          }
          i = j;
          if (j == 0)
          {
            paramToServiceMsg = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
            i = j;
            if (paramToServiceMsg != null) {
              paramToServiceMsg.d(k);
            }
          }
        }
      }
    }
    for (i = j;; i = -1)
    {
      paramToServiceMsg = this.app.getHandler(ChatHistoryAuthDevForRoamMsgFragment.class);
      if (paramToServiceMsg != null)
      {
        paramFromServiceMsg = paramToServiceMsg.obtainMessage();
        paramFromServiceMsg.what = 1;
        paramFromServiceMsg.arg1 = i;
        paramFromServiceMsg.arg2 = k;
        paramToServiceMsg.sendMessage(paramFromServiceMsg);
      }
      return;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "handle_get_roam_msg_auth_mode isSuccess: " + bool1);
      }
      if (!bool1) {}
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
        break label480;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        int i;
        long l;
        int j;
        int k;
        int m;
        label322:
        if (QLog.isColorLevel())
        {
          QLog.d("Q.roammsg", 2, "handle_get_roam_msg_auth_mode exception: " + paramToServiceMsg.getMessage());
          continue;
          i = -1;
          continue;
          i = 0;
          continue;
          i += 1;
        }
      }
    }
    if (i == 0)
    {
      l = paramFromServiceMsg.getInt();
      paramFromServiceMsg.get();
      j = paramFromServiceMsg.getShort();
      if (!QLog.isColorLevel()) {
        break label486;
      }
      QLog.d("Q.roammsg", 2, "handle_get_roam_msg_auth_mode, request success, tlvCount = " + j);
      break label486;
      if ((paramFromServiceMsg.hasRemaining()) && (i < j))
      {
        k = paramFromServiceMsg.getShort();
        m = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg", 2, "handle_get_roam_msg_auth_mode, TLV type: " + k + ",legnth: " + m);
        }
        if (k != -23723) {
          break label369;
        }
        i = paramFromServiceMsg.getShort();
        paramToServiceMsg = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.d(i);
        }
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handle_get_roam_msg_auth_mode authMode is :").append(i).append(", manager is null: ");
          if (paramToServiceMsg != null) {
            break label363;
          }
          bool1 = bool2;
          QLog.i("Q.roammsg", 2, bool1);
        }
      }
    }
    for (;;)
    {
      ((anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(34, null);
      return;
      bool1 = false;
      break;
      label363:
      bool1 = false;
      break label322;
      label369:
      if (!QLog.isColorLevel()) {
        break label492;
      }
      QLog.i("Q.roammsg", 2, "handle_get_roam_msg_auth_mode TLV error T: " + k);
      break label492;
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "handle_get_roam_msg_auth_mode pkg_result: " + i);
      }
    }
  }
  
  public anyz a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      apad localapad = new apad(this, paramInt);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localapad);
    }
    return (anyz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg", 2, "get_roam_msg_auth_mode begin...");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ByteBuffer.allocate(9);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)1);
    ((ByteBuffer)localObject).putShort((short)-23723);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromMessageRoamHandler", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[12];
      PkgTools.DWord2Byte(paramString, 0, l);
      PkgTools.DWordTo2Bytes(paramString, 4, paramInt1);
      PkgTools.DWordTo2Bytes(paramString, 6, paramInt2);
      PkgTools.DWordTo2Bytes(paramString, 8, paramInt3);
      PkgTools.DWordTo2Bytes(paramString, 10, paramInt4);
      paramString = makeOIDBPkg("OidbSvc.0x42e_3", 1070, 3, paramString);
      paramString.extraData.putInt("EndRoamYearKey", paramInt3);
      paramString.extraData.putInt("EndRoamMonthKey", paramInt4);
      paramString.extraData.putInt("EndRoamDayKey", paramInt5);
      sendPbReq(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.roammsg", 2, "send_oidb_0x42e_3 error: ", paramString);
    }
  }
  
  public void a(String paramString, Calendar paramCalendar, boolean paramBoolean, int paramInt)
  {
    if (a(paramString, paramCalendar, paramBoolean, paramInt)) {
      return;
    }
    paramString = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.a(0, paramInt, null);
      return;
    }
  }
  
  public void a(String paramString, Calendar paramCalendar, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    a(paramString, paramCalendar, paramBoolean1, paramInt, paramBoolean2, true);
  }
  
  public void a(String paramString, Calendar paramCalendar, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    anzc localanzc = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
    if (localanzc.b() == 0)
    {
      l1 = localSharedPreferences.getLong("vip_message_roam_last_request_timestamp" + this.app.getCurrentAccountUin(), 0L);
      if ((System.currentTimeMillis() - l1 > 7200000L) || (l1 == 0L))
      {
        QLog.d("Q.roammsg", 1, "getRoamHistoryForSomeDay open password lastRequestTime = " + l1);
        localanzc.a(3, 2, null);
        paramString = localSharedPreferences.edit();
        paramString.putLong("vip_message_roam_last_request_timestamp" + this.app.getCurrentAccountUin(), System.currentTimeMillis());
        paramString.commit();
        return;
      }
    }
    paramCalendar = localanzc.a((Calendar)paramCalendar.clone());
    long l1 = ((Long)paramCalendar.first).longValue();
    long l2 = ((Long)paramCalendar.second).longValue();
    this.app.getMsgHandler().a(paramString, l1, 0L, l2, (short)0, 0L, 1, localanzc.a(), localanzc.b(), paramBoolean1, paramInt, paramBoolean2, paramBoolean3);
  }
  
  public void a(short paramShort)
  {
    try
    {
      long l = Long.parseLong(this.app.getAccount());
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "set_roam_message_auth_mode_0x4ff_9  authMode: " + paramShort);
      }
      Object localObject = new byte[13];
      PkgTools.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.Word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.DWordTo2Bytes((byte[])localObject, 7, 41813);
      PkgTools.Word2Byte((byte[])localObject, 9, (short)2);
      PkgTools.Word2Byte((byte[])localObject, 11, paramShort);
      localObject = makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromMessageRoamHandler", true);
      ((ToServiceMsg)localObject).extraData.putShort("authMode", paramShort);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.roammsg", 2, "set_roam_message_auth_mode_0x4ff_9  error", localException);
    }
  }
  
  public boolean a(String paramString, Calendar paramCalendar, boolean paramBoolean, int paramInt)
  {
    anzc localanzc = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject = localanzc.a(paramCalendar);
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage next date is null");
      }
      return false;
    }
    paramCalendar = ((Bundle)localObject).getString("MSG_TYPE");
    int i = ((Bundle)localObject).getInt("DATE_YEAR");
    int j = ((Bundle)localObject).getInt("DATE_MONTH");
    int k = ((Bundle)localObject).getInt("DATE_DAY");
    localObject = Calendar.getInstance();
    ((Calendar)localObject).set(1, i);
    ((Calendar)localObject).set(2, j - 1);
    ((Calendar)localObject).set(5, k);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(14, 0);
    if ("server".equals(paramCalendar))
    {
      localanzc.a((Calendar)localObject);
      QLog.d("Q.roammsg", 1, "fetchMoreRoamMessage getRoamHistoryForSomeDay");
      a(paramString, (Calendar)localObject, paramBoolean, paramInt, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage from server date: " + i + "-" + j + "-" + k + ", fetchNum: " + paramInt);
      }
      return true;
    }
    if ("local".equals(paramCalendar))
    {
      localanzc.a((Calendar)localObject);
      paramCalendar = localanzc.a((Calendar)((Calendar)localObject).clone());
      int m = localanzc.a(paramString, ((Long)paramCalendar.first).longValue(), ((Long)paramCalendar.second).longValue());
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg", 2, "fetchMoreRoamMessage from local date: " + i + "-" + j + "-" + k + ",msgcount: " + m + ", fetchNum: " + (paramInt - m));
      }
      if ((m >= 0) && (m < paramInt)) {
        return a(paramString, (Calendar)localObject, paramBoolean, paramInt - m);
      }
      return false;
    }
    return false;
  }
  
  public anyz b(int paramInt)
  {
    anyz localanyz = (anyz)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    return localanyz;
  }
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x42e_3");
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x480_9");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("onReceive success ssoSeq: ").append(paramToServiceMsg.getRequestSsoSeq()).append(", serviceCmd: ").append(str).append(", resultCode: ").append(paramFromServiceMsg.getResultCode());
      QLog.d("Q.roammsg", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.0x42e_3".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      do
      {
        return;
        if (!"OidbSvc.0x4ff_9".equals(str)) {
          break;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("reqFromMessageRoamHandler"));
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while ((!"OidbSvc.0x480_9".equals(str)) || (!paramToServiceMsg.extraData.getBoolean("reqFromMessageRoamHandler")));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apac
 * JD-Core Version:    0.7.0.1
 */