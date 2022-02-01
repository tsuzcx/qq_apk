package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MarketFaceItemBuilder$11
  implements ActionSheet.OnButtonClickListener
{
  MarketFaceItemBuilder$11(MarketFaceItemBuilder paramMarketFaceItemBuilder, PicEmoticonInfo paramPicEmoticonInfo, ActionSheet paramActionSheet, MessageForMarketFace paramMessageForMarketFace) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType != 1) {
        break;
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.jobType == 3) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, bool1, bool2);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
        return;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon, this.jdField_a_of_type_ComTencentMobileqqDataMessageForMarketFace.uniseq);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */