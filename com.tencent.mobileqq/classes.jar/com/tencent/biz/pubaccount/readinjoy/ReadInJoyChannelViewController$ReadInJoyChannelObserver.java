package com.tencent.biz.pubaccount.readinjoy;

import android.content.res.Configuration;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import java.util.List;

class ReadInJoyChannelViewController$ReadInJoyChannelObserver
  extends ReadInJoyObserver
{
  private ReadInJoyChannelViewController$ReadInJoyChannelObserver(ReadInJoyChannelViewController paramReadInJoyChannelViewController) {}
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt, paramArticleInfo, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((ReadInJoyChannelViewController.a(this.a) == 56) && (ReadInJoyChannelViewController.a(this.a) != null))
    {
      ReadInJoyChannelViewController.a(this.a).f();
      ReadInJoyChannelViewController.a(this.a).g();
    }
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramConfiguration);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean, paramInt, paramLong, paramList, paramList1);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void aj_()
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).m();
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).b(paramInt, paramList);
    }
  }
  
  public void d(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList)
  {
    if ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void f_(int paramInt)
  {
    if ((ReadInJoyChannelViewController.a(this.a) != null) && ((ReadInJoyChannelViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ReadInJoyChannelViewController.a(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController.ReadInJoyChannelObserver
 * JD-Core Version:    0.7.0.1
 */