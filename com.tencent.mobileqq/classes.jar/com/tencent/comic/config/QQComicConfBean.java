package com.tencent.comic.config;

import android.text.TextUtils;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.data.BoodoHippyConfig;
import com.tencent.comic.data.ComicCancelRedPointPopConfig;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.IPExpressionConfig;
import com.tencent.comic.utils.VersionUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQComicConfBean
{
  private QQComicConfBean.ComicReaderConfig jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig = new QQComicConfBean.ComicReaderConfig();
  private QQComicConfBean.ServiceAccountConfig jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ServiceAccountConfig = new QQComicConfBean.ServiceAccountConfig();
  public QQComicConfBean.WebBundleConfig a;
  private BoodoHippyConfig jdField_a_of_type_ComTencentComicDataBoodoHippyConfig = new BoodoHippyConfig();
  private ComicCancelRedPointPopConfig jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig = new ComicCancelRedPointPopConfig();
  private IPExpressionConfig jdField_a_of_type_ComTencentComicDataIPExpressionConfig = new IPExpressionConfig();
  public Map<String, String> a;
  
  public QQComicConfBean()
  {
    this.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$WebBundleConfig = new QQComicConfBean.WebBundleConfig(this);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static QQComicConfBean.ComicReaderConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig;
  }
  
  public static QQComicConfBean.ServiceAccountConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ServiceAccountConfig;
  }
  
  public static QQComicConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject3 = paramArrayOfQConfItem;
    Object localObject2 = "urlConfig";
    Object localObject1 = "webbundle";
    Object localObject4 = "hippyConfig";
    if ((localObject3 != null) && (localObject3.length != 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicConfBean", 2, "parse");
      }
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        QQComicConfBean localQQComicConfBean = new QQComicConfBean();
        int k = localObject3.length;
        i = 0;
        localObject3 = localObject4;
        if (i < k)
        {
          localObject4 = paramArrayOfQConfItem[i];
          if (TextUtils.isEmpty(((QConfItem)localObject4).jdField_a_of_type_JavaLangString)) {
            break label1566;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQComicConfBean", 2, new Object[] { "parse, content=", ((QConfItem)localObject4).jdField_a_of_type_JavaLangString });
          }
          Object localObject7 = new JSONObject(((QConfItem)localObject4).jdField_a_of_type_JavaLangString);
          int m;
          if (((JSONObject)localObject7).has((String)localObject3))
          {
            localObject4 = ((JSONObject)localObject7).optJSONObject((String)localObject3);
            if (localObject4 == null) {
              break label1534;
            }
            localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mHippyStatus = ((JSONObject)localObject4).optInt("hippyStatus");
            localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mMainModuleName = ((JSONObject)localObject4).optString("mainModuleName");
            localObject5 = ((JSONObject)localObject4).optJSONArray("preloadModules");
            localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mPreloadModules.clear();
            m = ((JSONArray)localObject5).length();
            j = 0;
            if (j < m)
            {
              localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mPreloadModules.add(((JSONArray)localObject5).optString(j));
              j += 1;
              continue;
            }
            localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mAllModules.clear();
            localObject5 = ((JSONObject)localObject4).optJSONArray("allModules");
            m = ((JSONArray)localObject5).length();
            j = 0;
            if (j < m)
            {
              localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mAllModules.add(((JSONArray)localObject5).optString(j));
              j += 1;
              continue;
            }
            localQQComicConfBean.jdField_a_of_type_ComTencentComicDataBoodoHippyConfig.mPsKeyHost = ((JSONObject)localObject4).optString("pskeyHost");
            localObject6 = localObject2;
            localObject5 = localObject1;
            break label1542;
          }
          localObject4 = localObject3;
          bool = ((JSONObject)localObject7).has("ipEmoji");
          Object localObject8;
          if (bool)
          {
            localObject7 = ((JSONObject)localObject7).optJSONObject("ipEmoji");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (localObject7 == null) {
              break label1542;
            }
            localQQComicConfBean.jdField_a_of_type_ComTencentComicDataIPExpressionConfig.mPrefixUrl = ((JSONObject)localObject7).optString("url");
            localObject7 = ((JSONObject)localObject7).optJSONObject("matchList");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (localObject7 == null) {
              break label1542;
            }
            localObject8 = ((JSONObject)localObject7).keys();
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (!((Iterator)localObject8).hasNext()) {
              break label1542;
            }
            localObject3 = (String)((Iterator)localObject8).next();
            localObject5 = localQQComicConfBean.jdField_a_of_type_ComTencentComicDataIPExpressionConfig.mExpressionMap;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(localQQComicConfBean.jdField_a_of_type_ComTencentComicDataIPExpressionConfig.mPrefixUrl);
            ((StringBuilder)localObject6).append(((JSONObject)localObject7).optString((String)localObject3));
            ((HashMap)localObject5).put(localObject3, ((StringBuilder)localObject6).toString());
            continue;
          }
          bool = ((JSONObject)localObject7).has((String)localObject1);
          if (bool)
          {
            localObject7 = ((JSONObject)localObject7).optJSONObject((String)localObject1);
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (localObject7 == null) {
              break label1542;
            }
            localObject7 = ((JSONObject)localObject7).optJSONObject("qqcomic");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (localObject7 == null) {
              break label1542;
            }
            localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$WebBundleConfig.jdField_a_of_type_Boolean = ((JSONObject)localObject7).optBoolean("enable", false);
            localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$WebBundleConfig.jdField_a_of_type_JavaLangString = ((JSONObject)localObject7).optString("preload_url", "");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            break label1542;
          }
          if (((JSONObject)localObject7).has((String)localObject2))
          {
            localObject7 = ((JSONObject)localObject7).optJSONArray((String)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("QQComicConfBean", 2, new Object[] { "parse, urlConfig=", localObject7 });
            }
            m = ((JSONArray)localObject7).length();
            j = 0;
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (j >= m) {
              break label1542;
            }
            localObject8 = ((JSONArray)localObject7).getJSONObject(j);
            localObject6 = ((JSONObject)localObject8).optString("bizName");
            if (TextUtils.isEmpty((CharSequence)localObject6)) {
              break label1553;
            }
            if (VersionUtils.a("8.7.0", ((JSONObject)localObject8).optString("minVersion"), ((JSONObject)localObject8).optString("maxVersion")))
            {
              localObject5 = ((JSONObject)localObject8).optString("androidUrl");
              localObject3 = localObject5;
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject3 = ((JSONObject)localObject8).optString("url");
              }
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label1553;
              }
              localQQComicConfBean.jdField_a_of_type_JavaUtilMap.put(localObject6, localObject3);
              QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", localObject6, ", url=", localObject3 });
              break label1553;
            }
            QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", localObject6, ", version not match" });
            break label1553;
          }
          localObject5 = localObject2;
          localObject6 = localObject1;
          if (((JSONObject)localObject7).has("serviceAccount"))
          {
            localObject7 = ((JSONObject)localObject7).optJSONObject("serviceAccount");
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            if (localObject7 == null) {
              break label1566;
            }
            QQComicConfBean.ServiceAccountConfig.a(localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ServiceAccountConfig, ((JSONObject)localObject7).optString("uin"));
            QQComicConfBean.ServiceAccountConfig.b(localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ServiceAccountConfig, ((JSONObject)localObject7).optString("url"));
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            break label1566;
          }
          if (((JSONObject)localObject7).has("comicReader"))
          {
            localObject7 = ((JSONObject)localObject7).optJSONObject("comicReader");
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            if (localObject7 == null) {
              break label1566;
            }
            localObject1 = ((JSONObject)localObject7).optJSONObject("newVersion");
            if (localObject1 != null)
            {
              localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig.enableNewVersion = ((JSONObject)localObject1).optBoolean("enable");
              localObject2 = ((JSONObject)localObject1).optJSONObject("preload");
              if (localObject2 != null)
              {
                localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig.enablePreload = ((JSONObject)localObject2).optBoolean("enable");
                localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig.preloadNum = ((JSONObject)localObject2).optInt("maxNum");
              }
            }
            localObject2 = ((JSONObject)localObject7).optJSONObject("preRead");
            if (localObject1 != null) {
              localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig.enablePreRead = ((JSONObject)localObject2).optBoolean("enable");
            }
            localObject7 = ((JSONObject)localObject7).optJSONObject("sectionComment");
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            if (localObject7 == null) {
              break label1566;
            }
            j = ((JSONObject)localObject7).optInt("commentNumVS", 1);
            if (j < 0) {
              j = 0;
            } else {
              j = Math.min(j, 3);
            }
            localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig.sectionCommentNumVS = j;
            localObject1 = localQQComicConfBean.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ComicReaderConfig;
            if (((JSONObject)localObject7).optInt("masterSwitch", 0) != 1) {
              break label1560;
            }
            bool = true;
            ((QQComicConfBean.ComicReaderConfig)localObject1).sectionCommentMasterSwitch = bool;
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            break label1566;
          }
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (!((JSONObject)localObject7).has("cancelRedPointPopConfig")) {
            break label1566;
          }
          localObject7 = ((JSONObject)localObject7).optJSONObject("cancelRedPointPopConfig");
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (localObject7 == null) {
            break label1566;
          }
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.popSwitch = ((JSONObject)localObject7).optInt("popSwitch", 0);
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.enableLocalCache = ((JSONObject)localObject7).optInt("enableCache", 1);
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.ignoreRedDot = ((JSONObject)localObject7).optInt("ignoreRedDot", 0);
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.dayCount = ((JSONObject)localObject7).optInt("dayCount", 1);
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.ignoreInteractiveControll = ((JSONObject)localObject7).optInt("ignoreInteractive", 0);
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.list.clear();
          localObject7 = ((JSONObject)localObject7).optJSONArray("list");
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (localObject7 == null) {
            break label1566;
          }
          localObject7 = ComicCancelRedPointPopItemData.parseFromJsonArray((JSONArray)localObject7, true);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (((List)localObject7).isEmpty()) {
            break label1566;
          }
          localQQComicConfBean.jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig.list.addAll((Collection)localObject7);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          break label1566;
        }
        VipComicHelper.a((String)localQQComicConfBean.jdField_a_of_type_JavaUtilMap.get("danmuAnswerUrl"));
        QLog.d("QQComicConfBean", 1, new Object[] { "parse, confBean=", localQQComicConfBean });
        return localQQComicConfBean;
      }
      catch (Exception paramArrayOfQConfItem)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQComicConfBean", 1, new Object[] { "parse e:", paramArrayOfQConfItem.toString() });
        }
        return null;
      }
      return null;
      label1534:
      Object localObject5 = localObject1;
      Object localObject6 = localObject2;
      label1542:
      localObject2 = localObject6;
      localObject1 = localObject5;
      break label1566;
      label1553:
      j += 1;
      continue;
      label1560:
      boolean bool = false;
      continue;
      label1566:
      i += 1;
    }
  }
  
  public static BoodoHippyConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentComicDataBoodoHippyConfig;
  }
  
  public static ComicCancelRedPointPopConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentComicDataComicCancelRedPointPopConfig;
  }
  
  public static IPExpressionConfig a()
  {
    return ((QQComicConfBean)QConfigManager.a().a(534)).jdField_a_of_type_ComTencentComicDataIPExpressionConfig;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$WebBundleConfig);
    localStringBuilder.append(" ,urlConfigMap:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap);
    localStringBuilder.append(" ,serviceAccountConfig:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentComicConfigQQComicConfBean$ServiceAccountConfig);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean
 * JD-Core Version:    0.7.0.1
 */