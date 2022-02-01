package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;
import com.tencent.mobileqq.app.face.DynamicFaceDrawable;
import com.tencent.qphone.base.util.QLog;

class DynamicAvatarView$2
  implements VideoDrawable.OnPlayRepeatListener
{
  DynamicAvatarView$2(DynamicAvatarView paramDynamicAvatarView) {}
  
  public void onPlayRepeat(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPlayRepeat: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.a.b)
    {
      if (paramInt < 1) {
        return;
      }
      if (this.a.a != null)
      {
        localObject = this.a.a.jdField_a_of_type_ComTencentImageURLDrawable;
        if ((localObject instanceof URLDrawable))
        {
          localObject = ((URLDrawable)localObject).getCurrDrawable();
          if ((localObject instanceof VideoDrawable))
          {
            ((VideoDrawable)localObject).removeOnPlayRepeatListener(this);
            this.a.a.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarManager.a(this.a.a, true);
            if (QLog.isColorLevel()) {
              QLog.e("Q.dynamicAvatar", 2, "removeOnPlayRepeatListener.03");
            }
          }
        }
        this.a.a.jdField_a_of_type_ComTencentImageURLDrawable = null;
        this.a.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView.2
 * JD-Core Version:    0.7.0.1
 */