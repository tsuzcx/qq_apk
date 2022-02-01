package com.tencent.biz.expand.api.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.expand.NativeNavigateUtils;
import com.tencent.biz.expand.api.INativeNavigateApi;
import com.tencent.biz.expand.flutter.router.BaseRouter;
import com.tencent.biz.expand.flutter.router.RouterManager;
import java.util.Map;
import mqq.app.MobileQQ;

public class NativeNavigateApiImpl
  implements INativeNavigateApi
{
  public void navigateBySchema(String paramString)
  {
    NativeNavigateUtils.a.c(MobileQQ.sMobileQQ, paramString);
  }
  
  public void navigateMiniApp(String paramString)
  {
    NativeNavigateUtils.a.a(MobileQQ.sMobileQQ, paramString);
  }
  
  public void navigateWebView(String paramString)
  {
    NativeNavigateUtils.a.b(MobileQQ.sMobileQQ, paramString);
  }
  
  public void navigateWithoutSchema(String paramString, Map<Object, Object> paramMap1, Map<Object, Object> paramMap2)
  {
    if (!RouterManager.a().a()) {
      RouterManager.a().a();
    }
    if (TextUtils.isEmpty(paramString)) {}
    BaseRouter localBaseRouter;
    do
    {
      do
      {
        return;
        paramString = Uri.parse(paramString);
      } while ((paramString == null) || (!TextUtils.equals(paramString.getScheme(), "mqqapi")));
      localBaseRouter = RouterManager.a().a(paramString.getAuthority());
    } while (localBaseRouter == null);
    localBaseRouter.a(paramString, paramMap1, paramMap2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.impl.NativeNavigateApiImpl
 * JD-Core Version:    0.7.0.1
 */