package com.tencent.biz.pubaccount;

import android.view.View;
import com.tencent.biz.ui.MenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class PublicAccountMenuBar$2
  implements ActionSheet.OnButtonClickListener
{
  PublicAccountMenuBar$2(PublicAccountMenuBar paramPublicAccountMenuBar, List paramList, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    try
    {
      if (PublicAccountMenuBar.a(this.c)) {
        return;
      }
      PublicAccountMenuBar.a(this.c, true);
      if (paramInt == 0)
      {
        PublicAccountMenuBar.a(this.c, false);
        return;
      }
      paramView = (MenuItem)this.a.get(paramInt - 1);
      if (paramView == null)
      {
        PublicAccountMenuBar.a(this.c, false);
        return;
      }
      PublicAccountMenuBar.a(this.c, paramView);
      this.b.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountMenuBar.2
 * JD-Core Version:    0.7.0.1
 */