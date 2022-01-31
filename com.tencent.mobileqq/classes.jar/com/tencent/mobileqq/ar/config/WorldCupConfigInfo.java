package com.tencent.mobileqq.ar.config;

import aake;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.BusinessCommonConfig.ConfigInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class WorldCupConfigInfo
  extends BusinessCommonConfig.ConfigInfo
{
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "flag_show_splash", "flag_show_mainani", "flag_iconinaddbtn_clicked" };
  long jdField_a_of_type_Long = 0L;
  private WorldCupShareInfo jdField_a_of_type_ComTencentMobileqqArConfigWorldCupShareInfo = new WorldCupShareInfo();
  final TreeMap jdField_a_of_type_JavaUtilTreeMap = new TreeMap();
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  final TreeMap jdField_b_of_type_JavaUtilTreeMap = new TreeMap();
  public boolean b;
  long c = 0L;
  long d = 0L;
  long e = 0L;
  long f = 0L;
  long g = 3L;
  long h = 3600L;
  
  public WorldCupConfigInfo()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static long a()
  {
    return MessageCache.a() * 1000L;
  }
  
  private static long a(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    long l2 = a();
    long l1 = paramWorldCupConfigInfo.c;
    paramWorldCupConfigInfo = paramWorldCupConfigInfo.jdField_a_of_type_JavaUtilTreeMap.entrySet().iterator();
    while (paramWorldCupConfigInfo.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramWorldCupConfigInfo.next();
      if (((Long)localEntry.getValue()).longValue() > l2) {
        break;
      }
      l1 = ((Long)localEntry.getValue()).longValue();
    }
    return l1;
  }
  
  public static long a(String paramString)
  {
    long l = a(paramString, 1);
    if (AudioHelper.a(11) == 1)
    {
      QLog.w("WorldCupMgr", 1, "强制展示入口左到右动画, time[" + l + "]");
      a(paramString, 0L);
      return 0L;
    }
    if (AudioHelper.a(11) == 0)
    {
      QLog.w("WorldCupMgr", 1, "禁止展示入口左到右动画, time[" + l + "]");
      return 9223372036854775807L;
    }
    return l;
  }
  
  static long a(String paramString, int paramInt)
  {
    long l2 = WorldCupStaticInstance.a().a[paramInt];
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = a(paramString).getLong(jdField_a_of_type_ArrayOfJavaLangString[paramInt], 0L);
      WorldCupStaticInstance.a().a[paramInt] = l1;
    }
    return l1;
  }
  
  public static SharedPreferences a(String paramString)
  {
    if ((AudioHelper.d()) && (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("获取世界杯配置需要UIN");
    }
    return BaseApplication.getContext().getSharedPreferences("config_qq.android.worldcup_" + paramString, 4);
  }
  
  public static WorldCupConfigInfo a(String paramString1, String paramString2)
  {
    int i = 0;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = a(paramString1).getString("config", null);
      i = 1;
    }
    if (AudioHelper.d()) {
      QLog.w("WorldCupMgr", 1, "ConfigInfo.get, step[" + i + "], configText[" + str + "]");
    }
    paramString2 = new WorldCupConfigInfo();
    paramString2.a(paramString1);
    if (!TextUtils.isEmpty(str)) {
      paramString2.a("WorldCupMgr", str);
    }
    return paramString2;
  }
  
  static void a(String paramString, int paramInt, long paramLong)
  {
    WorldCupStaticInstance.a().a[paramInt] = paramLong;
    a(paramString).edit().putLong(jdField_a_of_type_ArrayOfJavaLangString[paramInt], paramLong).commit();
    QLog.w("WorldCupMgr", 1, "保存配置时间, spKeyFlag[" + paramInt + "], time[" + paramLong + "]");
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    BusinessCommonConfig.a("WorldCupMgr", a(paramString1), "md5_" + paramInt, paramString2);
  }
  
  public static void a(String paramString, long paramLong)
  {
    a(paramString, 1, paramLong);
  }
  
  private static boolean a(long paramLong1, long paramLong2)
  {
    long l = a();
    if (l < paramLong1) {}
    while (l > paramLong2) {
      return false;
    }
    return true;
  }
  
  public static boolean a(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    if (!paramWorldCupConfigInfo.a()) {}
    while (!a(paramWorldCupConfigInfo.e, paramWorldCupConfigInfo.f)) {
      return false;
    }
    return true;
  }
  
  public static long b(String paramString)
  {
    long l = a(paramString, 0);
    if (AudioHelper.a(10) == 1)
    {
      QLog.w("WorldCupMgr", 1, "强制展示闪屏, time[" + l + "]");
      b(paramString, 0L);
      return 0L;
    }
    return l;
  }
  
  public static void b(String paramString, long paramLong)
  {
    a(paramString, 0, paramLong);
  }
  
  public static boolean b(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    if (!paramWorldCupConfigInfo.a()) {
      return false;
    }
    long l3 = paramWorldCupConfigInfo.g;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    long l2 = 1L;
    long l1 = l2;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l1 = Long.parseLong(str) % l3;
      l2 = paramWorldCupConfigInfo.h * 1000L * l1;
      boolean bool = a(paramWorldCupConfigInfo.jdField_a_of_type_Long + l2, paramWorldCupConfigInfo.jdField_b_of_type_Long);
      QLog.w("WorldCupMgr", 1, "canShowSplash, 延迟[" + l1 + "], src[" + paramWorldCupConfigInfo.jdField_a_of_type_Long + "], fix[" + (l2 + paramWorldCupConfigInfo.jdField_a_of_type_Long) + "], show[" + bool + "], uin[" + str + "]");
      if (!bool) {
        return false;
      }
      return b(paramWorldCupConfigInfo.l) == 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  public static long c(String paramString)
  {
    long l = a(paramString, 2);
    if (AudioHelper.a(12) == 1)
    {
      QLog.w("WorldCupMgr", 1, "强制显示加号上面的足球, time[" + l + "]");
      c(paramString, 0L);
      return 0L;
    }
    return l;
  }
  
  public static void c(String paramString, long paramLong)
  {
    a(paramString, 2, paramLong);
  }
  
  static boolean c(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    if (!a(paramWorldCupConfigInfo)) {}
    while (!a(paramWorldCupConfigInfo.c, paramWorldCupConfigInfo.d)) {
      return false;
    }
    return true;
  }
  
  public static boolean d(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    boolean bool = false;
    if (!c(paramWorldCupConfigInfo)) {
      return false;
    }
    long l1 = c(paramWorldCupConfigInfo.l);
    long l2 = a(paramWorldCupConfigInfo);
    if (l1 < l2) {
      bool = true;
    }
    QLog.w("WorldCupMgr", 1, "canShowFootballInAddBtn, show[" + bool + "], time[" + l1 + "], beginTime[" + l2 + "]");
    return bool;
  }
  
  public static boolean e(WorldCupConfigInfo paramWorldCupConfigInfo)
  {
    boolean bool = false;
    if (!c(paramWorldCupConfigInfo)) {
      return false;
    }
    long l1 = a(paramWorldCupConfigInfo);
    long l2 = a(paramWorldCupConfigInfo.l);
    if (l1 > l2) {
      bool = true;
    }
    QLog.w("WorldCupMgr", 1, "canShowMainEntryMovingAni, show[" + bool + "], time[" + l2 + "], beginTime[" + l1 + "]");
    return bool;
  }
  
  public SharedPreferences a()
  {
    return a(this.l);
  }
  
  public WorldCupShareInfo a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupShareInfo.share.size() <= 0)
    {
      String str = a(2);
      File localFile = null;
      if (str != null)
      {
        localFile = new File(str);
        QLog.e("WorldCupMgr", 1, "WL_DEBUG getShareInfo root = " + str);
      }
      if ((localFile == null) || (!localFile.exists())) {
        QLog.e("WorldCupMgr", 1, "WL_DEBUG getShareInfo root is not exists");
      }
      this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupShareInfo.parse(str + "config.json");
    }
    return this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupShareInfo;
  }
  
  public String a(int paramInt)
  {
    aake localaake = (aake)this.jdField_b_of_type_JavaUtilTreeMap.get(Integer.valueOf(paramInt));
    if (localaake == null) {
      return null;
    }
    return WorldCupMgr.b(localaake.jdField_a_of_type_Int, localaake.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    aake localaake = (aake)this.jdField_b_of_type_JavaUtilTreeMap.get(Integer.valueOf(paramInt));
    if (localaake == null)
    {
      QLog.w("WorldCupMgr", 1, "isResReady, 没有ZipItem, index[" + paramInt + "]");
      return false;
    }
    return BusinessCommonConfig.a("WorldCupMgr", a(), "md5_" + localaake.jdField_a_of_type_Int, localaake.jdField_b_of_type_JavaLangString, a(localaake.jdField_a_of_type_Int));
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    if ((AudioHelper.d()) && (TextUtils.isEmpty(this.l))) {
      throw new IllegalArgumentException("世界杯配置需要UIN");
    }
    try
    {
      this.jdField_b_of_type_JavaUtilTreeMap.clear();
      this.jdField_a_of_type_JavaUtilTreeMap.clear();
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("worldCupMainswitch");
      this.jdField_a_of_type_Long = ArMapUtil.c(paramJSONObject.optString("splashEntranceBeginTime"));
      this.jdField_b_of_type_Long = ArMapUtil.c(paramJSONObject.optString("splashEntranceEndTime"));
      this.c = ArMapUtil.c(paramJSONObject.optString("mainEntranceBeginTime"));
      this.d = ArMapUtil.c(paramJSONObject.optString("mainEntranceEndTime"));
      this.e = ArMapUtil.c(paramJSONObject.optString("scanEntranceBeginTime"));
      this.f = ArMapUtil.c(paramJSONObject.optString("scanEntranceEndTime"));
      this.jdField_b_of_type_Boolean = paramJSONObject.optBoolean("splashSwitch", true);
      this.g = paramJSONObject.optLong("splashDealyCount", this.g);
      this.h = paramJSONObject.optLong("splashDealyTime", this.h);
      if (this.g <= 0L) {
        this.g = 3L;
      }
      if (this.h <= 0L) {
        this.h = 3600L;
      }
      JSONArray localJSONArray = paramJSONObject.optJSONArray("mainEntrance");
      int i;
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          long l = ArMapUtil.c(localJSONArray.getJSONObject(i).optString("time"));
          this.jdField_a_of_type_JavaUtilTreeMap.put(Long.valueOf(l), Long.valueOf(l));
          i += 1;
        }
      }
      new TreeMap();
      localJSONArray = paramJSONObject.optJSONArray("zip_list");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          aake localaake = new aake();
          localaake.jdField_a_of_type_Int = Integer.valueOf(localJSONObject.getString("index")).intValue();
          localaake.jdField_b_of_type_Int = Integer.valueOf(localJSONObject.getString("net_type")).intValue();
          localaake.jdField_a_of_type_Boolean = localJSONObject.getBoolean("auto_next");
          localaake.jdField_a_of_type_JavaLangString = localJSONObject.getString("url");
          localaake.jdField_b_of_type_JavaLangString = localJSONObject.getString("md5");
          this.jdField_b_of_type_JavaUtilTreeMap.put(Integer.valueOf(localaake.jdField_a_of_type_Int), localaake);
          i += 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupShareInfo.parseShare(paramJSONObject);
      a();
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("WorldCupMgr", 1, "parseJson, Exception", paramJSONObject);
    }
    return false;
  }
  
  public String toString()
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilTreeMap.values().iterator();
    aake localaake;
    for (String str = ""; localIterator.hasNext(); str = str + "\n" + localaake) {
      localaake = (aake)localIterator.next();
    }
    return "task_id[" + this.jdField_b_of_type_Int + "], _parseRet[" + this.jdField_a_of_type_Int + "], mUin[" + this.l + "], enable[" + this.jdField_a_of_type_Boolean + "], splashSwitch[" + this.jdField_b_of_type_Boolean + "], splashEntranceBeginTime[" + this.jdField_a_of_type_Long + "], splashEntranceEndTime[" + this.jdField_b_of_type_Long + "], mainEntranceBeginTime[" + this.c + "], mainEntranceEndTime[" + this.d + "], scanEntranceBeginTime[" + this.e + "], scanEntranceEndTime[" + this.f + "], splashDealyTime[" + this.h + "], splashDealyCount[" + this.g + "], ZipItems[" + str + "\n]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.config.WorldCupConfigInfo
 * JD-Core Version:    0.7.0.1
 */