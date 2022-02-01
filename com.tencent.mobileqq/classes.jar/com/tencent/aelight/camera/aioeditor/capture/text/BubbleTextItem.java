package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class BubbleTextItem
  extends DynamicTextItem
{
  private static final int g = AIOUtils.b(20.0F, BaseApplicationImpl.getContext().getResources());
  private static final int h = AIOUtils.b(12.0F, BaseApplicationImpl.getContext().getResources());
  float a;
  float b;
  private StaticLayout c;
  private NinePatch d;
  private TextPaint e = new TextPaint();
  private RectF f = new RectF();
  private RectF i = new RectF();
  
  public BubbleTextItem(int paramInt, List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    this.e.setAntiAlias(true);
    this.e.setTypeface(paramTypeface);
    this.e.setTextSize(AIOUtils.b(20.0F, BaseApplicationImpl.getContext().getResources()));
    this.e.setColor(-16777216);
    this.d = new NinePatch(paramBitmap, paramBitmap.getNinePatchChunk(), null);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject = super.c(paramInt);
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    int j = (int)this.e.measureText(HardCodeUtil.a(2131899459));
    paramInt = 0;
    this.c = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.e, j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 3);
    int k = this.c.getLineCount();
    float f1 = 0.0F;
    while (paramInt < k)
    {
      f1 = Math.max(f1, this.c.getLineWidth(paramInt));
      paramInt += 1;
    }
    float f2 = this.c.getHeight();
    float f3 = Math.max(this.d.getWidth(), h + g + f1);
    float f4 = this.d.getHeight();
    this.f.set(0.0F, 0.0F, f3, f4 * 0.7F + f2);
    this.a = f1;
    this.b = f2;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set text ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" max ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(" tw ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" th ");
    ((StringBuilder)localObject).append(f2);
    SLog.b("BubbleTextItem", ((StringBuilder)localObject).toString());
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.translate(10.0F, 10.0F);
    this.d.draw(paramCanvas, this.f);
    paramCanvas.translate(g, this.d.getHeight() * 0.4F);
    this.c.draw(paramCanvas);
    if (super.f(0))
    {
      float f1 = this.c.getHeight();
      float f2 = super.a(this.c);
      RectF localRectF = this.i;
      localRectF.left = 0.0F;
      localRectF.top = 0.0F;
      localRectF.right = f2;
      localRectF.bottom = f1;
      paramCanvas.drawRoundRect(localRectF, 6.0F, 6.0F, s());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 1;
  }
  
  public float c()
  {
    return this.f.width() + 20.0F;
  }
  
  public float d()
  {
    return this.f.height() + 20.0F;
  }
  
  public int g()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BubbleTextItem
 * JD-Core Version:    0.7.0.1
 */