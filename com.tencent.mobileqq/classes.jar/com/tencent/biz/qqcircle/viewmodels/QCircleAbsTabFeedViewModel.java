package com.tencent.biz.qqcircle.viewmodels;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.QCircleTianShuBannerBlock;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper.QCircleFolderPageCache;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest.Builder;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.sender.call.Call.OnRspCallBack;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedBase.StPageRedPointInfo;
import qqcircle.QQCircleFeedBase.StTabInfo;

public abstract class QCircleAbsTabFeedViewModel
  extends QCircleBaseViewModel
  implements IDataDisplaySurface<FeedBlockData>, Call.OnRspCallBack, IQCircleReportSessionOperation
{
  protected final MutableLiveData<UIStateData<List<FeedBlockData>>> a = new MutableLiveData();
  protected final MutableLiveData<FeedBlockData> b = new MutableLiveData();
  protected QCircleTabInfo c;
  protected QQCircleFeedBase.StPageRedPointInfo d = null;
  protected String e = null;
  protected String f = null;
  protected boolean g;
  protected boolean h = false;
  protected FeedCloudCommon.StCommonExt i = null;
  protected List<FeedCloudMeta.StFeed> j = new ArrayList();
  
  protected Bundle a(int paramInt, boolean paramBoolean)
  {
    QCircleTabInfo localQCircleTabInfo = this.c;
    Bundle localBundle = new Bundle();
    int k;
    if (localQCircleTabInfo.a != null) {
      k = localQCircleTabInfo.a.tabType.get();
    } else {
      k = -1;
    }
    localBundle.putInt("extra_key_tab_type", k);
    localBundle.putInt("extra_key_pull_scene_type", paramInt);
    localBundle.putBoolean("extra_key_is_load_more", paramBoolean);
    return localBundle;
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> a(Object... paramVarArgs)
  {
    return this.a;
  }
  
  public abstract String a();
  
  protected List<FeedCloudMeta.StFeed> a(boolean paramBoolean, List<FeedCloudMeta.StFeed> paramList)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FeedCloudMeta.StFeed)localIterator.next();
        if (paramBoolean)
        {
          if (((FeedCloudMeta.StFeed)localObject).dittoFeed.dittoId.get() == 7) {
            localIterator.remove();
          } else if (((FeedCloudMeta.StFeed)localObject).dittoFeed.dittoId.get() == 9) {
            localIterator.remove();
          }
        }
        else if (((FeedCloudMeta.StFeed)localObject).dittoFeed.dittoId.get() == 10)
        {
          long l1 = QCirclePluginConfig.a().l();
          long l2 = System.currentTimeMillis() - l1;
          if ((l1 != 0L) && (l2 <= QCircleTianShuBannerBlock.a)) {
            paramBoolean = false;
          } else {
            paramBoolean = true;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("min interval:");
          ((StringBuilder)localObject).append(QCircleTianShuBannerBlock.a);
          ((StringBuilder)localObject).append(",current show interval:");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(",isValid:");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.d("QCircleFeedTianShuBannerView", 1, ((StringBuilder)localObject).toString());
          if (!paramBoolean)
          {
            localIterator.remove();
            QLog.d("QCircleFeedTianShuBannerView", 1, "remove tianshu banner data");
          }
        }
      }
    }
    return paramList;
  }
  
  public void a(int paramInt)
  {
    a(this.f, this.e, true, false, paramInt, null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QCircleFolderCacheHelper.a().a(this, paramInt1, paramInt2);
  }
  
  public void a(QCircleTabInfo paramQCircleTabInfo)
  {
    this.c = paramQCircleTabInfo;
  }
  
  protected void a(FeedBlockData paramFeedBlockData)
  {
    RFThreadManager.getUIHandler().post(new QCircleAbsTabFeedViewModel.2(this, paramFeedBlockData));
  }
  
  public void a(@NonNull QCircleFolderCacheHelper.QCircleFolderPageCache paramQCircleFolderPageCache)
  {
    this.j.clear();
    this.j.addAll(paramQCircleFolderPageCache.c());
    this.h = paramQCircleFolderPageCache.d();
    this.i = paramQCircleFolderPageCache.e();
    this.f = paramQCircleFolderPageCache.f();
    this.e = paramQCircleFolderPageCache.g();
  }
  
  protected void a(UIStateData paramUIStateData)
  {
    RFThreadManager.getUIHandler().post(new QCircleAbsTabFeedViewModel.1(this, paramUIStateData));
  }
  
  public void a(FeedCloudCommon.BytesEntry paramBytesEntry)
  {
    if (this.k != null) {
      this.k.addExtraSessionEntry(paramBytesEntry);
    }
  }
  
  public void a(String paramString)
  {
    if (QCircleBaseTabFragment.d.equals(paramString))
    {
      this.k = QCircleReporterAgent.obtain(1);
      return;
    }
    if (QCircleBaseTabFragment.e.equals(paramString))
    {
      this.k = QCircleReporterAgent.obtain(3);
      return;
    }
    if (QCircleBaseTabFragment.f.equals(paramString)) {
      this.k = QCircleReporterAgent.obtain(91);
    }
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, QCircleFolderBean paramQCircleFolderBean)
  {
    if (this.c == null)
    {
      QLog.e(a(), 1, "requestData() tabInfo is null!");
      return;
    }
    if (!paramBoolean1) {
      a(UIStateData.b());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestFeedsData");
    localStringBuilder.append(paramInt);
    QCircleCollection.a(localStringBuilder.toString());
    b(paramString1, paramString2, paramBoolean1, paramBoolean2, paramInt, paramQCircleFolderBean);
  }
  
  public void a(List<FeedCloudMeta.StFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.j.clear();
      this.j.addAll(paramList);
    }
  }
  
  protected void a(List<FeedBlockData> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    if (paramList.size() > 0)
    {
      paramList = (FeedBlockData)paramList.get(0);
      if (paramList.b().dittoFeed.dittoId.get() == 10)
      {
        a(paramList);
        return;
      }
      a(null);
      return;
    }
    a(null);
  }
  
  public void a(QQCircleFeedBase.StPageRedPointInfo paramStPageRedPointInfo)
  {
    this.d = paramStPageRedPointInfo;
  }
  
  public void a(boolean paramBoolean, int paramInt, QCircleFolderBean paramQCircleFolderBean)
  {
    a(null, this.e, false, paramBoolean, paramInt, paramQCircleFolderBean);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return (paramBoolean) && (this.j.size() > 0);
  }
  
  public QQCircleFeedBase.StTabInfo b()
  {
    QCircleTabInfo localQCircleTabInfo = this.c;
    if (localQCircleTabInfo != null) {
      return localQCircleTabInfo.a;
    }
    return null;
  }
  
  public void b(String paramString)
  {
    if (this.k != null) {
      this.k.removeExtraSessionEntry(paramString);
    }
  }
  
  protected abstract void b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, int paramInt, QCircleFolderBean paramQCircleFolderBean);
  
  protected void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.j.clear();
    }
  }
  
  public void b(Object... paramVarArgs)
  {
    if ((a(new Object[0]).getValue() != null) && (((UIStateData)a(new Object[0]).getValue()).c() != 1))
    {
      ((UIStateData)a(new Object[0]).getValue()).c(1);
      a(0);
    }
  }
  
  public boolean b(@NonNull QCircleFolderCacheHelper.QCircleFolderPageCache paramQCircleFolderPageCache)
  {
    Object localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendRspByCache feed size:");
    localStringBuilder.append(this.j.size());
    localStringBuilder.append(" | isFinish:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(" | feedAttachInfo:");
    localStringBuilder.append(e());
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    localObject = new ArrayList(this.j);
    if (((List)localObject).size() > 0)
    {
      updateSession(this.i);
      RFThreadManager.getSerialThreadHandler().post(new QCircleAbsTabFeedViewModel.3(this, (List)localObject, paramQCircleFolderPageCache));
      return true;
    }
    return false;
  }
  
  public int c()
  {
    if (b() == null) {
      return 0;
    }
    return b().tabType.get();
  }
  
  public void c(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.startsWith("qcircle_fakeid_")))
    {
      paramString = new QCircleTabGetFeedListRequest(new QCircleTabGetFeedListRequest.Builder().a(this.c));
      paramString.mRequest.extInfo.set(getSession(true));
      if (BaseRequest.isCacheExist(paramString)) {
        BaseRequest.reMoveCache(paramString);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public MutableLiveData<FeedBlockData> g()
  {
    return this.b;
  }
  
  public FeedCloudCommon.StCommonExt getSession(boolean paramBoolean)
  {
    if (this.k != null) {
      return this.k.getSessionCommonExt(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public boolean h()
  {
    return QCircleFolderCacheHelper.a().a(this);
  }
  
  public Collection<? extends FeedCloudMeta.StFeed> i()
  {
    return this.j;
  }
  
  public boolean j()
  {
    return this.h;
  }
  
  public FeedCloudCommon.StCommonExt k()
  {
    return this.i;
  }
  
  public boolean l()
  {
    return this.g;
  }
  
  public void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.k != null) {
      this.k.updateSubSession(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel
 * JD-Core Version:    0.7.0.1
 */