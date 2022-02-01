import cooperation.vip.VasGdtService.listener.2;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "loader", "Lcom/tencent/gdtad/aditem/GdtAdLoader;", "kotlin.jvm.PlatformType", "onResponse"}, k=3, mv={1, 1, 16})
public final class bmks
  implements acag
{
  public bmks(VasGdtService.listener.2 param2) {}
  
  public final void onResponse(acaf paramacaf)
  {
    bmkq localbmkq = this.a.this$0.a();
    if (localbmkq != null)
    {
      if (paramacaf == null) {
        break label41;
      }
      paramacaf = paramacaf.a();
      if (paramacaf == null) {
        break label41;
      }
    }
    label41:
    for (paramacaf = paramacaf.a;; paramacaf = null)
    {
      localbmkq.a(paramacaf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmks
 * JD-Core Version:    0.7.0.1
 */