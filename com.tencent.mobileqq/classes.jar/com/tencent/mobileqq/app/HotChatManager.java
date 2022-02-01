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
  static boolean b = false;
  static boolean c = false;
  QQAppInterface d;
  boolean e = false;
  int f = 0;
  Boolean g = null;
  boolean h = false;
  final Map<String, HotChatInfo> i = new ConcurrentHashMap();
  SparseArray<String> j = new SparseArray();
  ConcurrentHashMap<String, String> k = null;
  PttShowRoomMng l;
  public long m = 0L;
  public long n = 20000L;
  public long o = 0L;
  public long p = 20000L;
  List<String> q = null;
  HotChatManager.OnVListUpdateListener r = null;
  volatile boolean s = false;
  private long t = 0L;
  private int u = 0;
  private final Object v = new Object();
  
  @Deprecated
  public HotChatManager() {}
  
  public HotChatManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    l();
    ThreadManager.getFileThreadHandler().post(new HotChatManager.1(this));
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 == 2) {
        return 2130843589;
      }
      if (paramInt1 == 3) {
        return 2130843599;
      }
      return 2130843597;
    }
    return 2130843600;
  }
  
  public static int a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHotChatMng(false);
    if (paramQQAppInterface != null) {
      paramString = paramQQAppInterface.c(paramString);
    } else {
      paramString = null;
    }
    int i2 = 2130843601;
    int i1 = i2;
    if (paramString != null)
    {
      i1 = i2;
      if (!paramString.isWifiHotChat) {
        i1 = a(paramString.hotThemeGroupFlag, 2130843601);
      }
    }
    return i1;
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
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString);
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      i1 = 0;
    }
    paramQQAppInterface = c(paramQQAppInterface).edit();
    paramQQAppInterface.putInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", i1);
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
        paramQQAppInterface = c(paramQQAppInterface);
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
    if (this.e)
    {
      this.e = false;
      Object localObject2 = d();
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
        NearbyFlowerManager.a(this.d).a(paramList);
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
          break label160;
        }
      }
      bool1 = false;
      label160:
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
        localObject2 = this.d.getEntityManagerFactory().createEntityManager();
        ((EntityManager)localObject2).update((Entity)localObject1);
        ((EntityManager)localObject2).close();
        if (paramBoolean2) {
          i(((HotChatInfo)localObject1).troopUin);
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
            i1 = 1;
            break label365;
          }
        }
        int i1 = 0;
        label365:
        if (i1 == 0)
        {
          a(paramArrayList2, HotChatManager.HotChatStateWrapper.wrap(4));
          b(paramArrayList2);
        }
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (!c) {
      c = paramAppInterface.getPreferences().getBoolean("hotchat_auth_flag", paramBoolean);
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("get authFlag:");
      paramAppInterface.append(c);
      QLog.d("Q.hotchat", 2, paramAppInterface.toString());
    }
    return c;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    b = true;
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("doesSupportHotChat:");
      paramQQAppInterface.append(b);
      QLog.d("HotChatManager", 2, paramQQAppInterface.toString());
    }
    return b;
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
  
  public static void b(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update authFlag:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" old:");
      localStringBuilder.append(c);
      QLog.d("Q.hotchat", 2, localStringBuilder.toString());
    }
    if (c == paramBoolean) {
      return;
    }
    paramAppInterface.getPreferences().edit().putBoolean("hotchat_auth_flag", paramBoolean).commit();
    c = paramBoolean;
  }
  
  private void b(HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo == null) {
      return;
    }
    Object localObject2 = (HashMap)e(this.d);
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
    a(this.d, (Map)localObject1);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("NOT_SHOW_WIFI_SHELL", false);
  }
  
  public static SharedPreferences c(QQAppInterface paramQQAppInterface)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config_Before_load_RU");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    return c(paramQQAppInterface).getInt("KEY_SPLASHPIC_CHARM_REQUIREMENT", 3);
  }
  
  public static Map<String, HotChatInfo.ExitedHotChatInfo> e(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    try
    {
      paramQQAppInterface = c(paramQQAppInterface).getString("PREF_KEY_EXITED_HOTCHATINFO", "");
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
  
  private void l()
  {
    boolean bool = h().getBoolean("HAS_USING_HOTCHAT", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hasJoinedHotChat = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool) || (a(this.d)))
    {
      localObject = (ArrayList)this.d.getEntityManagerFactory().createEntityManager().query(HotChatInfo.class, false, null, null, null, null, null, null);
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          HotChatInfo localHotChatInfo = (HotChatInfo)((Iterator)localObject).next();
          if ((localHotChatInfo.state != 5) && (!localHotChatInfo.isWifiHotChat)) {
            this.i.put(localHotChatInfo.troopUin, localHotChatInfo);
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
        ((StringBuilder)localObject).append(this.i.size());
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void m()
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
      int i1 = 0;
      while (i1 < ((NodeList)localObject1).getLength())
      {
        Object localObject3 = (Element)((NodeList)localObject1).item(i1);
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
        i1 += 1;
      }
      this.j = ((SparseArray)localObject2);
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
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setMyUinCharmLevel, charmLevel = ");
      localStringBuilder.append(paramInt);
      QLog.i("HotChatManager", 2, localStringBuilder.toString());
    }
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.t = paramLong;
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
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
      ((INearbyCardManager)this.d.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(paramHotChatInfo.ownerUin);
    }
    paramHotChatInfo.state = 0;
    paramHotChatInfo.ruState = 0;
    this.i.put(paramHotChatInfo.troopUin, paramHotChatInfo);
    Object localObject = this.d.getEntityManagerFactory().createEntityManager();
    ((EntityManager)localObject).persistOrReplace(paramHotChatInfo);
    ((EntityManager)localObject).close();
    NearbyFlowerManager.a(this.d).a(paramHotChatInfo.troopUin);
    b(paramHotChatInfo, paramInt);
    ((IHotChatApi)QRoute.api(IHotChatApi.class)).invokeRecentUserChangedToConversation(this.d);
    paramHotChatInfo = h().edit();
    paramHotChatInfo.putBoolean("HAS_USING_HOTCHAT", this.i.isEmpty() ^ true);
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
      ((INearbyCardManager)this.d.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a(paramHotChatInfo.ownerUin);
      ((IHotChatApi)QRoute.api(IHotChatApi.class)).invokeRecentUserChangedToConversation(this.d);
      int i1 = paramHotChatStateWrapper.targetState;
      paramHotChatInfo.onExit(i1);
      paramHotChatStateWrapper = this.d.getEntityManagerFactory().createEntityManager();
      if ((i1 != 4) && (i1 != 1))
      {
        paramHotChatStateWrapper.update(paramHotChatInfo);
      }
      else
      {
        this.i.remove(paramHotChatInfo.troopUin);
        paramHotChatStateWrapper.remove(paramHotChatInfo);
      }
      paramHotChatStateWrapper.close();
      if ((i1 != 6) && (i1 != 7))
      {
        j(paramHotChatInfo.troopUin);
        b(paramHotChatInfo);
      }
      else if (QLog.isDevelopLevel())
      {
        QLog.d("HotChatManager", 2, "onExitHotChat no need to clear message");
      }
      paramHotChatStateWrapper = h().edit();
      paramHotChatStateWrapper.putBoolean("HAS_USING_HOTCHAT", this.i.isEmpty() ^ true);
      paramHotChatStateWrapper.commit();
      NearbyFlowerManager.a(this.d).b(paramHotChatInfo.troopUin);
      ((HotChatCenterManager)this.d.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(paramHotChatInfo.troopUin, i1);
    }
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
    if (this.q != null)
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
        int i1 = 0;
        while (i1 < paramString1.length())
        {
          paramString2 = paramString1.optString(i1);
          if (!TextUtils.isEmpty(paramString2)) {
            ((List)localObject).add(paramString2);
          }
          i1 += 1;
        }
      }
      this.q.clear();
      this.q.addAll((Collection)localObject);
      paramString1 = this.r;
      if (paramString1 != null) {
        paramString1.a();
      }
    }
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    paramPbGetGroupMsgResp = c(paramString);
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
        paramString = this.d;
        HotChatHelper.a(paramString, paramPbGetGroupMsgResp, paramString.getApp().getString(2131890729), true);
        return;
      }
      if (paramInt == 4)
      {
        boolean bool = paramPbGetGroupMsgResp.isWifiHotChat;
        paramInt = 0;
        if (bool)
        {
          paramString = this.d;
          HotChatHelper.a(paramString, paramPbGetGroupMsgResp, paramString.getApp().getString(2131890726, new Object[] { paramPbGetGroupMsgResp.name }), true);
          return;
        }
        if (1 != paramPbGetGroupMsgResp.adminLevel)
        {
          paramString = this.d.getApp().getString(2131890725);
          localObject = this.d.getMessageFacade().a(paramPbGetGroupMsgResp.troopUin, 1, 10);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
              if (((localMessageRecord instanceof MessageForNewGrayTips)) && (localMessageRecord.msg.equals(paramString)))
              {
                NearbyUtils.a("HotChatManager", new Object[] { "onPullRecentGroupMsg", "grayTips exist in last 10 msgs" });
                break label297;
              }
            }
          }
          paramInt = 1;
          label297:
          if (paramInt != 0) {
            HotChatHelper.a(this.d, paramPbGetGroupMsgResp, paramString, true);
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
      NearbyUtils.a("HotChatManager", new Object[] { "onGetJoinedHotChatList", Integer.valueOf(paramList.size()), Boolean.valueOf(this.e) });
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    a(paramList, paramBoolean, localArrayList);
    paramList = h();
    boolean bool = paramList.getBoolean("qq_update_5.9", true);
    a(paramBoolean, localHashSet, localArrayList, bool, f());
    ((IHotChatApi)QRoute.api(IHotChatApi.class)).invokeRecentUserChangedToConversation(this.d);
    paramList = paramList.edit();
    paramList.putBoolean("HAS_USING_HOTCHAT", this.i.isEmpty() ^ true);
    if (bool) {
      paramList.putBoolean("qq_update_5.9", false);
    }
    paramList.commit();
    a(localHashSet);
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean a()
  {
    long l1 = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("needReqGlobleAdminFlag, svrTime:");
      localStringBuilder.append(l1);
      localStringBuilder.append("|mNextReqGlobleAdminFlagTime:");
      localStringBuilder.append(this.t);
      QLog.d("HotChatManager", 2, localStringBuilder.toString());
    }
    return NetConnInfoCenter.getServerTime() > this.t;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    paramString = (HotChatInfo)this.i.get(paramString);
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
  
  public PttShowRoomMng b(boolean paramBoolean)
  {
    if ((this.l == null) && (paramBoolean)) {
      this.l = new PttShowRoomMng(this.d);
    }
    return this.l;
  }
  
  public void b(long paramLong)
  {
    if (this.i.get(String.valueOf(paramLong)) != null)
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
    this.d.getMessageFacade().m(paramHotChatInfo.troopUin, paramInt);
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.i.containsKey(paramString);
  }
  
  public HotChatInfo c(String paramString)
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
    return (HotChatInfo)this.i.get(paramString);
  }
  
  public List<HotChatInfo> c()
  {
    ArrayList localArrayList1 = new ArrayList(this.i.values());
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.addAll(localArrayList1);
    return localArrayList2;
  }
  
  public HotChatInfo d(String paramString)
  {
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if (localHotChatInfo.uuid.equals(paramString)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public List<HotChatInfo> d()
  {
    Object localObject = new ArrayList(this.i.values());
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
  
  public HotChatInfo e(String paramString)
  {
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((localHotChatInfo != null) && (TextUtils.equals(localHotChatInfo.troopCode, paramString))) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public boolean e()
  {
    SharedPreferences localSharedPreferences = this.d.getPreferences();
    boolean bool = localSharedPreferences.getBoolean("qbhc_show_wifi_shell_setting", true);
    if (bool) {
      localSharedPreferences.edit().putBoolean("qbhc_show_wifi_shell_setting", false).commit();
    }
    return bool;
  }
  
  public String f(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      if (this.k == null) {
        this.k = new ConcurrentHashMap();
      }
      if (this.k.containsKey(paramString)) {
        return (String)this.k.get(paramString);
      }
      if (this.k != null)
      {
        Iterator localIterator = this.i.values().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (HotChatInfo)localIterator.next();
          if ((localObject != null) && (((HotChatInfo)localObject).troopCode != null) && (((HotChatInfo)localObject).troopCode.equals(paramString)))
          {
            localObject = ((HotChatInfo)localObject).troopUin;
            if ((localObject != null) && (((String)localObject).length() > 0))
            {
              this.k.put(paramString, localObject);
              return localObject;
            }
          }
        }
      }
    }
    return null;
  }
  
  public ArrayList<HotChatInfo> f()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.state == 0)) {
        localArrayList.add(localHotChatInfo);
      }
    }
    return localArrayList;
  }
  
  public HotChatInfo g()
  {
    Iterator localIterator = this.i.values().iterator();
    while (localIterator.hasNext())
    {
      HotChatInfo localHotChatInfo = (HotChatInfo)localIterator.next();
      if ((!localHotChatInfo.isWifiHotChat) && (localHotChatInfo.userCreate == 0) && (localHotChatInfo.state == 0)) {
        return localHotChatInfo;
      }
    }
    return null;
  }
  
  public void g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = c(paramString);
    if (paramString == null) {
      return;
    }
    EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
    paramString.ruState = 1;
    localEntityManager.update(paramString);
    localEntityManager.close();
  }
  
  public SharedPreferences h()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Config_Before_load_RU");
    localStringBuilder.append(this.d.getCurrentAccountUin());
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public boolean h(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString = c(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.supportDemo) {
          bool1 = ((Boolean)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.d.getAccount(), "supportHotChatDemo", Boolean.valueOf(false))).booleanValue();
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
  
  public void i()
  {
    if (this.f <= 0) {
      ThreadManager.post(new HotChatManager.2(this), 10, null, false);
    }
  }
  
  public void i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.getMessageFacade().b(paramString, 1, true, false);
    this.d.getMsgCache().U(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("HotChatManager", 2, "clear hotChat msgCache done");
    }
  }
  
  public void j(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.d.getWritableDatabase();
    if (localObject != null)
    {
      String str = MessageRecord.getTableName(paramString, 1);
      int i1 = ((SQLiteDatabase)localObject).getCount(str);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearLimitCountHotChatMsgCache, totalcount=");
        ((StringBuilder)localObject).append(i1);
        QLog.d("HotChatManager", 2, ((StringBuilder)localObject).toString());
      }
      if ((i1 > 250) && (str != null))
      {
        int i2 = Math.max(i1 - 200, 50);
        ((TroopMessageManager)this.d.getMessageFacade().a(1)).a(paramString, 1, true, false, str, i2);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("clearLimitCountHotChatMsgCache, count=");
          paramString.append(i1);
          QLog.d("HotChatManager", 2, paramString.toString());
        }
      }
    }
  }
  
  public boolean j()
  {
    int i1 = d(this.d);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isAllowedToSendSplashpic, myUinCharmLevel = ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", splashpicCharmRequirement = ");
      localStringBuilder.append(i1);
      QLog.i("HotChatManager", 2, localStringBuilder.toString());
    }
    return this.f >= i1;
  }
  
  public void k()
  {
    try
    {
      Map localMap = e(this.d);
      if (localMap == null) {
        return;
      }
      Object localObject2 = this.d.getWritableDatabase();
      if (localObject2 == null) {
        return;
      }
      long l1 = System.currentTimeMillis();
      localObject2 = localMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        HotChatInfo.ExitedHotChatInfo localExitedHotChatInfo = (HotChatInfo.ExitedHotChatInfo)((Map.Entry)((Iterator)localObject2).next()).getValue();
        if (localExitedHotChatInfo != null)
        {
          Object localObject3 = c(localExitedHotChatInfo.troopUin);
          if ((localObject3 != null) && (((HotChatInfo)localObject3).state == 0))
          {
            ((Iterator)localObject2).remove();
          }
          else if (Math.abs(l1 - localExitedHotChatInfo.leftTime) >= 604800000L)
          {
            if ((localExitedHotChatInfo.troopUin != null) && (localExitedHotChatInfo.troopUin.length() > 2))
            {
              this.d.getMessageFacade().c(localExitedHotChatInfo.troopUin, 1);
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
      a(this.d, localMap);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void k(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/hotchatclassify");
    FileUtils.writeFile(localStringBuilder.toString(), paramString);
    m();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateClassifyInfo, xmldata = ");
      localStringBuilder.append(paramString);
      QLog.i("HotChatManager", 2, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    b = false;
    c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatManager
 * JD-Core Version:    0.7.0.1
 */