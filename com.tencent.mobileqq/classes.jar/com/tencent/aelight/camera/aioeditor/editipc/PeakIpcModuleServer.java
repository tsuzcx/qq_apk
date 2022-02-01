package com.tencent.aelight.camera.aioeditor.editipc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicUploadPro;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.api.IShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.ITransProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.UUID;

public class PeakIpcModuleServer
  extends QIPCModule
{
  private static PeakIpcModuleServer a;
  
  private PeakIpcModuleServer(String paramString)
  {
    super(paramString);
  }
  
  public static PeakIpcModuleServer a()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new PeakIpcModuleServer("PeakIpcModuleServer");
          }
        }
        finally {}
      }
      PeakIpcModuleServer localPeakIpcModuleServer = a;
      return localPeakIpcModuleServer;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uploadVideo---videoFilePath=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", callbackClientName=");
    ((StringBuilder)localObject).append(paramString2);
    AEQLog.b("PeakIpcModuleServer", ((StringBuilder)localObject).toString());
    localObject = (ITransFileController)CaptureContext.a().getRuntimeService(ITransFileController.class, "");
    paramString2 = new PeakIpcModuleServer.4(this, (ITransFileController)localObject, paramString2);
    paramString2.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    ((ITransFileController)localObject).addHandle(paramString2);
    paramString2 = new TransferRequest();
    paramString2.mIsUp = true;
    paramString2.mLocalPath = paramString1;
    paramString2.mFileType = 24;
    paramString2.mCommandId = 82;
    paramString2.mRichTag = "ae_camera_ark_video_upload_statistic_tag";
    paramString2.mPeerUin = "0";
    paramString2.mSelfUin = CaptureContext.a().getCurrentAccountUin();
    paramString1 = new Bdh_extinfo.CommFileExtReq();
    paramString1.uint32_action_type.set(0);
    PBBytesField localPBBytesField = paramString1.bytes_uuid;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UUID.randomUUID().toString());
    localStringBuilder.append(".mp4");
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(localStringBuilder.toString()));
    paramString2.mExtentionInfo = paramString1.toByteArray();
    ((ITransFileController)localObject).transferAsync(paramString2);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[onCall]action= ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PeakIpcModuleServer", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localObject2 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakIpcModuleServer", 2, "[onCall] get app failed.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    boolean bool4 = "action_start_send".equals(paramString);
    Object localObject1 = "";
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool2 = true;
    Object localObject3;
    int i;
    if (bool4)
    {
      paramString = (Intent)paramBundle.getParcelable("key_intent");
      if (paramString != null)
      {
        paramBundle = (QQAppInterface)localObject2;
        localObject2 = paramString.getStringExtra("thumbfile_send_path");
        localObject3 = paramString.getStringExtra("thumbfile_md5");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
          ThreadManager.post(new PeakIpcModuleServer.1(this, (String)localObject3, (String)localObject2), 5, null, false);
        }
        localObject2 = SVBusiUtil.a(3, 0);
        localObject3 = ShortVideoBusiManager.a(0, paramString, (ShortVideoReq)localObject2);
        ((ShortVideoForwardInfo)localObject3).d = true;
        ((ShortVideoReq)localObject2).a((ShortVideoForwardInfo)localObject3);
        ShortVideoBusiManager.a((ShortVideoReq)localObject2, paramBundle);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("sendVideo intent= ");
        if (paramString != null) {
          localObject1 = paramString.getExtras();
        }
        paramBundle.append(localObject1);
        QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
      }
      if (paramString != null) {
        bool1 = true;
      }
      localBundle.putBoolean("key_result", bool1);
      paramString = EIPCResult.createSuccessResult(localBundle);
    }
    else
    {
      long l1;
      label462:
      Object localObject4;
      if ("action_cancel_send".equals(paramString))
      {
        localObject1 = paramBundle.getString("uin");
        i = paramBundle.getInt("uintype");
        long l2 = paramBundle.getLong("key_uinsequence");
        paramBundle = (QQAppInterface)localObject2;
        localObject2 = paramBundle.getMessageFacade().a((String)localObject1, i, l2);
        paramString = ((ITransFileController)paramBundle.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject1, l2);
        if (localObject2 != null) {
          l1 = ((MessageRecord)localObject2).uniseq;
        } else {
          l1 = -1L;
        }
        if (((paramString instanceof IShortVideoForwardProcessor)) && (!((IShortVideoForwardProcessor)paramString).isUpLoadSuccess())) {
          ((ITransProcessor)paramString).pause();
        }
        for (paramString = "forwardVideo";; paramString = "C2CPic")
        {
          bool1 = true;
          break label462;
          if ((!(paramString instanceof IPicTransFile.IPicUploadPro)) || (((IPicTransFile.IPicUploadPro)paramString).isUploadSuccess())) {
            break;
          }
          ((BaseUploadProcessor)paramString).pause();
        }
        paramString = "";
        bool1 = false;
        if (bool1)
        {
          localObject3 = (ITransFileController)paramBundle.getRuntimeService(ITransFileController.class);
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject1);
          ((StringBuilder)localObject4).append(l2);
          bool3 = ((ITransFileController)localObject3).removeProcessor(((StringBuilder)localObject4).toString());
          ((IOrderMediaMsgService)paramBundle.getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq((String)localObject1, l2);
          bool2 = bool3;
          if (localObject2 != null)
          {
            ThreadManager.post(new PeakIpcModuleServer.2(this, paramBundle, (MessageRecord)localObject2), 8, null, true);
            bool2 = bool3;
          }
        }
        else
        {
          bool2 = false;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("cancelInfo, uinseq:");
          paramBundle.append((String)localObject1);
          paramBundle.append(", uinType:");
          paramBundle.append(i);
          paramBundle.append(", sequence:");
          paramBundle.append(l2);
          paramBundle.append(", msgSequence");
          paramBundle.append(l1);
          paramBundle.append(", cancel:");
          paramBundle.append(bool1);
          paramBundle.append(", removeProcess:");
          paramBundle.append(bool2);
          paramBundle.append(", tips:");
          paramBundle.append(paramString);
          QLog.i("PeakIpcModuleServer", 2, paramBundle.toString());
        }
        localBundle.putBoolean("key_result", bool1);
        paramString = EIPCResult.createSuccessResult(localBundle);
      }
      else
      {
        if (!"action_pic_start_send".equals(paramString)) {
          break label941;
        }
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramString = paramBundle.getString("key_file_path");
        localObject1 = (SessionInfo)paramBundle.getParcelable("key_session");
        localObject3 = paramBundle.getString("widgetinfo", "");
        paramBundle = paramBundle.getString("key_camera_material_name", "");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject4 = new Intent();
          ((Intent)localObject4).putExtra("key_story_photo_to_recent", true);
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            ((Intent)localObject4).putExtra("widgetinfo", (String)localObject3);
            ((Intent)localObject4).putExtra("key_camera_material_name", paramBundle);
          }
          ForwardUtils.a((Intent)localObject4, (SessionInfo)localObject1, paramString, (QQAppInterface)localObject2);
          localBundle.putBoolean("key_result", true);
          bool1 = bool2;
        }
        else
        {
          localBundle.putBoolean("key_result", false);
          bool1 = false;
        }
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("sendPic success:");
          paramBundle.append(bool1);
          paramBundle.append(", photoPath：");
          paramBundle.append(paramString);
          QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
        }
        paramString = EIPCResult.createSuccessResult(localBundle);
      }
      for (;;)
      {
        break label2708;
        label941:
        if ("action_re_send".equals(paramString))
        {
          paramString = paramBundle.getString("uin");
          i = paramBundle.getInt("uintype");
          l1 = paramBundle.getLong("key_uinsequence");
          paramBundle = (QQAppInterface)localObject2;
          paramString = paramBundle.getMessageFacade().a(paramString, i, l1);
          if ((paramString instanceof MessageForShortVideo))
          {
            localObject2 = (MessageForShortVideo)paramString;
            if ((FileUtils.fileExistsAndNotEmpty(SVUtils.a(((MessageForShortVideo)localObject2).thumbMD5, "jpg"))) && (!TextUtils.isEmpty(((MessageForShortVideo)localObject2).videoFileName)) && (((MessageForShortVideo)localObject2).isStoryVideo))
            {
              ((IOrderMediaMsgService)paramBundle.getRuntimeService(IOrderMediaMsgService.class)).addOrderMsgStatus(((MessageForShortVideo)localObject2).frienduin, (MessageRecord)localObject2, ((MessageForShortVideo)localObject2).videoFileName);
              localObject2 = SVBusiUtil.a(4, 0);
              localObject3 = ShortVideoBusiManager.a(0, paramString, (ShortVideoReq)localObject2);
              ((ShortVideoForwardInfo)localObject3).d = true;
              ((ShortVideoReq)localObject2).a((ShortVideoForwardInfo)localObject3);
              ShortVideoBusiManager.a((ShortVideoReq)localObject2, paramBundle);
            }
            else
            {
              ((MessageForShortVideo)localObject2).videoFileStatus = 1005;
              break label1469;
            }
          }
          else
          {
            if (!(paramString instanceof MessageForPic)) {
              break label1469;
            }
            localObject2 = (MessageForPic)paramString;
            if ((!FileUtils.fileExistsAndNotEmpty(((MessageForPic)localObject2).path)) || (!((MessageForPic)localObject2).isStoryPhoto)) {
              break label1469;
            }
            ThreadManager.post(new PeakIpcModuleServer.3(this, paramBundle, (MessageForPic)localObject2), 5, null, false);
            if (((MessageForPic)localObject2).isSendFromLocal()) {
              ((ITransFileController)paramBundle.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).uniseq));
            }
            localObject3 = new PicUploadInfo.Builder();
            ((PicUploadInfo.Builder)localObject3).a(((MessageForPic)localObject2).path);
            ((PicUploadInfo.Builder)localObject3).d(5);
            ((PicUploadInfo.Builder)localObject3).d(((MessageForPic)localObject2).frienduin);
            if (((MessageForPic)localObject2).fileSizeFlag == 1) {
              ((PicUploadInfo.Builder)localObject3).c(1);
            } else {
              ((PicUploadInfo.Builder)localObject3).c(0);
            }
            ((PicUploadInfo.Builder)localObject3).e(((MessageForPic)localObject2).senderuin);
            ((PicUploadInfo.Builder)localObject3).c(((MessageForPic)localObject2).selfuin);
            ((PicUploadInfo.Builder)localObject3).e(((MessageForPic)localObject2).istroop);
            ((PicUploadInfo.Builder)localObject3).l(((MessageForPic)localObject2).getConfessTopicId());
            ((PicUploadInfo.Builder)localObject3).jdField_i_of_type_Int = ((MessageForPic)localObject2).extLong;
            ((PicUploadInfo.Builder)localObject3).jdField_i_of_type_JavaLangString = ((MessageForPic)localObject2).extStr;
            ((PicUploadInfo.Builder)localObject3).a(true);
            localObject4 = new PicUploadInfo.RetryInfo();
            ((PicUploadInfo.RetryInfo)localObject4).a = ((MessageForPic)localObject2).msgseq;
            ((PicUploadInfo.RetryInfo)localObject4).b = ((MessageForPic)localObject2).shmsgseq;
            ((PicUploadInfo.RetryInfo)localObject4).c = ((MessageForPic)localObject2).msgUid;
            ((PicUploadInfo.Builder)localObject3).a((PicUploadInfo.RetryInfo)localObject4);
            ((PicUploadInfo.Builder)localObject3).b(((MessageForPic)localObject2).uniseq);
            ((IOrderMediaMsgService)paramBundle.getRuntimeService(IOrderMediaMsgService.class)).enqueueMediaMsgByUniseq(((MessageForPic)localObject2).frienduin, ((MessageForPic)localObject2).uniseq);
            paramBundle = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(4, 5);
            paramBundle.a(((PicUploadInfo.Builder)localObject3).a());
            paramBundle.a = ((MessageForPic)localObject2).picExtraData;
            ((IPicBus)QRoute.api(IPicBus.class)).launch(paramBundle);
          }
          bool1 = true;
          break label1472;
          label1469:
          bool1 = false;
          label1472:
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("reSend success:");
            paramBundle.append(bool1);
            paramBundle.append(", message：");
            if (paramString != null) {
              localObject1 = paramString.toString();
            }
            paramBundle.append((String)localObject1);
            QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
          }
          localBundle.putBoolean("key_result", bool1);
          paramString = EIPCResult.createSuccessResult(localBundle);
        }
        else if ("action_get_troop_member_name".equals(paramString))
        {
          paramString = paramBundle.getString("troop_uin");
          paramBundle = paramBundle.getString("uin");
          try
          {
            localObject2 = (TroopManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_MANAGER);
            paramString = ((TroopManager)localObject2).a(((TroopManager)localObject2).b(paramString), paramBundle);
            localObject1 = paramString;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel())
            {
              paramBundle = new StringBuilder();
              paramBundle.append("getTroopMemberName exception = ");
              paramBundle.append(paramString.getMessage());
              QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
            }
            paramString.printStackTrace();
          }
          localBundle.putBoolean("key_result", true);
          localBundle.putString("uinname", (String)localObject1);
          paramString = EIPCResult.createSuccessResult(localBundle);
        }
        else if ("action_get_troop_info".equals(paramString))
        {
          paramString = paramBundle.getString("troop_uin");
        }
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = (TroopManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_MANAGER);
        paramString = paramBundle.a(paramBundle.b(paramString), true);
        if (paramString == null) {
          break label2706;
        }
        localBundle.putBoolean("key_result", true);
        localBundle.putBoolean("troop_owner", paramString.isDisband());
        if ((!paramString.isNewTroop()) || (paramString.hasSetTroopHead())) {
          break label2716;
        }
        bool1 = bool3;
        localBundle.putBoolean("troop_code", bool1);
        paramString = EIPCResult.createSuccessResult(localBundle);
        return paramString;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("ACTION_GET_TROOP_INFO exception = ");
          paramBundle.append(paramString.getMessage());
          QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
        }
        paramString.printStackTrace();
      }
      if ("action_get_name".equals(paramString))
      {
        paramString = paramBundle.getString("uin");
        try
        {
          paramString = ContactUtils.a((QQAppInterface)localObject2, paramString);
          localBundle.putBoolean("key_result", true);
          localBundle.putString("uinname", paramString);
          paramString = EIPCResult.createSuccessResult(localBundle);
          return paramString;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("ACTION_GET_NAME exception = ");
            paramBundle.append(paramString.getMessage());
            QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
          }
          paramString.printStackTrace();
        }
      }
      else if ("action_send_video_ark_msg".equals(paramString))
      {
        try
        {
          paramBundle.setClassLoader(SessionInfo.class.getClassLoader());
          paramString = (SessionInfo)paramBundle.getParcelable("key_session");
          localObject1 = paramBundle.getString("key_ark_msg_app_view");
          paramBundle = paramBundle.getString("key_ark_msg_meta_json");
          localObject3 = new ArkAppMessage();
          ((ArkAppMessage)localObject3).promptText = "promptTest";
          ((ArkAppMessage)localObject3).appMinVersion = "1.0.0.29";
          ((ArkAppMessage)localObject3).appName = "com.tencent.subscription";
          ((ArkAppMessage)localObject3).appView = ((String)localObject1);
          ((ArkAppMessage)localObject3).metaList = paramBundle;
          ChatActivityFacade.b((QQAppInterface)localObject2, paramString, (ArkAppMessage)localObject3);
          paramString = EIPCResult.createSuccessResult(localBundle);
          return paramString;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("ACTION_SEND_VIDEO_ARK_MSG exception = ");
            paramBundle.append(paramString.getMessage());
            QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
          }
          paramString.printStackTrace();
        }
      }
      else if ("action_upload_ark_video".equals(paramString))
      {
        try
        {
          a(paramBundle.getString("key_upload_ark_video_path"), paramBundle.getString("key_upload_ark_video_callback_client_name"));
          paramString = EIPCResult.createSuccessResult(localBundle);
          return paramString;
        }
        catch (Exception paramString)
        {
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("ACTION_SEND_VIDEO_ARK_MSG exception = ");
            paramBundle.append(paramString.getMessage());
            QLog.d("PeakIpcModuleServer", 2, paramBundle.toString());
          }
          paramString.printStackTrace();
        }
      }
      else if ("action_qcircle_report".equals(paramString))
      {
        paramString = paramBundle.getString("qcircle_client_traceid");
        QLog.d("[QcirclePublish]PeakIpcModuleServer", 1, new Object[] { "onCall... clientTraceId:", paramString, " action:E_PICKER_ENTER" });
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).E_PICKER_ENTER(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).TRACEID(), paramString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT2(), "nolongvideomode"), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
      }
      else if ("action_qcircle_picker_ready".equals(paramString))
      {
        paramString = paramBundle.getString("qcircle_client_traceid");
        QLog.d("[QcirclePublish]PeakIpcModuleServer", 1, new Object[] { "onCall... clientTraceId:", paramString, " action:ACTION_QCIRCLE_PICKER_READY" });
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).E_PICKER_READY(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).TRACEID(), paramString), ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).KEY_RET_CODE(), "0") }));
      }
      else if ("action_qcircle_picker_expose".equals(paramString))
      {
        i = paramBundle.getInt("QCIRCLE_PHOTOLIST_FIRST_ACTION");
        paramString = new StringBuilder();
        paramString.append("actiontype:");
        paramString.append(i);
        paramString.append(",subActionType:");
        paramString.append(1);
        paramString.append(",thrActionType:");
        paramString.append(1);
        paramString.append(",report to dc05504");
        paramString = paramString.toString();
        QLog.d("[QcirclePublish]PeakIpcModuleServer", 1, paramString);
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", i, 1, 1);
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportPublishQuality(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).E_PICKER_EXPOSE(), Arrays.asList(new FeedCloudCommon.Entry[] { ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).newEntry(((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).EXT1(), paramString) }));
      }
      label2706:
      paramString = null;
      label2708:
      callbackResult(paramInt, paramString);
      return null;
      label2716:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcModuleServer
 * JD-Core Version:    0.7.0.1
 */