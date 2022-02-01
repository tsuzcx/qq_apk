import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/JumpSchemeFactory;", "", "()V", "jumpSchemeMap", "", "", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "build", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayom
{
  public static final ayom a;
  private static final Map<Integer, ayoc> a;
  
  static
  {
    jdField_a_of_type_Ayom = new ayom();
    jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(0), new ayol()), TuplesKt.to(Integer.valueOf(-1), new ayop()), TuplesKt.to(Integer.valueOf(4), new ayoi()), TuplesKt.to(Integer.valueOf(5), new ayon()) });
  }
  
  @NotNull
  public final ayoc a(@NotNull ayog paramayog)
  {
    Intrinsics.checkParameterIsNotNull(paramayog, "pushComponent");
    if (paramayog.jdField_a_of_type_Boolean) {
      paramayog = (ayoc)new ayol();
    }
    ayoc localayoc;
    do
    {
      return paramayog;
      localayoc = (ayoc)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramayog.jdField_a_of_type_Int));
      paramayog = localayoc;
    } while (localayoc != null);
    return (ayoc)new ayok();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayom
 * JD-Core Version:    0.7.0.1
 */