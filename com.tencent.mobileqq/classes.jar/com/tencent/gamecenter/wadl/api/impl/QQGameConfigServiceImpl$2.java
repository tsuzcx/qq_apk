package com.tencent.gamecenter.wadl.api.impl;

import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class QQGameConfigServiceImpl$2
  implements Runnable
{
  QQGameConfigServiceImpl$2(QQGameConfigServiceImpl paramQQGameConfigServiceImpl, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    long l1 = GameCenterSpUtils.c("LAST_GET_CONF_VERSION");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkConfigUpdate isForce=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",newVersion=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",currVersion=");
    localStringBuilder.append(l1);
    QLog.d("Wadl_QQGameConfigServiceImpl", 1, localStringBuilder.toString());
    long l2 = this.b;
    if ((l2 > -1L) && (l2 == l1) && (this.this$0.getConfigFile().exists())) {
      return;
    }
    if (this.a)
    {
      this.this$0.requestConfig(l1);
      return;
    }
    if (QQGameConfigServiceImpl.access$100(this.this$0) >= 3)
    {
      QQGameConfigServiceImpl.access$202(this.this$0, System.currentTimeMillis());
      QQGameConfigServiceImpl.access$102(this.this$0, (short)0);
      return;
    }
    if (QQGameConfigServiceImpl.access$200(this.this$0) == -1L) {
      QQGameConfigServiceImpl.access$202(this.this$0, GameCenterSpUtils.c("LAST_GET_CONF_TIME"));
    }
    l2 = System.currentTimeMillis();
    if ((QQGameConfigServiceImpl.access$200(this.this$0) + 86400000L >= l2) && (QQGameConfigServiceImpl.access$200(this.this$0) <= l2)) {
      return;
    }
    this.this$0.requestConfig(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */