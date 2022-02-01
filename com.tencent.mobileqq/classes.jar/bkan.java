import android.content.Context;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import org.json.JSONObject;

public class bkan
{
  public static int a(int paramInt)
  {
    if (paramInt == 6) {
      return 4;
    }
    if (paramInt == 4) {
      return 2;
    }
    if (paramInt == 5) {
      return 3;
    }
    if ((paramInt == 7) || (paramInt == 14)) {
      return -2;
    }
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 9) {
      return 6;
    }
    if (paramInt == 11) {
      return 9;
    }
    if (paramInt == 12) {
      return 10;
    }
    if ((paramInt == 2) || (paramInt == 13)) {
      return 20;
    }
    if (paramInt == 10) {
      return 13;
    }
    return 0;
  }
  
  public static int a(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 9) {
      paramInt = 6;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt == 6)
      {
        i = paramInt;
        if (!bhmi.a(paramString2)) {
          i = 0;
        }
      }
      return i;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return bjjo.a().a().getString(2131694130);
    case 0: 
      return "";
    case 1: 
      return bjjo.a().a().getString(2131694135);
    case 2: 
      return bjjo.a().a().getString(2131694139);
    case 3: 
      return bjjo.a().a().getString(2131694137);
    case 4: 
      return bjjo.a().a().getString(2131694133);
    case 5: 
      return bjjo.a().a().getString(2131694130);
    }
    return bjjo.a().a().getString(2131694130);
  }
  
  public static JSONObject a(WadlResult paramWadlResult)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramWadlResult != null) {}
    try
    {
      if (paramWadlResult.a != null)
      {
        WadlParams localWadlParams = paramWadlResult.a;
        localJSONObject.put("appid", localWadlParams.jdField_a_of_type_JavaLangString);
        localJSONObject.put("state", a(paramWadlResult.b));
        localJSONObject.put("pro", paramWadlResult.d);
        localJSONObject.put("packagename", localWadlParams.f);
        localJSONObject.put("ismyapp", 0);
        localJSONObject.put("download_from", 0);
        localJSONObject.put("realDownloadType", 0);
        localJSONObject.put("via", localWadlParams.l);
        localJSONObject.put("writecodestate", 0);
        localJSONObject.put("extraInfo", localWadlParams.o);
        localJSONObject.put("isAutoInstallBySDK", localWadlParams.a(1));
        localJSONObject.put("isRes", localWadlParams.jdField_a_of_type_Boolean);
        int i = b(paramWadlResult.c);
        localJSONObject.put("errorCode", i);
        localJSONObject.put("errorMsg", a(i));
      }
      return localJSONObject;
    }
    catch (Exception paramWadlResult) {}
    return localJSONObject;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 6;
    case 0: 
      return 0;
    case -71: 
    case -30: 
    case -26: 
    case -25: 
    case -24: 
    case -23: 
    case -16: 
    case -15: 
    case -1: 
      return 1;
    case -51: 
    case -11: 
      return 2;
    case -40: 
    case -12: 
      return 3;
    case 999: 
      return 7;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkan
 * JD-Core Version:    0.7.0.1
 */