package com.tencent.gdtad.api.banner;

import android.content.Context;
import android.view.View;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;
import ytr;
import ytu;
import ytv;
import ytw;
import yxs;
import yyd;

public final class GdtBannerAd
  extends com.tencent.gdtad.api.GdtAd
{
  private ytu params;
  private boolean rendered;
  
  public GdtBannerAd(ytu paramytu)
  {
    super(paramytu);
    this.params = paramytu;
  }
  
  public int getErrorCode(com.tencent.gdtad.aditem.GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = super.getErrorCode(paramGdtAd, paramInt1, paramInt2, paramInt3);
    if (paramInt1 != 0) {
      return paramInt1;
    }
    if ((paramGdtAd == null) || (!isValid()))
    {
      yxs.d("GdtBannerAd", "getErrorCode error");
      return 1;
    }
    paramInt1 = paramGdtAd.getCreativeSize();
    if ((getParams().jdField_a_of_type_Int == 0) && ((paramInt1 == 65) || (paramInt1 == 184) || (paramInt1 == 193) || (paramInt1 == 194) || (paramInt1 == 210) || (paramInt1 == 285))) {
      return 0;
    }
    return 7;
  }
  
  protected ytu getParams()
  {
    return this.params;
  }
  
  public ytv render(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext == null) || (paramInt1 < 0) || (paramInt2 < 0) || (!isLoaded()) || (this.rendered))
    {
      yxs.d("GdtBannerAd", "render error");
      return null;
    }
    paramContext = new ytu();
    paramContext.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = this.params.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    paramContext.jdField_a_of_type_Int = this.params.jdField_a_of_type_Int;
    paramContext.b = paramInt1;
    paramContext.c = paramInt2;
    paramContext = ytw.a(paramContext);
    if ((paramContext == null) || (paramContext.a() == null) || (ytv.a == null))
    {
      yxs.d("GdtBannerAd", "render error");
      return null;
    }
    this.params.jdField_a_of_type_ComTencentGdtadStatisticsGdtDwellTimeStatisticsAfterClick = new GdtDwellTimeStatisticsAfterClick(getAd(), new WeakReference(paramContext.a()));
    paramContext.a().setOnClickListener(new ytr(this, paramContext));
    yyd.a(getAd().getUrlForImpression());
    notifyImpression();
    this.rendered = true;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.GdtBannerAd
 * JD-Core Version:    0.7.0.1
 */