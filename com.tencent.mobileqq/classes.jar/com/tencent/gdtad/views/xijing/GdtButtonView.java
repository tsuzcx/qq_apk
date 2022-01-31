package com.tencent.gdtad.views.xijing;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import yny;
import ypk;

public class GdtButtonView
  extends TextView
{
  public GdtButtonView(Context paramContext, GdtButtonData paramGdtButtonData)
  {
    super(paramContext);
    a(paramContext, paramGdtButtonData);
  }
  
  @TargetApi(16)
  private void a(Context paramContext, GdtButtonData paramGdtButtonData)
  {
    if ((paramGdtButtonData == null) || (!paramGdtButtonData.isValid())) {
      yny.d("GdtButtonView", "init error");
    }
    do
    {
      return;
      setGravity(17);
      setText(paramGdtButtonData.text.text);
      setSingleLine(true);
      setEllipsize(TextUtils.TruncateAt.END);
      int i = ypk.a(2.0F, paramContext.getResources());
      setPadding(i, 0, i, 0);
      setTextSize(0, paramGdtButtonData.text.size);
      setTextColor(paramGdtButtonData.text.color);
      paramContext = new GradientDrawable();
      paramContext.setShape(0);
      paramContext.setCornerRadius(paramGdtButtonData.borderCornerRadius);
      paramContext.setColor(paramGdtButtonData.backgroundColor);
    } while (Build.VERSION.SDK_INT < 16);
    setBackground(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.xijing.GdtButtonView
 * JD-Core Version:    0.7.0.1
 */