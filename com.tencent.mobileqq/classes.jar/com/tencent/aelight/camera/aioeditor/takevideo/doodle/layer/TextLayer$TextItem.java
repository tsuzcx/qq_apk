package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.capture.text.NormalTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

public class TextLayer$TextItem
  extends GestureHelper.ZoomItem
{
  Rect a;
  public float b;
  public DynamicTextItem c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public float k;
  public int l;
  
  public TextLayer$TextItem(TextLayer paramTextLayer)
  {
    this(paramTextLayer, new TextLayer.LayerParams(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    this.A.set(paramTextLayer.x);
    this.N = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public TextLayer$TextItem(TextLayer paramTextLayer, @NonNull TextLayer.LayerParams paramLayerParams)
  {
    super(paramLayerParams.a, paramLayerParams.b, paramLayerParams.c, paramLayerParams.d, paramLayerParams.e, paramLayerParams.f, paramLayerParams.g, true);
    this.c = new NormalTextItem();
    this.G = this.c.c();
    this.H = this.c.d();
    this.b = TextLayer.b;
    this.N = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public TextLayer$TextItem(TextLayer paramTextLayer, @NonNull TextItem paramTextItem)
  {
    super(paramTextItem, 1.0F);
    paramTextLayer = paramTextItem.a;
    if (paramTextLayer == null) {
      this.a = new Rect(0, 0, 0, 0);
    } else {
      this.a = new Rect(paramTextLayer);
    }
    this.c = paramTextItem.c;
    this.b = paramTextItem.b;
    this.d = paramTextItem.d;
    this.e = paramTextItem.e;
    this.f = paramTextItem.f;
    this.g = paramTextItem.g;
    this.h = paramTextItem.h;
    this.i = paramTextItem.i;
    this.j = paramTextItem.j;
    this.k = paramTextItem.k;
    this.N = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.save();
    int n;
    if (this.O == 0) {
      n = 2130845997;
    } else {
      n = 2130845996;
    }
    if (!this.U.isDataLocked()) {
      if (this.O == 0) {
        n = 2130846003;
      } else {
        n = 2130846001;
      }
    }
    int i2;
    if (this.O == 1) {
      i2 = 2130845993;
    } else {
      i2 = 2130845992;
    }
    int i1;
    if (this.O == 2) {
      i1 = 2130846000;
    } else {
      i1 = 2130845999;
    }
    if (this.V) {
      n = -1;
    }
    if (TextLayer.c(this.m).l.z())
    {
      n = -1;
      i1 = -1;
    }
    DisplayUtil.a(paramCanvas, this.m.m, this, n, i2, i1);
    paramCanvas.restore();
  }
  
  private void f()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(TextLayer.f);
    localValueAnimator.addUpdateListener(new TextLayer.TextItem.1(this));
    localValueAnimator.start();
  }
  
  private void g()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(TextLayer.f);
    localValueAnimator.addUpdateListener(new TextLayer.TextItem.2(this));
    localValueAnimator.start();
  }
  
  protected void a()
  {
    this.f = this.D;
    this.g = this.E;
    this.d = this.B;
    this.e = this.C;
    this.h = (this.m.p - this.A.x - this.f);
    this.i = (this.m.q - this.A.y - this.g);
    this.j = (1.0F - this.d);
    float f1 = this.e;
    if (f1 < 180.0F)
    {
      this.k = (0.0F - f1);
      return;
    }
    this.k = (360.0F - f1);
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.U.isInSegment(TextLayer.a(this.m).getTimeStamp())) && (!this.M)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.m.m.a(this, true));
    this.c.b(paramCanvas);
    paramCanvas.restore();
    if (this.M) {
      c(paramCanvas);
    }
  }
  
  public void b()
  {
    if (this.L == null)
    {
      this.L = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.L.setDuration(200L);
      this.L.setInterpolator(new LinearInterpolator());
      this.L.addUpdateListener(new TextLayer.TextItem.3(this));
      this.L.addListener(new TextLayer.TextItem.4(this));
    }
    if (!this.J) {
      this.L.start();
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    if ((!this.U.isInSegment(TextLayer.b(this.m).getTimeStamp())) && (!this.M)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.m.m.a(this, false));
    this.c.b(paramCanvas);
    paramCanvas.restore();
  }
  
  public void c()
  {
    if ((this.L != null) && (this.J)) {
      this.L.cancel();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
    {
      localStringBuilder.append("centerP x : ");
      localStringBuilder.append(this.A.x);
      localStringBuilder.append(" y: ");
      localStringBuilder.append(this.A.y);
    }
    localStringBuilder.append("textLeft: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("mSaveScaleValue: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("mSaveRotateValue: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("mSaveTranslateXValue: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("mDistanceX: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("mDistanceY: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("mDScale: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("mDRotate: ");
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem
 * JD-Core Version:    0.7.0.1
 */