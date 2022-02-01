package androidx.appcompat.app;

import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(26)
class AppCompatDelegateImpl$ConfigurationImplApi26
{
  static void generateConfigDelta_colorMode(@NonNull Configuration paramConfiguration1, @NonNull Configuration paramConfiguration2, @NonNull Configuration paramConfiguration3)
  {
    if ((paramConfiguration1.colorMode & 0x3) != (paramConfiguration2.colorMode & 0x3)) {
      paramConfiguration3.colorMode |= paramConfiguration2.colorMode & 0x3;
    }
    if ((paramConfiguration1.colorMode & 0xC) != (paramConfiguration2.colorMode & 0xC)) {
      paramConfiguration3.colorMode |= paramConfiguration2.colorMode & 0xC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ConfigurationImplApi26
 * JD-Core Version:    0.7.0.1
 */