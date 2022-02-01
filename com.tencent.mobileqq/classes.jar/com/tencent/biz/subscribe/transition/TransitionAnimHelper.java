package com.tencent.biz.subscribe.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.subscribe.transition.inter.ITransAnimInitImpl;
import com.tencent.biz.subscribe.transition.inter.ITransAnimStateListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class TransitionAnimHelper
{
  private static ActivityOptions jdField_a_of_type_AndroidAppActivityOptions;
  private static final Property<ImageView, Matrix> jdField_a_of_type_AndroidUtilProperty = new TransitionAnimHelper.4(Matrix.class, "animatedTransform");
  private static final AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private int jdField_a_of_type_Int;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TransAnimState jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
  private TransitionAnimHelper.TransAnimParam jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper$TransAnimParam;
  private ITransAnimInitImpl jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimInitImpl;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c;
  private int d;
  
  public TransitionAnimHelper(Bundle paramBundle, ITransAnimInitImpl paramITransAnimInitImpl)
  {
    if (paramBundle != null)
    {
      if (paramITransAnimInitImpl == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimInitImpl = paramITransAnimInitImpl;
      a(paramBundle);
      a();
      b();
      c();
      e();
    }
  }
  
  public static Intent a(URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (a())
    {
      Object localObject1 = new Bundle();
      Object localObject2 = new int[2];
      paramURLImageView.getLocationInWindow((int[])localObject2);
      paramURLImageView.getLocationOnScreen((int[])localObject2);
      ((Bundle)localObject1).putParcelable("bundle_key_trans_anim_rect", new Rect(localObject2[0], localObject2[1], localObject2[0] + paramURLImageView.getWidth(), localObject2[1] + paramURLImageView.getHeight()));
      try
      {
        localObject2 = ((URLDrawable)paramURLImageView.getDrawable()).getFileInLocal().getPath();
        String str = ((URLDrawable)paramURLImageView.getDrawable()).getURL().toString();
        if (jdField_a_of_type_JavaUtilMap == null) {
          jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        jdField_a_of_type_JavaUtilMap.clear();
        jdField_a_of_type_JavaUtilMap.put(str, localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (Build.VERSION.SDK_INT >= 16) {
            jdField_a_of_type_AndroidAppActivityOptions = ActivityOptions.makeScaleUpAnimation(paramURLImageView, 0, 0, paramURLImageView.getWidth(), paramURLImageView.getHeight());
          } else {
            jdField_a_of_type_AndroidAppActivityOptions = null;
          }
          ((Bundle)localObject1).putString("bundle_key_source_image_param", new TransitionAnimHelper.TransAnimParam((String)localObject2, paramInt1, paramInt2).a());
          ((Bundle)localObject1).putSerializable("bundle_key_image_scale_type", paramURLImageView.getScaleType());
          localIntent.putExtra("bundle_key_parms_extra", (Bundle)localObject1);
          return localIntent;
        }
      }
      catch (Exception paramURLImageView)
      {
        paramURLImageView.printStackTrace();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("generatePrams getImagePath error!");
        ((StringBuilder)localObject1).append(paramURLImageView.toString());
        QLog.e("TransitionAnimHelper", 1, ((StringBuilder)localObject1).toString());
        return localIntent;
      }
    }
    jdField_a_of_type_AndroidAppActivityOptions = null;
    return localIntent;
  }
  
  public static Matrix a(ImageView paramImageView)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getImageMatrix, imageView ");
    ((StringBuilder)localObject1).append(paramImageView);
    QLog.d("TransitionAnimHelper", 4, ((StringBuilder)localObject1).toString());
    int i = paramImageView.getLeft();
    int j = paramImageView.getTop();
    int k = paramImageView.getRight();
    int m = paramImageView.getBottom();
    localObject1 = new Rect(i, j, k, m);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getImageMatrix, left");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(",top:");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(",right:");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append(",bottom:");
    ((StringBuilder)localObject2).append(m);
    QLog.d("TransitionAnimHelper", 4, ((StringBuilder)localObject2).toString());
    localObject2 = paramImageView.getDrawable();
    ImageView.ScaleType localScaleType = paramImageView.getScaleType();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getImageMatrix, scaleType ");
    localStringBuilder.append(localScaleType);
    QLog.d("TransitionAnimHelper", 4, localStringBuilder.toString());
    if (localScaleType == ImageView.ScaleType.FIT_XY)
    {
      paramImageView = paramImageView.getImageMatrix();
      if (!paramImageView.isIdentity()) {
        return new Matrix(paramImageView);
      }
      i = ((Drawable)localObject2).getIntrinsicWidth();
      j = ((Drawable)localObject2).getIntrinsicHeight();
      if ((i > 0) && (j > 0))
      {
        float f1 = ((Rect)localObject1).width() / i;
        float f2 = ((Rect)localObject1).height() / j;
        paramImageView = new Matrix();
        paramImageView.setScale(f1, f2);
        return paramImageView;
      }
      return null;
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  @RequiresApi(api=16)
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    ActivityOptions localActivityOptions = jdField_a_of_type_AndroidAppActivityOptions;
    if (localActivityOptions != null)
    {
      localBundle = localActivityOptions.toBundle();
      jdField_a_of_type_AndroidAppActivityOptions = null;
    }
    return localBundle;
  }
  
  public static String a(String paramString)
  {
    Map localMap = jdField_a_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return "";
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if (localObject1 != null) {
      ((TransAnimState)localObject1).a(2);
    }
    localObject1 = PropertyValuesHolder.ofInt("left", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getLeft(), paramInt1 });
    Object localObject2 = PropertyValuesHolder.ofInt("top", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getTop(), paramInt2 });
    Object localObject3 = PropertyValuesHolder.ofInt("right", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getRight(), paramInt1 + paramInt3 });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("bottom", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getBottom(), paramInt2 + paramInt4 });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localPropertyValuesHolder });
    ((ObjectAnimator)localObject1).addListener(new TransitionAnimHelper.2(this, paramInt4, paramInt3, paramInt1, paramInt2));
    localObject2 = a(this.jdField_a_of_type_AndroidWidgetImageView);
    localObject3 = a(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
    localObject2 = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidWidgetImageView, jdField_a_of_type_AndroidUtilProperty, new TransitionAnimHelper.MatrixEvaluator(), new Matrix[] { localObject2, localObject3 });
    localObject3 = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidViewView, "backgroundColor", new int[] { -1, 16777215 });
    ((ValueAnimator)localObject3).setEvaluator(new ArgbEvaluator());
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new TransitionAnimHelper.3(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject1, localObject2, localObject3 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState = new TransAnimState();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper$TransAnimParam = new TransitionAnimHelper.TransAnimParam();
    this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper$TransAnimParam.a(str);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper$TransAnimParam.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper$TransAnimParam.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransitionAnimHelper$TransAnimParam.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ((ImageView.ScaleType)paramBundle.getSerializable("bundle_key_image_scale_type"));
    d();
    if (!b()) {
      this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState.a();
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqsubscribe", "secondaryEnableJumpDetailTransanimate", 1) > 0;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.containsKey("bundle_key_trans_anim_rect");
    }
    return false;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(((FrameLayout)localObject).getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = this.jdField_a_of_type_AndroidGraphicsRect.width();
      ((FrameLayout.LayoutParams)localObject).height = this.jdField_a_of_type_AndroidGraphicsRect.height();
      ((FrameLayout.LayoutParams)localObject).setMargins(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, 0, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageURI(Uri.fromFile(this.jdField_a_of_type_JavaIoFile));
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaIoFile.isFile()))
    {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {
        return false;
      }
      if (this.jdField_a_of_type_Int != 0)
      {
        if (this.jdField_b_of_type_Int == 0) {
          return false;
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) {
          return false;
        }
        if (this.c != 0) {
          return this.d != 0;
        }
      }
    }
    return false;
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localObject != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(((FrameLayout)localObject).getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      localObject = new FrameLayout.LayoutParams(this.c, this.d);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      ((FrameLayout.LayoutParams)localObject).topMargin = this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimInitImpl.a();
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageURI(Uri.fromFile(this.jdField_a_of_type_JavaIoFile));
    localObject = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if (localObject != null) {
      ((TransAnimState)localObject).a(1);
    }
  }
  
  private void d()
  {
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentBizSubscribeTransitionInterITransAnimInitImpl.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if ((arrayOfInt != null) && (arrayOfInt.length == 2))
    {
      this.c = arrayOfInt[0];
      this.d = arrayOfInt[1];
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if ((localObject != null) && (((TransAnimState)localObject).b()))
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).getViewTreeObserver().addOnPreDrawListener(new TransitionAnimHelper.1(this));
      }
      return;
    }
    QLog.d("TransitionAnimHelper", 1, "initImageEnterAnimation error!");
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a(ITransAnimStateListener paramITransAnimStateListener)
  {
    TransAnimState localTransAnimState = this.jdField_a_of_type_ComTencentBizSubscribeTransitionTransAnimState;
    if (localTransAnimState != null) {
      localTransAnimState.a(paramITransAnimStateListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper
 * JD-Core Version:    0.7.0.1
 */