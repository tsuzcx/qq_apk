import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.media.MiniAppLivePusher;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Ljava.util.List<Ljava.lang.String;>;>;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bhkv
  implements DownloaderProxy.DownloadListener
{
  public bhkv(MiniAppLivePusher paramMiniAppLivePusher, String paramString1, String paramString2, bgok parambgok, String paramString3, JSONObject paramJSONObject, String paramString4, DownloaderProxy paramDownloaderProxy) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    MiniAppLivePusher.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher).remove(this.jdField_a_of_type_JavaLangString, this.b);
    QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadFailed failed:" + paramString);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("livePusherId", this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Long);
      localJSONObject.put("errMsg", paramString);
      localJSONObject.put("errCode", 10003);
      this.jdField_a_of_type_Bgok.a.a("onLivePusherError", localJSONObject.toString(), this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher.jdField_a_of_type_Int);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (MiniAppLivePusher.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher))
    {
      QMLog.d("MiniAppLivePusher", "playBGM - download onDownloadProgress, abort");
      this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyDownloaderProxy.abort(this.b);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    for (;;)
    {
      try
      {
        QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed:" + this.b);
        if (MiniAppLivePusher.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher))
        {
          QMLog.e("MiniAppLivePusher", "playBGM - download onDownloadSucceed but needToStopDownloadBGM");
          return;
        }
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        paramMap = new File(this.c);
        localObject = paramMap;
        if (!paramMap.exists())
        {
          localObject = paramMap;
          if (!TextUtils.isEmpty(paramString)) {
            QMLog.e("MiniAppLivePusher", "file no exists, try to copy again.");
          }
        }
      }
      catch (JSONException paramString)
      {
        File localFile;
        paramString.printStackTrace();
        return;
      }
      for (;;)
      {
        try
        {
          localFile = new File(paramString);
          localObject = paramMap;
          if (localFile.exists())
          {
            localObject = paramMap;
            if (localFile.isFile())
            {
              localObject = paramMap;
              if (localFile.length() > 0L)
              {
                QMLog.w("MiniAppLivePusher", "download Succeed but target file not exists, try copy from download tmp file:" + paramString + ", length:" + localFile.length() + ", to:" + this.c);
                localObject = bgpc.a(this.c);
                paramMap = (Map<String, List<String>>)localObject;
              }
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          Map<String, List<String>> localMap;
          continue;
        }
        try
        {
          if ((!bgpc.b(localFile, paramMap)) || (!paramMap.exists()) || (paramMap.length() != localFile.length())) {
            continue;
          }
          QMLog.i("MiniAppLivePusher", "copy from download tmp file:" + paramString + " success");
          localObject = paramMap;
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("MiniAppLivePusher", "try copy from download tmp file exception! tmp file:" + paramString, localThrowable1);
          localMap = paramMap;
          break;
          QMLog.d("MiniAppLivePusher", "download failed, filepath not exists, tmpFile:" + paramString);
          return;
        }
      }
      MiniAppLivePusher.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher).remove(this.jdField_a_of_type_JavaLangString);
      if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
        break label420;
      }
      if (QMLog.isColorLevel()) {
        QMLog.d("MiniAppLivePusher", "download success BGMFilePath:" + this.c);
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("BGMFilePath", this.c);
      MiniAppLivePusher.a(this.jdField_a_of_type_ComTencentQqminiSdkRuntimeWidgetMediaMiniAppLivePusher).a(this.d, this.jdField_a_of_type_OrgJsonJSONObject);
      return;
      Object localObject = paramMap;
      if (paramMap.exists())
      {
        paramMap.delete();
        localObject = paramMap;
      }
    }
    label420:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkv
 * JD-Core Version:    0.7.0.1
 */