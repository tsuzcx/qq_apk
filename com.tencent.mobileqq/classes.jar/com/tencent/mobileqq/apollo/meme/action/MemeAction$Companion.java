package com.tencent.mobileqq.apollo.meme.action;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/action/MemeAction$Companion;", "", "()V", "TAG", "", "wrap", "key", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public final class MemeAction$Companion
{
  private final String a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(paramObject);
      localStringBuilder.append('"');
      return localStringBuilder.toString();
    }
    return String.valueOf(paramObject);
  }
  
  private final String a(@Nullable Object paramObject, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    localStringBuilder.append(paramString);
    localStringBuilder.append("\":");
    localStringBuilder.append(((Companion)this).a(paramObject));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.action.MemeAction.Companion
 * JD-Core Version:    0.7.0.1
 */