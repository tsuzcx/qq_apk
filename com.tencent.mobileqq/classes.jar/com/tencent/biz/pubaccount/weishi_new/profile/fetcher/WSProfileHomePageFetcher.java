package com.tencent.biz.pubaccount.weishi_new.profile.fetcher;

import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.profile.IWSProfileHomePageRspListener;
import com.tencent.biz.pubaccount.weishi_new.request.ProfileHomePageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/fetcher/WSProfileHomePageFetcher;", "", "()V", "fetchData", "", "pid", "", "listener", "Lcom/tencent/biz/pubaccount/weishi_new/profile/IWSProfileHomePageRspListener;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileHomePageFetcher
{
  public final boolean a(@Nullable String paramString, @NotNull IWSProfileHomePageRspListener paramIWSProfileHomePageRspListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIWSProfileHomePageRspListener, "listener");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i;
    if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    WSNetService.a((WSRequest)new ProfileHomePageRequest(paramString)).a((ServiceCallback)new WSProfileHomePageFetcher.fetchData.1(paramIWSProfileHomePageRspListener));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.fetcher.WSProfileHomePageFetcher
 * JD-Core Version:    0.7.0.1
 */