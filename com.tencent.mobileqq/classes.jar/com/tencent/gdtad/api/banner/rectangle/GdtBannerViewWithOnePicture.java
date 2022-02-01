package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.utils.GdtDownloadNumFormatter;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.image.URLImageView;

final class GdtBannerViewWithOnePicture
  extends RelativeLayout
  implements GdtBannerView
{
  private GdtHandler.Params a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private URLImageView g;
  private GdtRoundRectURLImageView h;
  
  public GdtBannerViewWithOnePicture(Context paramContext, GdtHandler.Params paramParams)
  {
    super(paramContext);
    if (paramParams != null)
    {
      if (!paramParams.a()) {
        return;
      }
      this.a = paramParams;
      paramParams = new RelativeLayout.LayoutParams(-2, -2);
      this.g = new URLImageView(paramContext);
      this.g.setImageURL(b().getBasic_img());
      this.g.setId(2131434089);
      paramParams.leftMargin = -5;
      paramParams.addRule(9);
      addView(this.g, paramParams);
      paramParams = new RelativeLayout.LayoutParams(-2, -2);
      this.b = new ImageView(paramContext);
      this.b.setImageResource(2130840544);
      addView(this.b, paramParams);
      if (b().getCreativeSize() != 194)
      {
        paramParams = new RelativeLayout.LayoutParams(-2, -2);
        this.h = new GdtRoundRectURLImageView(paramContext);
        this.h.a(GdtUIUtils.a(7.0F, getResources()));
        this.h.setImageURL(b().getAdvertiser_corporate_logo());
        this.h.setId(2131434090);
        paramParams.addRule(1, 2131434089);
        addView(this.h, paramParams);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      this.d = new TextView(paramContext);
      this.d.setMaxLines(1);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      TextView localTextView = this.d;
      if (TextUtils.isEmpty(b().getText())) {
        paramParams = b().getDescription();
      } else {
        paramParams = b().getText();
      }
      localTextView.setText(paramParams);
      this.d.setTextColor(Color.parseColor("#333333"));
      this.d.setId(2131434086);
      if (b().getCreativeSize() == 194) {
        localLayoutParams.addRule(1, 2131434089);
      } else {
        localLayoutParams.addRule(1, 2131434090);
      }
      addView(this.d, localLayoutParams);
      if (b().getCreativeSize() != 194)
      {
        paramParams = new RelativeLayout.LayoutParams(-2, -2);
        this.e = new TextView(paramContext);
        this.e.setMaxLines(1);
        this.e.setMaxEms(8);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setText(b().getAdvertiser_corporate_image_name());
        this.e.setTextColor(Color.parseColor("#A6A6A6"));
        this.e.setId(2131434085);
        paramParams.addRule(3, 2131434086);
        paramParams.addRule(1, 2131434090);
        addView(this.e, paramParams);
      }
      if (((b().getCreativeSize() == 184) || (b().getCreativeSize() == 194)) && (b().getProductType() == 12) && (b().getAppDownloadNum() != 0L))
      {
        paramParams = new RelativeLayout.LayoutParams(-2, -2);
        this.f = new TextView(paramContext);
        this.f.setId(2131434088);
        this.f.setMaxLines(1);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setText(GdtDownloadNumFormatter.a(b().getAppDownloadNum()));
        this.f.setTextColor(Color.parseColor("#A6A6A6"));
        if (b().getCreativeSize() == 194) {
          paramParams.addRule(1, 2131434089);
        } else {
          paramParams.addRule(1, 2131434085);
        }
        paramParams.addRule(3, 2131434086);
        addView(this.f, paramParams);
      }
      paramParams = new GradientDrawable();
      paramParams.setShape(0);
      paramParams.setCornerRadius(GdtUIUtils.a(14.0F, getResources()));
      paramParams.setColor(Color.parseColor("#12B7F5"));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.c = new TextView(paramContext);
      this.c.setGravity(17);
      this.c.setTextColor(-1);
      c();
      if (Build.VERSION.SDK_INT >= 16) {
        this.c.setBackground(paramParams);
      }
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(1, 2131434089);
      addView(this.c, localLayoutParams);
    }
  }
  
  private boolean a()
  {
    GdtHandler.Params localParams = this.a;
    return ((localParams != null) && (localParams.a()) && (b() != null) && (b().getImageData() != null) && (b().getImageData().a()) && ((b().getCreativeSize() == 65) || (b().getCreativeSize() == 184) || (b().getCreativeSize() == 194))) || (b().getCreativeSize() == 285);
  }
  
  private GdtAd b()
  {
    GdtHandler.Params localParams = this.a;
    if ((localParams != null) && (localParams.a())) {
      return this.a.a;
    }
    return null;
  }
  
  private void c()
  {
    if (!a()) {
      return;
    }
    if (this.c == null) {
      return;
    }
    String str;
    if (this.a.a.isAppProductType())
    {
      if (AdAppUtil.isInstalled(getContext(), this.a.a.getAppPackageName())) {
        str = "打开";
      } else {
        str = "立即下载";
      }
    }
    else {
      str = "查看详情";
    }
    this.c.setText(str);
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext)
  {
    c();
  }
  
  public void c(Context paramContext) {}
  
  public AdAntiSpamForClick getAntiSpamForClick()
  {
    return null;
  }
  
  public View getCloseView()
  {
    return null;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (this.b != null) && (this.c != null) && (this.d != null) && (this.g != null))
    {
      if (b().getCreativeSize() == 65) {
        i = Double.valueOf(paramInt1 * 303 / 684).intValue();
      } else if (b().getCreativeSize() == 184) {
        i = Double.valueOf(paramInt1 * 222 / 684).intValue();
      } else if (b().getCreativeSize() == 194) {
        i = Double.valueOf(paramInt1 * 168 / 684).intValue();
      } else {
        i = 0;
      }
      if (this.g.getLayoutParams() != null)
      {
        this.g.getLayoutParams().width = i;
        this.g.getLayoutParams().height = paramInt2;
      }
      int i = Double.valueOf(paramInt1 * 72 / 684).intValue();
      Object localObject = this.h;
      if (localObject != null) {
        localObject = ((GdtRoundRectURLImageView)localObject).getLayoutParams();
      } else {
        localObject = null;
      }
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = i;
        ((RelativeLayout.LayoutParams)localObject).height = i;
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(8.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(10.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(7.0F, getResources());
      }
      i = Double.valueOf(paramInt1 * 70 / 684).intValue();
      int j = Double.valueOf(i * 3 / 7).intValue();
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = i;
        ((RelativeLayout.LayoutParams)localObject).height = j;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(6.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(6.0F, getResources());
      }
      i = Double.valueOf(paramInt2 * 26 / 166).intValue();
      if (b().getCreativeSize() == 65) {
        paramInt1 = Double.valueOf(paramInt1 * 345 / 684).intValue();
      } else if (b().getCreativeSize() == 184) {
        paramInt1 = Double.valueOf(paramInt1 * 426 / 684).intValue();
      } else if (b().getCreativeSize() == 194) {
        paramInt1 = Double.valueOf(paramInt1 * 480 / 684).intValue();
      } else {
        paramInt1 = 0;
      }
      j = Double.valueOf(paramInt2 * 50 / 166).intValue();
      localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
        ((RelativeLayout.LayoutParams)localObject).height = j;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(9.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(9.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = GdtUIUtils.a(7.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(7.0F, getResources());
      }
      localObject = this.c;
      float f1 = i;
      ((TextView)localObject).setTextSize(0, f1);
      if ((b().getCreativeSize() == 194) && (this.f == null)) {
        this.d.setMaxLines(2);
      }
      this.d.setTextSize(0, f1);
      localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(8.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(9.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = GdtUIUtils.a(5.0F, getResources());
        if (b().getCreativeSize() == 194) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(9.0F, getResources());
        }
      }
      paramInt1 = Double.valueOf(paramInt2 * 22 / 166).intValue();
      localObject = this.e;
      if (localObject != null) {
        ((TextView)localObject).setTextSize(0, paramInt1);
      }
      localObject = this.f;
      if (localObject != null)
      {
        ((TextView)localObject).setTextSize(0, paramInt1);
        localObject = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
        if (localObject != null)
        {
          if (b().getCreativeSize() == 194)
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(9.0F, getResources());
            return;
          }
          ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(7.0F, getResources());
        }
      }
      return;
    }
    GdtLog.d("GdtBannerViewWithOnePicture", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithOnePicture
 * JD-Core Version:    0.7.0.1
 */