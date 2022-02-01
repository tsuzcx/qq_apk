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
  private static int jdField_a_of_type_Int;
  private static ArrayList<PendantItem> jdField_a_of_type_JavaUtilArrayList;
  private static int b;
  
  private static Class<?> a()
  {
    return PendantItem.class;
  }
  
  private static String a()
  {
    return "content";
  }
  
  private static String a(PendantItem paramPendantItem)
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
  
  private static ArrayList<PendantItem> a(String paramString)
  {
    localArrayList = new ArrayList();
    int i = 0;
    b = 0;
    jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int j = UITools.getQQVersion();
        Object localObject = a();
        if (paramString.has((String)localObject))
        {
          paramString = paramString.getJSONArray((String)localObject);
          localObject = a();
          while (i < paramString.length())
          {
            PendantItem localPendantItem = (PendantItem)JSONUtils.a((JSONObject)paramString.get(i), (Class)localObject);
            if ((localPendantItem != null) && (!TextUtils.isEmpty(localPendantItem.getId())) && (localPendantItem.isShow()))
            {
              int k = localPendantItem.getPlatform();
              if ((k == 0) || (j >= k))
              {
                boolean bool = b(localPendantItem);
                localPendantItem.setUsable(bool);
                localArrayList.add(localPendantItem);
                b += 1;
                if (bool) {
                  jdField_a_of_type_Int += 1;
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
    SharedPreUtils.b(jdField_a_of_type_Int, b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAVPendantDownloadInfo()  mTotalCount = ");
    localStringBuilder.append(b);
    localStringBuilder.append("  mDownloadCount = ");
    localStringBuilder.append(jdField_a_of_type_Int);
    AVLog.printColorLog("AVEffectPendantReport", localStringBuilder.toString());
  }
  
  private static String b()
  {
    return QAVConfig.b(e()).a;
  }
  
  public static void b()
  {
    SharedPreUtils.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAVPendantUseInfo()  time = ");
    localStringBuilder.append(System.currentTimeMillis());
    AVLog.printColorLog("AVEffectPendantReport", localStringBuilder.toString());
  }
  
  private static boolean b(PendantItem paramPendantItem)
  {
    if ((e() > 0) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())))
    {
      if (TextUtils.isEmpty(paramPendantItem.getResUrl())) {
        return true;
      }
      if (!new File(a(paramPendantItem)).exists()) {
        return false;
      }
      System.currentTimeMillis();
      String str = SecUtil.getFileMd5(a(paramPendantItem));
      System.currentTimeMillis();
      return paramPendantItem.getMd5().equalsIgnoreCase(str);
    }
    paramPendantItem = new StringBuilder();
    paramPendantItem.append("isTemplateUsable:");
    paramPendantItem.append(e());
    paramPendantItem.append("|");
    AVLog.printErrorLog("AVEffectPendantReport", paramPendantItem.toString());
    return false;
  }
  
  public static void c()
  {
    ThreadManager.getFileThreadHandler().post(new AVEffectPendantReport.1());
  }
  
  public static void d()
  {
    String str = b();
    jdField_a_of_type_JavaUtilArrayList = null;
    jdField_a_of_type_JavaUtilArrayList = a(str);
  }
  
  private static int e()
  {
    return 106;
  }
  
  public static void e()
  {
    Object localObject1;
    do
    {
      try
      {
        localHashMap = new HashMap();
        bool = SharedPreUtils.b();
        localObject1 = SharedPreUtils.b();
        l2 = SharedPreUtils.b();
        if ((!bool) && (localObject1[1] <= 0))
        {
          CapturePtvTemplateManager.a().b(false);
          SharedPreUtils.c();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport
 * JD-Core Version:    0.7.0.1
 */