import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveManager$ReceiveMethodHolder;", "", "obj", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/Object;Ljava/lang/reflect/Method;)V", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "getObj", "()Ljava/lang/Object;", "setObj", "(Ljava/lang/Object;)V", "callMethod", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbd
{
  @NotNull
  private Object jdField_a_of_type_JavaLangObject;
  @NotNull
  private Method jdField_a_of_type_JavaLangReflectMethod;
  
  public anbd(@NotNull Object paramObject, @NotNull Method paramMethod)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_JavaLangReflectMethod = paramMethod;
  }
  
  public final void a(@NotNull anbe paramanbe)
  {
    Intrinsics.checkParameterIsNotNull(paramanbe, "params");
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { paramanbe });
      return;
    }
    catch (IllegalAccessException paramanbe)
    {
      paramanbe.printStackTrace();
      return;
    }
    catch (InvocationTargetException paramanbe)
    {
      paramanbe.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbd
 * JD-Core Version:    0.7.0.1
 */