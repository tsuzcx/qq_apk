import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.local.requests.QCircleDoFollowRequest;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterRequest;
import com.tencent.mobileqq.flutter.channel.qqcircle.QCircleSearchHistoryWords;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudMeta.StUser;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class atip
  extends atis
{
  atip(atio paramatio) {}
  
  protected List<String> a(String paramString, int paramInt)
  {
    if (atio.a(this.a) == null)
    {
      QLog.e("flutter.QQCircleChannelHandler", 1, "[saveCache] invalid EntityManager");
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    try
    {
      localObject = atio.a(this.a).query(QCircleSearchHistoryWords.class);
      if ((localObject == null) || (((List)localObject).isEmpty()))
      {
        QLog.w("flutter.QQCircleChannelHandler", 1, "[getCache] list is null or empty");
        return null;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("flutter.QQCircleChannelHandler", 1, "[getCache] ", paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flutter.QQCircleChannelHandler", 2, "[getCache] words=" + localArrayList);
      }
      return localArrayList;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        QCircleSearchHistoryWords localQCircleSearchHistoryWords = (QCircleSearchHistoryWords)((Iterator)localObject).next();
        if ((paramString.equals(localQCircleSearchHistoryWords.key)) && (paramInt == localQCircleSearchHistoryWords.type)) {
          localArrayList.add(localQCircleSearchHistoryWords.word);
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, Map<String, Object> paramMap, boolean paramBoolean)
  {
    String str1;
    String str2;
    label30:
    String str3;
    label45:
    label60:
    int i;
    if (paramMap.get("touin") == null)
    {
      str1 = null;
      if (paramMap.get("ext5") != null) {
        break label130;
      }
      str2 = null;
      if (paramMap.get("ext6") != null) {
        break label147;
      }
      str3 = null;
      if (paramMap.get("ext7") != null) {
        break label164;
      }
      paramMap = null;
      i = -1;
      if (49 != paramInt1) {
        break label181;
      }
      i = 28;
    }
    for (;;)
    {
      QCircleLpReportDc05504.report(str1, paramInt1, paramInt2, paramInt3, "", "", str2, str3, paramMap, "", null, i, -1);
      if (atio.a() == null) {
        break label207;
      }
      QCircleReporter.getInstance().reportCacheDataListToServerWithSession(atio.a());
      return;
      str1 = String.valueOf(paramMap.get("touin"));
      break;
      label130:
      str2 = String.valueOf(paramMap.get("ext5"));
      break label30;
      label147:
      str3 = String.valueOf(paramMap.get("ext6"));
      break label45;
      label164:
      paramMap = String.valueOf(paramMap.get("ext7"));
      break label60;
      label181:
      if (50 == paramInt1) {
        i = 29;
      } else if (51 == paramInt1) {
        i = 30;
      }
    }
    label207:
    QLog.w("flutter.QQCircleChannelHandler", 1, "[reportDC05504] no report session");
  }
  
  protected void a(MethodChannel.Result paramResult)
  {
    String str = RFWDownloaderFactory.getDownloader(QCircleConfig.getDownloadStrategy()).getDefaultSavePath("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_fullscreen_disconnect.png");
    HashMap localHashMap = new HashMap();
    if (new File(str).exists())
    {
      localHashMap.put("type", "preload");
      localHashMap.put("imageFilePath", str);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flutter.QQCircleChannelHandler", 2, "[loadNoNetworkImage] map=" + localHashMap);
      }
      paramResult.success(localHashMap);
      return;
      localHashMap.put("type", "local");
      localHashMap.put("imageFilePath", "local");
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannelHandler", 2, "[gotoMainPage] uin" + paramString);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", paramString);
    vgn.a(BaseApplicationImpl.context, "openmainpage", localHashMap);
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (atio.a(this.a) == null) {
      QLog.e("flutter.QQCircleChannelHandler", 1, "[clearCache] invalid EntityManager");
    }
    do
    {
      return;
      paramInt = 0;
      try
      {
        int i = atio.a(this.a).delete(QCircleSearchHistoryWords.class.getSimpleName(), null, null);
        paramInt = i;
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QLog.e("flutter.QQCircleChannelHandler", 1, "[clearCache] ", paramString);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("flutter.QQCircleChannelHandler", 2, "[clearCache] count=" + paramInt);
  }
  
  protected void a(String paramString, MethodChannel.Result paramResult)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("flutter.QQCircleChannelHandler", 2, "parseText content is null");
      }
      return;
    }
    paramResult.success(atit.a(paramString));
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannelHandler", 2, "[openTagPage] tagid=" + paramString1 + ", tagname=" + paramString2);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("sourcetype", String.valueOf(7));
    localHashMap.put("tagid", paramString1);
    localHashMap.put("tagname", paramString2);
    vgn.a(BaseApplicationImpl.context, "openpolymerize", localHashMap);
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannelHandler", 2, "[openDetailPage] feedid=" + paramString1 + ", userid=" + paramString2 + ", createtime=" + paramString3);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("feedid", paramString1);
    localHashMap.put("uin", paramString2);
    localHashMap.put("createtime", paramString3);
    localHashMap.put("issinglefeed", "1");
    localHashMap.put("is_feed_detail", "1");
    vgn.a(BaseApplicationImpl.context, "opendetail", localHashMap);
  }
  
  protected void a(String paramString, List<String> paramList, int paramInt, long paramLong)
  {
    String str = null;
    EntityTransaction localEntityTransaction2 = null;
    if (atio.a(this.a) == null) {
      QLog.e("flutter.QQCircleChannelHandler", 1, "[saveCache] invalid EntityManager");
    }
    for (;;)
    {
      return;
      EntityTransaction localEntityTransaction1 = localEntityTransaction2;
      Object localObject = str;
      try
      {
        atio.a(this.a).delete(QCircleSearchHistoryWords.class.getSimpleName(), null, null);
        localEntityTransaction1 = localEntityTransaction2;
        localObject = str;
        localEntityTransaction2 = atio.a(this.a).getTransaction();
        localEntityTransaction1 = localEntityTransaction2;
        localObject = localEntityTransaction2;
        localEntityTransaction2.begin();
        localEntityTransaction1 = localEntityTransaction2;
        localObject = localEntityTransaction2;
        paramList = paramList.iterator();
        for (;;)
        {
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          if (!paramList.hasNext()) {
            break;
          }
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          str = (String)paramList.next();
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          QCircleSearchHistoryWords localQCircleSearchHistoryWords = new QCircleSearchHistoryWords();
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localQCircleSearchHistoryWords.key = paramString;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localQCircleSearchHistoryWords.type = paramInt;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localQCircleSearchHistoryWords.word = str;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          localQCircleSearchHistoryWords.expireTime = paramLong;
          localEntityTransaction1 = localEntityTransaction2;
          localObject = localEntityTransaction2;
          atio.a(this.a).persist(localQCircleSearchHistoryWords);
        }
      }
      catch (Throwable paramString)
      {
        localObject = localEntityTransaction1;
        QLog.e("flutter.QQCircleChannelHandler", 1, "[saveCache] ", paramString);
        if (localEntityTransaction1 == null) {
          continue;
        }
        localEntityTransaction1.end();
        return;
        localEntityTransaction1 = localEntityTransaction2;
        localObject = localEntityTransaction2;
        localEntityTransaction2.commit();
        if (localEntityTransaction2 == null) {
          continue;
        }
        localEntityTransaction2.end();
        return;
      }
      finally
      {
        if (localObject != null) {
          ((EntityTransaction)localObject).end();
        }
      }
    }
  }
  
  protected void a(String paramString, byte[] paramArrayOfByte, MethodChannel.Result paramResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannelHandler", 2, "[sendSsoRequest] cmd=" + paramString);
    }
    paramString = new QCircleFlutterRequest(paramString, paramArrayOfByte);
    VSNetworkHelper.getInstance().sendRequest(paramString, new atiq(this, paramResult));
  }
  
  protected void a(Map<String, String> paramMap, MethodChannel.Result paramResult)
  {
    if (paramMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("flutter.QQCircleChannelHandler", 2, "parseTextBatch content is null");
      }
      return;
    }
    HashMap localHashMap = new HashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localHashMap.put(localEntry.getKey(), atit.a((CharSequence)localEntry.getValue()));
    }
    paramMap = new HashMap();
    paramMap.put("textListNodes", localHashMap);
    paramResult.success(paramMap);
  }
  
  protected void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("flutter.QQCircleChannelHandler", 2, "[changeFollowState] uin=" + paramString1 + ", state=" + paramString2);
    }
    if ("1".equals(paramString2)) {}
    for (int i = 1;; i = 0)
    {
      paramString2 = new FeedCloudMeta.StUser();
      paramString2.id.set(paramString1);
      paramString2 = new QCircleDoFollowRequest(paramString2, i, null);
      VSNetworkHelper.getInstance().sendRequest(paramString2, new atir(this, paramString1, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atip
 * JD-Core Version:    0.7.0.1
 */