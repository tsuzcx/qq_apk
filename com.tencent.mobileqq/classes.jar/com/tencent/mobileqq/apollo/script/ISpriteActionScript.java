package com.tencent.mobileqq.apollo.script;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/script/ISpriteActionScript;", "", "notifyPanelStatusChanged", "", "status", "", "notifyPanelTabStatusChange", "packageId", "", "changeReason", "notifyScreenSizeChange", "screenWidth", "", "screenHeight", "width", "height", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteActionScript
{
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2);
  
  public abstract void a(@NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.ISpriteActionScript
 * JD-Core Version:    0.7.0.1
 */