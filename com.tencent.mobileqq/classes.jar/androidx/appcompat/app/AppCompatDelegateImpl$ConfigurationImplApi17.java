package androidx.appcompat.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
class AppCompatDelegateImpl$ConfigurationImplApi17
{
  static void generateConfigDelta_densityDpi(@NonNull Configuration paramConfiguration1, @NonNull Configuration paramConfiguration2, @NonNull Configuration paramConfiguration3)
  {
    if (paramConfiguration1.densityDpi != paramConfiguration2.densityDpi) {
      paramConfiguration3.densityDpi = paramConfiguration2.densityDpi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi17
 * JD-Core Version:    0.7.0.1
 */