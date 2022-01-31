import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bcbh
  implements bcgv
{
  public bcbh(DownloadInterface paramDownloadInterface, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    bcds.e("DownloadInterface", "innerQueryDownloadInfo ERROR");
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    bcds.c("DownloadInterface", "innerQueryDownloadInfo onResult = " + paramList.size());
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
          localJSONObject.put("pro", localDownloadInfo.f);
          localJSONObject.put("state", localDownloadInfo.a());
          localJSONObject.put("ismyapp", localDownloadInfo.jdField_c_of_type_Int);
          localJSONObject.put("download_from", localDownloadInfo.h);
          localJSONObject.put("writecodestate", localDownloadInfo.j);
          localJSONArray.put(localJSONObject);
          i += 1;
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
    paramList = "javascript:if (typeof(QzoneApp) === 'object' && typeof(QzoneApp.fire) === 'function') { QzoneApp.fire('interface.getQueryDownloadAction',{\"guid\": " + this.jdField_a_of_type_JavaLangString + ", \"r\" : 0, \"data\":" + localJSONArray.toString() + "});}void(0);";
    bcds.c("DownloadInterface", "querySucess : " + paramList);
    this.jdField_a_of_type_ComTencentOpenAppcommonJsDownloadInterface.jsCallBack(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcbh
 * JD-Core Version:    0.7.0.1
 */