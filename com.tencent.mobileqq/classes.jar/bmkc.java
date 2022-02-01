import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/VasAdvAppInterface;", "", "account", "", "context", "Landroid/content/Context;", "execute", "", "runnable", "Ljava/lang/Runnable;", "sendCmd", "cmd", "", "cmdKey", "reqBytes", "", "callback", "Lcooperation/vip/VasAdvCallback;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface bmkc
{
  public abstract long a();
  
  @NotNull
  public abstract Context a();
  
  public abstract void a(@NotNull Runnable paramRunnable);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull byte[] paramArrayOfByte, @NotNull bmkd parambmkd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkc
 * JD-Core Version:    0.7.0.1
 */