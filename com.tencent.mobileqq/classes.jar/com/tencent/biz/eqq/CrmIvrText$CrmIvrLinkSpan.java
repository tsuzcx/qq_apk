package com.tencent.biz.eqq;

import android.view.View;
import com.tencent.mobileqq.text.style.LinkSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrmIvrText$CrmIvrLinkSpan
  extends LinkSpan
{
  public CrmIvrText$CrmIvrLinkSpan(CrmIvrText paramCrmIvrText, String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    if (CrmUtils.a.matcher(this.b).find())
    {
      CrmIvrText.a(paramView, this.a.a, this.a.b, this.a.c);
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText.CrmIvrLinkSpan
 * JD-Core Version:    0.7.0.1
 */