package com.tencent.gdtad.api.banner;

import acle;
import aclf;
import aclg;
import aclh;
import acli;
import aclj;
import acqy;
import android.content.Context;
import android.view.View;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
{
  private aclh params;
  private boolean rendered;
  
  public GdtBannerAd(aclh paramaclh)
  {
    super(paramaclh);
    this.params = paramaclh;
    init();
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()) || (getParams().jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet == null))
    {
      acqy.d("GdtBannerAd", "getErrorCode error");
      return 1;
    }
    paramInt1 = paramGdtAd.getCreativeSize();
    if ((getParams().jdField_a_of_type_Int == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 194))) {
      return 0;
    }
    return 7;
  }
  
  protected aclh getParams()
  {
    return this.params;
  }
  
  public acli render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramInt1 < 0) || (paramInt2 < 0) || (!isLoaded()) || (this.rendered))
    {
      acqy.d("GdtBannerAd", "render error");
      return null;
    }
    this.params.b = paramInt1;
    this.params.c = paramInt2;
    paramContext = aclj.a(this.params);
    if ((paramContext == null) || (paramContext.a() == null) || (acli.a == null))
    {
      acqy.d("GdtBannerAd", "render error");
      return null;
    }
    paramContext.a().setOnTouchListener(new acle(this, paramContext));
    paramContext.a().setOnClickListener(new aclf(this, paramContext));
    if (paramContext.b() != null) {
      paramContext.b().setOnClickListener(new aclg(this, paramContext));
    }
    this.rendered = true;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */