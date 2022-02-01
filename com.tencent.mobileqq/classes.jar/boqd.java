import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import eipc.EIPCResult;
import eipc.EIPCServer;

public class boqd
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
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString);
    paramString = QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_name", localBundle);
    if ((paramString != null) && (paramString.isSuccess()) && (paramString.data != null))
    {
      paramString = paramString.data.getString("uinname");
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "getFriendName success name = " + paramString);
      }
      return paramString;
    }
    return null;
  }
  
  public static void a(bpfr parambpfr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PeakIpcController", 2, "cancelSendVideoOrPhoto uinseq:" + parambpfr.jdField_a_of_type_Long);
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", parambpfr.jdField_a_of_type_Long);
    localBundle.putString("uin", parambpfr.jdField_a_of_type_JavaLangString);
    localBundle.putInt("uintype", parambpfr.jdField_a_of_type_Int);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_cancel_send", localBundle, new boqf(parambpfr));
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
    }
    for (;;)
    {
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
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "client result:" + bool1);
      }
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        localBundle.putString("key_file_md5", ((MessageForPic)paramMessageRecord).md5);
      }
    }
  }
  
  public static void a(String paramString1, bpfr parambpfr, String paramString2, String paramString3)
  {
    if (parambpfr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "sendPhoto editVideoInfo is null");
      }
      return;
    }
    parambpfr.jdField_a_of_type_Long = 0L;
    Object localObject = HexUtil.bytes2HexStr(auea.e(paramString1));
    if (localObject == null)
    {
      QLog.e("PeakIpcController", 1, "sendPic file md5 fail!");
      return;
    }
    parambpfr.g = ((String)localObject);
    localObject = new SessionInfo();
    ((SessionInfo)localObject).curFriendUin = parambpfr.jdField_a_of_type_JavaLangString;
    ((SessionInfo)localObject).curType = parambpfr.jdField_a_of_type_Int;
    ((SessionInfo)localObject).troopUin = parambpfr.b;
    parambpfr = new Bundle();
    parambpfr.putParcelable("key_session", (Parcelable)localObject);
    parambpfr.putString("key_file_path", paramString1);
    parambpfr.putString("widgetinfo", paramString2);
    parambpfr.putString("key_camera_material_name", paramString3);
    bnrh.b("PeakIpcController", "sendPhoto---takeSameName=" + paramString3);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_pic_start_send", parambpfr, new boqg());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putString("uin", paramString2);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_troop_member_name", localBundle, new boqi(paramString2));
  }
  
  public static void a(String paramString1, String paramString2, bpfr parambpfr, String paramString3, String paramString4)
  {
    bnrh.b("PeakIpcController", "sendVideo---takeSameName=" + paramString4);
    parambpfr.jdField_a_of_type_Long = 0L;
    paramString1 = bove.a(paramString1, paramString2, parambpfr, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putParcelable("key_intent", paramString1);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_start_send", paramString2, new boqe());
  }
  
  public static void b(bpfr parambpfr)
  {
    if (parambpfr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "reSendMessage editVideoInfo is null");
      }
      return;
    }
    if (parambpfr.jdField_a_of_type_Long <= 0L)
    {
      QLog.e("PeakIpcController", 1, "reSendMessage error!");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", parambpfr.jdField_a_of_type_Long);
    localBundle.putString("uin", parambpfr.jdField_a_of_type_JavaLangString);
    localBundle.putInt("uintype", parambpfr.jdField_a_of_type_Int);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_re_send", localBundle, new boqh());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boqd
 * JD-Core Version:    0.7.0.1
 */