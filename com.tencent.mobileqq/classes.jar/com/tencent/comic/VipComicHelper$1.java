package com.tencent.comic;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

final class VipComicHelper$1
  implements Runnable
{
  VipComicHelper$1(WeakReference paramWeakReference, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = (AppRuntime)this.a.get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.comic_plugin_profile.name(), "");
    Integer[] arrayOfInteger = new Integer[7];
    int k = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser((String)localObject2, arrayOfInteger);
    int m = arrayOfInteger.length;
    int j = 0;
    int i = j;
    if (k >= m)
    {
      i = j;
      if ((arrayOfInteger[4].intValue() & this.b) != 0) {
        i = 1;
      }
    }
    if (i == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Skip update offline pkg. entry = ");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("ComicHelper", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Do update offline pkg. entry = ");
      ((StringBuilder)localObject2).append(this.b);
      QLog.d("ComicHelper", 2, ((StringBuilder)localObject2).toString());
    }
    HtmlOffline.b("354", (AppRuntime)localObject1, true, new VipComicHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.VipComicHelper.1
 * JD-Core Version:    0.7.0.1
 */