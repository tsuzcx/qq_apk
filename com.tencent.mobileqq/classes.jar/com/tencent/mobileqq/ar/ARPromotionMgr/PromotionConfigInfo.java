package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionConstant;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerJsonParser;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
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
  static final String TAG = PromotionUtil.jdField_a_of_type_JavaLangString;
  public static final int zipIndex_0 = 0;
  public static final int zipIndex_1 = 1;
  public static final int zipIndex_2 = 2;
  public static final int zipIndex_3 = 3;
  String activityid = "-1";
  public long config364Version = 0L;
  ArCloudConfigInfo mArCloudConfigInfo = null;
  boolean mainswitch = false;
  TreeMap<String, PromotionConfigInfo.PromotionItem> operationInfos = new TreeMap();
  public boolean showInTopView = false;
  public boolean showOnce = false;
  String version = "-1";
  
  static boolean set364ZipItem(ArCloudConfigInfo paramArCloudConfigInfo, PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    int k = 0;
    int j = 0;
    if (paramArCloudConfigInfo == null)
    {
      QLog.w(TAG, 1, "setZipItem，没有364信息");
      return false;
    }
    PromotionConfigInfo.PromotionItem.a(paramPromotionItem, paramArCloudConfigInfo);
    int i = k;
    PromotionConfigInfo.ZipItem localZipItem;
    if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_JavaLangString))
      {
        i = k;
        if (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString))
        {
          i = j;
          if (paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Int == 1) {
            i = 1;
          }
          localZipItem = new PromotionConfigInfo.ZipItem(paramPromotionItem.jdField_a_of_type_JavaLangString, 1);
          localZipItem.jdField_b_of_type_Int = i;
          localZipItem.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_JavaLangString;
          localZipItem.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_b_of_type_JavaLangString;
          localZipItem.c = (ARPromotionConstant.b() + localZipItem.jdField_b_of_type_JavaLangString + ".zip");
          localZipItem.d = (ARPromotionConstant.b() + localZipItem.jdField_b_of_type_JavaLangString + File.separator);
          PromotionConfigInfo.PromotionItem.a(paramPromotionItem).put(Integer.valueOf(localZipItem.jdField_a_of_type_Int), localZipItem);
        }
      }
    }
    if ((paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString)))
    {
      localZipItem = new PromotionConfigInfo.ZipItem(paramPromotionItem.jdField_a_of_type_JavaLangString, 2);
      localZipItem.jdField_b_of_type_Int = i;
      localZipItem.jdField_a_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_b_of_type_JavaLangString;
      localZipItem.jdField_b_of_type_JavaLangString = paramArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArModelResource.jdField_a_of_type_JavaLangString;
      localZipItem.c = (ARPromotionConstant.a() + localZipItem.jdField_b_of_type_JavaLangString + ARPromotionConstant.jdField_a_of_type_JavaLangString);
      localZipItem.d = (ARPromotionConstant.a() + localZipItem.jdField_b_of_type_JavaLangString + File.separator);
      PromotionConfigInfo.PromotionItem.a(paramPromotionItem).put(Integer.valueOf(localZipItem.jdField_a_of_type_Int), localZipItem);
    }
    return true;
  }
  
  public PromotionConfigInfo.PromotionItem getActivityItem()
  {
    PromotionConfigInfo.PromotionItem localPromotionItem = getItem(this.activityid);
    if ((localPromotionItem != null) && (PromotionUtil.a(localPromotionItem.jdField_a_of_type_Long, localPromotionItem.jdField_b_of_type_Long))) {
      return localPromotionItem;
    }
    return null;
  }
  
  public PromotionConfigInfo.PromotionItem getItem(String paramString)
  {
    return (PromotionConfigInfo.PromotionItem)this.operationInfos.get(paramString);
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
        j = ARPromotionConfigSP.a(this.mUin);
        str = ARPromotionConfigSP.a(this.mUin);
        if (str != null) {
          break;
        }
      } while (!AudioHelper.e());
      QLog.w(TAG, 1, "loadResConfig, 没有json");
      return -1;
      this.mArCloudConfigInfo = ARCloudMarkerJsonParser.a(str);
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
    this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo.d = (ARResouceDir.a() + "ar_cloud_marker_model/" + this.mArCloudConfigInfo.d + File.separator);
    if (this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) {
      this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Boolean = true;
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
            PromotionConfigInfo.PromotionItem localPromotionItem = new PromotionConfigInfo.PromotionItem();
            localPromotionItem.jdField_a_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("begin")).getTime();
            localPromotionItem.jdField_b_of_type_Long = localSimpleDateFormat.parse(localJSONObject.optString("end")).getTime();
            localPromotionItem.c = Integer.valueOf(localJSONObject.getString("recoglizeMask")).intValue();
            localPromotionItem.jdField_a_of_type_JavaLangString = localJSONObject.getString("id");
            localPromotionItem.jdField_b_of_type_JavaLangString = localJSONObject.optString("title");
            localPromotionItem.jdField_a_of_type_Boolean = localJSONObject.optBoolean("need364");
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
                localObject = new PromotionConfigInfo.ZipItem(localPromotionItem.jdField_a_of_type_JavaLangString, 0);
                ((PromotionConfigInfo.ZipItem)localObject).jdField_a_of_type_JavaLangString = localJSONObject.getString("urlEntry");
                ((PromotionConfigInfo.ZipItem)localObject).jdField_b_of_type_JavaLangString = localJSONObject.getString("md5Entry");
                ((PromotionConfigInfo.ZipItem)localObject).c = PromotionPath.a(((PromotionConfigInfo.ZipItem)localObject).e, 0, ((PromotionConfigInfo.ZipItem)localObject).jdField_b_of_type_JavaLangString);
                ((PromotionConfigInfo.ZipItem)localObject).d = PromotionPath.b(((PromotionConfigInfo.ZipItem)localObject).e, 0, ((PromotionConfigInfo.ZipItem)localObject).jdField_b_of_type_JavaLangString);
                ARResouceDir.a(((PromotionConfigInfo.ZipItem)localObject).d + ".nomedia");
                PromotionConfigInfo.PromotionItem.a(localPromotionItem).put(Integer.valueOf(((PromotionConfigInfo.ZipItem)localObject).jdField_a_of_type_Int), localObject);
                if (localPromotionItem.jdField_a_of_type_Boolean)
                {
                  loadResConfig();
                  set364ZipItem(this.mArCloudConfigInfo, localPromotionItem);
                }
                this.operationInfos.put(localPromotionItem.jdField_a_of_type_JavaLangString, localPromotionItem);
                i += 1;
                break;
              }
              localPromotionItem.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject);
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
    PromotionConfigInfo.PromotionItem localPromotionItem;
    for (String str = ""; localIterator.hasNext(); str = str + "\n" + localPromotionItem) {
      localPromotionItem = (PromotionConfigInfo.PromotionItem)localIterator.next();
    }
    return "task_id[" + this.task_id + "], _parseRet[" + this._parseRet + "], mUin[" + this.mUin + "], version[" + this.version + "], enable[" + this.mainswitch + "], activityid[" + this.activityid + "], config364Version[" + this.config364Version + "], Items[" + str + "\n]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */