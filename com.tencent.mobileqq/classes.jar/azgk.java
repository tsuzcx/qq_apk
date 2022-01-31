import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class azgk
  extends bceg<HashMap<String, Object>, Void, JSONObject>
{
  protected int a;
  protected Bundle a;
  protected azgl a;
  protected boolean a;
  
  public azgk(String paramString1, String paramString2, azgl paramazgl, int paramInt, Bundle paramBundle)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_Azgl = paramazgl;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public azgk(String paramString1, String paramString2, azgl paramazgl, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.jdField_a_of_type_Azgl = paramazgl;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected JSONObject a(HashMap<String, Object>... paramVarArgs)
  {
    if (isCancelled()) {
      return null;
    }
    Object localObject = paramVarArgs[0];
    if (((((HashMap)localObject).get("CONTEXT") instanceof Context)) && ((((HashMap)localObject).get("BUNDLE") instanceof Bundle)))
    {
      paramVarArgs = (Context)((HashMap)localObject).get("CONTEXT");
      localObject = (Bundle)((HashMap)localObject).get("BUNDLE");
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        String str1 = ((Bundle)localObject).getString("Cookie");
        String str2 = ((Bundle)localObject).getString("Referer");
        String str3 = ((Bundle)localObject).getString("Host");
        if (str1 != null)
        {
          localBundle.putString("Cookie", str1);
          ((Bundle)localObject).remove("Cookie");
        }
        if (str2 != null)
        {
          localBundle.putString("Referer", str2);
          ((Bundle)localObject).remove("Referer");
        }
        if (str3 != null)
        {
          localBundle.putString("Host", str3);
          ((Bundle)localObject).remove(str3);
        }
        localObject = new JSONObject(mpl.a(paramVarArgs, this.jdField_a_of_type_JavaLangString, this.b, (Bundle)localObject, localBundle));
        paramVarArgs = (HashMap<String, Object>[])localObject;
        if (!this.jdField_a_of_type_Boolean)
        {
          paramVarArgs = (HashMap<String, Object>[])localObject;
          if (((JSONObject)localObject).getInt("retcode") == 0) {
            paramVarArgs = ((JSONObject)localObject).getJSONObject("result");
          }
        }
      }
      catch (IOException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (JSONException paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
        paramVarArgs = null;
        continue;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        QLog.w("HttpWebCgiAsyncTask", 1, paramVarArgs.getMessage(), paramVarArgs);
      }
      return paramVarArgs;
      paramVarArgs = null;
    }
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public void a(HashMap<String, Object> paramHashMap)
  {
    Executor localExecutor = a();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new HashMap[] { paramHashMap });
      return;
    }
    execute(new HashMap[] { paramHashMap });
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    if (isCancelled()) {}
    while (this.jdField_a_of_type_Azgl == null) {
      return;
    }
    this.jdField_a_of_type_Azgl.a(paramJSONObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azgk
 * JD-Core Version:    0.7.0.1
 */