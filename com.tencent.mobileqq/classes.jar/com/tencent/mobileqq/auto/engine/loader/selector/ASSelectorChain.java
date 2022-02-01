package com.tencent.mobileqq.auto.engine.loader.selector;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ASSelectorChain
{
  private List<IPluginSelector<ASPluginBean>> a = new ArrayList();
  
  private void a(@NonNull ASPluginBean paramASPluginBean)
  {
    String str1 = new Gson().toJson(paramASPluginBean);
    if (TextUtils.isEmpty(str1))
    {
      QLog.d(ASDynamicEngine.a(paramASPluginBean.getBusinessKey()), 1, "writeCurrentBeanToLocal failed");
      return;
    }
    String str2 = ASDynamicEngine.a(paramASPluginBean.getBusinessKey());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeCurrentBeanToLocal :");
    localStringBuilder.append(str1);
    QLog.d(str2, 1, localStringBuilder.toString());
    SharePreferenceUtils.a(BaseApplication.getContext(), "ASSelectorChain", c(paramASPluginBean.getBusinessKey()), str1);
  }
  
  private ASPluginBean b(String paramString)
  {
    return null;
  }
  
  private String c(@NonNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(ASEngineUtils.b());
    localStringBuilder.append("_");
    localStringBuilder.append(QUA.getQUA3());
    return localStringBuilder.toString();
  }
  
  public ASPluginBean a(String paramString)
  {
    Object localObject1 = b(paramString);
    if (localObject1 != null)
    {
      localObject2 = ASDynamicEngine.a(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentBean debug intercept:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
      return localObject1;
    }
    localObject1 = SharePreferenceUtils.b(BaseApplication.getContext(), "ASSelectorChain", c(paramString));
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QLog.d(ASDynamicEngine.a(paramString), 1, "ASSelectorChain getCurrentBean native");
      return new ASPluginBean().setBusinessKey(paramString).setType("TYPE_NATIVE").setVersionCode(ASEngineUtils.a());
    }
    localObject1 = (ASPluginBean)new Gson().fromJson((String)localObject1, ASPluginBean.class);
    paramString = ASDynamicEngine.a(paramString);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ASSelectorChain getCurrentBean success:");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.d(paramString, 1, ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public ASSelectorChain a(IPluginSelector<ASPluginBean> paramIPluginSelector)
  {
    this.a.add(paramIPluginSelector);
    return this;
  }
  
  public ASSelectorChain a(List<IPluginSelector<ASPluginBean>> paramList)
  {
    this.a.addAll(paramList);
    return this;
  }
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ASPluginBean localASPluginBean = ((IPluginSelector)localIterator.next()).a();
      if (localASPluginBean != null) {
        a(localASPluginBean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASSelectorChain
 * JD-Core Version:    0.7.0.1
 */