import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.transfile.dns.InnerDns.4;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Layxf;>;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.mobileqq.configpush.DomainIp.NameRspBody;
import tencent.im.mobileqq.configpush.DomainIp.ServerList;
import tencent.im.mobileqq.configpush.DomainIp.SubCmd_name_Rsp;
import tencent.im.mobileqq.configpush.DomainIp.iplistInfo;

public class ayxg
  extends QIPCModule
{
  public static volatile ayxg a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ayxj(this);
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, HashMap<String, ayxf>> jdField_a_of_type_JavaUtilHashMap;
  private Random jdField_a_of_type_JavaUtilRandom = new Random();
  private final boolean jdField_a_of_type_Boolean;
  private boolean b;
  private volatile boolean c;
  
  private ayxg()
  {
    super("InnerDnsModule");
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label105;
      }
      localObject = a(BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).getString("sp_domain", null));
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap((Map)localObject);
      return;
      bool = false;
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    return;
    label105:
    QIPCClientHelper.getInstance().getClient().connect(new ayxh(this));
    QIPCClientHelper.getInstance().getClient().addListener(new ayxi(this));
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.innerdns.domainAddressDataUpdateAction");
    try
    {
      BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static ayxg a()
  {
    if (jdField_a_of_type_Ayxg == null) {}
    try
    {
      if (jdField_a_of_type_Ayxg == null) {
        jdField_a_of_type_Ayxg = new ayxg();
      }
      return jdField_a_of_type_Ayxg;
    }
    finally {}
  }
  
  private String a()
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str2 = String.valueOf(bbfj.a(localContext));
    String str1 = str2;
    if (!bbkk.a(str2))
    {
      str1 = str2;
      if (str2.equals(String.valueOf(1))) {
        str1 = avbw.a(localContext);
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    if (bbkk.a(paramString)) {
      return paramString;
    }
    try
    {
      paramString = new URL(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    Object localObject2;
    if (!bbkk.a(paramString2))
    {
      localObject1 = paramString1;
      if (!bbkk.a(paramString1))
      {
        localObject2 = null;
        localObject1 = paramString1;
        if (paramString1 != null)
        {
          if (!paramString1.startsWith("http://")) {
            break label68;
          }
          localObject1 = "http://" + paramString2 + "/";
        }
      }
    }
    for (;;)
    {
      localObject1 = ayuk.a(paramString1, (String)localObject1);
      return localObject1;
      label68:
      localObject1 = localObject2;
      if (paramString1.startsWith("https://")) {
        localObject1 = "https://" + paramString2 + "/";
      }
    }
  }
  
  public static String a(HashMap<String, HashMap<String, ayxf>> paramHashMap)
  {
    if (paramHashMap == null) {
      return null;
    }
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      JSONArray localJSONArray = new JSONArray();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (HashMap)((Map.Entry)localObject).getValue();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("net_identifier", str);
        localJSONObject.put("domain_map", ayxf.a((HashMap)localObject));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
    }
    catch (Throwable paramHashMap)
    {
      paramHashMap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "parse failed");
      }
      return null;
    }
    return paramHashMap;
  }
  
  private ArrayList<ayxk> a(ArrayList<ayxk> paramArrayList)
  {
    if (paramArrayList != null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        int i = paramArrayList.size();
        if (i == 0)
        {
          localObject = null;
          return localObject;
        }
        localObject = paramArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          if (((ayxk)((Iterator)localObject).next()).b <= 0) {
            continue;
          }
          ((Iterator)localObject).remove();
          continue;
        }
        localObject = paramArrayList;
      }
      finally {}
      if (paramArrayList.size() > 1)
      {
        localObject = paramArrayList;
        if (this.jdField_a_of_type_JavaUtilRandom.nextInt() % 10 == 0)
        {
          Collections.shuffle(paramArrayList);
          localObject = paramArrayList;
        }
      }
    }
  }
  
  public static HashMap<String, HashMap<String, ayxf>> a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      try
      {
        HashMap localHashMap = new HashMap();
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = paramString.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("net_identifier");
          localObject = ayxf.a(((JSONObject)localObject).getString("domain_map"));
          if (localObject != null) {
            localHashMap.put(str, localObject);
          }
          i += 1;
        }
        return localHashMap;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.d("InnerDns", 2, "unParse failed");
    return null;
  }
  
  private static HashMap<String, ayxf> a(List<DomainIp.iplistInfo> paramList, HashMap<String, ayxf> paramHashMap)
  {
    if (paramList == null) {}
    Object localObject1;
    String str;
    int i;
    label136:
    Object localObject2;
    do
    {
      return paramHashMap;
      localObject1 = paramHashMap;
      if (paramHashMap == null) {
        localObject1 = new HashMap();
      }
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramHashMap = (HashMap<String, ayxf>)localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (DomainIp.iplistInfo)localIterator.next();
        str = paramList.string_dname.get();
        paramHashMap = (HashMap<String, ayxf>)localObject1;
        if (bbkk.a(str)) {
          break;
        }
        paramHashMap = (HashMap<String, ayxf>)localObject1;
        if (paramList.int32_result.get() != 0) {
          break;
        }
        i = paramList.uint32_type.get();
        if ((i == 1) || (i == 28)) {
          break label136;
        }
        if (QLog.isColorLevel()) {
          QLog.d("InnerDns", 2, "onDomainServerListUpdate unexpected type=" + i);
        }
      }
      localObject2 = paramList.ServerList_data.get();
      paramHashMap = (HashMap<String, ayxf>)localObject1;
    } while (localObject2 == null);
    if ((((HashMap)localObject1).containsKey(str)) && (((HashMap)localObject1).get(str) != null))
    {
      paramList = (ayxf)((HashMap)localObject1).get(str);
      if (paramList.a != null) {
        break label392;
      }
      paramList.a = new ArrayList();
    }
    label392:
    for (;;)
    {
      paramHashMap = ((List)localObject2).iterator();
      for (;;)
      {
        if (paramHashMap.hasNext())
        {
          localObject2 = (DomainIp.ServerList)paramHashMap.next();
          ayxk localayxk = new ayxk();
          localayxk.jdField_a_of_type_JavaLangString = ((DomainIp.ServerList)localObject2).string_IP.get();
          localayxk.jdField_a_of_type_Int = ((DomainIp.ServerList)localObject2).uint32_Port.get();
          localayxk.c = i;
          paramList.a.add(localayxk);
          if (QLog.isColorLevel())
          {
            QLog.d("InnerDns", 2, "onDomainServerListUpdate type=" + i + " d:" + str + " " + localayxk.jdField_a_of_type_JavaLangString + " " + localayxk.jdField_a_of_type_Int);
            continue;
            paramList = new ayxf(str, new ArrayList());
            break;
          }
        }
      }
      if (paramList.a.size() <= 0) {
        break;
      }
      ((HashMap)localObject1).put(str, paramList);
      break;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    List localList = null;
    HashMap localHashMap = new HashMap();
    Object localObject = localHashMap;
    for (;;)
    {
      try
      {
        DomainIp.NameRspBody localNameRspBody = new DomainIp.NameRspBody();
        if (paramArrayOfByte != null)
        {
          localObject = localHashMap;
          localNameRspBody.mergeFrom(paramArrayOfByte);
        }
        localObject = localHashMap;
        paramArrayOfByte = (DomainIp.SubCmd_name_Rsp)localNameRspBody.SubCmd_name_Rsp.get();
        if (paramArrayOfByte == null) {
          break label243;
        }
        localObject = localHashMap;
        localList = paramArrayOfByte.iplistInfo.get();
        localObject = localHashMap;
        paramArrayOfByte = paramArrayOfByte.iplistInfoV6.get();
        if ((localList != null) || (paramArrayOfByte != null)) {
          continue;
        }
        paramArrayOfByte = localHashMap;
        bool = false;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = (byte[])localObject;
        boolean bool = false;
        continue;
      }
      if (bool) {
        localObject = a();
      }
      try
      {
        if (!bbkk.a((String)localObject))
        {
          if ((this.jdField_a_of_type_JavaUtilHashMap.size() >= 3) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))) {
            this.jdField_a_of_type_JavaUtilHashMap.clear();
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramArrayOfByte);
        }
        if (this.jdField_a_of_type_Boolean) {
          BaseApplicationImpl.getApplication().getSharedPreferences("sp_inner_dns", 0).edit().putString("sp_domain", a(this.jdField_a_of_type_JavaUtilHashMap)).commit();
        }
        return bool;
      }
      finally {}
      localObject = localHashMap;
      localHashMap = a(localList, localHashMap);
      localObject = localHashMap;
      paramArrayOfByte = a(paramArrayOfByte, localHashMap);
      bool = true;
      continue;
      label243:
      paramArrayOfByte = null;
    }
  }
  
  public static ayxg b()
  {
    return jdField_a_of_type_Ayxg;
  }
  
  public static String b(String paramString, int paramInt)
  {
    String str = a(paramString);
    return a(paramString, a().a(str, paramInt));
  }
  
  private void c()
  {
    if (this.b)
    {
      ThreadManager.postImmediately(new InnerDns.4(this), null, false);
      return;
    }
    QLog.e("InnerDns", 1, "syncAddressData fail, ipc is not connected.");
  }
  
  public String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, 1);
  }
  
  public String a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, paramInt, paramBoolean, 1);
  }
  
  public String a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = null;
    ArrayList localArrayList = a(paramString, paramInt1, paramBoolean, paramInt2);
    paramString = localObject;
    if (localArrayList != null)
    {
      paramString = localObject;
      if (localArrayList.size() > 0) {
        paramString = (String)localArrayList.get(0);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDns after dns:" + paramString);
    }
    return paramString;
  }
  
  public ArrayList<String> a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true, 1);
  }
  
  public ArrayList<String> a(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reqDns, p:" + BaseApplicationImpl.sProcessId + " d:" + paramString + " b:" + paramInt1 + "N:" + this.jdField_a_of_type_JavaLangString + " t:" + paramInt2);
    }
    if (bbkk.a(paramString))
    {
      paramString = null;
      return paramString;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = true;
    Object localObject;
    if ((this.jdField_a_of_type_Boolean) || ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))) {
      localObject = a();
    }
    label227:
    do
    {
      ayxk localayxk;
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
          break label581;
        }
        localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if (!((HashMap)localObject).containsKey(paramString)) {
          break label733;
        }
        localObject = a(((ayxf)((HashMap)localObject).get(paramString)).a);
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          if (((ayxk)((ArrayList)localObject).get(0)).b <= 0) {
            break label716;
          }
          i = 1;
          continue;
          localObject = new HashMap();
          ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject).put("domain", paramString);
          ((HashMap)localObject).put("ipType", String.valueOf(paramInt2));
          ((HashMap)localObject).put("businessType", String.valueOf(paramInt1));
          axrn.a(BaseApplication.getContext()).a(null, "actDnsReq", paramBoolean, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
          paramString = localArrayList;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("InnerDns", 2, "reqDnsForIpList succeeded:" + paramBoolean + " retList=" + localArrayList + " error=" + i);
          return localArrayList;
        }
        i = 1;
      }
      finally {}
      Iterator localIterator = ((ArrayList)localObject).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localayxk = (ayxk)localIterator.next();
      } while (localayxk.c != paramInt2);
      String str = localayxk.jdField_a_of_type_JavaLangString;
      if ((localayxk.c == 1) && (localayxk.jdField_a_of_type_Int != 80)) {
        localObject = str + ":" + localayxk.jdField_a_of_type_Int;
      }
      for (;;)
      {
        localArrayList.add(localObject);
        break label384;
        localObject = str;
        if (localayxk.c == 28)
        {
          str = "[" + str + "]";
          localObject = str;
          if (localayxk.jdField_a_of_type_Int != 80)
          {
            localObject = str + ":" + localayxk.jdField_a_of_type_Int;
            continue;
            b();
            paramBoolean = false;
            i = 60;
            break;
            if ((this.b) && (paramBoolean))
            {
              localObject = new Bundle();
              ((Bundle)localObject).putString("domain", paramString);
              ((Bundle)localObject).putInt("ipType", paramInt2);
              ((Bundle)localObject).putInt("businessType", paramInt1);
              localObject = QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reqDomain2IpList", (Bundle)localObject);
              if (((EIPCResult)localObject).isSuccess())
              {
                localArrayList = ((EIPCResult)localObject).data.getStringArrayList("ip");
                paramBoolean = bool;
              }
              for (;;)
              {
                break;
                paramBoolean = false;
                i = 20;
              }
            }
            i = 10;
            paramBoolean = false;
            break label227;
          }
        }
      }
      paramBoolean = true;
      i = 0;
      break label730;
      i = 0;
    } while (i == 0);
    label384:
    label581:
    label716:
    paramBoolean = false;
    for (i = 30;; i = 50)
    {
      label730:
      break;
      label733:
      paramBoolean = false;
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 44	ayxg:jdField_a_of_type_Boolean	Z
    //   4: ifeq +43 -> 47
    //   7: ldc 2
    //   9: monitorenter
    //   10: invokestatic 48	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   13: ldc 50
    //   15: iconst_0
    //   16: invokevirtual 54	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: invokeinterface 417 1 0
    //   24: ldc 56
    //   26: aload_0
    //   27: getfield 72	ayxg:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   30: invokestatic 418	ayxg:a	(Ljava/util/HashMap;)Ljava/lang/String;
    //   33: invokeinterface 424 3 0
    //   38: invokeinterface 427 1 0
    //   43: pop
    //   44: ldc 2
    //   46: monitorexit
    //   47: invokestatic 48	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   50: aload_0
    //   51: getfield 36	ayxg:jdField_a_of_type_AndroidContentBroadcastReceiver	Landroid/content/BroadcastReceiver;
    //   54: invokevirtual 560	com/tencent/common/app/BaseApplicationImpl:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   57: return
    //   58: astore_1
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   69: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	ayxg
    //   58	5	1	localObject	Object
    //   64	2	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	47	58	finally
    //   59	62	58	finally
    //   47	57	64	java/lang/Exception
  }
  
  public void a(FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "onReceivePush:" + BaseApplicationImpl.sProcessId);
    }
    this.c = false;
    if (!this.jdField_a_of_type_Boolean) {}
    Object localObject1;
    do
    {
      return;
      Object localObject2 = null;
      localObject1 = localObject2;
      try
      {
        ByteBuffer localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject1 = localObject2;
        paramFromServiceMsg = new byte[localByteBuffer.getInt() - 4];
        localObject1 = paramFromServiceMsg;
        localByteBuffer.get(paramFromServiceMsg);
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          QLog.e("InnerDns", 1, "decode failed:" + paramFromServiceMsg.getMessage());
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
      }
      try
      {
        if (a(paramFromServiceMsg))
        {
          paramFromServiceMsg = new Intent();
          paramFromServiceMsg.setAction("com.tencent.innerdns.domainAddressDataUpdateAction");
          BaseApplicationImpl.getApplication().sendBroadcast(paramFromServiceMsg, "com.tencent.msg.permission.pushnotify");
          return;
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        QLog.e("InnerDns", 1, "onReceivePush sendBroadcast fail:" + paramFromServiceMsg.getMessage());
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("InnerDns", 2, "decode failed.");
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "reportBadIp domian: " + paramString1 + " ip:" + paramString2 + " busiType:" + paramInt + " ServerProcName:" + this.jdField_a_of_type_JavaLangString);
    }
    paramString2 = paramString2.replaceAll("\\[(.*)\\]", "$1");
    int i;
    boolean bool1;
    if ((bbkk.a(paramString1)) || (bbkk.a(paramString2)) || (paramString1.equals(paramString2)))
    {
      i = 40;
      bool1 = false;
    }
    label471:
    label481:
    label484:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("InnerDns", 2, "reportBadIp succeeded:" + bool1 + " error=" + i);
      }
      Object localObject = new HashMap();
      ((HashMap)localObject).put("domain", paramString1);
      ((HashMap)localObject).put("ip", paramString2);
      ((HashMap)localObject).put("businessType", String.valueOf(paramInt));
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      axrn.a(BaseApplication.getContext()).a(null, "actDnsBadIp", bool1, BaseApplicationImpl.sProcessId, 0L, (HashMap)localObject, "");
      return;
      localObject = a();
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)))
      {
        try
        {
          localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
          if (((HashMap)localObject).containsKey(paramString1))
          {
            localObject = (ayxf)((HashMap)localObject).get(paramString1);
            if (((ayxf)localObject).a != null)
            {
              localObject = ((ayxf)localObject).a.iterator();
              while (((Iterator)localObject).hasNext())
              {
                ayxk localayxk = (ayxk)((Iterator)localObject).next();
                if (paramString2.equals(localayxk.jdField_a_of_type_JavaLangString)) {
                  localayxk.b += 1;
                }
              }
            }
          }
        }
        finally {}
        bool1 = true;
        i = 0;
        label378:
        if (this.jdField_a_of_type_Boolean) {
          break label484;
        }
        if (!this.b) {
          break label471;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("domain", paramString1);
        ((Bundle)localObject).putString("ip", paramString2);
        ((Bundle)localObject).putInt("businessType", paramInt);
        if (QIPCClientHelper.getInstance().getClient().callServer("InnerDnsModule", "reportBadIp", (Bundle)localObject).isSuccess()) {
          break label481;
        }
        i = 20;
        bool1 = bool2;
      }
      for (;;)
      {
        break;
        i = 60;
        bool1 = false;
        break label378;
        i = 10;
        bool1 = false;
        break;
      }
    }
  }
  
  public void b()
  {
    if ((BaseApplicationImpl.sProcessId == 1) && (!this.c))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localQQAppInterface.startServlet(new NewIntent(localQQAppInterface.getApp(), axbz.class));
      this.c = true;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InnerDns", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("reqDomain2IpList".equals(paramString)) {
      localBundle.putStringArrayList("ip", a(paramBundle.getString("domain"), paramBundle.getInt("businessType"), false, paramBundle.getInt("ipType", 1)));
    }
    for (;;)
    {
      return EIPCResult.createSuccessResult(localBundle);
      if ("reportBadIp".equals(paramString)) {
        a(paramBundle.getString("domain"), paramBundle.getString("ip"), paramBundle.getInt("businessType"));
      } else if ("syncAddressData".equals(paramString)) {
        localBundle.putString("addressData", a(this.jdField_a_of_type_JavaUtilHashMap));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayxg
 * JD-Core Version:    0.7.0.1
 */