package com.tencent.biz.pubaccount.weishi_new.instancestate;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/instancestate/WSInstanceStateConstants;", "", "()V", "KEY_ENTER_PUBLIC_ACC_FROM", "", "KEY_SCENE_FROM", "instanceStateRegisterList", "", "Lcom/tencent/biz/pubaccount/weishi_new/instancestate/IWSInstanceStateOperation;", "getInstanceStateRegisterList", "()Ljava/util/List;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSInstanceStateConstants
{
  public static final WSInstanceStateConstants a = new WSInstanceStateConstants();
  @NotNull
  private static final List<IWSInstanceStateOperation> b = CollectionsKt.listOf(new IWSInstanceStateOperation[] { (IWSInstanceStateOperation)new WSInstanceStateConstants.instanceStateRegisterList.1(), (IWSInstanceStateOperation)new WSInstanceStateConstants.instanceStateRegisterList.2() });
  
  @NotNull
  public final List<IWSInstanceStateOperation> a()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.instancestate.WSInstanceStateConstants
 * JD-Core Version:    0.7.0.1
 */