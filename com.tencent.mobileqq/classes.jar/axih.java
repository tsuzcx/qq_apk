import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/JumpSchemeFactory;", "", "()V", "jumpSchemeMap", "", "", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "build", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class axih
{
  public static final axih a;
  private static final Map<Integer, axhx> a;
  
  static
  {
    jdField_a_of_type_Axih = new axih();
    jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(0), new axig()), TuplesKt.to(Integer.valueOf(-1), new axik()), TuplesKt.to(Integer.valueOf(4), new axid()), TuplesKt.to(Integer.valueOf(5), new axii()) });
  }
  
  @NotNull
  public final axhx a(@NotNull axib paramaxib)
  {
    Intrinsics.checkParameterIsNotNull(paramaxib, "pushComponent");
    if (paramaxib.jdField_a_of_type_Boolean) {
      paramaxib = (axhx)new axig();
    }
    axhx localaxhx;
    do
    {
      return paramaxib;
      localaxhx = (axhx)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramaxib.jdField_a_of_type_Int));
      paramaxib = localaxhx;
    } while (localaxhx != null);
    return (axhx)new axif();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axih
 * JD-Core Version:    0.7.0.1
 */