package com.tencent.gdtad.api.banner;

import acpi;
import acpj;
import acpk;
import acpl;
import acpm;
import acpn;
import acvc;
import android.content.Context;
import android.view.View;
import com.tencent.gdtad.aditem.GdtHandler.Params;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
{
  private acpl params;
  private boolean rendered;
  private float touchUpX;
  private float touchUpY;
  
  public GdtBannerAd(acpl paramacpl)
  {
    super(paramacpl);
    this.params = paramacpl;
    init();
  }
  
  private boolean a()
  {
    long l = this.params.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.getMinIntervalMillisBetweenExposureAndClick();
    acvc.b("GdtBannerAd", "getView().onClick exp time :" + l);
    l = Math.min(Math.max(l, 0L), 1000L);
    if (l > System.currentTimeMillis() - this.params.jdField_a_of_type_Long) {
      acvc.d("GdtBannerAd", "getView().onClick return cause click unless than exp time :" + l);
    }
    int i;
    do
    {
      do
      {
        return false;
        i = this.params.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.getBannerInvalidClickXPercent();
        acvc.b("GdtBannerAd", "getView().onClick exp leftRightPercent :" + i);
        i = Math.min(Math.max(i, 0), 100);
      } while ((this.touchUpX < this.params.b * i * 1.0D / 100.0D) || (this.touchUpX > (100 - i) * this.params.b * 1.0D / 100.0D));
      i = this.params.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a.getBannerInvalidClickYPercent();
      acvc.b("GdtBannerAd", "getView().onClick exp upDownPercent :" + i);
      i = Math.min(Math.max(i, 0), 100);
    } while ((this.touchUpY < this.params.c * i * 1.0D / 100.0D) || (this.touchUpY > (100 - i) * this.params.c * 1.0D / 100.0D));
    return true;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()) || (getParams().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet == null))
    {
      acvc.d("GdtBannerAd", "getErrorCode error");
      return 1;
    }
    paramInt1 = paramGdtAd.getCreativeSize();
    if ((getParams().jdField_a_of_type_Int == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 194))) {
      return 0;
    }
    return 7;
  }
  
  protected acpl getParams()
  {
    return this.params;
  }
  
  public void onDisplay()
  {
    if ((this.params != null) && (this.params.jdField_a_of_type_Long == -2147483648L)) {
      this.params.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public acpm render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramInt1 < 0) || (paramInt2 < 0) || (!isLoaded()) || (this.rendered))
    {
      acvc.d("GdtBannerAd", "render error");
      return null;
    }
    this.params.b = paramInt1;
    this.params.c = paramInt2;
    paramContext = acpn.a(this.params);
    if ((paramContext == null) || (paramContext.a() == null) || (acpm.a == null))
    {
      acvc.d("GdtBannerAd", "render error");
      return null;
    }
    paramContext.a().setOnTouchListener(new acpi(this, paramContext));
    paramContext.a().setOnClickListener(new acpj(this, paramContext));
    if (paramContext.b() != null) {
      paramContext.b().setOnClickListener(new acpk(this, paramContext));
    }
    this.rendered = true;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */