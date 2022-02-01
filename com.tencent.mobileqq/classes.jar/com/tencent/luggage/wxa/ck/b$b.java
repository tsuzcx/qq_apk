package com.tencent.luggage.wxa.ck;

import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.mn.a;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultCode", "", "<anonymous parameter 1>", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"}, k=3, mv={1, 1, 16})
final class b$b
  implements LuggageActivityHelper.ActivityResultCallback
{
  b$b(String[] paramArrayOfString) {}
  
  public final void onResult(int paramInt, Intent paramIntent)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("previewImage ok: ");
    paramIntent.append(paramInt);
    o.d("Luggage.JsApiPreviewImage", paramIntent.toString());
    a.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ck.b.b
 * JD-Core Version:    0.7.0.1
 */