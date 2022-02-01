package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(24)
class AppCompatDelegateImpl$ConfigurationImplApi24
{
  static void generateConfigDelta_locale(@NonNull Configuration paramConfiguration1, @NonNull Configuration paramConfiguration2, @NonNull Configuration paramConfiguration3)
  {
    paramConfiguration1 = paramConfiguration1.getLocales();
    LocaleList localLocaleList = paramConfiguration2.getLocales();
    if (!paramConfiguration1.equals(localLocaleList))
    {
      paramConfiguration3.setLocales(localLocaleList);
      paramConfiguration3.locale = paramConfiguration2.locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi24
 * JD-Core Version:    0.7.0.1
 */