package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;

public class h
{
  public static void a(ArrayList<f> paramArrayList, long paramLong, JSONArray paramJSONArray, Context paramContext)
  {
    if ((paramContext != null) && (paramArrayList != null) && (paramArrayList.size() > 0) && (HianalyticsHelper.getInstance().isEnableReportNoSeed(paramContext))) {
      HianalyticsHelper.getInstance().getReportExecutor().submit(new g(paramLong, paramContext, paramArrayList, paramJSONArray));
    }
  }
  
  private static LinkedHashMap<String, String> b(f paramf)
  {
    LinkedHashMapPack localLinkedHashMapPack = new LinkedHashMapPack();
    Exception localException = paramf.d();
    if (localException != null)
    {
      localLinkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(localException));
      localLinkedHashMapPack.put("exception_name", localException.getClass().getSimpleName());
      localLinkedHashMapPack.put("message", StringUtils.anonymizeMessage(localException.getMessage()));
    }
    else
    {
      localLinkedHashMapPack.put("error_code", paramf.b());
      localLinkedHashMapPack.put("exception_name", paramf.c());
    }
    try
    {
      localLinkedHashMapPack.put("domain", new URL(paramf.k()).getHost());
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Logger.w("HaReportHelper", "report host MalformedURLException", localMalformedURLException);
    }
    localLinkedHashMapPack.put("req_start_time", paramf.g());
    localLinkedHashMapPack.put("req_end_time", paramf.f());
    localLinkedHashMapPack.put("req_total_time", paramf.h());
    return localLinkedHashMapPack.getAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.h
 * JD-Core Version:    0.7.0.1
 */