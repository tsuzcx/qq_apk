package com.tencent.mobileqq.activity.home;

import android.util.Pair;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class MainFragment$6
  implements ActionSheet.OnButtonClickListener
{
  MainFragment$6(MainFragment paramMainFragment, List paramList, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.c.h();
    if ((paramInt < 0) && (paramInt >= this.a.size())) {
      return;
    }
    try
    {
      MainFragment.a(this.c, ((Integer)((Pair)this.a.get(paramInt)).first).intValue(), (MainFragment.OverallMenuInfo)((Pair)this.a.get(paramInt)).second);
      this.b.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.6
 * JD-Core Version:    0.7.0.1
 */