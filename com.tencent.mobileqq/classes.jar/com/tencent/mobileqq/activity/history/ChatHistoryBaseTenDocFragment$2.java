package com.tencent.mobileqq.activity.history;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.history.helper.ChatHistoryItemSelectHelper;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.widget.CustomFastOnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class ChatHistoryBaseTenDocFragment$2
  extends CustomFastOnClickListener
{
  ChatHistoryBaseTenDocFragment$2(ChatHistoryBaseTenDocFragment paramChatHistoryBaseTenDocFragment) {}
  
  public void a(View paramView)
  {
    if (paramView.getId() == 2131366452) {
      ChatHistoryBaseTenDocFragment.a(this.a);
    }
    while ((paramView.getTag() instanceof String)) {
      return;
    }
    TencentDocItem localTencentDocItem = ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)paramView.getTag()).a;
    if (this.a.c)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a(localTencentDocItem);
      ChatHistoryBaseTenDocFragment.a(this.a).notifyDataSetChanged();
      return;
    }
    paramView = "unknown";
    if (FMConstants.b(localTencentDocItem.mUrl)) {
      paramView = "doc";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("url", localTencentDocItem.mUrl);
      localBundle.putString("tdsourcetag", "s_qq_history_tab");
      localBundle.putString("tdsourcetype", paramView + ChatHistoryBaseTenDocFragment.a(this.a));
      TeamWorkDocEditBrowserActivity.a(ChatHistoryBaseTenDocFragment.a(this.a), localBundle, false);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A16B", "0X800A16B", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", paramView);
      return;
      if (FMConstants.e(localTencentDocItem.mUrl)) {
        paramView = "form";
      } else if (FMConstants.d(localTencentDocItem.mUrl)) {
        paramView = "ppt";
      } else if (FMConstants.c(localTencentDocItem.mUrl)) {
        paramView = "sheet";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.2
 * JD-Core Version:    0.7.0.1
 */