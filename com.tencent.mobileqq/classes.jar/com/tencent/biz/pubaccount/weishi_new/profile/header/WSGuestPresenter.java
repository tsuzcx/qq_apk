package com.tencent.biz.pubaccount.weishi_new.profile.header;

import UserGrowth.stPersonExt;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.ToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/header/WSGuestPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/header/AbsWSHeaderPresenter;", "context", "Landroid/content/Context;", "profileViewImpl", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;)V", "getDefaultSignature", "", "getRightBigBtnText", "getRightBigBtnTextSize", "", "getRightSmallBtnRes", "", "isHost", "", "onConfirmCancelFollow", "", "onRightBigBtnClick", "onRightSmallBtnClick", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSGuestPresenter
  extends AbsWSHeaderPresenter
{
  public static final WSGuestPresenter.Companion b = new WSGuestPresenter.Companion(null);
  
  public WSGuestPresenter(@NotNull Context paramContext, @NotNull WSProfileContract.View paramView)
  {
    super(paramContext, paramView);
  }
  
  @NotNull
  public String j()
  {
    Object localObject = a();
    if (localObject != null) {
      localObject = Integer.valueOf(((stSimpleMetaPerson)localObject).followStatus);
    } else {
      localObject = null;
    }
    int i;
    if ((localObject != null) && (((Integer)localObject).intValue() == 1)) {
      i = 1929838619;
    } else if ((localObject != null) && (((Integer)localObject).intValue() == 3)) {
      i = 1929838595;
    } else if ((localObject != null) && (((Integer)localObject).intValue() == 4)) {
      i = 1929838593;
    } else {
      i = 1929838617;
    }
    localObject = w().getString(i);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context.getString(stringId)");
    return localObject;
  }
  
  public float k()
  {
    return 14.0F;
  }
  
  public int l()
  {
    return 1929641987;
  }
  
  public void m()
  {
    WSLog.b("WSGuestPresenter", "onRightSmallBtnClick() conversation");
    WSProfileHeaderUtils localWSProfileHeaderUtils = WSProfileHeaderUtils.a;
    Context localContext = w();
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((stSimpleMetaPerson)localObject1).extInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stPersonExt)localObject1).msgSchema;
        break label45;
      }
    }
    localObject1 = null;
    label45:
    Object localObject2 = b();
    if (localObject2 != null) {
      localObject2 = ((WSProfileContract.View)localObject2).c();
    } else {
      localObject2 = null;
    }
    localWSProfileHeaderUtils.a(localContext, (stSchema)localObject1, (String)localObject2, a(), "private_letter");
  }
  
  public void n()
  {
    WSLog.b("WSGuestPresenter", "onRightBigBtnClick() follow");
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    if (localstSimpleMetaPerson == null)
    {
      WSLog.e("WSGuestPresenter", "onFollowBtnClick() mPerson is null");
      return;
    }
    if (q())
    {
      localObject = b();
      if (localObject != null) {
        ((WSProfileContract.View)localObject).b();
      }
      return;
    }
    if (!NetworkUtil.a((Context)BaseApplicationImpl.getContext()))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    Object localObject = b();
    if (localObject != null) {
      localObject = ((WSProfileContract.View)localObject).c();
    } else {
      localObject = null;
    }
    WSProfileBeaconReport.a((String)localObject, localstSimpleMetaPerson.id, localstSimpleMetaPerson.followStatus);
    WSUserBusiness.a().a(localstSimpleMetaPerson.id, 1);
  }
  
  @NotNull
  public String o()
  {
    String str = w().getString(1929838644);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…s_thanks_for_your_follow)");
    return str;
  }
  
  public void p()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = a();
    if (localstSimpleMetaPerson == null)
    {
      WSLog.e("WSGuestPresenter", "onConfirmCancelFollow() mPerson is null");
      return;
    }
    Object localObject = b();
    if (localObject != null) {
      localObject = ((WSProfileContract.View)localObject).c();
    } else {
      localObject = null;
    }
    WSProfileBeaconReport.a((String)localObject, localstSimpleMetaPerson.id, localstSimpleMetaPerson.followStatus);
    WSUserBusiness.a().a(localstSimpleMetaPerson.id, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.WSGuestPresenter
 * JD-Core Version:    0.7.0.1
 */