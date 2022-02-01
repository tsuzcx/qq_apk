package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class ApolloPluginRscLoader$1
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$1(ApolloPluginRscLoader paramApolloPluginRscLoader, JSONArray paramJSONArray, File paramFile, AppInterface paramAppInterface, String paramString1, int[] paramArrayOfInt, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    QLog.d("[cmshow]ApolloPluginRscLoader", 1, new Object[] { "getCombination onDownLoadFinish success:", Boolean.valueOf(paramBoolean) });
    if (paramInt1 > 0)
    {
      paramString = this.g;
      if (ApolloPluginRscLoader.a(this.g).b(paramInt1)) {
        paramInt2 = 0;
      } else {
        paramInt2 = 2;
      }
      paramString = ApolloPluginRscLoader.a(paramString, 1, String.valueOf(paramInt1), paramInt2);
      this.a.put(paramString);
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfInt.length)
      {
        paramString = this.g;
        int i = paramArrayOfInt[paramInt1];
        if (ApolloPluginRscLoader.a(this.g).a(paramArrayOfInt[paramInt1])) {
          paramInt2 = 0;
        } else {
          paramInt2 = 2;
        }
        paramString = ApolloPluginRscLoader.a(paramString, 2, String.valueOf(i), paramInt2);
        this.a.put(paramString);
        paramInt1 += 1;
      }
    }
    paramString = this.b;
    if ((paramString != null) && (!paramString.exists()))
    {
      ApolloPluginRscLoader.a(this.g).a().a(this.c, this.d, new ApolloPluginRscLoader.1.1(this));
      return;
    }
    if (!TextUtils.isEmpty(this.d))
    {
      paramString = ApolloPluginRscLoader.a(this.g, 6, this.d, 0);
      this.a.put(paramString);
    }
    paramString = this.e;
    if ((paramString != null) && (paramString.length > 0))
    {
      ApolloPluginRscLoader.a(this.g, paramString, this.f, this.a);
      return;
    }
    this.g.a(this.f, HardCodeUtil.a(2131898733), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.1
 * JD-Core Version:    0.7.0.1
 */