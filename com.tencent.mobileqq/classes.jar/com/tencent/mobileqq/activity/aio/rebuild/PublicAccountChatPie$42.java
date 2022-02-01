package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class PublicAccountChatPie$42
  extends AvatarObserver
{
  PublicAccountChatPie$42(PublicAccountChatPie paramPublicAccountChatPie, ImageView paramImageView) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a().a))) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildPublicAccountChatPie.a, paramString, (byte)3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.42
 * JD-Core Version:    0.7.0.1
 */