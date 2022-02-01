package com.tencent.mobileqq.apollo.web.jsmodule;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ThunderJsModule
  extends BaseJsModule
{
  public ThunderJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  @RequestRoute(a="clearThunderCache")
  private void clearThunderCache(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/webview/");
    if (!((File)localObject).exists())
    {
      b(paramCmshowWebReqParam);
      return;
    }
    localObject = ((File)localObject).listFiles();
    if ((localObject != null) && (localObject.length != 0))
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = localObject[i];
        if (localFile.isDirectory())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localFile.getName());
          localStringBuilder.append(".txt");
          if (new File(localFile, localStringBuilder.toString()).exists())
          {
            FileUtils.deleteDirectory(localFile.getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("clearThunderCache, htmlFileDir:");
              localStringBuilder.append(localFile.getName());
              QLog.d("[cmshow]ThunderJsModule", 2, localStringBuilder.toString());
            }
          }
        }
        i += 1;
      }
      b(paramCmshowWebReqParam);
      return;
    }
    b(paramCmshowWebReqParam);
  }
  
  @RequestRoute(a="resumeThunderCache")
  private void resumeThunderCache(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).resumeThunderCache();
    b(paramCmshowWebReqParam);
  }
  
  @RequestRoute(a="stopThunderCache")
  private void stopThunderCache(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).stopThunderCache();
    b(paramCmshowWebReqParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.ThunderJsModule
 * JD-Core Version:    0.7.0.1
 */