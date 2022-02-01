package com.tencent.biz.qqcircle.fragments.content;

import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.ResponseBean;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.helpers.QCircleVideoPreloadHelper;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.qqcircle.viewmodels.QCircleBaseViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetFeedDetailReq;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

public class QCircleContentModel
  extends QCircleBaseViewModel
  implements IQCircleReportSessionOperation
{
  private final MutableLiveData<ResponseBean> a = new MutableLiveData();
  private final QCircleVideoPreloadHelper b = new QCircleVideoPreloadHelper(this.D);
  private final MutableLiveData<UIStateData<List<FeedBlockData>>> c = new MutableLiveData();
  private RecyclerView.ViewHolder d;
  private LoadInfo e = new LoadInfo();
  
  public QCircleContentModel()
  {
    this.k = QCircleReporterAgent.obtain(57);
  }
  
  private void a(long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if (paramLong != 0L)
    {
      e().postValue(UIStateData.a(paramString));
      return;
    }
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.feed.has()))
    {
      e().postValue(UIStateData.a(VSNetworkHelper.isProtocolCache(paramString)).a(false, new ArrayList(Arrays.asList(new FeedBlockData[] { new FeedBlockData(paramStGetFeedDetailRsp.feed).c() }))).c(true));
      return;
    }
    e().postValue(UIStateData.a().c(true));
  }
  
  private void a(QCircleInitBean paramQCircleInitBean)
  {
    QCircleGetFeedDetailRequest localQCircleGetFeedDetailRequest = new QCircleGetFeedDetailRequest(paramQCircleInitBean.getFeed().id.get(), paramQCircleInitBean.getFeed().poster.id.get(), paramQCircleInitBean.getFeed().createTime.get(), false, QCircleGetFeedDetailRequest.FROM_NATIVE, paramQCircleInitBean.getFeed(), paramQCircleInitBean);
    localQCircleGetFeedDetailRequest.mRequest.extInfo.set(getSession(true));
    a(localQCircleGetFeedDetailRequest, new QCircleContentModel.3(this, localQCircleGetFeedDetailRequest, paramQCircleInitBean));
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = this.e.f();
    } else {
      str = null;
    }
    paramString1 = new QCircleGetFeedListRequest(paramString1, paramString2, true, str, this.e.g());
    paramString1.mRequest.extInfo.set(getSession(paramBoolean ^ true));
    a(paramString1, new QCircleContentModel.2(this, paramBoolean));
  }
  
  private void a(boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp, boolean paramBoolean2)
  {
    if (paramStGetFeedListRsp != null)
    {
      this.e.a(paramStGetFeedListRsp.feedAttchInfo.get());
      this.e.c(paramStGetFeedListRsp.adAttchInfo.get());
      Object localObject = this.e;
      int i = paramStGetFeedListRsp.isFinish.get();
      paramBoolean1 = true;
      if (i != 1) {
        paramBoolean1 = false;
      }
      ((LoadInfo)localObject).a(paramBoolean1);
      if (paramStGetFeedListRsp.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      if (paramStGetFeedListRsp.busiRspData.has())
      {
        localObject = new QQCircleFeedBase.StFeedListBusiRspData();
        try
        {
          ((QQCircleFeedBase.StFeedListBusiRspData)localObject).mergeFrom(paramStGetFeedListRsp.busiRspData.get().toByteArray());
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
        if (((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.has()) {
          this.e.b(((QQCircleFeedBase.StFeedListBusiRspData)localObject).refreshAttachInfo.get());
        }
      }
    }
    this.a.postValue(new ResponseBean(paramLong, paramString, paramStGetFeedListRsp, paramBoolean2));
    b().a(4);
  }
  
  private void b(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    paramQCircleInitBean = new QCircleGetFeedListRequest(paramQCircleInitBean, this.e.f(), this.e.h(), this.e.g());
    paramQCircleInitBean.mRequest.extInfo.set(getSession(paramBoolean ^ true));
    a(paramQCircleInitBean, new QCircleContentModel.4(this, paramQCircleInitBean, paramBoolean));
  }
  
  public String a()
  {
    return "QCircleContentModel";
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.d = paramViewHolder;
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    b().a(3);
    if (paramQCircleInitBean.isSingleFeed())
    {
      a(paramQCircleInitBean);
      return;
    }
    if (paramQCircleInitBean.getTagInfo().has())
    {
      if (PreLoader.exists("2005"))
      {
        PreLoader.addListener("2005", new QCircleContentModel.1(this));
        return;
      }
      a(paramQCircleInitBean.getTagInfo().tagId.get(), paramQCircleInitBean.getTagInfo().tagName.get(), paramBoolean);
      return;
    }
    b(paramQCircleInitBean, paramBoolean);
  }
  
  public LoadInfo b()
  {
    return this.e;
  }
  
  public MutableLiveData<ResponseBean> c()
  {
    return this.a;
  }
  
  public RecyclerView.ViewHolder d()
  {
    return this.d;
  }
  
  public MutableLiveData<UIStateData<List<FeedBlockData>>> e()
  {
    return this.c;
  }
  
  public FeedCloudCommon.StCommonExt getSession(boolean paramBoolean)
  {
    if (this.k != null) {
      return this.k.getSessionCommonExt(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    Object localObject = this.d;
    if (localObject != null)
    {
      if ((localObject instanceof QCircleContentHorizontalAdapter.QCirclePicVH))
      {
        localObject = ((QCircleContentHorizontalAdapter.QCirclePicVH)localObject).a;
        if (localObject != null) {
          ((QCircleContentImage)localObject).release();
        }
      }
      else if ((localObject instanceof QCircleContentHorizontalAdapter.QCircleVideoVH))
      {
        localObject = ((QCircleContentHorizontalAdapter.QCircleVideoVH)localObject).a;
        if (localObject != null) {
          ((QCircleContentVideo)localObject).release();
        }
      }
      this.d = null;
    }
    c().postValue(null);
    localObject = this.b;
    if (localObject != null)
    {
      ((QCircleVideoPreloadHelper)localObject).a();
      this.b.b();
    }
  }
  
  public void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    if (this.k != null) {
      this.k.updateSubSession(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentModel
 * JD-Core Version:    0.7.0.1
 */