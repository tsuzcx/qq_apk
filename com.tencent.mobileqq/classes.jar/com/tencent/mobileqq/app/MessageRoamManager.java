package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageRoamManager
  implements Manager
{
  int jdField_a_of_type_Int = 2001;
  long jdField_a_of_type_Long = 0L;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  RoamDateCache jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
  MessageRoamHandler jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler;
  public MessageRecord a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new MessageRoamManager.11(this);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  String jdField_a_of_type_JavaLangString;
  ArrayList<MessageRoamManager.MessageRoamListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  Calendar jdField_a_of_type_JavaUtilCalendar;
  public HashMap<Calendar, RoamMessagePreloadInfo> a;
  List<Long> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int = -1;
  Calendar jdField_b_of_type_JavaUtilCalendar;
  public volatile boolean b;
  int jdField_c_of_type_Int = -1;
  Calendar jdField_c_of_type_JavaUtilCalendar;
  public volatile boolean c;
  public Calendar d;
  Calendar e;
  Calendar f;
  Calendar g;
  private Calendar h = null;
  
  public MessageRoamManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler = ((MessageRoamHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache = ((RoamDateCache)paramQQAppInterface.getCacheManager().getCache(2));
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).getString("vip_message_roam_passwordmd5" + paramQQAppInterface.getCurrentAccountUin(), null);
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = Base64.decode(paramQQAppInterface, 0);; paramQQAppInterface = null)
    {
      this.jdField_a_of_type_ArrayOfByte = paramQQAppInterface;
      return;
    }
  }
  
  private long a(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      throw new IllegalArgumentException("date is null!");
    }
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    return paramCalendar.getTimeInMillis();
  }
  
  private String a(Calendar paramCalendar)
  {
    if (paramCalendar == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(12);
    localStringBuilder.append(paramCalendar.get(1)).append("-").append(paramCalendar.get(2) + 1).append("-").append(paramCalendar.get(5));
    return localStringBuilder.toString();
  }
  
  private List<MessageRecord> a(String paramString1, String paramString2, String paramString3)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase();
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "rawQuery db = null!");
      }
      return null;
    }
    paramString1 = MessageDBUtils.a(paramString2, paramString1, localSQLiteDatabase, paramString3, null);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "sqlStr db = null!");
      }
      return null;
    }
    return ((MessageRecordEntityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().a()).a(paramString1.toString(), null);
  }
  
  private void a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    b(localCalendar);
    a(localCalendar);
  }
  
  private void a(List<MessageRecord> paramList1, Pair<Long, Long> paramPair, List<MessageRecord> paramList2, String paramString, long paramLong)
  {
    if (((MessageRecord)paramList1.get(paramList1.size() - 1)).time <= ((Long)paramPair.second).longValue())
    {
      if ((paramList2 != null) && (paramList2.size() == paramList1.size()))
      {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label160;
        }
      }
      label160:
      for (paramList1 = this.jdField_a_of_type_JavaLangString;; paramList1 = paramString)
      {
        paramPair.a(paramList1, paramLong - 5L, 1);
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString != null) {
          paramString = this.jdField_a_of_type_JavaLangString;
        }
        paramList1.b(paramString, paramLong - 5L, 0);
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "judgeClearRoamDateIndex: " + paramLong });
        if (this.jdField_a_of_type_JavaLangString != null) {
          b(paramLong);
        }
        return;
      }
    }
    int j = 0;
    int i = paramList1.size();
    Iterator localIterator = paramList1.iterator();
    label185:
    if (localIterator.hasNext())
    {
      if (((MessageRecord)localIterator.next()).time > ((Long)paramPair.second).longValue()) {
        break label666;
      }
      j += 1;
      i -= 1;
    }
    label269:
    label660:
    label666:
    for (;;)
    {
      break label185;
      if ((paramList2 != null) && (paramList2.size() == j))
      {
        paramList2 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label621;
        }
        paramPair = this.jdField_a_of_type_JavaLangString;
        paramList2.a(paramPair, paramLong - 5L, 1);
        paramList2 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label627;
        }
        paramPair = this.jdField_a_of_type_JavaLangString;
        label298:
        paramList2.b(paramPair, paramLong - 5L, 0);
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "judgeClearRoamDateIndex: " + paramLong });
        if (this.jdField_a_of_type_JavaLangString != null) {
          b(paramLong);
        }
      }
      paramLong = ((MessageRecord)paramList1.get(paramList1.size() - 1)).time;
      paramList1 = Calendar.getInstance();
      paramList1.setTimeInMillis(1000L * paramLong);
      paramPair = a(paramList1);
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramList1 = this.jdField_a_of_type_JavaLangString;
        label410:
        paramPair = a(paramList1, ((Long)paramPair.first).longValue(), ((Long)paramPair.second).longValue());
        paramList2 = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
        if (this.jdField_a_of_type_JavaLangString != null) {
          break label639;
        }
        paramList1 = paramString;
        label460:
        paramList2 = paramList2.append(paramList1).append(", tomorrowList.size() = ");
        if (paramPair != null) {
          break label647;
        }
        paramList1 = "null";
        label479:
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { paramList1 });
        if ((paramPair == null) || (paramPair.size() != i)) {
          break;
        }
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label660;
        }
      }
      for (paramList1 = this.jdField_a_of_type_JavaLangString;; paramList1 = paramString)
      {
        paramPair.a(paramList1, paramLong - 5L, 1);
        paramList1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString != null) {
          paramString = this.jdField_a_of_type_JavaLangString;
        }
        paramList1.b(paramString, paramLong - 5L, 0);
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "judgeClearRoamDateIndex: " + paramLong });
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        b(paramLong);
        return;
        label621:
        paramPair = paramString;
        break label269;
        label627:
        paramPair = paramString;
        break label298;
        paramList1 = paramString;
        break label410;
        label639:
        paramList1 = this.jdField_a_of_type_JavaLangString;
        break label460;
        paramList1 = Integer.valueOf(paramPair.size());
        break label479;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      ThreadManager.getSubThreadHandler().post(new MessageRoamManager.3(this, paramInt));
      return;
    }
    a(0, null);
  }
  
  private boolean a(Calendar paramCalendar)
  {
    int i = paramCalendar.get(1);
    int j = paramCalendar.get(2);
    int k = paramCalendar.get(5);
    paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, i, j + 1);
    return (paramCalendar == null) || (paramCalendar.getSerState(k - 1) == 0) || (paramCalendar.getSerState(k - 1) == 1);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    paramJSONObject = paramJSONObject.getString("lastNumber");
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramJSONObject))
    {
      bool1 = bool2;
      if (paramJSONObject.length() > 2)
      {
        paramJSONObject = paramJSONObject.substring(1, paramJSONObject.length() - 1);
        ArrayList localArrayList = new ArrayList(10);
        Object localObject = paramJSONObject.split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localArrayList.add(localObject[i]);
          i += 1;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!localArrayList.contains(((String)localObject).substring(((String)localObject).length() - 1, ((String)localObject).length())))) {
          break label189;
        }
      }
    }
    label189:
    for (bool1 = true;; bool1 = false)
    {
      Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg Field[lastNumber]: " + paramJSONObject + ", matchLastNumber: " + bool1 });
      return bool1;
    }
  }
  
  private void b(int paramInt, Calendar paramCalendar, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    Object localObject;
    RoamMessagePreloadInfo localRoamMessagePreloadInfo;
    if (paramInt == 1)
    {
      localObject = this.jdField_a_of_type_JavaUtilCalendar;
      localRoamMessagePreloadInfo = null;
    }
    for (;;)
    {
      if (localObject != null) {
        a((Calendar)localObject, null, paramBoolean1, paramBoolean2);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory end");
        }
        return;
        if (paramInt == 0)
        {
          localObject = this.jdField_c_of_type_JavaUtilCalendar;
          localRoamMessagePreloadInfo = null;
          break;
        }
        if (paramCalendar != null)
        {
          localRoamMessagePreloadInfo = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, paramCalendar, 0);
          localObject = null;
          break;
        }
        if ((paramInt == 3) && (this.jdField_a_of_type_JavaUtilCalendar != null))
        {
          localRoamMessagePreloadInfo = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilCalendar, 2);
          localObject = null;
          break;
        }
        if ((paramInt != 2) || (this.jdField_a_of_type_JavaUtilCalendar == null)) {
          break label264;
        }
        localRoamMessagePreloadInfo = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilCalendar, 1);
        localObject = null;
        break;
        if ((localRoamMessagePreloadInfo == null) || (localRoamMessagePreloadInfo.curday == null)) {
          break label191;
        }
        a(localRoamMessagePreloadInfo.curday, localRoamMessagePreloadInfo, paramBoolean1, paramBoolean2);
      }
      label191:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("getRoamHistory: null roamFrom: ").append(paramInt).append("info==null:");
        if (localRoamMessagePreloadInfo != null) {
          break label259;
        }
      }
      label259:
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        QLog.d("Q.roammsg.MessageRoamManager", 2, paramBoolean1);
        if (paramCalendar == null) {
          break;
        }
        a(33, paramCalendar);
        break;
      }
      label264:
      localRoamMessagePreloadInfo = null;
      localObject = null;
    }
  }
  
  private void b(long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean) {
      if (a(paramLong - 5L, this.jdField_b_of_type_JavaUtilCalendar))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar, null);
        if (localObject != null)
        {
          this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)localObject);
          if (this.jdField_a_of_type_JavaLangString != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putLong("first_page_date" + this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis()).commit();
            localObject = new StringBuilder(50);
            ((StringBuilder)localObject).append("judgeUpdateFirstLastPageDate firstPage=").append(a(this.jdField_b_of_type_JavaUtilCalendar));
            ((StringBuilder)localObject).append(" first=").append(this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
            QLog.d("Q.roammsg.MessageRoamManager", 1, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    label180:
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
              break label180;
              break label180;
              break label180;
              do
              {
                return;
              } while (!a(paramLong - 5L, this.jdField_c_of_type_JavaUtilCalendar));
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaUtilCalendar, null);
            } while (localObject == null);
            this.jdField_c_of_type_JavaUtilCalendar = ((Calendar)localObject);
          } while (this.jdField_a_of_type_JavaLangString == null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putLong("last_page_date" + this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis()).commit();
          localObject = new StringBuilder(50);
          ((StringBuilder)localObject).append("judgeUpdateFirstLastPageDate lastPage=").append(a(this.jdField_c_of_type_JavaUtilCalendar));
          ((StringBuilder)localObject).append(" last=").append(this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
          QLog.d("Q.roammsg.MessageRoamManager", 1, ((StringBuilder)localObject).toString());
          return;
          if (!a(paramLong - 5L, this.f)) {
            break;
          }
          i = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.f)));
        } while ((i == -1) || (i >= this.jdField_a_of_type_JavaUtilList.size() - 1));
        this.f.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(i + 1)).longValue());
        return;
      } while (!a(paramLong - 5L, this.g));
      i = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.g)));
    } while (i <= 0);
    this.g.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(i - 1)).longValue());
  }
  
  private boolean b(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = a((Calendar)paramCalendar.clone());
    return (paramLong >= ((Long)paramCalendar.first).longValue()) && (paramLong <= ((Long)paramCalendar.second).longValue());
  }
  
  private boolean b(Calendar paramCalendar)
  {
    Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(this.jdField_a_of_type_JavaLangString);
    if (localPair == null) {
      return false;
    }
    long l = ((Long)localPair.first).longValue();
    localPair = a((Calendar)paramCalendar.clone());
    if ((l > ((Long)localPair.first).longValue()) && (l <= ((Long)localPair.second).longValue()))
    {
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, i, j + 1);
      if (paramCalendar != null)
      {
        paramCalendar.setLocState(k - 1, 0);
        this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramCalendar);
      }
      return true;
    }
    return false;
  }
  
  private boolean b(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.getString("userType");
    paramJSONObject = str1;
    boolean bool;
    if (!TextUtils.isEmpty(str1))
    {
      paramJSONObject = str1;
      if (str1.length() > 2)
      {
        str1 = str1.substring(1, str1.length() - 1);
        paramJSONObject = str1.split(",");
        ArrayList localArrayList = new ArrayList();
        int j = paramJSONObject.length;
        int i = 0;
        if (i < j)
        {
          str2 = paramJSONObject[i];
          if (str2.equalsIgnoreCase("svip")) {
            localArrayList.add("2");
          }
          for (;;)
          {
            i += 1;
            break;
            if (str2.equalsIgnoreCase("vip")) {
              localArrayList.add("1");
            } else if (str2.equalsIgnoreCase("normal")) {
              localArrayList.add("0");
            }
          }
        }
        String str2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (!localArrayList.contains("0"))
        {
          paramJSONObject = str1;
          if (!localArrayList.contains(str2)) {}
        }
        else
        {
          bool = true;
          paramJSONObject = str1;
        }
      }
    }
    for (;;)
    {
      Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg Field[userType]: " + paramJSONObject });
      return bool;
      bool = false;
    }
  }
  
  private boolean m()
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine error : mFriendUin == null");
      }
      return false;
    }
    Object localObject2 = a();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        break label92;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.roammsg.MessageRoamManager", 2, "createLocMsgDateLine fasle");
      return false;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    label92:
    Object localObject1 = Calendar.getInstance();
    localObject2 = ((List)localObject2).iterator();
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      ((Calendar)localObject1).setTimeInMillis(((MessageRecord)((Iterator)localObject2).next()).time * 1000L);
      ((Calendar)localObject1).set(11, 0);
      ((Calendar)localObject1).set(12, 0);
      ((Calendar)localObject1).set(13, 0);
      ((Calendar)localObject1).set(14, 0);
      l = ((Calendar)localObject1).getTimeInMillis();
      if (!this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(l))) {
        this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
      }
    }
    if (this.g == null)
    {
      this.g = Calendar.getInstance();
      this.g.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).longValue());
    }
    for (localObject1 = this.g.get(1) + "-" + (this.g.get(2) + 1) + "-" + this.g.get(5);; localObject1 = "")
    {
      if (this.f == null)
      {
        this.f = Calendar.getInstance();
        this.f.setTimeInMillis(((Long)this.jdField_a_of_type_JavaUtilList.get(0)).longValue());
      }
      for (localObject2 = this.f.get(1) + "-" + (this.f.get(2) + 1) + "-" + this.f.get(5);; localObject2 = "")
      {
        if (this.e == null)
        {
          this.e = Calendar.getInstance();
          this.e.setTimeInMillis(this.g.getTimeInMillis());
        }
        if ((this.f != null) && (this.g != null))
        {
          l = (this.g.getTimeInMillis() - this.f.getTimeInMillis()) / 86400000L;
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "local_timeline", 0, 0, new String[] { l + "", "0", localObject2, localObject1 });
        }
        return true;
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  private void s()
  {
    ThreadManager.getSubThreadHandler().post(new MessageRoamManager.9(this));
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(String paramString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return 0;
    }
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getReadableDatabase();
    if (localSQLiteDatabase == null) {
      return 0;
    }
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder(" msgtype ");
      localStringBuilder.append(UinTypeUtil.a());
      localStringBuilder.append(" and isValid=1 ");
    }
    for (paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, "", localStringBuilder.toString(), ""); paramString == null; paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), localSQLiteDatabase, localStringBuilder.toString()))
    {
      return 0;
      localStringBuilder = new StringBuilder(" where msgtype ");
      localStringBuilder.append(UinTypeUtil.a());
      localStringBuilder.append(" and isValid=1 ");
    }
    paramString = localSQLiteDatabase.rawQuery(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    long l;
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      if (paramInt != 3000) {
        break label239;
      }
      l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
    }
    for (;;)
    {
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
      paramInt = paramString.getCount();
      paramString.close();
      return paramInt;
      label239:
      if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
    }
  }
  
  public int a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    paramString = a(MessageRecord.getTableName(paramString, 0), null, "( msgtype " + UinTypeUtil.a() + " and isValid=1 and " + str + " ) " + "ORDER BY time asc , longMsgIndex asc", paramLong1, paramLong2);
    if (paramString == null) {
      return 0;
    }
    return paramString.size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Bundle a(Calendar paramCalendar)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    int m;
    int n;
    int i1;
    int i;
    if (!localList.isEmpty())
    {
      m = paramCalendar.get(1);
      n = paramCalendar.get(2) + 1;
      i1 = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, m, n);
      i = 0;
      if (i >= localList.size()) {
        break label381;
      }
      if (!((String)((Map.Entry)localList.get(i)).getKey()).equals(paramCalendar)) {}
    }
    label372:
    label381:
    for (;;)
    {
      if (i < localList.size())
      {
        paramCalendar = (RoamDate)((Map.Entry)localList.get(i)).getValue();
        String str = (String)((Map.Entry)localList.get(i)).getKey();
        str = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(str)[1];
        int i2 = Integer.valueOf(str.split("-")[0]).intValue();
        int i3 = Integer.valueOf(str.split("-")[1]).intValue();
        int k = 1;
        int j = k;
        if (m == i2)
        {
          j = k;
          if (n == i3) {
            j = i1 + 1;
          }
        }
        for (;;)
        {
          if (j > RoamDate.getDays(i2, i3)) {
            break label372;
          }
          if (paramCalendar.getLocState(j - 1) == 3)
          {
            paramCalendar = new Bundle();
            paramCalendar.putString("MSG_TYPE", "local");
            paramCalendar.putInt("DATE_YEAR", i2);
            paramCalendar.putInt("DATE_MONTH", i3);
            paramCalendar.putInt("DATE_DAY", j);
            return paramCalendar;
            i += 1;
            break;
          }
          if ((paramCalendar.getSerState(j - 1) == 2) && (NetworkUtil.d(BaseApplication.getContext())))
          {
            paramCalendar = new Bundle();
            paramCalendar.putString("MSG_TYPE", "server");
            paramCalendar.putInt("DATE_YEAR", i2);
            paramCalendar.putInt("DATE_MONTH", i3);
            paramCalendar.putInt("DATE_DAY", j);
            return paramCalendar;
          }
          j += 1;
        }
        i += 1;
      }
      else
      {
        return null;
      }
    }
  }
  
  public Pair<Long, Long> a(Calendar paramCalendar)
  {
    paramCalendar.set(11, 0);
    paramCalendar.set(12, 0);
    paramCalendar.set(13, 0);
    paramCalendar.set(14, 0);
    long l = paramCalendar.getTimeInMillis() / 1000L;
    paramCalendar.set(11, 23);
    paramCalendar.set(12, 59);
    paramCalendar.set(13, 59);
    paramCalendar.set(14, 0);
    return new Pair(Long.valueOf(l), Long.valueOf(paramCalendar.getTimeInMillis() / 1000L));
  }
  
  public RoamDateCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
  }
  
  public RoamMessagePreloadInfo a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilCalendar, paramInt);
  }
  
  public BitSet a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      paramCalendar1 = (Calendar)paramCalendar1.clone();
      int i = 0;
      while ((paramCalendar1.before(paramCalendar2)) || (paramCalendar1.equals(paramCalendar2)))
      {
        paramCalendar1.set(11, 0);
        paramCalendar1.set(12, 0);
        paramCalendar1.set(13, 0);
        paramCalendar1.set(14, 0);
        if (this.jdField_a_of_type_JavaUtilList.contains(Long.valueOf(paramCalendar1.getTimeInMillis()))) {
          localBitSet.set(i, true);
        }
        paramCalendar1.add(5, 1);
        i += 1;
      }
    }
    return localBitSet;
  }
  
  public Calendar a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilCalendar;
    }
    return this.e;
  }
  
  public List<MessageRecord> a()
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB: friendUin = " + this.jdField_a_of_type_JavaLangString);
    }
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getAllMessageFormDB error : mFriendUin == null");
        localObject1 = localObject2;
      }
    }
    List localList;
    for (;;)
    {
      return localObject1;
      localObject1 = MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, 0);
      localObject2 = "( msgtype " + UinTypeUtil.a() + " and isValid=1 ) " + "ORDER BY time asc , longMsgIndex asc";
      localList = a((String)localObject1, null, (String)localObject2);
      try
      {
        QSlowTableManager localQSlowTableManager = (QSlowTableManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        if (localQSlowTableManager != null)
        {
          localObject2 = localQSlowTableManager.a((String)localObject1, (String)localObject2);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject1 = localObject2;
            if (localList == null) {
              continue;
            }
            localList.addAll(0, (Collection)localObject2);
            return localList;
          }
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("Q.roammsg.MessageRoamManager", 1, "getAllMessageFormDB error");
      }
    }
    return localList;
  }
  
  public List<MessageRecord> a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageFromDB: friendUin = " + paramString + ", start = " + paramLong1 + ", end = " + paramLong2);
    }
    String str = "time BETWEEN " + paramLong1 + " AND " + paramLong2;
    return a(MessageRecord.getTableName(paramString, 0), null, str + " " + "ORDER BY time asc , longMsgIndex asc", paramLong1, paramLong2);
  }
  
  public List<MessageRecord> a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    Object localObject = (QSlowTableManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    if (localObject == null) {
      paramString3 = a(paramString1, paramString2, paramString3);
    }
    int i;
    int j;
    do
    {
      return paramString3;
      this.jdField_a_of_type_Long = ((QSlowTableManager)localObject).a(paramString1);
      if (this.jdField_a_of_type_Long <= paramLong2) {
        break label169;
      }
      paramString2 = "slowTable";
      paramString1 = ((QSlowTableManager)localObject).a(paramString1, paramString3);
      if (paramString1 != null) {
        break;
      }
      i = 0;
      k = 0;
      j = i;
      i = k;
      paramString3 = paramString1;
    } while (!QLog.isColorLevel());
    paramString3 = new StringBuilder().append("queryMsgDbBoth: msgLists = ");
    if (paramString1 == null) {}
    for (int k = 0;; k = paramString1.size())
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, k + ",fromWhichTable:" + paramString2 + ",stCount:" + j + " ,qtCount:" + i);
      return paramString1;
      i = paramString1.size();
      break;
      label169:
      if (this.jdField_a_of_type_Long < paramLong1)
      {
        localObject = "quickTable";
        paramString1 = a(paramString1, paramString2, paramString3);
        if (paramString1 == null) {}
        for (i = 0;; i = paramString1.size())
        {
          j = 0;
          paramString2 = (String)localObject;
          break;
        }
      }
      localObject = ((QSlowTableManager)localObject).a(paramString1, paramString3);
      label236:
      String str;
      if (localObject == null)
      {
        i = 0;
        str = "slowTable";
        if (i <= 0) {
          break label323;
        }
        paramString1 = a(paramString1, null, paramString3);
        if (paramString1 != null) {
          break label312;
        }
      }
      label312:
      for (j = 0;; j = paramString1.size())
      {
        paramString2 = str;
        if (j > 0)
        {
          ((List)localObject).addAll(paramString1);
          paramString2 = "bothTable";
        }
        k = i;
        i = j;
        j = k;
        paramString1 = (String)localObject;
        break;
        i = ((List)localObject).size();
        break label236;
      }
      label323:
      paramString1 = a(paramString1, paramString2, paramString3);
      if (paramString1 == null) {}
      for (j = 0;; j = paramString1.size())
      {
        k = i;
        i = j;
        paramString2 = "quickTable";
        j = k;
        break;
      }
    }
  }
  
  public void a()
  {
    QLog.d("Q.roammsg.MessageRoamManager", 1, "clearShowRoamBefore");
    this.jdField_a_of_type_JavaUtilCalendar = null;
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.jdField_c_of_type_JavaUtilCalendar = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_JavaUtilCalendar == null) {
      this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    this.jdField_a_of_type_JavaUtilCalendar.set(1, paramInt1);
    this.jdField_a_of_type_JavaUtilCalendar.set(2, paramInt2);
    this.jdField_a_of_type_JavaUtilCalendar.set(5, paramInt3);
    this.jdField_a_of_type_JavaUtilCalendar.set(11, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(12, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(13, 0);
    this.jdField_a_of_type_JavaUtilCalendar.set(14, 0);
    a(this.jdField_a_of_type_JavaUtilCalendar);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((MessageRoamManager.MessageRoamListener)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b(paramInt1, paramInt2, paramObject);
      i += 1;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    a(paramInt, 0, paramObject);
  }
  
  public void a(int paramInt, Calendar paramCalendar, boolean paramBoolean)
  {
    a(paramInt, paramCalendar, paramBoolean, true);
  }
  
  public void a(int paramInt, Calendar paramCalendar, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_c_of_type_Int = paramInt;
    int i;
    int j;
    if ((paramCalendar != null) && (QLog.isColorLevel()))
    {
      i = paramCalendar.get(1);
      j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistory start... someday=" + i + "-" + (j + 1) + "-" + k);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.e == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory error :mLocCurPageDate == null");
        }
        return;
      }
      i = 0;
      if (paramCalendar != null) {
        i = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(paramCalendar)));
      }
    }
    label274:
    label428:
    for (;;)
    {
      if ((i < 0) || (i > this.jdField_a_of_type_JavaUtilList.size() - 1))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.roammsg.MessageRoamManager", 2, "getForwardRoamHistoryByDate error :index < 0");
        }
        if ((paramInt == 1) || (paramInt == 0)) {
          break;
        }
        a(33, paramCalendar);
        return;
        if (paramInt == 1)
        {
          long l = a(this.e);
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
          label222:
          if ((i < 0) || (((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue() <= l))
          {
            if (i != -1) {
              break label274;
            }
            i += 1;
          }
          for (;;)
          {
            break;
            i -= 1;
            break label222;
          }
        }
        if (paramInt == 3)
        {
          i = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.e)));
          if (i >= this.jdField_a_of_type_JavaUtilList.size() - 1) {
            break;
          }
          i += 1;
          continue;
        }
        if (paramInt != 2) {
          break label428;
        }
        j = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(this.e)));
        i = j;
        if (j <= 0) {
          break label428;
        }
        i = j - 1;
        continue;
      }
      if (paramInt == 0) {
        b(this.g);
      }
      for (;;)
      {
        a(paramBoolean1, i);
        return;
        a(((Long)this.jdField_a_of_type_JavaUtilList.get(i)).longValue());
      }
      b(paramInt, paramCalendar, paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  public void a(MessageRoamManager.MessageRoamListener paramMessageRoamListener)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((MessageRoamManager.MessageRoamListener)localIterator.next()).a(paramMessageRoamListener);
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMessageRoamListener);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
      this.jdField_c_of_type_Int = 6;
      long l = paramMessageRecord.time;
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(l * 1000L);
      a(26, null);
      if (this.jdField_a_of_type_Boolean) {
        break label120;
      }
      i = this.jdField_a_of_type_JavaUtilList.indexOf(Long.valueOf(a(paramMessageRecord)));
      if (i >= 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistoryBySearchResult local state error index < 0");
    return;
    b(paramMessageRecord);
    r();
    this.jdField_a_of_type_JavaLangRunnable = new MessageRoamManager.5(this, i);
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    return;
    label120:
    Calendar localCalendar = Calendar.getInstance();
    if ((paramMessageRecord.get(1) == localCalendar.get(1)) && (paramMessageRecord.get(2) == localCalendar.get(2)) && (paramMessageRecord.get(5) == localCalendar.get(5)) && (b(paramMessageRecord))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        a(false);
        return;
      }
      a(paramMessageRecord, null, true);
      return;
    }
  }
  
  void a(DownloadTask paramDownloadTask)
  {
    if ((paramDownloadTask.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("cloudSearchCfgLastModify", paramDownloadTask.i).commit();
      if (200 == paramDownloadTask.f) {
        ThreadManager.getFileThreadHandler().post(new MessageRoamManager.12(this));
      }
    }
    if (QLog.isColorLevel())
    {
      File localFile = new File(MessageRoamConstants.b);
      long l = 0L;
      if (localFile.exists()) {
        l = localFile.lastModified();
      }
      QLog.d("Q.roammsg.MessageRoamManager", 2, "onDone status=" + paramDownloadTask.a() + ",errCode=" + paramDownloadTask.jdField_a_of_type_Int + ",httpCode=" + paramDownloadTask.f + ",local lastModify=" + l + ",server lastModify=" + paramDownloadTask.i);
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    this.jdField_a_of_type_JavaUtilCalendar = null;
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.jdField_c_of_type_JavaUtilCalendar = null;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    for (;;)
    {
      this.e = null;
      this.f = null;
      this.g = null;
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c();
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      long l1 = paramString.getLong("first_page_date" + this.jdField_a_of_type_JavaLangString, 0L);
      long l2 = paramString.getLong("last_page_date" + this.jdField_a_of_type_JavaLangString, 0L);
      paramString = new StringBuilder();
      paramString.append("init: first:").append(l1).append(" last:").append(l2);
      if (l1 != 0L)
      {
        this.jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(l1);
      }
      if (l2 != 0L)
      {
        this.jdField_c_of_type_JavaUtilCalendar = Calendar.getInstance();
        this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(l2);
      }
      paramString.append(" firstPage=").append(a(this.jdField_b_of_type_JavaUtilCalendar));
      paramString.append(" secondPage=").append(a(this.jdField_c_of_type_JavaUtilCalendar));
      QLog.d("Q.roammsg.MessageRoamManager", 1, paramString.toString());
      this.d = null;
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      ThreadManager.getSubThreadHandler().post(new MessageRoamManager.1(this));
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(Calendar paramCalendar)
  {
    if (this.d == null) {
      this.d = Calendar.getInstance();
    }
    this.d.setTimeInMillis(paramCalendar.getTimeInMillis());
  }
  
  public void a(Calendar paramCalendar, RoamMessagePreloadInfo paramRoamMessagePreloadInfo, boolean paramBoolean)
  {
    a(paramCalendar, paramRoamMessagePreloadInfo, paramBoolean, true);
  }
  
  public void a(Calendar paramCalendar, RoamMessagePreloadInfo paramRoamMessagePreloadInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCalendar == null) {}
    int m;
    int n;
    boolean bool;
    for (;;)
    {
      return;
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2) + 1;
      int k = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: Date = " + i + "-" + j + "-" + k);
      }
      RoamDate localRoamDate = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, i, j);
      if (localRoamDate == null)
      {
        if (!paramCalendar.equals(this.h))
        {
          this.h = paramCalendar;
          a(false);
          return;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 1, "handleRoamDateQuery endless loop protection");
        return;
      }
      a(i, j - 1, k);
      m = localRoamDate.getLocState(k - 1);
      n = localRoamDate.getSerState(k - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: serverStatus: " + n + ", localStaus: " + m);
      }
      switch (m)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
        bool = NetworkUtil.d(BaseApplication.getContext());
        if ((n != 2) || (!bool)) {
          break label482;
        }
        a(26, null);
        paramCalendar = Calendar.getInstance();
        paramCalendar.setTime(new Date(i - 1900, j - 1, k));
        QLog.d("Q.roammsg.MessageRoamManager", 1, "handleRoamDateQuery getRoamHistoryForSomeDay year = " + i + " month = " + j + " day = " + k + " call stack = " + Log.getStackTraceString(new Throwable()));
        this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_a_of_type_JavaLangString, paramCalendar, paramBoolean1, 8, false, paramBoolean2);
        if (paramRoamMessagePreloadInfo != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaUtilCalendar, paramRoamMessagePreloadInfo);
          return;
        }
        break;
      case 3: 
        if (paramBoolean1) {
          ThreadManager.getSubThreadHandler().post(new MessageRoamManager.4(this, paramCalendar));
        }
        while ((NetworkUtil.d(BaseApplication.getContext())) && (paramRoamMessagePreloadInfo != null))
        {
          this.jdField_a_of_type_JavaUtilHashMap.clear();
          this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_JavaUtilCalendar, paramRoamMessagePreloadInfo);
          a(this.jdField_a_of_type_JavaUtilCalendar, paramBoolean2);
          return;
          a(0, null);
        }
      }
    }
    label482:
    if (QLog.isColorLevel()) {
      QLog.w("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery serStatus: " + n + ", locStatus: " + m + ", network status: " + bool);
    }
    a(1, -1, null);
  }
  
  public void a(Calendar paramCalendar, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramCalendar))
    {
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "startPreloadCalendar: Calendar key = " + i + "-" + (j + 1) + "-" + k);
      }
      RoamMessagePreloadInfo localRoamMessagePreloadInfo = (RoamMessagePreloadInfo)this.jdField_a_of_type_JavaUtilHashMap.get(paramCalendar);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramCalendar);
      if (localRoamMessagePreloadInfo.preloadType != 0)
      {
        b(localRoamMessagePreloadInfo.nextday, paramBoolean);
        b(localRoamMessagePreloadInfo.previousday, paramBoolean);
      }
    }
  }
  
  public void a(List<MessageRecord> paramList, String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    QSlowTableManager localQSlowTableManager = (QSlowTableManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
    paramString = MessageRecord.getTableName(paramString, 0);
    this.jdField_a_of_type_Long = localQSlowTableManager.a(paramString);
    int j = paramList.size();
    int i = 0;
    if ((i >= j) || (((MessageRecord)paramList.get(i)).time > this.jdField_a_of_type_Long))
    {
      if (i <= 0) {
        break label220;
      }
      localQSlowTableManager.a(paramString, paramList.subList(0, i));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramList.subList(i, j), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "addRoamMessage: msgLists.size:" + paramList.size() + ",index:" + i + ",slowTableMaxTime:" + this.jdField_a_of_type_Long + ",cost:" + (System.currentTimeMillis() - l) + ", notify:" + paramBoolean);
      }
      return;
      i += 1;
      break;
      label220:
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    if ((paramBoolean) || (b(localCalendar)) || (a(localCalendar)))
    {
      paramBoolean = true;
      if (!paramBoolean) {
        break label100;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          a(26, null);
          this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_a_of_type_JavaLangString, 0, 1, i, j + 1, k);
          return;
          paramBoolean = false;
          break;
          label100:
          paramBoolean = k();
          continue;
        }
        a(16, 1, null);
        return;
      }
    }
    a(18, null);
    this.jdField_a_of_type_Int = 2003;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 2003;
  }
  
  public boolean a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.b(paramInt));
    r();
    return (this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a == null) || (this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a.size() == 0);
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (this.jdField_a_of_type_JavaUtilCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: mCurPageDate == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == this.jdField_a_of_type_JavaUtilCalendar.get(1)) && (localCalendar.get(2) == this.jdField_a_of_type_JavaUtilCalendar.get(2)) && (localCalendar.get(5) == this.jdField_a_of_type_JavaUtilCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean a(long paramLong, Calendar paramCalendar)
  {
    boolean bool = true;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis((5L + paramLong) * 1000L);
    if (paramCalendar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "isSameDay return false: day == null");
      }
      return false;
    }
    if ((localCalendar.get(1) == paramCalendar.get(1)) && (localCalendar.get(2) == paramCalendar.get(2)) && (localCalendar.get(5) == paramCalendar.get(5))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public byte[] a()
  {
    int i = b();
    if (i == 0) {
      return this.jdField_a_of_type_ArrayOfByte;
    }
    if (1 == i) {
      return b();
    }
    return null;
  }
  
  public int b()
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    int j = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
    if ((j == 0) || (1 == j)) {
      i = j;
    }
    return i;
  }
  
  public BitSet b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    Calendar localCalendar;
    if (!localList.isEmpty())
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramCalendar1.getTimeInMillis());
      int i = 0;
      if ((localCalendar.before(paramCalendar2)) || (localCalendar.equals(paramCalendar2)))
      {
        int n = localCalendar.get(1);
        int i1 = localCalendar.get(2) + 1;
        localCalendar.get(5);
        paramCalendar1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, n, i1);
        int j = 0;
        int m = 0;
        while (j < localList.size())
        {
          int k = i;
          if (((String)((Map.Entry)localList.get(j)).getKey()).equals(paramCalendar1))
          {
            RoamDate localRoamDate = (RoamDate)((Map.Entry)localList.get(j)).getValue();
            k = localCalendar.get(5);
            if (k <= RoamDate.getDays(n, i1))
            {
              if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(localRoamDate, k - 1))
              {
                localBitSet.set(i, true);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
              for (;;)
              {
                i += 1;
                k += 1;
                break;
                localBitSet.set(i, false);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
            }
            m = 1;
            k = i;
          }
          j += 1;
          i = k;
        }
        if (m != 0) {
          break label476;
        }
        j = i + RoamDate.getDays(n, i1);
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramCalendar1 + " no roamDate add =" + RoamDate.getDays(n, i1) + ",index=" + j);
          i = j;
        }
      }
    }
    label476:
    for (;;)
    {
      localCalendar.add(2, 1);
      localCalendar.set(5, 1);
      break;
      return localBitSet;
    }
  }
  
  public Calendar b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_b_of_type_JavaUtilCalendar;
    }
    return this.f;
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0).edit();
    localEditor.remove("vip_message_roam_passwordmd5" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).commit();
    this.jdField_a_of_type_ArrayOfByte = null;
    localEditor.putLong("vip_message_roam_last_request_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0L);
    localEditor.commit();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(paramInt));
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, paramInt1);
    localCalendar.set(2, paramInt2 - 1);
    localCalendar.set(5, paramInt3);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_JavaLangString, 0);
    Object localObject;
    if (localList != null)
    {
      localObject = localList;
      if (!localList.isEmpty()) {}
    }
    else
    {
      localObject = a((Calendar)localCalendar.clone());
      localObject = a(this.jdField_a_of_type_JavaLangString, ((Long)((Pair)localObject).first).longValue(), ((Long)((Pair)localObject).second).longValue());
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (b(((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time, (Calendar)localCalendar.clone())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "judgeLatestMsgInToday: friendUin = " + this.jdField_a_of_type_JavaLangString + ", year/month/day = " + paramInt1 + "/" + paramInt2 + "/" + paramInt3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, localCalendar.getTimeInMillis() / 1000L, 2);
    }
  }
  
  public void b(MessageRoamManager.MessageRoamListener paramMessageRoamListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramMessageRoamListener);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    String str = paramMessageRecord.frienduin;
    long l = paramMessageRecord.time;
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(str);
    }
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(1000L * l);
    Pair localPair = a((Calendar)((Calendar)localObject).clone());
    List localList;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      localList = a((String)localObject, ((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("judgeClearRoamDateIndex: friendUin = ");
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label392;
      }
      localObject = str;
      label125:
      localStringBuilder = localStringBuilder.append((String)localObject).append(", dayList.size() = ");
      if (localList != null) {
        break label401;
      }
      localObject = "null";
      label149:
      Utils.a("Q.roammsg.MessageRoamManager", new Object[] { localObject });
      localObject = new ArrayList();
      if ((paramMessageRecord instanceof MessageForLongMsg))
      {
        ((List)localObject).addAll(((MessageForLongMsg)paramMessageRecord).longMsgFragmentList);
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "judgeClearRoamDateIndex: delList.size() = " + ((List)localObject).size() });
      }
      if (!((List)localObject).isEmpty()) {
        break label422;
      }
      if ((localList != null) && (localList.size() == 1))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString == null) {
          break label416;
        }
        paramMessageRecord = this.jdField_a_of_type_JavaLangString;
        label284:
        ((RoamDateCache)localObject).a(paramMessageRecord, l - 5L, 1);
        paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache;
        if (this.jdField_a_of_type_JavaLangString != null) {
          str = this.jdField_a_of_type_JavaLangString;
        }
        paramMessageRecord.b(str, l - 5L, 0);
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "judgeClearRoamDateIndex: " + l });
        if (this.jdField_a_of_type_JavaLangString != null) {
          b(l);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
      }
      return;
      localObject = str;
      break;
      label392:
      localObject = this.jdField_a_of_type_JavaLangString;
      break label125;
      label401:
      localObject = Integer.valueOf(localList.size());
      break label149;
      label416:
      paramMessageRecord = str;
      break label284;
      label422:
      a((List)localObject, localPair, localList, str, l);
    }
  }
  
  void b(DownloadTask paramDownloadTask)
  {
    boolean bool = true;
    Object localObject;
    SharedPreferences.Editor localEditor;
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.jdField_a_of_type_Int == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download success!");
      }
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir(), paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
        localEditor = paramDownloadTask.edit();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONArray(FileUtils.a((File)localObject));
        i = 0;
        if (i >= ((JSONArray)localObject).length()) {
          break label477;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
        if ((localJSONObject == null) || (localJSONObject.getInt("id") != 1)) {
          break label483;
        }
        localEditor.putInt("blue_banner_cheak_update_internal", localJSONObject.getInt("updateinternal"));
        localEditor.putInt("blue_banner_show_internal", localJSONObject.getInt("showinternal"));
        localEditor.putInt("blue_banner_show_time", localJSONObject.getInt("showtime"));
        localEditor.putString("blue_banner_go_url", localJSONObject.getString("url"));
        localEditor.putString("blue_banner_notvip_text", localJSONObject.getString("notvip"));
        localEditor.putString("blue_banner_vip_text", localJSONObject.getString("vip"));
        localEditor.putString("blue_banner_svip_text", localJSONObject.getString("svip"));
        localEditor.commit();
        if (bool)
        {
          paramDownloadTask.edit().putLong("blue_banner_last_update_timestamp", NetConnInfoCenter.getServerTimeMillis()).commit();
          return;
        }
        if (!QLog.isColorLevel()) {
          break label482;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 2, "save sp error , isSaveSuccess" + bool);
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          break label482;
        }
        QLog.e("Q.roammsg.MessageRoamManager", 2, "JSONException,blue banner parse json error : " + paramDownloadTask.toString());
        return;
      }
      catch (Exception paramDownloadTask)
      {
        if (!QLog.isColorLevel()) {
          break label482;
        }
      }
      QLog.e("Q.roammsg.MessageRoamManager", 2, "Exception,blue banner parse json error : " + paramDownloadTask.toString());
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download file save failed!");
        return;
        if (QLog.isColorLevel())
        {
          QLog.e("Q.roammsg.MessageRoamManager", 2, "blue banner download failed, task.status = " + paramDownloadTask.a() + " , task.errCode = " + paramDownloadTask.jdField_a_of_type_Int);
          return;
          label477:
          bool = false;
          continue;
        }
      }
      label482:
      return;
      label483:
      i += 1;
    }
  }
  
  public void b(String paramString)
  {
    c(paramString);
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = -1;
      return;
      a(24, null);
      continue;
      a(25, null);
    }
  }
  
  public void b(Calendar paramCalendar)
  {
    if (this.e == null) {
      this.e = Calendar.getInstance();
    }
    this.e.set(1, paramCalendar.get(1));
    this.e.set(2, paramCalendar.get(2));
    this.e.set(5, paramCalendar.get(5));
    this.e.set(11, 0);
    this.e.set(12, 0);
    this.e.set(13, 0);
    this.e.set(14, 0);
    a(this.e);
  }
  
  public void b(Calendar paramCalendar, boolean paramBoolean)
  {
    if (paramCalendar == null) {}
    int i;
    int j;
    int k;
    int m;
    int n;
    do
    {
      return;
      i = paramCalendar.get(1);
      j = paramCalendar.get(2) + 1;
      k = paramCalendar.get(5);
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, i, j);
      m = paramCalendar.getLocState(k - 1);
      n = paramCalendar.getSerState(k - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "preloadRoamMessage: Date = " + i + "-" + j + "-" + k + " locState: " + m + " serverState " + n);
      }
    } while ((m == 3) || (n != 2));
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "preloadRoamMessage: preload >>>>> Date = " + i + "-" + j + "-" + k);
    }
    paramCalendar = Calendar.getInstance();
    paramCalendar.setTime(new Date(i - 1900, j - 1, k));
    QLog.d("Q.roammsg.MessageRoamManager", 1, "preloadRoamMessage getRoamHistoryForSomeDay");
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_a_of_type_JavaLangString, paramCalendar, false, 0, true, paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((MessageRoamManager.MessageRoamListener)localIterator.next()).a(paramBoolean, null);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilCalendar != null;
  }
  
  public byte[] b()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getDA2(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());; localObject = null)
    {
      if ((localObject != null) && (localObject.length > 0)) {
        return localObject;
      }
      VasWebviewUtil.reportVasStatus("messageRoam", "da2", "0", 0, 0, 0, 0, "", "");
      return null;
    }
  }
  
  public BitSet c(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    BitSet localBitSet = new BitSet();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    Calendar localCalendar;
    if (!localList.isEmpty())
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramCalendar1.getTimeInMillis());
      int i = 0;
      if ((localCalendar.before(paramCalendar2)) || (localCalendar.equals(paramCalendar2)))
      {
        int n = localCalendar.get(1);
        int i1 = localCalendar.get(2) + 1;
        localCalendar.get(5);
        paramCalendar1 = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, n, i1);
        int j = 0;
        int m = 0;
        while (j < localList.size())
        {
          int k = i;
          if (((String)((Map.Entry)localList.get(j)).getKey()).equals(paramCalendar1))
          {
            RoamDate localRoamDate = (RoamDate)((Map.Entry)localList.get(j)).getValue();
            k = localCalendar.get(5);
            if (k <= RoamDate.getDays(n, i1))
            {
              if ((i == 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(localRoamDate, k - 1)))
              {
                c();
                a(18, null);
                if (QLog.isColorLevel()) {
                  QLog.d("MessageRoamManagerDebug", 2, "getRoamDateMap exception situation handle.");
                }
                return localBitSet;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(localRoamDate, k - 1))
              {
                localBitSet.set(i, true);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
              for (;;)
              {
                i += 1;
                k += 1;
                break;
                localBitSet.set(i, false);
                if (QLog.isColorLevel()) {
                  QLog.d("TimeLineView", 2, paramCalendar1 + "-" + k + ",index= " + i + ",mask=" + localBitSet.get(i));
                }
              }
            }
            m = 1;
            k = i;
          }
          j += 1;
          i = k;
        }
        if (m != 0) {
          break label526;
        }
        j = i + RoamDate.getDays(n, i1);
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.roammsg.MessageRoamManager", 2, paramCalendar1 + " no roamDate add =" + RoamDate.getDays(n, i1) + ",index=" + j);
          i = j;
        }
      }
    }
    label526:
    for (;;)
    {
      localCalendar.add(2, 1);
      localCalendar.set(5, 1);
      break;
      return localBitSet;
    }
  }
  
  public Calendar c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_c_of_type_JavaUtilCalendar;
    }
    return this.g;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a();
    if (localObject != null)
    {
      if (QLog.isColorLevel())
      {
        int i = ((Calendar)((Pair)localObject).first).get(1);
        int j = ((Calendar)((Pair)localObject).first).get(2);
        int k = ((Calendar)((Pair)localObject).first).get(5);
        int m = ((Calendar)((Pair)localObject).second).get(1);
        int n = ((Calendar)((Pair)localObject).second).get(2);
        int i1 = ((Calendar)((Pair)localObject).second).get(5);
        QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: first = " + i + "-" + (j + 1) + "-" + k + ", second = " + m + "-" + (n + 1) + "-" + i1);
      }
      this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)((Pair)localObject).first);
      this.jdField_c_of_type_JavaUtilCalendar = ((Calendar)((Pair)localObject).second);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong("first_page_date" + this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).putLong("last_page_date" + this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
      ((SharedPreferences.Editor)localObject).commit();
      localObject = new StringBuilder(50);
      ((StringBuilder)localObject).append("setPageDateRange firstPage=").append(a(this.jdField_b_of_type_JavaUtilCalendar)).append(" secondPage=").append(a(this.jdField_c_of_type_JavaUtilCalendar));
      ((StringBuilder)localObject).append(" first:").append(this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis()).append(" last:").append(this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
      QLog.d("Q.roammsg.MessageRoamManager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "setPageDateRange: null");
    }
    this.jdField_b_of_type_JavaUtilCalendar = null;
    this.jdField_c_of_type_JavaUtilCalendar = null;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    int j = paramString.length();
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = new byte[j / 2];
    }
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_ArrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "savePasswordMD5ForRoamMessage passwordMD5" + Arrays.toString(this.jdField_a_of_type_ArrayOfByte));
    }
    ThreadManager.getFileThreadHandler().post(new MessageRoamManager.6(this));
  }
  
  public void c(Calendar paramCalendar)
  {
    a(paramCalendar, true);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "show roam: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = this.jdField_b_of_type_JavaUtilCalendar;
      if (!this.jdField_a_of_type_Boolean) {
        break label110;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilCalendar;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isFirstPage: firstPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.f;
      break;
      localObject1 = this.e;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) >= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) >= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) >= ((Calendar)localObject1).get(5));
  }
  
  public void d()
  {
    this.jdField_c_of_type_Int = 4;
    e();
  }
  
  @TargetApi(9)
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramInt).commit();
  }
  
  public void d(Calendar paramCalendar)
  {
    if ((paramCalendar != null) && (QLog.isColorLevel()))
    {
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2);
      int k = paramCalendar.get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getRoamHistory start... someday=" + i + "-" + (j + 1) + "-" + k);
    }
    e(paramCalendar);
    if (QLog.isColorLevel()) {
      QLog.w("Q.roammsg.MessageRoamManager", 2, "getRoamHistory end");
    }
  }
  
  @TargetApi(9)
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("first_use_devlock_for_roam_message_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("first_use_devlock_for_roam_message_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean).commit();
  }
  
  public boolean d()
  {
    Object localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject2 = this.jdField_c_of_type_JavaUtilCalendar;
      if (!this.jdField_a_of_type_Boolean) {
        break label110;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilCalendar;
      label24:
      if ((localObject2 != null) && (localObject1 != null)) {
        break label132;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("isLastPage: lastPageDate ");
        if (localObject2 != null) {
          break label118;
        }
        localObject2 = "==";
        label60:
        localObject2 = localStringBuilder.append((String)localObject2).append(" null, curPageDate ");
        if (localObject1 != null) {
          break label125;
        }
      }
    }
    label110:
    label118:
    label125:
    for (Object localObject1 = "==";; localObject1 = "!=")
    {
      QLog.d("Q.roammsg.MessageRoamManager", 2, (String)localObject1 + " null");
      return true;
      localObject2 = this.g;
      break;
      localObject1 = this.e;
      break label24;
      localObject2 = "!=";
      break label60;
    }
    label132:
    return (((Calendar)localObject2).get(1) <= ((Calendar)localObject1).get(1)) && (((Calendar)localObject2).get(2) <= ((Calendar)localObject1).get(2)) && (((Calendar)localObject2).get(5) <= ((Calendar)localObject1).get(5));
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (Object localObject1 = this.jdField_a_of_type_JavaUtilCalendar; localObject1 == null; localObject1 = this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "getMessageByDay error:curPageDate == null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      int i = ((Calendar)localObject1).get(1);
      int j = ((Calendar)localObject1).get(2);
      int k = ((Calendar)localObject1).get(5);
      QLog.d("Q.roammsg.MessageRoamManager", 2, "getMessageByDay: friendUin = " + this.jdField_a_of_type_JavaLangString + ", mShowRoamFlag = " + this.jdField_a_of_type_Boolean + ", curPageDate = " + i + "-" + (j + 1) + "-" + k);
    }
    localObject1 = a((Calendar)((Calendar)localObject1).clone());
    long l = ((Long)((Pair)localObject1).second).longValue();
    Object localObject2;
    if (this.d != null)
    {
      localObject2 = a((Calendar)this.d.clone());
      if (((Long)((Pair)localObject2).second).longValue() > l) {
        l = ((Long)((Pair)localObject2).second).longValue();
      }
    }
    for (;;)
    {
      String str2 = " time BETWEEN " + ((Pair)localObject1).first + " AND " + l;
      localObject2 = MessageRecord.getTableName(this.jdField_a_of_type_JavaLangString, 0);
      String str1 = MessageRecord.getOldTableName(this.jdField_a_of_type_JavaLangString, 0);
      str2 = "( msgtype " + UinTypeUtil.a() + " and isValid=1 and" + str2 + " ) " + "ORDER BY time asc , longMsgIndex asc";
      ThreadManager.getSubThreadHandler().post(new MessageRoamManager.2(this, (String)localObject2, str1, str2, (Pair)localObject1, l));
      return;
    }
  }
  
  public void e(Calendar paramCalendar)
  {
    if (paramCalendar == null) {}
    for (;;)
    {
      return;
      int i = paramCalendar.get(1);
      int j = paramCalendar.get(2) + 1;
      int k = paramCalendar.get(5);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQueryNew: Date = " + i + "-" + j + "-" + k);
      }
      paramCalendar = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, i, j);
      if (paramCalendar == null)
      {
        QLog.e("Q.roammsg.MessageRoamManager", 1, "roamDate is null");
        return;
      }
      int m = paramCalendar.getLocState(k - 1);
      int n = paramCalendar.getSerState(k - 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery: serverStatus: " + n + ", localStaus: " + m);
      }
      boolean bool;
      switch (m)
      {
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
        bool = NetworkUtil.d(BaseApplication.getContext());
        if ((n == 2) && (bool))
        {
          paramCalendar = Calendar.getInstance();
          paramCalendar.setTime(new Date(i - 1900, j - 1, k));
          QLog.d("Q.roammsg.MessageRoamManager", 1, "handleRoamDateQuery getRoamHistoryForSomeDay year = " + i + " month = " + j + " day = " + k + " call stack = " + Log.getStackTraceString(new Throwable()));
          this.jdField_a_of_type_ComTencentMobileqqAppUtilsMessageRoamHandler.a(this.jdField_a_of_type_JavaLangString, paramCalendar, false, 8, false);
          return;
        }
        break;
      case 3: 
        paramCalendar = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramCalendar.hasNext()) {
          ((MessageRoamManager.MessageRoamListener)paramCalendar.next()).a(true, null);
        }
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.roammsg.MessageRoamManager", 2, "handleRoamDateQuery serStatus: " + n + ", locStatus: " + m + ", network status: " + bool);
      }
      paramCalendar = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramCalendar.hasNext()) {
        ((MessageRoamManager.MessageRoamListener)paramCalendar.next()).a(false, null);
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    long l1 = ((SharedPreferences)localObject).getLong("blue_banner_last_update_timestamp", 0L);
    long l2 = ((SharedPreferences)localObject).getInt("blue_banner_cheak_update_internal", 24);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if ((paramBoolean) || (l3 - l1 > l2 * 3600000L) || (l3 < l1))
    {
      localObject = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      if ((localObject != null) && (((DownloaderInterface)localObject).a("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json") == null))
      {
        DownloadTask localDownloadTask = new DownloadTask("https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json", new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir(), "https://imgcache.qq.com/club/mobile/messageroam/xiaoximanyou2.json"));
        localDownloadTask.p = false;
        ((DownloaderInterface)localObject).a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, null);
      }
    }
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void f()
  {
    if (b() == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("vip_message_roam_passwordmd5_and_signature_file", 0);
      l = ((SharedPreferences)localObject).getLong("vip_message_roam_last_request_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0L);
      if ((System.currentTimeMillis() - l > 7200000L) || (l == 0L))
      {
        QLog.d("Q.roammsg.MessageRoamManager", 1, "checkPasswdBeforeRequest open password lastRequestTime = " + l);
        a(3, 2, null);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putLong("vip_message_roam_last_request_timestamp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      long l;
      return;
    }
    QLog.d("Q.roammsg.MessageRoamManager", 2, "not passwd mode");
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("auth_mode_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1) != -1;
  }
  
  public void g()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      h();
    case 4: 
      return;
    case 0: 
    case 1: 
    case 2: 
      a(2, null, false);
      return;
    }
    a(3, null, false);
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return 1 == this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("message_roam_is_set_password" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public void h()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1) != 1;
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.contains("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.c();
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("first_use_devlock_for_roam_message_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.b();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit();
    localEditor.remove("first_page_date" + this.jdField_a_of_type_JavaLangString);
    localEditor.remove("last_page_date" + this.jdField_a_of_type_JavaLangString);
    localEditor.commit();
  }
  
  public boolean k()
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    boolean bool2;
    do
    {
      return bool1;
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      }
      bool2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("delServerRoamMSg_" + this.jdField_a_of_type_JavaLangString, false);
      bool1 = bool2;
    } while (!bool2);
    n();
    return bool2;
  }
  
  public void l()
  {
    ThreadManager.getSubThreadHandler().post(new MessageRoamManager.8(this));
  }
  
  public boolean l()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      s();
      this.jdField_b_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "canSearchInCloud: " + this.jdField_c_of_type_Boolean + ", mShowRoamFlag: " + this.jdField_a_of_type_Boolean);
    }
    return (this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean);
  }
  
  public void m()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.roammsg.MessageRoamManager", 2, "mFriendUin is null");
      }
    }
    for (;;)
    {
      return;
      Object localObject = a();
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "mergerLocTimeLine  no message");
        }
        j();
        return;
      }
      Calendar localCalendar = Calendar.getInstance();
      Iterator localIterator = ((List)localObject).iterator();
      int i = 0;
      int j = 0;
      label87:
      int m;
      for (int k = 0; localIterator.hasNext(); k = m)
      {
        localCalendar.setTimeInMillis(((MessageRecord)localIterator.next()).time * 1000L);
        m = localCalendar.get(1);
        int n = localCalendar.get(2) + 1;
        int i1 = localCalendar.get(5);
        if ((k == m) && (n == j) && (i1 == i)) {
          break label87;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.roammsg.MessageRoamManager", 2, "mergerLocTimeLine add local msg: " + m + "-" + n + "-" + i1);
        }
        RoamDate localRoamDate = this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(this.jdField_a_of_type_JavaLangString, m, n);
        localObject = localRoamDate;
        if (localRoamDate == null) {
          localObject = new RoamDate(String.valueOf(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a(m, n));
        }
        if (2 != ((RoamDate)localObject).getSerState(i1 - 1))
        {
          ((RoamDate)localObject).setLocState(i1 - 1, 3);
          this.jdField_a_of_type_ComTencentMobileqqAppAsyncdbCacheRoamDateCache.a((RoamDate)localObject);
        }
        i = i1;
        j = n;
      }
    }
  }
  
  @TargetApi(9)
  public void n()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    }
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("delServerRoamMSg_" + this.jdField_a_of_type_JavaLangString, false).apply();
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("delServerRoamMSg_" + this.jdField_a_of_type_JavaLangString, false).commit();
  }
  
  void o()
  {
    Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg start...." });
    Object localObject = new File(MessageRoamConstants.b);
    int i;
    JSONObject localJSONObject;
    String str;
    label265:
    String[] arrayOfString;
    int k;
    int j;
    if ((((File)localObject).isFile()) && (((File)localObject).exists()))
    {
      localObject = FileUtils.a((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        try
        {
          localObject = new JSONObject((String)localObject).getJSONObject("data").getJSONArray("searchStrategy");
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localJSONObject = (JSONObject)((JSONArray)localObject).get(0);
            str = localJSONObject.getString("version");
            if ((TextUtils.isEmpty(str)) || (AppSetting.a(str) < 0))
            {
              Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "curr ver: 8.5.5, config qqVer:" + str });
            }
            else
            {
              str = localJSONObject.getString("canSearchInCloud");
              if (!"1".equals(str)) {
                Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg Field[canSearchInCloud]: " + str });
              }
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "parse cloudSearchcfg failed " + localException.getMessage());
          }
          this.jdField_c_of_type_Boolean = false;
        }
        Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg done .... canCloudSearch: " + this.jdField_c_of_type_Boolean });
        return;
        str = localJSONObject.getString("whiteList");
        if ((!TextUtils.isEmpty(str)) && (str.length() > 2))
        {
          str = str.substring(1, str.length() - 1);
          arrayOfString = str.split(",");
          k = arrayOfString.length;
          j = 0;
        }
      }
    }
    for (;;)
    {
      if (j < k)
      {
        if (arrayOfString[j].equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
        {
          this.jdField_c_of_type_Boolean = true;
          Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "match Field[whitlist]:" + str });
        }
      }
      else
      {
        boolean bool1 = b(localJSONObject);
        if (!bool1)
        {
          Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg  matchUserType: " + bool1 });
        }
        else
        {
          boolean bool2 = a(localJSONObject);
          if ((bool1) && (bool2))
          {
            this.jdField_c_of_type_Boolean = true;
            break label265;
            Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg json text is empty" });
            break label265;
            Utils.a("Q.roammsg.MessageRoamManager", new Object[] { "parseCloudSearchCfg file not exist" });
            break label265;
          }
        }
        i += 1;
        break;
      }
      j += 1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences = null;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void p()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MessageRoamManager.10(this), 100L);
  }
  
  public void q()
  {
    this.jdField_a_of_type_Long = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager
 * JD-Core Version:    0.7.0.1
 */