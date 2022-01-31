import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import org.json.JSONObject;

class betv
  implements AsyncResult
{
  betv(bett parambett, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    betc.b("EngineManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.jdField_a_of_type_Int)));
      betc.b("EngineManager", "[MiniEng] engineLibInfo " + paramJSONObject);
      betq.c(this.jdField_a_of_type_Bett.a, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     betv
 * JD-Core Version:    0.7.0.1
 */