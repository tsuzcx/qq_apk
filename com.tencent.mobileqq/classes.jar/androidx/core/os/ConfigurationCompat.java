package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import java.util.Locale;

public final class ConfigurationCompat
{
  @NonNull
  public static LocaleListCompat getLocales(@NonNull Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return LocaleListCompat.wrap(paramConfiguration.getLocales());
    }
    return LocaleListCompat.create(new Locale[] { paramConfiguration.locale });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.os.ConfigurationCompat
 * JD-Core Version:    0.7.0.1
 */