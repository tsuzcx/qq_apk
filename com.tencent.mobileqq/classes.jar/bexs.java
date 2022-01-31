import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class bexs
  extends WebViewPlugin
{
  public bexs()
  {
    this.mPluginNameSpace = "floatingWindow";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("floatingWindow".equals(paramString2))
    {
      if ("show".equals(paramString3))
      {
        bexu.a(BaseApplication.getContext(), true, 16);
        return true;
      }
      if ("hide".equals(paramString3))
      {
        bexu.a(BaseApplication.getContext(), false, 16);
        return true;
      }
      if ("close".equals(paramString3))
      {
        bexu.a(BaseApplicationImpl.getContext(), 16);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, "onActivityResult requestCode=" + paramByte + "  resultCode=" + paramInt);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, "onCreate");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bexs
 * JD-Core Version:    0.7.0.1
 */