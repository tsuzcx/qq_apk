package com.tencent.biz.pubaccount.readinjoy.viewmodels;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import psw;
import slx;

public class ArticleViewModel$1
  implements Runnable
{
  public ArticleViewModel$1(slx paramslx) {}
  
  public void run()
  {
    CharSequence localCharSequence = psw.a((ArticleInfo)slx.a(this.this$0));
    ThreadManager.getUIHandler().post(new ArticleViewModel.1.1(this, localCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viewmodels.ArticleViewModel.1
 * JD-Core Version:    0.7.0.1
 */