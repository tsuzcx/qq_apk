package com.tencent.biz.pubaccount.readinjoy.view.proteus;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.CustomMethodsRegister;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ProteusConfig;

public class Proteus
{
  private static volatile Proteus instance;
  private static ProteusConfig proteusConfig;
  
  public static Proteus getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new Proteus();
      }
      return instance;
    }
    finally {}
  }
  
  public IProteusDtReporter getDtReporter()
  {
    if (proteusConfig != null) {
      return proteusConfig.dtReporter;
    }
    return null;
  }
  
  public void init(ProteusConfig paramProteusConfig)
  {
    if (paramProteusConfig == null) {}
    do
    {
      return;
      proteusConfig = paramProteusConfig;
      if (paramProteusConfig.proteusLog != null) {
        LogUtil.setProteusLog(paramProteusConfig.proteusLog);
      }
      if (paramProteusConfig.customMethodInterface != null) {
        CustomMethodsRegister.registerCustomMethod(paramProteusConfig.customMethodInterface);
      }
    } while (paramProteusConfig.drawableHelper == null);
    DrawableUtil.setDrawableHelper(paramProteusConfig.drawableHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.Proteus
 * JD-Core Version:    0.7.0.1
 */