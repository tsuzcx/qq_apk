package com.tencent.mobileqq.apollo.api.player.action;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/player/action/CMSAction$Companion;", "", "()V", "TAG", "", "wrap", "key", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSAction$Companion
{
  private final String a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return '"' + paramObject + '"';
    }
    return String.valueOf(paramObject);
  }
  
  private final String a(@Nullable Object paramObject, String paramString)
  {
    return '"' + paramString + "\":" + ((Companion)this).a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.action.CMSAction.Companion
 * JD-Core Version:    0.7.0.1
 */