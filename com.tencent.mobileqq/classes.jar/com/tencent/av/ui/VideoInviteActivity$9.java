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
    this.b.m();
    if (this.b.H != null)
    {
      this.b.H.b(this.b.j, this.b.o, this.b.q);
      this.b.H.c(this.b.e.az, this.b.e.aB);
    }
  }
  
  protected void a(long paramLong, int paramInt, String paramString)
  {
    if (TextUtils.equals(this.b.o, paramString))
    {
      if (QLog.isColorLevel())
      {
        String str = this.b.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClose  wrong uin: ");
        localStringBuilder.append(this.b.o);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      return;
    }
    if (!this.b.e.h())
    {
      TraeHelper.b(this.b.H);
      if ((this.b.Z) && (this.b.R != null) && (!this.b.r()))
      {
        this.b.R.a(new VideoInviteActivity.9.1(this, paramInt));
        return;
      }
      this.b.d().a(this.b.o, 251);
      this.b.d().b(251);
      this.b.d().b(this.b.o, paramInt);
      paramString = this.b;
      paramString.s = true;
      QLog.d(paramString.a, 1, "onClose()-> else ->finish  ");
      this.b.finish();
    }
  }
  
  protected void a(String paramString, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.b.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetStrangeFace uin = ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.b.j == 25)
    {
      localObject = new AvatarParam(this.b.j, paramString, this.b.q, true);
      this.b.E.a(this.b.H, this.b.y, (AvatarParam)localObject, paramBitmap);
    }
    super.a(paramString, paramBitmap);
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((this.b.o != null) && (this.b.o.equals(paramString)))
    {
      String str;
      StringBuilder localStringBuilder;
      if (QLog.isDevelopLevel())
      {
        str = this.b.a;
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
        TraeHelper.b(this.b.H);
        if ((this.b.Z) && (this.b.R != null) && (!this.b.r()))
        {
          if (QLog.isDevelopLevel())
          {
            str = this.b.a;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDestroyUI, outAnim, peer[");
            localStringBuilder.append(paramString);
            localStringBuilder.append("], isQuit[");
            localStringBuilder.append(paramBoolean);
            localStringBuilder.append("]");
            QLog.i(str, 4, localStringBuilder.toString());
          }
          this.b.R.a(new VideoInviteActivity.9.2(this));
          return;
        }
        if (QLog.isDevelopLevel())
        {
          str = this.b.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDestroyUI, noAnim, peer[");
          localStringBuilder.append(paramString);
          localStringBuilder.append("], isQuit[");
          localStringBuilder.append(paramBoolean);
          localStringBuilder.append("]");
          QLog.i(str, 4, localStringBuilder.toString());
        }
        paramString = this.b;
        paramString.s = paramBoolean;
        paramString.finish();
      }
    }
  }
  
  protected void b(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  protected void c(int paramInt)
  {
    String str;
    Object localObject;
    if (QLog.isColorLevel())
    {
      str = this.b.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPlayAnnimate, id[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], FunCallId[");
      ((StringBuilder)localObject).append(this.b.ab);
      ((StringBuilder)localObject).append("], isDestroy[");
      ((StringBuilder)localObject).append(this.b.aa);
      ((StringBuilder)localObject).append("]");
      QLog.w(str, 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == this.b.ab)
    {
      if (this.b.aa) {
        return;
      }
      int i = VipFunCallUtil.c();
      str = VipFunCallUtil.a(this.b.H, paramInt, i, null);
      localObject = new File(str);
      int j = this.b.e.g;
      if ((((File)localObject).exists()) && (this.b.e.i != 4) && ((j == 1) || (j == 0)) && (this.b.J != null))
      {
        if (this.b.N == null)
        {
          localObject = this.b;
          ((VideoInviteActivity)localObject).N = VipFunCallManager.a((Activity)((VideoInviteActivity)localObject).O.get(), this.b.J, false);
        }
        if (VipFunCallUtil.a(this.b.H.getApp().getApplicationContext(), this.b.N, str, i, null, paramInt, false))
        {
          this.b.a(true);
          ImmersiveUtils.setStatusTextColor(false, this.b.getWindow());
        }
      }
      if (QLog.isColorLevel())
      {
        str = this.b.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("VideoInviteFull onPlayAnnimate finish id:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d(str, 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if (this.b.j == 25)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.b.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoInviteActivity onGetQCallNickName nickName:");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      if (this.b.z != null)
      {
        localObject = this.b;
        ((VideoInviteActivity)localObject).p = paramString;
        ((VideoInviteActivity)localObject).z.setText(this.b.p);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.9
 * JD-Core Version:    0.7.0.1
 */