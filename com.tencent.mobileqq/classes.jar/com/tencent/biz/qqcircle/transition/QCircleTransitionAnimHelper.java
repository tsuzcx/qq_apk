package com.tencent.biz.qqcircle.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean.SourceRect;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;

public class QCircleTransitionAnimHelper
{
  private static Drawable n;
  private FrameLayout a;
  private TransAnimState b;
  private Rect c;
  private Rect d;
  private QCircleTransitionImageView e;
  private QCircleTransitionImageView f;
  private File g;
  private String h;
  private int i;
  private int j;
  private ImageView.ScaleType k;
  private int l;
  private int m;
  
  public QCircleTransitionAnimHelper(QCircleLayerBean paramQCircleLayerBean)
  {
    if (paramQCircleLayerBean == null) {
      return;
    }
    b(paramQCircleLayerBean);
    d();
    f();
    g();
    i();
  }
  
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2, QCircleLayerBean paramQCircleLayerBean)
  {
    QCircleLayerBean localQCircleLayerBean2 = paramQCircleLayerBean;
    if (paramQCircleLayerBean == null) {
      localQCircleLayerBean2 = new QCircleLayerBean();
    }
    if (a())
    {
      Object localObject2 = "";
      paramQCircleLayerBean = (QCircleLayerBean)localObject2;
      Object localObject1 = localObject2;
      QCircleLayerBean localQCircleLayerBean1;
      try
      {
        if ((paramImageView.getTag(HostUIHelper.getInstance().getHostResourceId("id", "qcircle_pic_tag_id")) instanceof String))
        {
          paramQCircleLayerBean = (QCircleLayerBean)localObject2;
          localObject1 = (String)paramImageView.getTag(HostUIHelper.getInstance().getHostResourceId("id", "qcircle_pic_tag_id"));
          paramQCircleLayerBean = (QCircleLayerBean)localObject2;
          localObject1 = QCircleFeedPicLoader.g().getPicLocalPath(new Option().setUrl((String)localObject1));
          paramQCircleLayerBean = (QCircleLayerBean)localObject1;
          n = paramImageView.getDrawable();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("generatePrams getImagePath error!");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.e("QCircleTransitionAnimHelper", 1, ((StringBuilder)localObject2).toString());
        localQCircleLayerBean1 = paramQCircleLayerBean;
      }
      if (!TextUtils.isEmpty(localQCircleLayerBean1))
      {
        paramQCircleLayerBean = new int[2];
        paramImageView.getLocationOnScreen(paramQCircleLayerBean);
        localQCircleLayerBean2.setSourceRect(new QCircleLayerBean.SourceRect(paramQCircleLayerBean[0], paramQCircleLayerBean[1], paramQCircleLayerBean[0] + paramImageView.getWidth(), paramQCircleLayerBean[1] + paramImageView.getHeight()));
        localQCircleLayerBean2.setImageUrl(localQCircleLayerBean1);
        localQCircleLayerBean2.setImageWidth(paramInt1);
        localQCircleLayerBean2.setImageHeight(paramInt2);
        localQCircleLayerBean2.setScaleType(paramImageView.getScaleType());
      }
    }
  }
  
  public static boolean a()
  {
    return QCircleConfigHelper.a("qqsubscribe", "secondaryEnableJumpDetailTransanimate", Integer.valueOf(1)).intValue() > 0;
  }
  
  public static boolean a(QCircleLayerBean paramQCircleLayerBean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQCircleLayerBean != null)
    {
      bool1 = bool2;
      if (paramQCircleLayerBean.getSourceRect() != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private int[] a(int paramInt1, int paramInt2)
  {
    float f1 = paramInt2 / paramInt1;
    paramInt1 = (int)(ImmersiveUtils.b() * f1);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = ImmersiveUtils.b();
    arrayOfInt[1] = paramInt1;
    paramInt1 = (int)((ImmersiveUtils.c() - paramInt1) / 2.0F);
    this.d = new Rect(0, paramInt1, arrayOfInt[0], arrayOfInt[1] + paramInt1);
    return arrayOfInt;
  }
  
  private void b(QCircleLayerBean paramQCircleLayerBean)
  {
    this.b = new TransAnimState();
    this.c = new Rect(paramQCircleLayerBean.getSourceRect().getLeft(), paramQCircleLayerBean.getSourceRect().getTop(), paramQCircleLayerBean.getSourceRect().getRight(), paramQCircleLayerBean.getSourceRect().getBottom());
    this.h = paramQCircleLayerBean.getImageUrl();
    this.g = new File(QCircleFeedPicLoader.g().getPicLocalPath(new Option().setUrl(this.h)));
    this.i = paramQCircleLayerBean.getImageWidth();
    this.j = paramQCircleLayerBean.getImageHeight();
    this.k = paramQCircleLayerBean.getScaleType();
    h();
    if (!e()) {
      this.b.c();
    }
  }
  
  public static Drawable c()
  {
    return n;
  }
  
  private void d()
  {
    TransAnimState localTransAnimState = this.b;
    if ((localTransAnimState != null) && (localTransAnimState.a())) {
      return;
    }
    this.a = new FrameLayout(QCircleApplication.APP);
    this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.a.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167060));
  }
  
  private boolean e()
  {
    if (this.c != null)
    {
      if (this.d == null) {
        return false;
      }
      if ((!TextUtils.isEmpty(this.h)) && (this.g.isFile()))
      {
        if (!this.g.exists()) {
          return false;
        }
        if (this.i != 0)
        {
          if (this.j == 0) {
            return false;
          }
          if (this.k == null) {
            return false;
          }
          if (this.l != 0)
          {
            if (this.m == 0) {
              return false;
            }
            return n != null;
          }
        }
      }
    }
    return false;
  }
  
  private void f()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    localObject = this.a;
    if (localObject != null)
    {
      this.e = new QCircleTransitionImageView(((FrameLayout)localObject).getContext());
      this.a.addView(this.e);
      localObject = (FrameLayout.LayoutParams)this.e.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = this.c.width();
      ((FrameLayout.LayoutParams)localObject).height = this.c.height();
      ((FrameLayout.LayoutParams)localObject).setMargins(this.c.left, this.c.top, 0, 0);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.e.setScaleType(this.k);
      this.e.setImageDrawable(n);
      this.e.setVisibility(4);
    }
  }
  
  private void g()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((TransAnimState)localObject).a())) {
      return;
    }
    localObject = this.a;
    if (localObject != null)
    {
      this.f = new QCircleTransitionImageView(((FrameLayout)localObject).getContext());
      this.f.setPadding(0, 0, 0, QCircleConstants.s);
      this.a.addView(this.f);
      this.f.setVisibility(4);
      localObject = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.f.setImageDrawable(n);
    }
    localObject = this.b;
    if (localObject != null) {
      ((TransAnimState)localObject).a(1);
    }
  }
  
  private void h()
  {
    int[] arrayOfInt = a(this.i, this.j);
    if (arrayOfInt.length == 2)
    {
      this.l = arrayOfInt[0];
      this.m = arrayOfInt[1];
    }
  }
  
  private void i()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((TransAnimState)localObject).b()))
    {
      localObject = this.f;
      if (localObject != null) {
        ((QCircleTransitionImageView)localObject).getViewTreeObserver().addOnPreDrawListener(new QCircleTransitionAnimHelper.1(this));
      }
      return;
    }
    QLog.d("QCircleTransitionAnimHelper", 1, "initImageEnterAnimation error!");
  }
  
  private void j()
  {
    this.a.setAlpha(1.0F);
    TransAnimState localTransAnimState = this.b;
    if (localTransAnimState != null) {
      localTransAnimState.a(2);
    }
    this.f.setVisibility(0);
    this.f.a(this.e.getInfo(), new QCircleTransitionAnimHelper.2(this));
  }
  
  public void a(Matrix paramMatrix, ImageView paramImageView, QCircleTransitionImageView.TranAnimListener paramTranAnimListener)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((TransAnimState)localObject).a(2);
    }
    QCircleTransitionImageView localQCircleTransitionImageView = this.e;
    if (localQCircleTransitionImageView != null)
    {
      localObject = this.f;
      if (localObject != null)
      {
        if (paramImageView == null)
        {
          paramImageView = (ImageView)localObject;
        }
        else
        {
          localQCircleTransitionImageView.setImageDrawable(paramImageView.getDrawable());
          this.f.setImageDrawable(paramImageView.getDrawable());
        }
        paramMatrix = QCircleTransitionImageView.a(paramMatrix, paramImageView);
        if (paramMatrix != null) {
          this.f.a(paramMatrix);
        }
        this.e.setVisibility(8);
        this.f.setVisibility(0);
        this.a.setAlpha(1.0F);
        this.a.setBackgroundColor(0);
        paramMatrix = this.e.getInfo();
        this.f.b(paramMatrix, new QCircleTransitionAnimHelper.3(this, paramTranAnimListener));
        return;
      }
    }
    if (paramTranAnimListener != null) {
      paramTranAnimListener.a();
    }
  }
  
  public void a(ITransAnimStateListener paramITransAnimStateListener)
  {
    TransAnimState localTransAnimState = this.b;
    if (localTransAnimState != null) {
      localTransAnimState.a(paramITransAnimStateListener);
    }
  }
  
  public FrameLayout b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionAnimHelper
 * JD-Core Version:    0.7.0.1
 */