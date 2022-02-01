import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/BrowserOpenBean;", "", "()V", "topBrowsers", "", "Lcom/tencent/mobileqq/browser/BrowserItem;", "blackListApps", "", "(Ljava/util/List;Ljava/util/List;)V", "getBlackListApps", "()Ljava/util/List;", "getTopBrowsers", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ardi
{
  @NotNull
  private final List<aqkg> a;
  @NotNull
  private final List<String> b;
  
  public ardi()
  {
    this((List)new ArrayList(), null, 2, null);
  }
  
  public ardi(@NotNull List<aqkg> paramList, @NotNull List<String> paramList1)
  {
    this.a = paramList;
    this.b = paramList1;
  }
  
  @NotNull
  public final List<aqkg> a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<String> b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ardi))
      {
        paramObject = (ardi)paramObject;
        if ((!Intrinsics.areEqual(this.a, paramObject.a)) || (!Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    List localList = this.a;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      localList = this.b;
      if (localList != null) {
        j = localList.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "BrowserOpenBean(topBrowsers=" + this.a + ", blackListApps=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ardi
 * JD-Core Version:    0.7.0.1
 */