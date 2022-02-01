package com.tencent.av.avatar;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.avatar.QavAvatarCallback;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;

class QavUpdateAvatarViewHelper$1
  implements QavAvatarCallback
{
  QavUpdateAvatarViewHelper$1(QavUpdateAvatarViewHelper paramQavUpdateAvatarViewHelper) {}
  
  public void a(AvatarParam paramAvatarParam, Drawable paramDrawable)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAvatar, param = ");
      localStringBuilder.append(paramAvatarParam);
      localStringBuilder.append(", drawable = ");
      localStringBuilder.append(paramDrawable);
      QLog.i("QavAvatarHelper", 4, localStringBuilder.toString());
    }
    if (paramDrawable == null)
    {
      paramAvatarParam = QavUpdateAvatarViewHelper.a(this.a).a(paramAvatarParam.jdField_a_of_type_Int, paramAvatarParam.jdField_a_of_type_JavaLangString, paramAvatarParam.b, paramAvatarParam.jdField_a_of_type_Boolean, true);
      ThreadManager.a().post(new QavUpdateAvatarViewHelper.1.1(this, paramAvatarParam));
      return;
    }
    ThreadManager.a().post(new QavUpdateAvatarViewHelper.1.2(this, paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avatar.QavUpdateAvatarViewHelper.1
 * JD-Core Version:    0.7.0.1
 */