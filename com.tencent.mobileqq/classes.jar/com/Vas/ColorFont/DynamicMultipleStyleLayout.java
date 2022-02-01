package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.font.api.IETextView;
import java.util.Arrays;
import java.util.List;

public class DynamicMultipleStyleLayout
  extends FounderColorLayout
{
  private Paint I;
  private int[] J;
  
  public DynamicMultipleStyleLayout(IETextView paramIETextView, ETFont paramETFont)
  {
    super(paramIETextView, paramETFont);
  }
  
  private void n()
  {
    if (this.d == null) {
      this.d = new Canvas(this.o);
    } else {
      this.d.setBitmap(this.o);
    }
    if (this.I == null)
    {
      this.I = new Paint();
      this.I.setColor(-16777216);
    }
    this.J = new int[this.f.size()];
    int i = 0;
    while (i < this.f.size())
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.f.get(i);
      if (!localModelFastColorFont.h)
      {
        this.J[i] = 0;
      }
      else
      {
        this.J[i] = 1;
        this.I.setTextSize(localModelFastColorFont.d);
        float f1 = localModelFastColorFont.d / 2.0F;
        float f2 = (this.I.descent() + this.I.ascent()) / 2.0F;
        this.d.drawText(String.valueOf(localModelFastColorFont.b), localModelFastColorFont.e, localModelFastColorFont.f + (f1 - f2), this.I);
      }
      i += 1;
    }
  }
  
  protected void D_()
  {
    int j = (int)(this.b.getTextSize() / 15.0F);
    if (this.c == null) {
      this.c = new Canvas(this.o);
    } else {
      this.c.setBitmap(this.o);
    }
    int k = this.f.size();
    int i = 0;
    while (i < k)
    {
      ModelFastColorFont localModelFastColorFont = (ModelFastColorFont)this.f.get(i);
      int m = localModelFastColorFont.a;
      Object localObject;
      if (m != 1)
      {
        if (m == 2)
        {
          this.c.drawRect(localModelFastColorFont.e, localModelFastColorFont.f, localModelFastColorFont.e + localModelFastColorFont.c, localModelFastColorFont.f + localModelFastColorFont.d, this.E);
          if ((localModelFastColorFont.i instanceof EmoticonSpan))
          {
            localObject = (EmoticonSpan)localModelFastColorFont.i;
            Canvas localCanvas = this.c;
            float f = localModelFastColorFont.e;
            m = localModelFastColorFont.f;
            int n = localModelFastColorFont.f;
            ((EmoticonSpan)localObject).draw(localCanvas, null, 0, 0, f, m, localModelFastColorFont.d + n, localModelFastColorFont.f + localModelFastColorFont.d, this.b.getPaint());
          }
          else if ((localModelFastColorFont.i instanceof SignatureActionSpan))
          {
            localObject = (SignatureActionSpan)localModelFastColorFont.i;
            ((SignatureActionSpan)localObject).c = false;
            ((SignatureActionSpan)localObject).draw(this.c, null, 0, 0, localModelFastColorFont.e, localModelFastColorFont.f, localModelFastColorFont.f, localModelFastColorFont.f + localModelFastColorFont.d, this.b.getPaint());
          }
        }
      }
      else
      {
        localObject = a(localModelFastColorFont.c, j);
        this.c.drawBitmap((Bitmap)localObject, localModelFastColorFont.e, localModelFastColorFont.f + localModelFastColorFont.d - j, this.b.getPaint());
      }
      i += 1;
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    if (m())
    {
      FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw view宽高为0或超过屏幕尺寸......");
      return false;
    }
    if (!k())
    {
      FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.e != null) && (!this.e.isEmpty()))
    {
      if (this.m.length <= 0)
      {
        FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw 字数为零！");
        return false;
      }
      long l1 = System.nanoTime();
      c();
      c(paramCanvas);
      n();
      if ((this.q.mShouldDisplayAnimation) && (!this.D) && (this.x > 0) && (this.x < 6))
      {
        FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.J, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, this.s, this.p, this.q.mComboIndex);
        D_();
        paramCanvas.drawBitmap(this.o, this.g, this.i, null);
        if (this.s == 0) {
          b();
        }
      }
      else
      {
        this.s = 0;
        FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.J, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, 0, this.p, this.q.mComboIndex);
        l();
        paramCanvas.drawBitmap(this.o, this.g, this.i, null);
      }
      if (FastColorFontHelper.a)
      {
        long l2 = System.nanoTime();
        paramCanvas = new StringBuilder();
        paramCanvas.append("动画帧耗时 frameIndex:");
        paramCanvas.append(this.s);
        paramCanvas.append("  行：");
        paramCanvas.append(this.x);
        paramCanvas.append("  列：");
        paramCanvas.append(this.y);
        paramCanvas.append("  耗时：");
        paramCanvas.append((float)(l2 - l1) / 1000000.0F);
        paramCanvas.append("ms");
        FastColorFontLog.b("DynamicMultipleStyleLayout", paramCanvas.toString());
        if (this.s == 0) {
          a("drawAnimationText.....");
        }
      }
      return true;
    }
    FastColorFontLog.b("DynamicMultipleStyleLayout", "DynamicMultipleStyleLayout::onDraw 行数为零！");
    return false;
  }
  
  public void b()
  {
    if (this.q != null)
    {
      if (m()) {
        return;
      }
      if ((this.x > 0) && (this.x <= 5) && (!this.D))
      {
        if ((this.r != null) && (this.r.isRunning())) {
          return;
        }
        if (FastColorFontHelper.a)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("StartAnimation......animInfo:");
          localStringBuilder.append(Arrays.toString(this.p));
          FastColorFontLog.a("DynamicMultipleStyleLayout", localStringBuilder.toString());
        }
        if ((this.p[0] > 0) && (this.p[1] > 0))
        {
          i();
          return;
        }
        this.s = 0;
        FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.J, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, this.s, this.p, this.q.mComboIndex);
        if ((this.p[0] > 0) && (this.p[1] > 0))
        {
          i();
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
        localStringBuilder.append(Arrays.toString(this.p));
        FastColorFontLog.b("DynamicMultipleStyleLayout", localStringBuilder.toString());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0行或超过5行或全EMOJI不支持播放动画...");
      localStringBuilder.append(this.q.mFontPath);
      FastColorFontLog.b("DynamicMultipleStyleLayout", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.DynamicMultipleStyleLayout
 * JD-Core Version:    0.7.0.1
 */