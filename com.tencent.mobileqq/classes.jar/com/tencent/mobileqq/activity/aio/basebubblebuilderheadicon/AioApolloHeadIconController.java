package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.extendfriend.apollo.aio.ApolloVasAvatar;
import com.tencent.mobileqq.extendfriend.apollo.face.Util;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.vas.avatar.VasAvatarLoader;

public class AioApolloHeadIconController
  extends BaseDefaultHeadIconController
{
  private String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend()) {
      return paramChatMessage.selfuin;
    }
    return paramChatMessage.senderuin;
  }
  
  private void b(Object paramObject)
  {
    int i = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar = new ApolloVasAvatar(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setId(2131364643);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setScaleType(ImageView.ScaleType.FIT_XY);
      localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.a(45.0F), ViewUtils.a(60.0F));
      localLayoutParams.topMargin = 0;
      localLayoutParams.addRule(3, 2131364642);
      if (c() == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, b());
        a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, localLayoutParams);
        b(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar);
        label141:
        if (!(paramObject instanceof Drawable)) {
          break label340;
        }
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setImageDrawable((Drawable)paramObject);
      }
    }
    for (;;)
    {
      a(8);
      return;
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if (a() != 8) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localLayoutParams.leftMargin = i)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.getLayoutParams();
      localLayoutParams.topMargin = 0;
      localLayoutParams.addRule(3, 2131364642);
      if (c() == 1)
      {
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(9, 0);
        localLayoutParams.rightMargin = i;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.addRule(3, b());
        break label141;
      }
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(11, 0);
      if (a() != 8) {}
      for (localLayoutParams.leftMargin = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());; localLayoutParams.leftMargin = i)
      {
        localLayoutParams.rightMargin = 0;
        break;
      }
      label340:
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar.setLoader(null, (VasAvatarLoader)paramObject);
    }
  }
  
  protected void a()
  {
    String str = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    b(Util.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
  }
  
  public boolean a()
  {
    return AioApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.AioApolloHeadIconController
 * JD-Core Version:    0.7.0.1
 */