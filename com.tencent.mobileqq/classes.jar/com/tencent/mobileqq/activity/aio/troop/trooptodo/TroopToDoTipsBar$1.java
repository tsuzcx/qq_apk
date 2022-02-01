package com.tencent.mobileqq.activity.aio.troop.trooptodo;

import android.view.View;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel;
import com.tencent.mobileqq.data.trooptodo.TroopToDoBannerModel.RawInfo;
import com.tencent.mobileqq.troop.trooptodo.handler.TroopToDoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopToDoTipsBar$1
  implements ActionSheet.OnButtonClickListener
{
  TroopToDoTipsBar$1(TroopToDoTipsBar paramTroopToDoTipsBar, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        QLog.e("TroopToDoTipsBar-TodoInfo", 1, "actionSheet: trigger default");
      } else {
        TroopToDoTipsBar.c(this.b);
      }
    }
    else
    {
      paramView = TroopToDoTipsBar.a(this.b).e();
      TroopToDoTipsBar.b(this.b).b(paramView.a, paramView.b, paramView.c);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.troop.trooptodo.TroopToDoTipsBar.1
 * JD-Core Version:    0.7.0.1
 */