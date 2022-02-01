import android.text.TextUtils;
import com.tencent.mobileqq.activity.weather.webpage.WeatherArkNotify.viewModel.2;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkNotify;", "Lcom/tencent/mobileqq/ark/API/ArkAppNotifyCenter$INotifyReg;", "fragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "(Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;)V", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "notify", "", "appName", "", "eventName", "params", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ameo
  implements apsy
{
  public static final amep a;
  private final Lazy a;
  
  static
  {
    jdField_a_of_type_Amep = new amep(null);
  }
  
  public ameo(@NotNull LifeCycleFragment paramLifeCycleFragment)
  {
    this.jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new WeatherArkNotify.viewModel.2(paramLifeCycleFragment));
  }
  
  private final amex a()
  {
    return (amex)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  public boolean notify(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeatherArkNotify", 2, "notify --->  appName: " + paramString1 + ", eventName: " + paramString2 + ", params: " + paramString3);
    }
    try
    {
      if (!TextUtils.equals((CharSequence)paramString1, (CharSequence)"com.tencent.weather_v2")) {
        break label150;
      }
      if (paramString2 == null) {
        return true;
      }
      switch (paramString2.hashCode())
      {
      case 6648771: 
        if (!paramString2.equals("notify_client_msg")) {
          break label150;
        }
        a().c(paramString3);
        return true;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.d("WeatherArkNotify", 1, paramString1, new Object[0]);
      return true;
    }
    if (paramString2.equals("notify_web_msg")) {
      a().b(paramString3);
    }
    label150:
    return true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ameo
 * JD-Core Version:    0.7.0.1
 */