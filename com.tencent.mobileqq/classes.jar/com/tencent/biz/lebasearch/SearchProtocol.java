package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import kno;
import knp;
import knq;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class SearchProtocol
{
  public static float a = -1.0F;
  public static int a;
  public static float b = -1.0F;
  
  public static void a(Context paramContext, long paramLong, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramContext.getAccount(), 0);
    int i = paramContext.getInt("search_lbs_delay", 0);
    if (i > 0) {
      paramLong = i * 60 * 60 * 1000;
    }
    if (System.currentTimeMillis() - paramContext.getLong("search_lbs_timestamp", 0L) > paramLong)
    {
      SosoInterface.a(new kno(0, true, false, 300000L, false, false, paramString, paramContext));
      return;
    }
    a = paramContext.getFloat("search_lbs_latitude", -1.0F);
    b = paramContext.getFloat("search_lbs_logitude", -1.0F);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext)
  {
    if (paramAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.d("lebasearch.SearchProtocol", 2, "getHomeHotWords.  app is null.");
      }
    }
    do
    {
      return;
      if (HttpUtil.a() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("lebasearch.SearchProtocol", 2, "getHomeHotWords.  NetWorkType is NONE.");
    return;
    ((UniteSearchHandler)paramAppInterface.getBusinessHandler(111)).a((QQAppInterface)paramAppInterface, 4);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null)) {
      return;
    }
    paramContext = new knp(Looper.getMainLooper(), paramSearchObserver);
    if (HttpUtil.a() == 0)
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
    localRequestBody.version.set(ByteStringMicro.copyFromUtf8("7.6.3"));
    paramSearchObserver.putExtra("data", localRequestBody.toByteArray());
    paramSearchObserver.setObserver(new knq(paramContext));
    paramAppInterface.startServlet(paramSearchObserver);
  }
  
  private static int b(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("#")) || (paramString.length() > 9) || (paramString.length() < 6)) {
      return 0;
    }
    try
    {
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol
 * JD-Core Version:    0.7.0.1
 */