package com.tencent.biz.qqcircle.comment;

import android.app.Application;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleDanmakuEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.manager.QCircleSwitchConfigManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDoCommentRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest;
import com.tencent.biz.qqcircle.requests.QCircleDoStickyRequest;
import com.tencent.biz.qqcircle.requests.QCircleGetCommentListRequest;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.IQCircleReportSessionOperation;
import cooperation.qqcircle.report.QCircleReporterAgent;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudRead.StGetCommentListReq;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class QCircleCommentBusiness
  implements IQCircleReportSessionOperation
{
  private static volatile QCircleCommentBusiness a;
  private final Map<String, ArrayList<FeedCloudMeta.StComment>> b = new HashMap();
  private final Map<String, Integer> c = new HashMap();
  private Map<String, String> d = new HashMap();
  private final Map<String, QCircleCommentBusiness.CommentResponse> e = new HashMap();
  private final QCircleReporterAgent f = QCircleReporterAgent.obtain(61);
  
  public static QCircleCommentBusiness a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleCommentBusiness();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramLong, paramString, paramStGetCommentListRsp, paramStFeed, paramBoolean2, false, null);
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramInt, paramBoolean1, paramLong, paramString, paramStGetCommentListRsp, paramStFeed, paramBoolean2, false, paramBoolean3, null);
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetCommentListRsp != null))
    {
      paramString = new StringBuilder();
      paramString.append("handleCommentResponse Success  isLoadMore:");
      paramString.append(paramBoolean2);
      QLog.d("QCircleCommentBusiness", 1, paramString.toString());
      a(paramStFeed.id.get(), true);
      if (paramStGetCommentListRsp.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramStGetCommentListRsp.extInfo.get());
      }
      paramString = paramStFeed.id.get();
      Object localObject = paramStGetCommentListRsp.feedAttchInfo.get();
      if (paramStGetCommentListRsp.isFinish.get() == 0) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      a(paramString, (String)localObject, paramBoolean1, true);
      if (paramBoolean2)
      {
        localObject = paramStFeed.id.get();
        paramString = (String)localObject;
        if (paramStBusiInfoCommentListData != null)
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(paramStBusiInfoCommentListData.comment.id.get());
          paramString.append(paramStBusiInfoCommentListData.reply.id.get());
          paramString = paramString.toString();
        }
        paramStBusiInfoCommentListData = (List)this.b.get(paramString);
        if (paramStBusiInfoCommentListData != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCommentSize:");
          ((StringBuilder)localObject).append(paramStGetCommentListRsp.vecComment.size());
          ((StringBuilder)localObject).append(", attachInfo:");
          ((StringBuilder)localObject).append(paramStGetCommentListRsp.feedAttchInfo.get());
          ((StringBuilder)localObject).append("isFinish：");
          ((StringBuilder)localObject).append(paramStGetCommentListRsp.isFinish.get());
          QLog.d("QCircleCommentBusiness", 2, ((StringBuilder)localObject).toString());
          paramStBusiInfoCommentListData.addAll(paramStGetCommentListRsp.vecComment.get());
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(2, paramString, paramStGetCommentListRsp.vecComment.get(), b(paramStFeed.id.get()), paramInt));
        return;
      }
      paramString = paramStFeed.id.get();
      localObject = paramString;
      if (paramStBusiInfoCommentListData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(paramStBusiInfoCommentListData.comment.id.get());
        ((StringBuilder)localObject).append(paramStBusiInfoCommentListData.reply.id.get());
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = null;
      if (paramStGetCommentListRsp.vecComment.size() > 0)
      {
        paramStBusiInfoCommentListData = (ArrayList)paramStGetCommentListRsp.vecComment.get();
        this.c.put(paramStFeed.id.get(), Integer.valueOf(paramStGetCommentListRsp.totalNum.get()));
        paramStGetCommentListRsp = (FeedCloudMeta.StComment)paramStGetCommentListRsp.vecComment.get(0);
        paramString = paramStBusiInfoCommentListData;
        if (paramStGetCommentListRsp.typeFlag.get() == 1)
        {
          a(paramStFeed.id.get(), paramStGetCommentListRsp.id.get());
          paramString = paramStBusiInfoCommentListData;
        }
      }
      paramStGetCommentListRsp = paramString;
      if (paramString == null)
      {
        paramStGetCommentListRsp = new ArrayList(0);
        this.c.put(paramStFeed.id.get(), Integer.valueOf(0));
      }
      this.b.put(localObject, paramStGetCommentListRsp);
      if (b(paramStFeed.id.get()) == 0) {
        QLog.e("QCircleCommentBusiness", 1, "后台返回评论数为0");
      }
      if (QCircleSwitchConfigManager.a().b())
      {
        paramString = new QCircleDanmakuEvent(1, (String)localObject, paramStGetCommentListRsp, b(paramStFeed.id.get()), paramInt);
        SimpleEventBus.getInstance().dispatchEvent(paramString);
      }
      return;
    }
    a(paramLong, paramString);
    paramStGetCommentListRsp = new StringBuilder();
    paramStGetCommentListRsp.append("getComment error:");
    paramStGetCommentListRsp.append(paramLong);
    paramStGetCommentListRsp.append("  errorMsg:");
    paramStGetCommentListRsp.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramStGetCommentListRsp.toString());
  }
  
  private void a(int paramInt, boolean paramBoolean1, long paramLong, String paramString, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    if ((paramBoolean1) && (paramLong == 0L) && (paramStGetCommentListRsp != null))
    {
      paramString = new StringBuilder();
      paramString.append("handleCommentResponse Success  isLoadMore:");
      paramString.append(paramBoolean2);
      QLog.d("QCircleCommentBusiness", 1, paramString.toString());
      a(paramStFeed.id.get(), true);
      if (paramStGetCommentListRsp.extInfo.has()) {
        updateSession((FeedCloudCommon.StCommonExt)paramStGetCommentListRsp.extInfo.get());
      }
      paramString = paramStFeed.id.get();
      Object localObject = paramStGetCommentListRsp.feedAttchInfo.get();
      if (paramStGetCommentListRsp.isFinish.get() == 0) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      a(paramString, (String)localObject, paramBoolean1, true);
      if (paramBoolean2)
      {
        localObject = paramStFeed.id.get();
        paramString = (String)localObject;
        if (paramStBusiInfoCommentListData != null)
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(paramStBusiInfoCommentListData.comment.id.get());
          paramString.append(paramStBusiInfoCommentListData.reply.id.get());
          paramString = paramString.toString();
        }
        paramStBusiInfoCommentListData = (List)this.b.get(paramString);
        if (paramStBusiInfoCommentListData != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCommentSize:");
          ((StringBuilder)localObject).append(paramStGetCommentListRsp.vecComment.size());
          ((StringBuilder)localObject).append(", attachInfo:");
          ((StringBuilder)localObject).append(paramStGetCommentListRsp.feedAttchInfo.get());
          ((StringBuilder)localObject).append("isFinish：");
          ((StringBuilder)localObject).append(paramStGetCommentListRsp.isFinish.get());
          QLog.d("QCircleCommentBusiness", 2, ((StringBuilder)localObject).toString());
          paramStBusiInfoCommentListData.addAll(paramStGetCommentListRsp.vecComment.get());
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(2, paramString, paramStGetCommentListRsp.vecComment.get(), b(paramStFeed.id.get()), paramInt));
        return;
      }
      paramString = paramStFeed.id.get();
      localObject = paramString;
      if (paramStBusiInfoCommentListData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(paramStBusiInfoCommentListData.comment.id.get());
        ((StringBuilder)localObject).append(paramStBusiInfoCommentListData.reply.id.get());
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = null;
      if (paramStGetCommentListRsp.vecComment.size() > 0)
      {
        paramStBusiInfoCommentListData = (ArrayList)paramStGetCommentListRsp.vecComment.get();
        this.c.put(paramStFeed.id.get(), Integer.valueOf(paramStGetCommentListRsp.totalNum.get()));
        paramStGetCommentListRsp = (FeedCloudMeta.StComment)paramStGetCommentListRsp.vecComment.get(0);
        paramString = paramStBusiInfoCommentListData;
        if (paramStGetCommentListRsp.typeFlag.get() == 1)
        {
          a(paramStFeed.id.get(), paramStGetCommentListRsp.id.get());
          paramString = paramStBusiInfoCommentListData;
        }
      }
      paramStGetCommentListRsp = paramString;
      if (paramString == null)
      {
        paramStGetCommentListRsp = new ArrayList(0);
        this.c.put(paramStFeed.id.get(), Integer.valueOf(0));
      }
      this.b.put(localObject, paramStGetCommentListRsp);
      if (b(paramStFeed.id.get()) == 0) {
        QLog.e("QCircleCommentBusiness", 1, "后台返回评论数为0");
      }
      if (paramBoolean3)
      {
        paramString = new QCircleDanmakuEvent(1, (String)localObject, paramStGetCommentListRsp, b(paramStFeed.id.get()), paramInt);
        SimpleEventBus.getInstance().dispatchEvent(paramString);
        return;
      }
      paramString = new QCircleCommentUpdateEvent(1, (String)localObject, paramStGetCommentListRsp, b(paramStFeed.id.get()), paramInt);
      paramString.needShowCommentPanel = paramBoolean4;
      SimpleEventBus.getInstance().dispatchEvent(paramString);
      return;
    }
    a(paramLong, paramString);
    paramStGetCommentListRsp = new StringBuilder();
    paramStGetCommentListRsp.append("getComment error:");
    paramStGetCommentListRsp.append(paramLong);
    paramStGetCommentListRsp.append("  errorMsg:");
    paramStGetCommentListRsp.append(paramString);
    QLog.e("QCircleCommentBusiness", 1, paramStGetCommentListRsp.toString());
  }
  
  private void a(long paramLong, String paramString)
  {
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      QCircleToastUtil.a(-1L, QCircleToast.c, QCircleApplication.APP.getResources().getString(2131892113), 0);
      return;
    }
    QCircleToastUtil.a(paramLong, QCircleToast.c, paramString, 0);
  }
  
  private void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    paramStFeed = QCircleFeedDataCenter.a().a(FeedBlockData.class, paramStFeed.id.get());
    if (paramStFeed == null) {
      return;
    }
    FeedBlockData localFeedBlockData = (FeedBlockData)paramStFeed.getValue();
    localFeedBlockData.b().commentCount.set(paramInt);
    paramStFeed.postValue(localFeedBlockData);
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("QCircleCommentBusiness", 1, "updateStickyCommentId param error");
      return;
    }
    if (this.d == null) {
      this.d = new HashMap();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateStickyCommentId feedId:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" commentId");
    localStringBuilder.append(paramString2);
    QLog.d("QCircleCommentBusiness", 1, localStringBuilder.toString());
    this.d.put(paramString1, paramString2);
  }
  
  private void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.e.get(paramString1) == null)
    {
      QCircleCommentBusiness.CommentResponse localCommentResponse = new QCircleCommentBusiness.CommentResponse(null);
      localCommentResponse.b = paramString2;
      localCommentResponse.a = paramBoolean1;
      localCommentResponse.c = paramBoolean2;
      this.e.put(paramString1, localCommentResponse);
      paramString1 = new StringBuilder();
      paramString1.append("getDetailCommentSize: feedAttachInfo:");
      paramString1.append(paramString2);
      QLog.d("QCircleCommentBusiness", 1, paramString1.toString());
      return;
    }
    ((QCircleCommentBusiness.CommentResponse)this.e.get(paramString1)).a = paramBoolean1;
    ((QCircleCommentBusiness.CommentResponse)this.e.get(paramString1)).b = paramString2;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    Map localMap = this.e;
    if ((localMap != null) && (localMap.get(paramString) != null)) {
      ((QCircleCommentBusiness.CommentResponse)this.e.get(paramString)).c = paramBoolean;
    }
  }
  
  private void b(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = new QCircleGetCommentListRequest(paramStFeed, paramInt2, paramString, 20, paramStFeed.likeInfo.id.get(), false);
    paramString.req.extInfo.set(getSession(paramBoolean1 ^ true));
    paramString.setEnableCache(paramBoolean1 ^ true);
    VSNetworkHelper.getInstance().sendRequest(paramInt1, paramString, new QCircleCommentBusiness.4(this, paramInt1, paramStFeed, paramBoolean1, paramBoolean2));
  }
  
  private void b(int paramInt, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    paramString = new QCircleGetCommentListRequest(paramStFeed, paramString, 20, paramStFeed.likeInfo.id.get(), true);
    paramString.req.extInfo.set(getSession(paramBoolean ^ true));
    paramString.setEnableCache(paramBoolean ^ true);
    VSNetworkHelper.getInstance().sendRequest(paramInt, paramString, new QCircleCommentBusiness.5(this, paramInt, paramStFeed, paramBoolean));
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = (QCircleCommentBusiness.CommentResponse)this.e.get(paramString);
    if (paramString != null)
    {
      if ((paramString.c) && (paramString.a) && (paramString.b != null)) {
        return paramString.b;
      }
      QLog.i("QCircleCommentBusiness", 1, paramString.toString());
    }
    return null;
  }
  
  public ArrayList<FeedCloudMeta.StComment> a(String paramString, ArrayList<FeedCloudMeta.StComment> paramArrayList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.b.put(paramString, paramArrayList);
  }
  
  public void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      b(paramInt1, paramInt2, paramStFeed, paramString, true, paramBoolean2);
      return;
    }
    if (PreLoader.exists("2004"))
    {
      QLog.i("QCircleCommentBusiness", 1, "runPreload");
      PreLoader.addListener("2004", new QCircleCommentBusiness.1(this, paramInt1, paramStFeed, paramBoolean2));
      return;
    }
    b(paramInt1, paramInt2, paramStFeed, paramString, false, paramBoolean2);
  }
  
  public void a(int paramInt1, int paramInt2, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramStFeed == null)
    {
      QLog.i("QCircleCommentBusiness", 1, "getComments  feed == null");
      return;
    }
    String str = null;
    if (paramBoolean1)
    {
      str = a(paramStFeed.id.get());
      if (str == null)
      {
        QLog.e("QCircleCommentBusiness", 1, "getComments loadMore , attachInfo is null ");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getComments, feedAttachInfo:");
      localStringBuilder.append(str);
      QLog.i("QCircleCommentBusiness", 1, localStringBuilder.toString());
    }
    a(paramInt1, paramInt2, paramStFeed, str, paramBoolean1, paramBoolean2);
    a(paramStFeed.id.get(), false);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 1);
    VSNetworkHelper.getInstance().sendRequest(paramInt, localQCircleDoStickyRequest, new QCircleCommentBusiness.10(this, paramStFeed, paramStComment, paramInt));
  }
  
  public void a(int paramInt1, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, int paramInt2, boolean paramBoolean)
  {
    if (paramStFeed != null)
    {
      if (paramStComment == null) {
        return;
      }
      if (paramStComment.id.get().startsWith("fake_id"))
      {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(4, paramStFeed.id.get(), paramStComment, b(paramStFeed.id.get()), paramInt1));
        return;
      }
      QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, paramInt2, paramBoolean);
      VSNetworkHelper.getInstance().sendRequest(paramInt1, localQCircleDoCommentRequest, new QCircleCommentBusiness.7(this, paramStComment, paramStFeed, paramInt1));
    }
  }
  
  public void a(int paramInt1, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt2, boolean paramBoolean)
  {
    if ((paramStFeed != null) && (paramStComment != null) && (paramStReply != null))
    {
      if (paramStReply.id.get().startsWith("fake_id"))
      {
        SimpleEventBus.getInstance().dispatchEvent(new QCircleCommentUpdateEvent(6, paramStFeed.id.get(), paramStComment, paramStReply, b(paramStFeed.id.get()), paramInt1));
        return;
      }
      QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, paramInt2, paramBoolean);
      VSNetworkHelper.getInstance().sendRequest(paramInt1, localQCircleDoReplyRequest, new QCircleCommentBusiness.9(this, paramStReply, paramStFeed, paramStComment, paramInt1));
      return;
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, boolean paramBoolean)
  {
    if ((paramStFeed != null) && (paramStComment != null))
    {
      if (paramStReply == null) {
        return;
      }
      QCircleDoReplyRequest localQCircleDoReplyRequest = new QCircleDoReplyRequest(paramStFeed, paramStComment, paramStReply, 1, paramBoolean);
      VSNetworkHelper.getInstance().sendRequest(paramInt, localQCircleDoReplyRequest, new QCircleCommentBusiness.8(this, paramStFeed, paramStComment, paramStReply, paramInt));
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramStFeed != null)
    {
      if (paramStComment == null) {
        return;
      }
      QCircleDoCommentRequest localQCircleDoCommentRequest = new QCircleDoCommentRequest(paramStFeed, paramStComment, 1, paramBoolean1);
      VSNetworkHelper.getInstance().sendRequest(paramInt, localQCircleDoCommentRequest, new QCircleCommentBusiness.6(this, paramStFeed, paramStComment, paramInt, paramBoolean2));
    }
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramInt, paramStFeed, paramString, true);
      return;
    }
    if (PreLoader.exists("2004"))
    {
      QLog.i("QCircleCommentBusiness", 1, "runPreload");
      PreLoader.addListener("2004", new QCircleCommentBusiness.2(this, paramInt, paramStFeed));
      return;
    }
    b(paramInt, paramStFeed, paramString, false);
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, QQCircleFeedBase.StBusiInfoCommentListData paramStBusiInfoCommentListData)
  {
    if (paramStFeed == null)
    {
      QLog.i("QCircleCommentBusiness", 1, "getComments  feed == null");
      return;
    }
    Object localObject = paramStFeed.id.get();
    boolean bool = false;
    a((String)localObject, false);
    localObject = new QCircleGetCommentListRequest(paramStFeed, null, 20, paramStFeed.likeInfo.id.get(), false);
    ((QCircleGetCommentListRequest)localObject).req.extInfo.set(getSession(true));
    if (paramStBusiInfoCommentListData != null) {
      ((QCircleGetCommentListRequest)localObject).req.busiReqData.set(ByteStringMicro.copyFrom(paramStBusiInfoCommentListData.toByteArray()));
    }
    ((QCircleGetCommentListRequest)localObject).setEnableCache(false);
    VSNetworkHelper.getInstance().sendRequest(paramInt, (BaseRequest)localObject, new QCircleCommentBusiness.3(this, paramInt, paramStFeed, paramStBusiInfoCommentListData));
    paramStFeed = new StringBuilder();
    paramStFeed.append("req traceId:");
    paramStFeed.append(((QCircleGetCommentListRequest)localObject).getTraceId());
    paramStFeed.append("stBusiInfoCommentListData is ");
    if (paramStBusiInfoCommentListData != null) {
      bool = true;
    }
    paramStFeed.append(bool);
    QLog.d("QCircleCommentBusiness", 1, paramStFeed.toString());
  }
  
  public void a(int paramInt, FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    if (paramStFeed == null)
    {
      QLog.i("QCircleCommentBusiness", 1, "getComments  feed == null");
      return;
    }
    String str = null;
    if (paramBoolean)
    {
      str = a(paramStFeed.id.get());
      if (str == null)
      {
        QLog.e("QCircleCommentBusiness", 1, "getComments loadMore , attachInfo is null ");
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getComments, feedAttachInfo:");
      localStringBuilder.append(str);
      QLog.i("QCircleCommentBusiness", 1, localStringBuilder.toString());
    }
    a(paramInt, paramStFeed, str, paramBoolean);
    a(paramStFeed.id.get(), false);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c.put(paramString, Integer.valueOf(paramInt));
  }
  
  public void a(String paramString1, String paramString2, ArrayList<FeedCloudMeta.StComment> paramArrayList, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramBoolean ^ true, true);
    if (paramArrayList.size() > 0) {
      this.b.put(paramString1, paramArrayList);
    }
  }
  
  public boolean a(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    if ((paramStFeed != null) && (paramStComment != null)) {}
    try
    {
      if ((this.d == null) || (!this.d.containsKey(paramStFeed.id.get()))) {
        break label96;
      }
      paramStFeed = (String)this.d.get(paramStFeed.id.get());
      if ((TextUtils.isEmpty(paramStFeed)) || (paramStFeed.equals(paramStComment.id.get()))) {
        break label98;
      }
      return true;
    }
    catch (Exception paramStFeed)
    {
      paramStFeed.printStackTrace();
    }
    QLog.e("QCircleCommentBusiness", 1, "isReplaceStickyComment param is null");
    return false;
    label96:
    return false;
    label98:
    return false;
  }
  
  public int b(String paramString)
  {
    paramString = (Integer)this.c.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return 0;
  }
  
  public void b(int paramInt, FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    QCircleDoStickyRequest localQCircleDoStickyRequest = new QCircleDoStickyRequest(paramStFeed, paramStComment, 2);
    VSNetworkHelper.getInstance().sendRequest(paramInt, localQCircleDoStickyRequest, new QCircleCommentBusiness.11(this, paramStFeed, paramStComment, paramInt));
  }
  
  public ArrayList<FeedCloudMeta.StComment> c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (ArrayList)this.b.get(paramString);
  }
  
  public FeedCloudCommon.StCommonExt getSession(boolean paramBoolean)
  {
    QCircleReporterAgent localQCircleReporterAgent = this.f;
    if (localQCircleReporterAgent != null) {
      return localQCircleReporterAgent.getSessionCommonExt(paramBoolean);
    }
    return new FeedCloudCommon.StCommonExt();
  }
  
  public void updateSession(FeedCloudCommon.StCommonExt paramStCommonExt)
  {
    QCircleReporterAgent localQCircleReporterAgent = this.f;
    if (localQCircleReporterAgent != null) {
      localQCircleReporterAgent.updateSubSession(paramStCommonExt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentBusiness
 * JD-Core Version:    0.7.0.1
 */