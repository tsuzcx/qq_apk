import android.text.TextUtils;
import org.json.JSONObject;

public final class bekg
{
  public static JSONObject a(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":ok");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 14	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +19 -> 23
    //   7: aload_1
    //   8: astore_0
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: new 16	org/json/JSONObject
    //   16: dup
    //   17: invokespecial 20	org/json/JSONObject:<init>	()V
    //   20: astore_0
    //   21: aload_0
    //   22: areturn
    //   23: aload_1
    //   24: ifnonnull +89 -> 113
    //   27: new 16	org/json/JSONObject
    //   30: dup
    //   31: invokespecial 20	org/json/JSONObject:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_1
    //   37: new 24	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 43
    //   50: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: astore_3
    //   54: aload_2
    //   55: invokestatic 14	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +24 -> 82
    //   61: ldc 45
    //   63: astore_0
    //   64: aload_1
    //   65: ldc 22
    //   67: aload_3
    //   68: aload_0
    //   69: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokevirtual 39	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: goto +37 -> 116
    //   82: new 24	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   89: ldc 47
    //   91: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_2
    //   95: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: goto -38 -> 64
    //   105: astore_0
    //   106: goto +10 -> 116
    //   109: astore_0
    //   110: goto +6 -> 116
    //   113: goto -76 -> 37
    //   116: aload_1
    //   117: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString1	String
    //   0	118	1	paramJSONObject	JSONObject
    //   0	118	2	paramString2	String
    //   34	34	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	35	105	java/lang/Exception
    //   37	61	109	java/lang/Exception
    //   64	79	109	java/lang/Exception
    //   82	102	109	java/lang/Exception
  }
  
  public static JSONObject b(String paramString, JSONObject paramJSONObject)
  {
    return a(paramString, paramJSONObject, null);
  }
  
  public static JSONObject c(String paramString, JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = paramJSONObject;
      if (paramJSONObject == null) {
        paramString = new JSONObject();
      }
      return paramString;
    }
    if (paramJSONObject == null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramJSONObject = localJSONObject;
        label63:
        for (;;) {}
      }
      catch (Exception paramString)
      {
        try
        {
          paramJSONObject.put("errMsg", paramString + ":cancel cancel");
          for (;;)
          {
            return paramJSONObject;
            paramString = paramString;
          }
        }
        catch (Exception paramString)
        {
          break label63;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bekg
 * JD-Core Version:    0.7.0.1
 */