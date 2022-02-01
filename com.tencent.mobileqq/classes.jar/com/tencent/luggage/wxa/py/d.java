package com.tencent.luggage.wxa.py;

import android.text.Spannable;
import android.text.Spannable.Factory;
import com.tencent.luggage.wxa.pz.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/prompt/FixedLineHeightSpannableFactory;", "Landroid/text/Spannable$Factory;", "height", "", "(I)V", "getHeight", "()I", "newSpannable", "Landroid/text/Spannable;", "source", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
final class d
  extends Spannable.Factory
{
  private final int a;
  
  public d(int paramInt)
  {
    this.a = paramInt;
  }
  
  @Nullable
  public Spannable newSpannable(@Nullable CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if (paramCharSequence != null)
    {
      paramCharSequence.setSpan(new a(this.a, 17), 0, paramCharSequence.length(), 18);
      return paramCharSequence;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.py.d
 * JD-Core Version:    0.7.0.1
 */