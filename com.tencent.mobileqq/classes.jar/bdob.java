import android.os.Handler;
import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.BaseLibManager.1;
import com.tencent.qqmini.sdk.manager.BaseLibManager.1.1.1;
import org.json.JSONObject;

public class bdob
  implements AsyncResult
{
  public bdob(BaseLibManager.1 param1, String paramString1, String paramString2) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      bdew.b().post(new BaseLibManager.1.1.1(this, paramJSONObject));
      Object localObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(1)));
      if (bdoa.a(this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.this$0, (BaseLibInfo)localObject).booleanValue())
      {
        paramJSONObject = ((BaseLibInfo)localObject).baseLibVersion;
        localObject = ((BaseLibInfo)localObject).baseLibUrl;
        bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib end : version : " + paramJSONObject + "; url : " + (String)localObject);
        this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.this$0.a((String)localObject, paramJSONObject, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a);
      }
    }
    do
    {
      do
      {
        return;
        bdnw.b("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib, no update");
      } while (this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a == null);
      this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a.a(1);
      return;
      bdnw.d("miniapp-process_BaseLibManager", "[MiniEng] updateBaseLib failed!");
    } while (this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a == null);
    this.jdField_a_of_type_ComTencentQqminiSdkManagerBaseLibManager$1.a.a(1100);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdob
 * JD-Core Version:    0.7.0.1
 */