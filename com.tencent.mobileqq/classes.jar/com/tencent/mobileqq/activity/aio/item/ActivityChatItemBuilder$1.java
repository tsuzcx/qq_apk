package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;

class ActivityChatItemBuilder$1
  implements ViewTreeObserver.OnPreDrawListener
{
  ActivityChatItemBuilder$1(ActivityChatItemBuilder paramActivityChatItemBuilder, TextView paramTextView, String paramString) {}
  
  private String a(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      } else if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
        paramString[i] = ((char)(paramString[i] - 65248));
      }
      i += 1;
    }
    return new String(paramString);
  }
  
  public boolean onPreDraw()
  {
    int i = this.a.getMeasuredWidth();
    this.a.setText(this.b);
    TextPaint localTextPaint = this.a.getPaint();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c.c.getString(2131894990));
    ((StringBuilder)localObject).append(">");
    String str1 = a(((StringBuilder)localObject).toString());
    String str2 = a(this.b);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("  ");
    ((StringBuilder)localObject).append(str1);
    String str3 = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append(str3);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("      ");
    float f1 = localTextPaint.measureText(localStringBuilder.toString());
    float f2 = i * 2;
    int j = 0;
    if (f1 >= f2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("...");
      localStringBuilder.append(str3);
      str3 = localStringBuilder.toString();
      k = str2.length();
      i = 0;
      while (i < k)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str2.substring(0, k - i));
        ((StringBuilder)localObject).append(str3);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("      ");
        if (localTextPaint.measureText(localStringBuilder.toString()) < f2) {
          break;
        }
        i += 1;
      }
    }
    int k = ((String)localObject).length();
    i = j;
    if (k > str1.length()) {
      i = k - str1.length();
    }
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(-12541697), i, k, 33);
    this.a.setText((CharSequence)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ActivityChatItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */