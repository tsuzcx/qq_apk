package com.tencent.biz.pubaccount.readinjoy;

import android.content.res.Configuration;
import com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerModule.ChannelBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJInvokeHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.IInsertArticleCallback;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyArticleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class KanDianViewController$KandianViewControllerObserver
  extends ReadInJoyObserver
{
  protected KanDianViewController$KandianViewControllerObserver(KanDianViewController paramKanDianViewController) {}
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt, paramArticleInfo, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (KanDianViewController.a(this.a) != null)
    {
      KanDianViewController.a(this.a).f();
      KanDianViewController.a(this.a).g();
    }
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramConfiguration);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(Long paramLong)
  {
    QLog.d("KanDianViewController", 1, "followArticle, pUin: " + paramLong);
    if (((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup)) && (KanDianViewController.a(this.a).a() == 0) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a() != null) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a() != null))
    {
      List localList = ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a().a();
      KanDianViewController.a(this.a, paramLong, localList);
    }
  }
  
  public void a(String paramString, List<ArticleInfo> paramList, RIJFeedsInsertController.IInsertArticleCallback paramIInsertArticleCallback)
  {
    QLog.d("KanDianViewController", 1, new Object[] { "insertArticleList, rowKey: " + paramString, " articleList: " + paramList });
    if (((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup)) && (KanDianViewController.a(this.a).a() == 0) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a() != null) && (((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a() != null) && (KanDianViewController.a(this.a, paramString, paramList))) {
      KanDianViewController.a(this.a, paramIInsertArticleCallback);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void aj_()
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).m();
    }
  }
  
  public void b()
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).r();
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup)))
    {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).b(paramInt, paramList);
      KanDianViewController.a(this.a, true);
    }
  }
  
  public void d(int paramInt, List<RIJChannelBannerModule.ChannelBannerInfo> paramList)
  {
    if ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      FrameworkHandler localFrameworkHandler = (FrameworkHandler)((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a().a(2);
      if (localFrameworkHandler != null) {
        localFrameworkHandler.b(paramInt, paramList);
      }
    }
  }
  
  public void f_(int paramInt)
  {
    if ((KanDianViewController.a(this.a) != null) && ((KanDianViewController.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)KanDianViewController.a(this.a)).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.KandianViewControllerObserver
 * JD-Core Version:    0.7.0.1
 */