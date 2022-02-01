package com.tencent.biz.widgets;

import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.LinkSpan;

public class PubAccountQQText
  extends QQText
{
  public String a;
  public String b;
  
  public PubAccountQQText(CharSequence paramCharSequence, int paramInt)
  {
    super(paramCharSequence, paramInt);
  }
  
  public void addSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof LinkSpan)) {
      localObject = new PubAccountQQText.PubAccountLinkSpan(this, ((LinkSpan)paramObject).a);
    }
    super.addSpan(localObject, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.PubAccountQQText
 * JD-Core Version:    0.7.0.1
 */