package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.UserBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianHBManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFHandlerUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeParam;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendFeedsTitle;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import lsb;
import lsc;
import lse;
import lsh;
import lsi;
import lsj;
import lsk;
import lsl;
import lsm;
import lsn;
import lso;
import lsp;
import lsq;
import lsr;
import lss;
import lst;
import lsu;
import lsv;
import lsw;
import lsx;
import lsy;
import lta;
import ltb;
import ltc;
import ltd;
import lte;
import ltf;
import ltg;
import lth;
import lti;
import ltj;
import ltk;
import ltl;
import ltm;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.DislikeParam;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.ReqBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.RspBody;
import tencent.im.oidb.cmd0x46f.oidb_cmd0x46f.UserDisLike;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ExposeTopic;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.LBSInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RefreshHistory;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqGetFollowTabPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabData;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspRedBonusInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspTrace;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ArticleInfo;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqBody;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqPara;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspArticle;
import tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.BiuMultiLevel;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.BiuOneLevelItem;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.FeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.PGCFeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.PGCPicInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.PGCVideoInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.ReqBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfoUser;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.TagInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.TopicRecommendFeedsTitle;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.TopicRecommendInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.UGCFeedsInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.UGCPicInfo;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.UGCVideoInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.RspBody;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.ReqSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspBody;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspRecommendTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.RspSearchTagInfo;
import tencent.im.oidb.cmd0xb83.oidb_cmd0xb83.SearchInfo;

