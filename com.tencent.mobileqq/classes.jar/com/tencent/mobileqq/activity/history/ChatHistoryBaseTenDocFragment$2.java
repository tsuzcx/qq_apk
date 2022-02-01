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
    if (paramView.getId() == 2131366333)
    {
      ChatHistoryBaseTenDocFragment.a(this.a);
      return;
    }
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    Object localObject = ((ChatHistoryBaseTenDocAdapter.HistoryTenDocItemHolder)paramView.getTag()).a;
    if (this.a.c)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryHelperChatHistoryItemSelectHelper.a(localObject);
      ChatHistoryBaseTenDocFragment.a(this.a).notifyDataSetChanged();
      return;
    }
    if (FMConstants.b(((TencentDocItem)localObject).mUrl)) {
      paramView = "doc";
    }
    for (;;)
    {
      break;
      if (FMConstants.e(((TencentDocItem)localObject).mUrl)) {
        paramView = "form";
      } else if (FMConstants.d(((TencentDocItem)localObject).mUrl)) {
        paramView = "ppt";
      } else if (FMConstants.c(((TencentDocItem)localObject).mUrl)) {
        paramView = "sheet";
      } else {
        paramView = "unknown";
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("url", ((TencentDocItem)localObject).mUrl);
    localBundle.putString("tdsourcetag", "s_qq_history_tab");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(ChatHistoryBaseTenDocFragment.a(this.a));
    localBundle.putString("tdsourcetype", ((StringBuilder)localObject).toString());
    TeamWorkDocEditBrowserActivity.a(ChatHistoryBaseTenDocFragment.a(this.a), localBundle, false);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A16B", "0X800A16B", ChatHistoryBaseTenDocFragment.a(this.a), 0, "", "", "s_qq_history_tab", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryBaseTenDocFragment.2
 * JD-Core Version:    0.7.0.1
 */