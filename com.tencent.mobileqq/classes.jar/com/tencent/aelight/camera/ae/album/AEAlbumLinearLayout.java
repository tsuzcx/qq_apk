package com.tencent.aelight.camera.ae.album;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.log.AEQLog;

public class AEAlbumLinearLayout
  extends LinearLayout
  implements NestedScrollingParent
{
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private View jdField_a_of_type_AndroidViewView;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  private AEAlbumLinearLayout.ScrollListener jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private int c;
  private int d;
  private int e;
  
  public AEAlbumLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public AEAlbumLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 31	android/widget/LinearLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 33	com/tencent/aelight/camera/ae/album/AEAlbumLinearLayout:d	I
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 35	com/tencent/aelight/camera/ae/album/AEAlbumLinearLayout:e	I
    //   17: aload_1
    //   18: aload_2
    //   19: getstatic 40	com/tencent/aelight/camera/impl/R$styleable:a	[I
    //   22: invokevirtual 46	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   25: astore_1
    //   26: aload_0
    //   27: aload_1
    //   28: iconst_0
    //   29: iconst_0
    //   30: invokevirtual 52	android/content/res/TypedArray:getDimensionPixelSize	(II)I
    //   33: putfield 54	com/tencent/aelight/camera/ae/album/AEAlbumLinearLayout:jdField_a_of_type_Int	I
    //   36: aload_1
    //   37: invokevirtual 58	android/content/res/TypedArray:recycle	()V
    //   40: goto +19 -> 59
    //   43: astore_2
    //   44: goto +32 -> 76
    //   47: astore_2
    //   48: ldc 60
    //   50: ldc 62
    //   52: aload_2
    //   53: invokestatic 67	com/tencent/aelight/camera/log/AEQLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: goto -20 -> 36
    //   59: aload_0
    //   60: iconst_1
    //   61: invokevirtual 71	com/tencent/aelight/camera/ae/album/AEAlbumLinearLayout:setOrientation	(I)V
    //   64: aload_0
    //   65: new 73	android/view/animation/AccelerateDecelerateInterpolator
    //   68: dup
    //   69: invokespecial 75	android/view/animation/AccelerateDecelerateInterpolator:<init>	()V
    //   72: putfield 77	com/tencent/aelight/camera/ae/album/AEAlbumLinearLayout:jdField_a_of_type_AndroidViewAnimationInterpolator	Landroid/view/animation/Interpolator;
    //   75: return
    //   76: aload_1
    //   77: invokevirtual 58	android/content/res/TypedArray:recycle	()V
    //   80: goto +5 -> 85
    //   83: aload_2
    //   84: athrow
    //   85: goto -2 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	AEAlbumLinearLayout
    //   0	88	1	paramContext	Context
    //   0	88	2	paramAttributeSet	AttributeSet
    //   0	88	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   26	36	43	finally
    //   48	56	43	finally
    //   26	36	47	java/lang/Exception
  }
  
  private float a()
  {
    return getScrollY() * 1.0F / this.c;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == 1) {
      return b();
    }
    if (paramInt == 2) {
      return a();
    }
    return false;
  }
  
  private void c()
  {
    int i = this.c / 2;
    if ((getScrollY() > 0) && (getScrollY() < i))
    {
      b();
      return;
    }
    if ((i <= getScrollY()) && (getScrollY() < this.c)) {
      a();
    }
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_a_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AEAlbumLinearLayout.1(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new AEAlbumLinearLayout.2(this));
      return;
    }
    localValueAnimator.cancel();
  }
  
  public void a()
  {
    AEQLog.a("AEAlbumLinearLayout", "[collapsePreviewContainer]");
    int i = getScrollY();
    int j = this.c;
    if (i >= j)
    {
      AEQLog.a("AEAlbumLinearLayout", "[collapsePreviewContainer], already collapsed");
      return;
    }
    this.e = 1;
    i = j - getScrollY();
    j = (int)(i * 1.0F / this.c * 275.0F);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[collapsePreviewContainer], dy=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", duration=");
    ((StringBuilder)localObject).append(j);
    AEQLog.a("AEAlbumLinearLayout", ((StringBuilder)localObject).toString());
    d();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { getScrollY(), this.c });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(j);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener;
    if (localObject != null) {
      ((AEAlbumLinearLayout.ScrollListener)localObject).a(false);
    }
  }
  
  public boolean a()
  {
    return getScrollY() == 0;
  }
  
  public void b()
  {
    AEQLog.a("AEAlbumLinearLayout", "[expandPreviewContainer]");
    if (getScrollY() <= 0)
    {
      AEQLog.a("AEAlbumLinearLayout", "[expandPreviewContainer], already expanded");
      return;
    }
    this.e = 2;
    int i = -getScrollY();
    int j = (int)(getScrollY() * 1.0F / this.c * 275.0F);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[expandPreviewContainer], dy=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", duration=");
    ((StringBuilder)localObject).append(j);
    AEQLog.a("AEAlbumLinearLayout", ((StringBuilder)localObject).toString());
    d();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { getScrollY(), 0 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(j);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener;
    if (localObject != null) {
      ((AEAlbumLinearLayout.ScrollListener)localObject).a(true);
    }
  }
  
  public boolean b()
  {
    return getScrollY() == this.c;
  }
  
  public int getNestedScrollAxes()
  {
    AEQLog.a("AEAlbumLinearLayout", "[getNestedScrollAxes]");
    return 2;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidViewView = getChildAt(0);
    this.jdField_b_of_type_AndroidViewView = getChildAt(1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    paramInt1 = this.jdField_b_of_type_Int;
    paramInt2 = this.jdField_a_of_type_Int;
    if ((paramInt1 < paramInt2) || (paramInt2 == 0)) {
      this.jdField_a_of_type_Int = (this.jdField_b_of_type_Int / 3);
    }
    this.c = (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView.getLayoutParams().height = (getMeasuredHeight() - this.jdField_a_of_type_Int);
    setMeasuredDimension(getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + this.jdField_b_of_type_AndroidViewView.getMeasuredHeight());
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedFling], velocityX=");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(", velocityY=");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(", consumed=");
    localStringBuilder.append(paramBoolean);
    AEQLog.a("AEAlbumLinearLayout", localStringBuilder.toString());
    return super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView = new StringBuilder();
    paramView.append("[onNestedPreFling], velocityX=");
    paramView.append(paramFloat1);
    paramView.append(", velocityY=");
    paramView.append(paramFloat2);
    AEQLog.a("AEAlbumLinearLayout", paramView.toString());
    if ((paramFloat2 > 0.0F) && (getScrollY() < this.c))
    {
      a();
      this.jdField_a_of_type_Boolean = true;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedPreScroll], dy=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", scrollY=");
    localStringBuilder.append(getScrollY());
    AEQLog.a("AEAlbumLinearLayout", localStringBuilder.toString());
    int j = 1;
    if ((paramInt2 > 0) && (getScrollY() < this.c)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    int i;
    if ((paramInt2 < 0) && (getScrollY() > 0) && (!ViewCompat.canScrollVertically(paramView, -1))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramInt1 != 0) || (i != 0))
    {
      if (paramInt1 != 0) {
        paramInt2 = Math.min(paramInt2, this.c - getScrollY());
      } else {
        paramInt2 = Math.max(paramInt2, -getScrollY());
      }
      scrollBy(0, paramInt2);
      paramArrayOfInt[1] = paramInt2;
      if (paramInt1 != 0) {
        paramInt1 = j;
      } else {
        paramInt1 = 2;
      }
      this.d = paramInt1;
      paramView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener;
      if (paramView != null)
      {
        paramView.a(this.d);
        this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener.b(a());
      }
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedScroll], dxConsumed=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", dyConsumed=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", dxUnconsumed=");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", dyUnconsumed=");
    localStringBuilder.append(paramInt4);
    AEQLog.a("AEAlbumLinearLayout", localStringBuilder.toString());
    super.onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener;
    if (paramView != null) {
      paramView.b(a());
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNestedScrollAccepted], axes=");
    localStringBuilder.append(paramInt);
    AEQLog.a("AEAlbumLinearLayout", localStringBuilder.toString());
    super.onNestedScrollAccepted(paramView1, paramView2, paramInt);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    paramView1 = new StringBuilder();
    paramView1.append("[onStartNestedScroll], nestedScrollAxes=");
    paramView1.append(paramInt);
    AEQLog.a("AEAlbumLinearLayout", paramView1.toString());
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onStopNestedScroll], scrollY=");
    localStringBuilder.append(getScrollY());
    AEQLog.a("AEAlbumLinearLayout", localStringBuilder.toString());
    super.onStopNestedScroll(paramView);
    if (!this.jdField_a_of_type_Boolean) {
      c();
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener;
    if (paramView != null)
    {
      int i = this.d;
      paramView.a(i, a(i));
    }
    this.d = 0;
  }
  
  public void setScrollListener(@Nullable AEAlbumLinearLayout.ScrollListener paramScrollListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumAEAlbumLinearLayout$ScrollListener = paramScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout
 * JD-Core Version:    0.7.0.1
 */