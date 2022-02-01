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
  private static final AccelerateDecelerateInterpolator a = new AccelerateDecelerateInterpolator();
  private static ActivityOptions r;
  private static Map<String, String> s;
  private static final Property<ImageView, Matrix> t = new TransitionAnimHelper.4(Matrix.class, "animatedTransform");
  private FrameLayout b;
  private View c;
  private TransAnimState d;
  private ITransAnimInitImpl e;
  private Rect f;
  private ImageView g;
  private ImageView h;
  private TransitionAnimHelper.TransAnimParam i;
  private File j;
  private String k;
  private int l;
  private int m;
  private ImageView.ScaleType n;
  private int o;
  private int p;
  private AnimatorSet q;
  
  public TransitionAnimHelper(Bundle paramBundle, ITransAnimInitImpl paramITransAnimInitImpl)
  {
    if (paramBundle != null)
    {
      if (paramITransAnimInitImpl == null) {
        return;
      }
      this.e = paramITransAnimInitImpl;
      b(paramBundle);
      d();
      f();
      g();
      i();
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
        if (s == null) {
          s = new HashMap();
        }
        s.clear();
        s.put(str, localObject2);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (Build.VERSION.SDK_INT >= 16) {
            r = ActivityOptions.makeScaleUpAnimation(paramURLImageView, 0, 0, paramURLImageView.getWidth(), paramURLImageView.getHeight());
          } else {
            r = null;
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
    r = null;
    return localIntent;
  }
  
  public static Matrix a(ImageView paramImageView)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getImageMatrix, imageView ");
    ((StringBuilder)localObject1).append(paramImageView);
    QLog.d("TransitionAnimHelper", 4, ((StringBuilder)localObject1).toString());
    int i1 = paramImageView.getLeft();
    int i2 = paramImageView.getTop();
    int i3 = paramImageView.getRight();
    int i4 = paramImageView.getBottom();
    localObject1 = new Rect(i1, i2, i3, i4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getImageMatrix, left");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(",top:");
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append(",right:");
    ((StringBuilder)localObject2).append(i3);
    ((StringBuilder)localObject2).append(",bottom:");
    ((StringBuilder)localObject2).append(i4);
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
      i1 = ((Drawable)localObject2).getIntrinsicWidth();
      i2 = ((Drawable)localObject2).getIntrinsicHeight();
      if ((i1 > 0) && (i2 > 0))
      {
        float f1 = ((Rect)localObject1).width() / i1;
        float f2 = ((Rect)localObject1).height() / i2;
        paramImageView = new Matrix();
        paramImageView.setScale(f1, f2);
        return paramImageView;
      }
      return null;
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  public static String a(String paramString)
  {
    Map localMap = s;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      return (String)s.get(paramString);
    }
    return "";
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = this.d;
    if (localObject1 != null) {
      ((TransAnimState)localObject1).a(2);
    }
    localObject1 = PropertyValuesHolder.ofInt("left", new int[] { this.g.getLeft(), paramInt1 });
    Object localObject2 = PropertyValuesHolder.ofInt("top", new int[] { this.g.getTop(), paramInt2 });
    Object localObject3 = PropertyValuesHolder.ofInt("right", new int[] { this.g.getRight(), paramInt1 + paramInt3 });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("bottom", new int[] { this.g.getBottom(), paramInt2 + paramInt4 });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.g, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localPropertyValuesHolder });
    ((ObjectAnimator)localObject1).addListener(new TransitionAnimHelper.2(this, paramInt4, paramInt3, paramInt1, paramInt2));
    localObject2 = a(this.g);
    localObject3 = a(this.h);
    this.g.setScaleType(ImageView.ScaleType.MATRIX);
    localObject2 = ObjectAnimator.ofObject(this.g, t, new TransitionAnimHelper.MatrixEvaluator(), new Matrix[] { localObject2, localObject3 });
    localObject3 = ObjectAnimator.ofInt(this.c, "backgroundColor", new int[] { -1, 16777215 });
    ((ValueAnimator)localObject3).setEvaluator(new ArgbEvaluator());
    this.q = new AnimatorSet();
    this.q.setDuration(200L);
    this.q.setInterpolator(a);
    this.q.addListener(new TransitionAnimHelper.3(this));
    this.q.playTogether(new Animator[] { localObject1, localObject2, localObject3 });
    this.q.start();
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
  
  @RequiresApi(api=16)
  public static Bundle b()
  {
    Bundle localBundle = new Bundle();
    ActivityOptions localActivityOptions = r;
    if (localActivityOptions != null)
    {
      localBundle = localActivityOptions.toBundle();
      r = null;
    }
    return localBundle;
  }
  
  private void b(Bundle paramBundle)
  {
    this.d = new TransAnimState();
    this.f = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.i = new TransitionAnimHelper.TransAnimParam();
    this.i.a(str);
    this.k = this.i.a;
    this.j = new File(this.k);
    this.l = this.i.b;
    this.m = this.i.c;
    this.n = ((ImageView.ScaleType)paramBundle.getSerializable("bundle_key_image_scale_type"));
    h();
    if (!e()) {
      this.d.c();
    }
  }
  
  private void d()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    this.b = new FrameLayout(BaseApplicationImpl.getContext());
    this.c = new View(BaseApplicationImpl.getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.b.addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.c.setBackgroundColor(-1);
  }
  
  private boolean e()
  {
    if (this.f == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(this.k)) && (this.j.isFile()))
    {
      if (!this.j.exists()) {
        return false;
      }
      if (this.l != 0)
      {
        if (this.m == 0) {
          return false;
        }
        if (this.n == null) {
          return false;
        }
        if (this.o != 0) {
          return this.p != 0;
        }
      }
    }
    return false;
  }
  
  private void f()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    localObject = this.b;
    if (localObject != null)
    {
      this.g = new ImageView(((FrameLayout)localObject).getContext());
      this.b.addView(this.g);
      localObject = (FrameLayout.LayoutParams)this.g.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = this.f.width();
      ((FrameLayout.LayoutParams)localObject).height = this.f.height();
      ((FrameLayout.LayoutParams)localObject).setMargins(this.f.left, this.f.top, 0, 0);
      this.g.setScaleType(this.n);
      this.g.setImageURI(Uri.fromFile(this.j));
    }
  }
  
  private void g()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    localObject = this.b;
    if (localObject != null)
    {
      this.h = new ImageView(((FrameLayout)localObject).getContext());
      this.b.addView(this.h);
      this.h.setVisibility(4);
      localObject = new FrameLayout.LayoutParams(this.o, this.p);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      ((FrameLayout.LayoutParams)localObject).topMargin = this.e.h();
      this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.h.setScaleType(this.n);
    this.h.setImageURI(Uri.fromFile(this.j));
    localObject = this.d;
    if (localObject != null) {
      ((TransAnimState)localObject).a(1);
    }
  }
  
  private void h()
  {
    int[] arrayOfInt = this.e.a(this.l, this.m);
    if ((arrayOfInt != null) && (arrayOfInt.length == 2))
    {
      this.o = arrayOfInt[0];
      this.p = arrayOfInt[1];
    }
  }
  
  private void i()
  {
    Object localObject = this.d;
    if ((localObject != null) && (((TransAnimState)localObject).b()))
    {
      localObject = this.h;
      if (localObject != null) {
        ((ImageView)localObject).getViewTreeObserver().addOnPreDrawListener(new TransitionAnimHelper.1(this));
      }
      return;
    }
    QLog.d("TransitionAnimHelper", 1, "initImageEnterAnimation error!");
  }
  
  public void a(ITransAnimStateListener paramITransAnimStateListener)
  {
    TransAnimState localTransAnimState = this.d;
    if (localTransAnimState != null) {
      localTransAnimState.a(paramITransAnimStateListener);
    }
  }
  
  public FrameLayout c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.transition.TransitionAnimHelper
 * JD-Core Version:    0.7.0.1
 */