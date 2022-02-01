package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.util.InfoStickerUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class RelaxedAfternoon
  extends DynamicTextItem
{
  public static final int a;
  public static final int b;
  public static final int c;
  private int A;
  private int B;
  private int C;
  private InputFilter D;
  TextDrawImplement d;
  TextDrawImplement e;
  TextDrawImplement f;
  int g;
  private TextPaint h;
  private RectF i = new RectF();
  private RectF j = new RectF();
  private int p;
  private String q;
  private String r;
  private String s;
  private int t;
  private int u;
  private TextPaint v;
  private float w;
  private float x;
  private int y;
  private int z;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    a = AIOUtils.b(18.0F, localResources);
    c = AIOUtils.b(6.0F, localResources);
    int k = DisplayUtil.a();
    b = localResources.getDisplayMetrics().widthPixels - TextLayer.b - k * 2;
  }
  
  public RelaxedAfternoon(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    int k = 0;
    this.p = 0;
    this.q = "jenny";
    this.r = "05/09";
    this.s = "by";
    this.t = 0;
    this.u = 0;
    this.A = 0;
    this.g = 0;
    this.D = null;
    this.v = new TextPaint();
    this.v.setTypeface(Typeface.DEFAULT);
    this.v.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.v.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.v.setTypeface(paramTypeface);
    }
    this.v.setAntiAlias(true);
    this.v.setStyle(Paint.Style.FILL_AND_STROKE);
    this.v.setTextSkewX(-0.15F);
    this.A = AIOUtils.b(41.0F, BaseApplicationImpl.getContext().getResources());
    this.v.setTextSize(this.A);
    this.v.setColor(-1);
    this.v.setTextAlign(Paint.Align.LEFT);
    this.t = AIOUtils.b(34.0F, BaseApplicationImpl.getContext().getResources());
    this.u = AIOUtils.b(45.0F, BaseApplicationImpl.getContext().getResources());
    this.B = AIOUtils.b(4.0F, BaseApplicationImpl.getContext().getResources());
    this.C = AIOUtils.b(3.0F, BaseApplicationImpl.getContext().getResources());
    this.f = new TextDrawImplement(0);
    this.f.a(new PathDrawBackground(-1, this.B, this.C));
    this.h = new TextPaint();
    this.h.setTextSkewX(-0.15F);
    if (paramTypeface != null) {
      this.h.setTypeface(paramTypeface);
    }
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.FILL_AND_STROKE);
    this.z = AIOUtils.b(19.0F, BaseApplicationImpl.getContext().getResources());
    this.h.setTextSize(this.z);
    this.h.setColor(-16777216);
    TextPaint localTextPaint = new TextPaint();
    if (paramTypeface != null) {
      localTextPaint.setTypeface(paramTypeface);
    }
    this.r = InfoStickerUtils.a();
    localTextPaint.setAntiAlias(true);
    localTextPaint.setTextSkewX(-0.15F);
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.y = AIOUtils.b(23.0F, BaseApplicationImpl.getContext().getResources());
    localTextPaint.setTextSize(this.y);
    localTextPaint.setColor(-1);
    this.e = new TextDrawImplement(0);
    this.e.a(new PathDrawBackground(-16777216, this.B, this.C));
    this.e.a(this.r, b, this.y, localTextPaint);
    if (paramList == null) {
      paramInt = 0;
    } else {
      paramInt = paramList.size();
    }
    while (k < paramInt)
    {
      a(k, (String)paramList.get(k));
      k += 1;
    }
  }
  
  private boolean a(float paramFloat1, float paramFloat2, RectF paramRectF, PointF paramPointF)
  {
    if (paramRectF != null)
    {
      if (paramPointF == null) {
        return false;
      }
      paramRectF = new RectF(paramRectF.left + paramPointF.x, paramRectF.top + paramPointF.y, paramRectF.right + paramPointF.x, paramRectF.bottom + paramPointF.y);
      if ((paramFloat1 > paramRectF.left) && (paramFloat1 < paramRectF.right) && (paramFloat2 > paramRectF.top) && (paramFloat2 < paramRectF.bottom)) {
        return true;
      }
    }
    return false;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / c();
    RectF localRectF1 = new RectF(this.j.left * f1, this.j.top * f1, this.j.right * f1, this.j.bottom * f1);
    RectF localRectF2 = new RectF(this.i.left * f1, this.i.top * f1, this.i.right * f1, this.i.bottom * f1);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 1;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 0;
    }
    return -1;
  }
  
  public int a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramTextItem != null) {
      return paramGestureHelper.a(paramTextItem, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - c()) / 2.0F, (paramFloat2 - d()) / 2.0F);
    if (a(f1, f2, this.j, paramMotionEvent)) {
      return 1;
    }
    if (a(f1, f2, this.i, paramMotionEvent)) {
      return 0;
    }
    return -1;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= b()) {
        return;
      }
      super.a(paramInt, paramString);
      Object localObject = super.c(paramInt);
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = "　　";
      }
      this.p = AIOUtils.b(18.0F, BaseApplicationImpl.getContext().getResources());
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString);
        paramString = ((StringBuilder)localObject).toString();
        this.d = new TextDrawImplement(0);
        this.d.a(new PathDrawBackground(-16777216, this.B, this.C));
        this.d.a(paramString, b, this.A, this.v);
        this.w = Math.max(this.d.a(), this.e.a());
        this.w = Math.max(this.f.a(), this.w);
        this.x = (this.d.b() + this.t + this.e.b() + this.u + this.f.b());
        return;
      }
      if (paramString.length() > 18) {
        this.q = paramString.substring(0, 18);
      } else {
        this.q = paramString;
      }
      paramString = this.f;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append("\n");
      ((StringBuilder)localObject).append(this.q);
      paramString.a(((StringBuilder)localObject).toString(), b, this.z, this.h);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.g = 0;
    this.d.a(paramCanvas, 0, this.g);
    this.g = ((int)(this.g + this.d.b()));
    this.g += this.t;
    this.e.a(paramCanvas, 0, this.g);
    this.g = ((int)(this.g + this.e.b()));
    this.g += this.u;
    this.f.a(paramCanvas, 0, this.g);
    RectF localRectF;
    if (super.f(1))
    {
      localRectF = this.j;
      TextDrawImplement localTextDrawImplement = this.f;
      localRectF.set(localTextDrawImplement.a(2, localTextDrawImplement.c()));
      localRectF = this.j;
      localRectF.top += this.g;
      localRectF = this.j;
      localRectF.bottom += this.g;
      paramCanvas.drawRoundRect(this.j, 6.0F, 6.0F, s());
    }
    this.g = ((int)(this.g + this.f.b()));
    if (super.f(0))
    {
      this.j.left = 0.0F;
      localRectF = this.i;
      localRectF.top = 0.0F;
      localRectF.right = this.d.a();
      this.i.bottom = this.d.b();
      paramCanvas.drawRoundRect(this.i, 6.0F, 6.0F, s());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 2;
  }
  
  public float c()
  {
    return this.w;
  }
  
  public float d()
  {
    return this.x;
  }
  
  public InputFilter f()
  {
    if (this.D == null) {
      this.D = new RelaxedAfternoon.1(this, 20);
    }
    return this.D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.RelaxedAfternoon
 * JD-Core Version:    0.7.0.1
 */