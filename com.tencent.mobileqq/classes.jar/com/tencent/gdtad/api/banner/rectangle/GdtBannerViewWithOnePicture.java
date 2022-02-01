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
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtHandler.Params jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
  private GdtRoundRectURLImageView jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public GdtBannerViewWithOnePicture(Context paramContext, GdtHandler.Params paramParams)
  {
    super(paramContext);
    if (paramParams != null)
    {
      if (!paramParams.a()) {
        return;
      }
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
      paramParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(a().getBasic_img());
      this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131367547);
      paramParams.leftMargin = -5;
      paramParams.addRule(9);
      addView(this.jdField_a_of_type_ComTencentImageURLImageView, paramParams);
      paramParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840226);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, paramParams);
      if (a().getCreativeSize() != 194)
      {
        paramParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView = new GdtRoundRectURLImageView(paramContext);
        this.jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView.a(GdtUIUtils.a(7.0F, getResources()));
        this.jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView.setImageURL(a().getAdvertiser_corporate_logo());
        this.jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView.setId(2131367548);
        paramParams.addRule(1, 2131367547);
        addView(this.jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView, paramParams);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      this.b = new TextView(paramContext);
      this.b.setMaxLines(1);
      this.b.setEllipsize(TextUtils.TruncateAt.END);
      TextView localTextView = this.b;
      if (TextUtils.isEmpty(a().getText())) {
        paramParams = a().getDescription();
      } else {
        paramParams = a().getText();
      }
      localTextView.setText(paramParams);
      this.b.setTextColor(Color.parseColor("#333333"));
      this.b.setId(2131367544);
      if (a().getCreativeSize() == 194) {
        localLayoutParams.addRule(1, 2131367547);
      } else {
        localLayoutParams.addRule(1, 2131367548);
      }
      addView(this.b, localLayoutParams);
      if (a().getCreativeSize() != 194)
      {
        paramParams = new RelativeLayout.LayoutParams(-2, -2);
        this.c = new TextView(paramContext);
        this.c.setMaxLines(1);
        this.c.setMaxEms(8);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setText(a().getAdvertiser_corporate_image_name());
        this.c.setTextColor(Color.parseColor("#A6A6A6"));
        this.c.setId(2131367543);
        paramParams.addRule(3, 2131367544);
        paramParams.addRule(1, 2131367548);
        addView(this.c, paramParams);
      }
      if (((a().getCreativeSize() == 184) || (a().getCreativeSize() == 194)) && (a().getProductType() == 12) && (a().getAppDownloadNum() != 0L))
      {
        paramParams = new RelativeLayout.LayoutParams(-2, -2);
        this.d = new TextView(paramContext);
        this.d.setId(2131367546);
        this.d.setMaxLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setText(GdtDownloadNumFormatter.a(a().getAppDownloadNum()));
        this.d.setTextColor(Color.parseColor("#A6A6A6"));
        if (a().getCreativeSize() == 194) {
          paramParams.addRule(1, 2131367547);
        } else {
          paramParams.addRule(1, 2131367543);
        }
        paramParams.addRule(3, 2131367544);
        addView(this.d, paramParams);
      }
      paramParams = new GradientDrawable();
      paramParams.setShape(0);
      paramParams.setCornerRadius(GdtUIUtils.a(14.0F, getResources()));
      paramParams.setColor(Color.parseColor("#12B7F5"));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      a();
      if (Build.VERSION.SDK_INT >= 16) {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackground(paramParams);
      }
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(1, 2131367547);
      addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    }
  }
  
  private GdtAd a()
  {
    GdtHandler.Params localParams = this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    if ((localParams != null) && (localParams.a())) {
      return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a;
    }
    return null;
  }
  
  private void a()
  {
    if (!a()) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.isAppProductType())
    {
      if (AdAppUtil.isInstalled(getContext(), this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.getAppPackageName())) {
        str = "打开";
      } else {
        str = "立即下载";
      }
    }
    else {
      str = "查看详情";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  private boolean a()
  {
    GdtHandler.Params localParams = this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    return ((localParams != null) && (localParams.a()) && (a() != null) && (a().getImageData() != null) && (a().getImageData().a()) && ((a().getCreativeSize() == 65) || (a().getCreativeSize() == 184) || (a().getCreativeSize() == 194))) || (a().getCreativeSize() == 285);
  }
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return null;
  }
  
  public void a(Context paramContext) {}
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext)
  {
    a();
  }
  
  public void c(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.b != null) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
    {
      if (a().getCreativeSize() == 65) {
        i = Double.valueOf(paramInt1 * 303 / 684).intValue();
      } else if (a().getCreativeSize() == 184) {
        i = Double.valueOf(paramInt1 * 222 / 684).intValue();
      } else if (a().getCreativeSize() == 194) {
        i = Double.valueOf(paramInt1 * 168 / 684).intValue();
      } else {
        i = 0;
      }
      if (this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams() != null)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
        this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = paramInt2;
      }
      int i = Double.valueOf(paramInt1 * 72 / 684).intValue();
      Object localObject = this.jdField_a_of_type_ComTencentGdtadApiBannerRectangleGdtRoundRectURLImageView;
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
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = i;
        ((RelativeLayout.LayoutParams)localObject).height = j;
        ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(6.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(6.0F, getResources());
      }
      i = Double.valueOf(paramInt2 * 26 / 166).intValue();
      if (a().getCreativeSize() == 65) {
        paramInt1 = Double.valueOf(paramInt1 * 345 / 684).intValue();
      } else if (a().getCreativeSize() == 184) {
        paramInt1 = Double.valueOf(paramInt1 * 426 / 684).intValue();
      } else if (a().getCreativeSize() == 194) {
        paramInt1 = Double.valueOf(paramInt1 * 480 / 684).intValue();
      } else {
        paramInt1 = 0;
      }
      j = Double.valueOf(paramInt2 * 50 / 166).intValue();
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).width = paramInt1;
        ((RelativeLayout.LayoutParams)localObject).height = j;
        ((RelativeLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(9.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(9.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = GdtUIUtils.a(7.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(7.0F, getResources());
      }
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      float f = i;
      ((TextView)localObject).setTextSize(0, f);
      if ((a().getCreativeSize() == 194) && (this.d == null)) {
        this.b.setMaxLines(2);
      }
      this.b.setTextSize(0, f);
      localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = GdtUIUtils.a(8.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).rightMargin = GdtUIUtils.a(9.0F, getResources());
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = GdtUIUtils.a(5.0F, getResources());
        if (a().getCreativeSize() == 194) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = GdtUIUtils.a(9.0F, getResources());
        }
      }
      paramInt1 = Double.valueOf(paramInt2 * 22 / 166).intValue();
      localObject = this.c;
      if (localObject != null) {
        ((TextView)localObject).setTextSize(0, paramInt1);
      }
      localObject = this.d;
      if (localObject != null)
      {
        ((TextView)localObject).setTextSize(0, paramInt1);
        localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
        if (localObject != null)
        {
          if (a().getCreativeSize() == 194)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithOnePicture
 * JD-Core Version:    0.7.0.1
 */