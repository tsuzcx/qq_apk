package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.VideoController;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.ui.funcall.FunCallUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.SeqUtil;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.UITools;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.av.wtogether.util.ChooseFileAssistant;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinMD5Cache;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contacts.friend.FriendsUtils;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationFileAssistant;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFastImage;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationFileAssistant;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qqexpand.manager.IExpandLimitChatManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.vipav.VipSetFunCallHandler;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityUtils
  extends BaseChatActivityUtils
{
  private static ChatActivityUtils.AddFriendSpan jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan;
  static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private static QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public static Queue<String> a;
  private static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    jdField_a_of_type_JavaUtilQueue = new LinkedList();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://m.qzone.com", "https://m.qzone.com", "http://mobile.qzone.qq.com", "https://mobile.qzone.qq.com" };
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static int a(List paramList, int paramInt)
  {
    int m = paramList.size();
    int k = 0;
    int i = m;
    while ((i > m - paramInt) && (i >= 1))
    {
      int j = k;
      if (a(paramList.get(i - 1))) {
        j = k + 1;
      }
      i -= 1;
      k = j;
    }
    paramList = new StringBuilder();
    paramList.append("filterIgnoreMsg() called with: unReadCnt = [");
    paramList.append(paramInt);
    paramList.append("], filterCount = [");
    paramList.append(k);
    paramList.append("]");
    QLog.i("BaseChatPie", 1, paramList.toString());
    return Math.max(paramInt - k, 0);
  }
  
  private static long a(ChatMessage paramChatMessage, Activity paramActivity)
  {
    long l1 = paramChatMessage.uniseq;
    if ((paramActivity != null) && (paramActivity.getIntent() != null) && (paramActivity.getIntent().hasExtra("origin_merge_structing_msg_uniseq")))
    {
      long l2 = paramActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
      if (l2 > 0L) {
        return l2;
      }
    }
    return l1;
  }
  
  static Bundle a(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    if (paramMap != null)
    {
      if (paramMap.containsKey("actid")) {
        localBundle.putString("actId", (String)paramMap.get("actid"));
      }
      if (paramMap.containsKey("mp_ext_params")) {
        localBundle.putString("mp_ext_params", (String)paramMap.get("mp_ext_params"));
      }
      localObject1 = (String)paramMap.get("MultiAVType");
      if (localObject1 != null) {
        localBundle.putInt("MultiAVType", Integer.valueOf((String)localObject1).intValue());
      }
      localBundle.putBoolean("isVideo", TextUtils.equals((String)paramMap.get("isVideo"), "true"));
      localObject1 = (String)paramMap.get("Fromwhere");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("Fromwhere", (String)localObject1);
      }
      if (paramMap.containsKey("ConfAppID")) {
        localBundle.putInt("ConfAppID", Integer.valueOf((String)paramMap.get("ConfAppID")).intValue());
      }
      if (paramMap.containsKey("MeetingConfID")) {
        localBundle.putInt("MeetingConfID", Integer.valueOf((String)paramMap.get("MeetingConfID")).intValue());
      }
      localBundle.putString("jump_from", (String)paramMap.get("jump_from"));
      localBundle.putString("enterType", (String)paramMap.get("enterType"));
    }
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      StringBuilder localStringBuilder;
      for (paramMap = "";; paramMap = localStringBuilder.toString())
      {
        localObject1 = paramMap;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = ((Map.Entry)localObject1).getValue();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMap);
        localStringBuilder.append("  [");
        localStringBuilder.append((String)((Map.Entry)localObject1).getKey());
        localStringBuilder.append("]=[");
        localStringBuilder.append(localObject2);
        localStringBuilder.append("], [");
        localStringBuilder.append(localObject2.getClass().getName());
        localStringBuilder.append("]\n");
      }
    }
    Object localObject1 = "null";
    paramMap = new StringBuilder();
    paramMap.append("strExtroInfo[extroInfo2Bundle]:\n");
    paramMap.append((String)localObject1);
    QLog.w("ChatActivityUtils", 1, paramMap.toString());
    QQAudioHelper.a("ChatActivityUtils_extroInfo2Bundle", localBundle, true);
    return localBundle;
  }
  
  public static View a(Context paramContext, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Context localContext = null;
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = LayoutInflater.from(paramContext).inflate(2131558850, null);
      localContext = paramContext;
      View localView = paramContext.findViewById(2131364590);
      localContext = paramContext;
      TextView localTextView = (TextView)paramContext.findViewById(2131364591);
      localContext = paramContext;
      ImageView localImageView = (ImageView)paramContext.findViewById(2131364589);
      if (paramString != null)
      {
        localContext = paramContext;
        localTextView.setText(paramString);
      }
      localContext = paramContext;
      localImageView.setOnClickListener(paramOnClickListener2);
      localContext = paramContext;
      localView.setOnClickListener(paramOnClickListener1);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      label96:
      break label96;
    }
    QLog.e("ChatActivityUtils", 1, "showChatTopBar, RuntimeException");
    return localContext;
  }
  
  @SuppressLint({"InflateParams"})
  public static Toast a(Context paramContext, String paramString)
  {
    Toast localToast = new Toast(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2131558583, null);
    localToast.setView(localView);
    localToast.setGravity(55, 0, paramContext.getResources().getDimensionPixelSize(2131299168));
    localToast.setDuration(1);
    ((TextView)localView.findViewById(2131362496)).setText(paramString);
    localView.setOnClickListener(new ChatActivityUtils.15(localToast));
    return localToast;
  }
  
  static com.tencent.mobileqq.app.BaseActivity a(long paramLong, Context paramContext)
  {
    boolean bool = paramContext instanceof com.tencent.mobileqq.app.BaseActivity;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramContext;
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).isFinishing()) {
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBaseActivity, Context[");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append("], baseActivity[");
      ((StringBuilder)localObject1).append(localObject2);
      ((StringBuilder)localObject1).append("], seq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("]");
      QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject1).toString(), new Throwable("打印调用栈"));
    }
    return localObject2;
  }
  
  private static MessageRecord a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    if ((i != -1003) && (i != -1031) && (i != -1032) && (i != -3001))
    {
      if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032) {
        return null;
      }
      if (((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramMessageRecord.frienduin)) {
        return null;
      }
      return paramMessageRecord;
    }
    return null;
  }
  
  public static MessageRecord a(List<ChatMessage> paramList, BaseSessionInfo paramBaseSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((a(paramBaseSessionInfo.jdField_a_of_type_Int)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return null;
      }
      int j = paramBaseSessionInfo.jdField_a_of_type_Int;
      int i = 0;
      if (j == 1006)
      {
        paramBaseSessionInfo = (MessageRecord)paramList.get(0);
      }
      else
      {
        j = paramList.size();
        if (paramBaseSessionInfo.jdField_a_of_type_Int != 10008) {
          i = 1;
        }
        j -= 1;
        while (j >= 0)
        {
          paramBaseSessionInfo = (MessageRecord)paramList.get(j);
          if (((i == 0) || (!paramBaseSessionInfo.isSend())) && (!MsgProxyUtils.b(paramBaseSessionInfo.msgtype)))
          {
            paramList = paramBaseSessionInfo;
            break label135;
          }
          j -= 1;
        }
        paramList = null;
        label135:
        paramBaseSessionInfo = paramList;
        if (paramList == null) {
          return null;
        }
      }
      return a(paramBaseSessionInfo, paramQQAppInterface);
    }
    return null;
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if ((paramContext instanceof Activity)) {
      paramQQAppInterface = paramContext;
    } else {
      paramQQAppInterface = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
    }
    Activity localActivity = (Activity)paramQQAppInterface;
    paramQQAppInterface = null;
    if (localActivity != null) {
      if (!CUKingCardHelper.a(localActivity, 4, new ChatActivityUtils.17(paramOnClickListener1, paramOnClickListener2), "qav")) {
        return paramQQAppInterface;
      }
    }
    paramQQAppInterface = PopupDialog.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    return paramQQAppInterface;
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, BaseSessionInfo paramBaseSessionInfo, MessageRecord paramMessageRecord, long paramLong)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      int i = paramMessageRecord.istroop;
      if ((!paramMessageRecord.isSend()) && (!MessageUtils.a(paramMessageRecord.msgtype)))
      {
        if (1000 == i)
        {
          a(paramBaseSessionInfo, paramMessageRecord, paramLong);
          paramQQAppInterface = localObject2;
        }
        else if (1020 == i)
        {
          paramMessageRecord = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramMessageRecord.senderuin);
          paramQQAppInterface = localObject2;
          if (paramMessageRecord != null)
          {
            paramQQAppInterface = paramMessageRecord.name;
            paramQQAppInterface = String.format(paramContext.getString(2131692670), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString, paramQQAppInterface });
          }
        }
        else
        {
          if (1004 == i)
          {
            paramQQAppInterface = ContactUtils.a(paramQQAppInterface, (String)localObject1, 3000);
            paramQQAppInterface = String.format(paramContext.getString(2131692668), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString, paramQQAppInterface });
            a(paramBaseSessionInfo, paramMessageRecord, paramLong);
          }
          for (;;)
          {
            break;
            if (1001 == i)
            {
              paramQQAppInterface = localObject2;
            }
            else if (10002 == i)
            {
              paramQQAppInterface = localObject2;
            }
            else
            {
              if (10004 == i)
              {
                paramQQAppInterface = String.format(paramContext.getString(2131692671), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
                continue;
              }
              if (1006 == i)
              {
                paramQQAppInterface = localObject2;
              }
              else
              {
                if (1009 == i)
                {
                  paramQQAppInterface = String.format(paramContext.getString(2131692673), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
                  continue;
                }
                if (1005 == i)
                {
                  paramQQAppInterface = localObject2;
                }
                else
                {
                  if (1021 == i)
                  {
                    paramQQAppInterface = String.format(paramContext.getString(2131692665), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
                    continue;
                  }
                  if (1022 == i)
                  {
                    paramQQAppInterface = String.format(paramContext.getString(2131692669), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
                    continue;
                  }
                  if (1023 == i)
                  {
                    paramQQAppInterface = String.format(paramContext.getString(2131692672), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
                    continue;
                  }
                  if (1010 == i)
                  {
                    paramQQAppInterface = NearbyManagerHelper.a(paramQQAppInterface).a(paramBaseSessionInfo.jdField_d_of_type_JavaLangString);
                    continue;
                  }
                  paramQQAppInterface = localObject2;
                  if (i == 10010) {
                    paramQQAppInterface = String.format(paramContext.getString(2131692664), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
                  }
                }
              }
            }
          }
        }
        localObject1 = paramQQAppInterface;
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("generateMsgSource, isTroop = ");
          paramContext.append(i);
          QLog.d("ChatActivityUtils", 2, paramContext.toString());
          return paramQQAppInterface;
        }
      }
      else
      {
        localObject1 = localObject3;
        if (1006 == i)
        {
          paramBaseSessionInfo = String.format(paramContext.getString(2131692667), new Object[] { paramBaseSessionInfo.jdField_d_of_type_JavaLangString });
          paramQQAppInterface = paramContext.getString(2131692666);
          if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
            jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131166354));
          }
          i = paramBaseSessionInfo.lastIndexOf(paramQQAppInterface);
          localObject1 = new SpannableStringBuilder(paramBaseSessionInfo);
          ((SpannableStringBuilder)localObject1).setSpan(jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan, i, paramQQAppInterface.length() + i, 33);
        }
      }
    }
    return localObject1;
  }
  
  public static Integer a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localConcurrentHashMap != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(paramString2);
        return (Integer)localConcurrentHashMap.get(localStringBuilder.toString());
      }
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1000)
      {
        if (paramInt != 1004)
        {
          if (paramInt != 1006) {
            return "999";
          }
          return "3";
        }
        return "1";
      }
      return "2";
    }
    return "0";
  }
  
  public static final String a(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramActivity.getClass().getName());
    localStringBuilder.append("_");
    localStringBuilder.append(paramActivity.hashCode());
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if (paramQQAppInterface == null) {
        return paramContext.getString(2131698619);
      }
      if (TextUtils.isEmpty(paramQQAppInterface.getTroopDisplayName())) {
        return paramContext.getString(2131698619);
      }
      paramQQAppInterface = String.format(paramContext.getString(2131698620), new Object[] { paramQQAppInterface.getTroopDisplayName() });
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext.getString(2131698619);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      int i = paramMessageRecord.istroop;
      if (i != 1000)
      {
        if (i != 1001)
        {
          if (i != 1009)
          {
            if (i != 1010)
            {
              if (i != 10002)
              {
                if (i != 10004)
                {
                  if (i != 10010) {
                    switch (i)
                    {
                    default: 
                      switch (i)
                      {
                      default: 
                        return null;
                      case 1023: 
                        return paramContext.getString(2131698614);
                      case 1022: 
                        return paramContext.getString(2131698609);
                      case 1021: 
                        return paramContext.getString(2131698605);
                      }
                      Object localObject3 = BaseApplicationImpl.sApplication.getRuntime();
                      localObject1 = localObject2;
                      if (localObject3 == null) {
                        break;
                      }
                      localObject1 = localObject2;
                      if (!(localObject3 instanceof QQAppInterface)) {
                        break;
                      }
                      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
                      localObject1 = localObject2;
                      if (paramQQAppInterface == null) {
                        break;
                      }
                      localObject3 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
                      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
                      localObject1 = localObject2;
                      if (TextUtils.isEmpty(((HotChatManager)localObject3).a(paramMessageRecord.senderuin))) {
                        break;
                      }
                      return paramContext.getString(2131698611);
                    case 1006: 
                      return paramContext.getString(2131698606);
                    case 1005: 
                      return paramContext.getString(2131698621);
                    case 1004: 
                      return paramContext.getString(2131698608);
                    }
                  } else {
                    return paramContext.getString(2131694304);
                  }
                }
                else {
                  return paramContext.getString(2131698613);
                }
              }
              else {
                return paramContext.getString(2131694305);
              }
            }
            else {
              return paramContext.getString(2131698607);
            }
          }
          else {
            return paramContext.getString(2131698617);
          }
        }
        else {
          return paramContext.getString(2131698612);
        }
      }
      else {
        try
        {
          paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          paramMessageRecord = paramQQAppInterface.b(paramQQAppInterface.c(paramMessageRecord.senderuin));
          if (paramMessageRecord == null)
          {
            paramMessageRecord = paramContext.getString(2131698619);
            paramContext = paramMessageRecord;
          }
          else if (TextUtils.isEmpty(paramMessageRecord.getTroopDisplayName()))
          {
            paramMessageRecord = paramContext.getString(2131698619);
            paramContext = paramMessageRecord;
          }
          else
          {
            paramMessageRecord = String.format(paramContext.getString(2131698620), new Object[] { paramMessageRecord.getTroopDisplayName() });
            paramContext = paramMessageRecord;
          }
        }
        catch (Exception paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
          paramContext = paramContext.getString(2131698619);
          localObject1 = paramContext;
          if (QLog.isColorLevel())
          {
            QLog.d("ChatActivityUtils", 2, "UIN_TYPE_OPEN_TROOP_MEMBER_STRANGER or UIN_TYPE_GROUP_MEMBER_STRANGER error");
            localObject1 = paramContext;
          }
        }
      }
    }
    return localObject1;
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    if (paramQQAppInterface.b(paramString, false)) {
      return paramQQAppInterface.a(paramContext, paramString);
    }
    return null;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, View paramView, boolean paramBoolean)
  {
    Object localObject1;
    if ((paramChatMessage instanceof MessageForReplyText)) {
      localObject1 = ((MessageForReplyText)paramChatMessage).mSourceMsgInfo;
    } else if ((paramChatMessage instanceof MessageForLongMsg)) {
      localObject1 = ((MessageForLongMsg)paramChatMessage).mSourceMsgInfo;
    } else {
      localObject1 = null;
    }
    Object localObject2 = new StringBuilder();
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = "";
    if (localObject1 != null)
    {
      String str2 = TimeFormatterUtils.a(paramContext, 3, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgTime * 1000L).toString();
      if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName))
      {
        paramContext = ((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName;
      }
      else if (((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin == 50000000L)
      {
        paramContext = ReplyTextItemBuilder.a(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq);
        if (paramContext != null)
        {
          paramContext = TroopBusinessUtil.a(paramContext);
          if (paramContext != null) {
            ((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName = paramContext.jdField_c_of_type_JavaLangString;
          }
        }
        paramContext = "";
      }
      else if (paramChatMessage.istroop == 0)
      {
        paramContext = new StringBuilder();
        paramContext.append(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin);
        paramContext.append("");
        paramContext = ContactUtils.f(paramQQAppInterface, paramContext.toString());
      }
      else
      {
        int i = paramChatMessage.istroop;
        paramContext = paramChatMessage.frienduin;
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin);
        localStringBuilder2.append("");
        paramContext = ContactUtils.a(paramQQAppInterface, i, paramContext, localStringBuilder2.toString());
      }
      ((StringBuilder)localObject2).append("“");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramContext);
      ((StringBuilder)localObject2).append("\r\n");
      localStringBuilder1.append("     ");
      localStringBuilder1.append("\r\n");
      if (paramChatMessage.istroop == 0) {
        paramContext = paramQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, 0, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgTime, ((MessageForReplyText.SourceMsgInfo)localObject1).origUid);
      } else {
        paramContext = paramQQAppInterface.getMessageFacade().a(paramChatMessage.frienduin, 1, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq, 0L);
      }
      paramQQAppInterface = (QQAppInterface)localObject2;
      if ((paramContext != null) && (paramContext.size() > 0)) {
        paramContext = (MessageRecord)paramContext.get(0);
      } else {
        paramContext = null;
      }
      if ((paramContext instanceof MessageForLongTextMsg))
      {
        localObject2 = paramContext.msg;
        localObject1 = paramQQAppInterface;
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("\r\n");
        localStringBuilder1.append(new QQText(paramContext.msg, 13, 32));
      }
      else
      {
        localObject2 = paramQQAppInterface;
        if (((MessageForReplyText.SourceMsgInfo)localObject1).mSourceSummaryFlag == 1)
        {
          ((StringBuilder)localObject2).append(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgText);
          ((StringBuilder)localObject2).append("\r\n");
          localStringBuilder1.append(new QQText(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgText, 13, 32));
        }
        else if (paramContext != null)
        {
          ((StringBuilder)localObject2).append(paramContext.msg);
          ((StringBuilder)localObject2).append("\r\n");
          localStringBuilder1.append(new QQText(paramContext.msg, 13, 32));
        }
        else
        {
          ((StringBuilder)localObject2).append(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgText);
          ((StringBuilder)localObject2).append("\r\n");
          localStringBuilder1.append(new QQText(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgText, 13, 32));
        }
      }
      MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "doubleClk", paramChatMessage.frienduin, paramChatMessage);
    }
    else
    {
      paramQQAppInterface = (QQAppInterface)localObject2;
    }
    if (!paramBoolean) {
      paramChatMessage = str1;
    } else {
      paramChatMessage = paramChatMessage.getSummaryMsg();
    }
    paramQQAppInterface.append(paramChatMessage);
    paramChatMessage = paramQQAppInterface.toString();
    if ((paramView.getId() == 2131371529) && ((paramView instanceof ETTextView))) {
      return localStringBuilder1.toString();
    }
    paramQQAppInterface = paramChatMessage;
    if (paramView.getId() == 2131364549)
    {
      paramQQAppInterface = paramChatMessage;
      if ((ETTextView)paramView.findViewById(2131371529) != null) {
        paramQQAppInterface = localStringBuilder1.toString();
      }
    }
    return paramQQAppInterface;
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      Object localObject = paramString.replace("+", "").split(",");
      paramString = new byte[localObject.length];
      int i = 0;
      while (i < localObject.length)
      {
        paramString[i] = Byte.parseByte(localObject[i].trim());
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("MasPlay");
      paramQQAppInterface = a(paramString, a(((StringBuilder)localObject).toString(), 32).getBytes("UTF-8"));
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = new String(paramQQAppInterface, "UTF-8").replace("$", "");
        return paramQQAppInterface;
      }
      return null;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    if (paramInt == 16) {
      return a(localMessageDigest.digest(paramString.getBytes("utf-8"))).substring(8, 24);
    }
    return a(localMessageDigest.digest(paramString.getBytes("utf-8")));
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      int k = paramArrayOfByte[i];
      int j = k;
      if (k < 0) {
        j = k + 256;
      }
      localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(j >>> 4)]);
      localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(j % 16)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static void a()
  {
    QQCustomDialog localQQCustomDialog = jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    long l = paramQQAppInterface.getAVNotifyCenter().b();
    int i = paramQQAppInterface.getAVNotifyCenter().a();
    int j = paramQQAppInterface.getAVNotifyCenter().b(l);
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("sendExitBroadcast, finalType[");
    paramQQAppInterface.append(paramInt1);
    paramQQAppInterface.append("], finalAvType[");
    paramQQAppInterface.append(paramInt2);
    paramQQAppInterface.append("], chattingType[");
    paramQQAppInterface.append(i);
    paramQQAppInterface.append("], seq[");
    paramQQAppInterface.append(paramLong);
    paramQQAppInterface.append("]");
    QLog.w("ChatActivityUtils", 1, paramQQAppInterface.toString());
    if ((paramInt1 == 1) || (i == 1))
    {
      if ((j == 2) && (paramInt2 != 2))
      {
        paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
        return;
      }
      if ((j != 2) && (paramInt2 == 2))
      {
        paramQQAppInterface = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
        SeqUtil.a(paramQQAppInterface, paramLong);
        paramContext.sendBroadcast(paramQQAppInterface);
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null) {
      if (paramActivity.isFinishing()) {
        return;
      }
    }
    try
    {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718766);
        }
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        paramActivity = jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if ((paramActivity == null) || (paramActivity.isShowing())) {
          break label113;
        }
      }
      finally
      {
        QQProgressDialog localQQProgressDialog = jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
        if ((localQQProgressDialog != null) && (!localQQProgressDialog.isShowing())) {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
      }
    }
    catch (Exception paramActivity)
    {
      label94:
      break label94;
    }
    paramActivity = jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramActivity != null) && (!paramActivity.isShowing())) {
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    label113:
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    a(paramActivity, paramSessionInfo, paramString, paramBoolean, false, paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    int j = 3008;
    int k = 3;
    int i;
    if (paramBoolean2)
    {
      i = 3071;
      j = 11;
    }
    else
    {
      int m = paramSessionInfo.jdField_a_of_type_Int;
      if (m != 1000)
      {
        if (m != 1001)
        {
          if (m != 1009) {
            if (m != 1010) {
              if (m != 10004)
              {
                i = j;
                switch (m)
                {
                default: 
                  i = j;
                  switch (m)
                  {
                  case 1023: 
                  default: 
                    switch (m)
                    {
                    default: 
                      i = 3999;
                    }
                    break;
                  }
                  break;
                }
              }
            }
          }
          for (;;)
          {
            j = 0;
            break label323;
            i = 3076;
            j = 6;
            break label323;
            i = 3071;
            j = 5192;
            break label323;
            i = 3080;
            j = k;
            break label323;
            i = 3076;
            j = 7;
            break label323;
            i = 3072;
            j = 1;
            break label323;
            i = 3041;
            break;
            i = 3003;
            break label308;
            i = 3006;
            j = 12;
            break label323;
            i = 3005;
            break label308;
            i = 3043;
            break label308;
            i = 3019;
            continue;
            i = 3013;
          }
        }
        i = 3007;
        label308:
        j = 2;
      }
      else
      {
        i = 3004;
        j = k;
      }
    }
    label323:
    com.tencent.mobileqq.app.BaseActivity localBaseActivity;
    if ((i == 3007) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
    {
      localBaseActivity = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      if (!LBSHandler.a(localBaseActivity.getChatFragment().a(), paramString2)) {
        localBaseActivity.getChatFragment().a().b(localBaseActivity.getString(2131694401));
      }
    }
    else if ((i == 3019) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
    {
      localBaseActivity = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      if (!DatingUtil.a(localBaseActivity.getChatFragment().a(), paramString2))
      {
        localBaseActivity.getChatFragment().a().b(localBaseActivity.getString(2131694401));
        return;
      }
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      if ((paramSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString.length() > 0))
      {
        paramSessionInfo = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramActivity, 2, paramString2, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.jdField_d_of_type_JavaLangString, null, null, paramString1, null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramActivity, paramSessionInfo);
      }
    }
    else
    {
      if (paramBoolean1)
      {
        paramSessionInfo = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramActivity, 1, paramString2, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.jdField_d_of_type_JavaLangString, null, AddContactsActivity.class.getName(), paramString1, null);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriend(paramActivity, paramSessionInfo);
        return;
      }
      paramSessionInfo = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramActivity, 1, paramString2, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.jdField_d_of_type_JavaLangString, null, null, paramString1, null);
      ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(paramActivity, paramSessionInfo, 11);
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = paramActivity instanceof com.tencent.mobileqq.app.BaseActivity;
    Object localObject2 = null;
    Object localObject1;
    if (bool) {
      localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
    } else {
      localObject1 = null;
    }
    if ((paramActivity instanceof mqq.app.BaseActivity)) {
      localObject2 = (mqq.app.BaseActivity)paramActivity;
    }
    if ((localObject1 == null) && (localObject2 == null)) {
      return;
    }
    int j = 1;
    int k = 1;
    int i;
    if (localObject1 != null)
    {
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.CAMERA") != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        j = k;
      } else {
        j = 0;
      }
    }
    else if (localObject2 != null)
    {
      if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.CAMERA") != 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        j = 0;
      }
    }
    else
    {
      i = 1;
    }
    if (paramBoolean) {
      i = 0;
    }
    if ((i != 0) && (j != 0)) {
      localObject1 = HardCodeUtil.a(2131701784);
    } else if (i != 0) {
      localObject1 = HardCodeUtil.a(2131701762);
    } else {
      localObject1 = HardCodeUtil.a(2131701769);
    }
    localObject2 = new ChatActivityUtils.18(paramActivity, paramOnClickListener);
    DialogUtil.a(paramActivity, null, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2, new ChatActivityUtils.19(paramOnClickListener));
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramActivity, 2131719046, 1);
      return;
    }
    b(paramActivity, 2131719048, 1);
  }
  
  public static void a(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131698511), paramContext.getString(2131698512), new ChatActivityUtils.16(), null).show();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject1 = paramQQAppInterface.getMsgHandler().a(AppShareIDUtil.a(paramLong));
    Object localObject2;
    if ((localObject1 != null) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<--gameShareOnClick appShareID.bundleid");
      ((StringBuilder)localObject2).append(((AppShareID)localObject1).bundleid);
      QLog.d("gameShareOnClick", 2, ((StringBuilder)localObject2).toString());
    }
    if ((localObject1 != null) && (((AppShareID)localObject1).bundleid != null) && (PackageUtil.a(paramContext, ((AppShareID)localObject1).bundleid)))
    {
      long l = AppShareIDUtil.b(paramLong);
      OpenID localOpenID = paramQQAppInterface.getMsgHandler().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject1).bundleid;
      if (localOpenID == null) {
        localObject1 = null;
      } else {
        localObject1 = localOpenID.openID;
      }
      PackageUtil.a(paramContext, (String)localObject2, (String)localObject1);
      if ((paramInt != -3005) && (paramInt != -3004) && ((paramString == null) || (!paramString.startsWith("https://gamecenter.qq.com")))) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
      if (paramInt != 0) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
      }
    }
    else
    {
      a(paramContext, paramQQAppInterface, paramString, paramLong, paramInt, null);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("appShareOnClick action:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",appShareId:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("mixType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ChatActivityUtils", 2, ((StringBuilder)localObject).toString());
    }
    String str = paramString.trim();
    if ((paramInt != -3005) && (paramInt != -3004) && (!str.startsWith("https://gamecenter.qq.com"))) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    if (55901189L == paramLong)
    {
      paramString = QZoneHelper.UserInfo.getInstance();
      paramString.qzone_uin = paramQQAppInterface.getCurrentAccountUin();
      paramString.nickname = paramQQAppInterface.getCurrentNickname();
      QZoneHelper.forwardToSharedFeedDetail((Activity)paramContext, paramString, str, "mqqChat", -1);
    }
    else
    {
      b(str);
      localObject = new Intent(paramContext, QQBrowserDelegationActivity.class);
      paramString = HtmlOffline.a(str, "from=androidqq");
      if (paramInt != 0)
      {
        ((Intent)localObject).putExtra("param_force_internal_browser", true);
        paramString = HtmlOffline.a(str, "platformId=qq_m");
      }
      ((Intent)localObject).putExtra("injectrecommend", false);
      ((Intent)localObject).putExtra("url", paramString.trim());
      ((Intent)localObject).putExtra("isAppShare", true);
      ((Intent)localObject).putExtra("appShareID", paramLong);
      paramString = paramString.toString();
      if (paramString.startsWith("http://browserApp.p.qq.com/"))
      {
        ((Intent)localObject).putExtra("url", paramString);
        if (paramBundle != null) {
          ((Intent)localObject).putExtras(paramBundle);
        }
        paramContext = new ActivityURIRequest(paramContext, "/pubaccount/browser");
        paramContext.extra().putAll(((Intent)localObject).getExtras());
        QRoute.startUri(paramContext, null);
      }
      else
      {
        paramContext.startActivity((Intent)localObject);
      }
    }
    if (paramInt != 0)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
      return;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(AppShareIDUtil.b(paramLong)));
  }
  
  private static void a(BaseSessionInfo paramBaseSessionInfo, MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramBaseSessionInfo != null)
    {
      if (paramMessageRecord == null) {
        return;
      }
      if ((paramLong != -1L) && (paramMessageRecord.shmsgseq != paramLong))
      {
        if (paramBaseSessionInfo.jdField_a_of_type_Int != paramMessageRecord.istroop)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateSession, type from ");
            localStringBuilder.append(paramBaseSessionInfo.jdField_a_of_type_Int);
            localStringBuilder.append(", to ");
            localStringBuilder.append(paramMessageRecord.istroop);
            QLog.d("ChatActivityUtils", 2, localStringBuilder.toString());
          }
          paramBaseSessionInfo.jdField_a_of_type_Int = paramMessageRecord.istroop;
          paramBaseSessionInfo.jdField_b_of_type_JavaLangString = paramMessageRecord.senderuin;
        }
        return;
      }
      paramBaseSessionInfo = new StringBuilder();
      paramBaseSessionInfo.append("preMrShMsgSeq = ");
      paramBaseSessionInfo.append(paramLong);
      QLog.d("ChatActivityUtils", 2, paramBaseSessionInfo.toString());
    }
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", paramSessionInfo.jdField_d_of_type_JavaLangString);
      paramIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("phonenum", paramSessionInfo.jdField_e_of_type_JavaLangString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramActivity, paramInt, paramString1, paramString2, paramBoolean, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (paramQQAppInterface == null) {
          break label390;
        }
      }
    }
    try
    {
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramActivity)
    {
      long l;
      label37:
      int j;
      ShieldMsgManger localShieldMsgManger;
      int i;
      String str;
      break label37;
    }
    l = 0L;
    if (l > 0L)
    {
      paramQQAppInterface.changeFriendShieldFlag(l, paramBoolean1 ^ true);
      return;
      if (paramInt == 25) {
        return;
      }
      j = 0;
      localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      i = j;
      str = paramString1;
      if (localShieldMsgManger != null)
      {
        str = paramString1;
        if (paramInt == 1006)
        {
          str = paramString1;
          if (paramString1 != null) {}
        }
        try
        {
          str = ContactUtils.b(paramQQAppInterface, paramString2);
          paramString1 = str;
          l = Long.parseLong(str);
          paramString1 = str;
          paramString2 = new ArrayList();
          paramString1 = str;
          paramString2.add(Long.valueOf(l));
          if (paramBoolean1)
          {
            paramString1 = str;
            localShieldMsgManger.b(paramInt, paramString2);
          }
          else
          {
            if (paramBoolean2)
            {
              paramString1 = str;
              if (jdField_a_of_type_JavaUtilQueue.size() > 5)
              {
                paramString1 = str;
                jdField_a_of_type_JavaUtilQueue.poll();
              }
              paramString1 = str;
              jdField_a_of_type_JavaUtilQueue.offer(str);
            }
            paramString1 = str;
            localShieldMsgManger.a(paramInt, paramString2);
          }
          i = 1;
        }
        catch (NumberFormatException paramString2)
        {
          i = j;
          str = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.e("ChatActivityUtils", 2, "shieldMsg", paramString2);
            str = paramString1;
            i = j;
          }
        }
      }
      if ((paramInt == 1001) || (paramInt == 10002))
      {
        if ((str != null) && (str.length() > 0)) {
          if (paramBoolean1) {
            paramQQAppInterface.getMsgHandler().d(str);
          } else {
            paramQQAppInterface.getMsgHandler().c(str);
          }
        }
        i = 1;
      }
      if ((paramActivity != null) && (!paramActivity.isFinishing()))
      {
        if (i != 0)
        {
          a(paramActivity);
          return;
        }
        if (paramBoolean1)
        {
          b(paramActivity, 2131719046, 1);
          return;
        }
        b(paramActivity, 2131719048, 1);
        return;
        if ((paramActivity != null) && (!paramActivity.isFinishing())) {
          b(paramActivity, 2131694395, 1);
        }
      }
    }
    label390:
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramInt1, paramIntent, paramInt2, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 1)
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      if (!((String)localObject1).equalsIgnoreCase(""))
      {
        if (paramInt2 == 1)
        {
          localObject2 = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT > 10) {
            paramInt1 = 4;
          } else {
            paramInt1 = 0;
          }
          ((BaseApplication)localObject2).getSharedPreferences("presend_config_sp", paramInt1).edit().putString("shot_photo_path", (String)localObject1).commit();
        }
        localObject1 = Uri.fromFile(new File((String)localObject1));
      }
      else
      {
        localObject1 = null;
      }
      PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().remove("camera_photo_path").commit();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ImageUtil.b(paramActivity, (Uri)localObject1);
      if (localObject1 != null)
      {
        ImageUtil.a(paramActivity, (String)localObject1);
        if (!FileUtils.isPicFile((String)localObject1))
        {
          QQToast.a(paramActivity, paramActivity.getString(2131692416), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        localObject2 = localObject1;
        if (!new File((String)localObject1).exists()) {
          QQToast.a(paramActivity, paramActivity.getString(2131694908), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299168));
        }
      }
      else
      {
        QQToast.a(paramActivity, paramActivity.getString(2131694908), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299168));
      }
    }
    else
    {
      localObject2 = null;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramActivity, "/base/album/photopreview");
    if (paramQQAppInterface != null)
    {
      localObject1 = paramQQAppInterface.getAccount();
      Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e((String)localObject1);
      localActivityURIRequest.extra().putString("PhotoConst.MY_UIN", (String)localObject1);
      if (localFriends != null) {
        localActivityURIRequest.extra().putString("PhotoConst.MY_NICK", localFriends.name);
      }
      if ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER) != null) {
        localActivityURIRequest.extra().putBoolean("showFlashPic", ((IPicFlash)QRoute.api(IPicFlash.class)).showFlashPicOption(paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_b_of_type_JavaLangString));
      }
    }
    localActivityURIRequest.extra().putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localActivityURIRequest.extra().putInt("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localActivityURIRequest.extra().putString("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localActivityURIRequest.extra().putString("uinname", paramSessionInfo.jdField_d_of_type_JavaLangString);
    localActivityURIRequest.extra().putInt("entrance", paramSessionInfo.c);
    localActivityURIRequest.extra().putInt("key_confess_topicid", paramSessionInfo.jdField_e_of_type_Int);
    localActivityURIRequest.extra().putBoolean("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("camera_type", 1);
      localActivityURIRequest.extra().putInt("camera_type", paramInt1);
      if (paramInt1 == 103)
      {
        i = 1;
        paramInt1 = 10012;
        break label545;
      }
    }
    int i = 0;
    paramInt1 = -1;
    label545:
    boolean bool;
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)))
    {
      localActivityURIRequest.extra().putAll(paramActivity.getIntent().getExtras());
      localObject1 = localActivityURIRequest;
    }
    else
    {
      bool = paramActivity instanceof SplashActivity;
      if (bool)
      {
        localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject1 = AIOUtils.a(localActivityURIRequest, null);
      }
      else
      {
        localObject1 = localActivityURIRequest;
        if ((paramActivity instanceof ChatActivity))
        {
          localActivityURIRequest.extra().putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
          localObject1 = localActivityURIRequest;
        }
      }
      ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      if (paramSessionInfo.jdField_a_of_type_Int == 9501)
      {
        if (bool)
        {
          ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
          localObject1 = AIOUtils.a((ActivityURIRequest)localObject1, null);
        }
        else
        {
          ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        }
        ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 82);
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
      }
      else
      {
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
        ((ActivityURIRequest)localObject1).extra().putString("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      }
    }
    ((ActivityURIRequest)localObject1).extra().putInt("enter_from", 52);
    ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFastImage.jdField_a_of_type_JavaLangString);
    if ((paramInt2 != -1) && (!QFileAssistantUtils.a(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      if (paramInt2 == 8)
      {
        if (paramQQAppInterface != null) {
          PlusPanelUtils.a((ActivityURIRequest)localObject1, paramSessionInfo, paramQQAppInterface);
        }
        ((ActivityURIRequest)localObject1).extra().putBoolean("callFromFastImage", true);
        ((ActivityURIRequest)localObject1).extra().putString("FROM_WHERE", "FromFastImage");
        ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1037);
        ((ActivityURIRequest)localObject1).extra().putString("key_activity_code", a(paramActivity));
      }
      else if (paramInt2 == 1)
      {
        if (paramQQAppInterface != null) {
          PlusPanelUtils.a((ActivityURIRequest)localObject1, paramSessionInfo, paramQQAppInterface);
        }
        ((ActivityURIRequest)localObject1).extra().putString("FROM_WHERE", "FromCamera");
        ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      }
    }
    if (QFileAssistantUtils.a(paramSessionInfo.jdField_a_of_type_JavaLangString))
    {
      ((ActivityURIRequest)localObject1).extra().putInt("enter_from", 51);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationFileAssistant.jdField_a_of_type_JavaLangString);
      ((ActivityURIRequest)localObject1).extra().putString("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationFileAssistant.jdField_a_of_type_JavaLangString);
      paramInt1 = 2;
      ((ActivityURIRequest)localObject1).extra().putInt(AlbumConstants.h, 2);
      i = 1;
    }
    if (paramIntent != null)
    {
      bool = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
      paramInt2 = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
      ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.IS_SINGLE_MODE", bool);
      if (paramInt2 == 1039) {
        ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1039);
      }
      if (paramInt2 == 1040) {
        ((ActivityURIRequest)localObject1).extra().putInt("PhotoConst.SEND_BUSINESS_TYPE", 1040);
      }
      PhotoUtils.copyReportInfo(paramIntent, (ActivityURIRequest)localObject1);
    }
    paramQQAppInterface = new ArrayList();
    paramQQAppInterface.add(localObject2);
    ((ActivityURIRequest)localObject1).extra().putStringArrayList("PhotoConst.PHOTO_PATHS", paramQQAppInterface);
    ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.HANDLE_DEST_RESULT", true);
    ((ActivityURIRequest)localObject1).extra().putBoolean("PhotoConst.ALLOW_LOCK", paramBoolean);
    ((ActivityURIRequest)localObject1).setFlags(603979776);
    if (i != 0) {
      ((ActivityURIRequest)localObject1).setRequestCode(paramInt1);
    }
    QRoute.startUri((URIRequest)localObject1);
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, String paramString5, Map<String, String> paramMap, boolean paramBoolean2)
  {
    Object localObject8 = paramQQAppInterface;
    Object localObject1 = paramString3;
    Object localObject3 = paramString4;
    int n = HardCoderManager.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootVideo");
    if (paramInt == 1011)
    {
      if (!ImageResUtil.a("random_talk_bg_2.png")) {
        ImageResUtil.a(paramQQAppInterface);
      }
      if (paramMap != null)
      {
        localObject4 = (String)paramMap.get("chat_type");
        if (paramMap != null)
        {
          localObject4 = (String)paramMap.get("encodeuin");
          if ((localObject4 != null) && (!TextUtils.isEmpty((CharSequence)localObject4)))
          {
            paramString1 = a((QQAppInterface)localObject8, (String)localObject4);
            if (paramString1 == null)
            {
              QLog.e("ChatActivityUtils", 1, "enterVideo Chat AnyOne decode peeruin Err!");
              return;
            }
          }
        }
      }
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("avideo enterVideo called, uinType[");
    ((StringBuilder)localObject4).append(paramInt);
    ((StringBuilder)localObject4).append("], peerUin[");
    ((StringBuilder)localObject4).append(paramString1);
    ((StringBuilder)localObject4).append("], name[");
    ((StringBuilder)localObject4).append(paramString2);
    ((StringBuilder)localObject4).append("], phoneNum[");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("], onlyAudio[");
    ((StringBuilder)localObject4).append(paramBoolean1);
    ((StringBuilder)localObject4).append("], extraUin[");
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append("], from[");
    ((StringBuilder)localObject4).append(paramString5);
    ((StringBuilder)localObject4).append("]");
    QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject4).toString());
    if ((paramQQAppInterface.isVideoChatting()) && (paramQQAppInterface.getAVNotifyCenter().f() != 1) && (paramQQAppInterface.getAVNotifyCenter().f() != 3000) && (paramQQAppInterface.getAVNotifyCenter().g()) && (paramQQAppInterface.getAVNotifyCenter().f()) && (paramQQAppInterface.getAVNotifyCenter().f() != 1011) && (paramQQAppInterface.getAVNotifyCenter().f() != 21))
    {
      paramQQAppInterface = new Intent(paramContext, VideoInviteActivity.class);
      paramQQAppInterface.addFlags(268435456);
      paramQQAppInterface.putExtra("uinType", paramInt);
      paramQQAppInterface.putExtra("peerUin", paramString1);
      paramQQAppInterface.putExtra("extraUin", (String)localObject3);
      paramQQAppInterface.putExtra("isAudioMode", paramBoolean1);
      paramContext.startActivity(paramQQAppInterface);
      return;
    }
    try
    {
      localObject4 = MediaPlayerManager.a(paramQQAppInterface);
      if (localObject4 != null) {
        ((MediaPlayerManager)localObject4).a(true);
      }
    }
    catch (Exception localException4)
    {
      localException4.printStackTrace();
    }
    Object localObject5;
    Object localObject6;
    if (paramInt == 0)
    {
      localObject5 = ((FriendsManager)((QQAppInterface)localObject8).getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
      if (localObject5 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("enterVideo terminal: ");
          ((StringBuilder)localObject6).append(ContactUtils.b((Friends)localObject5));
          ((StringBuilder)localObject6).append(", abilityBits: ");
          ((StringBuilder)localObject6).append(((Friends)localObject5).abilityBits);
          ((StringBuilder)localObject6).append(", _eSupportVoice: ");
          ((StringBuilder)localObject6).append(1);
          QLog.d("ChatActivityUtils", 2, ((StringBuilder)localObject6).toString());
        }
        if (FriendsUtils.a(((Friends)localObject5).eNetwork, ((Friends)localObject5).iTermType, ((Friends)localObject5).netTypeIconId) != 2)
        {
          bool1 = true;
          break label592;
        }
      }
    }
    boolean bool1 = false;
    label592:
    if ((paramInt != 1006) && (paramInt != 24) && (paramInt != 25))
    {
      localObject5 = localObject1;
      if (TextUtils.isEmpty(paramString3))
      {
        paramString3 = ((IPhoneContactService)((QQAppInterface)localObject8).getRuntimeService(IPhoneContactService.class, "")).queryPhoneContactByUin(paramString1);
        if (paramString3 != null)
        {
          localObject5 = paramString3.mobileNo;
        }
        else
        {
          localObject5 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.w("ChatActivityUtils", 2, "enterVideo cannot get phone number");
            localObject5 = localObject1;
          }
        }
      }
      localObject6 = null;
      localObject1 = null;
      paramString3 = (String)localObject5;
      localObject5 = localObject1;
    }
    else
    {
      if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)))
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("enterVideo uinType: ");
          paramQQAppInterface.append(paramInt);
          paramQQAppInterface.append(", peerUin: ");
          paramQQAppInterface.append(paramString1);
          paramQQAppInterface.append(", name: ");
          paramQQAppInterface.append(paramString2);
          paramQQAppInterface.append(", phoneNum: ");
          paramQQAppInterface.append((String)localObject1);
          paramQQAppInterface.append(", onlyAudio: ");
          paramQQAppInterface.append(paramBoolean1);
          paramQQAppInterface.append(", extraUin: ");
          paramQQAppInterface.append((String)localObject3);
          QLog.e("ChatActivityUtils", 2, paramQQAppInterface.toString());
        }
        return;
      }
      localObject7 = ((IPhoneContactService)((QQAppInterface)localObject8).getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
      if (localObject7 != null)
      {
        localObject5 = ((RespondQueryQQBindingStat)localObject7).nationCode;
        localObject6 = ((RespondQueryQQBindingStat)localObject7).mobileNo;
      }
      else
      {
        localObject6 = null;
        localObject5 = null;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = (String)localObject1;
        paramString3 = (String)localObject1;
      }
      else if (TextUtils.isEmpty(paramString3))
      {
        paramString3 = paramString1;
      }
      else
      {
        paramString3 = (String)localObject1;
      }
      if (((paramInt == 24) || (paramInt == 25)) && ((localObject7 == null) || (((RespondQueryQQBindingStat)localObject7).nationCode.equals("")) || (((RespondQueryQQBindingStat)localObject7).mobileNo.equals("")))) {
        break label3009;
      }
    }
    Object localObject7 = localObject3;
    if (paramInt == 1000)
    {
      localObject1 = (TroopManager)((QQAppInterface)localObject8).getManager(QQManagerFactory.TROOP_MANAGER);
      if (localObject1 != null) {
        localObject1 = ((TroopManager)localObject1).b((String)localObject3);
      } else {
        localObject1 = localObject3;
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityUtils", 2, "enterVideo can't find troop info!");
        }
        return;
      }
      localObject7 = localObject1;
    }
    if (paramInt == 9500) {
      if (paramMap != null) {
        paramString4 = (String)paramMap.get("devSubCode");
      } else {
        paramString4 = "";
      }
    }
    if (paramInt == 1011) {}
    try
    {
      localObject1 = (String)paramMap.get("sig");
      if (!QLog.isColorLevel()) {
        break label3054;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("sig string=");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.e("ChatActivityUtils", 2, ((StringBuilder)localObject3).toString());
    }
    catch (Exception paramQQAppInterface)
    {
      Object localObject9;
      for (;;)
      {
        int i;
      }
    }
    localObject1 = ((String)localObject1).replace("+", "").split(",");
    localObject3 = new byte[localObject1.length];
    i = 0;
    while (i < localObject1.length)
    {
      localObject3[i] = Byte.parseByte(localObject1[i].trim());
      i += 1;
    }
    try
    {
      localObject9 = new String(a(paramString2), "UTF-8");
      localObject1 = localObject9;
    }
    catch (Exception localException1)
    {
      label1271:
      int j;
      boolean bool2;
      int k;
      int m;
      int i1;
      int i2;
      int i3;
      Intent localIntent;
      break label1271;
    }
    try
    {
      if (!QLog.isColorLevel()) {
        break label1275;
      }
      paramString2 = new StringBuilder();
      paramString2.append("UTF-8 == ");
      paramString2.append((String)localObject9);
      QLog.e("ChatActivityUtils", 2, paramString2.toString());
      localObject1 = localObject9;
    }
    catch (Exception paramString2)
    {
      localObject2 = localObject9;
      break label1275;
    }
    localObject1 = paramString2;
    label1275:
    j = 1;
    paramString2 = (String)localObject3;
    break label1322;
    if (QLog.isColorLevel()) {
      QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
    }
    return;
    localObject3 = VideoMsgTools.a((QQAppInterface)localObject8, paramInt, paramString1);
    j = 0;
    localObject1 = paramString2;
    paramString2 = (String)localObject3;
    label1322:
    if (((paramInt == 1025) || (paramInt == 1024)) && (paramString2 != null) && (paramString2.length == 3))
    {
      if (paramBoolean1) {
        paramQQAppInterface = paramContext.getString(2131698334);
      } else {
        paramQQAppInterface = paramContext.getString(2131698335);
      }
      if (!(paramContext instanceof Activity)) {
        paramContext = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
      }
      DialogUtil.a(paramContext, 230, null, paramQQAppInterface, null, paramContext.getString(2131694583), new ChatActivityUtils.3(), null).show();
      return;
    }
    localObject9 = ((IOnlineStatusService)((QQAppInterface)localObject8).getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    bool2 = a((QQAppInterface)localObject8, paramString1);
    k = -1;
    localObject3 = ((FriendsManager)((QQAppInterface)localObject8).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
    if (localObject3 != null)
    {
      k = ContactUtils.a((Friends)localObject3, (QQAppInterface)localObject8);
      m = OnlineStatusUtils.a(((Friends)localObject3).detalStatusFlag, ((Friends)localObject3).iTermType);
    }
    else
    {
      m = 0;
    }
    i = ((ISVIPHandler)((QQAppInterface)localObject8).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    if (i == 2) {
      i = 0;
    } else if (i == 3) {
      i = 2;
    }
    i1 = VipFunCallUtil.a((AppRuntime)localObject8, paramString1, 3, true, null);
    if (i1 != 0)
    {
      if ((paramInt != 0) && (paramInt != 1004) && (paramInt != 1000) && (paramInt != 1003)) {
        break label1637;
      }
      localObject3 = (ColorRingManager)((QQAppInterface)localObject8).getManager(QQManagerFactory.COLOR_RING_MANAGER);
      if ((!new File(ColorRingManager.a(i1, 3)).exists()) && (VipFunCallUtil.a())) {
        ((ColorRingManager)localObject3).a(i1, 3, false, 0, "colorring");
      }
    }
    label1637:
    localObject3 = paramQQAppInterface;
    i2 = FunCallUtil.a((AppRuntime)localObject3, paramString1, true, true);
    if (i2 != 0)
    {
      i3 = VipFunCallUtil.a();
      localObject8 = VipFunCallUtil.a((AppRuntime)localObject3, i2, i3, null);
      if ((!TextUtils.isEmpty((CharSequence)localObject8)) && (!new File((String)localObject8).exists()) && (VipFunCallUtil.a())) {
        VasUtil.a().getFunCallManager().startDownload(i2, i3, false, 0);
      }
    }
    try
    {
      localObject3 = (VipSetFunCallHandler)((QQAppInterface)localObject3).getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
      localObject8 = new Bundle();
      try
      {
        ((Bundle)localObject8).putLong("uin", Long.parseLong(paramString1));
        ((Bundle)localObject8).putString("phone", "");
        ((VipSetFunCallHandler)localObject3).a(2, localObject8);
      }
      catch (Exception localException2) {}
      localObject8 = new StringBuilder();
    }
    catch (Exception localException3) {}
    ((StringBuilder)localObject8).append("VipSetFunCallHandler Error:");
    ((StringBuilder)localObject8).append(localException3.getMessage());
    QLog.e("ChatActivityUtils", 1, ((StringBuilder)localObject8).toString());
    localIntent = new Intent(paramContext, AVActivity.class);
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.putExtra("uinType", paramInt);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("name", (String)localObject1);
    localIntent.putExtra("selfNation", (String)localObject5);
    localIntent.putExtra("selfMobile", (String)localObject6);
    localIntent.putExtra("toMobile", paramString3);
    localIntent.putExtra("receive", false);
    localIntent.putExtra("isAudioMode", paramBoolean1);
    localIntent.putExtra("istatus", ((AppRuntime.Status)localObject9).getValue());
    localIntent.putExtra("remoteStatus", m);
    localIntent.putExtra("extraUin", (String)localObject7);
    localIntent.putExtra("extraCode", paramString4);
    localIntent.putExtra("isPeerNetworkWell", bool1);
    localIntent.putExtra("isFriend", bool2);
    localIntent.putExtra("senderStartTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("isSender", true);
    localIntent.putExtra("colorRingId", i1);
    localIntent.putExtra("vipType", i);
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    localIntent.putExtra("sessionType", i);
    localIntent.putExtra("hc_code", n);
    localIntent.putExtra("main_timestamp", System.currentTimeMillis());
    if (paramMap != null)
    {
      paramString4 = (String)paramMap.get("dstClient");
      localObject1 = (String)paramMap.get("bindId");
      localObject5 = (String)paramMap.get("bindType");
      localObject6 = (String)paramMap.get("extraType");
      if (paramString4 != null)
      {
        localIntent.putExtra("dstClient", paramString4);
        localIntent.putExtra("bindId", (String)localObject1);
        localIntent.putExtra("bindType", Integer.valueOf((String)localObject5).intValue());
        localIntent.putExtra("extraType", Integer.valueOf((String)localObject6).intValue());
        paramString4 = (String)paramMap.get("sig");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("sig string=");
          ((StringBuilder)localObject1).append(paramString4);
          QLog.e("ChatActivityUtils", 2, ((StringBuilder)localObject1).toString());
        }
        if (paramString4 == null) {}
      }
    }
    try
    {
      paramString2 = HexUtil.hexStr2Bytes(paramString4);
      HexUtil.printHexString("ChatActivityUtils", paramString2);
    }
    catch (Exception paramQQAppInterface)
    {
      label2311:
      Object localObject2;
      break label2311;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
    }
    return;
    paramString4 = (String)paramMap.get("actid");
    localIntent.putExtra("actId", paramString4);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("entervideo actid = ");
      ((StringBuilder)localObject1).append(paramString4);
      QLog.e("ChatActivityUtils", 2, ((StringBuilder)localObject1).toString());
    }
    paramString4 = (String)paramMap.get("mp_ext_params");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("entervideo mp_ext_params = ");
      ((StringBuilder)localObject1).append(paramString4);
      QLog.e("ChatActivityUtils", 2, ((StringBuilder)localObject1).toString());
    }
    localIntent.putExtra("mp_ext_params", paramString4);
    localIntent.putExtra("sig", paramString2);
    if (paramInt == 1011)
    {
      paramString2 = (String)paramMap.get("sex");
      paramString4 = (String)paramMap.get("headUrl");
      paramMap = new StringBuilder();
      paramMap.append(paramString4);
      paramMap.append(paramString2);
      paramMap.append(".jpg");
      localIntent.putExtra("headUrl", paramMap.toString());
    }
    if (paramQQAppInterface.getAVNotifyCenter().d(paramString1))
    {
      if (paramQQAppInterface.getAVNotifyCenter().b(paramString1) == 1) {
        localIntent.putExtra("isAudioMode", true);
      } else {
        localIntent.putExtra("isAudioMode", false);
      }
      localIntent.putExtra("startfromVideoEntry", paramBoolean1 ^ true);
      localIntent.putExtra("sessionType", paramQQAppInterface.getAVNotifyCenter().b(paramString1));
    }
    localIntent.putExtra("from", paramString5);
    localIntent.putExtra("Fromwhere", paramString5);
    localIntent.putExtra("friendTerminal", k);
    localIntent.putExtra("isOtherTerminalOnChating", paramQQAppInterface.getAVNotifyCenter().d(paramString1));
    localIntent.putExtra("otherTerminalChatingRoomId", paramQQAppInterface.getAVNotifyCenter().a(paramString1));
    localIntent.putExtra("triggerBeauty", paramBoolean2);
    localIntent.putExtra("isMakingAcall", true);
    if ("AIOQAVWatchTogether".equals(paramString5))
    {
      paramString2 = ChooseFileAssistant.a().a(paramInt, paramString1);
      if (paramString2 != null) {
        localIntent.putExtra("ChooseFileInfo", paramString2);
      }
      ChooseFileAssistant.a().a(paramInt, paramString1);
    }
    if ((paramString1 != null) || (paramString3 != null))
    {
      paramString2 = paramQQAppInterface.getAVNotifyCenter();
      paramString4 = paramQQAppInterface.getCurrentUin();
      if (paramString1 != null) {
        paramString3 = paramString1;
      }
      paramString2.a(paramString4, paramString3, paramBoolean1 ^ true, paramInt);
    }
    paramString1 = localIntent.getComponent().getClassName();
    paramString2 = paramContext.getClass().getName();
    if ((paramString1.equals("com.tencent.av.ui.AVActivity")) && ((paramString2.equals("com.tencent.mobileqq.qcall.QCallDetailActivity")) || (paramString2.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) || (paramString2.equals("com.tencent.mobileqq.activity.SplashActivity")) || (paramString2.equals("com.tencent.mobileqq.activity.PublicFragmentActivity")) || (paramInt == 9500) || (paramInt == 1044)))
    {
      paramString1 = new Intent(paramContext, AVLoadingDialogActivity.class);
      paramString1.putExtra("avactivity_intent", localIntent);
      paramString1.addFlags(268435456);
      paramContext.startActivity(paramString1);
    }
    else
    {
      paramContext.startActivity(localIntent);
    }
    if ((paramBoolean2) && ((paramContext instanceof Activity))) {
      ((Activity)paramContext).overridePendingTransition(2130772176, 2130772177);
    }
    if (paramQQAppInterface.isVideoChatting())
    {
      if (j != 0) {
        return;
      }
      if (paramInt == 9500) {
        return;
      }
      if ((paramContext instanceof Activity)) {
        ((Activity)paramContext).overridePendingTransition(2130772189, 0);
      }
    }
    return;
    label3009:
    QQToast.a(paramContext, 2131695717, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Activity paramActivity)
  {
    a(paramQQAppInterface, paramView, paramActivity, -2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick().");
    }
    if ((paramActivity != null) && (paramActivity.getCurrentFocus() != null)) {
      ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 0);
    } else if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "chatActivity current focus is null");
    }
    Context localContext = paramView.getContext();
    if (localContext == null) {
      return;
    }
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (localChatMessage == null) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool1 = localChatMessage instanceof MessageForLongMsg;
    boolean bool2;
    if (bool1)
    {
      bool1 = localChatMessage.isShowQIMStyleGroup;
      bool2 = localChatMessage.isShowTIMStyleGroup;
      localObject1 = ((MessageForLongMsg)localChatMessage).msg;
      bool1 ^= true;
      bool2 ^= true;
    }
    else if ((localChatMessage instanceof MessageForText))
    {
      boolean bool3 = localChatMessage.isShowQIMStyleGroup ^ true;
      boolean bool4 = localChatMessage.isShowTIMStyleGroup ^ true;
      localObject2 = (MessageForText)localChatMessage;
      if ((((MessageForText)localObject2).sb instanceof QQText)) {
        localObject1 = ((QQText)((MessageForText)localObject2).sb).mSource;
      } else if ((((MessageForText)localObject2).sb instanceof Spannable)) {
        localObject1 = ((MessageForText)localObject2).sb.toString();
      }
      bool1 = bool3;
      bool2 = bool4;
      if (localChatMessage.msgtype == -2008) {
        if (localChatMessage.isSend())
        {
          localObject1 = localContext.getString(2131718657);
          bool1 = bool3;
          bool2 = bool4;
        }
        else
        {
          localObject1 = localContext.getString(2131718656);
          bool1 = bool3;
          bool2 = bool4;
        }
      }
    }
    else
    {
      if ((localChatMessage instanceof MessageForQQStoryComment))
      {
        localObject1 = (MessageForQQStoryComment)localChatMessage;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("“");
        ((StringBuilder)localObject2).append(((MessageForQQStoryComment)localObject1).title);
        ((StringBuilder)localObject2).append("”\n");
        ((StringBuilder)localObject2).append(((MessageForQQStoryComment)localObject1).comment);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      for (;;)
      {
        bool1 = true;
        bool2 = true;
        break;
        if ((!(localChatMessage instanceof MessageForReplyText)) && (!bool1))
        {
          label507:
          Object localObject3;
          if ((localChatMessage instanceof MessageForMixedMsg))
          {
            localObject2 = (MessageForMixedMsg)localChatMessage;
            localObject1 = ((MessageForMixedMsg)localObject2).getReplyMessage(paramQQAppInterface);
            if ((paramView.getId() == 2131371529) && ((paramView instanceof ETTextView))) {
              if (localObject1 != null)
              {
                localObject1 = a(paramQQAppInterface, (ChatMessage)localObject1, localContext, paramView, false);
                continue;
              }
            }
            do
            {
              localObject1 = "";
              break;
              if (paramView.getId() != 2131364549) {
                break label507;
              }
            } while (((ETTextView)paramView.findViewById(2131371529) == null) || (localObject1 == null));
            localObject1 = a(paramQQAppInterface, (ChatMessage)localObject1, localContext, paramView, false);
            continue;
            if (localObject1 != null) {
              localObject1 = a(paramQQAppInterface, (ChatMessage)localObject1, localContext, paramView, false);
            } else {
              localObject1 = "";
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(((MessageForMixedMsg)localObject2).msg);
            localObject1 = ((StringBuilder)localObject3).toString();
          }
          else
          {
            localObject1 = localObject2;
            if ((localChatMessage instanceof MessageForHiBoom))
            {
              localObject3 = (MessageForHiBoom)localChatMessage;
              localObject1 = localObject2;
              if (((MessageForHiBoom)localObject3).mHiBoomMessage != null) {
                localObject1 = ((MessageForHiBoom)localObject3).mHiBoomMessage.text;
              }
            }
          }
        }
        else
        {
          localObject1 = a(paramQQAppInterface, localChatMessage, localContext, paramView, true);
        }
      }
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick() CharSequence null.");
      }
      return;
    }
    localObject2 = new Intent(localContext, TextPreviewActivity.class);
    ((Intent)localObject2).putExtra("peeruin", localChatMessage.frienduin);
    ((Intent)localObject2).putExtra("uin_type", localChatMessage.istroop);
    ((Intent)localObject2).putExtra("content", (String)localObject1);
    ((Intent)localObject2).putExtra("uniseq", localChatMessage.uniseq);
    ((Intent)localObject2).putExtra("bubbleId", localChatMessage.vipBubbleID);
    ((Intent)localObject2).putExtra("bubbleDiyId", localChatMessage.vipBubbleDiyTextId);
    ((Intent)localObject2).putExtra("fontId", localChatMessage.getExtInfoFromExtStr("vip_font_id"));
    ((Intent)localObject2).putExtra("troop_at_info", localChatMessage.getExtInfoFromExtStr(MessageConstants.i));
    ((Intent)localObject2).putExtra("origin_merge_structing_msg_uniseq", a(localChatMessage, paramActivity));
    ((Intent)localObject2).putExtra("senderUin", localChatMessage.senderuin);
    ((Intent)localObject2).putExtra("sessionType", paramInt);
    ((Intent)localObject2).putExtra("isMultiMsg", localChatMessage.isMultiMsg);
    paramActivity = localChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
    if ((!TextUtils.isEmpty(paramActivity)) && (TextUtils.isDigitsOnly(paramActivity))) {
      i = Integer.valueOf(paramActivity).intValue();
    } else {
      i = 0;
    }
    paramInt = i;
    if (i == 0)
    {
      paramInt = i;
      if (FontManagerConstants.parseMagicFont(localChatMessage)) {
        paramInt = 1;
      }
    }
    int i = paramInt;
    if (paramInt != 0)
    {
      i = paramInt;
      if (1 == localChatMessage.istroop)
      {
        i = paramInt;
        if (AnonymousChatHelper.a(localChatMessage)) {
          i = 0;
        }
      }
    }
    ((Intent)localObject2).putExtra("fontEffectId", i);
    ((Intent)localObject2).putExtra(QIMUserManager.jdField_a_of_type_JavaLangString, bool1);
    ((Intent)localObject2).putExtra(TIMUserManager.jdField_a_of_type_JavaLangString, bool2);
    if ((localChatMessage instanceof MessageForHiBoom))
    {
      paramActivity = (MessageForHiBoom)localChatMessage;
      if ((paramActivity.mHiBoomMessage != null) && ((paramView instanceof HiBoomTextView)))
      {
        ((Intent)localObject2).putExtra("HiBoomId", paramActivity.mHiBoomMessage.id);
        paramQQAppInterface = paramQQAppInterface.getCurrentUin();
        paramView = new StringBuilder();
        paramView.append("");
        paramView.append(paramActivity.mHiBoomMessage.id);
        VasWebviewUtil.a(paramQQAppInterface, "HighFont", "AioDoubleClick", "", 1, 0, 0, "", paramView.toString(), "");
      }
    }
    if (localChatMessage.isSend()) {
      paramQQAppInterface = localChatMessage.selfuin;
    }
    for (;;)
    {
      break;
      if ((localChatMessage.istroop != 1000) && (localChatMessage.istroop != 1020) && (localChatMessage.istroop != 1004)) {
        paramQQAppInterface = localChatMessage.senderuin;
      } else {
        paramQQAppInterface = localChatMessage.frienduin;
      }
    }
    ((Intent)localObject2).putExtra("real_msg_sender_uin", paramQQAppInterface);
    paramView = (Activity)localContext;
    paramView.startActivityForResult((Intent)localObject2, 14001);
    paramView.overridePendingTransition(2130772021, 0);
    VasWebviewUtil.a(paramQQAppInterface, "long_msg", "long_msg_double", "", 1, 0, 0, "", String.valueOf(SVIPHandlerConstants.a(localChatMessage.vipBubbleID)), "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Integer paramInteger)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      if (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin())) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setTroopTipStatus, troopUin:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",status:");
        ((StringBuilder)localObject).append(paramInteger);
        QLog.d("ChatActivityUtils.troop.notification_center.show_red_dot", 2, ((StringBuilder)localObject).toString());
      }
      if ((paramInteger.intValue() != -1) && (paramInteger.intValue() != 0)) {
        return;
      }
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      Object localObject = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      ((ConcurrentHashMap)localObject).put(localStringBuilder.toString(), paramInteger);
      if (paramInteger.intValue() == -1)
      {
        paramInteger = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        int j = 0;
        int i = j;
        if (paramInteger != null)
        {
          paramInteger = paramInteger.b(paramString);
          i = j;
          if (paramInteger != null)
          {
            localObject = paramQQAppInterface.getCurrentAccountUin();
            i = j;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              i = j;
              if (!TextUtils.isEmpty(paramInteger.Administrator)) {
                if (!((String)localObject).equals(paramInteger.Administrator))
                {
                  i = j;
                  if (!paramInteger.Administrator.contains((CharSequence)localObject)) {}
                }
                else
                {
                  i = 1;
                }
              }
            }
          }
        }
        if (i != 0) {
          paramInteger = "0";
        } else {
          paramInteger = "1";
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
      }
    }
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    long l1;
    if (paramMap != null)
    {
      String str = (String)paramMap.get("business_type");
      int j = 0;
      int i = j;
      if (str != null)
      {
        i = j;
        if (str.equals("1")) {
          i = 1;
        }
      }
      if (i != 0) {
        l1 = -1L;
      }
    }
    try
    {
      long l2 = Long.parseLong((String)paramMap.get("group_id"));
      l1 = l2;
    }
    catch (NumberFormatException paramMap)
    {
      label72:
      break label72;
    }
    paramMap = new Intent();
    paramMap.setAction("android.intent.action.gameparty.refresh");
    paramMap.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramMap.putExtra("teamId", l1);
    paramQQAppInterface.getApp().sendBroadcast(paramMap);
  }
  
  static boolean a(long paramLong1, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean, String paramString, int paramInt1, long paramLong2, int paramInt2)
  {
    if ((paramBoolean) && (paramQQAppInterface.isVideoChatting()))
    {
      int i = paramQQAppInterface.getAVNotifyCenter().b();
      int j = paramQQAppInterface.getAVNotifyCenter().c();
      int k = paramQQAppInterface.getAVNotifyCenter().e();
      if (((j != 1) && (j != 2)) || (((i < 1) || (i > 5)) && (k != 1) && (k != 2)))
      {
        if (((j != 3) && (j != 4)) || (((i >= 1) && (i <= 5)) || (k == 3) || (k == 4)))
        {
          long l1 = paramQQAppInterface.getAVNotifyCenter().b();
          if ((l1 == paramLong2) && (paramInt1 != 1) && (paramInt1 != 2))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatActivityUtils", 2, "startGroupAudio-->chatUin==discussid???Why");
            }
            return true;
          }
          long l2 = paramQQAppInterface.getAVNotifyCenter().b();
          if (l2 > 0L)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("checkMutex, chatingRelationId[");
            ((StringBuilder)localObject).append(l2);
            ((StringBuilder)localObject).append("], chatUin[");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append("], discussId[");
            ((StringBuilder)localObject).append(paramLong2);
            ((StringBuilder)localObject).append("], seq[");
            ((StringBuilder)localObject).append(paramLong1);
            ((StringBuilder)localObject).append("]");
            QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject).toString());
            if ((l1 != paramLong2) || ((paramInt1 != 2) && (paramInt1 != 1)))
            {
              localObject = paramContext.getString(2131695517);
              String str = paramQQAppInterface.getCurrentAccountUin();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString);
              localStringBuilder.append("");
              i = TroopMemberUtil.a(paramQQAppInterface, str, localStringBuilder.toString());
              PopupDialog.a(paramContext, 230, null, (String)localObject, 2131695421, 2131695433, new ChatActivityUtils.7(paramLong1, paramQQAppInterface, paramContext, paramInt1, paramInt2, paramOnClickListener, paramString, i), new ChatActivityUtils.8(paramStartVideoListener, paramString, i, paramQQAppInterface));
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(paramString);
              paramQQAppInterface.append("");
              paramQQAppInterface = paramQQAppInterface.toString();
              paramContext = new StringBuilder();
              paramContext.append(i);
              paramContext.append("");
              ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramQQAppInterface, paramContext.toString(), "", "");
              return true;
            }
          }
        }
      }
      else
      {
        QQToast.a(paramContext, 2131695889, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
        return true;
      }
    }
    return false;
  }
  
  protected static boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag)
  {
    Object localObject1 = paramContext;
    if (QQAudioHelper.a(13) == 1)
    {
      QLog.d("ChatActivityUtils", 1, "音视频进程在等待调试器连接(界面会无响应)");
      QQAudioHelper.c(HardCodeUtil.a(2131701793));
    }
    if (!paramQQAppInterface.isVideoChatting())
    {
      if ((localObject1 instanceof com.tencent.mobileqq.app.BaseActivity))
      {
        localObject1 = (com.tencent.mobileqq.app.BaseActivity)localObject1;
      }
      else
      {
        localObject2 = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startVideoCheck, Context[");
        localStringBuilder.append(localObject1);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w("ChatActivityUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
        localObject1 = localObject2;
      }
      boolean bool = paramVideoCheckFlag.jdField_a_of_type_Boolean;
      if (!a((Activity)localObject1, bool, new ChatActivityUtils.1(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag, (com.tencent.mobileqq.app.BaseActivity)localObject1, bool))) {
        return false;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005757", "0X8005757", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575B", "0X800575B", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575F", "0X800575F", 0, 0, "", "", "", "");
      if (paramQQAppInterface.getAVNotifyCenter().a()) {
        return ChatAVHelper.a(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag).booleanValue();
      }
      if (((paramVideoCheckFlag.jdField_a_of_type_Int == 1006) && (!a(paramQQAppInterface, paramVideoCheckFlag.jdField_a_of_type_JavaLangString))) || (paramVideoCheckFlag.jdField_a_of_type_Int == 1024) || (paramVideoCheckFlag.jdField_a_of_type_Int == 1011))
      {
        localObject2 = ChatAVHelper.b(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag);
        if (localObject2 != null) {
          return ((Boolean)localObject2).booleanValue();
        }
      }
      if ((paramVideoCheckFlag.jdField_a_of_type_Boolean) && (!ConfigSystemImpl.a(paramContext))) {
        return ChatAVHelper.c(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag).booleanValue();
      }
      if (paramVideoCheckFlag.jdField_a_of_type_Int == 1010)
      {
        localObject2 = ChatAVHelper.d(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag);
        if (localObject2 != null) {
          return ((Boolean)localObject2).booleanValue();
        }
      }
      if ((paramVideoCheckFlag.jdField_a_of_type_Int == 1044) && (((IExpandLimitChatManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a((Context)localObject1))) {
        return false;
      }
      if ((paramVideoCheckFlag.jdField_b_of_type_Boolean) && (a(paramQQAppInterface, paramVideoCheckFlag.jdField_a_of_type_Int, paramVideoCheckFlag.jdField_a_of_type_JavaLangString, paramVideoCheckFlag.jdField_c_of_type_JavaLangString)) && (paramVideoCheckFlag.jdField_a_of_type_Int != 1024)) {
        return ChatAVHelper.e(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag).booleanValue();
      }
      if (!NetworkUtil.isNetSupport(paramContext)) {
        return ChatAVHelper.f(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag).booleanValue();
      }
      bool = NetworkUtil.isWifiConnected(paramContext);
      if ((paramVideoCheckFlag.jdField_a_of_type_Int == 1024) && (!bool) && (NetworkUtil.getSystemNetwork(paramContext) == 2))
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        QQToast.a(paramContext, 2131695438, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
        return false;
      }
      if ((paramVideoCheckFlag.jdField_c_of_type_Boolean) && (!bool) && (!NetworkUtil.isBluetoothSharedNetwork(paramContext))) {
        return ChatAVHelper.g(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag).booleanValue();
      }
    }
    else
    {
      localObject1 = ChatAVHelper.h(paramLong, paramQQAppInterface, paramContext, paramStartVideoListener, paramVideoCheckFlag);
      if (localObject1 != null) {
        return ((Boolean)localObject1).booleanValue();
      }
    }
    localObject1 = paramContext;
    Object localObject2 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramVideoCheckFlag.jdField_a_of_type_Int == 0) && (!((FriendsManager)localObject2).b(paramVideoCheckFlag.jdField_a_of_type_JavaLangString))) {
      if (QQAudioHelper.a(16) == 1)
      {
        QQAudioHelper.a(HardCodeUtil.a(2131701768));
      }
      else
      {
        int i;
        if (paramVideoCheckFlag.jdField_a_of_type_Boolean) {
          i = 2131695414;
        } else {
          i = 2131695415;
        }
        paramQQAppInterface = ((Context)localObject1).getString(i);
        PopupDialog.a(paramContext, 230, ((Context)localObject1).getString(2131695691), paramQQAppInterface, 2131690728, 2131695565, new ChatActivityUtils.2(), null);
        return false;
      }
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005766", "0X8005766", 0, 0, "", "", "", "");
    if (paramStartVideoListener != null) {
      paramStartVideoListener.b();
    }
    a(paramQQAppInterface, paramContext, paramVideoCheckFlag.jdField_a_of_type_Int, paramVideoCheckFlag.jdField_a_of_type_JavaLangString, paramVideoCheckFlag.jdField_b_of_type_JavaLangString, paramVideoCheckFlag.jdField_c_of_type_JavaLangString, paramVideoCheckFlag.jdField_a_of_type_Boolean, paramVideoCheckFlag.jdField_d_of_type_JavaLangString, paramVideoCheckFlag.jdField_e_of_type_JavaLangString, paramVideoCheckFlag.jdField_a_of_type_JavaUtilMap, paramVideoCheckFlag.jdField_e_of_type_Boolean);
    if (paramStartVideoListener != null) {
      paramStartVideoListener.c();
    }
    return true;
  }
  
  public static boolean a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    com.tencent.mobileqq.app.BaseActivity localBaseActivity;
    int i;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localBaseActivity = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      bool1 = localBaseActivity.isFinishing();
      i = 1;
    }
    else
    {
      localBaseActivity = null;
      i = 0;
      bool1 = true;
    }
    mqq.app.BaseActivity localBaseActivity1;
    boolean bool3;
    if ((paramActivity instanceof mqq.app.BaseActivity))
    {
      localBaseActivity1 = (mqq.app.BaseActivity)paramActivity;
      bool3 = localBaseActivity1.isFinishing();
      i = 2;
    }
    else
    {
      localBaseActivity1 = null;
      bool3 = bool1;
    }
    if ((localBaseActivity == null) && (localBaseActivity1 == null)) {
      return true;
    }
    if (localBaseActivity != null)
    {
      if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
    }
    for (;;)
    {
      bool2 = bool1;
      break label176;
      do
      {
        bool1 = false;
        break label179;
        if (localBaseActivity1 == null) {
          break;
        }
        if (localBaseActivity1.checkSelfPermission("android.permission.CAMERA") == 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
      } while (localBaseActivity1.checkSelfPermission("android.permission.RECORD_AUDIO") != 0);
    }
    boolean bool2 = true;
    label176:
    boolean bool1 = true;
    label179:
    boolean bool4 = VideoController.a(paramActivity);
    if ((QLog.isDevelopLevel()) || (!bool2) || (!bool1) || (bool4))
    {
      paramActivity = new StringBuilder();
      paramActivity.append("checkQAVPermission, Camera[");
      paramActivity.append(bool2);
      paramActivity.append("], audio[");
      paramActivity.append(bool1);
      paramActivity.append("], onlyAudio[");
      paramActivity.append(paramBoolean);
      paramActivity.append("], activityType[");
      paramActivity.append(i);
      paramActivity.append("], isScreenLocked[");
      paramActivity.append(bool4);
      paramActivity.append("], isFinishing[");
      paramActivity.append(bool3);
      paramActivity.append("]");
      QLog.w("ChatActivityUtils", 1, paramActivity.toString());
    }
    if (paramBoolean) {
      bool2 = true;
    }
    if ((bool2) && (bool1)) {
      return true;
    }
    if (bool4)
    {
      paramOnClickListener.onClick(null, -1);
      return false;
    }
    paramActivity = new ChatActivityUtils.20(paramOnClickListener);
    if ((!bool2) && (!bool1))
    {
      if (localBaseActivity != null)
      {
        localBaseActivity.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        return false;
      }
      if (localBaseActivity1 != null)
      {
        localBaseActivity1.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        return false;
      }
    }
    else if (!bool2)
    {
      if (localBaseActivity != null)
      {
        localBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
        return false;
      }
      if (localBaseActivity1 != null)
      {
        localBaseActivity1.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
        return false;
      }
    }
    else if (!bool1)
    {
      if (localBaseActivity != null)
      {
        localBaseActivity.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
        return false;
      }
      if (localBaseActivity1 != null) {
        localBaseActivity1.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "");
    if (TextUtils.isEmpty(paramContext)) {
      return false;
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("single friend list: ");
      paramString.append(paramContext);
      paramString.append(" curType:");
      paramString.append(paramSessionInfo.jdField_a_of_type_Int);
      paramString.append(" curFriendUin:");
      paramString.append(paramSessionInfo.jdField_a_of_type_JavaLangString);
      QLog.d("ChatActivityUtils", 4, paramString.toString());
    }
    try
    {
      paramContext = new JSONArray(paramContext);
      int i = 0;
      while (i < paramContext.length())
      {
        paramString = paramContext.getJSONObject(i);
        if ((paramString.has("type")) && (paramString.has("uin")))
        {
          int j = paramString.getInt("type");
          paramString = paramString.getString("uin");
          if ((j == paramSessionInfo.jdField_a_of_type_Int) && (paramString.equals(UinMD5Cache.a(paramSessionInfo.jdField_a_of_type_JavaLangString))))
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore true");
            }
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString2, "");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return true;
    }
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("single friend list: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" curType:");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" uin:");
      ((StringBuilder)localObject2).append(paramString1);
      QLog.d("ChatActivityUtils", 4, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new JSONArray((String)localObject1);
        localObject1 = new JSONArray();
        i = 0;
        if (i < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
          if ((localJSONObject.has("type")) && (localJSONObject.has("uin")))
          {
            int j = localJSONObject.getInt("type");
            String str = localJSONObject.getString("uin");
            if ((j != paramInt) || (!str.equals(UinMD5Cache.a(paramString1)))) {
              ((JSONArray)localObject1).put(localJSONObject);
            }
          }
        }
        else
        {
          paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
          paramContext.putString(paramString2, ((JSONArray)localObject1).toString());
          boolean bool = paramContext.commit();
          return bool;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((1024 == paramInt) && (CrmUtils.a(paramQQAppInterface, paramString))) {
      return false;
    }
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramInt == 0) && (!paramQQAppInterface.b(paramString)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "isSingleWayFriend  true");
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isMsgShielded() ==== uinType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ChatActivityUtils", 2, ((StringBuilder)localObject).toString());
    }
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0)
    {
      bool1 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
    }
    else if ((paramInt != 1001) && (paramInt != 10002) && (paramInt != 10010))
    {
      if (paramInt == 1011)
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (localShieldMsgManger != null)
        {
          localObject = paramString1;
          if (paramInt == 1006)
          {
            localObject = paramString1;
            if (paramString1 == null) {
              localObject = ContactUtils.b(paramQQAppInterface, paramString2);
            }
          }
          bool1 = bool2;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            bool1 = localShieldMsgManger.a((String)localObject);
          }
        }
      }
    }
    else
    {
      paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      bool2 = bool1;
      if (localShieldMsgManger != null) {
        bool2 = localShieldMsgManger.a(paramString1);
      }
      bool1 = bool2;
      if (!bool2)
      {
        paramQQAppInterface = paramQQAppInterface.e(paramString1);
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (paramQQAppInterface.groupid == -1002) {
            bool1 = true;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isMsgShielded() ==== isMsgShield = ");
      paramQQAppInterface.append(bool1);
      QLog.d("ChatActivityUtils", 2, paramQQAppInterface.toString());
    }
    return bool1;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt1 == 1) && (paramQQAppInterface.getAVNotifyCenter().a(paramInt1, paramLong)) && (paramQQAppInterface.getAVNotifyCenter().h()) && (paramInt2 == 1))
    {
      paramLong = QQAudioHelper.b();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkGroupInAnotherChating, seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w("ChatActivityUtils", 1, localStringBuilder.toString());
      }
      long l = paramQQAppInterface.getAVNotifyCenter().b();
      paramInt1 = paramQQAppInterface.getAVNotifyCenter().b(l);
      if (paramInt1 != paramInt3)
      {
        if ((paramInt1 == 10) && (paramInt3 == 2))
        {
          if (paramQQAppInterface.getAVNotifyCenter().c())
          {
            QQToast.a(paramContext, 2131695516, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
            return true;
          }
          QQToast.a(paramContext, 2131695518, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
          return true;
        }
        if ((paramInt1 == 2) && (paramInt3 == 10))
        {
          if (paramQQAppInterface.getAVNotifyCenter().c())
          {
            QQToast.a(paramContext, 2131695519, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
            return true;
          }
          QQToast.a(paramContext, 2131695515, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
          return true;
        }
      }
      if (paramInt3 == 2)
      {
        paramQQAppInterface = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
        SeqUtil.a(paramQQAppInterface, paramLong);
        paramContext.sendBroadcast(paramQQAppInterface);
        return false;
      }
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5, Map<String, String> paramMap)
  {
    if (QLog.isDevelopLevel()) {
      localObject = new Throwable("打印调用栈");
    } else {
      localObject = null;
    }
    long l = QQAudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startVideo, uinType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], peerUin[");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("], name[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("], phoneNum[");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("], onlyAudio[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], extraUin[");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("], checkShieldMsg[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], checkWifi[");
    localStringBuilder.append(paramBoolean3);
    localStringBuilder.append("], from[");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w("ChatActivityUtils", 1, localStringBuilder.toString(), (Throwable)localObject);
    Object localObject = new ChatActivityUtils.VideoCheckFlag();
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_a_of_type_Int = paramInt;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_a_of_type_JavaLangString = paramString1;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_b_of_type_JavaLangString = paramString2;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_c_of_type_JavaLangString = paramString3;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_a_of_type_Boolean = paramBoolean1;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_d_of_type_JavaLangString = paramString4;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_b_of_type_Boolean = paramBoolean2;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_c_of_type_Boolean = paramBoolean3;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_e_of_type_JavaLangString = paramString5;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_a_of_type_JavaUtilMap = paramMap;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_d_of_type_Boolean = true;
    ((ChatActivityUtils.VideoCheckFlag)localObject).jdField_e_of_type_Boolean = false;
    return a(l, paramQQAppInterface, paramContext, paramStartVideoListener, (ChatActivityUtils.VideoCheckFlag)localObject);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.StartVideoListener paramStartVideoListener, Bundle paramBundle)
  {
    long l1 = QQAudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startGroupAudioEx, uinType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], uin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], checkWifi[");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append("], checkMutex[");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append("], StartVideoListener[");
    if (paramStartVideoListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], extroBundle[");
    if (paramBundle != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("], fromWhere[");
    if (paramBundle == null) {
      localObject = "null";
    } else {
      localObject = paramBundle.getString("Fromwhere");
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w("ChatActivityUtils", 1, localStringBuilder.toString());
    QQAudioHelper.a("ChatActivityUtils.startGroupAudioEx", paramBundle, true);
    if (!a(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt, paramString)) {
      return true;
    }
    long l2 = Long.valueOf(paramString).longValue();
    int j = UITools.b(paramInt);
    Object localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    SeqUtil.a((Bundle)localObject, l1);
    boolean bool = ((Bundle)localObject).getBoolean("isVideo", false);
    if (!a(a(l1, paramContext), bool ^ true, new ChatActivityUtils.9(l1, paramContext, paramQQAppInterface, paramInt, paramString, paramBoolean2, paramStartVideoListener, (Bundle)localObject, bool))) {
      return true;
    }
    int i = ((Bundle)localObject).getInt("MultiAVType", 0);
    if (i == 10) {
      QAVGroupConfig.a("startGroupAudioEx", paramQQAppInterface, paramString);
    }
    if (j == 2) {
      i = 1;
    }
    if (j == 1) {
      paramQQAppInterface.getAVNotifyCenter().a(l1, bool);
    }
    if (a(paramQQAppInterface, paramContext, j, paramInt, l2, i)) {
      return true;
    }
    if (!paramQQAppInterface.getAVNotifyCenter().a(j, l2, i))
    {
      if (!a(paramQQAppInterface, paramContext, paramStartVideoListener, new ChatActivityUtils.10(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramStartVideoListener, (Bundle)localObject), paramBoolean1, bool)) {
        return true;
      }
      if (a(l1, paramQQAppInterface, paramContext, paramStartVideoListener, new ChatActivityUtils.11(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramStartVideoListener, (Bundle)localObject), paramBoolean2, paramString, j, l2, i)) {
        return true;
      }
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005776", "0X8005776", 0, 0, "", "", "", "");
    if (paramStartVideoListener != null) {
      paramStartVideoListener.b();
    }
    b(paramQQAppInterface, paramContext, paramInt, paramString, (Bundle)localObject);
    if (paramStartVideoListener != null) {
      paramStartVideoListener.c();
    }
    paramQQAppInterface.getAVNotifyCenter().b(7, l2, i);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.StartVideoListener paramStartVideoListener, Map<String, String> paramMap)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    int i;
    if ((paramMap != null) && ("true".equals(paramMap.get("isVideo")))) {
      i = 4;
    } else {
      i = paramQQAppInterface.getAVNotifyCenter().e();
    }
    boolean bool;
    if (i == 4) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramInt, paramString, bool)) {
      return false;
    }
    return a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, a(paramMap));
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, int paramInt, String paramString)
  {
    Object localObject = paramContext;
    boolean bool = localObject instanceof Activity;
    if ((bool) && (((Activity)localObject).isFinishing()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, Activity isDestroyed!");
      return false;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 当前网络不可用");
      QQToast.a((Context)localObject, 2131694395, 0).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
    if (!VcSystemInfo.isSupportSharpAudio())
    {
      QQToast.a((Context)localObject, 2131695505, 1).b(paramContext.getResources().getDimensionPixelSize(2131299168));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005769", "0X8005769", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576B", "0X800576B", 0, 0, "", "", VcSystemInfo.getCpuReport(), "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576C", "0X800576C", 0, 0, "", "", VcSystemInfo.getModelReport(), "");
      return false;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576A", "0X800576A", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576E", "0X800576E", 0, 0, "", "", "", "");
    if ((paramQQAppInterface.getAVNotifyCenter().a()) && (!paramQQAppInterface.isVideoChatting()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 有系统电话");
      DataReport.e(true, true);
      paramQQAppInterface = ((Context)localObject).getString(2131695712);
      paramContext = ((Context)localObject).getString(2131695691);
      if (!bool) {
        localObject = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
      }
      DialogUtil.a((Context)localObject, 230, paramContext, paramQQAppInterface, 2131690728, 2131694583, new ChatActivityUtils.4(paramStartVideoListener), null).show();
      DataReport.a();
      return false;
    }
    if (!VcSystemInfo.isNormalSharp())
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, old engine");
      if (paramInt == 1011)
      {
        paramString = ((Context)localObject).getString(2131695893);
        DialogUtil.a(paramContext, 230, ((Context)localObject).getString(2131695691), paramString, 2131690728, 2131695618, new ChatActivityUtils.5(paramStartVideoListener), null).show();
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
        return false;
      }
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) && (paramInt == 3000))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("startGroupAudio, invalid discussId: ");
      paramQQAppInterface.append(paramString);
      QLog.d("ChatActivityUtils", 1, paramQQAppInterface.toString());
      return false;
    }
    return true;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!NetworkUtil.isWifiConnected(BaseApplication.getContext())) && (!NetworkUtil.isBluetoothSharedNetwork(BaseApplication.getContext())))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(VideoController.jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(paramQQAppInterface.getCurrentAccountUin());
      if (VideoController.d(((StringBuilder)localObject1).toString()) <= 0)
      {
        paramBoolean1 = NetworkUtil.isMobileNetWork(BaseApplication.getContext());
        localObject1 = null;
        Object localObject2;
        if (paramBoolean1)
        {
          localObject1 = paramContext.getString(2131695691);
          localObject2 = paramContext.getString(2131695686);
        }
        else
        {
          localObject2 = null;
        }
        Object localObject3;
        if (NetworkUtil.is3Gor4G(BaseApplication.getContext()))
        {
          localObject2 = paramContext.getString(2131695691);
          if (paramBoolean2) {
            localObject1 = paramContext.getString(2131695687);
          } else {
            localObject1 = paramContext.getString(2131695688);
          }
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject2;
          localObject2 = localObject1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(localObject3)))
        {
          a(paramQQAppInterface, paramContext, 230, (String)localObject2, localObject3, 2131695421, 2131695433, paramOnClickListener, new ChatActivityUtils.6(paramStartVideoListener));
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityUtils", 2, "startGAudio title or content is empty");
        }
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    return a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
  }
  
  public static boolean a(Object paramObject)
  {
    return ((paramObject instanceof MessageForUniteGrayTip)) || ((paramObject instanceof MessageForGrayTips));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.trim().length() > 0)
      {
        bool1 = bool2;
        if (!paramString.trim().equals(String.valueOf(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return false;
      }
      Object localObject = BaseApplication.getContext();
      if (localObject == null) {
        return false;
      }
      SharedPreferences localSharedPreferences = ((Context)localObject).getSharedPreferences("secondHandSharePre", 0);
      if (localSharedPreferences == null) {
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString3);
      if (!localSharedPreferences.contains(((StringBuilder)localObject).toString()))
      {
        paramString1 = localSharedPreferences.edit();
        paramString1.putInt(((StringBuilder)localObject).toString(), 0);
        paramString1.commit();
        return true;
      }
    }
    return false;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      paramString = paramString.toUpperCase();
      int j = paramString.length() / 2;
      paramString = paramString.toCharArray();
      byte[] arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        int k = i * 2;
        int m = a(paramString[k]);
        arrayOfByte[i] = ((byte)(a(paramString[(k + 1)]) | m << 4));
        i += 1;
      }
      return arrayOfByte;
    }
    return null;
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramJSONObject.toString());
      ((StringBuilder)localObject1).append("");
      QLog.d("ChatActivityUtils", 4, ((StringBuilder)localObject1).toString());
    }
    try
    {
      if (!paramJSONObject.has("url")) {
        break label676;
      }
      localObject2 = paramJSONObject.getString("url");
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        String str10;
        continue;
        Object localObject2 = null;
        continue;
        localObject1 = null;
        continue;
        String str1 = null;
        continue;
        String str2 = null;
        continue;
        Object localObject3 = null;
        continue;
        int i = 2;
        continue;
        Object localObject4 = null;
        continue;
        String str3 = null;
        continue;
        String str4 = null;
        continue;
        String str5 = null;
        continue;
        String str6 = null;
        continue;
        String str7 = null;
        continue;
        String str8 = null;
        continue;
        String str9 = null;
        continue;
        long l = -1L;
      }
    }
    if (paramJSONObject.has("picture"))
    {
      localObject1 = paramJSONObject.getString("picture");
      if (!paramJSONObject.has("title")) {
        break label688;
      }
      str1 = paramJSONObject.getString("title");
      if (!paramJSONObject.has("summary")) {
        break label694;
      }
      str2 = paramJSONObject.getString("summary");
      if (!paramJSONObject.has("brief")) {
        break label700;
      }
      localObject3 = paramJSONObject.getString("brief");
      if (!paramJSONObject.has("layout")) {
        break label706;
      }
      i = paramJSONObject.getInt("layout");
      if (!paramJSONObject.has("source")) {
        break label711;
      }
      localObject4 = paramJSONObject.getString("source");
      if (i == 6)
      {
        if (!paramJSONObject.has("price")) {
          break label717;
        }
        str3 = paramJSONObject.getString("price");
        if (!paramJSONObject.has("prunit")) {
          break label723;
        }
        str4 = paramJSONObject.getString("prunit");
        if (!paramJSONObject.has("icon")) {
          break label729;
        }
        str5 = paramJSONObject.getString("icon");
        if (!paramJSONObject.has("srcaction")) {
          break label735;
        }
        str6 = paramJSONObject.getString("srcaction");
        if (!paramJSONObject.has("action")) {
          break label741;
        }
        str7 = paramJSONObject.getString("action");
        if (!paramJSONObject.has("a_actionData")) {
          break label747;
        }
        str8 = paramJSONObject.getString("a_actionData");
        if (!paramJSONObject.has("i_actionData")) {
          break label753;
        }
        str9 = paramJSONObject.getString("i_actionData");
        str10 = "";
        if (paramJSONObject.has("appid")) {
          str10 = paramJSONObject.getString("appid");
        }
        paramJSONObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(41).a((String)localObject3).a(7);
        if (TextUtils.isEmpty(str10)) {
          break label759;
        }
        l = Long.parseLong(str10);
        paramJSONObject = paramJSONObject.a(l).a(str7, (String)localObject2, null, null, null).a((String)localObject4, str5).b(str6, null, null, str8, str9).d((String)localObject2).a();
        localObject2 = StructMsgElementFactory.a(i);
        ((AbsStructMsgItem)localObject2).a((String)localObject1, str1, str2, str3, str4, 0);
        paramJSONObject.addItem((AbsStructMsgElement)localObject2);
        return paramJSONObject.getBytes();
      }
      paramJSONObject = paramJSONObject.getString("puin");
      localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(21).a((String)localObject3).e((String)localObject2).a((String)localObject4, null);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=");
      ((StringBuilder)localObject3).append(paramJSONObject);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=");
      ((StringBuilder)localObject4).append(paramJSONObject);
      paramJSONObject = ((AbsShareMsg.Builder)localObject2).b("plugin", null, null, (String)localObject3, ((StringBuilder)localObject4).toString()).a();
      localObject2 = StructMsgElementFactory.a(2);
      ((AbsStructMsgItem)localObject2).a((String)localObject1, str1, str2);
      paramJSONObject.addItem((AbsStructMsgElement)localObject2);
      paramJSONObject = paramJSONObject.getBytes();
      return paramJSONObject;
      if (QLog.isDevelopLevel()) {
        QLog.e("ChatActivityUtils", 4, "createSecondHandProductInfoStructMsg---JSONException");
      }
      return null;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    try
    {
      localObject = new byte[16];
      i = 0;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    paramArrayOfByte2 = new SecretKeySpec((byte[])localObject, "AES");
    Object localObject = Cipher.getInstance("AES/CBC/NoPadding");
    ((Cipher)localObject).init(2, paramArrayOfByte2);
    paramArrayOfByte1 = ((Cipher)localObject).doFinal(paramArrayOfByte1);
    return paramArrayOfByte1;
    while (i < 16)
    {
      localObject[i] = paramArrayOfByte2[i];
      i += 1;
    }
  }
  
  public static MessageRecord b(List<ChatMessage> paramList, BaseSessionInfo paramBaseSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((a(paramBaseSessionInfo.jdField_a_of_type_Int)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return null;
      }
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 1006)
      {
        paramBaseSessionInfo = (MessageRecord)paramList.get(0);
      }
      else
      {
        int i = paramList.size() - 1;
        while (i >= 0)
        {
          paramBaseSessionInfo = (MessageRecord)paramList.get(i);
          if (!MsgProxyUtils.b(paramBaseSessionInfo.msgtype))
          {
            paramList = paramBaseSessionInfo;
            break label97;
          }
          i -= 1;
        }
        paramList = null;
        label97:
        paramBaseSessionInfo = paramList;
        if (paramList == null) {
          return null;
        }
      }
      return a(paramBaseSessionInfo, paramQQAppInterface);
    }
    return null;
  }
  
  public static String b(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        i = j;
        if (paramInt == 1000) {
          break label180;
        }
        i = j;
        if (paramInt == 1001) {
          break label180;
        }
        if (paramInt != 1008)
        {
          i = j;
          if (paramInt == 1009) {
            break label180;
          }
          i = j;
          if (paramInt == 1020) {
            break label180;
          }
          if (paramInt != 3000)
          {
            i = j;
            if (paramInt == 10002) {
              break label180;
            }
            i = j;
            if (paramInt == 10004) {
              break label180;
            }
            i = j;
            if (paramInt == 10008) {
              break label180;
            }
            i = j;
            if (paramInt == 10010) {
              break label180;
            }
            i = j;
          }
        }
      }
    }
    switch (paramInt)
    {
    default: 
      i = j;
      switch (paramInt)
      {
      default: 
        i = 999;
        break label180;
        i = 2;
        break label180;
        i = 4;
        break label180;
        i = 3;
        break label180;
        i = 0;
      }
      break;
    }
    label180:
    return String.valueOf(i);
  }
  
  public static void b()
  {
    QQProgressDialog localQQProgressDialog = jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      try
      {
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new QQToastNotifier(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131299168), 0, paramInt2);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    int i = 1;
    if (paramInt == 3000)
    {
      DiscussionInfo localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
      if (localDiscussionInfo != null)
      {
        if (localDiscussionInfo.isPSTNConf())
        {
          QQAudioHelper.b("发起音视频_获取会议id");
          ChatActivityUtils.ConfIdownloadTask.a("ChatActivityUtils", localDiscussionInfo.uin, new ChatActivityUtils.12(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
          break label130;
        }
        if ((localDiscussionInfo.isDiscussHrMeeting()) && ((paramBundle == null) || (!paramBundle.containsKey("MeetingStasks"))))
        {
          QQAudioHelper.b("发起音视频_获取hr信息");
          QAVHrMeeting.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin(), new ChatActivityUtils.13(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
          break label130;
        }
      }
    }
    i = 0;
    label130:
    if (i == 0) {
      c(paramQQAppInterface, paramContext, paramInt, paramString, paramBundle);
    }
  }
  
  public static boolean b(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramSessionInfo.jdField_a_of_type_Int);
      localJSONObject.put("uin", UinMD5Cache.a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSingleWayFriendTipsBefore curFriendUin:");
        localStringBuilder.append(paramSessionInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("  curType");
        localStringBuilder.append(paramSessionInfo.jdField_a_of_type_Int);
        QLog.d("ChatActivityUtils", 4, localStringBuilder.toString());
      }
      paramSessionInfo = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "");
      if (!TextUtils.isEmpty(paramSessionInfo)) {
        paramSessionInfo = new JSONArray(paramSessionInfo);
      } else {
        paramSessionInfo = new JSONArray();
      }
      paramSessionInfo.put(localJSONObject);
      paramSessionInfo = paramSessionInfo.toString();
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString(paramString, paramSessionInfo);
      boolean bool = paramContext.commit();
      return bool;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.jdField_a_of_type_Int;
    boolean bool3 = AIOTopRightButtonConfig.a().a(paramQQAppInterface.getCurrentAccountUin());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if ((i != 0) && (i != 1000) && (i != 1004) && (i != 3000) && (i != 1006) && (i != 1021) && (i != 1010))
      {
        bool1 = bool2;
        if (i != 1025) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      if (i >= arrayOfString.length) {
        break;
      }
      if (paramString.startsWith(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void c()
  {
    ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    Object localObject2 = paramBundle;
    long l1 = SeqUtil.a(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("createOrEnterGroupAudio, uinType[");
    paramBundle.append(paramInt);
    paramBundle.append("], uin[");
    paramBundle.append(paramString);
    paramBundle.append("], seq[");
    paramBundle.append(l1);
    paramBundle.append("]");
    QLog.w("ChatActivityUtils", 1, paramBundle.toString());
    QQAudioHelper.a("ChatActivityUtils", (Bundle)localObject2, true);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if (paramString == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    l1 = Long.parseLong(paramString);
    int i = UITools.b(paramInt);
    int j = ((Bundle)localObject1).getInt("MultiAVType", 0);
    String str = ((Bundle)localObject1).getString("Fromwhere");
    if (i == 2) {
      j = 1;
    }
    paramBundle = ((Bundle)localObject1).getString("jump_from");
    localIntent.putExtras((Bundle)localObject1);
    if ((("gvideo".equals(paramBundle)) || ("gvideo_h5".equals(paramBundle))) && (paramInt == 1))
    {
      i = 1;
    }
    else
    {
      long l2 = paramQQAppInterface.getAVNotifyCenter().a(i, l1);
      paramBundle = new StringBuilder();
      paramBundle.append("memberNum[");
      paramBundle.append(l2);
      paramBundle = paramBundle.toString();
      Object localObject3;
      if (l2 > 0L)
      {
        k = paramQQAppInterface.getAVNotifyCenter().b(l1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("], srcAVType[");
        ((StringBuilder)localObject2).append(k);
        paramBundle = ((StringBuilder)localObject2).toString();
        if ((j != k) && (paramInt == 1))
        {
          localObject2 = paramQQAppInterface.getAVNotifyCenter().a(l1, j);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramBundle);
          ((StringBuilder)localObject3).append("], VideoRoomInfo[");
          ((StringBuilder)localObject3).append(localObject2);
          paramBundle = ((StringBuilder)localObject3).toString();
          if ((localObject2 != null) && (((AVNotifyCenter.VideoRoomInfo)localObject2).b == j) && (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int > 0))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramBundle);
            ((StringBuilder)localObject2).append("], 1.TYPE_GAUDIO_STATUS_ENTER");
            paramBundle = ((StringBuilder)localObject2).toString();
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramBundle);
            ((StringBuilder)localObject2).append("], 2.TYPE_GAUDIO_STATUS_CREATE");
            paramBundle = ((StringBuilder)localObject2).toString();
            break label717;
          }
        }
        else
        {
          if (paramQQAppInterface.getAVNotifyCenter().a(i, l1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramBundle);
            ((StringBuilder)localObject2).append("], 3.TYPE_GAUDIO_STATUS_CHATING");
            paramBundle = ((StringBuilder)localObject2).toString();
            i = 2;
            break label720;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramBundle);
          ((StringBuilder)localObject2).append("], 4.TYPE_GAUDIO_STATUS_ENTER");
          paramBundle = ((StringBuilder)localObject2).toString();
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramBundle);
        ((StringBuilder)localObject2).append("], 5.TYPE_GAUDIO_STATUS_CREATE");
        localObject2 = ((StringBuilder)localObject2).toString();
        paramBundle = (Bundle)localObject2;
        if (j != 2) {
          break label717;
        }
        localObject3 = paramQQAppInterface.getAVNotifyCenter().a(l1, 2);
        paramBundle = (Bundle)localObject2;
        if (localObject3 == null) {
          break label717;
        }
        paramBundle = (Bundle)localObject2;
        if (((AVNotifyCenter.VideoRoomInfo)localObject3).jdField_a_of_type_Int <= 0) {
          break label717;
        }
        paramBundle = new StringBuilder();
        paramBundle.append((String)localObject2);
        paramBundle.append("], 6.TYPE_GAUDIO_STATUS_CREATE");
        paramBundle = paramBundle.toString();
      }
      i = 1;
      break label720;
      label717:
      i = 0;
      label720:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createOrEnterGroupAudio, ");
      ((StringBuilder)localObject2).append(paramBundle);
      QLog.w("ChatActivityUtils", 1, ((StringBuilder)localObject2).toString());
    }
    boolean bool2 = true;
    if (paramInt == 1)
    {
      paramBundle = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      boolean bool1 = bool2;
      if (paramBundle != null)
      {
        bool1 = bool2;
        if (paramBundle.b(paramString) == null) {
          bool1 = false;
        }
      }
      localIntent.putExtra("troopmember", bool1);
    }
    localIntent.putExtra("sessionType", 3);
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uinType", paramInt);
    localIntent.putExtra("Type", i);
    localIntent.putExtra("GroupId", paramString);
    localIntent.putExtra("MultiAVType", j);
    localIntent.putExtra("Fromwhere", str);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("createOrEnterGroupAudio, from[");
      paramBundle.append(str);
      paramBundle.append("]");
      QLog.i("ChatActivityUtils", 2, paramBundle.toString());
    }
    int k = ((Bundle)localObject1).getInt("MeetingStasks", -1);
    if (k >= 0) {
      paramQQAppInterface.getAVNotifyCenter().a(k);
    }
    if (j != 2) {
      localIntent.setClass(paramContext, AVActivity.class);
    }
    paramBundle = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("start_group_audio_time");
    ((StringBuilder)localObject1).append(paramQQAppInterface.getCurrentAccountUin());
    GVideoUpdateUtil.a(paramContext, paramString, j, new ChatActivityUtils.14(i, paramInt, paramQQAppInterface, paramBundle, l1, localIntent, l1, ((StringBuilder)localObject1).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */