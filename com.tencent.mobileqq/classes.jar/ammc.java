import android.arch.lifecycle.MutableLiveData;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.QQPermissionCallback;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel$requestAdCode$1", "Lmqq/app/QQPermissionCallback;", "deny", "", "i", "", "strings", "", "", "ints", "", "(I[Ljava/lang/String;[I)V", "grant", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ammc
  implements QQPermissionCallback
{
  ammc(String paramString) {}
  
  public void deny(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    QLog.i("WeatherWebArkViewModel", 1, "requestAdCode deny");
    if (TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_Amma.a().postValue(new ammk(3, null, null, null, 0, 0, 62, null));
    }
  }
  
  public void grant(int paramInt, @NotNull String[] paramArrayOfString, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "strings");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "ints");
    QLog.i("WeatherWebArkViewModel", 1, "requestAdCode grant");
    this.jdField_a_of_type_Amma.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammc
 * JD-Core Version:    0.7.0.1
 */