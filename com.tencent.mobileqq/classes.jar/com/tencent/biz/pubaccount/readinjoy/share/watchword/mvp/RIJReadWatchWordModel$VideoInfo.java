package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$VideoInfo;", "", "coverUrl", "", "title", "videoCoverType", "", "rowkey", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCoverUrl", "()Ljava/lang/String;", "getRowkey", "getTitle", "getVideoCoverType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJReadWatchWordModel$VideoInfo
{
  private final int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public RIJReadWatchWordModel$VideoInfo(@NotNull String paramString1, @NotNull String paramString2, int paramInt, @NotNull String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
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
      if ((paramObject instanceof VideoInfo))
      {
        paramObject = (VideoInfo)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.b, paramObject.b)) || (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (str != null)
    {
      i = str.hashCode();
      str = this.b;
      if (str == null) {
        break label82;
      }
    }
    label82:
    for (int j = str.hashCode();; j = 0)
    {
      int m = this.jdField_a_of_type_Int;
      str = this.c;
      if (str != null) {
        k = str.hashCode();
      }
      return ((j + i * 31) * 31 + m) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "VideoInfo(coverUrl=" + this.jdField_a_of_type_JavaLangString + ", title=" + this.b + ", videoCoverType=" + this.jdField_a_of_type_Int + ", rowkey=" + this.c + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.VideoInfo
 * JD-Core Version:    0.7.0.1
 */