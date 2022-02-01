package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoReportUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.RspBody;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardUtils
  extends BaseForwardUtil
{
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ForwardUtils", 1, "parseInt text isEmpty");
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ForwardUtils", 1, "parseInt Exception", paramString);
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ForwardUtils", 1, new Object[] { "parseLong text = ", paramString });
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    QLog.e("ForwardUtils", 1, new Object[] { "parseLong text = ", paramString });
    return 0L;
  }
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return AIORichMediaInfo.a(paramMessageForPic);
  }
  
  public static SessionInfo a(Intent paramIntent)
  {
    return a(paramIntent.getExtras());
  }
  
  public static SessionInfo a(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    return a(paramIntent.getExtras(), paramString1, paramInt, paramString2);
  }
  
  public static SessionInfo a(Bundle paramBundle)
  {
    String str2 = null;
    String str1;
    if (paramBundle == null) {
      str1 = null;
    } else {
      str1 = paramBundle.getString("uin");
    }
    int i = -1;
    if (paramBundle != null) {
      i = paramBundle.getInt("uintype", -1);
    }
    if (paramBundle != null) {
      str2 = paramBundle.getString("troop_uin");
    }
    return a(paramBundle, str1, i, str2);
  }
  
  public static SessionInfo a(Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = paramString1;
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    if (localSessionInfo.jdField_a_of_type_Int == 1026)
    {
      localSessionInfo.jdField_a_of_type_Int = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    if (paramBundle == null) {
      paramString1 = null;
    } else {
      paramString1 = paramBundle.getString("phonenum");
    }
    localSessionInfo.e = paramString1;
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("entrance", 0);
    }
    localSessionInfo.c = paramInt;
    localSessionInfo.b = paramString2;
    paramInt = 3999;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("add_friend_source_id", 3999);
    }
    localSessionInfo.d = paramInt;
    return localSessionInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.b(paramString1);
    } else {
      paramQQAppInterface = null;
    }
    if ((paramQQAppInterface != null) && (paramInt == 23)) {
      return paramQQAppInterface.getNewTroopNameOrTroopName();
    }
    return paramString2;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    int i = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString2);
    int j = paramString1.length();
    int k = paramQQAppInterface.getApplication().getResources().getInteger(2131427343);
    paramQQAppInterface = paramString1;
    if (j > k)
    {
      paramQQAppInterface = paramString1.substring(0, k);
      paramString1 = new StringBuilder();
      paramString1.append(paramQQAppInterface);
      paramString1.append("...");
      paramQQAppInterface = paramString1.toString();
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramQQAppInterface);
    paramString1.append("(");
    paramString1.append(i);
    paramString1.append(")");
    return paramString1.toString();
  }
  
  public static List<oidb_cmd0xdc2.BatchSendRsp> a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("ForwardUtils", 1, "parseOIDBdc2RspBody onError data == null");
      return null;
    }
    oidb_cmd0xdc2.RspBody localRspBody = new oidb_cmd0xdc2.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      return localRspBody.batch_send_rsp.get();
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ForwardUtils", 1, "onError msg =", paramArrayOfByte);
    }
    return null;
  }
  
  public static oidb_0xd55.RspBody a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("ForwardUtils", 1, "parseOIDBD55RspBody onError data == null");
      return null;
    }
    oidb_0xd55.RspBody localRspBody = new oidb_0xd55.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      return localRspBody;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ForwardUtils", 1, "onError msg =", paramArrayOfByte);
    }
    return null;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.finish();
    Intent localIntent = paramActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("param_bind_finish", false))) {
      paramActivity.sendBroadcast(new Intent("ForwardEntranceActivity"));
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.putExtra("k_from_login", true);
    paramIntent.putExtra("sdk_mult_share", true);
    AIOUtils.a(paramIntent, new int[] { 2 });
    paramIntent.putExtra("open_chatfragment", false);
    paramIntent.putExtra("fragment_id", 1);
    paramIntent.putExtras(paramBundle);
    paramActivity.startActivity(paramIntent);
    a(paramActivity);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("sdk_mult_share_for_local", true);
    a(paramActivity, localIntent, paramBundle);
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("sdk_mult_share_result_code", 3);
    localIntent.putExtra("sdk_mult_share_error_wording", paramString);
    a(paramActivity, localIntent, paramBundle);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent, long paramLong)
  {
    Intent localIntent = new Intent();
    Uri localUri = Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(paramLong), "shareToQQ" }));
    localIntent.setData(localUri);
    localIntent.setPackage(paramString);
    paramIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(paramContext, 0, localIntent, 268435456));
    paramIntent.putExtra("activity_finish_run_uriData", localUri);
    paramIntent.putExtra("activity_finish_run_appId", paramLong);
    paramIntent.putExtra("res_pkg_name", paramString);
  }
  
  public static void a(Intent paramIntent, Bundle paramBundle, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject2 = paramBundle.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramIntent.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramIntent.getStringExtra("forward_filepath");
    }
    paramIntent = (Intent)localObject2;
    if (localObject2 == null) {
      paramIntent = paramBundle.getString("forward_filepath");
    }
    localObject1 = paramIntent;
    if (paramIntent == null) {
      localObject1 = paramBundle.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    int i = paramBundle.getInt("KEY_MSG_FORWARD_ID");
    ThreadManager.getFileThreadHandler().post(new ForwardUtils.5((String)localObject1, i, paramQQAppInterface, paramString1, paramString2, paramInt));
  }
  
  public static void a(Intent paramIntent, PicReq paramPicReq)
  {
    if ((paramIntent.getBooleanExtra("forward_is_sticker", false)) || (paramIntent.getBooleanExtra("forward_is_sticker_ad", false)))
    {
      PicMessageExtraData localPicMessageExtraData = new PicMessageExtraData();
      if (paramIntent.getBooleanExtra("forward_is_sticker", false))
      {
        localPicMessageExtraData.imageBizType = 7;
      }
      else
      {
        localPicMessageExtraData.imageBizType = 9;
        localPicMessageExtraData.setAdEmoJumpUrl(paramIntent.getStringExtra("quick_send_ad_emo_jump_url"));
        localPicMessageExtraData.setAdEmoDescStr(paramIntent.getStringExtra("quick_send_ad_emo_desc_str"));
      }
      String str = paramIntent.getStringExtra("forward_summary_extra");
      if (!TextUtils.isEmpty(str)) {
        localPicMessageExtraData.textSummary = str;
      }
      localPicMessageExtraData.from = paramIntent.getIntExtra("key_emotion_source_from", 0);
      localPicMessageExtraData.source = paramIntent.getStringExtra("key_emotion_source_info");
      localPicMessageExtraData.webUrl = paramIntent.getStringExtra("key_emotion_source_weburl");
      localPicMessageExtraData.iconUrl = paramIntent.getStringExtra("key_emotion_source_iconurl");
      localPicMessageExtraData.packageName = paramIntent.getStringExtra("key_emotion_source_packagename");
      localPicMessageExtraData.emojiPkgId = paramIntent.getStringExtra("key_emotion_source_epid");
      paramPicReq.a = localPicMessageExtraData;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new ForwardUtils.7(paramQQAppInterface), paramLong);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    try
    {
      paramContext = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
      bool = paramIntent.getBooleanExtra("foward_editbar", false);
      if (bool) {}
    }
    catch (Exception paramQQAppInterface)
    {
      boolean bool;
      Object localObject1;
      label237:
      label255:
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("FORWARD_TYPE.FILE failed. ");
        paramActivity.append(paramQQAppInterface);
        QLog.d("", 2, paramActivity.toString(), paramQQAppInterface);
      }
    }
    try
    {
      if (paramIntent.getExtras().getBoolean("sendMultiple", false))
      {
        localObject1 = paramIntent.getStringExtra("uin");
        String str = paramIntent.getStringExtra("troop_uin");
        int i = paramIntent.getIntExtra("uintype", -1);
        Object localObject2 = (ArrayList)paramIntent.getExtras().get("android.intent.extra.STREAM");
        if (localObject2 == null) {
          return;
        }
        if (FileManagerUtil.a())
        {
          FMDialogUtil.a(paramActivity, 2131692561, 2131692566, new ForwardUtils.4((ArrayList)localObject2, paramActivity, i, paramQQAppInterface, (String)localObject1, paramInt, str));
          return;
        }
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (Uri)((Iterator)localObject2).next();
          localObject3 = new UriParserPathHelper(paramActivity, false, null).a((Uri)localObject3);
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            QLog.e("ForwardUtils<FileAssistant>", 1, "mutilSend but localpath is null!");
          } else if (i == 1) {
            paramQQAppInterface.getFileManagerEngine().a((String)localObject3, (String)localObject1, 0L, paramInt);
          } else {
            paramQQAppInterface.getFileManagerEngine().a((String)localObject3, str, (String)localObject1, i, true, 0L, paramInt);
          }
        }
        return;
      }
    }
    catch (Exception localException)
    {
      break label237;
      break label255;
    }
    if (!bool)
    {
      if (paramContext != null)
      {
        paramContext.jdField_a_of_type_Int = paramInt;
        ChatActivityFacade.a(paramQQAppInterface, paramActivity, paramSessionInfo, paramIntent, paramString, paramContext, false, paramInt);
      }
    }
    else
    {
      paramContext = paramIntent.getParcelableArrayListExtra("fileinfo_array");
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramString = paramContext.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            localObject1 = (ForwardFileInfo)paramString.next();
            if (((ForwardFileInfo)localObject1).d() == 3) {
              ((ForwardFileInfo)localObject1).d();
            }
          }
          else
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext())
            {
              paramString = (ForwardFileInfo)paramContext.next();
              ChatActivityFacade.a(paramQQAppInterface, paramActivity, paramSessionInfo, paramIntent, paramString.a(), paramString, true, paramInt);
            }
          }
        }
      }
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo)
  {
    Iterator localIterator = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Parcelable)localIterator.next();
      int i = ((BaseForwardUtil.SectionBase)localObject).jdField_a_of_type_Int;
      if (i != -1)
      {
        if (i == 1) {
          for (;;)
          {
            String str1 = paramIntent.getStringExtra("forward_download_image_task_key");
            String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
            i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
            String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
            long l = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
            ChatActivityFacade.a(paramQQAppInterface, paramActivity, paramSessionInfo, ((BaseForwardUtil.SectionPic)localObject).b, str3, str2, l, i, str1);
            localObject = new Message();
            ((Message)localObject).what = 57;
            if (paramMqqHandler != null) {
              paramMqqHandler.sendMessage((Message)localObject);
            }
          }
        }
      }
      else
      {
        localObject = (BaseForwardUtil.SectionText)localObject;
        if (!TextUtils.isEmpty(((BaseForwardUtil.SectionText)localObject).jdField_a_of_type_JavaLangString)) {
          AnonymousChatHelper.a().a = true;
        }
        ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, ((BaseForwardUtil.SectionText)localObject).jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, int paramInt)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    boolean bool2 = false;
    Object localObject;
    if (i == 9501)
    {
      paramContext = paramIntent.getStringExtra("forward_text");
      paramMqqHandler = (DeviceMsgHandle)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      localObject = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if (!TextUtils.isEmpty(paramContext))
      {
        paramSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
        paramSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
        boolean bool3 = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
        paramIntent = ((SmartDeviceProxyMgr)localObject).a(Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
        boolean bool1 = SettingCloneUtil.readValue(paramActivity, paramSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false);
        if ((!bool1) && ((paramIntent.SSOBid_Platform == 1027) || ((!StringUtil.a(paramIntent.SSOBid_Version)) && (Double.valueOf(paramIntent.SSOBid_Version).doubleValue() >= 1.1D))))
        {
          SettingCloneUtil.writeValue(paramActivity, paramSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
        }
        else if ((!bool1) && (!bool3))
        {
          paramInt = 0;
          break label209;
        }
        paramInt = 1;
        label209:
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (paramInt != 0) {
            bool1 = true;
          }
        }
        paramMqqHandler.a(paramQQAppInterface, paramSessionInfo, paramContext, bool1);
      }
    }
    else
    {
      paramActivity = paramIntent.getStringExtra("forward_text");
      if (!TextUtils.isEmpty(paramActivity)) {
        AnonymousChatHelper.a().a = true;
      }
      localObject = new ChatActivityFacade.SendMsgParams();
      ((ChatActivityFacade.SendMsgParams)localObject).j = true;
      boolean[] arrayOfBoolean = paramIntent.getBooleanArrayExtra("forward_is_write_together");
      String str = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getBooleanArrayExtra("forward_write_together_is_expired");
      if ((arrayOfBoolean != null) && (arrayOfBoolean[0] != 0) && (paramSessionInfo.jdField_a_of_type_Int == 1) && (str.equals(paramSessionInfo.jdField_a_of_type_JavaLangString)) && (paramIntent != null) && (paramIntent[0] == 0)) {
        return;
      }
      paramContext = ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, paramActivity, null, (ChatActivityFacade.SendMsgParams)localObject);
      if ((paramContext != null) && (paramContext.length > 0) && (paramInt > 0))
      {
        long l = paramContext[0];
        ForwardOrderManager.a().a(l, 0L, paramInt);
        ForwardOrderManager.a().a(paramQQAppInterface, l, paramInt);
      }
      paramQQAppInterface = new Message();
      paramQQAppInterface.what = 55;
      paramQQAppInterface.obj = paramActivity;
      if (paramMqqHandler != null) {
        paramMqqHandler.sendMessage(paramQQAppInterface);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, SessionInfo paramSessionInfo, int paramInt)
  {
    if (2 == MarketFaceItemBuilder.jdField_a_of_type_Int) {
      ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
    } else {
      ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
    }
    if (paramIntent.getBooleanExtra("forward_emotion_from_preview", false)) {
      paramIntent = AIOEmotionFragment.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
    } else {
      paramIntent = MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo;
    }
    AnonymousChatHelper.a().a = true;
    if (paramIntent != null) {
      paramIntent.send(paramQQAppInterface, paramActivity, null, paramSessionInfo, true, paramInt);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    boolean bool1 = paramIntent.getBooleanExtra("isFromShare", false);
    boolean bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleForwardData() photograph isFromShare");
    ((StringBuilder)localObject).append(bool1);
    a("forward", ((StringBuilder)localObject).toString());
    int i;
    long l1;
    if (bool1)
    {
      if (!bool2)
      {
        bool1 = paramIntent.getBooleanExtra("FORWARD_IS_EDITED", false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleForwardData() photograph isEdited");
        ((StringBuilder)localObject).append(bool1);
        a("forward", ((StringBuilder)localObject).toString());
        if (!bool1)
        {
          localObject = paramIntent.getStringExtra("forward_download_image_task_key");
          String str1 = paramIntent.getStringExtra("forward_download_image_org_uin");
          i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          String str2 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          paramIntent = new Message();
          paramIntent.what = 56;
          if (paramMqqHandler != null) {
            paramMqqHandler.sendMessage(paramIntent);
          }
          a("ForwardUtils", "[@]call sendPic start!");
          ThreadManager.post(new ForwardUtils.1(paramQQAppInterface, paramActivity, paramSessionInfo, paramString, str2, str1, l1, i, (String)localObject, paramInt, paramMqqHandler), 8, null, false);
          a("ForwardUtils", "[@]call sendPic end!");
        }
      }
    }
    else
    {
      if (a(paramIntent, paramSessionInfo, paramString, paramQQAppInterface))
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("handleForwardEditedPhoto = ");
        paramQQAppInterface.append(paramString);
        a("ForwardUtils", paramQQAppInterface.toString());
        return;
      }
      paramIntent.putExtra("FORWARD_UIN_TYPE", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("SENDER_TROOP_UIN", paramSessionInfo.b);
      paramIntent.putExtra("FORWARD_PEER_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
      i = paramIntent.getIntExtra("BUSI_TYPE", 1009);
      int j = paramIntent.getIntExtra("forward_source_uin_type", -1);
      paramActivity = new StringBuilder();
      paramActivity.append("report forward! forwardFilePath = ");
      paramActivity.append(paramString);
      paramActivity.append(",forwardSourceUinType = ");
      paramActivity.append(j);
      a("ForwardUtils", paramActivity.toString());
      if (paramString != null)
      {
        l1 = paramIntent.getLongExtra("forward_image_width", 0L);
        long l2 = paramIntent.getLongExtra("forward_image_height", 0L);
        int k = paramIntent.getIntExtra("forward_image_type", 0);
        paramActivity = new StringBuilder();
        paramActivity.append(AppConstants.SDCARD_AIO_FORWARD);
        paramActivity.append("#");
        paramActivity.append(l1);
        paramActivity.append("#");
        paramActivity.append(l2);
        paramActivity.append("#");
        paramActivity.append(k);
        ThreadManager.executeOnFileThread(new ForwardUtils.2(paramActivity.toString(), paramSessionInfo, j, paramQQAppInterface));
      }
      paramMqqHandler = ((IPicBus)QRoute.api(IPicBus.class)).createForwardPicInfo(i, paramIntent);
      paramActivity = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(3, i);
      paramActivity.a(paramMqqHandler);
      if (paramIntent.getBooleanExtra("forward_is_custom_face", false))
      {
        paramMqqHandler = new PicMessageExtraData();
        paramMqqHandler.imageBizType = 1;
        paramMqqHandler.customFaceType = paramIntent.getIntExtra("forward_cutsom_face_type", 0);
        paramMqqHandler.emojiPkgId = paramIntent.getStringExtra("forward_diy_package_id");
        if (paramMqqHandler.emojiPkgId == null) {
          paramMqqHandler.emojiPkgId = "";
        }
        paramString = paramIntent.getStringExtra("forward_summary_extra");
        if (!TextUtils.isEmpty(paramString)) {
          paramMqqHandler.textSummary = paramString;
        }
        paramActivity.a = paramMqqHandler;
      }
      if (paramIntent.getBooleanExtra("HOT_PIC_HAS_EXTRA", false))
      {
        paramMqqHandler = new PicMessageExtraData();
        paramMqqHandler.imageBizType = 2;
        paramString = paramIntent.getStringExtra("forward_summary_extra");
        if (!TextUtils.isEmpty(paramString)) {
          paramMqqHandler.textSummary = paramString;
        }
        paramActivity.a = paramMqqHandler;
      }
      a(paramIntent, paramActivity);
      if (paramIntent.getBooleanExtra("forward_is_zhitu", false))
      {
        paramMqqHandler = new PicMessageExtraData();
        paramMqqHandler.imageBizType = 4;
        paramString = paramIntent.getStringExtra("forward_summary_extra");
        if (!TextUtils.isEmpty(paramString)) {
          paramMqqHandler.textSummary = paramString;
        }
        paramActivity.a = paramMqqHandler;
      }
      if (paramIntent.getBooleanExtra("forward_is_selfie_face", false))
      {
        paramMqqHandler = new PicMessageExtraData();
        paramMqqHandler.imageBizType = 8;
        paramString = paramIntent.getStringExtra("forward_summary_extra");
        localObject = paramIntent.getStringExtra("widgetinfo");
        if (!TextUtils.isEmpty(paramString)) {
          paramMqqHandler.textSummary = paramString;
        }
        paramMqqHandler.mTemplateId = ((String)localObject);
        paramActivity.a = paramMqqHandler;
      }
      if (paramIntent.getBooleanExtra("forward_send_template_pic", false))
      {
        paramMqqHandler = paramIntent.getStringExtra("widgetinfo");
        paramString = paramIntent.getStringExtra("key_camera_material_name");
        if ((!TextUtils.isEmpty(paramMqqHandler)) || (!TextUtils.isEmpty(paramString)))
        {
          if (paramActivity.a == null) {
            paramActivity.a = new PicMessageExtraData();
          }
          paramActivity.a.mTemplateId = paramMqqHandler;
          paramActivity.a.mTemplateName = paramString;
        }
      }
      if (paramIntent.getBooleanExtra("forward_is_tab_search_emo", false))
      {
        if (paramActivity.a == null) {
          paramActivity.a = new PicMessageExtraData();
        }
        paramActivity.a.imageBizType = 12;
      }
      new AdEmoReportUtil().a(paramQQAppInterface, paramSessionInfo, paramActivity);
      paramActivity.c = paramInt;
      ThreadManagerV2.executeOnSubThread(new ForwardUtils.3(paramActivity));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, SessionInfo paramSessionInfo)
  {
    if (paramIntent.getBooleanExtra("isFromFavorites", false))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str1 = paramIntent.getString("forward_latitude");
        String str2 = paramIntent.getString("forward_longitude");
        String str3 = paramIntent.getString("forward_location");
        String str4 = paramIntent.getString("title");
        String str5 = paramIntent.getString("summary");
        paramIntent.putInt("isArk", 1);
        ChatActivityFacade.a(paramContext, paramQQAppInterface, paramSessionInfo, str1, str2, str3, str4, str5, "", "", "", "", paramIntent);
      }
    }
    else
    {
      ChatActivityFacade.a(paramQQAppInterface, paramSessionInfo, paramIntent.getStringExtra("forward_latitude"), paramIntent.getStringExtra("forward_longitude"), paramIntent.getStringExtra("forward_location"));
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 568	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +62 -> 65
    //   6: new 187	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   13: astore 9
    //   15: aload 9
    //   17: ldc_w 941
    //   20: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 9
    //   26: aload_2
    //   27: getfield 97	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   30: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 9
    //   36: ldc_w 943
    //   39: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 9
    //   45: aload_2
    //   46: getfield 94	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc_w 778
    //   56: iconst_2
    //   57: aload 9
    //   59: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 945	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aload_3
    //   66: ldc_w 947
    //   69: invokevirtual 951	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   72: invokestatic 956	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([B)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   75: astore 10
    //   77: aload 10
    //   79: ifnonnull +18 -> 97
    //   82: aload_3
    //   83: ldc_w 958
    //   86: invokevirtual 961	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   89: aload_3
    //   90: ldc_w 963
    //   93: invokevirtual 961	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   96: return
    //   97: aload 10
    //   99: aload_3
    //   100: ldc_w 965
    //   103: iconst_0
    //   104: invokevirtual 421	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   107: putfield 970	com/tencent/mobileqq/structmsg/AbsStructMsg:sourceAccoutType	I
    //   110: aload_3
    //   111: ldc_w 972
    //   114: invokevirtual 365	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 9
    //   119: aload 10
    //   121: getfield 975	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   124: istore 4
    //   126: iload 4
    //   128: bipush 83
    //   130: if_icmpne +10 -> 140
    //   133: aload 10
    //   135: ldc 151
    //   137: putfield 978	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgActionData	Ljava/lang/String;
    //   140: aload 10
    //   142: getfield 975	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   145: bipush 108
    //   147: if_icmpeq +23 -> 170
    //   150: aload 10
    //   152: getfield 975	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   155: bipush 114
    //   157: if_icmpeq +13 -> 170
    //   160: aload 10
    //   162: getfield 975	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   165: bipush 116
    //   167: if_icmpne +10 -> 177
    //   170: aload 10
    //   172: ldc 151
    //   174: putfield 978	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgActionData	Ljava/lang/String;
    //   177: aload 10
    //   179: instanceof 980
    //   182: istore 6
    //   184: iconst_1
    //   185: istore 4
    //   187: iload 6
    //   189: ifeq +6 -> 195
    //   192: goto +481 -> 673
    //   195: aload 10
    //   197: instanceof 982
    //   200: ifeq +25 -> 225
    //   203: aload 10
    //   205: checkcast 982	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   208: getfield 985	com/tencent/mobileqq/structmsg/AbsShareMsg:forwardType	I
    //   211: aload 10
    //   213: getfield 975	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   216: invokestatic 988	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(II)Z
    //   219: ifeq +6 -> 225
    //   222: goto +451 -> 673
    //   225: aload 10
    //   227: getfield 975	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   230: istore 4
    //   232: bipush 35
    //   234: iload 4
    //   236: if_icmpne +156 -> 392
    //   239: aload 9
    //   241: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifeq +432 -> 676
    //   247: aload 10
    //   249: getfield 991	com/tencent/mobileqq/structmsg/AbsStructMsg:mCommentText	Ljava/lang/String;
    //   252: astore 9
    //   254: goto +3 -> 257
    //   257: aload 9
    //   259: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   262: ifne +10 -> 272
    //   265: invokestatic 626	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   268: iconst_1
    //   269: putfield 629	com/tencent/biz/anonymous/AnonymousChatHelper:a	Z
    //   272: new 490	java/util/ArrayList
    //   275: dup
    //   276: invokespecial 992	java/util/ArrayList:<init>	()V
    //   279: astore 11
    //   281: invokestatic 997	com/tencent/mobileqq/multimsg/MultiMsgManager:a	()Lcom/tencent/mobileqq/multimsg/MultiMsgManager;
    //   284: getfield 1000	com/tencent/mobileqq/multimsg/MultiMsgManager:a	Ljava/util/ArrayList;
    //   287: ifnull +27 -> 314
    //   290: invokestatic 997	com/tencent/mobileqq/multimsg/MultiMsgManager:a	()Lcom/tencent/mobileqq/multimsg/MultiMsgManager;
    //   293: getfield 1000	com/tencent/mobileqq/multimsg/MultiMsgManager:a	Ljava/util/ArrayList;
    //   296: invokevirtual 558	java/util/ArrayList:size	()I
    //   299: ifle +15 -> 314
    //   302: aload 11
    //   304: invokestatic 997	com/tencent/mobileqq/multimsg/MultiMsgManager:a	()Lcom/tencent/mobileqq/multimsg/MultiMsgManager;
    //   307: getfield 1000	com/tencent/mobileqq/multimsg/MultiMsgManager:a	Ljava/util/ArrayList;
    //   310: invokevirtual 1004	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   313: pop
    //   314: aload_3
    //   315: ldc_w 1006
    //   318: lconst_0
    //   319: invokevirtual 602	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   322: lstore 7
    //   324: aload_3
    //   325: ldc_w 1008
    //   328: iconst_0
    //   329: invokevirtual 421	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   332: istore 4
    //   334: invokestatic 727	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   337: invokevirtual 1010	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()I
    //   340: istore 5
    //   342: invokestatic 727	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   345: aload_2
    //   346: aload 9
    //   348: aload 11
    //   350: iload 4
    //   352: iload 5
    //   354: invokevirtual 1013	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;Ljava/util/List;II)V
    //   357: invokestatic 997	com/tencent/mobileqq/multimsg/MultiMsgManager:a	()Lcom/tencent/mobileqq/multimsg/MultiMsgManager;
    //   360: aload_0
    //   361: aload_2
    //   362: getfield 94	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   365: aload_2
    //   366: getfield 97	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   369: aload_2
    //   370: getfield 120	com/tencent/mobileqq/activity/aio/SessionInfo:b	Ljava/lang/String;
    //   373: aload 10
    //   375: lload 7
    //   377: iconst_0
    //   378: iload 4
    //   380: iload 5
    //   382: aload_3
    //   383: invokevirtual 65	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   386: invokevirtual 1016	com/tencent/mobileqq/multimsg/MultiMsgManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mobileqq/structmsg/AbsStructMsg;JZIILandroid/os/Bundle;)V
    //   389: goto +290 -> 679
    //   392: invokestatic 727	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   395: invokevirtual 1010	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()I
    //   398: istore 4
    //   400: aload_3
    //   401: ldc_w 1008
    //   404: iconst_0
    //   405: invokevirtual 421	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   408: istore 5
    //   410: invokestatic 727	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   413: aload_2
    //   414: aload 9
    //   416: new 490	java/util/ArrayList
    //   419: dup
    //   420: invokespecial 992	java/util/ArrayList:<init>	()V
    //   423: iload 5
    //   425: iload 4
    //   427: invokevirtual 1013	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	(Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;Ljava/util/List;II)V
    //   430: aload 10
    //   432: iload 4
    //   434: putfield 1019	com/tencent/mobileqq/structmsg/AbsStructMsg:forwardID	I
    //   437: aload_0
    //   438: aload_2
    //   439: getfield 94	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   442: aload_2
    //   443: getfield 120	com/tencent/mobileqq/activity/aio/SessionInfo:b	Ljava/lang/String;
    //   446: aload_2
    //   447: getfield 97	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   450: aload 10
    //   452: aconst_null
    //   453: invokestatic 1024	com/tencent/mobileqq/utils/ShareMsgHelper:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/structmsg/AbsStructMsg;Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   456: goto +223 -> 679
    //   459: aload 10
    //   461: instanceof 1026
    //   464: ifeq +104 -> 568
    //   467: aload 10
    //   469: checkcast 982	com/tencent/mobileqq/structmsg/AbsShareMsg
    //   472: invokestatic 1031	com/tencent/mobileqq/structmsg/CGILoader:a	(Lcom/tencent/mobileqq/structmsg/AbsShareMsg;)Z
    //   475: ifeq +93 -> 568
    //   478: aload 10
    //   480: getfield 1034	com/tencent/mobileqq/structmsg/AbsStructMsg:uinType	I
    //   483: istore 5
    //   485: aload 10
    //   487: getfield 1037	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgUrl	Ljava/lang/String;
    //   490: invokestatic 1039	com/tencent/mobileqq/structmsg/CGILoader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   493: astore 11
    //   495: aload 11
    //   497: ifnull +71 -> 568
    //   500: aload 11
    //   502: ldc 151
    //   504: invokevirtual 719	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   507: ifne +61 -> 568
    //   510: new 187	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   517: astore 12
    //   519: aload 12
    //   521: iload 5
    //   523: invokestatic 1041	com/tencent/mobileqq/structmsg/CGILoader:a	(I)I
    //   526: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload 12
    //   532: ldc 151
    //   534: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aconst_null
    //   539: ldc_w 743
    //   542: ldc 151
    //   544: ldc 151
    //   546: ldc_w 1043
    //   549: ldc_w 1043
    //   552: iconst_0
    //   553: iconst_0
    //   554: aload 12
    //   556: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: ldc 151
    //   561: aload 11
    //   563: ldc 151
    //   565: invokestatic 752	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   568: iload 4
    //   570: ifeq +72 -> 642
    //   573: aload 9
    //   575: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   578: ifeq +107 -> 685
    //   581: aload 10
    //   583: getfield 991	com/tencent/mobileqq/structmsg/AbsStructMsg:mCommentText	Ljava/lang/String;
    //   586: astore 9
    //   588: goto +3 -> 591
    //   591: aload 9
    //   593: invokestatic 19	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   596: ifne +46 -> 642
    //   599: invokestatic 626	com/tencent/biz/anonymous/AnonymousChatHelper:a	()Lcom/tencent/biz/anonymous/AnonymousChatHelper;
    //   602: iconst_1
    //   603: putfield 629	com/tencent/biz/anonymous/AnonymousChatHelper:a	Z
    //   606: aload_0
    //   607: aload_1
    //   608: aload_2
    //   609: aload 9
    //   611: invokestatic 632	com/tencent/mobileqq/activity/ChatActivityFacade:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/SessionInfo;Ljava/lang/String;)V
    //   614: goto +28 -> 642
    //   617: astore_0
    //   618: goto +39 -> 657
    //   621: astore_0
    //   622: invokestatic 568	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +13 -> 638
    //   628: ldc 21
    //   630: iconst_2
    //   631: ldc_w 1045
    //   634: aload_0
    //   635: invokestatic 575	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   638: aload_0
    //   639: invokevirtual 1048	java/lang/Exception:printStackTrace	()V
    //   642: aload_3
    //   643: ldc_w 958
    //   646: invokevirtual 961	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   649: aload_3
    //   650: ldc_w 963
    //   653: invokevirtual 961	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   656: return
    //   657: aload_3
    //   658: ldc_w 958
    //   661: invokevirtual 961	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   664: aload_3
    //   665: ldc_w 963
    //   668: invokevirtual 961	android/content/Intent:removeExtra	(Ljava/lang/String;)V
    //   671: aload_0
    //   672: athrow
    //   673: goto -214 -> 459
    //   676: goto -419 -> 257
    //   679: iconst_0
    //   680: istore 4
    //   682: goto -223 -> 459
    //   685: goto -94 -> 591
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	paramQQAppInterface	QQAppInterface
    //   0	688	1	paramContext	Context
    //   0	688	2	paramSessionInfo	SessionInfo
    //   0	688	3	paramIntent	Intent
    //   124	557	4	i	int
    //   340	182	5	j	int
    //   182	6	6	bool	boolean
    //   322	54	7	l	long
    //   13	597	9	localObject1	Object
    //   75	507	10	localAbsStructMsg	AbsStructMsg
    //   279	283	11	localObject2	Object
    //   517	38	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	77	617	finally
    //   97	126	617	finally
    //   133	140	617	finally
    //   140	170	617	finally
    //   170	177	617	finally
    //   177	184	617	finally
    //   195	222	617	finally
    //   225	232	617	finally
    //   239	254	617	finally
    //   257	272	617	finally
    //   272	314	617	finally
    //   314	389	617	finally
    //   392	456	617	finally
    //   459	495	617	finally
    //   500	568	617	finally
    //   573	588	617	finally
    //   591	614	617	finally
    //   622	638	617	finally
    //   638	642	617	finally
    //   65	77	621	java/lang/Exception
    //   97	126	621	java/lang/Exception
    //   133	140	621	java/lang/Exception
    //   140	170	621	java/lang/Exception
    //   170	177	621	java/lang/Exception
    //   177	184	621	java/lang/Exception
    //   195	222	621	java/lang/Exception
    //   225	232	621	java/lang/Exception
    //   239	254	621	java/lang/Exception
    //   257	272	621	java/lang/Exception
    //   272	314	621	java/lang/Exception
    //   314	389	621	java/lang/Exception
    //   392	456	621	java/lang/Exception
    //   459	495	621	java/lang/Exception
    //   500	568	621	java/lang/Exception
    //   573	588	621	java/lang/Exception
    //   591	614	621	java/lang/Exception
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    int i = 0;
    int j = paramIntent.getIntExtra("from_busi_type", 0);
    if (j == 1) {
      i = 2;
    } else if (j == 2) {
      i = 3;
    }
    ShortVideoReq localShortVideoReq = SVBusiUtil.a(3, i);
    paramIntent = ShortVideoBusiManager.a(i, paramIntent, localShortVideoReq);
    if (paramIntent != null) {
      paramIntent.p = paramInt;
    }
    localShortVideoReq.a(paramIntent);
    ShortVideoBusiManager.a(localShortVideoReq, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, Activity paramActivity)
  {
    paramIntent.putExtra("selfSet_leftViewText", paramQQAppInterface.getApplication().getString(2131719442));
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    a(paramQQAppInterface, paramActivity, paramActivity, localIntent, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 1)
      {
        paramVarArgs = paramVarArgs[0];
        break label116;
      }
      String str4;
      if (paramVarArgs.length == 2)
      {
        str4 = paramVarArgs[0];
        str1 = paramVarArgs[1];
        str2 = "";
        str3 = str2;
        paramVarArgs = str4;
        break label128;
      }
      if (paramVarArgs.length == 3)
      {
        str4 = paramVarArgs[0];
        str1 = paramVarArgs[1];
        str2 = paramVarArgs[2];
        str3 = "";
        paramVarArgs = str4;
        break label128;
      }
      if (paramVarArgs.length == 4)
      {
        str4 = paramVarArgs[0];
        str1 = paramVarArgs[1];
        str2 = paramVarArgs[2];
        str3 = paramVarArgs[3];
        paramVarArgs = str4;
        break label128;
      }
    }
    paramVarArgs = "";
    label116:
    String str1 = "";
    String str2 = "";
    String str3 = str2;
    label128:
    ReportController.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, paramInt, 0, paramVarArgs, str1, str2, str3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, String... paramVarArgs)
  {
    a(paramQQAppInterface, paramString, 0, paramVarArgs);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, String paramString)
  {
    if (ChatActivityFacade.a(paramQQAppInterface, paramSessionInfo, paramString) != -1L)
    {
      paramQQAppInterface = new Message();
      paramQQAppInterface.what = 57;
      if (paramMqqHandler != null) {
        paramMqqHandler.sendMessage(paramQQAppInterface);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static void a(List<ResultRecord> paramList, List<oidb_cmd0xdc2.BatchSendRsp> paramList1, Context paramContext, String paramString)
  {
    QLog.d("ForwardUtils", 1, new Object[] { "sendCommentMsg: invoked textAndEmoji : ", paramString });
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramList.next();
      if (a(paramList1, localResultRecord.uin))
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_Int = localResultRecord.getUinType();
        localSessionInfo.jdField_a_of_type_JavaLangString = localResultRecord.uin;
        localSessionInfo.b = localResultRecord.groupUin;
        ChatActivityFacade.b(localQQAppInterface, paramContext, localSessionInfo, paramString);
      }
    }
  }
  
  public static boolean a()
  {
    try
    {
      Object localObject = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
      if ((localObject != null) && (((ArkPlatformConfigBean)localObject).a() != null))
      {
        localObject = ((ArkPlatformConfigBean)localObject).a();
        QLog.d("ForwardUtils", 1, new Object[] { "backToFileScheme mIsBackToFileSchemeEnable=", Boolean.valueOf(((ArkPlatformConfig)localObject).d) });
        boolean bool = ((ArkPlatformConfig)localObject).d;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ForwardUtils", 1, "Exception", localException);
      QLog.d("ForwardUtils", 1, "backToFileScheme default true");
    }
    return true;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if ((paramInt1 == arrayOfInt[i]) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 2147483646) || (paramInt2 == 6) || (paramInt2 == 147))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(Intent paramIntent, SessionInfo paramSessionInfo, String paramString, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = paramIntent.getBooleanExtra("extra_is_edited_pic", false);
    boolean bool3 = paramIntent.getBooleanExtra("forward_send_selfie_face", false);
    boolean bool2 = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
    if ((!bool1) && (!bool3) && (!bool2)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if (bool1)
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("troop_uin", paramSessionInfo.b);
      paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
      paramIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
      int k = ForwardBaseOption.a(paramIntent.getExtras());
      int j = 1048;
      if (k == 100200) {}
      do
      {
        i = 1051;
        break;
        i = j;
        if (k == 100100) {
          break;
        }
        i = j;
        if (k == 100101) {
          break;
        }
        i = j;
        if (k == 100300) {
          break;
        }
        if (ForwardBaseOption.a(paramIntent.getExtras()))
        {
          i = j;
          break;
        }
        if (paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1) == 1041)
        {
          i = j;
          break;
        }
      } while (bool2);
      int i = 1007;
      paramSessionInfo = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, i);
      paramSessionInfo.a(((IPicBus)QRoute.api(IPicBus.class)).createPicUploadInfo(i, paramIntent));
      paramSessionInfo.c = paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0);
      if (paramIntent.getBooleanExtra("forward_is_selfie_face", false))
      {
        paramString = new PicMessageExtraData();
        paramString.imageBizType = 8;
        paramIntent = paramIntent.getStringExtra("forward_summary_extra");
        if (!TextUtils.isEmpty(paramIntent)) {
          paramString.textSummary = paramIntent;
        }
        paramSessionInfo.a = paramString;
      }
      ThreadManagerV2.executeOnSubThread(new ForwardUtils.6(paramSessionInfo));
    }
    return bool1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler)
  {
    a("forward", "handleForwardData");
    Object localObject1 = paramIntent.getParcelableArrayListExtra("forward_multi_target");
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      a(paramQQAppInterface, paramActivity, paramContext, paramIntent, paramMqqHandler, (List)localObject1);
    }
    else
    {
      localObject1 = a(paramIntent);
      if ((((SessionInfo)localObject1).jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, true).a))
      {
        QQToast.a(paramQQAppInterface.getApp(), 2131697407, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        return false;
      }
      int j = paramIntent.getIntExtra("forward_type", 2147483647);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleForwardData() forwardType");
      ((StringBuilder)localObject2).append(j);
      a("forward", ((StringBuilder)localObject2).toString());
      if (j == 2147483647) {
        return false;
      }
      paramIntent.removeExtra("forward_type");
      localObject2 = paramIntent.getStringExtra("forward_filepath");
      int i = paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0);
      if (j != -6)
      {
        if (j != -5)
        {
          if (j != -3) {
            if (j != -2)
            {
              if (j != -1)
              {
                if (j != 0)
                {
                  if (j != 1)
                  {
                    if (j != 20) {
                      if (j != 21)
                      {
                        if ((j != 23) && (j != 24) && (j != 28) && (j != 29)) {
                          if (j != 32)
                          {
                            if ((j != 42) && (j != 36))
                            {
                              if (j != 37) {
                                switch (j)
                                {
                                default: 
                                  break;
                                case 10: 
                                  a(paramQQAppInterface, paramActivity, paramContext, paramIntent, paramMqqHandler, (SessionInfo)localObject1);
                                  break;
                                case 9: 
                                  a(paramQQAppInterface, paramActivity, paramIntent, (SessionInfo)localObject1, i);
                                  break;
                                case 8: 
                                  a(paramQQAppInterface, paramMqqHandler, (SessionInfo)localObject1, (String)localObject2);
                                  break;
                                }
                              }
                              paramActivity = paramIntent.getStringExtra("forward_text");
                              j = paramIntent.getIntExtra("key_hiboom_id", 0);
                              paramContext = new HiBoomMessage();
                              paramContext.id = j;
                              paramContext.text = paramActivity;
                              paramContext.type = paramIntent.getIntExtra("key_hiboom_type", 0);
                              ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject1, paramContext, null, i);
                              break label698;
                            }
                          }
                          else
                          {
                            paramQQAppInterface = TroopStoryForwardTask.a(paramQQAppInterface, paramIntent.getExtras(), (SessionInfo)localObject1);
                            if (paramQQAppInterface == null) {
                              break label698;
                            }
                            paramQQAppInterface.f();
                            break label698;
                          }
                        }
                      }
                      else
                      {
                        if (((SessionInfo)localObject1).jdField_a_of_type_Int == 9501) {
                          return true;
                        }
                        if (QFileAssistantUtils.a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString))
                        {
                          paramActivity = paramIntent.getStringExtra("file_send_path");
                          if (FileUtils.fileExistsAndNotEmpty(paramActivity))
                          {
                            paramQQAppInterface.getFileManagerEngine().a(paramActivity, ((SessionInfo)localObject1).b, ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject1).jdField_a_of_type_Int, true, 0L, i);
                            return true;
                          }
                        }
                        paramActivity = new StringBuilder();
                        paramActivity.append("handleForwardData(): ShortVideo => ");
                        paramActivity.append(paramIntent.getExtras());
                        a("ForwardUtils", paramActivity.toString());
                        a(paramQQAppInterface, paramIntent, i);
                        break label698;
                      }
                    }
                  }
                  else
                  {
                    a(paramQQAppInterface, paramActivity, paramIntent, paramMqqHandler, (SessionInfo)localObject1, (String)localObject2, i);
                    break label698;
                  }
                }
                else
                {
                  a(paramQQAppInterface, paramActivity, paramContext, paramIntent, (SessionInfo)localObject1, (String)localObject2, i);
                  break label698;
                }
              }
              else
              {
                a(paramQQAppInterface, paramActivity, paramContext, paramIntent, paramMqqHandler, (SessionInfo)localObject1, i);
                break label698;
              }
            }
            else
            {
              a(paramQQAppInterface, paramContext, paramIntent, (SessionInfo)localObject1);
              break label698;
            }
          }
          a(paramQQAppInterface, paramContext, (SessionInfo)localObject1, paramIntent);
        }
        else
        {
          long l = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
          ((MixedMsgManager)paramQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a((SessionInfo)localObject1, l, i);
        }
      }
      else {
        ReplyMsgSender.a().a(paramQQAppInterface, (SessionInfo)localObject1, paramIntent);
      }
    }
    label698:
    paramIntent.removeExtra("extra_is_edited_pic");
    paramIntent.removeExtra("key_help_forward_pic");
    paramIntent.removeExtra("key_allow_multiple_forward_from_limit");
    paramIntent.removeExtra("key_allow_forward_photo_preview_edit");
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler, List<ResultRecord> paramList)
  {
    paramIntent.removeExtra("forward_multi_target");
    int[] arrayOfInt = paramIntent.getIntArrayExtra("KEY_MSG_FORWARD_ID_ARRAY");
    int k = paramList.size();
    int i = 0;
    while (i < k)
    {
      ResultRecord localResultRecord = (ResultRecord)paramList.get(i);
      Intent localIntent = new Intent(paramIntent);
      localIntent.putExtra("uin", localResultRecord.uin);
      localIntent.putExtra("uintype", localResultRecord.getUinType());
      localIntent.putExtra("troop_uin", localResultRecord.groupUin);
      localIntent.putExtra("uinname", localResultRecord.name);
      localIntent.removeExtra("KEY_MSG_FORWARD_ID_ARRAY");
      int j;
      if ((arrayOfInt != null) && (arrayOfInt.length > i)) {
        j = arrayOfInt[i];
      } else {
        j = 0;
      }
      localIntent.putExtra("KEY_MSG_FORWARD_ID", j);
      a(paramQQAppInterface, paramActivity, paramContext, localIntent, paramMqqHandler);
      i += 1;
    }
    return true;
  }
  
  public static boolean a(UpCallBack.SendResult paramSendResult)
  {
    int i = paramSendResult.jdField_a_of_type_Int;
    boolean bool2 = false;
    if (i != 0) {
      return false;
    }
    paramSendResult = (String[])paramSendResult.jdField_a_of_type_JavaLangObject;
    boolean bool1 = bool2;
    if (paramSendResult != null)
    {
      bool1 = bool2;
      if (paramSendResult.length == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(AbsStructMsg paramAbsStructMsg)
  {
    return ((paramAbsStructMsg instanceof StructMsgForImageShare)) && (!ForwardShareByServerHelper.a());
  }
  
  private static boolean a(List<oidb_cmd0xdc2.BatchSendRsp> paramList, String paramString)
  {
    if (paramList == null) {
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      oidb_cmd0xdc2.BatchSendRsp localBatchSendRsp = (oidb_cmd0xdc2.BatchSendRsp)paramList.next();
      if ((String.valueOf(localBatchSendRsp.recv_uin.get()).equals(paramString)) && (localBatchSendRsp.err_code.get() != 0))
      {
        QLog.d("ForwardUtils", 1, new Object[] { "needSendComment uin=", AuthorityUtil.a(paramString), ", err_code=", Integer.valueOf(localBatchSendRsp.err_code.get()) });
        return false;
      }
    }
    return true;
  }
  
  public static Object[] a(byte[] paramArrayOfByte)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    String str = "";
    arrayOfObject[1] = "";
    arrayOfObject[2] = ForwardShareByServerHelper.jdField_a_of_type_JavaLangString;
    arrayOfObject[3] = "";
    if (paramArrayOfByte == null)
    {
      QLog.e("ForwardUtils", 1, "parseOIDBb77RspBody onError data == null");
      return arrayOfObject;
    }
    oidb_cmd0xb77.RspBody localRspBody = new oidb_cmd0xb77.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      arrayOfObject[0] = Integer.valueOf(localRspBody.jump_result.get());
      if (localRspBody.jump_url.has()) {
        paramArrayOfByte = localRspBody.jump_url.get();
      } else {
        paramArrayOfByte = "";
      }
      arrayOfObject[1] = paramArrayOfByte;
      if (localRspBody.wording.has()) {
        paramArrayOfByte = localRspBody.wording.get();
      } else {
        paramArrayOfByte = ForwardShareByServerHelper.jdField_a_of_type_JavaLangString;
      }
      arrayOfObject[2] = paramArrayOfByte;
      paramArrayOfByte = str;
      if (localRspBody.develop_msg.has()) {
        paramArrayOfByte = localRspBody.develop_msg.get();
      }
      arrayOfObject[3] = paramArrayOfByte;
      QLog.d("ForwardUtils", 1, new Object[] { "parseOIDBb77RspBody  jumpResult =", arrayOfObject[0], ", jumpUrl = ", arrayOfObject[1], ", wording =", arrayOfObject[2] });
      return arrayOfObject;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e("ForwardUtils", 1, "onError msg =", paramArrayOfByte);
    }
    return arrayOfObject;
  }
  
  public static boolean b()
  {
    try
    {
      Object localObject = (ArkPlatformConfigBean)((IArkConfig)QRoute.api(IArkConfig.class)).loadConfig(ArkPlatformConfigBean.class);
      if ((localObject != null) && (((ArkPlatformConfigBean)localObject).a() != null))
      {
        localObject = ((ArkPlatformConfigBean)localObject).a();
        QLog.d("ForwardUtils", 1, new Object[] { "addBackslashToUrl addBackslashEnable=", Boolean.valueOf(((ArkPlatformConfig)localObject).e) });
        boolean bool = ((ArkPlatformConfig)localObject).e;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ForwardUtils", 1, "Exception", localException);
      QLog.d("ForwardUtils", 1, "addBackslashToUrl default true");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils
 * JD-Core Version:    0.7.0.1
 */