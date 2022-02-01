package com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump;

import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/WSOpenHomeThenVideoManager;", "", "()V", "jumpHelperList", "", "Lcom/tencent/biz/pubaccount/weishi_new/verticalvideo/jump/IWSVerticalJumpHelper;", "handleJumpVertical", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSOpenHomeThenVideoManager
{
  private final List<IWSVerticalJumpHelper> a = CollectionsKt.listOf(new IWSVerticalJumpHelper[] { (IWSVerticalJumpHelper)new WSCLinkJumpHelper(), (IWSVerticalJumpHelper)new WSOpenHomeThenVideoJumpHelper(), (IWSVerticalJumpHelper)new WSDramaJumpHelper() });
  
  public final void a(@NotNull Context paramContext, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Iterator localIterator = this.a.iterator();
    while ((localIterator.hasNext()) && (!((IWSVerticalJumpHelper)localIterator.next()).a(paramContext, paramBundle))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.jump.WSOpenHomeThenVideoManager
 * JD-Core Version:    0.7.0.1
 */