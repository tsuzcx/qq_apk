package com.tencent.biz;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class PoiMapActivity$11
  implements AbsListView.OnScrollListener
{
  PoiMapActivity$11(PoiMapActivity paramPoiMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "onScrollStateChanged");
      }
      if ((!this.a.f) && (this.a.d))
      {
        paramAbsListView = this.a;
        paramAbsListView.f = true;
        paramAbsListView.n += 1;
        if (QLog.isDevelopLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("onScrollStateChanged mSearchPage:");
          paramAbsListView.append(this.a.n);
          QLog.i("PoiMapActivity", 4, paramAbsListView.toString());
        }
        paramAbsListView = this.a;
        paramAbsListView.a(paramAbsListView.h, this.a.i, this.a.c, "", this.a.n, 20);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.11
 * JD-Core Version:    0.7.0.1
 */