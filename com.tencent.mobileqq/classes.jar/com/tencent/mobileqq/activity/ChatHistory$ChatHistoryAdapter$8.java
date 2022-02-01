package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.utils.FileUtils;

class ChatHistory$ChatHistoryAdapter$8
  implements QueryCallback<PicEmoticonInfo>
{
  ChatHistory$ChatHistoryAdapter$8(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, ImageView paramImageView1, MarkFaceMessage paramMarkFaceMessage, ImageView paramImageView2, MessageRecord paramMessageRecord) {}
  
  public void a(PicEmoticonInfo paramPicEmoticonInfo)
  {
    Object localObject;
    int i;
    if (paramPicEmoticonInfo != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramPicEmoticonInfo);
      String str2 = EmoticonUtils.pngFramePath.replace("[epId]", paramPicEmoticonInfo.emoticon.epId);
      String str1 = "";
      localObject = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam != null)
      {
        localObject = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam.length > 0) {
          localObject = new String(this.jdField_a_of_type_ComTencentMobileqqDataMarkFaceMessage.mobileparam);
        }
      }
      i = PngFrameUtil.a((String)localObject);
      if ((!FileUtils.a(str2)) || (i != 1)) {
        break label194;
      }
      i = 3;
    }
    for (;;)
    {
      if (paramPicEmoticonInfo.isSound())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.getResources().getDrawable(2130847495);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.b.setMinimumHeight((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a * 100.0F));
        this.b.setMinimumWidth((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a * 100.0F));
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a(this.b, i, paramPicEmoticonInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
        label194:
        if (paramPicEmoticonInfo.isBigImageExists())
        {
          i = 2;
          break;
        }
        if (!paramPicEmoticonInfo.isAioPreviewExists()) {
          break label258;
        }
        i = 1;
        break;
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.getResources().getDrawable(2130838122);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        }
      }
      label258:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.8
 * JD-Core Version:    0.7.0.1
 */