package com.tencent.mobileqq.apollo.api.channel;

import android.app.Activity;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/channel/IRequestHandler;", "", "checkReCreateOnActivityChanged", "", "activity", "Landroid/app/Activity;", "destroyHandler", "", "getHandlePriority", "", "handleCmd", "Lcom/tencent/mobileqq/apollo/aioChannel/HandleResult;", "jsState", "", "cmd", "", "reqData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IRequestHandler
{
  public abstract int a();
  
  @Nullable
  public abstract HandleResult a(long paramLong, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void a();
  
  public abstract boolean a(@Nullable Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.channel.IRequestHandler
 * JD-Core Version:    0.7.0.1
 */