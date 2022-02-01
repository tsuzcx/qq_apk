import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/onlinestatus/view/WeatherView$initData$1", "Lcom/tencent/mobileqq/onlinestatus/weather/WeatherObserver;", "receiveReqWeather", "", "success", "", "bundle", "Landroid/os/Bundle;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class axzt
  extends ayaa
{
  public void a(boolean paramBoolean, @Nullable Bundle paramBundle)
  {
    super.a(paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("WeatherView", 2, new Object[] { "receiveReqWeather: called. ", "bundle: " + paramBundle, " success: " + paramBoolean });
    }
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzt
 * JD-Core Version:    0.7.0.1
 */