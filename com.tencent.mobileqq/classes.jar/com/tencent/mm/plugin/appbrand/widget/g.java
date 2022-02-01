package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextPaint;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.luggage.wxa.kd.f;
import com.tencent.luggage.wxa.mn.c.a;
import com.tencent.luggage.wxa.pz.a;

@SuppressLint({"AppCompatCustomView"})
public class g
  extends TextView
  implements f, c.a
{
  private boolean a;
  private a b;
  
  public g(Context paramContext)
  {
    super(paramContext);
    super.setIncludeFontPadding(false);
    super.setLineSpacing(0.0F, 1.0F);
    super.setSpannableFactory(new g.1(this));
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void setFakeBoldText(boolean paramBoolean)
  {
    getPaint().setFakeBoldText(paramBoolean);
  }
  
  public void setInterceptEvent(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setLineHeight(int paramInt)
  {
    if (this.b == null) {
      this.b = new a(paramInt, 17);
    }
    if (!this.b.a(paramInt)) {
      return;
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    TextView.BufferType localBufferType = paramBufferType;
    if (paramBufferType == TextView.BufferType.NORMAL) {
      localBufferType = TextView.BufferType.SPANNABLE;
    }
    super.setText(paramCharSequence, localBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g
 * JD-Core Version:    0.7.0.1
 */