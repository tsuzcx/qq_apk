import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.export.js.VipDownloadInterface;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bjou
  implements bjnh
{
  public bjou(VipDownloadInterface paramVipDownloadInterface, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    bjko.e(this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString, "getQueryDownloadAction ERROR");
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    bjko.c(this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString, "getQueryDownloadAction onResult = " + paramList.size());
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
    bjko.c(this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.jdField_a_of_type_JavaLangString, "querySucess : " + paramList);
    this.jdField_a_of_type_ComTencentOpenExportJsVipDownloadInterface.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjou
 * JD-Core Version:    0.7.0.1
 */