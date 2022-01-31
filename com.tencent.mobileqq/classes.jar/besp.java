import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager.2;
import com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1;
import org.json.JSONObject;

public class besp
  implements AsyncResult
{
  public besp(BaseLibManager.2 param2, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    besl.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      beiw.b().post(new BaseLibManager.2.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (besn.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        besl.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0.a((String)localObject, paramJSONObject, this.jdField_a_of_type_JavaLangString, this.b, null);
        paramJSONObject = beqh.a().a();
        if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.appId))) {
          beyb.b(paramJSONObject.appId, false);
        }
      }
      do
      {
        return;
        besl.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
        besn.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, 1);
        paramJSONObject = beqh.a().a();
      } while ((paramJSONObject == null) || (TextUtils.isEmpty(paramJSONObject.appId)));
      beyb.b(paramJSONObject.appId, true);
      return;
    }
    besl.d("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    besn.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, 1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besp
 * JD-Core Version:    0.7.0.1
 */