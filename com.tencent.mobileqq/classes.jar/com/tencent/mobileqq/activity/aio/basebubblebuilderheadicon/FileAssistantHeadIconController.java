package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class FileAssistantHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void a()
  {
    int i = 2130844382;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("dataline_msg_device_type");
    if (!TextUtils.isEmpty(str)) {
      i = QFileAssistantUtils.b(Integer.valueOf(str).intValue());
    }
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) && (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(null);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setTag(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.FileAssistantHeadIconController
 * JD-Core Version:    0.7.0.1
 */