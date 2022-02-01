package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import apbx;
import apcc;
import apcn;
import apco;
import apct;
import apcx;
import apjs;
import apmm;
import bhjo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class PromotionConfigInfo
  extends ConfigInfo
{
  public static final String TAG = apcx.jdField_a_of_type_JavaLangString;
  public static final int zipIndex_0 = 0;
  public static final int zipIndex_1 = 1;
  public static final int zipIndex_2 = 2;
  public static final int zipIndex_3 = 3;
  public String activityid = "-1";
  public long config364Version;
  ArCloudConfigInfo mArCloudConfigInfo = null;
  public boolean mainswitch = false;
  public TreeMap<String, apcn> operationInfos = new TreeMap();
  public boolean showInTopView;
  public boolean showOnce;
  String version = "-1";
  
  static boolean set364ZipItem(ArCloudConfigInfo paramArCloudConfigInfo, apcn paramapcn)
  {
    int k = 0;
    int j = 0;
    if (paramArCloudConfigInfo == null)
    {
      QLog.w(TAG, 1, "setZipItem，没有364信息");
      return false;
    }
    apcn.a(paramapcn, paramArCloudConfigInfo);
    int i = k;
    apco localapco;
    if (paramArCloudConfigInfo.jdField_a_of_type_Apcc != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Apcc.jdField_a_of_type_JavaLangString))
      {
        i = k;
        if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Apcc.jdField_b_of_type_JavaLangString))
        {
          i = j;
          if (paramArCloudConfigInfo.jdField_a_of_type_Apcc.jdField_a_of_type_Int == 1) {
            i = 1;
          }
          localapco = new apco(paramapcn.jdField_a_of_type_JavaLangString, 1);
          localapco.jdField_b_of_type_Int = i;
          localapco.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Apcc.jdField_a_of_type_JavaLangString;
          localapco.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Apcc.jdField_b_of_type_JavaLangString;
          localapco.c = (apbx.b() + localapco.jdField_b_of_type_JavaLangString + ".zip");
          localapco.d = (apbx.b() + localapco.jdField_b_of_type_JavaLangString + File.separator);
          apcn.a(paramapcn).put(Integer.valueOf(localapco.jdField_a_of_type_Int), localapco);
        }
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString)))
    {
      localapco = new apco(paramapcn.jdField_a_of_type_JavaLangString, 2);
      localapco.jdField_b_of_type_Int = i;
      localapco.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
      localapco.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
      localapco.c = (apbx.a() + localapco.jdField_b_of_type_JavaLangString + apbx.jdField_a_of_type_JavaLangString);
      localapco.d = (apbx.a() + localapco.jdField_b_of_type_JavaLangString + File.separator);
      apcn.a(paramapcn).put(Integer.valueOf(localapco.jdField_a_of_type_Int), localapco);
    }
    return true;
  }
  
  public apcn getActivityItem()
  {
    apcn localapcn = getItem(this.activityid);
    if ((localapcn != null) && (apcx.a(localapcn.jdField_a_of_type_Long, localapcn.jdField_b_of_type_Long))) {
      return localapcn;
    }
    return null;
  }
  
  public apcn getItem(String paramString)
  {
    return (apcn)this.operationInfos.get(paramString);
  }
  
  int loadResConfig()
  {
    int i = -1;
    if (this.mArCloudConfigInfo != null) {
      i = 0;
    }
    int j;
    do
    {
      String str;
      do
      {
        return i;
        j = bhjo.a(this.mUin);
        str = bhjo.a(this.mUin);
        if (str != null) {
          break;
        }
      } while (!AudioHelper.f());
      QLog.w(TAG, 1, "loadResConfig, 没有json");
      return -1;
      this.mArCloudConfigInfo = apjs.a(str);
      if (this.mArCloudConfigInfo != null) {
        break;
      }
    } while (!AudioHelper.f());
    QLog.w(TAG, 1, "loadResConfig, 没有arCloudConfigInfo");
    return -1;
    if (this.mArCloudConfigInfo.jdField_b_of_type_JavaLangString == null) {
      this.mArCloudConfigInfo.jdField_b_of_type_JavaLangString = this.activityid;
    }
    this.mArCloudConfigInfo.jdField_a_of_type_JavaLangString = "2.0";
    this.mArCloudConfigInfo.d = 8;
    this.mArCloudConfigInfo.c = 2;
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = new ArFeatureInfo();
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d = (apmm.a() + "ar_cloud_marker_model/" + this.mArCloudConfigInfo.d + File.separator);
    if (this.mArCloudConfigInfo.jdField_a_of_type_Apcc != null) {
      this.mArCloudConfigInfo.jdField_a_of_type_Apcc.jdField_a_of_type_Boolean = true;
    }
    this.config364Version = j;
    return j;
  }
  
  public boolean parse(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    ConfigHandler.checkUin(TAG, this.mUin);
    try
    {
      this.operationInfos.clear();
      this.mainswitch = paramJSONObject.getBoolean("mainswitch");
      this.activityid = paramJSONObject.getString("activityid");
      this.version = paramJSONObject.optString("version");
      if (paramJSONObject.has("showInTopView")) {
        this.showInTopView = paramJSONObject.getBoolean("showInTopView");
      }
      if (paramJSONObject.has("showOnce")) {
        this.showOnce = paramJSONObject.getBoolean("showOnce");
      }
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      paramJSONObject = paramJSONObject.optJSONArray("operationInfos");
      boolean bool1 = bool2;
      if (paramJSONObject != null)
      {
        bool1 = bool2;
        if (paramJSONObject.length() > 0)
        {
          int i = 0;
          bool1 = bool2;
          if (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            apcn localapcn = new apcn();
            localapcn.jdField_a_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
            localapcn.jdField_b_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
            localapcn.c = Integer.valueOf(localJSONObject.getString("recoglizeMask")).intValue();
            localapcn.jdField_a_of_type_JavaLangString = localJSONObject.getString("id");
            localapcn.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
            localapcn.jdField_a_of_type_Boolean = localJSONObject.optBoolean("need364");
            int j = 1;
            for (;;)
            {
              Object localObject;
              if (j <= 100)
              {
                localObject = localJSONObject.optString("tips" + j);
                if (!TextUtils.isEmpty((CharSequence)localObject)) {}
              }
              else
              {
                localObject = new apco(localapcn.jdField_a_of_type_JavaLangString, 0);
                ((apco)localObject).jdField_a_of_type_JavaLangString = localJSONObject.getString("urlEntry");
                ((apco)localObject).jdField_b_of_type_JavaLangString = localJSONObject.getString("md5Entry");
                ((apco)localObject).c = apct.a(((apco)localObject).e, 0, ((apco)localObject).jdField_b_of_type_JavaLangString);
                ((apco)localObject).d = apct.b(((apco)localObject).e, 0, ((apco)localObject).jdField_b_of_type_JavaLangString);
                apmm.a(((apco)localObject).d + ".nomedia");
                apcn.a(localapcn).put(Integer.valueOf(((apco)localObject).jdField_a_of_type_Int), localObject);
                if (localapcn.jdField_a_of_type_Boolean)
                {
                  loadResConfig();
                  set364ZipItem(this.mArCloudConfigInfo, localapcn);
                }
                this.operationInfos.put(localapcn.jdField_a_of_type_JavaLangString, localapcn);
                i += 1;
                break;
              }
              localapcn.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject);
              j += 1;
            }
          }
        }
      }
      return bool1;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w(TAG, 1, "parseJson, Exception", paramJSONObject);
      this.operationInfos.clear();
      bool1 = false;
    }
  }
  
  public String toString()
  {
    Iterator localIterator = this.operationInfos.values().iterator();
    apcn localapcn;
    for (String str = ""; localIterator.hasNext(); str = str + "\n" + localapcn) {
      localapcn = (apcn)localIterator.next();
    }
    return "task_id[" + this.task_id + "], _parseRet[" + this._parseRet + "], mUin[" + this.mUin + "], version[" + this.version + "], enable[" + this.mainswitch + "], activityid[" + this.activityid + "], config364Version[" + this.config364Version + "], Items[" + str + "\n]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */