import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.2;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.3;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.4;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aujh
{
  private static aujh jdField_a_of_type_Aujh;
  public int a;
  public long a;
  private augk jdField_a_of_type_Augk;
  public MsgBackupEndPoint a;
  public MsgBackupJniProxy a;
  public MsgBackupNotifier a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected String a;
  protected boolean a;
  private long jdField_b_of_type_Long;
  public MsgBackupEndPoint b;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  public MsgBackupEndPoint c;
  private boolean jdField_c_of_type_Boolean;
  public MsgBackupEndPoint d;
  private boolean d;
  private boolean e;
  
  public static aujh a()
  {
    if (jdField_a_of_type_Aujh == null) {}
    try
    {
      if (jdField_a_of_type_Aujh == null) {
        jdField_a_of_type_Aujh = new aujh();
      }
      return jdField_a_of_type_Aujh;
    }
    finally {}
  }
  
  private MsgBackupJniProxy a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy = new MsgBackupJniProxy(paramContext);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy;
  }
  
  private String a()
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", augd.a().a());
      localJSONArray.put(localJSONObject);
      return localJSONArray.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private String a(long paramLong, int paramInt)
  {
    int i = augo.jdField_b_of_type_Int;
    Object localObject3 = augo.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    ((ConcurrentHashMap)localObject3).size();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "getSessionJsonRsp, fid = " + paramLong + ", mServerReadyMList.size = " + ((ConcurrentHashMap)localObject3).size() + ", mDataCache = " + i + ", from = " + paramInt);
    }
    JSONArray localJSONArray = new JSONArray();
    ??? = new JSONObject();
    int j;
    try
    {
      if (((ConcurrentHashMap)localObject3).size() <= 0) {
        break label349;
      }
      ((JSONObject)???).put("cmd", "chat_list_count");
      ((JSONObject)???).put("listCount", i);
      localJSONArray.put(???);
      j = 0;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject3 = ((ConcurrentHashMap)localObject3).values().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          auhk localauhk = (auhk)((Iterator)localObject3).next();
          i = j;
          if (localauhk.jdField_c_of_type_Boolean) {
            i = j + 1;
          }
          j = i;
          if (!localauhk.jdField_a_of_type_Boolean)
          {
            JSONObject localJSONObject = new JSONObject();
            String str2 = localauhk.jdField_a_of_type_JavaLangString;
            j = localauhk.jdField_a_of_type_Int;
            localJSONObject.put("cmd", "chat_ready");
            localJSONObject.put("chatUin", str2);
            localJSONObject.put("chatType", aujq.b(j));
            localJSONObject.put("dbSize", localauhk.jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject);
            localauhk.jdField_a_of_type_Boolean = true;
            j = i;
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return "[]";
    }
    if ((3 == paramInt) && (this.jdField_a_of_type_Augk != null)) {
      this.jdField_a_of_type_Augk.a(j, augo.jdField_b_of_type_Int);
    }
    label349:
    String str1 = localJSONException.toString();
    return str1;
  }
  
  private void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (a()) {
      aujq.b("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    long l = aujq.a();
    String str1 = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
    String str2 = "getmsg?fid=" + l + "&chatUin=" + paramString + "&chatType=" + aujq.b(paramInt);
    str1 = str1 + aujq.b(str2, this.jdField_a_of_type_JavaLangString);
    str2 = aujq.a(paramString, aujq.b(paramInt), null);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", url = " + str1 + ", path = " + str2);
    }
    auhl localauhl = new auhl();
    localauhl.jdField_a_of_type_Boolean = true;
    localauhl.jdField_a_of_type_Short = 0;
    localauhl.jdField_b_of_type_JavaLangString = str2;
    localauhl.c = str1;
    paramString = aujq.a(paramString, aujq.b(paramInt));
    ConcurrentHashMap localConcurrentHashMap = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    aujo.a();
    Object localObject = aujo.a;
    ((aujl)localObject).m += 1L;
    localObject = (auhk)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((auhk)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localauhl);
      localauhl.jdField_b_of_type_Long = ((auhk)localObject).jdField_a_of_type_Long;
      localauhl.jdField_b_of_type_Boolean = aujq.a(((auhk)localObject).jdField_a_of_type_Long);
      aujl localaujl = aujo.a;
      localaujl.f += localauhl.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile , sessionInfo.dbMList = " + ((auhk)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap + ". sessionInfo.hashcode = " + localObject.hashCode() + ", task.isSmallerFile = " + localauhl.jdField_b_of_type_Boolean);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", mClientCanRecvMList = " + localConcurrentHashMap + ", keyFromUin = " + paramString + ", task.isSmallerFile = " + localauhl.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, str1, str2, localauhl.jdField_b_of_type_Boolean, localauhl.jdField_b_of_type_Long, false);
    boolean bool = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Augk != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      aujq.b("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((this.jdField_a_of_type_Augk == null) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Augk.c(true);
      return;
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, auhl> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    auhl localauhl = new auhl();
    localauhl.jdField_a_of_type_Short = 0;
    localauhl.jdField_a_of_type_Boolean = false;
    localauhl.jdField_a_of_type_JavaLangString = paramString;
    localauhl.jdField_a_of_type_Long = paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = " + paramLong2 + ", msg = " + paramString);
    }
    paramConcurrentHashMap.put(Long.valueOf(paramLong2), localauhl);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong1, paramLong2, paramString);
  }
  
  private void b(int paramInt1, int paramInt2, int paramInt3, String arg4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "recvMessageUdp udpdetected = " + this.jdField_c_of_type_Boolean + ", ipFrom = " + paramInt1 + ", port = " + paramInt2 + ", cmd = " + paramInt3 + ", cookie = " + paramLong + ", data = " + ???);
    }
    if (paramInt3 == 256) {}
    Object localObject1;
    label132:
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      return;
      if (paramInt3 == 257) {
        try
        {
          localObject1 = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
          ??? = new JSONArray(???);
          if (???.length() >= 1)
          {
            paramInt1 = 0;
            if (paramInt1 < ???.length())
            {
              localObject3 = (JSONObject)???.get(paramInt1);
              localObject4 = ((JSONObject)localObject3).optString("cmd");
              if ("chat_list_count".equals(localObject4))
              {
                augo.jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("listCount");
                aujo.a();
                aujo.a.jdField_b_of_type_Long = augo.jdField_b_of_type_Int;
              }
              if (!"chat_ready".equals(localObject4)) {
                break label809;
              }
              localObject4 = ((JSONObject)localObject3).optString("chatUin");
              paramInt2 = ((JSONObject)localObject3).optInt("chatType");
              paramLong = ((JSONObject)localObject3).optLong("dbSize");
              localObject3 = new auhk();
              ((auhk)localObject3).jdField_c_of_type_Boolean = false;
              ((auhk)localObject3).jdField_b_of_type_Boolean = false;
              ((auhk)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
              ((auhk)localObject3).jdField_a_of_type_Int = aujq.c(paramInt2);
              ((auhk)localObject3).jdField_a_of_type_Long = paramLong;
              localObject4 = aujq.a(((auhk)localObject3).jdField_a_of_type_JavaLangString, paramInt2);
              if (((ConcurrentHashMap)localObject1).get(localObject4) != null) {
                break label809;
              }
              ((ConcurrentHashMap)localObject1).put(localObject4, localObject3);
              break label809;
            }
            a(3);
            return;
          }
        }
        catch (JSONException ???)
        {
          QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", ???);
          return;
        }
      }
    }
    if (paramInt3 == 258)
    {
      try
      {
        localObject1 = augo.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        ??? = new JSONArray(???);
        if (???.length() >= 1)
        {
          paramInt1 = 0;
          label366:
          if (paramInt1 < ???.length())
          {
            localObject4 = (JSONObject)???.get(paramInt1);
            ((JSONObject)localObject4).optString("cmd");
            localObject3 = ((JSONObject)localObject4).optString("chatUin");
            paramInt2 = ((JSONObject)localObject4).optInt("chatType");
            localObject4 = aujq.a((String)localObject3, paramInt2);
            auhk localauhk = (auhk)((ConcurrentHashMap)localObject1).get(localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! keyFromUin = " + (String)localObject4 + ", mMList = " + localObject1);
            }
            if (localauhk != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "udp 通知 此会话接受完成 chatUin = " + (String)localObject3 + ", uinType = " + aujq.c(paramInt2));
              }
              localauhk.jdField_c_of_type_Boolean = true;
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! chatUin = " + (String)localObject3 + ", chatType = " + paramInt2);
            }
          }
        }
      }
      catch (JSONException ???)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", ???);
        return;
      }
      paramInt1 = 0;
    }
    label806:
    label809:
    label823:
    for (;;)
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            if (!((auhk)((Iterator)localObject1).next()).jdField_c_of_type_Boolean) {
              break label806;
            }
            paramInt1 += 1;
            break label823;
          }
          if (this.jdField_a_of_type_Augk == null) {
            break;
          }
          this.jdField_a_of_type_Augk.a(paramInt1, augo.jdField_b_of_type_Int);
          return;
        }
        if (paramInt3 != 259) {
          break;
        }
        try
        {
          ??? = new JSONArray(???);
          if (???.length() != 1) {
            break;
          }
          ??? = (JSONObject)???.get(0);
          if (!"exit".equals(???.optString("cmd"))) {
            break;
          }
          ??? = ???.optString("sig");
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "-------------------exit-------------------");
          }
          if ((!TextUtils.equals(???, augd.a().a())) || (this.jdField_a_of_type_Augk == null)) {
            break;
          }
          this.jdField_a_of_type_Augk.b(true);
          return;
        }
        catch (JSONException ???)
        {
          QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_EXIT parse json error!", ???);
          return;
        }
      }
      break label823;
      paramInt1 += 1;
      break label132;
      paramInt1 += 1;
      break label366;
    }
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    ??? = paramString;
    if (aujq.jdField_b_of_type_Boolean) {
      ??? = aujq.a(paramString, this.jdField_a_of_type_JavaLangString);
    }
    aujo.a();
    ConcurrentHashMap localConcurrentHashMap = augo.a().g;
    paramString = augo.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, MsgBackupManager.curDealType = " + augo.jdField_d_of_type_JavaLangString + ", MsgBackupManager.curDealType = " + augo.jdField_c_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (??? != null))
    {
      if (!((String)???).contains("/postinfo?")) {
        break label1119;
      }
      if (!a()) {
        break label127;
      }
      aujq.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
    }
    label127:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + (String)???);
      }
      ??? = aujq.a((String)???);
      if (!augo.jdField_f_of_type_Boolean)
      {
        l = Long.parseLong((String)((Map)???).get("fid"));
        paramString = new auhl();
        paramString.jdField_a_of_type_Short = 0;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_a_of_type_JavaLangString = "[]";
        paramString.jdField_a_of_type_Long = paramLong;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, postinfo ui is not ready!" + l + ", msg = " + "[]");
        }
        localConcurrentHashMap.put(Long.valueOf(l), paramString);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
        return;
      }
      if (((Map)???).size() == 1)
      {
        if (a())
        {
          aujq.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        l = Long.parseLong((String)((Map)???).get("fid"));
        a(paramLong, localConcurrentHashMap, l, a(l, 1));
        return;
      }
      if (!TextUtils.isEmpty((CharSequence)((Map)???).get("exit")))
      {
        if (a())
        {
          aujq.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        l = Long.parseLong((String)((Map)???).get("fid"));
        if ((!TextUtils.isEmpty((String)((Map)???).get("exit"))) && (this.jdField_a_of_type_Augk != null)) {
          this.jdField_a_of_type_Augk.b(true);
        }
        paramString = new auhl();
        paramString.jdField_a_of_type_Short = 0;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_a_of_type_JavaLangString = "[]";
        paramString.jdField_a_of_type_Long = paramLong;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, notify has exit!, fid = " + l + ", msg = " + "[]");
        }
        localConcurrentHashMap.put(Long.valueOf(l), paramString);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
        return;
      }
      if (((Map)???).size() == 4)
      {
        if (a())
        {
          aujq.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        l = Long.parseLong((String)((Map)???).get("fid"));
        if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = aujq.a((String)((Map)???).get("ip"));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = Integer.parseInt((String)((Map)???).get("udpport"));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = aujq.a((String)((Map)???).get("ip"));
          this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = Integer.parseInt((String)((Map)???).get("tcpport"));
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report its port and ipv4, fid = " + l + ", msg = []");
        }
        a(paramLong, localConcurrentHashMap, l, a(l, 2));
        return;
      }
    } while (((Map)???).size() < 3);
    if (a())
    {
      aujq.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)((Map)???).get("fid"));
    Object localObject2 = (String)((Map)???).get("chatUin");
    paramInt1 = Integer.parseInt((String)((Map)???).get("chatType"));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report 会话 uin =" + (String)localObject2 + " 接收完成, chatType = " + paramInt1 + "：mServerReadyMList.size = " + paramString.size());
    }
    ??? = (auhk)paramString.get(aujq.a((String)localObject2, paramInt1));
    if (??? != null)
    {
      ((auhk)???).jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Augk != null) {
        paramInt1 = 0;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = paramString.values().iterator();
      label960:
      if (paramString.hasNext())
      {
        if (!((auhk)paramString.next()).jdField_c_of_type_Boolean) {
          break label2151;
        }
        paramInt1 += 1;
        break label2151;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report session completed! hasCompletedCount = " + paramInt1);
      }
      if (this.jdField_a_of_type_Augk != null) {
        this.jdField_a_of_type_Augk.a(paramInt1, augo.jdField_b_of_type_Int);
      }
      if ((paramInt1 != augo.jdField_b_of_type_Int) || (QLog.isColorLevel())) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report session transport completed! fid = " + l + ", msg = []");
      }
      a(paramLong, localConcurrentHashMap, l, a(l, 3));
      return;
    }
    label1119:
    if (((String)???).contains("/getmsg?"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + (String)???);
      }
      if (a())
      {
        aujq.b("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      boolean bool2 = this.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Augk != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        aujq.b("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((this.jdField_a_of_type_Augk != null) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Augk.c(true);
        }
        localObject2 = aujq.a((String)???);
        l = Long.parseLong((String)((Map)localObject2).get("fid"));
        if (augo.jdField_f_of_type_Boolean) {
          break;
        }
        paramString = new auhl();
        paramString.jdField_a_of_type_Short = 0;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_a_of_type_JavaLangString = "[]";
        paramString.jdField_a_of_type_Long = paramLong;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, getmsg ui is not ready!" + l + ", msg = " + "[]");
        }
        localConcurrentHashMap.put(Long.valueOf(l), paramString);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
        return;
      }
      ??? = new aujn();
      ((aujn)???).jdField_a_of_type_Boolean = false;
      ((aujn)???).jdField_a_of_type_Long = 0L;
      augo.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), ???);
      ??? = (String)((Map)localObject2).get("chatUin");
      paramInt2 = Integer.parseInt((String)((Map)localObject2).get("chatType"));
      localObject2 = aujq.a((String)???, paramInt2, null);
      ??? = new auhl();
      ((auhl)???).jdField_a_of_type_Short = 0;
      ((auhl)???).jdField_a_of_type_Boolean = true;
      ((auhl)???).jdField_a_of_type_Long = paramLong;
      ((auhl)???).jdField_b_of_type_JavaLangString = ((String)localObject2);
      localConcurrentHashMap.put(Long.valueOf(l), ???);
      paramInt1 = 0;
    }
    label2148:
    label2151:
    label2154:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramString = paramString.values().iterator();
        if (paramString.hasNext())
        {
          if (!((auhk)paramString.next()).jdField_c_of_type_Boolean) {
            break label2148;
          }
          paramInt1 += 1;
          break label2154;
        }
        if (this.jdField_a_of_type_Augk != null) {
          this.jdField_a_of_type_Augk.a(paramInt1, augo.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, (String)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send db uin = " + (String)??? + ", uinType = " + aujq.c(paramInt2) + ", dbpath = " + (String)localObject2 + ", fid = " + l + ", mFidMList.size = " + localConcurrentHashMap.size());
        return;
      }
      if (((String)???).contains("/getres?"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + (String)???);
        }
        if (a())
        {
          aujq.b("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        paramString = aujo.a;
        paramString.jdField_d_of_type_Long += 1L;
        paramString = aujo.a;
        paramString.g += 1L;
        paramString = aujq.a((String)???);
        l = Long.parseLong((String)paramString.get("fid"));
        ??? = (String)paramString.get("filepath");
        aujq.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), ??? });
        paramString = (String)???;
        if (aujq.jdField_c_of_type_Boolean) {
          paramString = Uri.decode((String)???);
        }
        aujq.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), paramString });
        ??? = new aujn();
        ((aujn)???).jdField_a_of_type_Boolean = false;
        ((aujn)???).jdField_a_of_type_Long = 0L;
        augo.a().e.put(Long.valueOf(l), ???);
        ??? = new auhl();
        ((auhl)???).jdField_a_of_type_Short = 0;
        ((auhl)???).jdField_a_of_type_Boolean = true;
        ((auhl)???).jdField_b_of_type_JavaLangString = aujq.a(paramString);
        ((auhl)???).jdField_a_of_type_Long = paramLong;
        localConcurrentHashMap.put(Long.valueOf(l), ???);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, ((auhl)???).jdField_b_of_type_JavaLangString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send res file, fileRes path = " + ((auhl)???).jdField_b_of_type_JavaLangString + ", mFidMList.size = " + localConcurrentHashMap.size());
        return;
      }
      if (a())
      {
        aujq.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
        return;
      }
      paramString = (String)aujq.a((String)???).get("fid");
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      l = Long.parseLong(paramString);
      aujq.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.refuseFileRequest(this.jdField_a_of_type_Long, paramLong, l, "404");
      return;
      break label2154;
      break label960;
    }
  }
  
  private void b(long paramLong1, String arg3, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject1 = ???;
    if (aujq.jdField_b_of_type_Boolean) {
      localObject1 = aujq.b(???, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_a_of_type_JavaLangString);
    }
    ??? = augo.a().g;
    Object localObject2 = (auhl)???.get(Long.valueOf(paramLong1));
    ConcurrentHashMap localConcurrentHashMap = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted called! mfidMlist.size = " + ???.size() + ", mClientCanRecvMList.size = " + localConcurrentHashMap.size() + ", path = " + paramString2 + ",url = " + (String)localObject1 + ", fid = " + paramLong1 + ",errorCode = " + paramInt1 + ", task = " + localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted: mFidMList " + ???.toString() + ", MsgBackupManager.sessionCount = " + augo.jdField_b_of_type_Int);
    }
    if (localObject2 != null) {
      if (paramInt1 == 0)
      {
        ???.remove(Long.valueOf(paramLong1));
        if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (TextUtils.isEmpty(paramString2)))
        {
          if (!a()) {
            break label262;
          }
          aujq.b("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
        }
        for (;;)
        {
          return;
          label262:
          ??? = "";
          if (paramArrayOfByte != null) {}
          try
          {
            ??? = new String(paramArrayOfByte, "utf-8");
            if (!TextUtils.isEmpty(???))
            {
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, fid = " + paramLong1 + ", url = " + (String)localObject1 + ", errCode = " + paramInt1 + ", context = " + paramLong2 + ", json = " + ???);
              }
              for (;;)
              {
                try
                {
                  ??? = new JSONArray(???);
                  if (???.length() <= 0) {
                    break label895;
                  }
                  paramString2 = (JSONObject)???.get(0);
                  if (!"chat_list_count".equals(paramString2.optString("cmd"))) {
                    break label704;
                  }
                  augo.jdField_b_of_type_Int = paramString2.optInt("listCount");
                  aujo.a();
                  aujo.a.jdField_b_of_type_Long = augo.jdField_b_of_type_Int;
                  if (!QLog.isColorLevel()) {
                    break label3170;
                  }
                  QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = " + augo.jdField_b_of_type_Int);
                }
                catch (JSONException ???)
                {
                  label466:
                  QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted parse json error!", ???);
                  return;
                }
                if (paramInt1 >= ???.length()) {
                  continue;
                }
                paramArrayOfByte = (JSONObject)???.get(paramInt1);
                if ("chat_ready".equals(paramArrayOfByte.optString("cmd")))
                {
                  paramString2 = paramArrayOfByte.optString("chatUin");
                  paramInt2 = paramArrayOfByte.optInt("chatType");
                  paramLong1 = paramArrayOfByte.optLong("dbSize");
                  paramArrayOfByte = new auhk();
                  paramArrayOfByte.jdField_b_of_type_Boolean = false;
                  paramArrayOfByte.jdField_a_of_type_JavaLangString = paramString2;
                  paramArrayOfByte.jdField_a_of_type_Int = aujq.c(paramInt2);
                  paramArrayOfByte.jdField_a_of_type_Long = paramLong1;
                  localObject1 = aujq.a(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramInt2);
                  if (localConcurrentHashMap.get(localObject1) == null) {
                    localConcurrentHashMap.put(localObject1, paramArrayOfByte);
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + paramString2 + ", uintype = " + paramArrayOfByte.jdField_a_of_type_Int + "：mClientCanRecvMList= " + localConcurrentHashMap);
                  }
                }
                paramInt1 += 1;
              }
            }
          }
          catch (Exception ???)
          {
            for (;;)
            {
              aujq.b("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
              ??? = "";
            }
            a(4);
            return;
          }
        }
        label704:
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      if (paramInt1 < ???.length())
      {
        paramArrayOfByte = (JSONObject)???.get(paramInt1);
        if ("chat_ready".equals(paramArrayOfByte.optString("cmd")))
        {
          paramString2 = paramArrayOfByte.optString("chatUin");
          paramInt2 = paramArrayOfByte.optInt("chatType");
          paramLong1 = paramArrayOfByte.optLong("dbSize");
          paramArrayOfByte = new auhk();
          paramArrayOfByte.jdField_b_of_type_Boolean = false;
          paramArrayOfByte.jdField_a_of_type_JavaLangString = paramString2;
          paramArrayOfByte.jdField_a_of_type_Long = paramLong1;
          paramArrayOfByte.jdField_a_of_type_Int = aujq.c(paramInt2);
          localConcurrentHashMap.put(aujq.a(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramInt2), paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + paramString2 + ", uintype = " + paramArrayOfByte.jdField_a_of_type_Int + "：mClientCanRecvMList.size = " + localConcurrentHashMap.size());
          }
        }
      }
      else
      {
        a(4);
        return;
        label895:
        if ((localConcurrentHashMap.size() >= augo.jdField_b_of_type_Int) && (augo.jdField_b_of_type_Int > 0)) {
          break;
        }
        aujq.b("client cache is deal completedly! so get next session!", new Object[0]);
        f(3);
        return;
        if (((auhl)localObject2).jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mfidMlist fileTask receivedCompleted  called not success, so again task = " + localObject2);
          }
          if ((TextUtils.isEmpty(((auhl)localObject2).jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(((auhl)localObject2).c))) {
            break;
          }
          if (((auhl)localObject2).jdField_a_of_type_Short > 3)
          {
            ???.remove(Long.valueOf(paramLong1));
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localObject2);
            return;
          }
          if (a())
          {
            aujq.b("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
            return;
          }
          ((auhl)localObject2).jdField_a_of_type_Short = ((short)(((auhl)localObject2).jdField_a_of_type_Short + 1));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, ((auhl)localObject2).c, ((auhl)localObject2).jdField_b_of_type_JavaLangString, ((auhl)localObject2).jdField_b_of_type_Boolean, ((auhl)localObject2).jdField_b_of_type_Long, true);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist called not success, so again task = " + localObject2);
        }
        if (TextUtils.isEmpty(((auhl)localObject2).c)) {
          break;
        }
        if (((auhl)localObject2).jdField_a_of_type_Short > 3)
        {
          ???.remove(Long.valueOf(paramLong1));
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist retry over time task = " + localObject2);
          return;
        }
        if (a())
        {
          aujq.b("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        ((auhl)localObject2).jdField_a_of_type_Short = ((short)(((auhl)localObject2).jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, ((auhl)localObject2).c);
        return;
        paramArrayOfByte = aujq.a(augo.jdField_d_of_type_JavaLangString, aujq.b(augo.jdField_c_of_type_Int));
        ??? = (auhk)localConcurrentHashMap.get(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted key = " + paramArrayOfByte + ", mClientCanRecvMList = " + localConcurrentHashMap + ", sessionInfo = " + ??? + ", errCode = " + paramInt1);
        }
        if (??? == null) {
          break;
        }
        paramArrayOfByte = ???.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject1 = ???.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject2 = (auhl)paramArrayOfByte.get(Long.valueOf(paramLong1));
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  dbMList task = " + localObject2 + ", dbMList = " + paramArrayOfByte.toString() + ". sessionInfo.hashcode = " + ???.hashCode());
        }
        if (localObject2 != null)
        {
          if (paramInt1 == 0)
          {
            paramArrayOfByte.remove(Long.valueOf(paramLong1));
            if (!paramString2.endsWith(".db")) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, path = " + paramString2 + ", dbMList.size = " + paramArrayOfByte.size() + ", resMList.size = " + ((ConcurrentHashMap)localObject1).size());
            }
            ??? = paramString2.substring(paramString2.lastIndexOf("/") + 1);
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, dbName = " + ???);
            }
            ??? = new augu();
            ???.jdField_a_of_type_Int = 1;
            ???.jdField_a_of_type_JavaLangString = paramString2;
            augo.a().b(???);
            return;
          }
          if (!((auhl)localObject2).jdField_a_of_type_Boolean) {
            break;
          }
          aujo.a();
          paramString2 = aujo.a;
          paramString2.n += 1L;
          paramString2 = aujo.a;
          paramString2.r += 1L;
          paramString2 = new aujm();
          paramString2.jdField_b_of_type_Int = 1;
          paramString2.jdField_c_of_type_Int = 0;
          paramString2.jdField_a_of_type_Int = paramInt1;
          aujo.a.a.add(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "dbMList receivedCompleted  called not success, so again task = " + localObject2);
          }
          if ((TextUtils.isEmpty(((auhl)localObject2).jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(((auhl)localObject2).c))) {
            break;
          }
          if ((((auhl)localObject2).jdField_a_of_type_Short > 3) && (this.jdField_d_of_type_Boolean))
          {
            augo.jdField_a_of_type_Int += 1;
            aujq.b("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(augo.jdField_a_of_type_Int) });
            paramArrayOfByte.remove(Long.valueOf(paramLong1));
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.jdField_d_of_type_Boolean + ", 此会话db一直失败，扔掉，通知对端dbMList receivedCompleted retry over time task = " + localObject2);
            ???.jdField_c_of_type_Boolean = true;
            if (this.jdField_c_of_type_Boolean)
            {
              e(258);
              label1842:
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup", 2, "getdb failed !  mclient will get db mClientCanRecvMList.size = " + localConcurrentHashMap.size());
              }
              paramInt1 = 0;
            }
          }
        }
        label2636:
        label3161:
        label3164:
        label3167:
        for (;;)
        {
          boolean bool;
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            paramString2 = localConcurrentHashMap.values().iterator();
            if (paramString2.hasNext())
            {
              bool = ((auhk)paramString2.next()).jdField_c_of_type_Boolean;
              if (!bool) {
                break label3167;
              }
              paramInt1 += 1;
              continue;
              a(this.jdField_a_of_type_Long, false, ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Int);
              break label1842;
            }
            if (this.jdField_a_of_type_Augk != null) {
              this.jdField_a_of_type_Augk.a(paramInt1, augo.jdField_b_of_type_Int);
            }
            if ((paramInt1 == augo.jdField_b_of_type_Int) || (a(2))) {
              break;
            }
            aujq.b("this session db has received error! so get next session!", new Object[0]);
            f(3);
            return;
          }
          if (a())
          {
            aujq.b("recvFile panic error! dbMList receivedCompleted", new Object[0]);
            return;
          }
          ((auhl)localObject2).jdField_a_of_type_Short = ((short)(((auhl)localObject2).jdField_a_of_type_Short + 1));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, ((auhl)localObject2).c, ((auhl)localObject2).jdField_b_of_type_JavaLangString, ((auhl)localObject2).jdField_b_of_type_Boolean, ((auhl)localObject2).jdField_b_of_type_Long, false);
          return;
          paramString2 = (auhl)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called  task = " + paramString2 + ", resMList.size = " + ((ConcurrentHashMap)localObject1).size() + ", errCode = " + paramInt1);
          }
          if (paramString2 == null) {
            break;
          }
          if (paramInt1 == 0)
          {
            ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong1));
            paramInt1 = ((ConcurrentHashMap)localObject1).size();
            paramInt2 = paramArrayOfByte.size();
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called success, isResRequestAllFinished " + ???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", task = " + paramString2 + ", resMList.size = " + paramInt1);
            }
            if ((paramInt1 != 0) || (paramInt2 != 0) || (!???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
              break;
            }
            ???.jdField_c_of_type_Boolean = true;
            if (this.jdField_c_of_type_Boolean)
            {
              e(258);
              label2292:
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int + ", task = " + paramString2);
              }
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup", 2, "mclient will get db mClientCanRecvMList.size = " + localConcurrentHashMap.size());
              }
              paramInt1 = 0;
            }
          }
          for (;;)
          {
            synchronized (this.jdField_a_of_type_JavaLangObject)
            {
              paramString2 = localConcurrentHashMap.values().iterator();
              if (paramString2.hasNext())
              {
                bool = ((auhk)paramString2.next()).jdField_c_of_type_Boolean;
                if (!bool) {
                  break label3164;
                }
                paramInt1 += 1;
                continue;
                a(this.jdField_a_of_type_Long, false, ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Int);
                break label2292;
              }
              if (this.jdField_a_of_type_Augk != null) {
                this.jdField_a_of_type_Augk.a(paramInt1, augo.jdField_b_of_type_Int);
              }
              if ((paramInt1 == augo.jdField_b_of_type_Int) || (a(2))) {
                break;
              }
              aujq.b("this session res has received! so get next session!", new Object[0]);
              f(3);
              return;
            }
            if (!paramString2.jdField_a_of_type_Boolean) {
              break;
            }
            aujo.a();
            localObject2 = aujo.a;
            ((aujl)localObject2).h += 1L;
            localObject2 = aujo.a;
            ((aujl)localObject2).r += 1L;
            localObject2 = new aujm();
            if (augo.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(Long.valueOf(paramLong1)))
            {
              aujl localaujl = aujo.a;
              localaujl.k += 1L;
              augo.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(Long.valueOf(paramLong1));
              ((aujm)localObject2).jdField_c_of_type_Int = 2;
              ((aujm)localObject2).jdField_b_of_type_Int = 2;
              ((aujm)localObject2).jdField_a_of_type_Int = paramInt1;
              aujo.a.a.add(localObject2);
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "resReq fileTask receivedCompleted  called not success, so again task = " + paramString2);
              }
              if ((TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString2.c))) {
                break;
              }
              if ((paramString2.jdField_a_of_type_Short <= 3) || (!this.jdField_d_of_type_Boolean)) {
                break label3096;
              }
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.jdField_d_of_type_Boolean + ", isResRequestAllFinished" + ???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", resReq fileTask receivedCompleted retry over time task = " + paramString2);
              ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramLong1));
              paramInt1 = ((ConcurrentHashMap)localObject1).size();
              paramInt2 = paramArrayOfByte.size();
              if ((paramInt1 != 0) || (paramInt2 != 0) || (!???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())) {
                break;
              }
              ???.jdField_c_of_type_Boolean = true;
              if (!this.jdField_c_of_type_Boolean) {
                break label3014;
              }
              e(258);
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int + ", task = " + paramString2);
              }
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mclient will get db mClientCanRecvMList.size = " + localConcurrentHashMap.size());
              }
              paramInt1 = 0;
            }
            for (;;)
            {
              synchronized (this.jdField_a_of_type_JavaLangObject)
              {
                paramString2 = localConcurrentHashMap.values().iterator();
                if (paramString2.hasNext())
                {
                  bool = ((auhk)paramString2.next()).jdField_c_of_type_Boolean;
                  if (!bool) {
                    break label3161;
                  }
                  paramInt1 += 1;
                  continue;
                  ((aujm)localObject2).jdField_c_of_type_Int = 1;
                  break label2636;
                  a(this.jdField_a_of_type_Long, false, ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Int);
                  break label2851;
                }
                if (this.jdField_a_of_type_Augk != null) {
                  this.jdField_a_of_type_Augk.a(paramInt1, augo.jdField_b_of_type_Int);
                }
                if ((paramInt1 == augo.jdField_b_of_type_Int) || (a(2))) {
                  break;
                }
                aujq.b("this session res has received! over time  so get next session!", new Object[0]);
                f(3);
                return;
              }
              if (a())
              {
                aujq.b("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
                return;
              }
              paramString2.jdField_a_of_type_Short = ((short)(paramString2.jdField_a_of_type_Short + 1));
              this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, paramString2.c, paramString2.jdField_b_of_type_JavaLangString, paramString2.jdField_b_of_type_Boolean, paramString2.jdField_b_of_type_Long, true);
              return;
            }
          }
        }
        label2851:
        label3014:
        label3170:
        paramInt1 = 1;
        label3096:
        break label466;
      }
      paramInt1 += 1;
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.stop(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.destroySession(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
    aujg.a().a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public MsgBackupEndPoint a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  }
  
  public String a(int paramInt, long paramLong)
  {
    int j = 0;
    Object localObject1 = new JSONArray();
    if (paramInt == 256) {}
    for (;;)
    {
      Object localObject3;
      try
      {
        ??? = ((JSONArray)localObject1).toString();
        localObject1 = augo.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject3 = new auhl();
        ((auhl)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((auhl)localObject3).jdField_a_of_type_Int = paramInt;
        ((auhl)localObject3).jdField_a_of_type_Short = 0;
        ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
        localObject1 = ???;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "getSessionJson, cookie = " + paramLong + ", msg = " + (String)???);
        return ???;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return "[]";
      }
      int i;
      Object localObject4;
      Object localObject5;
      if (paramInt == 257)
      {
        if (!augo.jdField_f_of_type_Boolean)
        {
          ??? = ((JSONArray)localObject1).toString();
          localObject1 = augo.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localObject3 = new auhl();
          ((auhl)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
          ((auhl)localObject3).jdField_a_of_type_Int = paramInt;
          ((auhl)localObject3).jdField_a_of_type_Short = 0;
          ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
          localObject1 = ???;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "MsgBackupManager.sUIReady = " + augo.jdField_f_of_type_Boolean + ", getSessionJson is called! cookie = " + paramLong + ", msg = " + (String)???);
          return ???;
        }
        ??? = augo.a().jdField_a_of_type_JavaUtilHashSet;
        localObject3 = augo.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        i = augo.jdField_b_of_type_Int;
        if (((ConcurrentHashMap)localObject3).size() > 0)
        {
          ??? = new JSONObject();
          ((JSONObject)???).put("cmd", "chat_list_count");
          ((JSONObject)???).put("listCount", i);
          localJSONException.put(???);
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            localObject3 = ((ConcurrentHashMap)localObject3).values().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (auhk)((Iterator)localObject3).next();
              i = j;
              if (((auhk)localObject4).jdField_c_of_type_Boolean) {
                i = j + 1;
              }
              j = i;
              if (!((auhk)localObject4).jdField_a_of_type_Boolean)
              {
                localObject5 = ((auhk)localObject4).jdField_a_of_type_JavaLangString;
                j = ((auhk)localObject4).jdField_a_of_type_Int;
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("cmd", "chat_ready");
                localJSONObject.put("chatUin", localObject5);
                localJSONObject.put("chatType", aujq.b(j));
                localJSONObject.put("dbSize", ((auhk)localObject4).jdField_a_of_type_Long);
                localJSONException.put(localJSONObject);
                ((auhk)localObject4).jdField_a_of_type_Boolean = true;
                j = i;
              }
            }
          }
          if (this.jdField_a_of_type_Augk != null) {
            this.jdField_a_of_type_Augk.a(j, augo.jdField_b_of_type_Int);
          }
        }
      }
      else if (paramInt == 258)
      {
        ??? = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (auhk)((Iterator)???).next();
          if ((!((auhk)localObject3).jdField_d_of_type_Boolean) && (((auhk)localObject3).jdField_c_of_type_Boolean))
          {
            localObject4 = ((auhk)localObject3).jdField_a_of_type_JavaLangString;
            i = ((auhk)localObject3).jdField_a_of_type_Int;
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("cmd", "chat_transfer_complete");
            ((JSONObject)localObject5).put("chatUin", localObject4);
            ((JSONObject)localObject5).put("chatType", aujq.b(i));
            str.put(localObject5);
            ((auhk)localObject3).jdField_d_of_type_Boolean = true;
          }
        }
      }
      else if (paramInt == 259)
      {
        ??? = new JSONObject();
        ((JSONObject)???).put("cmd", "exit");
        ((JSONObject)???).put("sig", augd.a().a());
        str.put(???);
      }
    }
    return str;
  }
  
  public String a(String paramString)
  {
    return aujq.a(paramString, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (!a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "stop called! operator = " + this.jdField_a_of_type_Long + ". from = " + paramInt);
      }
      augo.a().b();
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.5(this));
      }
    }
    else
    {
      return;
    }
    f();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null) && (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = paramInt1;
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = paramInt2;
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null)) {
      return;
    }
    this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = paramInt1;
    this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = paramInt1;
    this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong)
  {
    b(paramInt1, paramInt2, paramInt3, paramString, paramLong);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    aujp.a(paramLong1, paramLong2);
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong3;
        if (this.jdField_a_of_type_Augk != null)
        {
          this.jdField_a_of_type_Augk.a(1000L * paramLong3 / paramLong2);
          aujp.b(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
      }
      this.jdField_c_of_type_Long += paramLong3;
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long += paramLong3;
  }
  
  public void a(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    aujq.b("MsgBackup_MsgBackupTransportProcessor", "onRecvComplete from jni fid = %d,url = %s,errcode = %d,path = %s ", new Object[] { Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramInt1), paramString2 });
    aujp.a(paramLong1);
    b(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    aujp.a(paramLong1, paramLong3);
    aujo.a();
    if (augo.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (aujn)augo.a().e.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_a_of_type_Long = paramLong3;
        paramString = aujo.a;
        paramString.e += paramLong3;
      }
    }
    while (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong4;
        if (this.jdField_a_of_type_Augk != null)
        {
          this.jdField_a_of_type_Augk.a(1000L * paramLong3 / paramLong2);
          aujp.b(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
        if (augo.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
        {
          paramString = (aujn)augo.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
          if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
          {
            paramString.jdField_a_of_type_Boolean = true;
            paramString.jdField_a_of_type_Long = paramLong3;
            paramString = aujo.a;
            paramString.f += paramLong3;
          }
        }
      }
      else
      {
        this.jdField_c_of_type_Long += paramLong4;
        return;
      }
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long += paramLong4;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void a(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    aujp.a(paramLong1);
    aujo.a();
    Object localObject;
    label184:
    auhl localauhl;
    if (augo.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (aujn)augo.a().e.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = aujq.a(((aujn)localObject).jdField_a_of_type_Long);
        if (bool)
        {
          localObject = aujo.a;
          ((aujl)localObject).j += 1L;
        }
        if (!paramBoolean)
        {
          localObject = aujo.a;
          ((aujl)localObject).r += 1L;
          localObject = new aujm();
          ((aujm)localObject).jdField_b_of_type_Int = 2;
          if (!bool) {
            break label273;
          }
          paramInt2 = 2;
          ((aujm)localObject).jdField_c_of_type_Int = paramInt2;
          ((aujm)localObject).jdField_a_of_type_Int = paramInt1;
          aujo.a.a.add(localObject);
          if (bool)
          {
            localObject = aujo.a;
            ((aujl)localObject).k += 1L;
          }
        }
      }
      augo.a().e.remove(Long.valueOf(paramLong1));
      localObject = augo.a().g;
      localauhl = (auhl)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localauhl == null) {
        break label724;
      }
      if (!paramBoolean) {
        break label426;
      }
      ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  task = " + localauhl + ", mFidMList.size = " + ((ConcurrentHashMap)localObject).size());
      }
    }
    label273:
    label426:
    label579:
    label724:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          return;
          paramInt2 = 1;
          break;
          if (!augo.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
            break label184;
          }
          if ((aujn)augo.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1)) != null)
          {
            localObject = aujo.a;
            ((aujl)localObject).m += 1L;
            if (!paramBoolean)
            {
              localObject = aujo.a;
              ((aujl)localObject).n += 1L;
              localObject = aujo.a;
              ((aujl)localObject).r += 1L;
              localObject = new aujm();
              ((aujm)localObject).jdField_b_of_type_Int = 1;
              ((aujm)localObject).jdField_c_of_type_Int = 0;
              ((aujm)localObject).jdField_a_of_type_Int = paramInt1;
              aujo.a.a.add(localObject);
            }
          }
          augo.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
          break label184;
          if (!localauhl.jdField_a_of_type_Boolean) {
            break label579;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "fileTask onSendComplete  called not success, so again  task = " + localauhl);
          }
        } while (TextUtils.isEmpty(localauhl.jdField_b_of_type_JavaLangString));
        if (localauhl.jdField_a_of_type_Short > 3)
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete fileTask  retry over time task = " + localauhl);
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (a())
        {
          aujq.b("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        localauhl.jdField_a_of_type_Short = ((short)(localauhl.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, localauhl.jdField_a_of_type_Long, paramLong1, localauhl.jdField_b_of_type_JavaLangString);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called not success, so again task = " + localauhl);
        }
      } while (TextUtils.isEmpty(localauhl.jdField_a_of_type_JavaLangString));
      if (localauhl.jdField_a_of_type_Short > 3)
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete retry over time task = " + localauhl);
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        return;
      }
      if (a())
      {
        aujq.b("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      localauhl.jdField_a_of_type_Short = ((short)(localauhl.jdField_a_of_type_Short + 1));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, localauhl.jdField_a_of_type_Long, paramLong1, localauhl.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called, please check your mFidMList whether contains this task, before execute, should add in mFidMList!, path = " + paramString + ", fid = " + paramLong1);
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
      }
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Int != 1) || (!this.jdField_d_of_type_Boolean)) {
        break;
      }
      if (a())
      {
        aujq.b("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      long l = aujq.a();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = "postinfo?fid=" + l + "&chatUin=" + paramString + "&chatType=" + aujq.b(paramInt);
        aujq.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
        paramString = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + aujq.b(paramString, this.jdField_a_of_type_JavaLangString);
      }
      while ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
      {
        auhl localauhl = new auhl();
        localauhl.jdField_a_of_type_Short = 0;
        localauhl.jdField_a_of_type_Boolean = false;
        localauhl.c = paramString;
        augo.a().g.put(Long.valueOf(l), localauhl);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer fid = " + l + ", url = " + paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, paramString);
        return;
        if (paramBoolean)
        {
          paramString = "postinfo?fid=" + l + "&ip=" + aujq.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + "&tcpport=" + this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + "&udpport=" + this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port;
          aujq.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + aujq.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramString = "postinfo?fid=" + l;
          aujq.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + aujq.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    aujq.b("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
  }
  
  public void a(augk paramaugk)
  {
    this.jdField_a_of_type_Augk = paramaugk;
  }
  
  public void a(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      augo.a().a();
      aujq.a();
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      a(1);
      augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.1(this, paramString));
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    augo.a().a();
    aujq.a();
    augo.a().a().a(paramInt);
    augo.a().a().a(paramString2);
    augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a(1);
    if (paramInt == 1)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.3(this, paramString1));
    }
    if (paramInt == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.4(this, paramString1));
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (a()) {
      aujq.b("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      aujo.a();
      localObject = aujo.a;
      ((aujl)localObject).g += 1L;
      localObject = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((paramString1 != null) || (paramString2 != null)) {
        break;
      }
      aujq.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { augo.jdField_d_of_type_JavaLangString, Integer.valueOf(augo.jdField_c_of_type_Int) });
      paramString1 = (auhk)((ConcurrentHashMap)localObject).get(aujq.a(augo.jdField_d_of_type_JavaLangString, aujq.b(augo.jdField_c_of_type_Int)));
    } while (paramString1 == null);
    aujq.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    if ((paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) && (paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {
      a(6);
    }
    paramString1.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    return;
    new File(paramString2).getParentFile().mkdirs();
    long l = aujq.a();
    paramString1 = aujq.b(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l), paramString1 }), this.jdField_a_of_type_JavaLangString);
    paramString1 = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + paramString1;
    auhl localauhl = new auhl();
    localauhl.jdField_a_of_type_Short = 0;
    localauhl.jdField_a_of_type_Boolean = true;
    localauhl.jdField_b_of_type_JavaLangString = paramString2;
    localauhl.c = paramString1;
    localauhl.jdField_b_of_type_Boolean = aujq.a(paramLong);
    localauhl.jdField_b_of_type_Long = paramLong;
    aujl localaujl = aujo.a;
    localaujl.e += paramLong;
    Object localObject = (auhk)((ConcurrentHashMap)localObject).get(aujq.a(augo.jdField_d_of_type_JavaLangString, aujq.b(augo.jdField_c_of_type_Int)));
    if (localObject != null) {
      ((auhk)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localauhl);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, paramString1, paramString2, localauhl.jdField_b_of_type_Boolean, localauhl.jdField_b_of_type_Long, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    augo.a().a();
    aujq.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
    }
    a(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    aujo.a();
    aujo.a.jdField_b_of_type_Boolean = this.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject;
    auhl localauhl;
    if (2 == this.jdField_a_of_type_Int)
    {
      localObject = augo.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
      localauhl = (auhl)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localauhl != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_SERVER");
        }
        if (!paramBoolean) {
          break label98;
        }
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      }
    }
    label98:
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!a()) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
              return;
              if (localauhl.jdField_a_of_type_Short > 3)
              {
                ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localauhl);
                return;
              }
              localauhl.jdField_a_of_type_Short = ((short)(localauhl.jdField_a_of_type_Short + 1));
              localObject = localauhl.jdField_a_of_type_JavaLangString;
              i = localauhl.jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: " + localauhl);
              }
            } while (TextUtils.isEmpty((CharSequence)localObject));
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
            return;
          } while (1 != this.jdField_a_of_type_Int);
          localObject = augo.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localauhl = (auhl)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_CLIENT");
          }
        } while (localauhl == null);
        if (paramBoolean)
        {
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (!a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
      return;
      if (localauhl.jdField_a_of_type_Short > 3)
      {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localauhl);
        return;
      }
      localObject = localauhl.jdField_a_of_type_JavaLangString;
      i = localauhl.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage  role = MBRROLE_CLIENT: " + localauhl);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Long == 0L;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    int j = 0;
    boolean bool1 = false;
    Object localObject2;
    int i;
    try
    {
      if ((!this.jdField_d_of_type_Boolean) && (paramInt == 3))
      {
        this.e = true;
        aujq.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
        bool3 = bool1;
        return bool3;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, from = " + paramInt);
      }
      ConcurrentHashMap localConcurrentHashMap = augo.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (((paramInt != 1) && (paramInt != 6)) || (TextUtils.isEmpty(augo.jdField_d_of_type_JavaLangString))) {
        break label302;
      }
      localObject2 = (auhk)localConcurrentHashMap.get(aujq.a(augo.jdField_d_of_type_JavaLangString, aujq.b(augo.jdField_c_of_type_Int)));
      if (localObject2 == null) {
        break label302;
      }
      ((auhk)localObject2).jdField_c_of_type_Boolean = true;
      aujq.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { augo.jdField_d_of_type_JavaLangString, Integer.valueOf(augo.jdField_c_of_type_Int) });
      if (this.jdField_c_of_type_Boolean) {
        e(258);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Augk == null) {
          break label302;
        }
        localObject2 = localConcurrentHashMap.values().iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        if (!((auhk)((Iterator)localObject2).next()).jdField_c_of_type_Boolean) {
          break label1688;
        }
        i += 1;
        break label1688;
        a(this.jdField_a_of_type_Long, false, ((auhk)localObject2).jdField_a_of_type_JavaLangString, ((auhk)localObject2).jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Augk == null) {
        break label288;
      }
    }
    finally {}
    this.jdField_a_of_type_Augk.a(i, augo.jdField_b_of_type_Int);
    label288:
    label302:
    Object localObject3;
    if (((i != augo.jdField_b_of_type_Int) || (this.jdField_a_of_type_Augk == null)) || (!TextUtils.isEmpty(augo.jdField_d_of_type_JavaLangString)))
    {
      localObject2 = (auhk)localObject1.get(aujq.a(augo.jdField_d_of_type_JavaLangString, aujq.b(augo.jdField_c_of_type_Int)));
      if (localObject2 == null) {
        break label1677;
      }
      if (((auhk)localObject2).jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int);
        }
        localObject2 = localObject1.values().iterator();
        i = 0;
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1671;
          }
          localObject3 = (auhk)((Iterator)localObject2).next();
          if (!((auhk)localObject3).jdField_b_of_type_Boolean)
          {
            if (((auhk)localObject3).jdField_a_of_type_Long > 0L) {
              break label781;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + ((auhk)localObject3).jdField_a_of_type_JavaLangString + ", uintype = " + ((auhk)localObject3).jdField_a_of_type_Int + ", dbsize = " + ((auhk)localObject3).jdField_a_of_type_Long);
            }
            ((auhk)localObject3).jdField_c_of_type_Boolean = true;
            ((auhk)localObject3).jdField_b_of_type_Boolean = true;
            if (this.jdField_c_of_type_Boolean) {
              e(258);
            }
            while (this.jdField_a_of_type_Augk != null)
            {
              localObject3 = localObject1.values().iterator();
              i = 0;
              label557:
              if (!((Iterator)localObject3).hasNext()) {
                break label612;
              }
              if (!((auhk)((Iterator)localObject3).next()).jdField_c_of_type_Boolean) {
                break label1668;
              }
              i += 1;
              break label1691;
              a(this.jdField_a_of_type_Long, false, ((auhk)localObject3).jdField_a_of_type_JavaLangString, ((auhk)localObject3).jdField_a_of_type_Int);
            }
          }
        }
        label612:
        if (this.jdField_a_of_type_Augk != null) {
          this.jdField_a_of_type_Augk.a(i, augo.jdField_b_of_type_Int);
        }
        if (i != augo.jdField_b_of_type_Int) {
          break label1708;
        }
        aujq.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
        bool1 = false;
        break label1694;
      }
    }
    label781:
    label1293:
    for (;;)
    {
      label657:
      if ((localObject1.size() == 0) || (TextUtils.isEmpty(augo.jdField_d_of_type_JavaLangString)))
      {
        f(5);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step1");
        }
        label694:
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with from = " + paramInt + ", ret = " + bool2 + ". isCurDealing = " + bool1 + ", hasFinishedC = " + i + ", sessionCount = " + augo.jdField_b_of_type_Int);
        bool3 = bool2;
        break;
        localObject2 = localObject1.values().iterator();
        i = 0;
        label795:
        if (((Iterator)localObject2).hasNext())
        {
          if (!((auhk)((Iterator)localObject2).next()).jdField_c_of_type_Boolean) {
            break label1665;
          }
          i += 1;
          break label1711;
        }
        if (this.jdField_a_of_type_Augk != null) {
          this.jdField_a_of_type_Augk.a(i, augo.jdField_b_of_type_Int);
        }
        if (i == augo.jdField_b_of_type_Int)
        {
          aujq.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
          bool1 = false;
          break label1694;
        }
        ((auhk)localObject3).jdField_b_of_type_Boolean = true;
        augo.jdField_d_of_type_JavaLangString = ((auhk)localObject3).jdField_a_of_type_JavaLangString;
        augo.jdField_c_of_type_Int = ((auhk)localObject3).jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, current uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int + ", dbsize = " + ((auhk)localObject3).jdField_a_of_type_Long);
        }
        a(this.jdField_a_of_type_Long, ((auhk)localObject3).jdField_a_of_type_JavaLangString, ((auhk)localObject3).jdField_a_of_type_Int, false);
        bool1 = true;
        break label1694;
        if (!QLog.isColorLevel()) {
          break label1714;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "current session not completed! requestNextSessionDb !, current uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int);
        break label1714;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int);
        }
        localObject2 = localObject1.values().iterator();
        label1238:
        do
        {
          for (;;)
          {
            if (!((Iterator)localObject2).hasNext()) {
              break label1657;
            }
            localObject3 = (auhk)((Iterator)localObject2).next();
            if (!((auhk)localObject3).jdField_b_of_type_Boolean)
            {
              if (((auhk)localObject3).jdField_a_of_type_Long > 0L) {
                break label1376;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + ((auhk)localObject3).jdField_a_of_type_JavaLangString + ", uintype = " + ((auhk)localObject3).jdField_a_of_type_Int + ", dbSize = " + ((auhk)localObject3).jdField_a_of_type_Long);
              }
              ((auhk)localObject3).jdField_c_of_type_Boolean = true;
              ((auhk)localObject3).jdField_b_of_type_Boolean = true;
              if (this.jdField_c_of_type_Boolean) {
                e(258);
              }
              while (this.jdField_a_of_type_Augk != null)
              {
                localObject3 = localObject1.values().iterator();
                i = 0;
                if (!((Iterator)localObject3).hasNext()) {
                  break label1293;
                }
                if (!((auhk)((Iterator)localObject3).next()).jdField_c_of_type_Boolean) {
                  break label1654;
                }
                i += 1;
                break label1722;
                a(this.jdField_a_of_type_Long, false, ((auhk)localObject3).jdField_a_of_type_JavaLangString, ((auhk)localObject3).jdField_a_of_type_Int);
              }
            }
          }
          if ((this.jdField_a_of_type_Augk != null) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Augk.c(true);
          }
          if (this.jdField_a_of_type_Augk != null) {
            this.jdField_a_of_type_Augk.a(i, augo.jdField_b_of_type_Int);
          }
        } while ((i != augo.jdField_b_of_type_Int) || (this.jdField_a_of_type_Augk == null));
        aujq.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
        i = 0;
        bool1 = false;
        continue;
        label1376:
        ((auhk)localObject3).jdField_b_of_type_Boolean = true;
        augo.jdField_d_of_type_JavaLangString = ((auhk)localObject3).jdField_a_of_type_JavaLangString;
        augo.jdField_c_of_type_Int = ((auhk)localObject3).jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, uin = " + augo.jdField_d_of_type_JavaLangString + ", uintype = " + augo.jdField_c_of_type_Int + ", dbsize = " + ((auhk)localObject3).jdField_a_of_type_Long);
        }
        localObject2 = localObject1.values().iterator();
        i = 0;
      }
    }
    label1665:
    label1668:
    label1671:
    label1677:
    label1688:
    label1691:
    label1694:
    label1697:
    label1708:
    label1711:
    label1714:
    label1722:
    label1725:
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        if (((auhk)((Iterator)localObject2).next()).jdField_c_of_type_Boolean)
        {
          i += 1;
          break label1725;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Augk != null) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Augk.c(true);
        }
        if (this.jdField_a_of_type_Augk != null) {
          this.jdField_a_of_type_Augk.a(i, augo.jdField_b_of_type_Int);
        }
        if (i == augo.jdField_b_of_type_Int)
        {
          aujq.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
          i = 0;
          bool1 = false;
          break label657;
        }
        a(this.jdField_a_of_type_Long, ((auhk)localObject3).jdField_a_of_type_JavaLangString, ((auhk)localObject3).jdField_a_of_type_Int, false);
        i = 0;
        bool2 = true;
        bool1 = false;
        break label657;
        if ((bool2) || (bool1) || (i == augo.jdField_b_of_type_Int)) {
          break label694;
        }
        f(5);
        if (!QLog.isColorLevel()) {
          break label694;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step2");
        break label694;
      }
      break label1725;
      label1654:
      break label1722;
      label1657:
      i = 0;
      bool1 = false;
      break label657;
      break label1711;
      break label1691;
      bool1 = false;
      break label1694;
      bool3 = false;
      bool1 = false;
      i = j;
      break label1697;
      break;
      break label557;
      bool3 = false;
      for (;;)
      {
        bool2 = bool1;
        bool1 = bool3;
        break label657;
        break;
        break label795;
        bool1 = false;
        i = j;
      }
      break label1238;
    }
  }
  
  public MsgBackupEndPoint b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onDestroy called! operator = " + this.jdField_a_of_type_Long);
    }
    a();
    a(2);
  }
  
  public void b(int paramInt)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start panic error!");
      }
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
      {
        if (paramInt == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_SERVER");
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientTcpEndPoint.ipv4 = " + aujq.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", clientUdpEndpoint.port = " + this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", clientTcpEndPoint.port" + this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverUdpEndpoint.ipv4 = " + aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", serverUdpEndpoint.port = " + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", serverTcpEndPoint.port" + this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint end， operator = " + this.jdField_a_of_type_Long);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientTcpEndPoint.ipv4 = " + aujq.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", clientUdpEndpoint.port = " + this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", clientTcpEndPoint.port" + this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverUdpEndpoint.ipv4 = " + aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", serverUdpEndpoint.port = " + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", serverTcpEndPoint.port" + this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    aujp.g = 0L;
    aujp.a(null, "cost_connect_total");
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Augk != null) {
      this.jdField_a_of_type_Augk.b(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public MsgBackupEndPoint c()
  {
    return this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  }
  
  public void c()
  {
    int i = augd.a().a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exit ---------> bizType = " + i);
    }
    if (i == 3)
    {
      d();
      return;
    }
    if (i == 1)
    {
      e();
      return;
    }
    e();
  }
  
  public void c(int paramInt)
  {
    if (a()) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey panic error!");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    if (paramInt == 2) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_SERVER");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey end， session = " + this.jdField_a_of_type_Long + ", encryptkey = " + this.jdField_a_of_type_JavaLangString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_CLIENT");
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2) {}
  
  public void c(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public MsgBackupEndPoint d()
  {
    return this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint;
  }
  
  public void d()
  {
    String str = a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + str + ", isUdpDetected = " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      e(259);
    }
    label64:
    long l;
    do
    {
      do
      {
        do
        {
          break label64;
          do
          {
            return;
          } while (this.jdField_a_of_type_Int != 1);
          if ((this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null) && (this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp called- for client-------------->>>");
        return;
      } while (!this.jdField_d_of_type_Boolean);
      if (a())
      {
        aujq.b("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      l = aujq.a();
      str = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
      localObject = "postinfo?fid=" + l + "&exit=1";
      aujq.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = aujq.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new auhl();
    ((auhl)localObject).jdField_a_of_type_Short = 0;
    ((auhl)localObject).jdField_a_of_type_Boolean = false;
    ((auhl)localObject).c = str;
    augo.a().g.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp fid = " + l + ", url = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, str);
  }
  
  public void d(int paramInt)
  {
    if (paramInt != 0) {}
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
    {
      if (this.jdField_d_of_type_Boolean) {
        aujp.a("cost_connect_total", null);
      }
      aujo.a();
      aujo.a.jdField_d_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Augk != null) {
        this.jdField_a_of_type_Augk.a(this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.e))
      {
        this.e = false;
        aujq.b("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
        a(3);
      }
      f(2);
      return;
    }
  }
  
  public void d(int paramInt1, int paramInt2) {}
  
  public void d(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    aujp.g = 0L;
    aujp.a(null, "cost_connect_total");
    this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public void e()
  {
    Object localObject = a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + (String)localObject);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      e(259);
      return;
    }
    localObject = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", augd.a().a());
      ((JSONArray)localObject).put(localJSONObject);
      augf.a().a(((JSONArray)localObject).toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null)
    {
      if (!this.jdField_c_of_type_Boolean) {
        break label120;
      }
      if (!a()) {
        break label37;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp panic error!");
      }
    }
    label37:
    label120:
    while (!QLog.isColorLevel())
    {
      long l;
      do
      {
        return;
        l = aujq.a();
        String str = a(paramInt, l);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramInt, str, l);
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp udpdetected = " + this.jdField_c_of_type_Boolean + ", cmd = " + paramInt + ", cookieIndex = " + l);
      return;
    }
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp is error! please use tcp get! udpdetected = " + this.jdField_c_of_type_Boolean + ", cmd = " + paramInt);
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null) || (this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
      }
    }
    long l;
    String str;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_Int != 1) || (!this.jdField_d_of_type_Boolean));
      if (a())
      {
        aujq.b("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList is called! isTcpDetected = " + this.jdField_d_of_type_Boolean + ", from = " + paramInt);
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        a(this.jdField_a_of_type_Long, true, "", 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList, isTcpDetected = " + this.jdField_d_of_type_Boolean + ", client will get ready session list from server------>");
      }
      l = aujq.a();
      str = aujq.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
      localObject = "postinfo?fid=" + l;
      aujq.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = aujq.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new auhl();
    ((auhl)localObject).jdField_a_of_type_Boolean = false;
    ((auhl)localObject).jdField_a_of_type_Short = 0;
    ((auhl)localObject).c = str;
    augo.a().g.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList fid = " + l + ", url = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujh
 * JD-Core Version:    0.7.0.1
 */