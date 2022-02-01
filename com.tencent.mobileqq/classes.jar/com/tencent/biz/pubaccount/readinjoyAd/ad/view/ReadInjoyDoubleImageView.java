package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.net.URL;

public class ReadInjoyDoubleImageView
  extends ViewBase
{
  private Drawable a = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private Drawable b = new ColorDrawable(Color.parseColor("#00000000"));
  private AdvertisementInfo c;
  private Context d;
  private View e;
  private NativeReadInjoyImageView f;
  private NativeReadInjoyImageView g;
  private ReadInjoyAdSuperBgDrawable h;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = 0;
  private IReadInJoyModel m;
  private String n;
  private int o = 0;
  
  public ReadInjoyDoubleImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.d = paramVafContext.getContext();
    a(this.d);
  }
  
  private void a(Context paramContext)
  {
    this.e = ((LayoutInflater)this.d.getSystemService("layout_inflater")).inflate(2131626108, null);
    this.f = ((NativeReadInjoyImageView)this.e.findViewById(2131436261));
    this.g = ((NativeReadInjoyImageView)this.e.findViewById(2131436262));
    this.g.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    View localView = null;
    Object localObject = null;
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localObject;
      for (;;)
      {
        localView = paramView;
        if (!(localContext instanceof ContextWrapper)) {
          break;
        }
        if ((localContext instanceof Activity)) {
          paramView = (Activity)localContext;
        }
        localContext = ((ContextWrapper)localContext).getBaseContext();
      }
    }
    if ((localView != null) && (localView.getWindow() != null))
    {
      paramView = localView.getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.i = paramView.getTop();
      }
    }
    paramView = this.m;
    if ((paramView != null) && (paramView.u() != null) && (this.m.u().d() != null))
    {
      this.j = this.m.u().d().getPaddingTop();
      this.k = this.m.u().d().getTop();
      if (this.i <= 0) {
        this.i = this.m.u().d().getBottom();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReadInjoyDoubleImageView", 2, "initQQUIHeight cannot get listview's too and padding.");
    }
    this.l = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.f.setImageDrawable(null);
      this.f.setImagePlaceHolder(paramDrawable);
    }
    paramDrawable = URLDrawable.URLDrawableOptions.obtain();
    paramDrawable.mLoadingDrawable = this.a;
    paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 2))
    {
      paramDrawable.restartDownload();
      return;
    }
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("status=URLDrawable.SUCCESSED:");
        localStringBuilder.append(paramString);
        QLog.d("ReadInjoyDoubleImageView", 2, localStringBuilder.toString());
      }
      this.h = new ReadInjoyAdSuperBgDrawable(paramDrawable.getCurrDrawable(), this.l, this.i - (this.j + this.k));
      this.f.setImageDrawable(this.h);
      this.n = paramString;
      return;
    }
    if (paramDrawable != null) {
      paramDrawable.setURLDrawableListener(new ReadInjoyDoubleImageView.1(this, paramString));
    }
  }
  
  private void b()
  {
    if (this.c != null)
    {
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType(this.c))
      {
        Object localObject = this.c.getVideoCoverUrlWithSmartCut(false);
        if (localObject != null) {
          localObject = ((URL)localObject).getFile();
        } else {
          localObject = null;
        }
        a(this.f, (String)localObject, this.a);
      }
      if ((this.c.mInteractType == 2) && (!TextUtils.isEmpty(this.c.mInteractImageList))) {
        a(this.g, this.c.mInteractImageList, this.b);
      }
    }
  }
  
  private void c()
  {
    if ((this.i == -1) || (this.j == -1)) {
      a(this.f);
    }
    if ((!TextUtils.isEmpty(this.c.mImaxImg)) && (!this.c.mImaxImg.equals(this.n))) {
      a(this.c.mImaxImg, this.a);
    }
  }
  
  private int d()
  {
    return this.i - getComMeasuredHeight();
  }
  
  public void a()
  {
    if (this.g.getVisibility() == 0) {
      this.g.setVisibility(8);
    }
  }
  
  public void a(float paramFloat)
  {
    this.g.setAlpha(paramFloat);
    if (paramFloat > 0.0F)
    {
      this.g.setVisibility(0);
      return;
    }
    this.g.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (d() < 0) {
      return;
    }
    int i1 = paramInt2;
    if (paramInt2 < d())
    {
      i1 = paramInt2;
      if (paramInt3 == 2)
      {
        paramInt3 = this.o;
        i1 = paramInt2;
        if (paramInt3 + 1 != paramInt2)
        {
          i1 = paramInt2;
          if (paramInt3 != 0)
          {
            i1 = paramInt2;
            if (Math.abs(paramInt2 - paramInt3) > 3)
            {
              i1 = paramInt2;
              if (paramDouble <= 0.0D)
              {
                paramInt3 = this.o;
                i1 = paramInt2;
                if (paramInt2 <= paramInt3) {
                  i1 = paramInt3 + 1;
                }
              }
            }
          }
        }
      }
    }
    if (this.o != i1) {
      this.o = i1;
    }
    ReadInjoyAdSuperBgDrawable localReadInjoyAdSuperBgDrawable = this.h;
    if (localReadInjoyAdSuperBgDrawable != null)
    {
      if (localReadInjoyAdSuperBgDrawable.getCallback() == null) {
        this.f.setImageDrawable(this.h);
      }
      paramInt2 = -(Math.abs(i1) - Math.abs(this.j));
      if (i1 <= 0) {
        paramInt2 = this.j + Math.abs(i1);
      }
      this.h.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AdvertisementInfo localAdvertisementInfo = this.c;
    if (localAdvertisementInfo == null) {
      return;
    }
    int i1 = localAdvertisementInfo.mInteractEffectType;
    if ((i1 != 2) && (i1 != 3)) {
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f1 = paramInt3;
      float f2 = paramInt1;
      f1 /= f2;
      if (paramBoolean) {
        f1 = 1.0F - paramInt4 * 1.0F / f2;
      }
      f2 = 0.0F;
      if (f1 < 0.0F) {
        f1 = f2;
      }
      f2 = f1;
      if (f1 > 1.0F) {
        f2 = 1.0F;
      }
      a(f2);
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadImage: path is ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInjoyDoubleImageView", 2, localStringBuilder.toString());
    if ((paramString != null) && (!paramString.equals("-1"))) {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount")))
      {
        paramString = ImageCommon.getDrawableResourceId(paramString);
        if (paramString == null) {
          break label135;
        }
        QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
      }
    }
    label135:
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      label107:
      break label107;
    }
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in resources dir, do nothing");
    return;
    if (paramDrawable != null) {
      paramNativeReadInjoyImageView.setImagePlaceHolder(this.a);
    }
    paramNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.m = paramIReadInJoyModel;
    if ((this.c != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType(this.c))) {
      c();
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.e.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.e.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.e;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.e.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.f.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.f.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.f.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.g.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.g.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.g.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    b();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.f.setImageSrc(null);
    this.g.setImageSrc(null);
    if (this.h != null)
    {
      this.f.setImageDrawable(null);
      this.h.a();
      this.h = null;
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1042) {
      return super.setAttribute(paramInt, paramObject);
    }
    if (paramObject != null) {
      try
      {
        if ((paramObject instanceof AdvertisementInfo))
        {
          this.c = ((AdvertisementInfo)paramObject);
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.c = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInjoyDoubleImageView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView
 * JD-Core Version:    0.7.0.1
 */