import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.open.appcommon.js.DownloadInterface;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfjg
  implements bfpr
{
  protected String a;
  
  public bfjg(DownloadInterface paramDownloadInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.hasRight()) {
      return;
    }
    bflp.e("DownloadInterface", "JsCheckUpdateCallback onException >>> " + paramString);
    paramString = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.jdField_a_of_type_JavaLangString + "\",\"r\":\"-1\"});}void(0);";
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramString);
  }
  
  public void a(ArrayList<ApkUpdateDetail> paramArrayList)
  {
    if (!this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.hasRight()) {
      return;
    }
    bflp.a("DownloadInterface", "JsCheckUpdateCallback onResult >>> " + paramArrayList.size());
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        ApkUpdateDetail localApkUpdateDetail = (ApkUpdateDetail)paramArrayList.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("packageName", localApkUpdateDetail.packageName);
        localJSONObject2.put("newapksize", localApkUpdateDetail.newapksize);
        localJSONObject2.put("patchsize", localApkUpdateDetail.patchsize);
        localJSONObject2.put("updatemethod", localApkUpdateDetail.updatemethod);
        localJSONObject2.put("versioncode", localApkUpdateDetail.versioncode);
        localJSONObject2.put("versionname", localApkUpdateDetail.versionname);
        localJSONObject2.put("fileMd5", localApkUpdateDetail.fileMd5);
        localJSONObject2.put("sigMd5", localApkUpdateDetail.sigMd5);
        localJSONObject2.put("url", localApkUpdateDetail.url);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("guid", this.jdField_a_of_type_JavaLangString);
      localJSONObject1.put("content", localJSONArray.toString());
      localJSONObject1.put("resultCode", "0");
      paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{'guid':'" + this.jdField_a_of_type_JavaLangString + "','r':'0','data':'" + localJSONArray.toString() + "'});}void(0);";
    }
    catch (JSONException paramArrayList)
    {
      for (;;)
      {
        paramArrayList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.checkUpdate',{\"guid\":\"" + this.jdField_a_of_type_JavaLangString + "\",\"r\":\"-1\"});}void(0);";
      }
    }
    bflp.b("DownloadInterface", ">>checkUpdate jsUrl:" + paramArrayList);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramArrayList);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjg
 * JD-Core Version:    0.7.0.1
 */