package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.view.View;
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
import com.tencent.image.URLImageView;

final class GdtBannerViewWithRectangleStyle
  extends RelativeLayout
  implements GdtBannerView
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdAntiSpamForClick jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick;
  private GdtHandler.Params jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  private GdtAd a()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a())) {
      return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a;
    }
    return null;
  }
  
  private void a()
  {
    if (!a()) {}
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    int i = AdClickUtil.getActionAboutApp(GdtHandler.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params), -2147483648);
    if ((i == 4) || (i == 5)) {}
    for (String str = "打开";; str = "查看")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()) && (a() != null) && (a().getImageData() != null) && (a().getImageData().a()) && ((a().getCreativeSize() == 65) || (a().getCreativeSize() == 184) || (a().getCreativeSize() == 194));
  }
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick;
  }
  
  public void a(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "pause");
    if (this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick != null) {
      this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick.setHasBeenPaused();
    }
  }
  
  public View b()
  {
    return this.b;
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "resume");
    a();
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "destroy");
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      GdtLog.d("GdtBannerViewWithRectangleStyle", "setSize error");
      return;
    }
    paramInt1 = paramInt2 - 2;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Double.valueOf(1.0D * paramInt1 / a().getImageData().b * a().getImageData().a).intValue(), paramInt1);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle
 * JD-Core Version:    0.7.0.1
 */