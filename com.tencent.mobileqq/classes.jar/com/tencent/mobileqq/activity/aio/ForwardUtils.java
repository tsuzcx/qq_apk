package com.tencent.mobileqq.activity.aio;

import abgm;
import abkw;
import admh;
import admo;
import agfe;
import ahaw;
import ahtm;
import aijb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import antp;
import aqyn;
import aqys;
import aqyt;
import aqzm;
import athn;
import audn;
import auea;
import aupt;
import auui;
import auuv;
import awyg;
import axio;
import azjv;
import azke;
import azlb;
import bber;
import bcwz;
import bcxr;
import bdla;
import bdny;
import bdof;
import bgkf;
import bgkl;
import bhdj;
import bhhn;
import bjgx;
import bjhh;
import bjpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import nty;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.RspBody;
import tencent.im.oidb.oidb_0xd55.RspBody;
import zcm;

public class ForwardUtils
{
  public static final String TAG_FOWARD = "ForwardUtils";
  private static int[] sAsyncShareForwardTypes = { 11, 2 };
  
  public static void addStickerExtraData(Intent paramIntent, azke paramazke)
  {
    PicMessageExtraData localPicMessageExtraData;
    if ((paramIntent.getBooleanExtra("forward_is_sticker", false)) || (paramIntent.getBooleanExtra("forward_is_sticker_ad", false)))
    {
      localPicMessageExtraData = new PicMessageExtraData();
      if (!paramIntent.getBooleanExtra("forward_is_sticker", false)) {
        break label130;
      }
      localPicMessageExtraData.imageBizType = 7;
    }
    for (;;)
    {
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
      paramazke.a = localPicMessageExtraData;
      return;
      label130:
      localPicMessageExtraData.imageBizType = 9;
      localPicMessageExtraData.setAdEmoJumpUrl(paramIntent.getStringExtra("quick_send_ad_emo_jump_url"));
      localPicMessageExtraData.setAdEmoDescStr(paramIntent.getStringExtra("quick_send_ad_emo_desc_str"));
    }
  }
  
  public static boolean backToFileScheme()
  {
    try
    {
      Object localObject = aqyt.b(380).a();
      if ((localObject != null) && (((aqys)localObject).a() != null))
      {
        localObject = ((aqys)localObject).a();
        QLog.d("ForwardUtils", 1, new Object[] { "backToFileScheme mIsBackToFileSchemeEnable=", Boolean.valueOf(((aqzm)localObject).d) });
        boolean bool = ((aqzm)localObject).d;
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
  
  public static void backToThirdAppIntent(Context paramContext, String paramString, Intent paramIntent, long paramLong)
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
  
  public static void finishRecentActivity(Activity paramActivity)
  {
    paramActivity.finish();
    Intent localIntent = paramActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("param_bind_finish", false))) {
      paramActivity.sendBroadcast(new Intent("ForwardEntranceActivity"));
    }
  }
  
  public static URLDrawable generateForwardImage(Context paramContext, MessageForPic paramMessageForPic)
  {
    return ahtm.a(paramMessageForPic);
  }
  
  public static String getDataDataPath()
  {
    return File.separator + "data" + File.separator + "data" + File.separator;
  }
  
  public static void handleAppShareAction(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleAppShareAction() type" + paramSessionInfo.curType + "uin=" + paramSessionInfo.curFriendUin);
    }
    try
    {
      AbsStructMsg localAbsStructMsg = bdof.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      localAbsStructMsg.sourceAccoutType = paramIntent.getIntExtra("accostType", 0);
      Object localObject1 = paramIntent.getStringExtra("share_comment_message");
      if (localAbsStructMsg.mMsgServiceID == 83) {
        localAbsStructMsg.mMsgActionData = "";
      }
      if ((localAbsStructMsg.mMsgServiceID == 108) || (localAbsStructMsg.mMsgServiceID == 114) || (localAbsStructMsg.mMsgServiceID == 116)) {
        localAbsStructMsg.mMsgActionData = "";
      }
      int i;
      int j;
      Object localObject2;
      if ((localAbsStructMsg instanceof StructMsgForImageShare))
      {
        i = 1;
        if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (bdny.a((AbsShareMsg)localAbsStructMsg)))
        {
          j = localAbsStructMsg.uinType;
          localObject2 = bdny.a(localAbsStructMsg.mMsgUrl);
          if ((localObject2 != null) && (!((String)localObject2).equals(""))) {
            bdla.b(null, "CliOper", "", "", "0X8005F54", "0X8005F54", 0, 0, bdny.a(j) + "", "", (String)localObject2, "");
          }
        }
        if (i != 0)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label660;
          }
          localObject1 = localAbsStructMsg.mCommentText;
        }
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          nty.a().a = true;
          admh.b(paramQQAppInterface, paramContext, paramSessionInfo, (String)localObject1);
        }
        return;
        if (((localAbsStructMsg instanceof AbsShareMsg)) && (isAsyncShareSupport(((AbsShareMsg)localAbsStructMsg).forwardType, localAbsStructMsg.mMsgServiceID)))
        {
          i = 1;
          break;
        }
        if (35 == localAbsStructMsg.mMsgServiceID)
        {
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localAbsStructMsg.mCommentText;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            nty.a().a = true;
          }
          localObject1 = new ArrayList();
          if ((axio.a().a != null) && (axio.a().a.size() > 0)) {
            ((ArrayList)localObject1).addAll(axio.a().a);
          }
          long l = paramIntent.getLongExtra("structmsg_uniseq", 0L);
          i = paramIntent.getIntExtra("forward_msg_from_together", 0);
          j = agfe.a().a();
          agfe.a().a(paramSessionInfo, (String)localObject2, (List)localObject1, i, j);
          axio.a().a(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.curType, paramSessionInfo.troopUin, localAbsStructMsg, l, false, i, j, paramIntent.getExtras());
          localObject1 = localObject2;
          i = 0;
          break;
        }
        i = agfe.a().a();
        j = paramIntent.getIntExtra("forward_msg_from_together", 0);
        agfe.a().a(paramSessionInfo, (String)localObject1, new ArrayList(), j, i);
        localAbsStructMsg.forwardID = i;
        bhhn.b(paramQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, paramSessionInfo.curType, localAbsStructMsg, null);
        i = 0;
        break;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardUtils", 2, "handleAppShareAction Exception", paramQQAppInterface);
      }
      paramQQAppInterface.printStackTrace();
      return;
    }
    finally
    {
      paramIntent.removeExtra("forward_type");
      paramIntent.removeExtra("res_share_id");
    }
  }
  
  public static String handleFordwardDiscName(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    int i = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString2);
    int j = paramString1.length();
    int k = paramQQAppInterface.getApplication().getResources().getInteger(2131427339);
    paramQQAppInterface = paramString1;
    if (j > k)
    {
      paramQQAppInterface = paramString1.substring(0, k);
      paramQQAppInterface = paramQQAppInterface + "...";
    }
    return paramQQAppInterface + "(" + i + ")";
  }
  
  private static void handleForwardComposite(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo)
  {
    Iterator localIterator = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Parcelable)localIterator.next();
      switch (((ForwardUtils.SectionBase)localObject).mForwardType)
      {
      case 0: 
      default: 
        break;
      case -1: 
        if (!TextUtils.isEmpty(((ForwardUtils.SectionText)localObject).mTextString)) {
          nty.a().a = true;
        }
        admh.b(paramQQAppInterface, paramContext, paramSessionInfo, ((ForwardUtils.SectionText)localObject).mTextString);
        break;
      case 1: 
        String str1 = paramIntent.getStringExtra("forward_download_image_task_key");
        String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
        int i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
        String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
        long l = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
        admh.a(paramQQAppInterface, paramActivity, paramSessionInfo, ((ForwardUtils.SectionPic)localObject).mBigURL, str3, str2, l, i, str1);
        localObject = new Message();
        ((Message)localObject).what = 57;
        if (paramMqqHandler != null) {
          paramMqqHandler.sendMessage((Message)localObject);
        }
        break;
      }
    }
  }
  
  public static boolean handleForwardData(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData");
    }
    Object localObject = paramIntent.getParcelableArrayListExtra("forward_multi_target");
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      handleForwardData2MultiTarget(paramQQAppInterface, paramActivity, paramContext, paramIntent, paramMqqHandler, (List)localObject);
    }
    for (;;)
    {
      paramIntent.removeExtra("extra_is_edited_pic");
      paramIntent.removeExtra("key_help_forward_pic");
      paramIntent.removeExtra("key_allow_multiple_forward_from_limit");
      paramIntent.removeExtra("key_allow_forward_photo_preview_edit");
      return true;
      localObject = sessionFromIntent(paramIntent);
      if ((((SessionInfo)localObject).curType == 1) && (((bgkf)paramQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(((SessionInfo)localObject).curFriendUin, true).a))
      {
        QQToast.a(paramQQAppInterface.getApp(), 2131697134, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
        return false;
      }
      int j = paramIntent.getIntExtra("forward_type", 2147483647);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "handleForwardData() forwardType" + j);
      }
      if (j == 2147483647) {
        return false;
      }
      paramIntent.removeExtra("forward_type");
      String str = paramIntent.getStringExtra("forward_filepath");
      int i = paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0);
      switch (j)
      {
      case -4: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      case 22: 
      case 25: 
      case 26: 
      case 27: 
      case 30: 
      case 31: 
      case 33: 
      case 34: 
      case 35: 
      case 38: 
      case 39: 
      case 40: 
      case 41: 
      default: 
        break;
      case -6: 
        bber.a().a(paramQQAppInterface, (SessionInfo)localObject, paramIntent);
        break;
      case -1: 
        handleForwardText(paramQQAppInterface, paramActivity, paramContext, paramIntent, paramMqqHandler, (SessionInfo)localObject, i);
        break;
      case 0: 
        handleForwardFile(paramQQAppInterface, paramActivity, paramContext, paramIntent, (SessionInfo)localObject, str, i);
        break;
      case 1: 
        handleForwardPhoto(paramQQAppInterface, paramActivity, paramIntent, paramMqqHandler, (SessionInfo)localObject, str, i);
        break;
      case 21: 
        if (((SessionInfo)localObject).curType == 9501) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ForwardUtils", 2, "handleForwardData(): ShortVideo => " + paramIntent.getExtras());
        }
        handleForwardShortVideo(paramQQAppInterface, paramIntent, i);
        break;
      case 8: 
        handleForwardPttCenter(paramQQAppInterface, paramMqqHandler, (SessionInfo)localObject, str);
        break;
      case -2: 
        handleForwardMap(paramQQAppInterface, paramContext, paramIntent, (SessionInfo)localObject);
        break;
      case -5: 
        long l = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
        ((awyg)paramQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a((SessionInfo)localObject, l, i);
        break;
      case -3: 
      case 20: 
      case 23: 
      case 24: 
      case 28: 
      case 29: 
      case 36: 
      case 42: 
        handleAppShareAction(paramQQAppInterface, paramContext, (SessionInfo)localObject, paramIntent);
        break;
      case 10: 
        handleForwardComposite(paramQQAppInterface, paramActivity, paramContext, paramIntent, paramMqqHandler, (SessionInfo)localObject);
        break;
      case 32: 
        paramQQAppInterface = zcm.a(paramQQAppInterface, paramIntent.getExtras(), (SessionInfo)localObject);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.f();
        }
        break;
      case 9: 
        handleForwardMarketFace(paramQQAppInterface, paramActivity, paramIntent, (SessionInfo)localObject, i);
        break;
      case 37: 
        paramActivity = paramIntent.getStringExtra("forward_text");
        j = paramIntent.getIntExtra("key_hiboom_id", 0);
        paramContext = new HiBoomMessage();
        paramContext.id = j;
        paramContext.text = paramActivity;
        paramContext.type = paramIntent.getIntExtra("key_hiboom_type", 0);
        admh.a(paramQQAppInterface, (SessionInfo)localObject, paramContext, null, i);
      }
    }
  }
  
  private static boolean handleForwardData2MultiTarget(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler, List<ResultRecord> paramList)
  {
    paramIntent.removeExtra("forward_multi_target");
    int[] arrayOfInt = paramIntent.getIntArrayExtra("KEY_MSG_FORWARD_ID_ARRAY");
    int k = paramList.size();
    int i = 0;
    Intent localIntent;
    if (i < k)
    {
      ResultRecord localResultRecord = (ResultRecord)paramList.get(i);
      localIntent = new Intent(paramIntent);
      localIntent.putExtra("uin", localResultRecord.uin);
      localIntent.putExtra("uintype", localResultRecord.getUinType());
      localIntent.putExtra("troop_uin", localResultRecord.groupUin);
      localIntent.putExtra("uinname", localResultRecord.name);
      localIntent.removeExtra("KEY_MSG_FORWARD_ID_ARRAY");
      if ((arrayOfInt == null) || (arrayOfInt.length <= i)) {
        break label176;
      }
    }
    label176:
    for (int j = arrayOfInt[i];; j = 0)
    {
      localIntent.putExtra("KEY_MSG_FORWARD_ID", j);
      handleForwardData(paramQQAppInterface, paramActivity, paramContext, localIntent, paramMqqHandler);
      i += 1;
      break;
      return true;
    }
  }
  
  public static boolean handleForwardEditedPhoto(Intent paramIntent, SessionInfo paramSessionInfo, String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 1051;
    boolean bool1 = paramIntent.getBooleanExtra("extra_is_edited_pic", false);
    boolean bool3 = paramIntent.getBooleanExtra("forward_send_selfie_face", false);
    boolean bool2 = paramIntent.getBooleanExtra("key_story_photo_to_recent", false);
    int j;
    if ((bool1) || (bool3) || (bool2))
    {
      bool1 = true;
      if (bool1)
      {
        paramIntent.putExtra("uin", paramSessionInfo.curFriendUin);
        paramIntent.putExtra("uintype", paramSessionInfo.curType);
        paramIntent.putExtra("troop_uin", paramSessionInfo.troopUin);
        paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        paramIntent.putExtra("PhotoConst.PHOTO_SEND_PATH", paramString);
        j = aupt.a(paramIntent.getExtras());
        if (j != 100200) {
          break label229;
        }
      }
    }
    for (;;)
    {
      paramSessionInfo = azjv.a(2, i);
      paramSessionInfo.a(azjv.a(i, paramIntent));
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
      ThreadManagerV2.executeOnSubThread(new ForwardUtils.5(paramSessionInfo, paramQQAppInterface));
      return bool1;
      bool1 = false;
      break;
      label229:
      if ((j == 100100) || (j == 100101) || (j == 100300) || (aupt.a(paramIntent.getExtras()))) {
        i = 1048;
      } else if (paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1) == 1041) {
        i = 1048;
      } else if (!bool2) {
        i = 1007;
      }
    }
  }
  
  private static void handleForwardFile(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    ForwardFileInfo localForwardFileInfo;
    String str1;
    String str2;
    int i;
    long l;
    Object localObject2;
    try
    {
      localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
      boolean bool = paramIntent.getBooleanExtra("foward_editbar", false);
      if (!bool) {
        try
        {
          if (paramIntent.getExtras().getBoolean("sendMultiple", false))
          {
            str1 = paramIntent.getStringExtra("uin");
            str2 = paramIntent.getStringExtra("troop_uin");
            i = paramIntent.getIntExtra("uintype", -1);
            localObject1 = (ArrayList)paramIntent.getExtras().get("android.intent.extra.STREAM");
            if (localObject1 == null) {
              return;
            }
            l = 0L;
            localObject2 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject2).hasNext()) {
              l += FileUtil.getFileSize(ForwardFileBaseOption.a(paramContext, (Uri)((Iterator)localObject2).next()));
            }
            if (!auea.a()) {
              break label241;
            }
            audn.a(paramActivity, 2131692476, 2131692481, new ForwardUtils.4((ArrayList)localObject1, paramContext, i, paramQQAppInterface, str1, paramInt, str2));
            return;
          }
        }
        catch (Exception paramContext) {}
      }
      if (bool) {
        break label342;
      }
      if (localForwardFileInfo != null) {
        localForwardFileInfo.jdField_a_of_type_Int = paramInt;
      }
      admh.a(paramQQAppInterface, paramActivity, paramSessionInfo, paramIntent, paramString, localForwardFileInfo, false, paramInt);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (!QLog.isColorLevel()) {
        break label463;
      }
    }
    QLog.d("", 2, "FORWARD_TYPE.FILE failed. " + paramQQAppInterface, paramQQAppInterface);
    return;
    label241:
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ForwardFileBaseOption.a(paramContext, (Uri)((Iterator)localObject1).next());
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        QLog.e("ForwardUtils<FileAssistant>", 1, "mutilSend but localpath is null!");
      }
      else if (i == 1)
      {
        paramQQAppInterface.getFileManagerEngine().a((String)localObject2, str1, 0L, paramInt);
      }
      else
      {
        paramQQAppInterface.getFileManagerEngine().a((String)localObject2, str2, str1, i, true, 0L, paramInt);
        continue;
        label342:
        paramContext = paramIntent.getParcelableArrayListExtra("fileinfo_array");
        l = 0L;
        if ((paramContext != null) && (paramContext.size() > 0)) {
          paramString = paramContext.iterator();
        }
      }
    }
    label463:
    label464:
    for (;;)
    {
      if (paramString.hasNext())
      {
        localForwardFileInfo = (ForwardFileInfo)paramString.next();
        if (localForwardFileInfo.d() == 3)
        {
          l = localForwardFileInfo.d() + l;
          break label464;
        }
      }
      else
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          paramString = (ForwardFileInfo)paramContext.next();
          admh.a(paramQQAppInterface, paramActivity, paramSessionInfo, paramIntent, paramString.a(), paramString, true, paramInt);
        }
      }
      break label464;
      return;
    }
  }
  
  private static void handleForwardMap(QQAppInterface paramQQAppInterface, Context paramContext, Intent paramIntent, SessionInfo paramSessionInfo)
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
        admh.a(paramContext, paramQQAppInterface, paramSessionInfo, str1, str2, str3, str4, str5, "", "", "", "", paramIntent);
      }
      return;
    }
    admh.a(paramQQAppInterface, paramSessionInfo, paramIntent.getStringExtra("forward_latitude"), paramIntent.getStringExtra("forward_longitude"), paramIntent.getStringExtra("forward_location"));
  }
  
  private static void handleForwardMarketFace(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, SessionInfo paramSessionInfo, int paramInt)
  {
    if (2 == ahaw.c)
    {
      bdla.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
      if (!paramIntent.getBooleanExtra("forward_emotion_from_preview", false)) {
        break label128;
      }
    }
    label128:
    for (paramIntent = AIOEmotionFragment.a;; paramIntent = ahaw.a)
    {
      nty.a().a = true;
      if (paramIntent != null) {
        paramIntent.send(paramQQAppInterface, paramActivity, null, paramSessionInfo, true, paramInt);
      }
      return;
      bdla.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
      break;
    }
  }
  
  private static void handleForwardPhoto(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    boolean bool1 = paramIntent.getBooleanExtra("isFromShare", false);
    boolean bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData() photograph isFromShare" + bool1);
    }
    String str1;
    long l1;
    if (bool1) {
      if (!bool2)
      {
        bool1 = paramIntent.getBooleanExtra("FORWARD_IS_EDITED", false);
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "handleForwardData() photograph isEdited" + bool1);
        }
        if (!bool1)
        {
          str1 = paramIntent.getStringExtra("forward_download_image_task_key");
          String str2 = paramIntent.getStringExtra("forward_download_image_org_uin");
          i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          String str3 = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          paramIntent = new Message();
          paramIntent.what = 56;
          if (paramMqqHandler != null) {
            paramMqqHandler.sendMessage(paramIntent);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ForwardUtils", 2, "[@]call sendPic start!");
          }
          ThreadManager.post(new ForwardUtils.1(paramQQAppInterface, paramActivity, paramSessionInfo, paramString, str3, str2, l1, i, str1, paramInt, paramMqqHandler), 8, null, false);
          if (QLog.isColorLevel()) {
            QLog.d("ForwardUtils", 2, "[@]call sendPic end!");
          }
        }
      }
    }
    do
    {
      return;
      if (!handleForwardEditedPhoto(paramIntent, paramSessionInfo, paramString, paramQQAppInterface)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardUtils", 2, "handleForwardEditedPhoto = " + paramString);
    return;
    paramIntent.putExtra("FORWARD_UIN_TYPE", paramSessionInfo.curType);
    paramIntent.putExtra("SENDER_TROOP_UIN", paramSessionInfo.troopUin);
    paramIntent.putExtra("FORWARD_PEER_UIN", paramSessionInfo.curFriendUin);
    paramIntent.putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
    int i = paramIntent.getIntExtra("BUSI_TYPE", 1009);
    int j = paramIntent.getIntExtra("forward_source_uin_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardUtils", 2, "report forward! forwardFilePath = " + paramString + ",forwardSourceUinType = " + j);
    }
    if (paramString != null)
    {
      l1 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l2 = paramIntent.getLongExtra("forward_image_height", 0L);
      int k = paramIntent.getIntExtra("forward_image_type", 0);
      ThreadManager.executeOnFileThread(new ForwardUtils.2(AppConstants.SDCARD_AIO_FORWARD + "#" + l1 + "#" + l2 + "#" + k, paramSessionInfo, j, paramQQAppInterface));
    }
    paramMqqHandler = azjv.a(i, paramIntent);
    paramActivity = azjv.a(3, i);
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
    addStickerExtraData(paramIntent, paramActivity);
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
      str1 = paramIntent.getStringExtra("widgetinfo");
      if (!TextUtils.isEmpty(paramString)) {
        paramMqqHandler.textSummary = paramString;
      }
      paramMqqHandler.mTemplateId = str1;
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
    new aijb().a(paramQQAppInterface, paramSessionInfo, paramActivity);
    paramActivity.c = paramInt;
    ThreadManagerV2.executeOnSubThread(new ForwardUtils.3(paramActivity, paramQQAppInterface));
  }
  
  private static void handleForwardPttCenter(QQAppInterface paramQQAppInterface, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, String paramString)
  {
    if (admh.a(paramQQAppInterface, paramSessionInfo, paramString) != -1L)
    {
      paramQQAppInterface = new Message();
      paramQQAppInterface.what = 57;
      if (paramMqqHandler != null) {
        paramMqqHandler.sendMessage(paramQQAppInterface);
      }
    }
  }
  
  private static void handleForwardShortVideo(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    int i = 2;
    int j = paramIntent.getIntExtra("from_busi_type", 0);
    if (j == 1) {}
    for (;;)
    {
      bcxr localbcxr = bcwz.a(3, i);
      paramIntent = bcwz.a(i, paramIntent, localbcxr);
      if (paramIntent != null) {
        paramIntent.p = paramInt;
      }
      localbcxr.a(paramIntent);
      bcwz.a(localbcxr, paramQQAppInterface);
      return;
      if (j == 2) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  private static void handleForwardText(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler, SessionInfo paramSessionInfo, int paramInt)
  {
    Object localObject;
    boolean bool1;
    boolean bool2;
    if (paramSessionInfo.curType == 9501)
    {
      paramContext = paramIntent.getStringExtra("forward_text");
      paramMqqHandler = (abkw)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      localObject = (abgm)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if (!TextUtils.isEmpty(paramContext))
      {
        paramSessionInfo.curFriendUin = paramIntent.getStringExtra("uin");
        paramSessionInfo.curType = paramIntent.getIntExtra("uintype", -1);
        bool1 = ((abgm)localObject).a(Long.parseLong(paramSessionInfo.curFriendUin)).booleanValue();
        paramIntent = ((abgm)localObject).a(Long.parseLong(paramSessionInfo.curFriendUin));
        bool2 = SettingCloneUtil.readValue(paramActivity, paramSessionInfo.curFriendUin, null, "devicemsg_openchat_firsttrue", false);
        if ((bool2) || ((paramIntent.SSOBid_Platform != 1027) && ((StringUtil.isEmpty(paramIntent.SSOBid_Version)) || (Double.valueOf(paramIntent.SSOBid_Version).doubleValue() < 1.1D)))) {
          break label207;
        }
        paramInt = 1;
        SettingCloneUtil.writeValue(paramActivity, paramSessionInfo.curFriendUin, null, "devicemsg_openchat_firsttrue", true);
      }
    }
    for (;;)
    {
      if ((bool1) && (paramInt != 0))
      {
        bool1 = true;
        label195:
        paramMqqHandler.a(paramQQAppInterface, paramSessionInfo, paramContext, bool1);
      }
      label207:
      do
      {
        boolean[] arrayOfBoolean;
        String str;
        do
        {
          return;
          if ((!bool2) && (!bool1)) {
            break label421;
          }
          paramInt = 1;
          break;
          bool1 = false;
          break label195;
          paramActivity = paramIntent.getStringExtra("forward_text");
          if (!TextUtils.isEmpty(paramActivity)) {
            nty.a().a = true;
          }
          localObject = new admo();
          ((admo)localObject).j = true;
          arrayOfBoolean = paramIntent.getBooleanArrayExtra("forward_is_write_together");
          str = paramIntent.getStringExtra("uin");
          paramIntent = paramIntent.getBooleanArrayExtra("forward_write_together_is_expired");
        } while ((arrayOfBoolean != null) && (arrayOfBoolean[0] != 0) && (paramSessionInfo.curType == 1) && (str.equals(paramSessionInfo.curFriendUin)) && (paramIntent != null) && (paramIntent[0] == 0));
        paramContext = admh.a(paramQQAppInterface, paramContext, paramSessionInfo, paramActivity, null, (admo)localObject);
        if ((paramContext != null) && (paramContext.length > 0) && (paramInt > 0))
        {
          long l = paramContext[0];
          agfe.a().a(l, 0L, paramInt);
          agfe.a().a(paramQQAppInterface, l, paramInt);
        }
        paramQQAppInterface = new Message();
        paramQQAppInterface.what = 55;
        paramQQAppInterface.obj = paramActivity;
      } while (paramMqqHandler == null);
      paramMqqHandler.sendMessage(paramQQAppInterface);
      return;
      label421:
      paramInt = 0;
    }
  }
  
  public static boolean hasSDPermission(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isAsyncShareSupport(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = sAsyncShareForwardTypes;
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
  
  public static boolean isImageLocalShare(AbsStructMsg paramAbsStructMsg)
  {
    return ((paramAbsStructMsg instanceof StructMsgForImageShare)) && (!auui.a());
  }
  
  public static boolean isShareProcessorSuccess(azlb paramazlb)
  {
    if (paramazlb.jdField_a_of_type_Int != 0) {
      return false;
    }
    paramazlb = (String[])paramazlb.jdField_a_of_type_JavaLangObject;
    if ((paramazlb != null) && (paramazlb.length == 2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void jumpToMainFragment(Activity paramActivity, Intent paramIntent, Bundle paramBundle)
  {
    paramIntent.putExtra("k_from_login", true);
    paramIntent.putExtra("sdk_mult_share", true);
    AIOUtils.setOpenAIOIntent(paramIntent, new int[] { 2 });
    paramIntent.putExtra("open_chatfragment", false);
    paramIntent.putExtra("fragment_id", 1);
    paramIntent.putExtras(paramBundle);
    paramActivity.startActivity(paramIntent);
    finishRecentActivity(paramActivity);
  }
  
  public static void jumpToMainFragment4Local(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("sdk_mult_share_for_local", true);
    jumpToMainFragment(paramActivity, localIntent, paramBundle);
  }
  
  public static void jumpToMainFragment4Server(Activity paramActivity, Bundle paramBundle, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("sdk_mult_share_result_code", 3);
    localIntent.putExtra("sdk_mult_share_error_wording", paramString);
    jumpToMainFragment(paramActivity, localIntent, paramBundle);
  }
  
  private static boolean needSendComment(List<oidb_cmd0xdc2.BatchSendRsp> paramList, String paramString)
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
        QLog.d("ForwardUtils", 1, new Object[] { "needSendComment uin=", bjhh.a(paramString), ", err_code=", Integer.valueOf(localBatchSendRsp.err_code.get()) });
        return false;
      }
    }
    return true;
  }
  
  public static void onForwardActivityResult(QQAppInterface paramQQAppInterface, Intent paramIntent, Activity paramActivity)
  {
    paramIntent.putExtra("selfSet_leftViewText", paramQQAppInterface.getApplication().getString(2131719161));
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramIntent.getExtras()));
    handleForwardData(paramQQAppInterface, paramActivity, paramActivity, localIntent, null);
  }
  
  public static int parseInt(String paramString)
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
  
  public static long parseLong(String paramString)
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
      QLog.e("ForwardUtils", 1, new Object[] { "parseLong text = ", paramString });
    }
    return 0L;
  }
  
  public static oidb_0xd55.RspBody parseOIDBD55RspBody(byte[] paramArrayOfByte)
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
  
  public static Object[] parseOIDBb77RspBody(byte[] paramArrayOfByte)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = "";
    arrayOfObject[2] = auui.a;
    arrayOfObject[3] = "";
    if (paramArrayOfByte == null)
    {
      QLog.e("ForwardUtils", 1, "parseOIDBb77RspBody onError data == null");
      return arrayOfObject;
    }
    oidb_cmd0xb77.RspBody localRspBody = new oidb_cmd0xb77.RspBody();
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        arrayOfObject[0] = Integer.valueOf(localRspBody.jump_result.get());
        if (localRspBody.jump_url.has())
        {
          paramArrayOfByte = localRspBody.jump_url.get();
          arrayOfObject[1] = paramArrayOfByte;
          if (!localRspBody.wording.has()) {
            break label207;
          }
          paramArrayOfByte = localRspBody.wording.get();
          arrayOfObject[2] = paramArrayOfByte;
          if (!localRspBody.develop_msg.has()) {
            break label214;
          }
          paramArrayOfByte = localRspBody.develop_msg.get();
          arrayOfObject[3] = paramArrayOfByte;
          QLog.d("ForwardUtils", 1, new Object[] { "parseOIDBb77RspBody  jumpResult =", arrayOfObject[0], ", jumpUrl = ", arrayOfObject[1], ", wording =", arrayOfObject[2] });
          return arrayOfObject;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("ForwardUtils", 1, "onError msg =", paramArrayOfByte);
        return arrayOfObject;
      }
      paramArrayOfByte = "";
      continue;
      label207:
      paramArrayOfByte = auui.a;
      continue;
      label214:
      paramArrayOfByte = "";
    }
  }
  
  public static List<oidb_cmd0xdc2.BatchSendRsp> parseOIDBdc2RspBody(byte[] paramArrayOfByte)
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
  
  public static void report(QQAppInterface paramQQAppInterface, String paramString, int paramInt, String... paramVarArgs)
  {
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    if (paramVarArgs == null) {}
    for (;;)
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", paramString, paramString, paramInt, 0, str1, str2, str3, str4);
      return;
      if (paramVarArgs.length == 1)
      {
        str1 = paramVarArgs[0];
      }
      else if (paramVarArgs.length == 2)
      {
        str1 = paramVarArgs[0];
        str2 = paramVarArgs[1];
      }
      else if (paramVarArgs.length == 3)
      {
        str1 = paramVarArgs[0];
        str2 = paramVarArgs[1];
        str3 = paramVarArgs[2];
      }
      else if (paramVarArgs.length == 4)
      {
        str1 = paramVarArgs[0];
        str2 = paramVarArgs[1];
        str3 = paramVarArgs[2];
        str4 = paramVarArgs[3];
      }
    }
  }
  
  public static void report(QQAppInterface paramQQAppInterface, String paramString, String... paramVarArgs)
  {
    report(paramQQAppInterface, paramString, 0, paramVarArgs);
  }
  
  public static void reportAuthorityTotal(int paramInt, bjpl parambjpl)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_ERROR_CODE", Integer.toString(paramInt));
    auuv.a("KEY_LOGIN_STAGE_3_TOTAL", parambjpl);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      auuv.a("KEY_AUTHORITY_TOTAL", parambjpl, localHashMap, bool);
      return;
    }
  }
  
  public static void reportLoginResult(int paramInt, String paramString1, String paramString2)
  {
    QLog.d("ForwardUtils", 1, new Object[] { "reportLoginResult, errorCode=", Integer.valueOf(paramInt), ", appId=", paramString1, ", uin=*", bjhh.a(paramString2) });
    if (paramInt == 0) {}
    for (String str = "0";; str = "1") {
      try
      {
        bjgx.a().a(paramString2, "", paramString1, "1", "3", str, true, true);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("ForwardUtils", 1, "reportLoginResult, error: ", paramString1);
      }
    }
  }
  
  public static String reqTypeToReportData(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return "0";
    case 1: 
      return "1";
    case 2: 
      return "2";
    case 4: 
      return "3";
    case 5: 
      return "4";
    }
    return "5";
  }
  
  public static void sendCommentMsg(List<ResultRecord> paramList, List<oidb_cmd0xdc2.BatchSendRsp> paramList1, Context paramContext, String paramString)
  {
    QLog.d("ForwardUtils", 1, new Object[] { "sendCommentMsg: invoked textAndEmoji : ", paramString });
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramList.next();
        if (needSendComment(paramList1, localResultRecord.uin))
        {
          SessionInfo localSessionInfo = new SessionInfo();
          localSessionInfo.curType = localResultRecord.getUinType();
          localSessionInfo.curFriendUin = localResultRecord.uin;
          localSessionInfo.troopUin = localResultRecord.groupUin;
          admh.b(localQQAppInterface, paramContext, localSessionInfo, paramString);
        }
      }
    }
  }
  
  public static SessionInfo sessionFromIntent(Intent paramIntent)
  {
    return sessionFromIntent(paramIntent.getExtras());
  }
  
  public static SessionInfo sessionFromIntent(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    return sessionFromIntent(paramIntent.getExtras(), paramString1, paramInt, paramString2);
  }
  
  public static SessionInfo sessionFromIntent(Bundle paramBundle)
  {
    String str2 = null;
    int i = -1;
    String str1;
    if (paramBundle == null)
    {
      str1 = null;
      if (paramBundle != null) {
        break label37;
      }
      label14:
      if (paramBundle != null) {
        break label49;
      }
    }
    for (;;)
    {
      return sessionFromIntent(paramBundle, str1, i, str2);
      str1 = paramBundle.getString("uin");
      break;
      label37:
      i = paramBundle.getInt("uintype", -1);
      break label14;
      label49:
      str2 = paramBundle.getString("troop_uin");
    }
  }
  
  public static SessionInfo sessionFromIntent(Bundle paramBundle, String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.curFriendUin = paramString1;
    localSessionInfo.curType = paramInt;
    if (localSessionInfo.curType == 1026)
    {
      localSessionInfo.curType = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    if (paramBundle == null)
    {
      paramString1 = null;
      localSessionInfo.phoneNum = paramString1;
      if (paramBundle != null) {
        break label112;
      }
      paramInt = 0;
      label72:
      localSessionInfo.entrance = paramInt;
      localSessionInfo.troopUin = paramString2;
      if (paramBundle != null) {
        break label124;
      }
    }
    label112:
    label124:
    for (paramInt = 3999;; paramInt = paramBundle.getInt("add_friend_source_id", 3999))
    {
      localSessionInfo.addFriendSourceId = paramInt;
      return localSessionInfo;
      paramString1 = paramBundle.getString("phonenum");
      break;
      paramInt = paramBundle.getInt("entrance", 0);
      break label72;
    }
  }
  
  @TargetApi(17)
  public static void showDialog(String paramString, Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      if (Build.VERSION.SDK_INT < 17) {
        break label58;
      }
      if (!paramActivity.isDestroyed()) {
        bhdj.b(paramActivity, 230).setMessageWithUrl(paramString).setTitle(paramActivity.getString(2131718185)).setPositiveButton(17039370, paramOnClickListener).show();
      }
    }
    return;
    label58:
    bhdj.b(paramActivity, 230).setMessageWithUrl(paramString).setTitle(paramActivity.getString(2131718185)).setPositiveButton(17039370, paramOnClickListener).show();
  }
  
  public static String toType(int paramInt)
  {
    if (paramInt == 0) {
      return "1";
    }
    if (1 == paramInt) {
      return "2";
    }
    if (3000 == paramInt) {
      return "3";
    }
    return "0";
  }
  
  public static String toTypeSimple(int paramInt)
  {
    if (paramInt == 0) {
      return "1";
    }
    if ((1 == paramInt) || (3000 == paramInt)) {
      return "2";
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils
 * JD-Core Version:    0.7.0.1
 */