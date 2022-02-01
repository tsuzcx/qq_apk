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
    long l = AudioHelper.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyInviteUI, relationId[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    boolean bool = this.a.i;
    if ((bool) && (this.a.c != null) && (this.a.c.equals(String.valueOf(paramLong))))
    {
      super.a(paramLong);
      TraeHelper.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      this.a.a(l);
      if ((bool) && (this.a.c.length() > 2) && (paramLong != 0L))
      {
        paramLong = Long.valueOf(this.a.c).longValue();
        if (!this.a.h)
        {
          localObject = this.a;
          ((VideoInviteActivity)localObject).h = true;
          if (paramInt == 1) {
            ((VideoInviteActivity)localObject).a().a(l, paramLong, 7);
          } else if (paramInt == 2) {
            ((VideoInviteActivity)localObject).a().a(l, paramLong, 2);
          }
        }
      }
      localObject = this.a;
      ((VideoInviteActivity)localObject).e = true;
      if ((((VideoInviteActivity)localObject).l) && (this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation != null) && (!this.a.f()))
      {
        this.a.jdField_a_of_type_ComTencentAvUiQavInOutAnimation.a(new VideoInviteActivity.10.1(this));
        return;
      }
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.10
 * JD-Core Version:    0.7.0.1
 */