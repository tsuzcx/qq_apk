import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager.2;
import com.tencent.qqmini.sdk.manager.BaseLibManager.2.1.1;
import org.json.JSONObject;

public class betg
  implements AsyncResult
{
  public betg(BaseLibManager.2 param2, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      bejn.b().post(new BaseLibManager.2.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (bete.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        betc.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0.a((String)localObject, paramJSONObject, this.jdField_a_of_type_JavaLangString, this.b, null);
        paramJSONObject = beqy.a().a();
        if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.appId))) {
          beys.b(paramJSONObject.appId, false);
        }
      }
      do
      {
        return;
        betc.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
        bete.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, 1);
        paramJSONObject = beqy.a().a();
      } while ((paramJSONObject == null) || (TextUtils.isEmpty(paramJSONObject.appId)));
      beys.b(paramJSONObject.appId, true);
      return;
    }
    betc.d("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    bete.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$2.this$0, 1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betg
 * JD-Core Version:    0.7.0.1
 */