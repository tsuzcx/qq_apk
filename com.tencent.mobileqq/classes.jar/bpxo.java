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

public class bpxo
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
  
  public static void a(bqvl parambqvl)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PeakIpcController", 2, "cancelSendVideoOrPhoto uinseq:" + parambqvl.jdField_a_of_type_Long);
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", parambqvl.jdField_a_of_type_Long);
    localBundle.putString("uin", parambqvl.jdField_a_of_type_JavaLangString);
    localBundle.putInt("uintype", parambqvl.jdField_a_of_type_Int);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_cancel_send", localBundle, new bpxq(parambqvl));
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
  
  public static void a(String paramString1, bqvl parambqvl, String paramString2, String paramString3)
  {
    if (parambqvl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "sendPhoto editVideoInfo is null");
      }
      return;
    }
    parambqvl.jdField_a_of_type_Long = 0L;
    Object localObject = HexUtil.bytes2HexStr(aunj.e(paramString1));
    if (localObject == null)
    {
      QLog.e("PeakIpcController", 1, "sendPic file md5 fail!");
      return;
    }
    parambqvl.g = ((String)localObject);
    localObject = new SessionInfo();
    ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = parambqvl.jdField_a_of_type_JavaLangString;
    ((SessionInfo)localObject).jdField_a_of_type_Int = parambqvl.jdField_a_of_type_Int;
    ((SessionInfo)localObject).b = parambqvl.b;
    parambqvl = new Bundle();
    parambqvl.putParcelable("key_session", (Parcelable)localObject);
    parambqvl.putString("key_file_path", paramString1);
    parambqvl.putString("widgetinfo", paramString2);
    parambqvl.putString("key_camera_material_name", paramString3);
    bpam.b("PeakIpcController", "sendPhoto---takeSameName=" + paramString3);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_pic_start_send", parambqvl, new bpxr());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putString("uin", paramString2);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_get_troop_member_name", localBundle, new bpxt(paramString2));
  }
  
  public static void a(String paramString1, String paramString2, bqvl parambqvl, String paramString3, String paramString4)
  {
    bpam.b("PeakIpcController", "sendVideo---takeSameName=" + paramString4);
    parambqvl.jdField_a_of_type_Long = 0L;
    paramString1 = bqip.a(paramString1, paramString2, parambqvl, paramString3, paramString4);
    paramString2 = new Bundle();
    paramString2.putParcelable("key_intent", paramString1);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_start_send", paramString2, new bpxp());
  }
  
  public static void b(bqvl parambqvl)
  {
    if (parambqvl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PeakIpcController", 2, "reSendMessage editVideoInfo is null");
      }
      return;
    }
    if (parambqvl.jdField_a_of_type_Long <= 0L)
    {
      QLog.e("PeakIpcController", 1, "reSendMessage error!");
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_uinsequence", parambqvl.jdField_a_of_type_Long);
    localBundle.putString("uin", parambqvl.jdField_a_of_type_JavaLangString);
    localBundle.putInt("uintype", parambqvl.jdField_a_of_type_Int);
    QIPCClientHelper.getInstance().callServer("PeakIpcModuleServer", "action_re_send", localBundle, new bpxs());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpxo
 * JD-Core Version:    0.7.0.1
 */