package com.tencent.ad.tangram.views.canvas;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.ad.tangram.statistics.b;
import com.tencent.ad.tangram.statistics.b.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

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
  private Set<String> preloadingUrlList = new HashSet();
  
  private boolean cache(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (this.mDataList != null))
    {
      this.mDataList.put(paramString1, paramString2);
      return true;
    }
    return false;
  }
  
  public static AdCanvasJsonManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new AdCanvasJsonManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void initDataList(int paramInt)
  {
    if (paramInt > 0)
    {
      if (this.mDataList == null) {
        this.mDataList = new LruCache(paramInt);
      } else if (this.mDataList.size() != paramInt) {
        if (Build.VERSION.SDK_INT >= 21) {
          this.mDataList.resize(paramInt);
        } else {
          this.mDataList = new LruCache(paramInt);
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canvas_json cache list size :");
      localStringBuilder.append(this.mDataList.maxSize());
      AdLog.i("AdCanvasJsonManager", localStringBuilder.toString());
      return;
    }
    this.mDataList = null;
  }
  
  private void preloadCanvasJsonOnNetworkThread(Ad paramAd, String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    report(paramAd, 74, 0, 0L);
    Object localObject = new AdHttp.Params();
    ((AdHttp.Params)localObject).method = "GET";
    ((AdHttp.Params)localObject).setUrl(paramString2);
    AdHttp.send((AdHttp.Params)localObject);
    if ((((AdHttp.Params)localObject).responseCode == 200) && (((AdHttp.Params)localObject).responseData != null))
    {
      paramString2 = null;
      try
      {
        localObject = new JSONObject(new String(((AdHttp.Params)localObject).responseData));
        if (((JSONObject)localObject).getInt("code") != 0) {
          return;
        }
        localObject = ((JSONObject)localObject).optString("data");
        paramString2 = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invalid canvasJson :");
        localStringBuilder.append(localThrowable);
        AdLog.e("AdCanvasJsonManager", localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      report(paramAd, 75, 0, System.currentTimeMillis() - l);
      cache(paramString1, paramString2);
      return;
    }
    paramAd = new StringBuilder();
    paramAd.append("preloadCanvasJson failed :");
    paramAd.append(localThrowable.responseCode);
    AdLog.i("AdCanvasJsonManager", paramAd.toString());
  }
  
  private void report(Ad paramAd, int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      b.a locala = new b.a();
      locala.context = this.mContext;
      locala.ad = paramAd;
      locala.data.landing_page_action_type = paramInt1;
      locala.data.landing_error_code = paramInt2;
      locala.data.latency_ms = paramLong;
      b.report(locala);
      return;
    }
    catch (Throwable paramAd)
    {
      AdLog.e("AdCanvasJsonManager", "rtp report error", paramAd);
    }
  }
  
  public String getCachedCanvasJson(Ad paramAd, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
      this.initialized = true;
      this.mContext = new WeakReference(paramContext);
      initDataList(20);
      return;
    }
    finally {}
  }
  
  public void preloadCanvasJson(Ad paramAd, String paramString1, String paramString2)
  {
    AdThreadManager.INSTANCE.post(new AdCanvasJsonManager.1(this, paramString2, paramAd, paramString1), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.AdCanvasJsonManager
 * JD-Core Version:    0.7.0.1
 */