package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.doodle.IDoodleMsgLayout;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ResInfo;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleMsgLayout
  extends BaseDoodleMsgLayout
  implements GifDrawable.OnGIFPlayOnceListener, DoodleMsgViewListener, IDoodleMsgLayout, ResCallback
{
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DoodleMsgLayout.PendingData jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData = new DoodleMsgLayout.PendingData(this);
  private DoodleMsgView jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<DoodleMsgLayoutListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  
  public DoodleMsgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  private Bitmap a()
  {
    Bitmap localBitmap;
    if (GlobalImageCache.a != null) {
      localBitmap = (Bitmap)GlobalImageCache.a.get("aio_doodle_progress");
    } else {
      localBitmap = null;
    }
    if ((localBitmap == null) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      ThreadManager.post(new DoodleMsgLayout.2(this), 5, null, true);
    }
    return localBitmap;
  }
  
  private Drawable a()
  {
    return BaseURLDrawableHelper.getFailedDrawable();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4)
    {
      a(1, paramBoolean);
      a(2, paramBoolean);
      a(3, paramBoolean);
      return;
    }
    URLImageView localURLImageView = null;
    if (paramInt == 1) {
      localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    } else if (paramInt == 2) {
      localURLImageView = this.jdField_b_of_type_ComTencentImageURLImageView;
    } else if (paramInt == 3) {
      localURLImageView = this.jdField_c_of_type_ComTencentImageURLImageView;
    }
    if (localURLImageView != null)
    {
      if (!paramBoolean)
      {
        localURLImageView.setVisibility(8);
        return;
      }
      if (this.jdField_b_of_type_Int > 0)
      {
        localURLImageView.setVisibility(0);
        return;
      }
      localURLImageView.setVisibility(4);
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject;
    if (paramInt > 0)
    {
      this.jdField_b_of_type_Boolean = false;
      localObject = DoodleResHelper.a().a(1, paramInt, true);
      if (localObject != null)
      {
        localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
        if (localURLImageView != null)
        {
          localURLImageView.setImageDrawable((Drawable)localObject);
          ((URLDrawable)localObject).setIndividualPause(true);
        }
      }
      localObject = DoodleResHelper.a().a(2, paramInt, false);
      URLImageView localURLImageView = this.jdField_c_of_type_ComTencentImageURLImageView;
      if ((localURLImageView != null) && (localObject != null))
      {
        localURLImageView.setImageDrawable((Drawable)localObject);
        ((URLDrawable)localObject).startDownload();
      }
      localObject = DoodleResHelper.a().a(2, paramInt, true);
      localURLImageView = this.jdField_b_of_type_ComTencentImageURLImageView;
      if ((localURLImageView != null) && (localObject != null))
      {
        localURLImageView.setImageDrawable((Drawable)localObject);
        ((URLDrawable)localObject).startDownload();
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localObject != null) {
        ((URLImageView)localObject).setImageDrawable(null);
      }
      localObject = this.jdField_c_of_type_ComTencentImageURLImageView;
      if (localObject != null) {
        ((URLImageView)localObject).setImageDrawable(null);
      }
      localObject = this.jdField_b_of_type_ComTencentImageURLImageView;
      if (localObject != null) {
        ((URLImageView)localObject).setImageDrawable(null);
      }
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeStateUI:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          a(1, false);
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
          if (localObject != null) {
            ((DoodleMsgView)localObject).setVisibility(0);
          }
          if (this.jdField_b_of_type_Boolean)
          {
            a(3, false);
            a(2, true);
          }
        }
        else
        {
          a(1, false);
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
          if (localObject != null)
          {
            ((DoodleMsgView)localObject).setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.c();
          }
          a(3, true);
          a(2, false);
        }
      }
      else
      {
        a(1, true);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
        if (localObject != null) {
          ((DoodleMsgView)localObject).setVisibility(4);
        }
        a(2, false);
        a(3, false);
      }
    }
    else
    {
      a(4, false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
      if (localObject != null) {
        ((DoodleMsgView)localObject).setVisibility(4);
      }
    }
  }
  
  private void h()
  {
    QLog.d("DoodleMsgLayout", 2, "init begin");
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = new DoodleMsgLayout.1(this);
    Object localObject = getResources().getDisplayMetrics();
    int i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int k = getResources().getDimensionPixelSize(2131296394);
    int m = getResources().getDimensionPixelSize(2131296396);
    int n = getResources().getDimensionPixelSize(2131296395);
    int i1 = getResources().getDimensionPixelSize(2131296393);
    this.jdField_d_of_type_Int = ((int)(i * 0.544F));
    i = this.jdField_d_of_type_Int;
    this.jdField_e_of_type_Int = ((int)(i * 1.0F / 1.133333F));
    i = i - k - n;
    int j = this.jdField_e_of_type_Int - i1 - m;
    float f1 = i;
    float f2 = j;
    if (1.0F * f1 / f2 > 1.133333F) {
      i = (int)(f2 * 1.133333F);
    } else {
      j = (int)(f1 / 1.133333F);
    }
    if (this.jdField_c_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
      addView(this.jdField_c_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
      a(3, false);
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
      addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      a(1, false);
    }
    if (this.jdField_b_of_type_ComTencentImageURLImageView == null)
    {
      this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
      addView(this.jdField_b_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
      a(2, false);
    }
    QLog.d("DoodleMsgLayout", 2, "brefor crate DoodleMsgView ");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView = new DoodleMsgView(getContext(), null);
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setBackgroundColor(getResources().getColor(2131167333));
      addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(this, i, j);
    }
    setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int));
  }
  
  private void i()
  {
    c(this.jdField_a_of_type_Int);
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_b_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_b_of_type_AndroidWidgetImageView.setClickable(false);
      addView(this.jdField_b_of_type_AndroidWidgetImageView);
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(Utils.a(19.0F, getResources()), Utils.a(19.0F, getResources()));
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
  }
  
  private void k()
  {
    DoodleMsgView localDoodleMsgView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localDoodleMsgView != null)
    {
      localDoodleMsgView.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView = null;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = null;
    this.jdField_c_of_type_ComTencentImageURLImageView = null;
    this.jdField_b_of_type_ComTencentImageURLImageView = null;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = null;
  }
  
  public int a()
  {
    DoodleMsgView localDoodleMsgView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    int j = 2;
    int i = j;
    if (localDoodleMsgView != null)
    {
      i = localDoodleMsgView.a();
      if (i != -1)
      {
        if (i != 0)
        {
          if ((i != 1) && (i != 2) && (i != 3)) {
            return 2;
          }
          int k = this.jdField_c_of_type_Int;
          if (k == 0) {}
          for (;;)
          {
            return 1;
            if (k == 2) {
              return 2;
            }
            i = j;
            if (k != 1) {
              break;
            }
          }
        }
        return this.jdField_c_of_type_Int;
      }
      i = -1;
    }
    return i;
  }
  
  public void a()
  {
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin");
    j();
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin 1");
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      if (((ImageView)localObject).getDrawable() == null)
      {
        localObject = a();
        if (localObject != null)
        {
          localObject = new PhotoProgressDrawable((Bitmap)localObject, 0, false);
          ((PhotoProgressDrawable)localObject).setBounds(new Rect(0, 0, Utils.a(19.0F, getResources()), Utils.a(19.0F, getResources())));
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
        else
        {
          QLog.d("DoodleMsgLayout", 2, "showLoadingStatus wait callback");
        }
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(4);
    }
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus end");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInitState:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" state:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = null;
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      localObject = (DoodleMsgLayoutListener)localWeakReference.get();
    }
    if ((paramInt != -1) && (paramInt != 4))
    {
      int i = this.jdField_c_of_type_Int;
      if (i != 2)
      {
        if ((paramInt == 0) && (i == 0))
        {
          if (this.jdField_a_of_type_Boolean) {
            c(3);
          } else {
            c(0);
          }
          if (localObject != null) {
            ((DoodleMsgLayoutListener)localObject).a(this, 0);
          }
          if (this.jdField_c_of_type_Boolean) {
            c();
          }
          return;
        }
        if (localObject != null) {
          ((DoodleMsgLayoutListener)localObject).a(this, 1);
        }
        QLog.i("DoodleMsgLayout", 2, "onLoadData end");
        return;
      }
    }
    c(0);
    this.jdField_c_of_type_Boolean = false;
    if ((paramInt != -1) && (localObject != null)) {
      ((DoodleMsgLayoutListener)localObject).a(this, 2);
    }
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if ((paramResInfo != null) && (paramView != null) && (paramInt1 == 2))
    {
      if (paramResInfo.jdField_b_of_type_Int != this.jdField_b_of_type_Int) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("handleMessage begin:");
        paramView.append(paramInt2);
        QLog.i("DoodleMsgLayout", 2, paramView.toString());
      }
      if (1 == paramInt2)
      {
        this.jdField_c_of_type_Int = 0;
        b(this.jdField_b_of_type_Int);
      }
      else if (4 == paramInt2)
      {
        this.jdField_c_of_type_Int = 1;
      }
      else
      {
        this.jdField_c_of_type_Int = 2;
      }
      paramInt1 = a();
      if (paramInt1 == 0)
      {
        if (this.jdField_a_of_type_Boolean) {
          c(3);
        } else {
          c(0);
        }
      }
      else if ((paramInt1 == 2) || (paramInt1 == -1)) {
        c(0);
      }
      paramView = null;
      paramResInfo = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (paramResInfo != null) {
        paramView = (DoodleMsgLayoutListener)paramResInfo.get();
      }
      if (paramView != null)
      {
        paramView.a(this, paramInt1);
        paramView = new StringBuilder();
        paramView.append("handleMessage end:");
        paramView.append(paramInt1);
        QLog.i("DoodleMsgLayout", 2, paramView.toString());
      }
      if ((paramInt1 == 0) && (this.jdField_c_of_type_Boolean)) {
        c();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("DoodleMsgLayout", 2, "showFailedStatus begin");
    j();
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    if (paramBoolean)
    {
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject != null) {
        ((RelativeLayout)localObject).setVisibility(4);
      }
      localObject = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageView.getDrawable() == null)
        {
          localObject = a();
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
    }
    QLog.d("DoodleMsgLayout", 2, "showFailedStatus end");
  }
  
  public boolean a()
  {
    return TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true;
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    return (paramView == this.jdField_b_of_type_ComTencentImageURLImageView) || (paramView == this.jdField_a_of_type_ComTencentImageURLImageView) || (paramView == this.jdField_c_of_type_ComTencentImageURLImageView) || (paramView == this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDoodleContent :");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" GifID:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" prepare:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      c(0);
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
      if (paramString != null)
      {
        paramString.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(null, false);
      }
      return false;
    }
    if (this.jdField_b_of_type_Int == i)
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equals(paramString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_b_of_type_Boolean = false;
        if (b())
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgLayout", 2, "setDoodleContent isplaying, return:");
          }
          return false;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setDoodleContent same data, prepare old:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
          QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
        }
        if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int == 2))
        {
          DoodleResHelper.a().b(1, this.jdField_b_of_type_Int, this, this);
          this.jdField_c_of_type_Int = 1;
        }
        this.jdField_a_of_type_Boolean = paramBoolean;
        c(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
        if (localObject != null) {
          ((DoodleMsgView)localObject).setContent(paramString, paramBoolean);
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDoodleContent old data:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" GifID:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(" prepare:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgLayout", 2, "pending data, return");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData;
      ((DoodleMsgLayout.PendingData)localObject).jdField_a_of_type_JavaLangString = paramString;
      ((DoodleMsgLayout.PendingData)localObject).jdField_a_of_type_Int = i;
      ((DoodleMsgLayout.PendingData)localObject).jdField_c_of_type_Boolean = paramBoolean;
      ((DoodleMsgLayout.PendingData)localObject).jdField_b_of_type_Boolean = true;
      c(0);
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
      if (paramString != null) {
        paramString.a(true);
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_b_of_type_Boolean = false;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localObject != null) {
      ((DoodleMsgView)localObject).a(false);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (i > 0)
    {
      if (i == this.jdField_b_of_type_Int)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("setDoodleContent use same template:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
          ((StringBuilder)localObject).append(" status:");
          ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
          ((StringBuilder)localObject).append("loopOK:");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
          QLog.d("DoodleMsgLayout", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.jdField_b_of_type_Int = i;
        this.jdField_c_of_type_Int = 1;
        this.jdField_b_of_type_Boolean = false;
        ThreadManager.post(new DoodleMsgLayout.3(this, this.jdField_b_of_type_Int), 5, null, true);
      }
    }
    else
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      b(i);
    }
    c(0);
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localObject != null) {
      ((DoodleMsgView)localObject).setContent(paramString, paramBoolean);
    }
    return true;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject != null) {
      ((RelativeLayout)localObject).setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_a_of_type_Boolean = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localObject != null) {
      ((DoodleMsgView)localObject).a(paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_b_of_type_Boolean)
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_c_of_type_Boolean))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
          if (localObject != null) {
            a(((DoodleMsgView)localObject).a());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData.jdField_b_of_type_Boolean = false;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$PendingData;
      ((DoodleMsgLayout.PendingData)localObject).jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      ((DoodleMsgLayout.PendingData)localObject).jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
      ((DoodleMsgLayout.PendingData)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((DoodleMsgLayout.PendingData)localObject).jdField_b_of_type_Boolean = true;
    }
  }
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    return (i != 0) && (i != 3);
  }
  
  public void c()
  {
    if (a() != 0)
    {
      this.jdField_c_of_type_Boolean = true;
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if ((i != 0) || (i != 3)) {
      d();
    }
    this.jdField_c_of_type_Boolean = false;
    Object localObject;
    if (this.jdField_b_of_type_Int > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
      if (localObject != null)
      {
        localObject = ((URLImageView)localObject).getDrawable();
        if ((localObject != null) && ((localObject instanceof URLDrawable)))
        {
          localObject = (URLDrawable)localObject;
          Drawable localDrawable = ((URLDrawable)localObject).getCurrDrawable();
          if ((localDrawable instanceof GifDrawable)) {
            ((GifDrawable)localDrawable).getImage().reset();
          }
          ((URLDrawable)localObject).setIndividualPause(false);
          c(1);
          return;
        }
        c(0);
        ThreadManager.post(new DoodleMsgLayout.4(this), 5, null, true);
      }
    }
    else
    {
      c(2);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
      if (localObject != null) {
        ((DoodleMsgView)localObject).a(0L);
      }
    }
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = false;
    c(3);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localObject != null) {
      ((DoodleMsgView)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject != null) {
      ((URLImageView)localObject).setImageDrawable(null);
    }
    localObject = this.jdField_c_of_type_ComTencentImageURLImageView;
    if (localObject != null) {
      ((URLImageView)localObject).setImageDrawable(null);
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int != 0))
    {
      DoodleResHelper.a().b(1, this.jdField_b_of_type_Int, this, this);
      this.jdField_c_of_type_Int = 1;
    }
    DoodleMsgView localDoodleMsgView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localDoodleMsgView != null) {
      localDoodleMsgView.b();
    }
  }
  
  public void f() {}
  
  public void g()
  {
    c(3);
    Object localObject = this.jdField_b_of_type_ComTencentImageURLImageView;
    if (localObject != null)
    {
      localObject = ((URLImageView)localObject).getDrawable();
      if ((localObject instanceof URLDrawable))
      {
        localObject = (URLDrawable)localObject;
        ((URLDrawable)localObject).setIndividualPause(false);
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        if ((localObject instanceof GifDrawable)) {
          ((GifDrawable)localObject).getImage().reset();
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject != null)
    {
      localObject = ((URLImageView)localObject).getDrawable();
      if ((localObject instanceof URLDrawable)) {
        ((URLDrawable)localObject).setIndividualPause(false);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    k();
    super.onDetachedFromWindow();
    QLog.i("DoodleMsgLayout", 2, "onDetachedFromWindow");
  }
  
  public void onPlayOnce()
  {
    c(2);
    Object localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject != null)
    {
      localObject = ((URLImageView)localObject).getDrawable();
      if ((localObject != null) && ((localObject instanceof URLDrawable)))
      {
        localObject = (URLDrawable)localObject;
        ((URLDrawable)localObject).setIndividualPause(true);
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        if ((localObject instanceof GifDrawable)) {
          ((GifDrawable)localObject).getImage().reset();
        }
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localObject != null) {
      ((DoodleMsgView)localObject).a(100L);
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      return;
    }
    d();
  }
  
  public void setOperateListener(View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener, View.OnLongClickListener paramOnLongClickListener, DoodleMsgLayoutListener paramDoodleMsgLayoutListener)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localObject != null)
    {
      if (paramOnClickListener != null) {
        ((DoodleMsgView)localObject).setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject != null)
    {
      if (paramOnClickListener != null) {
        ((URLImageView)localObject).setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    localObject = this.jdField_c_of_type_ComTencentImageURLImageView;
    if (localObject != null)
    {
      if (paramOnClickListener != null) {
        ((URLImageView)localObject).setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDoodleMsgLayoutListener);
  }
  
  public void setTalkBack(String paramString)
  {
    DoodleMsgView localDoodleMsgView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
    if (localDoodleMsgView != null) {
      localDoodleMsgView.setContentDescription(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout
 * JD-Core Version:    0.7.0.1
 */