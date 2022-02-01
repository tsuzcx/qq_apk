import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/JumpSchemeFactory;", "", "()V", "jumpSchemeMap", "", "", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "build", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aycg
{
  public static final aycg a;
  private static final Map<Integer, aybw> a;
  
  static
  {
    jdField_a_of_type_Aycg = new aycg();
    jdField_a_of_type_JavaUtilMap = MapsKt.mapOf(new Pair[] { TuplesKt.to(Integer.valueOf(0), new aycf()), TuplesKt.to(Integer.valueOf(-1), new aycj()), TuplesKt.to(Integer.valueOf(4), new aycc()), TuplesKt.to(Integer.valueOf(5), new aych()) });
  }
  
  @NotNull
  public final aybw a(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    if (paramayca.jdField_a_of_type_Boolean) {
      paramayca = (aybw)new aycf();
    }
    aybw localaybw;
    do
    {
      return paramayca;
      localaybw = (aybw)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramayca.jdField_a_of_type_Int));
      paramayca = localaybw;
    } while (localaybw != null);
    return (aybw)new ayce();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycg
 * JD-Core Version:    0.7.0.1
 */