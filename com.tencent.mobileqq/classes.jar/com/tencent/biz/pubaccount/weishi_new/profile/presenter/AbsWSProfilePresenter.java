package com.tencent.biz.pubaccount.weishi_new.profile.presenter;

import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import NS_KING_SOCIALIZE_META.stShareInfo;
import UserGrowth.stGetPersonalInfoRsp;
import UserGrowth.stSimpleMetaPerson;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.profile.IWSProfileHomePageRspListener;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View;
import com.tencent.biz.pubaccount.weishi_new.profile.fetcher.WSProfileHomePageFetcher;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/presenter/AbsWSProfilePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/presenter/WSBasePresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$Presenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/IWSProfileHomePageRspListener;", "()V", "from", "", "isLoadingData", "", "person", "LUserGrowth/stSimpleMetaPerson;", "profileHomePageFetcher", "Lcom/tencent/biz/pubaccount/weishi_new/profile/fetcher/WSProfileHomePageFetcher;", "shareInfo", "LNS_KING_SOCIALIZE_META/stShareInfo;", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getFeedNum", "", "getFrom", "getNewCnt", "num", "isIncrease", "getPerson", "getPersonId", "getPraiseNum", "getShareInfo", "isHost", "isNeedSetVisibleToUserWhenCreated", "isToolbarShowDetailBtn", "isToolbarShowFeedbackBtn", "isWorksDefaultSelected", "loadProfileHomePageData", "", "personId", "onFail", "errCode", "errMsg", "onFollowSuccess", "hasFollowed", "onFragmentVisibilityChanged", "fragmentVisible", "onLikeSuccess", "posterId", "feedId", "isDing", "onPageSelected", "isSelectedByClickAvatar", "onReceiveEvent", "event", "Lcom/tencent/biz/pubaccount/weishi_new/event/WSSimpleBaseEvent;", "onSuccess", "rsp", "LUserGrowth/stGetPersonalInfoRsp;", "parseArguments", "arguments", "Landroid/os/Bundle;", "reportExposureAfterGetData", "followStatus", "isShowPraise", "reportTabClick", "position", "reset", "setFrom", "setPerson", "startLoadData", "update", "updateView", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsWSProfilePresenter
  extends WSBasePresenter<WSProfileContract.View>
  implements IWSProfileHomePageRspListener, WSProfileContract.Presenter
{
  public static final AbsWSProfilePresenter.Companion a = new AbsWSProfilePresenter.Companion(null);
  private final WSProfileHomePageFetcher b = new WSProfileHomePageFetcher();
  private stSimpleMetaPerson c;
  private stShareInfo d;
  private String e;
  private boolean f;
  
  private final int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt + 1;
    }
    int i = paramInt - 1;
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private final void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    stSimpleMetaPerson localstSimpleMetaPerson = this.c;
    stMetaNumericSys localstMetaNumericSys;
    if (localstSimpleMetaPerson != null) {
      localstMetaNumericSys = localstSimpleMetaPerson.nueric;
    } else {
      localstMetaNumericSys = null;
    }
    if ((localView != null) && (!TextUtils.isEmpty((CharSequence)paramString1)) && (!TextUtils.isEmpty((CharSequence)paramString2)) && (localstSimpleMetaPerson != null))
    {
      if (localstMetaNumericSys == null) {
        return;
      }
      if ((Intrinsics.areEqual(paramString1, localstSimpleMetaPerson.id) ^ true)) {
        return;
      }
      int i = a(localstMetaNumericSys.receivepraise_num, paramBoolean);
      localstMetaNumericSys.receivepraise_num = i;
      localView.b(i);
    }
  }
  
  private final void a(boolean paramBoolean, String paramString)
  {
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    stSimpleMetaPerson localstSimpleMetaPerson = this.c;
    Object localObject;
    if (localstSimpleMetaPerson != null) {
      localObject = localstSimpleMetaPerson.nueric;
    } else {
      localObject = null;
    }
    if ((localView != null) && (!TextUtils.isEmpty((CharSequence)paramString)) && (localstSimpleMetaPerson != null))
    {
      CharSequence localCharSequence = (CharSequence)localstSimpleMetaPerson.id;
      int i;
      if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        if (localObject == null) {
          return;
        }
        if (Intrinsics.areEqual(paramString, localstSimpleMetaPerson.id))
        {
          i = WeishiUtils.a(localstSimpleMetaPerson.followStatus, paramBoolean);
          localstSimpleMetaPerson.followStatus = i;
          localView.a(i);
          int j = a(((stMetaNumericSys)localObject).fans_num, paramBoolean);
          ((stMetaNumericSys)localObject).fans_num = j;
          localView.c(j);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("personId = ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", newFollowStatus = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", newFansCnt = ");
          ((StringBuilder)localObject).append(j);
          WSLog.e("WSProfilePresenter", ((StringBuilder)localObject).toString());
          return;
        }
        if (Intrinsics.areEqual(localstSimpleMetaPerson.id, WeishiUtils.n()))
        {
          i = a(((stMetaNumericSys)localObject).interest_num, paramBoolean);
          ((stMetaNumericSys)localObject).interest_num = i;
          localView.d(i);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("personId = ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", newFollowCnt = ");
          ((StringBuilder)localObject).append(i);
          WSLog.e("WSProfilePresenter", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  private final int b(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson != null)
    {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.nueric;
      if (paramstSimpleMetaPerson != null) {
        return paramstSimpleMetaPerson.feed_num;
      }
    }
    return 0;
  }
  
  private final void b(int paramInt, boolean paramBoolean)
  {
    if (f())
    {
      WSProfileBeaconReport.c(this.e, d());
      return;
    }
    WSProfileBeaconReport.a(this.e, d(), paramInt, paramBoolean);
  }
  
  private final int c(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson != null)
    {
      paramstSimpleMetaPerson = paramstSimpleMetaPerson.nueric;
      if (paramstSimpleMetaPerson != null) {
        return paramstSimpleMetaPerson.praise_num;
      }
    }
    return 0;
  }
  
  public void a()
  {
    a(d());
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      WSProfileBeaconReport.f(this.e, d());
      return;
    }
    if (paramInt == 1) {
      WSProfileBeaconReport.g(this.e, d());
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    if (localView != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localView, "view ?: return");
      this.f = false;
      localView.a(paramInt, paramString);
      localView.u();
    }
  }
  
  public void a(@Nullable stGetPersonalInfoRsp paramstGetPersonalInfoRsp)
  {
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    Object localObject1;
    if (paramstGetPersonalInfoRsp != null) {
      localObject1 = paramstGetPersonalInfoRsp.info;
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (localView != null))
    {
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        localObject2 = ((stSimpleMetaPerson)localObject2).id;
        if (localObject2 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      if ((!StringsKt.isBlank((CharSequence)localObject2)) && ((Intrinsics.areEqual(localObject2, ((stSimpleMetaPerson)localObject1).id) ^ true)))
      {
        paramstGetPersonalInfoRsp = new StringBuilder();
        paramstGetPersonalInfoRsp.append("no same person. mPerson.id = ");
        paramstGetPersonalInfoRsp.append((String)localObject2);
        paramstGetPersonalInfoRsp.append(", rsp.pid = ");
        paramstGetPersonalInfoRsp.append(((stSimpleMetaPerson)localObject1).id);
        WSLog.e("WSProfilePresenter", paramstGetPersonalInfoRsp.toString());
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onSuccess() pid = ");
      ((StringBuilder)localObject2).append(((stSimpleMetaPerson)localObject1).id);
      ((StringBuilder)localObject2).append(", nick = ");
      ((StringBuilder)localObject2).append(((stSimpleMetaPerson)localObject1).nick);
      ((StringBuilder)localObject2).append(", isShowPraisedFeed = ");
      ((StringBuilder)localObject2).append(paramstGetPersonalInfoRsp.isShowPraisedFeed);
      WSLog.e("WSProfilePresenter", ((StringBuilder)localObject2).toString());
      boolean bool = false;
      this.f = false;
      this.c = ((stSimpleMetaPerson)localObject1);
      this.d = paramstGetPersonalInfoRsp.share_info;
      if (paramstGetPersonalInfoRsp.isShowPraisedFeed == 1) {
        bool = true;
      }
      localView.a((stSimpleMetaPerson)localObject1, Intrinsics.areEqual(((stSimpleMetaPerson)localObject1).id, WeishiUtils.n()));
      localObject1 = ((stSimpleMetaPerson)localObject1).nick;
      if (localObject1 == null) {
        localObject1 = "";
      }
      localView.a((String)localObject1);
      localView.a(b(this.c), c(this.c), bool);
      localView.u();
      b(paramstGetPersonalInfoRsp.info.followStatus, bool);
      return;
    }
    WSLog.e("WSProfilePresenter", "rsp is null.");
  }
  
  public void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    this.c = paramstSimpleMetaPerson;
  }
  
  public void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson, @Nullable String paramString) {}
  
  protected final void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson, boolean paramBoolean)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    if (localView != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localView, "view ?: return");
      localView.a(paramstSimpleMetaPerson, paramBoolean);
      localView.e();
      localView.b(paramstSimpleMetaPerson.id);
      localView.c(g());
    }
  }
  
  public void a(@Nullable Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("key_pid", "");
    stSimpleMetaPerson localstSimpleMetaPerson2 = (stSimpleMetaPerson)paramBundle.getSerializable("key_person");
    stSimpleMetaPerson localstSimpleMetaPerson1 = localstSimpleMetaPerson2;
    if (localstSimpleMetaPerson2 == null)
    {
      localstSimpleMetaPerson1 = new stSimpleMetaPerson();
      localstSimpleMetaPerson1.id = str;
    }
    a(localstSimpleMetaPerson1);
    paramBundle = paramBundle.getString("from", "");
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "arguments.getString(WSProfileIntentKey.FROM, \"\")");
    b(paramBundle);
  }
  
  public void a(@Nullable WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof FollowEvent))
    {
      paramWSSimpleBaseEvent = (FollowEvent)paramWSSimpleBaseEvent;
      a(paramWSSimpleBaseEvent.hasFollowed(), paramWSSimpleBaseEvent.getPersonId());
      return;
    }
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
    {
      paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
      if ((paramWSSimpleBaseEvent.getRpsStatus() == 4301) && (paramWSSimpleBaseEvent.isFromRsp()))
      {
        String str1 = paramWSSimpleBaseEvent.getPosterId();
        String str2 = paramWSSimpleBaseEvent.getFeedId();
        int i = paramWSSimpleBaseEvent.getRspIsDing();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        a(str1, str2, bool);
      }
    }
  }
  
  public void a(@Nullable String paramString)
  {
    if (this.f)
    {
      WSLog.e("WSProfilePresenter", "is loading data.");
      return;
    }
    if (this.b.a(paramString, (IWSProfileHomePageRspListener)this))
    {
      this.f = true;
      return;
    }
    paramString = (WSProfileContract.View)getView();
    if (paramString != null) {
      paramString.u();
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  @Nullable
  public ArrayList<Class<?>> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowEvent.class);
    localArrayList.add(LikeRspEvent.class);
    return localArrayList;
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "from");
    this.e = paramString;
  }
  
  public void b(boolean paramBoolean) {}
  
  @Nullable
  public stSimpleMetaPerson c()
  {
    return this.c;
  }
  
  @NotNull
  public String d()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).id;
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @Nullable
  public stShareInfo e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((stSimpleMetaPerson)localObject).id;
    } else {
      localObject = null;
    }
    return Intrinsics.areEqual(localObject, WeishiUtils.n());
  }
  
  @Nullable
  public String g()
  {
    return this.e;
  }
  
  public boolean h()
  {
    return f();
  }
  
  public boolean i()
  {
    return false;
  }
  
  public boolean j()
  {
    return false;
  }
  
  public boolean k()
  {
    return false;
  }
  
  protected final void l()
  {
    this.c = ((stSimpleMetaPerson)null);
    this.d = ((stShareInfo)null);
    this.f = false;
    WSProfileContract.View localView = (WSProfileContract.View)getView();
    if (localView != null) {
      localView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.presenter.AbsWSProfilePresenter
 * JD-Core Version:    0.7.0.1
 */