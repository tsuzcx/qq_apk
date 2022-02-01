package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyMedalInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageTypeOptHelper;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyEngineModule;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.AccountLevelInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Activity;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ArticleInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Banner;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ExtraInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.HerfData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Label;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.LinkData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MedalInfo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.MediaData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ReqParam;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RptData;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.RspBody;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.TextData;
import tencent.im.oidb.cmd0xdc8.oidb_cmd0xdc8.ReqBody;

public class ReadInJoyCommentPBModule
  extends ReadInJoyEngineModule
{
  private ReadInJoyCommentObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyCommentPBModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private ReadInJoyMedalInfo a(boolean paramBoolean, List<oidb_cmd0xc46.MedalInfo> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        oidb_cmd0xc46.MedalInfo localMedalInfo = (oidb_cmd0xc46.MedalInfo)paramList.next();
        ReadInJoyMedalInfo localReadInJoyMedalInfo = new ReadInJoyMedalInfo();
        if (localMedalInfo.is_jump.has()) {
          localReadInJoyMedalInfo.jdField_b_of_type_Int = localMedalInfo.is_jump.get();
        }
        if (localMedalInfo.jump_url.has()) {
          localReadInJoyMedalInfo.jdField_c_of_type_JavaLangString = localMedalInfo.jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.medal_type.has()) {
          localReadInJoyMedalInfo.jdField_a_of_type_Int = localMedalInfo.medal_type.get();
        }
        if (localMedalInfo.medal_id.has()) {
          localReadInJoyMedalInfo.jdField_a_of_type_Long = localMedalInfo.medal_id.get();
        }
        if (localMedalInfo.medal_name.has()) {
          localReadInJoyMedalInfo.jdField_a_of_type_JavaLangString = localMedalInfo.medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.medal_url.has()) {
          localReadInJoyMedalInfo.jdField_b_of_type_JavaLangString = localMedalInfo.medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.pic_width.has()) {
          localReadInJoyMedalInfo.jdField_c_of_type_Int = localMedalInfo.pic_width.get();
        }
        if (localMedalInfo.pic_height.has()) {
          localReadInJoyMedalInfo.jdField_d_of_type_Int = localMedalInfo.pic_height.get();
        }
        localReadInJoyMedalInfo.jdField_e_of_type_JavaLangString = "3";
        if (paramBoolean) {}
        for (localReadInJoyMedalInfo.f = "7";; localReadInJoyMedalInfo.f = "6")
        {
          localReadInJoyMedalInfo.h = paramString;
          localArrayList.add(localReadInJoyMedalInfo);
          break;
        }
      }
    }
    paramList = null;
    if (!localArrayList.isEmpty()) {
      paramList = (ReadInJoyMedalInfo)localArrayList.get(0);
    }
    return paramList;
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData a(oidb_cmd0xc46.RptData paramRptData)
  {
    if (paramRptData.text_data.has())
    {
      paramRptData = (oidb_cmd0xc46.TextData)paramRptData.text_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 0;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private CommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool2 = true;
    if ((paramComment == null) || (!paramComment.comment_id.has())) {
      return null;
    }
    CommentData localCommentData = new CommentData();
    a(paramComment, localCommentData);
    if (paramComment.sub_comments_total.has()) {
      localCommentData.subCommentNum = paramComment.sub_comments_total.get();
    }
    if (paramComment.sub_comments.has())
    {
      localCommentData.subCommentList = new ArrayList();
      Iterator localIterator = paramComment.sub_comments.get().iterator();
      while (localIterator.hasNext())
      {
        SubCommentData localSubCommentData = a((oidb_cmd0xc46.Comment)localIterator.next());
        if (localSubCommentData != null) {
          localCommentData.subCommentList.add(localSubCommentData);
        }
      }
    }
    if (paramComment.is_anchor.has())
    {
      if (paramComment.is_anchor.get() == 1)
      {
        bool1 = true;
        localCommentData.isAnchor = bool1;
      }
    }
    else if (paramComment.is_delete.has()) {
      if (paramComment.is_delete.get() != 1) {
        break label266;
      }
    }
    label266:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localCommentData.isDelete = bool1;
      if (paramComment.rpt_medal_info_list.has()) {
        localCommentData.medalInfo = a(false, paramComment.rpt_medal_info_list.get(), localCommentData.uin);
      }
      QLog.d("ReadInJoyCommentPBModule", 2, "convertCommentData | " + localCommentData.toString());
      return localCommentData;
      bool1 = false;
      break;
    }
  }
  
  private SubCommentData a(oidb_cmd0xc46.Comment paramComment)
  {
    boolean bool2 = false;
    if ((paramComment == null) || (!paramComment.comment_id.has())) {
      return null;
    }
    SubCommentData localSubCommentData = new SubCommentData();
    a(paramComment, localSubCommentData);
    if (paramComment.first_comment_id.has()) {
      localSubCommentData.parentCommentId = paramComment.first_comment_id.get();
    }
    if (paramComment.replied_user_id.has()) {
      localSubCommentData.repliedUserUin = paramComment.replied_user_id.get();
    }
    if (paramComment.replied_user_nick_name.has()) {
      localSubCommentData.repliedUserNickname = paramComment.replied_user_nick_name.get();
    }
    if (paramComment.replied_user_homepage.has()) {
      localSubCommentData.repliedUserHomePage = paramComment.replied_user_homepage.get();
    }
    if (paramComment.has_target.has()) {
      localSubCommentData.hasTarget = paramComment.has_target.get();
    }
    if (paramComment.is_anchor.has()) {
      if (paramComment.is_anchor.get() != 1) {
        break label269;
      }
    }
    label269:
    for (boolean bool1 = true;; bool1 = false)
    {
      localSubCommentData.isAnchor = bool1;
      if (paramComment.is_delete.has())
      {
        bool1 = bool2;
        if (paramComment.is_delete.get() == 1) {
          bool1 = true;
        }
        localSubCommentData.isDelete = bool1;
      }
      if (paramComment.rpt_medal_info_list.has()) {
        localSubCommentData.medalInfo = a(true, paramComment.rpt_medal_info_list.get(), localSubCommentData.uin);
      }
      QLog.d("ReadInJoyCommentPBModule", 2, "convertSubCommentData | " + localSubCommentData.toString());
      return localSubCommentData;
    }
  }
  
  private List<CommentData> a(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
      if (localObject != null)
      {
        localObject = a((oidb_cmd0xc46.Comment)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(@NotNull BaseCommentData paramBaseCommentData, @NotNull oidb_cmd0xc46.Comment paramComment)
  {
    if ((paramComment.is_multi_media.has()) && (paramComment.is_multi_media.get() == 1))
    {
      QLog.d("ReadInJoyCommentPBModule", 1, "comment type is multi media");
      if (paramComment.rpt_media_data_list.has()) {}
      for (paramComment = paramComment.rpt_media_data_list.get(); (paramComment != null) && (paramComment.size() > 0); paramComment = null)
      {
        int j = paramComment.size();
        QLog.d("ReadInJoyCommentPBModule", 1, "comment media size : " + j);
        paramBaseCommentData.mediaDataList = new ArrayList();
        int i = 0;
        while (i < j)
        {
          oidb_cmd0xc46.MediaData localMediaData = (oidb_cmd0xc46.MediaData)paramComment.get(i);
          BaseCommentData.MediaData localMediaData1 = new BaseCommentData.MediaData();
          localMediaData1.jdField_a_of_type_JavaLangString = localMediaData.text.get();
          localMediaData1.jdField_e_of_type_Int = localMediaData.media_type.get();
          localMediaData1.jdField_a_of_type_Int = localMediaData.pic_width.get();
          localMediaData1.jdField_b_of_type_Int = localMediaData.pic_length.get();
          localMediaData1.jdField_b_of_type_JavaLangString = localMediaData.pic_url.get();
          localMediaData1.jdField_e_of_type_JavaLangString = localMediaData.thumbnail_url.get();
          localMediaData1.jdField_d_of_type_JavaLangString = localMediaData.video_url.get();
          localMediaData1.jdField_d_of_type_Int = localMediaData.video_duration.get();
          localMediaData1.jdField_c_of_type_JavaLangString = localMediaData.sound_url.get();
          localMediaData1.jdField_c_of_type_Int = localMediaData.sound_duration.get();
          paramBaseCommentData.mediaDataList.add(localMediaData1);
          i += 1;
        }
      }
    }
  }
  
  private static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_b_of_type_Boolean = true;
      localImageRequest.jdField_b_of_type_Int = ViewUtils.b(37.0F);
      localImageRequest.jdField_a_of_type_Int = ViewUtils.b(37.0F);
      localImageRequest.jdField_c_of_type_Int = 1;
      RIJImageTypeOptHelper.a.a(localImageRequest, paramString);
      ImageManager.a().a(localImageRequest, new ReadInJoyCommentPBModule.12(paramString));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ReadInJoyCommentPBModule", 2, paramString.getMessage());
    }
  }
  
  private void a(oidb_cmd0xc46.ReqBody paramReqBody, CommonCommentData paramCommonCommentData)
  {
    if (paramCommonCommentData == null) {}
    do
    {
      return;
      if (paramCommonCommentData.getFeedsType() != -1) {
        paramReqBody.feeds_type.set(paramCommonCommentData.getFeedsType());
      }
    } while (TextUtils.isEmpty(paramCommonCommentData.getFeedsId()));
    paramReqBody.feeds_id.set(paramCommonCommentData.getFeedsId());
  }
  
  private static void a(oidb_cmd0xc46.RptData paramRptData, BaseCommentData paramBaseCommentData)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (RIJPBFieldUtils.a(paramRptData.data_type, 0))
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramBaseCommentData.commentRptDataList.add(localObject1);
      }
      return;
      localObject1 = a(paramRptData);
      continue;
      localObject1 = b(paramRptData);
    }
  }
  
  @Nullable
  private static BaseCommentData.CommentRptData b(oidb_cmd0xc46.RptData paramRptData)
  {
    if (paramRptData.herf_data.has())
    {
      paramRptData = (oidb_cmd0xc46.HerfData)paramRptData.herf_data.get();
      if (paramRptData != null)
      {
        BaseCommentData.CommentRptData localCommentRptData = new BaseCommentData.CommentRptData();
        localCommentRptData.jdField_a_of_type_Int = 3;
        localCommentRptData.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.content, "");
        localCommentRptData.jdField_b_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.url, "");
        localCommentRptData.jdField_c_of_type_JavaLangString = RIJPBFieldUtils.a(paramRptData.topic_id, "");
        return localCommentRptData;
      }
    }
    return null;
  }
  
  private List<SubCommentData> b(List<oidb_cmd0xc46.Comment> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (oidb_cmd0xc46.Comment)paramList.next();
      if (localObject != null)
      {
        localObject = a((oidb_cmd0xc46.Comment)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new oidb_cmd0xc46.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | retCode " + j);
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    ReadInJoyCommentPBModule.ResponseExtraInfo localResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    localResponseExtraInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label = new ReadInJoyCommentPBModule.Label();
    boolean bool;
    if (j == 0)
    {
      if (RIJPBFieldUtils.a(((oidb_cmd0xc46.RspBody)localObject1).next, 0) != 1) {
        break label1184;
      }
      bool = true;
    }
    for (;;)
    {
      paramObject.jdField_a_of_type_Boolean = bool;
      QLog.d("ReadInJoyCommentPBModule", 2, "handleCommonCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject1).next.get());
      paramObject.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(((oidb_cmd0xc46.RspBody)localObject1).page_cookie, "");
      if (((oidb_cmd0xc46.RspBody)localObject1).extra_info.has())
      {
        if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hot_next, 0) != 1) {
          break label1190;
        }
        bool = true;
        paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
        paramFromServiceMsg.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hot_page_cookie, "");
        localResponseExtraInfo.jdField_b_of_type_Long = RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).hidden_comment_count, 0);
        localResponseExtraInfo.jdField_a_of_type_Int = RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).show_mask, 0);
        if (!((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).jump_kva_schema.has()) {}
      }
      try
      {
        localResponseExtraInfo.jdField_a_of_type_JavaLangString = new String(Base64Util.decode(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).jump_kva_schema.get(), 0), "utf-8");
        if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).is_pgc_author, 0) == 1)
        {
          bool = true;
          localResponseExtraInfo.jdField_a_of_type_Boolean = bool;
          if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).is_show_label, 0) != 1) {
            break label1212;
          }
          bool = true;
          localResponseExtraInfo.jdField_b_of_type_Boolean = bool;
          if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).default_input.has()) {
            localResponseExtraInfo.jdField_b_of_type_JavaLangString = ((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).default_input.get();
          }
          Object localObject2;
          if (((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.has())
          {
            localObject2 = localResponseExtraInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
            if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_delete, 0) != 1) {
              break label1218;
            }
            bool = true;
            ((ReadInJoyCommentPBModule.Label)localObject2).jdField_a_of_type_Boolean = bool;
            localObject2 = localResponseExtraInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
            if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_top, 0) != 1) {
              break label1224;
            }
            bool = true;
            ((ReadInJoyCommentPBModule.Label)localObject2).c = bool;
            localObject2 = localResponseExtraInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
            if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_sink, 0) != 1) {
              break label1230;
            }
            bool = true;
            ((ReadInJoyCommentPBModule.Label)localObject2).jdField_b_of_type_Boolean = bool;
            localObject2 = localResponseExtraInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataReadInJoyCommentPBModule$Label;
            if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).label.show_block, 0) != 1) {
              break label1236;
            }
            bool = true;
            ((ReadInJoyCommentPBModule.Label)localObject2).d = bool;
          }
          if (RIJPBFieldUtils.a(((oidb_cmd0xc46.ExtraInfo)((oidb_cmd0xc46.RspBody)localObject1).extra_info.get()).is_show_follow_button, 0) != 1) {
            break label1242;
          }
          bool = true;
          this.jdField_a_of_type_Boolean = bool;
          if (((oidb_cmd0xc46.RspBody)localObject1).hot_comment_list.has()) {
            paramFromServiceMsg.jdField_a_of_type_JavaUtilList = a(((oidb_cmd0xc46.RspBody)localObject1).hot_comment_list.get());
          }
          if (((oidb_cmd0xc46.RspBody)localObject1).comment_list.has()) {
            paramObject.jdField_a_of_type_JavaUtilList = a(((oidb_cmd0xc46.RspBody)localObject1).comment_list.get());
          }
          if (((oidb_cmd0xc46.RspBody)localObject1).article_info.has())
          {
            localObject2 = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject1).article_info.get();
            localResponseExtraInfo.jdField_a_of_type_Long = RIJPBFieldUtils.a(((oidb_cmd0xc46.ArticleInfo)localObject2).comment_count, 0L);
            if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.has())) {
              break label1248;
            }
            if (((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get() == 0) {
              this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.1(this));
            }
            QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + ((oidb_cmd0xc46.ArticleInfo)localObject2).has_anchor.get());
          }
          paramToServiceMsg = null;
          if (((oidb_cmd0xc46.RspBody)localObject1).banner.has())
          {
            localObject1 = (oidb_cmd0xc46.Banner)((oidb_cmd0xc46.RspBody)localObject1).banner.get();
            paramToServiceMsg = new CommentData();
            paramToServiceMsg.commentId = String.valueOf(((oidb_cmd0xc46.Banner)localObject1).config_id.get());
            paramToServiceMsg.commentContent = ((oidb_cmd0xc46.Banner)localObject1).title.get();
            paramToServiceMsg.activityJumpUrl = ((oidb_cmd0xc46.Banner)localObject1).jump_url.get();
            paramToServiceMsg.isBanner = true;
            QLog.d("ReadInJoyCommentPBModule", 1, "handleCommonCommentList | banner configid ：" + paramToServiceMsg.commentId + "; title :" + paramToServiceMsg.commentContent + "; url " + paramToServiceMsg.activityJumpUrl);
          }
          localObject1 = new StringBuilder().append("handleCommonCommentList | retCode ").append(j).append(" | hasNewNextPage ").append(paramObject.jdField_a_of_type_Boolean).append(" | hasHotNextPage+").append(paramFromServiceMsg.jdField_a_of_type_Boolean).append(" | newPageCookie ").append(paramObject.jdField_a_of_type_JavaLangString).append("; hotPageCookie ").append(paramFromServiceMsg.jdField_a_of_type_JavaLangString).append("| articleCommentCnt ").append(localResponseExtraInfo.jdField_a_of_type_Long).append(" | hotCommentListSize ");
          if (paramFromServiceMsg.jdField_a_of_type_JavaUtilList == null) {
            break label1260;
          }
          i = paramFromServiceMsg.jdField_a_of_type_JavaUtilList.size();
          localObject1 = ((StringBuilder)localObject1).append(i).append(" | newCommentListSize ");
          if (paramObject.jdField_a_of_type_JavaUtilList == null) {
            break label1266;
          }
          i = paramObject.jdField_a_of_type_JavaUtilList.size();
          QLog.d("ReadInJoyCommentPBModule", 1, i + " ; extraInfo : " + localResponseExtraInfo);
          if (paramFromServiceMsg.a()) {
            paramFromServiceMsg.jdField_a_of_type_JavaUtilList.add(0, paramToServiceMsg);
          }
          if (paramObject.a()) {
            paramObject.jdField_a_of_type_JavaUtilList.add(0, paramToServiceMsg);
          }
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.2(this, j, paramFromServiceMsg, paramObject, localResponseExtraInfo));
          return;
          label1184:
          bool = false;
          continue;
          label1190:
          bool = false;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          continue;
          bool = false;
          continue;
          label1212:
          bool = false;
          continue;
          label1218:
          bool = false;
          continue;
          label1224:
          bool = false;
          continue;
          label1230:
          bool = false;
          continue;
          label1236:
          bool = false;
          continue;
          label1242:
          bool = false;
          continue;
          label1248:
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
          continue;
          label1260:
          int i = 0;
          continue;
          label1266:
          i = 0;
        }
      }
    }
  }
  
  private static void b(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if (!paramComment.rpt_data.has()) {}
    for (;;)
    {
      return;
      paramBaseCommentData.commentRptDataList = new ArrayList();
      paramComment = paramComment.rpt_data.get();
      if (paramComment != null)
      {
        paramComment = paramComment.iterator();
        while (paramComment.hasNext())
        {
          oidb_cmd0xc46.RptData localRptData = (oidb_cmd0xc46.RptData)paramComment.next();
          if (localRptData != null) {
            a(localRptData, paramBaseCommentData);
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | retCode " + i);
    ReadInJoyCommentPBModule.ResponseCommentInfo localResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    ReadInJoyCommentPBModule.ResponseExtraInfo localResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label469;
        }
        bool = true;
        localResponseCommentInfo.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleFamilyCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localResponseCommentInfo.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        localResponseCommentInfo.jdField_a_of_type_JavaUtilList = a(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localResponseExtraInfo.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label475;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.3(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "family comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.4(this, i, localResponseCommentInfo, localResponseExtraInfo, paramFromServiceMsg));
      return;
      label469:
      bool = false;
      break;
      label475:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | retCode " + i);
    ReadInJoyCommentPBModule.ResponseCommentInfo localResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    ReadInJoyCommentPBModule.ResponseExtraInfo localResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label469;
        }
        bool = true;
        localResponseCommentInfo.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleNewCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localResponseCommentInfo.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.comment_list.has()) {
        localResponseCommentInfo.jdField_a_of_type_JavaUtilList = a(localRspBody.comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localResponseExtraInfo.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label475;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.5(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "new comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.6(this, i, localResponseCommentInfo, localResponseExtraInfo, paramFromServiceMsg));
      return;
      label469:
      bool = false;
      break;
      label475:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xc46.RspBody localRspBody = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | retCode " + i);
    ReadInJoyCommentPBModule.ResponseCommentInfo localResponseCommentInfo = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    ReadInJoyCommentPBModule.ResponseExtraInfo localResponseExtraInfo = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    paramObject = null;
    paramFromServiceMsg = paramObject;
    boolean bool;
    if (i == 0)
    {
      if (localRspBody.next.has())
      {
        if (localRspBody.next.get() != 1) {
          break label469;
        }
        bool = true;
        localResponseCommentInfo.jdField_a_of_type_Boolean = bool;
        QLog.d("ReadInJoyCommentPBModule", 1, "handleHotCommentList | hasNextPage " + localRspBody.next.get());
      }
      if (localRspBody.page_cookie.has()) {
        localResponseCommentInfo.jdField_a_of_type_JavaLangString = localRspBody.page_cookie.get().toStringUtf8();
      }
      if (localRspBody.hot_comment_list.has()) {
        localResponseCommentInfo.jdField_a_of_type_JavaUtilList = a(localRspBody.hot_comment_list.get());
      }
      if (localRspBody.article_info.has())
      {
        paramFromServiceMsg = (oidb_cmd0xc46.ArticleInfo)localRspBody.article_info.get();
        if (paramFromServiceMsg.comment_count.has()) {
          localResponseExtraInfo.jdField_a_of_type_Long = paramFromServiceMsg.comment_count.get();
        }
        if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!paramFromServiceMsg.has_anchor.has())) {
          break label475;
        }
        if (paramFromServiceMsg.has_anchor.get() == 0) {
          this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.7(this));
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + paramFromServiceMsg.has_anchor.get());
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramObject;
      if (localRspBody.banner.has())
      {
        paramToServiceMsg = (oidb_cmd0xc46.Banner)localRspBody.banner.get();
        paramFromServiceMsg = new CommentData();
        paramFromServiceMsg.commentId = String.valueOf(paramToServiceMsg.config_id.get());
        paramFromServiceMsg.commentContent = paramToServiceMsg.title.get();
        paramFromServiceMsg.activityJumpUrl = paramToServiceMsg.jump_url.get();
        paramFromServiceMsg.isBanner = true;
        QLog.d("ReadInJoyCommentPBModule", 1, "hot comment banner configid ：" + paramFromServiceMsg.commentId + "; title :" + paramFromServiceMsg.commentContent + "; url" + paramFromServiceMsg.activityPicUrl);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.8(this, i, localResponseCommentInfo, localResponseExtraInfo, paramFromServiceMsg));
      return;
      label469:
      bool = false;
      break;
      label475:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xc46.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | retCode " + i);
    paramFromServiceMsg = new ReadInJoyCommentPBModule.ResponseCommentInfo();
    paramObject = new ReadInJoyCommentPBModule.ResponseExtraInfo();
    boolean bool;
    if (i == 0) {
      if (((oidb_cmd0xc46.RspBody)localObject).next.has())
      {
        if (((oidb_cmd0xc46.RspBody)localObject).next.get() == 1)
        {
          bool = true;
          paramFromServiceMsg.jdField_a_of_type_Boolean = bool;
          QLog.d("ReadInJoyCommentPBModule", 1, "handleSubCommentList | hasNextPage " + ((oidb_cmd0xc46.RspBody)localObject).next.get());
        }
      }
      else
      {
        if (((oidb_cmd0xc46.RspBody)localObject).page_cookie.has()) {
          paramFromServiceMsg.jdField_a_of_type_JavaLangString = ((oidb_cmd0xc46.RspBody)localObject).page_cookie.get().toStringUtf8();
        }
        if (!((oidb_cmd0xc46.RspBody)localObject).comment_list.has()) {
          break label358;
        }
        paramFromServiceMsg.b = b(((oidb_cmd0xc46.RspBody)localObject).comment_list.get());
        label184:
        if (((oidb_cmd0xc46.RspBody)localObject).first_comment_detail.has()) {
          paramFromServiceMsg.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommentData = a((oidb_cmd0xc46.Comment)((oidb_cmd0xc46.RspBody)localObject).first_comment_detail.get());
        }
        if (((oidb_cmd0xc46.RspBody)localObject).article_info.has())
        {
          localObject = (oidb_cmd0xc46.ArticleInfo)((oidb_cmd0xc46.RspBody)localObject).article_info.get();
          if ((paramToServiceMsg.getAttribute("anchor_request") == null) || (!((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.has())) {
            break label372;
          }
          if (((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get() == 0) {
            this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.9(this));
          }
          QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor: " + ((oidb_cmd0xc46.ArticleInfo)localObject).has_anchor.get());
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = (String)paramToServiceMsg.getAttribute("parent_comment_id");
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.11(this, i, paramFromServiceMsg, paramToServiceMsg, paramObject));
      return;
      bool = false;
      break;
      label358:
      paramFromServiceMsg.b = new ArrayList();
      break label184;
      label372:
      QLog.d("ReadInJoyCommentPBModule", 1, "has_anchor : null");
      continue;
      paramFromServiceMsg.b = new ArrayList();
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyCommentPBModule.10(this, i));
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xc46.RspBody());
    int j = ((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue();
    ReadinjoyReportUtils.a(i, paramToServiceMsg, 5, null);
    if (ReadInJoyUtils.a() == null) {
      return;
    }
    paramFromServiceMsg = new HashMap();
    paramFromServiceMsg.put("retCode", String.valueOf(i));
    paramFromServiceMsg.put("request_comment_type", String.valueOf(j));
    paramObject = StatisticCollector.getInstance(ReadInJoyUtils.a().getApplication());
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramObject.collectPerformance(null, "actKandian0xc46Result", bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), 0L, paramFromServiceMsg, null);
      QLog.d("ReadInJoyCommentPBModule", 1, "report0xc46Result | actKandian0xc46Result | retCode ： " + i + "| request_comment_type : " + j);
      return;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver = null;
  }
  
  public void a(ReadInJoyCommentObserver paramReadInJoyCommentObserver)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentObserver = paramReadInJoyCommentObserver;
  }
  
  @VisibleForTesting
  void a(BaseCommentData paramBaseCommentData)
  {
    if ((paramBaseCommentData.isAuthorReply()) && (this.jdField_a_of_type_Boolean) && ((paramBaseCommentData instanceof CommentData)))
    {
      paramBaseCommentData.shouldShowFollowButton = true;
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    paramBaseCommentData.shouldShowFollowButton = false;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc46"))
    {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject);
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() != 1) {
        break label90;
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    for (;;)
    {
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xdc8")) {
        QLog.d("ReadInJoyCommentPBModule", 1, "handle 0xdc8 : " + paramFromServiceMsg.toString());
      }
      return;
      label90:
      if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 4) {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 3) {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 2) {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 5) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if (((Integer)paramToServiceMsg.getAttributes().get("service_type")).intValue() == 6) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestFamliyCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestFamliyCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + " ; pageCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqParam.with_style_data.set(1);
    localReqBody.req_param.set(localReqParam);
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(ReadInJoyCommentHelper.a(paramInt2));
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 6, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(6));
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestCommonCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestCommonCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + "; mainCommentId : " + paramString3 + " ; pageCookie : " + paramString2 + "; commonCommentData " + paramCommonCommentData);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    oidb_cmd0xc46.ReqParam localReqParam = new oidb_cmd0xc46.ReqParam();
    localReqParam.with_style_data.set(1);
    localReqParam.with_sub_comments.set(1);
    localReqParam.with_author_reply.set(1);
    localReqBody.req_param.set(localReqParam);
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(ReadInJoyCommentHelper.a(paramInt2));
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestCommonCommentList | articleId : " + paramString1 + " contentSrc : " + paramInt2 + "; mainCommentId : " + paramString3 + " ; pageCookie : " + paramString2);
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 5, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(5));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString4 == null) || (paramString3 == null) || (paramString2 == null)) {}
    do
    {
      return;
      oidb_cmd0xdc8.ReqBody localReqBody = new oidb_cmd0xdc8.ReqBody();
      QLog.d("ReadInJoyCommentPBModule", 1, "start request 0xdc8  rowKey :" + paramString1 + " parentCommentId :" + paramString2 + " subCommentId : " + paramString3 + " commentId :" + paramString4);
      localReqBody.str_rowkey.set(paramString1);
      localReqBody.str_first_comment_id.set(paramString2);
      localReqBody.str_sub_comment_id.set(paramString3);
      localReqBody.str_comment_id.set(paramString4);
      localReqBody.int32_flag.set(1);
      paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xdc8", 3528, 1, localReqBody.toByteArray());
    } while (paramString1 == null);
    a(paramString1);
    QLog.d("ReadInJoyCommentPBModule", 1, "0xdc8 request :" + paramString1.toString());
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestSubCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestSubCommentList | subPageCookie : " + paramString4);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.comment_id.set(paramString2);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString4));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(ReadInJoyCommentHelper.a(paramInt2));
    localReqBody.with_activity_data.set(1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.with_first_comment_detail.set(1);
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 4, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(4));
    paramString1.addAttribute("parent_comment_id", paramString2);
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void a(oidb_cmd0xc46.Comment paramComment, BaseCommentData paramBaseCommentData)
  {
    if ((paramComment == null) || (paramBaseCommentData == null)) {
      return;
    }
    paramBaseCommentData.commentId = RIJPBFieldUtils.a(paramComment.comment_id, "");
    paramBaseCommentData.uin = RIJPBFieldUtils.a(paramComment.author_id, "");
    paramBaseCommentData.commentTime = RIJPBFieldUtils.a(paramComment.create_time);
    paramBaseCommentData.commentContent = RIJPBFieldUtils.a(paramComment.content, "");
    b(paramComment, paramBaseCommentData);
    paramBaseCommentData.likeCnt = RIJPBFieldUtils.a(paramComment.like_num, 0);
    paramBaseCommentData.like = RIJPBFieldUtils.a(paramComment.like, 0);
    paramBaseCommentData.disLike = RIJPBFieldUtils.a(paramComment.dislike, 0);
    paramBaseCommentData.anonymous = RIJPBFieldUtils.a(paramComment.anonymous, 0);
    paramBaseCommentData.authorSelection = RIJPBFieldUtils.a(paramComment.author_selection, 0);
    paramBaseCommentData.rank = RIJPBFieldUtils.a(paramComment.rank, 0);
    paramBaseCommentData.level = RIJPBFieldUtils.a(paramComment.level);
    paramBaseCommentData.authorComment = RIJPBFieldUtils.a(paramComment.author_comment, "");
    paramBaseCommentData.nickName = RIJPBFieldUtils.a(paramComment.nick_name, "");
    boolean bool;
    if (RIJPBFieldUtils.a(paramComment.author_like) == 1) {
      bool = true;
    }
    for (;;)
    {
      paramBaseCommentData.isAuthorLike = bool;
      if (RIJPBFieldUtils.a(paramComment.follow_status) == 1)
      {
        bool = true;
        label204:
        paramBaseCommentData.isFollowing = bool;
        paramBaseCommentData.avatar = RIJPBFieldUtils.a(paramComment.avatar, "");
        a(paramBaseCommentData.avatar);
        paramBaseCommentData.myself = RIJPBFieldUtils.a(paramComment.myself, 0);
        paramBaseCommentData.homepage = RIJPBFieldUtils.a(paramComment.homepage, "");
        paramBaseCommentData.awesome = RIJPBFieldUtils.a(paramComment.awesome);
        paramBaseCommentData.rowKey = RIJPBFieldUtils.a(paramComment.rowkey, "");
        paramBaseCommentData.contentSrc = RIJPBFieldUtils.a(paramComment.content_source, 0);
        paramBaseCommentData.passthrough = RIJPBFieldUtils.a(paramComment.passthrough, "");
        paramBaseCommentData.isActivity = RIJPBFieldUtils.a(paramComment.is_activity);
        paramBaseCommentData.activityPicUrl = RIJPBFieldUtils.a(paramComment.pic_url, "");
        paramBaseCommentData.activityJumpUrl = RIJPBFieldUtils.a(paramComment.jump_url, "");
        paramBaseCommentData.isStar = RIJPBFieldUtils.a(paramComment.is_star);
        paramBaseCommentData.isApproved = RIJPBFieldUtils.a(paramComment.is_approved);
        if (paramComment.account_level_info.has())
        {
          paramBaseCommentData.accountLevelInfo = new BaseCommentData.AccountLevelInfo();
          paramBaseCommentData.accountLevelInfo.jdField_a_of_type_Int = RIJPBFieldUtils.a(paramComment.account_level_info.uint32_account_cc_level);
          paramBaseCommentData.accountLevelInfo.jdField_a_of_type_JavaLangString = RIJPBFieldUtils.a(paramComment.account_level_info.account_cc_level_icon_s, "");
        }
        paramBaseCommentData.createSrc = RIJPBFieldUtils.a(paramComment.create_source, 0);
        QLog.d("ReadInJoyCommentPBModule", 1, "create_source : " + paramComment.create_source.get());
        paramBaseCommentData.isAuthorReply = RIJPBFieldUtils.a(paramComment.is_author_reply);
        paramBaseCommentData.userTitle = RIJPBFieldUtils.a(paramComment.user_title, "");
        paramBaseCommentData.ksHomePage = RIJPBFieldUtils.a(paramComment.ks_homepage, "");
        if (paramComment.activity.has()) {
          paramBaseCommentData.activityCfgID = RIJPBFieldUtils.a(paramComment.activity.config_id);
        }
        if (!paramComment.jump_schema.has()) {}
      }
      try
      {
        paramBaseCommentData.flowGuidePtsData = new String(Base64Util.decode(paramComment.jump_schema.get(), 0), "utf-8");
        QLog.d("ReadInJoyCommentPBModule", 1, "flowGuidePtsData : " + paramBaseCommentData.flowGuidePtsData);
        label588:
        a(paramBaseCommentData, paramComment);
        paramBaseCommentData.styleData = RIJPBFieldUtils.a(paramComment.style_data, "");
        if (RIJPBFieldUtils.a(paramComment.comment_author_top) == 1)
        {
          bool = true;
          label620:
          paramBaseCommentData.isAuthorSticky = bool;
          if (RIJPBFieldUtils.a(paramComment.comment_author_top) != 3) {
            break label836;
          }
        }
        label836:
        for (bool = true;; bool = false)
        {
          paramBaseCommentData.isAuthorBottom = bool;
          paramBaseCommentData.avatarPendantUrl = RIJPBFieldUtils.a(paramComment.avatar_pendant, "");
          paramBaseCommentData.commentLinkDataList = new ArrayList();
          if (!paramComment.link_data.has()) {
            break label841;
          }
          paramBaseCommentData.commentLinkDataList = new ArrayList();
          Object localObject = paramComment.link_data.get();
          if (localObject == null) {
            break label841;
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            oidb_cmd0xc46.LinkData localLinkData = (oidb_cmd0xc46.LinkData)((Iterator)localObject).next();
            if (localLinkData != null)
            {
              BaseCommentData.CommentLinkData localCommentLinkData = new BaseCommentData.CommentLinkData();
              localCommentLinkData.iconUrl = RIJPBFieldUtils.a(localLinkData.icon, "");
              localCommentLinkData.linkUrl = RIJPBFieldUtils.a(localLinkData.url, "");
              localCommentLinkData.type = RIJPBFieldUtils.a(localLinkData.type, 0);
              localCommentLinkData.wording = RIJPBFieldUtils.a(localLinkData.wording, "");
              paramBaseCommentData.commentLinkDataList.add(localCommentLinkData);
            }
          }
          bool = false;
          break;
          bool = false;
          break label204;
          bool = false;
          break label620;
        }
        label841:
        if (paramComment.activity_level.has()) {
          paramBaseCommentData.activityLevel = ((oidb_cmd0xc46.ActivityLevel)paramComment.activity_level.get());
        }
        paramBaseCommentData.shareUrl = paramComment.share_url.get();
        paramBaseCommentData.commentApp = RIJPBFieldUtils.a(paramComment.comment_app, 0);
        a(paramBaseCommentData);
        if (QLog.isColorLevel()) {
          QLog.i("ReadInJoyCommentPBModule", 1, "[convertBaseCommentData] uin = " + paramBaseCommentData.uin + ", avatarPendantUrl = " + paramBaseCommentData.avatarPendantUrl);
        }
        QLog.d("ReadInJoyCommentPBModule", 1, "comment style_data " + paramBaseCommentData.styleData);
        QLog.d("ReadInJoyCommentPBModule", 2, "convertBaseCommentData | " + paramBaseCommentData.toString());
        return;
      }
      catch (Exception localException)
      {
        break label588;
      }
    }
  }
  
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestNewCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestNewCommentList | newCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(ReadInJoyCommentHelper.a(paramInt2));
    localReqBody.with_activity_data.set(1);
    paramString1 = new oidb_cmd0xc46.ReqParam();
    paramString1.with_sub_comments.set(1);
    paramString1.with_author_reply.set(1);
    paramString1.with_style_data.set(1);
    localReqBody.req_param.set(paramString1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 2, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(2));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
  
  public void c(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, CommonCommentData paramCommonCommentData)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("ReadInJoyCommentPBModule", 2, "requestHotCommentList | articleId is null");
      return;
    }
    QLog.d("ReadInJoyCommentPBModule", 1, "requestHotCommentList | hotPageCookie : " + paramString2);
    oidb_cmd0xc46.ReqBody localReqBody = new oidb_cmd0xc46.ReqBody();
    localReqBody.rowkey.set(paramString1);
    localReqBody.page_cookie.set(ByteStringMicro.copyFromUtf8(paramString2));
    localReqBody.page_size.set(paramInt1);
    localReqBody.content_src.set(ReadInJoyCommentHelper.a(paramInt2));
    localReqBody.with_activity_data.set(1);
    paramString1 = new oidb_cmd0xc46.ReqParam();
    paramString1.with_sub_comments.set(1);
    paramString1.with_author_reply.set(1);
    paramString1.with_style_data.set(1);
    localReqBody.req_param.set(paramString1);
    a(localReqBody, paramCommonCommentData);
    paramInt1 = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localReqBody.anchor_id.set(paramString3);
      paramInt1 = 1;
    }
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0xc46", 3142, 3, localReqBody.toByteArray());
    paramString1.addAttribute("service_type", Integer.valueOf(3));
    if (paramInt1 != 0) {
      paramString1.addAttribute("anchor_request", Integer.valueOf(1));
    }
    a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentPBModule
 * JD-Core Version:    0.7.0.1
 */