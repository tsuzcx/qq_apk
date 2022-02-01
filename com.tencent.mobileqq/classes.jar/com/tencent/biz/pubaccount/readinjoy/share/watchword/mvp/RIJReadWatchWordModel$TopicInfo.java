package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$TopicInfo;", "", "iconUrl", "", "title", "topicId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getTitle", "getTopicId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJReadWatchWordModel$TopicInfo
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public RIJReadWatchWordModel$TopicInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TopicInfo))
      {
        paramObject = (TopicInfo)paramObject;
        if ((!Intrinsics.areEqual(this.a, paramObject.a)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (!Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    String str = this.a;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.b;
      if (str == null) {
        break label70;
      }
    }
    label70:
    for (int j = str.hashCode();; j = 0)
    {
      str = this.c;
      if (str != null) {
        k = str.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "TopicInfo(iconUrl=" + this.a + ", title=" + this.b + ", topicId=" + this.c + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.TopicInfo
 * JD-Core Version:    0.7.0.1
 */