import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvInterfaceBinder$Companion;", "", "()V", "app", "Lcooperation/vip/VasAdvAppInterface;", "getApp", "()Lcooperation/vip/VasAdvAppInterface;", "app$delegate", "Lkotlin/Lazy;", "gdt", "Lcooperation/vip/VasAdvGdtInterface;", "getGdt", "()Lcooperation/vip/VasAdvGdtInterface;", "gdt$delegate", "appInterface", "gdtInterface", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class bmmo
{
  private final bmkc b()
  {
    Lazy localLazy = bmmn.a();
    bmmo localbmmo = bmmn.a;
    return (bmkc)localLazy.getValue();
  }
  
  private final bmke b()
  {
    Lazy localLazy = bmmn.b();
    bmmo localbmmo = bmmn.a;
    return (bmke)localLazy.getValue();
  }
  
  @JvmStatic
  @NotNull
  public final bmkc a()
  {
    return ((bmmo)this).b();
  }
  
  @JvmStatic
  @NotNull
  public final bmke a()
  {
    return ((bmmo)this).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmo
 * JD-Core Version:    0.7.0.1
 */