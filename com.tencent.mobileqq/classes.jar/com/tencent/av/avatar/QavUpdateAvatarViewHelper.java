package com.tencent.av.avatar;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.ui.avatar.QavAvatarCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class QavUpdateAvatarViewHelper
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  private QavAvatarCallback jdField_a_of_type_ComTencentAvUiAvatarQavAvatarCallback = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a(AvatarParam paramAvatarParam)
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateAvatar, param = ");
        localStringBuilder.append(paramAvatarParam);
        QLog.i("QavAvatarHelper", 4, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentAvUiAvatarQavAvatarCallback == null) {
        this.jdField_a_of_type_ComTencentAvUiAvatarQavAvatarCallback = new QavUpdateAvatarViewHelper.1(this);
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUiAvatarQavAvatarCallback.a(paramAvatarParam, null);
      }
      this.jdField_a_of_type_Boolean = true;
      ThreadManager.excute(new QavUpdateAvatarViewHelper.2(this, paramAvatarParam), 16, null, false);
      return;
    }
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAvatar, fail view is null. param = ");
      localStringBuilder.append(paramAvatarParam);
      QLog.i("QavAvatarHelper", 4, localStringBuilder.toString());
    }
  }
  
  public void a(VideoAppInterface paramVideoAppInterface, ImageView paramImageView, AvatarParam paramAvatarParam, Bitmap paramBitmap)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAvatar, param = ");
      localStringBuilder.append(paramAvatarParam);
      localStringBuilder.append(", bitmap = ");
      localStringBuilder.append(paramBitmap);
      localStringBuilder.append(", app = ");
      localStringBuilder.append(paramVideoAppInterface);
      localStringBuilder.append(", headView = ");
      localStringBuilder.append(paramImageView);
      QLog.i("QavAvatarHelper", 4, localStringBuilder.toString());
    }
    if (paramBitmap != null)
    {
      if (paramImageView != null) {
        paramImageView.setImageBitmap(paramBitmap);
      }
    }
    else if (paramImageView != null)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != paramVideoAppInterface) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != paramImageView)
      {
        this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
        this.jdField_a_of_type_Boolean = false;
      }
      a(paramAvatarParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.avatar.QavUpdateAvatarViewHelper
 * JD-Core Version:    0.7.0.1
 */