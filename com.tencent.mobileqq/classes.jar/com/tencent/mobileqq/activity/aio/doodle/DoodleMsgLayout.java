package com.tencent.mobileqq.activity.aio.doodle;

import agej;
import agpg;
import agph;
import agpi;
import agpm;
import agpy;
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
import bbxu;
import beyq;
import bjae;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class DoodleMsgLayout
  extends RelativeLayout
  implements agpm, bbxu, GifDrawable.OnGIFPlayOnceListener
{
  private int jdField_a_of_type_Int = 0;
  private agpi jdField_a_of_type_Agpi = new agpi(this);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DoodleMsgView jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<agph> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private URLImageView jdField_c_of_type_ComTencentImageURLImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  
  public DoodleMsgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  private Bitmap a()
  {
    if (BaseApplicationImpl.sImageCache != null) {}
    for (Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get("aio_doodle_progress");; localBitmap = null)
    {
      if ((localBitmap == null) && (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_d_of_type_Boolean = true;
        ThreadManager.post(new DoodleMsgLayout.2(this), 5, null, true);
      }
      return localBitmap;
    }
  }
  
  private Drawable a()
  {
    return beyq.a();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4)
    {
      a(1, paramBoolean);
      a(2, paramBoolean);
      a(3, paramBoolean);
    }
    URLImageView localURLImageView;
    for (;;)
    {
      return;
      localURLImageView = null;
      if (paramInt == 1) {
        localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
      }
      while (localURLImageView != null)
      {
        if (paramBoolean) {
          break label77;
        }
        localURLImageView.setVisibility(8);
        return;
        if (paramInt == 2) {
          localURLImageView = this.jdField_b_of_type_ComTencentImageURLImageView;
        } else if (paramInt == 3) {
          localURLImageView = this.jdField_c_of_type_ComTencentImageURLImageView;
        }
      }
    }
    label77:
    if (this.jdField_b_of_type_Int > 0)
    {
      localURLImageView.setVisibility(0);
      return;
    }
    localURLImageView.setVisibility(4);
  }
  
  private void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_b_of_type_Boolean = false;
      Drawable localDrawable = agpy.a().a(1, paramInt, true);
      if ((localDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
        ((URLDrawable)localDrawable).setIndividualPause(true);
      }
      localDrawable = agpy.a().a(2, paramInt, false);
      if ((this.jdField_c_of_type_ComTencentImageURLImageView != null) && (localDrawable != null))
      {
        this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
        ((URLDrawable)localDrawable).startDownload();
      }
      localDrawable = agpy.a().a(2, paramInt, true);
      if ((this.jdField_b_of_type_ComTencentImageURLImageView != null) && (localDrawable != null))
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(localDrawable);
        ((URLDrawable)localDrawable).startDownload();
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    if (this.jdField_c_of_type_ComTencentImageURLImageView != null) {
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    if (this.jdField_b_of_type_ComTencentImageURLImageView != null) {
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "changeStateUI:" + this.jdField_a_of_type_JavaLangString + " state:" + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        a(4, false);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(4);
      return;
      a(1, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(4);
      }
      a(2, false);
      a(3, false);
      return;
      a(1, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.c();
      }
      a(3, true);
      a(2, false);
      return;
      a(1, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(0);
      }
    } while (!this.jdField_b_of_type_Boolean);
    a(3, false);
    a(2, true);
  }
  
  private void h()
  {
    QLog.d("DoodleMsgLayout", 2, "init begin");
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = new agpg(this);
    Object localObject = getResources().getDisplayMetrics();
    int i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int k = getResources().getDimensionPixelSize(2131296346);
    int m = getResources().getDimensionPixelSize(2131296348);
    int n = getResources().getDimensionPixelSize(2131296347);
    int i1 = getResources().getDimensionPixelSize(2131296345);
    this.jdField_d_of_type_Int = ((int)(i * 0.544F));
    this.e = ((int)(this.jdField_d_of_type_Int * 1.0F / 1.133333F));
    int j = this.jdField_d_of_type_Int - k - n;
    i = this.e - i1 - m;
    if (j * 1.0F / i > 1.133333F) {
      j = (int)(i * 1.133333F);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_c_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        addView(this.jdField_c_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
        a(3, false);
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        addView(this.jdField_a_of_type_ComTencentImageURLImageView, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
        a(1, false);
      }
      if (this.jdField_b_of_type_ComTencentImageURLImageView == null)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
        localObject = new RelativeLayout.LayoutParams(j, i);
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
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setBackgroundColor(getResources().getColor(2131167247));
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(this, j, i);
      }
      setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_d_of_type_Int, this.e));
      return;
      i = (int)(j / 1.133333F);
    }
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
      localLayoutParams = new RelativeLayout.LayoutParams(agej.a(19.0F, getResources()), agej.a(19.0F, getResources()));
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView = null;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = null;
    this.jdField_c_of_type_ComTencentImageURLImageView = null;
    this.jdField_b_of_type_ComTencentImageURLImageView = null;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = null;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a())
      {
      }
    }
    do
    {
      return 2;
      return -1;
      return this.jdField_c_of_type_Int;
      if (this.jdField_c_of_type_Int == 0) {
        return 1;
      }
    } while ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int != 1));
    return 1;
  }
  
  public void a()
  {
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin");
    j();
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin 1");
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      if (this.jdField_a_of_type_AndroidWidgetImageView.getDrawable() == null)
      {
        Object localObject = a();
        if (localObject == null) {
          break label149;
        }
        localObject = new bjae((Bitmap)localObject, 0, false);
        ((bjae)localObject).setBounds(new Rect(0, 0, agej.a(19.0F, getResources()), agej.a(19.0F, getResources())));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      QLog.d("DoodleMsgLayout", 2, "showLoadingStatus end");
      return;
      label149:
      QLog.d("DoodleMsgLayout", 2, "showLoadingStatus wait callback");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "onInitState:" + this.jdField_a_of_type_JavaLangString + " state:" + paramInt);
    }
    agph localagph = null;
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      localagph = (agph)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    if ((paramInt == -1) || (paramInt == 4) || (this.jdField_c_of_type_Int == 2))
    {
      c(0);
      this.jdField_c_of_type_Boolean = false;
      if ((paramInt != -1) && (localagph != null)) {
        localagph.a(this, 2);
      }
      return;
    }
    if ((paramInt == 0) && (this.jdField_c_of_type_Int == 0))
    {
      if (this.jdField_a_of_type_Boolean) {
        c(3);
      }
      for (;;)
      {
        if (localagph != null) {
          localagph.a(this, 0);
        }
        if (!this.jdField_c_of_type_Boolean) {
          break;
        }
        c();
        return;
        c(0);
      }
    }
    if (localagph != null) {
      localagph.a(this, 1);
    }
    QLog.i("DoodleMsgLayout", 2, "onLoadData end");
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if ((paramResInfo == null) || (paramView == null) || (paramInt1 != 2) || (paramResInfo.sourceId != this.jdField_b_of_type_Int)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoodleMsgLayout", 2, "handleMessage begin:" + paramInt2);
    }
    if (1 == paramInt2)
    {
      this.jdField_c_of_type_Int = 0;
      b(this.jdField_b_of_type_Int);
      label77:
      paramInt1 = a();
      if (paramInt1 != 0) {
        break label202;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label194;
      }
      c(3);
    }
    for (;;)
    {
      paramView = null;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        paramView = (agph)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
      if (paramView != null)
      {
        paramView.a(this, paramInt1);
        QLog.i("DoodleMsgLayout", 2, "handleMessage end:" + paramInt1);
      }
      if ((paramInt1 != 0) || (!this.jdField_c_of_type_Boolean)) {
        break;
      }
      c();
      return;
      if (4 == paramInt2)
      {
        this.jdField_c_of_type_Int = 1;
        break label77;
      }
      this.jdField_c_of_type_Int = 2;
      break label77;
      label194:
      c(0);
      continue;
      label202:
      if ((paramInt1 == 2) || (paramInt1 == -1)) {
        c(0);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("DoodleMsgLayout", 2, "showFailedStatus begin");
    j();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (paramBoolean)
    {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
    }
    for (;;)
    {
      QLog.d("DoodleMsgLayout", 2, "showFailedStatus end");
      return;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      }
      if (this.jdField_b_of_type_AndroidWidgetImageView != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_b_of_type_AndroidWidgetImageView.getDrawable() == null)
        {
          Drawable localDrawable = a();
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(View paramView)
  {
    if (paramView == null) {}
    while ((paramView != this.jdField_b_of_type_ComTencentImageURLImageView) && (paramView != this.jdField_a_of_type_ComTencentImageURLImageView) && (paramView != this.jdField_c_of_type_ComTencentImageURLImageView) && (paramView != this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView)) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "setDoodleContent :" + paramString + " GifID:" + paramInt + " prepare:" + paramBoolean);
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      c(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(null, false);
      }
    }
    do
    {
      return false;
      if ((this.jdField_b_of_type_Int != i) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(paramString))) {
        break label277;
      }
      this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean = false;
      if (!b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent isplaying, return:");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "setDoodleContent same data, prepare old:" + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int == 2))
    {
      agpy.a().b(1, this.jdField_b_of_type_Int, this, this);
      this.jdField_c_of_type_Int = 1;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    c(0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(paramString, paramBoolean);
    }
    return true;
    label277:
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "setDoodleContent old data:" + this.jdField_a_of_type_JavaLangString + " GifID:" + this.jdField_b_of_type_Int + " prepare:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Agpi.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgLayout", 2, "pending data, return");
      }
      this.jdField_a_of_type_Agpi.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Agpi.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Agpi.jdField_c_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean = true;
      c(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(true);
      }
      return true;
    }
    this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(false);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (i > 0) {
      if (i == this.jdField_b_of_type_Int) {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleMsgLayout", 2, "setDoodleContent use same template:" + this.jdField_b_of_type_Int + " status:" + this.jdField_c_of_type_Int + "loopOK:" + this.jdField_b_of_type_Boolean);
        }
      }
    }
    for (;;)
    {
      c(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(paramString, paramBoolean);
      }
      return true;
      this.jdField_b_of_type_Int = i;
      this.jdField_c_of_type_Int = 1;
      this.jdField_b_of_type_Boolean = false;
      ThreadManager.post(new DoodleMsgLayout.3(this, this.jdField_b_of_type_Int), 5, null, true);
      continue;
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      b(i);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Agpi.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean)
      {
        if ((!a(this.jdField_a_of_type_Agpi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Agpi.jdField_a_of_type_Int, this.jdField_a_of_type_Agpi.jdField_c_of_type_Boolean)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)) {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a());
        }
        this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean = false;
      }
      return;
    }
    this.jdField_a_of_type_Agpi.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Agpi.jdField_c_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Agpi.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Agpi.jdField_b_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_Int != 3);
  }
  
  public void c()
  {
    if (a() != 0) {
      this.jdField_c_of_type_Boolean = true;
    }
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_Int != 0) || (this.jdField_a_of_type_Int != 3)) {
          d();
        }
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_b_of_type_Int <= 0) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentImageURLImageView == null);
      Drawable localDrawable1 = this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localDrawable1 != null) && ((localDrawable1 instanceof URLDrawable)))
      {
        Drawable localDrawable2 = ((URLDrawable)localDrawable1).getCurrDrawable();
        if ((localDrawable2 instanceof GifDrawable)) {
          ((GifDrawable)localDrawable2).getImage().reset();
        }
        ((URLDrawable)localDrawable1).setIndividualPause(false);
        c(1);
        return;
      }
      c(0);
      ThreadManager.post(new DoodleMsgLayout.4(this), 5, null, true);
      return;
      c(2);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(0L);
  }
  
  public void d()
  {
    this.jdField_c_of_type_Boolean = false;
    c(3);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.d();
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    if (this.jdField_c_of_type_ComTencentImageURLImageView != null) {
      this.jdField_c_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int != 0))
    {
      agpy.a().b(1, this.jdField_b_of_type_Int, this, this);
      this.jdField_c_of_type_Int = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.b();
    }
  }
  
  public void f() {}
  
  public void g()
  {
    c(3);
    Drawable localDrawable;
    if (this.jdField_b_of_type_ComTencentImageURLImageView != null)
    {
      localDrawable = this.jdField_b_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable))
      {
        ((URLDrawable)localDrawable).setIndividualPause(false);
        localDrawable = ((URLDrawable)localDrawable).getCurrDrawable();
        if ((localDrawable instanceof GifDrawable)) {
          ((GifDrawable)localDrawable).getImage().reset();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      localDrawable = this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        ((URLDrawable)localDrawable).setIndividualPause(false);
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
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)))
      {
        ((URLDrawable)localDrawable).setIndividualPause(true);
        localDrawable = ((URLDrawable)localDrawable).getCurrDrawable();
        if ((localDrawable instanceof GifDrawable)) {
          ((GifDrawable)localDrawable).getImage().reset();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(100L);
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
  
  public void setOperateListener(View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener, View.OnLongClickListener paramOnLongClickListener, agph paramagph)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
    {
      if (paramOnClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null)
    {
      if (paramOnClickListener != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    if (this.jdField_c_of_type_ComTencentImageURLImageView != null)
    {
      if (paramOnClickListener != null) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_c_of_type_ComTencentImageURLImageView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramagph);
  }
  
  public void setTalkBack(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContentDescription(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout
 * JD-Core Version:    0.7.0.1
 */