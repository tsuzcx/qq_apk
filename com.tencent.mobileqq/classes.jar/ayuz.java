import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/JumpSchemeFactory;", "", "()V", "jumpSchemeMap", "", "", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "build", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ayuz
{
  public static final ayuz a;
  private static final Map<Integer, ayup> a;
  
  static
  {
    jdField_a_of_type_Ayuz = new ayuz();
    jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(0), new ayuy()), TuplesKt.to(Integer.valueOf(-1), new ayvc()), TuplesKt.to(Integer.valueOf(4), new ayuv()), TuplesKt.to(Integer.valueOf(5), new ayva()) });
  }
  
  @NotNull
  public final ayup a(@NotNull ayut paramayut)
  {
    Intrinsics.checkParameterIsNotNull(paramayut, "pushComponent");
    if (paramayut.jdField_a_of_type_Boolean) {
      paramayut = (ayup)new ayuy();
    }
    ayup localayup;
    do
    {
      return paramayut;
      localayup = (ayup)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramayut.jdField_a_of_type_Int));
      paramayut = localayup;
    } while (localayup != null);
    return (ayup)new ayux();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuz
 * JD-Core Version:    0.7.0.1
 */