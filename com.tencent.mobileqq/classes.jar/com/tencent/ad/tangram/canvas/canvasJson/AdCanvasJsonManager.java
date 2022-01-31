package com.tencent.ad.tangram.canvas.canvasJson;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.AdCanvas;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.a;
import com.tencent.ad.tangram.statistics.a.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;

@Keep
public class AdCanvasJsonManager
{
  private static final int FAIL = 1;
  private static final int SUCC = 0;
  private static final String TAG = "AdCanvasJsonManager";
  private static volatile AdCanvasJsonManager sInstance;
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
  
  private int getQueueLength(Context paramContext)
  {
    int i = AdCanvas.getQueueLength(new WeakReference(paramContext));
    AdLog.i("AdCanvasJsonManager", "getQueueLength :" + i);
    if (i <= 0) {
      AdLog.e("AdCanvasJsonManager", "getQueueLength error");
    }
    return i;
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
  
  public String getCachedCanvasJson(Ad paramAd, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    for (;;)
    {
      AdLog.i("AdCanvasJsonManager", "getCachedCanvasJson failed :" + paramString);
      return null;
      if ((this.mDataList != null) && (this.mDataList.size() != 0))
      {
        str = (String)this.mDataList.get(paramString);
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        report(paramAd, 76, 1, 0L);
      }
    }
    report(paramAd, 76, 0, 0L);
    return str;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    int i = getQueueLength(paramContext);
    if (i > 0)
    {
      if (this.mDataList == null) {
        this.mDataList = new LruCache(i);
      }
      for (;;)
      {
        AdLog.i("AdCanvasJsonManager", "canvas_json cache list size :" + this.mDataList.maxSize());
        return;
        if (this.mDataList.size() != i) {
          if (Build.VERSION.SDK_INT >= 21) {
            this.mDataList.resize(i);
          } else {
            this.mDataList = new LruCache(i);
          }
        }
      }
    }
    this.mDataList = null;
  }
  
  public void preloadCanvasJson(Ad paramAd, String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    report(paramAd, 74, 0, 0L);
    AdThreadManager.INSTANCE.post(new AdCanvasJsonManager.1(this, paramString2, l, paramAd, paramString1), 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.canvasJson.AdCanvasJsonManager
 * JD-Core Version:    0.7.0.1
 */