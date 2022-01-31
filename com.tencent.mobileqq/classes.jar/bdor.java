import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import org.json.JSONObject;

class bdor
  implements AsyncResult
{
  bdor(bdop parambdop, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    bdnw.b("EngineManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.jdField_a_of_type_Int)));
      bdnw.b("EngineManager", "[MiniEng] engineLibInfo " + paramJSONObject);
      bdom.c(this.jdField_a_of_type_Bdop.a, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdor
 * JD-Core Version:    0.7.0.1
 */