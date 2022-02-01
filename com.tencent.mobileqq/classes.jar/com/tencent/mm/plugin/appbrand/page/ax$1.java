package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import com.tencent.luggage.wxa.oi.e;
import com.tencent.luggage.wxa.pd.k;

class ax$1
  implements e
{
  ax$1(ax paramax, e parame) {}
  
  public void a()
  {
    this.a.a();
  }
  
  public void b()
  {
    this.a.b();
    if ((!TextUtils.isEmpty(ax.a(this.b))) && (this.b.K().d()))
    {
      ba localba = this.b.K();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("document.title=\"");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(ax.a(this.b));
      localStringBuilder2.append("(PAUSED)");
      localStringBuilder1.append(k.a(localStringBuilder2.toString()));
      localStringBuilder1.append("\"");
      localba.evaluateJavascript(localStringBuilder1.toString(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax.1
 * JD-Core Version:    0.7.0.1
 */