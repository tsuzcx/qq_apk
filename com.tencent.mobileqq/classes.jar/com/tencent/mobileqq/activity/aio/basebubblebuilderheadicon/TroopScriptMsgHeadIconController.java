package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.vas.avatar.VasAvatar;

public class TroopScriptMsgHeadIconController
  extends BaseBubbleBuilderHeadIconController
{
  protected void a()
  {
    a(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840556));
  }
  
  public boolean a()
  {
    return TroopBindPublicAccountMgr.a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
  
  protected void b()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setOnLongClickListener(null);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.TroopScriptMsgHeadIconController
 * JD-Core Version:    0.7.0.1
 */