package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "onActionStatusChange", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "status", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface InnerMemePlayerListener
  extends IMemePlayerListener
{
  public abstract void a(@NotNull MemeAction paramMemeAction, @NotNull ActionStatus paramActionStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.InnerMemePlayerListener
 * JD-Core Version:    0.7.0.1
 */