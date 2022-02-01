package com.tencent.luggage.wxa.bq;

import android.text.Editable;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;

class f$1
  implements Runnable
{
  f$1(f paramf, h paramh, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.a.d())
    {
      Object localObject = this.a.v();
      if (localObject == null) {
        return;
      }
      localObject = a.a(((u)localObject).getContentView());
      if (localObject != null)
      {
        WAGamePanelInputEditText localWAGamePanelInputEditText = ((a)localObject).getAttachedEditText();
        int i = localWAGamePanelInputEditText.getMaxLength();
        o.f("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[] { Integer.valueOf(i) });
        if (!af.c(this.b))
        {
          if (i > 0)
          {
            if (this.b.length() > i) {
              localObject = this.b.substring(0, i);
            } else {
              localObject = this.b;
            }
            localWAGamePanelInputEditText.setText((CharSequence)localObject);
          }
          else
          {
            localWAGamePanelInputEditText.setText(this.b);
          }
          localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
        }
        else
        {
          localWAGamePanelInputEditText.setText("");
        }
        this.a.a(this.c, this.d.b("ok"));
        return;
      }
      this.a.a(this.c, this.d.b("fail"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.f.1
 * JD-Core Version:    0.7.0.1
 */