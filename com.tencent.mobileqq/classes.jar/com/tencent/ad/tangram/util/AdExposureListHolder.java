package com.tencent.ad.tangram.util;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

@Keep
public final class AdExposureListHolder
{
  private static final String EXPOSURED_AD = "exposured_ad";
  private static final String IDS = "_ids";
  private static final String TAG = "AdExposureListHolder";
  private static volatile AdExposureListHolder sInstance;
  private final Object fileLock = new Object();
  private volatile boolean initialized;
  private final Object memoryLock = new Object();
  private LinkedList<String> traceIdList = null;
  private LinkedList<String> traceIdListForAnalysis = null;
  
  private void addCheckedData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.memoryLock)
    {
      LinkedList localLinkedList = getExposuredTraceIdList();
      if ((localLinkedList != null) && (!localLinkedList.contains(paramString)))
      {
        if (localLinkedList.size() - 100 >= 0)
        {
          int i = 0;
          while (i <= localLinkedList.size() - 100)
          {
            localLinkedList.removeLast();
            i += 1;
          }
        }
        localLinkedList.add(paramString);
      }
      return;
    }
  }
  
  private void addDiskCheckedData(Context paramContext)
  {
    if (paramContext == null) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = getExposuredTraceIdList();
    } while ((localLinkedList == null) || (localLinkedList.size() <= 0));
    AdThreadManager.INSTANCE.post(new AdExposureListHolder.2(this, paramContext), 5);
  }
  
  private LinkedList<String> getExposuredTraceIdList()
  {
    return this.traceIdList;
  }
  
  private File getFileByProcessName(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    return new File(getFileDir(paramContext).getAbsolutePath() + File.separator + paramString + "_ids");
  }
  
  private File getFileDir(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getDir("exposured_ad", 0);
  }
  
  public static AdExposureListHolder getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new AdExposureListHolder();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void addTraceIdForAnalysis(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.traceIdListForAnalysis == null) || (this.traceIdListForAnalysis.contains(paramString))) {
      return;
    }
    if (this.traceIdListForAnalysis.size() >= 100)
    {
      this.traceIdListForAnalysis.removeLast();
      this.traceIdListForAnalysis.add(paramString);
      return;
    }
    this.traceIdListForAnalysis.add(paramString);
  }
  
  public boolean containsTraceIdForAnalysis(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((this.traceIdListForAnalysis == null) || (!this.traceIdListForAnalysis.contains(paramString))) {
      return false;
    }
    return true;
  }
  
  public boolean inCheckedList(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (this.memoryLock)
    {
      Object localObject2 = getExposuredTraceIdList();
      if (localObject2 != null)
      {
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if ((!TextUtils.isEmpty(str)) && (paramString.equals(str))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public void init(Context paramContext)
  {
    if (this.initialized) {}
    do
    {
      return;
      try
      {
        if (this.initialized) {
          return;
        }
      }
      finally {}
      this.initialized = true;
    } while (paramContext == null);
    if (this.traceIdList == null) {
      this.traceIdList = new LinkedList();
    }
    if (this.traceIdListForAnalysis == null) {
      this.traceIdListForAnalysis = new LinkedList();
    }
    AdThreadManager.INSTANCE.post(new AdExposureListHolder.1(this, paramContext), 5);
  }
  
  public void putExternalReportData(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    AdLog.i("AdExposureListHolder", "putExternalReportData id :" + paramString);
    addCheckedData(paramString);
    addDiskCheckedData(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdExposureListHolder
 * JD-Core Version:    0.7.0.1
 */