import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
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

public class avwk
{
  private static avwk jdField_a_of_type_Avwk;
  public int a;
  public long a;
  private avtm jdField_a_of_type_Avtm;
  public MsgBackupJniProxy a;
  public MsgBackupNotifier a;
  public Integer a;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  protected String a;
  protected boolean a;
  public String[] a;
  private long jdField_b_of_type_Long;
  public Integer b;
  private boolean jdField_b_of_type_Boolean;
  public String[] b;
  private long jdField_c_of_type_Long;
  public Integer c;
  private boolean jdField_c_of_type_Boolean;
  public Integer d;
  private boolean d;
  private boolean e;
  
  public avwk()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[10];
    this.jdField_a_of_type_JavaLangInteger = new Integer(0);
    this.jdField_b_of_type_JavaLangInteger = new Integer(0);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[10];
    this.jdField_c_of_type_JavaLangInteger = new Integer(0);
    this.jdField_d_of_type_JavaLangInteger = new Integer(0);
  }
  
  private int a(ConcurrentHashMap<String, avum> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    int i = 0;
    if (paramConcurrentHashMap.hasNext())
    {
      if (!((avum)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
        break label45;
      }
      i += 1;
    }
    label45:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public static avwk a()
  {
    if (jdField_a_of_type_Avwk == null) {}
    try
    {
      if (jdField_a_of_type_Avwk == null) {
        jdField_a_of_type_Avwk = new avwk();
      }
      return jdField_a_of_type_Avwk;
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
  
  private String a(long paramLong, int paramInt)
  {
    int i = avtq.jdField_b_of_type_Int;
    Object localObject3 = avtq.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
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
          avum localavum = (avum)((Iterator)localObject3).next();
          i = j;
          if (localavum.jdField_c_of_type_Boolean) {
            i = j + 1;
          }
          j = i;
          if (!localavum.jdField_a_of_type_Boolean)
          {
            JSONObject localJSONObject = new JSONObject();
            String str2 = localavum.jdField_a_of_type_JavaLangString;
            j = localavum.jdField_a_of_type_Int;
            localJSONObject.put("cmd", "chat_ready");
            localJSONObject.put("chatUin", str2);
            localJSONObject.put("chatType", avwu.b(j));
            localJSONObject.put("dbSize", localavum.jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject);
            localavum.jdField_a_of_type_Boolean = true;
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
    if ((3 == paramInt) && (this.jdField_a_of_type_Avtm != null)) {
      this.jdField_a_of_type_Avtm.a(j, avtq.jdField_b_of_type_Int);
    }
    label349:
    String str1 = localJSONException.toString();
    return str1;
  }
  
  private String a(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte != null) {}
    try
    {
      str = new String(paramArrayOfByte, "utf-8");
      return str;
    }
    catch (Exception paramArrayOfByte)
    {
      avwu.b("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
    }
    return "";
  }
  
  private void a(long paramLong, int paramInt, avun paramavun, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1)
  {
    if (paramavun.jdField_a_of_type_Boolean)
    {
      avwr.a();
      Object localObject = avwr.a;
      ((avwo)localObject).n += 1L;
      localObject = avwr.a;
      ((avwo)localObject).r += 1L;
      localObject = new avwp();
      ((avwp)localObject).jdField_b_of_type_Int = 1;
      ((avwp)localObject).jdField_c_of_type_Int = 0;
      ((avwp)localObject).jdField_a_of_type_Int = paramInt;
      avwr.a.a.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "dbMList receivedCompleted  called not success, so again task = " + paramavun);
      }
      if ((!TextUtils.isEmpty(paramavun.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramavun.c))) {
        a(paramLong, paramavun, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1);
      }
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString, avun paramavun, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2)
  {
    if (paramInt == 0)
    {
      a(paramLong, paramString, paramConcurrentHashMap1, paramConcurrentHashMap2);
      return;
    }
    a(paramLong, paramInt, paramavun, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1);
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2)
  {
    avun localavun = (avun)paramConcurrentHashMap2.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called  task = " + localavun + ", resMList.size = " + paramConcurrentHashMap2.size() + ", errCode = " + paramInt);
    }
    if (localavun != null) {
      a(paramLong, paramInt, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1, paramConcurrentHashMap2, localavun);
    }
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2, avun paramavun)
  {
    if (paramInt == 0)
    {
      b(paramLong, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1, paramConcurrentHashMap2, paramavun);
      return;
    }
    b(paramLong, paramInt, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1, paramConcurrentHashMap2, paramavun);
  }
  
  private void a(long paramLong, avun paramavun, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1)
  {
    if ((paramavun.jdField_a_of_type_Short > 3) && (this.jdField_d_of_type_Boolean))
    {
      b(paramLong, paramavun, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1);
      return;
    }
    if (a())
    {
      avwu.b("recvFile panic error! dbMList receivedCompleted", new Object[0]);
      return;
    }
    paramavun.jdField_a_of_type_Short = ((short)(paramavun.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramavun.c, paramavun.jdField_b_of_type_JavaLangString, paramavun.jdField_b_of_type_Boolean, paramavun.jdField_b_of_type_Long, false);
  }
  
  private void a(long paramLong, String paramString)
  {
    if (a()) {
      avwu.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
    }
    do
    {
      return;
      paramString = (String)avwu.a(paramString).get("fid");
    } while (TextUtils.isEmpty(paramString));
    long l = Long.parseLong(paramString);
    avwu.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.refuseFileRequest(this.jdField_a_of_type_Long, paramLong, l, "404");
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, long paramLong2, ConcurrentHashMap<String, avum> paramConcurrentHashMap, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, fid = " + paramLong1 + ", url = " + paramString1 + ", errCode = " + paramInt + ", context = " + paramLong2 + ", recvBuf = " + paramString2);
      }
      try
      {
        paramString1 = new JSONArray(paramString2);
        if (paramString1.length() > 0)
        {
          paramString2 = (JSONObject)paramString1.get(0);
          if ("chat_list_count".equals(paramString2.optString("cmd")))
          {
            a(paramConcurrentHashMap, paramString1, paramString2);
            return;
          }
          a(paramConcurrentHashMap, paramString1);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted parse json error!", paramString1);
        return;
      }
      if ((paramConcurrentHashMap.size() < avtq.jdField_b_of_type_Int) || (avtq.jdField_b_of_type_Int <= 0))
      {
        avwu.b("client cache is deal completedly! so get next session!", new Object[0]);
        j(3);
      }
    }
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong2, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, ConcurrentHashMap<String, avum> paramConcurrentHashMap1)
  {
    paramConcurrentHashMap.remove(Long.valueOf(paramLong1));
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (TextUtils.isEmpty(paramString2)))
    {
      if (a()) {
        avwu.b("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
      }
    }
    else {
      return;
    }
    a(paramLong1, paramString1, paramInt, paramLong2, paramConcurrentHashMap1, a(paramArrayOfByte));
  }
  
  private void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    if (a()) {
      avwu.b("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    long l = avwu.a();
    String str1 = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
    String str2 = "getmsg?fid=" + l + "&chatUin=" + paramString + "&chatType=" + avwu.b(paramInt);
    str1 = str1 + avwu.b(str2, this.jdField_a_of_type_JavaLangString);
    str2 = avwu.a(paramString, avwu.b(paramInt), null);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", url = " + str1 + ", path = " + str2);
    }
    avun localavun = new avun();
    localavun.jdField_a_of_type_Boolean = true;
    localavun.jdField_a_of_type_Short = 0;
    localavun.jdField_b_of_type_JavaLangString = str2;
    localavun.c = str1;
    paramString = avwu.b(paramString, avwu.b(paramInt));
    ConcurrentHashMap localConcurrentHashMap = avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    avwr.a();
    Object localObject = avwr.a;
    ((avwo)localObject).m += 1L;
    localObject = (avum)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((avum)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localavun);
      localavun.jdField_b_of_type_Long = ((avum)localObject).jdField_a_of_type_Long;
      localavun.jdField_b_of_type_Boolean = avwu.a(((avum)localObject).jdField_a_of_type_Long);
      avwo localavwo = avwr.a;
      localavwo.f += localavun.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile , sessionInfo.dbMList = " + ((avum)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap + ". sessionInfo.hashcode = " + localObject.hashCode() + ", task.isSmallerFile = " + localavun.jdField_b_of_type_Boolean);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", mClientCanRecvMList = " + localConcurrentHashMap + ", keyFromUin = " + paramString + ", task.isSmallerFile = " + localavun.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, str1, str2, localavun.jdField_b_of_type_Boolean, localavun.jdField_b_of_type_Long, false);
    boolean bool = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Avtm != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      avwu.b("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((this.jdField_a_of_type_Avtm == null) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Avtm.c(true);
      return;
    }
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, avun> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
    }
    if (a()) {
      avwu.b("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
    }
    Object localObject;
    do
    {
      return;
      localObject = avwr.a;
      ((avwo)localObject).jdField_d_of_type_Long += 1L;
      localObject = avwr.a;
      ((avwo)localObject).g += 1L;
      paramString = avwu.a(paramString);
      long l = Long.parseLong((String)paramString.get("fid"));
      localObject = (String)paramString.get("filepath");
      avwu.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), localObject });
      paramString = (String)localObject;
      if (avwu.jdField_c_of_type_Boolean) {
        paramString = Uri.decode((String)localObject);
      }
      avwu.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), paramString });
      localObject = new avwq();
      ((avwq)localObject).jdField_a_of_type_Boolean = false;
      ((avwq)localObject).jdField_a_of_type_Long = 0L;
      avtq.a().e.put(Long.valueOf(l), localObject);
      localObject = new avun();
      ((avun)localObject).jdField_a_of_type_Short = 0;
      ((avun)localObject).jdField_a_of_type_Boolean = true;
      ((avun)localObject).jdField_b_of_type_JavaLangString = avwu.a(paramString);
      ((avun)localObject).jdField_a_of_type_Long = paramLong;
      paramConcurrentHashMap.put(Long.valueOf(l), localObject);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, ((avun)localObject).jdField_b_of_type_JavaLangString);
    } while (!QLog.isColorLevel());
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send res file, fileRes path = " + ((avun)localObject).jdField_b_of_type_JavaLangString + ", mFidMList.size = " + paramConcurrentHashMap.size());
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2)
  {
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    if (paramString.endsWith(".db"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, path = " + paramString + ", dbMList.size = " + paramConcurrentHashMap1.size() + ", resMList.size = " + paramConcurrentHashMap2.size());
      }
      paramConcurrentHashMap1 = paramString.substring(paramString.lastIndexOf("/") + 1);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, dbName = " + paramConcurrentHashMap1);
      }
      paramConcurrentHashMap1 = new avtw();
      paramConcurrentHashMap1.jdField_a_of_type_Int = 1;
      paramConcurrentHashMap1.jdField_a_of_type_JavaLangString = paramString;
      avtq.a().b(paramConcurrentHashMap1);
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    avun localavun = new avun();
    localavun.jdField_a_of_type_Short = 0;
    localavun.jdField_a_of_type_Boolean = false;
    localavun.jdField_a_of_type_JavaLangString = paramString;
    localavun.jdField_a_of_type_Long = paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = " + paramLong2 + ", msg = " + paramString);
    }
    paramConcurrentHashMap.put(Long.valueOf(paramLong2), localavun);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong1, paramLong2, paramString);
  }
  
  private void a(long paramLong, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum arg4, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2, avun paramavun)
  {
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.jdField_d_of_type_Boolean + ", isResRequestAllFinished" + ???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", resReq fileTask receivedCompleted retry over time task = " + paramavun);
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if ((i == 0) && (j == 0) && (???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      ???.jdField_c_of_type_Boolean = true;
      a(???);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int + ", task = " + paramavun);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mclient will get db mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
      }
    }
    label324:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i = 0;
        if (paramConcurrentHashMap.hasNext())
        {
          if (!((avum)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            break label324;
          }
          i += 1;
          break label324;
        }
        if (this.jdField_a_of_type_Avtm != null) {
          this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
        }
        if (i == avtq.jdField_b_of_type_Int) {
          return;
        }
      }
      if (!a(2))
      {
        avwu.b("this session res has received! over time  so get next session!", new Object[0]);
        j(3);
        return;
      }
    }
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, avun paramavun)
  {
    if (paramavun.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mfidMlist fileTask receivedCompleted  called not success, so again task = " + paramavun);
      }
      if ((!TextUtils.isEmpty(paramavun.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramavun.c)))
      {
        if (paramavun.jdField_a_of_type_Short <= 3) {
          break label109;
        }
        paramConcurrentHashMap.remove(Long.valueOf(paramLong));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + paramavun);
      }
    }
    label109:
    do
    {
      return;
      if (a())
      {
        avwu.b("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
        return;
      }
      paramavun.jdField_a_of_type_Short = ((short)(paramavun.jdField_a_of_type_Short + 1));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramavun.c, paramavun.jdField_b_of_type_JavaLangString, paramavun.jdField_b_of_type_Boolean, paramavun.jdField_b_of_type_Long, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist called not success, so again task = " + paramavun);
      }
    } while (TextUtils.isEmpty(paramavun.c));
    if (paramavun.jdField_a_of_type_Short > 3)
    {
      paramConcurrentHashMap.remove(Long.valueOf(paramLong));
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist retry over time task = " + paramavun);
      return;
    }
    if (a())
    {
      avwu.b("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    paramavun.jdField_a_of_type_Short = ((short)(paramavun.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramavun.c);
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      avwu.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    a(paramLong, paramConcurrentHashMap, l, a(l, 1));
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, ConcurrentHashMap<String, avum> paramConcurrentHashMap1, Map<String, String> arg5)
  {
    if (???.size() >= 3)
    {
      if (a()) {
        avwu.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      }
    }
    else {
      return;
    }
    long l = Long.parseLong((String)???.get("fid"));
    String str = (String)???.get("chatUin");
    int i = Integer.parseInt((String)???.get("chatType"));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report 会话 uin =" + str + " 接收完成, chatType = " + i + "：mServerReadyMList.size = " + paramConcurrentHashMap1.size());
    }
    ??? = (avum)paramConcurrentHashMap1.get(avwu.b(str, i));
    if (??? != null)
    {
      ???.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Avtm == null) {}
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
        i = 0;
        if (paramConcurrentHashMap1.hasNext())
        {
          if (((avum)paramConcurrentHashMap1.next()).jdField_c_of_type_Boolean) {
            i += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report session completed! hasCompletedCount = " + i);
          }
          if (this.jdField_a_of_type_Avtm != null) {
            this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
          }
          if ((i != avtq.jdField_b_of_type_Int) || (QLog.isColorLevel())) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report session transport completed! fid = " + l + ", msg = []");
          }
          a(paramLong, paramConcurrentHashMap, l, a(l, 3));
          return;
        }
      }
    }
  }
  
  private void a(avum paramavum)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      i(258);
      return;
    }
    a(this.jdField_a_of_type_Long, false, paramavum.jdField_a_of_type_JavaLangString, paramavum.jdField_a_of_type_Int);
  }
  
  private void a(ConcurrentHashMap<String, avum> paramConcurrentHashMap, JSONArray paramJSONArray)
  {
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i);
      if ("chat_ready".equals(((JSONObject)localObject).optString("cmd")))
      {
        String str = ((JSONObject)localObject).optString("chatUin");
        int j = ((JSONObject)localObject).optInt("chatType");
        long l = ((JSONObject)localObject).optLong("dbSize");
        localObject = new avum();
        ((avum)localObject).jdField_b_of_type_Boolean = false;
        ((avum)localObject).jdField_a_of_type_JavaLangString = str;
        ((avum)localObject).jdField_a_of_type_Long = l;
        ((avum)localObject).jdField_a_of_type_Int = avwu.c(j);
        paramConcurrentHashMap.put(avwu.b(((avum)localObject).jdField_a_of_type_JavaLangString, j), localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + str + ", uintype = " + ((avum)localObject).jdField_a_of_type_Int + "：mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
        }
      }
      i += 1;
    }
    a(4);
  }
  
  private void a(ConcurrentHashMap<String, avum> paramConcurrentHashMap, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    avtq.jdField_b_of_type_Int = paramJSONObject.optInt("listCount");
    avwr.a();
    avwr.a.jdField_b_of_type_Long = avtq.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = " + avtq.jdField_b_of_type_Int);
    }
    int i = 1;
    while (i < paramJSONArray.length())
    {
      Object localObject = (JSONObject)paramJSONArray.get(i);
      if ("chat_ready".equals(((JSONObject)localObject).optString("cmd")))
      {
        paramJSONObject = ((JSONObject)localObject).optString("chatUin");
        int j = ((JSONObject)localObject).optInt("chatType");
        long l = ((JSONObject)localObject).optLong("dbSize");
        localObject = new avum();
        ((avum)localObject).jdField_b_of_type_Boolean = false;
        ((avum)localObject).jdField_a_of_type_JavaLangString = paramJSONObject;
        ((avum)localObject).jdField_a_of_type_Int = avwu.c(j);
        ((avum)localObject).jdField_a_of_type_Long = l;
        String str = avwu.b(((avum)localObject).jdField_a_of_type_JavaLangString, j);
        if (paramConcurrentHashMap.get(str) == null) {
          paramConcurrentHashMap.put(str, localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + paramJSONObject + ", uintype = " + ((avum)localObject).jdField_a_of_type_Int + "：mClientCanRecvMList= " + paramConcurrentHashMap);
        }
      }
      i += 1;
    }
    a(4);
  }
  
  private boolean a(long paramLong, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (!avtq.jdField_f_of_type_Boolean)
    {
      long l = Long.parseLong((String)paramMap.get("fid"));
      paramMap = new avun();
      paramMap.jdField_a_of_type_Short = 0;
      paramMap.jdField_a_of_type_Boolean = false;
      paramMap.jdField_a_of_type_JavaLangString = "[]";
      paramMap.jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, postinfo ui is not ready!" + l + ", msg = " + "[]");
      }
      paramConcurrentHashMap.put(Long.valueOf(l), paramMap);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
      return true;
    }
    return false;
  }
  
  private boolean a(ConcurrentHashMap<String, avum> paramConcurrentHashMap, boolean paramBoolean)
  {
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    int i = 0;
    avum localavum;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localavum = (avum)localIterator.next();
        if (!localavum.jdField_b_of_type_Boolean) {
          if (localavum.jdField_a_of_type_Long <= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + localavum.jdField_a_of_type_JavaLangString + ", uintype = " + localavum.jdField_a_of_type_Int + ", dbsize = " + localavum.jdField_a_of_type_Long);
            }
            localavum.jdField_c_of_type_Boolean = true;
            localavum.jdField_b_of_type_Boolean = true;
            a(localavum);
            if (this.jdField_a_of_type_Avtm == null) {
              continue;
            }
            i = a(paramConcurrentHashMap);
            if (this.jdField_a_of_type_Avtm != null) {
              this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
            }
            if (i == avtq.jdField_b_of_type_Int) {
              avwu.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((!paramBoolean) && (i != avtq.jdField_b_of_type_Int))
      {
        j(5);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step2 , , hasFinishedC = " + i);
        }
      }
      return paramBoolean;
      break;
      i = a(paramConcurrentHashMap);
      if (this.jdField_a_of_type_Avtm != null) {
        this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
      }
      if (i == avtq.jdField_b_of_type_Int)
      {
        avwu.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
      }
      else
      {
        localavum.jdField_b_of_type_Boolean = true;
        avtq.jdField_d_of_type_JavaLangString = localavum.jdField_a_of_type_JavaLangString;
        avtq.jdField_c_of_type_Int = localavum.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, current uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int + ", dbsize = " + localavum.jdField_a_of_type_Long);
        }
        a(this.jdField_a_of_type_Long, localavum.jdField_a_of_type_JavaLangString, localavum.jdField_a_of_type_Int, false);
        paramBoolean = true;
      }
    }
  }
  
  private void b(long paramLong, int paramInt, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2, avun paramavun)
  {
    Object localObject;
    if (paramavun.jdField_a_of_type_Boolean)
    {
      avwr.a();
      localObject = avwr.a;
      ((avwo)localObject).h += 1L;
      localObject = avwr.a;
      ((avwo)localObject).r += 1L;
      localObject = new avwp();
      if (!avtq.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(Long.valueOf(paramLong))) {
        break label218;
      }
      avwo localavwo = avwr.a;
      localavwo.k += 1L;
      avtq.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(Long.valueOf(paramLong));
    }
    label218:
    for (((avwp)localObject).jdField_c_of_type_Int = 2;; ((avwp)localObject).jdField_c_of_type_Int = 1)
    {
      ((avwp)localObject).jdField_b_of_type_Int = 2;
      ((avwp)localObject).jdField_a_of_type_Int = paramInt;
      avwr.a.a.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "resReq fileTask receivedCompleted  called not success, so again task = " + paramavun);
      }
      if ((!TextUtils.isEmpty(paramavun.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramavun.c)))
      {
        if ((paramavun.jdField_a_of_type_Short <= 3) || (!this.jdField_d_of_type_Boolean)) {
          break;
        }
        a(paramLong, paramConcurrentHashMap, paramavum, paramConcurrentHashMap1, paramConcurrentHashMap2, paramavun);
      }
      return;
    }
    if (a())
    {
      avwu.b("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
      return;
    }
    paramavun.jdField_a_of_type_Short = ((short)(paramavun.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramavun.c, paramavun.jdField_b_of_type_JavaLangString, paramavun.jdField_b_of_type_Boolean, paramavun.jdField_b_of_type_Long, true);
  }
  
  private void b(long paramLong, avun arg3, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum paramavum, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1)
  {
    avtq.jdField_a_of_type_Int += 1;
    avwu.b("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(avtq.jdField_a_of_type_Int) });
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.jdField_d_of_type_Boolean + ", 此会话db一直失败，扔掉，通知对端dbMList receivedCompleted retry over time task = " + ???);
    paramavum.jdField_c_of_type_Boolean = true;
    a(paramavum);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "getdb failed !  mclient will get db mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
    }
    label246:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        int i = 0;
        if (paramConcurrentHashMap.hasNext())
        {
          if (!((avum)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            break label246;
          }
          i += 1;
          break label246;
        }
        if (this.jdField_a_of_type_Avtm != null) {
          this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
        }
        if (i == avtq.jdField_b_of_type_Int) {
          return;
        }
      }
      if (!a(2))
      {
        avwu.b("this session db has received error! so get next session!", new Object[0]);
        j(3);
        return;
      }
    }
  }
  
  private void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (avwu.jdField_b_of_type_Boolean) {}
    for (paramString1 = avwu.a(paramString2, this.jdField_a_of_type_JavaLangString);; paramString1 = paramString2)
    {
      avwr.a();
      paramString2 = avtq.a().g;
      ConcurrentHashMap localConcurrentHashMap = avtq.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, MsgBackupManager.curDealType = " + avtq.jdField_d_of_type_JavaLangString + ", MsgBackupManager.curDealType = " + avtq.jdField_c_of_type_Int);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (paramString1 != null))
      {
        if (paramString1.contains("/postinfo?")) {
          c(paramLong, paramString1, paramString2, localConcurrentHashMap);
        }
      }
      else {
        return;
      }
      if (paramString1.contains("/getmsg?"))
      {
        b(paramLong, paramString1, paramString2, localConcurrentHashMap);
        return;
      }
      if (paramString1.contains("/getres?"))
      {
        a(paramLong, paramString1, paramString2);
        return;
      }
      a(paramLong, paramString1);
      return;
    }
  }
  
  private void b(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    if (avwu.jdField_b_of_type_Boolean) {
      paramString1 = avwu.b(paramString1, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap2 = avtq.a().g;
      avun localavun = (avun)localConcurrentHashMap2.get(Long.valueOf(paramLong1));
      ConcurrentHashMap localConcurrentHashMap1 = avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted called! mfidMlist.size = " + localConcurrentHashMap2.size() + ", mClientCanRecvMList.size = " + localConcurrentHashMap1.size() + ", path = " + paramString2 + ",url = " + paramString1 + ", fid = " + paramLong1 + ",errorCode = " + paramInt1 + ", task = " + localavun + "，mFidMList " + localConcurrentHashMap2.toString() + ", MsgBackupManager.sessionCount = " + avtq.jdField_b_of_type_Int);
      }
      if (localavun != null) {
        if (paramInt1 == 0) {
          a(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramLong2, localConcurrentHashMap2, localConcurrentHashMap1);
        }
      }
      do
      {
        return;
        a(paramLong1, localConcurrentHashMap2, localavun);
        return;
        paramArrayOfByte = avwu.b(avtq.jdField_d_of_type_JavaLangString, avwu.b(avtq.jdField_c_of_type_Int));
        paramString1 = (avum)localConcurrentHashMap1.get(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted key = " + paramArrayOfByte + ", mClientCanRecvMList = " + localConcurrentHashMap1 + ", sessionInfo = " + paramString1 + ", errCode = " + paramInt1);
        }
      } while (paramString1 == null);
      paramArrayOfByte = paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      localConcurrentHashMap2 = paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      localavun = (avun)paramArrayOfByte.get(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  dbMList task = " + localavun + ", dbMList = " + paramArrayOfByte.toString() + ". sessionInfo.hashcode = " + paramString1.hashCode());
      }
      if (localavun != null)
      {
        a(paramLong1, paramInt1, paramString2, localavun, localConcurrentHashMap1, paramString1, paramArrayOfByte, localConcurrentHashMap2);
        return;
      }
      a(paramLong1, paramInt1, localConcurrentHashMap1, paramString1, paramArrayOfByte, localConcurrentHashMap2);
      return;
    }
  }
  
  private void b(long paramLong, String paramString, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, ConcurrentHashMap<String, avum> paramConcurrentHashMap1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
    }
    if (a())
    {
      avwu.b("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Avtm != null) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      avwu.b("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.jdField_a_of_type_Avtm != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Avtm.c(true);
      }
      localObject1 = avwu.a(paramString);
      l = Long.parseLong((String)((Map)localObject1).get("fid"));
      if (avtq.jdField_f_of_type_Boolean) {
        break;
      }
      paramString = new avun();
      paramString.jdField_a_of_type_Short = 0;
      paramString.jdField_a_of_type_Boolean = false;
      paramString.jdField_a_of_type_JavaLangString = "[]";
      paramString.jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, getmsg ui is not ready!" + l + ", msg = " + "[]");
      }
      paramConcurrentHashMap.put(Long.valueOf(l), paramString);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
      return;
    }
    paramString = new avwq();
    paramString.jdField_a_of_type_Boolean = false;
    paramString.jdField_a_of_type_Long = 0L;
    avtq.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), paramString);
    paramString = (String)((Map)localObject1).get("chatUin");
    int j = Integer.parseInt((String)((Map)localObject1).get("chatType"));
    Object localObject1 = avwu.a(paramString, j, null);
    ??? = new avun();
    ((avun)???).jdField_a_of_type_Short = 0;
    ((avun)???).jdField_a_of_type_Boolean = true;
    ((avun)???).jdField_a_of_type_Long = paramLong;
    ((avun)???).jdField_b_of_type_JavaLangString = ((String)localObject1);
    paramConcurrentHashMap.put(Long.valueOf(l), ???);
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
        if (paramConcurrentHashMap1.hasNext())
        {
          if (((avum)paramConcurrentHashMap1.next()).jdField_c_of_type_Boolean) {
            i += 1;
          }
        }
        else
        {
          if (this.jdField_a_of_type_Avtm != null) {
            this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, (String)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send db uin = " + paramString + ", uinType = " + avwu.c(j) + ", dbpath = " + (String)localObject1 + ", fid = " + l + ", mFidMList.size = " + paramConcurrentHashMap.size());
          return;
        }
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<String, avum> paramConcurrentHashMap, avum arg4, ConcurrentHashMap<Long, avun> paramConcurrentHashMap1, ConcurrentHashMap<Long, avun> paramConcurrentHashMap2, avun paramavun)
  {
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called success, isResRequestAllFinished " + ???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", task = " + paramavun + ", resMList.size = " + i);
    }
    if ((i == 0) && (j == 0) && (???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      ???.jdField_c_of_type_Boolean = true;
      a(???);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int + ", task = " + paramavun);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup", 2, "mclient will get db mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
      }
    }
    label328:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
        i = 0;
        if (paramConcurrentHashMap.hasNext())
        {
          if (!((avum)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            break label328;
          }
          i += 1;
          break label328;
        }
        if (this.jdField_a_of_type_Avtm != null) {
          this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
        }
        if (i == avtq.jdField_b_of_type_Int) {
          return;
        }
      }
      if (!a(2))
      {
        avwu.b("this session res has received! so get next session!", new Object[0]);
        j(3);
        return;
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      avwu.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if (this.jdField_a_of_type_JavaLangInteger.intValue() != 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = ((String)paramMap.get("ip"));
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(Integer.parseInt((String)paramMap.get("udpport")));
    }
    if (this.jdField_b_of_type_JavaLangInteger.intValue() != 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = ((String)paramMap.get("ip"));
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(Integer.parseInt((String)paramMap.get("tcpport")));
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report its port and ipv4, fid = " + l + ", msg = []");
    }
    a(paramLong, paramConcurrentHashMap, l, a(l, 2));
  }
  
  private void b(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "recvMessageUdp udpdetected = " + this.jdField_c_of_type_Boolean + ", ip = " + paramString1 + ", port = " + paramInt1 + ", cmd = " + paramInt2 + ", cookie = " + paramLong + ", data = " + paramString2);
    }
    if (paramInt2 == 256) {}
    do
    {
      return;
      if (paramInt2 == 257)
      {
        g(paramString2);
        return;
      }
      if (paramInt2 == 258)
      {
        f(paramString2);
        return;
      }
    } while (paramInt2 != 259);
    e(paramString2);
  }
  
  private String c()
  {
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", avtf.a().a());
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
  
  private void c(long paramLong, String paramString, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, ConcurrentHashMap<String, avum> paramConcurrentHashMap1)
  {
    if (a()) {
      avwu.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
      }
      paramString = avwu.a(paramString);
    } while (a(paramLong, paramConcurrentHashMap, paramString));
    if (paramString.size() == 1)
    {
      a(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (!TextUtils.isEmpty((CharSequence)paramString.get("exit")))
    {
      c(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    if (paramString.size() == 4)
    {
      b(paramLong, paramConcurrentHashMap, paramString);
      return;
    }
    a(paramLong, paramConcurrentHashMap, paramConcurrentHashMap1, paramString);
  }
  
  private void c(long paramLong, ConcurrentHashMap<Long, avun> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      avwu.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if ((!TextUtils.isEmpty((String)paramMap.get("exit"))) && (this.jdField_a_of_type_Avtm != null)) {
      this.jdField_a_of_type_Avtm.b(true);
    }
    paramMap = new avun();
    paramMap.jdField_a_of_type_Short = 0;
    paramMap.jdField_a_of_type_Boolean = false;
    paramMap.jdField_a_of_type_JavaLangString = "[]";
    paramMap.jdField_a_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, notify has exit!, fid = " + l + ", msg = " + "[]");
    }
    paramConcurrentHashMap.put(Long.valueOf(l), paramMap);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong, l, "[]");
  }
  
  private void e(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() == 1)
      {
        paramString = (JSONObject)paramString.get(0);
        if ("exit".equals(paramString.optString("cmd")))
        {
          paramString = paramString.optString("sig");
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "-------------------exit-------------------");
          }
          if ((TextUtils.equals(paramString, avtf.a().a())) && (this.jdField_a_of_type_Avtm != null)) {
            this.jdField_a_of_type_Avtm.b(true);
          }
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_EXIT parse json error!", paramString);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.stop(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.destroySession(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
    avwj.a().a();
  }
  
  private void f(String arg1)
  {
    int j = 0;
    Object localObject1;
    int i;
    try
    {
      localObject1 = avtq.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      ??? = new JSONArray(???);
      if (???.length() < 1) {
        break label258;
      }
      i = 0;
      if (i >= ???.length()) {
        break label258;
      }
      Object localObject3 = (JSONObject)???.get(i);
      ((JSONObject)localObject3).optString("cmd");
      String str = ((JSONObject)localObject3).optString("chatUin");
      int k = ((JSONObject)localObject3).optInt("chatType");
      localObject3 = avwu.b(str, k);
      avum localavum = (avum)((ConcurrentHashMap)localObject1).get(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! keyFromUin = " + (String)localObject3 + ", mMList = " + localObject1);
      }
      if (localavum != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "udp 通知 此会话接受完成 chatUin = " + str + ", uinType = " + avwu.c(k));
        }
        localavum.jdField_c_of_type_Boolean = true;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! chatUin = " + str + ", chatType = " + k);
      }
    }
    catch (JSONException ???)
    {
      QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", ???);
    }
    label257:
    return;
    label258:
    label352:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localObject1 = ((ConcurrentHashMap)localObject1).values().iterator();
        i = j;
        if (((Iterator)localObject1).hasNext())
        {
          if (((avum)((Iterator)localObject1).next()).jdField_c_of_type_Boolean)
          {
            i += 1;
            break label352;
          }
        }
        else
        {
          if (this.jdField_a_of_type_Avtm == null) {
            break label257;
          }
          this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
          return;
        }
      }
      break label352;
      i += 1;
      break;
    }
  }
  
  private void g(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        ConcurrentHashMap localConcurrentHashMap = avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        paramString = new JSONArray(paramString);
        if (paramString.length() >= 1)
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = (JSONObject)paramString.get(i);
            String str = ((JSONObject)localObject).optString("cmd");
            if ("chat_list_count".equals(str))
            {
              avtq.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("listCount");
              avwr.a();
              avwr.a.jdField_b_of_type_Long = avtq.jdField_b_of_type_Int;
            }
            if ("chat_ready".equals(str))
            {
              str = ((JSONObject)localObject).optString("chatUin");
              int j = ((JSONObject)localObject).optInt("chatType");
              long l = ((JSONObject)localObject).optLong("dbSize");
              localObject = new avum();
              ((avum)localObject).jdField_c_of_type_Boolean = false;
              ((avum)localObject).jdField_b_of_type_Boolean = false;
              ((avum)localObject).jdField_a_of_type_JavaLangString = str;
              ((avum)localObject).jdField_a_of_type_Int = avwu.c(j);
              ((avum)localObject).jdField_a_of_type_Long = l;
              str = avwu.b(((avum)localObject).jdField_a_of_type_JavaLangString, j);
              if (localConcurrentHashMap.get(str) == null) {
                localConcurrentHashMap.put(str, localObject);
              }
            }
          }
          else
          {
            a(3);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", paramString);
        return;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaLangInteger.intValue();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString[0];
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
        localObject1 = avtq.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject3 = new avun();
        ((avun)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((avun)localObject3).jdField_a_of_type_Int = paramInt;
        ((avun)localObject3).jdField_a_of_type_Short = 0;
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
        if (!avtq.jdField_f_of_type_Boolean)
        {
          ??? = ((JSONArray)localObject1).toString();
          localObject1 = avtq.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localObject3 = new avun();
          ((avun)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
          ((avun)localObject3).jdField_a_of_type_Int = paramInt;
          ((avun)localObject3).jdField_a_of_type_Short = 0;
          ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
          localObject1 = ???;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "MsgBackupManager.sUIReady = " + avtq.jdField_f_of_type_Boolean + ", getSessionJson is called! cookie = " + paramLong + ", msg = " + (String)???);
          return ???;
        }
        ??? = avtq.a().jdField_a_of_type_JavaUtilHashSet;
        localObject3 = avtq.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        i = avtq.jdField_b_of_type_Int;
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
              localObject4 = (avum)((Iterator)localObject3).next();
              i = j;
              if (((avum)localObject4).jdField_c_of_type_Boolean) {
                i = j + 1;
              }
              j = i;
              if (!((avum)localObject4).jdField_a_of_type_Boolean)
              {
                localObject5 = ((avum)localObject4).jdField_a_of_type_JavaLangString;
                j = ((avum)localObject4).jdField_a_of_type_Int;
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("cmd", "chat_ready");
                localJSONObject.put("chatUin", localObject5);
                localJSONObject.put("chatType", avwu.b(j));
                localJSONObject.put("dbSize", ((avum)localObject4).jdField_a_of_type_Long);
                localJSONException.put(localJSONObject);
                ((avum)localObject4).jdField_a_of_type_Boolean = true;
                j = i;
              }
            }
          }
          if (this.jdField_a_of_type_Avtm != null) {
            this.jdField_a_of_type_Avtm.a(j, avtq.jdField_b_of_type_Int);
          }
        }
      }
      else if (paramInt == 258)
      {
        ??? = avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (avum)((Iterator)???).next();
          if ((!((avum)localObject3).jdField_d_of_type_Boolean) && (((avum)localObject3).jdField_c_of_type_Boolean))
          {
            localObject4 = ((avum)localObject3).jdField_a_of_type_JavaLangString;
            i = ((avum)localObject3).jdField_a_of_type_Int;
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("cmd", "chat_transfer_complete");
            ((JSONObject)localObject5).put("chatUin", localObject4);
            ((JSONObject)localObject5).put("chatType", avwu.b(i));
            str.put(localObject5);
            ((avum)localObject3).jdField_d_of_type_Boolean = true;
          }
        }
      }
      else if (paramInt == 259)
      {
        ??? = new JSONObject();
        ((JSONObject)???).put("cmd", "exit");
        ((JSONObject)???).put("sig", avtf.a().a());
        str.put(???);
      }
    }
    return str;
  }
  
  public String a(String paramString)
  {
    return avwu.a(paramString, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    avwt.a(paramLong1, paramLong2);
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong3;
        if (this.jdField_a_of_type_Avtm != null)
        {
          this.jdField_a_of_type_Avtm.a(1000L * paramLong3 / paramLong2);
          avwt.b(paramLong1, paramLong3 * 1000L / paramLong2);
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
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (this.jdField_a_of_type_Int == 2) {
      b(paramLong, paramString1, paramInt, paramString2);
    }
  }
  
  public void a(long paramLong1, String paramString1, int paramInt1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, long paramLong2)
  {
    avwu.b("MsgBackup_MsgBackupTransportProcessor", "onRecvComplete from jni fid = %d,url = %s,errcode = %d,path = %s ", new Object[] { Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramInt1), paramString2 });
    avwt.a(paramLong1);
    b(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    avwt.a(paramLong1, paramLong3);
    avwr.a();
    if (avtq.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (avwq)avtq.a().e.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_a_of_type_Long = paramLong3;
        paramString = avwr.a;
        paramString.e += paramLong3;
      }
    }
    while (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong4;
        if (this.jdField_a_of_type_Avtm != null)
        {
          this.jdField_a_of_type_Avtm.a(1000L * paramLong3 / paramLong2);
          avwt.b(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
        if (avtq.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
        {
          paramString = (avwq)avtq.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
          if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
          {
            paramString.jdField_a_of_type_Boolean = true;
            paramString.jdField_a_of_type_Long = paramLong3;
            paramString = avwr.a;
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
    avwt.a(paramLong1);
    avwr.a();
    Object localObject;
    label184:
    avun localavun;
    if (avtq.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (avwq)avtq.a().e.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = avwu.a(((avwq)localObject).jdField_a_of_type_Long);
        if (bool)
        {
          localObject = avwr.a;
          ((avwo)localObject).j += 1L;
        }
        if (!paramBoolean)
        {
          localObject = avwr.a;
          ((avwo)localObject).r += 1L;
          localObject = new avwp();
          ((avwp)localObject).jdField_b_of_type_Int = 2;
          if (!bool) {
            break label273;
          }
          paramInt2 = 2;
          ((avwp)localObject).jdField_c_of_type_Int = paramInt2;
          ((avwp)localObject).jdField_a_of_type_Int = paramInt1;
          avwr.a.a.add(localObject);
          if (bool)
          {
            localObject = avwr.a;
            ((avwo)localObject).k += 1L;
          }
        }
      }
      avtq.a().e.remove(Long.valueOf(paramLong1));
      localObject = avtq.a().g;
      localavun = (avun)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localavun == null) {
        break label724;
      }
      if (!paramBoolean) {
        break label426;
      }
      ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  task = " + localavun + ", mFidMList.size = " + ((ConcurrentHashMap)localObject).size());
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
          if (!avtq.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
            break label184;
          }
          if ((avwq)avtq.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1)) != null)
          {
            localObject = avwr.a;
            ((avwo)localObject).m += 1L;
            if (!paramBoolean)
            {
              localObject = avwr.a;
              ((avwo)localObject).n += 1L;
              localObject = avwr.a;
              ((avwo)localObject).r += 1L;
              localObject = new avwp();
              ((avwp)localObject).jdField_b_of_type_Int = 1;
              ((avwp)localObject).jdField_c_of_type_Int = 0;
              ((avwp)localObject).jdField_a_of_type_Int = paramInt1;
              avwr.a.a.add(localObject);
            }
          }
          avtq.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
          break label184;
          if (!localavun.jdField_a_of_type_Boolean) {
            break label579;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "fileTask onSendComplete  called not success, so again  task = " + localavun);
          }
        } while (TextUtils.isEmpty(localavun.jdField_b_of_type_JavaLangString));
        if (localavun.jdField_a_of_type_Short > 3)
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete fileTask  retry over time task = " + localavun);
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (a())
        {
          avwu.b("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        localavun.jdField_a_of_type_Short = ((short)(localavun.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, localavun.jdField_a_of_type_Long, paramLong1, localavun.jdField_b_of_type_JavaLangString);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called not success, so again task = " + localavun);
        }
      } while (TextUtils.isEmpty(localavun.jdField_a_of_type_JavaLangString));
      if (localavun.jdField_a_of_type_Short > 3)
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete retry over time task = " + localavun);
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        return;
      }
      if (a())
      {
        avwu.b("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      localavun.jdField_a_of_type_Short = ((short)(localavun.jdField_a_of_type_Short + 1));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, localavun.jdField_a_of_type_Long, paramLong1, localavun.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called, please check your mFidMList whether contains this task, before execute, should add in mFidMList!, path = " + paramString + ", fid = " + paramLong1);
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.jdField_d_of_type_JavaLangInteger.intValue() == 0) || (this.jdField_c_of_type_JavaLangInteger.intValue() == 0)) {
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
        avwu.b("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      long l = avwu.a();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = "postinfo?fid=" + l + "&chatUin=" + paramString + "&chatType=" + avwu.b(paramInt);
        avwu.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
        paramString = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + avwu.b(paramString, this.jdField_a_of_type_JavaLangString);
      }
      while ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
      {
        avun localavun = new avun();
        localavun.jdField_a_of_type_Short = 0;
        localavun.jdField_a_of_type_Boolean = false;
        localavun.c = paramString;
        avtq.a().g.put(Long.valueOf(l), localavun);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer fid = " + l + ", url = " + paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, paramString);
        return;
        if (paramBoolean)
        {
          paramString = "postinfo?fid=" + l + "&ip=" + this.jdField_a_of_type_ArrayOfJavaLangString[0] + "&tcpport=" + this.jdField_b_of_type_JavaLangInteger + "&udpport=" + this.jdField_a_of_type_JavaLangInteger;
          avwu.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + avwu.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramString = "postinfo?fid=" + l;
          avwu.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + avwu.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    avwu.b("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
  }
  
  public void a(avtm paramavtm)
  {
    this.jdField_a_of_type_Avtm = paramavtm;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      avtq.a().a();
      avwu.a();
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      e(1);
      avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.1(this, paramString));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_JavaLangInteger.intValue() != 0) {
        this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(paramInt);
      }
    }
    while ((this.jdField_a_of_type_Int != 2) || (this.jdField_c_of_type_JavaLangInteger.intValue() == 0)) {
      return;
    }
    this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    b(paramString1, paramInt1, paramInt2, paramString2, paramLong);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    avtq.a().a();
    avwu.a();
    avtq.a().a().a(paramInt);
    avtq.a().a().a(paramString2);
    avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    e(1);
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
      avwu.b("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      avwr.a();
      localObject = avwr.a;
      ((avwo)localObject).g += 1L;
      localObject = avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((paramString1 != null) || (paramString2 != null)) {
        break;
      }
      avwu.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { avtq.jdField_d_of_type_JavaLangString, Integer.valueOf(avtq.jdField_c_of_type_Int) });
      paramString1 = (avum)((ConcurrentHashMap)localObject).get(avwu.b(avtq.jdField_d_of_type_JavaLangString, avwu.b(avtq.jdField_c_of_type_Int)));
    } while (paramString1 == null);
    avwu.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    if ((paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) && (paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {
      a(6);
    }
    paramString1.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    return;
    new File(paramString2).getParentFile().mkdirs();
    long l = avwu.a();
    paramString1 = avwu.b(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l), paramString1 }), this.jdField_a_of_type_JavaLangString);
    paramString1 = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + paramString1;
    avun localavun = new avun();
    localavun.jdField_a_of_type_Short = 0;
    localavun.jdField_a_of_type_Boolean = true;
    localavun.jdField_b_of_type_JavaLangString = paramString2;
    localavun.c = paramString1;
    localavun.jdField_b_of_type_Boolean = avwu.a(paramLong);
    localavun.jdField_b_of_type_Long = paramLong;
    avwo localavwo = avwr.a;
    localavwo.e += paramLong;
    Object localObject = (avum)((ConcurrentHashMap)localObject).get(avwu.b(avtq.jdField_d_of_type_JavaLangString, avwu.b(avtq.jdField_c_of_type_Int)));
    if (localObject != null) {
      ((avum)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localavun);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, paramString1, paramString2, localavun.jdField_b_of_type_Boolean, localavun.jdField_b_of_type_Long, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    avtq.a().a();
    avwu.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
    }
    e(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  protected void a(ConcurrentHashMap<String, avum> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(avtq.jdField_d_of_type_JavaLangString))
    {
      avum localavum = (avum)paramConcurrentHashMap.get(avwu.b(avtq.jdField_d_of_type_JavaLangString, avwu.b(avtq.jdField_c_of_type_Int)));
      if (localavum != null)
      {
        localavum.jdField_c_of_type_Boolean = true;
        avwu.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { avtq.jdField_d_of_type_JavaLangString, Integer.valueOf(avtq.jdField_c_of_type_Int) });
        a(localavum);
        if (this.jdField_a_of_type_Avtm != null)
        {
          int i = a(paramConcurrentHashMap);
          if (this.jdField_a_of_type_Avtm != null) {
            this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
          }
          if ((i != avtq.jdField_b_of_type_Int) || (this.jdField_a_of_type_Avtm == null)) {}
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    avwr.a();
    avwr.a.jdField_b_of_type_Boolean = this.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject;
    avun localavun;
    if (2 == this.jdField_a_of_type_Int)
    {
      localObject = avtq.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
      localavun = (avun)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localavun != null)
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
              if (localavun.jdField_a_of_type_Short > 3)
              {
                ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localavun);
                return;
              }
              localavun.jdField_a_of_type_Short = ((short)(localavun.jdField_a_of_type_Short + 1));
              localObject = localavun.jdField_a_of_type_JavaLangString;
              i = localavun.jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: " + localavun);
              }
            } while (TextUtils.isEmpty((CharSequence)localObject));
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
            return;
          } while (1 != this.jdField_a_of_type_Int);
          localObject = avtq.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localavun = (avun)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_CLIENT");
          }
        } while (localavun == null);
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
      if (localavun.jdField_a_of_type_Short > 3)
      {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localavun);
        return;
      }
      localObject = localavun.jdField_a_of_type_JavaLangString;
      i = localavun.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage  role = MBRROLE_CLIENT: " + localavun);
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
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if ((!this.jdField_d_of_type_Boolean) && (paramInt == 3))
        {
          this.e = true;
          avwu.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
          return bool2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, from = " + paramInt);
        }
        ConcurrentHashMap localConcurrentHashMap1 = avtq.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        if ((paramInt == 1) || (paramInt == 6)) {
          a(localConcurrentHashMap1);
        }
        boolean bool1;
        if (!TextUtils.isEmpty(avtq.jdField_d_of_type_JavaLangString))
        {
          bool1 = a(localConcurrentHashMap1);
          if ((localConcurrentHashMap1.size() == 0) || (TextUtils.isEmpty(avtq.jdField_d_of_type_JavaLangString)))
          {
            j(5);
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step1");
            }
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with from = " + paramInt + ", ret = " + bool1 + ", sessionCount = " + avtq.jdField_b_of_type_Int);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = b(localConcurrentHashMap2);
        }
      }
      finally {}
    }
  }
  
  protected boolean a(ConcurrentHashMap<String, avum> paramConcurrentHashMap)
  {
    avum localavum = (avum)paramConcurrentHashMap.get(avwu.b(avtq.jdField_d_of_type_JavaLangString, avwu.b(avtq.jdField_c_of_type_Int)));
    if (localavum != null)
    {
      if (localavum.jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int);
        }
        return a(paramConcurrentHashMap, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "current session not completed! requestNextSessionDb !, current uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int);
      }
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaLangInteger.intValue();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_ArrayOfJavaLangString[0];
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onDestroy called! operator = " + this.jdField_a_of_type_Long);
    }
    a();
    e(2);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = paramString;
  }
  
  public void b(String paramString, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Avtm != null) {
      this.jdField_a_of_type_Avtm.b(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean b(ConcurrentHashMap<String, avum> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int);
    }
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    avum localavum;
    while (localIterator.hasNext())
    {
      localavum = (avum)localIterator.next();
      if (!localavum.jdField_b_of_type_Boolean)
      {
        if (localavum.jdField_a_of_type_Long > 0L) {
          break label266;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + localavum.jdField_a_of_type_JavaLangString + ", uintype = " + localavum.jdField_a_of_type_Int + ", dbSize = " + localavum.jdField_a_of_type_Long);
        }
        localavum.jdField_c_of_type_Boolean = true;
        localavum.jdField_b_of_type_Boolean = true;
        a(localavum);
        if (this.jdField_a_of_type_Avtm != null)
        {
          i = a(paramConcurrentHashMap);
          if ((this.jdField_a_of_type_Avtm != null) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Avtm.c(true);
          }
          if (this.jdField_a_of_type_Avtm != null) {
            this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
          }
          if ((i == avtq.jdField_b_of_type_Int) && (this.jdField_a_of_type_Avtm != null)) {
            avwu.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
          }
        }
      }
    }
    return false;
    label266:
    localavum.jdField_b_of_type_Boolean = true;
    avtq.jdField_d_of_type_JavaLangString = localavum.jdField_a_of_type_JavaLangString;
    avtq.jdField_c_of_type_Int = localavum.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, uin = " + avtq.jdField_d_of_type_JavaLangString + ", uintype = " + avtq.jdField_c_of_type_Int + ", dbsize = " + localavum.jdField_a_of_type_Long);
    }
    int i = a(paramConcurrentHashMap);
    if ((this.jdField_a_of_type_Avtm != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Avtm.c(true);
    }
    if (this.jdField_a_of_type_Avtm != null) {
      this.jdField_a_of_type_Avtm.a(i, avtq.jdField_b_of_type_Int);
    }
    if (i == avtq.jdField_b_of_type_Int)
    {
      avwu.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
      return false;
    }
    a(this.jdField_a_of_type_Long, localavum.jdField_a_of_type_JavaLangString, localavum.jdField_a_of_type_Int, false);
    return true;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_JavaLangInteger.intValue();
  }
  
  public void c()
  {
    int i = avtf.a().a();
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
    this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void c(String paramString)
  {
    this.jdField_b_of_type_ArrayOfJavaLangString[0] = paramString;
  }
  
  public void c(String paramString, int paramInt) {}
  
  public int d()
  {
    return this.jdField_d_of_type_JavaLangInteger.intValue();
  }
  
  public void d()
  {
    String str = c();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + str + ", isUdpDetected = " + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_c_of_type_Boolean) {
      i(259);
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
          if ((this.jdField_d_of_type_JavaLangInteger.intValue() != 0) && (this.jdField_c_of_type_JavaLangInteger.intValue() != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp called- for client-------------->>>");
        return;
      } while (!this.jdField_d_of_type_Boolean);
      if (a())
      {
        avwu.b("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      l = avwu.a();
      str = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
      localObject = "postinfo?fid=" + l + "&exit=1";
      avwu.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = avwu.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new avun();
    ((avun)localObject).jdField_a_of_type_Short = 0;
    ((avun)localObject).jdField_a_of_type_Boolean = false;
    ((avun)localObject).c = str;
    avtq.a().g.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp fid = " + l + ", url = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, str);
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_JavaLangInteger = Integer.valueOf(paramInt);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void d(String paramString, int paramInt) {}
  
  public int e()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void e()
  {
    Object localObject = c();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + (String)localObject);
    }
    if (this.jdField_c_of_type_Boolean)
    {
      i(259);
      return;
    }
    localObject = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", avtf.a().a());
      ((JSONArray)localObject).put(localJSONObject);
      avth.a().a(((JSONArray)localObject).toString());
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
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (!a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "stop called! operator = " + this.jdField_a_of_type_Long + ". from = " + paramInt);
      }
      avtq.a().b();
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
  
  public void f(int paramInt)
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
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientIP = " + a() + ", clientUdpPort = " + this.jdField_a_of_type_JavaLangInteger + ", clientTcpPort = " + this.jdField_b_of_type_JavaLangInteger);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverIP = " + b() + ", serverUdpPort = " + this.jdField_c_of_type_JavaLangInteger + ", serverTcpPort = " + this.jdField_d_of_type_JavaLangInteger);
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangInteger.intValue(), this.jdField_b_of_type_JavaLangInteger.intValue());
        }
        while (QLog.isColorLevel())
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint end， operator = " + this.jdField_a_of_type_Long);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientIP = " + a() + ", clientUdpPort = " + this.jdField_a_of_type_JavaLangInteger + ", clientTcpPort = " + this.jdField_b_of_type_JavaLangInteger);
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverIP = " + b() + ", serverUdpPort = " + this.jdField_c_of_type_JavaLangInteger + ", serverTcpPort = " + this.jdField_d_of_type_JavaLangInteger);
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.setPeerEndpoint(this.jdField_a_of_type_Long, this.jdField_b_of_type_ArrayOfJavaLangString, this.jdField_c_of_type_JavaLangInteger.intValue(), this.jdField_d_of_type_JavaLangInteger.intValue());
        }
      }
    }
  }
  
  public void g(int paramInt)
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
  
  public void h(int paramInt)
  {
    if (paramInt != 0) {}
    for (this.jdField_d_of_type_Boolean = true;; this.jdField_d_of_type_Boolean = false)
    {
      if (this.jdField_d_of_type_Boolean) {
        avwt.a("cost_connect_total", null);
      }
      avwr.a();
      avwr.a.jdField_d_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Avtm != null) {
        this.jdField_a_of_type_Avtm.a(this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.e))
      {
        this.e = false;
        avwu.b("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
        a(3);
      }
      j(2);
      return;
    }
  }
  
  public void i(int paramInt)
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
        l = avwu.a();
        String str = a(paramInt, l);
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramInt, str, l);
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp udpdetected = " + this.jdField_c_of_type_Boolean + ", cmd = " + paramInt + ", cookieIndex = " + l);
      return;
    }
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp is error! please use tcp get! udpdetected = " + this.jdField_c_of_type_Boolean + ", cmd = " + paramInt);
  }
  
  public void j(int paramInt)
  {
    if ((this.jdField_d_of_type_JavaLangInteger.intValue() == 0) || (this.jdField_c_of_type_JavaLangInteger.intValue() == 0)) {
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
        avwu.b("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
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
      l = avwu.a();
      str = avwu.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
      localObject = "postinfo?fid=" + l;
      avwu.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = avwu.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new avun();
    ((avun)localObject).jdField_a_of_type_Boolean = false;
    ((avun)localObject).jdField_a_of_type_Short = 0;
    ((avun)localObject).c = str;
    avtq.a().g.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList fid = " + l + ", url = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwk
 * JD-Core Version:    0.7.0.1
 */