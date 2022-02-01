package com.tencent.biz.pubaccount.weishi_new.drama;

import com.tencent.biz.pubaccount.weishi_new.drama.checkable.OnCheckedListener;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.report.WSDramaBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.drama.utils.WSDramaUtils;

class WSDramaMiddlePart$3
  implements OnCheckedListener<WSDramaItemData>
{
  WSDramaMiddlePart$3(WSDramaMiddlePart paramWSDramaMiddlePart) {}
  
  public void a(WSDramaItemData paramWSDramaItemData, int paramInt)
  {
    WSDramaMiddlePart.a(this.a, 1);
    WSDramaMiddlePart.a(this.a, paramWSDramaItemData, paramInt);
  }
  
  public void b(WSDramaItemData paramWSDramaItemData, int paramInt)
  {
    WSDramaBeaconReport.a(paramWSDramaItemData, paramInt, 1, true, this.a.a());
    WSDramaMiddlePart.a(this.a, WSDramaUtils.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart.3
 * JD-Core Version:    0.7.0.1
 */