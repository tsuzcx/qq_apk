package com.tencent.av.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vipav.VipFunCallManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;

class VideoInviteActivity$9
  extends VideoObserver
{
  VideoInviteActivity$9(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.h();
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_e_of_type_Int, this.a.c, this.a.jdField_e_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.A, this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.o);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.equals(this.a.c, paramString))
    {
      if (QLog.isColorLevel())
      {
        String str = this.a.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClose  wrong uin: ");
        localStringBuilder.append(this.a.c);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return;
    }
    if (!this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.h())
    {
      TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if ((this.a.l) && (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && (!this.a.f()))
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new VideoInviteActivity.9.1(this, paramInt));
        return;
      }
      this.a.a().a(this.a.c, 251);
      this.a.a().b(251);
      this.a.a().b(this.a.c, paramInt);
      paramString = this.a;
      paramString.jdField_e_of_type_Boolean = true;
      QLog.d(paramString.jdField_a_of_type_JavaLangString, 1, "onClose()-> else ->finish  ");
      this.a.finish();
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetStrangeFace uin = ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_e_of_type_Int == 25)
    {
      localObject = new AvatarParam(this.a.jdField_e_of_type_Int, paramString, this.a.jdField_e_of_type_JavaLangString, true);
      this.a.jdField_a_of_type_ComTencentAvAvatarQavUpdateAvatarViewHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.a.jdField_a_of_type_AndroidWidgetImageView, (AvatarParam)localObject, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((this.a.c != null) && (this.a.c.equals(paramString)))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isDevelopLevel())
      {
        str = this.a.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroyUI, peer[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], isQuit[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.i(str, 4, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        if ((this.a.l) && (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && (!this.a.f()))
        {
          if (QLog.isDevelopLevel())
          {
            str = this.a.jdField_a_of_type_JavaLangString;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDestroyUI, outAnim, peer[");
            localStringBuilder.append(paramString);
            localStringBuilder.append("], isQuit[");
            localStringBuilder.append(paramBoolean);
            localStringBuilder.append("]");
            QLog.i(str, 4, localStringBuilder.toString());
          }
          this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new VideoInviteActivity.9.2(this));
          return;
        }
        if (QLog.isDevelopLevel())
        {
          str = this.a.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDestroyUI, noAnim, peer[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], isQuit[");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append("]");
          QLog.i(str, 4, localStringBuilder.toString());
        }
        paramString = this.a;
        paramString.jdField_e_of_type_Boolean = paramBoolean;
        paramString.finish();
      }
    }
  }
  
  protected void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void c(int paramInt)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.a.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPlayAnnimate, id[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], FunCallId[");
      ((StringBuilder)localObject).append(this.a.j);
      ((StringBuilder)localObject).append("], isDestroy[");
      ((StringBuilder)localObject).append(this.a.m);
      ((StringBuilder)localObject).append("]");
      QLog.w(str, 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == this.a.j)
    {
      if (this.a.m) {
        return;
      }
      int i = VipFunCallUtil.a();
      str = VipFunCallUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, i, null);
      localObject = new File(str);
      int j = this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.d;
      if ((((File)localObject).exists()) && (this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.f != 4) && ((j == 1) || (j == 0)) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView == null)
        {
          localObject = this.a;
          ((VideoInviteActivity)localObject).jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView = VipFunCallManager.a((Activity)((VideoInviteActivity)localObject).jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
        }
        if (VipFunCallUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getApplicationContext(), this.a.jdField_a_of_type_ComTencentMobileqqVasVipavVipFullScreenVideoView, str, i, null, paramInt, false))
        {
          this.a.a(true);
          ImmersiveUtils.setStatusTextColor(false, this.a.getWindow());
        }
      }
      if (QLog.isColorLevel())
      {
        str = this.a.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VideoInviteFull onPlayAnnimate finish id:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d(str, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void d(String paramString)
  {
    super.d(paramString);
    if (this.a.jdField_e_of_type_Int == 25)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.a.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoInviteActivity onGetQCallNickName nickName:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = this.a;
        ((VideoInviteActivity)localObject).d = paramString;
        ((VideoInviteActivity)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(this.a.d);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.9
 * JD-Core Version:    0.7.0.1
 */