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
  static final String TAG = PromotionUtil.a;
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
    if (paramArCloudConfigInfo.r != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramArCloudConfigInfo.r.f))
      {
        i = k;
        if (!TextUtils.isEmpty(paramArCloudConfigInfo.r.h))
        {
          i = j;
          if (paramArCloudConfigInfo.r.b == 1) {
            i = 1;
          }
          localZipItem = new PromotionConfigInfo.ZipItem(paramPromotionItem.e, 1);
          localZipItem.g = i;
          localZipItem.b = paramArCloudConfigInfo.r.f;
          localZipItem.c = paramArCloudConfigInfo.r.h;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(ARPromotionConstant.b());
          localStringBuilder.append(localZipItem.c);
          localStringBuilder.append(".zip");
          localZipItem.d = localStringBuilder.toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ARPromotionConstant.b());
          localStringBuilder.append(localZipItem.c);
          localStringBuilder.append(File.separator);
          localZipItem.e = localStringBuilder.toString();
          PromotionConfigInfo.PromotionItem.a(paramPromotionItem).put(Integer.valueOf(localZipItem.a), localZipItem);
        }
      }
    }
    if ((paramArCloudConfigInfo.k != null) && (!TextUtils.isEmpty(paramArCloudConfigInfo.k.c)) && (!TextUtils.isEmpty(paramArCloudConfigInfo.k.b)))
    {
      localZipItem = new PromotionConfigInfo.ZipItem(paramPromotionItem.e, 2);
      localZipItem.g = i;
      localZipItem.b = paramArCloudConfigInfo.k.c;
      localZipItem.c = paramArCloudConfigInfo.k.b;
      paramArCloudConfigInfo = new StringBuilder();
      paramArCloudConfigInfo.append(ARPromotionConstant.a());
      paramArCloudConfigInfo.append(localZipItem.c);
      paramArCloudConfigInfo.append(ARPromotionConstant.a);
      localZipItem.d = paramArCloudConfigInfo.toString();
      paramArCloudConfigInfo = new StringBuilder();
      paramArCloudConfigInfo.append(ARPromotionConstant.a());
      paramArCloudConfigInfo.append(localZipItem.c);
      paramArCloudConfigInfo.append(File.separator);
      localZipItem.e = paramArCloudConfigInfo.toString();
      PromotionConfigInfo.PromotionItem.a(paramPromotionItem).put(Integer.valueOf(localZipItem.a), localZipItem);
    }
    return true;
  }
  
  public PromotionConfigInfo.PromotionItem getActivityItem()
  {
    PromotionConfigInfo.PromotionItem localPromotionItem = getItem(this.activityid);
    if ((localPromotionItem != null) && (PromotionUtil.a(localPromotionItem.a, localPromotionItem.b))) {
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
    int i = ARPromotionConfigSP.d(this.mUin);
    Object localObject = ARPromotionConfigSP.c(this.mUin);
    if (localObject == null)
    {
      if (QQAudioHelper.f()) {
        QLog.w(TAG, 1, "loadResConfig, 没有json");
      }
      return -1;
    }
    this.mArCloudConfigInfo = ARCloudMarkerJsonParser.a((String)localObject);
    localObject = this.mArCloudConfigInfo;
    if (localObject == null)
    {
      if (QQAudioHelper.f()) {
        QLog.w(TAG, 1, "loadResConfig, 没有arCloudConfigInfo");
      }
      return -1;
    }
    if (((ArCloudConfigInfo)localObject).f == null) {
      this.mArCloudConfigInfo.f = this.activityid;
    }
    localObject = this.mArCloudConfigInfo;
    ((ArCloudConfigInfo)localObject).b = "2.0";
    ((ArCloudConfigInfo)localObject).e = 8;
    ((ArCloudConfigInfo)localObject).d = 2;
    ((ArCloudConfigInfo)localObject).j = new ArFeatureInfo();
    localObject = this.mArCloudConfigInfo.j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ARResouceDir.a());
    localStringBuilder.append("ar_cloud_marker_model/");
    localStringBuilder.append(this.mArCloudConfigInfo.e);
    localStringBuilder.append(File.separator);
    ((ArFeatureInfo)localObject).e = localStringBuilder.toString();
    if (this.mArCloudConfigInfo.r != null) {
      this.mArCloudConfigInfo.r.a = true;
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
          localPromotionItem.a = localSimpleDateFormat.parse(((JSONObject)localObject1).optString("begin")).getTime();
          localPromotionItem.b = localSimpleDateFormat.parse(((JSONObject)localObject1).optString("end")).getTime();
          localPromotionItem.d = Integer.valueOf(((JSONObject)localObject1).getString("recoglizeMask")).intValue();
          localPromotionItem.e = ((JSONObject)localObject1).getString("id");
          localPromotionItem.f = ((JSONObject)localObject1).optString("title");
          localPromotionItem.c = ((JSONObject)localObject1).optBoolean("need364");
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
            localPromotionItem.g.put(Integer.valueOf(j), localObject2);
            j += 1;
          }
          Object localObject2 = new PromotionConfigInfo.ZipItem(localPromotionItem.e, 0);
          ((PromotionConfigInfo.ZipItem)localObject2).b = ((JSONObject)localObject1).getString("urlEntry");
          ((PromotionConfigInfo.ZipItem)localObject2).c = ((JSONObject)localObject1).getString("md5Entry");
          ((PromotionConfigInfo.ZipItem)localObject2).d = PromotionPath.a(((PromotionConfigInfo.ZipItem)localObject2).f, 0, ((PromotionConfigInfo.ZipItem)localObject2).c);
          ((PromotionConfigInfo.ZipItem)localObject2).e = PromotionPath.b(((PromotionConfigInfo.ZipItem)localObject2).f, 0, ((PromotionConfigInfo.ZipItem)localObject2).c);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(((PromotionConfigInfo.ZipItem)localObject2).e);
          ((StringBuilder)localObject1).append(".nomedia");
          ARResouceDir.b(((StringBuilder)localObject1).toString());
          PromotionConfigInfo.PromotionItem.a(localPromotionItem).put(Integer.valueOf(((PromotionConfigInfo.ZipItem)localObject2).a), localObject2);
          if (localPromotionItem.c)
          {
            loadResConfig();
            set364ZipItem(this.mArCloudConfigInfo, localPromotionItem);
          }
          this.operationInfos.put(localPromotionItem.e, localPromotionItem);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo
 * JD-Core Version:    0.7.0.1
 */