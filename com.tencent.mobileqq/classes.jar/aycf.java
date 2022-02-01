import android.app.PendingIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/business/FallbackJumpScheme;", "Lcom/tencent/mobileqq/notification/modularize/BaseJumpScheme;", "()V", "customJumpIntent", "Landroid/app/PendingIntent;", "pushComponent", "Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "needCustomJump", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aycf
  extends aybw
{
  @NotNull
  protected PendingIntent a(@NotNull ayca paramayca)
  {
    Intrinsics.checkParameterIsNotNull(paramayca, "pushComponent");
    return c(paramayca);
  }
  
  protected boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycf
 * JD-Core Version:    0.7.0.1
 */