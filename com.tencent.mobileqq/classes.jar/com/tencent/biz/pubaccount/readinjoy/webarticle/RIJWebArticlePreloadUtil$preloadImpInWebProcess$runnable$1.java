package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.text.TextUtils;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicRuntime;
import com.tencent.sonic.sdk.SonicSessionConfig;
import com.tencent.sonic.sdk.SonicSessionConfig.Builder;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import udf;
import udg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJWebArticlePreloadUtil$preloadImpInWebProcess$runnable$1
  implements Runnable
{
  public RIJWebArticlePreloadUtil$preloadImpInWebProcess$runnable$1(String paramString) {}
  
  public final void run()
  {
    if (TextUtils.isEmpty((CharSequence)this.a))
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] url is empty.");
      return;
    }
    Object localObject1 = new SonicSessionConfig.Builder().setSessionMode(1).setSupportLocalServer(true).build();
    SonicEngine localSonicEngine = WebAccelerateHelper.getSonicEngine();
    if (localSonicEngine == null)
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] sonicEngine is null.");
      return;
    }
    Object localObject2 = localSonicEngine.getRuntime();
    if ((localObject2 == null) || (((SonicRuntime)localObject2).isSonicUrl(this.a) != true))
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] not sonic url, url = " + this.a);
      return;
    }
    if (udf.a(udf.a, this.a))
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] is already in preload list, url = " + this.a);
      return;
    }
    localObject2 = this.a;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    boolean bool = localSonicEngine.preCreateSession((String)localObject2, (SonicSessionConfig)localObject1);
    if (!bool)
    {
      localObject2 = (udg)udf.a(udf.a).poll();
      if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)((udg)localObject2).b())))
      {
        String str = ((udg)localObject2).b();
        if (str == null) {
          Intrinsics.throwNpe();
        }
        bool = localSonicEngine.removeSessionCache(str);
        QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] removeRes = " + bool + ", url = " + this.a + ", firstPreloadData url = " + ((udg)localObject2).a());
        bool = localSonicEngine.preCreateSession(this.a, (SonicSessionConfig)localObject1);
      }
    }
    for (;;)
    {
      QLog.i("RIJWebArticlePreloadUtil", 1, "[preloadImpInWebProcess] preloadRes = " + bool + ", url = " + this.a);
      localObject1 = new udg(this.a, SonicEngine.makeSessionId(this.a, true));
      if (!bool) {
        break;
      }
      udf.a(udf.a).add(localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticlePreloadUtil.preloadImpInWebProcess.runnable.1
 * JD-Core Version:    0.7.0.1
 */