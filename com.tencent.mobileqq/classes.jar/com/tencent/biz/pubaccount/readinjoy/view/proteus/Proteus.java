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
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new Proteus();
        }
      }
      finally {}
    }
    return instance;
  }
  
  public IProteusDtReporter getDtReporter()
  {
    ProteusConfig localProteusConfig = proteusConfig;
    if (localProteusConfig != null) {
      return localProteusConfig.dtReporter;
    }
    return null;
  }
  
  public void init(ProteusConfig paramProteusConfig)
  {
    if (paramProteusConfig == null) {
      return;
    }
    proteusConfig = paramProteusConfig;
    if (paramProteusConfig.proteusLog != null) {
      LogUtil.setProteusLog(paramProteusConfig.proteusLog);
    }
    if (paramProteusConfig.customMethodInterface != null) {
      CustomMethodsRegister.registerCustomMethod(paramProteusConfig.customMethodInterface);
    }
    if (paramProteusConfig.drawableHelper != null) {
      DrawableUtil.setDrawableHelper(paramProteusConfig.drawableHelper);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.Proteus
 * JD-Core Version:    0.7.0.1
 */