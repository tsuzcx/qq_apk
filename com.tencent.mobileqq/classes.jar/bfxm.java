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

public class bfxm
  extends BaseJsModule
{
  private bfxn jdField_a_of_type_Bfxn;
  private WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public bfxm()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof ToolRuntimePeak)) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((AppInterface)((ToolRuntimePeak)localAppRuntime).getAppRuntime("peak"));
    }
  }
  
  public void a(bfxn parambfxn)
  {
    this.jdField_a_of_type_Bfxn = parambfxn;
  }
  
  public String getModuleName()
  {
    return "textEffect";
  }
  
  public boolean handleJsRequest(String paramString, JSONObject paramJSONObject, InvokeCallback paramInvokeCallback)
  {
    wxe.b("TextEffectModule", "handleJsRequest method = " + paramString);
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
        paramJSONObject = anmj.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramJSONObject);
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
        paramJSONObject = ((blrx)blqr.a(5)).a.b;
        if (!TextUtils.isEmpty(paramJSONObject)) {
          paramInvokeCallback.exec(0, "success", new JSONObject(paramJSONObject));
        }
        while (this.jdField_a_of_type_Bfxn != null)
        {
          this.jdField_a_of_type_Bfxn.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxm
 * JD-Core Version:    0.7.0.1
 */