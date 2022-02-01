package com.tencent.luggage.wxa.at;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Parcelable;
import androidx.core.content.FileProvider;
import com.tencent.image_picker.imagepicker.helper.d;
import com.tencent.luggage.wxa.av.a;
import java.io.File;
import java.io.Serializable;
import java.util.Locale;

public class b
  implements Serializable
{
  private String a;
  
  public Intent a(Context paramContext, a parama)
  {
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    parama = com.tencent.image_picker.imagepicker.helper.c.a(parama.p());
    if (parama != null)
    {
      Object localObject = paramContext.getApplicationContext();
      localObject = FileProvider.getUriForFile((Context)localObject, String.format(Locale.ENGLISH, "%s%s", new Object[] { ((Context)localObject).getPackageName(), ".wmpf.imagepicker.provider" }), parama);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(parama.getAbsolutePath());
      this.a = localStringBuilder.toString();
      localIntent.putExtra("output", (Parcelable)localObject);
      com.tencent.image_picker.imagepicker.helper.c.a(paramContext, localIntent, (Uri)localObject);
      return localIntent;
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
    }
  }
  
  public void a(Context paramContext, Intent paramIntent, c paramc)
  {
    if (paramc != null)
    {
      paramIntent = this.a;
      if (paramIntent == null)
      {
        d.a().c("currentImagePath null. This happen if you haven't call #getCameraIntent() or the activity is being recreated");
        paramc.a(null);
        return;
      }
      Uri localUri = Uri.parse(paramIntent);
      if (localUri != null)
      {
        paramIntent = paramContext.getApplicationContext();
        String str = localUri.getPath();
        paramContext = new b.1(this, paramc, paramContext, localUri);
        MediaScannerConnection.scanFile(paramIntent, new String[] { str }, null, paramContext);
      }
      return;
    }
    throw new IllegalStateException("OnImageReadyListener must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.at.b
 * JD-Core Version:    0.7.0.1
 */