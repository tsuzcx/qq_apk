package com.tencent.biz.subscribe.utils;

import android.view.View;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SubscribeDraftManager$7
  implements ActionSheet.OnButtonClickListener
{
  SubscribeDraftManager$7(SubscribeDraftManager paramSubscribeDraftManager, String paramString1, String paramString2, SubscribeFollowUserUtil.ResultListener paramResultListener, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (FastClickUtils.a("subScribe_delete_draft")) {
        return;
      }
      this.e.a(this.a, this.b, new SubscribeDraftManager.7.1(this));
    }
    this.d.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeDraftManager.7
 * JD-Core Version:    0.7.0.1
 */