package com.tencent.biz;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class PoiMapActivity$PoiTab$1
  implements AdapterView.OnItemClickListener
{
  PoiMapActivity$PoiTab$1(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.a(paramInt, true);
    int i = this.b.l.d.length;
    paramInt = 0;
    while (paramInt < i)
    {
      if (this.b.i != paramInt) {
        this.b.l.d[paramInt].a(-1, false);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.PoiTab.1
 * JD-Core Version:    0.7.0.1
 */