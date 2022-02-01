package com.tencent.biz;

import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class PoiMapActivity$PoiTab$2
  implements AbsListView.OnScrollListener
{
  PoiMapActivity$PoiTab$2(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.b.h.e))
    {
      this.b.b(false);
      if (!PoiMapActivity.n(this.b.l)) {
        this.b.l.a("share_locate", "turn_page", this.b.l.ac, this.b.l.ab, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab.2
 * JD-Core Version:    0.7.0.1
 */