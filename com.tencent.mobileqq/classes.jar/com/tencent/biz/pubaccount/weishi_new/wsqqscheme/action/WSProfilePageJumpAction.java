package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.profile.WSProfileFragment;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/wsqqscheme/action/WSProfilePageJumpAction;", "Lcom/tencent/biz/pubaccount/weishi_new/wsqqscheme/action/AbsWSJumpAction;", "()V", "doAction", "", "context", "Landroid/content/Context;", "attrs", "", "", "extData", "", "startProfilePage", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfilePageJumpAction
  extends AbsWSJumpAction
{
  private final boolean a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap != null) {
      paramMap = (String)paramMap.get("pid");
    } else {
      paramMap = null;
    }
    if ((paramContext != null) && (!TextUtils.isEmpty((CharSequence)paramMap)))
    {
      WSProfileFragment.a(paramContext, paramMap, "qq_schema");
      return true;
    }
    return false;
  }
  
  protected boolean a(@Nullable Context paramContext, @Nullable Map<String, String> paramMap, @Nullable Object paramObject)
  {
    return a(paramContext, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSProfilePageJumpAction
 * JD-Core Version:    0.7.0.1
 */