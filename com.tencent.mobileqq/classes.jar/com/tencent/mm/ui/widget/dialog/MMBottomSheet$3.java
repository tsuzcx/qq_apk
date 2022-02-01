package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class MMBottomSheet$3
  implements AdapterView.OnItemClickListener
{
  MMBottomSheet$3(MMBottomSheet paramMMBottomSheet) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < MMBottomSheet.c(this.a).size())
    {
      h localh = (h)MMBottomSheet.c(this.a).getItemList().get(paramInt);
      if ((localh == null) || (!localh.f()))
      {
        if (paramInt < MMBottomSheet.c(this.a).size())
        {
          if (MMBottomSheet.d(this.a) != null) {
            MMBottomSheet.d(this.a).a(MMBottomSheet.c(this.a).getItem(paramInt), paramInt);
          } else {
            localh.h();
          }
        }
        else if ((MMBottomSheet.e(this.a).size() > 0) && (paramInt < MMBottomSheet.c(this.a).size() + MMBottomSheet.e(this.a).size()))
        {
          if (MMBottomSheet.f(this.a) != null) {
            MMBottomSheet.f(this.a).a(MMBottomSheet.e(this.a).getItem(paramInt - MMBottomSheet.c(this.a).size()), paramInt);
          }
        }
        else {
          MMBottomSheet.g(this.a);
        }
        if (!MMBottomSheet.h(this.a)) {
          this.a.tryHide();
        }
        MMBottomSheet.a(this.a, true);
        MMBottomSheet.a(this.a, paramInt);
        MMBottomSheet.i(this.a).notifyDataSetChanged();
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.3
 * JD-Core Version:    0.7.0.1
 */