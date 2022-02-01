package com.tencent.luggage.wxa.pf;

import android.text.Editable;
import android.text.Html.TagHandler;
import org.xml.sax.XMLReader;

public class c
  implements Html.TagHandler
{
  d.a a;
  private boolean b;
  
  public c(d.a parama, boolean paramBoolean)
  {
    this.a = parama;
    this.b = paramBoolean;
  }
  
  private <T> T a(Editable paramEditable, Class<T> paramClass)
  {
    paramClass = paramEditable.getSpans(0, paramEditable.length(), paramClass);
    if (paramClass.length == 0) {
      return null;
    }
    int i = paramClass.length;
    while (i > 0)
    {
      int j = i - 1;
      if (paramEditable.getSpanFlags(paramClass[j]) == 17) {
        return paramClass[j];
      }
      i -= 1;
    }
    return null;
  }
  
  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    if ("a".equalsIgnoreCase(paramString))
    {
      if (paramBoolean)
      {
        i = paramEditable.length();
        paramEditable.setSpan(new a("", this.a, this.b), i, i, 17);
        return;
      }
      int i = paramEditable.length();
      paramString = (a)a(paramEditable, a.class);
      int j = paramEditable.getSpanStart(paramString);
      paramXMLReader = paramEditable.subSequence(j, i).toString();
      paramEditable.removeSpan(paramString);
      if (j != i) {
        paramEditable.setSpan(new a(paramXMLReader, this.a, this.b), j, i, 33);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pf.c
 * JD-Core Version:    0.7.0.1
 */