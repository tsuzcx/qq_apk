import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.forward.ForwardSDKB77Sender.2;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.ShareData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;

public class avbe
{
  private static final String jdField_a_of_type_JavaLangString = anzj.a(2131718001);
  private long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForArkApp jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp;
  private OpenSdkShareModel jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel;
  private String b;
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("share_comment_message_for_server");
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (TextUtils.isEmpty(str)))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg null");
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      paramBundle = ForwardUtils.a(paramBundle);
      nlj.a().a = true;
      aean.b(localQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramBundle, str);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg exception", paramBundle);
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp == null) {}
    for (long l = 0L;; l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq)
    {
      paramString1 = avcj.a(paramBundle, paramString1, paramString2, null, l);
      avcj.a(this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel, paramBundle, paramString1);
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if (paramString2 != null) {
        break;
      }
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage send runtime = null ");
      a(new Object[] { Integer.valueOf(0), "", jdField_a_of_type_JavaLangString, "" }, -5);
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.jdField_a_of_type_Long);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage sendOIDBRequest");
    avcw.a("KEY_STAGE_2_NORMAL_B77");
    nkm.a(paramString2, new avbg(this, paramLong, paramBundle), paramString1.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, localBundle, 0L);
  }
  
  private void a(azrh paramazrh, Bundle paramBundle, long paramLong)
  {
    String str;
    Object localObject;
    if (System.currentTimeMillis() - paramLong > 10000L)
    {
      bool = true;
      str = paramBundle.getString("uin");
      HashMap localHashMap = new HashMap();
      if (!bool) {
        break label143;
      }
      localObject = "1";
      label41:
      localHashMap.put("param_time_out", localObject);
      if (str != null) {
        break label150;
      }
      localObject = "";
      label60:
      avcw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER", (String)localObject, localHashMap, ForwardUtils.a(paramazrh));
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "handleSendResult timeout=", Boolean.valueOf(bool) });
      if (!bool) {
        break label157;
      }
      a(new Object[] { Integer.valueOf(0), "", anzj.a(2131703688), "" }, -3);
    }
    label143:
    label150:
    label157:
    do
    {
      return;
      bool = false;
      break;
      localObject = "0";
      break label41;
      localObject = str;
      break label60;
      i = paramazrh.jdField_a_of_type_Int;
      localObject = (String[])paramazrh.jdField_a_of_type_JavaLangObject;
      if (i == 0)
      {
        if ((localObject != null) && (localObject.length == 2))
        {
          QLog.i("SDK_SHARE.ForwardSDKB77Sender", 1, "UpCallBack onSend urls=" + localObject[0] + ", " + localObject[1]);
          a(paramBundle, localObject[0], localObject[1], paramLong);
          return;
        }
        QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "onSend updateMsg error !");
        return;
      }
    } while (-1 != i);
    int i = paramazrh.b;
    boolean bool = ForwardUtils.a(this.jdField_a_of_type_AndroidContentContext);
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "UpCallBack onSend failed errCode=", i + ", hasSDPermission=", Boolean.valueOf(bool) });
    if ((i == 9402) && (!bool) && (localObject != null) && (localObject.length == 2))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "UpCallBack onSend failed urls=", localObject[0], " ,", localObject[1] });
      ThreadManager.getUIHandler().post(new ForwardSDKB77Sender.2(this));
      a(paramBundle, localObject[0], localObject[1], paramLong);
      return;
    }
    a(new Object[] { Integer.valueOf(0), "", jdField_a_of_type_JavaLangString, "" }, -4);
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, AbsShareMsg paramAbsShareMsg, Bundle paramBundle)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fake_key", this.b);
      localJSONObject.put("forward_type", paramAbsShareMsg.forwardType);
      localJSONObject.put("serviceType", paramAbsShareMsg.mMsgServiceID);
      localJSONObject.put("appId", paramAbsShareMsg.mSourceAppid);
      localJSONObject.put("pkg_name", paramAbsShareMsg.shareData.pkgName);
      localJSONObject.put("targetUrl", paramAbsShareMsg.mMsgUrl);
      localJSONObject.put("title", paramAbsShareMsg.mContentTitle);
      localJSONObject.put("summary", paramAbsShareMsg.mContentSummary);
      localJSONObject.put("image_url", paramAbsShareMsg.mContentCover);
      localJSONObject.put("audio_url", paramAbsShareMsg.mContentSrc);
      localJSONObject.put("imageUrlStatus", paramAbsShareMsg.shareData.imageUrlStatus);
      localJSONObject.put("shortUrlStatus", paramAbsShareMsg.shareData.shortUrlStatus);
      localJSONObject.put("appInfo_sourceName", paramAbsShareMsg.mSourceName);
      localJSONObject.put("appInfo_sourceIconSmall", paramAbsShareMsg.mSourceIcon);
      localJSONObject.put("appInfo_sourceIconBig", paramAbsShareMsg.shareData.sourceIconBig);
      localJSONObject.put("appInfo_sourceUrl", paramAbsShareMsg.mSourceUrl);
      localJSONObject.put("appInfo_packName", paramAbsShareMsg.mSource_A_ActionData);
      localJSONObject.put("appInfo_status", paramAbsShareMsg.shareData.appInfoStatus);
      localJSONObject.put("uin", paramBundle.getString("uin"));
      localJSONObject.put("req_type", paramBundle.getInt("req_type"));
      localJSONObject.put("title", paramBundle.getString("title"));
      localJSONObject.put("uintype", paramBundle.getInt("uintype"));
      localJSONObject.put("share_comment_message_for_server", paramBundle.getString("share_comment_message_for_server"));
      localJSONObject.put("req_share_id", paramBundle.getLong("req_share_id"));
      localJSONObject.put("desc", paramBundle.getString("desc"));
      localJSONObject.put("detail_url", paramBundle.getString("detail_url"));
      localJSONObject.put("image_url_remote", paramBundle.getString("image_url_remote"));
      localJSONObject.put("res_pkg_name", paramBundle.getString("res_pkg_name"));
      localJSONObject.put("share_comment_message", paramBundle.getString("share_comment_message"));
      localJSONObject.put("forward_ark_app_name", paramBundle.getString("forward_ark_app_name"));
      localJSONObject.put("forward_ark_app_view", paramBundle.getString("forward_ark_app_view"));
      localJSONObject.put("forward_ark_app_ver", paramBundle.getString("forward_ark_app_ver"));
      localJSONObject.put("forward_ark_app_meta", paramBundle.getString("forward_ark_app_meta"));
      localJSONObject.put("forward_ark_app_config", paramBundle.getString("forward_ark_app_config"));
      localJSONObject.put("shareArkInfo", paramBundle.getString("shareArkInfo"));
      localJSONObject.put("forward_ark_app_desc", paramBundle.getString("forward_ark_app_desc"));
      localJSONObject.put("forward_ark_app_prompt", paramBundle.getString("forward_ark_app_prompt"));
      localJSONObject.put("forward_ark_app_compat", paramBundle.getString("forward_ark_app_compat"));
      localJSONObject.put("uin", paramBundle.getString("uin"));
      localJSONObject.put("troop_uin", paramBundle.getString("troop_uin"));
      localJSONObject.put("phonenum", paramBundle.getString("phonenum"));
      localJSONObject.put("entrance", paramBundle.getInt("entrance", 0));
      localJSONObject.put("add_friend_source_id", paramBundle.getInt("add_friend_source_id", 3999));
      paramAbsShareMsg = localJSONObject.toString();
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "saveExtInfo jsonStr=", paramAbsShareMsg });
      paramMessageForArkApp.saveExtInfoToExtStr(bcrn.w, Integer.toString(-1));
      paramMessageForArkApp.saveExtInfoToExtStr(bcrn.y, paramAbsShareMsg);
      return;
    }
    catch (Exception paramMessageForArkApp)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "Exception", paramMessageForArkApp);
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uin");
    int i = paramBundle.getInt("uintype");
    String str2 = paramBundle.getString("troop_uin");
    avcw.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    avbf localavbf = new avbf(this, paramBundle, System.currentTimeMillis());
    if (a(paramBundle))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = AbsShareMsg.sendSdkFakeMessage(paramBundle, localQQAppInterface, paramAbsShareMsg, str1, i, str2, localavbf);
      a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, paramAbsShareMsg, paramBundle);
      paramBundle.putString("fake_friend_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.frienduin);
      paramBundle.putInt("fake_is_troop", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.istroop);
      paramBundle.putLong("fake_uinseq", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq);
      return;
    }
    AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, paramAbsShareMsg, str1, i, str2, localavbf);
  }
  
  private void a(Object[] paramArrayOfObject, int paramInt)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "notifyAIOActivity result[0]=", paramArrayOfObject[0], ", result[1]=", paramArrayOfObject[1], ", result[2]=", paramArrayOfObject[2], ", result[3]=", paramArrayOfObject[3], ", errorCode=", Integer.valueOf(paramInt) });
    b(paramArrayOfObject, paramInt);
    if ((-6 == paramInt) || (-3 == paramInt)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_b77_jump_result", paramArrayOfObject[0]);
    localHashMap.put("key_b77_jump_url", paramArrayOfObject[1]);
    localHashMap.put("key_b77_wording", paramArrayOfObject[2]);
    localHashMap.put("key_b77_develop_msg", paramArrayOfObject[3]);
    localHashMap.put("key_b77_error_code", Integer.valueOf(paramInt));
    paramArrayOfObject = new Intent("action_notify_aio_activity_by_b77");
    paramArrayOfObject.putExtra("key_b77_error_code", paramInt);
    BaseApplication.getContext().sendBroadcast(paramArrayOfObject);
    ((avcd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(350)).a(this.b, localHashMap);
  }
  
  private boolean a(Bundle paramBundle)
  {
    if (!arfy.a()) {}
    int i;
    do
    {
      do
      {
        return false;
      } while (ArkFullScreenAppActivity.a(paramBundle));
      i = paramBundle.getInt("uintype");
      if ("0".equals(ForwardUtils.a(i)))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "toFakeMsg not support =", Integer.valueOf(i) });
        return false;
      }
      i = paramBundle.getInt("req_type");
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "toFakeMsg reqType=", Integer.valueOf(i) });
    } while ((i != 1) && (i != 2));
    return true;
  }
  
  private void b(Object[] paramArrayOfObject, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "updateFakeArkMsg (null == mFakeArkMsg)");
      return;
    }
    if ((paramInt == 0) || (paramInt == -2))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { "updateFakeArkMsg errorCode=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.extraflag = 0;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.saveMsgExtStrAndFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(6003, true, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq) });
      return;
    }
    avae.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp, paramInt, (String)paramArrayOfObject[2]);
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, Activity paramActivity, Bundle paramBundle, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel = ((OpenSdkShareModel)paramActivity.getIntent().getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"));
    if (paramAbsShareMsg == null)
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "requestShareMessage error structMsg = null");
      return;
    }
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      a(new Object[] { Integer.valueOf(0), "", anzj.a(2131703689), "" }, -2);
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, " requestShareMessage net error");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, new Object[] { " forwardShare structMsg=", paramAbsShareMsg.getXml(), ", key=", paramString });
    paramQQAppInterface = ForwardUtils.c(paramBundle.getInt("req_type"));
    paramActivity = ForwardUtils.a(paramBundle.getInt("uintype"));
    paramString = paramBundle.getString("title");
    bdll.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, String.valueOf(paramBundle.getLong("req_share_id")), paramQQAppInterface, paramActivity, paramString);
    a(paramAbsShareMsg, paramBundle);
  }
  
  public void a(MessageForArkApp paramMessageForArkApp, Context paramContext, JSONObject paramJSONObject)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "resend message");
    if (paramJSONObject == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "resend message null == jsonObject");
      return;
    }
    if (!bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, " resend net error");
      auyp.a((Activity)paramContext, anzj.a(2131703689), new avbh(this));
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp = paramMessageForArkApp;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.b = paramJSONObject.optString("fake_key");
    paramContext = new Bundle();
    paramContext.putInt("forward_type", paramJSONObject.optInt("forward_type"));
    paramContext.putInt("serviceType", paramJSONObject.optInt("serviceType"));
    paramContext.putLong("appId", paramJSONObject.optLong("appId"));
    paramContext.putString("pkg_name", paramJSONObject.optString("pkg_name"));
    paramContext.putString("targetUrl", paramJSONObject.optString("targetUrl"));
    paramContext.putString("title", paramJSONObject.optString("title"));
    paramContext.putString("summary", paramJSONObject.optString("summary"));
    paramContext.putString("image_url", paramJSONObject.optString("image_url"));
    paramContext.putString("audio_url", paramJSONObject.optString("audio_url"));
    paramContext.putInt("imageUrlStatus", paramJSONObject.optInt("imageUrlStatus"));
    paramContext.putInt("shortUrlStatus", paramJSONObject.optInt("shortUrlStatus"));
    paramContext.putString("appInfo_sourceName", paramJSONObject.optString("appInfo_sourceName"));
    paramContext.putString("appInfo_sourceIconSmall", paramJSONObject.optString("appInfo_sourceIconSmall"));
    paramContext.putString("appInfo_sourceIconBig", paramJSONObject.optString("appInfo_sourceIconBig"));
    paramContext.putString("appInfo_sourceUrl", paramJSONObject.optString("appInfo_sourceUrl"));
    paramContext.putString("appInfo_packName", paramJSONObject.optString("appInfo_packName"));
    paramContext.putInt("appInfo_status", paramJSONObject.optInt("appInfo_status"));
    paramContext.putString("uin", paramJSONObject.optString("uin"));
    paramContext.putInt("req_type", paramJSONObject.optInt("req_type"));
    paramContext.putString("title", paramJSONObject.optString("title"));
    paramContext.putInt("uintype", paramJSONObject.optInt("uintype"));
    paramContext.putString("share_comment_message_for_server", paramJSONObject.optString("share_comment_message_for_server"));
    paramContext.putLong("req_share_id", paramJSONObject.optLong("req_share_id"));
    paramContext.putString("desc", paramJSONObject.optString("desc"));
    paramContext.putString("detail_url", paramJSONObject.optString("detail_url"));
    paramContext.putString("image_url_remote", paramJSONObject.optString("image_url_remote"));
    paramContext.putString("res_pkg_name", paramJSONObject.optString("res_pkg_name"));
    paramContext.putString("share_comment_message", paramJSONObject.optString("share_comment_message"));
    paramContext.putString("forward_ark_app_name", paramJSONObject.optString("forward_ark_app_name"));
    paramContext.putString("forward_ark_app_view", paramJSONObject.optString("forward_ark_app_view"));
    paramContext.putString("forward_ark_app_ver", paramJSONObject.optString("forward_ark_app_ver"));
    paramContext.putString("forward_ark_app_meta", paramJSONObject.optString("forward_ark_app_meta"));
    paramContext.putString("forward_ark_app_config", paramJSONObject.optString("forward_ark_app_config"));
    paramContext.putString("shareArkInfo", paramJSONObject.optString("shareArkInfo"));
    paramContext.putString("forward_ark_app_desc", paramJSONObject.optString("forward_ark_app_desc"));
    paramContext.putString("forward_ark_app_prompt", paramJSONObject.optString("forward_ark_app_prompt"));
    paramContext.putString("forward_ark_app_compat", paramJSONObject.optString("forward_ark_app_compat"));
    paramContext.putString("uin", paramJSONObject.optString("uin"));
    paramContext.putString("troop_uin", paramJSONObject.optString("troop_uin"));
    paramContext.putString("phonenum", paramJSONObject.optString("phonenum"));
    paramContext.putInt("entrance", paramJSONObject.optInt("entrance", 0));
    paramContext.putInt("add_friend_source_id", paramJSONObject.optInt("add_friend_source_id", 3999));
    AbsShareMsg.resendSdkFakeMessage(paramMessageForArkApp, paramJSONObject, new avbi(this, paramContext, System.currentTimeMillis()));
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.extraflag = 32772;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.saveMsgData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.saveMsgExtStrAndFlag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyUI(6003, false, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.frienduin, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbe
 * JD-Core Version:    0.7.0.1
 */