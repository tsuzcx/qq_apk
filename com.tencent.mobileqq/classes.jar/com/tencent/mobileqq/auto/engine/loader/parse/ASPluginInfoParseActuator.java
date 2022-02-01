package com.tencent.mobileqq.auto.engine.loader.parse;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class ASPluginInfoParseActuator
{
  private final String a;
  private final ConcurrentHashMap<String, ASPluginBean> b = new ConcurrentHashMap();
  
  public ASPluginInfoParseActuator(@NonNull String paramString)
  {
    this.a = paramString;
  }
  
  private void b()
  {
    ASPluginBean localASPluginBean = ASDynamicEngineFactory.a(this.a).a().a(this.a);
    if (localASPluginBean == null)
    {
      QLog.d("ASDynamicEngine", 1, "netBean is empty");
      return;
    }
    String str = ASDynamicEngine.a(localASPluginBean.getBusinessKey());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initNetParse");
    localStringBuilder.append(localASPluginBean);
    QLog.d(str, 1, localStringBuilder.toString());
    localASPluginBean = new ASPluginNetInfoParse(localASPluginBean).b();
    if (localASPluginBean != null) {
      this.b.put(localASPluginBean.getType(), localASPluginBean);
    }
  }
  
  private void c()
  {
    ASPluginBean localASPluginBean = new ASPluginBean().setBusinessKey(this.a).setType("TYPE_NATIVE").setVersionCode(ASEngineUtils.a());
    this.b.put(localASPluginBean.getType(), localASPluginBean);
    QLog.d(ASDynamicEngine.a(this.a), 1, "initNativeParse() create a fake bean");
  }
  
  public ConcurrentHashMap<String, ASPluginBean> a()
  {
    if (this.b.size() > 0) {
      return this.b;
    }
    c();
    b();
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.parse.ASPluginInfoParseActuator
 * JD-Core Version:    0.7.0.1
 */