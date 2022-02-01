package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import java.util.List;

class ReadInJoyDailyViewController$1
  extends ReadInJoyObserver
{
  ReadInJoyDailyViewController$1(ReadInJoyDailyViewController paramReadInJoyDailyViewController) {}
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup)) && (paramInt == ReadInJoyDailyViewController.a(this.a)))
    {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      ReadInJoyDailyViewController.a(this.a);
    }
  }
  
  public void aj_()
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).m();
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).b(paramInt, paramList);
    }
  }
  
  public void d(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList)
  {
    if ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void f_(int paramInt)
  {
    if ((ReadInJoyDailyViewController.a(this.a) != null) && ((ReadInJoyDailyViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyDailyViewController.a(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyDailyViewController.1
 * JD-Core Version:    0.7.0.1
 */