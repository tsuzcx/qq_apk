package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.webviewplugin.PubAccountPreloadPlugin;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class ReadInJoyChannelWaterFallViewController$InnerReadInJoyObserver
  extends ReadInJoyObserver
{
  private ReadInJoyChannelWaterFallViewController$InnerReadInJoyObserver(ReadInJoyChannelWaterFallViewController paramReadInJoyChannelWaterFallViewController) {}
  
  private void c(String paramString) {}
  
  private void d(List<Long> paramList)
  {
    Object localObject = ReadInJoyUtils.a();
    if ((!ReadInJoyHelper.C((AppRuntime)localObject)) || (!ReadInJoyHelper.D((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int i = 5;; i = paramList.size())
    {
      localObject = new ArrayList();
      int j = 0;
      while (j < i)
      {
        long l = ((Long)paramList.get(j)).longValue();
        ArticleInfo localArticleInfo = ReadInJoyLogicEngine.a().a(ReadInJoyChannelWaterFallViewController.a(this.a), l);
        if ((localArticleInfo != null) && (!RIJFeedsType.a(localArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localArticleInfo);
        }
        j += 1;
      }
    }
    ReadInJoyLogicEngine.a().a().a((List)localObject);
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if (paramInt != ReadInJoyChannelWaterFallViewController.a(this.a)) {
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 1);
      Object localObject1 = (Long)paramList.get(0);
      Object localObject2 = ReadInJoyLogicEngine.a().a(ReadInJoyChannelWaterFallViewController.a(this.a), ((Long)localObject1).longValue());
      StringBuilder localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
      if (localObject2 != null)
      {
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = RIJAppSetting.a((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label285;
        }
      }
      label285:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyChannelWaterFallViewController_" + ReadInJoyChannelWaterFallViewController.a(this.a), 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label326;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyChannelWaterFallViewController_" + ReadInJoyChannelWaterFallViewController.a(this.a), 1, ((StringBuilder)localObject1).toString());
    }
    label326:
    this.a.a.a(true, true);
    paramList = this.a;
    if (!ReadInJoyChannelWaterFallViewController.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!ReadInJoyChannelWaterFallViewController.a(paramList, bool)) {
        ReadInJoyChannelWaterFallViewController.a(this.a);
      }
      if (ReadInJoyChannelWaterFallViewController.a(this.a)) {
        break;
      }
      ReadInJoyChannelWaterFallViewController.b(this.a, true);
      return;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    super.a(paramInt, paramBoolean, paramList);
    if ((paramInt == ReadInJoyChannelWaterFallViewController.a(this.a)) && (paramBoolean) && (paramList != null) && (!paramList.isEmpty())) {
      this.a.a.c(paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo) {}
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      ReadInJoyChannelWaterFallViewController.a(this.a);
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l = ((Long)paramList.get(i)).longValue();
          Object localObject = ReadInJoyLogicEngine.a().a(ReadInJoyChannelWaterFallViewController.a(this.a), l);
          if ((localObject != null) && (!RIJFeedsType.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!RIJFeedsType.a((BaseArticleInfo)localObject)) && (!ReadInJoyLogicEngine.a().a(((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (PubAccountPreloadPlugin.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if (paramInt != ReadInJoyChannelWaterFallViewController.a(this.a)) {
      return;
    }
    paramInt = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt));
    Object localObject;
    if (paramBoolean1) {
      if ((paramList != null) && (paramInt > 0) && (paramList.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("onChannelRefreshed ");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyChannelWaterFallViewController_" + ReadInJoyChannelWaterFallViewController.a(this.a), 1, ((StringBuilder)localObject).toString());
        }
        ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 1);
        localObject = String.format(this.a.a().getResources().getString(2131718094), new Object[] { Integer.valueOf(paramInt) });
        this.a.a.a(true, (String)localObject);
      }
    }
    for (;;)
    {
      a(paramList);
      d(paramList);
      return;
      if (this.a.a.a())
      {
        this.a.a.b(true);
        c(this.a.a().getResources().getString(2131718345));
      }
      else
      {
        localObject = this.a.a().getResources().getString(2131718093);
        this.a.a.a(true, (String)localObject);
        continue;
        if (this.a.a.a()) {
          c(this.a.a().getResources().getString(2131718306));
        }
        this.a.a.b(paramBoolean1);
      }
    }
  }
  
  public void aj_()
  {
    this.a.a.a();
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != ReadInJoyChannelWaterFallViewController.a(this.a)) || (paramList == null)) {
      return;
    }
    paramList = ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList);
    this.a.a.b(paramList);
    this.a.a.a();
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool = true;
    if (paramInt != ReadInJoyChannelWaterFallViewController.a(this.a))
    {
      ReadInJoyChannelWaterFallViewController.c(this.a, false);
      return;
    }
    if ((paramBoolean1) && (paramList != null)) {
      ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 2);
    }
    ReadInJoyPicWaterFallFragment.PicWaterFallViewInterface localPicWaterFallViewInterface;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean2 = true;
      localPicWaterFallViewInterface = this.a.a;
      if (paramBoolean2) {
        break label278;
      }
    }
    for (;;)
    {
      localPicWaterFallViewInterface.a(paramBoolean1, bool);
      if ((paramList != null) && (!paramList.isEmpty())) {
        ReadInJoyChannelWaterFallViewController.a(this.a, NetConnInfoCenter.getServerTime());
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyChannelWaterFallViewController", 2, "autoLoad:" + ReadInJoyChannelWaterFallViewController.b(this.a) + " noMoreData:" + paramBoolean2 + " fore:" + GesturePWDUtils.isAppOnForeground(this.a.a()));
      }
      if ((!ReadInJoyChannelWaterFallViewController.b(this.a)) && (paramBoolean2) && (GesturePWDUtils.isAppOnForeground(this.a.a())) && (ReadInJoyChannelWaterFallViewController.a(this.a) != 70))
      {
        paramList = this.a.a().getResources().getString(2131718093);
        QQToast.a(this.a.a().getApplicationContext(), paramList, 0).a();
      }
      ReadInJoyChannelWaterFallViewController.c(this.a, false);
      return;
      paramBoolean2 = false;
      break;
      label278:
      bool = false;
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt != ReadInJoyChannelWaterFallViewController.a(this.a)) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyChannelWaterFallViewController_" + ReadInJoyChannelWaterFallViewController.a(this.a), 1, localStringBuilder.toString());
        }
        ReadInJoyChannelWaterFallViewController.a(this.a, ReadInJoyLogicEngine.a().a(Integer.valueOf(ReadInJoyChannelWaterFallViewController.a(this.a)), paramList), 1);
        return;
      }
    } while (!this.a.a.a());
    c(this.a.a().getResources().getString(2131718345));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelWaterFallViewController.InnerReadInJoyObserver
 * JD-Core Version:    0.7.0.1
 */