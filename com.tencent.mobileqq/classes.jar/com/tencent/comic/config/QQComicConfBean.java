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
  public QQComicConfBean.WebBundleConfig a = new QQComicConfBean.WebBundleConfig(this);
  public Map<String, String> b = new HashMap();
  private QQComicConfBean.ServiceAccountConfig c = new QQComicConfBean.ServiceAccountConfig();
  private IPExpressionConfig d = new IPExpressionConfig();
  private BoodoHippyConfig e = new BoodoHippyConfig();
  private QQComicConfBean.ComicReaderConfig f = new QQComicConfBean.ComicReaderConfig();
  private ComicCancelRedPointPopConfig g = new ComicCancelRedPointPopConfig();
  
  public static QQComicConfBean.ComicReaderConfig a()
  {
    return ((QQComicConfBean)QConfigManager.b().b(534)).f;
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
          if (TextUtils.isEmpty(((QConfItem)localObject4).b)) {
            break label1551;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQComicConfBean", 2, new Object[] { "parse, content=", ((QConfItem)localObject4).b });
          }
          Object localObject7 = new JSONObject(((QConfItem)localObject4).b);
          int m;
          if (((JSONObject)localObject7).has((String)localObject3))
          {
            localObject4 = ((JSONObject)localObject7).optJSONObject((String)localObject3);
            if (localObject4 == null) {
              break label1519;
            }
            localQQComicConfBean.e.mHippyStatus = ((JSONObject)localObject4).optInt("hippyStatus");
            localQQComicConfBean.e.mMainModuleName = ((JSONObject)localObject4).optString("mainModuleName");
            localObject5 = ((JSONObject)localObject4).optJSONArray("preloadModules");
            localQQComicConfBean.e.mPreloadModules.clear();
            m = ((JSONArray)localObject5).length();
            j = 0;
            if (j < m)
            {
              localQQComicConfBean.e.mPreloadModules.add(((JSONArray)localObject5).optString(j));
              j += 1;
              continue;
            }
            localQQComicConfBean.e.mAllModules.clear();
            localObject5 = ((JSONObject)localObject4).optJSONArray("allModules");
            m = ((JSONArray)localObject5).length();
            j = 0;
            if (j < m)
            {
              localQQComicConfBean.e.mAllModules.add(((JSONArray)localObject5).optString(j));
              j += 1;
              continue;
            }
            localQQComicConfBean.e.mPsKeyHost = ((JSONObject)localObject4).optString("pskeyHost");
            localObject6 = localObject2;
            localObject5 = localObject1;
            break label1527;
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
              break label1527;
            }
            localQQComicConfBean.d.mPrefixUrl = ((JSONObject)localObject7).optString("url");
            localObject7 = ((JSONObject)localObject7).optJSONObject("matchList");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (localObject7 == null) {
              break label1527;
            }
            localObject8 = ((JSONObject)localObject7).keys();
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (!((Iterator)localObject8).hasNext()) {
              break label1527;
            }
            localObject3 = (String)((Iterator)localObject8).next();
            localObject5 = localQQComicConfBean.d.mExpressionMap;
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(localQQComicConfBean.d.mPrefixUrl);
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
              break label1527;
            }
            localObject7 = ((JSONObject)localObject7).optJSONObject("qqcomic");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            if (localObject7 == null) {
              break label1527;
            }
            localQQComicConfBean.a.a = ((JSONObject)localObject7).optBoolean("enable", false);
            localQQComicConfBean.a.b = ((JSONObject)localObject7).optString("preload_url", "");
            localObject6 = localObject2;
            localObject5 = localObject1;
            localObject3 = localObject4;
            break label1527;
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
              break label1527;
            }
            localObject8 = ((JSONArray)localObject7).getJSONObject(j);
            localObject6 = ((JSONObject)localObject8).optString("bizName");
            if (TextUtils.isEmpty((CharSequence)localObject6)) {
              break label1538;
            }
            if (VersionUtils.a("8.8.17", ((JSONObject)localObject8).optString("minVersion"), ((JSONObject)localObject8).optString("maxVersion")))
            {
              localObject5 = ((JSONObject)localObject8).optString("androidUrl");
              localObject3 = localObject5;
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                localObject3 = ((JSONObject)localObject8).optString("url");
              }
              if (TextUtils.isEmpty((CharSequence)localObject3)) {
                break label1538;
              }
              localQQComicConfBean.b.put(localObject6, localObject3);
              QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", localObject6, ", url=", localObject3 });
              break label1538;
            }
            QLog.d("QQComicConfBean", 1, new Object[] { "parse, urlConfig, bizName=", localObject6, ", version not match" });
            break label1538;
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
              break label1551;
            }
            QQComicConfBean.ServiceAccountConfig.a(localQQComicConfBean.c, ((JSONObject)localObject7).optString("uin"));
            QQComicConfBean.ServiceAccountConfig.b(localQQComicConfBean.c, ((JSONObject)localObject7).optString("url"));
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            break label1551;
          }
          if (((JSONObject)localObject7).has("comicReader"))
          {
            localObject7 = ((JSONObject)localObject7).optJSONObject("comicReader");
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            if (localObject7 == null) {
              break label1551;
            }
            localObject1 = ((JSONObject)localObject7).optJSONObject("newVersion");
            if (localObject1 != null)
            {
              localObject2 = ((JSONObject)localObject1).optJSONObject("preload");
              if (localObject2 != null)
              {
                localQQComicConfBean.f.enablePreload = ((JSONObject)localObject2).optBoolean("enable");
                localQQComicConfBean.f.preloadNum = ((JSONObject)localObject2).optInt("maxNum");
              }
            }
            localObject2 = ((JSONObject)localObject7).optJSONObject("preRead");
            if (localObject1 != null) {
              localQQComicConfBean.f.enablePreRead = ((JSONObject)localObject2).optBoolean("enable");
            }
            localObject7 = ((JSONObject)localObject7).optJSONObject("sectionComment");
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            if (localObject7 == null) {
              break label1551;
            }
            j = ((JSONObject)localObject7).optInt("commentNumVS", 1);
            if (j < 0) {
              j = 0;
            } else {
              j = Math.min(j, 3);
            }
            localQQComicConfBean.f.sectionCommentNumVS = j;
            localObject1 = localQQComicConfBean.f;
            if (((JSONObject)localObject7).optInt("masterSwitch", 0) != 1) {
              break label1545;
            }
            bool = true;
            ((QQComicConfBean.ComicReaderConfig)localObject1).sectionCommentMasterSwitch = bool;
            localObject3 = localObject4;
            localObject2 = localObject5;
            localObject1 = localObject6;
            break label1551;
          }
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (!((JSONObject)localObject7).has("cancelRedPointPopConfig")) {
            break label1551;
          }
          localObject7 = ((JSONObject)localObject7).optJSONObject("cancelRedPointPopConfig");
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (localObject7 == null) {
            break label1551;
          }
          localQQComicConfBean.g.popSwitch = ((JSONObject)localObject7).optInt("popSwitch", 0);
          localQQComicConfBean.g.enableLocalCache = ((JSONObject)localObject7).optInt("enableCache", 1);
          localQQComicConfBean.g.ignoreRedDot = ((JSONObject)localObject7).optInt("ignoreRedDot", 0);
          localQQComicConfBean.g.dayCount = ((JSONObject)localObject7).optInt("dayCount", 1);
          localQQComicConfBean.g.ignoreInteractiveControll = ((JSONObject)localObject7).optInt("ignoreInteractive", 0);
          localQQComicConfBean.g.list.clear();
          localObject7 = ((JSONObject)localObject7).optJSONArray("list");
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (localObject7 == null) {
            break label1551;
          }
          localObject7 = ComicCancelRedPointPopItemData.parseFromJsonArray((JSONArray)localObject7, true);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          if (((List)localObject7).isEmpty()) {
            break label1551;
          }
          localQQComicConfBean.g.list.addAll((Collection)localObject7);
          localObject3 = localObject4;
          localObject2 = localObject5;
          localObject1 = localObject6;
          break label1551;
        }
        VipComicHelper.a((String)localQQComicConfBean.b.get("danmuAnswerUrl"));
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
      label1519:
      Object localObject5 = localObject1;
      Object localObject6 = localObject2;
      label1527:
      localObject2 = localObject6;
      localObject1 = localObject5;
      break label1551;
      label1538:
      j += 1;
      continue;
      label1545:
      boolean bool = false;
      continue;
      label1551:
      i += 1;
    }
  }
  
  public static BoodoHippyConfig b()
  {
    return ((QQComicConfBean)QConfigManager.b().b(534)).e;
  }
  
  public static IPExpressionConfig c()
  {
    return ((QQComicConfBean)QConfigManager.b().b(534)).d;
  }
  
  public static QQComicConfBean.ServiceAccountConfig d()
  {
    return ((QQComicConfBean)QConfigManager.b().b(534)).c;
  }
  
  public static ComicCancelRedPointPopConfig e()
  {
    return ((QQComicConfBean)QConfigManager.b().b(534)).g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("qqComicConfig:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" ,urlConfigMap:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ,serviceAccountConfig:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean
 * JD-Core Version:    0.7.0.1
 */