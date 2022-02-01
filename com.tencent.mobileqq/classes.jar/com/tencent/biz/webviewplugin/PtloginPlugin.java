package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import mqq.manager.TicketManager;

public class PtloginPlugin
  extends WebViewPlugin
{
  private AuthorizeConfig a;
  
  public PtloginPlugin()
  {
    this.mPluginNameSpace = getClass().getSimpleName();
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (("http".equals(paramString2)) || ("https".equals(paramString2)))
    {
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("handleSchemaRequest, originUrl=");
        paramString2.append(paramString1);
        QLog.d("PtloginPlugin", 2, paramString2.toString());
      }
      paramString2 = this.a;
      if (paramString2 == null) {
        return false;
      }
      paramString2 = paramString2.a("ptlogin2");
      if (paramString2 != null)
      {
        if (paramString2.isEmpty()) {
          return false;
        }
        Object localObject2 = this.mRuntime.a();
        paramString2 = paramString2.iterator();
        while (paramString2.hasNext())
        {
          Object localObject1 = (String)paramString2.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("/jump?");
          if (paramString1.startsWith(localStringBuilder.toString()))
          {
            if (paramString1.contains("clientuin=$UIN$"))
            {
              paramString2 = new StringBuilder();
              paramString2.append("clientuin=");
              paramString2.append(((AppInterface)localObject2).getAccount());
            }
            for (paramString2 = paramString1.replace("clientuin=$UIN$", paramString2.toString());; paramString2 = paramString1.replace("clientuin=$UIN", paramString2.toString()))
            {
              i = 1;
              break label277;
              if (!paramString1.contains("clientuin=$UIN")) {
                break;
              }
              paramString2 = new StringBuilder();
              paramString2.append("clientuin=");
              paramString2.append(((AppInterface)localObject2).getAccount());
            }
            paramString2 = paramString1;
            i = 0;
            label277:
            if (paramString1.contains("clientkey=$KEY$"))
            {
              localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((TicketManager)localObject1).getStweb(((AppInterface)localObject2).getAccount());
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("clientkey=");
              localObject2 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = "";
              }
              localStringBuilder.append((String)localObject2);
            }
            for (localObject1 = paramString2.replace("clientkey=$KEY$", localStringBuilder.toString());; localObject1 = paramString2.replace("clientkey=$KEY", localStringBuilder.toString()))
            {
              i = 1;
              break;
              localObject1 = paramString2;
              if (!paramString1.contains("clientkey=$KEY")) {
                break;
              }
              localObject1 = (TicketManager)((AppInterface)localObject2).getManager(2);
              if (localObject1 == null) {
                localObject1 = null;
              } else {
                localObject1 = ((TicketManager)localObject1).getStweb(((AppInterface)localObject2).getAccount());
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("clientkey=");
              localObject2 = localObject1;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                localObject2 = "";
              }
              localStringBuilder.append((String)localObject2);
            }
            if (paramString1.contains("keyindex=$KEYINDEX$")) {}
            for (paramString1 = ((String)localObject1).replace("keyindex=$KEYINDEX$", "keyindex=19");; paramString1 = ((String)localObject1).replace("keyindex=$KEYINDEX", "keyindex=19"))
            {
              i = 1;
              break label540;
              if (!paramString1.contains("keyindex=$KEYINDEX")) {
                break;
              }
            }
            paramString1 = (String)localObject1;
            break label540;
          }
        }
        int i = 0;
        label540:
        if (i != 0)
        {
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("handleSchemaRequest, replacePtloginUrl, duration=");
            paramString2.append(System.currentTimeMillis() - l);
            QLog.d("PtloginPlugin", 2, paramString2.toString());
          }
          if (QLog.isColorLevel()) {
            QLog.d("PtloginPlugin", 2, "handleSchemaRequest, load replaced url");
          }
          paramString2 = this.mRuntime.a();
          if (paramString2 != null) {
            paramString2.loadUrlOriginal(paramString1);
          }
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleSchemaRequest, not replaced, duration=");
          paramString1.append(System.currentTimeMillis() - l);
          QLog.d("PtloginPlugin", 2, paramString1.toString());
        }
      }
    }
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = AuthorizeConfig.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.PtloginPlugin
 * JD-Core Version:    0.7.0.1
 */