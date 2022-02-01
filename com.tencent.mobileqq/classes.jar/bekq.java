import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.util.Pair;
import java.lang.reflect.Type;

final class bekq
  implements JsonDeserializer<beko>
{
  public beko a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
  {
    paramType = paramJsonElement.getAsJsonObject();
    paramJsonElement = new beko();
    paramJsonElement.jdField_a_of_type_Int = paramType.get("nextNum").getAsInt();
    paramType = paramType.get("numToAttrib").getAsJsonObject();
    int i = 0;
    while (i < paramJsonElement.jdField_a_of_type_Int)
    {
      Object localObject = paramType.get(i + "").getAsJsonArray();
      paramJsonDeserializationContext = ((JsonArray)localObject).get(0).getAsString();
      localObject = ((JsonArray)localObject).get(1).getAsString();
      paramJsonElement.jdField_a_of_type_AndroidSupportV4UtilSparseArrayCompat.put(i, new Pair(paramJsonDeserializationContext, localObject));
      paramJsonElement.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(beko.a(paramJsonDeserializationContext, (String)localObject), Integer.valueOf(i));
      i += 1;
    }
    return paramJsonElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekq
 * JD-Core Version:    0.7.0.1
 */