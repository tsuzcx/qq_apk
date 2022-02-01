package com.tencent.biz.pubaccount.weishi_new.profile.header;

import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.jump.IJumpListener;
import com.tencent.biz.pubaccount.weishi_new.jump.WSStSchemaJumpManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/profile/header/WSProfileHeaderUtils;", "", "()V", "onJump", "", "context", "Landroid/content/Context;", "jumpScheme", "LUserGrowth/stSchema;", "from", "", "personInfo", "LUserGrowth/stSimpleMetaPerson;", "position", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSProfileHeaderUtils
{
  public static final WSProfileHeaderUtils a = new WSProfileHeaderUtils();
  
  public final void a(@NotNull Context paramContext, @Nullable stSchema paramstSchema, @Nullable String paramString1, @Nullable stSimpleMetaPerson paramstSimpleMetaPerson, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString2, "position");
    new WSStSchemaJumpManager(paramContext).a(true).c(true).a(paramstSchema).a((IJumpListener)new WSProfileHeaderUtils.onJump.1(paramString1, paramString2, paramstSimpleMetaPerson)).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.profile.header.WSProfileHeaderUtils
 * JD-Core Version:    0.7.0.1
 */