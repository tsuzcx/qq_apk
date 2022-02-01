import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bmmj
  extends bmmk
{
  private static JSONObject a;
  
  private static void a(String paramString)
  {
    QLog.i("QzoneInternalWebViewPlugin", 2, "saxon@ openUserInfoCard uin is " + paramString);
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_OPEN_USER_INFO_CARD");
      localIntent.putExtra("uin", paramString);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyOpenUserInfoCard exception", paramString);
    }
  }
  
  private static void b()
  {
    QLog.i("QzoneInternalWebViewPlugin", 2, "saxon@ hideInnerWebview running");
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_HIDE_INNER_WEBVIEW");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyHideInnerWebview exception", localThrowable);
    }
  }
  
  private static void c()
  {
    QLog.i("QzoneInternalWebViewPlugin", 2, "saxon@ onPageReady running");
    try
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_NOTIFY_PAGE_READY");
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QzoneInternalWebViewPlugin", 1, "saxon@ notifyPageReadyInnerWebview exception", localThrowable);
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"qzlive".equals(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null)) {}
    boolean bool;
    do
    {
      do
      {
        return false;
      } while (TextUtils.isEmpty(paramString3));
      QLog.i("QzoneInternalWebViewPlugin", 2, "qz_livevideo_jsbridge, dispatch method callback linkchain, " + paramString3);
      bool = b(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      try
      {
        paramJsBridgeListener = new Intent("com.tencent.mobileqq.action.ACTION_QZ_LIVE_DISPATCH_EVENT");
        paramJsBridgeListener.putExtra("event", paramString3);
        if ((paramVarArgs != null) && (paramVarArgs.length > 0))
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          if (paramString1 != null) {
            paramJsBridgeListener.putExtra("data", paramString1.toString());
          }
        }
        BaseApplicationImpl.getContext().sendBroadcast(paramJsBridgeListener, "com.tencent.msg.permission.pushnotify");
        if (!bool) {}
        return true;
      }
      catch (Throwable paramJsBridgeListener)
      {
        QLog.e("QzoneInternalWebViewPlugin", 1, "qz_livevideo_jsbridge, dispatch method callback linkchain exception", paramJsBridgeListener);
      }
    } while (!bool);
    return true;
  }
  
  public boolean b(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("getLiveMusicUrl".equals(paramString3)) {
      if (paramVarArgs != null) {
        try
        {
          if (paramVarArgs.length == 1)
          {
            jdField_a_of_type_OrgJsonJSONObject = new JSONObject(paramVarArgs[0]);
            if (jdField_a_of_type_OrgJsonJSONObject != null)
            {
              paramJsBridgeListener = jdField_a_of_type_OrgJsonJSONObject.optJSONObject("data");
              paramJsBridgeListener.getString("file_mid");
              paramJsBridgeListener = paramJsBridgeListener.getString("song_mid");
              paramString1 = new Intent("com.qzone.module.browser.plugin.QzLivePlugin.liveMusicSelect");
              paramString1.putExtra("get_live_music_song_mid", paramJsBridgeListener);
              BaseApplicationImpl.getApplication().sendBroadcast(paramString1);
              if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() != null)) {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
              }
            }
            return true;
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          QLog.w("QzoneInternalWebViewPlugin", 1, "getLiveMusicUrl Exception" + paramJsBridgeListener.toString());
        }
      }
    }
    label157:
    label334:
    do
    {
      for (;;)
      {
        return false;
        if ("getAuthenticationResults".equals(paramString3))
        {
          if (paramVarArgs != null) {
            for (;;)
            {
              try
              {
                if (paramVarArgs.length <= 0) {
                  break label157;
                }
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                if (paramJsBridgeListener == null) {
                  break;
                }
                int i = paramJsBridgeListener.getInt("result");
                int j = paramJsBridgeListener.getInt("from");
                paramJsBridgeListener = new Intent("com.cooperation.cooperation.qzone.webviewplugin.QzoneInterActiveVideoPlugin.getAuthenticationResults");
                paramJsBridgeListener.putExtra("result", i);
                paramJsBridgeListener.putExtra("from", j);
                BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
                if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a() == null)) {
                  break label334;
                }
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().finish();
                QLog.i("QzoneInternalWebViewPlugin", 1, "result is " + i + ",from is " + j);
                return true;
              }
              catch (Exception paramJsBridgeListener)
              {
                QLog.w("QzoneInternalWebViewPlugin", 1, "doAuthentication catch an exception in handleJsRequest", paramJsBridgeListener);
              }
              break label157;
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null) {
                QLog.i("QzoneInternalWebViewPlugin", 1, " the parentPlugin.mRuntime is null");
              } else {
                QLog.i("QzoneInternalWebViewPlugin", 1, " parentPlugin.mRuntime.getActivity() is null");
              }
            }
          }
        }
        else
        {
          if (!"openUserInfoCard".equals(paramString3)) {
            break label460;
          }
          if (paramVarArgs != null) {
            try
            {
              if (paramVarArgs.length > 0)
              {
                paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("uin");
                if ((paramJsBridgeListener != null) && (paramJsBridgeListener.length() != 0)) {
                  break label454;
                }
                QLog.w("QzoneInternalWebViewPlugin", 1, "openUserInfoCard uin is empty");
                return true;
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.w("QzoneInternalWebViewPlugin", 1, "openUserInfoCard Exception" + paramJsBridgeListener);
            }
          }
        }
      }
      a(paramJsBridgeListener);
      return true;
      if ("hideInnerWebview".equals(paramString3))
      {
        b();
        return true;
      }
    } while (!"onPageReady".equals(paramString3));
    label454:
    label460:
    c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmj
 * JD-Core Version:    0.7.0.1
 */