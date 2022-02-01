package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import UserGrowth.stFirstPageSubjectInfo;
import UserGrowth.stGetFirstPageMsgListRsp;
import UserGrowth.stGetMsgRedDotRsp;
import UserGrowth.stMsgContent;
import UserGrowth.stMsgRedDotCount;
import UserGrowth.stNotifyMsg;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData;
import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgSectionData.SectionInfo;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSGetMsgRedDotRequest;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSMsgPageRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgDataFetcher;", "", "()V", "mAttachInfo", "", "buildMsgContentData", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgSectionData;", "subjectId", "", "msgInfo", "LUserGrowth/stNotifyMsg;", "index", "isLastMsgInSection", "", "buildMsgSectionData", "subjectInfo", "LUserGrowth/stFirstPageSubjectInfo;", "fetchData", "params", "Lcom/tencent/biz/pubaccount/weishi_new/data/FetcherParams;", "listener", "Lcom/tencent/biz/pubaccount/weishi_new/drama/cache/IFetchDataListener;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgPageData;", "fetchRedDotData", "", "handleFailOnUIThread", "errorInfo", "Lcom/tencent/biz/pubaccount/weishi_new/net/common/WSServiceErrorInfo;", "handleSuccessOnSubThread", "response", "LUserGrowth/stGetFirstPageMsgListRsp;", "handleSuccessOnUIThread", "responseModel", "handleSuccessRedDotOnSubThread", "LUserGrowth/stGetMsgRedDotRsp;", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgDataFetcher
{
  public static final WSMsgDataFetcher.Companion a = new WSMsgDataFetcher.Companion(null);
  private String b;
  
  private final int a(stGetMsgRedDotRsp paramstGetMsgRedDotRsp)
  {
    paramstGetMsgRedDotRsp = (stMsgRedDotCount)paramstGetMsgRedDotRsp.redDotCount.get(Integer.valueOf(1));
    int i;
    if (paramstGetMsgRedDotRsp != null) {
      i = paramstGetMsgRedDotRsp.count;
    } else {
      i = 0;
    }
    paramstGetMsgRedDotRsp = new StringBuilder();
    paramstGetMsgRedDotRsp.append("[WSMsgDataFetcher.java][handleSuccessRedDotOnSubThread] redDotNum:");
    paramstGetMsgRedDotRsp.append(i);
    WSLog.d("WSMsgDataFetcher", paramstGetMsgRedDotRsp.toString());
    return i;
  }
  
  private final WSMsgPageData a(FetcherParams paramFetcherParams, stGetFirstPageMsgListRsp paramstGetFirstPageMsgListRsp)
  {
    Object localObject1 = paramstGetFirstPageMsgListRsp.attachInfo;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "response.attachInfo");
    this.b = ((String)localObject1);
    localObject1 = new ArrayList();
    if (paramstGetFirstPageMsgListRsp.subjectList != null)
    {
      Iterator localIterator = paramstGetFirstPageMsgListRsp.subjectList.iterator();
      while (localIterator.hasNext())
      {
        stFirstPageSubjectInfo localstFirstPageSubjectInfo = (stFirstPageSubjectInfo)localIterator.next();
        Intrinsics.checkExpressionValueIsNotNull(localstFirstPageSubjectInfo, "subjectInfo");
        ((ArrayList)localObject1).add(a(localstFirstPageSubjectInfo));
        Object localObject2 = localstFirstPageSubjectInfo.topContent;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "subjectInfo.topContent");
        localObject2 = ((Iterable)localObject2).iterator();
        int i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          stNotifyMsg localstNotifyMsg = (stNotifyMsg)((Iterator)localObject2).next();
          int j = localstFirstPageSubjectInfo.topContent.size();
          boolean bool = true;
          if (i != j - 1) {
            bool = false;
          }
          j = localstFirstPageSubjectInfo.ID;
          Intrinsics.checkExpressionValueIsNotNull(localstNotifyMsg, "msgInfo");
          ((ArrayList)localObject1).add(a(j, localstNotifyMsg, i, bool));
          i += 1;
        }
      }
    }
    WSLog.d("WSMsgDataFetcher", "[WSMsgDataFetcher.java][handleSuccessOnSubThread] response.subjectList is null!");
    return new WSMsgPageData(paramFetcherParams.a(), paramFetcherParams.b(), paramstGetFirstPageMsgListRsp.attachInfo, paramstGetFirstPageMsgListRsp.IsFinished, (List)localObject1, paramstGetFirstPageMsgListRsp.topRedCount);
  }
  
  private final WSMsgSectionData a(int paramInt1, stNotifyMsg paramstNotifyMsg, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramstNotifyMsg.content != null) {
      i = paramstNotifyMsg.content.templateID;
    } else {
      i = 0;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSMsgDataFetcher.java][buildMsgContentData] msgID:");
    localStringBuilder.append(paramstNotifyMsg.msgID);
    WSLog.e("WSMsgDataFetcher", localStringBuilder.toString());
    paramstNotifyMsg = new WSMsgSectionData(i, paramInt1, null, paramstNotifyMsg);
    paramstNotifyMsg.a(paramInt2);
    paramstNotifyMsg.a(paramBoolean);
    return paramstNotifyMsg;
  }
  
  private final WSMsgSectionData a(stFirstPageSubjectInfo paramstFirstPageSubjectInfo)
  {
    WSMsgSectionData.SectionInfo localSectionInfo = new WSMsgSectionData.SectionInfo(paramstFirstPageSubjectInfo.ID, paramstFirstPageSubjectInfo.name, paramstFirstPageSubjectInfo.redCount, paramstFirstPageSubjectInfo.schema);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSMsgDataFetcher.java][buildMsgSectionData] subjectInfo.ID:");
    localStringBuilder.append(paramstFirstPageSubjectInfo.ID);
    localStringBuilder.append(", subjectInfo.name:");
    localStringBuilder.append(paramstFirstPageSubjectInfo.name);
    WSLog.e("WSMsgDataFetcher", localStringBuilder.toString());
    return new WSMsgSectionData(0, paramstFirstPageSubjectInfo.ID, localSectionInfo, null);
  }
  
  private final void a(WSMsgPageData paramWSMsgPageData, IFetchDataListener<WSMsgPageData> paramIFetchDataListener)
  {
    if (paramIFetchDataListener != null) {
      paramIFetchDataListener.a(paramWSMsgPageData);
    }
  }
  
  private final void a(WSServiceErrorInfo paramWSServiceErrorInfo, IFetchDataListener<?> paramIFetchDataListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSMsgDataFetcher.java][handleFailOnUIThread] response errorCode:");
    localStringBuilder.append(paramWSServiceErrorInfo.a());
    localStringBuilder.append(", errorMsg:");
    localStringBuilder.append(paramWSServiceErrorInfo.b());
    WSLog.d("WSMsgDataFetcher", localStringBuilder.toString());
    if (paramIFetchDataListener != null) {
      paramIFetchDataListener.a(paramWSServiceErrorInfo.a(), paramWSServiceErrorInfo.b());
    }
  }
  
  public final void a(@Nullable IFetchDataListener<Integer> paramIFetchDataListener)
  {
    WSNetService.a((WSRequest)new WSGetMsgRedDotRequest()).a((ServiceCallback)new WSMsgDataFetcher.fetchRedDotData.1(this, paramIFetchDataListener));
  }
  
  public final boolean a(@NotNull FetcherParams paramFetcherParams, @NotNull IFetchDataListener<WSMsgPageData> paramIFetchDataListener)
  {
    Intrinsics.checkParameterIsNotNull(paramFetcherParams, "params");
    Intrinsics.checkParameterIsNotNull(paramIFetchDataListener, "listener");
    boolean bool1 = paramFetcherParams.a();
    boolean bool2 = paramFetcherParams.b();
    if ((bool1) || (bool2)) {
      this.b = "";
    }
    String str = this.b;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mAttachInfo");
    }
    WSNetService.a((WSRequest)new WSMsgPageRequest(str)).a((ServiceCallback)new WSMsgDataFetcher.fetchData.1(this, paramFetcherParams, paramIFetchDataListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgDataFetcher
 * JD-Core Version:    0.7.0.1
 */