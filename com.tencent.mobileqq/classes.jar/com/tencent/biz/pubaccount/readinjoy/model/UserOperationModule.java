package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.engine.SPEventReportSwitch;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyMSFService;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.VideoExtraRepoerData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import lsb;
import lsc;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.FeedsReportData;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReportInfo;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.ReqBody;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.RspBody;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportReq;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.KDEventReportResp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.ReqBody;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.RspBody;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.AdInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.PhoneInfo;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.ReqBody;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationInfo;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.OneFollowOperationResult;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.ReqBody;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.ReqFollowOperationPara;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspBody;
import tencent.im.oidb.cmd0x978.oidb_cmd0x978.RspFollowOperationResult;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class UserOperationModule
  extends ReadInJoyEngineModule
{
  static int jdField_a_of_type_Int = 42105;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public UserOperationModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  public UserOperationModule(EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(null, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private int a()
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
  
  private ToServiceMsg a(List paramList)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (ReportInfo)paramList.next();
        oidb_cmd0x64e.ReportInfo localReportInfo = new oidb_cmd0x64e.ReportInfo();
        localReportInfo.uint64_uin.set(((ReportInfo)localObject1).mUin);
        localReportInfo.uint32_source.set(((ReportInfo)localObject1).mSource);
        if (((ReportInfo)localObject1).mSourceArticleId != -1L) {
          localReportInfo.uint64_source_article_id.set(((ReportInfo)localObject1).mSourceArticleId);
        }
        if (((ReportInfo)localObject1).mChannelId != -1) {
          localReportInfo.uint32_channel_id.set(((ReportInfo)localObject1).mChannelId);
        }
        if (((ReportInfo)localObject1).mAlgorithmId != -1) {
          localReportInfo.uint32_algorithm_id.set(((ReportInfo)localObject1).mAlgorithmId);
        }
        if (((ReportInfo)localObject1).mStrategyId != -1) {
          localReportInfo.uint32_strategy_id.set(((ReportInfo)localObject1).mStrategyId);
        }
        localReportInfo.enum_operation.set(((ReportInfo)localObject1).mOperation);
        if ((((ReportInfo)localObject1).mOperation == 9) && (((ReportInfo)localObject1).mReadTimeLength != -1)) {
          localReportInfo.uint32_read_time_length.set(((ReportInfo)localObject1).mReadTimeLength);
        }
        if ((((ReportInfo)localObject1).mOperation == 12) && (((ReportInfo)localObject1).mPlayTimeLength != -1)) {
          localReportInfo.uint32_play_time_length.set(((ReportInfo)localObject1).mPlayTimeLength);
        }
        if (!TextUtils.isEmpty(((ReportInfo)localObject1).mCollectUrl)) {
          localReportInfo.bytes_collect_url.set(ByteStringMicro.copyFromUtf8(((ReportInfo)localObject1).mCollectUrl));
        }
        if (!TextUtils.isEmpty(((ReportInfo)localObject1).mInnerId)) {
          localReportInfo.bytes_inner_id.set(ByteStringMicro.copyFromUtf8(((ReportInfo)localObject1).mInnerId));
        }
        if (((ReportInfo)localObject1).mOpSource >= 0) {
          localReportInfo.enum_op_source.set(((ReportInfo)localObject1).mOpSource);
        }
        if (((ReportInfo)localObject1).mServerContext != null) {
          localReportInfo.bytes_server_context.set(ByteStringMicro.copyFrom(((ReportInfo)localObject1).mServerContext));
        }
        localReportInfo.bool_is_gallery.set(((ReportInfo)localObject1).mIsGallery);
        if (((ReportInfo)localObject1).mGalleryReportInfo != null) {
          localReportInfo.bytes_gallery_report_info.set(ByteStringMicro.copyFrom(((ReportInfo)localObject1).mGalleryReportInfo));
        }
        if (((ReportInfo)localObject1).mArticleLength != -1) {
          localReportInfo.uint32_article_length.set(((ReportInfo)localObject1).mArticleLength);
        }
        if (((ReportInfo)localObject1).mReadArticleLength != -1) {
          localReportInfo.uint32_read_article_length.set(((ReportInfo)localObject1).mReadArticleLength);
        }
        Object localObject2 = ReadInJoyUtils.h();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          localReportInfo.bytes_device_id.set(ByteStringMicro.copyFromUtf8((String)localObject2));
          localObject2 = new ArrayList();
          Object localObject3 = ((ReportInfo)localObject1).mFeedsReportData;
          if (localObject3 != null)
          {
            localFeedsReportData = new oidb_cmd0x64e.FeedsReportData();
            localFeedsReportData.uint64_feeds_id.set(((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_Long);
            localFeedsReportData.uint64_publish_uin.set(((ReportInfo.FeedsReportData)localObject3).jdField_b_of_type_Long);
            localFeedsReportData.uint32_like_total_count.set(((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_Int);
            localFeedsReportData.uint32_comment_total_count.set(((ReportInfo.FeedsReportData)localObject3).jdField_b_of_type_Int);
            localArrayList2 = new ArrayList();
            if ((((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList != null) && (!((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList.isEmpty()))
            {
              localObject3 = ((ReportInfo.FeedsReportData)localObject3).jdField_a_of_type_JavaUtilList.iterator();
              while (((Iterator)localObject3).hasNext()) {
                localArrayList2.add((Long)((Iterator)localObject3).next());
              }
            }
          }
        }
        catch (Exception localException)
        {
          oidb_cmd0x64e.FeedsReportData localFeedsReportData;
          ArrayList localArrayList2;
          for (;;)
          {
            localException.printStackTrace();
          }
          localFeedsReportData.rpt_like_uin_list.set(localArrayList2);
          localException.add(localFeedsReportData);
          localReportInfo.rpt_feeds_report_data_list.set(localException);
          localObject1 = ((ReportInfo)localObject1).mVideoExtraRepoerData;
          if (localObject1 != null)
          {
            localReportInfo.enum_network_type.set(b());
            localReportInfo.operator_platform.set(3);
            if (((ReportInfo.VideoExtraRepoerData)localObject1).jdField_b_of_type_Boolean) {
              localReportInfo.whether_click_in.set(((ReportInfo.VideoExtraRepoerData)localObject1).jdField_a_of_type_Boolean);
            }
            if (((ReportInfo.VideoExtraRepoerData)localObject1).jdField_a_of_type_Int != -1) {
              localReportInfo.enum_jumpway_which.set(((ReportInfo.VideoExtraRepoerData)localObject1).jdField_a_of_type_Int);
            }
            if (((ReportInfo.VideoExtraRepoerData)localObject1).jdField_b_of_type_Int != -1) {
              localReportInfo.enum_in_onetree_source.set(((ReportInfo.VideoExtraRepoerData)localObject1).jdField_b_of_type_Int);
            }
            if (((ReportInfo.VideoExtraRepoerData)localObject1).c != -1) {
              localReportInfo.enum_in_videochannel_source.set(((ReportInfo.VideoExtraRepoerData)localObject1).c);
            }
            if (((ReportInfo.VideoExtraRepoerData)localObject1).d != -1) {
              localReportInfo.uint32_current_video_time.set(((ReportInfo.VideoExtraRepoerData)localObject1).d);
            }
            if (((ReportInfo.VideoExtraRepoerData)localObject1).e != -1) {
              localReportInfo.uint32_video_duration.set(((ReportInfo.VideoExtraRepoerData)localObject1).e);
            }
          }
          localArrayList1.add(localReportInfo);
        }
      }
    }
    localReqBody.rpt_report_info.set(localArrayList1);
    return ReadInJoyOidbHelper.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private int b()
  {
    switch (NetworkUtil.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 1;
  }
  
  private ToServiceMsg b(List paramList)
  {
    oidb_cmd0x64e.ReqBody localReqBody = new oidb_cmd0x64e.ReqBody();
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ReportInfo localReportInfo = (ReportInfo)paramList.next();
        oidb_cmd0x64e.ReportInfo localReportInfo1 = new oidb_cmd0x64e.ReportInfo();
        localReportInfo1.uint64_uin.set(localReportInfo.mUin);
        if (localReportInfo.mSourceArticleId != -1L) {
          localReportInfo1.uint64_source_article_id.set(localReportInfo.mSourceArticleId);
        }
        if (localReportInfo.mAlgorithmId != -1) {
          localReportInfo1.uint32_algorithm_id.set(localReportInfo.mAlgorithmId);
        }
        if (localReportInfo.mStrategyId != -1) {
          localReportInfo1.uint32_strategy_id.set(localReportInfo.mStrategyId);
        }
        localReportInfo1.enum_op_source.set(3);
        localReportInfo1.uint32_folder_status.set(localReportInfo.mFolderStatus);
        localReportInfo1.enum_operation.set(localReportInfo.mOperation);
        localReportInfo1.bytes_device_id.set(ByteStringMicro.copyFromUtf8(ReadInJoyUtils.h()));
        localArrayList.add(localReportInfo1);
      }
    }
    localReqBody.rpt_report_info.set(localArrayList);
    return ReadInJoyOidbHelper.a("OidbSvc.0x64e", 1614, 0, localReqBody.toByteArray());
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label194;
      }
      paramFromServiceMsg = null;
      if (paramObject == null) {}
    }
    else
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (Exception paramFromServiceMsg)
      {
        label71:
        paramToServiceMsg = null;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramToServiceMsg == null) {
        break label233;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramFromServiceMsg)
    {
      break label96;
      break label71;
    }
    if (i == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer success");
      }
    }
    label96:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer merge fail ", paramFromServiceMsg);
          }
          continue;
          paramToServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel())
          {
            QLog.d("UserOperationModule", 2, " handleSetKandianTopToServer data == null");
            paramToServiceMsg = paramFromServiceMsg;
          }
        }
      } while (!QLog.isColorLevel());
      paramFromServiceMsg = new StringBuilder().append("handleSetKandianTopToServer failed ");
      if (paramToServiceMsg != null) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error_msg.get();; paramToServiceMsg = "null")
      {
        QLog.d("UserOperationModule", 2, paramToServiceMsg);
        return;
      }
    }
    label194:
    QLog.d("UserOperationModule", 2, "handleSetKandianTopToServer " + i);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if (paramToServiceMsg.extraData.getBoolean("reqFromReadinjoyHandler"))
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label400;
      }
      paramFromServiceMsg = null;
      if (paramObject == null) {}
    }
    else
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (Exception paramFromServiceMsg)
      {
        label71:
        paramToServiceMsg = null;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      if (paramToServiceMsg == null) {
        break label439;
      }
      i = paramToServiceMsg.uint32_result.get();
    }
    catch (Exception paramFromServiceMsg)
    {
      break label276;
      break label71;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer success");
      }
      paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      l = paramToServiceMsg.getInt();
      paramToServiceMsg.get();
      i = paramToServiceMsg.getShort();
      j = paramToServiceMsg.getShort();
      k = paramToServiceMsg.getShort();
      m = paramToServiceMsg.getShort();
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer, request success, tlvCount = " + i + " uin:" + l + " type:" + j + " length:" + k + " value:" + m);
      }
      paramToServiceMsg = (KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(161);
      if (m == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer server no set,upload local ");
        }
        bool = paramToServiceMsg.c();
        if (bool) {
          paramToServiceMsg.c(bool);
        }
      }
    }
    label276:
    while (!QLog.isColorLevel())
    {
      do
      {
        int m;
        do
        {
          for (;;)
          {
            long l;
            int j;
            int k;
            boolean bool;
            return;
            if (QLog.isColorLevel()) {
              QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer merge fail ", paramFromServiceMsg);
            }
            continue;
            paramToServiceMsg = paramFromServiceMsg;
            if (QLog.isColorLevel())
            {
              QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer data == null");
              paramToServiceMsg = paramFromServiceMsg;
            }
          }
          if (m == 1)
          {
            paramToServiceMsg.a(false, true);
            return;
          }
        } while (m != 2);
        paramToServiceMsg.a(true, true);
        return;
      } while (!QLog.isColorLevel());
      paramFromServiceMsg = new StringBuilder().append("handleGetKandianTopFromServer failed ");
      if (paramToServiceMsg != null) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error_msg.get();; paramToServiceMsg = "null")
      {
        QLog.d("UserOperationModule", 2, paramToServiceMsg);
        return;
      }
    }
    label400:
    QLog.d("UserOperationModule", 2, "handleGetKandianTopFromServer " + i);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0x80a.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0) {
      if (!paramToServiceMsg.uint64_uin.has()) {
        break label491;
      }
    }
    label491:
    for (long l1 = paramToServiceMsg.uint64_uin.get();; l1 = 0L)
    {
      if ((paramToServiceMsg.rsp_kd_event_report_resp.has()) && (paramToServiceMsg.rsp_kd_event_report_resp.get() != null))
      {
        if (((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).condParams.has()) {
          SPEventReportSwitch.a(((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).condParams.get());
        }
        if (QLog.isColorLevel()) {
          QLog.d("UserOperationModule", 2, "handle0x80aPushEffectEvent, uin:" + l1 + ";rspKDEventReportResp.result:" + ((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).result.get() + ";rspKDEventReportResp.err_msg" + ((oidb_cmd0x80a.KDEventReportResp)paramToServiceMsg.rsp_kd_event_report_resp.get()).err_msg.get());
        }
      }
      if ((paramToServiceMsg.AIOPulseMaxCnt.has()) && (paramToServiceMsg.firstScnRedPntPulseMaxCnt.has()) && (paramToServiceMsg.leftBtmRedPntPulseMaxCnt.has()))
      {
        l1 = paramToServiceMsg.leftBtmRedPntPulseMaxCnt.get();
        long l2 = paramToServiceMsg.firstScnRedPntPulseMaxCnt.get();
        long l3 = paramToServiceMsg.AIOPulseMaxCnt.get();
        ReadInJoyHelper.a(ReadInJoyUtils.a(), l1, l2, l3);
      }
      if ((paramToServiceMsg.lastRecvMsgDuration.has()) && (paramToServiceMsg.lastSendMsgDuration.has())) {
        ReadInJoyHelper.a((int)paramToServiceMsg.lastRecvMsgDuration.get(), (int)paramToServiceMsg.lastSendMsgDuration.get());
      }
      if ((paramToServiceMsg.pulseTimerDuration.has()) && (paramToServiceMsg.pulseTimerDuration.get() != 12345678L)) {
        ReadinjoySPEventReport.a().b((int)paramToServiceMsg.pulseTimerDuration.get());
      }
      if (paramToServiceMsg.leftBtmRedCntMaxForExitAIO.has()) {
        ReadInJoyHelper.a((int)paramToServiceMsg.leftBtmRedCntMaxForExitAIO.get());
      }
      if ((paramToServiceMsg.uint64_main_video_tab_red.has()) && (paramToServiceMsg.uint64_main_video_tab_red.get() > 0L)) {
        ((KandianMergeManager)ReadInJoyUtils.a().getManager(161)).a(new KandianRedDotInfo("kandian_video_tab_reddot_info"));
      }
      if (paramToServiceMsg.uint64_scroll_interval_time.has()) {
        com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ScrollReportUtil.jdField_a_of_type_Long = paramToServiceMsg.uint64_scroll_interval_time.get();
      }
      if (paramToServiceMsg.uint64_scroll_all_time.has()) {
        com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ScrollReportUtil.jdField_b_of_type_Long = paramToServiceMsg.uint64_scroll_all_time.get();
      }
      if (paramToServiceMsg.uint64_chat_aio_time.has()) {
        ReadinjoySPEventReport.jdField_b_of_type_Long = paramToServiceMsg.uint64_chat_aio_time.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d("UserOperationModule", 2, "handle0x80aPushEffectEvent, result=" + i);
      }
      return;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x64e.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "handleUserOperationReport, result=" + i);
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "handle0x886UserOperationReport, result=" + i);
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, VideoAdInfo paramVideoAdInfo, Bundle paramBundle)
  {
    Object localObject = PublicAccountAdUtil.a();
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      oidb_cmd0x886.AdInfo localAdInfo = paramVideoAdInfo.a(paramInt, paramBundle);
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      String str = MD5Utils.d(l1 + paramVideoAdInfo.h + paramInt + l2);
      oidb_cmd0x886.ReqBody localReqBody = new oidb_cmd0x886.ReqBody();
      localReqBody.uint64_uin.set(l1);
      localReqBody.msg_phone_info.set((MessageMicro)localObject);
      localReqBody.msg_ad_info.set(localAdInfo);
      localReqBody.uint64_client_time.set(l2);
      localReqBody.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.enum_ad_display.set(3);
      a(ReadInJoyOidbHelper.a("OidbSvc.0x886", 2182, 0, localReqBody.toByteArray()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("VideoAdReport(");
        ((StringBuilder)localObject).append(paramInt).append(",").append(paramVideoAdInfo.g).append("):");
        ((StringBuilder)localObject).append("client_time=").append(l2).append(", uuid=").append(str).append(", adInfo=").append(paramVideoAdInfo.toString()).append("\n");
        if (paramBundle != null) {
          ((StringBuilder)localObject).append("videoPlayInfo=").append(paramBundle.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("UserOperationModule", 2, ((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
        localException.printStackTrace();
      }
    }
  }
  
  public void a(int paramInt, String paramString, List paramList)
  {
    oidb_cmd0x80a.ReqBody localReqBody = new oidb_cmd0x80a.ReqBody();
    long l = Long.valueOf(ReadInJoyUtils.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.uint32_app_bitmap.set(1);
    if (ReadInJoyHelper.g()) {
      localReqBody.uint32_kandian_mode.set(3);
    }
    for (;;)
    {
      oidb_cmd0x80a.KDEventReportReq localKDEventReportReq = new oidb_cmd0x80a.KDEventReportReq();
      if (paramInt != -1) {
        localKDEventReportReq.event_id.set(paramInt);
      }
      if (!TextUtils.isEmpty(paramString)) {
        localKDEventReportReq.event_name.set(paramString);
      }
      if ((paramList != null) && (!paramList.isEmpty())) {
        localKDEventReportReq.att_list.set(paramList);
      }
      localReqBody.req_kd_event_report_req.set(localKDEventReportReq);
      a(ReadInJoyOidbHelper.a("OidbSvc.0x80a", 2058, 0, localReqBody.toByteArray()));
      return;
      if (ReadInJoyHelper.f()) {
        localReqBody.uint32_kandian_mode.set(2);
      } else {
        localReqBody.uint32_kandian_mode.set(1);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x64e")) {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x80a"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x480_9"))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x4ff_9"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886"))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x978"));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserOperationModule", 2, "getKandianTopFromServer begin...");
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[9];
      PkgTools.a(paramString, 0, l);
      paramString[4] = 0;
      PkgTools.a(paramString, 5, (short)1);
      PkgTools.a(paramString, 7, jdField_a_of_type_Int);
      paramString = ReadInJoyOidbHelper.a("OidbSvc.0x480_9", 1152, 9, paramString);
      paramString.extraData.putBoolean("reqFromReadinjoyHandler", true);
      a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("UserOperationModule", 2, "send_oidb_0x480_9 error", paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UserOperationModule", 2, "setKandianTopToServer value=" + paramInt);
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new byte[13];
      PkgTools.a(paramString, 0, l);
      paramString[4] = 0;
      PkgTools.a(paramString, 5, (short)1);
      PkgTools.a(paramString, 7, jdField_a_of_type_Int);
      PkgTools.a(paramString, 9, (short)2);
      PkgTools.a(paramString, 11, (short)paramInt);
      paramString = ReadInJoyOidbHelper.a("OidbSvc.0x4ff_9", 1279, 9, paramString);
      paramString.extraData.putBoolean("reqFromReadinjoyHandler", true);
      a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("UserOperationModule", 2, "setKandianTopToServer ex", paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, UserOperationModule.Ox978RespCallBack paramOx978RespCallBack)
  {
    a(paramString1, paramString2, paramBoolean, paramOx978RespCallBack, 2);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, UserOperationModule.Ox978RespCallBack paramOx978RespCallBack, int paramInt)
  {
    Object localObject2 = new oidb_cmd0x978.OneFollowOperationInfo();
    ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint64_dst_uin.set(Long.valueOf(paramString2).longValue());
    ((oidb_cmd0x978.OneFollowOperationInfo)localObject2).uint32_op_account_type.set(paramInt);
    Object localObject1 = new oidb_cmd0x978.ReqFollowOperationPara();
    PBEnumField localPBEnumField = ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).op_type;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 2)
    {
      localPBEnumField.set(paramInt);
      ((oidb_cmd0x978.ReqFollowOperationPara)localObject1).rpt_follow_operation_info.add((MessageMicro)localObject2);
      localObject2 = new oidb_cmd0x978.ReqBody();
      ((oidb_cmd0x978.ReqBody)localObject2).uint64_uin.set(Long.valueOf(paramString1).longValue());
      ((oidb_cmd0x978.ReqBody)localObject2).msg_req_follow_para.set((MessageMicro)localObject1);
      localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0x978", 2424, 0, ((oidb_cmd0x978.ReqBody)localObject2).toByteArray());
      paramInt = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, new WeakReference(paramOx978RespCallBack));
      ((ToServiceMsg)localObject1).addAttribute("distUin", paramString2);
      ((ToServiceMsg)localObject1).addAttribute("callbackSeq", Integer.valueOf(paramInt));
      ((ToServiceMsg)localObject1).addAttribute("selfUin", paramString1);
      a((ToServiceMsg)localObject1);
      return;
    }
  }
  
  public void a(List paramList)
  {
    a(a(paramList));
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("callbackSeq")).intValue();
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("distUin");
    UserOperationModule.Ox978RespCallBack localOx978RespCallBack = (UserOperationModule.Ox978RespCallBack)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(i)).get();
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
    oidb_cmd0x978.RspBody localRspBody = new oidb_cmd0x978.RspBody();
    i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    QLog.d("UserOperationModule", 2, "handle 978resp  retCode : " + i);
    if (localOx978RespCallBack == null) {}
    do
    {
      do
      {
        return;
        if (i != 0) {
          break;
        }
      } while (!localRspBody.msg_rsp_follow_op_result.has());
      paramFromServiceMsg = (oidb_cmd0x978.RspFollowOperationResult)localRspBody.msg_rsp_follow_op_result.get();
    } while (!paramFromServiceMsg.rpt_follow_operation_result.has());
    paramFromServiceMsg = paramFromServiceMsg.rpt_follow_operation_result.get().iterator();
    while (paramFromServiceMsg.hasNext())
    {
      paramObject = (oidb_cmd0x978.OneFollowOperationResult)paramFromServiceMsg.next();
      if (TextUtils.equals(String.valueOf(paramObject.uint64_dst_uin.get()), paramToServiceMsg))
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new lsb(this, localOx978RespCallBack, paramToServiceMsg, paramObject));
        return;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new lsc(this, localOx978RespCallBack, paramToServiceMsg, i));
  }
  
  public void b(List paramList)
  {
    a(b(paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule
 * JD-Core Version:    0.7.0.1
 */