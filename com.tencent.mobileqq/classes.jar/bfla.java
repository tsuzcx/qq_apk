import android.text.TextUtils;
import com.tencent.open.appstore.js.DINewForCommonWebView;
import com.tencent.open.downloadnew.DownloadInfo;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bfla
  implements bfor
{
  public bfla(DINewForCommonWebView paramDINewForCommonWebView, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    bflp.e("DINewForCommonWebView", "[innerQuery] [onException] errorCode=" + paramInt + ", errorMsg=" + paramString);
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    bflp.c("DINewForCommonWebView", "[innerQuery] onResult = " + paramList.size());
    JSONArray localJSONArray = new JSONArray();
    int j = paramList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        JSONObject localJSONObject = new JSONObject();
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.get(i);
        try
        {
          localJSONObject.put("appid", localDownloadInfo.jdField_c_of_type_JavaLangString);
          localJSONObject.put("packagename", localDownloadInfo.e);
          localJSONObject.put("versioncode", localDownloadInfo.b);
          localJSONObject.put("url", localDownloadInfo.d);
          localJSONObject.put("pro", localDownloadInfo.f);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("ismyapp", localDownloadInfo.jdField_c_of_type_Int);
          localJSONObject.put("download_from", localDownloadInfo.h);
          localJSONObject.put("writecodestate", localDownloadInfo.j);
          if (TextUtils.isEmpty(localDownloadInfo.l)) {
            localJSONObject.put("final_file_exits", "false");
          }
          for (;;)
          {
            localJSONArray.put(localJSONObject);
            i += 1;
            break;
            localJSONObject.put("final_file_exits", new File(localDownloadInfo.l).exists());
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    paramList = "javascript:" + this.jdField_a_of_type_JavaLangString + "(" + localJSONArray.toString() + ")";
    bflp.c("DINewForCommonWebView", "[innerQuery] querySucess : " + paramList);
    DINewForCommonWebView.a(this.jdField_a_of_type_ComTencentOpenAppstoreJsDINewForCommonWebView, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfla
 * JD-Core Version:    0.7.0.1
 */