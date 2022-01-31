package com.tencent.mobileqq.ar.ARPromotionMgr;

import akxy;
import akyd;
import akyo;
import akyp;
import akyu;
import akyy;
import alfy;
import alis;
import android.text.TextUtils;
import bblp;
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
  public static final String TAG = akyy.jdField_a_of_type_JavaLangString;
  public static final int zipIndex_0 = 0;
  public static final int zipIndex_1 = 1;
  public static final int zipIndex_2 = 2;
  public static final int zipIndex_3 = 3;
  public String activityid = "-1";
  public long config364Version;
  ArCloudConfigInfo mArCloudConfigInfo = null;
  public boolean mainswitch = false;
  public TreeMap<String, akyo> operationInfos = new TreeMap();
  public boolean showInTopView;
  public boolean showOnce;
  String version = "-1";
  
  static boolean set364ZipItem(ArCloudConfigInfo paramArCloudConfigInfo, akyo paramakyo)
  {
    int k = 0;
    int j = 0;
    if (paramArCloudConfigInfo == null)
    {
      QLog.w(TAG, 1, "setZipItem，没有364信息");
      return false;
    }
    akyo.a(paramakyo, paramArCloudConfigInfo);
    int i = k;
    akyp localakyp;
    if (paramArCloudConfigInfo.jdField_a_of_type_Akyd != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Akyd.jdField_a_of_type_JavaLangString))
      {
        i = k;
        if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Akyd.jdField_b_of_type_JavaLangString))
        {
          i = j;
          if (paramArCloudConfigInfo.jdField_a_of_type_Akyd.jdField_a_of_type_Int == 1) {
            i = 1;
          }
          localakyp = new akyp(paramakyo.jdField_a_of_type_JavaLangString, 1);
          localakyp.jdField_b_of_type_Int = i;
          localakyp.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Akyd.jdField_a_of_type_JavaLangString;
          localakyp.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Akyd.jdField_b_of_type_JavaLangString;
          localakyp.c = (akxy.b() + localakyp.jdField_b_of_type_JavaLangString + ".zip");
          localakyp.d = (akxy.b() + localakyp.jdField_b_of_type_JavaLangString + File.separator);
          akyo.a(paramakyo).put(Integer.valueOf(localakyp.jdField_a_of_type_Int), localakyp);
        }
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString)))
    {
      localakyp = new akyp(paramakyo.jdField_a_of_type_JavaLangString, 2);
      localakyp.jdField_b_of_type_Int = i;
      localakyp.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
      localakyp.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
      localakyp.c = (akxy.a() + localakyp.jdField_b_of_type_JavaLangString + akxy.jdField_a_of_type_JavaLangString);
      localakyp.d = (akxy.a() + localakyp.jdField_b_of_type_JavaLangString + File.separator);
      akyo.a(paramakyo).put(Integer.valueOf(localakyp.jdField_a_of_type_Int), localakyp);
    }
    return true;
  }
  
  public akyo getActivityItem()
  {
    akyo localakyo = getItem(this.activityid);
    if ((localakyo != null) && (akyy.a(localakyo.jdField_a_of_type_Long, localakyo.jdField_b_of_type_Long))) {
      return localakyo;
    }
    return null;
  }
  
  public akyo getItem(String paramString)
  {
    return (akyo)this.operationInfos.get(paramString);
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
        j = bblp.a(this.mUin);
        str = bblp.a(this.mUin);
        if (str != null) {
          break;
        }
      } while (!AudioHelper.e());
      QLog.w(TAG, 1, "loadResConfig, 没有json");
      return -1;
      this.mArCloudConfigInfo = alfy.a(str);
      if (this.mArCloudConfigInfo != null) {
        break;
      }
    } while (!AudioHelper.e());
    QLog.w(TAG, 1, "loadResConfig, 没有arCloudConfigInfo");
    return -1;
    if (this.mArCloudConfigInfo.jdField_b_of_type_JavaLangString == null) {
      this.mArCloudConfigInfo.jdField_b_of_type_JavaLangString = this.activityid;
    }
    this.mArCloudConfigInfo.jdField_a_of_type_JavaLangString = "2.0";
    this.mArCloudConfigInfo.d = 8;
    this.mArCloudConfigInfo.c = 2;
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = new ArFeatureInfo();
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d = (alis.a() + "ar_cloud_marker_model/" + this.mArCloudConfigInfo.d + File.separator);
    if (this.mArCloudConfigInfo.jdField_a_of_type_Akyd != null) {
      this.mArCloudConfigInfo.jdField_a_of_type_Akyd.jdField_a_of_type_Boolean = true;
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
            akyo localakyo = new akyo();
            localakyo.jdField_a_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
            localakyo.jdField_b_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
            localakyo.c = Integer.valueOf(localJSONObject.getString("recoglizeMask")).intValue();
            localakyo.jdField_a_of_type_JavaLangString = localJSONObject.getString("id");
            localakyo.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
            localakyo.jdField_a_of_type_Boolean = localJSONObject.optBoolean("need364");
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
                localObject = new akyp(localakyo.jdField_a_of_type_JavaLangString, 0);
                ((akyp)localObject).jdField_a_of_type_JavaLangString = localJSONObject.getString("urlEntry");
                ((akyp)localObject).jdField_b_of_type_JavaLangString = localJSONObject.getString("md5Entry");
                ((akyp)localObject).c = akyu.a(((akyp)localObject).e, 0, ((akyp)localObject).jdField_b_of_type_JavaLangString);
                ((akyp)localObject).d = akyu.b(((akyp)localObject).e, 0, ((akyp)localObject).jdField_b_of_type_JavaLangString);
                akyo.a(localakyo).put(Integer.valueOf(((akyp)localObject).jdField_a_of_type_Int), localObject);
                if (localakyo.jdField_a_of_type_Boolean)
                {
                  loadResConfig();
                  set364ZipItem(this.mArCloudConfigInfo, localakyo);
                }
                this.operationInfos.put(localakyo.jdField_a_of_type_JavaLangString, localakyo);
                i += 1;
                break;
              }
              localakyo.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject);
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
    akyo localakyo;
    for (String str = ""; localIterator.hasNext(); str = str + "\n" + localakyo) {
      localakyo = (akyo)localIterator.next();
    }
    return "task_id[" + this.task_id + "], _parseRet[" + this._parseRet + "], mUin[" + this.mUin + "], version[" + this.version + "], enable[" + this.mainswitch + "], activityid[" + this.activityid + "], config364Version[" + this.config364Version + "], Items[" + str + "\n]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */