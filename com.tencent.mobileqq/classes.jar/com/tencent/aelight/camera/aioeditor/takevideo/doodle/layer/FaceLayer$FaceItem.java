package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;

public class FaceLayer$FaceItem
  extends GestureHelper.ZoomItem
{
  public Drawable l;
  public RectF m;
  public final String n;
  public final String o;
  public final String p;
  public int q = 1;
  public int r = 0;
  public boolean s;
  public boolean t;
  public TroopBarPOI u;
  public long v = -1L;
  public String w;
  public int x;
  public int y;
  
  public FaceLayer$FaceItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramLayerParams.a, paramLayerParams.b, paramLayerParams.c, paramLayerParams.d, paramLayerParams.e, paramLayerParams.f, paramLayerParams.g, true);
    this.l = paramDrawable;
    this.n = paramString1;
    this.o = paramString2;
    this.p = paramString3;
    this.m = new RectF(paramDrawable.getBounds());
    this.s = false;
    this.y = paramInt;
  }
  
  public FaceLayer$FaceItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt1);
    this.r = paramInt2;
  }
  
  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i;
    if (this.O == 0) {
      i = 2130845995;
    } else {
      i = 2130845994;
    }
    if (!this.U.isDataLocked()) {
      if (this.O == 0) {
        i = 2130846003;
      } else {
        i = 2130846001;
      }
    }
    int k;
    if (this.O == 1) {
      k = 2130845993;
    } else {
      k = 2130845992;
    }
    int j;
    if (this.O == 2) {
      j = 2130846000;
    } else {
      j = 2130845999;
    }
    if (this.V) {
      i = -1;
    }
    if (FaceLayer.e(this.z).l.z())
    {
      i = -1;
      j = -1;
    }
    DisplayUtil.a(paramCanvas, this.z.m, this, i, k, j);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.U.isInSegment(FaceLayer.d(this.z).getTimeStamp())) && (!this.M)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.z.m.b(this));
    paramCanvas.translate(-this.G / 2.0F, -this.H / 2.0F);
    this.l.draw(paramCanvas);
    paramCanvas.restore();
    if (this.M) {
      b(paramCanvas);
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((!this.U.isInSegment(FaceLayer.f(this.z).getTimeStamp())) && (!this.M)) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(-this.G / 2.0F, -this.H / 2.0F);
    this.l.draw(paramCanvas);
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
    Drawable localDrawable = this.l;
    if (localDrawable != null)
    {
      if ((localDrawable instanceof InfoStickerDrawable))
      {
        this.l = InformationFaceConstant.a((InfoStickerDrawable)localDrawable, this.z.y, paramString);
        localDrawable = this.l;
        if (localDrawable != null) {
          this.w = ((InfoStickerDrawable)localDrawable).g();
        }
      }
      else if ((localDrawable instanceof BitmapDrawable))
      {
        this.l = InformationFaceConstant.a(this.w, this.z.y, paramString);
      }
      localDrawable = this.l;
      if (localDrawable == null) {
        return;
      }
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), this.l.getIntrinsicHeight());
      float f = this.A.x - this.B * this.l.getIntrinsicWidth() / 2.0F + this.D;
      if (f < ScreenUtil.dip2px(23.0F)) {
        this.A.x = (this.A.x - f + ScreenUtil.dip2px(23.0F));
      }
      this.l.setCallback(FaceLayer.g(this.z));
      this.m = new RectF(this.l.getBounds());
      this.G = this.l.getIntrinsicWidth();
      this.H = this.l.getIntrinsicHeight();
      ((PasterDataManager)QIMManager.a(4)).a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void b()
  {
    if (this.L == null)
    {
      this.L = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.L.setDuration(200L);
      this.L.setInterpolator(new LinearInterpolator());
      this.L.addUpdateListener(new FaceLayer.FaceItem.1(this));
      this.L.addListener(new FaceLayer.FaceItem.2(this));
    }
    if (!this.J) {
      this.L.start();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }
  
  public void c()
  {
    if ((this.L != null) && (this.J)) {
      this.L.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem
 * JD-Core Version:    0.7.0.1
 */