package com.tencent.luggage.wxa.cs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.luggage.wxa.iu.b;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "com/tencent/luggage/jsapi/version/JsApiUpdateApp$invoke$1$1$1$2", "com/tencent/luggage/jsapi/version/JsApiUpdateApp$invoke$1$1$$special$$inlined$also$lambda$2"}, k=3, mv={1, 1, 16})
final class a$b$2
  implements DialogInterface.OnClickListener
{
  a$b$2(a.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.c;
    if (paramDialogInterface != null) {
      paramDialogInterface.a(this.a.d, this.a.b.b("fail user canceled updateApp"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cs.a.b.2
 * JD-Core Version:    0.7.0.1
 */