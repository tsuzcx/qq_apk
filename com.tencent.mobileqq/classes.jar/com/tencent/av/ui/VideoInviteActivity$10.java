package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$10
  extends GAudioUIObserver
{
  VideoInviteActivity$10(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a(long paramLong, int paramInt)
  {
    long l = AudioHelper.c();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.b.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyInviteUI, relationId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    boolean bool = this.b.G;
    if ((bool) && (this.b.o != null) && (this.b.o.equals(String.valueOf(paramLong))))
    {
      super.a(paramLong);
      TraeHelper.b(this.b.H);
      this.b.a(l);
      if ((bool) && (this.b.o.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.b.o).longValue();
        if (!this.b.F)
        {
          localObject = this.b;
          ((VideoInviteActivity)localObject).F = true;
          if (paramInt == 1) {
            ((VideoInviteActivity)localObject).d().a(l, paramLong, 7);
          } else if (paramInt == 2) {
            ((VideoInviteActivity)localObject).d().a(l, paramLong, 2);
          }
        }
      }
      localObject = this.b;
      ((VideoInviteActivity)localObject).s = true;
      if ((((VideoInviteActivity)localObject).Z) && (this.b.R != null) && (!this.b.r()))
      {
        this.b.R.a(new VideoInviteActivity.10.1(this));
        return;
      }
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.10
 * JD-Core Version:    0.7.0.1
 */