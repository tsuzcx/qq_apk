package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ReadInJoyBlurImageView
  extends ViewBase
{
  private Context a;
  private View b;
  private NativeReadInjoyImageView c;
  private AdvertisementInfo d;
  private Drawable e = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private Drawable f = new ColorDrawable(Color.parseColor("#00000000"));
  private Handler g = new ReadInJoyBlurImageView.1(this, Looper.getMainLooper());
  
  public ReadInJoyBlurImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = paramVafContext.getContext();
    a(this.a);
  }
  
  private void a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = ((AdvertisementInfo)localObject).getVideoCoverUrlWithSmartCut(false);
      if (localObject != null) {
        localObject = ((URL)localObject).getFile();
      } else {
        localObject = null;
      }
      try
      {
        a(this.c, (String)localObject, this.e);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131626100, null);
    this.c = ((NativeReadInjoyImageView)this.b.findViewById(2131436291));
  }
  
  private void b()
  {
    if (this.c != null)
    {
      Object localObject = this.d;
      if (localObject == null) {
        return;
      }
      localObject = CommonImageCacheHelper.a(String.valueOf(((AdvertisementInfo)localObject).mAdAid));
      if (localObject == null) {
        return;
      }
      this.c.setImageBitmap((Bitmap)localObject);
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    paramNativeReadInjoyImageView = new StringBuilder();
    paramNativeReadInjoyImageView.append("loadImage: path is ");
    paramNativeReadInjoyImageView.append(paramString);
    QLog.d("ReadInjoyBlurImageView", 2, paramNativeReadInjoyImageView.toString());
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      paramNativeReadInjoyImageView = this.d;
      if (paramNativeReadInjoyImageView != null)
      {
        if (this.c == null) {
          return;
        }
        paramNativeReadInjoyImageView = String.valueOf(paramNativeReadInjoyImageView.mAdAid);
        if (CommonImageCacheHelper.a(paramNativeReadInjoyImageView) == null)
        {
          ThreadManagerV2.excute(new ReadInJoyBlurImageView.2(this, paramString, paramNativeReadInjoyImageView), 128, null, false);
          return;
        }
        this.g.sendEmptyMessage(1);
      }
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    a();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.c.setImageSrc(null);
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
          this.d = ((AdvertisementInfo)paramObject);
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.d = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInjoyBlurImageView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView
 * JD-Core Version:    0.7.0.1
 */