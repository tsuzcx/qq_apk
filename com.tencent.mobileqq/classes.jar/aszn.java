import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import org.json.JSONException;
import org.json.JSONObject;

public class aszn
{
  private static String jdField_a_of_type_JavaLangString;
  private static int[] jdField_a_of_type_ArrayOfInt;
  
  public static int a(MessageForStructing paramMessageForStructing)
  {
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof axwz))
      {
        paramMessageForStructing = (axwz)paramMessageForStructing;
        if (paramMessageForStructing.a.size() > 0)
        {
          paramMessageForStructing = paramMessageForStructing.a.getString("fCount");
          if (!TextUtils.isEmpty(paramMessageForStructing)) {
            return Integer.valueOf(paramMessageForStructing).intValue();
          }
        }
      }
    }
    return 0;
  }
  
  public static String a(MessageForStructing paramMessageForStructing)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMessageForStructing = (AbsShareMsg)paramMessageForStructing.structingMsg;
    if (paramMessageForStructing.getItemCount() > 0)
    {
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if ((paramMessageForStructing instanceof axwz))
      {
        Object localObject = (axwz)paramMessageForStructing;
        if (((axwz)localObject).a.size() > 0)
        {
          paramMessageForStructing = ((axwz)localObject).a.getString("sNick");
          String str = ((axwz)localObject).a.getString("rNick");
          localObject = ((axwz)localObject).a.getString("cMean");
          localStringBuilder.append(paramMessageForStructing).append("送给").append(str).append((String)localObject);
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString)
  {
    try
    {
      jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("icon");
      return;
    }
    catch (JSONException paramString) {}
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (!(paramMessageRecord instanceof ChatMessage)) {
      return false;
    }
    paramMessageRecord = (ChatMessage)paramMessageRecord;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && ((paramMessageRecord.structingMsg instanceof AbsShareMsg)) && (paramMessageRecord.structingMsg.mMsgServiceID == 52))
      {
        paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
        if ((paramMessageRecord.getItemCount() <= 0) || (!(paramMessageRecord.getItemByIndex(0) instanceof axwz))) {}
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static int[] a(Context paramContext)
  {
    if (jdField_a_of_type_ArrayOfInt != null) {
      return jdField_a_of_type_ArrayOfInt;
    }
    paramContext = bbjn.k(paramContext);
    if (paramContext != null) {
      b(paramContext);
    }
    return jdField_a_of_type_ArrayOfInt;
  }
  
  /* Error */
  public static void b(String paramString)
  {
    // Byte code:
    //   0: new 84	org/json/JSONObject
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 86	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: ldc 118
    //   10: invokevirtual 122	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   13: astore_0
    //   14: aload_0
    //   15: ifnull +47 -> 62
    //   18: aload_0
    //   19: invokevirtual 127	org/json/JSONArray:length	()I
    //   22: newarray int
    //   24: putstatic 105	aszn:jdField_a_of_type_ArrayOfInt	[I
    //   27: iconst_0
    //   28: istore_1
    //   29: iload_1
    //   30: aload_0
    //   31: invokevirtual 127	org/json/JSONArray:length	()I
    //   34: if_icmpge +28 -> 62
    //   37: aload_0
    //   38: iload_1
    //   39: invokevirtual 130	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: invokestatic 136	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   47: istore_2
    //   48: getstatic 105	aszn:jdField_a_of_type_ArrayOfInt	[I
    //   51: iload_1
    //   52: iload_2
    //   53: iastore
    //   54: iload_1
    //   55: iconst_1
    //   56: iadd
    //   57: istore_1
    //   58: goto -29 -> 29
    //   61: astore_0
    //   62: return
    //   63: astore_3
    //   64: goto -10 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramString	String
    //   28	30	1	i	int
    //   47	6	2	j	int
    //   42	2	3	str	String
    //   63	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	61	org/json/JSONException
    //   18	27	61	org/json/JSONException
    //   29	43	61	org/json/JSONException
    //   43	54	61	org/json/JSONException
    //   43	54	63	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aszn
 * JD-Core Version:    0.7.0.1
 */