import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class blaa
{
  static EIPCResultCallback jdField_a_of_type_EipcEIPCResultCallback = new blab();
  static Vector<blac> jdField_a_of_type_JavaUtilVector;
  static JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  static
  {
    jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  public static int a(String paramString, int paramInt)
  {
    return jdField_a_of_type_OrgJsonJSONObject.optInt(paramString, paramInt);
  }
  
  public static void a()
  {
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "getComicConfig", localBundle, jdField_a_of_type_EipcEIPCResultCallback);
  }
  
  public static void a(blac paramblac)
  {
    if (paramblac != null) {
      jdField_a_of_type_JavaUtilVector.add(paramblac);
    }
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("VipComicCommonConfig");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = paramString.optJSONObject(i);
            if ((localObject == null) || (!bhre.a((JSONObject)localObject, "VipComicCommonConfig"))) {
              break label118;
            }
            jdField_a_of_type_OrgJsonJSONObject = (JSONObject)localObject;
            paramString = jdField_a_of_type_JavaUtilVector.iterator();
            if (paramString.hasNext())
            {
              localObject = (blac)paramString.next();
              if (localObject == null) {
                continue;
              }
              ((blac)localObject).a(jdField_a_of_type_OrgJsonJSONObject);
              continue;
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        QLog.d("VipComicConfigHelper", 2, "parse config json file failed.", paramString);
      }
      label118:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blaa
 * JD-Core Version:    0.7.0.1
 */