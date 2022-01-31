package com.tencent.av.business.manager.pendant;

import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.utils.UITools;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
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
import jfy;
import jfz;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class AVEffectPendantReport
{
  private static int jdField_a_of_type_Int;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static int b;
  
  private static Class a()
  {
    return PendantItem.class;
  }
  
  private static String a()
  {
    return "content";
  }
  
  public static String a(PendantItem paramPendantItem)
  {
    String str = null;
    if (paramPendantItem != null) {
      str = AppConstants.aJ + "ptv_template" + File.separator + paramPendantItem.getName();
    }
    return str;
  }
  
  private static ArrayList a(String paramString)
  {
    localArrayList = new ArrayList();
    b = 0;
    jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int j = UITools.a();
        Object localObject = a();
        if (paramString.has((String)localObject))
        {
          paramString = paramString.getJSONArray((String)localObject);
          localObject = a();
          int i = 0;
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
    AVLog.c("AVEffectPendantReport", "setAVPendantDownloadInfo()  mTotalCount = " + b + "  mDownloadCount = " + jdField_a_of_type_Int);
  }
  
  private static String b()
  {
    int i = e();
    return EffectPendantTools.a(BaseApplicationImpl.getApplication(), i);
  }
  
  public static void b()
  {
    SharedPreUtils.c();
    AVLog.c("AVEffectPendantReport", "setAVPendantUseInfo()  time = " + System.currentTimeMillis());
  }
  
  private static boolean b(PendantItem paramPendantItem)
  {
    if ((e() <= 0) || (paramPendantItem == null) || (TextUtils.isEmpty(paramPendantItem.getId()))) {
      AVLog.e("AVEffectPendantReport", "isTemplateUsable:" + e() + "|");
    }
    do
    {
      return false;
      if (TextUtils.isEmpty(paramPendantItem.getResurl())) {
        return true;
      }
    } while (!new File(a(paramPendantItem)).exists());
    System.currentTimeMillis();
    String str = SecUtil.getFileMd5(a(paramPendantItem));
    System.currentTimeMillis();
    return paramPendantItem.getMd5().equalsIgnoreCase(str);
  }
  
  public static void c()
  {
    ThreadManager.getFileThreadHandler().post(new jfy());
  }
  
  public static void d()
  {
    AVLog.c("AVEffectPendantReport", "parseAndSetDownloadInfo()  ");
    ThreadManager.getFileThreadHandler().post(new jfz());
  }
  
  private static int e()
  {
    return 106;
  }
  
  public static void e()
  {
    String str = b();
    jdField_a_of_type_JavaUtilArrayList = null;
    jdField_a_of_type_JavaUtilArrayList = a(str);
  }
  
  public static void f()
  {
    long l1 = -1L;
    try
    {
      localHashMap = new HashMap();
      bool = SharedPreUtils.b();
      arrayOfInt = SharedPreUtils.b();
      l2 = SharedPreUtils.b();
      if ((!bool) && (arrayOfInt[1] <= 0))
      {
        CapturePtvTemplateManager.a().b(false);
        SharedPreUtils.d();
      }
      if (l2 <= 0L) {
        break label382;
      }
      l1 = (System.currentTimeMillis() - l2) / 1000L;
    }
    catch (Throwable localThrowable)
    {
      int[] arrayOfInt;
      do
      {
        HashMap localHashMap;
        boolean bool;
        long l2;
        BigDecimal localBigDecimal;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AVEffectPendantReport", 2, "reportAVPendantDownloadInfo", localThrowable);
        return;
        if ((arrayOfInt[0] <= 0) && (arrayOfInt[1] <= 0)) {
          break;
        }
      } while (arrayOfInt[0] <= arrayOfInt[1]);
    }
    localBigDecimal = new BigDecimal(arrayOfInt[0] * 1.0F / arrayOfInt[1]);
    localHashMap.put("filter_download", String.valueOf(arrayOfInt[0]));
    localHashMap.put("filter_total", String.valueOf(arrayOfInt[1]));
    localHashMap.put("filter_ratio", String.valueOf(localBigDecimal.setScale(2, 4).floatValue()));
    localHashMap.put("filter_spacing", String.valueOf(l1));
    if (QLog.isColorLevel()) {
      QLog.d("DailyReport", 2, "reportAVPendantDownloadInfo filter_download = " + arrayOfInt[0] + ",filter_total = " + arrayOfInt[1] + ",filter_spacing" + l1);
    }
    bool = UserAction.onUserAction("AVFunChatExpression", true, -1L, -1L, localHashMap, true);
    UserAction.flushObjectsToDB(true);
    AVLog.c("AVEffectPendantReport", "reportAVPendantDownloadInfo, filter_download[" + (String)localHashMap.get("filter_download") + "], filter_total[" + (String)localHashMap.get("filter_total") + "],filter_total[" + (String)localHashMap.get("filter_ratio") + "],filter_ratio[" + (String)localHashMap.get("filter_spacing") + "], lastUserTime = " + l2 + "    ret[" + bool + "]");
    return;
    label382:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.pendant.AVEffectPendantReport
 * JD-Core Version:    0.7.0.1
 */