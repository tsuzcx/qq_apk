package com.tencent.mobileqq.activity.contact.connections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

public class TabThemeMaskView
  extends ImageView
{
  Paint a;
  RectF b = new RectF();
  private int c = ThemeUtil.NIGHTMODE_MASKCOLOR;
  
  public TabThemeMaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public TabThemeMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public TabThemeMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public static boolean b()
  {
    return ("1103".equals(ThemeUtil.curThemeId)) || ("2920".equals(ThemeUtil.curThemeId));
  }
  
  protected void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (b())
    {
      this.b.set(0.0F, 0.0F, getWidth(), getHeight());
      super.onDraw(paramCanvas);
      this.a.setColorFilter(null);
      this.a.setColor(this.c);
      paramCanvas.drawRect(this.b, this.a);
      return;
    }
    super.onDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.connections.TabThemeMaskView
 * JD-Core Version:    0.7.0.1
 */