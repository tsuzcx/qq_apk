import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import java.lang.reflect.ParameterizedType;

final class anmy
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
    if ((anmw.a(paramFieldAttributes.getDeclaredClass())) || (anmw.a(paramFieldAttributes.getDeclaredClass().getComponentType())) || (((paramFieldAttributes.getDeclaredType() instanceof ParameterizedType)) && (anmw.a(((ParameterizedType)paramFieldAttributes.getDeclaredType()).getActualTypeArguments()[0])))) {
      return false;
    }
    return paramFieldAttributes.getAnnotation(anlz.class) == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmy
 * JD-Core Version:    0.7.0.1
 */