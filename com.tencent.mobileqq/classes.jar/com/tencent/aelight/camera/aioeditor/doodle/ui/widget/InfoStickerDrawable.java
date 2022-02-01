package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public abstract class InfoStickerDrawable
  extends Drawable
{
  public static final int m = a(1.0F, MobileQQ.getContext().getResources());
  private InfoStickerDrawable.AnimationListener a = null;
  protected AnimStateTypeEvaluator f = new AnimStateTypeEvaluator();
  protected ArrayList<Integer> g = null;
  protected Context h = null;
  protected String i = null;
  protected int j = 0;
  protected ValueAnimator k;
  protected Bitmap l = null;
  
  public InfoStickerDrawable(Context paramContext, String paramString)
  {
    this.i = paramString;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  protected int a(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > paramInt1))
    {
      paramArrayList = (Integer)paramArrayList.get(paramInt1);
      if (paramArrayList != null) {
        return paramArrayList.intValue();
      }
    }
    return paramInt2;
  }
  
  public Bitmap a(long paramLong)
  {
    Bitmap localBitmap = i();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.f.a(paramLong);
    if (localArrayList != null) {
      a(localCanvas, localArrayList);
    }
    return localBitmap;
  }
  
  protected abstract void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList);
  
  public abstract String[] a(String paramString);
  
  protected abstract void b();
  
  public void draw(Canvas paramCanvas)
  {
    ArrayList localArrayList = this.g;
    if (localArrayList != null) {
      a(paramCanvas, localArrayList);
    }
  }
  
  protected void e()
  {
    AnimStateTypeEvaluator localAnimStateTypeEvaluator = this.f;
    this.k = ValueAnimator.ofObject(localAnimStateTypeEvaluator, new Object[] { localAnimStateTypeEvaluator.b(), this.f.a() });
    this.k.setInterpolator(new DecelerateInterpolator());
    this.k.addUpdateListener(new InfoStickerDrawable.1(this));
    this.k.addListener(new InfoStickerDrawable.2(this));
    this.k.setDuration(this.f.c());
    this.k.start();
  }
  
  public int f()
  {
    return this.j;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public Bitmap h()
  {
    return a(this.f.c());
  }
  
  protected Bitmap i()
  {
    Bitmap localBitmap = this.l;
    if (localBitmap == null) {
      this.l = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      new Canvas(localBitmap).drawColor(0, PorterDuff.Mode.CLEAR);
    }
    return this.l;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */