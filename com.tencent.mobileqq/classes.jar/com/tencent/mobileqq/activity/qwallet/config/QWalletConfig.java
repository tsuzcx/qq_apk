package com.tencent.mobileqq.activity.qwallet.config;

import Wallet.RspWalletConfig;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import xii;

public class QWalletConfig
  implements Serializable
{
  public static final int OCCASION_DEFAULT = 0;
  public static final int OCCASION_FOREGROUND = 4;
  public static final int OCCASION_FOREGROUND_WAIT = 1024;
  public static final int OCCASION_INVALID = -1;
  public static final int OCCASION_LOGIN = 1;
  public static final int OCCASION_LOGIN_WAIT = 256;
  public static final int OCCASION_PUSH = 0;
  public static final int OCCASION_RECONNECT = 2;
  public static final int OCCASION_RECONNECT_WAIT = 512;
  public static final int REQ_TYPE_ALL = 0;
  public static final long REQ_TYPE_GOLDMSG = 1L;
  private static final long serialVersionUID = 1L;
  private transient int jdField_a_of_type_Int;
  private transient String jdField_a_of_type_JavaLangString;
  private transient Map jdField_a_of_type_JavaUtilMap;
  private transient byte[] jdField_a_of_type_ArrayOfByte;
  private int action;
  private transient String jdField_b_of_type_JavaLangString;
  private transient Map jdField_b_of_type_JavaUtilMap;
  private transient byte[] jdField_b_of_type_ArrayOfByte;
  public String commonMsg;
  public Map configs = new HashMap();
  public long lastReqTime;
  private Map lastReqTimes = new HashMap();
  private Map localVersions = new HashMap();
  public int refreshTime;
  private Map refreshTimes = new HashMap();
  public int refreshType;
  public long seriesNo;
  
  private static String a(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppRuntime.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/QWallet/").append(paramAppRuntime.getAccount()).append("/.config/");
    localStringBuilder.append(".config");
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong)
  {
    this.lastReqTime = paramLong;
    Iterator localIterator = this.lastReqTimes.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.lastReqTimes.put(localEntry.getKey(), Long.valueOf(paramLong));
    }
  }
  
  private void a(long paramLong1, long paramLong2, RspWalletConfig paramRspWalletConfig)
  {
    long l2 = 1L;
    long l1 = paramLong2;
    paramLong2 = l2;
    while (l1 != 0L) {
      if ((paramLong2 & l1) != 0L)
      {
        this.lastReqTimes.put(Long.valueOf(paramLong2), Long.valueOf(paramLong1));
        this.refreshTimes.put(Long.valueOf(paramLong2), Integer.valueOf(paramRspWalletConfig.refreshTime));
        l1 &= (0xFFFFFFFF ^ paramLong2);
        paramLong2 <<= 1;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ArrayOfByte = new byte[0];
    this.jdField_b_of_type_ArrayOfByte = new byte[0];
    if (this.localVersions == null) {
      this.localVersions = new HashMap();
    }
  }
  
  private void a(Map paramMap, boolean paramBoolean, long paramLong)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = this.jdField_b_of_type_ArrayOfByte;
    Iterator localIterator;
    Object localObject2;
    if (paramBoolean)
    {
      if (paramMap != null)
      {
        try
        {
          localIterator = this.configs.entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (Map.Entry)localIterator.next();
            if (!paramMap.containsKey(((Map.Entry)localObject2).getKey())) {
              localLinkedList.add(((Map.Entry)localObject2).getKey());
            }
          }
          localIterator = localLinkedList.iterator();
        }
        finally {}
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          this.localVersions.put(localObject2, Long.valueOf(paramLong));
        }
      }
      this.configs.clear();
    }
    if (paramMap != null)
    {
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (Map.Entry)localIterator.next();
        this.configs.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
        this.localVersions.put(((Map.Entry)localObject2).getKey(), Long.valueOf(paramLong));
      }
    }
    localObject1 = paramMap;
    if (paramBoolean)
    {
      localObject1 = paramMap;
      if (localLinkedList.size() > 0)
      {
        localObject1 = new HashMap(paramMap);
        paramMap = localLinkedList.iterator();
        while (paramMap.hasNext()) {
          ((Map)localObject1).put((String)paramMap.next(), null);
        }
      }
    }
    b((Map)localObject1, paramBoolean, paramLong);
  }
  
  private void b(Map paramMap, boolean paramBoolean, long paramLong)
  {
    Iterator localIterator;
    Map.Entry localEntry;
    if (paramMap != null)
    {
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        QWalletConfigHandler.a(this.jdField_b_of_type_JavaLangString, (String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if (!paramBoolean) {
        break label89;
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    for (;;)
    {
      notifyUpdateListeners(paramMap, paramLong);
      return;
      label89:
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        this.jdField_b_of_type_JavaUtilMap.remove(localEntry.getKey());
      }
    }
  }
  
  public static QWalletConfig readConfig(QQAppInterface paramQQAppInterface)
  {
    String str = a(paramQQAppInterface);
    try
    {
      QWalletConfig localQWalletConfig1 = (QWalletConfig)QWalletTools.a(str);
      QWalletConfig localQWalletConfig2 = localQWalletConfig1;
      if (localQWalletConfig1 == null) {
        localQWalletConfig2 = new QWalletConfig();
      }
      localQWalletConfig2.a(paramQQAppInterface, str);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfig", 2, "readQWalletConfig:" + localQWalletConfig2);
      }
      return localQWalletConfig2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void addUpdateListener(String paramString, QWalletConfigManager.ConfigUpdateListener paramConfigUpdateListener)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramConfigUpdateListener != null))
      {
        List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        }
        if (!((List)localObject).contains(paramConfigUpdateListener)) {
          ((List)localObject).add(paramConfigUpdateListener);
        }
      }
      return;
    }
  }
  
  public String getConfig(String paramString)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      paramString = (String)this.configs.get(paramString);
      return paramString;
    }
  }
  
  public QWalletConfig.ConfigInfo getConfigInfo(String paramString)
  {
    QWalletConfig.ConfigInfo localConfigInfo = new QWalletConfig.ConfigInfo();
    localConfigInfo.jdField_a_of_type_JavaLangString = paramString;
    for (;;)
    {
      synchronized (this.jdField_b_of_type_ArrayOfByte)
      {
        localConfigInfo.jdField_b_of_type_JavaLangString = getConfig(paramString);
        paramString = (Long)this.localVersions.get(paramString);
        if (paramString != null)
        {
          l = paramString.longValue();
          localConfigInfo.jdField_a_of_type_Long = l;
          return localConfigInfo;
        }
      }
      long l = 0L;
    }
  }
  
  public Object getParsedConfig(String paramString)
  {
    JSONArray localJSONArray = null;
    String str = getConfig(paramString);
    paramString = localJSONArray;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      paramString = new JSONObject(str);
      if (paramString != null) {}
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        try
        {
          localJSONArray = new JSONArray(str);
          paramString = localJSONArray;
          return paramString;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString;
  }
  
  public int getValidReqOcca(int paramInt)
  {
    int i = paramInt;
    if (this.refreshType != 0)
    {
      i = paramInt;
      if (this.action != 3)
      {
        if (NetConnInfoCenter.getServerTimeMillis() - this.lastReqTime < this.refreshTime * 1000) {
          break label76;
        }
        i = 1;
        switch (paramInt)
        {
        }
      }
    }
    label76:
    do
    {
      do
      {
        do
        {
          i = -1;
          return i;
          i = 0;
          break;
          if ((this.refreshType & 0x1) != 0) {
            return 1;
          }
        } while ((i == 0) || ((this.refreshType & 0x100) == 0));
        return 256;
        if ((this.refreshType & 0x2) != 0) {
          return 2;
        }
      } while ((i == 0) || ((this.refreshType & 0x200) == 0));
      return 512;
      if ((this.refreshType & 0x4) != 0) {
        return 4;
      }
    } while ((i == 0) || ((this.refreshType & 0x400) == 0));
    return 1024;
  }
  
  public void handleRsp(RspWalletConfig paramRspWalletConfig, long paramLong, QWalletConfigManager.ConfigListener paramConfigListener, QWalletConfigManager paramQWalletConfigManager)
  {
    if ((paramRspWalletConfig == null) || (paramRspWalletConfig.result != RspWalletConfig.RET_SUCC)) {
      return;
    }
    int i;
    long l;
    if (paramRspWalletConfig.refreshTime > 86400)
    {
      i = 86400;
      paramRspWalletConfig.refreshTime = i;
      l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLong != 0L) {
        break label344;
      }
      a(l);
      this.action = paramRspWalletConfig.action;
      if (paramRspWalletConfig.action != 1) {
        break label128;
      }
      label69:
      if (paramRspWalletConfig.action != 3) {
        this.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfig", 2, "after update|" + this);
      }
      saveConfig();
      return;
      i = paramRspWalletConfig.refreshTime;
      break;
      label128:
      if (paramRspWalletConfig.action == 0)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, true, l);
        break label69;
      }
      if (paramRspWalletConfig.action == 2)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, false, l);
        break label69;
      }
      if (paramRspWalletConfig.action != 3) {
        break label69;
      }
      if (this.seriesNo == paramRspWalletConfig.seriesNo) {}
      for (i = 1;; i = 0)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, false, l);
        if ((paramQWalletConfigManager == null) || (i != 0) || (this.jdField_a_of_type_Int >= 100)) {
          break;
        }
        paramQWalletConfigManager.a();
        this.jdField_a_of_type_Int += 1;
        break;
      }
      label344:
      a(l, paramLong, paramRspWalletConfig);
      a(paramRspWalletConfig.mConfig, false, l);
      notifyListener(paramConfigListener);
    }
  }
  
  public boolean isValidToReq(long paramLong)
  {
    boolean bool = false;
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = 1L;
    long l1 = paramLong;
    paramLong = l2;
    for (;;)
    {
      if (l1 != 0L) {
        if ((paramLong & l1) != 0L) {
          if (this.lastReqTimes.containsKey(Long.valueOf(paramLong)))
          {
            l2 = ((Long)this.lastReqTimes.get(Long.valueOf(paramLong))).longValue();
            if (!this.refreshTimes.containsKey(Long.valueOf(paramLong))) {
              break label185;
            }
            i = ((Integer)this.refreshTimes.get(Long.valueOf(paramLong))).intValue();
            if (Math.abs(l3 - Long.valueOf(l2).longValue()) < i * 1000) {
              break label190;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QWalletConfig", 2, "isValidToReq true when" + l1 + "|" + paramLong);
            }
            bool = true;
          }
        }
      }
    }
    label185:
    label190:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return bool;
        l2 = 0L;
        continue;
        int i = 0;
      }
      l1 &= (0xFFFFFFFF ^ paramLong);
      paramLong <<= 1;
      break;
    }
    QLog.d("QWalletConfig", 2, "isValidToReq false" + l1);
    return false;
  }
  
  public void notifyListener(QWalletConfigManager.ConfigListener paramConfigListener)
  {
    if (paramConfigListener != null) {}
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      HashMap localHashMap = new HashMap(this.configs);
      paramConfigListener.a(this.jdField_b_of_type_JavaLangString, localHashMap);
      return;
    }
  }
  
  public void notifyUpdateListeners(Map paramMap, long paramLong)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        if (!TextUtils.isEmpty(str))
        {
          Object localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            if (((Iterator)localObject2).hasNext()) {
              ((QWalletConfigManager.ConfigUpdateListener)((Iterator)localObject2).next()).a(str, (String)localObject1, new QWalletConfig.ConfigInfo(str, (String)localObject1, paramLong));
            }
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void removeUpdateListener(String paramString, QWalletConfigManager.ConfigUpdateListener paramConfigUpdateListener)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramConfigUpdateListener != null))
      {
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (paramString != null) {
          paramString.remove(paramConfigUpdateListener);
        }
      }
      return;
    }
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new xii(this));
  }
  
  public String toString()
  {
    return "QWalletConfig{seriesNo=" + this.seriesNo + ", refreshType=" + this.refreshType + ", refreshTime=" + this.refreshTime + ", lastReqTime=" + this.lastReqTime + ", commonMsg='" + this.commonMsg + '\'' + ", configs=" + this.configs + ", refreshTimes=" + this.refreshTimes + ", lastReqTimes=" + this.lastReqTimes + ", mSavePath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mCurUin='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfig
 * JD-Core Version:    0.7.0.1
 */