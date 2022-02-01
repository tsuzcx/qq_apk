package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmotionPanelConstans;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.utils.FileUtils;

class ChatHistory$ChatHistoryAdapter$8
  implements QueryCallback<IPicEmoticonInfo>
{
  ChatHistory$ChatHistoryAdapter$8(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(IPicEmoticonInfo paramIPicEmoticonInfo)
  {
    if (paramIPicEmoticonInfo != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramIPicEmoticonInfo);
      String str = EmotionPanelConstans.pngFramePath.replace("[epId]", paramIPicEmoticonInfo.getEmoticon().epId);
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0)) {
        localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
      } else {
        localObject = "";
      }
      int i = PngFrameUtil.a((String)localObject);
      if ((FileUtils.fileExists(str)) && (i == 1)) {
        i = 3;
      } else if (paramIPicEmoticonInfo.isBigImageExists()) {
        i = 2;
      } else if (paramIPicEmoticonInfo.isAioPreviewExists()) {
        i = 1;
      } else {
        i = 0;
      }
      if (paramIPicEmoticonInfo.isSound())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.getResources().getDrawable(2130847365);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      else if (i == 1)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.getResources().getDrawable(2130837971);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      this.b.setMinimumHeight((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a * 100.0F));
      this.b.setMinimumWidth((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a * 100.0F));
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.b, i, paramIPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.8
 * JD-Core Version:    0.7.0.1
 */