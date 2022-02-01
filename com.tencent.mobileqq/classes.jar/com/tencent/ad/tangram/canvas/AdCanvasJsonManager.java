package com.tencent.ad.tangram.canvas;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.a;
import com.tencent.ad.tangram.statistics.a.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public final class AdCanvasJsonManager
{
  private static final int FAIL = 1;
  private static final int SUCC = 0;
  private static final String TAG = "AdCanvasJsonManager";
  private static volatile AdCanvasJsonManager sInstance;
  private volatile boolean initialized = false;
  private WeakReference<Context> mContext;
  private volatile LruCache<String, String> mDataList;
  
  private boolean cache(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.mDataList == null)) {
      return false;
    }
    this.mDataList.put(paramString1, paramString2);
    return true;
  }
  
  public static AdCanvasJsonManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new AdCanvasJsonManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void initDataList(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.mDataList == null) {
        this.mDataList = new LruCache(paramInt);
      }
      for (;;)
      {
        AdLog.i("AdCanvasJsonManager", "canvas_json cache list size :" + this.mDataList.maxSize());
        return;
        if (this.mDataList.size() != paramInt) {
          if (Build.VERSION.SDK_INT >= 21) {
            this.mDataList.resize(paramInt);
          } else {
            this.mDataList = new LruCache(paramInt);
          }
        }
      }
    }
    this.mDataList = null;
  }
  
  private void report(Ad paramAd, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      a.a locala = new a.a();
      locala.context = this.mContext;
      locala.ad = paramAd;
      locala.data.landing_page_action_type = paramInt1;
      locala.data.landing_error_code = paramInt2;
      locala.data.latency_ms = paramLong;
      a.report(locala);
      return;
    }
    catch (Throwable paramAd)
    {
      AdLog.e("AdCanvasJsonManager", "rtp report error", paramAd);
    }
  }
  
  public String getCachedCanvasJson(Ad paramAd, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    label33:
    while ((this.mDataList == null) || (this.mDataList.size() == 0))
    {
      AdLog.i("AdCanvasJsonManager", "getCachedCanvasJson failed :" + paramString);
      paramAd = null;
      return paramAd;
    }
    String str = (String)this.mDataList.get(paramString);
    if (paramBoolean) {
      if (TextUtils.isEmpty(str)) {
        break label104;
      }
    }
    label104:
    for (int i = 0;; i = 1)
    {
      report(paramAd, 76, i, 0L);
      paramAd = str;
      if (!TextUtils.isEmpty(str)) {
        break label33;
      }
      break;
    }
  }
  
  public void init(Context paramContext)
  {
    if (this.initialized) {
      return;
    }
    try
    {
      if (this.initialized) {
        return;
      }
    }
    finally {}
    this.initialized = true;
    this.mContext = new WeakReference(paramContext);
    initDataList(20);
  }
  
  public void preloadCanvasJson(Ad paramAd, String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    report(paramAd, 74, 0, 0L);
    AdThreadManager.INSTANCE.post(new AdCanvasJsonManager.1(this, paramString2, l, paramAd, paramString1), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.AdCanvasJsonManager
 * JD-Core Version:    0.7.0.1
 */