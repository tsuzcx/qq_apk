import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class bjud
  extends BaseJsPlugin
  implements bmxp
{
  private int jdField_a_of_type_Int;
  SparseArray<RequestEvent> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public bjud()
  {
    bmxq.a().a(this);
  }
  
  private int a()
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private JSONObject a(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("WebSsoJsPlugin", 1, "Failed to parse jsonParams=" + paramRequestEvent.jsonParams);
    }
    return null;
  }
  
  public HashSet<String> getFilterCmds()
  {
    bizg localbizg = (bizg)bizh.a().a("comminfo");
    if (localbizg != null) {
      return localbizg.a();
    }
    return bmxq.a;
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("mini_seq", -1);
      if (i != -1) {
        break label26;
      }
    }
    label26:
    RequestEvent localRequestEvent;
    do
    {
      return;
      i = -1;
      break;
      localRequestEvent = (RequestEvent)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    } while (localRequestEvent == null);
    paramIntent = paramJSONObject;
    if (paramJSONObject == null) {
      paramIntent = new JSONObject();
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("cmd", paramString);
      paramJSONObject.put("ret", paramLong);
      paramJSONObject.put("rsp", paramIntent);
      if (paramLong == 0L)
      {
        localRequestEvent.ok(paramJSONObject);
        return;
      }
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
      localRequestEvent.fail(paramJSONObject, "");
    }
  }
  
  @JsEvent({"requestWebSSO"})
  public void requestWebSSO(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = a(paramRequestEvent).getJSONObject("data");
      String str = localJSONObject.getString("webssoCmdId");
      localJSONObject = localJSONObject.getJSONObject("webssoReq");
      Object localObject = getFilterCmds();
      if ((TextUtils.isEmpty(str)) || (localObject == null) || (!((HashSet)localObject).contains(str)))
      {
        paramRequestEvent.fail(anni.a(2131715562));
        return;
      }
      int i = a();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramRequestEvent);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("mini_seq", i);
      bmxq.a().a(str, localJSONObject, (Bundle)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      paramRequestEvent.fail(anni.a(2131715561));
      if (QLog.isColorLevel()) {
        QLog.w("WebSsoJsPlugin", 2, "requestWebSSO,decode param error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjud
 * JD-Core Version:    0.7.0.1
 */