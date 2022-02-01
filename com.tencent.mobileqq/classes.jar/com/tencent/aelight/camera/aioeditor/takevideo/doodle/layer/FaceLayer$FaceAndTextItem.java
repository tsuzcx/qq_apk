package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.qphone.base.util.QLog;

public final class FaceLayer$FaceAndTextItem
  extends FaceLayer.FaceItem
{
  public final String a = "...";
  public int b;
  public int c;
  public String d;
  public String e;
  public StaticLayout f;
  public int g;
  public Path h = new Path();
  public int i;
  public boolean j;
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt);
    this.b = paramLayerParams.j;
    this.c = paramLayerParams.i;
    a(paramLayerParams.h);
    this.s = true;
  }
  
  public FaceLayer$FaceAndTextItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt1);
    this.r = paramInt2;
  }
  
  public void a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    localValueAnimator.setDuration(1000L);
    localValueAnimator.setRepeatCount(2);
    localValueAnimator.setRepeatMode(2);
    localValueAnimator.addUpdateListener(new FaceLayer.FaceAndTextItem.1(this));
    localValueAnimator.addListener(new FaceLayer.FaceAndTextItem.2(this));
    localValueAnimator.start();
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.k.m.b(this));
    DisplayUtil.a();
    paramCanvas.translate(-this.G / 2.0F, -this.H / 2.0F);
    if (this.f.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.g);
    }
    this.l.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.m.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.k.e.setTextSize(this.b);
    this.k.e.setColor(this.c);
    this.f.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, 10.0F);
    if (this.j)
    {
      this.k.h.setAlpha(this.i);
      paramCanvas.drawPath(this.h, this.k.h);
    }
    paramCanvas.restore();
    paramCanvas.translate(0.0F, this.f.getHeight() + 32);
    this.k.l.setBounds(0, 0, (int)this.G, 6);
    this.k.l.draw(paramCanvas);
    paramCanvas.restore();
    if (this.M)
    {
      paramCanvas.save();
      int m;
      if (this.O == 0) {
        m = 2130845995;
      } else {
        m = 2130845994;
      }
      if (!this.U.isDataLocked()) {
        if (this.O == 0) {
          m = 2130846003;
        } else {
          m = 2130846001;
        }
      }
      int n;
      if (this.O == 1) {
        n = 2130845993;
      } else {
        n = 2130845992;
      }
      int i1;
      if (this.O == 2) {
        i1 = 2130846000;
      } else {
        i1 = 2130845999;
      }
      DisplayUtil.a(paramCanvas, this.k.m, this, m, n, i1);
      paramCanvas.restore();
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    float f2 = this.G;
    float f1 = this.H;
    if (f2 * this.B < 200.0F) {
      f2 = this.B;
    }
    if (f1 * this.B < 200.0F) {
      f1 = this.B;
    }
    paramCanvas.save();
    paramCanvas.translate(-this.G / 2.0F, -this.H / 2.0F);
    if (this.f.getLineCount() == 1) {
      paramCanvas.translate(0.0F, this.g);
    }
    this.l.draw(paramCanvas);
    paramCanvas.translate(0.0F, this.m.height());
    paramCanvas.save();
    paramCanvas.translate(6.0F, 16.0F);
    this.k.e.setTextSize(this.b);
    this.k.e.setColor(this.c);
    this.f.draw(paramCanvas);
    paramCanvas.restore();
    if (paramBoolean)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 10.0F);
      if (this.j)
      {
        this.k.h.setAlpha(this.i);
        paramCanvas.drawPath(this.h, this.k.h);
      }
      paramCanvas.restore();
    }
    paramCanvas.translate(0.0F, this.f.getHeight() + 32);
    this.k.l.setBounds(0, 0, (int)this.G, 6);
    this.k.l.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.u = paramTroopBarPOI;
    if (paramTroopBarPOI != null)
    {
      a(paramTroopBarPOI.b());
      this.v = System.currentTimeMillis();
      return;
    }
    a(null);
    this.v = -1L;
  }
  
  public void a(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.e(FaceLayer.a, "text is empty.");
      localObject = "";
    }
    paramString = FaceLayer.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("text:");
    localStringBuilder.append((String)localObject);
    SLog.b(paramString, localStringBuilder.toString());
    this.e = ((String)localObject);
    this.d = ((String)localObject);
    int n = (int)(this.G - 12.0F);
    int m = n;
    if (n < 0)
    {
      QLog.d(FaceLayer.a, 2, "faceItem setText width < 0");
      m = 0;
    }
    this.k.e.setTextSize(this.b);
    this.f = new StaticLayout(this.e, this.k.e, m, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    if (this.f.getLineCount() > 2)
    {
      n = this.f.getLineEnd(1);
      paramString = this.e.substring(0, n);
      localObject = FaceLayer.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("subString : ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" -> ");
      localStringBuilder.append(paramString);
      SLog.b((String)localObject, localStringBuilder.toString());
      this.e = paramString;
      n = this.e.length() - 1;
      paramString = new StringBuilder();
      paramString.append(this.e);
      paramString.append("...");
      this.e = paramString.toString();
      for (this.f = new StaticLayout(this.e, this.k.e, m, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false); (n > 0) && (this.f.getLineCount() > 2); this.f = new StaticLayout(this.e, this.k.e, m, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false))
      {
        paramString = new StringBuilder();
        paramString.append(this.e.substring(0, n));
        paramString.append("...");
        paramString = paramString.toString();
        n -= 1;
        localObject = FaceLayer.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete last char : ");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(paramString);
        SLog.b((String)localObject, localStringBuilder.toString());
        this.e = paramString;
      }
      if (n == 0)
      {
        paramString = FaceLayer.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("text size is too large :");
        ((StringBuilder)localObject).append(this.b);
        SLog.e(paramString, ((StringBuilder)localObject).toString());
      }
    }
    paramString = FaceLayer.a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("final text : ");
    ((StringBuilder)localObject).append(this.e);
    ((StringBuilder)localObject).append(" , original text : ");
    ((StringBuilder)localObject).append(this.d);
    SLog.b(paramString, ((StringBuilder)localObject).toString());
    paramString = new Rect();
    this.f.getLineBounds(0, paramString);
    this.g = paramString.height();
    this.h.reset();
    this.h.addRoundRect(new RectF(0.0F, 0.0F, this.G, this.f.getHeight() + 12), 4.0F, 4.0F, Path.Direction.CCW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceAndTextItem
 * JD-Core Version:    0.7.0.1
 */