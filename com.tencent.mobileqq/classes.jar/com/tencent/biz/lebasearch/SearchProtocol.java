package com.tencent.biz.lebasearch;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mxh;
import nam;
import ncz;
import nda;
import ndb;

public class SearchProtocol
{
  public static void a(AppInterface paramAppInterface, Context paramContext, ndb paramndb)
  {
    if ((paramAppInterface == null) || (paramndb == null)) {
      return;
    }
    paramContext = new ncz(Looper.getMainLooper(), paramndb);
    if (nam.a() == 0)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = -1;
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    paramndb = new NewIntent(paramAppInterface.getApp(), mxh.class);
    paramndb.putExtra("cmd", "PubAccountArticleCenter.GetSearchHotwords");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(1);
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRequestBody.search_request.set(localRootSearcherRequest);
    localRequestBody.version.set(ByteStringMicro.copyFromUtf8("8.2.8"));
    paramndb.putExtra("data", localRequestBody.toByteArray());
    paramndb.setObserver(new nda(paramContext));
    paramAppInterface.startServlet(paramndb);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol
 * JD-Core Version:    0.7.0.1
 */