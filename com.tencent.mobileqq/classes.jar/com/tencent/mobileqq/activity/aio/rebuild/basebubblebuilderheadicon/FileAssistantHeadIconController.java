package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

public class FileAssistantHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  public boolean a()
  {
    return (!this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) && (QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
  }
  
  protected void b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("dataline_msg_device_type");
    int i;
    if (!TextUtils.isEmpty(str)) {
      i = QFileAssistantUtils.a(Integer.valueOf(str).intValue());
    } else {
      i = 2130844288;
    }
    b(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i));
  }
  
  protected void c()
  {
    a(null);
  }
  
  protected void d()
  {
    a(null);
  }
  
  protected void g()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.FileAssistantHeadIconController
 * JD-Core Version:    0.7.0.1
 */