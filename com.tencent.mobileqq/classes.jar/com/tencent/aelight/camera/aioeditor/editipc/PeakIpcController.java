package com.tencent.aelight.camera.aioeditor.editipc;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.aelight.camera.aioeditor.takevideo.ShortVideoForwardManager;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelItemInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import eipc.EIPCClient;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.UUID;

public class PeakIpcController
{
  public static Pair<Boolean, Boolean> a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString);
    paramString = QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_troop_info", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null)) {
      return new Pair(Boolean.valueOf(paramString.data.getBoolean("troop_owner")), Boolean.valueOf(paramString.data.getBoolean("troop_code")));
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("uin", paramString);
    paramString = QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_name", (Bundle)localObject);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null))
    {
      paramString = paramString.data.getString("uinname");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getFriendName success name = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("PeakIpcController", 2, ((StringBuilder)localObject).toString());
      }
      return paramString;
    }
    return null;
  }
  
  public static void a(SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelSendVideoOrPhoto uinseq:");
      ((StringBuilder)localObject).append(paramSendPanelItemInfo.jdField_a_of_type_Long);
      QLog.i("PeakIpcController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_uinsequence", paramSendPanelItemInfo.jdField_a_of_type_Long);
    ((Bundle)localObject).putString("uin", paramSendPanelItemInfo.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putInt("uintype", paramSendPanelItemInfo.jdField_a_of_type_Int);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_cancel_send", (Bundle)localObject, new PeakIpcController.2(paramSendPanelItemInfo));
  }
  
  public static void a(SessionInfo paramSessionInfo, String paramString1, String paramString2)
  {
    AEQLog.b("PeakIpcController", "sendVideoArkMsg---");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_session", paramSessionInfo);
    localBundle.putString("key_ark_msg_app_view", paramString1);
    localBundle.putString("key_ark_msg_meta_json", paramString2);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_send_video_ark_msg", localBundle, new PeakIpcController.6());
  }
  
  public static void a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_status", paramInt1);
    localBundle.putInt("key_progress", paramInt2);
    localBundle.putLong("key_uinsequence", paramMessageRecord.uniseq);
    localBundle.putString("uin", paramMessageRecord.frienduin);
    localBundle.putInt("uintype", paramMessageRecord.istroop);
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      localBundle.putString("key_file_md5", ((MessageForShortVideo)paramMessageRecord).md5);
    } else if ((paramMessageRecord instanceof MessageForPic)) {
      localBundle.putString("key_file_md5", ((MessageForPic)paramMessageRecord).md5);
    }
    paramMessageRecord = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:peak", 1, "PeakIpcModuleClient", "action_update_status", localBundle);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (paramMessageRecord.data != null) {
        bool1 = paramMessageRecord.data.getBoolean("key_result");
      }
    }
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("client result:");
      paramMessageRecord.append(bool1);
      QLog.i("PeakIpcController", 2, paramMessageRecord.toString());
    }
  }
  
  public static void a(String paramString, PeakIpcController.IUploadArkVideoCallback paramIUploadArkVideoCallback)
  {
    AEQLog.b("PeakIpcController", "uploadArkVideo---");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive_progress_");
    ((StringBuilder)localObject).append(System.nanoTime());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(UUID.randomUUID().toString());
    localObject = ((StringBuilder)localObject).toString();
    QIPCClientHelper.getInstance().getClient().registerModule(new PeakIpcController.7((String)localObject, (String)localObject, paramIUploadArkVideoCallback));
    paramIUploadArkVideoCallback = new Bundle();
    paramIUploadArkVideoCallback.putString("key_upload_ark_video_path", paramString);
    paramIUploadArkVideoCallback.putString("key_upload_ark_video_callback_client_name", (String)localObject);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_upload_ark_video", paramIUploadArkVideoCallback, null);
  }
  
  public static void a(String paramString1, SendPanelItemInfo paramSendPanelItemInfo, String paramString2, String paramString3)
  {
    if (paramSendPanelItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "sendPhoto editVideoInfo is null");
      }
      return;
    }
    paramSendPanelItemInfo.jdField_a_of_type_Long = 0L;
    Object localObject = HexUtil.bytes2HexStr(FileManagerUtil.d(paramString1));
    if (localObject == null)
    {
      QLog.e("PeakIpcController", 1, "sendPic file md5 fail!");
      return;
    }
    paramSendPanelItemInfo.g = ((String)localObject);
    localObject = new SessionInfo();
    ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramSendPanelItemInfo.jdField_a_of_type_JavaLangString;
    ((SessionInfo)localObject).jdField_a_of_type_Int = paramSendPanelItemInfo.jdField_a_of_type_Int;
    ((SessionInfo)localObject).b = paramSendPanelItemInfo.b;
    paramSendPanelItemInfo = new Bundle();
    paramSendPanelItemInfo.putParcelable("key_session", (Parcelable)localObject);
    paramSendPanelItemInfo.putString("key_file_path", paramString1);
    paramSendPanelItemInfo.putString("widgetinfo", paramString2);
    paramSendPanelItemInfo.putString("key_camera_material_name", paramString3);
    paramString1 = new StringBuilder();
    paramString1.append("sendPhoto---takeSameName=");
    paramString1.append(paramString3);
    AEQLog.b("PeakIpcController", paramString1.toString());
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_pic_start_send", paramSendPanelItemInfo, new PeakIpcController.3());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("qcircle_client_traceid", paramString1);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", paramString2, localBundle);
  }
  
  public static void a(String paramString1, String paramString2, SendPanelItemInfo paramSendPanelItemInfo, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendVideo---takeSameName=");
    localStringBuilder.append(paramString4);
    AEQLog.b("PeakIpcController", localStringBuilder.toString());
    paramSendPanelItemInfo.jdField_a_of_type_Long = 0L;
    paramString1 = ShortVideoForwardManager.a(paramString1, paramString2, paramSendPanelItemInfo, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putParcelable("key_intent", paramString1);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_start_send", paramString2, new PeakIpcController.1());
  }
  
  public static void b(SendPanelItemInfo paramSendPanelItemInfo)
  {
    if (paramSendPanelItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "reSendMessage editVideoInfo is null");
      }
      return;
    }
    if (paramSendPanelItemInfo.jdField_a_of_type_Long <= 0L)
    {
      QLog.e("PeakIpcController", 1, "reSendMessage error!");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", paramSendPanelItemInfo.jdField_a_of_type_Long);
    localBundle.putString("uin", paramSendPanelItemInfo.jdField_a_of_type_JavaLangString);
    localBundle.putInt("uintype", paramSendPanelItemInfo.jdField_a_of_type_Int);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_re_send", localBundle, new PeakIpcController.4());
  }
  
  public static void b(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putString("uin", paramString2);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_troop_member_name", localBundle, new PeakIpcController.5(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.editipc.PeakIpcController
 * JD-Core Version:    0.7.0.1
 */