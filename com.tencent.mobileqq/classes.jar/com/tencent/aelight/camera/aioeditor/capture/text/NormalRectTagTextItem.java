package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class NormalRectTagTextItem
  extends NormalTextItem
{
  public static final int a;
  private static final int j;
  private static final int s;
  private Paint p = new TextPaint();
  private RectF q;
  private int r = Color.parseColor("#FFFFFF");
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    s = AIOUtils.b(1.0F, localResources);
    a = AIOUtils.b(22.0F, localResources);
    j = AIOUtils.b(11.0F, localResources);
  }
  
  public NormalRectTagTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.p.setStyle(Paint.Style.FILL);
    this.p.setColor(16777215);
    this.p.setAlpha(230);
    this.p.setAntiAlias(true);
    this.q = new RectF();
  }
  
  public void a(int paramInt)
  {
    this.p.setColor(paramInt);
    this.p.setAlpha(230);
    this.r = paramInt;
    if ((paramInt != Color.parseColor("#FFFFFF")) && (paramInt != Color.parseColor("#F7E368")) && (paramInt != Color.parseColor("#7ED5F8")))
    {
      this.g.setColor(Color.parseColor("#ffffff"));
      return;
    }
    this.g.setColor(Color.parseColor("#000000"));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      if (this.n.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(c() / 2.0F, d() / 2.0F);
        this.g.setTextAlign(Paint.Align.CENTER);
        Object localObject2 = super.c(0);
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "　　";
        }
        i = (int)this.g.measureText((String)localObject1);
        int k = (int)Math.ceil(this.g.descent() - this.g.ascent());
        localObject2 = this.q;
        int m = a;
        ((RectF)localObject2).left = (-(m * 2 + i) / 2.0F);
        ((RectF)localObject2).right = ((m * 2 + i) / 2.0F);
        m = j;
        ((RectF)localObject2).top = (-(m * 2 + k) / 2.0F);
        ((RectF)localObject2).bottom = ((m * 2 + k) / 2.0F);
        m = s;
        paramCanvas.drawRoundRect((RectF)localObject2, m, m, this.p);
        paramCanvas.drawText((String)localObject1, 0.0F, -((this.g.descent() + this.g.ascent()) / 2.0F), this.g);
        if (super.f(0))
        {
          this.e.left = (-i / 2.0F);
          this.e.top = (-k / 2.0F);
          this.e.right = (i / 2.0F);
          this.e.bottom = (k / 2.0F);
          paramCanvas.drawRoundRect(this.e, 6.0F, 6.0F, s());
        }
        paramCanvas.restore();
        return;
      }
      this.g.setTextAlign(Paint.Align.LEFT);
      paramCanvas.save();
      paramCanvas.translate(a, j);
      float f1 = super.a(this.n);
      float f2 = this.n.getHeight();
      Object localObject1 = this.q;
      int i = a;
      ((RectF)localObject1).left = (-i);
      ((RectF)localObject1).right = (i + f1);
      i = j;
      ((RectF)localObject1).top = (-i);
      ((RectF)localObject1).bottom = (i + f2);
      i = s;
      paramCanvas.drawRoundRect((RectF)localObject1, i, i, this.p);
      this.n.draw(paramCanvas);
      if (super.f(0))
      {
        this.e.left = 0.0F;
        this.e.top = 0.0F;
        this.e.right = f1;
        this.e.bottom = f2;
        paramCanvas.drawRoundRect(this.e, 6.0F, 6.0F, s());
      }
      paramCanvas.restore();
    }
  }
  
  public float c()
  {
    return this.h + a * 2;
  }
  
  public float d()
  {
    return this.i + j * 2;
  }
  
  public int u()
  {
    return this.r;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalRectTagTextItem
 * JD-Core Version:    0.7.0.1
 */