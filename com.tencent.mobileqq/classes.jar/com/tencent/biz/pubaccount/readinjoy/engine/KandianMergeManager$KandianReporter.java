package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager;
import cooperation.readinjoy.content.ReadInJoyDataProviderObserver.Reporter;

public class KandianMergeManager$KandianReporter
  extends ReadInJoyDataProviderObserver.Reporter
{
  public void a(String paramString)
  {
    TaskManager.getInstance().accept(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.KandianReporter
 * JD-Core Version:    0.7.0.1
 */