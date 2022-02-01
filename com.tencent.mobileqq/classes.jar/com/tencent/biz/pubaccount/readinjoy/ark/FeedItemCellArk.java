package com.tencent.biz.pubaccount.readinjoy.ark;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import mqq.app.AppRuntime;

public class FeedItemCellArk
{
  private View a;
  
  public FeedItemCellArk(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    if (ReadInJoyUtils.a() != null)
    {
      paramArkAppMessage = ReadInJoyUtils.a().getApplication();
      if (paramArkAppMessage != null) {}
    }
    else
    {
      return;
    }
    this.a = new View(paramArkAppMessage);
    this.a.setVisibility(8);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a() {}
  
  public void a(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.FeedItemCellArk
 * JD-Core Version:    0.7.0.1
 */