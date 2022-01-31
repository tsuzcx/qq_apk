package com.tencent.mobileqq.ar.ARPromotionMgr;

import amtc;
import amth;
import amts;
import amtt;
import amty;
import amuc;
import anaw;
import andq;
import android.text.TextUtils;
import bdpg;
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
  public static final String TAG = amuc.jdField_a_of_type_JavaLangString;
  public static final int zipIndex_0 = 0;
  public static final int zipIndex_1 = 1;
  public static final int zipIndex_2 = 2;
  public static final int zipIndex_3 = 3;
  public String activityid = "-1";
  public long config364Version;
  ArCloudConfigInfo mArCloudConfigInfo = null;
  public boolean mainswitch = false;
  public TreeMap<String, amts> operationInfos = new TreeMap();
  public boolean showInTopView;
  public boolean showOnce;
  String version = "-1";
  
  static boolean set364ZipItem(ArCloudConfigInfo paramArCloudConfigInfo, amts paramamts)
  {
    int k = 0;
    int j = 0;
    if (paramArCloudConfigInfo == null)
    {
      QLog.w(TAG, 1, "setZipItem，没有364信息");
      return false;
    }
    amts.a(paramamts, paramArCloudConfigInfo);
    int i = k;
    amtt localamtt;
    if (paramArCloudConfigInfo.jdField_a_of_type_Amth != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_a_of_type_JavaLangString))
      {
        i = k;
        if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_b_of_type_JavaLangString))
        {
          i = j;
          if (paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_a_of_type_Int == 1) {
            i = 1;
          }
          localamtt = new amtt(paramamts.jdField_a_of_type_JavaLangString, 1);
          localamtt.jdField_b_of_type_Int = i;
          localamtt.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_a_of_type_JavaLangString;
          localamtt.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_Amth.jdField_b_of_type_JavaLangString;
          localamtt.c = (amtc.b() + localamtt.jdField_b_of_type_JavaLangString + ".zip");
          localamtt.d = (amtc.b() + localamtt.jdField_b_of_type_JavaLangString + File.separator);
          amts.a(paramamts).put(Integer.valueOf(localamtt.jdField_a_of_type_Int), localamtt);
        }
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString)))
    {
      localamtt = new amtt(paramamts.jdField_a_of_type_JavaLangString, 2);
      localamtt.jdField_b_of_type_Int = i;
      localamtt.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
      localamtt.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
      localamtt.c = (amtc.a() + localamtt.jdField_b_of_type_JavaLangString + amtc.jdField_a_of_type_JavaLangString);
      localamtt.d = (amtc.a() + localamtt.jdField_b_of_type_JavaLangString + File.separator);
      amts.a(paramamts).put(Integer.valueOf(localamtt.jdField_a_of_type_Int), localamtt);
    }
    return true;
  }
  
  public amts getActivityItem()
  {
    amts localamts = getItem(this.activityid);
    if ((localamts != null) && (amuc.a(localamts.jdField_a_of_type_Long, localamts.jdField_b_of_type_Long))) {
      return localamts;
    }
    return null;
  }
  
  public amts getItem(String paramString)
  {
    return (amts)this.operationInfos.get(paramString);
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
        j = bdpg.a(this.mUin);
        str = bdpg.a(this.mUin);
        if (str != null) {
          break;
        }
      } while (!AudioHelper.e());
      QLog.w(TAG, 1, "loadResConfig, 没有json");
      return -1;
      this.mArCloudConfigInfo = anaw.a(str);
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
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d = (andq.a() + "ar_cloud_marker_model/" + this.mArCloudConfigInfo.d + File.separator);
    if (this.mArCloudConfigInfo.jdField_a_of_type_Amth != null) {
      this.mArCloudConfigInfo.jdField_a_of_type_Amth.jdField_a_of_type_Boolean = true;
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
            amts localamts = new amts();
            localamts.jdField_a_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
            localamts.jdField_b_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
            localamts.c = Integer.valueOf(localJSONObject.getString("recoglizeMask")).intValue();
            localamts.jdField_a_of_type_JavaLangString = localJSONObject.getString("id");
            localamts.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
            localamts.jdField_a_of_type_Boolean = localJSONObject.optBoolean("need364");
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
                localObject = new amtt(localamts.jdField_a_of_type_JavaLangString, 0);
                ((amtt)localObject).jdField_a_of_type_JavaLangString = localJSONObject.getString("urlEntry");
                ((amtt)localObject).jdField_b_of_type_JavaLangString = localJSONObject.getString("md5Entry");
                ((amtt)localObject).c = amty.a(((amtt)localObject).e, 0, ((amtt)localObject).jdField_b_of_type_JavaLangString);
                ((amtt)localObject).d = amty.b(((amtt)localObject).e, 0, ((amtt)localObject).jdField_b_of_type_JavaLangString);
                amts.a(localamts).put(Integer.valueOf(((amtt)localObject).jdField_a_of_type_Int), localObject);
                if (localamts.jdField_a_of_type_Boolean)
                {
                  loadResConfig();
                  set364ZipItem(this.mArCloudConfigInfo, localamts);
                }
                this.operationInfos.put(localamts.jdField_a_of_type_JavaLangString, localamts);
                i += 1;
                break;
              }
              localamts.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject);
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
    amts localamts;
    for (String str = ""; localIterator.hasNext(); str = str + "\n" + localamts) {
      localamts = (amts)localIterator.next();
    }
    return "task_id[" + this.task_id + "], _parseRet[" + this._parseRet + "], mUin[" + this.mUin + "], version[" + this.version + "], enable[" + this.mainswitch + "], activityid[" + this.activityid + "], config364Version[" + this.config364Version + "], Items[" + str + "\n]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */