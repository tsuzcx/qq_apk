package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class SuperRichTextItem
  extends DynamicTextItem
{
  public static final int a;
  public static final int b;
  public static final int c;
  TextDrawImplement d;
  private RectF e = new RectF();
  private int f = 0;
  private boolean g = true;
  private TextPaint h = new TextPaint();
  private float i;
  private float j;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    a = AIOUtils.b(36.0F, localResources);
    c = AIOUtils.b(6.0F, localResources);
    int k = DisplayUtil.a();
    b = localResources.getDisplayMetrics().widthPixels - TextLayer.b - k * 2;
  }
  
  public SuperRichTextItem(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.h.setTypeface(Typeface.DEFAULT);
    this.h.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null) {
      this.h.setTypeface(Typeface.defaultFromStyle(1));
    } else {
      this.h.setTypeface(paramTypeface);
    }
    this.h.setAntiAlias(true);
    this.h.setStyle(Paint.Style.FILL_AND_STROKE);
    this.h.setTextSize(a);
    this.h.setColor(-1);
    this.h.setTextAlign(Paint.Align.LEFT);
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
    this.f = AIOUtils.b(18.0F, BaseApplicationImpl.getContext().getResources());
    this.d = new TextDrawImplement(0);
    this.d.b(new PerLineBackgoundDrawer(-65536, c));
    this.d.a(paramString, b, a, this.h);
    this.d.a(new LineMarginCoverter(this.f));
    paramString = this.d;
    this.i = paramString.a(1, paramString.c()).width();
    paramString = this.d;
    this.j = paramString.a(1, paramString.c()).height();
    this.d.a(new CenterMarginCoverter(this.i, this.j));
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.d.a(paramCanvas, 0, 0);
    if (super.f(0))
    {
      RectF localRectF = this.e;
      TextDrawImplement localTextDrawImplement = this.d;
      localRectF.set(localTextDrawImplement.a(1, localTextDrawImplement.c()));
      paramCanvas.drawRoundRect(this.e, 6.0F, 6.0F, s());
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
    return this.i;
  }
  
  public float d()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.SuperRichTextItem
 * JD-Core Version:    0.7.0.1
 */