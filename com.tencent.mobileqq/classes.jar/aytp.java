import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/ConstellationView$initData$1", "Lcom/tencent/mobileqq/onlinestatus/constellation/StatusExtInfoObserver;", "onGetConstellationTrend", "", "success", "", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class aytp
  extends aysj
{
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ConstellationView", 2, new Object[] { "onGetConstellationTrend: called. ", "bundle: " + paramBundle });
    }
    aytj localaytj = this.a;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("key_today_constellation_trend");
      if (paramBundle == null) {}
    }
    for (;;)
    {
      aytj.a(localaytj, paramBundle);
      this.a.a();
      return;
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytp
 * JD-Core Version:    0.7.0.1
 */