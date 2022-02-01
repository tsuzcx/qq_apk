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

public class axcm
{
  private static axcm jdField_a_of_type_Axcm;
  public int a;
  public long a;
  private awzo jdField_a_of_type_Awzo;
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
  
  public axcm()
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[10];
    this.jdField_a_of_type_JavaLangInteger = new Integer(0);
    this.jdField_b_of_type_JavaLangInteger = new Integer(0);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[10];
    this.jdField_c_of_type_JavaLangInteger = new Integer(0);
    this.jdField_d_of_type_JavaLangInteger = new Integer(0);
  }
  
  private int a(ConcurrentHashMap<String, axao> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = paramConcurrentHashMap.values().iterator();
    int i = 0;
    if (paramConcurrentHashMap.hasNext())
    {
      if (!((axao)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
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
  
  public static axcm a()
  {
    if (jdField_a_of_type_Axcm == null) {}
    try
    {
      if (jdField_a_of_type_Axcm == null) {
        jdField_a_of_type_Axcm = new axcm();
      }
      return jdField_a_of_type_Axcm;
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
    int i = awzs.jdField_b_of_type_Int;
    Object localObject3 = awzs.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
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
          axao localaxao = (axao)((Iterator)localObject3).next();
          i = j;
          if (localaxao.jdField_c_of_type_Boolean) {
            i = j + 1;
          }
          j = i;
          if (!localaxao.jdField_a_of_type_Boolean)
          {
            JSONObject localJSONObject = new JSONObject();
            String str2 = localaxao.jdField_a_of_type_JavaLangString;
            j = localaxao.jdField_a_of_type_Int;
            localJSONObject.put("cmd", "chat_ready");
            localJSONObject.put("chatUin", str2);
            localJSONObject.put("chatType", axcw.b(j));
            localJSONObject.put("dbSize", localaxao.jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject);
            localaxao.jdField_a_of_type_Boolean = true;
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
    if ((3 == paramInt) && (this.jdField_a_of_type_Awzo != null)) {
      this.jdField_a_of_type_Awzo.a(j, awzs.jdField_b_of_type_Int);
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
      axcw.b("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
    }
    return "";
  }
  
  private void a(long paramLong, int paramInt, axap paramaxap, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1)
  {
    if (paramaxap.jdField_a_of_type_Boolean)
    {
      axct.a();
      Object localObject = axct.a;
      ((axcq)localObject).n += 1L;
      localObject = axct.a;
      ((axcq)localObject).r += 1L;
      localObject = new axcr();
      ((axcr)localObject).jdField_b_of_type_Int = 1;
      ((axcr)localObject).jdField_c_of_type_Int = 0;
      ((axcr)localObject).jdField_a_of_type_Int = paramInt;
      axct.a.a.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "dbMList receivedCompleted  called not success, so again task = " + paramaxap);
      }
      if ((!TextUtils.isEmpty(paramaxap.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramaxap.c))) {
        a(paramLong, paramaxap, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1);
      }
    }
  }
  
  private void a(long paramLong, int paramInt, String paramString, axap paramaxap, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2)
  {
    if (paramInt == 0)
    {
      a(paramLong, paramString, paramConcurrentHashMap1, paramConcurrentHashMap2);
      return;
    }
    a(paramLong, paramInt, paramaxap, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1);
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2)
  {
    axap localaxap = (axap)paramConcurrentHashMap2.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called  task = " + localaxap + ", resMList.size = " + paramConcurrentHashMap2.size() + ", errCode = " + paramInt);
    }
    if (localaxap != null) {
      a(paramLong, paramInt, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1, paramConcurrentHashMap2, localaxap);
    }
  }
  
  private void a(long paramLong, int paramInt, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2, axap paramaxap)
  {
    if (paramInt == 0)
    {
      b(paramLong, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1, paramConcurrentHashMap2, paramaxap);
      return;
    }
    b(paramLong, paramInt, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1, paramConcurrentHashMap2, paramaxap);
  }
  
  private void a(long paramLong, axap paramaxap, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1)
  {
    if ((paramaxap.jdField_a_of_type_Short > 3) && (this.jdField_d_of_type_Boolean))
    {
      b(paramLong, paramaxap, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1);
      return;
    }
    if (a())
    {
      axcw.b("recvFile panic error! dbMList receivedCompleted", new Object[0]);
      return;
    }
    paramaxap.jdField_a_of_type_Short = ((short)(paramaxap.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramaxap.c, paramaxap.jdField_b_of_type_JavaLangString, paramaxap.jdField_b_of_type_Boolean, paramaxap.jdField_b_of_type_Long, false);
  }
  
  private void a(long paramLong, String paramString)
  {
    if (a()) {
      axcw.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
    }
    do
    {
      return;
      paramString = (String)axcw.a(paramString).get("fid");
    } while (TextUtils.isEmpty(paramString));
    long l = Long.parseLong(paramString);
    axcw.b("http get reached! but can not understand this request! session is valid........", new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.refuseFileRequest(this.jdField_a_of_type_Long, paramLong, l, "404");
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, long paramLong2, ConcurrentHashMap<String, axao> paramConcurrentHashMap, String paramString2)
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
      if ((paramConcurrentHashMap.size() < awzs.jdField_b_of_type_Int) || (awzs.jdField_b_of_type_Int <= 0))
      {
        axcw.b("client cache is deal completedly! so get next session!", new Object[0]);
        j(3);
      }
    }
  }
  
  private void a(long paramLong1, String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong2, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, ConcurrentHashMap<String, axao> paramConcurrentHashMap1)
  {
    paramConcurrentHashMap.remove(Long.valueOf(paramLong1));
    if ((this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null) && (TextUtils.isEmpty(paramString2)))
    {
      if (a()) {
        axcw.b("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
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
      axcw.b("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null) {
      return;
    }
    long l = axcw.a();
    String str1 = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
    String str2 = "getmsg?fid=" + l + "&chatUin=" + paramString + "&chatType=" + axcw.b(paramInt);
    str1 = str1 + axcw.b(str2, this.jdField_a_of_type_JavaLangString);
    str2 = axcw.a(paramString, axcw.b(paramInt), null);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", url = " + str1 + ", path = " + str2);
    }
    axap localaxap = new axap();
    localaxap.jdField_a_of_type_Boolean = true;
    localaxap.jdField_a_of_type_Short = 0;
    localaxap.jdField_b_of_type_JavaLangString = str2;
    localaxap.c = str1;
    paramString = axcw.b(paramString, axcw.b(paramInt));
    ConcurrentHashMap localConcurrentHashMap = awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
    axct.a();
    Object localObject = axct.a;
    ((axcq)localObject).m += 1L;
    localObject = (axao)localConcurrentHashMap.get(paramString);
    if (localObject != null)
    {
      ((axao)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localaxap);
      localaxap.jdField_b_of_type_Long = ((axao)localObject).jdField_a_of_type_Long;
      localaxap.jdField_b_of_type_Boolean = axcw.a(((axao)localObject).jdField_a_of_type_Long);
      axcq localaxcq = axct.a;
      localaxcq.f += localaxap.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile , sessionInfo.dbMList = " + ((axao)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap + ". sessionInfo.hashcode = " + localObject.hashCode() + ", task.isSmallerFile = " + localaxap.jdField_b_of_type_Boolean);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + l + ", mClientCanRecvMList = " + localConcurrentHashMap + ", keyFromUin = " + paramString + ", task.isSmallerFile = " + localaxap.jdField_b_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, str1, str2, localaxap.jdField_b_of_type_Boolean, localaxap.jdField_b_of_type_Long, false);
    boolean bool = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Awzo != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      axcw.b("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((this.jdField_a_of_type_Awzo == null) || (this.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Awzo.c(true);
      return;
    }
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, axap> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
    }
    if (a()) {
      axcw.b("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
    }
    Object localObject;
    do
    {
      return;
      localObject = axct.a;
      ((axcq)localObject).jdField_d_of_type_Long += 1L;
      localObject = axct.a;
      ((axcq)localObject).g += 1L;
      paramString = axcw.a(paramString);
      long l = Long.parseLong((String)paramString.get("fid"));
      localObject = (String)paramString.get("filepath");
      axcw.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), localObject });
      paramString = (String)localObject;
      if (axcw.jdField_c_of_type_Boolean) {
        paramString = Uri.decode((String)localObject);
      }
      axcw.b("res url parse fid = %d,filepath = %s", new Object[] { Long.valueOf(l), paramString });
      localObject = new axcs();
      ((axcs)localObject).jdField_a_of_type_Boolean = false;
      ((axcs)localObject).jdField_a_of_type_Long = 0L;
      awzs.a().e.put(Long.valueOf(l), localObject);
      localObject = new axap();
      ((axap)localObject).jdField_a_of_type_Short = 0;
      ((axap)localObject).jdField_a_of_type_Boolean = true;
      ((axap)localObject).jdField_b_of_type_JavaLangString = axcw.a(paramString);
      ((axap)localObject).jdField_a_of_type_Long = paramLong;
      paramConcurrentHashMap.put(Long.valueOf(l), localObject);
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, ((axap)localObject).jdField_b_of_type_JavaLangString);
    } while (!QLog.isColorLevel());
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send res file, fileRes path = " + ((axap)localObject).jdField_b_of_type_JavaLangString + ", mFidMList.size = " + paramConcurrentHashMap.size());
  }
  
  private void a(long paramLong, String paramString, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2)
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
      paramConcurrentHashMap1 = new awzy();
      paramConcurrentHashMap1.jdField_a_of_type_Int = 1;
      paramConcurrentHashMap1.jdField_a_of_type_JavaLangString = paramString;
      awzs.a().b(paramConcurrentHashMap1);
    }
  }
  
  private void a(long paramLong1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, long paramLong2, String paramString)
  {
    axap localaxap = new axap();
    localaxap.jdField_a_of_type_Short = 0;
    localaxap.jdField_a_of_type_Boolean = false;
    localaxap.jdField_a_of_type_JavaLangString = paramString;
    localaxap.jdField_a_of_type_Long = paramLong1;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = " + paramLong2 + ", msg = " + paramString);
    }
    paramConcurrentHashMap.put(Long.valueOf(paramLong2), localaxap);
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, paramLong1, paramLong2, paramString);
  }
  
  private void a(long paramLong, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao arg4, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2, axap paramaxap)
  {
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.jdField_d_of_type_Boolean + ", isResRequestAllFinished" + ???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", resReq fileTask receivedCompleted retry over time task = " + paramaxap);
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if ((i == 0) && (j == 0) && (???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      ???.jdField_c_of_type_Boolean = true;
      a(???);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int + ", task = " + paramaxap);
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
          if (!((axao)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            break label324;
          }
          i += 1;
          break label324;
        }
        if (this.jdField_a_of_type_Awzo != null) {
          this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
        }
        if (i == awzs.jdField_b_of_type_Int) {
          return;
        }
      }
      if (!a(2))
      {
        axcw.b("this session res has received! over time  so get next session!", new Object[0]);
        j(3);
        return;
      }
    }
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, axap paramaxap)
  {
    if (paramaxap.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mfidMlist fileTask receivedCompleted  called not success, so again task = " + paramaxap);
      }
      if ((!TextUtils.isEmpty(paramaxap.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramaxap.c)))
      {
        if (paramaxap.jdField_a_of_type_Short <= 3) {
          break label109;
        }
        paramConcurrentHashMap.remove(Long.valueOf(paramLong));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + paramaxap);
      }
    }
    label109:
    do
    {
      return;
      if (a())
      {
        axcw.b("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
        return;
      }
      paramaxap.jdField_a_of_type_Short = ((short)(paramaxap.jdField_a_of_type_Short + 1));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramaxap.c, paramaxap.jdField_b_of_type_JavaLangString, paramaxap.jdField_b_of_type_Boolean, paramaxap.jdField_b_of_type_Long, true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist called not success, so again task = " + paramaxap);
      }
    } while (TextUtils.isEmpty(paramaxap.c));
    if (paramaxap.jdField_a_of_type_Short > 3)
    {
      paramConcurrentHashMap.remove(Long.valueOf(paramLong));
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist retry over time task = " + paramaxap);
      return;
    }
    if (a())
    {
      axcw.b("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    paramaxap.jdField_a_of_type_Short = ((short)(paramaxap.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramaxap.c);
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      axcw.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    a(paramLong, paramConcurrentHashMap, l, a(l, 1));
  }
  
  private void a(long paramLong, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, ConcurrentHashMap<String, axao> paramConcurrentHashMap1, Map<String, String> arg5)
  {
    if (???.size() >= 3)
    {
      if (a()) {
        axcw.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
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
    ??? = (axao)paramConcurrentHashMap1.get(axcw.b(str, i));
    if (??? != null)
    {
      ???.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Awzo == null) {}
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
        i = 0;
        if (paramConcurrentHashMap1.hasNext())
        {
          if (((axao)paramConcurrentHashMap1.next()).jdField_c_of_type_Boolean) {
            i += 1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report session completed! hasCompletedCount = " + i);
          }
          if (this.jdField_a_of_type_Awzo != null) {
            this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
          }
          if ((i != awzs.jdField_b_of_type_Int) || (QLog.isColorLevel())) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report session transport completed! fid = " + l + ", msg = []");
          }
          a(paramLong, paramConcurrentHashMap, l, a(l, 3));
          return;
        }
      }
    }
  }
  
  private void a(axao paramaxao)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      i(258);
      return;
    }
    a(this.jdField_a_of_type_Long, false, paramaxao.jdField_a_of_type_JavaLangString, paramaxao.jdField_a_of_type_Int);
  }
  
  private void a(ConcurrentHashMap<String, axao> paramConcurrentHashMap, JSONArray paramJSONArray)
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
        localObject = new axao();
        ((axao)localObject).jdField_b_of_type_Boolean = false;
        ((axao)localObject).jdField_a_of_type_JavaLangString = str;
        ((axao)localObject).jdField_a_of_type_Long = l;
        ((axao)localObject).jdField_a_of_type_Int = axcw.c(j);
        paramConcurrentHashMap.put(axcw.b(((axao)localObject).jdField_a_of_type_JavaLangString, j), localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + str + ", uintype = " + ((axao)localObject).jdField_a_of_type_Int + "：mClientCanRecvMList.size = " + paramConcurrentHashMap.size());
        }
      }
      i += 1;
    }
    a(4);
  }
  
  private void a(ConcurrentHashMap<String, axao> paramConcurrentHashMap, JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    awzs.jdField_b_of_type_Int = paramJSONObject.optInt("listCount");
    axct.a();
    axct.a.jdField_b_of_type_Long = awzs.jdField_b_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, 会话总个数：MsgBackupManager.sessionCount = " + awzs.jdField_b_of_type_Int);
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
        localObject = new axao();
        ((axao)localObject).jdField_b_of_type_Boolean = false;
        ((axao)localObject).jdField_a_of_type_JavaLangString = paramJSONObject;
        ((axao)localObject).jdField_a_of_type_Int = axcw.c(j);
        ((axao)localObject).jdField_a_of_type_Long = l;
        String str = axcw.b(((axao)localObject).jdField_a_of_type_JavaLangString, j);
        if (paramConcurrentHashMap.get(str) == null) {
          paramConcurrentHashMap.put(str, localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  会话 uin =" + paramJSONObject + ", uintype = " + ((axao)localObject).jdField_a_of_type_Int + "：mClientCanRecvMList= " + paramConcurrentHashMap);
        }
      }
      i += 1;
    }
    a(4);
  }
  
  private boolean a(long paramLong, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (!awzs.jdField_f_of_type_Boolean)
    {
      long l = Long.parseLong((String)paramMap.get("fid"));
      paramMap = new axap();
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
  
  private boolean a(ConcurrentHashMap<String, axao> paramConcurrentHashMap, boolean paramBoolean)
  {
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    int i = 0;
    axao localaxao;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localaxao = (axao)localIterator.next();
        if (!localaxao.jdField_b_of_type_Boolean) {
          if (localaxao.jdField_a_of_type_Long <= 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, curDealUin is not null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + localaxao.jdField_a_of_type_JavaLangString + ", uintype = " + localaxao.jdField_a_of_type_Int + ", dbsize = " + localaxao.jdField_a_of_type_Long);
            }
            localaxao.jdField_c_of_type_Boolean = true;
            localaxao.jdField_b_of_type_Boolean = true;
            a(localaxao);
            if (this.jdField_a_of_type_Awzo == null) {
              continue;
            }
            i = a(paramConcurrentHashMap);
            if (this.jdField_a_of_type_Awzo != null) {
              this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
            }
            if (i == awzs.jdField_b_of_type_Int) {
              axcw.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((!paramBoolean) && (i != awzs.jdField_b_of_type_Int))
      {
        j(5);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step2 , , hasFinishedC = " + i);
        }
      }
      return paramBoolean;
      break;
      i = a(paramConcurrentHashMap);
      if (this.jdField_a_of_type_Awzo != null) {
        this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
      }
      if (i == awzs.jdField_b_of_type_Int)
      {
        axcw.b("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
      }
      else
      {
        localaxao.jdField_b_of_type_Boolean = true;
        awzs.jdField_d_of_type_JavaLangString = localaxao.jdField_a_of_type_JavaLangString;
        awzs.jdField_c_of_type_Int = localaxao.jdField_a_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, current uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int + ", dbsize = " + localaxao.jdField_a_of_type_Long);
        }
        a(this.jdField_a_of_type_Long, localaxao.jdField_a_of_type_JavaLangString, localaxao.jdField_a_of_type_Int, false);
        paramBoolean = true;
      }
    }
  }
  
  private void b(long paramLong, int paramInt, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2, axap paramaxap)
  {
    Object localObject;
    if (paramaxap.jdField_a_of_type_Boolean)
    {
      axct.a();
      localObject = axct.a;
      ((axcq)localObject).h += 1L;
      localObject = axct.a;
      ((axcq)localObject).r += 1L;
      localObject = new axcr();
      if (!awzs.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.contains(Long.valueOf(paramLong))) {
        break label218;
      }
      axcq localaxcq = axct.a;
      localaxcq.k += 1L;
      awzs.a().jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(Long.valueOf(paramLong));
    }
    label218:
    for (((axcr)localObject).jdField_c_of_type_Int = 2;; ((axcr)localObject).jdField_c_of_type_Int = 1)
    {
      ((axcr)localObject).jdField_b_of_type_Int = 2;
      ((axcr)localObject).jdField_a_of_type_Int = paramInt;
      axct.a.a.add(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "resReq fileTask receivedCompleted  called not success, so again task = " + paramaxap);
      }
      if ((!TextUtils.isEmpty(paramaxap.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramaxap.c)))
      {
        if ((paramaxap.jdField_a_of_type_Short <= 3) || (!this.jdField_d_of_type_Boolean)) {
          break;
        }
        a(paramLong, paramConcurrentHashMap, paramaxao, paramConcurrentHashMap1, paramConcurrentHashMap2, paramaxap);
      }
      return;
    }
    if (a())
    {
      axcw.b("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
      return;
    }
    paramaxap.jdField_a_of_type_Short = ((short)(paramaxap.jdField_a_of_type_Short + 1));
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, paramaxap.c, paramaxap.jdField_b_of_type_JavaLangString, paramaxap.jdField_b_of_type_Boolean, paramaxap.jdField_b_of_type_Long, true);
  }
  
  private void b(long paramLong, axap arg3, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao paramaxao, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1)
  {
    awzs.jdField_a_of_type_Int += 1;
    axcw.b("MsgBackup_MsgBackupTransportProcessor", "MsgBackup_Manager skipSessionCount = %d", new Object[] { Integer.valueOf(awzs.jdField_a_of_type_Int) });
    paramConcurrentHashMap1.remove(Long.valueOf(paramLong));
    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "isTcpDetected = " + this.jdField_d_of_type_Boolean + ", 此会话db一直失败，扔掉，通知对端dbMList receivedCompleted retry over time task = " + ???);
    paramaxao.jdField_c_of_type_Boolean = true;
    a(paramaxao);
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
          if (!((axao)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            break label246;
          }
          i += 1;
          break label246;
        }
        if (this.jdField_a_of_type_Awzo != null) {
          this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
        }
        if (i == awzs.jdField_b_of_type_Int) {
          return;
        }
      }
      if (!a(2))
      {
        axcw.b("this session db has received error! so get next session!", new Object[0]);
        j(3);
        return;
      }
    }
  }
  
  private void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (axcw.jdField_b_of_type_Boolean) {}
    for (paramString1 = axcw.a(paramString2, this.jdField_a_of_type_JavaLangString);; paramString1 = paramString2)
    {
      axct.a();
      paramString2 = awzs.a().g;
      ConcurrentHashMap localConcurrentHashMap = awzs.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, MsgBackupManager.curDealType = " + awzs.jdField_d_of_type_JavaLangString + ", MsgBackupManager.curDealType = " + awzs.jdField_c_of_type_Int);
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
    if (axcw.jdField_b_of_type_Boolean) {
      paramString1 = axcw.b(paramString1, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ConcurrentHashMap localConcurrentHashMap2 = awzs.a().g;
      axap localaxap = (axap)localConcurrentHashMap2.get(Long.valueOf(paramLong1));
      ConcurrentHashMap localConcurrentHashMap1 = awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted called! mfidMlist.size = " + localConcurrentHashMap2.size() + ", mClientCanRecvMList.size = " + localConcurrentHashMap1.size() + ", path = " + paramString2 + ",url = " + paramString1 + ", fid = " + paramLong1 + ",errorCode = " + paramInt1 + ", task = " + localaxap + "，mFidMList " + localConcurrentHashMap2.toString() + ", MsgBackupManager.sessionCount = " + awzs.jdField_b_of_type_Int);
      }
      if (localaxap != null) {
        if (paramInt1 == 0) {
          a(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramLong2, localConcurrentHashMap2, localConcurrentHashMap1);
        }
      }
      do
      {
        return;
        a(paramLong1, localConcurrentHashMap2, localaxap);
        return;
        paramArrayOfByte = axcw.b(awzs.jdField_d_of_type_JavaLangString, axcw.b(awzs.jdField_c_of_type_Int));
        paramString1 = (axao)localConcurrentHashMap1.get(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted key = " + paramArrayOfByte + ", mClientCanRecvMList = " + localConcurrentHashMap1 + ", sessionInfo = " + paramString1 + ", errCode = " + paramInt1);
        }
      } while (paramString1 == null);
      paramArrayOfByte = paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
      localConcurrentHashMap2 = paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      localaxap = (axap)paramArrayOfByte.get(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  dbMList task = " + localaxap + ", dbMList = " + paramArrayOfByte.toString() + ". sessionInfo.hashcode = " + paramString1.hashCode());
      }
      if (localaxap != null)
      {
        a(paramLong1, paramInt1, paramString2, localaxap, localConcurrentHashMap1, paramString1, paramArrayOfByte, localConcurrentHashMap2);
        return;
      }
      a(paramLong1, paramInt1, localConcurrentHashMap1, paramString1, paramArrayOfByte, localConcurrentHashMap2);
      return;
    }
  }
  
  private void b(long paramLong, String paramString, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, ConcurrentHashMap<String, axao> paramConcurrentHashMap1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
    }
    if (a())
    {
      axcw.b("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Awzo != null) {}
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      axcw.b("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((this.jdField_a_of_type_Awzo != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Awzo.c(true);
      }
      localObject1 = axcw.a(paramString);
      l = Long.parseLong((String)((Map)localObject1).get("fid"));
      if (awzs.jdField_f_of_type_Boolean) {
        break;
      }
      paramString = new axap();
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
    paramString = new axcs();
    paramString.jdField_a_of_type_Boolean = false;
    paramString.jdField_a_of_type_Long = 0L;
    awzs.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), paramString);
    paramString = (String)((Map)localObject1).get("chatUin");
    int j = Integer.parseInt((String)((Map)localObject1).get("chatType"));
    Object localObject1 = axcw.a(paramString, j, null);
    ??? = new axap();
    ((axap)???).jdField_a_of_type_Short = 0;
    ((axap)???).jdField_a_of_type_Boolean = true;
    ((axap)???).jdField_a_of_type_Long = paramLong;
    ((axap)???).jdField_b_of_type_JavaLangString = ((String)localObject1);
    paramConcurrentHashMap.put(Long.valueOf(l), ???);
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        paramConcurrentHashMap1 = paramConcurrentHashMap1.values().iterator();
        if (paramConcurrentHashMap1.hasNext())
        {
          if (((axao)paramConcurrentHashMap1.next()).jdField_c_of_type_Boolean) {
            i += 1;
          }
        }
        else
        {
          if (this.jdField_a_of_type_Awzo != null) {
            this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
          }
          this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, paramLong, l, (String)localObject1);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send db uin = " + paramString + ", uinType = " + axcw.c(j) + ", dbpath = " + (String)localObject1 + ", fid = " + l + ", mFidMList.size = " + paramConcurrentHashMap.size());
          return;
        }
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<String, axao> paramConcurrentHashMap, axao arg4, ConcurrentHashMap<Long, axap> paramConcurrentHashMap1, ConcurrentHashMap<Long, axap> paramConcurrentHashMap2, axap paramaxap)
  {
    paramConcurrentHashMap2.remove(Long.valueOf(paramLong));
    int i = paramConcurrentHashMap2.size();
    int j = paramConcurrentHashMap1.size();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called success, isResRequestAllFinished " + ???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + ", task = " + paramaxap + ", resMList.size = " + i);
    }
    if ((i == 0) && (j == 0) && (???.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()))
    {
      ???.jdField_c_of_type_Boolean = true;
      a(???);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int + ", task = " + paramaxap);
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
          if (!((axao)paramConcurrentHashMap.next()).jdField_c_of_type_Boolean) {
            break label328;
          }
          i += 1;
          break label328;
        }
        if (this.jdField_a_of_type_Awzo != null) {
          this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
        }
        if (i == awzs.jdField_b_of_type_Int) {
          return;
        }
      }
      if (!a(2))
      {
        axcw.b("this session res has received! so get next session!", new Object[0]);
        j(3);
        return;
      }
    }
  }
  
  private void b(long paramLong, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      axcw.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
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
      localJSONObject.put("sig", awzh.a().a());
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
  
  private void c(long paramLong, String paramString, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, ConcurrentHashMap<String, axao> paramConcurrentHashMap1)
  {
    if (a()) {
      axcw.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + paramString);
      }
      paramString = axcw.a(paramString);
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
  
  private void c(long paramLong, ConcurrentHashMap<Long, axap> paramConcurrentHashMap, Map<String, String> paramMap)
  {
    if (a())
    {
      axcw.b("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
      return;
    }
    long l = Long.parseLong((String)paramMap.get("fid"));
    if ((!TextUtils.isEmpty((String)paramMap.get("exit"))) && (this.jdField_a_of_type_Awzo != null)) {
      this.jdField_a_of_type_Awzo.b(true);
    }
    paramMap = new axap();
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
          if ((TextUtils.equals(paramString, awzh.a().a())) && (this.jdField_a_of_type_Awzo != null)) {
            this.jdField_a_of_type_Awzo.b(true);
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
    axcl.a().a();
  }
  
  private void f(String arg1)
  {
    int j = 0;
    Object localObject1;
    int i;
    try
    {
      localObject1 = awzs.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
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
      localObject3 = axcw.b(str, k);
      axao localaxao = (axao)((ConcurrentHashMap)localObject1).get(localObject3);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! keyFromUin = " + (String)localObject3 + ", mMList = " + localObject1);
      }
      if (localaxao != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "udp 通知 此会话接受完成 chatUin = " + str + ", uinType = " + axcw.c(k));
        }
        localaxao.jdField_c_of_type_Boolean = true;
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
          if (((axao)((Iterator)localObject1).next()).jdField_c_of_type_Boolean)
          {
            i += 1;
            break label352;
          }
        }
        else
        {
          if (this.jdField_a_of_type_Awzo == null) {
            break label257;
          }
          this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
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
        ConcurrentHashMap localConcurrentHashMap = awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
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
              awzs.jdField_b_of_type_Int = ((JSONObject)localObject).optInt("listCount");
              axct.a();
              axct.a.jdField_b_of_type_Long = awzs.jdField_b_of_type_Int;
            }
            if ("chat_ready".equals(str))
            {
              str = ((JSONObject)localObject).optString("chatUin");
              int j = ((JSONObject)localObject).optInt("chatType");
              long l = ((JSONObject)localObject).optLong("dbSize");
              localObject = new axao();
              ((axao)localObject).jdField_c_of_type_Boolean = false;
              ((axao)localObject).jdField_b_of_type_Boolean = false;
              ((axao)localObject).jdField_a_of_type_JavaLangString = str;
              ((axao)localObject).jdField_a_of_type_Int = axcw.c(j);
              ((axao)localObject).jdField_a_of_type_Long = l;
              str = axcw.b(((axao)localObject).jdField_a_of_type_JavaLangString, j);
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
        localObject1 = awzs.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject3 = new axap();
        ((axap)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
        ((axap)localObject3).jdField_a_of_type_Int = paramInt;
        ((axap)localObject3).jdField_a_of_type_Short = 0;
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
        if (!awzs.jdField_f_of_type_Boolean)
        {
          ??? = ((JSONArray)localObject1).toString();
          localObject1 = awzs.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localObject3 = new axap();
          ((axap)localObject3).jdField_a_of_type_JavaLangString = ((String)???);
          ((axap)localObject3).jdField_a_of_type_Int = paramInt;
          ((axap)localObject3).jdField_a_of_type_Short = 0;
          ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramLong), localObject3);
          localObject1 = ???;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "MsgBackupManager.sUIReady = " + awzs.jdField_f_of_type_Boolean + ", getSessionJson is called! cookie = " + paramLong + ", msg = " + (String)???);
          return ???;
        }
        ??? = awzs.a().jdField_a_of_type_JavaUtilHashSet;
        localObject3 = awzs.a().jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
        i = awzs.jdField_b_of_type_Int;
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
              localObject4 = (axao)((Iterator)localObject3).next();
              i = j;
              if (((axao)localObject4).jdField_c_of_type_Boolean) {
                i = j + 1;
              }
              j = i;
              if (!((axao)localObject4).jdField_a_of_type_Boolean)
              {
                localObject5 = ((axao)localObject4).jdField_a_of_type_JavaLangString;
                j = ((axao)localObject4).jdField_a_of_type_Int;
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("cmd", "chat_ready");
                localJSONObject.put("chatUin", localObject5);
                localJSONObject.put("chatType", axcw.b(j));
                localJSONObject.put("dbSize", ((axao)localObject4).jdField_a_of_type_Long);
                localJSONException.put(localJSONObject);
                ((axao)localObject4).jdField_a_of_type_Boolean = true;
                j = i;
              }
            }
          }
          if (this.jdField_a_of_type_Awzo != null) {
            this.jdField_a_of_type_Awzo.a(j, awzs.jdField_b_of_type_Int);
          }
        }
      }
      else if (paramInt == 258)
      {
        ??? = awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (axao)((Iterator)???).next();
          if ((!((axao)localObject3).jdField_d_of_type_Boolean) && (((axao)localObject3).jdField_c_of_type_Boolean))
          {
            localObject4 = ((axao)localObject3).jdField_a_of_type_JavaLangString;
            i = ((axao)localObject3).jdField_a_of_type_Int;
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("cmd", "chat_transfer_complete");
            ((JSONObject)localObject5).put("chatUin", localObject4);
            ((JSONObject)localObject5).put("chatType", axcw.b(i));
            str.put(localObject5);
            ((axao)localObject3).jdField_d_of_type_Boolean = true;
          }
        }
      }
      else if (paramInt == 259)
      {
        ??? = new JSONObject();
        ((JSONObject)???).put("cmd", "exit");
        ((JSONObject)???).put("sig", awzh.a().a());
        str.put(???);
      }
    }
    return str;
  }
  
  public String a(String paramString)
  {
    return axcw.a(paramString, this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue(), this.jdField_a_of_type_JavaLangString);
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
    axcv.a(paramLong1, paramLong2);
    if (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong3;
        if (this.jdField_a_of_type_Awzo != null)
        {
          this.jdField_a_of_type_Awzo.a(1000L * paramLong3 / paramLong2);
          axcv.b(paramLong1, paramLong3 * 1000L / paramLong2);
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
    axcw.b("MsgBackup_MsgBackupTransportProcessor", "onRecvComplete from jni fid = %d,url = %s,errcode = %d,path = %s ", new Object[] { Long.valueOf(paramLong1), paramString1, Integer.valueOf(paramInt1), paramString2 });
    axcv.a(paramLong1);
    b(paramLong1, paramString1, paramInt1, paramString2, paramArrayOfByte, paramInt2, paramInt3, paramLong2);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, long paramLong4, int paramInt2, int paramInt3, long paramLong5)
  {
    axcv.a(paramLong1, paramLong3);
    axct.a();
    if (awzs.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = (axcs)awzs.a().e.get(Long.valueOf(paramLong1));
      if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
      {
        paramString.jdField_a_of_type_Boolean = true;
        paramString.jdField_a_of_type_Long = paramLong3;
        paramString = axct.a;
        paramString.e += paramLong3;
      }
    }
    while (this.jdField_b_of_type_Long > 0L)
    {
      paramLong2 = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
      if (paramLong2 > 1500L)
      {
        paramLong3 = this.jdField_c_of_type_Long + paramLong4;
        if (this.jdField_a_of_type_Awzo != null)
        {
          this.jdField_a_of_type_Awzo.a(1000L * paramLong3 / paramLong2);
          axcv.b(paramLong1, paramLong3 * 1000L / paramLong2);
        }
        this.jdField_c_of_type_Long = 0L;
        this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
        return;
        if (awzs.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
        {
          paramString = (axcs)awzs.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1));
          if ((paramString != null) && (!paramString.jdField_a_of_type_Boolean))
          {
            paramString.jdField_a_of_type_Boolean = true;
            paramString.jdField_a_of_type_Long = paramLong3;
            paramString = axct.a;
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
    axcv.a(paramLong1);
    axct.a();
    Object localObject;
    label184:
    axap localaxap;
    if (awzs.a().e.containsKey(Long.valueOf(paramLong1)))
    {
      localObject = (axcs)awzs.a().e.get(Long.valueOf(paramLong1));
      if (localObject != null)
      {
        boolean bool = axcw.a(((axcs)localObject).jdField_a_of_type_Long);
        if (bool)
        {
          localObject = axct.a;
          ((axcq)localObject).j += 1L;
        }
        if (!paramBoolean)
        {
          localObject = axct.a;
          ((axcq)localObject).r += 1L;
          localObject = new axcr();
          ((axcr)localObject).jdField_b_of_type_Int = 2;
          if (!bool) {
            break label273;
          }
          paramInt2 = 2;
          ((axcr)localObject).jdField_c_of_type_Int = paramInt2;
          ((axcr)localObject).jdField_a_of_type_Int = paramInt1;
          axct.a.a.add(localObject);
          if (bool)
          {
            localObject = axct.a;
            ((axcq)localObject).k += 1L;
          }
        }
      }
      awzs.a().e.remove(Long.valueOf(paramLong1));
      localObject = awzs.a().g;
      localaxap = (axap)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localaxap == null) {
        break label724;
      }
      if (!paramBoolean) {
        break label426;
      }
      ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  task = " + localaxap + ", mFidMList.size = " + ((ConcurrentHashMap)localObject).size());
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
          if (!awzs.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1))) {
            break label184;
          }
          if ((axcs)awzs.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong1)) != null)
          {
            localObject = axct.a;
            ((axcq)localObject).m += 1L;
            if (!paramBoolean)
            {
              localObject = axct.a;
              ((axcq)localObject).n += 1L;
              localObject = axct.a;
              ((axcq)localObject).r += 1L;
              localObject = new axcr();
              ((axcr)localObject).jdField_b_of_type_Int = 1;
              ((axcr)localObject).jdField_c_of_type_Int = 0;
              ((axcr)localObject).jdField_a_of_type_Int = paramInt1;
              axct.a.a.add(localObject);
            }
          }
          awzs.a().jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong1));
          break label184;
          if (!localaxap.jdField_a_of_type_Boolean) {
            break label579;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "fileTask onSendComplete  called not success, so again  task = " + localaxap);
          }
        } while (TextUtils.isEmpty(localaxap.jdField_b_of_type_JavaLangString));
        if (localaxap.jdField_a_of_type_Short > 3)
        {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete fileTask  retry over time task = " + localaxap);
          ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
          return;
        }
        if (a())
        {
          axcw.b("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
          return;
        }
        localaxap.jdField_a_of_type_Short = ((short)(localaxap.jdField_a_of_type_Short + 1));
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, localaxap.jdField_a_of_type_Long, paramLong1, localaxap.jdField_b_of_type_JavaLangString);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called not success, so again task = " + localaxap);
        }
      } while (TextUtils.isEmpty(localaxap.jdField_a_of_type_JavaLangString));
      if (localaxap.jdField_a_of_type_Short > 3)
      {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete retry over time task = " + localaxap);
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        return;
      }
      if (a())
      {
        axcw.b("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      localaxap.jdField_a_of_type_Short = ((short)(localaxap.jdField_a_of_type_Short + 1));
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.b(this.jdField_a_of_type_Long, localaxap.jdField_a_of_type_Long, paramLong1, localaxap.jdField_a_of_type_JavaLangString);
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
        axcw.b("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      long l = axcw.a();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = "postinfo?fid=" + l + "&chatUin=" + paramString + "&chatType=" + axcw.b(paramInt);
        axcw.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
        paramString = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + axcw.b(paramString, this.jdField_a_of_type_JavaLangString);
      }
      while ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy != null))
      {
        axap localaxap = new axap();
        localaxap.jdField_a_of_type_Short = 0;
        localaxap.jdField_a_of_type_Boolean = false;
        localaxap.c = paramString;
        awzs.a().g.put(Long.valueOf(l), localaxap);
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer fid = " + l + ", url = " + paramString);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(paramLong, l, paramString);
        return;
        if (paramBoolean)
        {
          paramString = "postinfo?fid=" + l + "&ip=" + this.jdField_a_of_type_ArrayOfJavaLangString[0] + "&tcpport=" + this.jdField_b_of_type_JavaLangInteger + "&udpport=" + this.jdField_a_of_type_JavaLangInteger;
          axcw.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + axcw.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
        else
        {
          paramString = "postinfo?fid=" + l;
          axcw.b("MsgBackup_MsgBackupTransportProcessor", paramString, new Object[0]);
          paramString = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + axcw.b(paramString, this.jdField_a_of_type_JavaLangString);
        }
      }
    }
    axcw.b("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
  }
  
  public void a(awzo paramawzo)
  {
    this.jdField_a_of_type_Awzo = paramawzo;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      awzs.a().a();
      axcw.a();
      if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
      }
      awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      e(1);
      awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
    awzs.a().a();
    axcw.a();
    awzs.a().a().a(paramInt);
    awzs.a().a().a(paramString2);
    awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
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
      axcw.b("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
    }
    do
    {
      return;
      axct.a();
      localObject = axct.a;
      ((axcq)localObject).g += 1L;
      localObject = awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
      if ((paramString1 != null) || (paramString2 != null)) {
        break;
      }
      axcw.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { awzs.jdField_d_of_type_JavaLangString, Integer.valueOf(awzs.jdField_c_of_type_Int) });
      paramString1 = (axao)((ConcurrentHashMap)localObject).get(axcw.b(awzs.jdField_d_of_type_JavaLangString, axcw.b(awzs.jdField_c_of_type_Int)));
    } while (paramString1 == null);
    axcw.b("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", new Object[] { Integer.valueOf(paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size()), Integer.valueOf(paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size()) });
    if ((paramString1.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) && (paramString1.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0)) {
      a(6);
    }
    paramString1.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    return;
    new File(paramString2).getParentFile().mkdirs();
    long l = axcw.a();
    paramString1 = axcw.b(String.format("getres?fid=%d&filepath=%s", new Object[] { Long.valueOf(l), paramString1 }), this.jdField_a_of_type_JavaLangString);
    paramString1 = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue()) + paramString1;
    axap localaxap = new axap();
    localaxap.jdField_a_of_type_Short = 0;
    localaxap.jdField_a_of_type_Boolean = true;
    localaxap.jdField_b_of_type_JavaLangString = paramString2;
    localaxap.c = paramString1;
    localaxap.jdField_b_of_type_Boolean = axcw.a(paramLong);
    localaxap.jdField_b_of_type_Long = paramLong;
    axcq localaxcq = axct.a;
    localaxcq.e += paramLong;
    Object localObject = (axao)((ConcurrentHashMap)localObject).get(axcw.b(awzs.jdField_d_of_type_JavaLangString, axcw.b(awzs.jdField_c_of_type_Int)));
    if (localObject != null) {
      ((axao)localObject).jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(l), localaxap);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, paramString1, paramString2, localaxap.jdField_b_of_type_Boolean, localaxap.jdField_b_of_type_Long, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    awzs.a().a();
    axcw.a();
    if (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupNotifier = new MsgBackupNotifier();
    }
    e(1);
    ThreadManager.getSubThreadHandler().post(new MsgBackupTransportProcessor.2(this, paramString, paramBoolean));
  }
  
  protected void a(ConcurrentHashMap<String, axao> paramConcurrentHashMap)
  {
    if (!TextUtils.isEmpty(awzs.jdField_d_of_type_JavaLangString))
    {
      axao localaxao = (axao)paramConcurrentHashMap.get(axcw.b(awzs.jdField_d_of_type_JavaLangString, axcw.b(awzs.jdField_c_of_type_Int)));
      if (localaxao != null)
      {
        localaxao.jdField_c_of_type_Boolean = true;
        axcw.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", new Object[] { awzs.jdField_d_of_type_JavaLangString, Integer.valueOf(awzs.jdField_c_of_type_Int) });
        a(localaxao);
        if (this.jdField_a_of_type_Awzo != null)
        {
          int i = a(paramConcurrentHashMap);
          if (this.jdField_a_of_type_Awzo != null) {
            this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
          }
          if ((i != awzs.jdField_b_of_type_Int) || (this.jdField_a_of_type_Awzo == null)) {}
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    axct.a();
    axct.a.jdField_b_of_type_Boolean = this.jdField_c_of_type_Boolean;
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject;
    axap localaxap;
    if (2 == this.jdField_a_of_type_Int)
    {
      localObject = awzs.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
      localaxap = (axap)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
      if (localaxap != null)
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
              if (localaxap.jdField_a_of_type_Short > 3)
              {
                ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localaxap);
                return;
              }
              localaxap.jdField_a_of_type_Short = ((short)(localaxap.jdField_a_of_type_Short + 1));
              localObject = localaxap.jdField_a_of_type_JavaLangString;
              i = localaxap.jdField_a_of_type_Int;
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: " + localaxap);
              }
            } while (TextUtils.isEmpty((CharSequence)localObject));
            this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, i, (String)localObject, paramLong1);
            return;
          } while (1 != this.jdField_a_of_type_Int);
          localObject = awzs.a().jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap;
          localaxap = (axap)((ConcurrentHashMap)localObject).get(Long.valueOf(paramLong1));
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + paramBoolean + ", cookie = " + paramLong1 + ", role = MBRROLE_CLIENT");
          }
        } while (localaxap == null);
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
      if (localaxap.jdField_a_of_type_Short > 3)
      {
        ((ConcurrentHashMap)localObject).remove(Long.valueOf(paramLong1));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + localaxap);
        return;
      }
      localObject = localaxap.jdField_a_of_type_JavaLangString;
      i = localaxap.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage  role = MBRROLE_CLIENT: " + localaxap);
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
          axcw.b("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
          return bool2;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, from = " + paramInt);
        }
        ConcurrentHashMap localConcurrentHashMap1 = awzs.a().jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
        if ((paramInt == 1) || (paramInt == 6)) {
          a(localConcurrentHashMap1);
        }
        boolean bool1;
        if (!TextUtils.isEmpty(awzs.jdField_d_of_type_JavaLangString))
        {
          bool1 = a(localConcurrentHashMap1);
          if ((localConcurrentHashMap1.size() == 0) || (TextUtils.isEmpty(awzs.jdField_d_of_type_JavaLangString)))
          {
            j(5);
            if (QLog.isColorLevel()) {
              QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step1");
            }
          }
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with from = " + paramInt + ", ret = " + bool1 + ", sessionCount = " + awzs.jdField_b_of_type_Int);
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
  
  protected boolean a(ConcurrentHashMap<String, axao> paramConcurrentHashMap)
  {
    axao localaxao = (axao)paramConcurrentHashMap.get(axcw.b(awzs.jdField_d_of_type_JavaLangString, axcw.b(awzs.jdField_c_of_type_Int)));
    if (localaxao != null)
    {
      if (localaxao.jdField_c_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int);
        }
        return a(paramConcurrentHashMap, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "current session not completed! requestNextSessionDb !, current uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int);
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
    if (this.jdField_a_of_type_Awzo != null) {
      this.jdField_a_of_type_Awzo.b(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  protected boolean b(ConcurrentHashMap<String, axao> paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, last uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int);
    }
    Iterator localIterator = paramConcurrentHashMap.values().iterator();
    axao localaxao;
    while (localIterator.hasNext())
    {
      localaxao = (axao)localIterator.next();
      if (!localaxao.jdField_b_of_type_Boolean)
      {
        if (localaxao.jdField_a_of_type_Long > 0L) {
          break label266;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !,  curDealUin  null! dbsize 等于 0 ！客户端不会去请求了，只是通知server端，该会话已经接受完成了！uin = " + localaxao.jdField_a_of_type_JavaLangString + ", uintype = " + localaxao.jdField_a_of_type_Int + ", dbSize = " + localaxao.jdField_a_of_type_Long);
        }
        localaxao.jdField_c_of_type_Boolean = true;
        localaxao.jdField_b_of_type_Boolean = true;
        a(localaxao);
        if (this.jdField_a_of_type_Awzo != null)
        {
          i = a(paramConcurrentHashMap);
          if ((this.jdField_a_of_type_Awzo != null) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Boolean = true;
            this.jdField_a_of_type_Awzo.c(true);
          }
          if (this.jdField_a_of_type_Awzo != null) {
            this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
          }
          if ((i == awzs.jdField_b_of_type_Int) && (this.jdField_a_of_type_Awzo != null)) {
            axcw.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
          }
        }
      }
    }
    return false;
    label266:
    localaxao.jdField_b_of_type_Boolean = true;
    awzs.jdField_d_of_type_JavaLangString = localaxao.jdField_a_of_type_JavaLangString;
    awzs.jdField_c_of_type_Int = localaxao.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, uin = " + awzs.jdField_d_of_type_JavaLangString + ", uintype = " + awzs.jdField_c_of_type_Int + ", dbsize = " + localaxao.jdField_a_of_type_Long);
    }
    int i = a(paramConcurrentHashMap);
    if ((this.jdField_a_of_type_Awzo != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Awzo.c(true);
    }
    if (this.jdField_a_of_type_Awzo != null) {
      this.jdField_a_of_type_Awzo.a(i, awzs.jdField_b_of_type_Int);
    }
    if (i == awzs.jdField_b_of_type_Int)
    {
      axcw.b("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
      return false;
    }
    a(this.jdField_a_of_type_Long, localaxao.jdField_a_of_type_JavaLangString, localaxao.jdField_a_of_type_Int, false);
    return true;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_JavaLangInteger.intValue();
  }
  
  public void c()
  {
    int i = awzh.a().a();
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
        axcw.b("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp, isTcpDetected = " + this.jdField_d_of_type_Boolean);
      }
      l = axcw.a();
      str = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
      localObject = "postinfo?fid=" + l + "&exit=1";
      axcw.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = axcw.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new axap();
    ((axap)localObject).jdField_a_of_type_Short = 0;
    ((axap)localObject).jdField_a_of_type_Boolean = false;
    ((axap)localObject).c = str;
    awzs.a().g.put(Long.valueOf(l), localObject);
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
      localJSONObject.put("sig", awzh.a().a());
      ((JSONArray)localObject).put(localJSONObject);
      awzj.a().a(((JSONArray)localObject).toString());
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
      awzs.a().b();
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
        axcv.a("cost_connect_total", null);
      }
      axct.a();
      axct.a.jdField_d_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Awzo != null) {
        this.jdField_a_of_type_Awzo.a(this.jdField_d_of_type_Boolean);
      }
      if ((this.jdField_d_of_type_Boolean) && (this.e))
      {
        this.e = false;
        axcw.b("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
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
        l = axcw.a();
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
        axcw.b("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
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
      l = axcw.a();
      str = axcw.a(this.jdField_b_of_type_ArrayOfJavaLangString[0], this.jdField_d_of_type_JavaLangInteger.intValue());
      localObject = "postinfo?fid=" + l;
      axcw.b("MsgBackup_MsgBackupTransportProcessor", (String)localObject, new Object[0]);
      localObject = axcw.b((String)localObject, this.jdField_a_of_type_JavaLangString);
      str = str + (String)localObject;
    } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy == null));
    Object localObject = new axap();
    ((axap)localObject).jdField_a_of_type_Boolean = false;
    ((axap)localObject).jdField_a_of_type_Short = 0;
    ((axap)localObject).c = str;
    awzs.a().g.put(Long.valueOf(l), localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList fid = " + l + ", url = " + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsgbackupTransportMsgBackupJniProxy.a(this.jdField_a_of_type_Long, l, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axcm
 * JD-Core Version:    0.7.0.1
 */