import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class bjvx
  extends bjts
{
  private bjvw jdField_a_of_type_Bjvw = new bjvw();
  private String jdField_a_of_type_JavaLangString = "";
  private bjvw jdField_b_of_type_Bjvw = new bjvw();
  private String jdField_b_of_type_JavaLangString = "";
  
  private String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "no sdcard");
        }
        return "";
      }
      Object localObject = bjea.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = ((String)localObject + "tencent/Qzone/tinyprogram/");
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (!((File)localObject).exists())
      {
        if (!((File)localObject).mkdirs())
        {
          if (QLog.isColorLevel()) {
            QLog.i("QzoneSoundPlugin", 2, "make dir fail");
          }
          return "";
        }
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "make dir suc");
        }
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.i("QzoneSoundPlugin", 2, "dir is exists");
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QzoneSoundPlugin", 2, "cache root found use : " + this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_Bjvw != null) {
      this.jdField_a_of_type_Bjvw.b();
    }
  }
  
  private void b(String... paramVarArgs)
  {
    if (this.jdField_b_of_type_Bjvw != null) {
      this.jdField_b_of_type_Bjvw.b();
    }
  }
  
  private void c(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = bfhi.d(new JSONObject(paramVarArgs[0]).optString("url"));
      paramVarArgs = a() + paramVarArgs + ".mp3";
      QLog.d("QzoneSoundPlugin", 2, "playLocalSound : " + paramVarArgs);
      if (new File(paramVarArgs).exists())
      {
        this.jdField_b_of_type_Bjvw.a(paramVarArgs);
        this.jdField_b_of_type_Bjvw.a();
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
  
  private void d(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = bfhi.d(new JSONObject(paramVarArgs[0]).optString("url"));
      paramVarArgs = a() + paramVarArgs + ".mp3";
      QLog.d("QzoneSoundPlugin", 2, "playLocalBackSound : " + paramVarArgs);
      if (new File(paramVarArgs).exists())
      {
        this.jdField_a_of_type_Bjvw.a(paramVarArgs);
        this.jdField_a_of_type_Bjvw.a();
      }
      return;
    }
    catch (Exception paramVarArgs) {}
  }
  
  private void e(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).optString("callback");
        Object localObject1 = ((JSONObject)localObject2).optString("url");
        localObject2 = bfhi.d(((JSONObject)localObject2).optString("url"));
        QLog.d("QzoneSoundPlugin", 2, "downloadMusicUrl : " + (String)localObject1);
        QLog.d("QzoneSoundPlugin", 2, "downloadMusicMD5 : " + (String)localObject2);
        this.jdField_b_of_type_JavaLangString = (a() + (String)localObject2 + ".mp3");
        QLog.d("QzoneSoundPlugin", 2, "mDownloadMusicFinalCachePath : " + this.jdField_b_of_type_JavaLangString);
        if (!new File(this.jdField_b_of_type_JavaLangString).exists())
        {
          DownloaderFactory.getInstance(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a()).getCommonDownloader().download((String)localObject1, this.jdField_b_of_type_JavaLangString, new bjvy(this, paramVarArgs));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneSoundPlugin", 2, "The Music File is Exist");
        }
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("code", 0);
          ((JSONObject)localObject1).put("message", "success");
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(paramVarArgs, new String[] { ((JSONObject)localObject1).toString() });
          return;
        }
        catch (Exception paramVarArgs)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.i("QzoneSoundPlugin", 2, "DownloaderFactory onDownloadSucceed : " + paramVarArgs.getMessage());
        return;
      }
      catch (JSONException paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneSoundPlugin", 2, "METHOD_DOWNLOAD_SUPER_LIKE_MUSIC: ", paramVarArgs);
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("QzoneSoundPlugin", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Bjvw != null)
    {
      this.jdField_a_of_type_Bjvw.a();
      this.jdField_a_of_type_Bjvw = null;
    }
    if (this.jdField_b_of_type_Bjvw != null)
    {
      this.jdField_b_of_type_Bjvw.a();
      this.jdField_b_of_type_Bjvw = null;
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("playLocalSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "playLocalSound");
      }
      c(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("playLocalBackSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "playLocalBackSound");
      }
      d(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("preloadSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "preloadSound");
      }
      e(paramVarArgs);
      return true;
    }
    if (paramString3.equalsIgnoreCase("stopLocalSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "stopLocalSound");
      }
      b(new String[0]);
      return true;
    }
    if (paramString3.equalsIgnoreCase("stopLocalBackSound"))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QzoneSoundPlugin", 2, "stopLocalBackSound");
      }
      a(new String[0]);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvx
 * JD-Core Version:    0.7.0.1
 */