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
    long l1 = GameCenterSpUtils.a("LAST_GET_CONF_VERSION");
    if (QLog.isColorLevel()) {
      QLog.d("QQGameConfigServiceImpl", 2, "checkConfigUpdate isForce=" + this.jdField_a_of_type_Boolean + ",newVersion=" + this.jdField_a_of_type_Long + ",currVersion=" + l1);
    }
    if ((this.jdField_a_of_type_Long > -1L) && (this.jdField_a_of_type_Long == l1) && (this.this$0.getConfigFile().exists())) {}
    long l2;
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
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
        QQGameConfigServiceImpl.access$202(this.this$0, GameCenterSpUtils.a("LAST_GET_CONF_TIME"));
      }
      l2 = System.currentTimeMillis();
    } while ((QQGameConfigServiceImpl.access$200(this.this$0) + 86400000L >= l2) && (QQGameConfigServiceImpl.access$200(this.this$0) <= l2));
    this.this$0.requestConfig(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameConfigServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */