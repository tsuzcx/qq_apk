package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVPathUtil;
import com.tencent.av.ManageConfig.QAVConfItem;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.utils.UITools;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AVEffectPendantReport
{
  private static ArrayList<PendantItem> a;
  private static int b;
  private static int c;
  
  private static ArrayList<PendantItem> a(String paramString)
  {
    localArrayList = new ArrayList();
    int i = 0;
    c = 0;
    b = 0;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int j = UITools.getQQVersion();
        Object localObject = k();
        if (paramString.has((String)localObject))
        {
          paramString = paramString.getJSONArray((String)localObject);
          localObject = l();
          while (i < paramString.length())
          {
            PendantItem localPendantItem = (PendantItem)JSONUtils.a((JSONObject)paramString.get(i), (Class)localObject);
            if ((localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())) && (localPendantItem.isShow()))
            {
              int k = localPendantItem.getPlatform();
              if ((k == 0) || (j >= k))
              {
                boolean bool = c(localPendantItem);
                localPendantItem.setUsable(bool);
                localArrayList.add(localPendantItem);
                c += 1;
                if (bool) {
                  b += 1;
                }
              }
            }
            i += 1;
          }
        }
        return localArrayList;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void a()
  {
    SharedPreUtils.b(b, c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAVPendantDownloadInfo()  mTotalCount = ");
    localStringBuilder.append(c);
    localStringBuilder.append("  mDownloadCount = ");
    localStringBuilder.append(b);
    AVLog.printColorLog("AVEffectPendantReport", localStringBuilder.toString());
  }
  
  private static String b(PendantItem paramPendantItem)
  {
    if (paramPendantItem != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AVPathUtil.c());
      localStringBuilder.append(paramPendantItem.getName());
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void b()
  {
    SharedPreUtils.j();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAVPendantUseInfo()  time = ");
    localStringBuilder.append(System.currentTimeMillis());
    AVLog.printColorLog("AVEffectPendantReport", localStringBuilder.toString());
  }
  
  public static void c()
  {
    ThreadManager.getFileThreadHandler().post(new AVEffectPendantReport.1());
  }
  
  private static boolean c(PendantItem paramPendantItem)
  {
    if ((n() > 0) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      if (TextUtils.isEmpty(paramPendantItem.getResUrl())) {
        return true;
      }
      if (!new File(b(paramPendantItem)).exists()) {
        return false;
      }
      System.currentTimeMillis();
      String str = SecUtil.getFileMd5(b(paramPendantItem));
      System.currentTimeMillis();
      return paramPendantItem.getMd5().equalsIgnoreCase(str);
    }
    paramPendantItem = new StringBuilder();
    paramPendantItem.append("isTemplateUsable:");
    paramPendantItem.append(n());
    paramPendantItem.append("|");
    AVLog.printErrorLog("AVEffectPendantReport", paramPendantItem.toString());
    return false;
  }
  
  public static void d()
  {
    String str = m();
    a = null;
    a = a(str);
  }
  
  public static void e()
  {
    Object localObject1;
    do
    {
      try
      {
        localHashMap = new HashMap();
        bool = SharedPreUtils.m();
        localObject1 = SharedPreUtils.i();
        l2 = SharedPreUtils.k();
        if ((!bool) && (localObject1[1] <= 0))
        {
          CapturePtvTemplateManager.a().b(false);
          SharedPreUtils.l();
        }
        l1 = -1L;
        if (l2 <= 0L) {
          continue;
        }
        l1 = (System.currentTimeMillis() - l2) / 1000L;
      }
      catch (Throwable localThrowable)
      {
        HashMap localHashMap;
        boolean bool;
        long l2;
        long l1;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AVEffectPendantReport", 2, "reportAVPendantDownloadInfo", localThrowable);
        return;
      }
      localObject2 = new BigDecimal(localObject1[0] * 1.0F / localObject1[1]);
      localHashMap.put("filter_download", String.valueOf(localObject1[0]));
      localHashMap.put("filter_total", String.valueOf(localObject1[1]));
      localHashMap.put("filter_ratio", String.valueOf(((BigDecimal)localObject2).setScale(2, 4).floatValue()));
      localHashMap.put("filter_spacing", String.valueOf(l1));
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportAVPendantDownloadInfo filter_download = ");
        ((StringBuilder)localObject2).append(localObject1[0]);
        ((StringBuilder)localObject2).append(",filter_total = ");
        ((StringBuilder)localObject2).append(localObject1[1]);
        ((StringBuilder)localObject2).append(",filter_spacing");
        ((StringBuilder)localObject2).append(l1);
        QLog.d("DailyReport", 2, ((StringBuilder)localObject2).toString());
      }
      bool = UserAction.onUserAction("AVFunChatExpression", true, -1L, -1L, localHashMap, true);
      UserAction.flushObjectsToDB(true);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportAVPendantDownloadInfo, filter_download[");
      ((StringBuilder)localObject1).append((String)localHashMap.get("filter_download"));
      ((StringBuilder)localObject1).append("], filter_total[");
      ((StringBuilder)localObject1).append((String)localHashMap.get("filter_total"));
      ((StringBuilder)localObject1).append("],filter_total[");
      ((StringBuilder)localObject1).append((String)localHashMap.get("filter_ratio"));
      ((StringBuilder)localObject1).append("],filter_ratio[");
      ((StringBuilder)localObject1).append((String)localHashMap.get("filter_spacing"));
      ((StringBuilder)localObject1).append("], lastUserTime = ");
      ((StringBuilder)localObject1).append(l2);
      ((StringBuilder)localObject1).append("    ret[");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append("]");
      AVLog.printColorLog("AVEffectPendantReport", ((StringBuilder)localObject1).toString());
      return;
    } while (((localObject1[0] > 0) || (localObject1[1] > 0)) && (localObject1[0] <= localObject1[1]));
  }
  
  private static String k()
  {
    return "content";
  }
  
  private static Class<?> l()
  {
    return PendantItem.class;
  }
  
  private static String m()
  {
    return QAVConfig.b(n()).b;
  }
  
  private static int n()
  {
    return 106;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport
 * JD-Core Version:    0.7.0.1
 */