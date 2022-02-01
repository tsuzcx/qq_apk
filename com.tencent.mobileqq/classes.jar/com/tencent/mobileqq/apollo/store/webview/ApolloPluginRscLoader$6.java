package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import java.io.File;

class ApolloPluginRscLoader$6
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$6(ApolloPluginRscLoader paramApolloPluginRscLoader, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (this.a.exists())
      {
        paramString = this.c;
        paramArrayOfInt = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(HardCodeUtil.a(2131898754));
        ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 0, localStringBuilder.toString());
        return;
      }
      paramString = this.c;
      paramArrayOfInt = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(HardCodeUtil.a(2131898730));
      ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 2, localStringBuilder.toString());
      return;
    }
    paramString = this.c;
    paramArrayOfInt = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(HardCodeUtil.a(2131898751));
    ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.6
 * JD-Core Version:    0.7.0.1
 */