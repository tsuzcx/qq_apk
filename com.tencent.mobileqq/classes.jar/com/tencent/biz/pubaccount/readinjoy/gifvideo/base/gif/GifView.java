package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;
import omr;
import owp;
import owq;

public class GifView
  extends FrameLayout
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  
  public GifView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
    c();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
    c();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 1;
    c();
  }
  
  private static Drawable a()
  {
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841297);
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    AtomicLong localAtomicLong1 = new AtomicLong(0L);
    AtomicLong localAtomicLong2 = new AtomicLong(0L);
    long l = System.currentTimeMillis();
    AtomicLong localAtomicLong3 = new AtomicLong(l);
    AtomicLong localAtomicLong4 = new AtomicLong(0L);
    paramURLDrawable.setDownloadListener(new owp(this, localAtomicLong3, localAtomicLong1, l, localAtomicLong2, localAtomicLong4, paramURLDrawable));
    paramURLDrawable.setURLDrawableListener(new owq(this, l, localAtomicLong3, localAtomicLong1, localAtomicLong4, localAtomicLong2, paramURLDrawable));
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_Int <= 2;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentContext = getContext();
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = new KandianUrlImageView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, -1, -1);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void e()
  {
    a(this.jdField_b_of_type_Int >> this.jdField_a_of_type_Int, this.c >> this.jdField_a_of_type_Int);
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(4);
  }
  
  public void a()
  {
    a(-1, -1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = a();
      if ((paramInt2 > 0) && (paramInt1 > 0))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      }
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1) {
        f();
      }
      a((URLDrawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getVisibility() != 0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setAlpha(1.0F);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    b();
  }
  
  public void setCoverUrl(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) {}
    try
    {
      omr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, new URL(this.jdField_b_of_type_JavaLangString), getContext());
      d();
      return;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        QLog.d("gifvideo.GifView", 2, paramString.getMessage());
      }
    }
  }
  
  public void setGifHeight(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setGifUrl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  public void setGifWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setIsBigImg(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setScaleType(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(paramInt, ImageView.ScaleType.CENTER_CROP));
    }
    if (this.jdField_a_of_type_ComTencentImageURLImageView != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(paramInt, ImageView.ScaleType.CENTER_CROP));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView
 * JD-Core Version:    0.7.0.1
 */