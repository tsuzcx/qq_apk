package com.tencent.biz.pubaccount.readinjoy.struct;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import localpb.readinjoy.Readinjoy.ArticleSummary;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rgl;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.ArticleSummary;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/struct/WeiShiVideoArticleInfo;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseVideoArticleInfo;", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "videoSubscriptColor", "", "videoSubscriptTxt", "writeToParcel", "", "dest", "flags", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WeiShiVideoArticleInfo
  extends BaseVideoArticleInfo
{
  public static final rgl Companion = new rgl(null);
  @JvmField
  @NotNull
  public static final String TABLE_NAME;
  @JvmField
  @Nullable
  public String videoSubscriptColor;
  @JvmField
  @Nullable
  public String videoSubscriptTxt;
  
  static
  {
    String str = WeiShiVideoArticleInfo.class.getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(str, "WeiShiVideoArticleInfo::class.java.simpleName");
    TABLE_NAME = str;
  }
  
  public WeiShiVideoArticleInfo() {}
  
  private WeiShiVideoArticleInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.videoSubscriptTxt = paramParcel.readString();
    this.videoSubscriptColor = paramParcel.readString();
  }
  
  @JvmStatic
  @Nullable
  public static final WeiShiVideoArticleInfo mergeFromArticleSummaryPb(@Nullable Readinjoy.ArticleSummary paramArticleSummary)
  {
    return Companion.a(paramArticleSummary);
  }
  
  @JvmStatic
  @Nullable
  public static final WeiShiVideoArticleInfo mergeFromCmd0xbedPb(@Nullable oidb_cmd0xbed.ArticleSummary paramArticleSummary)
  {
    return Companion.a(paramArticleSummary);
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.videoSubscriptTxt);
    paramParcel.writeString(this.videoSubscriptColor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo
 * JD-Core Version:    0.7.0.1
 */