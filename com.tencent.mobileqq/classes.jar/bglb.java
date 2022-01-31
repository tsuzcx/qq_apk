import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bglb
{
  public static int a;
  private static String a;
  public static int b = 2;
  public byte[] a;
  public int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = "NativeBuffer";
    jdField_a_of_type_Int = 1;
  }
  
  public static bglb a(bgho parambgho, JSONObject paramJSONObject, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      if (paramString != null) {
        break label22;
      }
      localObject1 = localObject2;
    }
    label22:
    int i;
    do
    {
      String str2;
      String str1;
      do
      {
        do
        {
          do
          {
            do
            {
              return localObject1;
              paramJSONObject = paramJSONObject.optJSONArray("__nativeBuffers__");
              localObject1 = localObject2;
            } while (paramJSONObject == null);
            localObject1 = localObject2;
          } while (paramJSONObject.length() == 0);
          paramJSONObject = paramJSONObject.optJSONObject(0);
          localObject1 = localObject2;
        } while (paramJSONObject == null);
        str2 = paramJSONObject.optString("key");
        str1 = paramJSONObject.optString("base64");
        i = paramJSONObject.optInt("id", -1);
        localObject1 = localObject2;
      } while (!paramString.equals(str2));
      paramJSONObject = new bglb();
      if (!TextUtils.isEmpty(str1))
      {
        paramJSONObject.jdField_a_of_type_ArrayOfByte = Base64.decode(str1, 2);
        paramJSONObject.c = b;
        return paramJSONObject;
      }
      localObject1 = paramJSONObject;
    } while (i == -1);
    paramJSONObject.jdField_a_of_type_ArrayOfByte = parambgho.a(i);
    paramJSONObject.c = jdField_a_of_type_Int;
    return paramJSONObject;
  }
  
  public static void a(bgho parambgho, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramString == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        JSONArray localJSONArray = new JSONArray();
        localJSONObject = new JSONObject();
        localJSONObject.put("key", paramString);
        if (paramInt3 == b)
        {
          localJSONObject.put("base64", Base64.encodeToString(paramArrayOfByte, paramInt1, paramInt2, 2));
          localJSONArray.put(localJSONObject);
          paramJSONObject.put("__nativeBuffers__", localJSONArray);
          return;
        }
      }
      catch (JSONException parambgho)
      {
        QMLog.e("[minigame]", "packNativeBuffer err :", parambgho);
        return;
      }
      if (paramInt3 == jdField_a_of_type_Int) {
        localJSONObject.put("id", parambgho.a(paramArrayOfByte, paramInt1, paramInt2));
      }
    }
  }
  
  public static void a(bgho parambgho, byte[] paramArrayOfByte, int paramInt, String paramString, JSONObject paramJSONObject)
  {
    a(parambgho, paramArrayOfByte, 0, paramArrayOfByte.length, paramInt, paramString, paramJSONObject);
  }
  
  public static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    return paramJSONObject.has("__nativeBuffers__");
  }
  
  public static byte[] a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      paramJSONArray = paramJSONArray.optJSONObject(0);
      if (paramJSONArray != null)
      {
        paramJSONArray = paramJSONArray.optString("base64");
        if (!TextUtils.isEmpty(paramJSONArray)) {
          return Base64.decode(paramJSONArray, 0);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bglb
 * JD-Core Version:    0.7.0.1
 */