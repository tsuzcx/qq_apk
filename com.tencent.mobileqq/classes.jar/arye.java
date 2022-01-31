import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;

public class arye
{
  private static final String jdField_a_of_type_JavaLangString = alpo.a(2131719913);
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AbsStructMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
  private String b;
  
  private void a(Bundle paramBundle, String paramString1, String paramString2, long paramLong)
  {
    paramString1 = arzk.a(paramBundle, paramString1, paramString2, null);
    arzk.a((OpenSdkShareModel)this.jdField_a_of_type_AndroidAppActivity.getIntent().getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"), paramBundle, paramString1);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage send runtime = null ");
      a(new Object[] { Integer.valueOf(0), "", jdField_a_of_type_JavaLangString, "" }, -1);
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.jdField_a_of_type_Long);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage sendOIDBRequest");
    arzy.a("KEY_STAGE_2_NORMAL_B77");
    mzy.a(paramString2, new aryg(this, paramLong, paramBundle), paramString1.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, localBundle, 0L);
  }
  
  private void a(awfz paramawfz, long paramLong)
  {
    String str;
    Object localObject;
    if (System.currentTimeMillis() - paramLong > 10000L)
    {
      bool = true;
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      HashMap localHashMap = new HashMap();
      if (!bool) {
        break label145;
      }
      localObject = "1";
      label44:
      localHashMap.put("param_time_out", localObject);
      if (str != null) {
        break label152;
      }
      localObject = "";
      label63:
      arzy.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramawfz));
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "handleSendResult timeout=", Boolean.valueOf(bool) });
      if (!bool) {
        break label159;
      }
      a(new Object[] { Integer.valueOf(0), "", alpo.a(2131705173), "" }, -1);
    }
    label145:
    label152:
    label159:
    do
    {
      return;
      bool = false;
      break;
      localObject = "0";
      break label44;
      localObject = str;
      break label63;
      i = paramawfz.jdField_a_of_type_Int;
      localObject = (String[])paramawfz.jdField_a_of_type_JavaLangObject;
      if (i == 0)
      {
        if ((localObject != null) && (localObject.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardSDKB77Sender", 1, "UpCallBack onSend urls=" + localObject[0] + " ," + localObject[1]);
          a(this.jdField_a_of_type_AndroidOsBundle, localObject[0], localObject[1], paramLong);
          return;
        }
        QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramawfz.b;
    boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "UpCallBack onSend failed errCode=", i + ", hasSDPermission=", Boolean.valueOf(bool) });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "UpCallBack onSend failed urls=", localObject[0], " ,", localObject[1] });
      a(this.jdField_a_of_type_AndroidOsBundle, localObject[0], localObject[1], paramLong);
      return;
    }
    a(new Object[] { Integer.valueOf(0), "", jdField_a_of_type_JavaLangString, "" }, -1);
  }
  
  private void a(AbsStructMsg paramAbsStructMsg)
  {
    String str1 = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str2 = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    arzy.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    long l = System.currentTimeMillis();
    AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, (AbsShareMsg)paramAbsStructMsg, str1, i, str2, new aryf(this, l));
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg null");
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      SessionInfo localSessionInfo = ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle);
      nav.a().a = true;
      acex.b(localQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localSessionInfo, paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg exception", paramString);
    }
  }
  
  private void a(Object[] paramArrayOfObject, int paramInt)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyAIOActivity result[0]=", paramArrayOfObject[0], ", result[1]=", paramArrayOfObject[1], ", result[2]=", paramArrayOfObject[2], ", result[3]=", paramArrayOfObject[3], ", errorCode=", Integer.valueOf(paramInt) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_b77_jump_result", paramArrayOfObject[0]);
    localHashMap.put("key_b77_jump_url", paramArrayOfObject[1]);
    localHashMap.put("key_b77_wording", paramArrayOfObject[2]);
    localHashMap.put("key_b77_develop_msg", paramArrayOfObject[3]);
    localHashMap.put("key_b77_error_code", Integer.valueOf(paramInt));
    paramArrayOfObject = new Intent("action_notify_aio_activity_by_b77");
    paramArrayOfObject.putExtra("key_b77_error_code", paramInt);
    BaseApplication.getContext().sendBroadcast(paramArrayOfObject);
    ((arzd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a(this.b, localHashMap);
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsStructMsg paramAbsStructMsg, Activity paramActivity, Bundle paramBundle, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = paramAbsStructMsg;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if (paramAbsStructMsg == null)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "requestShareMessage error structMsg = null");
      return;
    }
    if (!bdee.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      a(new Object[] { Integer.valueOf(0), "", alpo.a(2131705174), "" }, -1);
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, " requestShareMessage net error");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { " forwardShare structMsg=", paramAbsStructMsg.getXml(), ", key=", paramString });
    paramActivity = ForwardUtils.c(this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"));
    paramBundle = ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
    if ((paramAbsStructMsg instanceof AbsShareMsg)) {}
    for (paramQQAppInterface = ((AbsShareMsg)paramAbsStructMsg).mContentTitle;; paramQQAppInterface = "")
    {
      azmj.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, "", paramActivity, paramBundle, paramQQAppInterface);
      a(paramAbsStructMsg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arye
 * JD-Core Version:    0.7.0.1
 */