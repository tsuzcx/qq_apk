package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ApolloPluginRscLoader$7
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloPluginRscLoader$7(ApolloPluginRscLoader paramApolloPluginRscLoader, int paramInt, File paramFile, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getApolloRsc onDownLoadFinish:");
      paramString.append(this.a);
      paramString.append(" sucess:");
      paramString.append(paramBoolean);
      QLog.d("[cmshow]ApolloPluginRscLoader", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      if (this.b.exists())
      {
        paramString = this.d;
        paramArrayOfInt = this.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append(HardCodeUtil.a(2131898737));
        ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 0, localStringBuilder.toString());
        return;
      }
      paramString = this.d;
      paramArrayOfInt = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(HardCodeUtil.a(2131898736));
      ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 2, localStringBuilder.toString());
      return;
    }
    paramString = this.d;
    paramArrayOfInt = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(HardCodeUtil.a(2131898758));
    ApolloPluginRscLoader.a(paramString, paramArrayOfInt, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloPluginRscLoader.7
 * JD-Core Version:    0.7.0.1
 */