import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolRuntimePeak;
import com.tencent.qg.sdk.invoke.BaseJsModule;
import com.tencent.qg.sdk.invoke.InvokeCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class bcos
  extends BaseJsModule
{
  private bcot jdField_a_of_type_Bcot;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bcos()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof ToolRuntimePeak)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((AppInterface)((ToolRuntimePeak)localAppRuntime).getAppRuntime("peak"));
    }
  }
  
  public void a(bcot parambcot)
  {
    this.jdField_a_of_type_Bcot = parambcot;
  }
  
  public String getModuleName()
  {
    return "textEffect";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    urk.b("TextEffectModule", "handleJsRequest method = " + paramString);
    try
    {
      if ("wordSplit".equals(paramString))
      {
        if (paramJSONObject == null)
        {
          paramInvokeCallback.exec(4);
          return false;
        }
        JSONArray localJSONArray = new JSONArray();
        paramJSONObject = paramJSONObject.optString("text");
        if (TextUtils.isEmpty(paramJSONObject))
        {
          paramInvokeCallback.exec(0, "success", localJSONArray);
          return true;
        }
        paramJSONObject = alcv.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramJSONObject);
        if (!paramJSONObject.jdField_a_of_type_Boolean)
        {
          paramInvokeCallback.exec(-1, "sdk init failed! soLoaded.");
          return false;
        }
        if (paramJSONObject.jdField_a_of_type_ArrayOfJavaLangString != null)
        {
          paramJSONObject = paramJSONObject.jdField_a_of_type_ArrayOfJavaLangString;
          int j = paramJSONObject.length;
          int i = 0;
          while (i < j)
          {
            localJSONArray.put(paramJSONObject[i]);
            i += 1;
          }
        }
        paramInvokeCallback.exec(0, "success", localJSONArray);
        return true;
      }
      if ("getTextConfig".equals(paramString))
      {
        paramJSONObject = ((bhgs)bhfm.a(5)).a.b;
        if (!TextUtils.isEmpty(paramJSONObject)) {
          paramInvokeCallback.exec(0, "success", new JSONObject(paramJSONObject));
        }
        while (this.jdField_a_of_type_Bcot != null)
        {
          this.jdField_a_of_type_Bcot.a();
          break;
          paramInvokeCallback.exec(-1, "text config is empty!");
        }
      }
      return false;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("TextEffectModule", 1, "handle method " + paramString + "failed", paramJSONObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcos
 * JD-Core Version:    0.7.0.1
 */