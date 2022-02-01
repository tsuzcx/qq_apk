import android.util.Base64;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.lang.reflect.Type;

public class anmu<T extends AbsStructMsg>
  implements JsonDeserializer<T>, JsonSerializer<T>
{
  public JsonElement a(T paramT, Type paramType, JsonSerializationContext paramJsonSerializationContext)
  {
    return new JsonPrimitive(Base64.encodeToString(paramT.getBytes(), 3));
  }
  
  public T a(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
  {
    return bchh.a(Base64.decode(paramJsonElement.getAsString(), 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmu
 * JD-Core Version:    0.7.0.1
 */