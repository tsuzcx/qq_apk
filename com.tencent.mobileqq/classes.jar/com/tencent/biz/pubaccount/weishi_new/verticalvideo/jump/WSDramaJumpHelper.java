package com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageIntentParams;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/WSDramaJumpHelper;", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/IWSVerticalJumpHelper;", "()V", "handle", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSDramaJumpHelper
  implements IWSVerticalJumpHelper
{
  public static final WSDramaJumpHelper.Companion a = new WSDramaJumpHelper.Companion(null);
  
  public boolean a(@NotNull Context paramContext, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramBundle != null) {
      paramBundle = paramBundle.getBundle("key_home_bundle");
    } else {
      paramBundle = null;
    }
    if (paramBundle == null)
    {
      WSLog.e("WSDramaJumpHelper", "homeBundle is null");
      return false;
    }
    String str1 = paramBundle.getString("key_drama_id", "");
    String str2 = paramBundle.getString("key_drama_jump_schema", "");
    paramBundle.putString("key_drama_id", "");
    paramBundle.putString("key_drama_jump_schema", "");
    Intrinsics.checkExpressionValueIsNotNull(str1, "redDotDramaId");
    if (StringsKt.isBlank((CharSequence)str1))
    {
      WSLog.e("WSDramaJumpHelper", "drama id is null");
      return false;
    }
    WSDramaPageFragment.a(new WSDramaPageIntentParams("aio_red_dot", paramContext).a(str1).b(str2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump.WSDramaJumpHelper
 * JD-Core Version:    0.7.0.1
 */