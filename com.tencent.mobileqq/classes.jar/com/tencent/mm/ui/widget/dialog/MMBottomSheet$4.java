package com.tencent.mm.ui.widget.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class MMBottomSheet$4
  implements AdapterView.OnItemClickListener
{
  MMBottomSheet$4(MMBottomSheet paramMMBottomSheet) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt <= MMBottomSheet.j(this.a).size())
    {
      h localh = (h)MMBottomSheet.j(this.a).getItemList().get(paramInt);
      if ((localh == null) || (!localh.f()))
      {
        if ((paramInt < MMBottomSheet.j(this.a).size()) && (MMBottomSheet.k(this.a) != null)) {
          MMBottomSheet.k(this.a).a(MMBottomSheet.j(this.a).getItem(paramInt), paramInt);
        }
        if (!MMBottomSheet.h(this.a)) {
          this.a.tryHide();
        }
        MMBottomSheet.a(this.a, true);
        MMBottomSheet.l(this.a).notifyDataSetChanged();
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMBottomSheet.4
 * JD-Core Version:    0.7.0.1
 */