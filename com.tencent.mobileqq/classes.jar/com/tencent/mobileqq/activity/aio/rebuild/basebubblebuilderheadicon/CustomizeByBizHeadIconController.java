package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

import com.tencent.mobileqq.activity.aio.coreui.basebubblebuilderheadicon.BaseBubbleBuilderHeadIconController;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempChatPluginManager;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.TempChatSource;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;

public class CustomizeByBizHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private boolean b()
  {
    return ((ITempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).isCustomizeByBiz(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
  }
  
  public boolean a()
  {
    return b();
  }
  
  protected void b()
  {
    Object localObject = ((ITempChatPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITempChatPluginManager.class, "")).getTempChatPlugin(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop);
    if (localObject != null) {
      localObject = ((AbstractTempChatPlugin)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, TempChatSource.SOURCE_FROM_AIO);
    } else {
      localObject = null;
    }
    b(localObject);
  }
  
  protected void c()
  {
    a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.CustomizeByBizHeadIconController
 * JD-Core Version:    0.7.0.1
 */