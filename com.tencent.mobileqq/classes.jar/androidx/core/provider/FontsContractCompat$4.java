package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Handler;

class FontsContractCompat$4
  implements Runnable
{
  FontsContractCompat$4(Context paramContext, FontRequest paramFontRequest, Handler paramHandler, FontsContractCompat.FontRequestCallback paramFontRequestCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = FontsContractCompat.fetchFonts(this.val$appContext, null, this.val$request);
      int i;
      if (((FontsContractCompat.FontFamilyResult)localObject1).getStatusCode() != 0)
      {
        i = ((FontsContractCompat.FontFamilyResult)localObject1).getStatusCode();
        if (i != 1)
        {
          if (i != 2)
          {
            this.val$callerThreadHandler.post(new FontsContractCompat.4.4(this));
            return;
          }
          this.val$callerThreadHandler.post(new FontsContractCompat.4.3(this));
          return;
        }
        this.val$callerThreadHandler.post(new FontsContractCompat.4.2(this));
        return;
      }
      localObject1 = ((FontsContractCompat.FontFamilyResult)localObject1).getFonts();
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        int j = localObject1.length;
        i = 0;
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
        return;
      }
      this.val$callerThreadHandler.post(new FontsContractCompat.4.5(this));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      label244:
      break label244;
    }
    this.val$callerThreadHandler.post(new FontsContractCompat.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.4
 * JD-Core Version:    0.7.0.1
 */