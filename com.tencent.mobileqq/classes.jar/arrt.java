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

public class arrt
{
  private static arrt jdField_a_of_type_Arrt;
  public int a;
  public long a;
  private arow jdField_a_of_type_Arow;
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
  
  public static arrt a()
  {
    if (jdField_a_of_type_Arrt == null) {}
    try
    {
      if (jdField_a_of_type_Arrt == null) {
        jdField_a_of_type_Arrt = new arrt();
      }
      return jdField_a_of_type_Arrt;
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
      localJSONObject.put("sig", arop.a().a());
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
    int i = arpa.jdField_b_of_type_Int;
    Object localObject3 = arpa.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
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
          arpw localarpw = (arpw)((Iterator)localObject3).next();
          i = j;
          if (localarpw.jdField_c_of_type_Boolean) {
            i = j + 1;
          }
          j = i;
          if (!localarpw.jdField_a_of_type_Boolean)
          {
            JSONObject localJSONObject = new JSONObject();
            String str2 = localarpw.jdField_a_of_type_JavaLangString;
            j = localarpw.jdField_a_of_type_Int;
            localJSONObject.put("cmd", "chat_ready");
            localJSONObject.put("chatUin", str2);
            localJSONObject.put("chatType", arsc.b(j));
            localJSONObject.put("dbSize", localarpw.jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject);
            localarpw.jdField_a_of_type_Boolean = true;
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
    if ((3 == paramInt) && (this.jdField_a_of_type_Arow != null)) {
      this.jdField_a_of_type_Arow.a(j, arpa.jdField_b_of_type_Int);
    }
    label349:
    String str1 = localJSONException.toString();
    return str1;
  }
  
  private void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (a()) {
      arsc.b("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    long l = arsc.a();
    String str1 = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
    String str2 = "getmsg?fid=" + l + "&chatUin=" + paramString + "&chatType=" + arsc.b(paramInt);
    str1 = str1 + arsc.b(str2, this.jdField_a_of_type_JavaLangString);
    str2 = arsc.a(paramString, arsc.b(paramInt), null);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", url = " + str1 + ", path = " + str2);
    }
    arpx localarpx = new arpx();
    localarpx.jdField_a_of_type_Boolean = true;
    localarpx.jdField_a_of_type_Short = 0;
    localarpx.jdField_b_of_type_JavaLangString = str2;
    localarpx.c = str1;
    paramString = arsc.a(paramString, arsc.b(paramInt));
    ConcurrentHashMap localConcurrentHashMap = arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    arsa.a();
    Object localObject = arsa.a;
    ((arrx)localObject).m += 1L;
    localObject = (arpw)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((arpw)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localarpx);
      localarpx.jdField_b_of_type_Long = ((arpw)localObject).jdField_a_of_type_Long;
      localarpx.jdField_b_of_type_Boolean = arsc.a(((arpw)localObject).jdField_a_of_type_Long);
      arrx localarrx = arsa.a;
      localarrx.f += localarpx.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile , sessionInfo.dbMList = " + ((arpw)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap + ". sessionInfo.hashcode = " + localObject.hashCode() + ", task.isSmallerFile = " + localarpx.jdField_b_of_type_Boolean);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", mClientCanRecvMList = " + localConcurrentHashMap + ", keyFromUin = " + paramString + ", task.isSmallerFile = " + localarpx.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, str1, str2, localarpx.jdField_b_of_type_Boolean, localarpx.jdField_b_of_type_Long, false);
    boolean bool = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Arow != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      arsc.b("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((this.jdField_a_of_type_Arow == null) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Arow.c(true);
      return;
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, arpx> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    arpx localarpx = new arpx();
    localarpx.jdField_a_of_type_Short = 0;
    localarpx.jdField_a_of_type_Boolean = false;
    localarpx.jdField_a_of_type_JavaLangString = paramString;
    localarpx.jdField_a_of_type_Long = paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = " + paramLong2 + ", msg = " + paramString);
    }
    paramConcurrentHashMap.put(Long.valueOf(paramLong2), localarpx);
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
          localObject1 = arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
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
                arpa.jdField_b_of_type_Int = ((JSONObject)localObject3).optInt("listCount");
                arsa.a();
                arsa.a.jdField_b_of_type_Long = arpa.jdField_b_of_type_Int;
              }
              if (!"chat_ready".equals(localObject4)) {
                break label809;
              }
              localObject4 = ((JSONObject)localObject3).optString("chatUin");
              paramInt2 = ((JSONObject)localObject3).optInt("chatType");
              paramLong = ((JSONObject)localObject3).optLong("dbSize");
              localObject3 = new arpw();
              ((arpw)localObject3).jdField_c_of_type_Boolean = false;
              ((arpw)localObject3).jdField_b_of_type_Boolean = false;
              ((arpw)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
              ((arpw)localObject3).jdField_a_of_type_Int = arsc.c(paramInt2);
              ((arpw)localObject3).jdField_a_of_type_Long = paramLong;
              localObject4 = arsc.a(((arpw)localObject3).jdField_a_of_type_JavaLangString, paramInt2);
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
        localObject1 = arpa.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
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
            localObject4 = arsc.a((String)localObject3, paramInt2);
            arpw localarpw = (arpw)((ConcurrentHashMap)localObject1).get(localObject4);
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! keyFromUin = " + (String)localObject4 + ", mMList = " + localObject1);
            }
            if (localarpw != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "udp 通知 此会话接受完成 chatUin = " + (String)localObject3 + ", uinType = " + arsc.c(paramInt2));
              }
              localarpw.jdField_c_of_type_Boolean = true;
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
            if (!((arpw)((Iterator)localObject1).next()).jdField_c_of_type_Boolean) {
              break label806;
            }
            paramInt1 += 1;
            break label823;
          }
          if (this.jdField_a_of_type_Arow == null) {
            break;
          }
          this.jdField_a_of_type_Arow.a(paramInt1, arpa.jdField_b_of_type_Int);
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
          if ((!TextUtils.equals(???, arop.a().a())) || (this.jdField_a_of_type_Arow == null)) {
            break;
          }
          this.jdField_a_of_type_Arow.b(true);
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
    if (arsc.jdField_b_of_type_Boolean) {
      ??? = arsc.a(paramString, this.jdField_a_of_type_JavaLangString);
    }
    arsa.a();
    ConcurrentHashMap localConcurrentHashMap = arpa.a().g;
    paramString = arpa.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, MsgBackupManager.curDealType = " + arpa.jdField_d_of_type_JavaLangString + ", MsgBackupManager.curDealType = " + arpa.jdField_c_of_type_Int);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (??? != null))
    {
      if (!((String)???).contains("/postinfo?")) {
        break label1119;
      }
      if (!a()) {
        break label127;
      }
      arsc.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
    }
    label127:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + (String)???);
      }
      ??? = arsc.a((String)???);
      if (!arpa.jdField_f_of_type_Boolean)
      {
        l = Long.parseLong((String)((Map)???).get("fid"));
        paramString = new arpx();
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
          arsc.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
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
          arsc.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        l = Long.parseLong((String)((Map)???).get("fid"));
        if ((!TextUtils.isEmpty((String)((Map)???).get("exit"))) && (this.jdField_a_of_type_Arow != null)) {
          this.jdField_a_of_type_Arow.b(true);
        }
        paramString = new arpx();
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
          arsc.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        l = Long.parseLong((String)((Map)???).get("fid"));
        if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = arsc.a((String)((Map)???).get("ip"));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port = Integer.parseInt((String)((Map)???).get("udpport"));
        }
        if (this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint != null)
        {
          this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4 = arsc.a((String)((Map)???).get("ip"));
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
      arsc.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)((Map)???).get("fid"));
    Object localObject2 = (String)((Map)???).get("chatUin");
    paramInt1 = Integer.parseInt((String)((Map)???).get("chatType"));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report 会话 uin =" + (String)localObject2 + " 接收完成, chatType = " + paramInt1 + "：mServerReadyMList.size = " + paramString.size());
    }
    ??? = (arpw)paramString.get(arsc.a((String)localObject2, paramInt1));
    if (??? != null)
    {
      ((arpw)???).jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Arow != null) {
        paramInt1 = 0;
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = paramString.values().iterator();
      label960:
      if (paramString.hasNext())
      {
        if (!((arpw)paramString.next()).jdField_c_of_type_Boolean) {
          break label2151;
        }
        paramInt1 += 1;
        break label2151;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report session completed! hasCompletedCount = " + paramInt1);
      }
      if (this.jdField_a_of_type_Arow != null) {
        this.jdField_a_of_type_Arow.a(paramInt1, arpa.jdField_b_of_type_Int);
      }
      if ((paramInt1 != arpa.jdField_b_of_type_Int) || (QLog.isColorLevel())) {
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
        arsc.b("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      boolean bool2 = this.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_Arow != null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        arsc.b("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((this.jdField_a_of_type_Arow != null) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Arow.c(true);
        }
        localObject2 = arsc.a((String)???);
        l = Long.parseLong((String)((Map)localObject2).get("fid"));
        if (arpa.jdField_f_of_type_Boolean) {
          break;
        }
        paramString = new arpx();
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
      ??? = new arrz();
      ((arrz)???).jdField_a_of_type_Boolean = false;
      ((arrz)???).jdField_a_of_type_Long = 0L;
      arpa.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), ???);
      ??? = (String)((Map)localObject2).get("chatUin");
      paramInt2 = Integer.parseInt((String)((Map)localObject2).get("chatType"));
      localObject2 = arsc.a((String)???, paramInt2, null);
      ??? = new arpx();
      ((arpx)???).jdField_a_of_type_Short = 0;
      ((arpx)???).jdField_a_of_type_Boolean = true;
      ((arpx)???).jdField_a_of_type_Long = paramLong;
      ((arpx)???).jdField_b_of_type_JavaLangString = ((String)localObject2);
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
          if (!((arpw)paramString.next()).jdField_c_of_type_Boolean) {
            break label2148;
          }
          paramInt1 += 1;
          break label2154;
        }
        if (this.jdField_a_of_type_Arow != null) {
          this.jdField_a_of_type_Arow.a(paramInt1, arpa.jdField_b_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, (String)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send db uin = " + (String)??? + ", uinType = " + arsc.c(paramInt2) + ", dbpath = " + (String)localObject2 + ", fid = " + l + ", mFidMList.size = " + localConcurrentHashMap.size());
        return;
      }
      if (((String)???).contains("/getres?"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + (String)???);
        }
        if (a())
        {
          arsc.b("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        paramString = arsa.a;
        paramString.jdField_d_of_type_Long += 1L;
        paramString = arsa.a;
        paramString.g += 1L;
        paramString = arsc.a((String)???);
        l = Long.parseLong((String)paramString.get("fid"));
        ??? = (String)paramString.get("filepath");
        arsc.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), ??? });
        paramString = (String)???;
        if (arsc.jdField_c_of_type_Boolean) {
          paramString = Uri.decode((String)???);
        }
        arsc.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), paramString });
        ??? = new arrz();
        ((arrz)???).jdField_a_of_type_Boolean = false;
        ((arrz)???).jdField_a_of_type_Long = 0L;
        arpa.a().e.put(Long.valueOf(l), ???);
        ??? = new arpx();
        ((arpx)???).jdField_a_of_type_Short = 0;
        ((arpx)???).jdField_a_of_type_Boolean = true;
        ((arpx)???).jdField_b_of_type_JavaLangString = arsc.a(paramString);
        ((arpx)???).jdField_a_of_type_Long = paramLong;
        localConcurrentHashMap.put(Long.valueOf(l), ???);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, ((arpx)???).jdField_b_of_type_JavaLangString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send res file, fileRes path = " + ((arpx)???).jdField_b_of_type_JavaLangString + ", mFidMList.size = " + localConcurrentHashMap.size());
        return;
      }
      if (a())
      {
        arsc.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
        return;
      }
      paramString = (String)arsc.a((String)???).get("fid");
      if (TextUtils.isEmpty(paramString)) {
        break;
      }
      l = Long.parseLong(paramString);
      arsc.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.refuseFileRequest(this.jdField_a_of_type_Long, paramLong, l, "404");
      return;
      break label2154;
      break label960;
    }
  }
  
  private void b(long paramLong1, String arg3, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    Object localObject1 = ???;
    if (arsc.jdField_b_of_type_Boolean) {
      localObject1 = arsc.b(???, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_a_of_type_JavaLangString);
    }
    ??? = arpa.a().g;
    Object localObject2 = (arpx)???.get(Long.valueOf(paramLong1));
    ConcurrentHashMap localConcurrentHashMap = arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted called! mfidMlist.size = " + ???.size() + ", mClientCanRecvMList.size = " + localConcurrentHashMap.size() + ", path = " + paramString2 + ",url = " + (String)localObject1 + ", fid = " + paramLong1 + ",errorCode = " + paramInt1 + ", task = " + localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted: mFidMList " + ???.toString() + ", MsgBackupManager.sessionCount = " + arpa.jdField_b_of_type_Int);
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
          arsc.b("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
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
                  arpa.jdField_b_of_type_Int = paramString2.optInt("listCount");
                  arsa.a();
                  arsa.a.jdField_b_of_type_Long = arpa.jdField_b_of_type_Int;
                  if (!QLog.isColorLevel()) {
                    break label3170;
                  }
                  QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = " + arpa.jdField_b_of_type_Int);
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
                  paramArrayOfByte = new arpw();
                  paramArrayOfByte.jdField_b_of_type_Boolean = false;
                  paramArrayOfByte.jdField_a_of_type_JavaLangString = paramString2;
                  paramArrayOfByte.jdField_a_of_type_Int = arsc.c(paramInt2);
                  paramArrayOfByte.jdField_a_of_type_Long = paramLong1;
                  localObject1 = arsc.a(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramInt2);
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
              arsc.b("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
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
          paramArrayOfByte = new arpw();
          paramArrayOfByte.jdField_b_of_type_Boolean = false;
          paramArrayOfByte.jdField_a_of_type_JavaLangString = paramString2;
          paramArrayOfByte.jdField_a_of_type_Long = paramLong1;
          paramArrayOfByte.jdField_a_of_type_Int = arsc.c(paramInt2);
          localConcurrentHashMap.put(arsc.a(paramArrayOfByte.jdField_a_of_type_JavaLangString, paramInt2), paramArrayOfByte);
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
        if ((localConcurrentHashMap.size() >= arpa.jdField_b_of_type_Int) && (arpa.jdField_b_of_type_Int > 0)) {
          break;
        }
        arsc.b("client cache is deal completedly! so get next session!", new Object[0]);
        f(3);
        return;
        if (((arpx)localObject2).jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mfidMlist fileTask receivedCompleted  called not success, so again task = " + localObject2);
          }
          if ((TextUtils.isEmpty(((arpx)localObject2).jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(((arpx)localObject2).c))) {
            break;
          }
          if (((arpx)localObject2).jdField_a_of_type_Short > 3)
          {
            ???.remove(Long.valueOf(paramLong1));
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localObject2);
            return;
          }
          if (a())
          {
            arsc.b("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
            return;
          }
          ((arpx)localObject2).jdField_a_of_type_Short = ((short)(((arpx)localObject2).jdField_a_of_type_Short + 1));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, ((arpx)localObject2).c, ((arpx)localObject2).jdField_b_of_type_JavaLangString, ((arpx)localObject2).jdField_b_of_type_Boolean, ((arpx)localObject2).jdField_b_of_type_Long, true);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist called not success, so again task = " + localObject2);
        }
        if (TextUtils.isEmpty(((arpx)localObject2).c)) {
          break;
        }
        if (((arpx)localObject2).jdField_a_of_type_Short > 3)
        {
          ???.remove(Long.valueOf(paramLong1));
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist retry over time task = " + localObject2);
          return;
        }
        if (a())
        {
          arsc.b("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        ((arpx)localObject2).jdField_a_of_type_Short = ((short)(((arpx)localObject2).jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, ((arpx)localObject2).c);
        return;
        paramArrayOfByte = arsc.a(arpa.jdField_d_of_type_JavaLangString, arsc.b(arpa.jdField_c_of_type_Int));
        ??? = (arpw)localConcurrentHashMap.get(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted key = " + paramArrayOfByte + ", mClientCanRecvMList = " + localConcurrentHashMap + ", sessionInfo = " + ??? + ", errCode = " + paramInt1);
        }
        if (??? == null) {
          break;
        }
        paramArrayOfByte = ???.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject1 = ???.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject2 = (arpx)paramArrayOfByte.get(Long.valueOf(paramLong1));
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
            ??? = new arpg();
            ???.jdField_a_of_type_Int = 1;
            ???.jdField_a_of_type_JavaLangString = paramString2;
            arpa.a().b(???);
            return;
          }
          if (!((arpx)localObject2).jdField_a_of_type_Boolean) {
            break;
          }
          arsa.a();
          paramString2 = arsa.a;
          paramString2.n += 1L;
          paramString2 = arsa.a;
          paramString2.r += 1L;
          paramString2 = new arry();
          paramString2.jdField_b_of_type_Int = 1;
          paramString2.jdField_c_of_type_Int = 0;
          paramString2.jdField_a_of_type_Int = paramInt1;
          arsa.a.a.add(paramString2);
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "dbMList receivedCompleted  called not success, so again task = " + localObject2);
          }
          if ((TextUtils.isEmpty(((arpx)localObject2).jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(((arpx)localObject2).c))) {
            break;
          }
          if ((((arpx)localObject2).jdField_a_of_type_Short > 3) && (this.jdField_d_of_type_Boolean))
          {
            arpa.jdField_a_of_type_Int += 1;
            arsc.b("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(arpa.jdField_a_of_type_Int) });
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
              bool = ((arpw)paramString2.next()).jdField_c_of_type_Boolean;
              if (!bool) {
                break label3167;
              }
              paramInt1 += 1;
              continue;
              a(this.jdField_a_of_type_Long, false, ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Int);
              break label1842;
            }
            if (this.jdField_a_of_type_Arow != null) {
              this.jdField_a_of_type_Arow.a(paramInt1, arpa.jdField_b_of_type_Int);
            }
            if ((paramInt1 == arpa.jdField_b_of_type_Int) || (a(2))) {
              break;
            }
            arsc.b("this session db has received error! so get next session!", new Object[0]);
            f(3);
            return;
          }
          if (a())
          {
            arsc.b("recvFile panic error! dbMList receivedCompleted", new Object[0]);
            return;
          }
          ((arpx)localObject2).jdField_a_of_type_Short = ((short)(((arpx)localObject2).jdField_a_of_type_Short + 1));
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong1, ((arpx)localObject2).c, ((arpx)localObject2).jdField_b_of_type_JavaLangString, ((arpx)localObject2).jdField_b_of_type_Boolean, ((arpx)localObject2).jdField_b_of_type_Long, false);
          return;
          paramString2 = (arpx)((ConcurrentHashMap)localObject1).get(Long.valueOf(paramLong1));
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
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int + ", task = " + paramString2);
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
                bool = ((arpw)paramString2.next()).jdField_c_of_type_Boolean;
                if (!bool) {
                  break label3164;
                }
                paramInt1 += 1;
                continue;
                a(this.jdField_a_of_type_Long, false, ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Int);
                break label2292;
              }
              if (this.jdField_a_of_type_Arow != null) {
                this.jdField_a_of_type_Arow.a(paramInt1, arpa.jdField_b_of_type_Int);
              }
              if ((paramInt1 == arpa.jdField_b_of_type_Int) || (a(2))) {
                break;
              }
              arsc.b("this session res has received! so get next session!", new Object[0]);
              f(3);
              return;
            }
            if (!paramString2.jdField_a_of_type_Boolean) {
              break;
            }
            arsa.a();
            localObject2 = arsa.a;
            ((arrx)localObject2).h += 1L;
            localObject2 = arsa.a;
            ((arrx)localObject2).r += 1L;
            localObject2 = new arry();
            if (arpa.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(Long.valueOf(paramLong1)))
            {
              arrx localarrx = arsa.a;
              localarrx.k += 1L;
              arpa.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(Long.valueOf(paramLong1));
              ((arry)localObject2).jdField_c_of_type_Int = 2;
              ((arry)localObject2).jdField_b_of_type_Int = 2;
              ((arry)localObject2).jdField_a_of_type_Int = paramInt1;
              arsa.a.a.add(localObject2);
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
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int + ", task = " + paramString2);
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
                  bool = ((arpw)paramString2.next()).jdField_c_of_type_Boolean;
                  if (!bool) {
                    break label3161;
                  }
                  paramInt1 += 1;
                  continue;
                  ((arry)localObject2).jdField_c_of_type_Int = 1;
                  break label2636;
                  a(this.jdField_a_of_type_Long, false, ???.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_Int);
                  break label2851;
                }
                if (this.jdField_a_of_type_Arow != null) {
                  this.jdField_a_of_type_Arow.a(paramInt1, arpa.jdField_b_of_type_Int);
                }
                if ((paramInt1 == arpa.jdField_b_of_type_Int) || (a(2))) {
                  break;
                }
                arsc.b("this session res has received! over time  so get next session!", new Object[0]);
                f(3);
                return;
              }
              if (a())
              {
                arsc.b("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
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
    arrs.a().a();
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
        localObject1 = arpa.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject3 = new arpx();
        ((arpx)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((arpx)localObject3).jdField_a_of_type_Int = paramInt;
        ((arpx)localObject3).jdField_a_of_type_Short = 0;
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
        if (!arpa.jdField_f_of_type_Boolean)
        {
          ??? = ((JSONArray)localObject1).toString();
          localObject1 = arpa.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localObject3 = new arpx();
          ((arpx)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
          ((arpx)localObject3).jdField_a_of_type_Int = paramInt;
          ((arpx)localObject3).jdField_a_of_type_Short = 0;
          ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
          localObject1 = ???;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "MsgBackupManager.sUIReady = " + arpa.jdField_f_of_type_Boolean + ", getSessionJson is called! cookie = " + paramLong + ", msg = " + (String)???);
          return ???;
        }
        ??? = arpa.a().jdField_a_of_type_JavaUtilHashSet;
        localObject3 = arpa.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        i = arpa.jdField_b_of_type_Int;
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
              localObject4 = (arpw)((Iterator)localObject3).next();
              i = j;
              if (((arpw)localObject4).jdField_c_of_type_Boolean) {
                i = j + 1;
              }
              j = i;
              if (!((arpw)localObject4).jdField_a_of_type_Boolean)
              {
                localObject5 = ((arpw)localObject4).jdField_a_of_type_JavaLangString;
                j = ((arpw)localObject4).jdField_a_of_type_Int;
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("cmd", "chat_ready");
                localJSONObject.put("chatUin", localObject5);
                localJSONObject.put("chatType", arsc.b(j));
                localJSONObject.put("dbSize", ((arpw)localObject4).jdField_a_of_type_Long);
                localJSONException.put(localJSONObject);
                ((arpw)localObject4).jdField_a_of_type_Boolean = true;
                j = i;
              }
            }
          }
          if (this.jdField_a_of_type_Arow != null) {
            this.jdField_a_of_type_Arow.a(j, arpa.jdField_b_of_type_Int);
          }
        }
      }
      else if (paramInt == 258)
      {
        ??? = arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (arpw)((Iterator)???).next();
          if ((!((arpw)localObject3).jdField_d_of_type_Boolean) && (((arpw)localObject3).jdField_c_of_type_Boolean))
          {
            localObject4 = ((arpw)localObject3).jdField_a_of_type_JavaLangString;
            i = ((arpw)localObject3).jdField_a_of_type_Int;
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("cmd", "chat_transfer_complete");
            ((JSONObject)localObject5).put("chatUin", localObject4);
            ((JSONObject)localObject5).put("chatType", arsc.b(i));
            str.put(localObject5);
            ((arpw)localObject3).jdField_d_of_type_Boolean = true;
          }
        }
      }
      else if (paramInt == 259)
      {
        ??? = new JSONObject();
        ((JSONObject)???).put("cmd", "exit");
        ((JSONObject)???).put("sig", arop.a().a());
        str.put(???);
      }
    }
    return str;
  }
  
  public String a(String paramString)
  {
    return arsc.a(paramString, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_a_of_type_JavaLangString);
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
      arpa.a().b();
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
  
  public void a(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    arsc.b("MsgBackup_MsgBackupTransportProcessor", "onRecvComplete from jni fid = %d,url = %s,errcode = %d,path = %s ", new Object[] { Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramInt1), paramString2 });
    arsb.a(paramLong1);
    b(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    arsb.a(paramLong1, paramLong3);
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong4;
        if (this.jdField_a_of_type_Arow != null)
        {
          this.jdField_a_of_type_Arow.a(1000L * paramLong3 / paramLong2);
          arsb.b(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
      }
      this.jdField_c_of_type_Long += paramLong4;
      return;
    }
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_c_of_type_Long += paramLong4;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, long paramLong4) {}
  
  public void a(long paramLong1, boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong2)
  {
    arsb.a(paramLong1);
    arsa.a();
    Object localObject;
    label184:
    arpx localarpx;
    if (arpa.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (arrz)arpa.a().e.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = arsc.a(((arrz)localObject).jdField_a_of_type_Long);
        if (bool)
        {
          localObject = arsa.a;
          ((arrx)localObject).j += 1L;
        }
        if (!paramBoolean)
        {
          localObject = arsa.a;
          ((arrx)localObject).r += 1L;
          localObject = new arry();
          ((arry)localObject).jdField_b_of_type_Int = 2;
          if (!bool) {
            break label273;
          }
          paramInt2 = 2;
          ((arry)localObject).jdField_c_of_type_Int = paramInt2;
          ((arry)localObject).jdField_a_of_type_Int = paramInt1;
          arsa.a.a.add(localObject);
          if (bool)
          {
            localObject = arsa.a;
            ((arrx)localObject).k += 1L;
          }
        }
      }
      arpa.a().e.remove(Long.valueOf(paramLong1));
      localObject = arpa.a().g;
      localarpx = (arpx)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localarpx == null) {
        break label724;
      }
      if (!paramBoolean) {
        break label426;
      }
      ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  task = " + localarpx + ", mFidMList.size = " + ((ConcurrentHashMap)localObject).size());
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
          if (!arpa.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
            break label184;
          }
          if ((arrz)arpa.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1)) != null)
          {
            localObject = arsa.a;
            ((arrx)localObject).m += 1L;
            if (!paramBoolean)
            {
              localObject = arsa.a;
              ((arrx)localObject).n += 1L;
              localObject = arsa.a;
              ((arrx)localObject).r += 1L;
              localObject = new arry();
              ((arry)localObject).jdField_b_of_type_Int = 1;
              ((arry)localObject).jdField_c_of_type_Int = 0;
              ((arry)localObject).jdField_a_of_type_Int = paramInt1;
              arsa.a.a.add(localObject);
            }
          }
          arpa.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
          break label184;
          if (!localarpx.jdField_a_of_type_Boolean) {
            break label579;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "fileTask onSendComplete  called not success, so again  task = " + localarpx);
          }
        } while (TextUtils.isEmpty(localarpx.jdField_b_of_type_JavaLangString));
        if (localarpx.jdField_a_of_type_Short > 3)
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete fileTask  retry over time task = " + localarpx);
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (a())
        {
          arsc.b("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        localarpx.jdField_a_of_type_Short = ((short)(localarpx.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, localarpx.jdField_a_of_type_Long, paramLong1, localarpx.jdField_b_of_type_JavaLangString);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called not success, so again task = " + localarpx);
        }
      } while (TextUtils.isEmpty(localarpx.jdField_a_of_type_JavaLangString));
      if (localarpx.jdField_a_of_type_Short > 3)
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete retry over time task = " + localarpx);
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        return;
      }
      if (a())
      {
        arsc.b("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      localarpx.jdField_a_of_type_Short = ((short)(localarpx.jdField_a_of_type_Short + 1));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, localarpx.jdField_a_of_type_Long, paramLong1, localarpx.jdField_a_of_type_JavaLangString);
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
        arsc.b("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      long l = arsc.a();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = "postinfo?fid=" + l + "&chatUin=" + paramString + "&chatType=" + arsc.b(paramInt);
        arsc.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
        paramString = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + arsc.b(paramString, this.jdField_a_of_type_JavaLangString);
      }
      while ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
      {
        arpx localarpx = new arpx();
        localarpx.jdField_a_of_type_Short = 0;
        localarpx.jdField_a_of_type_Boolean = false;
        localarpx.c = paramString;
        arpa.a().g.put(Long.valueOf(l), localarpx);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer fid = " + l + ", url = " + paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, paramString);
        return;
        if (paramBoolean)
        {
          paramString = "postinfo?fid=" + l + "&ip=" + arsc.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + "&tcpport=" + this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + "&udpport=" + this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port;
          arsc.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + arsc.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramString = "postinfo?fid=" + l;
          arsc.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + arsc.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    arsc.b("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
  }
  
  public void a(arow paramarow)
  {
    this.jdField_a_of_type_Arow = paramarow;
  }
  
  public void a(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public void a(String paramString)
  {
    arpa.a().a();
    arsc.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
    }
    arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    a(1);
    arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.1(this, paramString));
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    arpa.a().a();
    arsc.a();
    arpa.a().a().a(paramInt);
    arpa.a().a().a(paramString2);
    arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    arpa.a().a();
    arsc.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
    }
    a(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (a()) {
      arsc.b("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      arsa.a();
      localObject = arsa.a;
      ((arrx)localObject).g += 1L;
      localObject = arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((paramString1 != null) || (paramString2 != null)) {
        break;
      }
      arsc.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { arpa.jdField_d_of_type_JavaLangString, Integer.valueOf(arpa.jdField_c_of_type_Int) });
      paramString1 = (arpw)((ConcurrentHashMap)localObject).get(arsc.a(arpa.jdField_d_of_type_JavaLangString, arsc.b(arpa.jdField_c_of_type_Int)));
    } while (paramString1 == null);
    arsc.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    if ((paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) && (paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {
      a(6);
    }
    paramString1.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    return;
    new File(paramString2).getParentFile().mkdirs();
    long l = arsc.a();
    paramString1 = arsc.b(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l), paramString1 }), this.jdField_a_of_type_JavaLangString);
    paramString1 = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port) + paramString1;
    arpx localarpx = new arpx();
    localarpx.jdField_a_of_type_Short = 0;
    localarpx.jdField_a_of_type_Boolean = true;
    localarpx.jdField_b_of_type_JavaLangString = paramString2;
    localarpx.c = paramString1;
    localarpx.jdField_b_of_type_Boolean = arsc.a(paramLong);
    localarpx.jdField_b_of_type_Long = paramLong;
    arrx localarrx = arsa.a;
    localarrx.e += paramLong;
    Object localObject = (arpw)((ConcurrentHashMap)localObject).get(arsc.a(arpa.jdField_d_of_type_JavaLangString, arsc.b(arpa.jdField_c_of_type_Int)));
    if (localObject != null) {
      ((arpw)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localarpx);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, paramString1, paramString2, localarpx.jdField_b_of_type_Boolean, localarpx.jdField_b_of_type_Long, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    arsa.a();
    arsa.a.jdField_b_of_type_Boolean = this.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject;
    arpx localarpx;
    if (2 == this.jdField_a_of_type_Int)
    {
      localObject = arpa.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
      localarpx = (arpx)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localarpx != null)
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
              if (localarpx.jdField_a_of_type_Short > 3)
              {
                ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localarpx);
                return;
              }
              localarpx.jdField_a_of_type_Short = ((short)(localarpx.jdField_a_of_type_Short + 1));
              localObject = localarpx.jdField_a_of_type_JavaLangString;
              i = localarpx.jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: " + localarpx);
              }
            } while (TextUtils.isEmpty((CharSequence)localObject));
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
            return;
          } while (1 != this.jdField_a_of_type_Int);
          localObject = arpa.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localarpx = (arpx)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_CLIENT");
          }
        } while (localarpx == null);
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
      if (localarpx.jdField_a_of_type_Short > 3)
      {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localarpx);
        return;
      }
      localObject = localarpx.jdField_a_of_type_JavaLangString;
      i = localarpx.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage  role = MBRROLE_CLIENT: " + localarpx);
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
        arsc.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
        bool3 = bool1;
        return bool3;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, from = " + paramInt);
      }
      ConcurrentHashMap localConcurrentHashMap = arpa.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (((paramInt != 1) && (paramInt != 6)) || (TextUtils.isEmpty(arpa.jdField_d_of_type_JavaLangString))) {
        break label302;
      }
      localObject2 = (arpw)localConcurrentHashMap.get(arsc.a(arpa.jdField_d_of_type_JavaLangString, arsc.b(arpa.jdField_c_of_type_Int)));
      if (localObject2 == null) {
        break label302;
      }
      ((arpw)localObject2).jdField_c_of_type_Boolean = true;
      arsc.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { arpa.jdField_d_of_type_JavaLangString, Integer.valueOf(arpa.jdField_c_of_type_Int) });
      if (this.jdField_c_of_type_Boolean) {
        e(258);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Arow == null) {
          break label302;
        }
        localObject2 = localConcurrentHashMap.values().iterator();
        i = 0;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        if (!((arpw)((Iterator)localObject2).next()).jdField_c_of_type_Boolean) {
          break label1688;
        }
        i += 1;
        break label1688;
        a(this.jdField_a_of_type_Long, false, ((arpw)localObject2).jdField_a_of_type_JavaLangString, ((arpw)localObject2).jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Arow == null) {
        break label288;
      }
    }
    finally {}
    this.jdField_a_of_type_Arow.a(i, arpa.jdField_b_of_type_Int);
    label288:
    label302:
    Object localObject3;
    if (((i != arpa.jdField_b_of_type_Int) || (this.jdField_a_of_type_Arow == null)) || (!TextUtils.isEmpty(arpa.jdField_d_of_type_JavaLangString)))
    {
      localObject2 = (arpw)localObject1.get(arsc.a(arpa.jdField_d_of_type_JavaLangString, arsc.b(arpa.jdField_c_of_type_Int)));
      if (localObject2 == null) {
        break label1677;
      }
      if (((arpw)localObject2).jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int);
        }
        localObject2 = localObject1.values().iterator();
        i = 0;
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label1671;
          }
          localObject3 = (arpw)((Iterator)localObject2).next();
          if (!((arpw)localObject3).jdField_b_of_type_Boolean)
          {
            if (((arpw)localObject3).jdField_a_of_type_Long > 0L) {
              break label781;
            }
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + ((arpw)localObject3).jdField_a_of_type_JavaLangString + ", uintype = " + ((arpw)localObject3).jdField_a_of_type_Int + ", dbsize = " + ((arpw)localObject3).jdField_a_of_type_Long);
            }
            ((arpw)localObject3).jdField_c_of_type_Boolean = true;
            ((arpw)localObject3).jdField_b_of_type_Boolean = true;
            if (this.jdField_c_of_type_Boolean) {
              e(258);
            }
            while (this.jdField_a_of_type_Arow != null)
            {
              localObject3 = localObject1.values().iterator();
              i = 0;
              label557:
              if (!((Iterator)localObject3).hasNext()) {
                break label612;
              }
              if (!((arpw)((Iterator)localObject3).next()).jdField_c_of_type_Boolean) {
                break label1668;
              }
              i += 1;
              break label1691;
              a(this.jdField_a_of_type_Long, false, ((arpw)localObject3).jdField_a_of_type_JavaLangString, ((arpw)localObject3).jdField_a_of_type_Int);
            }
          }
        }
        label612:
        if (this.jdField_a_of_type_Arow != null) {
          this.jdField_a_of_type_Arow.a(i, arpa.jdField_b_of_type_Int);
        }
        if (i != arpa.jdField_b_of_type_Int) {
          break label1708;
        }
        arsc.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
        bool1 = false;
        break label1694;
      }
    }
    label781:
    label1293:
    for (;;)
    {
      label657:
      if ((localObject1.size() == 0) || (TextUtils.isEmpty(arpa.jdField_d_of_type_JavaLangString)))
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
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with from = " + paramInt + ", ret = " + bool2 + ". isCurDealing = " + bool1 + ", hasFinishedC = " + i + ", sessionCount = " + arpa.jdField_b_of_type_Int);
        bool3 = bool2;
        break;
        localObject2 = localObject1.values().iterator();
        i = 0;
        label795:
        if (((Iterator)localObject2).hasNext())
        {
          if (!((arpw)((Iterator)localObject2).next()).jdField_c_of_type_Boolean) {
            break label1665;
          }
          i += 1;
          break label1711;
        }
        if (this.jdField_a_of_type_Arow != null) {
          this.jdField_a_of_type_Arow.a(i, arpa.jdField_b_of_type_Int);
        }
        if (i == arpa.jdField_b_of_type_Int)
        {
          arsc.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
          bool1 = false;
          break label1694;
        }
        ((arpw)localObject3).jdField_b_of_type_Boolean = true;
        arpa.jdField_d_of_type_JavaLangString = ((arpw)localObject3).jdField_a_of_type_JavaLangString;
        arpa.jdField_c_of_type_Int = ((arpw)localObject3).jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, current uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int + ", dbsize = " + ((arpw)localObject3).jdField_a_of_type_Long);
        }
        a(this.jdField_a_of_type_Long, ((arpw)localObject3).jdField_a_of_type_JavaLangString, ((arpw)localObject3).jdField_a_of_type_Int, false);
        bool1 = true;
        break label1694;
        if (!QLog.isColorLevel()) {
          break label1714;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "current session not completed! requestNextSessionDb !, current uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int);
        break label1714;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int);
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
            localObject3 = (arpw)((Iterator)localObject2).next();
            if (!((arpw)localObject3).jdField_b_of_type_Boolean)
            {
              if (((arpw)localObject3).jdField_a_of_type_Long > 0L) {
                break label1376;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + ((arpw)localObject3).jdField_a_of_type_JavaLangString + ", uintype = " + ((arpw)localObject3).jdField_a_of_type_Int + ", dbSize = " + ((arpw)localObject3).jdField_a_of_type_Long);
              }
              ((arpw)localObject3).jdField_c_of_type_Boolean = true;
              ((arpw)localObject3).jdField_b_of_type_Boolean = true;
              if (this.jdField_c_of_type_Boolean) {
                e(258);
              }
              while (this.jdField_a_of_type_Arow != null)
              {
                localObject3 = localObject1.values().iterator();
                i = 0;
                if (!((Iterator)localObject3).hasNext()) {
                  break label1293;
                }
                if (!((arpw)((Iterator)localObject3).next()).jdField_c_of_type_Boolean) {
                  break label1654;
                }
                i += 1;
                break label1722;
                a(this.jdField_a_of_type_Long, false, ((arpw)localObject3).jdField_a_of_type_JavaLangString, ((arpw)localObject3).jdField_a_of_type_Int);
              }
            }
          }
          if ((this.jdField_a_of_type_Arow != null) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Arow.c(true);
          }
          if (this.jdField_a_of_type_Arow != null) {
            this.jdField_a_of_type_Arow.a(i, arpa.jdField_b_of_type_Int);
          }
        } while ((i != arpa.jdField_b_of_type_Int) || (this.jdField_a_of_type_Arow == null));
        arsc.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
        i = 0;
        bool1 = false;
        continue;
        label1376:
        ((arpw)localObject3).jdField_b_of_type_Boolean = true;
        arpa.jdField_d_of_type_JavaLangString = ((arpw)localObject3).jdField_a_of_type_JavaLangString;
        arpa.jdField_c_of_type_Int = ((arpw)localObject3).jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, uin = " + arpa.jdField_d_of_type_JavaLangString + ", uintype = " + arpa.jdField_c_of_type_Int + ", dbsize = " + ((arpw)localObject3).jdField_a_of_type_Long);
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
        if (((arpw)((Iterator)localObject2).next()).jdField_c_of_type_Boolean)
        {
          i += 1;
          break label1725;
        }
      }
      else
      {
        if ((this.jdField_a_of_type_Arow != null) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_Arow.c(true);
        }
        if (this.jdField_a_of_type_Arow != null) {
          this.jdField_a_of_type_Arow.a(i, arpa.jdField_b_of_type_Int);
        }
        if (i == arpa.jdField_b_of_type_Int)
        {
          arsc.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
          i = 0;
          bool1 = false;
          break label657;
        }
        a(this.jdField_a_of_type_Long, ((arpw)localObject3).jdField_a_of_type_JavaLangString, ((arpw)localObject3).jdField_a_of_type_Int, false);
        i = 0;
        bool2 = true;
        bool1 = false;
        break label657;
        if ((bool2) || (bool1) || (i == arpa.jdField_b_of_type_Int)) {
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
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientTcpEndPoint.ipv4 = " + arsc.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", clientUdpEndpoint.port = " + this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", clientTcpEndPoint.port" + this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverUdpEndpoint.ipv4 = " + arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", serverUdpEndpoint.port = " + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", serverTcpEndPoint.port" + this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint end， operator = " + this.jdField_a_of_type_Long);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientTcpEndPoint.ipv4 = " + arsc.a(this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", clientUdpEndpoint.port = " + this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", clientTcpEndPoint.port" + this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverUdpEndpoint.ipv4 = " + arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4) + ", serverUdpEndpoint.port = " + this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port + ", serverTcpEndPoint.port" + this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_c_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
        }
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void b(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    arsb.a(paramLong1, paramLong3);
    arsa.a();
    if (arpa.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (arrz)arpa.a().e.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_a_of_type_Long = paramLong3;
        paramString = arsa.a;
        paramString.e += paramLong3;
      }
    }
    while (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong4;
        if (this.jdField_a_of_type_Arow != null)
        {
          this.jdField_a_of_type_Arow.a(1000L * paramLong3 / paramLong2);
          arsb.b(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
        if (arpa.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
        {
          paramString = (arrz)arpa.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
          if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
          {
            paramString.jdField_a_of_type_Boolean = true;
            paramString.jdField_a_of_type_Long = paramLong3;
            paramString = arsa.a;
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
  
  public void b(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    arsb.g = 0L;
    arsb.a(null, "cost_connect_total");
    this.jdField_b_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint = paramMsgBackupEndPoint;
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Arow != null) {
      this.jdField_a_of_type_Arow.b(true);
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
    int i = arop.a().a();
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
        arsc.b("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      l = arsc.a();
      str = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
      localObject = "postinfo?fid=" + l + "&exit=1";
      arsc.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = arsc.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new arpx();
    ((arpx)localObject).jdField_a_of_type_Short = 0;
    ((arpx)localObject).jdField_a_of_type_Boolean = false;
    ((arpx)localObject).c = str;
    arpa.a().g.put(Long.valueOf(l), localObject);
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
        arsb.a("cost_connect_total", null);
      }
      arsa.a();
      arsa.a.jdField_d_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Arow != null) {
        this.jdField_a_of_type_Arow.a(this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.e))
      {
        this.e = false;
        arsc.b("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
        a(3);
      }
      f(2);
      return;
    }
  }
  
  public void d(int paramInt1, int paramInt2) {}
  
  public void d(MsgBackupEndPoint paramMsgBackupEndPoint)
  {
    arsb.g = 0L;
    arsb.a(null, "cost_connect_total");
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
      localJSONObject.put("sig", arop.a().a());
      ((JSONArray)localObject).put(localJSONObject);
      aror.a().a(((JSONArray)localObject).toString());
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
        l = arsc.a();
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
        arsc.b("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
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
      l = arsc.a();
      str = arsc.a(this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.ipv4, this.jdField_d_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupEndPoint.port);
      localObject = "postinfo?fid=" + l;
      arsc.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = arsc.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new arpx();
    ((arpx)localObject).jdField_a_of_type_Boolean = false;
    ((arpx)localObject).jdField_a_of_type_Short = 0;
    ((arpx)localObject).c = str;
    arpa.a().g.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList fid = " + l + ", url = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrt
 * JD-Core Version:    0.7.0.1
 */