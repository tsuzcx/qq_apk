package com.tencent.biz.pubaccount.weishi_new.combo.msg;

import com.tencent.biz.pubaccount.weishi_new.combo.msg.bean.WSMsgPageData;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.IFetchDataListener;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/combo/msg/WSMsgFragmentPresenter$fetchData$1", "Lcom/tencent/biz/pubaccount/weishi_new/drama/cache/IFetchDataListener;", "Lcom/tencent/biz/pubaccount/weishi_new/combo/msg/bean/WSMsgPageData;", "onFailure", "", "errorCode", "", "errorMsg", "", "onSuccess", "data", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSMsgFragmentPresenter$fetchData$1
  implements IFetchDataListener<WSMsgPageData>
{
  WSMsgFragmentPresenter$fetchData$1(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    WSMsgContract.View localView = (WSMsgContract.View)this.a.getView();
    if (localView != null) {
      localView.aJ_();
    }
    localView = (WSMsgContract.View)this.a.getView();
    if (localView != null)
    {
      if (paramString == null) {
        paramString = "";
      }
      localView.a(paramInt, paramString, this.b);
    }
  }
  
  public void a(@NotNull WSMsgPageData paramWSMsgPageData)
  {
    Intrinsics.checkParameterIsNotNull(paramWSMsgPageData, "data");
    if ((!paramWSMsgPageData.a()) && (!paramWSMsgPageData.b()))
    {
      localObject = WSMsgFragmentPresenter.a(this.a);
      if (localObject != null) {
        ((WSMsgPageData)localObject).a(paramWSMsgPageData.a(), paramWSMsgPageData.b(), paramWSMsgPageData.c(), paramWSMsgPageData.d());
      }
      localObject = WSMsgFragmentPresenter.a(this.a);
      if (localObject != null)
      {
        localObject = ((WSMsgPageData)localObject).e();
        if (localObject != null)
        {
          List localList = paramWSMsgPageData.e();
          Intrinsics.checkExpressionValueIsNotNull(localList, "data.sectionList");
          ((List)localObject).addAll((Collection)localList);
        }
      }
    }
    else
    {
      WSMsgFragmentPresenter.a(this.a, paramWSMsgPageData);
    }
    Object localObject = (WSMsgContract.View)this.a.getView();
    if (localObject != null) {
      ((WSMsgContract.View)localObject).aJ_();
    }
    localObject = (WSMsgContract.View)this.a.getView();
    if (localObject != null) {
      ((WSMsgContract.View)localObject).a(paramWSMsgPageData, this.b, this.c, paramWSMsgPageData.d() ^ true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.msg.WSMsgFragmentPresenter.fetchData.1
 * JD-Core Version:    0.7.0.1
 */