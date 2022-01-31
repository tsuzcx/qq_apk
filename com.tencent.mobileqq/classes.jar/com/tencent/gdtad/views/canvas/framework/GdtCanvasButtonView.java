package com.tencent.gdtad.views.canvas.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;

public class GdtCanvasButtonView
  extends TextView
{
  public GdtCanvasButtonView(Context paramContext, GdtCanvasButtonData paramGdtCanvasButtonData)
  {
    super(paramContext);
    a(paramContext, paramGdtCanvasButtonData);
  }
  
  @TargetApi(16)
  private void a(Context paramContext, GdtCanvasButtonData paramGdtCanvasButtonData)
  {
    if ((paramGdtCanvasButtonData == null) || (!paramGdtCanvasButtonData.isValid())) {
      GdtLog.d("GdtCanvasButtonView", "init error");
    }
    do
    {
      return;
      setGravity(17);
      setText(paramGdtCanvasButtonData.text.text);
      setTextSize(0, paramGdtCanvasButtonData.text.size);
      setTextColor(paramGdtCanvasButtonData.text.color);
      paramContext = new GradientDrawable();
      paramContext.setShape(0);
      paramContext.setCornerRadius(paramGdtCanvasButtonData.borderCornerRadius);
      paramContext.setColor(paramGdtCanvasButtonData.backgroundColor);
    } while (Build.VERSION.SDK_INT < 16);
    setBackground(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonView
 * JD-Core Version:    0.7.0.1
 */