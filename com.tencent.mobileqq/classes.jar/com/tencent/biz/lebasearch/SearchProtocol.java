package com.tencent.biz.lebasearch;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import mqq.app.NewIntent;

public class SearchProtocol
{
  public static int a;
  public static final String b = ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).SP_LBS_UPDATE_TIME_STAMP();
  public static final String c = ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).SP_LBS_LATITUDE();
  public static final String d = ((IQQHealthApi)QRoute.api(IQQHealthApi.class)).SP_LBS_LOGITUDE();
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver)
  {
    if (paramAppInterface != null)
    {
      if (paramSearchObserver == null) {
        return;
      }
      paramContext = new SearchProtocol.1(Looper.getMainLooper(), paramSearchObserver);
      if (HttpUtil.getNetWorkType() == 0)
      {
        paramAppInterface = paramContext.obtainMessage();
        paramAppInterface.arg1 = -1;
        paramContext.sendMessage(paramAppInterface);
        return;
      }
      paramSearchObserver = new NewIntent(paramAppInterface.getApp(), ProtoServlet.class);
      paramSearchObserver.putExtra("cmd", "PubAccountArticleCenter.GetSearchHotwords");
      mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
      localRequestBody.cmd.set(1);
      mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
      localRootSearcherRequest.business.set(128);
      localRequestBody.search_request.set(localRootSearcherRequest);
      localRequestBody.version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
      paramSearchObserver.putExtra("data", localRequestBody.toByteArray());
      paramSearchObserver.setObserver(new SearchProtocol.2(paramContext));
      paramAppInterface.startServlet(paramSearchObserver);
    }
  }
  
  private static int b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 0;
    int i = j;
    if (!bool)
    {
      i = j;
      if (paramString.startsWith("#"))
      {
        i = j;
        if (paramString.length() <= 9) {
          if (paramString.length() < 6) {
            return 0;
          }
        }
      }
    }
    try
    {
      i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol
 * JD-Core Version:    0.7.0.1
 */