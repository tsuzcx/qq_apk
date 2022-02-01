package com.tencent.luggage.wxa.kt;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.TypedValue;
import com.tencent.luggage.wxa.hx.c;
import com.tencent.luggage.wxa.mn.c.a;

class a
  implements c.a
{
  private static final ThreadLocal<TextPaint> a = new a.1();
  private final TextPaint b;
  private final Resources c;
  private final com.tencent.luggage.wxa.hx.a d;
  private CharSequence e = "";
  private com.tencent.luggage.wxa.pz.a f;
  
  public a(Resources paramResources, int paramInt)
  {
    this.c = paramResources;
    paramResources = a.get();
    paramResources.getClass();
    this.b = ((TextPaint)paramResources);
    this.e = "";
    this.d = com.tencent.luggage.wxa.hx.a.a(this.e, this.b, paramInt);
  }
  
  private void b()
  {
    if (this.f == null)
    {
      this.d.a(this.e);
      return;
    }
    SpannableString localSpannableString = new SpannableString(this.e);
    localSpannableString.setSpan(this.f, 0, localSpannableString.length(), 18);
    this.d.a(localSpannableString);
  }
  
  public StaticLayout a()
  {
    return this.d.b().a();
  }
  
  public float getTextSize()
  {
    return this.b.getTextSize();
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    this.d.a(paramTruncateAt);
  }
  
  public void setFakeBoldText(boolean paramBoolean)
  {
    this.b.setFakeBoldText(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.d.b(paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    com.tencent.luggage.wxa.pz.a locala = this.f;
    if ((locala == null) || (locala.a(paramInt)))
    {
      this.f = new com.tencent.luggage.wxa.pz.a(paramInt, 16);
      b();
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.a(1);
      return;
    }
    this.d.a(2147483647);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!localObject.equals(this.e))
    {
      this.e = ((CharSequence)localObject);
      b();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.b.setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.b.setTextSize(TypedValue.applyDimension(paramInt, paramFloat, this.c.getDisplayMetrics()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.a
 * JD-Core Version:    0.7.0.1
 */