package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.data.MessageRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/engine/IRIJNormalRedDotInterceptor;", "", "onNotifyRedDotMsg", "", "mr", "Lcom/tencent/mobileqq/data/MessageRecord;", "onReceiveRedDotMsg", "onSaveRedDotMsg", "", "shouldIntercept", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJNormalRedDotInterceptor
{
  public static final IRIJNormalRedDotInterceptor.Companion a = IRIJNormalRedDotInterceptor.Companion.a;
  
  public abstract int a(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean a(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean b(@NotNull MessageRecord paramMessageRecord);
  
  public abstract boolean c(@NotNull MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.IRIJNormalRedDotInterceptor
 * JD-Core Version:    0.7.0.1
 */