package com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/share/watchword/mvp/RIJReadWatchWordModel$UserInfo;", "", "nickName", "", "uin", "", "(Ljava/lang/String;J)V", "getNickName", "()Ljava/lang/String;", "getUin", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJReadWatchWordModel$UserInfo
{
  private final long jdField_a_of_type_Long;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  
  public RIJReadWatchWordModel$UserInfo(@NotNull String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof UserInfo))
      {
        paramObject = (UserInfo)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      long l = this.jdField_a_of_type_Long;
      return i * 31 + (int)(l ^ l >>> 32);
    }
  }
  
  @NotNull
  public String toString()
  {
    return "UserInfo(nickName=" + this.jdField_a_of_type_JavaLangString + ", uin=" + this.jdField_a_of_type_Long + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.UserInfo
 * JD-Core Version:    0.7.0.1
 */