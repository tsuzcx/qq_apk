import com.tencent.qqmini.sdk.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineChannel;
import org.json.JSONObject;

class bgsb
  implements AsyncResult
{
  bgsb(bgsa parambgsa, int paramInt, EngineChannel paramEngineChannel) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QMLog.i("EngineManager", "[MiniEng] updateBaseLib response. isSuc=" + paramBoolean + " rsp=" + paramJSONObject);
    if ((paramBoolean) && (paramJSONObject != null))
    {
      paramJSONObject = BaseLibInfo.fromJSON(paramJSONObject.optJSONObject(BaseLibInfo.getKey(this.jdField_a_of_type_Int)));
      QMLog.i("EngineManager", "[MiniEng] engineLibInfo " + paramJSONObject);
      bgrx.b(this.jdField_a_of_type_Bgsa.a, paramJSONObject, this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineChannel);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgsb
 * JD-Core Version:    0.7.0.1
 */