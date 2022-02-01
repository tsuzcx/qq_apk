package com.tencent.biz.widgets;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class KandianTextView
  extends TextView
{
  private boolean a;
  
  public KandianTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KandianTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KandianTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    if (this.a) {
      return;
    }
    if (super.getLineCount() == 2)
    {
      paramInt1 = super.getLayout().getLineVisibleEnd(0);
      paramInt2 = super.getLayout().getLineVisibleEnd(1);
      paramInt3 = paramInt1 - 1;
      if (paramInt3 >= 0)
      {
        paramInt1 = paramInt2 - paramInt1;
        if ((paramInt1 == 1) || (paramInt1 == 2))
        {
          String str2 = super.getText().toString();
          if (paramInt1 == 2 ? (str2.charAt(paramInt3) >= '一') && (str2.charAt(paramInt3) <= 40869) : (str2.charAt(paramInt3) >= '一') && (str2.charAt(paramInt3) <= 40869)) {
            paramInt1 = 1;
          } else {
            paramInt1 = 0;
          }
          if (paramInt1 != 0)
          {
            String str1 = str2.substring(0, paramInt3);
            str2 = str2.substring(paramInt3, paramInt2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1);
            localStringBuilder.append("\n");
            localStringBuilder.append(str2);
            super.setText(localStringBuilder.toString());
          }
        }
      }
    }
    this.a = true;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.a = false;
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.KandianTextView
 * JD-Core Version:    0.7.0.1
 */