package com.tencent.luggage.wxa.at;

import android.content.Context;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import com.tencent.image_picker.imagepicker.helper.d;

class b$1
  implements MediaScannerConnection.OnScanCompletedListener
{
  b$1(b paramb, c paramc, Context paramContext, Uri paramUri) {}
  
  public void onScanCompleted(String paramString, Uri paramUri)
  {
    d locald = d.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" was scanned successfully: ");
    localStringBuilder.append(paramUri);
    locald.a(localStringBuilder.toString());
    paramUri = paramString;
    if (paramString == null)
    {
      d.a().a("This should not happen, go back to Immediate implemenation");
      paramUri = b.a(this.d);
    }
    this.a.a(com.tencent.luggage.wxa.az.c.a(paramUri));
    com.tencent.image_picker.imagepicker.helper.c.a(this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.at.b.1
 * JD-Core Version:    0.7.0.1
 */