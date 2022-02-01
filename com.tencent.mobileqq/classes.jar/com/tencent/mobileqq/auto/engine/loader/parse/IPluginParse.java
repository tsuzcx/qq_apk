package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import java.util.concurrent.Callable;

public abstract interface IPluginParse<T extends ASPluginBean>
  extends Callable<T>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.parse.IPluginParse
 * JD-Core Version:    0.7.0.1
 */