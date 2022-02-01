package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NativeProteusBidConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("NativeProteusBidConfigHandler", 1, "[onReceiveConfig] " + paramString);
    Map localMap = AladdinParseUtils.a(paramString);
    Object localObject2 = localMap.keySet();
    Object localObject1 = "";
    paramString = "";
    Iterator localIterator = ((Set)localObject2).iterator();
    String str;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localObject2 = (String)localMap.get(str);
      QLog.d("NativeProteusBidConfigHandler", 2, "[onReceiveConfig] key=" + str + ", value=" + (String)localObject2);
      if (TextUtils.equals(str, "native_article"))
      {
        ReadInJoyHelper.a("native_proteus_offline_bid", (String)localObject2);
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
      break;
      if (TextUtils.equals(str, "native_article_cdn_url"))
      {
        localObject1 = paramString;
        paramString = (String)localObject2;
        continue;
        ProteusCDNUtils.a(paramString, (String)localObject1);
        return true;
      }
      else
      {
        localObject2 = paramString;
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.a("native_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.NativeProteusBidConfigHandler
 * JD-Core Version:    0.7.0.1
 */