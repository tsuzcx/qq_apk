package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArraySet;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.miniaio.MiniChatMsgProxy;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.RoleIdUtil;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.jubao.JubaoApiPlugin;
import com.tencent.mobileqq.jubao.JubaoIPCServer;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.gameroom.WerewolvesMsgUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class BaseChatpieHelper
{
  private static ArraySet<Integer> jdField_a_of_type_AndroidSupportV4UtilArraySet;
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public boolean a;
  public boolean b = false;
  
  public BaseChatpieHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
  }
  
  @NotNull
  private CharSequence a(Intent paramIntent, Message paramMessage, CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject = TroopBusinessUtil.a(paramMessage);
    if (localObject != null) {
      paramMessage.nickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
    }
    if (paramMessage.istroop == 10007)
    {
      paramIntent = ((GameMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(RoleIdUtil.b(paramMessage));
      if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.f))) {
        localSpannableStringBuilder.append(HardCodeUtil.a(2131692836));
      }
    }
    for (;;)
    {
      if (paramCharSequence != null)
      {
        localSpannableStringBuilder.append("：");
        localSpannableStringBuilder.append(paramCharSequence);
      }
      return localSpannableStringBuilder;
      localSpannableStringBuilder.append(paramIntent.f);
      continue;
      if (paramMessage.nickName != null)
      {
        if (paramMessage.nickName.equals(this.jdField_a_of_type_AndroidContentContext.getString(2131693827)))
        {
          paramCharSequence = paramCharSequence.toString();
          int i = 0;
          for (;;)
          {
            localObject = paramCharSequence;
            if (i >= EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
              break;
            }
            localObject = paramCharSequence;
            if (paramCharSequence.indexOf('\024' + EmotcationConstants.SYS_EMOTICON_SYMBOL[i]) != -1) {
              localObject = paramCharSequence.replace('\024' + EmotcationConstants.SYS_EMOTICON_SYMBOL[i], "\024" + (char)i);
            }
            i += 1;
            paramCharSequence = (CharSequence)localObject;
          }
        }
        localObject = paramCharSequence;
        paramCharSequence = paramIntent.getStringExtra("uinname");
        localSpannableStringBuilder.append(new ColorNickText("[" + paramCharSequence + "]", 16));
        localSpannableStringBuilder.append(" ");
        localSpannableStringBuilder.append(new ColorNickText(paramMessage.nickName, 16));
        NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessage, paramIntent, localSpannableStringBuilder);
        paramCharSequence = (CharSequence)localObject;
      }
      else
      {
        localObject = paramIntent.getStringExtra("uinname");
        NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramMessage, localSpannableStringBuilder);
        if ((localObject == null) || (((String)localObject).length() == 0)) {
          localSpannableStringBuilder.append(paramMessage.frienduin);
        } else {
          paramCharSequence = a(paramIntent, paramMessage, paramCharSequence, localSpannableStringBuilder, (String)localObject);
        }
      }
    }
  }
  
  private CharSequence a(Intent paramIntent, Message paramMessage, CharSequence paramCharSequence, SpannableStringBuilder paramSpannableStringBuilder, String paramString)
  {
    String str;
    if (7000 == paramMessage.istroop)
    {
      str = paramIntent.getStringExtra("subAccountLatestNick");
      if (str != null)
      {
        paramIntent = str;
        if (str.length() != 0) {}
      }
      else
      {
        paramIntent = paramMessage.senderuin;
      }
      paramSpannableStringBuilder.append(paramString);
      paramSpannableStringBuilder.append(" ");
      paramSpannableStringBuilder.append(paramIntent);
      return paramCharSequence;
    }
    if ((1010 == paramMessage.istroop) || (1001 == paramMessage.istroop))
    {
      if (String.valueOf(AppConstants.LBS_HELLO_UIN).equals(paramMessage.frienduin))
      {
        str = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.senderuin);
        paramIntent = str;
        if (TextUtils.isEmpty(str)) {
          paramIntent = paramMessage.senderuin;
        }
      }
      for (;;)
      {
        paramSpannableStringBuilder.append(paramString);
        paramSpannableStringBuilder.append("-");
        paramSpannableStringBuilder.append(paramIntent);
        if (paramMessage.msgtype != -1024) {
          break;
        }
        return String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698673), new Object[] { paramIntent });
        str = ContactUtils.q(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
        paramIntent = str;
        if (TextUtils.isEmpty(str)) {
          paramIntent = paramMessage.frienduin;
        }
      }
    }
    if (1024 == paramMessage.istroop)
    {
      paramIntent = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage.frienduin);
      if (TextUtils.isEmpty(paramIntent))
      {
        paramSpannableStringBuilder.append(paramString);
        return paramCharSequence;
      }
      paramSpannableStringBuilder.append(paramIntent);
      return paramCharSequence;
    }
    if ((7220 == paramMessage.istroop) && (paramMessage.extInt == 2) && (!TextUtils.isEmpty(paramMessage.senderuin)))
    {
      paramIntent = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).b(paramMessage.senderuin);
      if ((paramIntent != null) && (!TextUtils.isEmpty(paramIntent.name)))
      {
        paramSpannableStringBuilder.append(paramIntent.name);
        return paramCharSequence;
      }
      paramSpannableStringBuilder.append(paramString);
      return paramCharSequence;
    }
    paramSpannableStringBuilder.append(paramString);
    return paramCharSequence;
  }
  
  private CharSequence a(Message paramMessage)
  {
    if (paramMessage.msgtype == -2016)
    {
      paramMessage = paramMessage.msg.split("\\|");
      if (paramMessage.length > 0) {
        paramMessage = paramMessage[0].trim();
      }
    }
    Object localObject;
    CharSequence localCharSequence;
    do
    {
      return paramMessage;
      return "";
      if ((paramMessage.msgtype == -2011) || (paramMessage.msgtype == -2059))
      {
        localObject = StructMsgFactory.a(paramMessage.msgData);
        if (localObject != null) {
          return ((AbsStructMsg)localObject).mMsgBrief;
        }
        return paramMessage.msg;
      }
      if (paramMessage.msgtype == -2000)
      {
        if ((((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramMessage.frienduin)) || (FlashPicHelper.a(paramMessage))) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131691362);
        }
        return paramMessage.getMessageText();
      }
      if (paramMessage.msgtype == -7001) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694364);
      }
      localCharSequence = paramMessage.getMessageText();
      if (!TroopRobotManager.b(paramMessage)) {
        break;
      }
      if (!TroopRobotManager.d(paramMessage)) {
        TroopRobotManager.a(paramMessage);
      }
      localObject = TroopRobotManager.b(paramMessage);
      paramMessage = (Message)localObject;
    } while (!TextUtils.isEmpty((CharSequence)localObject));
    return localCharSequence;
  }
  
  public static List<ChatMessage> a(List<ChatMessage> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size list == null, targetUin=" + paramString);
      }
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseChatpieHelper", 2, "filterTargetUinMsgList size " + paramList.size() + ", targetUin=" + paramString);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramList.next();
      if (paramString.equals(localChatMessage.senderuin)) {
        localArrayList.add(localChatMessage);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "filterTargetUinMsgList targetList " + localArrayList.size() + ", targetUin=" + paramString);
    }
    return localArrayList;
  }
  
  public static void a(SessionInfo paramSessionInfo, EditText paramEditText, Button paramButton, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w("BaseChatpieHelper", 2, "exitMsgFilterMode ");
    }
    paramSessionInfo.l = false;
    paramSessionInfo.i = null;
    if (paramBoolean) {
      paramEditText.setText("");
    }
    paramButton.setText(HardCodeUtil.a(2131701032));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx, boolean paramBoolean)
  {
    boolean bool2 = true;
    int i = 120;
    int j = VipUtils.a(paramQQAppInterface, null);
    Object localObject;
    boolean bool1;
    if ((j & 0x4) != 0)
    {
      i = PttItemBuilder.a(paramQQAppInterface, "SVIP_MaxPtt");
      if (paramXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
      {
        paramQQAppInterface = QQRecorder.a();
        localObject = paramXEditTextEx.getInputExtras(true);
        if (paramBoolean) {
          break label201;
        }
        bool1 = true;
        label61:
        ((Bundle)localObject).putBoolean("DoesSupportDirectlyAudio", bool1);
        paramXEditTextEx.getInputExtras(true).putInt("Channels", 1);
        paramXEditTextEx.getInputExtras(true).putInt("SampleRate", paramQQAppInterface.jdField_a_of_type_Int);
        paramXEditTextEx.getInputExtras(true).putInt("TimeLength", i);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("sougouptt params : support = ");
          if (paramBoolean) {
            break label207;
          }
        }
      }
    }
    label201:
    label207:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      QLog.d("BaseChatpieHelper", 2, paramBoolean + "sample = " + paramQQAppInterface.jdField_a_of_type_Int + " max = " + i);
      paramXEditTextEx.a = paramQQAppInterface;
      return;
      if ((j & 0x2) == 0) {
        break;
      }
      i = PttItemBuilder.a(paramQQAppInterface, "VIP_MaxPtt");
      break;
      bool1 = false;
      break label61;
    }
  }
  
  public static boolean a(Button paramButton, CharSequence paramCharSequence, int paramInt)
  {
    return false;
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return false;
  }
  
  public static boolean a(SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (paramQQAppInterface.isTroopMark(paramMessage)) || (TroopManager.a(paramQQAppInterface, paramMessage))) {
      return false;
    }
    if (a(paramQQAppInterface, paramMessage)) {
      return false;
    }
    if (UinTypeUtil.d(paramMessage.senderuin)) {
      return false;
    }
    if (WerewolvesMsgUtil.a(paramMessage)) {
      return false;
    }
    if (paramMessage.msgtype == -2058) {
      return false;
    }
    if ((paramMessage.istroop == 0) && (FriendsStatusUtil.a(paramMessage.frienduin, paramQQAppInterface))) {
      return false;
    }
    if ((paramMessage.istroop == 0) && (TextUtils.equals(paramMessage.frienduin, AppConstants.TROOP_SUSPICIOUS_MSG_UIN))) {
      return false;
    }
    if (((paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Int == 10007)) || (paramMessage.istroop == 10007)) {
      return false;
    }
    if (AppConstants.WEISHI_UIN.equals(paramMessage.senderuin)) {
      return false;
    }
    return !((TempMsgBoxManager)paramQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).a(paramMessage.frienduin, paramMessage.istroop);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (ShortVideoUtils.isVideoSoLibLoaded()) {}
    do
    {
      return true;
      ShortVideoUtils.loadShortVideoSo(paramQQAppInterface);
    } while (ShortVideoUtils.isVideoSoLibLoaded());
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet == null)
    {
      jdField_a_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
      jdField_a_of_type_AndroidSupportV4UtilArraySet.addAll(Arrays.asList(new Integer[] { Integer.valueOf(7220), Integer.valueOf(1036), Integer.valueOf(10010) }));
    }
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Integer.valueOf(paramMessage.istroop))) {
      return true;
    }
    if (((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramMessage.frienduin)) {
      return true;
    }
    if ((paramMessage.istroop == 1008) && (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramMessage.senderuin))) {
      return true;
    }
    if ((paramMessage.istroop == 1008) && (AppConstants.KANDIAN_DAILY_UIN.equals(paramMessage.senderuin))) {
      return true;
    }
    if (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && (UinTypeUtil.a(paramMessage))) {
      return true;
    }
    if ((paramMessage.istroop != 7220) && (TextUtils.equals(paramMessage.frienduin, AppConstants.NEW_KANDIAN_UIN))) {
      return true;
    }
    if (ConfessMsgUtil.a(paramMessage)) {
      return true;
    }
    return (LimitChatUtil.b(paramMessage)) || (LimitChatUtil.a(paramMessage));
  }
  
  public CharSequence a(Intent paramIntent, Message paramMessage)
  {
    try
    {
      paramIntent = a(paramIntent, paramMessage, a(paramMessage));
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QLog.e("BaseChatpieHelper", 1, "getMessageTipsStr error: " + paramMessage, paramIntent);
    }
    return "";
  }
  
  public void a()
  {
    MiniChatMsgProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.post(new BaseChatpieHelper.1(this, paramInt2, paramInt1, paramString), 2, null, false);
  }
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    ArrayList localArrayList = (ArrayList)MultiMsgManager.a().a();
    JubaoIPCServer.a().a(localArrayList);
    String str = JubaoApiPlugin.a(localArrayList);
    paramIntent.putExtra("chatuin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("chattype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    paramIntent.putExtra("msgs", str);
    paramActivity.setResult(-1, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("jubaoApiPlugin", 2, "select msg size = " + localArrayList.size());
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public void b()
  {
    MiniChatMsgProxy.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) && (!MiniChatMsgProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      do
      {
        Bundle localBundle;
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("BaseChatpieHelper", 2, "uploadPreviewPhoto");
          }
          ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(AlbumConstants.h, -1));
          localBundle = paramIntent.getExtras();
        } while (localBundle == null);
        if (localBundle.getBoolean("deleteImage", false))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c(true, false);
          return;
        }
        i = paramIntent.getIntExtra(AlbumConstants.h, -1);
      } while ((i != 2) && (i != 1));
      paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
    } while ((paramIntent == null) || (paramIntent.isEmpty()));
    if (paramIntent.size() == 1)
    {
      if (i == 1)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 1, "");
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 2, "");
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.c, 4, "" + paramIntent.size());
  }
  
  public void c(Intent paramIntent)
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000|0");
    LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig of PreUploadVideoConfig :" + (String)localObject);
    float f1 = 0.0F;
    float f3 = 0.0F;
    float f2 = 0.0F;
    long l2 = 0L;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      int i;
      long l1;
      int i1;
      try
      {
        k = Integer.valueOf(localObject[0]).intValue();
        boolean bool3;
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          j = Integer.valueOf(localObject[1]).intValue();
          f2 = f3;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            boolean bool1;
            boolean bool2;
            int j = 0;
            i = 0;
            i1 = k;
          }
        }
        try
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          f2 = f1;
          i = Integer.valueOf(localObject[3]).intValue();
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          i = 0;
          f1 = f2;
          i1 = k;
          break label587;
        }
        try
        {
          l1 = Long.valueOf(localObject[4]).longValue();
          n = k;
          m = j;
          k = i;
          f2 = f1;
          LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig PreUpEnable:" + n + " HardEncodeEnable:" + m + " Limits:" + k + " dpcDuration:" + f2 + " dpcTimeout:" + l1);
          bool3 = VideoUpConfigInfo.isPreUpload();
          bool1 = VideoUpConfigInfo.sIsHardCodeEnable;
          if ((m != 1) || (!bool1)) {
            break label644;
          }
          bool2 = true;
          LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> HardCodeEnable: " + bool2 + " DPC:" + m + " BDH:" + bool1);
          if (!VideoUpConfigInfo.getIsUpdated())
          {
            if (QLog.isColorLevel()) {
              QLog.d("BaseChatpieHelper", 2, "<BDH_LOG>VideoUpConfigInfo is not updated");
            }
            HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            VideoUpConfigInfo.setIsUpdated();
          }
          if (!NetworkUtil.h(BaseApplication.getContext())) {
            break label656;
          }
          if ((n != 1) || (!bool3)) {
            break label650;
          }
          bool1 = true;
          LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> Enable: " + bool1 + " DPC:" + n + " BDH:" + bool3 + " isWifi");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)) {
            bool1 = false;
          }
          bool3 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)
          {
            bool3 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)
            {
              bool3 = bool1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
              {
                bool3 = bool1;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) {
                  bool3 = false;
                }
              }
            }
          }
          paramIntent.putExtra("key_video_hard_encode_enable", bool2);
          paramIntent.putExtra("key_video_presend_slice_duration", f2);
          com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Boolean = bool2;
          com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.b = bool3;
          return;
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          i1 = k;
          break label587;
        }
        localNumberFormatException1 = localNumberFormatException1;
        j = 0;
        i1 = 0;
        i = 0;
      }
      label587:
      f2 = f1;
      int k = i;
      int m = j;
      int n = i1;
      if (QLog.isColorLevel())
      {
        QLog.e("BaseChatpieHelper", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException1);
        l1 = l2;
        f2 = f1;
        k = i;
        m = j;
        n = i1;
        continue;
        label644:
        bool2 = false;
        continue;
        label650:
        bool1 = false;
        continue;
        label656:
        bool1 = false;
        continue;
        k = 0;
        m = 0;
        n = 0;
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper
 * JD-Core Version:    0.7.0.1
 */