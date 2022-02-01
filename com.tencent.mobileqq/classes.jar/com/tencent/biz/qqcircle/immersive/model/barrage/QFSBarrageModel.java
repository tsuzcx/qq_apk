package com.tencent.biz.qqcircle.immersive.model.barrage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.events.QFSGetBarrageEvent;
import com.tencent.biz.qqcircle.immersive.model.barrage.bean.QFSLoadBarrageListBean;
import com.tencent.biz.qqcircle.immersive.model.barrage.cache.QFSBarrageCachePack;
import com.tencent.biz.qqcircle.immersive.model.barrage.cache.QFSBarrageCachePack.FSBarrageResponse;
import com.tencent.biz.qqcircle.immersive.request.QFSGetBarrageListRequest;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeListUtils;
import com.tencent.biz.qqcircle.immersive.utils.QFSSafeMapUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetCommentListRsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QFSBarrageModel
  implements IQFSBarrageModel
{
  private static volatile IQFSBarrageModel a;
  private final QFSBarrageCachePack b = new QFSBarrageCachePack();
  
  public static IQFSBarrageModel a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QFSBarrageModel();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return null;
    }
    return paramStFeed.id.get();
  }
  
  private List<FeedCloudMeta.StComment> a(@NonNull String paramString)
  {
    ArrayList localArrayList = (ArrayList)QFSSafeMapUtils.a(b(paramString), paramString);
    paramString = localArrayList;
    if (localArrayList == null)
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[getCommentCache] comment cache is empty, create comment cache.");
      paramString = new ArrayList();
    }
    return paramString;
  }
  
  private void a(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean, long paramLong, String paramString)
  {
    boolean bool = paramQFSLoadBarrageListBean.d();
    String str = a(paramQFSLoadBarrageListBean.c());
    QFSGetBarrageEvent localQFSGetBarrageEvent = QFSGetBarrageEvent.build();
    localQFSGetBarrageEvent.setLoadSuccess(false);
    localQFSGetBarrageEvent.setFeedId(str);
    localQFSGetBarrageEvent.setRetCode(paramLong);
    localQFSGetBarrageEvent.setLoadMore(bool);
    localQFSGetBarrageEvent.setErrMsg(paramString);
    SimpleEventBus.getInstance().dispatchEvent(localQFSGetBarrageEvent);
    QLog.d("QDM-QFSBarrageModel", 1, new Object[] { "[handleGetCommentListFail] ret code: ", Long.valueOf(paramLong), " | err msg: ", paramString, " | isLoadMore: ", Boolean.valueOf(bool), " | feed id: ", str, " | hash code: ", Integer.valueOf(paramQFSLoadBarrageListBean.b()) });
  }
  
  private void a(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean, @NonNull FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    String str = a(paramQFSLoadBarrageListBean.c());
    if (TextUtils.isEmpty(str))
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[handleGetBarrageDataSource] current feed id is empty, handle fail.");
      return;
    }
    List localList = paramStGetCommentListRsp.vecComment.get();
    if (localList == null)
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[handleGetBarrageDataSource] comment list is empty, handler fail.");
      return;
    }
    QLog.d("QDM-QFSBarrageModel", 1, new Object[] { "[handleGetBarrageDataSource] bean value: ", paramQFSLoadBarrageListBean.toString() });
    if (paramQFSLoadBarrageListBean.d())
    {
      a(str, localList);
      return;
    }
    a(str, localList, paramStGetCommentListRsp.totalNum.get());
  }
  
  private void a(QFSLoadBarrageListBean paramQFSLoadBarrageListBean, FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp, int paramInt, long paramLong, String paramString)
  {
    String str = a(paramQFSLoadBarrageListBean.c());
    int i = paramStGetCommentListRsp.totalNum.get();
    boolean bool = paramQFSLoadBarrageListBean.d();
    paramStGetCommentListRsp = paramStGetCommentListRsp.vecComment.get();
    QFSGetBarrageEvent localQFSGetBarrageEvent = QFSGetBarrageEvent.build();
    localQFSGetBarrageEvent.setLoadSuccess(false);
    localQFSGetBarrageEvent.setFeedId(str);
    localQFSGetBarrageEvent.setRetCode(paramLong);
    localQFSGetBarrageEvent.setLoadMore(bool);
    localQFSGetBarrageEvent.setErrMsg(paramString);
    localQFSGetBarrageEvent.setTotal(i);
    localQFSGetBarrageEvent.setCommentList(paramStGetCommentListRsp);
    localQFSGetBarrageEvent.setStartIndex(paramInt);
    SimpleEventBus.getInstance().dispatchEvent(localQFSGetBarrageEvent);
    i = QFSSafeListUtils.b(paramStGetCommentListRsp);
    paramStGetCommentListRsp = new StringBuilder();
    paramStGetCommentListRsp.append("ret code: ");
    paramStGetCommentListRsp.append(paramLong);
    paramStGetCommentListRsp.append(" | err msg: ");
    paramStGetCommentListRsp.append(paramString);
    paramStGetCommentListRsp.append(" | count: ");
    paramStGetCommentListRsp.append(i);
    paramStGetCommentListRsp.append(" | startIndex: ");
    paramStGetCommentListRsp.append(paramInt);
    paramStGetCommentListRsp.append(" | isLoadMore: ");
    paramStGetCommentListRsp.append(bool);
    paramStGetCommentListRsp.append(" | feedId: ");
    paramStGetCommentListRsp.append(str);
    paramStGetCommentListRsp.append(" | hash code: ");
    paramStGetCommentListRsp.append(paramQFSLoadBarrageListBean.b());
    QLog.d("QDM-QFSBarrageModel", 1, new Object[] { "[notifyGetBarrageListFinish]", paramStGetCommentListRsp.toString() });
  }
  
  private void a(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean, Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length >= 4))
    {
      boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
      long l = ((Long)paramVarArgs[1]).longValue();
      String str = (String)paramVarArgs[2];
      paramVarArgs = (FeedCloudRead.StGetCommentListRsp)paramVarArgs[3];
      if ((bool) && (l == 0L) && (paramVarArgs != null))
      {
        Object localObject = a(paramQFSLoadBarrageListBean.c());
        a((String)localObject, true);
        b(paramQFSLoadBarrageListBean, paramVarArgs);
        localObject = (List)QFSSafeMapUtils.a(this.b.a(), localObject);
        int i;
        if (localObject == null) {
          i = 0;
        } else {
          i = ((List)localObject).size();
        }
        a(paramQFSLoadBarrageListBean, paramVarArgs);
        a(paramQFSLoadBarrageListBean, paramVarArgs, i, l, str);
        return;
      }
      a(paramQFSLoadBarrageListBean, l, str);
      return;
    }
    QLog.e("QDM-QFSBarrageModel", 1, "[handleGetCommentListResponse] handle args is null or args length < 4");
  }
  
  private void a(String paramString, int paramInt) {}
  
  private void a(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList)
  {
    List localList = a(paramString);
    localList.addAll(paramList);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" | server call comment count: ");
    QLog.d("QDM-QFSBarrageModel", 1, new Object[] { "[updateBarrageLoadMoreData] update feed id: ", localStringBuilder.toString(), Integer.valueOf(paramList.size()), " | current cache comment count: ", Integer.valueOf(localList.size()) });
  }
  
  private void a(@NonNull String paramString, @NonNull List<FeedCloudMeta.StComment> paramList, int paramInt)
  {
    a(paramString, paramInt);
    QFSSafeMapUtils.a(b(paramString), paramString, new ArrayList(paramList));
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    QFSBarrageCachePack localQFSBarrageCachePack = this.b;
    if (localQFSBarrageCachePack == null) {
      return;
    }
    paramString = (QFSBarrageCachePack.FSBarrageResponse)QFSSafeMapUtils.a(localQFSBarrageCachePack.b(), paramString);
    if (paramString == null) {
      return;
    }
    paramString.b(paramBoolean);
  }
  
  private Map<String, ArrayList<FeedCloudMeta.StComment>> b(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[getBarrageCacheMap] feed id not is empty.");
      return null;
    }
    paramString = this.b;
    if (paramString == null)
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[getBarrageCacheMap] comment cache pack should not be null.");
      return null;
    }
    return paramString.a();
  }
  
  private void b(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean)
  {
    if (paramQFSLoadBarrageListBean.d())
    {
      c(paramQFSLoadBarrageListBean);
      return;
    }
    d(paramQFSLoadBarrageListBean);
  }
  
  private void b(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean, @NonNull FeedCloudRead.StGetCommentListRsp paramStGetCommentListRsp)
  {
    String str1 = a(paramQFSLoadBarrageListBean.c());
    if (TextUtils.isEmpty(str1))
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[updateResponseAttachInfo] feed id not is empty.");
      return;
    }
    String str2 = paramStGetCommentListRsp.feedAttchInfo.get();
    boolean bool;
    if (paramStGetCommentListRsp.isFinish.get() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("QDM-QFSBarrageModel", 1, new Object[] { "[updateResponseAttachInfo] feed id: ", a(paramQFSLoadBarrageListBean.c()), " | attachInfo: ", str2, " | isFinish: ", Boolean.valueOf(bool) });
    paramQFSLoadBarrageListBean = this.b.b();
    paramStGetCommentListRsp = (QFSBarrageCachePack.FSBarrageResponse)QFSSafeMapUtils.a(paramQFSLoadBarrageListBean, str1);
    if (paramStGetCommentListRsp == null)
    {
      paramStGetCommentListRsp = QFSBarrageCachePack.FSBarrageResponse.a();
      paramStGetCommentListRsp.a(str2);
      paramStGetCommentListRsp.a(bool);
      paramStGetCommentListRsp.b(true);
      paramQFSLoadBarrageListBean.put(str1, paramStGetCommentListRsp);
      return;
    }
    paramStGetCommentListRsp.a(bool);
    paramStGetCommentListRsp.a(str2);
  }
  
  private void c(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean)
  {
    if (c(a(paramQFSLoadBarrageListBean.c())))
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[requestFeedCommentData] current load data finish, not load more.");
      return;
    }
    d(paramQFSLoadBarrageListBean);
  }
  
  private boolean c(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1)
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[isLoadFinish] current feed id should not be null.");
      return false;
    }
    paramString = (QFSBarrageCachePack.FSBarrageResponse)QFSSafeMapUtils.a(this.b.b(), paramString);
    bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String d(String paramString)
  {
    paramString = (QFSBarrageCachePack.FSBarrageResponse)QFSSafeMapUtils.a(this.b.b(), paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.c();
  }
  
  private void d(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean)
  {
    if (paramQFSLoadBarrageListBean.d()) {
      localObject = d(paramQFSLoadBarrageListBean.c().id.get());
    } else {
      localObject = "";
    }
    int i = paramQFSLoadBarrageListBean.b();
    Object localObject = new QFSGetBarrageListRequest(paramQFSLoadBarrageListBean, (String)localObject, 20);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hashCode: ");
    localStringBuilder.append(i);
    localStringBuilder.append(" | feed id: ");
    localStringBuilder.append(a(paramQFSLoadBarrageListBean.c()));
    localStringBuilder.append(" | isLoadMore: ");
    localStringBuilder.append(paramQFSLoadBarrageListBean.d());
    QLog.d("QDM-QFSBarrageModel", 1, new Object[] { "[requestFeedCommentData]", localStringBuilder.toString() });
    VSNetworkHelper.getInstance().sendRequest(i, (BaseRequest)localObject, new QFSBarrageModel.LoadTaskCallback(paramQFSLoadBarrageListBean, this));
  }
  
  private boolean e(@NonNull QFSLoadBarrageListBean paramQFSLoadBarrageListBean)
  {
    if (!paramQFSLoadBarrageListBean.d()) {
      return false;
    }
    return TextUtils.isEmpty(d(a(paramQFSLoadBarrageListBean.c())));
  }
  
  public void a(QFSLoadBarrageListBean paramQFSLoadBarrageListBean)
  {
    if (paramQFSLoadBarrageListBean == null)
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[loadBarrageList] bean should not be null.");
      return;
    }
    if (e(paramQFSLoadBarrageListBean))
    {
      QLog.d("QDM-QFSBarrageModel", 1, "[loadBarrageList] load more param illegality, load handle fail.");
      return;
    }
    b(paramQFSLoadBarrageListBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.model.barrage.QFSBarrageModel
 * JD-Core Version:    0.7.0.1
 */