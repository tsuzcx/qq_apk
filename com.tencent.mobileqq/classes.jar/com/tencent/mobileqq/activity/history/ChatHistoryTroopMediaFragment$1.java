package com.tencent.mobileqq.activity.history;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class ChatHistoryTroopMediaFragment$1
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryTroopMediaFragment$1(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, ActionSheet paramActionSheet, ArrayList paramArrayList) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.a.getContent(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView)) {
        if (paramView.equals(this.c.getBaseActivity().getResources().getString(2131886528)))
        {
          paramView = this.b;
          if ((paramView != null) && (paramView.size() > 0) && (this.c.s != null)) {
            this.c.s.l();
          }
        }
        else if (paramView.equals(this.c.getBaseActivity().getResources().getString(2131890805)))
        {
          this.c.a(this.b);
        }
        else if (paramView.equals(this.c.getBaseActivity().getResources().getString(2131890811)))
        {
          if (this.b.size() > 20) {
            QQToast.makeText(this.c.getBaseActivity(), 2131889677, 0).show();
          } else {
            this.c.b(this.b);
          }
        }
      }
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment.1
 * JD-Core Version:    0.7.0.1
 */