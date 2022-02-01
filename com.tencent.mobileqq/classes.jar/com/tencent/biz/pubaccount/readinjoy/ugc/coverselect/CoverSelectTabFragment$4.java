package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;

class CoverSelectTabFragment$4
  implements OutputPicListener
{
  CoverSelectTabFragment$4(CoverSelectTabFragment paramCoverSelectTabFragment) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.CoverSelectTabFragment", 2, "OutputPicListener outPath:" + paramString);
    }
    CoverSelectTabFragment.a(this.a, paramString, CoverSelectTabFragment.a(this.a).getCurrentItem());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment.4
 * JD-Core Version:    0.7.0.1
 */