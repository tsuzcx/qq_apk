package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloPluginRscLoader$8
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$8(ApolloPluginRscLoader paramApolloPluginRscLoader, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getApolloRsc onDownLoadFinish:");
      paramString.append(paramInt1);
      paramString.append(" sucess:");
      paramString.append(paramBoolean);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      if (this.a.exists())
      {
        paramString = this.c;
        paramArrayOfInt = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(HardCodeUtil.a(2131898756));
        ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 0, localStringBuilder.toString());
        return;
      }
      paramString = this.c;
      paramArrayOfInt = this.b;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(HardCodeUtil.a(2131898732));
      ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 2, localStringBuilder.toString());
      return;
    }
    paramString = this.c;
    paramArrayOfInt = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(HardCodeUtil.a(2131898750));
    ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.8
 * JD-Core Version:    0.7.0.1
 */