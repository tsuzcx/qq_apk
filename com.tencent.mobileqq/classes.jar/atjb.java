import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

public final class atjb
  implements EIPCResultCallback
{
  public atjb(JSONObject paramJSONObject, spj paramspj, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {}
    for (boolean bool = paramEIPCResult.data.getBoolean("action_update_biu_and_comment_switch");; bool = false) {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("isGrayscaleUser", bool);
        QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig is " + bool);
        this.jdField_a_of_type_Spj.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
        return;
      }
      catch (JSONException paramEIPCResult)
      {
        for (;;)
        {
          QLog.e("UiApiPlugin", 1, "webGetCommentAladdinConfig error " + paramEIPCResult.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjb
 * JD-Core Version:    0.7.0.1
 */