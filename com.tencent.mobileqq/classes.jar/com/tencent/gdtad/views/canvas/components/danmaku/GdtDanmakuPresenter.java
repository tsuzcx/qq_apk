package com.tencent.gdtad.views.canvas.components.danmaku;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.Pools.SimplePool;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

public class GdtDanmakuPresenter
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int = 2;
  private Context jdField_a_of_type_AndroidContentContext;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Pools.SimplePool<GdtDanmakuItemView> jdField_a_of_type_AndroidSupportV4UtilPools$SimplePool;
  private GdtDanmakuModel jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuModel = new GdtDanmakuModel();
  private String jdField_a_of_type_JavaLangString = "#FFFFFFFF";
  private boolean jdField_a_of_type_Boolean;
  private GdtDanmakuPresenter.DanmakuRunnable[] jdField_a_of_type_ArrayOfComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter$DanmakuRunnable;
  private int jdField_b_of_type_Int = 10;
  private String jdField_b_of_type_JavaLangString = "#993C3C3C";
  private int c = 20;
  private int d = 14;
  private int e = 10;
  private int f = 10;
  private int g = -1;
  
  public GdtDanmakuPresenter(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GdtDanmakuPresenter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private GdtDanmakuItemView a()
  {
    Object localObject2 = (GdtDanmakuItemView)this.jdField_a_of_type_AndroidSupportV4UtilPools$SimplePool.acquire();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new GdtDanmakuItemView(this.jdField_a_of_type_AndroidContentContext);
    }
    ((GdtDanmakuItemView)localObject1).setTextSize(this.d);
    ((GdtDanmakuItemView)localObject1).setClickable(false);
    localObject2 = (GradientDrawable)((GdtDanmakuItemView)localObject1).getBackground();
    ((GradientDrawable)localObject2).setColor(Color.parseColor(this.jdField_b_of_type_JavaLangString));
    if (Build.VERSION.SDK_INT >= 16) {
      ((GdtDanmakuItemView)localObject1).setBackground((Drawable)localObject2);
    } else {
      ((GdtDanmakuItemView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    }
    ((GdtDanmakuItemView)localObject1).setTextColor(Color.parseColor(this.jdField_a_of_type_JavaLangString));
    String str = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuModel.a();
    localObject2 = str;
    if (str.length() > this.e)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str.substring(0, this.e));
      ((StringBuilder)localObject2).append("...");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    ((GdtDanmakuItemView)localObject1).setText((CharSequence)localObject2);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    ((GdtDanmakuItemView)localObject1).measure(i, i);
    i = ((GdtDanmakuItemView)localObject1).getMeasuredWidth();
    int j = AdUIUtils.dp2px(this.g, getResources());
    localObject2 = ObjectAnimator.ofFloat(localObject1, "translationX", new float[] { AdUIUtils.dp2px(this.g, getResources()), -i });
    ((ObjectAnimator)localObject2).setInterpolator(new LinearInterpolator());
    ((ObjectAnimator)localObject2).addListener(new GdtDanmakuPresenter.1(this, (GdtDanmakuItemView)localObject1));
    ((ObjectAnimator)localObject2).setDuration((int)(AdUIUtils.px2dp(getContext(), j + i) / this.jdField_a_of_type_Float));
    ((GdtDanmakuItemView)localObject1).a((ObjectAnimator)localObject2);
    return localObject1;
  }
  
  private void a(GdtDanmakuItemView paramGdtDanmakuItemView)
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4UtilPools$SimplePool.release(paramGdtDanmakuItemView);
      return;
    }
    catch (IllegalStateException paramGdtDanmakuItemView) {}
  }
  
  private void b()
  {
    GdtDanmakuPresenter.DanmakuRunnable[] arrayOfDanmakuRunnable = this.jdField_a_of_type_ArrayOfComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter$DanmakuRunnable;
    if (arrayOfDanmakuRunnable != null)
    {
      int j = arrayOfDanmakuRunnable.length;
      int i = 0;
      while (i < j)
      {
        GdtDanmakuPresenter.DanmakuRunnable localDanmakuRunnable = arrayOfDanmakuRunnable[i];
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localDanmakuRunnable);
        i += 1;
      }
    }
    removeAllViews();
    clearDisappearingChildren();
  }
  
  public GdtDanmakuPresenter a(int paramInt, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuModel.a(paramArrayOfString);
    this.g = AdUIUtils.px2dp(getContext(), paramInt);
    return this;
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_Boolean = false;
    GdtDanmakuModel localGdtDanmakuModel = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuModel;
    if (localGdtDanmakuModel != null) {
      localGdtDanmakuModel.a();
    }
    AdLog.i("GdtDanmakuPresenter", "danmaku is stopped");
  }
  
  public boolean a()
  {
    b();
    int j = 0;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuModel.a()) {
      return false;
    }
    if (this.g == -1) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidSupportV4UtilPools$SimplePool == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilPools$SimplePool = new Pools.SimplePool(this.f);
    }
    GdtDanmakuPresenter.DanmakuRunnable[] arrayOfDanmakuRunnable = this.jdField_a_of_type_ArrayOfComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter$DanmakuRunnable;
    if (arrayOfDanmakuRunnable != null)
    {
      int k = arrayOfDanmakuRunnable.length;
      i = 0;
      while (i < k)
      {
        GdtDanmakuPresenter.DanmakuRunnable localDanmakuRunnable = arrayOfDanmakuRunnable[i];
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localDanmakuRunnable);
        i += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter$DanmakuRunnable = new GdtDanmakuPresenter.DanmakuRunnable[this.jdField_a_of_type_Int];
    int i = j;
    while (i < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ArrayOfComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter$DanmakuRunnable[i] = new GdtDanmakuPresenter.DanmakuRunnable(this, i);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ArrayOfComTencentGdtadViewsCanvasComponentsDanmakuGdtDanmakuPresenter$DanmakuRunnable[i], i * 600);
      i += 1;
    }
    this.jdField_a_of_type_Boolean = true;
    AdLog.i("GdtDanmakuPresenter", "danmaku start");
    return true;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter
 * JD-Core Version:    0.7.0.1
 */