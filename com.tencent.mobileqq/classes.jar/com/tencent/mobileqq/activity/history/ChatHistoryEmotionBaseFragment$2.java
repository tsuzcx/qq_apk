package com.tencent.mobileqq.activity.history;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatHistoryEmotionBaseFragment$2
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryEmotionBaseFragment$2(ChatHistoryEmotionBaseFragment paramChatHistoryEmotionBaseFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new ArrayList();
    if ((ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment) != null) && (!ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment).isEmpty()))
    {
      Iterator localIterator = ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryEmotionBaseFragment).iterator();
      while (localIterator.hasNext()) {
        paramView.add((ChatMessage)((EmotionPreviewData)localIterator.next()).a);
      }
    }
    if (paramView.size() > 0) {
      ThreadManager.post(new ChatHistoryEmotionBaseFragment.2.1(this, paramView), 8, null, true);
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */