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
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.HerfData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.LinkData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.RptData;
import tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.TextData;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/Base0xd1eHandler;", "", "()V", "genLinkData", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$LinkData;", "commentLinkData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentLinkData;", "genRptData", "Ltencent/im/oidb/oidb_0xd1e/oidb_0xd1e$RptData;", "commentRptData", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentRptData;", "genTextData", "", "genTopicData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class Base0xd1eHandler
{
  public static final Base0xd1eHandler a = new Base0xd1eHandler();
  
  private final void a(@NotNull oidb_0xd1e.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(0);
    paramRptData = paramRptData.text_data;
    oidb_0xd1e.TextData localTextData = new oidb_0xd1e.TextData();
    localTextData.content.set(paramCommentRptData.jdField_a_of_type_JavaLangString);
    paramRptData.set((MessageMicro)localTextData);
  }
  
  private final void b(@NotNull oidb_0xd1e.RptData paramRptData, BaseCommentData.CommentRptData paramCommentRptData)
  {
    paramRptData.data_type.set(3);
    paramRptData = paramRptData.herf_data;
    oidb_0xd1e.HerfData localHerfData = new oidb_0xd1e.HerfData();
    localHerfData.content.set(paramCommentRptData.jdField_a_of_type_JavaLangString);
    paramRptData.set((MessageMicro)localHerfData);
  }
  
  @NotNull
  public final oidb_0xd1e.LinkData a(@NotNull BaseCommentData.CommentLinkData paramCommentLinkData)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentLinkData, "commentLinkData");
    oidb_0xd1e.LinkData localLinkData = new oidb_0xd1e.LinkData();
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
  public final oidb_0xd1e.RptData a(@NotNull BaseCommentData.CommentRptData paramCommentRptData)
  {
    Intrinsics.checkParameterIsNotNull(paramCommentRptData, "commentRptData");
    oidb_0xd1e.RptData localRptData = new oidb_0xd1e.RptData();
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.Base0xd1eHandler
 * JD-Core Version:    0.7.0.1
 */