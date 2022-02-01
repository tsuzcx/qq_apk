package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Handler;

final class FontsContractCompat$4
  implements Runnable
{
  FontsContractCompat$4(Context paramContext, FontRequest paramFontRequest, Handler paramHandler, FontsContractCompat.FontRequestCallback paramFontRequestCallback) {}
  
  public void run()
  {
    try
    {
      FontsContractCompat.FontFamilyResult localFontFamilyResult = FontsContractCompat.fetchFonts(this.val$appContext, null, this.val$request);
      if (localFontFamilyResult.getStatusCode() == 0) {
        break label117;
      }
      switch (localFontFamilyResult.getStatusCode())
      {
      default: 
        this.val$callerThreadHandler.post(new FontsContractCompat.4.4(this));
        return;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this.val$callerThreadHandler.post(new FontsContractCompat.4.1(this));
      return;
    }
    this.val$callerThreadHandler.post(new FontsContractCompat.4.2(this));
    return;
    this.val$callerThreadHandler.post(new FontsContractCompat.4.3(this));
    return;
    label117:
    Object localObject1 = localNameNotFoundException.getFonts();
    if ((localObject1 == null) || (localObject1.length == 0))
    {
      this.val$callerThreadHandler.post(new FontsContractCompat.4.5(this));
      return;
    }
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (localObject2.getResultCode() != 0)
      {
        i = localObject2.getResultCode();
        if (i < 0)
        {
          this.val$callerThreadHandler.post(new FontsContractCompat.4.6(this));
          return;
        }
        this.val$callerThreadHandler.post(new FontsContractCompat.4.7(this, i));
        return;
      }
      i += 1;
    }
    localObject1 = FontsContractCompat.buildTypeface(this.val$appContext, null, (FontsContractCompat.FontInfo[])localObject1);
    if (localObject1 == null)
    {
      this.val$callerThreadHandler.post(new FontsContractCompat.4.8(this));
      return;
    }
    this.val$callerThreadHandler.post(new FontsContractCompat.4.9(this, (Typeface)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.4
 * JD-Core Version:    0.7.0.1
 */