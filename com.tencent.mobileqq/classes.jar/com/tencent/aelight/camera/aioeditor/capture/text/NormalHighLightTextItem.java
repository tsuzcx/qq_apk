package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NormalHighLightTextItem
  extends NormalTextItem
{
  private int a;
  private StaticLayout j;
  private TextPaint p;
  private Map<Integer, Integer> q = new HashMap();
  private Map<Integer, Integer> r = new HashMap();
  
  public NormalHighLightTextItem(int paramInt, List<String> paramList)
  {
    super(paramInt, paramList);
    this.g.setAntiAlias(true);
    this.g.setStyle(Paint.Style.FILL);
    this.g.setColor(-1);
    this.g.setTextSize(b);
    if (this.p == null) {
      this.p = new TextPaint(this.g);
    }
    this.p.setStyle(Paint.Style.FILL_AND_STROKE);
    this.p.setStrokeWidth(2.0F);
    x();
  }
  
  private int a(Map<Integer, Integer> paramMap, int paramInt)
  {
    int i = paramInt;
    if (paramMap != null)
    {
      i = paramInt;
      if (paramMap.containsKey(Integer.valueOf(paramInt)))
      {
        paramMap = (Integer)paramMap.get(Integer.valueOf(paramInt));
        i = paramInt;
        if (paramMap != null)
        {
          i = paramInt;
          if (paramMap.intValue() > 0) {
            i = paramMap.intValue();
          }
        }
      }
    }
    return i;
  }
  
  private void x()
  {
    Object localObject1 = this.q;
    Integer localInteger1 = Integer.valueOf(-14079703);
    ((Map)localObject1).put(localInteger1, Integer.valueOf(-1275068417));
    Object localObject2 = this.q;
    localObject1 = Integer.valueOf(-1);
    ((Map)localObject2).put(localObject1, Integer.valueOf(-869717719));
    Object localObject3 = this.q;
    localObject2 = Integer.valueOf(-1027508);
    ((Map)localObject3).put(localObject2, Integer.valueOf(-27761));
    Object localObject4 = this.q;
    localObject3 = Integer.valueOf(-1131223);
    ((Map)localObject4).put(localObject3, Integer.valueOf(-6997));
    Object localObject5 = this.q;
    localObject4 = Integer.valueOf(-6038445);
    ((Map)localObject5).put(localObject4, Integer.valueOf(-5770946));
    Map localMap = this.q;
    localObject5 = Integer.valueOf(-12147713);
    localMap.put(localObject5, Integer.valueOf(-4199169));
    localMap = this.q;
    Integer localInteger2 = Integer.valueOf(-7768577);
    localMap.put(localInteger2, Integer.valueOf(-5464321));
    this.q.put(Integer.valueOf(-496479), Integer.valueOf(-20274));
    this.r.put(localInteger1, Integer.valueOf(-2130706433));
    this.r.put(localObject1, Integer.valueOf(-1003935447));
    this.r.put(localObject2, Integer.valueOf(-62975));
    this.r.put(localObject3, Integer.valueOf(-27136));
    this.r.put(localObject4, Integer.valueOf(-5505226));
    this.r.put(localObject5, Integer.valueOf(-16744193));
    this.r.put(localInteger2, Integer.valueOf(-10682121));
    this.r.put(Integer.valueOf(-496479), Integer.valueOf(-65439));
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
    this.p.setColor(a(this.q, paramInt));
    this.p.setShadowLayer(10.0F, 0.0F, 0.0F, a(this.r, paramInt));
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject = super.c(paramInt);
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    if (this.p == null) {
      this.p = new TextPaint(this.g);
    }
    if (this.l) {
      this.p.setTextSize(this.k);
    }
    this.j = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.p, c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    if (this.j.getLineCount() > this.f)
    {
      paramInt = this.j.getLineEnd(this.f - 1);
      localObject = paramString;
      if (paramInt < paramString.length())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.subSequence(0, paramInt));
        ((StringBuilder)localObject).append("");
        localObject = ((StringBuilder)localObject).toString();
      }
      this.j = StaticLayoutWithMaxLines.a((CharSequence)localObject, 0, ((String)localObject).length(), this.p, c, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false, null, 0, this.f);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.n != null)
    {
      float f1;
      if (this.n.getLineCount() == 1)
      {
        paramCanvas.save();
        paramCanvas.translate(c() / 2.0F, d() / 2.0F);
        this.g.setTextAlign(Paint.Align.CENTER);
        this.p.setTextAlign(Paint.Align.CENTER);
        f1 = -((this.g.descent() + this.g.ascent()) / 2.0F);
        String str = super.c(0);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "　　";
        }
        this.p.setAlpha(102);
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.p);
        this.p.setAlpha(255);
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.p);
        paramCanvas.drawText((String)localObject, 0.0F, f1, this.g);
        if (super.f(0))
        {
          int i = (int)this.g.measureText((String)localObject);
          int k = (int)Math.ceil(this.g.descent() - this.g.ascent());
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
      this.p.setTextAlign(Paint.Align.LEFT);
      paramCanvas.save();
      Object localObject = this.j;
      if (localObject != null)
      {
        ((StaticLayout)localObject).getPaint().setAlpha(102);
        this.j.draw(paramCanvas);
        this.j.getPaint().setAlpha(255);
        this.j.draw(paramCanvas);
      }
      this.n.draw(paramCanvas);
      if (super.f(0))
      {
        f1 = super.a(this.n);
        float f2 = this.n.getHeight();
        this.e.left = 0.0F;
        this.e.top = 0.0F;
        this.e.right = f1;
        this.e.bottom = f2;
        paramCanvas.drawRoundRect(this.e, 6.0F, 6.0F, s());
      }
      paramCanvas.restore();
    }
  }
  
  public int u()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.NormalHighLightTextItem
 * JD-Core Version:    0.7.0.1
 */