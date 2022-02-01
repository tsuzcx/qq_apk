import android.os.Bundle;
import kotlin.Metadata;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "Lmqq/observer/BusinessObserver;", "()V", "onGetConstellationTrend", "", "success", "", "bundle", "Landroid/os/Bundle;", "onReceive", "type", "", "isSuccess", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class azew
  implements BusinessObserver
{
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azew
 * JD-Core Version:    0.7.0.1
 */