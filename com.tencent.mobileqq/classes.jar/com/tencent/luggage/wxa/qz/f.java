package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.File;

public class f
{
  public static Uri a(Context paramContext, i parami)
  {
    parami = k.c(parami.b(), false);
    if (parami == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(".external.fileprovider");
      return FileProvider.getUriForFile(paramContext, localStringBuilder.toString(), new File(parami));
    }
    return Uri.fromFile(new File(parami));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.f
 * JD-Core Version:    0.7.0.1
 */