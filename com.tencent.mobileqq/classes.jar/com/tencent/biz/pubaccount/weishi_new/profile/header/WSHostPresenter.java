package com.tencent.biz.pubaccount.weishi_new.profile.header;

import UserGrowth.stPersonExt;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileContract.View;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/header/WSHostPresenter;", "Lcom/tencent/biz/pubaccount/weishi_new/profile/header/AbsWSHeaderPresenter;", "context", "Landroid/content/Context;", "profileViewImpl", "Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi_new/profile/WSProfileContract$View;)V", "getDefaultSignature", "", "getRightBigBtnText", "getRightBigBtnTextSize", "", "getRightSmallBtnRes", "", "isHost", "", "onRightBigBtnClick", "", "onRightSmallBtnClick", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSHostPresenter
  extends AbsWSHeaderPresenter
{
  public static final WSHostPresenter.Companion b = new WSHostPresenter.Companion(null);
  
  public WSHostPresenter(@NotNull Context paramContext, @NotNull WSProfileContract.View paramView)
  {
    super(paramContext, paramView);
  }
  
  @NotNull
  public String j()
  {
    String str = w().getString(1929838613);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.string.ws_edit_profile)");
    return str;
  }
  
  public float k()
  {
    return 12.0F;
  }
  
  public int l()
  {
    return 1929642008;
  }
  
  public void m()
  {
    WSLog.b("WSHostPresenter", "onRightSmallBtnClick() setting");
    WSProfileHeaderUtils localWSProfileHeaderUtils = WSProfileHeaderUtils.a;
    Context localContext = w();
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((stSimpleMetaPerson)localObject1).extInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stPersonExt)localObject1).settingSchema;
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
    localWSProfileHeaderUtils.a(localContext, (stSchema)localObject1, (String)localObject2, a(), "set_up");
  }
  
  public void n()
  {
    WSLog.b("WSHostPresenter", "onRightBigBtnClick() edit profile");
    WSProfileHeaderUtils localWSProfileHeaderUtils = WSProfileHeaderUtils.a;
    Context localContext = w();
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject1 = ((stSimpleMetaPerson)localObject1).extInfo;
      if (localObject1 != null)
      {
        localObject1 = ((stPersonExt)localObject1).editSchema;
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
    localWSProfileHeaderUtils.a(localContext, (stSchema)localObject1, (String)localObject2, a(), "editing_materials");
  }
  
  @NotNull
  public String o()
  {
    String str = w().getString(1929838614);
    Intrinsics.checkExpressionValueIsNotNull(str, "context.getString(R.stri…ignature_for_more_follow)");
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.WSHostPresenter
 * JD-Core Version:    0.7.0.1
 */