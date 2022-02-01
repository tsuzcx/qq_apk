package com.tencent.luggage.wxa.bq;

import android.text.Editable;
import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.pp.p;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ri.a.a;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class e
  extends com.tencent.luggage.wxa.jx.a<h>
{
  private static final int CTRL_INDEX = 1;
  private static final String NAME = "showKeyboard";
  private final c a = new c();
  private final a b = new a();
  private final b c = new b();
  
  private void a(h paramh, String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, com.tencent.luggage.wxa.pw.b paramb, int paramInt2)
  {
    if (paramh.d())
    {
      Object localObject = paramh.v();
      if (localObject == null) {
        return;
      }
      float f = com.tencent.luggage.wxa.qx.a.a(((u)localObject).getContext());
      localObject = com.tencent.luggage.game.widget.input.a.b(((u)localObject).getContentView());
      WAGamePanelInputEditText localWAGamePanelInputEditText = ((com.tencent.luggage.game.widget.input.a)localObject).getAttachedEditText();
      localWAGamePanelInputEditText.setSingleLine(paramBoolean1 ^ true);
      localWAGamePanelInputEditText.setMaxLength(paramInt1);
      p.a(localWAGamePanelInputEditText).b(paramInt1).a(false).a(a.a.a).a(new e.2(this, localWAGamePanelInputEditText, paramh));
      if (!af.c(paramString))
      {
        if (paramString.length() > paramInt1) {
          paramString = paramString.substring(0, paramInt1);
        }
        localWAGamePanelInputEditText.setText(paramString);
        localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
      }
      else
      {
        localWAGamePanelInputEditText.setText("");
      }
      localWAGamePanelInputEditText.addTextChangedListener(new e.3(this, paramh));
      localWAGamePanelInputEditText.setComposingDismissedListener(new e.4(this, localWAGamePanelInputEditText, paramh));
      ((com.tencent.luggage.game.widget.input.a)localObject).setOnConfirmClickListener(new e.5(this, localWAGamePanelInputEditText, paramh, paramBoolean2, (com.tencent.luggage.game.widget.input.a)localObject));
      ((com.tencent.luggage.game.widget.input.a)localObject).setOnVisibilityChangedListener(new e.6(this, localWAGamePanelInputEditText, paramh, (com.tencent.luggage.game.widget.input.a)localObject, f, paramInt2));
      if (!paramBoolean1) {
        localWAGamePanelInputEditText.setOnEditorActionListener(new e.7(this, localWAGamePanelInputEditText, paramh, paramBoolean2));
      }
      paramString = paramh.y().getOrientationHandler().a();
      ((com.tencent.luggage.game.widget.input.a)localObject).a(paramb, paramh.q().ah(), paramString);
    }
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("defaultValue");
    int i = paramJSONObject.optInt("maxLength", 140);
    if (i <= 0) {
      i = 2147483647;
    }
    boolean bool1 = paramJSONObject.optBoolean("multiple", false);
    boolean bool2 = paramJSONObject.optBoolean("confirmHold", false);
    paramJSONObject = com.tencent.luggage.wxa.pw.b.a(paramJSONObject.optString("confirmType"));
    o.d("MicroMsg.WAGameJsApiShowKeyboard", "defaultValue :%s,finalMaxLength(%d),multiple(%b),confirmHold(%b).", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    paramh.a(new e.1(this, paramh, str, i, bool1, bool2, paramJSONObject, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.e
 * JD-Core Version:    0.7.0.1
 */