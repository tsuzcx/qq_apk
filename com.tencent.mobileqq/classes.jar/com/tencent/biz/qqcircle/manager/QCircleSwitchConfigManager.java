package com.tencent.biz.qqcircle.manager;

import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class QCircleSwitchConfigManager
{
  public static volatile QCircleSwitchConfigManager a;
  private int b = -1;
  
  public static QCircleSwitchConfigManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleSwitchConfigManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean b()
  {
    int i = this.b;
    boolean bool = false;
    if (i == -1)
    {
      this.b = QCircleConfigHelper.a("qqcircle", "qqcircle_show_barrage_personal_switch", Integer.valueOf(0)).intValue();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBarrageOpen  first time, sBarrageSwitch = ");
      localStringBuilder.append(this.b);
      QLog.i("QCircleBarrageSwitchManager", 1, localStringBuilder.toString());
    }
    if (this.b == 1) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    this.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager
 * JD-Core Version:    0.7.0.1
 */