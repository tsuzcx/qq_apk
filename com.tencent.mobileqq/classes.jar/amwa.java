import com.tencent.mobileqq.apollo.player.action.CMSAction;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it1", "Lcom/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$ActionItem;", "it2", "compare"}, k=3, mv={1, 1, 16})
final class amwa<T>
  implements Comparator<amvz>
{
  public static final amwa a = new amwa();
  
  public final int a(@NotNull amvz paramamvz1, @NotNull amvz paramamvz2)
  {
    Intrinsics.checkParameterIsNotNull(paramamvz1, "it1");
    Intrinsics.checkParameterIsNotNull(paramamvz2, "it2");
    if (paramamvz1.a().a() > paramamvz2.a().a()) {
      return 1;
    }
    if (paramamvz1.a().a() < paramamvz2.a().a()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwa
 * JD-Core Version:    0.7.0.1
 */