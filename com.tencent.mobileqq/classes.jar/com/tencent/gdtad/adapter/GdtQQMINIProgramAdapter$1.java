package com.tencent.gdtad.adapter;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter.Params;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import java.lang.ref.WeakReference;

class GdtQQMINIProgramAdapter$1
  implements MiniAppLaunchListener
{
  GdtQQMINIProgramAdapter$1(GdtQQMINIProgramAdapter paramGdtQQMINIProgramAdapter, AdQQMINIProgramAdapter.Params paramParams, GdtAd paramGdtAd) {}
  
  public void onLaunchResult(boolean paramBoolean, Bundle paramBundle)
  {
    GdtLog.b("GdtQQMINIProgramAdapter", String.format("onLaunchResult %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    AdAnalysisHelperForUtil.reportForLaunchQQMINIProgramEND((Context)this.jdField_a_of_type_ComTencentAdTangramMiniAdQQMINIProgramAdapter$Params.context.get(), this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtQQMINIProgramAdapter.1
 * JD-Core Version:    0.7.0.1
 */