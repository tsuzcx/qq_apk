import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.lang.reflect.ParameterizedType;

final class aopr
  implements ExclusionStrategy
{
  public boolean shouldSkipClass(Class<?> paramClass)
  {
    return false;
  }
  
  public boolean shouldSkipField(FieldAttributes paramFieldAttributes)
  {
    if ((paramFieldAttributes.hasModifier(128)) || (paramFieldAttributes.hasModifier(8)) || (paramFieldAttributes.hasModifier(64))) {
      return true;
    }
    if ((aopp.a(paramFieldAttributes.getDeclaredClass())) || (aopp.a(paramFieldAttributes.getDeclaredClass().getComponentType())) || (((paramFieldAttributes.getDeclaredType() instanceof ParameterizedType)) && (aopp.a(((ParameterizedType)paramFieldAttributes.getDeclaredType()).getActualTypeArguments()[0])))) {
      return false;
    }
    return paramFieldAttributes.getAnnotation(aoos.class) == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopr
 * JD-Core Version:    0.7.0.1
 */