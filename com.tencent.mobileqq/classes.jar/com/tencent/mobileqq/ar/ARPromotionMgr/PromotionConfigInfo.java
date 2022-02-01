package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionConstant;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudMarkerJsonParser;
import com.tencent.mobileqq.ar.arengine.ARResouceDir;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.ArModelResource;
import com.tencent.mobileqq.utils.QQAudioHelper;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ARPromotionConstant.b());
          localStringBuilder.append(localZipItem.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(".zip");
          localZipItem.c = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ARPromotionConstant.b());
          localStringBuilder.append(localZipItem.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(File.separator);
          localZipItem.d = localStringBuilder.toString();
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
      paramArCloudConfigInfo = new StringBuilder();
      paramArCloudConfigInfo.append(ARPromotionConstant.a());
      paramArCloudConfigInfo.append(localZipItem.jdField_b_of_type_JavaLangString);
      paramArCloudConfigInfo.append(ARPromotionConstant.jdField_a_of_type_JavaLangString);
      localZipItem.c = paramArCloudConfigInfo.toString();
      paramArCloudConfigInfo = new StringBuilder();
      paramArCloudConfigInfo.append(ARPromotionConstant.a());
      paramArCloudConfigInfo.append(localZipItem.jdField_b_of_type_JavaLangString);
      paramArCloudConfigInfo.append(File.separator);
      localZipItem.d = paramArCloudConfigInfo.toString();
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
    if (this.mArCloudConfigInfo != null) {
      return 0;
    }
    int i = ARPromotionConfigSP.a(this.mUin);
    Object localObject = ARPromotionConfigSP.a(this.mUin);
    if (localObject == null)
    {
      if (QQAudioHelper.c()) {
        QLog.w(TAG, 1, "loadResConfig, 没有json");
      }
      return -1;
    }
    this.mArCloudConfigInfo = ARCloudMarkerJsonParser.a((String)localObject);
    localObject = this.mArCloudConfigInfo;
    if (localObject == null)
    {
      if (QQAudioHelper.c()) {
        QLog.w(TAG, 1, "loadResConfig, 没有arCloudConfigInfo");
      }
      return -1;
    }
    if (((ArCloudConfigInfo)localObject).jdField_b_of_type_JavaLangString == null) {
      this.mArCloudConfigInfo.jdField_b_of_type_JavaLangString = this.activityid;
    }
    localObject = this.mArCloudConfigInfo;
    ((ArCloudConfigInfo)localObject).jdField_a_of_type_JavaLangString = "2.0";
    ((ArCloudConfigInfo)localObject).d = 8;
    ((ArCloudConfigInfo)localObject).c = 2;
    ((ArCloudConfigInfo)localObject).jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo = new ArFeatureInfo();
    localObject = this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArModelArFeatureInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ARResouceDir.a());
    localStringBuilder.append("ar_cloud_marker_model/");
    localStringBuilder.append(this.mArCloudConfigInfo.d);
    localStringBuilder.append(File.separator);
    ((ArFeatureInfo)localObject).d = localStringBuilder.toString();
    if (this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo != null) {
      this.mArCloudConfigInfo.jdField_a_of_type_ComTencentMobileqqArARPromotionARTransferDoorConfigInfo.jdField_a_of_type_Boolean = true;
    }
    this.config364Version = i;
    return i;
  }
  
  protected boolean parse(JSONObject paramJSONObject)
  {
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
      if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          Object localObject1 = paramJSONObject.getJSONObject(i);
          PromotionConfigInfo.PromotionItem localPromotionItem = new PromotionConfigInfo.PromotionItem();
          localPromotionItem.jdField_a_of_type_Long = localSimpleDateFormat.parse(((JSONObject)localObject1).optString("begin")).getTime();
          localPromotionItem.jdField_b_of_type_Long = localSimpleDateFormat.parse(((JSONObject)localObject1).optString("end")).getTime();
          localPromotionItem.c = Integer.valueOf(((JSONObject)localObject1).getString("recoglizeMask")).intValue();
          localPromotionItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("id");
          localPromotionItem.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("title");
          localPromotionItem.jdField_a_of_type_Boolean = ((JSONObject)localObject1).optBoolean("need364");
          int j = 1;
          while (j <= 100)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("tips");
            ((StringBuilder)localObject2).append(j);
            localObject2 = ((JSONObject)localObject1).optString(((StringBuilder)localObject2).toString());
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              break;
            }
            localPromotionItem.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(j), localObject2);
            j += 1;
          }
          Object localObject2 = new PromotionConfigInfo.ZipItem(localPromotionItem.jdField_a_of_type_JavaLangString, 0);
          ((PromotionConfigInfo.ZipItem)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("urlEntry");
          ((PromotionConfigInfo.ZipItem)localObject2).jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("md5Entry");
          ((PromotionConfigInfo.ZipItem)localObject2).c = PromotionPath.a(((PromotionConfigInfo.ZipItem)localObject2).e, 0, ((PromotionConfigInfo.ZipItem)localObject2).jdField_b_of_type_JavaLangString);
          ((PromotionConfigInfo.ZipItem)localObject2).d = PromotionPath.b(((PromotionConfigInfo.ZipItem)localObject2).e, 0, ((PromotionConfigInfo.ZipItem)localObject2).jdField_b_of_type_JavaLangString);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((PromotionConfigInfo.ZipItem)localObject2).d);
          ((StringBuilder)localObject1).append(".nomedia");
          ARResouceDir.a(((StringBuilder)localObject1).toString());
          PromotionConfigInfo.PromotionItem.a(localPromotionItem).put(Integer.valueOf(((PromotionConfigInfo.ZipItem)localObject2).jdField_a_of_type_Int), localObject2);
          if (localPromotionItem.jdField_a_of_type_Boolean)
          {
            loadResConfig();
            set364ZipItem(this.mArCloudConfigInfo, localPromotionItem);
          }
          this.operationInfos.put(localPromotionItem.jdField_a_of_type_JavaLangString, localPromotionItem);
          i += 1;
        }
      }
      return true;
    }
    catch (Exception paramJSONObject)
    {
      QLog.w(TAG, 1, "parseJson, Exception", paramJSONObject);
      this.operationInfos.clear();
    }
    return false;
  }
  
  public String toString()
  {
    Object localObject = this.operationInfos.values().iterator();
    StringBuilder localStringBuilder;
    for (String str = ""; ((Iterator)localObject).hasNext(); str = localStringBuilder.toString())
    {
      PromotionConfigInfo.PromotionItem localPromotionItem = (PromotionConfigInfo.PromotionItem)((Iterator)localObject).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuilder.append(localPromotionItem);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("task_id[");
    ((StringBuilder)localObject).append(this.taskId);
    ((StringBuilder)localObject).append("], _parseRet[");
    ((StringBuilder)localObject).append(this.parseRet);
    ((StringBuilder)localObject).append("], mUin[");
    ((StringBuilder)localObject).append(this.mUin);
    ((StringBuilder)localObject).append("], version[");
    ((StringBuilder)localObject).append(this.version);
    ((StringBuilder)localObject).append("], enable[");
    ((StringBuilder)localObject).append(this.mainswitch);
    ((StringBuilder)localObject).append("], activityid[");
    ((StringBuilder)localObject).append(this.activityid);
    ((StringBuilder)localObject).append("], config364Version[");
    ((StringBuilder)localObject).append(this.config364Version);
    ((StringBuilder)localObject).append("], Items[");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("\n]");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */