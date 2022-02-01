package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.InputFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoldOverTextItem
  extends DynamicTextItem
{
  private static final int[] r = { 5, 5, 5, 5 };
  private static Method s;
  private static final float v;
  private static final int w;
  private int a = Color.parseColor("#ffa414");
  private int b = Color.parseColor("#ff1a14");
  private int c = Color.parseColor("#1f14ff");
  private float d = 0.0F;
  private float e = 0.0F;
  private List<Float> f;
  private TextPaint g;
  private float h = 0.0F;
  private float i = 0.0F;
  private Bitmap j;
  private Shader p;
  private float q = 0.0F;
  private String t = "";
  private RectF u = new RectF();
  private InputFilter x = null;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    v = AIOUtils.b(2.0F, localResources);
    int k = DisplayUtil.a();
    w = localResources.getDisplayMetrics().widthPixels - TextLayer.b - k * 2;
  }
  
  public FoldOverTextItem(int paramInt, @NonNull List<String> paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.q = (localResources.getDisplayMetrics().density * 2.0F);
    this.f = new ArrayList();
    this.d = AIOUtils.b(25.0F, localResources);
    this.e = AIOUtils.b(3.0F, localResources);
    this.g = new TextPaint();
    this.g.setTextSize(this.d);
    this.g.setAntiAlias(true);
    if (paramTypeface != null) {
      this.g.setTypeface(paramTypeface);
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (s == null) {
        s = Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE });
      }
      if (s != null) {
        s.invoke(this.g, new Object[] { Float.valueOf(-0.09F) });
      }
    }
    catch (Exception paramTypeface)
    {
      label162:
      break label162;
    }
    if (paramBitmap != null)
    {
      this.j = paramBitmap;
      this.p = new BitmapShader(this.j, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }
  }
  
  private CharSequence b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    int m = 0;
    int k = 0;
    int n = 0;
    while (m < paramString.length())
    {
      if ((paramString.charAt(m) != '\n') && (paramString.charAt(m) != '\r') && (k < r[n]))
      {
        localStringBuilder.append(paramString.charAt(m));
        k += 1;
      }
      else
      {
        localStringBuilder.append('\n');
        if ((paramString.charAt(m) != '\n') && (paramString.charAt(m) != '\r'))
        {
          localStringBuilder.append(paramString.charAt(m));
          k = 1;
        }
        else
        {
          k = 0;
        }
        int i2 = n + 1;
        n = i2;
        if (i2 >= r.length) {
          break;
        }
      }
      m += 1;
    }
    this.f.clear();
    paramString = new SpannableString(localStringBuilder.toString());
    float f1 = 0.0F;
    m = 0;
    k = i1;
    while (k < paramString.length())
    {
      if ((paramString.charAt(k) != '\n') && (paramString.charAt(k) != '\r'))
      {
        float f2 = (int)(this.d + m * this.e);
        paramString.setSpan(new AbsoluteSizeAndLineSpaceSpan(f2, 0.85F), k, k + 1, 17);
        f1 += f2;
        m += 1;
      }
      else
      {
        this.f.add(Float.valueOf(f1));
        f1 = 0.0F;
      }
      k += 1;
    }
    this.f.add(Float.valueOf(f1));
    return paramString;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    Object localObject1 = a(paramInt, new FoldOverTextItem.1(this));
    this.t = ((String)localObject1);
    paramString = r;
    int n = paramString.length;
    int m = 0;
    paramInt = 0;
    int k = 0;
    while (paramInt < n)
    {
      k += paramString[paramInt];
      paramInt += 1;
    }
    paramString = (String)localObject1;
    if (((String)localObject1).length() > k) {
      paramString = ((String)localObject1).substring(0, k);
    }
    localObject1 = b(paramString);
    Object localObject2 = this.f.iterator();
    for (float f1 = 0.0F; ((Iterator)localObject2).hasNext(); f1 = Math.max(((Float)((Iterator)localObject2).next()).floatValue(), f1)) {}
    f1 = Math.min(w, f1);
    k = ((CharSequence)localObject1).length();
    localObject2 = this.g;
    paramInt = (int)f1;
    this.n = StaticLayoutWithMaxLines.a((CharSequence)localObject1, 0, k, (TextPaint)localObject2, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, r.length);
    localObject1 = paramString;
    if (this.n.getLineCount() == 4)
    {
      k = this.n.getLineEnd(3);
      localObject1 = paramString;
      if (k > 0)
      {
        k = Math.min(k, paramString.length());
        localObject1 = paramString.substring(0, k);
        if ((!((String)localObject1).endsWith("\n")) && (!((String)localObject1).endsWith("\r"))) {
          localObject1 = paramString.substring(0, k);
        } else {
          localObject1 = paramString.substring(0, k - 1);
        }
      }
    }
    paramString = b((String)localObject1);
    this.n = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.g, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, r.length);
    this.h = 0.0F;
    k = this.n.getLineCount();
    paramInt = m;
    while (paramInt < k)
    {
      this.h = Math.max(this.n.getLineWidth(paramInt), this.h);
      paramInt += 1;
    }
    f1 = this.n.getHeight();
    float f2 = this.q;
    this.i = (f1 + 3.0F * f2);
    this.h += f2 * 2.0F;
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.q * 2.0F, 0.0F);
    paramCanvas.save();
    this.g.setStyle(Paint.Style.FILL);
    float f1 = this.q;
    paramCanvas.translate(f1 * -2.0F, f1 * 3.0F);
    this.g.setColor(this.c);
    this.n.draw(paramCanvas);
    this.g.setColor(-16777216);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeWidth(2.0F);
    this.n.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.g.setStyle(Paint.Style.FILL);
    f1 = this.q;
    paramCanvas.translate(-f1, f1 * 1.5F);
    this.g.setColor(this.b);
    this.n.draw(paramCanvas);
    this.g.setColor(-16777216);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeWidth(2.0F);
    this.n.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.g.setStyle(Paint.Style.FILL);
    paramCanvas.translate(0.0F, 0.0F);
    this.g.setColor(this.a);
    this.n.draw(paramCanvas);
    Object localObject = this.p;
    if (localObject != null)
    {
      this.g.setShader((Shader)localObject);
      this.n.draw(paramCanvas);
      this.g.setShader(null);
    }
    this.g.setColor(-16777216);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setStrokeWidth(2.0F);
    this.n.draw(paramCanvas);
    int k = 0;
    if (f(0))
    {
      int m = this.n.getLineCount();
      f1 = 0.0F;
      while (k < m)
      {
        f1 = Math.max(f1, this.n.getLineWidth(k));
        k += 1;
      }
      float f4 = this.h;
      f1 = this.n.getHeight();
      float f2 = this.n.getWidth() / 2.0F;
      localObject = this.u;
      float f3 = this.q;
      f4 /= 2.0F;
      float f5 = v;
      ((RectF)localObject).left = (-2.0F * f3 + f2 - f4 - f5);
      ((RectF)localObject).top = (0.0F - f5 * 3.0F);
      ((RectF)localObject).right = (f2 + f4 + f5 * 2.0F);
      ((RectF)localObject).bottom = (f1 + f3 * 3.0F + f5 * 2.0F);
      paramCanvas.drawRoundRect((RectF)localObject, 6.0F, 6.0F, s());
    }
    paramCanvas.restore();
    paramCanvas.restore();
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
    return this.n.getWidth() + this.q * 3.0F;
  }
  
  public float d()
  {
    return this.i;
  }
  
  public boolean e()
  {
    return (TextUtils.isEmpty(this.t)) || (super.e());
  }
  
  public InputFilter f()
  {
    if (this.x == null) {
      this.x = new FoldOverTextItem.2(this, 20);
    }
    return this.x;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.FoldOverTextItem
 * JD-Core Version:    0.7.0.1
 */