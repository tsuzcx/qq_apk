import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager.1;
import com.tencent.qqmini.sdk.manager.BaseLibManager.1.1.1;
import org.json.JSONObject;

public class betf
  implements AsyncResult
{
  public betf(BaseLibManager.1 param1, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      bejn.b().post(new BaseLibManager.1.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (bete.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        betc.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.this$0.a((String)localObject, paramJSONObject, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a);
      }
    }
    do
    {
      do
      {
        return;
        betc.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
      } while (this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a == null);
      this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a.a(1);
      return;
      betc.d("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    } while (this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a == null);
    this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a.a(1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betf
 * JD-Core Version:    0.7.0.1
 */