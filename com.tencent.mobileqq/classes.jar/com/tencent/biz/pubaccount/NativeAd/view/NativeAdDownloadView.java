package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.image.PublicDrawableUtil;
import org.json.JSONObject;

public class NativeAdDownloadView
  extends RelativeLayout
{
  private Context a;
  private RelativeLayout b;
  private ProgressBar c;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress d;
  private TextView e;
  private int f = 1;
  private JSONObject g;
  private CommonProgressStyle h;
  
  public NativeAdDownloadView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    JSONObject localJSONObject = this.g;
    if (localJSONObject == null) {
      return;
    }
    if (this.h == null) {
      this.h = CommonProgressStyle.a(1, localJSONObject);
    }
    setStyle(this.h);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    inflate(getContext(), 2131626104, this);
    this.b = ((RelativeLayout)findViewById(2131439909));
  }
  
  private void b()
  {
    if (this.d == null) {
      this.d = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
    }
    ReadInJoyCommonSoftAdUtils.a(this.d);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(25.0F, getContext().getResources()), AIOUtils.b(25.0F, getContext().getResources()));
    localLayoutParams.rightMargin = AIOUtils.b(10.0F, getContext().getResources());
    this.b.addView(this.d, localLayoutParams);
  }
  
  public void setBtnText(String paramString)
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void setProgress(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((ProgressBar)localObject).setProgress(paramInt);
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).setPauseWithoutInvalidate(false);
      this.d.setProgress(paramInt);
    }
    setText(paramInt);
  }
  
  public void setProgressStyle(JSONObject paramJSONObject)
  {
    this.g = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.f = ParseUtil.a(paramJSONObject.optString("style"), 1);
      setStyle(this.f);
    }
  }
  
  public void setStyle(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      b();
      return;
    }
    a();
  }
  
  public void setStyle(CommonProgressStyle paramCommonProgressStyle)
  {
    if (paramCommonProgressStyle == null) {
      return;
    }
    if (paramCommonProgressStyle.a == 1)
    {
      if (this.c == null)
      {
        inflate(getContext(), 2131626115, this.b);
        this.c = ((ProgressBar)this.b.findViewById(2131439913));
        this.e = ((TextView)this.b.findViewById(2131448661));
      }
      this.h = paramCommonProgressStyle;
      this.c.setVisibility(0);
      paramCommonProgressStyle = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      paramCommonProgressStyle.width = AIOUtils.b(this.h.d, this.a.getResources());
      paramCommonProgressStyle.height = AIOUtils.b(this.h.f, this.a.getResources());
      paramCommonProgressStyle.addRule(13);
      this.c.setLayoutParams(paramCommonProgressStyle);
      this.c.setMax(100);
      Object localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(AIOUtils.b(this.h.h, this.a.getResources()));
      ((GradientDrawable)localObject1).setColor(ParseUtil.a(this.h.i, "#F2F2F2"));
      localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
      ((ClipDrawable)localObject1).setLevel(10000);
      Object localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.b(this.h.h, this.a.getResources()));
      ((GradientDrawable)localObject2).setColor(ParseUtil.a(this.h.j, "#F2F2F2"));
      localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(this.h.h, this.a.getResources()));
      localGradientDrawable.setColor(ParseUtil.a(this.h.b, "#12B7F5"));
      localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      this.c.setProgressDrawable((Drawable)localObject1);
      this.c.setProgress(0);
      this.e.setGravity(17);
      this.e.setTextColor(ParseUtil.a(this.h.k, "#ffffff"));
      int j = this.h.l;
      int i;
      if (j < this.h.m)
      {
        i = this.h.m;
      }
      else
      {
        i = j;
        if (j > this.h.n) {
          i = this.h.n;
        }
      }
      this.e.setTextSize(2, i);
      this.e.setVisibility(0);
      this.e.setClickable(false);
      localObject1 = this.h.o;
      localObject2 = String.valueOf(this.h.p);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        float f2 = ParseUtil.a((String)localObject2, 0.0F);
        float f1 = f2;
        if (f2 > 2.0F) {
          f1 = 2.0F;
        }
        localObject2 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (paramCommonProgressStyle.width + AIOUtils.b(f1, this.a.getResources()) * 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (paramCommonProgressStyle.height + AIOUtils.b(f1, this.a.getResources()) * 2);
        this.b.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        PublicDrawableUtil.a(this.b, AIOUtils.b(this.h.h, this.a.getResources()), ParseUtil.a((String)localObject1, "#12B7F5"), AIOUtils.b(f1, this.a.getResources()));
      }
    }
    else if ((paramCommonProgressStyle.a == 2) && (this.d == null))
    {
      this.d = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(getContext());
      ReadInJoyCommonSoftAdUtils.a(this.d);
      paramCommonProgressStyle = new RelativeLayout.LayoutParams(AIOUtils.b(25.0F, getContext().getResources()), AIOUtils.b(25.0F, getContext().getResources()));
      paramCommonProgressStyle.rightMargin = AIOUtils.b(10.0F, getContext().getResources());
      this.b.addView(this.d, paramCommonProgressStyle);
    }
  }
  
  public void setText(int paramInt)
  {
    if (this.e != null)
    {
      if (this.f != 1) {
        return;
      }
      Object localObject = this.h;
      if ((localObject != null) && (!((CommonProgressStyle)localObject).r))
      {
        localObject = this.e;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("%");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131904937));
      localStringBuilder.append(paramInt);
      localStringBuilder.append("%");
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView
 * JD-Core Version:    0.7.0.1
 */