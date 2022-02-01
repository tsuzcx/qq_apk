package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class CustomizeByBizHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean b()
  {
    return ((TempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
  }
  
  protected void a()
  {
    Object localObject = ((TempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_CHAT_PLUGIN_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
    if (localObject != null) {}
    for (localObject = ((AbstractTempChatPlugin)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, TempChatSource.SOURCE_FROM_AIO);; localObject = null)
    {
      a(localObject);
      return;
    }
  }
  
  public boolean a()
  {
    return b();
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.CustomizeByBizHeadIconController
 * JD-Core Version:    0.7.0.1
 */