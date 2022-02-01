package com.Vas.ColorFont;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.etrump.mixlayout.ETFont;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richstatus.SignatureActionSpan;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.vas.font.api.IETextView;
import java.util.Arrays;
import java.util.List;

public class StrikingLayout
  extends FounderColorLayout
{
  private Paint I;
  private int[] J;
  
  public StrikingLayout(IETextView paramIETextView, ETFont paramETFont)
  {
    super(paramIETextView, paramETFont);
  }
  
  private void o()
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
  
  public boolean a(Canvas paramCanvas)
  {
    if (m())
    {
      a("StrikingLayout::onDraw view宽高为0或超过屏幕尺寸！");
      return false;
    }
    if (!k())
    {
      a("StrikingLayout::onDraw 创建bitmap失败！");
      return false;
    }
    if ((this.e != null) && (!this.e.isEmpty()))
    {
      if (this.m.length <= 0)
      {
        a(HardCodeUtil.a(2131911884));
        return false;
      }
      long l = System.nanoTime();
      c();
      c(paramCanvas);
      o();
      FastColorFontCache.b(this.q.mFontId);
      int i = FastColorFontCache.g(this.q.mFontId);
      StringBuilder localStringBuilder;
      if ((!this.D) && (this.x > 0) && (this.x < 6))
      {
        if (this.q.mShouldDisplayAnimation)
        {
          FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.J, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, this.s, this.p, this.q.mComboIndex);
          n();
          paramCanvas.drawBitmap(this.o, this.g, this.i, null);
          if (this.s == 0) {
            b();
          }
          if (FastColorFontHelper.a)
          {
            paramCanvas = f();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("字数：");
            localStringBuilder.append(this.m.length);
            localStringBuilder.append("\n   字号：");
            localStringBuilder.append(this.b.getTextSize());
            localStringBuilder.append("px\n");
            FastColorFontLog.a(paramCanvas, l, localStringBuilder.toString());
            a("StrikingLayout::onDraw......");
          }
          return true;
        }
        if ((!this.q.mShouldDisplayAnimation) && (i == 1))
        {
          FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.J, this.o, null, this.k - this.g - this.h, this.l - this.i - this.j, this.x, this.y, this.z, this.q.mAnimationId, this.p[0], this.p, this.q.mComboIndex);
          n();
          paramCanvas.drawBitmap(this.o, this.g, this.i, null);
          if (FastColorFontHelper.a)
          {
            paramCanvas = f();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("字数：");
            localStringBuilder.append(this.m.length);
            localStringBuilder.append("\n   字号：");
            localStringBuilder.append(this.b.getTextSize());
            localStringBuilder.append("px\n");
            FastColorFontLog.a(paramCanvas, l, localStringBuilder.toString());
            a("StrikingLayout::onDraw......");
          }
          return true;
        }
      }
      this.B = new int[0];
      FastColorFontHelper.a().a(this.q.mFontId, this.m, this.n, this.u, this.v, this.w, this.o, this.k - this.g - this.h, this.l - this.i - this.j, this.A, this.B, this.C);
      l();
      paramCanvas.drawBitmap(this.o, this.g, this.i, null);
      if (a) {
        b(paramCanvas);
      }
      if (FastColorFontHelper.a)
      {
        paramCanvas = f();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("字数：");
        localStringBuilder.append(this.m.length);
        localStringBuilder.append("\n   字号：");
        localStringBuilder.append(this.b.getTextSize());
        localStringBuilder.append("px\n");
        FastColorFontLog.a(paramCanvas, l, localStringBuilder.toString());
        a("StrikingLayout::onDraw......");
      }
      return true;
    }
    a(HardCodeUtil.a(2131911883));
    return false;
  }
  
  public void b()
  {
    if ((this.q != null) && (!m()))
    {
      if (this.m.length <= 0) {
        return;
      }
      if ((this.x > 0) && (this.x <= 5) && (!this.D))
      {
        if ((this.r != null) && (this.r.isRunning())) {
          return;
        }
        if (FastColorFontHelper.a)
        {
          str = f();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("StartAnimation......animInfo:");
          localStringBuilder.append(Arrays.toString(this.p));
          FastColorFontLog.a(str, localStringBuilder.toString());
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
        str = f();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("StartAnimation......动画帧数和帧间隔数据异常 animInfo:");
        localStringBuilder.append(Arrays.toString(this.p));
        FastColorFontLog.b(str, localStringBuilder.toString());
        return;
      }
      String str = f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0行或超过5行或全EMOJI不支持播放动画...");
      localStringBuilder.append(this.q.mFontPath);
      FastColorFontLog.b(str, localStringBuilder.toString());
    }
  }
  
  protected void n()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.Vas.ColorFont.StrikingLayout
 * JD-Core Version:    0.7.0.1
 */