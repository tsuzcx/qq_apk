package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
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
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import ulk;
import ull;
import ulm;

public class ForwardUtils
{
  private static int[] a = { 11, 2 };
  
  public static URLDrawable a(Context paramContext, MessageForPic paramMessageForPic)
  {
    return AIORichMediaInfo.a(paramMessageForPic);
  }
  
  public static SessionInfo a(Intent paramIntent)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    if (localSessionInfo.jdField_a_of_type_Int == 1026)
    {
      localSessionInfo.jdField_a_of_type_Int = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    localSessionInfo.e = paramIntent.getStringExtra("phonenum");
    localSessionInfo.c = paramIntent.getIntExtra("entrance", 0);
    localSessionInfo.b = paramIntent.getStringExtra("troop_uin");
    localSessionInfo.d = paramIntent.getIntExtra("add_friend_source_id", 3999);
    return localSessionInfo;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return "";
    }
    int i = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString2);
    int j = paramString1.length();
    int k = paramQQAppInterface.getApplication().getResources().getInteger(2131689477);
    paramQQAppInterface = paramString1;
    if (j > k)
    {
      paramQQAppInterface = paramString1.substring(0, k);
      paramQQAppInterface = paramQQAppInterface + "...";
    }
    return paramQQAppInterface + "(" + i + ")";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleAppShareAction() type" + paramSessionInfo.jdField_a_of_type_Int + "uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString);
    }
    try
    {
      localAbsStructMsg = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
      if (localAbsStructMsg == null) {
        return;
      }
      localAbsStructMsg.sourceAccoutType = paramIntent.getIntExtra("accostType", 0);
      str1 = paramIntent.getStringExtra("share_comment_message");
      if (localAbsStructMsg.mMsgServiceID == 83) {
        localAbsStructMsg.mMsgActionData = "";
      }
      if ((localAbsStructMsg.mMsgServiceID == 108) || (localAbsStructMsg.mMsgServiceID == 114) || (localAbsStructMsg.mMsgServiceID == 116)) {
        localAbsStructMsg.mMsgActionData = "";
      }
      if (!(localAbsStructMsg instanceof StructMsgForImageShare)) {
        break label304;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        AbsStructMsg localAbsStructMsg;
        String str1;
        int i;
        String str2;
        if (QLog.isColorLevel()) {
          QLog.d("ForwardUtils", 2, "handleAppShareAction Exception", paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        return;
        ShareMsgHelper.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, localAbsStructMsg, null);
      }
    }
    finally
    {
      paramIntent.removeExtra("forward_type");
      paramIntent.removeExtra("res_share_id");
    }
    if (((localAbsStructMsg instanceof StructMsgForGeneralShare)) && (CGILoader.a((AbsShareMsg)localAbsStructMsg)))
    {
      i = localAbsStructMsg.uinType;
      str2 = CGILoader.a(localAbsStructMsg.mMsgUrl);
      if ((str2 != null) && (!str2.equals(""))) {
        ReportController.b(null, "CliOper", "", "", "0X8005F54", "0X8005F54", 0, 0, CGILoader.a(i) + "", "", str2, "");
      }
    }
    if (TextUtils.isEmpty(str1)) {
      str1 = localAbsStructMsg.mCommentText;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str1))
      {
        AnonymousChatHelper.a().a = true;
        ChatActivityFacade.b(paramQQAppInterface, paramContext, paramSessionInfo, str1);
      }
      paramIntent.removeExtra("forward_type");
      paramIntent.removeExtra("res_share_id");
      return;
      label304:
      if (((localAbsStructMsg instanceof AbsShareMsg)) && (a(((AbsShareMsg)localAbsStructMsg).forwardType, localAbsStructMsg.mMsgServiceID))) {
        break;
      }
      if (35 == localAbsStructMsg.mMsgServiceID)
      {
        long l = paramIntent.getLongExtra("structmsg_uniseq", 0L);
        i = paramIntent.getIntExtra("forward_msg_from_together", 0);
        MultiMsgManager.a().a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b, localAbsStructMsg, l, false, i);
        break;
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if ((paramInt1 == arrayOfInt[i]) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 6))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, Context paramContext, Intent paramIntent, MqqHandler paramMqqHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData");
    }
    SessionInfo localSessionInfo = a(paramIntent);
    if ((localSessionInfo.jdField_a_of_type_Int == 1) && (((TroopGagMgr)paramQQAppInterface.getManager(47)).a(localSessionInfo.jdField_a_of_type_JavaLangString, true).a))
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131430273, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return false;
    }
    int i = paramIntent.getIntExtra("forward_type", 2147483647);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "handleForwardData() forwardType" + i);
    }
    if (i == 2147483647) {
      return false;
    }
    paramIntent.removeExtra("forward_type");
    Object localObject1 = paramIntent.getStringExtra("forward_filepath");
    boolean bool1;
    boolean bool2;
    label480:
    Object localObject2;
    label523:
    String str;
    Object localObject3;
    Object localObject4;
    long l1;
    switch (i)
    {
    default: 
    case -1: 
    case 0: 
      label930:
      do
      {
        for (;;)
        {
          return true;
          if (localSessionInfo.jdField_a_of_type_Int == 9501)
          {
            paramContext = paramIntent.getStringExtra("forward_text");
            paramMqqHandler = (DeviceMsgHandle)paramQQAppInterface.a(49);
            localObject1 = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
            if (!TextUtils.isEmpty(paramContext))
            {
              localSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
              localSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
              bool1 = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString)).booleanValue();
              paramIntent = ((SmartDeviceProxyMgr)localObject1).a(Long.parseLong(localSessionInfo.jdField_a_of_type_JavaLangString));
              bool2 = SettingCloneUtil.readValue(paramActivity, localSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", false);
              if ((!bool2) && ((paramIntent.SSOBid_Platform == 1027) || ((!StringUtil.a(paramIntent.SSOBid_Version)) && (Double.valueOf(paramIntent.SSOBid_Version).doubleValue() >= 1.1D))))
              {
                i = 1;
                SettingCloneUtil.writeValue(paramActivity, localSessionInfo.jdField_a_of_type_JavaLangString, null, "devicemsg_openchat_firsttrue", true);
                if ((!bool1) || (i == 0)) {
                  break label523;
                }
              }
              for (bool1 = true;; bool1 = false)
              {
                paramMqqHandler.a(paramQQAppInterface, localSessionInfo, paramContext, bool1);
                break;
                if ((!bool2) && (!bool1)) {
                  break label2309;
                }
                i = 1;
                break label480;
              }
            }
          }
          else
          {
            paramActivity = paramIntent.getStringExtra("forward_text");
            if (!TextUtils.isEmpty(paramActivity)) {
              AnonymousChatHelper.a().a = true;
            }
            paramIntent = new ChatActivityFacade.SendMsgParams();
            paramIntent.h = true;
            ChatActivityFacade.a(paramQQAppInterface, paramContext, localSessionInfo, paramActivity, null, paramIntent);
            paramQQAppInterface = new Message();
            paramQQAppInterface.what = 55;
            paramQQAppInterface.obj = paramActivity;
            if (paramMqqHandler != null)
            {
              paramMqqHandler.sendMessage(paramQQAppInterface);
              continue;
              try
              {
                paramMqqHandler = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
                bool1 = paramIntent.getBooleanExtra("foward_editbar", false);
                if (!bool1) {
                  try
                  {
                    if (paramIntent.getExtras().getBoolean("sendMultiple", false))
                    {
                      localObject2 = paramIntent.getStringExtra("uin");
                      str = paramIntent.getStringExtra("troop_uin");
                      i = paramIntent.getIntExtra("uintype", -1);
                      localObject3 = (ArrayList)paramIntent.getExtras().get("android.intent.extra.STREAM");
                      if (localObject3 == null) {
                        continue;
                      }
                      localObject4 = ((ArrayList)localObject3).iterator();
                      for (l1 = 0L; ((Iterator)localObject4).hasNext(); l1 = FileUtil.a(ForwardFileBaseOption.a(paramContext, (Uri)((Iterator)localObject4).next())) + l1) {}
                      if (!FileManagerUtil.a()) {
                        break;
                      }
                      FMDialogUtil.a(paramActivity, 2131428241, 2131428237, new ulk((ArrayList)localObject3, paramContext, i, paramQQAppInterface, (String)localObject2, str));
                    }
                  }
                  catch (Exception paramContext) {}
                }
                if (bool1) {
                  break label930;
                }
                ChatActivityFacade.a(paramQQAppInterface, paramActivity, localSessionInfo, paramIntent, (String)localObject1, paramMqqHandler, false);
              }
              catch (Exception paramQQAppInterface) {}
              if (QLog.isColorLevel()) {
                QLog.d("", 2, "FORWARD_TYPE.FILE failed. " + paramQQAppInterface, paramQQAppInterface);
              }
            }
          }
        }
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ForwardFileBaseOption.a(paramContext, (Uri)((Iterator)localObject3).next());
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            QLog.e("ForwardUtils<FileAssistant>", 1, "mutilSend but localpath is null!");
          } else if (i == 1) {
            paramQQAppInterface.a().a((String)localObject4, (String)localObject2);
          } else {
            paramQQAppInterface.a().a((String)localObject4, str, (String)localObject2, i, true);
          }
        }
        paramContext = paramIntent.getParcelableArrayListExtra("fileinfo_array");
        l1 = 0L;
      } while ((paramContext == null) || (paramContext.size() <= 0));
      paramMqqHandler = paramContext.iterator();
    }
    label2309:
    label2315:
    for (;;)
    {
      if (paramMqqHandler.hasNext())
      {
        localObject1 = (ForwardFileInfo)paramMqqHandler.next();
        if (((ForwardFileInfo)localObject1).d() == 3)
        {
          l1 = ((ForwardFileInfo)localObject1).d() + l1;
          break label2315;
        }
      }
      else
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          paramMqqHandler = (ForwardFileInfo)paramContext.next();
          ChatActivityFacade.a(paramQQAppInterface, paramActivity, localSessionInfo, paramIntent, paramMqqHandler.a(), paramMqqHandler, true);
        }
        bool1 = paramIntent.getBooleanExtra("isFromShare", false);
        bool2 = paramIntent.getBooleanExtra("sendMultiple", false);
        if (QLog.isColorLevel()) {
          QLog.d("forward", 2, "handleForwardData() photograph isFromShare" + bool1);
        }
        if (bool1)
        {
          if (bool2) {
            break;
          }
          bool1 = paramIntent.getBooleanExtra("FORWARD_IS_EDITED", false);
          if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "handleForwardData() photograph isEdited" + bool1);
          }
          if (bool1) {
            break;
          }
          paramContext = paramIntent.getStringExtra("forward_download_image_task_key");
          localObject2 = paramIntent.getStringExtra("forward_download_image_org_uin");
          i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
          str = paramIntent.getStringExtra("forward_download_image_server_path");
          l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
          paramIntent = new Message();
          paramIntent.what = 56;
          if (paramMqqHandler != null) {
            paramMqqHandler.sendMessage(paramIntent);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ForwardUtils", 2, "[@]call sendPic start!");
          }
          ThreadManager.post(new ull(paramQQAppInterface, paramActivity, localSessionInfo, (String)localObject1, str, (String)localObject2, l1, i, paramContext, paramMqqHandler), 8, null, false);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ForwardUtils", 2, "[@]call sendPic end!");
          break;
        }
        if (paramIntent.getBooleanExtra("FORWARD_IS_EDITED", false)) {
          break;
        }
        paramIntent.putExtra("FORWARD_UIN_TYPE", localSessionInfo.jdField_a_of_type_Int);
        paramIntent.putExtra("SENDER_TROOP_UIN", localSessionInfo.b);
        paramIntent.putExtra("FORWARD_PEER_UIN", localSessionInfo.jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("FORWARD_SELF_UIN", paramQQAppInterface.getCurrentAccountUin());
        i = paramIntent.getIntExtra("BUSI_TYPE", 1009);
        int j = paramIntent.getIntExtra("forward_source_uin_type", -1);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardUtils", 2, "report forward! forwardFilePath = " + (String)localObject1 + ",forwardSourceUinType = " + j);
        }
        if (localObject1 != null)
        {
          l1 = paramIntent.getLongExtra("forward_image_width", 0L);
          long l2 = paramIntent.getLongExtra("forward_image_height", 0L);
          int k = paramIntent.getIntExtra("forward_image_type", 0);
          ThreadManager.executeOnFileThread(new ulm(AppConstants.aT + "#" + l1 + "#" + l2 + "#" + k, localSessionInfo, j, paramQQAppInterface));
        }
        paramContext = PicBusiManager.a(i, paramIntent);
        paramActivity = PicBusiManager.a(3, i);
        paramActivity.a(paramContext);
        if (paramIntent.getBooleanExtra("forward_is_custom_face", false))
        {
          paramContext = new PicMessageExtraData();
          paramContext.imageBizType = 1;
          paramContext.customFaceType = paramIntent.getIntExtra("forward_cutsom_face_type", 0);
          paramContext.emojiPkgId = paramIntent.getStringExtra("forward_diy_package_id");
          if (paramContext.emojiPkgId == null) {
            paramContext.emojiPkgId = "";
          }
          paramActivity.a = paramContext;
        }
        if (paramIntent.getBooleanExtra("HOT_PIC_HAS_EXTRA", false))
        {
          paramContext = new PicMessageExtraData();
          paramContext.imageBizType = 2;
          paramActivity.a = paramContext;
        }
        PicBusiManager.a(paramActivity, paramQQAppInterface);
        break;
        if (localSessionInfo.jdField_a_of_type_Int == 9501) {
          return true;
        }
        if (paramIntent.getBooleanExtra("isFromFavorite", false)) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ForwardUtils", 2, "handleForwardData(): ShortVideo => " + paramIntent.getExtras());
        }
        i = paramIntent.getIntExtra("from_busi_type", 0);
        if (i == 1) {
          i = 2;
        }
        for (;;)
        {
          paramActivity = ShortVideoBusiManager.a(3, i);
          paramActivity.a(ShortVideoBusiManager.a(i, paramIntent, paramActivity));
          ShortVideoBusiManager.a(paramActivity, paramQQAppInterface);
          break;
          if (i == 2) {
            i = 3;
          } else {
            i = 0;
          }
        }
        if (ChatActivityFacade.a(paramQQAppInterface, localSessionInfo, (String)localObject1) == -1L) {
          break;
        }
        paramQQAppInterface = new Message();
        paramQQAppInterface.what = 57;
        if (paramMqqHandler == null) {
          break;
        }
        paramMqqHandler.sendMessage(paramQQAppInterface);
        break;
        if (paramIntent.getBooleanExtra("isFromFavorites", false))
        {
          paramActivity = paramIntent.getExtras();
          if (paramActivity == null) {
            break;
          }
          ChatActivityFacade.a(paramContext, paramQQAppInterface, localSessionInfo, paramActivity.getString("forward_latitude"), paramActivity.getString("forward_longitude"), paramActivity.getString("forward_location"), paramActivity.getString("title"), paramActivity.getString("summary"), "", "", "", "", null);
          break;
        }
        ChatActivityFacade.a(paramQQAppInterface, localSessionInfo, paramIntent.getStringExtra("forward_latitude"), paramIntent.getStringExtra("forward_longitude"), paramIntent.getStringExtra("forward_location"));
        break;
        l1 = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
        ((MixedMsgManager)paramQQAppInterface.getManager(173)).a(localSessionInfo, l1);
        break;
        a(paramQQAppInterface, paramContext, localSessionInfo, paramIntent);
        break;
        localObject1 = paramIntent.getExtras().getParcelableArrayList("forward_composite").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Parcelable)((Iterator)localObject1).next();
          switch (((ForwardUtils.SectionBase)localObject2).jdField_a_of_type_Int)
          {
          case 0: 
          default: 
            break;
          case -1: 
            if (!TextUtils.isEmpty(((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString)) {
              AnonymousChatHelper.a().a = true;
            }
            ChatActivityFacade.b(paramQQAppInterface, paramContext, localSessionInfo, ((ForwardUtils.Section_Text)localObject2).jdField_a_of_type_JavaLangString);
            break;
          case 1: 
            str = paramIntent.getStringExtra("forward_download_image_task_key");
            localObject3 = paramIntent.getStringExtra("forward_download_image_org_uin");
            i = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
            localObject4 = paramIntent.getStringExtra("forward_download_image_server_path");
            l1 = paramIntent.getLongExtra("forward_download_image_item_id", -1L);
            ChatActivityFacade.a(paramQQAppInterface, paramActivity, localSessionInfo, ((ForwardUtils.Section_Pic)localObject2).b, (String)localObject4, (String)localObject3, l1, i, str);
            localObject2 = new Message();
            ((Message)localObject2).what = 57;
            if (paramMqqHandler != null) {
              paramMqqHandler.sendMessage((Message)localObject2);
            }
            break;
          }
        }
        if (2 == MarketFaceItemBuilder.b) {
          ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          paramContext = MarketFaceItemBuilder.a;
          AnonymousChatHelper.a().a = true;
          if (paramContext == null) {
            break;
          }
          paramContext.a(paramQQAppInterface, paramActivity, null, localSessionInfo, true);
          break;
          ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity.getIntent().getStringExtra("uin"), "ep_mall", "Ep_detail_send_aio", 0, 0, "", "", "", "");
        }
        paramQQAppInterface = TroopStoryForwardTask.a(paramQQAppInterface, paramIntent.getExtras(), localSessionInfo);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.f();
        break;
      }
      break label2315;
      i = 0;
      break label480;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ForwardUtils
 * JD-Core Version:    0.7.0.1
 */