package com.tencent.biz.pubaccount.weishi_new.drama;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.gallery.WSDramaGalleryAdapter;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;

class WSDramaMiddlePart$1
  implements View.OnClickListener
{
  WSDramaMiddlePart$1(WSDramaMiddlePart paramWSDramaMiddlePart) {}
  
  public void onClick(View paramView)
  {
    WSDramaMiddlePart.a(this.a, WSDramaUtils.a);
    paramView = (WSDramaItemData)WSDramaMiddlePart.a(this.a).getItem(WSDramaMiddlePart.a(this.a).b());
    WSDramaBeaconReport.b(paramView.d(), paramView.e(), paramView.b(), paramView.c(), this.a.k());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart.1
 * JD-Core Version:    0.7.0.1
 */