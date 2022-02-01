package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLImageView;

public final class GdtBannerViewWithRectangleStyle
  extends RelativeLayout
  implements GdtBannerView
{
  private AdAntiSpamForClick a = new AdAntiSpamForClick();
  private GdtHandler.Params b;
  private URLImageView c;
  private TextView d;
  private TextView e;
  private View.OnClickListener f = new GdtBannerViewWithRectangleStyle.1(this);
  
  public GdtBannerViewWithRectangleStyle(Context paramContext, GdtHandler.Params paramParams)
  {
    super(paramContext);
    if ((paramContext != null) && (paramParams != null) && (paramParams.a()))
    {
      this.b = paramParams;
      if (!a())
      {
        GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
        return;
      }
      setGravity(16);
      setPadding(1, 1, 1, 1);
      paramParams = new GradientDrawable();
      paramParams.setShape(0);
      paramParams.setStroke(1, Color.parseColor("#EFEFEF"));
      paramParams.setColor(-1);
      if (Build.VERSION.SDK_INT >= 16) {
        setBackground(paramParams);
      }
      paramParams = new RelativeLayout.LayoutParams(-2, -1);
      paramParams.addRule(9);
      this.c = new URLImageView(paramContext);
      this.c.setId(2131434091);
      this.c.setImageURL(getAd().getImageData().a);
      addView(this.c, paramParams);
      paramParams = new GradientDrawable();
      paramParams.setShape(0);
      paramParams.setCornerRadius(GdtUIUtils.a(14.0F, getResources()));
      paramParams.setColor(Color.parseColor("#00CAFC"));
      Object localObject1 = new RelativeLayout.LayoutParams(GdtUIUtils.a(58.0F, getResources()), GdtUIUtils.a(29.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = GdtUIUtils.a(12.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      ((RelativeLayout.LayoutParams)localObject1).addRule(11);
      this.d = new TextView(paramContext);
      this.d.setId(2131434087);
      this.d.setGravity(17);
      this.d.setTextColor(-1);
      this.d.setTextSize(2, 14.0F);
      b();
      if (Build.VERSION.SDK_INT >= 16) {
        this.d.setBackground(paramParams);
      }
      addView(this.d, (ViewGroup.LayoutParams)localObject1);
      paramParams = new LinearLayout(paramContext);
      paramParams.setOrientation(1);
      localObject1 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = GdtUIUtils.a(12.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = GdtUIUtils.a(12.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131434091);
      ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131434087);
      ((RelativeLayout.LayoutParams)localObject1).addRule(15);
      addView(paramParams, (ViewGroup.LayoutParams)localObject1);
      if ((getAd().getCreativeSize() != 65) && (getAd().getCreativeSize() != 184))
      {
        if (getAd().getCreativeSize() == 194)
        {
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          localObject2 = new TextView(paramContext);
          ((TextView)localObject2).setMaxLines(1);
          ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject2).setText(getAd().getText());
          ((TextView)localObject2).setTextColor(Color.parseColor("#333333"));
          ((TextView)localObject2).setTypeface(null, 1);
          ((TextView)localObject2).setTextSize(2, 14.0F);
          paramParams.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).topMargin = GdtUIUtils.a(8.0F, getResources());
          localObject2 = new TextView(paramContext);
          ((TextView)localObject2).setMaxLines(2);
          ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject2).setText(getAd().getDescription());
          ((TextView)localObject2).setTextColor(Color.parseColor("#666666"));
          ((TextView)localObject2).setTextSize(2, 13.0F);
          paramParams.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        }
        else
        {
          GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
        }
      }
      else
      {
        localObject1 = new TextView(paramContext);
        ((TextView)localObject1).setMaxLines(2);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setText(getAd().getText());
        ((TextView)localObject1).setTextColor(Color.parseColor("#333333"));
        ((TextView)localObject1).setTextSize(2, 13.0F);
        paramParams.addView((View)localObject1, new LinearLayout.LayoutParams(-1, -2));
        localObject1 = new LinearLayout(paramContext);
        localObject2 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject2).topMargin = GdtUIUtils.a(8.0F, getResources());
        ((LinearLayout)localObject1).setOrientation(0);
        ((LinearLayout)localObject1).setGravity(16);
        paramParams.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        int i = GdtUIUtils.a(16.0F, getResources());
        paramParams = new LinearLayout.LayoutParams(i, i);
        localObject2 = new GdtCircleImageView(paramContext);
        ((GdtCircleImageView)localObject2).setImageURL(getAd().getAdvertiser_corporate_logo());
        ((GdtCircleImageView)localObject2).a(i / 2);
        ((LinearLayout)localObject1).addView((View)localObject2, paramParams);
        paramParams = new LinearLayout.LayoutParams(-1, -2);
        paramParams.leftMargin = GdtUIUtils.a(4.0F, getResources());
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setMaxLines(1);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject2).setText(getAd().getAdvertiser_corporate_image_name());
        ((TextView)localObject2).setTextColor(Color.parseColor("#999999"));
        ((TextView)localObject2).setTextSize(2, 12.0F);
        ((LinearLayout)localObject1).addView((View)localObject2, paramParams);
      }
      localObject1 = new FrameLayout(paramContext);
      addView((View)localObject1, new FrameLayout.LayoutParams(GdtUIUtils.a(36.0F, getResources()), GdtUIUtils.a(22.0F, getResources())));
      paramParams = new LinearLayout(paramContext);
      Object localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setShape(0);
      ((GradientDrawable)localObject2).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, GdtUIUtils.a(4.0F, getResources()), GdtUIUtils.a(4.0F, getResources()), 0.0F, 0.0F });
      ((GradientDrawable)localObject2).setColor(Color.argb(127, 0, 0, 0));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, GdtUIUtils.a(14.0F, getResources()));
      paramParams.setOrientation(0);
      paramParams.setGravity(17);
      if (Build.VERSION.SDK_INT >= 16) {
        paramParams.setBackground((Drawable)localObject2);
      }
      ((FrameLayout)localObject1).addView(paramParams, localLayoutParams);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText("广告");
      ((TextView)localObject1).setTextColor(Color.argb(Double.valueOf(204.0D).intValue(), 255, 255, 255));
      ((TextView)localObject1).setTextSize(2, 9.0F);
      paramParams.addView((View)localObject1);
      new LinearLayout.LayoutParams(GdtUIUtils.a(8.0F, getResources()), GdtUIUtils.a(8.0F, getResources())).leftMargin = GdtUIUtils.a(2.0F, getResources());
      new ImageView(paramContext).setImageResource(2130840571);
      paramContext = new GradientDrawable();
      paramContext.setShape(0);
      paramContext.setStroke(1, Color.parseColor("#EBEDF5"));
      paramContext.setCornerRadius(GdtUIUtils.a(6.0F, getResources()));
      paramContext.setColor(-1);
      paramParams = new RelativeLayout.LayoutParams(GdtUIUtils.a(88.0F, getResources()), GdtUIUtils.a(34.0F, getResources()));
      paramParams.leftMargin = GdtUIUtils.a(3.0F, getResources());
      paramParams.topMargin = GdtUIUtils.a(18.0F, getResources());
      this.e = new TextView(getContext());
      this.e.setGravity(17);
      this.e.setText("不感兴趣");
      this.e.setTextColor(Color.parseColor("#333333"));
      this.e.setTextSize(2, 14.0F);
      if (Build.VERSION.SDK_INT >= 16) {
        this.e.setBackground(paramContext);
      }
      if (Build.VERSION.SDK_INT > 22) {
        ViewCompat.setElevation(this.e, GdtUIUtils.a(5.0F, getResources()));
      }
      addView(this.e, paramParams);
      this.e.setVisibility(8);
      return;
    }
    GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
  }
  
  private boolean a()
  {
    GdtHandler.Params localParams = this.b;
    return (localParams != null) && (localParams.a()) && (getAd() != null) && (getAd().getImageData() != null) && (getAd().getImageData().a()) && ((getAd().getCreativeSize() == 65) || (getAd().getCreativeSize() == 184) || (getAd().getCreativeSize() == 194));
  }
  
  private void b()
  {
    if (!a()) {
      return;
    }
    if (this.d == null) {
      return;
    }
    int i = AdClickUtil.getActionAboutApp(GdtHandler.b(this.b), -2147483648);
    String str;
    if ((i != 4) && (i != 5)) {
      str = "查看";
    } else {
      str = "打开";
    }
    this.d.setText(str);
  }
  
  private GdtAd getAd()
  {
    GdtHandler.Params localParams = this.b;
    if ((localParams != null) && (localParams.a())) {
      return this.b.a;
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "pause");
    paramContext = this.a;
    if (paramContext != null) {
      paramContext.setHasBeenPaused();
    }
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "resume");
    b();
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "destroy");
  }
  
  public AdAntiSpamForClick getAntiSpamForClick()
  {
    return this.a;
  }
  
  public View getCloseView()
  {
    return this.e;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      GdtLog.d("GdtBannerViewWithRectangleStyle", "setSize error");
      return;
    }
    paramInt1 = paramInt2 - 2;
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = getAd().getImageData().c;
    Double.isNaN(d2);
    d1 = d1 * 1.0D / d2;
    d2 = getAd().getImageData().b;
    Double.isNaN(d2);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Double.valueOf(d1 * d2).intValue(), paramInt1);
    localLayoutParams.addRule(9, -1);
    this.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle
 * JD-Core Version:    0.7.0.1
 */