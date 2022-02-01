package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicLong;
import pgk;
import psp;
import psq;

public class GifView
  extends FrameLayout
{
  private static final int MAXTRYCOUNTS = 2;
  private static final String TAG = "gifvideo.GifView";
  private static Drawable mLoadingDrawable;
  private Context mContext;
  private NativeReadInjoyImageView mCoverImageView;
  protected String mCoverUrl;
  private int mGifHeight;
  private URLImageView mGifImageView;
  private String mGifUrl;
  private int mGifWidth;
  private boolean mIsBigImg;
  private NativeReadInjoyImageView mStaticZImageView;
  public int mTryCounts = 1;
  private boolean needGifUrl;
  
  public GifView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public GifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private static Drawable getLoadingDrawable()
  {
    if (mLoadingDrawable == null) {
      mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130841680);
    }
    return mLoadingDrawable;
  }
  
  private void handleDrawableLoadListener(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {}
    AtomicLong localAtomicLong1;
    AtomicLong localAtomicLong2;
    long l;
    AtomicLong localAtomicLong3;
    AtomicLong localAtomicLong4;
    do
    {
      return;
      localAtomicLong1 = new AtomicLong(0L);
      localAtomicLong2 = new AtomicLong(0L);
      l = System.currentTimeMillis();
      localAtomicLong3 = new AtomicLong(l);
      localAtomicLong4 = new AtomicLong(0L);
      paramURLDrawable.setDownloadListener(new psp(this, localAtomicLong3, localAtomicLong1, l, localAtomicLong2, localAtomicLong4, paramURLDrawable));
    } while (this.mGifImageView == null);
    StringBuilder localStringBuilder = new StringBuilder();
    this.mGifImageView.setURLDrawableDownListener(new psq(this, l, localAtomicLong3, localAtomicLong1, localAtomicLong4, localAtomicLong2, localStringBuilder, paramURLDrawable));
  }
  
  private void hideGifAnim()
  {
    this.mCoverImageView.setVisibility(4);
  }
  
  private void init()
  {
    this.mContext = getContext();
    this.mGifImageView = new URLImageView(this.mContext);
    this.mCoverImageView = new NativeReadInjoyImageView(this.mContext);
    this.mStaticZImageView = new NativeReadInjoyImageView(this.mContext);
    this.mGifImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mCoverImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mStaticZImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.mGifImageView, -1, -1);
    addView(this.mCoverImageView, -1, -1);
    addView(this.mStaticZImageView, -1, -1);
  }
  
  private void initBigImgParams()
  {
    this.mTryCounts = 1;
    this.mIsBigImg = false;
  }
  
  private void reloadBigImg()
  {
    displayGif(this.mGifWidth >> this.mTryCounts, this.mGifHeight >> this.mTryCounts);
  }
  
  private boolean shouldTryLoad()
  {
    return this.mTryCounts <= 2;
  }
  
  public void displayCover()
  {
    this.mCoverImageView.setVisibility(0);
    this.mCoverImageView.setAlpha(1.0F);
  }
  
  public void displayGif()
  {
    displayGif(-1, -1);
  }
  
  public void displayGif(int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.mGifUrl)) && (this.mGifImageView.getVisibility() == 0))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = getLoadingDrawable();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = getLoadingDrawable();
      if ((paramInt2 > 0) && (paramInt1 > 0))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
      }
      localObject = URLDrawable.getDrawable(this.mGifUrl, (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1) {
        hideGifAnim();
      }
      handleDrawableLoadListener((URLDrawable)localObject);
      this.mGifImageView.setImageDrawable((Drawable)localObject);
    }
  }
  
  public boolean isPlaying()
  {
    return (this.mCoverImageView != null) && (this.mCoverImageView.getVisibility() != 0);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    displayCover();
  }
  
  public void setCoverUrl(String paramString)
  {
    this.mCoverUrl = paramString;
    if ((this.mCoverImageView != null) && (paramString != null)) {}
    try
    {
      pgk.a(this.mCoverImageView, new URL(this.mCoverUrl), getContext());
      return;
    }
    catch (MalformedURLException paramString)
    {
      QLog.d("gifvideo.GifView", 2, paramString.getMessage());
    }
  }
  
  public void setGifHeight(int paramInt)
  {
    this.mGifHeight = paramInt;
  }
  
  public void setGifUrl(String paramString)
  {
    if ((this.needGifUrl) && (paramString != null) && (!paramString.contains("fmt=gif")))
    {
      setStaticImageUrl(paramString);
      this.mGifImageView.setURLDrawableDownListener(null);
      this.mStaticZImageView.setVisibility(0);
      this.mGifImageView.setVisibility(8);
      this.mCoverImageView.setVisibility(8);
      return;
    }
    this.mStaticZImageView.setVisibility(8);
    this.mGifImageView.setVisibility(0);
    this.mCoverImageView.setVisibility(0);
    this.mGifUrl = paramString;
  }
  
  public void setGifWidth(int paramInt)
  {
    this.mGifWidth = paramInt;
  }
  
  public void setIsBigImg(boolean paramBoolean)
  {
    this.mIsBigImg = paramBoolean;
  }
  
  public void setNeedGifUrl(boolean paramBoolean)
  {
    this.needGifUrl = paramBoolean;
  }
  
  public void setScaleType(int paramInt)
  {
    if (this.mCoverImageView != null) {
      this.mCoverImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(paramInt, ImageView.ScaleType.CENTER_CROP));
    }
    if (this.mGifImageView != null) {
      this.mGifImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(paramInt, ImageView.ScaleType.CENTER_CROP));
    }
  }
  
  public void setStaticImageUrl(String paramString)
  {
    if ((this.mStaticZImageView != null) && (paramString != null)) {}
    try
    {
      pgk.a(this.mStaticZImageView, new URL(paramString), getContext());
      return;
    }
    catch (MalformedURLException paramString)
    {
      QLog.d("gifvideo.GifView", 2, paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.gif.GifView
 * JD-Core Version:    0.7.0.1
 */