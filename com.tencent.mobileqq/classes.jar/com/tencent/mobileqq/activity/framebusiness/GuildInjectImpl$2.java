package com.tencent.mobileqq.activity.framebusiness;

import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.qphone.base.util.QLog;

final class GuildInjectImpl$2
  extends QQGuildObserver
{
  public void a(Object paramObject, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQGuildObserver", 4, "onUserTypeUpdate() -> refresh tab");
    }
    QCircleInjectImpl.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl.2
 * JD-Core Version:    0.7.0.1
 */