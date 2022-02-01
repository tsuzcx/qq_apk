package com.tencent.biz.pubaccount.weishi_new.profile.header;

import NS_KING_SOCIALIZE_META.stMetaAddr;
import NS_KING_SOCIALIZE_META.stMetaNumericSys;
import UserGrowth.stPersonExt;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSAddressUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSTextFormatter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/header/AbsWSHeaderPresenter;", "", "context", "Landroid/content/Context;", "profileViewImpl", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;)V", "getContext", "()Landroid/content/Context;", "mPerson", "LUserGrowth/stSimpleMetaPerson;", "getMPerson", "()LUserGrowth/stSimpleMetaPerson;", "setMPerson", "(LUserGrowth/stSimpleMetaPerson;)V", "mProfileViewRf", "Lmqq/util/WeakReference;", "formatBasicNum", "", "num", "", "suffixTextId", "getCoverUrl", "", "getDefaultSignature", "getFansCntText", "getFollowCntText", "getLocation", "getNick", "getReceivePraiseCntText", "getRightBigBtnText", "getRightBigBtnTextSize", "", "getRightSmallBtnRes", "getSignature", "getUnitIndex", "entireString", "getView", "hasFollowed", "", "isFemale", "isHost", "isMale", "onConfirmCancelFollow", "", "onFansCntClick", "onFollowCntClick", "onReceivePraiseCntClick", "onRightBigBtnClick", "onRightSmallBtnClick", "setData", "person", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsWSHeaderPresenter
{
  public static final AbsWSHeaderPresenter.Companion a = new AbsWSHeaderPresenter.Companion(null);
  private static final int e = DisplayUtil.c((Context)BaseApplicationImpl.getApplication(), 12.0F);
  private static final int f = DisplayUtil.c((Context)BaseApplicationImpl.getApplication(), 16.0F);
  @Nullable
  private stSimpleMetaPerson b;
  private WeakReference<WSProfileContract.View> c;
  @NotNull
  private final Context d;
  
  public AbsWSHeaderPresenter(@NotNull Context paramContext, @NotNull WSProfileContract.View paramView)
  {
    this.d = paramContext;
    this.c = new WeakReference(paramView);
  }
  
  private final int a(String paramString)
  {
    paramString = (CharSequence)paramString;
    int i = StringsKt.indexOf$default(paramString, "万", 0, false, 6, null);
    if (i != -1) {
      return i;
    }
    return StringsKt.indexOf$default(paramString, "亿", 0, false, 6, null);
  }
  
  private final CharSequence a(int paramInt1, int paramInt2)
  {
    String str = WSTextFormatter.b(paramInt1);
    Intrinsics.checkExpressionValueIsNotNull(str, "WSTextFormatter.formatNumCh(num)");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(this.d.getString(paramInt2));
    localObject = ((StringBuilder)localObject).toString();
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
    paramInt1 = str.length();
    paramInt2 = ((String)localObject).length();
    localSpannableString.setSpan(new AbsoluteSizeSpan(e), paramInt1, paramInt2, 33);
    localSpannableString.setSpan(new ForegroundColorSpan(this.d.getResources().getColor(2131165566)), paramInt1, paramInt2, 33);
    paramInt1 = a((String)localObject);
    if (paramInt1 != -1) {
      localSpannableString.setSpan(new AbsoluteSizeSpan(f), paramInt1, paramInt1 + 1, 33);
    }
    return (CharSequence)localSpannableString;
  }
  
  @Nullable
  protected final stSimpleMetaPerson a()
  {
    return this.b;
  }
  
  public final void a(@Nullable stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    this.b = paramstSimpleMetaPerson;
  }
  
  @Nullable
  public final WSProfileContract.View b()
  {
    return (WSProfileContract.View)this.c.get();
  }
  
  @NotNull
  public final String c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).nick;
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @NotNull
  public final String d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).background;
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @NotNull
  public final String e()
  {
    WSAddressUtil localWSAddressUtil = WSAddressUtil.a;
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((stSimpleMetaPerson)localObject).formatAddr;
    } else {
      localObject = null;
    }
    return localWSAddressUtil.a((stMetaAddr)localObject, true);
  }
  
  @NotNull
  public final String f()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).status;
      CharSequence localCharSequence = (CharSequence)localObject;
      int i;
      if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        localObject = o();
      }
      return localObject;
    }
    return "";
  }
  
  @NotNull
  public final CharSequence g()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).nueric;
      if (localObject != null)
      {
        i = ((stMetaNumericSys)localObject).interest_num;
        break label28;
      }
    }
    int i = 0;
    label28:
    return a(i, 1929838617);
  }
  
  @NotNull
  public final CharSequence h()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).nueric;
      if (localObject != null)
      {
        i = ((stMetaNumericSys)localObject).fans_num;
        break label28;
      }
    }
    int i = 0;
    label28:
    return a(i, 1929838615);
  }
  
  @NotNull
  public final CharSequence i()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((stSimpleMetaPerson)localObject).nueric;
      if (localObject != null)
      {
        i = ((stMetaNumericSys)localObject).receivepraise_num;
        break label28;
      }
    }
    int i = 0;
    label28:
    return a(i, 1929838640);
  }
  
  @NotNull
  public abstract String j();
  
  public abstract float k();
  
  public abstract int l();
  
  public abstract void m();
  
  public abstract void n();
  
  @NotNull
  public abstract String o();
  
  public void p() {}
  
  public final boolean q()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.b;
    boolean bool = true;
    if ((localstSimpleMetaPerson == null) || (localstSimpleMetaPerson.followStatus != 1))
    {
      localstSimpleMetaPerson = this.b;
      if ((localstSimpleMetaPerson != null) && (localstSimpleMetaPerson.followStatus == 3)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public final boolean r()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.b;
    return (localstSimpleMetaPerson != null) && (localstSimpleMetaPerson.sex == 1);
  }
  
  public final boolean s()
  {
    stSimpleMetaPerson localstSimpleMetaPerson = this.b;
    return (localstSimpleMetaPerson != null) && (localstSimpleMetaPerson.sex == 0);
  }
  
  public final void t()
  {
    WSLog.b("AbsWSHeaderPresenter", "onFollowCntClick()");
    WSProfileHeaderUtils localWSProfileHeaderUtils = WSProfileHeaderUtils.a;
    Context localContext = this.d;
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((stSimpleMetaPerson)localObject1).extInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stPersonExt)localObject1).followSchema;
        break label47;
      }
    }
    localObject1 = null;
    label47:
    Object localObject2 = b();
    if (localObject2 != null) {
      localObject2 = ((WSProfileContract.View)localObject2).c();
    } else {
      localObject2 = null;
    }
    localWSProfileHeaderUtils.a(localContext, (stSchema)localObject1, (String)localObject2, this.b, "concern_number");
  }
  
  public final void u()
  {
    WSLog.b("AbsWSHeaderPresenter", "onFansCntClick()");
    WSProfileHeaderUtils localWSProfileHeaderUtils = WSProfileHeaderUtils.a;
    Context localContext = this.d;
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((stSimpleMetaPerson)localObject1).extInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stPersonExt)localObject1).fansSchema;
        break label47;
      }
    }
    localObject1 = null;
    label47:
    Object localObject2 = b();
    if (localObject2 != null) {
      localObject2 = ((WSProfileContract.View)localObject2).c();
    } else {
      localObject2 = null;
    }
    localWSProfileHeaderUtils.a(localContext, (stSchema)localObject1, (String)localObject2, this.b, "fans_number");
  }
  
  public final void v()
  {
    WSLog.b("AbsWSHeaderPresenter", "onReceivePraiseCntClick()");
    WSProfileHeaderUtils localWSProfileHeaderUtils = WSProfileHeaderUtils.a;
    Context localContext = this.d;
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((stSimpleMetaPerson)localObject1).extInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stPersonExt)localObject1).dingSchema;
        break label47;
      }
    }
    localObject1 = null;
    label47:
    Object localObject2 = b();
    if (localObject2 != null) {
      localObject2 = ((WSProfileContract.View)localObject2).c();
    } else {
      localObject2 = null;
    }
    localWSProfileHeaderUtils.a(localContext, (stSchema)localObject1, (String)localObject2, this.b, "praise_number");
  }
  
  @NotNull
  public final Context w()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.AbsWSHeaderPresenter
 * JD-Core Version:    0.7.0.1
 */