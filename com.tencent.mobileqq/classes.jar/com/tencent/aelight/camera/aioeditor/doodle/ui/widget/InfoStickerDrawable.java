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
  public static final int g = a(1.0F, MobileQQ.getContext().getResources());
  protected ValueAnimator a;
  protected Context a;
  protected AnimStateTypeEvaluator a;
  private InfoStickerDrawable.AnimationListener a;
  protected String a;
  protected ArrayList<Integer> a;
  protected Bitmap b = null;
  protected int f = 0;
  
  public InfoStickerDrawable(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator = new AnimStateTypeEvaluator();
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetInfoStickerDrawable$AnimationListener = null;
    this.jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public int a()
  {
    return this.f;
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
  
  public Bitmap a()
  {
    return a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a());
  }
  
  public Bitmap a(long paramLong)
  {
    Bitmap localBitmap = b();
    Canvas localCanvas = new Canvas(localBitmap);
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a(paramLong);
    if (localArrayList != null) {
      a(localCanvas, localArrayList);
    }
    return localBitmap;
  }
  
  protected abstract void a(Canvas paramCanvas, ArrayList<Integer> paramArrayList);
  
  public abstract String[] a(String paramString);
  
  protected Bitmap b()
  {
    Bitmap localBitmap = this.b;
    if (localBitmap == null) {
      this.b = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    } else {
      new Canvas(localBitmap).drawColor(0, PorterDuff.Mode.CLEAR);
    }
    return this.b;
  }
  
  protected abstract void b();
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void c()
  {
    AnimStateTypeEvaluator localAnimStateTypeEvaluator = this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator;
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofObject(localAnimStateTypeEvaluator, new Object[] { localAnimStateTypeEvaluator.b(), this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a() });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new InfoStickerDrawable.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new InfoStickerDrawable.2(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiWidgetAnimStateTypeEvaluator.a());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void draw(Canvas paramCanvas)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      a(paramCanvas, localArrayList);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable
 * JD-Core Version:    0.7.0.1
 */