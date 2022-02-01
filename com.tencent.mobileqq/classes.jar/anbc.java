import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveManager;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mMethodMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveManager$ReceiveMethodHolder;", "Lkotlin/collections/HashMap;", "getRequestReceive", "cmd", "handleApolloRoleAndDress", "", "params", "Lcom/tencent/mobileqq/apollo/request/ApolloRequestReceiveParams;", "handleApolloSetModel", "handleChangeApolloStatus", "loadMethods", "obj", "cls", "Ljava/lang/Class;", "ReceiveMethodHolder", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbc
{
  public static final anbc a;
  @NotNull
  private static final String jdField_a_of_type_JavaLangString = "ApolloRequestReceiveManager";
  private static final HashMap<String, anbd> jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    anbc localanbc = new anbc();
    jdField_a_of_type_Anbc = localanbc;
    jdField_a_of_type_JavaLangString = "ApolloRequestReceiveManager";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    localanbc.a(localanbc, anbc.class);
  }
  
  private final void a(Object paramObject, Class<?> paramClass)
  {
    paramClass = paramClass.getMethods();
    int j = paramClass.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = paramClass[i];
      Object localObject2;
      if (((Method)localObject1).isAnnotationPresent(anbf.class))
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "method");
        ((Method)localObject1).setAccessible(true);
        localObject2 = ((Method)localObject1).getAnnotation(anbf.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "method.getAnnotation<Apo…questReceive::class.java)");
        localObject2 = (anbf)localObject2;
        if (!jdField_a_of_type_JavaUtilHashMap.containsKey(((anbf)localObject2).a())) {
          break label91;
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label91:
        localObject1 = new anbd(paramObject, (Method)localObject1);
        ((Map)jdField_a_of_type_JavaUtilHashMap).put(((anbf)localObject2).a(), localObject1);
      }
    }
  }
  
  @Nullable
  public final anbd a(@Nullable String paramString)
  {
    return (anbd)((Map)jdField_a_of_type_JavaUtilHashMap).get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbc
 * JD-Core Version:    0.7.0.1
 */