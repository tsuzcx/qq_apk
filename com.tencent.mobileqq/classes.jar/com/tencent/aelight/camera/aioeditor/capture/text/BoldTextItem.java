package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class BoldTextItem
  extends DynamicTextItem
{
  private TextPaint a = new TextPaint();
  private TextPaint b = new TextPaint();
  private float c;
  private float d;
  private RectF e = new RectF();
  private StaticLayout f;
  
  public BoldTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    if (paramTypeface != null)
    {
      this.a.setTypeface(paramTypeface);
      this.b.setTypeface(paramTypeface);
    }
    else
    {
      this.a.setTypeface(Typeface.defaultFromStyle(1));
      this.b.setTypeface(Typeface.defaultFromStyle(1));
    }
    this.a.setTextAlign(Paint.Align.LEFT);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setTextSize(AIOUtils.b(22.0F, BaseApplicationImpl.getContext().getResources()));
    this.a.setColor(-1);
    this.b.setTextAlign(Paint.Align.LEFT);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeJoin(Paint.Join.ROUND);
    this.b.setTextSize(AIOUtils.b(22.0F, BaseApplicationImpl.getContext().getResources()));
    this.b.setColor(-16777216);
    this.b.setStrokeWidth(AIOUtils.b(6.0F, BaseApplicationImpl.getContext().getResources()));
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = super.c(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    paramInt = (int)this.a.measureText(HardCodeUtil.a(2131899410));
    this.n = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.a, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    this.f = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.b, paramInt, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, 2);
    this.c = super.a(this.n);
    this.d = this.n.getHeight();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      paramCanvas.save();
      this.f.draw(paramCanvas);
      this.n.draw(paramCanvas);
      if (f(0))
      {
        RectF localRectF = this.e;
        localRectF.left = 0.0F;
        localRectF.top = 0.0F;
        localRectF.right = super.a(this.n);
        this.e.bottom = this.n.getHeight();
        paramCanvas.drawRoundRect(this.e, 6.0F, 6.0F, s());
      }
      paramCanvas.restore();
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
    return this.c;
  }
  
  public float d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BoldTextItem
 * JD-Core Version:    0.7.0.1
 */