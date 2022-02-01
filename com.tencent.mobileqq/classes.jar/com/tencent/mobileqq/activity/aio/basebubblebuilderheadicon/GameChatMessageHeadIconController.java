package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.message.RoleIdUtil;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class GameChatMessageHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  private View.OnClickListener a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject instanceof GameMsgChatPie))
        {
          localObject = (GameMsgChatPie)localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {
            return ((GameMsgChatPie)localObject).a();
          }
          return ((GameMsgChatPie)localObject).b();
        }
      }
    }
    return null;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend()) {}
    for (Object localObject = RoleIdUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);; localObject = RoleIdUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))
    {
      localObject = GameMsgUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject);
      if (localObject != null) {
        break;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840452));
      return;
    }
    a(localObject);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 10007;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnClickListener(a());
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.GameChatMessageHeadIconController
 * JD-Core Version:    0.7.0.1
 */