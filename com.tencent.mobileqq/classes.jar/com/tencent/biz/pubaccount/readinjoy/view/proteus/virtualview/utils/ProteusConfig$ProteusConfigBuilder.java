package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;

public class ProteusConfig$ProteusConfigBuilder
{
  private ProteusConfig config = new ProteusConfig();
  
  public ProteusConfig build()
  {
    return this.config;
  }
  
  public ProteusConfigBuilder withCustomMethodInterface(CustomMethodsRegister.CustomMethodInterface paramCustomMethodInterface)
  {
    this.config.customMethodInterface = paramCustomMethodInterface;
    return this;
  }
  
  public ProteusConfigBuilder withDrawableHelper(DrawableUtil.DrawableHelper paramDrawableHelper)
  {
    this.config.drawableHelper = paramDrawableHelper;
    return this;
  }
  
  public ProteusConfigBuilder withDtReporter(IProteusDtReporter paramIProteusDtReporter)
  {
    this.config.dtReporter = paramIProteusDtReporter;
    return this;
  }
  
  public ProteusConfigBuilder withLogger(LogUtil.ProteusLog paramProteusLog)
  {
    this.config.proteusLog = paramProteusLog;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ProteusConfig.ProteusConfigBuilder
 * JD-Core Version:    0.7.0.1
 */