public class ArticleInfoModule
  extends ReadInJoyEngineModule
{
  private static long jdField_a_of_type_Long = 1800000L;
  private static volatile boolean jdField_a_of_type_Boolean;
  public int a;
  PackMsgProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelPackMsgProcessor = new PackMsgProcessor(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  public List a;
  private Map jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private long jdField_b_of_type_Long;
  private LinkedHashMap jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  
  public ArticleInfoModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  public static int a()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private ToServiceMsg a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    Object localObject1;
    if (paramRequest0x68bParams == null) {
      localObject1 = null;
    }
    Object localObject2;
    label250:
    label894:
    do
    {
      return localObject1;
      if (paramRequest0x68bParams.jdField_b_of_type_Int == -1) {
        return null;
      }
      localObject1 = new oidb_cmd0x68b.ReqBody();
      long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
      ((oidb_cmd0x68b.ReqBody)localObject1).uint64_uin.set(l);
      ((oidb_cmd0x68b.ReqBody)localObject1).uint32_network_type.set(a());
      localObject2 = new oidb_cmd0x68b.ReqChannelPara();
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint64_channel_id.set(paramRequest0x68bParams.jdField_b_of_type_Int);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_channel_list.set(1);
      if (paramRequest0x68bParams.jdField_a_of_type_Long != -1L) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint64_begin_recommend_seq.set(paramRequest0x68bParams.jdField_a_of_type_Long);
      }
      if (paramRequest0x68bParams.jdField_b_of_type_Long != -1L) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint64_end_recommend_seq.set(paramRequest0x68bParams.jdField_b_of_type_Long);
      }
      if (paramRequest0x68bParams.jdField_a_of_type_Boolean) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_article_list.set(1);
      }
      if (paramRequest0x68bParams.jdField_b_of_type_Boolean) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_deleted_article_list.set(1);
      }
      if (paramRequest0x68bParams.jdField_a_of_type_JavaUtilList != null) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_curr_article_list.set(paramRequest0x68bParams.jdField_a_of_type_JavaUtilList);
      }
      if (paramRequest0x68bParams.jdField_b_of_type_JavaUtilList != null) {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_subscription_article_list.set(paramRequest0x68bParams.jdField_b_of_type_JavaUtilList);
      }
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_recommend_flag.set(paramRequest0x68bParams.jdField_i_of_type_Int);
      ArrayList localArrayList;
      Object localObject4;
      oidb_cmd0x68b.InnerMsg localInnerMsg;
      if (paramRequest0x68bParams.jdField_d_of_type_Boolean)
      {
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_video_list.set(1);
        if (!paramRequest0x68bParams.jdField_e_of_type_Boolean) {
          break label818;
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_picture_list.set(1);
        if (!paramRequest0x68bParams.jdField_f_of_type_Boolean) {
          break label830;
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_need_force_set_top.set(1);
        if (paramRequest0x68bParams.jdField_a_of_type_ArrayOfByte != null) {
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramRequest0x68bParams.jdField_a_of_type_ArrayOfByte));
        }
        if (paramRequest0x68bParams.jdField_b_of_type_ArrayOfByte != null) {
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).bytes_device_id.set(ByteStringMicro.copyFrom(paramRequest0x68bParams.jdField_b_of_type_ArrayOfByte));
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_update_times.set(paramRequest0x68bParams.jdField_c_of_type_Int);
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_media_specs.set(1);
        if (!ReadInJoyHelper.a(paramRequest0x68bParams.jdField_d_of_type_Int)) {
          ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_is_support_video_with_small_picture.set(1);
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_is_support_packinfo.set(1);
        localArrayList = new ArrayList();
        if ((paramRequest0x68bParams.jdField_i_of_type_Boolean) && (paramRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo != null))
        {
          localObject3 = new oidb_cmd0x68b.InnerMsg();
          ((oidb_cmd0x68b.InnerMsg)localObject3).uint32_jump_src_type.set(4);
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.articleID)));
          ((oidb_cmd0x68b.InnerMsg)localObject3).template_id.set(paramRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.templateID);
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.extraInfo));
          localArrayList.add(localObject3);
        }
        if (TextUtils.isEmpty(paramRequest0x68bParams.jdField_a_of_type_JavaLangString)) {
          break label894;
        }
        localObject3 = new oidb_cmd0x68b.InnerMsg();
        if (paramRequest0x68bParams.jdField_h_of_type_Int != 5) {
          break label842;
        }
        ((oidb_cmd0x68b.InnerMsg)localObject3).uint32_jump_src_type.set(5);
        ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_a_of_type_JavaLangString));
        if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_c_of_type_JavaLangString))
        {
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_c_of_type_JavaLangString));
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfoModule", 2, "add push contenxt:" + paramRequest0x68bParams.jdField_c_of_type_JavaLangString);
          }
        }
        localArrayList.add(localObject3);
        if ((paramRequest0x68bParams.jdField_b_of_type_JavaUtilList == null) || (paramRequest0x68bParams.jdField_b_of_type_JavaUtilList.size() <= 0)) {
          break label1066;
        }
        localObject3 = paramRequest0x68bParams.jdField_b_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label1066;
        }
        localObject4 = (Long)((Iterator)localObject3).next();
        localInnerMsg = new oidb_cmd0x68b.InnerMsg();
        if (paramRequest0x68bParams.jdField_h_of_type_Int <= 0) {
          break label1054;
        }
        localInnerMsg.uint32_jump_src_type.set(paramRequest0x68bParams.jdField_h_of_type_Int);
      }
      for (;;)
      {
        localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localObject4)));
        if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_c_of_type_JavaLangString))
        {
          localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_c_of_type_JavaLangString));
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfoModule", 2, "add push contenxt:" + paramRequest0x68bParams.jdField_c_of_type_JavaLangString);
          }
        }
        localInnerMsg.uint64_algorithm_id.set(paramRequest0x68bParams.jdField_d_of_type_Long);
        localInnerMsg.uint32_strategy_id.set((int)paramRequest0x68bParams.jdField_e_of_type_Long);
        localArrayList.add(localInnerMsg);
        break label641;
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_video_list.set(0);
        break;
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_picture_list.set(0);
        break label250;
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_need_force_set_top.set(0);
        break label266;
        ((oidb_cmd0x68b.InnerMsg)localObject3).uint32_jump_src_type.set(3);
        ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_a_of_type_JavaLangString));
        if (TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
          break label601;
        }
        ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
        break label601;
        if (paramRequest0x68bParams.jdField_c_of_type_Long == -1L) {
          break label611;
        }
        localObject3 = new ArrayList();
        localObject4 = new oidb_cmd0x68b.SubscribeMsg();
        ((oidb_cmd0x68b.SubscribeMsg)localObject4).uint64_source_article_id.set(paramRequest0x68bParams.jdField_c_of_type_Long);
        if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.SubscribeMsg)localObject4).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
        }
        ((List)localObject3).add(localObject4);
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_subscribe_msg_list.set((List)localObject3);
        localObject3 = new oidb_cmd0x68b.InnerMsg();
        ((oidb_cmd0x68b.InnerMsg)localObject3).uint32_jump_src_type.set(2);
        ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramRequest0x68bParams.jdField_c_of_type_Long)));
        if (!TextUtils.isEmpty(paramRequest0x68bParams.jdField_b_of_type_JavaLangString)) {
          ((oidb_cmd0x68b.InnerMsg)localObject3).bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.jdField_b_of_type_JavaLangString));
        }
        localArrayList.add(localObject3);
        break label611;
        localInnerMsg.uint32_jump_src_type.set(1);
      }
      Object localObject3 = SosoInterface.a();
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long > jdField_a_of_type_Long)
      {
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        ThreadManager.post(new lsp(this), 2, null, true);
      }
      if ((localObject3 != null) && (((SosoInterface.SosoLbsInfo)localObject3).a != null))
      {
        localObject4 = new oidb_cmd0x68b.LBSInfo();
        ((oidb_cmd0x68b.LBSInfo)localObject4).int32_latitude.set((int)(((SosoInterface.SosoLbsInfo)localObject3).a.a * 1000000.0D));
        ((oidb_cmd0x68b.LBSInfo)localObject4).int32_longitude.set((int)(((SosoInterface.SosoLbsInfo)localObject3).a.b * 1000000.0D));
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "0x68b lbs info , lat =" + (int)(((SosoInterface.SosoLbsInfo)localObject3).a.a * 1000000.0D) + "   lon=" + (int)(((SosoInterface.SosoLbsInfo)localObject3).a.b * 1000000.0D));
        }
        ((oidb_cmd0x68b.ReqChannelPara)localObject2).bytes_lbs_data.set(ByteStringMicro.copyFrom(((oidb_cmd0x68b.LBSInfo)localObject4).toByteArray()));
      }
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).rpt_inner_msg_list.set(localArrayList);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_is_disp_timestamp.set(1);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_is_support_gallery.set(1);
      ((oidb_cmd0x68b.ReqChannelPara)localObject2).uint32_req_picture_number.set(1);
      ((oidb_cmd0x68b.ReqBody)localObject1).reqChannelPara.set((MessageMicro)localObject2);
      ((oidb_cmd0x68b.ReqBody)localObject1).reqChannelPara.setHasFlag(true);
      ((oidb_cmd0x68b.ReqBody)localObject1).uint32_req_dislike_type.set(paramRequest0x68bParams.jdField_e_of_type_Int);
      ((oidb_cmd0x68b.ReqBody)localObject1).uint64_client_swithes.set(paramRequest0x68bParams.jdField_f_of_type_Int);
      ((oidb_cmd0x68b.ReqBody)localObject1).enum_refresh_type.set(paramRequest0x68bParams.g);
      if ((paramRequest0x68bParams.jdField_b_of_type_Int == 0) && (ReadInJoyUtils.a()))
      {
        localObject2 = new oidb_cmd0x68b.RefreshHistory();
        ((oidb_cmd0x68b.RefreshHistory)localObject2).bytes_session_id.set(ByteStringMicro.copyFromUtf8(ReadInJoyUtils.i()));
        ((oidb_cmd0x68b.RefreshHistory)localObject2).rpt_refresh_history.set(ReadInJoyUtils.a());
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "session_id = " + ReadInJoyUtils.i() + ", history = " + ReadInJoyUtils.a().toString());
        }
        ((oidb_cmd0x68b.ReqBody)localObject1).msg_refresh_history.set((MessageMicro)localObject2);
      }
      if (paramRequest0x68bParams.jdField_h_of_type_Boolean)
      {
        localObject2 = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162);
        if (localObject2 != null)
        {
          localObject2 = ((ReadInJoyLogicManager)localObject2).a().a(paramRequest0x68bParams.jdField_b_of_type_Int);
          if (localObject2 != null)
          {
            ((oidb_cmd0x68b.ReqBody)localObject1).req_advertise_para.set((MessageMicro)localObject2);
            PublicAccountReportUtils.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
          }
        }
      }
      localObject2 = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, paramRequest0x68bParams.j, ((oidb_cmd0x68b.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).getAttributes().put(jdField_c_of_type_JavaLangString, Integer.valueOf(paramRequest0x68bParams.jdField_a_of_type_Int));
      ((ToServiceMsg)localObject2).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramRequest0x68bParams.jdField_a_of_type_Long));
      ((ToServiceMsg)localObject2).getAttributes().put(jdField_e_of_type_JavaLangString, Long.valueOf(paramRequest0x68bParams.jdField_b_of_type_Long));
      ((ToServiceMsg)localObject2).getAttributes().put(g, Integer.valueOf(1));
      ((ToServiceMsg)localObject2).getAttributes().put(jdField_b_of_type_JavaLangString, Integer.valueOf(paramRequest0x68bParams.g));
      localObject1 = localObject2;
    } while (paramRequest0x68bParams.jdField_b_of_type_JavaUtilList == null);
    label266:
    label601:
    label611:
    ((ToServiceMsg)localObject2).getAttributes().put(jdField_f_of_type_JavaLangString, paramRequest0x68bParams.jdField_b_of_type_JavaUtilList);
    label641:
    label818:
    label830:
    label842:
    return localObject2;
  }
  
  private List a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((ArticleInfo)paramList.next()).mRecommendSeq));
    }
    return localArrayList;
  }
  
  private oidb_cmd0x46f.DislikeParam a(DislikeParam paramDislikeParam)
  {
    oidb_cmd0x46f.DislikeParam localDislikeParam = new oidb_cmd0x46f.DislikeParam();
    localDislikeParam.uint64_articleid.set(paramDislikeParam.jdField_a_of_type_Long);
    localDislikeParam.uint32_reasonid.set(paramDislikeParam.jdField_a_of_type_Int);
    localDislikeParam.uint64_feeds_id.set(paramDislikeParam.jdField_b_of_type_Long);
    localDislikeParam.uint64_biu_uin.set(paramDislikeParam.jdField_c_of_type_Long);
    localDislikeParam.uint64_topic_id.set(paramDislikeParam.jdField_d_of_type_Long);
    if ((paramDislikeParam.jdField_a_of_type_JavaLangString != null) && (paramDislikeParam.jdField_a_of_type_JavaLangString.length() > 0)) {
      localDislikeParam.bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramDislikeParam.jdField_a_of_type_JavaLangString));
    }
    Object localObject1;
    Object localObject2;
    if ((paramDislikeParam.jdField_a_of_type_JavaUtilList != null) && (paramDislikeParam.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      localObject1 = paramDislikeParam.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        localDislikeParam.rpt_uint64_tagid.add(localObject2);
      }
    }
    if ((paramDislikeParam.jdField_a_of_type_JavaUtilArrayList != null) && (paramDislikeParam.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramDislikeParam = paramDislikeParam.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDislikeParam.hasNext())
      {
        localObject1 = (DislikeInfo)paramDislikeParam.next();
        localObject2 = new oidb_cmd0x46f.UserDisLike();
        ((oidb_cmd0x46f.UserDisLike)localObject2).bytes_dislike_account_id.set(ByteStringMicro.copyFromUtf8(((DislikeInfo)localObject1).jdField_b_of_type_JavaLangString));
        ((oidb_cmd0x46f.UserDisLike)localObject2).type.set(((DislikeInfo)localObject1).jdField_a_of_type_Int);
        ((oidb_cmd0x46f.UserDisLike)localObject2).uint64_dislike_tagid.set(((DislikeInfo)localObject1).jdField_a_of_type_Long);
        localDislikeParam.rpt_user_dislike_list.add((MessageMicro)localObject2);
      }
    }
    return localDislikeParam;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ltk(this, paramInt));
  }
  
  private void a(long paramLong, int paramInt, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    Iterator localIterator = ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt))).values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (ArticleInfo)localIterator.next();
      if ((localObject1 != null) && (((ArticleInfo)localObject1).mFeedId == paramLong) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null))
      {
        localObject1 = ((ArticleInfo)localObject1).mTopicRecommendFeedsInfo;
        if ((paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.has()) && (localObject1 != null) && (((TopicRecommendFeedsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null))
        {
          Object localObject2 = (oidb_cmd0x8c8.TopicRecommendFeedsInfo)paramSocializeFeedsInfo.msg_topic_recommend_feeds_info.get();
          if (((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject2).msg_topic_recommend_info.has())
          {
            localObject2 = ((oidb_cmd0x8c8.TopicRecommendFeedsInfo)localObject2).msg_topic_recommend_info.get();
            paramInt = 0;
            while ((paramInt < ((List)localObject2).size()) && (paramInt < ((TopicRecommendFeedsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.size()))
            {
              oidb_cmd0x8c8.TopicRecommendInfo localTopicRecommendInfo = (oidb_cmd0x8c8.TopicRecommendInfo)((List)localObject2).get(paramInt);
              TopicRecommendFeedsInfo.TopicRecommendInfo localTopicRecommendInfo1 = (TopicRecommendFeedsInfo.TopicRecommendInfo)((TopicRecommendFeedsInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.get(paramInt);
              if (localTopicRecommendInfo.uint32_number_of_participants.has()) {
                localTopicRecommendInfo1.jdField_b_of_type_Int = localTopicRecommendInfo.uint32_number_of_participants.get();
              }
              paramInt += 1;
            }
          }
        }
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, oidb_cmd0x8c8.SocializeFeedsInfo paramSocializeFeedsInfo, int paramInt)
  {
    if (((paramArticleInfo.mFeedType == 11) || (paramArticleInfo.mFeedType == 14)) && (paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      a(paramArticleInfo.mFeedId, paramInt, paramSocializeFeedsInfo);
    }
    int i;
    do
    {
      a(paramArticleInfo);
      do
      {
        return;
      } while (paramArticleInfo.mSocialFeedInfo == null);
      i = paramArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int;
      paramArticleInfo.mSocialFeedInfo.a(paramSocializeFeedsInfo);
      a(paramArticleInfo);
      paramSocializeFeedsInfo = a(paramArticleInfo, paramInt);
    } while ((i == 2) || (paramArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int != 2));
    paramSocializeFeedsInfo.isNeedShowBtnWhenFollowed = true;
  }
  
  private void a(Integer paramInteger, ArticleInfo paramArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if ((paramInteger != null) && (paramInteger.contains(paramArticleInfo))) {
      paramInteger.remove(paramArticleInfo);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lti(this, paramBoolean, paramInt, paramList));
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List paramList, long paramLong1, long paramLong2)
  {
    if (!paramBoolean1)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, null, true);
      return;
    }
    a(Integer.valueOf(paramInt), paramList, true);
    if (paramList.isEmpty())
    {
      paramBoolean1 = true;
      if (paramInt != 70) {
        break label155;
      }
      if ((!paramBoolean1) && (!paramBoolean2)) {
        break label150;
      }
      paramBoolean1 = true;
    }
    label150:
    label155:
    for (;;)
    {
      List localList = a(Integer.valueOf(paramInt));
      if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramBoolean1)) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161)).a(localList.size());
      }
      if (paramInt == 0) {
        ReadinjoyReportUtils.a(paramList, localList, false);
      }
      ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, localList, paramBoolean1);
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List paramList1, long paramLong1, long paramLong2, List paramList2, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramBoolean1)
    {
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramFromServiceMsg = new CopyOnWriteArrayList(paramList1);
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramFromServiceMsg);
      }
      if (paramInt == 70) {
        break label482;
      }
      if (paramBoolean2)
      {
        a(Integer.valueOf(paramInt), paramList1, true);
        a(paramInt, paramList2);
      }
    }
    else
    {
      paramList2 = a(Integer.valueOf(paramInt));
      if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((paramBoolean2) || ((paramList1 == null) && (paramBoolean1))) && (paramList2 != null)) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161)).a(paramList2.size());
      }
      if (paramInt == 0)
      {
        paramToServiceMsg = paramToServiceMsg.getAttribute("isRedRefreshReq");
        if ((paramToServiceMsg == null) || (!(paramToServiceMsg instanceof Boolean))) {
          break label555;
        }
      }
    }
    label555:
    for (boolean bool = ((Boolean)paramToServiceMsg).booleanValue();; bool = false)
    {
      ReadinjoyReportUtils.a(paramList1, paramList2, bool);
      ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean1, paramInt, paramList2, paramBoolean2);
      if ((paramInt == 0) && (paramList2 != null) && (!paramList2.isEmpty()))
      {
        paramLong1 = NetConnInfoCenter.getServerTime();
        paramToServiceMsg = a(Integer.valueOf(paramInt), (Long)paramList2.get(0));
        if ((paramToServiceMsg != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
        {
          paramList1 = PublicAccountUtil.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg);
          paramToServiceMsg = PublicAccountUtil.a(paramToServiceMsg);
          PublicAccountUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg, String.valueOf(paramLong1), paramList1, paramBoolean1);
        }
      }
      if ((paramInt == 40677) && (paramList2 != null) && (!paramList2.isEmpty()))
      {
        paramLong1 = NetConnInfoCenter.getServerTime();
        paramList1 = a(Integer.valueOf(paramInt), (Long)paramList2.get(0));
        if ((paramList1 != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
        {
          paramList2 = (WeishiManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(274);
          if (paramList2 != null) {
            paramList2.a(PublicAccountUtil.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList1), paramLong1);
          }
        }
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "handleRefreshChannel clearChannelArticleInfo channelId=" + paramInt);
      }
      if ((paramList1 == null) || (paramList1.size() <= 0)) {
        break;
      }
      a(paramInt);
      a(Integer.valueOf(paramInt), paramList1, true);
      break;
      label482:
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        a(paramInt);
        a(Integer.valueOf(paramInt), paramList1, true);
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "articleInfoList is wrong");
      }
      a(Integer.valueOf(paramInt), paramList1, true);
      a(paramInt, paramList2);
      break;
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List paramList1, long paramLong1, long paramLong2, List paramList2, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lth(this, paramLong1, paramInt, paramArrayOfByte, paramBoolean1, paramList1, paramBoolean2, paramLong2, paramList2, paramToServiceMsg, paramFromServiceMsg));
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Integer paramInteger, ArticleInfo paramArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    if (paramArticleInfo == null) {
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (localConcurrentHashMap1 == null)
    {
      localConcurrentHashMap1 = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramInteger, localConcurrentHashMap1);
    }
    for (;;)
    {
      if (localConcurrentHashMap1.get(Long.valueOf(paramArticleInfo.mRecommendSeq)) != null)
      {
        a(paramInteger, paramArticleInfo);
        if (paramArticleInfo.mAbandonRepeatFlag != 0) {
          break label493;
        }
      }
      label490:
      label493:
      for (bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "saveArticleInfo, article duplicated, article been channelID=" + paramInteger + ", articleID=" + paramArticleInfo.mArticleID + "，seq=" + paramArticleInfo.mRecommendSeq + ", toDb=" + paramBoolean1 + "，isDupArticle =" + bool);
        }
        ConcurrentHashMap localConcurrentHashMap2;
        if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 0) && (paramInteger.intValue() != 9999) && (!TextUtils.isEmpty(paramArticleInfo.mVideoVid)))
        {
          localConcurrentHashMap2 = (ConcurrentHashMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(paramInteger);
          if (localConcurrentHashMap2 != null) {
            break label490;
          }
          localConcurrentHashMap2 = new ConcurrentHashMap();
          this.jdField_b_of_type_JavaUtilLinkedHashMap.put(paramInteger, localConcurrentHashMap2);
        }
        for (;;)
        {
          if (localConcurrentHashMap2.get(paramArticleInfo.mVideoVid) != null)
          {
            ArticleInfo localArticleInfo = (ArticleInfo)localConcurrentHashMap2.get(paramArticleInfo.mVideoVid);
            if (localArticleInfo.mArticleID != paramArticleInfo.mArticleID)
            {
              b(paramInteger.intValue(), localArticleInfo.mRecommendSeq);
              if (QLog.isColorLevel()) {
                QLog.e("ArticleInfoModule", 2, "saveArticleInfo, find article vid duplicated! old article: channelID=" + paramInteger + ", id=" + localArticleInfo.mArticleID + "，seq: " + localArticleInfo.mRecommendSeq + ", title: " + ReadInJoyUtils.d(localArticleInfo.mTitle) + "，vid =" + localArticleInfo.mVideoVid + "\n new article  id : " + paramArticleInfo.mArticleID + " seq : " + paramArticleInfo.mRecommendSeq + " title : " + ReadInJoyUtils.d(paramArticleInfo.mTitle) + "，vid =" + paramArticleInfo.mVideoVid);
              }
            }
          }
          localConcurrentHashMap2.put(paramArticleInfo.mVideoVid, paramArticleInfo);
          if ((!bool) || (paramBoolean2))
          {
            localConcurrentHashMap1.put(Long.valueOf(paramArticleInfo.mRecommendSeq), paramArticleInfo);
            if (paramBoolean1) {
              this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsh(this, paramArticleInfo));
            }
          }
          return true;
        }
      }
    }
  }
  
  public static byte[] a()
  {
    String str2 = DeviceInfoUtil.a();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1.getBytes();
  }
  
  private List b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject = a(paramInt1, paramInt2, paramLong, paramBoolean);
    if (((List)localObject).isEmpty()) {
      return null;
    }
    a(Integer.valueOf(paramInt1), (List)localObject, false);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID))) {
        QLog.d("ArticleInfoModule", 2, "loadChannelArticleSeqList articleID duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else if (!localHashSet2.add(Long.valueOf(localArticleInfo.mRecommendSeq))) {
        QLog.d("ArticleInfoModule", 2, "loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelPackMsgProcessor.a(Integer.valueOf(paramInt1), localArrayList);
    return localArrayList;
  }
  
  private void b(int paramInt, List paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ltj(this, paramInt, paramList));
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    Integer localInteger = (Integer)paramToServiceMsg.getAttributes().get("channelID");
    boolean bool3 = false;
    boolean bool2 = false;
    oidb_cmd0x68b.RspChannelArticle localRspChannelArticle = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int m = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramObject = ReadInJoyUtils.a();
    long l1;
    label249:
    int i;
    label275:
    label299:
    label330:
    int k;
    label420:
    label582:
    int j;
    if (m == 0)
    {
      bool1 = true;
      ReadInJoyUtils.a(paramObject, bool1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), m, localInteger.intValue());
      jdField_a_of_type_Boolean = false;
      if (m != 0) {
        break label1665;
      }
      if (!localRspBody.uint64_client_swithes.has()) {
        break label1645;
      }
      l1 = localRspBody.uint64_client_swithes.get();
      if (((l1 >> 9 & 1L) != 1L) || (!localRspBody.msg_rsp_get_follow_tab_data.has())) {
        break label1632;
      }
      localObject2 = (oidb_cmd0x68b.RspGetFollowTabData)localRspBody.msg_rsp_get_follow_tab_data.get();
      if ((!((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_set_top_cookie.has()) || (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_set_top_cookie.get() == null)) {
        break label1627;
      }
      paramObject = ((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_set_top_cookie.get().toByteArray();
      if (localInteger.intValue() != 70) {
        break label952;
      }
      if ((paramObject == null) || (paramObject.length <= 0)) {
        break label936;
      }
      if (!QLog.isColorLevel()) {
        break label952;
      }
      QLog.d("ArticleInfoModule", 2, "follow request back cookie is " + new String(paramObject));
      if (!((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_is_no_more_data.has()) {
        break label1621;
      }
      if (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_is_no_more_data.get() != 1) {
        break label955;
      }
      bool1 = true;
      if (!((oidb_cmd0x68b.RspGetFollowTabData)localObject2).rpt_article_list.has()) {
        break label1615;
      }
      localObject1 = ReadInJoyMSFHandlerUtils.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).rpt_article_list.get());
      if (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_has_followed_topic.has())
      {
        localObject3 = ReadInJoyLogicEngine.a();
        if (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_has_followed_topic.get() != 1) {
          break label961;
        }
        bool2 = true;
        ((ReadInJoyLogicEngine)localObject3).c(bool2);
      }
      if (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_topic_reddot_update_num.has()) {
        ReadInJoyLogicEngine.a().f(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_topic_reddot_update_num.get());
      }
      if ((((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_refresh_topic_update_info.has()) && (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_refresh_topic_update_info.get() == 1))
      {
        if (!((oidb_cmd0x68b.RspGetFollowTabData)localObject2).topic_update_info.has()) {
          break label967;
        }
        localObject3 = TopicRecommendFeedsInfo.a((oidb_cmd0x68b.TopicRecommendFeedsInfo)((oidb_cmd0x68b.RspGetFollowTabData)localObject2).topic_update_info.get());
        ReadInJoyLogicEngine.a().a((TopicRecommendFeedsInfo)localObject3);
        ReadInJoyLogicEngine.a().o();
      }
      if (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_hint_index.has())
      {
        i = ((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_hint_index.get() - 1;
        if ((localObject1 != null) && (i > 0) && (i < ((List)localObject1).size())) {
          ((ArticleInfo)((List)localObject1).get(i)).hintFlag = true;
        }
        QLog.d("ArticleInfoModule", 2, "getFollowTabData : hint " + i);
      }
      if (((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_refresh_cookie.has())
      {
        localObject2 = Base64Util.encodeToString(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_refresh_cookie.get().toByteArray(), 0);
        ReadInJoyLogicEngine.a().e((String)localObject2);
        QLog.d("ArticleInfoModule", 2, "getFollowTabData : lastRefreshCookie " + (String)localObject2);
      }
      i = 1;
      if ((l1 >> 13 & 1L) != 1L) {
        break label1601;
      }
      k = 1;
      j = i;
      i = k;
      label605:
      if (localRspBody.uint64_uin.has()) {
        localRspBody.uint64_uin.get();
      }
      if ((!localRspBody.rspChannelArticle.has()) || (localRspBody.rspChannelArticle.get() == null) || (j != 0)) {
        break label1585;
      }
      localRspChannelArticle = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
      if (localRspChannelArticle.uint64_channel_id.has()) {
        localInteger = Integer.valueOf((int)localRspChannelArticle.uint64_channel_id.get());
      }
      if (localRspChannelArticle.uint32_is_no_more_data.has()) {
        if (localRspChannelArticle.uint32_is_no_more_data.get() != 1) {
          break label977;
        }
      }
    }
    label804:
    label936:
    label952:
    label955:
    label961:
    label967:
    label977:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject2 = localObject1;
      if (localRspChannelArticle.rpt_article_list.has())
      {
        localObject2 = localObject1;
        if (localRspChannelArticle.rpt_article_list.get() != null) {
          localObject2 = ReadInJoyMSFHandlerUtils.a(localRspChannelArticle.rpt_article_list.get(), localInteger.intValue());
        }
      }
      if ((!localRspChannelArticle.rpt_deleted_article_list.has()) || (localRspChannelArticle.rpt_deleted_article_list.get() == null)) {
        break label1579;
      }
      localObject1 = ReadInJoyMSFHandlerUtils.a(localRspChannelArticle.rpt_deleted_article_list.get(), localInteger.intValue());
      localObject3 = paramObject;
      if (localRspChannelArticle.bytes_set_top_cookie.has())
      {
        localObject3 = paramObject;
        if (localRspChannelArticle.bytes_set_top_cookie.get() != null) {
          localObject3 = localRspChannelArticle.bytes_set_top_cookie.get().toByteArray();
        }
      }
      if ((localRspChannelArticle.rpt_advertise_list.has()) && (localRspChannelArticle.rpt_advertise_list.get() != null))
      {
        paramObject = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162);
        if (paramObject != null) {
          paramObject.a().a(localRspChannelArticle);
        }
      }
      paramObject = localObject2;
      localObject2 = localObject3;
      if (i == 0) {
        break label983;
      }
      paramToServiceMsg = (List)paramToServiceMsg.getAttribute(jdField_f_of_type_JavaLangString);
      a(true, localInteger.intValue(), paramToServiceMsg, paramObject);
      return;
      bool1 = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "follow request back cookie is null");
      }
      break label249;
      bool1 = false;
      break label275;
      bool2 = false;
      break label330;
      ReadInJoyLogicEngine.a().a(null);
      break label420;
    }
    label901:
    label983:
    if (localRspBody.msg_rsp_trace.has()) {
      ReadInJoyUtils.a(ReadInJoyUtils.a(), localRspBody.msg_rsp_trace.rpt_trace_record_list.get());
    }
    label1169:
    if ((j == 0) && (((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue() == -1L) && (localRspBody.rspRedBonusInfo.has()))
    {
      j = ((Integer)paramToServiceMsg.getAttribute("clientSwithes")).intValue();
      if ((j & 0x4) == 0) {
        break label1499;
      }
      i = 1;
      if ((i == 0) || ((j & 0x8) == 0)) {
        break label1505;
      }
      i = 1;
      label1088:
      if (i != 0)
      {
        localObject3 = (oidb_cmd0x68b.RspRedBonusInfo)localRspBody.rspRedBonusInfo.get();
        if (!((oidb_cmd0x68b.RspRedBonusInfo)localObject3).uint32_accumlated_days.has()) {
          break label1511;
        }
        i = ((oidb_cmd0x68b.RspRedBonusInfo)localObject3).uint32_accumlated_days.get();
        label1127:
        if (!((oidb_cmd0x68b.RspRedBonusInfo)localObject3).uint32_required_days.has()) {
          break label1517;
        }
        j = ((oidb_cmd0x68b.RspRedBonusInfo)localObject3).uint32_required_days.get();
        label1148:
        if (!((oidb_cmd0x68b.RspRedBonusInfo)localObject3).str_turntable_url.has()) {
          break label1523;
        }
        localObject3 = ((oidb_cmd0x68b.RspRedBonusInfo)localObject3).str_turntable_url.get();
        if ((i > 0) && (j > 0)) {
          KandianHBManager.a().a(j, i, (String)localObject3);
        }
      }
    }
    bool3 = true;
    bool2 = bool1;
    bool1 = bool3;
    for (;;)
    {
      switch (((Integer)paramToServiceMsg.getAttribute(jdField_c_of_type_JavaLangString)).intValue())
      {
      default: 
        return;
      case 5: 
        l1 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
        long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_e_of_type_JavaLangString)).longValue();
        j = ((Integer)paramToServiceMsg.getAttribute(g)).intValue();
        k = ((Integer)paramToServiceMsg.getAttribute(jdField_b_of_type_JavaLangString)).intValue();
        if (QLog.isColorLevel()) {
          if (paramObject != null) {
            break label1529;
          }
        }
        label1499:
        label1505:
        label1511:
        label1517:
        label1523:
        label1529:
        for (i = 0;; i = paramObject.size())
        {
          QLog.d("ArticleInfoModule", 2, "handle0x68bGetSubscribeArticalList result=" + m + " channelID=" + localInteger + " beginSeq=" + l1 + " endSeq=" + l2 + " articlecount=" + i + " reqType=" + k);
          if ((m != 154) || (j != 1)) {
            break label1540;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfoModule", 2, "handle0x68bGetSubscribeArticalList re-request" + m + " channelID=" + localInteger + " beginSeq=" + l1 + " endSeq=" + l2);
          }
          paramToServiceMsg.getAttributes().put(g, Integer.valueOf(2));
          a(paramToServiceMsg);
          return;
          i = 0;
          break;
          i = 0;
          break label1088;
          i = -1;
          break label1127;
          j = -1;
          break label1148;
          localObject3 = null;
          break label1169;
        }
        label1540:
        a(bool1, localInteger.intValue(), bool2, paramObject, l1, l2, (List)localObject1, (byte[])localObject2, paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      a(bool1, localInteger.intValue(), (List)localObject1);
      return;
      label1579:
      localObject1 = null;
      break label804;
      label1585:
      localObject3 = null;
      localObject2 = paramObject;
      paramObject = localObject1;
      localObject1 = localObject3;
      break label901;
      label1601:
      k = 0;
      j = i;
      i = k;
      break label605;
      label1615:
      localObject1 = null;
      break label299;
      label1621:
      bool1 = false;
      break label275;
      label1627:
      paramObject = null;
      break;
      label1632:
      i = 0;
      paramObject = localObject3;
      bool1 = bool2;
      break label582;
      label1645:
      i = 0;
      j = 0;
      paramObject = localRspChannelArticle;
      bool1 = bool3;
      localObject1 = localObject2;
      break label605;
      label1665:
      paramObject = null;
      bool2 = false;
      bool1 = false;
      localObject1 = null;
      localObject2 = null;
    }
  }
  
  private static void b(List paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
        if (ProteusSupportUtil.a(ReadInJoyBaseAdapter.c(localArticleInfo))) {
          ProteusSupportUtil.a(localArticleInfo);
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new lso(this, paramInt));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x46f.RspBody();
    int j = 0;
    int i = 0;
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      if (paramToServiceMsg.uint32_fail_count.has()) {
        i = paramToServiceMsg.uint32_fail_count.get();
      }
      j = i;
      if (!paramToServiceMsg.rpt_result_list.has()) {}
    }
    for (paramToServiceMsg = ReadInJoyMSFHandlerUtils.b(paramToServiceMsg.rpt_result_list.get());; paramToServiceMsg = null)
    {
      b(i, paramToServiceMsg);
      return;
      i = j;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x75e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if ((paramToServiceMsg.msg_rsp_article.has()) && (paramToServiceMsg.msg_rsp_article.get() != null))
      {
        paramToServiceMsg = (oidb_cmd0x75e.RspArticle)paramToServiceMsg.msg_rsp_article.get();
        if ((paramToServiceMsg.rpt_article_info.has()) && (paramToServiceMsg.rpt_article_info.get() != null))
        {
          paramToServiceMsg = paramToServiceMsg.rpt_article_info.get();
          if ((paramToServiceMsg.size() > 0) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.has()) && (((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get() != null))
          {
            paramToServiceMsg = ((oidb_cmd0x75e.ArticleInfo)paramToServiceMsg.get(0)).bytes_article_xml.get().toStringUtf8();
            ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161)).a(paramToServiceMsg);
          }
        }
      }
    }
    for (;;)
    {
      ReadInJoyHelper.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ArticleInfoModule", 2, "handle0x75eIndividualArticleList error = " + i);
      }
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x83e.RspBody localRspBody = new oidb_cmd0x83e.RspBody();
    if (ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      QLog.d("ArticleInfoModule", 1, "handle0x83eUpvoteAction result OK");
      if (QLog.isColorLevel())
      {
        if (localRspBody.uint64_feeds_id.has()) {
          QLog.d("ArticleInfoModule", 2, "upvote feeds id:" + localRspBody.uint64_feeds_id.get());
        }
        if (localRspBody.uint32_operation.has())
        {
          paramFromServiceMsg = new StringBuilder().append("upvote status:");
          if (localRspBody.uint32_operation.get() != 2) {
            break label166;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        QLog.d("ArticleInfoModule", 2, bool);
        try
        {
          paramToServiceMsg = (ArticleInfo)paramToServiceMsg.getAttribute("0x83e_article");
          this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsq(this, paramToServiceMsg));
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          label166:
          QLog.d("ArticleInfoModule", 1, "failed to update article ", paramToServiceMsg);
          return;
        }
      }
    }
    int i = ((Integer)paramToServiceMsg.getAttribute("0x83e_retry_times")).intValue();
    if (i < 0)
    {
      paramToServiceMsg.addAttribute("0x83e_retry_times", Integer.valueOf(i + 1));
      a(paramToServiceMsg);
      return;
    }
    QLog.d("ArticleInfoModule", 1, "retry times:" + i + " exceeds");
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x83e.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eBiuAtlasDeliverAction result:" + i);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lsr(this, i));
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    long l = paramToServiceMsg.uint64_feeds_id.get();
    paramFromServiceMsg = paramToServiceMsg.bytes_rowkey.get().toStringUtf8();
    int j = paramToServiceMsg.uint32_ugc_status.get();
    paramToServiceMsg = paramToServiceMsg.bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eDeliverUGCAction result=" + i + ", feedsId=" + l + ", rowkey=" + paramFromServiceMsg + ", status=" + j + ", comment=" + paramToServiceMsg);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lss(this, i, l, paramFromServiceMsg, j, paramToServiceMsg));
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x83e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    long l = paramToServiceMsg.uint64_feeds_id.get();
    paramFromServiceMsg = paramToServiceMsg.bytes_rowkey.get().toStringUtf8();
    int j = paramToServiceMsg.uint32_ugc_status.get();
    paramToServiceMsg = paramToServiceMsg.bytes_default_comments.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eDeliverUpMasterAction result=" + i + ", feedsId=" + l + ", rowkey=" + paramFromServiceMsg + ", status=" + j + ", comment=" + paramToServiceMsg);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lst(this, i, l, paramFromServiceMsg, j, paramToServiceMsg));
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x83e.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "handle0x83eBiuDeliverAction result:" + i);
    }
    if (i == 0)
    {
      long l = ((Long)paramToServiceMsg.getAttribute("BaseArticleSeq")).longValue();
      paramToServiceMsg = a(Integer.valueOf(0), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.jdField_f_of_type_Int += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        a(paramToServiceMsg);
      }
      paramToServiceMsg = a(Integer.valueOf(70), Long.valueOf(l));
      if ((paramToServiceMsg != null) && (paramToServiceMsg.mSocialFeedInfo != null))
      {
        paramFromServiceMsg = paramToServiceMsg.mSocialFeedInfo;
        paramFromServiceMsg.jdField_f_of_type_Int += 1;
        paramToServiceMsg.invalidateProteusTemplateBean();
        a(paramToServiceMsg);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new lsu(this, i));
      return;
      if (i != 33) {}
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x8c8.RspBody localRspBody = new oidb_cmd0x8c8.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (ConcurrentHashMap)paramToServiceMsg.getAttribute("0x8c8_articleMap");
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("isUpdateByAccount")).booleanValue();
    if (i == 0)
    {
      QLog.d("ArticleInfoModule", 1, "handle0x8c8UpvoteAction result OK");
      if ((localRspBody.rpt_social_feeds_info.has()) && (localRspBody.rpt_social_feeds_info.get() != null))
      {
        paramToServiceMsg = localRspBody.rpt_social_feeds_info.get();
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsx(this, paramToServiceMsg, paramFromServiceMsg, bool));
      }
      if ((localRspBody.rpt_del_feeds_info_list.has()) && (localRspBody.rpt_del_feeds_info_list.get() != null))
      {
        paramToServiceMsg = localRspBody.rpt_del_feeds_info_list.get();
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsy(this, paramToServiceMsg, paramFromServiceMsg));
      }
      return;
    }
    i = ((Integer)paramToServiceMsg.getAttribute("0x8c8_retry_times")).intValue();
    if (i < 0)
    {
      paramToServiceMsg.addAttribute("0x8c8_retry_times", Integer.valueOf(i + 1));
      a(paramToServiceMsg);
      return;
    }
    QLog.d("ArticleInfoModule", 1, "retry times:" + i + " exceeds");
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xb83.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    if (i == 0)
    {
      QLog.d("ArticleInfoModule", 1, "handle0xb83GetKeywordList result OK");
      paramObject = ReadInJoyMSFHandlerUtils.c(paramToServiceMsg.msg_rsp_search_tag_info.rpt_msg_tag_info_list.get());
      paramToServiceMsg = ReadInJoyMSFHandlerUtils.c(paramToServiceMsg.msg_rsp_recommend_tag_info.rpt_msg_tag_info_list.get());
      paramFromServiceMsg.addAll(paramObject);
      paramFromServiceMsg.addAll(paramToServiceMsg);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new ltg(this, paramFromServiceMsg));
      return;
      QLog.d("ArticleInfoModule", 2, "handle0xb83GetKeywordList: failed, result: " + i);
    }
  }
  
  public int a(Integer paramInteger)
  {
    paramInteger = (List)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.size();
  }
  
  public long a(Integer paramInteger)
  {
    long l1 = -1L;
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = l1;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() > l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public ArticleInfo a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if (paramInt == 0)
    {
      localObject3 = ((ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(0))).values().iterator();
      localObject1 = null;
      do
      {
        do
        {
          do
          {
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)((Iterator)localObject3).next();
            localObject1 = localObject2;
          } while (localObject2 == null);
          localObject1 = localObject2;
        } while (((ArticleInfo)localObject2).mFeedId != paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long);
        localObject1 = localObject2;
      } while (((ArticleInfo)localObject2).mFeedType != paramArticleInfo.mFeedType);
    }
    for (;;)
    {
      if ((localObject2 != null) && (((ArticleInfo)localObject2).mFeedId == paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long) && (((ArticleInfo)localObject2).mFeedType == paramArticleInfo.mFeedType))
      {
        ((ArticleInfo)localObject2).mSocialFeedInfoByte = paramArticleInfo.mSocialFeedInfoByte;
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 2, "mArticleID = " + ((ArticleInfo)localObject2).mArticleID + ", old data = " + ((ArticleInfo)localObject2).mSocialFeedInfo + ", new data = " + paramArticleInfo.mSocialFeedInfo);
        }
        ((ArticleInfo)localObject2).mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo;
        localObject1 = localObject2;
        localObject2 = localObject1;
        if (paramInt == 70)
        {
          localObject3 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(70));
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject3 = ((ConcurrentHashMap)localObject3).values().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject2 = (ArticleInfo)((Iterator)localObject3).next();
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((ArticleInfo)localObject2).mFeedId == paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long)
                {
                  localObject1 = localObject2;
                  if (((ArticleInfo)localObject2).mFeedType == paramArticleInfo.mFeedType) {
                    localObject1 = localObject2;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if ((localObject1 != null) && (localObject1.mFeedId == paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long) && (localObject1.mFeedType == paramArticleInfo.mFeedType))
        {
          localObject1.mSocialFeedInfoByte = paramArticleInfo.mSocialFeedInfoByte;
          if (QLog.isColorLevel()) {
            QLog.d("ArticleInfoModule", 2, "mArticleID = " + localObject1.mArticleID + ", old data = " + localObject1.mSocialFeedInfo + ", new data = " + paramArticleInfo.mSocialFeedInfo);
          }
          localObject1.mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo;
          localObject2 = localObject1;
        }
        do
        {
          return localObject2;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ArticleInfoModule", 2, "cannot update no-cached article id:" + paramArticleInfo.mArticleID + " title:" + paramArticleInfo.mTitle);
          localObject1 = localObject2;
          break;
          localObject2 = localObject1;
        } while (!QLog.isColorLevel());
        QLog.d("ArticleInfoModule", 2, "cannot update no-cached article id:" + paramArticleInfo.mArticleID + " title:" + paramArticleInfo.mTitle);
        return localObject1;
      }
      localObject2 = localObject1;
    }
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramInteger.intValue() == 70)
      {
        int i = 0;
        while (i < localList.size())
        {
          paramInteger = (ArticleInfo)localList.get(i);
          if (paramInteger.hintFlag) {
            return paramInteger;
          }
          i += 1;
        }
      }
      return (ArticleInfo)localList.get(localList.size() - 1);
    }
    return null;
  }
  
  public ArticleInfo a(Integer paramInteger, Long paramLong)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return (ArticleInfo)paramInteger.get(paramLong);
  }
  
  List a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "mChannelID = ? and mRecommendSeq < ?";; localObject = "mChannelID = ? and mRecommendSeq > ?")
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "loadChannelArticleSeqList with selection=" + (String)localObject + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      }
      ArrayList localArrayList = new ArrayList();
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.a(ArticleInfo.class, true, (String)localObject, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "mRecommendSeq desc", String.valueOf(paramInt2));
      if (localObject != null)
      {
        ReadInJoyMSFHandlerUtils.a((List)localObject);
        localArrayList.addAll((Collection)localObject);
      }
      if ((localArrayList.isEmpty()) && (QLog.isColorLevel())) {
        QLog.e("ArticleInfoModule", 2, "loadChannelArticleSeqList mEntityManager.query return empty");
      }
      return localArrayList;
    }
  }
  
  public List a(Integer paramInteger)
  {
    Object localObject = c(paramInteger);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if ((paramInteger.intValue() != 70) && (!localHashSet.add(Long.valueOf(localArticleInfo.mArticleID))))
      {
        QLog.d("ArticleInfoModule", 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "，articleID = " + localArticleInfo.mArticleID);
        a(paramInteger, localArticleInfo);
      }
      else
      {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelPackMsgProcessor.a(paramInteger, localArrayList);
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ArrayList)c(paramInt1);
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "no recommend topic feeds");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReadInJoyMSFHandlerUtils.a((List)localObject1);
    localArrayList.addAll((Collection)localObject1);
    int i = 0;
    int j;
    if (i < localArrayList.size())
    {
      j = (int)((ArticleInfo)localArrayList.get(i)).mChannelID;
      localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(j));
      if (localObject1 != null) {
        break label676;
      }
      localObject1 = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(j), localObject1);
    }
    label676:
    for (;;)
    {
      for (;;)
      {
        if ((((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
        }
        int k;
        Object localObject2;
        if (((ArticleInfo)localArrayList.get(i)).mPolymericInfo != null)
        {
          k = paramInt2 + 1;
          ((ArticleInfo)localArrayList.get(i)).mPolymericInfo.jdField_e_of_type_Int = k;
          localObject2 = new oidb_cmd0x68b.PackInfo();
        }
        try
        {
          ((oidb_cmd0x68b.PackInfo)localObject2).mergeFrom(((ArticleInfo)localArrayList.get(i)).mPackInfoBytes);
          ((oidb_cmd0x68b.PackInfo)localObject2).uint32_follow_status.set(k, true);
          ((ArticleInfo)localArrayList.get(i)).mPackInfoBytes = ((oidb_cmd0x68b.PackInfo)localObject2).toByteArray();
          localObject2 = ((ArticleInfo)localArrayList.get(i)).clone();
          if (((ConcurrentHashMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq)) != null)
          {
            a(Integer.valueOf(j), (ArticleInfo)localObject2);
            if (QLog.isColorLevel()) {
              QLog.e("ArticleInfoModule", 2, "saveArticleInfo, article duplicated, article been channelID=" + j + ", articleID=" + ((ArticleInfo)localObject2).mArticleID + "，seq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
          }
          localObject1 = (ArticleInfo)((ConcurrentHashMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq));
          if (localObject1 != null)
          {
            if ((((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
              ((TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
            }
            if (((ArticleInfo)localObject1).mPolymericInfo != null)
            {
              j = paramInt2 + 1;
              ((ArticleInfo)localObject1).mPolymericInfo.jdField_e_of_type_Int = j;
              localPackInfo = new oidb_cmd0x68b.PackInfo();
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          try
          {
            oidb_cmd0x68b.PackInfo localPackInfo;
            localPackInfo.mergeFrom(((ArticleInfo)localObject1).mPackInfoBytes);
            localPackInfo.uint32_follow_status.set(j, true);
            ((ArticleInfo)localObject1).mPackInfoBytes = localPackInfo.toByteArray();
            ((ArticleInfo)localObject1).invalidateProteusTemplateBean();
            this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lte(this, (ArticleInfo)localObject2));
            i += 1;
            break;
            localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
            QLog.e("ArticleInfoModule", 1, "first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:" + paramInt1 + " e = " + localInvalidProtocolBufferMicroException1);
            localInvalidProtocolBufferMicroException1.printStackTrace();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            for (;;)
            {
              QLog.e("ArticleInfoModule", 1, "first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:" + paramInt1 + " e = " + localInvalidProtocolBufferMicroException2);
              localInvalidProtocolBufferMicroException2.printStackTrace();
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ltf(this, paramInt1, paramInt2));
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    List localList = a(Integer.valueOf(paramInt1));
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsc(this, localList, paramInt1, paramInt2, paramLong, paramBoolean));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.d("ArticleInfoModule", 1, "loadChannelArticle Exception.");
      localRejectedExecutionException.printStackTrace();
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "deleteCacheChannelArticle channelId=" + paramInt + "recommendSeq=" + paramLong);
    }
    ConcurrentHashMap localConcurrentHashMap;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      if (localConcurrentHashMap != null) {
        break label72;
      }
    }
    label72:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      localArticleInfo = (ArticleInfo)localConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localArticleInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ArticleInfoModule", 2, "deleteCacheChannelArticle connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + paramLong);
    return;
    a(Integer.valueOf(paramInt), localArticleInfo);
    localConcurrentHashMap.remove(Long.valueOf(paramLong));
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new ArrayList(((ConcurrentHashMap)localObject2).size());
    Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
    ArticleInfo localArticleInfo;
    while (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      if (localArticleInfo.mRecommendTime < paramLong) {
        ((ArrayList)localObject1).add(localArticleInfo);
      }
    }
    int j = ((ConcurrentHashMap)localObject2).size() - ((ArrayList)localObject1).size();
    if (j < paramInt2)
    {
      Collections.sort((List)localObject1, new ltl(this));
      int i = 0;
      for (;;)
      {
        if (i >= paramInt2 - j) {
          break label161;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break;
        }
        ((ArrayList)localObject1).remove(0);
        i += 1;
      }
    }
    label161:
    localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      ((ConcurrentHashMap)localObject2).remove(Long.valueOf(localArticleInfo.mRecommendSeq));
      a(Integer.valueOf(paramInt1), localArticleInfo);
    }
    localObject2 = a(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_AndroidOsHandler.post(new ltm(this, paramInt1, (List)localObject2));
    localObject1 = new StringBuilder().append("delete outdated article cache , cnt ").append(((ArrayList)localObject1).size()).append(", reservedCnt : ");
    if (j < paramInt2) {}
    for (;;)
    {
      QLog.d("ArticleInfoModule", 2, paramInt2);
      return;
      paramInt2 = j;
    }
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("ArticleInfoModule", 2, "deleteChannelArticleList channelID=" + paramInt + "articleList");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArticleInfo)((Iterator)localObject1).next();
          QLog.e("ArticleInfoModule", 2, "articleInfo.mArticleID=" + ((ArticleInfo)localObject2).mArticleID);
        }
      }
      localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    } while (localObject1 == null);
    Object localObject2 = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    label150:
    ArticleInfo localArticleInfo;
    Map.Entry localEntry;
    if (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      paramList = ((ConcurrentHashMap)localObject1).entrySet().iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        localEntry = (Map.Entry)paramList.next();
      } while (((ArticleInfo)localEntry.getValue()).mArticleID != localArticleInfo.mArticleID);
    }
    for (paramList = (ArticleInfo)localEntry.getValue();; paramList = null)
    {
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break label150;
        }
        ((StringBuilder)localObject2).append("deleteChannelArticleList connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + localArticleInfo.mRecommendSeq + '\n');
        break label150;
      }
      a(Integer.valueOf(paramInt), paramList);
      ((ConcurrentHashMap)localObject1).remove(Long.valueOf(paramList.mRecommendSeq));
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsj(this, paramList));
      break label150;
      if (((StringBuilder)localObject2).length() <= 0) {
        break;
      }
      QLog.e("ArticleInfoModule", 2, ((StringBuilder)localObject2).toString());
      return;
    }
  }
  
  public void a(long paramLong)
  {
    oidb_cmd0xb83.ReqRecommendTagInfo localReqRecommendTagInfo = new oidb_cmd0xb83.ReqRecommendTagInfo();
    localReqRecommendTagInfo.uint64_topic_id.set(paramLong);
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    localReqBody.msg_req_recommend_tag_info.set(localReqRecommendTagInfo);
    a(ReadInJoyOidbHelper.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, int paramInt)
  {
    oidb_cmd0x75e.ReqBody localReqBody = new oidb_cmd0x75e.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_network_type.set(a());
    oidb_cmd0x75e.ReqPara localReqPara = new oidb_cmd0x75e.ReqPara();
    localReqPara.enum_op_type.set(paramInt);
    localReqBody.msg_req_para.set(localReqPara);
    a(ReadInJoyOidbHelper.a("OidbSvc.0x75e", 1886, 0, localReqBody.toByteArray()));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsv(this, paramLong, paramInt1, paramInt2, paramBoolean));
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.uint64_client_swithes.set(768L);
    oidb_cmd0x68b.ReqGetFollowTabPara localReqGetFollowTabPara = new oidb_cmd0x68b.ReqGetFollowTabPara();
    localReqGetFollowTabPara.uint64_channel_id.set(70L);
    localReqGetFollowTabPara.uint64_begin_recommend_seq.set(paramLong1);
    localReqGetFollowTabPara.uint64_end_recommend_seq.set(paramLong2);
    if (paramHashMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topic update exp time ");
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        oidb_cmd0x68b.ExposeTopic localExposeTopic = new oidb_cmd0x68b.ExposeTopic();
        localExposeTopic.uint32_business_id.set(((Long)localEntry.getKey()).intValue());
        localExposeTopic.uint32_expose_time.set((int)(((Long)localEntry.getValue()).longValue() / 1000L));
        localReqGetFollowTabPara.rpt_expose_topic_list.add(localExposeTopic);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(((Long)localEntry.getKey()).intValue());
          localStringBuilder.append(" ");
          localStringBuilder.append(((Long)localEntry.getValue()).longValue() / 1000L);
          localStringBuilder.append(" ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, localStringBuilder.toString());
      }
    }
    localReqBody.msg_get_follow_tab_feeds_para.set(localReqGetFollowTabPara);
    paramHashMap = a(Integer.valueOf(70));
    if ((paramHashMap != null) && (paramLong1 != 0L))
    {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramHashMap));
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 1, "request0x68bFollowList: cookie: " + new String(paramHashMap));
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_red_dot_cookie.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_refresh_cookie.set(ByteStringMicro.copyFrom(Base64Util.decode(paramString2, 0)));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_last_feed_cookie.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.msg_get_follow_tab_feeds_para.uint32_update_times.set(paramInt1);
    localReqBody.msg_get_follow_tab_feeds_para.uint32_enter_topic_reddot_time.set(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "request0x68bFollowList: beginRecommendSeq : " + paramLong1 + ", endRecommendSeq : " + paramLong2 + ", upDate_times : " + paramInt1 + ", reddotCookie : " + paramString1 + ", lastRefreshCookie : " + paramString2 + ", lastFeedsCookie : " + paramString3);
    }
    paramHashMap = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    paramHashMap.getAttributes().put(jdField_c_of_type_JavaLangString, Integer.valueOf(5));
    l = paramLong1;
    if (paramLong1 == 0L) {
      l = -1L;
    }
    paramLong1 = paramLong2;
    if (paramLong2 == 0L) {
      paramLong1 = -1L;
    }
    paramHashMap.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(l));
    paramHashMap.getAttributes().put(jdField_e_of_type_JavaLangString, Long.valueOf(paramLong1));
    paramHashMap.getAttributes().put("isSingleHighLight", Boolean.valueOf(false));
    paramHashMap.getAttributes().put(g, Integer.valueOf(1));
    paramHashMap.getAttributes().put(jdField_b_of_type_JavaLangString, Integer.valueOf(0));
    paramHashMap.getAttributes().put("channelID", Integer.valueOf(70));
    a(paramHashMap);
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(long paramLong1, long paramLong2, SocializeFeedsInfo.BiuInfo paramBiuInfo, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint64_feeds_id.set(paramLong2);
    localReqBody.uint32_operation.set(4);
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    localFeedsInfo.feeds_type.set(paramInt2);
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    localSocializeFeedsInfo.uint64_feeds_id.set(paramLong2);
    localSocializeFeedsInfo.uint64_article_id.set(paramLong4);
    Object localObject1 = new oidb_cmd0x83e.SocializeFeedsInfoUser();
    ((oidb_cmd0x83e.SocializeFeedsInfoUser)localObject1).uint64_uin.set(paramLong3);
    Object localObject2 = ByteStringMicro.copyFromUtf8(paramString1);
    localSocializeFeedsInfo.bytes_comments.set((ByteStringMicro)localObject2);
    localObject2 = new oidb_cmd0x83e.BiuMultiLevel();
    if (paramBiuInfo.jdField_a_of_type_JavaLangLong != null) {
      ((oidb_cmd0x83e.BiuMultiLevel)localObject2).uint64_origin_feeds_id.set(paramBiuInfo.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (paramBiuInfo.jdField_b_of_type_JavaLangLong != null) {
      ((oidb_cmd0x83e.BiuMultiLevel)localObject2).uint64_origin_feeds_type.set(paramBiuInfo.jdField_b_of_type_JavaLangLong.longValue());
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 1, "request0x83eDeliver feedID=" + paramLong2 + ", feeds_type=" + paramInt2 + ", articleId=" + paramLong4 + ", masterUin=" + paramLong3 + ", comment=" + paramString1 + ",mOriFeedId=" + paramBiuInfo.jdField_a_of_type_JavaLangLong + ",mOriFeedType" + paramBiuInfo.jdField_b_of_type_JavaLangLong + ",bussinessId = " + paramArticleInfo.businessId);
    }
    paramBiuInfo = paramBiuInfo.jdField_a_of_type_JavaUtilList.iterator();
    Object localObject3;
    while (paramBiuInfo.hasNext())
    {
      paramString1 = (SocializeFeedsInfo.BiuCommentInfo)paramBiuInfo.next();
      localObject3 = new oidb_cmd0x83e.BiuOneLevelItem();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString1.jdField_a_of_type_JavaLangString);
      ((oidb_cmd0x83e.BiuOneLevelItem)localObject3).bytes_biu_comments.set(localByteStringMicro);
      ((oidb_cmd0x83e.BiuOneLevelItem)localObject3).uint32_biu_time.set(paramString1.jdField_a_of_type_Int);
      ((oidb_cmd0x83e.BiuOneLevelItem)localObject3).uint64_feeds_id.set(paramString1.jdField_b_of_type_JavaLangLong.longValue());
      ((oidb_cmd0x83e.BiuOneLevelItem)localObject3).uint64_uin.set(paramString1.jdField_a_of_type_JavaLangLong.longValue());
      ((oidb_cmd0x83e.BiuOneLevelItem)localObject3).feeds_type.set(paramString1.jdField_b_of_type_Int);
      ((oidb_cmd0x83e.BiuOneLevelItem)localObject3).op_type.set(paramString1.jdField_c_of_type_Int);
      ((oidb_cmd0x83e.BiuMultiLevel)localObject2).rpt_biu_mutli_level.add((MessageMicro)localObject3);
    }
    localSocializeFeedsInfo.msg_biu_mutli_level.set((MessageMicro)localObject2);
    localSocializeFeedsInfo.msg_master_uin.set((MessageMicro)localObject1);
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) && (ReadInJoyBaseAdapter.f(paramArticleInfo)))
      {
        paramString1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo;
        paramBiuInfo = new oidb_cmd0x83e.UGCFeedsInfo();
        if (!TextUtils.isEmpty(paramString1.jdField_a_of_type_JavaLangString)) {
          paramBiuInfo.bytes_ugc_comments.set(ByteStringMicro.copyFromUtf8(paramString1.jdField_a_of_type_JavaLangString));
        }
        paramBiuInfo.enum_ugc_feeds_card_type.set(paramString1.jdField_a_of_type_Int);
        paramBiuInfo.uint64_cuin.set(paramString1.jdField_a_of_type_Long);
        localObject1 = paramString1.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SocializeFeedsInfo.UGCPicInfo)((Iterator)localObject1).next();
          localObject3 = new oidb_cmd0x83e.UGCPicInfo();
          ((oidb_cmd0x83e.UGCPicInfo)localObject3).is_animation.set(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_c_of_type_Int);
          ((oidb_cmd0x83e.UGCPicInfo)localObject3).uint32_pic_height.set(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_b_of_type_Int);
          ((oidb_cmd0x83e.UGCPicInfo)localObject3).uint32_pic_width.set(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_a_of_type_Int);
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_a_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCPicInfo)localObject3).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCPicInfo)localObject3).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_c_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCPicInfo)localObject3).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCPicInfo)localObject2).jdField_c_of_type_JavaLangString));
          }
          paramBiuInfo.msg_ugc_pic_info_list.add((MessageMicro)localObject3);
        }
        paramString1 = paramString1.b.iterator();
        while (paramString1.hasNext())
        {
          localObject1 = (SocializeFeedsInfo.UGCVideoInfo)paramString1.next();
          localObject2 = new oidb_cmd0x83e.UGCVideoInfo();
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint32_pic_height.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_d_of_type_Int);
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint32_pic_width.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_c_of_type_Int);
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint32_video_height.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_b_of_type_Int);
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint32_video_width.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_a_of_type_Int);
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint64_duration.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_a_of_type_Long);
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint32_create_time.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_e_of_type_Int);
          ((oidb_cmd0x83e.UGCVideoInfo)localObject2).uint32_busi_type.set(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_f_of_type_Int);
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_c_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_c_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_d_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_d_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_a_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_e_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_title.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_e_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_f_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_uuid.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).jdField_f_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).i)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_vid.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).i));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).h)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_share_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).h));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.UGCVideoInfo)localObject1).g)) {
            ((oidb_cmd0x83e.UGCVideoInfo)localObject2).bytes_uniq_id.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.UGCVideoInfo)localObject1).g));
          }
          paramBiuInfo.msg_ugc_video_info_list.add((MessageMicro)localObject2);
        }
        localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(paramBiuInfo);
      }
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (ReadInJoyBaseAdapter.a(paramArticleInfo)))
      {
        paramBiuInfo = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo;
        paramString1 = new oidb_cmd0x83e.PGCFeedsInfo();
        localObject1 = paramBiuInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SocializeFeedsInfo.PGCPicInfo)((Iterator)localObject1).next();
          localObject3 = new oidb_cmd0x83e.PGCPicInfo();
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_a_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCPicInfo)localObject3).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCPicInfo)localObject3).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_c_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCPicInfo)localObject3).bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_c_of_type_JavaLangString));
          }
          ((oidb_cmd0x83e.PGCPicInfo)localObject3).is_animation.set(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_c_of_type_Int);
          ((oidb_cmd0x83e.PGCPicInfo)localObject3).uint32_pic_height.set(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_b_of_type_Int);
          ((oidb_cmd0x83e.PGCPicInfo)localObject3).uint32_pic_width.set(((SocializeFeedsInfo.PGCPicInfo)localObject2).jdField_a_of_type_Int);
          paramString1.msg_pgc_pic_info_list.add((MessageMicro)localObject3);
        }
        localObject1 = paramBiuInfo.b.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SocializeFeedsInfo.PGCVideoInfo)((Iterator)localObject1).next();
          localObject3 = new oidb_cmd0x83e.PGCVideoInfo();
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_c_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCVideoInfo)localObject3).bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_c_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_d_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCVideoInfo)localObject3).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_d_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_a_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCVideoInfo)localObject3).bytes_video_md5.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_a_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            ((oidb_cmd0x83e.PGCVideoInfo)localObject3).bytes_video_url.set(ByteStringMicro.copyFromUtf8(((SocializeFeedsInfo.PGCVideoInfo)localObject2).jdField_b_of_type_JavaLangString));
          }
          paramString1.msg_pgc_video_info_list.add((MessageMicro)localObject3);
        }
        if (!TextUtils.isEmpty(paramBiuInfo.jdField_a_of_type_JavaLangString)) {
          paramString1.bytes_pgc_comments.set(ByteStringMicro.copyFromUtf8(paramBiuInfo.jdField_a_of_type_JavaLangString));
        }
        localSocializeFeedsInfo.msg_pgc_topic_feeds_info.set(paramString1);
      }
      if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo != null) && (ReadInJoyBaseAdapter.a(paramArticleInfo)))
      {
        paramBiuInfo = new oidb_cmd0x83e.TopicRecommendFeedsInfo();
        paramBiuInfo.uint32_feeds_style.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_Int);
        paramBiuInfo.uint64_feeds_id.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_Long);
        paramString1 = new ArrayList();
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localObject1 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (TopicRecommendFeedsInfo.TopicRecommendInfo)((Iterator)localObject1).next();
            localObject3 = new oidb_cmd0x83e.TopicRecommendInfo();
            ((oidb_cmd0x83e.TopicRecommendInfo)localObject3).uint32_number_of_participants.set(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_b_of_type_Int);
            if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_a_of_type_JavaLangString)) {
              ((oidb_cmd0x83e.TopicRecommendInfo)localObject3).bytes_business_name.set(ByteStringMicro.copyFromUtf8(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_a_of_type_JavaLangString));
            }
            if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_c_of_type_JavaLangString)) {
              ((oidb_cmd0x83e.TopicRecommendInfo)localObject3).bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_c_of_type_JavaLangString));
            }
            if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_b_of_type_JavaLangString)) {
              ((oidb_cmd0x83e.TopicRecommendInfo)localObject3).bytes_business_url.set(ByteStringMicro.copyFromUtf8(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_b_of_type_JavaLangString));
            }
            if (!TextUtils.isEmpty(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_d_of_type_JavaLangString)) {
              ((oidb_cmd0x83e.TopicRecommendInfo)localObject3).bytes_pic_url.set(ByteStringMicro.copyFromUtf8(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_d_of_type_JavaLangString));
            }
            ((oidb_cmd0x83e.TopicRecommendInfo)localObject3).uint32_business_id.set(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject2).jdField_a_of_type_Int);
            paramString1.add(localObject3);
          }
        }
        paramBiuInfo.msg_topic_recommend_info.set(paramString1);
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null)
        {
          paramString1 = new oidb_cmd0x83e.TopicRecommendFeedsTitle();
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString)) {
            paramString1.bytes_url.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString)) {
            paramString1.bytes_title_content.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString));
          }
          paramBiuInfo.msg_left_title.set(paramString1);
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle != null)
        {
          paramString1 = new oidb_cmd0x83e.TopicRecommendFeedsTitle();
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString)) {
            paramString1.bytes_url.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_b_of_type_JavaLangString));
          }
          if (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString)) {
            paramString1.bytes_title_content.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendFeedsTitle.jdField_a_of_type_JavaLangString));
          }
          paramBiuInfo.msg_right_title.set(paramString1);
        }
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaLangString != null) {
          paramBiuInfo.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_a_of_type_JavaLangString));
        }
        paramBiuInfo.uint64_uin.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_Long);
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString != null) {
          paramBiuInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.jdField_b_of_type_JavaLangString));
        }
        localSocializeFeedsInfo.msg_topic_recommend_feeds_info.set(paramBiuInfo);
      }
    }
    if ((ReadInJoyUtils.b(paramArticleInfo)) || (ReadInJoyUtils.c(paramArticleInfo)) || (ReadInJoyUtils.d(paramArticleInfo)) || (ReadInJoyUtils.e(paramArticleInfo))) {
      if ((paramArticleInfo.mTopicRecommendFeedsInfo != null) && (paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localFeedsInfo.uint32_business_id.set(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
      if (!TextUtils.isEmpty(paramArticleInfo.businessName)) {
        localFeedsInfo.bytes_business_name.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessName));
      }
      if (!TextUtils.isEmpty(paramArticleInfo.businessUrl)) {
        localFeedsInfo.bytes_business_url.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessUrl));
      }
      if (!TextUtils.isEmpty(paramArticleInfo.businessNamePrefix)) {
        localFeedsInfo.bytes_business_name_prefix.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.businessNamePrefix));
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 1, "request0x83eDeliver enum_biu_src=" + paramInt1);
      }
      localReqBody.enum_biu_src.set(paramInt1);
      if (((paramInt1 == 17) || (paramInt1 == 2)) && (!TextUtils.isEmpty(paramString2)))
      {
        paramBiuInfo = ByteStringMicro.copyFromUtf8(paramString2);
        localReqBody.bytes_inner_uniq_id.set(paramBiuInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ArticleInfoModule", 1, "request0x83eDeliver innerUniqueIDc=" + paramString2);
        }
      }
      localReqBody.msg_feeds_info.set(localFeedsInfo);
      paramBiuInfo = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramBiuInfo.addAttribute("biu_deliver", Integer.valueOf(1));
      paramBiuInfo.addAttribute("BaseArticleSeq", Long.valueOf(paramLong5));
      a(paramBiuInfo);
      return;
      localFeedsInfo.uint32_business_id.set((int)paramArticleInfo.businessId);
    }
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    Object localObject = new oidb_cmd0x83e.ReqBody();
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      if (paramLong1 != -1L) {
        ((oidb_cmd0x83e.ReqBody)localObject).uint64_uin.set(paramLong1);
      }
      if (paramLong2 != -1L) {
        ((oidb_cmd0x83e.ReqBody)localObject).uint64_feeds_id.set(paramLong2);
      }
      ((oidb_cmd0x83e.ReqBody)localObject).uint32_operation.set(i);
      oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
      localFeedsInfo.feeds_type.set(paramArticleInfo.busiType);
      localFeedsInfo.uint32_business_id.set((int)paramArticleInfo.businessId);
      ((oidb_cmd0x83e.ReqBody)localObject).msg_feeds_info.set(localFeedsInfo);
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, ((oidb_cmd0x83e.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("0x83e_retry_times", Integer.valueOf(0));
      ((ToServiceMsg)localObject).addAttribute("0x83e_article", paramArticleInfo);
      a((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    localReqBody.enum_biu_src.set(paramInt);
    localReqBody.uint32_operation.set(4);
    localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
    oidb_cmd0x83e.FeedsInfo localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
    oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    paramString1 = new oidb_cmd0x83e.SocializeFeedsInfoUser();
    paramString1.uint64_uin.set(paramLong);
    localSocializeFeedsInfo.msg_master_uin.set(paramString1);
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "";
    }
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localSocializeFeedsInfo.bytes_comments.set(paramString1);
    if (paramArrayList != null)
    {
      paramString2 = new SocializeFeedsInfo();
      paramString2.getClass();
      paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo(paramString2);
      paramInt = paramArrayList.size() - 1;
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        if (paramInt > 0)
        {
          localObject1 = (ReadInJoyBaseDeliverActivity.UserBiuInfo)paramArrayList.get(paramInt);
          paramString2.getClass();
          localObject2 = new SocializeFeedsInfo.BiuCommentInfo(paramString2);
          try
          {
            ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangLong = Long.valueOf(((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject1).jdField_a_of_type_JavaLangString);
            if (((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject1).b == null)
            {
              paramString1 = "";
              ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangString = paramString1;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_c_of_type_Int = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject1).jdField_d_of_type_Int;
              ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
              paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject2);
              paramInt -= 1;
            }
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject2).jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
              continue;
              paramString1 = ((ReadInJoyBaseDeliverActivity.UserBiuInfo)localObject1).b.toString();
            }
          }
        }
      }
      paramString1 = new oidb_cmd0x83e.BiuMultiLevel();
      paramString2 = paramString2.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.iterator();
      while (paramString2.hasNext())
      {
        paramArrayList = (SocializeFeedsInfo.BiuCommentInfo)paramString2.next();
        localObject1 = new oidb_cmd0x83e.BiuOneLevelItem();
        localObject2 = ByteStringMicro.copyFromUtf8(paramArrayList.jdField_a_of_type_JavaLangString);
        ((oidb_cmd0x83e.BiuOneLevelItem)localObject1).bytes_biu_comments.set((ByteStringMicro)localObject2);
        ((oidb_cmd0x83e.BiuOneLevelItem)localObject1).uint32_biu_time.set(paramArrayList.jdField_a_of_type_Int);
        ((oidb_cmd0x83e.BiuOneLevelItem)localObject1).uint64_feeds_id.set(paramArrayList.jdField_b_of_type_JavaLangLong.longValue());
        ((oidb_cmd0x83e.BiuOneLevelItem)localObject1).uint64_uin.set(paramArrayList.jdField_a_of_type_JavaLangLong.longValue());
        ((oidb_cmd0x83e.BiuOneLevelItem)localObject1).feeds_type.set(paramArrayList.jdField_b_of_type_Int);
        ((oidb_cmd0x83e.BiuOneLevelItem)localObject1).op_type.set(paramArrayList.jdField_c_of_type_Int);
        paramString1.rpt_biu_mutli_level.add((MessageMicro)localObject1);
      }
      localSocializeFeedsInfo.msg_biu_mutli_level.set(paramString1);
    }
    localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
    localReqBody.msg_feeds_info.set(localFeedsInfo);
    paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
    paramString1.addAttribute("biu_deliver", Integer.valueOf(2));
    a(paramString1);
  }
  
  public void a(long paramLong, List paramList)
  {
    oidb_cmd0x46f.ReqBody localReqBody = new oidb_cmd0x46f.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0x46f.DislikeParam localDislikeParam = a((DislikeParam)paramList.next());
      localReqBody.rpt_param_list.add(localDislikeParam);
    }
    a(ReadInJoyOidbHelper.a("OidbSvc.0x46f", 1135, 0, localReqBody.toByteArray()));
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()))
    {
      QLog.d("ArticleInfoModule", 2, "request0x68bChannelArticleList executorService has error !");
      return;
    }
    jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsb(this, paramRequest0x68bParams));
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsw(this, paramArticleInfo));
    }
  }
  
  public void a(ChannelTopCookie paramChannelTopCookie)
  {
    if (paramChannelTopCookie.mChannelID == 70)
    {
      if ((paramChannelTopCookie.mSetTopCookie == null) || (paramChannelTopCookie.mSetTopCookie.length <= 0)) {
        break label86;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "save follow cookie is " + new String(paramChannelTopCookie.mSetTopCookie));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramChannelTopCookie.mChannelID), paramChannelTopCookie);
      return;
      label86:
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "save follow cookie is null");
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      do
      {
        return;
        if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (paramFromServiceMsg.getServiceCmd().equals("PubAccountArticleCenter.ArticleLike"));
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
      {
        if (((Integer)paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0))).intValue() == 1)
        {
          i(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (((Integer)paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0))).intValue() == 2)
        {
          f(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (((Integer)paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0))).intValue() == 1)
        {
          g(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (((Integer)paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0))).intValue() == 1)
        {
          h(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb83"));
    k(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(Integer paramInteger, byte[] paramArrayOfByte)
  {
    ChannelTopCookie localChannelTopCookie2 = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    ChannelTopCookie localChannelTopCookie1;
    if (localChannelTopCookie2 == null)
    {
      localChannelTopCookie2 = new ChannelTopCookie();
      localChannelTopCookie2.mChannelID = paramInteger.intValue();
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
    for (;;)
    {
      a(localChannelTopCookie1);
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsn(this, localChannelTopCookie1));
        return;
      }
      catch (Exception paramInteger)
      {
        paramInteger.printStackTrace();
      }
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    oidb_cmd0xb83.ReqBody localReqBody = new oidb_cmd0xb83.ReqBody();
    if (!TextUtils.isEmpty(paramString))
    {
      oidb_cmd0xb83.SearchInfo localSearchInfo = new oidb_cmd0xb83.SearchInfo();
      localSearchInfo.bytes_key.set(ByteStringMicro.copyFromUtf8(paramString));
      paramString = new oidb_cmd0xb83.ReqSearchTagInfo();
      paramString.rpt_msg_search_info_list.add(localSearchInfo);
      localReqBody.msg_req_search_tag_info.set(paramString);
    }
    for (;;)
    {
      a(ReadInJoyOidbHelper.a("OidbSvc.0xb83", 2947, 0, localReqBody.toByteArray()));
      return;
      paramString = new oidb_cmd0xb83.ReqRecommendTagInfo();
      localReqBody.msg_req_recommend_tag_info.set(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, String paramString5, boolean paramBoolean1, String paramString6, int paramInt5, ArrayList paramArrayList, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ArticleInfoModule", 2, "requestDeliverUGC uin=" + paramString1 + ", topicId=" + paramString2 + ", adtag=" + paramInt1 + ", type=" + paramInt2 + ", comment=" + paramString3 + ", pic=" + ReadInJoyDeliverUGCActivity.a(paramString4) + ", width=" + paramInt3 + ", height=" + paramInt4 + ", md5=" + paramString5 + ", isGif=" + paramBoolean1 + "pic_type=" + paramInt5 + "is from dian dian = " + paramBoolean2);
      if (paramString6 != null) {
        QLog.d("ArticleInfoModule", 2, "gifurl: " + paramString6);
      }
    }
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label210:
      break label210;
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_operation.set(5);
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    for (;;)
    {
      localReqBody.bool_is_master.set(true);
      paramString1 = new oidb_cmd0x83e.FeedsInfo();
      if (paramInt1 == 12)
      {
        paramString1.feeds_type.set(4);
        label281:
        paramInt1 = 0;
      }
      try
      {
        int i = Integer.parseInt(paramString2);
        paramInt1 = i;
      }
      catch (Exception paramString2)
      {
        label292:
        Object localObject;
        ReadInJoyBaseDeliverActivity.UserBiuInfo localUserBiuInfo;
        oidb_cmd0x83e.BiuOneLevelItem localBiuOneLevelItem;
        break label292;
      }
      paramString1.uint32_business_id.set(paramInt1);
      if (paramBoolean2) {
        localReqBody.enum_ugc_src.set(1);
      }
      paramString2 = new oidb_cmd0x83e.SocializeFeedsInfo();
      localObject = new oidb_cmd0x83e.SocializeFeedsInfoUser();
      ((oidb_cmd0x83e.SocializeFeedsInfoUser)localObject).uint64_uin.set(l1);
      ((oidb_cmd0x83e.SocializeFeedsInfoUser)localObject).enum_uin_type.set(0);
      paramString2.msg_master_uin.set((MessageMicro)localObject);
      if (!TextUtils.isEmpty(paramString3))
      {
        paramString2.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString3));
        paramString3 = new oidb_cmd0x83e.UGCFeedsInfo();
        if (paramArrayList == null) {
          break label578;
        }
        localObject = new oidb_cmd0x83e.BiuMultiLevel();
        paramInt1 = paramArrayList.size() - 1;
        label410:
        if (paramInt1 >= 0)
        {
          localUserBiuInfo = (ReadInJoyBaseDeliverActivity.UserBiuInfo)paramArrayList.get(paramInt1);
          localBiuOneLevelItem = new oidb_cmd0x83e.BiuOneLevelItem();
        }
      }
      else
      {
        try
        {
          localBiuOneLevelItem.uint64_uin.set(Long.valueOf(localUserBiuInfo.jdField_a_of_type_JavaLangString).longValue());
          localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localUserBiuInfo.b.toString()));
          localBiuOneLevelItem.op_type.set(localUserBiuInfo.jdField_d_of_type_Int);
          ((oidb_cmd0x83e.BiuMultiLevel)localObject).rpt_biu_mutli_level.add(localBiuOneLevelItem);
          paramInt1 -= 1;
          break label410;
          localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
          continue;
          if (paramInt1 != 13) {
            break label281;
          }
          paramString1.feeds_type.set(5);
          break label281;
          paramString2.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localBiuOneLevelItem.uint64_uin.set(0L);
          }
        }
      }
    }
    paramString3.msg_at_multi_level.set((MessageMicro)localObject);
    label578:
    if (paramInt2 == 2)
    {
      paramString6 = new oidb_cmd0x83e.UGCPicInfo();
      paramString6.uint32_pic_width.set(paramInt3);
      paramString6.uint32_pic_height.set(paramInt4);
      paramString6.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramString5));
      paramString6.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramString4));
      paramString4 = paramString6.is_animation;
      if (paramBoolean1)
      {
        paramInt1 = 1;
        paramString4.set(paramInt1);
        paramString6.uint32_pic_type.set(paramInt5);
        paramString4 = new ArrayList();
        paramString4.add(paramString6);
        paramString3.msg_ugc_pic_info_list.set(paramString4);
      }
    }
    while (paramInt2 != 3) {
      for (;;)
      {
        paramString2.msg_ugc_topic_feeds_info.set(paramString3);
        paramString1.msg_social_feeds_info.set(paramString2);
        localReqBody.msg_feeds_info.set(paramString1);
        paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
        paramString1.addAttribute("ugc_deliver", Integer.valueOf(1));
        a(paramString1);
        return;
        paramInt1 = 0;
      }
    }
    paramArrayList = new oidb_cmd0x83e.UGCPicInfo();
    paramArrayList.uint32_pic_width.set(paramInt3);
    paramArrayList.uint32_pic_height.set(paramInt4);
    paramArrayList.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramString5));
    paramString5 = new ArrayList();
    localObject = paramArrayList.is_animation;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      paramArrayList.uint32_pic_type.set(paramInt5);
      if (paramString6 != null) {
        paramArrayList.bytes_thumbnail_url.set(ByteStringMicro.copyFromUtf8(paramString6));
      }
      if (paramString4 != null) {
        paramArrayList.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramString4));
      }
      paramString5.add(paramArrayList);
      paramString3.msg_ugc_pic_info_list.set(paramString5);
      break;
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArticleInfoModule", 2, "requestDeliverUpMasterVideo uin=" + paramString1 + ", comment=" + paramString2 + ", bundle=" + paramBundle.toString());
    }
    oidb_cmd0x83e.ReqBody localReqBody = new oidb_cmd0x83e.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString1);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label78:
      oidb_cmd0x83e.FeedsInfo localFeedsInfo;
      int i;
      break label78;
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_operation.set(5);
    if (!TextUtils.isEmpty(paramString2))
    {
      localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(paramString2));
      localReqBody.bool_is_master.set(true);
      localFeedsInfo = new oidb_cmd0x83e.FeedsInfo();
      i = paramBundle.getInt("arg_ad_tag");
      if (i != 12) {
        break label401;
      }
      localFeedsInfo.feeds_type.set(4);
      label159:
      i = 0;
    }
    try
    {
      int j = Integer.parseInt(paramBundle.getString("arg_topic_id"));
      i = j;
    }
    catch (Exception paramString1)
    {
      label178:
      oidb_cmd0x83e.SocializeFeedsInfo localSocializeFeedsInfo;
      oidb_cmd0x83e.UGCFeedsInfo localUGCFeedsInfo;
      Object localObject;
      break label178;
    }
    localFeedsInfo.uint32_business_id.set(i);
    if (paramBoolean2) {
      localReqBody.enum_ugc_src.set(1);
    }
    localSocializeFeedsInfo = new oidb_cmd0x83e.SocializeFeedsInfo();
    paramString1 = new oidb_cmd0x83e.SocializeFeedsInfoUser();
    paramString1.uint64_uin.set(l1);
    paramString1.enum_uin_type.set(0);
    localSocializeFeedsInfo.msg_master_uin.set(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    for (;;)
    {
      localUGCFeedsInfo = new oidb_cmd0x83e.UGCFeedsInfo();
      paramString1 = paramBundle.getParcelableArrayList("arg_ugc_tag_list");
      if (paramString1 == null) {
        break label437;
      }
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (TagInfo)paramString1.next();
        localObject = new oidb_cmd0x83e.TagInfo();
        ((oidb_cmd0x83e.TagInfo)localObject).uint64_tag_id.set(paramString2.a());
        ((oidb_cmd0x83e.TagInfo)localObject).bytes_tag_name.set(ByteStringMicro.copyFromUtf8(paramString2.a()));
        ((oidb_cmd0x83e.TagInfo)localObject).double_tag_score.set(paramString2.a());
        ((oidb_cmd0x83e.TagInfo)localObject).uint64_channel.set(paramString2.b());
        localUGCFeedsInfo.rpt_msg_tag_info_list.add((MessageMicro)localObject);
      }
      localReqBody.bytes_comment.set(ByteStringMicro.copyFromUtf8(""));
      break;
      label401:
      if (i != 13) {
        break label159;
      }
      localFeedsInfo.feeds_type.set(5);
      break label159;
      localSocializeFeedsInfo.bytes_comments.set(ByteStringMicro.copyFromUtf8(""));
    }
    label437:
    if (paramArrayList != null)
    {
      paramString1 = new oidb_cmd0x83e.BiuMultiLevel();
      i = paramArrayList.size() - 1;
      for (;;)
      {
        if (i >= 0)
        {
          paramString2 = (ReadInJoyBaseDeliverActivity.UserBiuInfo)paramArrayList.get(i);
          localObject = new oidb_cmd0x83e.BiuOneLevelItem();
          try
          {
            ((oidb_cmd0x83e.BiuOneLevelItem)localObject).uint64_uin.set(Long.valueOf(paramString2.jdField_a_of_type_JavaLangString).longValue());
            ((oidb_cmd0x83e.BiuOneLevelItem)localObject).bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(paramString2.b.toString()));
            ((oidb_cmd0x83e.BiuOneLevelItem)localObject).op_type.set(paramString2.jdField_d_of_type_Int);
            paramString1.rpt_biu_mutli_level.add((MessageMicro)localObject);
            i -= 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ((oidb_cmd0x83e.BiuOneLevelItem)localObject).uint64_uin.set(0L);
            }
          }
        }
      }
      localUGCFeedsInfo.msg_at_multi_level.set(paramString1);
    }
    if (paramBoolean1) {
      localUGCFeedsInfo.enum_ugc_feeds_src.set(1);
    }
    for (;;)
    {
      paramArrayList = new oidb_cmd0x83e.UGCVideoInfo();
      paramArrayList.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_url", "")));
      paramArrayList.bytes_pic_md5.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_cover_md5", "")));
      paramArrayList.bytes_video_url.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_url", "")));
      paramString2 = paramBundle.getString("arg_video_md5", "");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = paramBundle.getString("arg_video_url", "");
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = "12345";
        }
      }
      paramArrayList.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(paramString1));
      paramArrayList.bytes_title.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_title", "")));
      paramArrayList.bytes_uuid.set(ByteStringMicro.copyFromUtf8(paramBundle.getString("arg_video_uuid", "")));
      paramArrayList.uint64_duration.set(paramBundle.getLong("arg_video_duration"));
      paramArrayList.uint32_pic_width.set(paramBundle.getInt("arg_video_cover_width"));
      paramArrayList.uint32_pic_height.set(paramBundle.getInt("arg_video_cover_height"));
      paramArrayList.uint32_video_width.set(paramBundle.getInt("arg_video_width"));
      paramArrayList.uint32_video_height.set(paramBundle.getInt("arg_video_height"));
      paramArrayList.bytes_video_format.set(ByteStringMicro.copyFromUtf8("mp4"));
      paramString1 = new ArrayList();
      paramString1.add(paramArrayList);
      localUGCFeedsInfo.msg_ugc_video_info_list.set(paramString1);
      localSocializeFeedsInfo.msg_ugc_topic_feeds_info.set(localUGCFeedsInfo);
      localFeedsInfo.msg_social_feeds_info.set(localSocializeFeedsInfo);
      localReqBody.msg_feeds_info.set(localFeedsInfo);
      paramString1 = ReadInJoyOidbHelper.a("OidbSvc.0x83e", 2110, 0, localReqBody.toByteArray());
      paramString1.addAttribute("up_master_deliver", Integer.valueOf(1));
      a(paramString1);
      return;
      localUGCFeedsInfo.enum_ugc_feeds_src.set(0);
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lsm(this, paramList));
  }
  
  public void a(boolean paramBoolean, int paramInt, List paramList1, List paramList2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ltb(this, paramBoolean, paramList1, paramList2, paramInt));
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Object localObject = (ArrayList)b(paramInt1);
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArticleInfoModule", 2, "no recommend topic feeds");
      }
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    ReadInJoyMSFHandlerUtils.a((List)localObject);
    localArrayList.addAll((Collection)localObject);
    paramInt1 = 0;
    int i;
    if (paramInt1 < localArrayList.size())
    {
      i = (int)((ArticleInfo)localArrayList.get(paramInt1)).mChannelID;
      localObject = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(i));
      if (localObject != null) {
        break label419;
      }
      localObject = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), localObject);
    }
    label419:
    for (;;)
    {
      if ((((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        ((TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
      }
      ArticleInfo localArticleInfo = ((ArticleInfo)localArrayList.get(paramInt1)).clone();
      if (((ConcurrentHashMap)localObject).get(Long.valueOf(localArticleInfo.mRecommendSeq)) != null)
      {
        a(Integer.valueOf(i), localArticleInfo);
        if (QLog.isColorLevel()) {
          QLog.e("ArticleInfoModule", 2, "saveArticleInfo, article duplicated, article been channelID=" + i + ", articleID=" + localArticleInfo.mArticleID + "，seq=" + localArticleInfo.mRecommendSeq);
        }
      }
      localObject = (ArticleInfo)((ConcurrentHashMap)localObject).get(Long.valueOf(localArticleInfo.mRecommendSeq));
      if (localObject != null)
      {
        if ((((ArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList != null) && (((ArticleInfo)localObject).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)((ArticleInfo)localObject).mTopicRecommendFeedsInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_c_of_type_Int = paramInt2;
        }
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ltc(this, localArticleInfo));
      paramInt1 += 1;
      break;
      this.jdField_a_of_type_AndroidOsHandler.post(new ltd(this));
      return true;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramBoolean) {}
    for (String str = "mChannelID = ? and mRecommendSeq < ?";; str = "mChannelID = ? and mRecommendSeq > ?")
    {
      QLog.i("ArticleInfoModule", 1, "loadMoreChannelArticleList with selection=" + str + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lse(this, str, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt6, paramBoolean, paramInt5));
      return true;
    }
  }
  
  public boolean a(Integer paramInteger, List paramList, boolean paramBoolean)
  {
    b(paramList);
    if ((paramInteger.intValue() == -1) || (paramList == null) || (paramList.size() == 0))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramInteger);
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelPackMsgProcessor.a(paramInteger, paramList, paramBoolean);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      a(paramInteger, localArticleInfo, paramBoolean, a(Long.valueOf(localArticleInfo.mArticleID)));
    }
    return true;
  }
  
  public boolean a(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramLong) != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public byte[] a(Integer paramInteger)
  {
    paramInteger = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return paramInteger.mSetTopCookie;
  }
  
  public long b(Integer paramInteger)
  {
    long l1 = 9223372036854775807L;
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = -1L;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() < l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public List b(Integer paramInteger)
  {
    Object localObject = c(paramInteger);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if ((localArrayList.contains(Long.valueOf(localArticleInfo.mArticleID))) || (localArticleInfo.mRecommendSeq == -2L) || (localArticleInfo.mRecommendSeq == -3L))
      {
        QLog.d("ArticleInfoModule", 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
        a(paramInteger, localArticleInfo);
      }
      else
      {
        localArrayList.add(Long.valueOf(localArticleInfo.mArticleID));
      }
    }
    return localArrayList;
  }
  
  public void b() {}
  
  public void b(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArticleInfoModule", 2, "deleteChannelArticle channelId=" + paramInt + "recommendSeq=" + paramLong);
    }
    if ((paramLong == -2L) || (paramLong == -3L)) {
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "deleteChannelArticle recommendSeq is TOPIC/SUBSCRIBE recommendSeq");
      }
    }
    ConcurrentHashMap localConcurrentHashMap;
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
        localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      } while (localConcurrentHashMap == null);
      localArticleInfo = (ArticleInfo)localConcurrentHashMap.get(Long.valueOf(paramLong));
      if (localArticleInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ArticleInfoModule", 2, "deleteChannelArticle connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + paramLong);
    return;
    a(Integer.valueOf(paramInt), localArticleInfo);
    localConcurrentHashMap.remove(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsk(this, localArticleInfo));
  }
  
  public boolean b(Long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilHashMap.get(paramLong) != null) {
          bool1 = ((AtomicBoolean)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong)).get();
        }
      }
    }
    return bool1;
  }
  
  public List c(Integer paramInteger)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if ((paramInteger == null) || (paramInteger.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInteger.size());
    Iterator localIterator = paramInteger.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ArticleInfo)paramInteger.get((Long)localIterator.next()));
    }
    Collections.sort(localArrayList, new lsi(this));
    return localArrayList;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("ArticleInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
  }
  
  public void e() {}
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new lsl(this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    c(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(161)).a(0));
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().post(new lta(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule
 * JD-Core Version:    0.7.0.1
 */