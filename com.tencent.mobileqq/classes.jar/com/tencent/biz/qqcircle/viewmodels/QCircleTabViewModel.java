package com.tencent.biz.qqcircle.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.tencent.QCircleCollection;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.folder.QCircleFolderCacheHelper;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import feedcloud.FeedCloudMeta.StGPSV2;
import java.util.List;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleTabViewModel
  extends QCircleBaseViewModel
{
  private final MutableLiveData<List<QQCircleFeedBase.StTabInfo>> a = new MutableLiveData();
  
  public String a()
  {
    return "QCircleTabViewModel";
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2, QCircleFolderBean paramQCircleFolderBean)
  {
    this.a.setValue(QCircleFolderTabInfoManager.a().c(paramStGPSV2, paramQCircleFolderBean));
    QCirclePeriodCollect.record("get_tab_cache_rsp");
    QCircleCollection.a("initTab", "from net");
  }
  
  public boolean a(int paramInt)
  {
    List localList = QCircleFolderTabInfoManager.a().c(null, null);
    QCirclePluginGlobalInfo.a(paramInt);
    this.a.setValue(localList);
    QCirclePeriodCollect.record("get_tab_cache_rsp");
    QCircleCollection.a("initTab", "from cache");
    return true;
  }
  
  public MutableLiveData<List<QQCircleFeedBase.StTabInfo>> b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return QCircleFolderCacheHelper.a().a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.viewmodels.QCircleTabViewModel
 * JD-Core Version:    0.7.0.1
 */