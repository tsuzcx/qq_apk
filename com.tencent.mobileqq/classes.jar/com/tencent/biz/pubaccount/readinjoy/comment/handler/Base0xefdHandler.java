package com.tencent.biz.pubaccount.readinjoy.comment.handler;

import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentRptData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.HerfData;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.LinkData;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.RptData;
import tencent.im.oidb.oidb_0xefd.oidb_0xefd.TextData;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/Base0xefdHandler;", "", "()V", "genLinkData", "Ltencent/im/oidb/oidb_0xefd/oidb_0xefd$LinkData;", "commentLinkData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentLinkData;", "genRptData", "Ltencent/im/oidb/oidb_0xefd/oidb_0xefd$RptData;", "commentRptData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentRptData;", "genTextData", "", "genTopicData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class Base0xefdHandler
{
  public static final Base0xefdHandler a = new Base0xefdHandler();
  
  private final void a(@NotNull oidb_0xefd.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(0);
    paramRptData = paramRptData.text_data;
    oidb_0xefd.TextData localTextData = new oidb_0xefd.TextData();
    localTextData.content.set(paramCommentRptData.jdField_a_of_type_JavaLangString);
    paramRptData.set((MessageMicro)localTextData);
  }
  
  private final void b(@NotNull oidb_0xefd.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(3);
    paramRptData = paramRptData.herf_data;
    oidb_0xefd.HerfData localHerfData = new oidb_0xefd.HerfData();
    localHerfData.content.set(paramCommentRptData.jdField_a_of_type_JavaLangString);
    paramRptData.set((MessageMicro)localHerfData);
  }
  
  @NotNull
  public final oidb_0xefd.LinkData a(@NotNull BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentLinkData, "commentLinkData");
    oidb_0xefd.LinkData localLinkData = new oidb_0xefd.LinkData();
    localLinkData.type.set(paramCommentLinkData.type);
    localLinkData.url.set(paramCommentLinkData.linkUrl);
    PBStringField localPBStringField = localLinkData.icon;
    String str = paramCommentLinkData.iconUrl;
    if (str != null) {}
    for (;;)
    {
      localPBStringField.set(str);
      localLinkData.wording.set(paramCommentLinkData.wording);
      return localLinkData;
      str = "";
    }
  }
  
  @NotNull
  public final oidb_0xefd.RptData a(@NotNull BaseCommentData.CommentRptData paramCommentRptData)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentRptData, "commentRptData");
    oidb_0xefd.RptData localRptData = new oidb_0xefd.RptData();
    switch (paramCommentRptData.jdField_a_of_type_Int)
    {
    case 1: 
    case 2: 
    default: 
      return localRptData;
    case 0: 
      a.a(localRptData, paramCommentRptData);
      return localRptData;
    }
    a.b(localRptData, paramCommentRptData);
    return localRptData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.Base0xefdHandler
 * JD-Core Version:    0.7.0.1
 */