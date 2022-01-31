package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatInfo.ExitedHotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;
import zmg;
import zmh;
import zmi;

public class HotChatManager
  implements Manager
{
  public static boolean a;
  static boolean b;
  static boolean jdField_c_of_type_Boolean;
  int jdField_a_of_type_Int = 0;
  public long a;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  HotChatManager.OnVListUpdateListener jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener = null;
  public QQAppInterface a;
  PttShowRoomMng jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  List jdField_a_of_type_JavaUtilList = null;
  public final Map a;
  ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  public long b;
  private long jdField_c_of_type_Long;
  boolean d = false;
  boolean e = false;
  volatile boolean f = false;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public HotChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 20000L;
    this.jdField_b_of_type_Long = 20000L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
    ThreadManager.getFileThreadHandler().post(new zmg(this));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      if (paramInt1 == 2) {
        return 2130840599;
      }
      break;
    case 1: 
      return 2130840611;
    }
    if (paramInt1 == 3) {
      return 2130840610;
    }
    return 2130840608;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface).getInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", 3);
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    int j = 2130840613;
    HotChatManager localHotChatManager = paramQQAppInterface.a(false);
    paramQQAppInterface = null;
    if (localHotChatManager != null) {
      paramQQAppInterface = localHotChatManager.a(paramString);
    }
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (!paramQQAppInterface.isWifiHotChat) {
        i = a(paramQQAppInterface.hotThemeGroupFlag, 2130840613);
      }
    }
    return i;
  }
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("Config_Before_load_RU" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static String a(WifiInfo paramWifiInfo)
  {
    if (paramWifiInfo == null) {
      paramWifiInfo = "";
    }
    String str;
    do
    {
      do
      {
        return paramWifiInfo;
        str = paramWifiInfo.getSSID();
        if (str == null) {
          break;
        }
        paramWifiInfo = str;
      } while (!str.startsWith("\""));
      paramWifiInfo = str;
    } while (!str.endsWith("\""));
    return str.substring(1, str.length() - 1);
    return "";
  }
  
  public static Map a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = a(paramQQAppInterface).getString("PREF_KEY_EXITED_HOTCHATINFO", "");
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label76;
        }
        paramQQAppInterface = (Map)new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramQQAppInterface.getBytes(), 0))).readObject();
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("HotChatManager", 2, "", paramQQAppInterface);
      return null;
      label76:
      paramQQAppInterface = null;
    }
  }
  
  public static im_msg_body.Elem a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (!a(paramAppInterface, false)) {
      return null;
    }
    paramAppInterface = new im_msg_body.NearByMessageType();
    paramAppInterface.uint32_identify_type.set(1);
    paramMessageRecord = new im_msg_body.Elem();
    paramMessageRecord.near_by_msg.set(paramAppInterface);
    return paramMessageRecord;
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseActivity.sTopActivity;
    }
    if (localObject == null) {
      return;
    }
    paramContext = new Intent((Context)localObject, NearbyActivity.class);
    paramContext.putExtra("ENTER_TIME", System.currentTimeMillis());
    paramContext.putExtra("TAB_TYPE", 3);
    paramContext.setFlags(67108864);
    if (paramBoolean) {
      paramContext.putExtra("abp_flag", paramBoolean);
    }
    ((Context)localObject).startActivity(paramContext);
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "update authFlag:" + paramBoolean + " old:" + jdField_c_of_type_Boolean);
    }
    if (jdField_c_of_type_Boolean == paramBoolean) {
      return;
    }
    paramAppInterface.getPreferences().edit().putBoolean("hotchat_auth_flag", paramBoolean).commit();
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramQQAppInterface = a(paramQQAppInterface).edit();
    paramQQAppInterface.putInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", i);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Map paramMap)
  {
    if ((paramQQAppInterface == null) || (paramMap == null)) {}
    do
    {
      return;
      try
      {
        paramQQAppInterface = a(paramQQAppInterface);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramMap);
        paramMap = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
        paramQQAppInterface = paramQQAppInterface.edit();
        paramQQAppInterface.putString("PREF_KEY_EXITED_HOTCHATINFO", paramMap);
        paramQQAppInterface.commit();
        return;
      }
      catch (Exception paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.e("HotChatManager", 2, "", paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "saveSupportHotChatFlag", Boolean.valueOf(paramBoolean), Boolean.valueOf(jdField_b_of_type_Boolean) });
    }
    Object localObject = paramQQAppInterface.getPreferences().edit();
    ((SharedPreferences.Editor)localObject).putBoolean("DOES_SUPPORT_HOT_CHAT", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if ((!jdField_b_of_type_Boolean) && (paramBoolean))
    {
      jdField_b_of_type_Boolean = true;
      localObject = (HotChatManager)paramQQAppInterface.getManager(59);
      ((HotChatManager)localObject).d = true;
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotChatManager", new Object[] { "saveSupportHotChatFlag", "needGetMessage", Boolean.valueOf(((HotChatManager)localObject).d) });
      }
      ((HotChatHandler)paramQQAppInterface.a(35)).b();
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (!jdField_c_of_type_Boolean) {
      jdField_c_of_type_Boolean = paramAppInterface.getPreferences().getBoolean("hotchat_auth_flag", paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat", 2, "get authFlag:" + jdField_c_of_type_Boolean);
    }
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "doesSupportHotChat:" + jdField_b_of_type_Boolean);
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("identify_flag")));
  }
  
  private void b(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      return;
    }
    HashMap localHashMap = (HashMap)a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localHashMap == null) {
      localHashMap = new HashMap();
    }
    for (;;)
    {
      if (localHashMap.containsKey(paramHotChatInfo.troopUin)) {
        ((HotChatInfo.ExitedHotChatInfo)localHashMap.get(paramHotChatInfo.troopUin)).leftTime = paramHotChatInfo.leftTime;
      }
      for (;;)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHashMap);
        return;
        HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo = new HotChatInfo.ExitedHotChatInfo();
        localExitedHotChatInfo.leftTime = paramHotChatInfo.leftTime;
        localExitedHotChatInfo.troopUin = paramHotChatInfo.troopUin;
        localHashMap.put(localExitedHotChatInfo.troopUin, localExitedHotChatInfo);
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_SHELL", false);
  }
  
  private void c()
  {
    boolean bool = a().getBoolean("HAS_USING_HOTCHAT", false);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "hasJoinedHotChat = " + bool);
    }
    if ((bool) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      Object localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if ((localHotChatInfo.state != 5) && (!localHotChatInfo.isWifiHotChat)) {
            this.jdField_a_of_type_JavaUtilMap.put(localHotChatInfo.troopUin, localHotChatInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.d("HotChatManager", 2, "initCache  HotChatInfo = " + localHotChatInfo);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "initCache  size = " + this.jdField_a_of_type_JavaUtilMap.size());
      }
    }
  }
  
  private void d()
  {
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Object localObject2 = new File(BaseApplicationImpl.getApplication().getFilesDir() + "/hotchatclassify");
      if (!((File)localObject2).exists()) {
        return;
      }
      localObject1 = ((DocumentBuilder)localObject1).parse((File)localObject2).getElementsByTagName("data");
      localObject2 = new SparseArray();
      int i = 0;
      while (i < ((NodeList)localObject1).getLength())
      {
        Object localObject3 = (Element)((NodeList)localObject1).item(i);
        String str = ((Element)localObject3).getElementsByTagName("key").item(0).getFirstChild().getNodeValue();
        localObject3 = ((Element)localObject3).getElementsByTagName("value").item(0).getFirstChild().getNodeValue();
        if (QLog.isColorLevel()) {
          QLog.i("HotChatManager", 2, "buildClassifyInfos, key = " + str + ",value=" + (String)localObject3);
        }
        ((SparseArray)localObject2).put(Integer.valueOf(str).intValue(), localObject3);
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.i("HotChatManager", 1, "buildClassifyInfos exception happen:" + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public SharedPreferences a()
  {
    return BaseApplicationImpl.sApplication.getSharedPreferences("Config_Before_load_RU" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public HotChatInfo a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.userCreate == 0) && (localHotChatInfo.state == 0)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public HotChatInfo a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 0) && (localHotChatInfo.apolloGameId == paramInt)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public HotChatInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "getHotCatInfo troopUin isEmpty," + paramString);
      }
      return null;
    }
    return (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  public PttShowRoomMng a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng == null) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng = new PttShowRoomMng(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng;
  }
  
  public String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (HotChatInfo)localIterator.next();
        if ((localObject != null) && (((HotChatInfo)localObject).troopCode != null) && (((HotChatInfo)localObject).troopCode.equals(paramString)))
        {
          localObject = ((HotChatInfo)localObject).troopUin;
          if ((localObject != null) && (((String)localObject).length() > 0))
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
            return localObject;
          }
        }
      }
    }
    return null;
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public List a()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      ThreadManager.post(new zmh(this), 10, null, false);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "setMyUinCharmLevel, charmLevel = " + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.a(paramHotChatInfo);
    localEntityManager.a();
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onJoinedHotChat hc = " + paramHotChatInfo + ", preState:" + paramInt);
    }
    if (paramHotChatInfo.adminLevel == 0)
    {
      paramHotChatInfo.state = 0;
      paramHotChatInfo.ruState = 0;
      this.jdField_a_of_type_JavaUtilMap.put(paramHotChatInfo.troopUin, paramHotChatInfo);
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localEntityManager.b(paramHotChatInfo);
      localEntityManager.a();
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramHotChatInfo.troopUin);
      b(paramHotChatInfo, paramInt);
      HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramHotChatInfo = a().edit();
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        break label197;
      }
    }
    label197:
    for (boolean bool = true;; bool = false)
    {
      paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatInfo.commit();
      return;
      if (paramHotChatInfo.adminLevel != 1) {
        break;
      }
      ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).a(paramHotChatInfo.ownerUin);
      break;
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "onExitHotChat hc = " + paramHotChatInfo + ", ts = " + paramHotChatStateWrapper);
    }
    if ((paramHotChatInfo == null) || (paramHotChatStateWrapper == null)) {
      return;
    }
    ((NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105)).a(paramHotChatInfo.ownerUin);
    HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = paramHotChatStateWrapper.targetState;
    paramHotChatInfo.onExit(i);
    paramHotChatStateWrapper = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((i == 4) || (i == 1))
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramHotChatInfo.troopUin);
      paramHotChatStateWrapper.b(paramHotChatInfo);
      paramHotChatStateWrapper.a();
      if ((i != 6) && (i != 7)) {
        break label249;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("HotChatManager", 2, "onExitHotChat no need to clear message");
      }
      label159:
      paramHotChatStateWrapper = a().edit();
      if (this.jdField_a_of_type_JavaUtilMap.isEmpty()) {
        break label265;
      }
    }
    label265:
    for (boolean bool = true;; bool = false)
    {
      paramHotChatStateWrapper.putBoolean("HAS_USING_HOTCHAT", bool);
      paramHotChatStateWrapper.commit();
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramHotChatInfo.troopUin);
      ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(254)).a(paramHotChatInfo.troopUin, i);
      return;
      paramHotChatStateWrapper.a(paramHotChatInfo);
      break;
      label249:
      c(paramHotChatInfo.troopUin);
      b(paramHotChatInfo);
      break label159;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = a(paramString);
    } while (paramString == null);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString.ruState = 1;
    localEntityManager.a(paramString);
    localEntityManager.a();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "handleGetHotchatVList, json:" + paramString2);
    }
    FileUtils.a(BaseApplicationImpl.getContext().getFilesDir() + File.separator + paramString1 + "_nearby_hotchat_v_list", paramString2);
    ArrayList localArrayList;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localArrayList = new ArrayList();
      paramString1 = null;
      try
      {
        paramString2 = new JSONObject(paramString2).getJSONArray("vusers");
        paramString1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        for (;;)
        {
          int i;
          paramString2.printStackTrace();
        }
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        if (this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener == null) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener.a();
      }
      if (paramString1 != null)
      {
        i = 0;
        while (i < paramString1.length())
        {
          paramString2 = paramString1.optString(i);
          if (!TextUtils.isEmpty(paramString2)) {
            localArrayList.add(paramString2);
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    paramPbGetGroupMsgResp = a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "----->onPullRecentGroupMsg troopUin = " + paramString + ", doSome:" + paramInt + ", hotChat = " + paramPbGetGroupMsgResp);
    }
    if (paramPbGetGroupMsgResp != null)
    {
      if (paramInt != 1) {
        break label90;
      }
      HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437352), true);
    }
    for (;;)
    {
      return;
      label90:
      if (paramInt == 4)
      {
        if (paramPbGetGroupMsgResp.isWifiHotChat)
        {
          HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437338, new Object[] { paramPbGetGroupMsgResp.name }), true);
          return;
        }
        if (1 == paramPbGetGroupMsgResp.adminLevel) {
          break;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437337, new Object[] { paramPbGetGroupMsgResp.name });
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramPbGetGroupMsgResp.troopUin, 1, 10);
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (((localMessageRecord instanceof MessageForNewGrayTips)) && (localMessageRecord.msg.equals(paramString))) {
              NearbyUtils.a("HotChatManager", new Object[] { "onPullRecentGroupMsg", "grayTips exist in last 10 msgs" });
            }
          }
        }
        for (paramInt = 0; paramInt != 0; paramInt = 1)
        {
          HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, paramString, true);
          return;
        }
      }
    }
  }
  
  final void a(List paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList,hotchat list = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "onGetJoinedHotChatList", Integer.valueOf(paramList.size()), Boolean.valueOf(this.d) });
    }
    HashSet localHashSet = new HashSet();
    Object localObject1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (HotChatInfo)((Iterator)localObject2).next();
        if (!((HotChatInfo)localObject3).isWifiHotChat) {
          if (((HotChatInfo)localObject3).userCreate == 0)
          {
            ((ArrayList)localObject1).add(localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newPOIHotChat = " + localObject3);
            }
          }
          else
          {
            ((ArrayList)localObject1).add(localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("HotChatManager", 2, "onGetJoinedHotChatList newUserCreateHotChat = " + localObject3);
            }
          }
        }
      }
      if (!paramBoolean) {
        NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramList);
      }
    }
    Object localObject2 = a();
    boolean bool2 = ((SharedPreferences)localObject2).getBoolean("qq_update_5.9", true);
    Object localObject3 = a();
    Iterator localIterator1 = ((ArrayList)localObject1).iterator();
    label275:
    Object localObject4;
    if (localIterator1.hasNext())
    {
      localObject4 = (HotChatInfo)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localObject3).iterator();
      do
      {
        if (!localIterator2.hasNext()) {
          break;
        }
        paramList = (HotChatInfo)localIterator2.next();
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "onGetJoinedHotChatList old.trooUin=:" + paramList.troopUin + ",hc.troopUin=:" + ((HotChatInfo)localObject4).troopUin);
        }
      } while (!paramList.troopUin.equals(((HotChatInfo)localObject4).troopUin));
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList exist=:" + bool1);
      }
      if (bool1)
      {
        paramList.updateHotChatInfo((HotChatInfo)localObject4);
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject4).a(paramList);
        ((EntityManager)localObject4).a();
        if (!bool2) {
          break label275;
        }
        b(paramList.troopUin);
        break label275;
      }
      a((HotChatInfo)localObject4, 4);
      localHashSet.add(((HotChatInfo)localObject4).troopUin);
      break label275;
      paramList = ((ArrayList)localObject3).iterator();
      label782:
      label841:
      for (;;)
      {
        label503:
        if (paramList.hasNext())
        {
          localObject3 = (HotChatInfo)paramList.next();
          if (((HotChatInfo)localObject3).isGameRoom == paramBoolean)
          {
            localIterator1 = ((ArrayList)localObject1).iterator();
            do
            {
              if (!localIterator1.hasNext()) {
                break;
              }
            } while (!((HotChatInfo)localIterator1.next()).troopUin.equals(((HotChatInfo)localObject3).troopUin));
          }
        }
        else
        {
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label841;
            }
            a((HotChatInfo)localObject3, HotChatManager.HotChatStateWrapper.wrap(4));
            b((HotChatInfo)localObject3);
            break label503;
            HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramList = ((SharedPreferences)localObject2).edit();
            if (!this.jdField_a_of_type_JavaUtilMap.isEmpty()) {}
            for (paramBoolean = true;; paramBoolean = false)
            {
              paramList.putBoolean("HAS_USING_HOTCHAT", paramBoolean);
              if (bool2) {
                paramList.putBoolean("qq_update_5.9", false);
              }
              paramList.commit();
              if (!this.d) {
                break;
              }
              this.d = false;
              localObject1 = b();
              if (!QLog.isColorLevel()) {
                break label782;
              }
              localObject2 = ((List)localObject1).iterator();
              for (paramList = ""; ((Iterator)localObject2).hasNext(); paramList = paramList + " " + ((HotChatInfo)localObject3).troopUin) {
                localObject3 = (HotChatInfo)((Iterator)localObject2).next();
              }
            }
            QLog.d("HotChatManager", 2, "troopUin:" + paramList);
            paramList = ((List)localObject1).iterator();
            while (paramList.hasNext())
            {
              localObject1 = (HotChatInfo)paramList.next();
              if ((localObject1 != null) && (!localHashSet.contains(((HotChatInfo)localObject1).troopUin))) {
                b((HotChatInfo)localObject1, 0);
              }
            }
            break;
          }
        }
      }
      paramList = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "needReqGlobleAdminFlag, svrTime:" + l + "|mNextReqGlobleAdminFlagTime:" + this.jdField_c_of_type_Long);
    }
    return NetConnInfoCenter.getServerTime() > this.jdField_c_of_type_Long;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.state == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public HotChatInfo b(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if (localHotChatInfo.uuid.equals(paramString)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public List b()
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
      if ((localHotChatInfo != null) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    for (;;)
    {
      Iterator localIterator;
      HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo;
      try
      {
        Map localMap1 = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localMap1 == null) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) {
          continue;
        }
        long l = System.currentTimeMillis();
        localIterator = localMap1.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label215;
        }
        localExitedHotChatInfo = (HotChatInfo.ExitedHotChatInfo)((Map.Entry)localIterator.next()).getValue();
        if (localExitedHotChatInfo == null) {
          continue;
        }
        HotChatInfo localHotChatInfo = a(localExitedHotChatInfo.troopUin);
        if ((localHotChatInfo != null) && (localHotChatInfo.state == 0))
        {
          localIterator.remove();
          continue;
        }
        if (Math.abs(l - localExitedHotChatInfo.leftTime) < 604800000L) {
          continue;
        }
      }
      finally {}
      if ((localExitedHotChatInfo.troopUin != null) && (localExitedHotChatInfo.troopUin.length() > 2)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localExitedHotChatInfo.troopUin, 1);
      }
      for (;;)
      {
        localIterator.remove();
        break;
        QLog.d("HotChatManager", 1, "clearUnUsableHotChatTable exitedInfo.troopUin isEmpty:" + localExitedHotChatInfo.troopUin);
      }
      label215:
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMap2);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(String.valueOf(paramLong)) != null)
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a("HotChatManager", new Object[] { "checkHotChatInfo", Long.valueOf(paramLong) });
      }
      return;
    }
    Object localObject = new HotChatInfo();
    ((HotChatInfo)localObject).troopUin = String.valueOf(paramLong);
    ((HotChatInfo)localObject).name = ((HotChatInfo)localObject).troopUin;
    ((HotChatInfo)localObject).hotThemeGroupFlag = 1;
    ((HotChatInfo)localObject).userCreate = 0;
    ((HotChatInfo)localObject).supportFlashPic = true;
    ((HotChatInfo)localObject).isWifiHotChat = false;
    ((HotChatInfo)localObject).adminLevel = 2;
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "checkHotChatInfo", "need AddHotChatInfoRunnable", Long.valueOf(paramLong) });
    }
    localObject = new zmi(this, (HotChatInfo)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void b(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "pullRecentGroupMsg", Integer.valueOf(paramInt), paramHotChatInfo.troopUin, paramHotChatInfo.name });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramHotChatInfo.troopUin, paramInt);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, 1, true, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "clear hotChat msgCache done");
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public HotChatInfo c(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (TextUtils.equals(localHotChatInfo.troopCode, paramString))) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      String str;
      do
      {
        SQLiteDatabase localSQLiteDatabase;
        do
        {
          return;
          localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        } while (localSQLiteDatabase == null);
        str = MessageRecord.getTableName(paramString, 1);
        i = localSQLiteDatabase.a(str);
        if (QLog.isColorLevel()) {
          QLog.d("HotChatManager", 2, "clearLimitCountHotChatMsgCache, totalcount=" + i);
        }
      } while ((i <= 250) || (str == null));
      int j = Math.max(i - 200, 50);
      ((TroopMessageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1)).a(paramString, 1, true, false, str, j);
    } while (!QLog.isColorLevel());
    QLog.d("HotChatManager", 2, "clearLimitCountHotChatMsgCache, count=" + i);
  }
  
  public boolean c()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_wifi_shell_setting", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_wifi_shell_setting", false).commit();
    }
    return bool;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = a(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.supportDemo) {
          bool1 = ((Boolean)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf(false))).booleanValue();
        }
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("HotChatManager", 4, "isSupportDemo,  bRet = " + bool1);
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    FileUtils.a(BaseApplicationImpl.getApplication().getFilesDir() + "/hotchatclassify", paramString);
    d();
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "updateClassifyInfo, xmldata = " + paramString);
    }
  }
  
  public boolean d()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("HotChatManager", 2, "isAllowedToSendSplashpic, myUinCharmLevel = " + this.jdField_a_of_type_Int + ", splashpicCharmRequirement = " + i);
    }
    return this.jdField_a_of_type_Int >= i;
  }
  
  public void onDestroy()
  {
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager
 * JD-Core Version:    0.7.0.1
 */