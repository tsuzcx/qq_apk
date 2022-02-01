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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatInfo.ExitedHotChatInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.PttShowRoomMng;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
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

public class HotChatManager
  implements Manager
{
  public static boolean a = true;
  static boolean jdField_b_of_type_Boolean = false;
  static boolean c = false;
  int jdField_a_of_type_Int = 0;
  public long a;
  SparseArray<String> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  HotChatManager.OnVListUpdateListener jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PttShowRoomMng jdField_a_of_type_ComTencentMobileqqHotchatPttShowRoomMng;
  Boolean jdField_a_of_type_JavaLangBoolean = null;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  List<String> jdField_a_of_type_JavaUtilList = null;
  final Map<String, HotChatInfo> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private int jdField_b_of_type_Int = 0;
  public long b;
  public long c;
  public long d;
  boolean d;
  private long jdField_e_of_type_Long = 0L;
  boolean jdField_e_of_type_Boolean = false;
  volatile boolean f = false;
  
  @Deprecated
  public HotChatManager()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 20000L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 20000L;
  }
  
  public HotChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 20000L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 20000L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
    ThreadManager.getFileThreadHandler().post(new HotChatManager.1(this));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2) {
        return 2130842636;
      }
      if (paramInt1 == 3) {
        return 2130842646;
      }
      return 2130842644;
    }
    return 2130842647;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface).getInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", 3);
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHotChatMng(false);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.a(paramString);
    } else {
      paramString = null;
    }
    int j = 2130842648;
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (!paramString.isWifiHotChat) {
        i = a(paramString.hotThemeGroupFlag, 2130842648);
      }
    }
    return i;
  }
  
  public static SharedPreferences a(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config_Before_load_RU");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static String a(WifiInfo paramWifiInfo)
  {
    String str1 = "";
    if (paramWifiInfo == null) {
      return "";
    }
    String str2 = paramWifiInfo.getSSID();
    paramWifiInfo = str1;
    if (str2 != null)
    {
      if ((str2.startsWith("\"")) && (str2.endsWith("\""))) {
        return str2.substring(1, str2.length() - 1);
      }
      paramWifiInfo = str2;
    }
    return paramWifiInfo;
  }
  
  public static Map<String, HotChatInfo.ExitedHotChatInfo> a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    try
    {
      paramQQAppInterface = a(paramQQAppInterface).getString("PREF_KEY_EXITED_HOTCHATINFO", "");
      if (!TextUtils.isEmpty(paramQQAppInterface))
      {
        paramQQAppInterface = (Map)new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramQQAppInterface.getBytes(), 0))).readObject();
        return paramQQAppInterface;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HotChatManager", 2, "", paramQQAppInterface);
      }
    }
    return null;
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
    paramContext = new Intent();
    paramContext.putExtra("ENTER_TIME", System.currentTimeMillis());
    paramContext.putExtra("TAB_TYPE", 3);
    paramContext.setFlags(67108864);
    if (paramBoolean) {
      paramContext.putExtra("abp_flag", paramBoolean);
    }
    RouteUtils.a((Context)localObject, paramContext, "/nearby/activity");
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update authFlag:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" old:");
      localStringBuilder.append(jdField_c_of_type_Boolean);
      QLog.d("Q.hotchat", 2, localStringBuilder.toString());
    }
    if (jdField_c_of_type_Boolean == paramBoolean) {
      return;
    }
    paramAppInterface.getPreferences().edit().putBoolean("hotchat_auth_flag", paramBoolean).commit();
    jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      i = 0;
    }
    paramQQAppInterface = a(paramQQAppInterface).edit();
    paramQQAppInterface.putInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", i);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Map<String, HotChatInfo.ExitedHotChatInfo> paramMap)
  {
    if (paramQQAppInterface != null)
    {
      if (paramMap == null) {
        return;
      }
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
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatManager", 2, "", paramQQAppInterface);
        }
      }
    }
  }
  
  private void a(HashSet<String> paramHashSet)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      Object localObject2 = b();
      if (QLog.isColorLevel())
      {
        Object localObject3 = ((List)localObject2).iterator();
        StringBuilder localStringBuilder;
        for (localObject1 = ""; ((Iterator)localObject3).hasNext(); localObject1 = localStringBuilder.toString())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject3).next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(" ");
          localStringBuilder.append(localHotChatInfo.troopUin);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("troopUin:");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject3).toString());
      }
      Object localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotChatInfo)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!paramHashSet.contains(((HotChatInfo)localObject2).troopUin))) {
          b((HotChatInfo)localObject2, 0);
        }
      }
    }
  }
  
  private void a(List<HotChatInfo> paramList, boolean paramBoolean, ArrayList<HotChatInfo> paramArrayList)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
        if (!localHotChatInfo.isWifiHotChat)
        {
          StringBuilder localStringBuilder;
          if (localHotChatInfo.userCreate == 0)
          {
            paramArrayList.add(localHotChatInfo);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onGetJoinedHotChatList newPOIHotChat = ");
              localStringBuilder.append(localHotChatInfo);
              QLog.d("HotChatManager", 2, localStringBuilder.toString());
            }
          }
          else
          {
            paramArrayList.add(localHotChatInfo);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onGetJoinedHotChatList newUserCreateHotChat = ");
              localStringBuilder.append(localHotChatInfo);
              QLog.d("HotChatManager", 2, localStringBuilder.toString());
            }
          }
        }
      }
      if (!paramBoolean) {
        NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramList);
      }
    }
  }
  
  private void a(boolean paramBoolean1, HashSet<String> paramHashSet, ArrayList<HotChatInfo> paramArrayList1, boolean paramBoolean2, ArrayList<HotChatInfo> paramArrayList2)
  {
    Iterator localIterator1 = paramArrayList1.iterator();
    Object localObject1;
    for (;;)
    {
      boolean bool2 = localIterator1.hasNext();
      boolean bool1 = true;
      if (!bool2) {
        break;
      }
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator1.next();
      localObject1 = null;
      Iterator localIterator2 = paramArrayList2.iterator();
      Object localObject2;
      while (localIterator2.hasNext())
      {
        localObject2 = (HotChatInfo)localIterator2.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetJoinedHotChatList old.trooUin=:");
          localStringBuilder.append(((HotChatInfo)localObject2).troopUin);
          localStringBuilder.append(",hc.troopUin=:");
          localStringBuilder.append(localHotChatInfo.troopUin);
          QLog.d("HotChatManager", 2, localStringBuilder.toString());
        }
        if (((HotChatInfo)localObject2).troopUin.equals(localHotChatInfo.troopUin))
        {
          localObject1 = localObject2;
          break label159;
        }
      }
      bool1 = false;
      label159:
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onGetJoinedHotChatList exist=:");
        ((StringBuilder)localObject2).append(bool1);
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool1)
      {
        ((HotChatInfo)localObject1).updateHotChatInfo(localHotChatInfo);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject2).update((Entity)localObject1);
        ((EntityManager)localObject2).close();
        if (paramBoolean2) {
          b(((HotChatInfo)localObject1).troopUin);
        }
      }
      else
      {
        a(localHotChatInfo, 4);
        paramHashSet.add(localHotChatInfo.troopUin);
      }
    }
    paramHashSet = paramArrayList2.iterator();
    while (paramHashSet.hasNext())
    {
      paramArrayList2 = (HotChatInfo)paramHashSet.next();
      if (paramArrayList2.isGameRoom == paramBoolean1)
      {
        localObject1 = paramArrayList1.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((HotChatInfo)((Iterator)localObject1).next()).troopUin.equals(paramArrayList2.troopUin))
          {
            i = 1;
            break label363;
          }
        }
        int i = 0;
        label363:
        if (i == 0)
        {
          a(paramArrayList2, HotChatManager.HotChatStateWrapper.wrap(4));
          b(paramArrayList2);
        }
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (!jdField_c_of_type_Boolean) {
      jdField_c_of_type_Boolean = paramAppInterface.getPreferences().getBoolean("hotchat_auth_flag", paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("get authFlag:");
      paramAppInterface.append(jdField_c_of_type_Boolean);
      QLog.d("Q.hotchat", 2, paramAppInterface.toString());
    }
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("doesSupportHotChat:");
      paramQQAppInterface.append(jdField_b_of_type_Boolean);
      QLog.d("HotChatManager", 2, paramQQAppInterface.toString());
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.istroop == 1)
    {
      if (((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramMessageRecord.frienduin)) {
        return true;
      }
    }
    else if (paramMessageRecord.istroop == 1026) {
      return true;
    }
    return false;
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
    Object localObject2 = (HashMap)a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new HashMap();
    }
    if (((HashMap)localObject1).containsKey(paramHotChatInfo.troopUin))
    {
      ((HotChatInfo.ExitedHotChatInfo)((HashMap)localObject1).get(paramHotChatInfo.troopUin)).leftTime = paramHotChatInfo.leftTime;
    }
    else
    {
      localObject2 = new HotChatInfo.ExitedHotChatInfo();
      ((HotChatInfo.ExitedHotChatInfo)localObject2).leftTime = paramHotChatInfo.leftTime;
      ((HotChatInfo.ExitedHotChatInfo)localObject2).troopUin = paramHotChatInfo.troopUin;
      ((HashMap)localObject1).put(((HotChatInfo.ExitedHotChatInfo)localObject2).troopUin, localObject2);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Map)localObject1);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_SHELL", false);
  }
  
  private void c()
  {
    boolean bool = a().getBoolean("HAS_USING_HOTCHAT", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasJoinedHotChat = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().query(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if ((localHotChatInfo.state != 5) && (!localHotChatInfo.isWifiHotChat)) {
            this.jdField_a_of_type_JavaUtilMap.put(localHotChatInfo.troopUin, localHotChatInfo);
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initCache  HotChatInfo = ");
            localStringBuilder.append(localHotChatInfo);
            QLog.d("HotChatManager", 2, localStringBuilder.toString());
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initCache  size = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilMap.size());
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void d()
  {
    try
    {
      Object localObject1 = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getFilesDir());
      ((StringBuilder)localObject2).append("/hotchatclassify");
      localObject2 = new File(((StringBuilder)localObject2).toString());
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildClassifyInfos, key = ");
          localStringBuilder.append(str);
          localStringBuilder.append(",value=");
          localStringBuilder.append((String)localObject3);
          QLog.i("HotChatManager", 2, localStringBuilder.toString());
        }
        ((SparseArray)localObject2).put(Integer.valueOf(str).intValue(), localObject3);
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)localObject2);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("buildClassifyInfos exception happen:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.i("HotChatManager", 1, ((StringBuilder)localObject2).toString());
      localException.printStackTrace();
    }
  }
  
  public SharedPreferences a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config_Before_load_RU");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
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
  
  public HotChatInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getHotCatInfo troopUin isEmpty,");
        localStringBuilder.append(paramString);
        QLog.d("HotChatManager", 2, localStringBuilder.toString());
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
    if (paramString != null)
    {
      if (paramString.length() == 0) {
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
    }
    return null;
  }
  
  public ArrayList<HotChatInfo> a()
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
  
  public List<HotChatInfo> a()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int <= 0) {
      ThreadManager.post(new HotChatManager.2(this), 10, null, false);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMyUinCharmLevel, charmLevel = ");
      localStringBuilder.append(paramInt);
      QLog.i("HotChatManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_e_of_type_Long = paramLong;
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.update(paramHotChatInfo);
    localEntityManager.close();
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("----->onJoinedHotChat hc = ");
      ((StringBuilder)localObject).append(paramHotChatInfo);
      ((StringBuilder)localObject).append(", preState:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramHotChatInfo.adminLevel != 0) && (paramHotChatInfo.adminLevel == 1)) {
      ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(paramHotChatInfo.ownerUin);
    }
    paramHotChatInfo.state = 0;
    paramHotChatInfo.ruState = 0;
    this.jdField_a_of_type_JavaUtilMap.put(paramHotChatInfo.troopUin, paramHotChatInfo);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ((EntityManager)localObject).persistOrReplace(paramHotChatInfo);
    ((EntityManager)localObject).close();
    NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramHotChatInfo.troopUin);
    b(paramHotChatInfo, paramInt);
    ((IHotChatApi)QRoute.api(IHotChatApi.class)).invokeRecentUserChangedToConversation(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramHotChatInfo = a().edit();
    paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", this.jdField_a_of_type_JavaUtilMap.isEmpty() ^ true);
    paramHotChatInfo.commit();
  }
  
  public void a(HotChatInfo paramHotChatInfo, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitHotChat hc = ");
      localStringBuilder.append(paramHotChatInfo);
      localStringBuilder.append(", ts = ");
      localStringBuilder.append(paramHotChatStateWrapper);
      QLog.d("HotChatManager", 2, localStringBuilder.toString());
    }
    if (paramHotChatInfo != null)
    {
      if (paramHotChatStateWrapper == null) {
        return;
      }
      ((INearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(paramHotChatInfo.ownerUin);
      ((IHotChatApi)QRoute.api(IHotChatApi.class)).invokeRecentUserChangedToConversation(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int i = paramHotChatStateWrapper.targetState;
      paramHotChatInfo.onExit(i);
      paramHotChatStateWrapper = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((i != 4) && (i != 1))
      {
        paramHotChatStateWrapper.update(paramHotChatInfo);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramHotChatInfo.troopUin);
        paramHotChatStateWrapper.remove(paramHotChatInfo);
      }
      paramHotChatStateWrapper.close();
      if ((i != 6) && (i != 7))
      {
        c(paramHotChatInfo.troopUin);
        b(paramHotChatInfo);
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d("HotChatManager", 2, "onExitHotChat no need to clear message");
      }
      paramHotChatStateWrapper = a().edit();
      paramHotChatStateWrapper.putBoolean("HAS_USING_HOTCHAT", this.jdField_a_of_type_JavaUtilMap.isEmpty() ^ true);
      paramHotChatStateWrapper.commit();
      NearbyFlowerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(paramHotChatInfo.troopUin);
      ((HotChatCenterManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramHotChatInfo.troopUin, i);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString.ruState = 1;
    localEntityManager.update(paramString);
    localEntityManager.close();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetHotchatVList, json:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("HotChatManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getFilesDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_nearby_hotchat_v_list");
    FileUtils.writeFile(((StringBuilder)localObject).toString(), paramString2);
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = new ArrayList();
      paramString1 = null;
      try
      {
        paramString2 = new JSONObject(paramString2).getJSONArray("vusers");
        paramString1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
      if (paramString1 != null)
      {
        int i = 0;
        while (i < paramString1.length())
        {
          paramString2 = paramString1.optString(i);
          if (!TextUtils.isEmpty(paramString2)) {
            ((List)localObject).add(paramString2);
          }
          i += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppHotChatManager$OnVListUpdateListener;
      if (paramString1 != null) {
        paramString1.a();
      }
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    paramPbGetGroupMsgResp = a(paramString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("----->onPullRecentGroupMsg troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", doSome:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", hotChat = ");
      ((StringBuilder)localObject).append(paramPbGetGroupMsgResp);
      QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramPbGetGroupMsgResp != null)
    {
      if (paramInt == 1)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        HotChatHelper.a(paramString, paramPbGetGroupMsgResp, paramString.getApp().getString(2131693189), true);
        return;
      }
      if (paramInt == 4)
      {
        boolean bool = paramPbGetGroupMsgResp.isWifiHotChat;
        paramInt = 0;
        if (bool)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          HotChatHelper.a(paramString, paramPbGetGroupMsgResp, paramString.getApp().getString(2131693186, new Object[] { paramPbGetGroupMsgResp.name }), true);
          return;
        }
        if (1 != paramPbGetGroupMsgResp.adminLevel)
        {
          paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131693185);
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramPbGetGroupMsgResp.troopUin, 1, 10);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if (((localMessageRecord instanceof MessageForNewGrayTips)) && (localMessageRecord.msg.equals(paramString)))
              {
                NearbyUtils.a("HotChatManager", new Object[] { "onPullRecentGroupMsg", "grayTips exist in last 10 msgs" });
                break label295;
              }
            }
          }
          paramInt = 1;
          label295:
          if (paramInt != 0) {
            HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPbGetGroupMsgResp, paramString, true);
          }
        }
      }
    }
  }
  
  public final void a(List<HotChatInfo> paramList, boolean paramBoolean)
  {
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotChatManager", 2, "onGetJoinedHotChatList,hotchat list = null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "onGetJoinedHotChatList", Integer.valueOf(paramList.size()), Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    a(paramList, paramBoolean, localArrayList);
    paramList = a();
    boolean bool = paramList.getBoolean("qq_update_5.9", true);
    a(paramBoolean, localHashSet, localArrayList, bool, a());
    ((IHotChatApi)QRoute.api(IHotChatApi.class)).invokeRecentUserChangedToConversation(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramList = paramList.edit();
    paramList.putBoolean("HAS_USING_HOTCHAT", this.jdField_a_of_type_JavaUtilMap.isEmpty() ^ true);
    if (bool) {
      paramList.putBoolean("qq_update_5.9", false);
    }
    paramList.commit();
    a(localHashSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    long l = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needReqGlobleAdminFlag, svrTime:");
      localStringBuilder.append(l);
      localStringBuilder.append("|mNextReqGlobleAdminFlagTime:");
      localStringBuilder.append(this.jdField_e_of_type_Long);
      QLog.d("HotChatManager", 2, localStringBuilder.toString());
    }
    return NetConnInfoCenter.getServerTime() > this.jdField_e_of_type_Long;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = (HotChatInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.state == 0) {
        bool1 = true;
      }
    }
    return bool1;
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
  
  public List<HotChatInfo> b()
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
    try
    {
      Map localMap = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localMap == null) {
        return;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
      if (localObject2 == null) {
        return;
      }
      long l = System.currentTimeMillis();
      localObject2 = localMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo = (HotChatInfo.ExitedHotChatInfo)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localExitedHotChatInfo != null)
        {
          Object localObject3 = a(localExitedHotChatInfo.troopUin);
          if ((localObject3 != null) && (((HotChatInfo)localObject3).state == 0))
          {
            ((Iterator)localObject2).remove();
          }
          else if (Math.abs(l - localExitedHotChatInfo.leftTime) >= 604800000L)
          {
            if ((localExitedHotChatInfo.troopUin != null) && (localExitedHotChatInfo.troopUin.length() > 2))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localExitedHotChatInfo.troopUin, 1);
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("clearUnUsableHotChatTable exitedInfo.troopUin isEmpty:");
              ((StringBuilder)localObject3).append(localExitedHotChatInfo.troopUin);
              QLog.d("HotChatManager", 1, ((StringBuilder)localObject3).toString());
            }
            ((Iterator)localObject2).remove();
          }
        }
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMap);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
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
    localObject = new HotChatManager.AddHotChatInfoRunnable(this, (HotChatInfo)localObject);
    ThreadManager.getSubThreadHandler().post((Runnable)localObject);
  }
  
  public void b(HotChatInfo paramHotChatInfo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatManager", new Object[] { "pullRecentGroupMsg", Integer.valueOf(paramInt), paramHotChatInfo.troopUin, paramHotChatInfo.name });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(paramHotChatInfo.troopUin, paramInt);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 1, true, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().i(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "clear hotChat msgCache done");
    }
  }
  
  public boolean b()
  {
    return this.jdField_e_of_type_Boolean;
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
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getWritableDatabase();
    if (localObject != null)
    {
      String str = MessageRecord.getTableName(paramString, 1);
      int i = ((SQLiteDatabase)localObject).getCount(str);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearLimitCountHotChatMsgCache, totalcount=");
        ((StringBuilder)localObject).append(i);
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((i > 250) && (str != null))
      {
        int j = Math.max(i - 200, 50);
        ((TroopMessageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(1)).a(paramString, 1, true, false, str, j);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("clearLimitCountHotChatMsgCache, count=");
          paramString.append(i);
          QLog.d("HotChatManager", 2, paramString.toString());
        }
      }
    }
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
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString = a(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.supportDemo) {
          bool1 = ((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "supportHotChatDemo", Boolean.valueOf(false))).booleanValue();
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isSupportDemo,  bRet = ");
      paramString.append(bool1);
      QLog.i("HotChatManager", 4, paramString.toString());
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/hotchatclassify");
    FileUtils.writeFile(localStringBuilder.toString(), paramString);
    d();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateClassifyInfo, xmldata = ");
      localStringBuilder.append(paramString);
      QLog.i("HotChatManager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean d()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAllowedToSendSplashpic, myUinCharmLevel = ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append(", splashpicCharmRequirement = ");
      localStringBuilder.append(i);
      QLog.i("HotChatManager", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_Int >= i;
  }
  
  public void onDestroy()
  {
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager
 * JD-Core Version:    0.7.0.1
 */