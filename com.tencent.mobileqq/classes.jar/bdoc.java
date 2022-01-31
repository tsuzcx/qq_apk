import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager.2;
import com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1;
import org.json.JSONObject;

public class bdoc
  implements AsyncResult
{
  public bdoc(BaseLibManager.2 param2, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      bdew.b().post(new BaseLibManager.2.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (bdoa.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0.a((String)localObject, paramJSONObject, this.jdField_a_of_type_JavaLangString, this.b, null);
        paramJSONObject = bdlx.a().a();
        if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.appId))) {
          bdse.b(paramJSONObject.appId, false);
        }
      }
      do
      {
        return;
        bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
        bdoa.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, 1);
        paramJSONObject = bdlx.a().a();
      } while ((paramJSONObject == null) || (TextUtils.isEmpty(paramJSONObject.appId)));
      bdse.b(paramJSONObject.appId, true);
      return;
    }
    bdnw.d("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    bdoa.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, 1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdoc
 * JD-Core Version:    0.7.0.1
 */