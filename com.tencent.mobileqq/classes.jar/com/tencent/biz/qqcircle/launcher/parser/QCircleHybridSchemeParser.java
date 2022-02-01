package com.tencent.biz.qqcircle.launcher.parser;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleJsUrlConfig;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class QCircleHybridSchemeParser
  extends QCircleBaseSchemeParser
{
  private void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (!paramHashMap.containsKey("url")) {
        return;
      }
      try
      {
        localObject1 = URLDecoder.decode((String)paramHashMap.get("url"));
        if (((String)localObject1).startsWith("https://h5.qzone.qq.com/v2/wezone/message"))
        {
          localObject1 = QCircleJsUrlConfig.b((String)localObject1);
          ((HashMap)localObject1).put("from", String.valueOf(7));
          localObject2 = new QCircleSchemeBean();
          ((QCircleSchemeBean)localObject2).setAttrs((HashMap)localObject1);
          ((QCircleSchemeBean)localObject2).setSchemeAction("opennoticelist");
          QCircleSchemeLauncher.b(paramContext, (QCircleSchemeBean)localObject2);
          return;
        }
        Object localObject2 = new Intent();
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) {
            ((Intent)localObject2).putExtra((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
        QCircleLauncher.a(paramContext, (String)localObject1, (Intent)localObject2, -1);
        return;
      }
      catch (Exception paramContext)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseUrl:");
        ((StringBuilder)localObject1).append((String)paramHashMap.get("url"));
        ((StringBuilder)localObject1).append(" error:");
        ((StringBuilder)localObject1).append(paramContext.getMessage());
        QLog.e("QCircleBaseSchemeParser", 1, ((StringBuilder)localObject1).toString());
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a(Context paramContext, QCircleSchemeBean paramQCircleSchemeBean)
  {
    a(paramContext, paramQCircleSchemeBean.getAttrs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.launcher.parser.QCircleHybridSchemeParser
 * JD-Core Version:    0.7.0.1
 */