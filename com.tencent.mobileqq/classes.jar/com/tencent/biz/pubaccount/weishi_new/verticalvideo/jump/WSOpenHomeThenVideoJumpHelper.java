package com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.WSOpenHomeThenVideoParams;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.VerticalPageLauncher;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedParseUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/WSOpenHomeThenVideoJumpHelper;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/IWSVerticalJumpHelper;", "()V", "getRecommendSubTabId", "", "handle", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSOpenHomeThenVideoJumpHelper
  implements IWSVerticalJumpHelper
{
  public static final WSOpenHomeThenVideoJumpHelper.Companion a = new WSOpenHomeThenVideoJumpHelper.Companion(null);
  
  private final String a()
  {
    if (!WSComboExpHelper.a.a())
    {
      WSExpABTestManager localWSExpABTestManager = WSExpABTestManager.a();
      Intrinsics.checkExpressionValueIsNotNull(localWSExpABTestManager, "WSExpABTestManager.getInstance()");
      if (localWSExpABTestManager.m()) {
        return "1000";
      }
    }
    return "";
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramBundle == null)
    {
      WSLog.e("WSOpenHomeThenVideoJumpHelper", "bundle is null.");
      return false;
    }
    paramBundle = paramBundle.getBundle("key_home_bundle");
    if (paramBundle != null) {
      paramBundle = paramBundle.getSerializable("key_open_home_then_video_params");
    } else {
      paramBundle = null;
    }
    Object localObject = paramBundle;
    if (!(paramBundle instanceof WSOpenHomeThenVideoParams)) {
      localObject = null;
    }
    paramBundle = (WSOpenHomeThenVideoParams)localObject;
    if (paramBundle == null)
    {
      WSLog.e("WSOpenHomeThenVideoJumpHelper", "openHomeThenVideoParams is null.");
      return false;
    }
    localObject = (CharSequence)paramBundle.getFeedId();
    int i;
    if ((localObject != null) && (!StringsKt.isBlank((CharSequence)localObject))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      WSLog.e("WSOpenHomeThenVideoJumpHelper", "openHomeThenVideoParams.feedId is null or blank.");
      return false;
    }
    localObject = WSFeedParseUtils.a(paramBundle.getFeedJson());
    List localList = (List)new ArrayList();
    if (localObject != null) {
      localList.add(localObject);
    }
    WSLauncher.VerticalPageLauncher.a(new WSVerticalPageOpenParams("open_home_then_video", paramBundle.getPlayScene()).e(paramBundle.getFeedId()).a(localList).a(paramContext).a(a()).a(0).a(false).c(0).c(String.valueOf(System.currentTimeMillis())).e(2).a(paramBundle.getAutoShowCommentParams()));
    WSLog.e("WSOpenHomeThenVideoJumpHelper", "handle() success.");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump.WSOpenHomeThenVideoJumpHelper
 * JD-Core Version:    0.7.0.1
 */