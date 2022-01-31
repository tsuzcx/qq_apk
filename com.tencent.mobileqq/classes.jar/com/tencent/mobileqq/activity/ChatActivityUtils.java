package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.etrump.mixlayout.FontManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.VideoRoomInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.GVideoUpdateUtil;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.UITools;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.selectmember.PhoneContactSelectActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.phone.PhoneNumberUtil;
import com.tencent.mobileqq.qcall.LightalkShieldHandler;
import com.tencent.mobileqq.qcall.LightalkShieldManager;
import com.tencent.mobileqq.qcall.LightalkSwitchHanlder;
import com.tencent.mobileqq.qcall.LightalkSwitchManager;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.qcall.PstnSwitchConfig;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.UinUtils;
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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QAVGroupConfig;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
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
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import saf;
import sag;
import sah;
import sai;
import saj;
import sak;
import sal;
import sam;
import san;
import sao;
import sap;
import saq;
import sar;
import sas;
import sat;
import sau;
import sav;
import saw;
import sax;
import say;
import saz;
import sba;
import sbb;
import sbc;
import sbd;
import sbe;
import sbf;
import sbg;
import sbh;
import sbi;
import sbj;
import sbk;
import sbl;
import sbm;
import sbn;
import sbo;
import sbq;
import sbr;
import sbs;
import sbt;
import sbu;
import sbv;
import sbw;
import sbx;
import sby;
import sbz;
import sca;
import scb;
import scc;
import scd;
import sce;
import sch;
import sci;
import scj;
import sck;
import scl;
import scp;
import scq;
import scr;
import scs;
import sct;
import scu;
import scv;

public class ChatActivityUtils
{
  private static ChatActivityUtils.AddFriendSpan jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan;
  static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private static QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public static Queue a;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  public static final String[] a;
  
  static
  {
    jdField_a_of_type_JavaUtilQueue = new LinkedList();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "http://m.qzone.com", "https://m.qzone.com", "http://mobile.qzone.qq.com", "https://mobile.qzone.qq.com" };
  }
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  static Bundle a(Map paramMap)
  {
    boolean bool2 = false;
    Bundle localBundle = new Bundle();
    Object localObject1;
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
      if (!TextUtils.equals((String)paramMap.get("isVideo"), "true")) {
        break label615;
      }
    }
    label615:
    for (boolean bool1 = true;; bool1 = false)
    {
      localBundle.putBoolean("isVideo", bool1);
      localBundle.putString("jump_from", (String)paramMap.get("jump_from"));
      localObject1 = (String)paramMap.get("Fromwhere");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("Fromwhere", (String)localObject1);
      }
      if (TextUtils.equals((String)paramMap.get("isAVMeeting"), "true")) {}
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("isAVMeeting", bool1);
        bool1 = bool2;
        if (TextUtils.equals((String)paramMap.get("isAVGroupMeeting"), "true")) {
          bool1 = true;
        }
        localBundle.putBoolean("isAVGroupMeeting", bool1);
        if (paramMap.containsKey("ConfAppID")) {
          localBundle.putInt("ConfAppID", Integer.valueOf((String)paramMap.get("ConfAppID")).intValue());
        }
        if (paramMap.containsKey("MeetingConfID")) {
          localBundle.putInt("MeetingConfID", Integer.valueOf((String)paramMap.get("MeetingConfID")).intValue());
        }
        localObject1 = (String)paramMap.get("PhoneNumberList");
        if (localObject1 != null) {
          localBundle.putStringArrayList("phoneNumbers", PstnUtils.b((String)localObject1));
        }
        localObject1 = (String)paramMap.get("PstnLevel");
        if (localObject1 != null) {
          localBundle.putString("PstnLevel", (String)localObject1);
        }
        localObject1 = (String)paramMap.get("PLACE");
        if (localObject1 != null) {
          localBundle.putString("PLACE", (String)localObject1);
        }
        localObject1 = (String)paramMap.get("CREATE_PLACE");
        if (localObject1 != null) {
          localBundle.putString("CREATE_PLACE", (String)localObject1);
        }
        localObject1 = (String)paramMap.get("ipPstnEnterType");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localBundle.putInt("ipPstnEnterType", Integer.parseInt((String)localObject1));
        }
        localBundle.putString("enterType", (String)paramMap.get("enterType"));
        if (paramMap != null)
        {
          Iterator localIterator = paramMap.entrySet().iterator();
          Object localObject2;
          for (paramMap = "";; paramMap = paramMap + "  [" + (String)((Map.Entry)localObject1).getKey() + "]=[" + localObject2 + "], [" + localObject2.getClass().getName() + "]\n")
          {
            localObject1 = paramMap;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)localIterator.next();
            localObject2 = ((Map.Entry)localObject1).getValue();
          }
        }
        localObject1 = "null";
        QLog.w("ChatActivityUtils", 1, "strExtroInfo[extroInfo2Bundle]:\n" + (String)localObject1);
        AudioHelper.a("ChatActivityUtils_extroInfo2Bundle", localBundle, true);
        return localBundle;
      }
    }
  }
  
  /* Error */
  public static View a(Context paramContext, String paramString, android.view.View.OnClickListener paramOnClickListener1, android.view.View.OnClickListener paramOnClickListener2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 247	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   13: ldc 248
    //   15: aconst_null
    //   16: invokevirtual 252	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   19: astore_0
    //   20: aload_0
    //   21: ldc 253
    //   23: invokevirtual 259	android/view/View:findViewById	(I)Landroid/view/View;
    //   26: astore 4
    //   28: aload_0
    //   29: ldc_w 260
    //   32: invokevirtual 259	android/view/View:findViewById	(I)Landroid/view/View;
    //   35: checkcast 262	android/widget/TextView
    //   38: astore 5
    //   40: aload_0
    //   41: ldc_w 263
    //   44: invokevirtual 259	android/view/View:findViewById	(I)Landroid/view/View;
    //   47: checkcast 265	android/widget/ImageView
    //   50: astore 6
    //   52: aload_1
    //   53: ifnull +9 -> 62
    //   56: aload 5
    //   58: aload_1
    //   59: invokevirtual 269	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   62: aload 6
    //   64: aload_3
    //   65: invokevirtual 273	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   68: aload 4
    //   70: aload_2
    //   71: invokevirtual 274	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   74: aload_0
    //   75: areturn
    //   76: astore_0
    //   77: aload 4
    //   79: astore_0
    //   80: ldc 223
    //   82: iconst_1
    //   83: ldc_w 276
    //   86: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   89: aload_0
    //   90: areturn
    //   91: astore_1
    //   92: goto -12 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   0	95	1	paramString	String
    //   0	95	2	paramOnClickListener1	android.view.View.OnClickListener
    //   0	95	3	paramOnClickListener2	android.view.View.OnClickListener
    //   1	77	4	localView	View
    //   38	19	5	localTextView	TextView
    //   50	13	6	localImageView	android.widget.ImageView
    // Exception table:
    //   from	to	target	type
    //   9	20	76	java/lang/RuntimeException
    //   20	52	91	java/lang/RuntimeException
    //   56	62	91	java/lang/RuntimeException
    //   62	74	91	java/lang/RuntimeException
  }
  
  @SuppressLint({"InflateParams"})
  public static Toast a(Context paramContext, String paramString)
  {
    Toast localToast = new Toast(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2130968662, null);
    localToast.setView(localView);
    localToast.setGravity(55, 0, paramContext.getResources().getDimensionPixelSize(2131558448));
    localToast.setDuration(1);
    ((TextView)localView.findViewById(2131363085)).setText(paramString);
    localView.setOnClickListener(new scp(localToast));
    return localToast;
  }
  
  private static MessageRecord a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    MessageRecord localMessageRecord;
    if ((i == -1003) || (i == -1031) || (i == -1032) || (i == -3001) || (MsgProxyUtils.a(paramMessageRecord.istroop) == 1032)) {
      localMessageRecord = null;
    }
    do
    {
      return localMessageRecord;
      localMessageRecord = paramMessageRecord;
    } while (!((FriendsManager)paramQQAppInterface.getManager(50)).b(paramMessageRecord.frienduin));
    return null;
  }
  
  public static MessageRecord a(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if ((paramSessionInfo.isSend()) || (MsgProxyUtils.g(paramSessionInfo.msgtype))) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if ((paramContext instanceof Activity)) {}
    for (paramQQAppInterface = paramContext;; paramQQAppInterface = BaseActivity.sTopActivity)
    {
      paramQQAppInterface = (Activity)paramQQAppInterface;
      if ((paramQQAppInterface != null) && (!CUKingCardHelper.a(paramQQAppInterface, 4, new scs(paramOnClickListener1, paramOnClickListener2), "qav"))) {
        break;
      }
      return PopupDialog.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    }
    return null;
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      i = paramMessageRecord.istroop;
      if ((paramMessageRecord.isSend()) || (MessageUtils.a(paramMessageRecord.msgtype))) {
        break label533;
      }
      if (1000 == i)
      {
        paramQQAppInterface = ContactUtils.o(paramQQAppInterface, (String)localObject1);
        localObject1 = String.format(paramContext.getString(2131435852), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        a(paramSessionInfo, paramMessageRecord);
      }
    }
    else
    {
      return localObject1;
    }
    if (1020 == i)
    {
      paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(59)).c(paramMessageRecord.senderuin);
      if (paramQQAppInterface == null) {
        break label638;
      }
      paramQQAppInterface = paramQQAppInterface.name;
    }
    label533:
    label638:
    for (paramQQAppInterface = String.format(paramContext.getString(2131435853), new Object[] { paramSessionInfo.d, paramQQAppInterface });; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if (1004 == i)
      {
        paramQQAppInterface = ContactUtils.b(paramQQAppInterface, (String)localObject1, 3000);
        paramQQAppInterface = String.format(paramContext.getString(2131435854), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        a(paramSessionInfo, paramMessageRecord);
        return paramQQAppInterface;
      }
      if (1001 == i) {
        return String.format(paramContext.getString(2131435855), new Object[] { paramSessionInfo.d });
      }
      if (10002 == i) {
        return String.format(paramContext.getString(2131435856), new Object[] { paramSessionInfo.d });
      }
      if (10004 == i) {
        return String.format(paramContext.getString(2131435868), new Object[] { paramSessionInfo.d });
      }
      if (1006 == i) {
        return String.format(paramContext.getString(2131435857), new Object[] { paramSessionInfo.d });
      }
      if (1009 == i) {
        return String.format(paramContext.getString(2131435859), new Object[] { paramSessionInfo.d });
      }
      if (1005 == i) {
        return String.format(paramContext.getString(2131435860), new Object[] { paramSessionInfo.d });
      }
      if (1021 == i) {
        return String.format(paramContext.getString(2131435861), new Object[] { paramSessionInfo.d });
      }
      if (1022 == i) {
        return String.format(paramContext.getString(2131435862), new Object[] { paramSessionInfo.d });
      }
      if (1029 == i) {
        return String.format(paramContext.getString(2131435867), new Object[] { paramSessionInfo.d });
      }
      if (1023 == i) {
        return String.format(paramContext.getString(2131435863), new Object[] { paramSessionInfo.d });
      }
      localObject1 = localObject2;
      if (1010 != i) {
        break;
      }
      return paramQQAppInterface.a().a(paramSessionInfo.d);
      localObject1 = localObject2;
      if (1006 != i) {
        break;
      }
      paramSessionInfo = String.format(paramContext.getString(2131435858), new Object[] { paramSessionInfo.d });
      paramQQAppInterface = paramContext.getString(2131435864);
      if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
        jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131493060));
      }
      i = paramSessionInfo.lastIndexOf(paramQQAppInterface);
      paramContext = new SpannableStringBuilder(paramSessionInfo);
      paramContext.setSpan(jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan, i, paramQQAppInterface.length() + i, 33);
      return paramContext;
    }
  }
  
  public static Integer a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)) {
      return null;
    }
    return (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1 + paramString2);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 1000: 
      return "2";
    }
    return "3";
  }
  
  public static final String a(Activity paramActivity)
  {
    return paramActivity.getClass().getName() + "_" + paramActivity.hashCode();
  }
  
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(51)).a(paramString);
      if (paramQQAppInterface == null) {
        return paramContext.getString(2131435869);
      }
      if (TextUtils.isEmpty(paramQQAppInterface.getTroopName())) {
        return paramContext.getString(2131435869);
      }
      paramQQAppInterface = String.format(paramContext.getString(2131435870), new Object[] { paramQQAppInterface.getTroopName() });
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext.getString(2131435869);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null) {}
    switch (paramMessageRecord.istroop)
    {
    default: 
      localObject1 = localObject2;
    case 1000: 
    case 1020: 
      AppRuntime localAppRuntime;
      do
      {
        do
        {
          do
          {
            return localObject1;
            try
            {
              paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
              paramMessageRecord = paramQQAppInterface.a(paramQQAppInterface.c(paramMessageRecord.senderuin));
              if (paramMessageRecord == null)
              {
                paramMessageRecord = paramContext.getString(2131435869);
                paramContext = paramMessageRecord;
              }
              else if (TextUtils.isEmpty(paramMessageRecord.getTroopName()))
              {
                paramMessageRecord = paramContext.getString(2131435869);
                paramContext = paramMessageRecord;
              }
              else
              {
                paramMessageRecord = String.format(paramContext.getString(2131435870), new Object[] { paramMessageRecord.getTroopName() });
                paramContext = paramMessageRecord;
              }
            }
            catch (Exception paramMessageRecord)
            {
              paramMessageRecord.printStackTrace();
              paramContext = paramContext.getString(2131435869);
              localObject1 = paramContext;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ChatActivityUtils", 2, "UIN_TYPE_OPEN_TROOP_MEMBER_STRANGER or UIN_TYPE_GROUP_MEMBER_STRANGER error");
          return paramContext;
          localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
          localObject1 = localObject2;
        } while (localAppRuntime == null);
        localObject1 = localObject2;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramQQAppInterface != null)
      {
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(59);
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (TextUtils.isEmpty(((HotChatManager)localObject1).a(paramMessageRecord.senderuin))) {
          break;
        }
      }
      break;
    }
    for (paramContext = paramContext.getString(2131435871);; paramContext = null)
    {
      return paramContext;
      return paramContext.getString(2131435872);
      return paramContext.getString(2131435873);
      return paramContext.getString(2131437443);
      return paramContext.getString(2131435885);
      return paramContext.getString(2131435874);
      return paramContext.getString(2131435875);
      return paramContext.getString(2131435876);
      return paramContext.getString(2131435877);
      return paramContext.getString(2131435878);
      return paramContext.getString(2131435879);
      return paramContext.getString(2131435880);
      return paramContext.getString(2131435881);
    }
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (QidianManager)paramQQAppInterface.getManager(164);
    if (paramQQAppInterface.b(paramString, false)) {
      return paramQQAppInterface.a(paramContext, paramString);
    }
    return null;
  }
  
  static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      paramString = a(arrayOfByte, a(paramQQAppInterface.getCurrentAccountUin() + "MasPlay", 32).getBytes("UTF-8"));
      paramQQAppInterface = localObject;
      if (paramString != null) {
        paramQQAppInterface = new String(paramString, "UTF-8").replace("$", "");
      }
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0));
      return paramString;
    }
    catch (Exception paramString) {}
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
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString2 = paramString2.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString2.length];
      int i = 0;
      while (i < paramString2.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString2[i].trim());
        i += 1;
      }
      paramString2 = a(arrayOfByte, a(paramString1 + "MasPlay", 32).getBytes("UTF-8"));
      paramString1 = localObject;
      if (paramString2 != null) {
        paramString1 = new String(paramString2, "UTF-8").replace("$", "");
      }
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, a(paramString + "MasPlay", 32).getBytes("UTF-8"));
      paramString = localObject;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte, "UTF-8").replace("$", "");
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
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
    if ((jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131558448));
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131434469);
        }
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      catch (Exception paramActivity) {}finally
      {
        if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    int i = 3004;
    int j = 0;
    FragmentActivity localFragmentActivity;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      i = 3999;
      if ((i == 3007) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
      {
        localFragmentActivity = (FragmentActivity)paramActivity;
        if (LBSHandler.a(localFragmentActivity.getChatFragment().a(), paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label361;
        }
        localFragmentActivity.getChatFragment().a().d(localFragmentActivity.getString(2131437429));
      }
      break;
    }
    label361:
    do
    {
      return;
      j = 2;
      i = 3007;
      break;
      i = 3008;
      break;
      i = 3013;
      break;
      i = 3006;
      break;
      j = 2;
      break;
      j = 2;
      break;
      i = 3005;
      j = 2;
      break;
      i = 3003;
      j = 2;
      break;
      i = 3008;
      break;
      i = 3019;
      break;
      i = 3041;
      break;
      i = 3082;
      j = 1;
      break;
      if ((i == 3019) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
      {
        localFragmentActivity = (FragmentActivity)paramActivity;
        if (!DatingUtil.a(localFragmentActivity.getChatFragment().a(), paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localFragmentActivity.getChatFragment().a().d(localFragmentActivity.getString(2131437429));
          return;
        }
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 1006) {
        break label418;
      }
    } while ((paramSessionInfo.jdField_a_of_type_JavaLangString == null) || (paramSessionInfo.jdField_a_of_type_JavaLangString.length() <= 0));
    paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.d, null, null, paramString, null));
    return;
    label418:
    if (paramBoolean)
    {
      paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.d, null, AddContactsActivity.class.getName(), paramString, null));
      return;
    }
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, i, j, paramSessionInfo.d, null, null, paramString, null), 11);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramActivity, 2131434527, 1);
      return;
    }
    b(paramActivity, 2131434526, 1);
  }
  
  public static void a(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131433424));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131493062), paramContext.getResources().getColor(2131493063)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(paramContext, paramContext.getString(2131433423), localSpannableString, 0, 2131433711, null, null, new scq(paramContext)).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    new QQToastNotifier(paramContext).a(paramInt, paramContext.getResources().getDimensionPixelSize(2131558448), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131558448));
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = paramQQAppInterface.a().a(AppShareIDUtil.a(paramLong));
    if ((localObject2 != null) && (QLog.isColorLevel())) {
      QLog.d("gameShareOnClick", 2, "<--gameShareOnClick appShareID.bundleid" + ((AppShareID)localObject2).bundleid);
    }
    if ((localObject2 != null) && (((AppShareID)localObject2).bundleid != null) && (PackageUtil.a(paramContext, ((AppShareID)localObject2).bundleid)))
    {
      long l = AppShareIDUtil.b(paramLong);
      Object localObject1 = paramQQAppInterface.a().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject2).bundleid;
      if (localObject1 == null)
      {
        localObject1 = null;
        PackageUtil.a(paramContext, (String)localObject2, (String)localObject1);
        if ((paramInt != -3005) && (paramInt != -3004) && ((paramString == null) || (!paramString.startsWith("http://gamecenter.qq.com")))) {
          break label206;
        }
      }
      label206:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
        }
        return;
        localObject1 = ((OpenID)localObject1).openID;
        break;
      }
    }
    a(paramContext, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "appShareOnClick action:" + paramString + ",appShareId:" + paramLong + "mixType:" + paramInt);
    }
    String str = paramString.trim();
    if ((paramInt == -3005) || (paramInt == -3004) || (str.startsWith("http://gamecenter.qq.com")))
    {
      paramInt = 1;
      if (55901189L != paramLong) {
        break label181;
      }
      paramString = QZoneHelper.UserInfo.a();
      paramString.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      paramString.jdField_b_of_type_JavaLangString = paramQQAppInterface.getCurrentNickname();
      QZoneHelper.a((Activity)paramContext, paramString, str, "mqqChat", -1);
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label333;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
      return;
      paramInt = 0;
      break;
      label181:
      b(str);
      Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      paramString = HtmlOffline.a(str, "from=androidqq");
      if (paramInt != 0)
      {
        localIntent.putExtra("param_force_internal_browser", true);
        paramString = HtmlOffline.a(str, "platformId=qq_m");
      }
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("url", paramString.trim());
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", paramLong);
      paramString = paramString.toString();
      if (paramString.startsWith("http://browserApp.p.qq.com/"))
      {
        localIntent.putExtra("url", paramString);
        localIntent.setClass(paramContext, PublicAccountBrowser.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
      }
      paramContext.startActivity(localIntent);
    }
    label333:
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(AppShareIDUtil.b(paramLong)));
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
      paramIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
      paramIntent.putExtra("phonenum", paramSessionInfo.jdField_e_of_type_JavaLangString);
    }
  }
  
  private static void a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    if ((paramSessionInfo == null) || (paramMessageRecord == null)) {}
    while (paramSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) {
      return;
    }
    paramSessionInfo.jdField_a_of_type_Int = paramMessageRecord.istroop;
    paramSessionInfo.jdField_b_of_type_JavaLangString = paramMessageRecord.senderuin;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramActivity, paramInt, paramString1, paramString2, paramBoolean, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (NetworkUtil.d(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {}
      }
    }
    label406:
    label418:
    while ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      long l;
      do
      {
        do
        {
          do
          {
            try
            {
              l = Long.parseLong(paramString1);
              if (l > 0L)
              {
                if (!paramBoolean1)
                {
                  paramBoolean1 = bool;
                  paramQQAppInterface.a(l, paramBoolean1);
                }
              }
              else {
                return;
              }
            }
            catch (Exception paramActivity)
            {
              for (;;)
              {
                l = 0L;
                continue;
                paramBoolean1 = false;
              }
            }
            if (paramInt != 25) {
              break;
            }
          } while (!paramBoolean1);
          paramActivity = (LightalkShieldHandler)paramQQAppInterface.a(78);
          if (paramActivity != null) {
            paramActivity.b(10, UinUtils.a(paramString1));
          }
          paramActivity = (LightalkSwitchManager)paramQQAppInterface.getManager(85);
        } while ((paramActivity == null) || (paramActivity.b()));
        paramQQAppInterface = (LightalkSwitchHanlder)paramQQAppInterface.a(52);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.a((byte)0);
      return;
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
      String str = paramString1;
      if (localShieldMsgManger != null)
      {
        str = paramString1;
        if (paramInt == 1006)
        {
          str = paramString1;
          if (paramString1 != null) {}
        }
      }
      for (;;)
      {
        try
        {
          str = ContactUtils.g(paramQQAppInterface, paramString2);
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
            i = 1;
            if ((paramInt == 1001) || (paramInt == 10002))
            {
              if ((str != null) && (str.length() > 0))
              {
                if (!paramBoolean1) {
                  break label406;
                }
                paramQQAppInterface.a().b(str);
              }
              i = 1;
            }
            if ((paramActivity == null) || (paramActivity.isFinishing())) {
              break;
            }
            if (i == 0) {
              break label418;
            }
            a(paramActivity);
            return;
          }
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
          continue;
          int i = 0;
        }
        catch (NumberFormatException paramString2)
        {
          str = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.e("ChatActivityUtils", 2, "shieldMsg", paramString2);
            str = paramString1;
          }
        }
        continue;
        paramQQAppInterface.a().a(str);
      }
      if (paramBoolean1)
      {
        b(paramActivity, 2131434527, 1);
        return;
      }
      b(paramActivity, 2131434526, 1);
      return;
    }
    b(paramActivity, 2131433117, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramInt1, paramIntent, paramInt2, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    String str = null;
    if (paramInt1 == 1)
    {
      str = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      if (!str.equalsIgnoreCase("")) {
        if (paramInt2 == 1)
        {
          localObject = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label131;
          }
        }
      }
      label131:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", paramInt1).edit().putString("shot_photo_path", str).commit();
        localObject = Uri.fromFile(new File(str));
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().remove("camera_photo_path").commit();
        if (localObject != null) {
          break;
        }
        return;
      }
      str = ImageUtil.b(paramActivity, (Uri)localObject);
      if (str == null) {
        break label825;
      }
      ImageUtil.a(paramActivity, str);
      if (!FileUtils.e(str))
      {
        QQToast.a(paramActivity, paramActivity.getString(2131434520), 0).b(paramActivity.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      if (!new File(str).exists())
      {
        QQToast.a(paramActivity, paramActivity.getString(2131434521), 0).b(paramActivity.getResources().getDimensionPixelSize(2131558448));
        return;
      }
    }
    Intent localIntent = new Intent();
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.getAccount();
      Friends localFriends = ((FriendsManager)paramQQAppInterface.getManager(50)).c((String)localObject);
      localIntent.putExtra("PhotoConst.MY_UIN", (String)localObject);
      if (localFriends != null) {
        localIntent.putExtra("PhotoConst.MY_NICK", localFriends.name);
      }
      localObject = (HotChatManager)paramQQAppInterface.getManager(59);
      if (localObject != null) {
        localIntent.putExtra("showFlashPic", FlashPicHelper.a(paramSessionInfo.jdField_a_of_type_Int, (HotChatManager)localObject, paramSessionInfo.jdField_b_of_type_JavaLangString));
      }
    }
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramSessionInfo.d);
    localIntent.putExtra("entrance", paramSessionInfo.c);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.jdField_e_of_type_Int);
    localIntent.putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    int j = 0;
    int k = -1;
    int i = k;
    paramInt1 = j;
    if (paramIntent != null)
    {
      int m = paramIntent.getIntExtra("camera_type", 1);
      paramInt1 = paramIntent.getIntExtra("camera_front_back", 0);
      i = paramIntent.getIntExtra("camera_filter_id", -1);
      int n = paramIntent.getIntExtra("camera_capture_method", -1);
      localIntent.putExtra("camera_type", m);
      localIntent.putExtra("camera_front_back", paramInt1);
      localIntent.putExtra("camera_filter_id", i);
      localIntent.putExtra("camera_capture_method", n);
      i = k;
      paramInt1 = j;
      if (m == 103)
      {
        paramInt1 = 1;
        i = 100012;
      }
    }
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)))
    {
      localIntent.putExtras(paramActivity.getIntent());
      localObject = localIntent;
      if (paramInt2 != -1)
      {
        if (paramInt2 != 8) {
          break label1061;
        }
        if (paramQQAppInterface != null) {
          PlusPanelUtils.a((Intent)localObject, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject).putExtra("callFromFastImage", true);
        ((Intent)localObject).putExtra("FROM_WHERE", "FromFastImage");
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1037);
        ((Intent)localObject).putExtra("key_activity_code", a(paramActivity));
      }
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        boolean bool = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
        paramInt2 = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", bool);
        if (paramInt2 == 1039) {
          ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
        }
        if (paramInt2 == 1040) {
          ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        }
        PhotoUtils.a(paramIntent, (Intent)localObject);
      }
      paramQQAppInterface = new ArrayList();
      paramQQAppInterface.add(str);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramQQAppInterface);
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject).putExtra("PhotoConst.ALLOW_LOCK", paramBoolean);
      ((Intent)localObject).setClass(paramActivity, PhotoPreviewActivity.class);
      ((Intent)localObject).addFlags(603979776);
      if (paramInt1 == 0) {
        break label1105;
      }
      paramActivity.startActivityForResult((Intent)localObject, i);
      return;
      label825:
      QQToast.a(paramActivity, paramActivity.getString(2131434521), 0).b(paramActivity.getResources().getDimensionPixelSize(2131558448));
      return;
      if ((paramActivity instanceof SplashActivity))
      {
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.a(localIntent, null);
        label882:
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        if (paramSessionInfo.jdField_a_of_type_Int != 9501) {
          break label1021;
        }
        if (!(paramActivity instanceof SplashActivity)) {
          break label1003;
        }
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.a((Intent)localObject, null);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra(AlbumConstants.h, 82);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        break;
        localObject = localIntent;
        if (!(paramActivity instanceof ChatActivity)) {
          break label882;
        }
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        localObject = localIntent;
        break label882;
        label1003:
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      label1021:
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      break;
      label1061:
      if (paramInt2 == 1)
      {
        if (paramQQAppInterface != null) {
          PlusPanelUtils.a((Intent)localObject, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject).putExtra("FROM_WHERE", "FromCamera");
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      }
    }
    label1105:
    paramActivity.startActivity((Intent)localObject);
  }
  
  /* Error */
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, String paramString5, Map paramMap, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 223
    //   2: iconst_1
    //   3: ldc_w 1267
    //   6: invokestatic 542	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9: aload_3
    //   10: astore 20
    //   12: iload_2
    //   13: sipush 1011
    //   16: if_icmpne +632 -> 648
    //   19: ldc_w 1269
    //   22: invokestatic 1272	com/tencent/av/utils/ImageResUtil:a	(Ljava/lang/String;)Z
    //   25: ifne +7 -> 32
    //   28: aload_0
    //   29: invokestatic 1275	com/tencent/av/utils/ImageResUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   32: aload_3
    //   33: astore 20
    //   35: aload 9
    //   37: ifnull +611 -> 648
    //   40: ldc_w 1277
    //   43: aload 9
    //   45: ldc_w 1279
    //   48: invokeinterface 78 2 0
    //   53: checkcast 41	java/lang/String
    //   56: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +534 -> 593
    //   62: aload 9
    //   64: ldc_w 1281
    //   67: invokeinterface 78 2 0
    //   72: checkcast 41	java/lang/String
    //   75: astore_3
    //   76: aload 9
    //   78: ldc_w 1283
    //   81: invokeinterface 78 2 0
    //   86: checkcast 41	java/lang/String
    //   89: astore 4
    //   91: aload 9
    //   93: ldc_w 1285
    //   96: invokeinterface 78 2 0
    //   101: checkcast 41	java/lang/String
    //   104: astore 5
    //   106: aload 9
    //   108: ldc_w 1287
    //   111: invokeinterface 78 2 0
    //   116: checkcast 41	java/lang/String
    //   119: astore 7
    //   121: aload 9
    //   123: ldc_w 1289
    //   126: invokeinterface 78 2 0
    //   131: checkcast 41	java/lang/String
    //   134: astore 8
    //   136: aload 9
    //   138: ldc_w 1291
    //   141: invokeinterface 78 2 0
    //   146: checkcast 41	java/lang/String
    //   149: astore 20
    //   151: aload 9
    //   153: ldc_w 1293
    //   156: invokeinterface 78 2 0
    //   161: checkcast 41	java/lang/String
    //   164: astore 21
    //   166: aload 9
    //   168: ldc_w 1295
    //   171: invokeinterface 78 2 0
    //   176: checkcast 41	java/lang/String
    //   179: astore 22
    //   181: new 897	android/content/Intent
    //   184: dup
    //   185: aload_1
    //   186: ldc_w 1297
    //   189: invokespecial 902	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   192: astore_0
    //   193: aload_0
    //   194: ldc_w 1281
    //   197: aload_3
    //   198: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   201: pop
    //   202: aload_0
    //   203: ldc_w 1283
    //   206: aload 4
    //   208: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   211: pop
    //   212: aload_0
    //   213: ldc_w 1285
    //   216: aload 5
    //   218: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   221: pop
    //   222: aload_0
    //   223: ldc_w 1287
    //   226: aload 7
    //   228: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   231: pop
    //   232: aload_0
    //   233: ldc_w 1289
    //   236: aload 8
    //   238: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   241: pop
    //   242: aload_0
    //   243: ldc_w 1291
    //   246: aload 20
    //   248: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   251: pop
    //   252: aload_0
    //   253: ldc_w 1293
    //   256: aload 21
    //   258: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   261: pop
    //   262: aload_0
    //   263: ldc_w 1295
    //   266: aload 22
    //   268: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   271: pop
    //   272: iconst_0
    //   273: istore_2
    //   274: aload 5
    //   276: invokestatic 156	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   279: istore 11
    //   281: iload 11
    //   283: istore_2
    //   284: iload_2
    //   285: iconst_1
    //   286: if_icmple +301 -> 587
    //   289: aload 9
    //   291: ldc_w 1299
    //   294: invokeinterface 78 2 0
    //   299: checkcast 41	java/lang/String
    //   302: astore_3
    //   303: aload 9
    //   305: ldc_w 1301
    //   308: invokeinterface 78 2 0
    //   313: checkcast 41	java/lang/String
    //   316: astore 4
    //   318: aload 9
    //   320: ldc_w 1303
    //   323: invokeinterface 78 2 0
    //   328: checkcast 41	java/lang/String
    //   331: astore 5
    //   333: aload 9
    //   335: ldc_w 1305
    //   338: invokeinterface 78 2 0
    //   343: checkcast 41	java/lang/String
    //   346: astore 7
    //   348: aload 9
    //   350: ldc_w 1307
    //   353: invokeinterface 78 2 0
    //   358: checkcast 41	java/lang/String
    //   361: astore 8
    //   363: aload 9
    //   365: ldc_w 920
    //   368: invokeinterface 78 2 0
    //   373: checkcast 41	java/lang/String
    //   376: astore 20
    //   378: aload 9
    //   380: ldc_w 1309
    //   383: invokeinterface 78 2 0
    //   388: checkcast 41	java/lang/String
    //   391: astore 21
    //   393: aload 9
    //   395: ldc_w 1311
    //   398: invokeinterface 78 2 0
    //   403: checkcast 41	java/lang/String
    //   406: astore 22
    //   408: aload 9
    //   410: ldc_w 1313
    //   413: invokeinterface 78 2 0
    //   418: checkcast 41	java/lang/String
    //   421: astore 23
    //   423: aload 9
    //   425: ldc_w 1315
    //   428: invokeinterface 78 2 0
    //   433: checkcast 41	java/lang/String
    //   436: astore 24
    //   438: aload 9
    //   440: ldc_w 1317
    //   443: invokeinterface 78 2 0
    //   448: checkcast 41	java/lang/String
    //   451: astore 25
    //   453: aload 9
    //   455: ldc_w 1319
    //   458: invokeinterface 78 2 0
    //   463: checkcast 41	java/lang/String
    //   466: astore 9
    //   468: aload_0
    //   469: ldc_w 1299
    //   472: aload_3
    //   473: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   476: pop
    //   477: aload_0
    //   478: ldc_w 1301
    //   481: aload 4
    //   483: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   486: pop
    //   487: aload_0
    //   488: ldc_w 1303
    //   491: aload 5
    //   493: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   496: pop
    //   497: aload_0
    //   498: ldc_w 1305
    //   501: aload 7
    //   503: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   506: pop
    //   507: aload_0
    //   508: ldc_w 1307
    //   511: aload 8
    //   513: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   516: pop
    //   517: aload_0
    //   518: ldc_w 920
    //   521: aload 20
    //   523: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   526: pop
    //   527: aload_0
    //   528: ldc_w 1309
    //   531: aload 21
    //   533: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   536: pop
    //   537: aload_0
    //   538: ldc_w 1311
    //   541: aload 22
    //   543: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   546: pop
    //   547: aload_0
    //   548: ldc_w 1313
    //   551: aload 23
    //   553: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   556: pop
    //   557: aload_0
    //   558: ldc_w 1315
    //   561: aload 24
    //   563: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   566: pop
    //   567: aload_0
    //   568: ldc_w 1317
    //   571: aload 25
    //   573: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   576: pop
    //   577: aload_0
    //   578: ldc_w 1319
    //   581: aload 9
    //   583: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   586: pop
    //   587: aload_1
    //   588: aload_0
    //   589: invokevirtual 944	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   592: return
    //   593: aload_3
    //   594: astore 20
    //   596: aload 9
    //   598: ifnull +50 -> 648
    //   601: aload 9
    //   603: ldc_w 1321
    //   606: invokeinterface 78 2 0
    //   611: checkcast 41	java/lang/String
    //   614: astore 21
    //   616: aload_3
    //   617: astore 20
    //   619: aload 21
    //   621: ifnull +27 -> 648
    //   624: aload_3
    //   625: astore 20
    //   627: aload 21
    //   629: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   632: ifne +16 -> 648
    //   635: aload_0
    //   636: aload 21
    //   638: invokestatic 1323	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   641: astore 20
    //   643: aload 20
    //   645: ifnull +249 -> 894
    //   648: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq +95 -> 746
    //   654: ldc 223
    //   656: iconst_2
    //   657: new 187	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   664: ldc_w 1325
    //   667: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: iload_2
    //   671: invokevirtual 514	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: ldc_w 1327
    //   677: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload 20
    //   682: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: ldc_w 1329
    //   688: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: aload 4
    //   693: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 1331
    //   699: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 5
    //   704: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc_w 1333
    //   710: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: iload 6
    //   715: invokevirtual 1336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   718: ldc_w 1338
    //   721: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 7
    //   726: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: ldc_w 1340
    //   732: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload 8
    //   737: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 542	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload_0
    //   747: invokevirtual 1342	com/tencent/mobileqq/app/QQAppInterface:c	()Z
    //   750: ifeq +169 -> 919
    //   753: aload_0
    //   754: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   757: invokevirtual 1350	com/tencent/av/gaudio/AVNotifyCenter:f	()I
    //   760: iconst_1
    //   761: if_icmpeq +158 -> 919
    //   764: aload_0
    //   765: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   768: invokevirtual 1350	com/tencent/av/gaudio/AVNotifyCenter:f	()I
    //   771: sipush 3000
    //   774: if_icmpeq +145 -> 919
    //   777: aload_0
    //   778: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   781: invokevirtual 1352	com/tencent/av/gaudio/AVNotifyCenter:f	()Z
    //   784: ifeq +135 -> 919
    //   787: aload_0
    //   788: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   791: invokevirtual 1354	com/tencent/av/gaudio/AVNotifyCenter:e	()Z
    //   794: ifeq +125 -> 919
    //   797: aload_0
    //   798: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   801: invokevirtual 1350	com/tencent/av/gaudio/AVNotifyCenter:f	()I
    //   804: sipush 1011
    //   807: if_icmpeq +112 -> 919
    //   810: aload_0
    //   811: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   814: invokevirtual 1350	com/tencent/av/gaudio/AVNotifyCenter:f	()I
    //   817: bipush 21
    //   819: if_icmpeq +100 -> 919
    //   822: aload_1
    //   823: invokestatic 1358	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;)Z
    //   826: ifeq +78 -> 904
    //   829: new 897	android/content/Intent
    //   832: dup
    //   833: aload_1
    //   834: ldc_w 1360
    //   837: invokespecial 902	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   840: astore_0
    //   841: aload_0
    //   842: ldc_w 1361
    //   845: invokevirtual 1232	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   848: pop
    //   849: aload_0
    //   850: ldc_w 1363
    //   853: iload_2
    //   854: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   857: pop
    //   858: aload_0
    //   859: ldc_w 1365
    //   862: aload 20
    //   864: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   867: pop
    //   868: aload_0
    //   869: ldc_w 1367
    //   872: aload 7
    //   874: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   877: pop
    //   878: aload_0
    //   879: ldc_w 1369
    //   882: iload 6
    //   884: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   887: pop
    //   888: aload_1
    //   889: aload_0
    //   890: invokevirtual 944	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   893: return
    //   894: ldc 223
    //   896: iconst_1
    //   897: ldc_w 1371
    //   900: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   903: return
    //   904: new 897	android/content/Intent
    //   907: dup
    //   908: aload_1
    //   909: ldc_w 1373
    //   912: invokespecial 902	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   915: astore_0
    //   916: goto -75 -> 841
    //   919: aload_0
    //   920: invokestatic 1378	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/MediaPlayerManager;
    //   923: astore_3
    //   924: aload_3
    //   925: ifnull +8 -> 933
    //   928: aload_3
    //   929: iconst_1
    //   930: invokevirtual 1381	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(Z)V
    //   933: iload_2
    //   934: ifne +2464 -> 3398
    //   937: aload_0
    //   938: bipush 50
    //   940: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   943: checkcast 342	com/tencent/mobileqq/app/FriendsManager
    //   946: aload 20
    //   948: invokevirtual 1133	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   951: astore_3
    //   952: aload_3
    //   953: ifnull +2445 -> 3398
    //   956: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   959: ifeq +55 -> 1014
    //   962: ldc 223
    //   964: iconst_2
    //   965: new 187	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   972: ldc_w 1383
    //   975: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: aload_3
    //   979: invokestatic 1386	com/tencent/mobileqq/utils/ContactUtils:b	(Lcom/tencent/mobileqq/data/Friends;)Ljava/lang/String;
    //   982: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: ldc_w 1388
    //   988: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: aload_3
    //   992: getfield 1392	com/tencent/mobileqq/data/Friends:abilityBits	J
    //   995: invokevirtual 871	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   998: ldc_w 1394
    //   1001: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: iconst_1
    //   1005: invokevirtual 514	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokestatic 542	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1014: aload_3
    //   1015: invokevirtual 1397	com/tencent/mobileqq/data/Friends:getNetWorkType	()I
    //   1018: iconst_2
    //   1019: if_icmpeq +2379 -> 3398
    //   1022: iconst_1
    //   1023: istore 18
    //   1025: iload_2
    //   1026: sipush 1006
    //   1029: if_icmpeq +15 -> 1044
    //   1032: iload_2
    //   1033: bipush 24
    //   1035: if_icmpeq +9 -> 1044
    //   1038: iload_2
    //   1039: bipush 25
    //   1041: if_icmpne +329 -> 1370
    //   1044: aload 20
    //   1046: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1049: ifeq +107 -> 1156
    //   1052: aload 5
    //   1054: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1057: ifeq +99 -> 1156
    //   1060: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq -471 -> 592
    //   1066: ldc 223
    //   1068: iconst_2
    //   1069: new 187	java/lang/StringBuilder
    //   1072: dup
    //   1073: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1076: ldc_w 1325
    //   1079: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: iload_2
    //   1083: invokevirtual 514	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1086: ldc_w 1327
    //   1089: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: aload 20
    //   1094: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: ldc_w 1329
    //   1100: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: aload 4
    //   1105: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: ldc_w 1331
    //   1111: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: aload 5
    //   1116: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: ldc_w 1333
    //   1122: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: iload 6
    //   1127: invokevirtual 1336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1130: ldc_w 1338
    //   1133: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: aload 7
    //   1138: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1144: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1147: return
    //   1148: astore_3
    //   1149: aload_3
    //   1150: invokevirtual 532	java/lang/Exception:printStackTrace	()V
    //   1153: goto -220 -> 933
    //   1156: aload_0
    //   1157: bipush 10
    //   1159: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1162: checkcast 1399	com/tencent/mobileqq/model/PhoneContactManager
    //   1165: invokeinterface 1402 1 0
    //   1170: astore 24
    //   1172: aload 24
    //   1174: ifnull +2216 -> 3390
    //   1177: aload 24
    //   1179: getfield 1407	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   1182: astore_3
    //   1183: aload 24
    //   1185: getfield 1410	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   1188: astore 22
    //   1190: aload 20
    //   1192: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1195: ifeq +77 -> 1272
    //   1198: aload 5
    //   1200: astore 21
    //   1202: aload 5
    //   1204: astore 23
    //   1206: iload_2
    //   1207: bipush 24
    //   1209: if_icmpeq +9 -> 1218
    //   1212: iload_2
    //   1213: bipush 25
    //   1215: if_icmpne +84 -> 1299
    //   1218: aload 24
    //   1220: ifnull +29 -> 1249
    //   1223: aload 24
    //   1225: getfield 1407	SecurityAccountServer/RespondQueryQQBindingStat:nationCode	Ljava/lang/String;
    //   1228: ldc 170
    //   1230: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1233: ifne +16 -> 1249
    //   1236: aload 24
    //   1238: getfield 1410	SecurityAccountServer/RespondQueryQQBindingStat:mobileNo	Ljava/lang/String;
    //   1241: ldc 170
    //   1243: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1246: ifeq +53 -> 1299
    //   1249: aload_1
    //   1250: ldc_w 1411
    //   1253: iconst_0
    //   1254: invokestatic 794	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   1257: aload_1
    //   1258: invokevirtual 299	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1261: ldc_w 300
    //   1264: invokevirtual 305	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1267: invokevirtual 797	com/tencent/mobileqq/widget/QQToast:b	(I)Landroid/widget/Toast;
    //   1270: pop
    //   1271: return
    //   1272: aload 20
    //   1274: astore 21
    //   1276: aload 5
    //   1278: astore 23
    //   1280: aload 5
    //   1282: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1285: ifeq -79 -> 1206
    //   1288: aload 20
    //   1290: astore 23
    //   1292: aload 20
    //   1294: astore 21
    //   1296: goto -90 -> 1206
    //   1299: aload 22
    //   1301: astore 20
    //   1303: aload_3
    //   1304: astore 22
    //   1306: aload 23
    //   1308: astore 5
    //   1310: aload 21
    //   1312: astore_3
    //   1313: aload 22
    //   1315: astore 21
    //   1317: iload_2
    //   1318: sipush 1000
    //   1321: if_icmpne +2062 -> 3383
    //   1324: aload_0
    //   1325: bipush 51
    //   1327: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1330: checkcast 519	com/tencent/mobileqq/app/TroopManager
    //   1333: astore 22
    //   1335: aload 22
    //   1337: ifnull +2039 -> 3376
    //   1340: aload 22
    //   1342: aload 7
    //   1344: invokevirtual 1413	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1347: astore 22
    //   1349: aload 22
    //   1351: ifnonnull +101 -> 1452
    //   1354: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1357: ifeq -765 -> 592
    //   1360: ldc 223
    //   1362: iconst_2
    //   1363: ldc_w 1415
    //   1366: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1369: return
    //   1370: aload 5
    //   1372: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1375: ifeq +61 -> 1436
    //   1378: aload_0
    //   1379: bipush 10
    //   1381: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1384: checkcast 1399	com/tencent/mobileqq/model/PhoneContactManager
    //   1387: aload 20
    //   1389: invokeinterface 1418 2 0
    //   1394: astore_3
    //   1395: aload_3
    //   1396: ifnull +25 -> 1421
    //   1399: aload_3
    //   1400: getfield 1421	com/tencent/mobileqq/data/PhoneContact:mobileNo	Ljava/lang/String;
    //   1403: astore 5
    //   1405: aconst_null
    //   1406: astore 22
    //   1408: aconst_null
    //   1409: astore 21
    //   1411: aload 20
    //   1413: astore_3
    //   1414: aload 22
    //   1416: astore 20
    //   1418: goto -101 -> 1317
    //   1421: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1424: ifeq +12 -> 1436
    //   1427: ldc 223
    //   1429: iconst_2
    //   1430: ldc_w 1423
    //   1433: invokestatic 231	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1436: aconst_null
    //   1437: astore 22
    //   1439: aconst_null
    //   1440: astore 21
    //   1442: aload 20
    //   1444: astore_3
    //   1445: aload 22
    //   1447: astore 20
    //   1449: goto -132 -> 1317
    //   1452: aload 22
    //   1454: astore 23
    //   1456: aload 7
    //   1458: astore 22
    //   1460: iload_2
    //   1461: sipush 9500
    //   1464: if_icmpne +23 -> 1487
    //   1467: aload 9
    //   1469: ifnull +134 -> 1603
    //   1472: aload 9
    //   1474: ldc_w 1425
    //   1477: invokeinterface 78 2 0
    //   1482: checkcast 41	java/lang/String
    //   1485: astore 22
    //   1487: iload_2
    //   1488: sipush 1011
    //   1491: if_icmpne +272 -> 1763
    //   1494: aload 9
    //   1496: ldc_w 1427
    //   1499: invokeinterface 78 2 0
    //   1504: checkcast 41	java/lang/String
    //   1507: astore 7
    //   1509: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1512: ifeq +30 -> 1542
    //   1515: ldc 223
    //   1517: iconst_2
    //   1518: new 187	java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1525: ldc_w 1429
    //   1528: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: aload 7
    //   1533: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1539: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1542: aload 7
    //   1544: ldc_w 581
    //   1547: ldc 170
    //   1549: invokevirtual 585	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1552: ldc_w 587
    //   1555: invokevirtual 591	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1558: astore 24
    //   1560: aload 24
    //   1562: arraylength
    //   1563: newarray byte
    //   1565: astore 7
    //   1567: iconst_0
    //   1568: istore 11
    //   1570: iload 11
    //   1572: aload 24
    //   1574: arraylength
    //   1575: if_icmpge +35 -> 1610
    //   1578: aload 7
    //   1580: iload 11
    //   1582: aload 24
    //   1584: iload 11
    //   1586: aaload
    //   1587: invokevirtual 594	java/lang/String:trim	()Ljava/lang/String;
    //   1590: invokestatic 600	java/lang/Byte:parseByte	(Ljava/lang/String;)B
    //   1593: bastore
    //   1594: iload 11
    //   1596: iconst_1
    //   1597: iadd
    //   1598: istore 11
    //   1600: goto -30 -> 1570
    //   1603: ldc 170
    //   1605: astore 22
    //   1607: goto -120 -> 1487
    //   1610: new 41	java/lang/String
    //   1613: dup
    //   1614: aload 4
    //   1616: invokestatic 1431	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Ljava/lang/String;)[B
    //   1619: ldc_w 610
    //   1622: invokespecial 620	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1625: astore 24
    //   1627: aload 24
    //   1629: astore 4
    //   1631: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1634: ifeq +34 -> 1668
    //   1637: ldc 223
    //   1639: iconst_2
    //   1640: new 187	java/lang/StringBuilder
    //   1643: dup
    //   1644: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1647: ldc_w 1433
    //   1650: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1653: aload 24
    //   1655: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1661: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1664: aload 24
    //   1666: astore 4
    //   1668: iconst_1
    //   1669: istore 12
    //   1671: iload_2
    //   1672: sipush 1025
    //   1675: if_icmpeq +10 -> 1685
    //   1678: iload_2
    //   1679: sipush 1024
    //   1682: if_icmpne +113 -> 1795
    //   1685: aload 7
    //   1687: ifnull +108 -> 1795
    //   1690: aload 7
    //   1692: arraylength
    //   1693: iconst_3
    //   1694: if_icmpne +101 -> 1795
    //   1697: iload 6
    //   1699: ifeq +78 -> 1777
    //   1702: aload_1
    //   1703: ldc_w 1434
    //   1706: invokevirtual 419	android/content/Context:getString	(I)Ljava/lang/String;
    //   1709: astore_0
    //   1710: aload_1
    //   1711: instanceof 378
    //   1714: ifeq +74 -> 1788
    //   1717: aload_1
    //   1718: sipush 230
    //   1721: aconst_null
    //   1722: aload_0
    //   1723: aconst_null
    //   1724: aload_1
    //   1725: ldc_w 1435
    //   1728: invokevirtual 419	android/content/Context:getString	(I)Ljava/lang/String;
    //   1731: new 1437	sbp
    //   1734: dup
    //   1735: invokespecial 1438	sbp:<init>	()V
    //   1738: aconst_null
    //   1739: invokestatic 1441	com/tencent/mobileqq/utils/DialogUtil:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   1742: invokevirtual 1442	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   1745: return
    //   1746: astore_0
    //   1747: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1750: ifeq -1158 -> 592
    //   1753: ldc 223
    //   1755: iconst_2
    //   1756: ldc_w 1444
    //   1759: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1762: return
    //   1763: aload_0
    //   1764: iload_2
    //   1765: aload_3
    //   1766: invokestatic 1449	com/tencent/av/utils/VideoMsgTools:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)[B
    //   1769: astore 7
    //   1771: iconst_0
    //   1772: istore 12
    //   1774: goto -103 -> 1671
    //   1777: aload_1
    //   1778: ldc_w 1450
    //   1781: invokevirtual 419	android/content/Context:getString	(I)Ljava/lang/String;
    //   1784: astore_0
    //   1785: goto -75 -> 1710
    //   1788: getstatic 401	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   1791: astore_1
    //   1792: goto -75 -> 1717
    //   1795: aload_0
    //   1796: invokevirtual 1453	com/tencent/mobileqq/app/QQAppInterface:a	()J
    //   1799: l2i
    //   1800: istore 14
    //   1802: aload_0
    //   1803: aload_3
    //   1804: invokestatic 1454	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   1807: istore 19
    //   1809: aload_0
    //   1810: bipush 50
    //   1812: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1815: checkcast 342	com/tencent/mobileqq/app/FriendsManager
    //   1818: aload_3
    //   1819: invokevirtual 1456	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   1822: astore 24
    //   1824: aload 24
    //   1826: ifnull +1544 -> 3370
    //   1829: aload 24
    //   1831: aload_0
    //   1832: invokestatic 1459	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/data/Friends;Lcom/tencent/mobileqq/app/QQAppInterface;)I
    //   1835: istore 13
    //   1837: aload_0
    //   1838: bipush 13
    //   1840: invokevirtual 979	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1843: checkcast 1461	com/tencent/mobileqq/app/SVIPHandler
    //   1846: invokevirtual 1464	com/tencent/mobileqq/app/SVIPHandler:j	()I
    //   1849: istore 11
    //   1851: iload 11
    //   1853: iconst_2
    //   1854: if_icmpne +1333 -> 3187
    //   1857: iconst_0
    //   1858: istore 11
    //   1860: aload_0
    //   1861: aload_3
    //   1862: iconst_3
    //   1863: iconst_1
    //   1864: aconst_null
    //   1865: invokestatic 1469	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;Ljava/lang/String;IZLjava/lang/String;)I
    //   1868: istore 15
    //   1870: iload 15
    //   1872: ifeq +78 -> 1950
    //   1875: iload_2
    //   1876: ifeq +24 -> 1900
    //   1879: iload_2
    //   1880: sipush 1004
    //   1883: if_icmpeq +17 -> 1900
    //   1886: iload_2
    //   1887: sipush 1000
    //   1890: if_icmpeq +10 -> 1900
    //   1893: iload_2
    //   1894: sipush 1003
    //   1897: if_icmpne +53 -> 1950
    //   1900: aload_0
    //   1901: bipush 44
    //   1903: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1906: checkcast 1471	com/tencent/mobileqq/vas/ColorRingManager
    //   1909: astore 24
    //   1911: new 1093	java/io/File
    //   1914: dup
    //   1915: iload 15
    //   1917: i2l
    //   1918: iconst_3
    //   1919: invokestatic 1474	com/tencent/mobileqq/vas/ColorRingManager:a	(JI)Ljava/lang/String;
    //   1922: invokespecial 1095	java/io/File:<init>	(Ljava/lang/String;)V
    //   1925: invokevirtual 1125	java/io/File:exists	()Z
    //   1928: ifne +22 -> 1950
    //   1931: invokestatic 1475	com/tencent/mobileqq/vipav/VipFunCallManager:b	()Z
    //   1934: ifeq +16 -> 1950
    //   1937: aload 24
    //   1939: iload 15
    //   1941: iconst_3
    //   1942: iconst_0
    //   1943: iconst_0
    //   1944: ldc_w 1477
    //   1947: invokevirtual 1480	com/tencent/mobileqq/vas/ColorRingManager:a	(IIZILjava/lang/String;)V
    //   1950: aload_0
    //   1951: aload_3
    //   1952: bipush 6
    //   1954: iconst_1
    //   1955: aconst_null
    //   1956: invokestatic 1469	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;Ljava/lang/String;IZLjava/lang/String;)I
    //   1959: istore 16
    //   1961: iload 16
    //   1963: ifeq +66 -> 2029
    //   1966: invokestatic 1482	com/tencent/mobileqq/vipav/VipFunCallManager:a	()I
    //   1969: istore 17
    //   1971: aload_0
    //   1972: iload 16
    //   1974: iload 17
    //   1976: aconst_null
    //   1977: invokestatic 1485	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;IILjava/lang/String;)Ljava/lang/String;
    //   1980: astore 24
    //   1982: aload 24
    //   1984: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1987: ifne +42 -> 2029
    //   1990: new 1093	java/io/File
    //   1993: dup
    //   1994: aload 24
    //   1996: invokespecial 1095	java/io/File:<init>	(Ljava/lang/String;)V
    //   1999: invokevirtual 1125	java/io/File:exists	()Z
    //   2002: ifne +27 -> 2029
    //   2005: invokestatic 1475	com/tencent/mobileqq/vipav/VipFunCallManager:b	()Z
    //   2008: ifeq +21 -> 2029
    //   2011: aload_0
    //   2012: bipush 83
    //   2014: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2017: checkcast 1466	com/tencent/mobileqq/vipav/VipFunCallManager
    //   2020: iload 16
    //   2022: iload 17
    //   2024: iconst_0
    //   2025: iconst_0
    //   2026: invokevirtual 1488	com/tencent/mobileqq/vipav/VipFunCallManager:a	(IIZI)V
    //   2029: aload_0
    //   2030: iload 16
    //   2032: invokestatic 1491	com/tencent/mobileqq/vipav/VipFunCallManager:a	(Lmqq/app/AppRuntime;I)V
    //   2035: aload_0
    //   2036: bipush 46
    //   2038: invokevirtual 979	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2041: checkcast 1493	com/tencent/mobileqq/vipav/VipSetFunCallHandler
    //   2044: astore 24
    //   2046: new 63	android/os/Bundle
    //   2049: dup
    //   2050: invokespecial 64	android/os/Bundle:<init>	()V
    //   2053: astore 25
    //   2055: aload 25
    //   2057: ldc_w 952
    //   2060: aload_3
    //   2061: invokestatic 987	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2064: invokevirtual 1497	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2067: aload 25
    //   2069: ldc_w 1499
    //   2072: ldc 170
    //   2074: invokevirtual 82	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2077: aload 24
    //   2079: iconst_2
    //   2080: aload 25
    //   2082: invokevirtual 1502	com/tencent/mobileqq/vipav/VipSetFunCallHandler:a	(ILjava/lang/Object;)V
    //   2085: new 897	android/content/Intent
    //   2088: dup
    //   2089: aload_1
    //   2090: ldc_w 1504
    //   2093: invokespecial 902	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   2096: astore 24
    //   2098: aload 24
    //   2100: ldc_w 1505
    //   2103: invokevirtual 1232	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2106: pop
    //   2107: aload 24
    //   2109: ldc_w 1361
    //   2112: invokevirtual 1232	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   2115: pop
    //   2116: aload 24
    //   2118: ldc_w 1363
    //   2121: iload_2
    //   2122: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2125: pop
    //   2126: aload 24
    //   2128: ldc_w 952
    //   2131: aload_3
    //   2132: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2135: pop
    //   2136: aload 24
    //   2138: ldc_w 1506
    //   2141: aload 4
    //   2143: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2146: pop
    //   2147: aload 24
    //   2149: ldc_w 1508
    //   2152: aload 21
    //   2154: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2157: pop
    //   2158: aload 24
    //   2160: ldc_w 1510
    //   2163: aload 20
    //   2165: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2168: pop
    //   2169: aload 24
    //   2171: ldc_w 1512
    //   2174: aload 5
    //   2176: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2179: pop
    //   2180: aload 24
    //   2182: ldc_w 1514
    //   2185: iconst_0
    //   2186: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2189: pop
    //   2190: aload 24
    //   2192: ldc_w 1369
    //   2195: iload 6
    //   2197: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2200: pop
    //   2201: aload 24
    //   2203: ldc_w 1516
    //   2206: iload 14
    //   2208: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2211: pop
    //   2212: aload 24
    //   2214: ldc_w 1367
    //   2217: aload 23
    //   2219: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2222: pop
    //   2223: aload 24
    //   2225: ldc_w 1518
    //   2228: aload 22
    //   2230: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2233: pop
    //   2234: aload 24
    //   2236: ldc_w 1520
    //   2239: iload 18
    //   2241: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2244: pop
    //   2245: aload 24
    //   2247: ldc_w 1522
    //   2250: iload 19
    //   2252: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2255: pop
    //   2256: aload 24
    //   2258: ldc_w 1524
    //   2261: invokestatic 1529	android/os/SystemClock:elapsedRealtime	()J
    //   2264: invokevirtual 930	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2267: pop
    //   2268: aload 24
    //   2270: ldc_w 1531
    //   2273: iconst_1
    //   2274: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2277: pop
    //   2278: aload 24
    //   2280: ldc_w 1533
    //   2283: iload 15
    //   2285: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2288: pop
    //   2289: aload 24
    //   2291: ldc_w 1535
    //   2294: iload 11
    //   2296: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2299: pop
    //   2300: iload 6
    //   2302: ifeq +932 -> 3234
    //   2305: iconst_1
    //   2306: istore 11
    //   2308: aload 24
    //   2310: ldc_w 1537
    //   2313: iload 11
    //   2315: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2318: pop
    //   2319: aload 9
    //   2321: ifnull +1039 -> 3360
    //   2324: aload 9
    //   2326: ldc_w 1539
    //   2329: invokeinterface 78 2 0
    //   2334: checkcast 41	java/lang/String
    //   2337: astore 4
    //   2339: aload 9
    //   2341: ldc_w 1541
    //   2344: invokeinterface 78 2 0
    //   2349: checkcast 41	java/lang/String
    //   2352: astore 20
    //   2354: aload 9
    //   2356: ldc_w 1543
    //   2359: invokeinterface 78 2 0
    //   2364: checkcast 41	java/lang/String
    //   2367: astore 21
    //   2369: aload 9
    //   2371: ldc_w 1545
    //   2374: invokeinterface 78 2 0
    //   2379: checkcast 41	java/lang/String
    //   2382: astore 22
    //   2384: aload 4
    //   2386: ifnull +967 -> 3353
    //   2389: aload 24
    //   2391: ldc_w 1539
    //   2394: aload 4
    //   2396: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2399: pop
    //   2400: aload 24
    //   2402: ldc_w 1541
    //   2405: aload 20
    //   2407: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2410: pop
    //   2411: aload 24
    //   2413: ldc_w 1543
    //   2416: aload 21
    //   2418: invokestatic 92	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2421: invokevirtual 96	java/lang/Integer:intValue	()I
    //   2424: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2427: pop
    //   2428: aload 24
    //   2430: ldc_w 1545
    //   2433: aload 22
    //   2435: invokestatic 92	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   2438: invokevirtual 96	java/lang/Integer:intValue	()I
    //   2441: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2444: pop
    //   2445: aload 9
    //   2447: ldc_w 1427
    //   2450: invokeinterface 78 2 0
    //   2455: checkcast 41	java/lang/String
    //   2458: astore 4
    //   2460: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2463: ifeq +30 -> 2493
    //   2466: ldc 223
    //   2468: iconst_2
    //   2469: new 187	java/lang/StringBuilder
    //   2472: dup
    //   2473: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   2476: ldc_w 1429
    //   2479: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: aload 4
    //   2484: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2490: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2493: aload 4
    //   2495: ifnull +858 -> 3353
    //   2498: aload 4
    //   2500: invokestatic 1548	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   2503: astore 4
    //   2505: ldc 223
    //   2507: aload 4
    //   2509: invokestatic 1551	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;[B)V
    //   2512: aload 9
    //   2514: ldc 66
    //   2516: invokeinterface 78 2 0
    //   2521: checkcast 41	java/lang/String
    //   2524: astore 7
    //   2526: aload 24
    //   2528: ldc 74
    //   2530: aload 7
    //   2532: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2535: pop
    //   2536: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2539: ifeq +30 -> 2569
    //   2542: ldc 223
    //   2544: iconst_2
    //   2545: new 187	java/lang/StringBuilder
    //   2548: dup
    //   2549: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   2552: ldc_w 1553
    //   2555: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2558: aload 7
    //   2560: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2566: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2569: aload 9
    //   2571: ldc 84
    //   2573: invokeinterface 78 2 0
    //   2578: checkcast 41	java/lang/String
    //   2581: astore 7
    //   2583: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2586: ifeq +30 -> 2616
    //   2589: ldc 223
    //   2591: iconst_2
    //   2592: new 187	java/lang/StringBuilder
    //   2595: dup
    //   2596: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   2599: ldc_w 1555
    //   2602: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2605: aload 7
    //   2607: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2610: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2613: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2616: aload 24
    //   2618: ldc 84
    //   2620: aload 7
    //   2622: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2625: pop
    //   2626: aload 24
    //   2628: ldc_w 1427
    //   2631: aload 4
    //   2633: invokevirtual 1558	android/content/Intent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   2636: pop
    //   2637: iload_2
    //   2638: sipush 1011
    //   2641: if_icmpne +68 -> 2709
    //   2644: aload 9
    //   2646: ldc_w 1560
    //   2649: invokeinterface 78 2 0
    //   2654: checkcast 41	java/lang/String
    //   2657: astore 4
    //   2659: aload 9
    //   2661: ldc_w 1562
    //   2664: invokeinterface 78 2 0
    //   2669: checkcast 41	java/lang/String
    //   2672: astore 7
    //   2674: aload 24
    //   2676: ldc_w 1562
    //   2679: new 187	java/lang/StringBuilder
    //   2682: dup
    //   2683: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   2686: aload 7
    //   2688: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2691: aload 4
    //   2693: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2696: ldc_w 1564
    //   2699: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2702: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2705: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2708: pop
    //   2709: aload_0
    //   2710: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2713: aload_3
    //   2714: invokevirtual 1566	com/tencent/av/gaudio/AVNotifyCenter:d	(Ljava/lang/String;)Z
    //   2717: ifeq +61 -> 2778
    //   2720: aload_0
    //   2721: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2724: aload_3
    //   2725: invokevirtual 1568	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)I
    //   2728: iconst_1
    //   2729: if_icmpne +528 -> 3257
    //   2732: aload 24
    //   2734: ldc_w 1369
    //   2737: iconst_1
    //   2738: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2741: pop
    //   2742: iload 6
    //   2744: ifeq +526 -> 3270
    //   2747: iconst_0
    //   2748: istore 18
    //   2750: aload 24
    //   2752: ldc_w 1570
    //   2755: iload 18
    //   2757: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2760: pop
    //   2761: aload 24
    //   2763: ldc_w 1537
    //   2766: aload_0
    //   2767: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2770: aload_3
    //   2771: invokevirtual 1568	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)I
    //   2774: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2777: pop
    //   2778: aload 24
    //   2780: ldc_w 1571
    //   2783: aload 8
    //   2785: invokevirtual 923	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2788: pop
    //   2789: aload 24
    //   2791: ldc_w 1573
    //   2794: iload 13
    //   2796: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2799: pop
    //   2800: aload 24
    //   2802: ldc_w 1575
    //   2805: aload_0
    //   2806: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2809: aload_3
    //   2810: invokevirtual 1566	com/tencent/av/gaudio/AVNotifyCenter:d	(Ljava/lang/String;)Z
    //   2813: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2816: pop
    //   2817: aload 24
    //   2819: ldc_w 1577
    //   2822: aload_0
    //   2823: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2826: aload_3
    //   2827: invokevirtual 1578	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;)J
    //   2830: invokevirtual 930	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2833: pop
    //   2834: aload 24
    //   2836: ldc_w 1580
    //   2839: iload 10
    //   2841: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2844: pop
    //   2845: aload_0
    //   2846: new 1582	com/tencent/av/app/PstnSessionInfo
    //   2849: dup
    //   2850: invokespecial 1583	com/tencent/av/app/PstnSessionInfo:<init>	()V
    //   2853: aload_3
    //   2854: iload_2
    //   2855: invokestatic 1586	com/tencent/av/utils/PstnUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/av/app/PstnSessionInfo;Ljava/lang/String;I)Lcom/tencent/av/app/PstnSessionInfo;
    //   2858: astore 4
    //   2860: aload 4
    //   2862: getfield 1587	com/tencent/av/app/PstnSessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2865: ifnull +479 -> 3344
    //   2868: aload 4
    //   2870: getfield 1589	com/tencent/av/app/PstnSessionInfo:c	Ljava/lang/String;
    //   2873: ifnull +471 -> 3344
    //   2876: aload_0
    //   2877: sipush 142
    //   2880: invokevirtual 340	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2883: checkcast 1591	com/tencent/mobileqq/qcall/PstnManager
    //   2886: astore 4
    //   2888: aload 4
    //   2890: aload_0
    //   2891: invokevirtual 603	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2894: invokevirtual 1594	com/tencent/mobileqq/qcall/PstnManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/qcall/PstnCardInfo;
    //   2897: astore 7
    //   2899: aload 7
    //   2901: ifnull +443 -> 3344
    //   2904: aload 4
    //   2906: invokevirtual 1595	com/tencent/mobileqq/qcall/PstnManager:a	()I
    //   2909: iconst_1
    //   2910: if_icmpne +434 -> 3344
    //   2913: aload 4
    //   2915: invokevirtual 1598	com/tencent/mobileqq/qcall/PstnManager:a	()Lcom/tencent/mobileqq/qcall/PstnSwitchConfig;
    //   2918: getfield 1601	com/tencent/mobileqq/qcall/PstnSwitchConfig:c	I
    //   2921: iconst_1
    //   2922: if_icmpne +422 -> 3344
    //   2925: iconst_1
    //   2926: istore 13
    //   2928: aload 7
    //   2930: ifnull +346 -> 3276
    //   2933: aload 7
    //   2935: getfield 1606	com/tencent/mobileqq/qcall/PstnCardInfo:pstn_c2c_call_time	I
    //   2938: ifle +338 -> 3276
    //   2941: iconst_1
    //   2942: istore 11
    //   2944: aload 24
    //   2946: ldc_w 1608
    //   2949: iload 13
    //   2951: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2954: pop
    //   2955: aload 24
    //   2957: ldc_w 1610
    //   2960: iload 11
    //   2962: invokevirtual 957	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2965: pop
    //   2966: aload 24
    //   2968: ldc_w 1612
    //   2971: iconst_1
    //   2972: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   2975: pop
    //   2976: aload_3
    //   2977: ifnonnull +8 -> 2985
    //   2980: aload 5
    //   2982: ifnull +39 -> 3021
    //   2985: aload_0
    //   2986: invokevirtual 1345	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   2989: astore 4
    //   2991: aload_0
    //   2992: invokevirtual 1614	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   2995: astore 7
    //   2997: aload_3
    //   2998: ifnull +307 -> 3305
    //   3001: iload 6
    //   3003: ifeq +308 -> 3311
    //   3006: iconst_0
    //   3007: istore 11
    //   3009: aload 4
    //   3011: aload 7
    //   3013: aload_3
    //   3014: iload 11
    //   3016: iload_2
    //   3017: invokevirtual 1617	com/tencent/av/gaudio/AVNotifyCenter:a	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   3020: pop
    //   3021: aload 24
    //   3023: invokevirtual 1621	android/content/Intent:getComponent	()Landroid/content/ComponentName;
    //   3026: invokevirtual 1626	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   3029: astore_3
    //   3030: aload_1
    //   3031: invokevirtual 208	java/lang/Object:getClass	()Ljava/lang/Class;
    //   3034: invokevirtual 214	java/lang/Class:getName	()Ljava/lang/String;
    //   3037: astore 4
    //   3039: aload_3
    //   3040: ldc_w 1628
    //   3043: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3046: ifeq +271 -> 3317
    //   3049: aload 4
    //   3051: ldc_w 1630
    //   3054: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3057: ifne +32 -> 3089
    //   3060: aload 4
    //   3062: ldc_w 1632
    //   3065: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3068: ifne +21 -> 3089
    //   3071: aload 4
    //   3073: ldc_w 1634
    //   3076: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3079: ifne +10 -> 3089
    //   3082: iload_2
    //   3083: sipush 9500
    //   3086: if_icmpne +231 -> 3317
    //   3089: new 897	android/content/Intent
    //   3092: dup
    //   3093: aload_1
    //   3094: ldc_w 1636
    //   3097: invokespecial 902	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   3100: astore_3
    //   3101: aload_3
    //   3102: ldc_w 1638
    //   3105: aload 24
    //   3107: invokevirtual 1641	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   3110: pop
    //   3111: aload_3
    //   3112: ldc_w 1361
    //   3115: invokevirtual 1232	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   3118: pop
    //   3119: aload_1
    //   3120: aload_3
    //   3121: invokevirtual 944	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3124: iload 10
    //   3126: ifeq +23 -> 3149
    //   3129: aload_1
    //   3130: instanceof 378
    //   3133: ifeq +16 -> 3149
    //   3136: aload_1
    //   3137: checkcast 378	android/app/Activity
    //   3140: ldc_w 1642
    //   3143: ldc_w 1643
    //   3146: invokevirtual 1646	android/app/Activity:overridePendingTransition	(II)V
    //   3149: aload_0
    //   3150: invokevirtual 1342	com/tencent/mobileqq/app/QQAppInterface:c	()Z
    //   3153: ifeq -2561 -> 592
    //   3156: iload 12
    //   3158: ifne -2566 -> 592
    //   3161: iload_2
    //   3162: sipush 9500
    //   3165: if_icmpeq -2573 -> 592
    //   3168: aload_1
    //   3169: instanceof 378
    //   3172: ifeq -2580 -> 592
    //   3175: aload_1
    //   3176: checkcast 378	android/app/Activity
    //   3179: ldc_w 1647
    //   3182: iconst_0
    //   3183: invokevirtual 1646	android/app/Activity:overridePendingTransition	(II)V
    //   3186: return
    //   3187: iload 11
    //   3189: iconst_3
    //   3190: if_icmpne +177 -> 3367
    //   3193: iconst_2
    //   3194: istore 11
    //   3196: goto -1336 -> 1860
    //   3199: astore 24
    //   3201: ldc 223
    //   3203: iconst_1
    //   3204: new 187	java/lang/StringBuilder
    //   3207: dup
    //   3208: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   3211: ldc_w 1649
    //   3214: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3217: aload 24
    //   3219: invokevirtual 1652	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3222: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3225: invokevirtual 219	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3228: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3231: goto -1146 -> 2085
    //   3234: iconst_2
    //   3235: istore 11
    //   3237: goto -929 -> 2308
    //   3240: astore_0
    //   3241: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3244: ifeq -2652 -> 592
    //   3247: ldc 223
    //   3249: iconst_2
    //   3250: ldc_w 1444
    //   3253: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3256: return
    //   3257: aload 24
    //   3259: ldc_w 1369
    //   3262: iconst_0
    //   3263: invokevirtual 914	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   3266: pop
    //   3267: goto -525 -> 2742
    //   3270: iconst_1
    //   3271: istore 18
    //   3273: goto -523 -> 2750
    //   3276: aload 4
    //   3278: invokevirtual 1654	com/tencent/mobileqq/qcall/PstnManager:b	()I
    //   3281: iconst_1
    //   3282: if_icmpne +17 -> 3299
    //   3285: aload 7
    //   3287: getfield 1657	com/tencent/mobileqq/qcall/PstnCardInfo:pstn_c2c_try_status	I
    //   3290: ifne +9 -> 3299
    //   3293: iconst_2
    //   3294: istore 11
    //   3296: goto -352 -> 2944
    //   3299: iconst_5
    //   3300: istore 11
    //   3302: goto -358 -> 2944
    //   3305: aload 5
    //   3307: astore_3
    //   3308: goto -307 -> 3001
    //   3311: iconst_1
    //   3312: istore 11
    //   3314: goto -305 -> 3009
    //   3317: aload_1
    //   3318: aload 24
    //   3320: invokevirtual 944	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   3323: goto -199 -> 3124
    //   3326: astore_3
    //   3327: goto -3043 -> 284
    //   3330: astore 24
    //   3332: goto -1664 -> 1668
    //   3335: astore 4
    //   3337: aload 24
    //   3339: astore 4
    //   3341: goto -1673 -> 1668
    //   3344: iconst_5
    //   3345: istore 11
    //   3347: iconst_0
    //   3348: istore 13
    //   3350: goto -406 -> 2944
    //   3353: aload 7
    //   3355: astore 4
    //   3357: goto -845 -> 2512
    //   3360: aload 7
    //   3362: astore 4
    //   3364: goto -738 -> 2626
    //   3367: goto -1507 -> 1860
    //   3370: iconst_m1
    //   3371: istore 13
    //   3373: goto -1536 -> 1837
    //   3376: aload 7
    //   3378: astore 22
    //   3380: goto -2031 -> 1349
    //   3383: aload 7
    //   3385: astore 23
    //   3387: goto -1931 -> 1456
    //   3390: aconst_null
    //   3391: astore 22
    //   3393: aconst_null
    //   3394: astore_3
    //   3395: goto -2205 -> 1190
    //   3398: iconst_0
    //   3399: istore 18
    //   3401: goto -2376 -> 1025
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3404	0	paramQQAppInterface	QQAppInterface
    //   0	3404	1	paramContext	Context
    //   0	3404	2	paramInt	int
    //   0	3404	3	paramString1	String
    //   0	3404	4	paramString2	String
    //   0	3404	5	paramString3	String
    //   0	3404	6	paramBoolean1	boolean
    //   0	3404	7	paramString4	String
    //   0	3404	8	paramString5	String
    //   0	3404	9	paramMap	Map
    //   0	3404	10	paramBoolean2	boolean
    //   279	3067	11	i	int
    //   1669	1488	12	j	int
    //   1835	1537	13	k	int
    //   1800	407	14	m	int
    //   1868	416	15	n	int
    //   1959	72	16	i1	int
    //   1969	54	17	i2	int
    //   1023	2377	18	bool1	boolean
    //   1807	444	19	bool2	boolean
    //   10	2396	20	localObject1	Object
    //   164	2253	21	localObject2	Object
    //   179	3213	22	localObject3	Object
    //   421	2965	23	localObject4	Object
    //   436	2670	24	localObject5	Object
    //   3199	120	24	localException1	Exception
    //   3330	8	24	localException2	Exception
    //   451	1630	25	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   919	924	1148	java/lang/Exception
    //   928	933	1148	java/lang/Exception
    //   1494	1542	1746	java/lang/Exception
    //   1542	1567	1746	java/lang/Exception
    //   1570	1594	1746	java/lang/Exception
    //   2035	2085	3199	java/lang/Exception
    //   2498	2505	3240	java/lang/Exception
    //   274	281	3326	java/lang/NumberFormatException
    //   1610	1627	3330	java/lang/Exception
    //   1631	1664	3335	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map paramMap)
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramContext);
    localQQProgressDialog.c(2131429510);
    localQQProgressDialog.show();
    paramContext = new sce(localQQProgressDialog, paramMap, paramQQAppInterface, paramContext, paramInt, paramString);
    localQQProgressDialog.a(new sch(paramContext));
    GVideoGrayConfig.a().a(paramQQAppInterface, paramString, paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo uinType: " + paramInt + ", uin: " + paramString);
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo Activity isDestroyed!");
      }
    }
    do
    {
      return;
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        QQToast.a(paramContext, 2131433117, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
      if ((paramQQAppInterface.a().a()) && (!paramQQAppInterface.c()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo phone is calling!");
        }
        paramQQAppInterface = paramContext.getString(2131429045);
        DialogUtil.b(paramContext, 230, paramContext.getString(2131429041), paramQQAppInterface, 2131433029, 2131433030, new sby(), null).show();
        DataReport.a();
        return;
      }
      if (!VcSystemInfo.f())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo old engine!");
        }
        if (paramInt == 1011)
        {
          paramString = paramContext.getString(2131429248);
          DialogUtil.b(paramContext, 230, paramContext.getString(2131429041), paramString, 2131433029, 2131429056, new sbz(), null).show();
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
          return;
        }
      }
      if ((DiscussionInfo.isValidDisUin(paramString)) || (paramInt != 3000)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatActivityUtils", 2, "invalid discussId: " + paramString);
    return;
    long l1 = Long.valueOf(paramString).longValue();
    int m = UITools.a(paramInt);
    int k = 0;
    int j = 0;
    int i = k;
    Object localObject1;
    if (paramMap != null)
    {
      i = k;
      if (m == 1)
      {
        localObject1 = (String)paramMap.get("MultiAVType");
        i = j;
        if (localObject1 != null) {
          i = Integer.valueOf((String)localObject1).intValue();
        }
        localObject1 = (String)paramMap.get("isVideo");
        if ((localObject1 != null) && (((String)localObject1).equals("true"))) {
          paramQQAppInterface.a().a(true);
        }
      }
    }
    for (;;)
    {
      if (m == 2) {
        i = 1;
      }
      if ((!paramQQAppInterface.a().a(m, l1)) || (m != 1) || (!paramQQAppInterface.a().g()) || (paramInt != 1)) {
        break label656;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "check mutex of qq call and group call!");
      }
      long l2 = paramQQAppInterface.a().b();
      j = paramQQAppInterface.a().b(l2);
      if ((j == i) || (j != 10) || (i != 2)) {
        break label656;
      }
      if (!paramQQAppInterface.a().b()) {
        break;
      }
      QQToast.a(paramContext, 2131428987, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return;
      paramQQAppInterface.a().a(false);
    }
    QQToast.a(paramContext, 2131428984, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
    return;
    label656:
    Object localObject2;
    Object localObject3;
    if (!paramQQAppInterface.a().a(m, l1, i)) {
      if ((paramBoolean1) && (!NetworkUtil.h(BaseApplication.getContext())) && (!NetworkUtil.f(BaseApplication.getContext())))
      {
        if (VideoController.d(VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin()) > 0)
        {
          a(paramQQAppInterface, paramContext, paramInt, paramString, false, paramBoolean2, paramMap);
          return;
        }
        localObject1 = null;
        localObject2 = null;
        if (NetworkUtil.b(BaseApplication.getContext()))
        {
          localObject1 = paramContext.getString(2131429041);
          localObject2 = paramContext.getString(2131429033);
        }
        if (!NetworkUtil.c(BaseApplication.getContext())) {
          break label1488;
        }
        localObject1 = paramContext.getString(2131429041);
        if ((paramMap != null) && (TextUtils.equals((CharSequence)paramMap.get("isVideo"), "true")))
        {
          localObject3 = paramContext.getString(2131429035);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ChatActivityUtils", 2, "enterNewGroupVideo title or content is empty");
        return;
        localObject3 = paramContext.getString(2131429036);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
      }
      a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131429048, 2131429053, new sca(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramMap), new scb());
      return;
      if ((paramBoolean2) && (paramQQAppInterface.c()))
      {
        j = paramQQAppInterface.a().b();
        k = paramQQAppInterface.a().c();
        if (((k != 1) && (k != 2)) || (((j >= 1) && (j <= 5)) || (paramQQAppInterface.a().e() == 1) || (paramQQAppInterface.a().e() == 2)))
        {
          QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
          return;
        }
        if (((k != 3) && (k != 4)) || (((j >= 1) && (j <= 5)) || (paramQQAppInterface.a().e() == 3) || (paramQQAppInterface.a().e() == 4)))
        {
          if ((paramQQAppInterface.a().b() == l1) && (m != 1))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ChatActivityUtils", 2, "enterNewGroupVideo-->chatUin==discussid???Why");
            return;
          }
          if (paramQQAppInterface.a().b() <= 0L) {
            break label1339;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo is multi calling!");
          }
          localObject1 = paramContext.getString(2131428983);
          j = TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString + "");
          PopupDialog.a(paramContext, 230, null, (String)localObject1, 2131429048, 2131429053, new scc(paramQQAppInterface, paramContext, m, i, paramInt, paramString, paramBoolean1, paramMap), new scd(paramQQAppInterface, paramString));
          ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", j + "", "", "");
          return;
        }
        if (paramQQAppInterface.a().a().jdField_b_of_type_Int != -1)
        {
          QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
          return;
        }
      }
      label1339:
      localObject1 = null;
      localObject3 = "0";
      localObject2 = localObject3;
      if (paramMap != null)
      {
        paramMap = (String)paramMap.get("from");
        if (!TextUtils.equals(paramMap, "Panel")) {
          break label1427;
        }
        localObject2 = "1";
        localObject1 = "openMiddlePage";
      }
      for (;;)
      {
        ((GroupVideoManager)paramQQAppInterface.getManager(235)).a(paramContext, paramQQAppInterface.getCurrentAccountUin(), paramString, (String)localObject2, (String)localObject1);
        paramQQAppInterface.a().a(l1, i);
        return;
        label1427:
        if (TextUtils.equals(paramMap, "tipBar"))
        {
          localObject1 = "openRoom";
          localObject2 = localObject3;
        }
        else if (!paramQQAppInterface.a().b(Long.parseLong(paramString)))
        {
          localObject1 = "openMiddlePage";
          localObject2 = localObject3;
        }
        else
        {
          localObject1 = "openRoom";
          localObject2 = localObject3;
        }
      }
      label1488:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int m = 5;
    int k = 1;
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    paramQQAppInterface = localPstnManager.a(paramQQAppInterface.getCurrentAccountUin());
    int i;
    int j;
    if ((paramQQAppInterface != null) && (localPstnManager.a() == 1)) {
      if (paramQQAppInterface.pstn_multi_call_time > 0)
      {
        i = 3;
        j = k;
      }
    }
    for (;;)
    {
      paramIntent.putExtra("graySwitch", j);
      paramIntent.putExtra("ltMultiMembership", i);
      paramIntent.putExtra("multiPstnAutoTranTime", localPstnManager.a().jdField_e_of_type_Int);
      paramIntent.putExtra("multiPstnMissDelayTime", localPstnManager.a().f);
      paramIntent.putExtra("multiPstnMissShowTime", localPstnManager.a().g);
      return;
      i = m;
      j = k;
      if (localPstnManager.c() == 1)
      {
        i = m;
        j = k;
        if (paramQQAppInterface.pstn_multi_try_status == 0)
        {
          i = 4;
          j = k;
          continue;
          j = 0;
          i = m;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick().");
    }
    if ((paramActivity != null) && (paramActivity.getCurrentFocus() != null)) {}
    Context localContext;
    ChatMessage localChatMessage;
    do
    {
      ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 0);
      for (;;)
      {
        localContext = paramView.getContext();
        if (localContext != null) {
          break;
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "chatActivity current focus is null");
        }
      }
      localChatMessage = AIOUtils.a(paramView);
    } while (localChatMessage == null);
    paramView = null;
    boolean bool1;
    label112:
    boolean bool2;
    if ((localChatMessage instanceof MessageForLongMsg))
    {
      if (!localChatMessage.isShowQIMStyleGroup)
      {
        bool1 = true;
        if (localChatMessage.isShowTIMStyleGroup) {
          break label159;
        }
      }
      label159:
      for (bool2 = true;; bool2 = false)
      {
        paramQQAppInterface = ((MessageForLongMsg)localChatMessage).msg;
        if (paramQQAppInterface != null) {
          break label794;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick() CharSequence null.");
        return;
        bool1 = false;
        break label112;
      }
    }
    if ((localChatMessage instanceof MessageForText)) {
      if (!localChatMessage.isShowQIMStyleGroup)
      {
        bool1 = true;
        label184:
        if (localChatMessage.isShowTIMStyleGroup) {
          break label259;
        }
        bool2 = true;
        label195:
        paramQQAppInterface = (MessageForText)localChatMessage;
        if (!(paramQQAppInterface.sb instanceof QQText)) {
          break label1196;
        }
      }
    }
    label259:
    label265:
    label426:
    label1196:
    for (paramQQAppInterface = ((QQText)paramQQAppInterface.sb).jdField_e_of_type_JavaLangString;; paramQQAppInterface = null)
    {
      if (localChatMessage.msgtype == -2008) {
        if (!localChatMessage.isSend()) {
          break label265;
        }
      }
      for (paramQQAppInterface = localContext.getString(2131436182);; paramQQAppInterface = localContext.getString(2131436181))
      {
        break;
        bool1 = false;
        break label184;
        bool2 = false;
        break label195;
      }
      if ((localChatMessage instanceof MessageForQQStoryComment))
      {
        paramQQAppInterface = (MessageForQQStoryComment)localChatMessage;
        paramQQAppInterface = "“" + paramQQAppInterface.title + "”\n" + paramQQAppInterface.comment;
        bool2 = true;
        bool1 = true;
        break;
      }
      if (((localChatMessage instanceof MessageForReplyText)) || ((localChatMessage instanceof MessageForLongMsg)))
      {
        paramView = null;
        label372:
        StringBuilder localStringBuilder;
        String str1;
        if ((localChatMessage instanceof MessageForReplyText))
        {
          paramView = ((MessageForReplyText)localChatMessage).mSourceMsgInfo;
          localStringBuilder = new StringBuilder();
          if (paramView != null)
          {
            String str2 = TimeFormatterUtils.a(localContext, 3, paramView.mSourceMsgTime * 1000L).toString();
            str1 = "";
            if (TextUtils.isEmpty(paramView.mAnonymousNickName)) {
              break label543;
            }
            paramActivity = paramView.mAnonymousNickName;
            localStringBuilder.append("“").append(str2).append(" ").append(paramActivity).append("\r\n");
            if (paramView.mSourceSummaryFlag != 1) {
              break label652;
            }
            localStringBuilder.append(paramView.mSourceMsgText).append("\r\n");
          }
        }
        label728:
        for (;;)
        {
          MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "doubleClk", localChatMessage.frienduin, localChatMessage);
          localStringBuilder.append(localChatMessage.getSummaryMsg());
          paramQQAppInterface = localStringBuilder.toString();
          bool2 = true;
          bool1 = true;
          break;
          if (!(localChatMessage instanceof MessageForLongMsg)) {
            break label372;
          }
          paramView = ((MessageForLongMsg)localChatMessage).mSourceMsgInfo;
          break label372;
          if (paramView.mSourceMsgSenderUin == 50000000L)
          {
            Object localObject = ReplyTextItemBuilder.a(paramQQAppInterface, localChatMessage.frienduin, localChatMessage.istroop, paramView.mSourceMsgSeq);
            paramActivity = str1;
            if (localObject == null) {
              break label426;
            }
            localObject = TroopBusinessUtil.a((MessageRecord)localObject);
            paramActivity = str1;
            if (localObject == null) {
              break label426;
            }
            paramView.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).c;
            paramActivity = str1;
            break label426;
          }
          paramActivity = ContactUtils.a(paramQQAppInterface, localChatMessage.istroop, localChatMessage.frienduin, paramView.mSourceMsgSenderUin + "");
          break label426;
          if (paramView.mSourceSummaryFlag == 0)
          {
            paramQQAppInterface = paramQQAppInterface.a().a(localChatMessage.frienduin, 1, paramView.mSourceMsgSeq, 0L);
            if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {}
            for (paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);; paramQQAppInterface = null)
            {
              if (paramQQAppInterface == null) {
                break label728;
              }
              localStringBuilder.append(paramQQAppInterface.msg).append("\r\n");
              break;
            }
          }
        }
      }
      if ((localChatMessage instanceof MessageForMixedMsg))
      {
        paramQQAppInterface = ((MessageForMixedMsg)localChatMessage).msg;
        bool2 = true;
        bool1 = true;
        break;
      }
      if ((localChatMessage instanceof MessageForHiBoom))
      {
        paramQQAppInterface = (MessageForHiBoom)localChatMessage;
        if (paramQQAppInterface.mHiBoomMessage != null)
        {
          paramQQAppInterface = paramQQAppInterface.mHiBoomMessage.text;
          bool2 = true;
          bool1 = true;
          break;
          paramView = new Intent(localContext, TextPreviewActivity.class);
          paramView.putExtra("peeruin", localChatMessage.frienduin);
          paramView.putExtra("uin_type", localChatMessage.istroop);
          paramView.putExtra("content", paramQQAppInterface);
          paramView.putExtra("uniseq", localChatMessage.uniseq);
          paramView.putExtra("bubbleId", localChatMessage.vipBubbleID);
          paramView.putExtra("bubbleDiyId", localChatMessage.vipBubbleDiyTextId);
          paramView.putExtra("fontId", localChatMessage.getExtInfoFromExtStr("vip_font_id"));
          int j = 0;
          paramQQAppInterface = localChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
          int i = j;
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            i = j;
            if (TextUtils.isDigitsOnly(paramQQAppInterface)) {
              i = Integer.valueOf(paramQQAppInterface).intValue();
            }
          }
          j = i;
          if (i == 0)
          {
            j = i;
            if (FontManager.a(localChatMessage)) {
              j = 1;
            }
          }
          i = j;
          if (j != 0)
          {
            i = j;
            if (1 == localChatMessage.istroop)
            {
              i = j;
              if (AnonymousChatHelper.a(localChatMessage)) {
                i = 0;
              }
            }
          }
          paramView.putExtra("fontEffectId", i);
          paramView.putExtra(QIMUserManager.jdField_a_of_type_JavaLangString, bool1);
          paramView.putExtra(TIMUserManager.jdField_a_of_type_JavaLangString, bool2);
          if ((localChatMessage instanceof MessageForHiBoom))
          {
            paramQQAppInterface = (MessageForHiBoom)localChatMessage;
            if (paramQQAppInterface.mHiBoomMessage != null) {
              paramView.putExtra("HiBoomId", paramQQAppInterface.mHiBoomMessage.id);
            }
          }
          if (localChatMessage.isSend()) {
            paramQQAppInterface = localChatMessage.selfuin;
          }
          for (;;)
          {
            paramView.putExtra("real_msg_sender_uin", paramQQAppInterface);
            ((Activity)localContext).startActivityForResult(paramView, 14001);
            ((Activity)localContext).overridePendingTransition(2131034140, 0);
            VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface, "long_msg", "long_msg_double", "", 1, 0, 0, "", String.valueOf(SVIPHandler.a(localChatMessage.vipBubbleID)), "");
            return;
            if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004)) {
              paramQQAppInterface = localChatMessage.frienduin;
            } else {
              paramQQAppInterface = localChatMessage.senderuin;
            }
          }
        }
      }
      bool2 = true;
      bool1 = true;
      paramQQAppInterface = paramView;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Integer paramInteger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils.troop.notification_center.show_red_dot", 2, "setTroopTipStatus, troopUin:" + paramString + ",status:" + paramInteger);
        }
      } while ((paramInteger.intValue() != -1) && (paramInteger.intValue() != 0));
      if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString + paramQQAppInterface.getCurrentAccountUin(), paramInteger);
    } while (paramInteger.intValue() != -1);
    paramInteger = (TroopManager)paramQQAppInterface.getManager(51);
    int i;
    if (paramInteger != null)
    {
      paramInteger = paramInteger.a(paramString);
      if (paramInteger != null)
      {
        String str = paramQQAppInterface.getCurrentAccountUin();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramInteger.Administrator))) {
          if ((str.equals(paramInteger.Administrator)) || (paramInteger.Administrator.contains(str))) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (paramInteger = "0";; paramInteger = "1")
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
        return;
        i = 0;
        break;
      }
      i = 0;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Map paramMap)
  {
    if (paramMap != null)
    {
      String str = (String)paramMap.get("business_type");
      if ((str == null) || (!str.equals("1"))) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        l = Long.parseLong((String)paramMap.get("group_id"));
        paramMap = new Intent();
        paramMap.setAction("android.intent.action.gameparty.refresh");
        paramMap.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
        paramMap.putExtra("teamId", l);
        paramQQAppInterface.getApp().sendBroadcast(paramMap);
        return;
      }
      catch (NumberFormatException paramMap)
      {
        for (;;)
        {
          long l = -1L;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1029) || (paramInt == 1023) || (paramInt == 1020) || (paramInt == 1025) || (paramInt == 1010);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, "single friend list: " + (String)localObject);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        localObject = new JSONArray();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((!localJSONObject.has("type")) || (!localJSONObject.has("uin"))) {
            break label215;
          }
          int j = localJSONObject.getInt("type");
          String str = localJSONObject.getString("uin");
          if ((j == paramInt) && (str.equals(MsgProxyUtils.a(paramString)))) {
            break label215;
          }
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("single_way_friend_list", ((JSONArray)localObject).toString());
      boolean bool = paramContext.commit();
      return bool;
      label215:
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt != 0) {
      return false;
    }
    if (((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + paramInt);
    }
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
    boolean bool1;
    if (paramInt == 0)
    {
      if (!((FriendsManager)paramQQAppInterface.getManager(50)).d(paramString1)) {
        break label282;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + bool1);
      }
      return bool1;
      if ((paramInt == 1001) || (paramInt == 10002))
      {
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (localShieldMsgManger == null) {
          break label276;
        }
      }
      label276:
      for (bool1 = localShieldMsgManger.a(paramString1);; bool1 = false)
      {
        if (!bool1)
        {
          paramQQAppInterface = paramQQAppInterface.c(paramString1);
          if ((paramQQAppInterface != null) && (paramQQAppInterface.groupid == -1002)) {
            bool1 = bool2;
          }
        }
        for (;;)
        {
          break;
          bool1 = bool3;
          if (paramInt == 1011) {
            break;
          }
          if (paramInt == 25)
          {
            bool1 = ((LightalkShieldManager)paramQQAppInterface.getManager(138)).a(UinUtils.a(paramString1));
            break;
          }
          bool1 = bool3;
          if (localShieldMsgManger == null) {
            break;
          }
          String str = paramString1;
          if (paramInt == 1006)
          {
            str = paramString1;
            if (paramString1 == null) {
              str = ContactUtils.g(paramQQAppInterface, paramString2);
            }
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          bool1 = localShieldMsgManger.a(str);
          break;
        }
      }
      label282:
      bool1 = false;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList paramArrayList)
  {
    paramArrayList = (PhoneContactManager)paramQQAppInterface.getManager(10);
    if (paramInt == 3000)
    {
      paramString = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
      if (paramString != null)
      {
        int i = paramString.size();
        paramInt = 0;
        while (paramInt < i)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(paramInt);
          if ((localDiscussionMemberInfo != null) && (!paramQQAppInterface.getAccount().equals(localDiscussionMemberInfo.memberUin)) && (paramArrayList.a(localDiscussionMemberInfo.memberUin) != null)) {
            return true;
          }
          paramInt += 1;
        }
      }
    }
    return false;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt1 == 1) && (paramQQAppInterface.a().a(paramInt1, paramLong)) && (paramQQAppInterface.a().g()) && (paramInt2 == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "check mutex of qq call and group call!");
      }
      paramLong = paramQQAppInterface.a().b();
      paramInt1 = paramQQAppInterface.a().b(paramLong);
      if (paramInt1 != paramInt3)
      {
        if ((paramInt1 == 10) && (paramInt3 == 2))
        {
          if (paramQQAppInterface.a().b())
          {
            QQToast.a(paramContext, 2131428987, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
            return true;
          }
          QQToast.a(paramContext, 2131428984, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          return true;
        }
        if ((paramInt1 == 2) && (paramInt3 == 10))
        {
          if (paramQQAppInterface.a().b())
          {
            QQToast.a(paramContext, 2131428986, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
            return true;
          }
          QQToast.a(paramContext, 2131428985, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          return true;
        }
      }
      if (paramInt3 != 2) {
        break label235;
      }
      paramContext.sendBroadcast(new Intent("com.tencent.av.EXIT_VIDEO_PROCESS"));
    }
    for (;;)
    {
      return false;
      label235:
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5, Map paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "startVideo uinType: " + paramInt + ", peerUin: " + paramString1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean1 + ", extraUin: " + paramString4 + ", checkShieldMsg: " + paramBoolean2 + ", checkWifi: " + paramBoolean3 + ", from: " + paramString5);
    }
    return b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramMap, true, true, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, Map paramMap, int paramInt2, boolean paramBoolean4)
  {
    if (!NetworkUtil.g(paramContext))
    {
      QQToast.a(paramContext, 0, 2131433227, 0).a();
      return false;
    }
    Object localObject2 = (PhoneContactManager)paramQQAppInterface.getManager(10);
    Object localObject1 = ((PhoneContactManager)localObject2).a();
    String str;
    if (localObject1 != null)
    {
      localObject3 = ((RespondQueryQQBindingStat)localObject1).mobileNo;
      str = ((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo;
      if (((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramString3))) || ((!TextUtils.isEmpty(str)) && (str.equals(paramString3))))
      {
        QQToast.a(paramContext, 2131429583, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        return false;
      }
    }
    PstnManager localPstnManager = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject3 = localPstnManager.a(paramQQAppInterface.getCurrentAccountUin());
    int i;
    if ((localObject3 != null) && (((PstnCardInfo)localObject3).pstn_c2c_call_time > 0))
    {
      i = 1;
      if ((!paramBoolean4) || (paramInt1 != 0) || (localPstnManager.a()) || (!PstnUtils.a(paramQQAppInterface, 1)) || (!a(paramQQAppInterface, paramInt1, paramString1)) || (i == 0)) {
        break label373;
      }
      localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131438428);
      localObject2 = paramQQAppInterface.getApplication().getResources().getString(2131438429);
      str = localPstnManager.a("pstn_c2c_trans_wording");
      localObject3 = localPstnManager.a("pstn_c2c_trans_check_wording");
      if (!TextUtils.isEmpty(str)) {
        break label359;
      }
      label278:
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label366;
      }
    }
    for (;;)
    {
      DialogUtil.a(paramContext, 230, "确认呼叫方式", (String)localObject1, (String)localObject2, "取消", "呼叫", null, new sct(localPstnManager, paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramMap, paramInt2), new scu(paramStartVideoListener, paramQQAppInterface)).show();
      return false;
      i = 0;
      break;
      label359:
      localObject1 = str;
      break label278;
      label366:
      localObject2 = localObject3;
    }
    label373:
    if ((paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 1006) || (paramInt1 == 56938) || (paramInt1 == 5) || ((paramInt1 == 0) && (a(paramQQAppInterface, paramInt1, paramString1))))
    {
      paramString4 = new PstnSessionInfo();
      paramString4.jdField_a_of_type_Int = paramInt1;
      if (paramInt1 == 5)
      {
        paramString4.jdField_a_of_type_JavaLangString = paramString1.substring("pstn".length());
        paramString4.jdField_a_of_type_Int = 56938;
        if (!TextUtils.isEmpty(paramString3)) {
          break label553;
        }
        paramString1 = ((PhoneContactManager)localObject2).a(paramString1);
        if (paramString1 == null) {}
      }
      for (paramString4.jdField_b_of_type_JavaLangString = paramString1.unifiedCode;; paramString4.jdField_b_of_type_JavaLangString = paramString3)
      {
        paramString4.d = paramString2;
        if (localObject1 != null) {
          paramString4.c = (((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo);
        }
        return a(paramQQAppInterface, paramContext, paramString4, paramInt2, paramStartVideoListener, true);
        paramString4.jdField_a_of_type_JavaLangString = paramString1;
        break;
      }
    }
    label553:
    if (paramInt1 == 0) {
      return a(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, "from_internal", paramMap);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityUtils", 2, "startC2CCall| type is wrong.");
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.StartVideoListener paramStartVideoListener, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("startGroupAudioEx, uinType[").append(paramInt).append("], uin[").append(paramString).append("], checkWifi[").append(paramBoolean1).append("], checkMutex[").append(paramBoolean2).append("], StartVideoListener[");
    if (paramStartVideoListener != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append("], extroBundle[");
      if (paramBundle == null) {
        break label139;
      }
    }
    label139:
    for (boolean bool = true;; bool = false)
    {
      QLog.w("ChatActivityUtils", 1, bool + "]");
      AudioHelper.a("ChatActivityUtils.startGroupAudioEx", paramBundle, true);
      if (a(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt, paramString)) {
        break label145;
      }
      return true;
      bool = false;
      break;
    }
    label145:
    long l = Long.valueOf(paramString).longValue();
    int j = UITools.a(paramInt);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      int i = paramBundle.getInt("MultiAVType", 0);
      bool = paramBundle.getBoolean("isVideo", false);
      if (i == 10) {
        QAVGroupConfig.a("startGroupAudioEx", paramQQAppInterface, paramString);
      }
      if (j == 2) {
        i = 1;
      }
      if (j == 1) {
        paramQQAppInterface.a().a(bool);
      }
      if (a(paramQQAppInterface, paramContext, j, paramInt, l, i)) {
        return true;
      }
      if (!paramQQAppInterface.a().a(j, l, i))
      {
        if (!a(paramQQAppInterface, paramContext, paramStartVideoListener, new sbv(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramStartVideoListener, paramBundle), paramBoolean1, bool)) {
          return true;
        }
        if (a(paramQQAppInterface, paramContext, paramStartVideoListener, new sbw(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramStartVideoListener, paramBundle), paramBoolean2, paramString, j, l, i)) {
          return true;
        }
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005776", "0X8005776", 0, 0, "", "", "", "");
      if (paramStartVideoListener != null) {
        paramStartVideoListener.b();
      }
      b(paramQQAppInterface, paramContext, paramInt, paramString, paramBundle);
      if (paramStartVideoListener != null) {
        paramStartVideoListener.c();
      }
      paramQQAppInterface.a().a(l, i);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.StartVideoListener paramStartVideoListener, Map paramMap)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, a(paramMap));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, ArrayList paramArrayList, int paramInt2, int paramInt3)
  {
    return b(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramStartVideoListener, paramArrayList, paramInt2, paramInt3, true, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt)
  {
    return a(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt, null, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt, ChatActivityUtils.StartVideoListener paramStartVideoListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      if ("startPstnC2CCall|pstnSession=" + paramPstnSessionInfo != null) {
        break label63;
      }
    }
    label63:
    for (String str1 = "null";; str1 = paramPstnSessionInfo.toString() + ", from=" + paramInt)
    {
      QLog.d("ChatActivityUtils", 2, str1);
      if (NetworkUtil.g(paramContext)) {
        break;
      }
      QQToast.a(paramContext, 0, 2131433227, 0).a();
      return false;
    }
    if (paramQQAppInterface.c())
    {
      i = 1;
      if (paramQQAppInterface.a().a().jdField_b_of_type_Int != -1)
      {
        str1 = paramQQAppInterface.a().a().jdField_a_of_type_JavaLangString;
        if ((TextUtils.isEmpty(paramPstnSessionInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(str1)) || (!str1.equals(paramPstnSessionInfo.jdField_a_of_type_JavaLangString))) {
          break label730;
        }
      }
    }
    label721:
    label730:
    for (int i = 0;; i = 1)
    {
      String str2;
      if (i != 0)
      {
        str1 = (String)PhoneNumberUtil.a(paramPstnSessionInfo.jdField_b_of_type_JavaLangString).get(1);
        str2 = (String)PhoneNumberUtil.a(paramQQAppInterface.a().a().jdField_b_of_type_JavaLangString).get(1);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.equals(str2))) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          return false;
        }
        if ((!TextUtils.isEmpty(paramPstnSessionInfo.c)) && (!TextUtils.isEmpty(paramPstnSessionInfo.jdField_b_of_type_JavaLangString)) && ((paramPstnSessionInfo.c.equals(paramPstnSessionInfo.jdField_b_of_type_JavaLangString)) || (paramPstnSessionInfo.c.contains(paramPstnSessionInfo.jdField_b_of_type_JavaLangString))))
        {
          QQToast.a(paramContext, 2131429583, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          return false;
        }
        str1 = PstnUtils.b(paramQQAppInterface, 1);
        str2 = PstnUtils.c(paramQQAppInterface, 1);
        String str3 = PstnUtils.d(paramQQAppInterface, 1);
        if (PstnUtils.a(paramQQAppInterface, 1))
        {
          if ((PstnUtils.b(paramQQAppInterface, 1)) && (paramBoolean))
          {
            DialogUtil.a(paramContext, 230, "时长不足", PstnUtils.a(paramQQAppInterface, 1), "购买时长", "继续拨打", new saf(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt, paramStartVideoListener), new saq(paramQQAppInterface, paramContext, paramStartVideoListener)).show();
            return false;
          }
          if ((paramContext instanceof BaseActivity)) {
            if ((paramInt != 4) && (paramInt != 5))
            {
              paramBoolean = true;
              if (!PstnUtils.a(paramQQAppInterface, (BaseActivity)paramContext, 2002, paramBoolean))
              {
                paramQQAppInterface = new Intent(paramContext, CallbackWaitingActivityExt.class);
                if (paramInt == 7) {
                  paramQQAppInterface.addFlags(268435456);
                }
                paramQQAppInterface.putExtra("pstn_session_info", paramPstnSessionInfo);
                paramContext.startActivity(paramQQAppInterface);
              }
            }
          }
          for (;;)
          {
            if (paramStartVideoListener != null) {
              paramStartVideoListener.c();
            }
            return true;
            paramBoolean = false;
            break;
            if (!PstnUtils.a(paramQQAppInterface, paramContext))
            {
              paramQQAppInterface = new Intent(paramContext, CallbackWaitingActivityExt.class);
              if (paramInt == 7) {
                paramQQAppInterface.addFlags(268435456);
              }
              paramQQAppInterface.putExtra("pstn_session_info", paramPstnSessionInfo);
              paramContext.startActivity(paramQQAppInterface);
            }
          }
        }
        if ((paramInt == 3) || (paramInt == 5)) {
          if ((paramPstnSessionInfo.jdField_a_of_type_Int != 0) || (((PhoneContactManager)paramQQAppInterface.getManager(10)).a(paramPstnSessionInfo.jdField_a_of_type_JavaLangString) == null)) {
            break label721;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            DialogUtil.a(paramContext, str1, str2, str3, new sbb(paramQQAppInterface, paramContext, paramInt), paramContext.getString(2131429559), new sbm(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt)).show();
          }
          for (;;)
          {
            return false;
            DialogUtil.a(paramContext, 230, str1, str2, paramContext.getString(2131428675), str3, new sbx(paramQQAppInterface, paramContext, paramInt), new sck(paramQQAppInterface, paramInt)).show();
            continue;
            PstnUtils.a(paramQQAppInterface, paramContext, 1, 8);
          }
        }
      }
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, int paramInt, String paramString)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, Activity isDestroyed!");
      return false;
    }
    if (!NetworkUtil.d(BaseApplication.getContext()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 当前网络不可用");
      QQToast.a(paramContext, 2131433117, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
    if (!VcSystemInfo.c())
    {
      QQToast.a(paramContext, 2131429011, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005769", "0X8005769", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576B", "0X800576B", 0, 0, "", "", VcSystemInfo.d(), "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576C", "0X800576C", 0, 0, "", "", VcSystemInfo.e(), "");
      return false;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576A", "0X800576A", 0, 0, "", "", "", "");
    if (!VcSystemInfo.d())
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, earlyDown so not ready!");
      QQToast.a(paramContext, 2131428815, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576D", "0X800576D", 0, 0, "", "", "", "");
      return false;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800576E", "0X800576E", 0, 0, "", "", "", "");
    if ((paramQQAppInterface.a().a()) && (!paramQQAppInterface.c()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 有系统电话");
      paramQQAppInterface = paramContext.getString(2131429045);
      paramString = paramContext.getString(2131429041);
      if ((paramContext instanceof Activity)) {}
      for (;;)
      {
        DialogUtil.b(paramContext, 230, paramString, paramQQAppInterface, 2131433029, 2131433030, new sbq(paramStartVideoListener), null).show();
        DataReport.a();
        return false;
        paramContext = BaseActivity.sTopActivity;
      }
    }
    if (!VcSystemInfo.f())
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, old engine");
      if (paramInt == 1011)
      {
        paramString = paramContext.getString(2131429248);
        DialogUtil.b(paramContext, 230, paramContext.getString(2131429041), paramString, 2131433029, 2131429056, new sbr(paramStartVideoListener), null).show();
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
        return false;
      }
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) && (paramInt == 3000))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, invalid discussId: " + paramString);
      return false;
    }
    return true;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    int i;
    if ((paramBoolean) && (paramQQAppInterface.c()))
    {
      i = paramQQAppInterface.a().b();
      int j = paramQQAppInterface.a().c();
      int k = paramQQAppInterface.a().e();
      if (((j != 1) && (j != 2)) || (((i >= 1) && (i <= 5)) || (k == 1) || (k == 2)))
      {
        QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
        return true;
      }
      if (((j == 3) || (j == 4)) && (((i < 1) || (i > 5)) && (k != 3) && (k != 4))) {
        break label440;
      }
      l1 = paramQQAppInterface.a().b();
      if ((l1 == paramLong) && (paramInt1 != 1) && (paramInt1 != 2))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityUtils", 2, "startGroupAudio-->chatUin==discussid???Why");
        }
        return true;
      }
      l2 = paramQQAppInterface.a().b();
      if (l2 > 0L)
      {
        QLog.w("ChatActivityUtils", 1, "checkMutex, chatingRelationId[" + l2 + "], chatUin[" + l1 + "], discussId[" + paramLong + "]");
        if ((l1 != paramLong) || ((paramInt1 != 2) && (paramInt1 != 1))) {
          break label287;
        }
      }
    }
    label287:
    label440:
    while (paramQQAppInterface.a().a().jdField_b_of_type_Int == -1)
    {
      long l1;
      long l2;
      return false;
      String str = paramContext.getString(2131428983);
      i = TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString + "");
      PopupDialog.a(paramContext, 230, null, str, 2131429048, 2131429053, new sbt(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramOnClickListener, paramString, i), new sbu(paramStartVideoListener, paramString, i, paramQQAppInterface));
      ReportController.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", i + "", "", "");
      return true;
    }
    QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
    QAVHrMeeting.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
    return true;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramBoolean1) && (!NetworkUtil.h(BaseApplication.getContext())) && (!NetworkUtil.f(BaseApplication.getContext())) && (VideoController.d(VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin()) <= 0))
    {
      if (!NetworkUtil.b(BaseApplication.getContext())) {
        break label206;
      }
      localObject1 = paramContext.getString(2131429041);
      localObject2 = paramContext.getString(2131429033);
    }
    for (;;)
    {
      if (NetworkUtil.c(BaseApplication.getContext()))
      {
        localObject2 = paramContext.getString(2131429041);
        if (paramBoolean2) {
          localObject1 = paramContext.getString(2131429035);
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatActivityUtils", 2, "startGAudio title or content is empty");
          }
          return false;
          localObject1 = paramContext.getString(2131429036);
        }
        else
        {
          a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131429048, 2131429053, paramOnClickListener, new sbs(paramStartVideoListener));
          return false;
          return true;
          Object localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      label206:
      localObject1 = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((1024 == paramSessionInfo.jdField_a_of_type_Int) && (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
      return false;
    }
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
    return (paramSessionInfo.jdField_a_of_type_Int == 0) && (!paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((FriendsManager)paramQQAppInterface.getManager(50)).b(paramString);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3)
  {
    boolean bool = false;
    Object localObject2 = "";
    PhoneContactManager localPhoneContactManager;
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (paramInt == 3000)
    {
      localPhoneContactManager = (PhoneContactManager)paramQQAppInterface.getManager(10);
      localObject3 = (DiscussionManager)paramQQAppInterface.getManager(52);
      localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localObject3 = ((DiscussionManager)localObject3).a(paramString);
      if (localObject3 != null)
      {
        int j = ((ArrayList)localObject3).size();
        i = 0;
        if (i < j)
        {
          localObject4 = (DiscussionMemberInfo)((ArrayList)localObject3).get(i);
          if (localObject4 != null) {
            if (((String)localObject1).equals(((DiscussionMemberInfo)localObject4).memberUin))
            {
              if (localPhoneContactManager.a() != null) {
                break label767;
              }
              bool = true;
            }
          }
        }
      }
    }
    label252:
    label767:
    for (;;)
    {
      i += 1;
      break;
      paramArrayList2.add(new InviteBaseData((DiscussionMemberInfo)localObject4));
      localObject4 = localPhoneContactManager.a(((DiscussionMemberInfo)localObject4).memberUin);
      if (localObject4 != null)
      {
        paramArrayList1.add(((PhoneContact)localObject4).unifiedCode);
        paramArrayList3.add(((PhoneContact)localObject4).mobileNo);
      }
      for (;;)
      {
        break;
        bool = true;
      }
      bool = true;
      continue;
      localObject1 = localObject2;
      if (!paramBoolean)
      {
        localObject3 = PstnUtils.a(paramQQAppInterface, paramString, 3000);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = PstnUtils.a((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject2 = ((ArrayList)localObject3).iterator();
            localObject1 = "";
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (AVPhoneUserInfo)((Iterator)localObject2).next();
              if (!a(localPhoneContactManager, ((AVPhoneUserInfo)localObject3).telInfo.mobile, paramArrayList2))
              {
                paramArrayList2.add(new InviteBaseData((AVPhoneUserInfo)localObject3, paramQQAppInterface));
                paramArrayList1.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
                paramArrayList3.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
              }
              if (!QLog.isDevelopLevel()) {
                break label764;
              }
              localObject1 = (String)localObject1 + String.format("\n\rAVPhoneUserInfo: %s", new Object[] { localObject3 });
            }
          }
        }
      }
      for (;;)
      {
        break label252;
        bool = true;
        break;
        while (QLog.isDevelopLevel())
        {
          paramQQAppInterface = (String)localObject1 + String.format("\n\rphoneList[%s]", new Object[] { Integer.valueOf(paramArrayList1.size()) });
          paramArrayList1 = paramArrayList1.iterator();
          for (;;)
          {
            if (paramArrayList1.hasNext())
            {
              localObject1 = (String)paramArrayList1.next();
              paramQQAppInterface = paramQQAppInterface + String.format("\n\rphone: %s", new Object[] { localObject1 });
              continue;
              bool = true;
              localObject1 = localObject2;
              break;
            }
          }
          paramQQAppInterface = paramQQAppInterface + String.format("\n\rselectedList[%s]", new Object[] { Integer.valueOf(paramArrayList3.size()) });
          paramArrayList1 = paramArrayList3.iterator();
          while (paramArrayList1.hasNext())
          {
            paramArrayList3 = (String)paramArrayList1.next();
            paramQQAppInterface = paramQQAppInterface + String.format("\n\rselected: %s", new Object[] { paramArrayList3 });
          }
          paramQQAppInterface = paramQQAppInterface + String.format("\n\rinviteList[%s]", new Object[] { Integer.valueOf(paramArrayList2.size()) });
          paramArrayList1 = paramArrayList2.iterator();
          while (paramArrayList1.hasNext())
          {
            paramArrayList2 = (InviteBaseData)paramArrayList1.next();
            paramQQAppInterface = paramQQAppInterface + String.format("\n\rinvite: %s", new Object[] { paramArrayList2 });
          }
          QLog.d("ChatActivityUtils", 4, String.format("checkDiscussMemberNoPhone, onlyMembers[%s], uinType[%s], uin[%s], hasNoPhone[%s], %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool), paramQQAppInterface }));
        }
        return bool;
      }
    }
  }
  
  public static boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramTroopMemberInfo.alias == null) || (paramTroopMemberInfo.alias.length() <= 0))
    {
      bool1 = bool2;
      if (paramTroopMemberInfo.memberuin != null)
      {
        bool1 = bool2;
        if (paramTroopMemberInfo.memberuin.trim().length() > 0)
        {
          bool1 = bool2;
          if (paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase(String.valueOf(0))) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean a(PhoneContactManager paramPhoneContactManager, String paramString, List paramList)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramPhoneContactManager = paramPhoneContactManager.b(paramString);
    if ((paramPhoneContactManager != null) && (!TextUtils.isEmpty(paramPhoneContactManager.uin)) && (!paramPhoneContactManager.uin.equals("0")))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (InviteBaseData)paramString.next();
        if ((paramList.jdField_a_of_type_JavaLangString != null) && (paramList.jdField_a_of_type_JavaLangString.equals(paramPhoneContactManager.uin))) {
          return true;
        }
      }
    }
    return false;
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
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    Object localObject;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = BaseApplication.getContext();
        } while (localObject == null);
        localSharedPreferences = ((Context)localObject).getSharedPreferences("secondHandSharePre", 0);
      } while (localSharedPreferences == null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1).append(paramString2).append(paramString3);
    } while (localSharedPreferences.contains(((StringBuilder)localObject).toString()));
    paramString1 = localSharedPreferences.edit();
    paramString1.putInt(((StringBuilder)localObject).toString(), 0);
    paramString1.commit();
    return true;
  }
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = null;
      return paramString;
    }
    paramString = paramString.toUpperCase();
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, paramJSONObject.toString() + "");
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("url"))
        {
          localObject1 = paramJSONObject.getString("url");
          if (!paramJSONObject.has("picture")) {
            break label588;
          }
          str1 = paramJSONObject.getString("picture");
          if (!paramJSONObject.has("title")) {
            break label594;
          }
          str2 = paramJSONObject.getString("title");
          if (!paramJSONObject.has("summary")) {
            break label600;
          }
          str3 = paramJSONObject.getString("summary");
          if (!paramJSONObject.has("brief")) {
            break label606;
          }
          localObject2 = paramJSONObject.getString("brief");
          if (!paramJSONObject.has("layout")) {
            break label612;
          }
          i = paramJSONObject.getInt("layout");
          if (!paramJSONObject.has("source")) {
            break label617;
          }
          str4 = paramJSONObject.getString("source");
          if (i == 6)
          {
            if (!paramJSONObject.has("price")) {
              break label623;
            }
            str5 = paramJSONObject.getString("price");
            if (!paramJSONObject.has("prunit")) {
              break label629;
            }
            str6 = paramJSONObject.getString("prunit");
            if (!paramJSONObject.has("icon")) {
              break label635;
            }
            str7 = paramJSONObject.getString("icon");
            if (!paramJSONObject.has("srcaction")) {
              break label641;
            }
            str8 = paramJSONObject.getString("srcaction");
            if (!paramJSONObject.has("action")) {
              break label647;
            }
            str9 = paramJSONObject.getString("action");
            if (!paramJSONObject.has("a_actionData")) {
              break label653;
            }
            str10 = paramJSONObject.getString("a_actionData");
            if (!paramJSONObject.has("i_actionData")) {
              break label659;
            }
            str11 = paramJSONObject.getString("i_actionData");
            if (!paramJSONObject.has("appid")) {
              break label665;
            }
            paramJSONObject = paramJSONObject.getString("appid");
            localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(41).a((String)localObject2).a(7);
            if (TextUtils.isEmpty(paramJSONObject)) {
              break label671;
            }
            l = Long.parseLong(paramJSONObject);
            paramJSONObject = ((AbsShareMsg.Builder)localObject2).a(l).a(str9, (String)localObject1, null, null, null).a(str4, str7).b(str8, null, null, str10, str11).b((String)localObject1).a();
            localObject1 = StructMsgElementFactory.a(i);
            ((AbsStructMsgItem)localObject1).a(str1, str2, str3, str5, str6, 0);
            paramJSONObject.addItem((AbsStructMsgElement)localObject1);
            return paramJSONObject.getBytes();
          }
          paramJSONObject = paramJSONObject.getString("puin");
          paramJSONObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(1).a((String)localObject2).c((String)localObject1).a(str4, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
          localObject1 = StructMsgElementFactory.a(2);
          ((AbsStructMsgItem)localObject1).a(str1, str2, str3);
          paramJSONObject.addItem((AbsStructMsgElement)localObject1);
          paramJSONObject = paramJSONObject.getBytes();
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("ChatActivityUtils", 4, "createSecondHandProductInfoStructMsg---JSONException");
        }
        return null;
      }
      Object localObject1 = null;
      continue;
      label588:
      String str1 = null;
      continue;
      label594:
      String str2 = null;
      continue;
      label600:
      String str3 = null;
      continue;
      label606:
      Object localObject2 = null;
      continue;
      label612:
      int i = 2;
      continue;
      label617:
      String str4 = null;
      continue;
      label623:
      String str5 = null;
      continue;
      label629:
      String str6 = null;
      continue;
      label635:
      String str7 = null;
      continue;
      label641:
      String str8 = null;
      continue;
      label647:
      String str9 = null;
      continue;
      label653:
      String str10 = null;
      continue;
      label659:
      String str11 = null;
      continue;
      label665:
      paramJSONObject = "";
      continue;
      label671:
      long l = -1L;
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
    Object localObject = Cipher.getInstance("AES/ECB/NoPadding");
    ((Cipher)localObject).init(2, paramArrayOfByte2);
    paramArrayOfByte1 = ((Cipher)localObject).doFinal(paramArrayOfByte1);
    return paramArrayOfByte1;
    while (i < 16)
    {
      localObject[i] = paramArrayOfByte2[i];
      i += 1;
    }
  }
  
  public static MessageRecord b(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if (MsgProxyUtils.g(paramSessionInfo.msgtype)) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static String b(int paramInt)
  {
    int i = 999;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return String.valueOf(paramInt);
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 2;
      continue;
      paramInt = 4;
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    int j = 1;
    int k = 0;
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramString2.length();
        if (m >= 16) {
          break label203;
        }
        i = 0;
        str = paramString2;
        if (i < 16 - m)
        {
          paramString2 = paramString2 + "$";
          i += 1;
          continue;
        }
        paramString1 = a(paramString1 + "MasPlay", 32).getBytes("UTF-8");
        paramString2 = new byte[16];
        i = k;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString1 = new SecretKeySpec(paramString2, "AES");
      paramString2 = Cipher.getInstance("AES/ECB/NoPadding");
      paramString2.init(1, paramString1);
      paramString1 = paramString2.doFinal(str.getBytes("utf-8"));
      paramString2 = new StringBuffer();
      if (paramString1.length > 0)
      {
        paramString2.append(paramString1[0]);
        i = j;
        if (i < paramString1.length)
        {
          paramString2.append(",");
          paramString2.append(paramString1[i]);
          i += 1;
          continue;
        }
      }
      paramString1 = paramString2.toString();
      return paramString1;
      label203:
      String str = paramString2;
      if (m > 16)
      {
        return null;
        while (i < 16)
        {
          paramString2[i] = paramString1[i];
          i += 1;
        }
      }
    }
  }
  
  public static String b(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, a(paramString + "MasPlay", 32).getBytes("UTF-8"));
      paramString = localObject;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte, "UTF-8").replace("$", "");
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static void b()
  {
    if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131433425), paramContext.getString(2131433426), new scr(), null).show();
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new QQToastNotifier(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131558448), 0, paramInt2);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    long l = paramQQAppInterface.a().b();
    int i = paramQQAppInterface.a().a();
    int j = paramQQAppInterface.a().b(l);
    QLog.d("ChatActivityUtils", 1, "sendExitBroadcast finalType = " + paramInt1 + ",finalAvType = " + paramInt2 + ",chattingType = " + i);
    if ((paramInt1 == 1) || (i == 1))
    {
      if ((j != 2) || (paramInt2 == 2)) {
        break label113;
      }
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
    label113:
    while ((j == 2) || (paramInt2 != 2)) {
      return;
    }
    paramContext.sendBroadcast(new Intent("com.tencent.av.EXIT_VIDEO_PROCESS"));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    DiscussionInfo localDiscussionInfo;
    int i;
    if (paramInt == 3000)
    {
      localDiscussionInfo = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
      if (localDiscussionInfo != null) {
        if (localDiscussionInfo.isPSTNConf())
        {
          AudioHelper.b("发起音视频_获取会议id");
          ChatActivityUtils.ConfIdownloadTask.a("ChatActivityUtils", localDiscussionInfo.uin, new sci(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        c(paramQQAppInterface, paramContext, paramInt, paramString, paramBundle);
      }
      return;
      if ((localDiscussionInfo.isDiscussHrMeeting()) && ((paramBundle == null) || (!paramBundle.containsKey("MeetingStasks"))))
      {
        AudioHelper.b("发起音视频_获取hr信息");
        QAVHrMeeting.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin(), new scj(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, String paramString5, Map paramMap, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    int i;
    long l;
    int j;
    label726:
    label756:
    Object localObject1;
    Object localObject2;
    if (!paramQQAppInterface.c())
    {
      if (!VcSystemInfo.c())
      {
        QLog.d("ChatActivityUtils", 1, "startVideo device not support!");
        QQToast.a(paramContext, 2131428805, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005756", "0X8005756", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005758", "0X8005758", 0, 0, "", "", VcSystemInfo.d(), "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005759", "0X8005759", 0, 0, "", "", VcSystemInfo.e(), "");
        return true;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005757", "0X8005757", 0, 0, "", "", "", "");
      if (!VcSystemInfo.d())
      {
        QLog.d("ChatActivityUtils", 1, "startVideo earlyDown so not ready!");
        QQToast.a(paramContext, 2131428815, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575A", "0X800575A", 0, 0, "", "", "", "");
        return true;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575B", "0X800575B", 0, 0, "", "", "", "");
      if ((!paramBoolean1) && (!VcSystemInfo.b()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo sdk not support Video!");
        }
        QQToast.a(paramContext, 2131428807, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575C", "0X800575C", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575D", "0X800575D", 0, 0, "", "", VcSystemInfo.d(), "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575E", "0X800575E", 0, 0, "", "", VcSystemInfo.e(), "");
        return true;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800575F", "0X800575F", 0, 0, "", "", "", "");
      if (paramQQAppInterface.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo phone is calling!");
        }
        paramString1 = paramContext.getString(2131429045);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131429041), paramString1, 2131433029, 2131433030, new sau(paramStartVideoListener, paramBoolean1), null);
        DataReport.a(paramBoolean1);
        if (paramInt == 1024) {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
        }
        return false;
      }
      if (((paramInt == 1006) && (!a(paramQQAppInterface, paramString1))) || (paramInt == 1024) || (paramInt == 1011))
      {
        new VcSystemInfo();
        VcSystemInfo.a();
        i = VcSystemInfo.f();
        l = VcSystemInfo.c();
        j = Build.VERSION.SDK_INT;
        if ((i < 3) || (l / 1000L < 800L) || (j < 9))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
          }
          if (paramMap != null)
          {
            paramString1 = (String)paramMap.get("chat_type");
            if (paramInt != 1011) {
              break label756;
            }
            paramString2 = paramContext.getString(2131429248);
            PopupDialog.a(paramContext, 230, paramContext.getString(2131429041), paramString2, 2131433029, 2131429056, new sav(paramStartVideoListener), null);
            if (!paramString1.equals("randomc2c")) {
              break label726;
            }
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            return false;
            paramString1 = "";
            break;
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
          }
          QQToast.a(paramContext, 2131429086, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          if (paramBoolean1)
          {
            ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            if (paramInt == 1024) {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            }
          }
          return true;
        }
      }
      if ((paramBoolean1) && (!ConfigSystemImpl.a(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo audio disabled!");
        }
        paramString1 = paramContext.getString(2131429046);
        PopupDialog.a(paramContext, 230, paramContext.getString(2131429041), paramString1, 2131433029, 2131429056, new saw(paramStartVideoListener), null);
        if (paramBoolean1)
        {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
          if (paramInt == 1024) {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
          }
        }
        return false;
      }
      if ((paramInt == 1010) && (!paramQQAppInterface.a().a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
        }
        paramQQAppInterface = PopupDialog.a(paramContext, 230, null, paramContext.getString(2131429043), 2131429048, 2131429058, new sax(paramQQAppInterface, paramBoolean1, paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5), new say(paramBoolean1, paramStartVideoListener));
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setOnCancelListener(new saz(paramBoolean1, paramStartVideoListener));
        }
        return false;
      }
      if ((paramBoolean2) && (a(paramQQAppInterface, paramInt, paramString1, paramString3)) && (paramInt != 1024))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo check shiled msg!");
        }
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
        }
        localObject1 = paramContext.getString(2131429042);
        paramQQAppInterface = PopupDialog.a(paramContext, 230, paramContext.getString(2131429041), (String)localObject1, 2131429048, 2131429058, new sba(paramQQAppInterface, paramInt, paramString1, paramString3, paramBoolean1, paramContext, paramString2, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5), new sbc(paramBoolean1, paramStartVideoListener));
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setOnCancelListener(new sbd(paramBoolean1, paramStartVideoListener));
        }
        return false;
      }
      if (!NetworkUtil.d(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo network not support!");
        }
        QQToast.a(paramContext, 2131433117, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        if (paramBoolean1)
        {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
          if (paramInt == 1024) {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
          }
        }
        return true;
      }
      paramBoolean2 = NetworkUtil.h(paramContext);
      if ((paramInt == 1024) && (!paramBoolean2) && (NetworkUtil.a(paramContext) == 2))
      {
        ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        QQToast.a(paramContext, 2131429034, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
        return false;
      }
      if ((!paramBoolean3) || (paramBoolean2) || (NetworkUtil.f(paramContext))) {
        break label3161;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo check wifi!");
      }
      localObject1 = VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin();
      if (paramMap == null) {
        break label3575;
      }
      localObject2 = (String)paramMap.get("chat_type");
      if ((localObject2 != null) && ((((String)localObject2).equals("randomc2c")) || (((String)localObject2).equals("randomgroup")))) {
        localObject1 = VideoController.c + paramQQAppInterface.getCurrentAccountUin();
      }
    }
    label3161:
    label3560:
    label3575:
    for (;;)
    {
      if (VideoController.d((String)localObject1) > 0)
      {
        b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, false, false, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5, false);
        return true;
        if ("guildgroup".equals(localObject2)) {
          localObject1 = VideoController.d + paramQQAppInterface.getCurrentAccountUin();
        }
      }
      else
      {
        i = NetworkUtil.a(paramContext);
        Object localObject4;
        if (i == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo is 2G!");
          }
          localObject1 = paramContext.getString(2131429041);
          localObject2 = paramContext.getString(2131429033);
          if (!paramBoolean1) {
            break label3560;
          }
          ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
          localObject4 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject4;
        }
        for (;;)
        {
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatActivityUtils", 2, "startVideo title or content is empty");
            }
            return true;
            if ((i == 3) || (i == 4))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils", 2, "startVideo is 3G or 4G!");
              }
              localObject1 = paramContext.getString(2131429041);
              if (paramBoolean1)
              {
                localObject2 = paramContext.getString(2131429036);
                ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
                localObject4 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject4;
                continue;
              }
              localObject4 = paramContext.getString(2131429035);
              localObject2 = localObject1;
              localObject1 = localObject4;
            }
          }
          else
          {
            paramQQAppInterface = a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131429048, 2131429053, new sbe(paramBoolean1, i, paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean4, paramBoolean5), new sbf(paramBoolean1, i, paramStartVideoListener));
            if (paramQQAppInterface != null) {
              paramQQAppInterface.setOnCancelListener(new sbg(paramBoolean1, i, paramStartVideoListener));
            }
            return false;
            i = paramQQAppInterface.a().e();
            j = paramQQAppInterface.a().b();
            int k = paramQQAppInterface.a().c();
            if (paramMap != null)
            {
              localObject1 = (String)paramMap.get("chat_type");
              if ((localObject1 != null) && ((((String)localObject1).equals("randomgroup")) || (((String)localObject1).equals("randomc2c"))))
              {
                localObject4 = (String)paramMap.get("session_name");
                l = -1L;
                localObject2 = localObject1;
                localObject1 = localObject4;
              }
            }
            for (;;)
            {
              if (((k == 1) || (k == 2)) && (j >= 1) && (j <= 5))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
                }
                if ((localObject1 == null) || (!((String)localObject2).equals("randomc2c")) || (!((String)localObject1).equals(paramQQAppInterface.a().a())))
                {
                  QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
                  a(paramQQAppInterface, paramMap);
                  return true;
                  if (!"guildgroup".equals(localObject1)) {
                    break label3518;
                  }
                  try
                  {
                    l = Long.parseLong((String)paramMap.get("group_id"));
                    localObject4 = null;
                    localObject2 = localObject1;
                    localObject1 = localObject4;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    localObject4 = null;
                    localObject3 = localObject1;
                    l = -1L;
                    localObject1 = localObject4;
                  }
                }
              }
              else
              {
                if ((paramBoolean5) && ((k == 3) || (k == 4)) && (j >= 1) && (j <= 5))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
                  }
                  if (((!TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.equals((CharSequence)localObject1, paramQQAppInterface.a().a()))) || (("guildgroup".equals(localObject3)) && (l > 0L) && (l == paramQQAppInterface.a().c()))) {
                    i = 1;
                  }
                }
                while (i == 0)
                {
                  PopupDialog.a(paramContext, 230, null, paramContext.getString(2131428983), 2131429048, 2131429053, new sbh(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramMap, paramBoolean4), new sbi(paramStartVideoListener));
                  a(paramQQAppInterface, paramMap);
                  return false;
                  i = 0;
                  continue;
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ChatActivityUtils", 2, "startVideo is calling!");
                    }
                    if ((paramBoolean1) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().c()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().c()))) || ((paramInt == 1006) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().d()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().d())))))))
                    {
                      if (paramStartVideoListener != null) {
                        paramStartVideoListener.b();
                      }
                      if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
                      {
                        paramString1 = new Intent(paramContext, AVActivity.class);
                        paramString1.addFlags(262144);
                        paramString1.addFlags(268435456);
                        paramString1.putExtra("sessionType", 3);
                        paramString1.putExtra("GroupId", paramQQAppInterface.a().c());
                        paramString1.putExtra("isDoubleVideoMeeting", true);
                        paramContext.startActivity(paramString1);
                        if (paramStartVideoListener != null) {
                          paramStartVideoListener.c();
                        }
                      }
                    }
                    for (;;)
                    {
                      return true;
                      a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramMap, false);
                      break;
                      QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
                      a(paramQQAppInterface, paramMap);
                    }
                  }
                  if (i == 2)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("ChatActivityUtils", 2, "startVideo is calling!");
                    }
                    if ((!paramBoolean1) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().c()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().c()))) || ((paramInt == 1006) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().d()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().d())))))))
                    {
                      if (paramStartVideoListener != null) {
                        paramStartVideoListener.b();
                      }
                      if (paramQQAppInterface.a().b(paramQQAppInterface.a().c()))
                      {
                        paramString1 = new Intent(paramContext, AVActivity.class);
                        paramString1.addFlags(262144);
                        paramString1.addFlags(268435456);
                        paramString1.putExtra("sessionType", 3);
                        paramString1.putExtra("GroupId", paramQQAppInterface.a().c());
                        paramString1.putExtra("isDoubleVideoMeeting", true);
                        paramContext.startActivity(paramString1);
                        if (paramStartVideoListener != null) {
                          paramStartVideoListener.c();
                        }
                      }
                    }
                    for (;;)
                    {
                      return true;
                      a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramMap, false);
                      break;
                      QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
                      a(paramQQAppInterface, paramMap);
                    }
                  }
                  if ((paramBoolean5) && ((i == 3) || (i == 4)))
                  {
                    if (paramQQAppInterface.a().b() > 0L)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ChatActivityUtils", 2, "startVideo is multi calling!");
                      }
                      PopupDialog.a(paramContext, 230, null, paramContext.getString(2131428983), 2131429048, 2131429053, new sbj(paramInt, paramMap, paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramStartVideoListener, paramString5, paramBoolean4), new sbk(paramStartVideoListener));
                      a(paramQQAppInterface, paramMap);
                      return false;
                    }
                  }
                  else if (paramQQAppInterface.a().a().jdField_b_of_type_Int != -1)
                  {
                    QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
                    a(paramQQAppInterface, paramMap);
                    return true;
                  }
                }
              }
              localObject1 = (FriendsManager)paramQQAppInterface.getManager(50);
              if ((paramInt == 0) && (!((FriendsManager)localObject1).b(paramString1)))
              {
                if (paramBoolean1) {}
                for (paramInt = 2131429217;; paramInt = 2131429216)
                {
                  paramQQAppInterface = paramContext.getString(paramInt);
                  DialogUtil.b(paramContext, 230, paramContext.getString(2131429041), paramQQAppInterface, 2131433029, 2131429057, new sbl(), null).show();
                  return false;
                }
              }
              if ((paramBoolean4) && (!paramBoolean1) && (paramInt != 1) && (paramInt != 3000) && (paramInt != 9500) && (!paramQQAppInterface.a().d(paramString1)) && (AVNotifyCenter.f(paramQQAppInterface.getCurrentAccountUin())))
              {
                if (AVNotifyCenter.e(paramQQAppInterface.getCurrentAccountUin()))
                {
                  jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(paramContext, 230, 2130969266, null, paramContext.getString(2131429037), 2131428677, 2131428674, new sbn(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean5), new sbo(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramStartVideoListener, paramString5, paramMap, paramBoolean5));
                  jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
                  ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005014", "0X8005014", 0, 0, "", "", "", "");
                  return false;
                }
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800501B", "0X800501B", 0, 0, "", "", "", "");
              }
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005766", "0X8005766", 0, 0, "", "", "", "");
              if (paramStartVideoListener != null) {
                paramStartVideoListener.b();
              }
              a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramMap, paramBoolean6);
              if (paramStartVideoListener != null) {
                paramStartVideoListener.c();
              }
              return true;
              localObject4 = null;
              localObject3 = localObject1;
              l = -1L;
              localObject1 = localObject4;
              continue;
              localObject1 = null;
              localObject3 = null;
              l = -1L;
            }
          }
          localObject1 = null;
          Object localObject3 = null;
          continue;
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.StartVideoListener paramStartVideoListener, ArrayList paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (!NetworkUtil.g(paramContext))
    {
      QQToast.a(paramContext, 0, 2131433227, 0).a();
      return false;
    }
    Object localObject2 = PstnUtils.b(paramQQAppInterface, 2);
    String str1 = PstnUtils.c(paramQQAppInterface, 2);
    String str2 = PstnUtils.d(paramQQAppInterface, 2);
    Object localObject3 = (PstnManager)paramQQAppInterface.getManager(142);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("PstnLevel", "LEVEL2");
    ((Map)localObject1).put("PLACE", "CALL_CREATE");
    long l2 = 0L;
    long l1;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      if (paramQQAppInterface.a().a().containsKey(Long.valueOf(l1)))
      {
        String str3 = (String)paramQQAppInterface.a().a().get(Long.valueOf(l1));
        paramQQAppInterface.a().a().remove(Long.valueOf(l1));
        ((Map)localObject1).put("CREATE_PLACE", str3);
      }
      if ((((PstnManager)localObject3).a() == 0) || (paramInt2 == 0))
      {
        ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
        return a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatActivityUtils", 2, "NumberFormatException uin = " + paramString);
          l1 = l2;
        }
      }
    }
    ArrayList localArrayList;
    if (paramInt2 == 1)
    {
      ((Map)localObject1).put("ipPstnEnterType", String.valueOf(paramInt2));
      localObject3 = new ArrayList();
      localArrayList = new ArrayList();
      if (paramArrayList != null) {
        ((ArrayList)localObject3).addAll(paramArrayList);
      }
      if (PstnUtils.a(paramQQAppInterface, 2)) {
        if (!PstnUtils.a(paramQQAppInterface, paramContext))
        {
          paramArrayList = new ArrayList();
          paramBoolean3 = true;
          if (paramInt3 != 2) {
            break label1371;
          }
          paramBoolean3 = false;
        }
      }
    }
    label768:
    label847:
    label854:
    label1371:
    for (paramInt3 = 2131438405;; paramInt3 = 2131438404)
    {
      if (!a(paramQQAppInterface, paramBoolean3, paramInt1, paramString, (ArrayList)localObject3, paramArrayList, localArrayList))
      {
        if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
          ((Map)localObject1).put("PhoneNumberList", PstnUtils.b((ArrayList)localObject3));
        }
        if ((PstnUtils.b(paramQQAppInterface, 2)) && (paramBoolean5))
        {
          DialogUtil.a(paramContext, 230, "时长不足", PstnUtils.a(paramQQAppInterface, 2), "购买时长", "继续拨打", new scv(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1), new sag(paramQQAppInterface, paramContext)).show();
          return false;
        }
        a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
      }
      for (;;)
      {
        return false;
        PhoneContactSelectActivity.a(paramContext, paramInt2, localArrayList, paramInt3);
        return true;
        if ((paramInt3 == 6) || (paramInt3 == 3)) {
          DialogUtil.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131428675), str2, new sah(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt3), new sai(paramQQAppInterface, paramInt3)).show();
        }
        for (;;)
        {
          return false;
          PstnUtils.a(paramQQAppInterface, paramContext, 2, 12);
        }
        if (PstnUtils.a(paramQQAppInterface, 2))
        {
          localObject2 = (PhoneContactManagerImp)paramQQAppInterface.getManager(10);
          if ((localObject2 != null) && (((PhoneContactManagerImp)localObject2).c() >= 9))
          {
            localObject2 = ((PstnManager)localObject3).a(paramQQAppInterface.getCurrentAccountUin());
            int i;
            if ((localObject2 != null) && (((PstnCardInfo)localObject2).pstn_multi_call_time > 0))
            {
              i = 1;
              int j = UITools.a(paramInt1);
              l1 = Long.valueOf(paramString).longValue();
              if ((paramQQAppInterface.a().a(j, l1)) || (((PstnManager)localObject3).d() != 1) || (((PstnManager)localObject3).b()) || ((!a(paramQQAppInterface, paramInt1, paramString, paramArrayList)) && (NetworkUtil.a(paramContext.getApplicationContext()) != 2)) || (i == 0) || (6 == paramInt3) || (!paramBoolean4)) {
                break label861;
              }
              localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131438431);
              localObject2 = paramQQAppInterface.getApplication().getResources().getString(2131438432);
              str2 = ((PstnManager)localObject3).a("pstn_multi_trans_wording");
              str1 = ((PstnManager)localObject3).a("pstn_multi_trans_check_wording");
              if (!TextUtils.isEmpty(str2)) {
                break label847;
              }
              if (!TextUtils.isEmpty(str1)) {
                break label854;
              }
            }
            for (;;)
            {
              DialogUtil.a(paramContext, 230, "确认呼叫方式", (String)localObject1, (String)localObject2, "取消", "呼叫", null, new saj((PstnManager)localObject3, paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramStartVideoListener, paramArrayList, paramInt2, paramInt3, paramBoolean5), new sak(paramStartVideoListener, paramQQAppInterface)).show();
              return false;
              i = 0;
              break;
              localObject1 = str2;
              break label768;
              localObject2 = str1;
            }
            label861:
            if ((PstnUtils.b(paramQQAppInterface, 2)) && (paramBoolean5))
            {
              DialogUtil.a(paramContext, 230, "时长不足", PstnUtils.a(paramQQAppInterface, 2), "购买时长", "继续拨打", new sal(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramStartVideoListener, paramArrayList, paramInt2, paramInt3, paramBoolean4), new sam(paramQQAppInterface, paramContext)).show();
              return false;
            }
            if (paramInt2 == 4) {
              ((Map)localObject1).put("ipPstnEnterType", String.valueOf(4));
            }
            for (;;)
            {
              if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
                ((Map)localObject1).put("PhoneNumberList", PstnUtils.b(paramArrayList));
              }
              a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
              break;
              ((Map)localObject1).put("ipPstnEnterType", String.valueOf(2));
            }
          }
          if ((paramInt2 == 3) && ((paramArrayList == null) || (paramArrayList.size() == 0)))
          {
            ((Map)localObject1).put("PstnLevel", "LEVEL2");
            ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
            a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
          }
          else
          {
            PstnUtils.a(paramQQAppInterface, paramContext);
          }
        }
        else if ((paramInt3 == 3) || (paramInt3 == 6))
        {
          localObject3 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
          if ((localObject3 != null) && (((List)localObject3).size() == 1) && (((DiscussionMemberInfo)((List)localObject3).get(0)).memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            DialogUtil.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131428675), str2, new san(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt3), new sao(paramQQAppInterface, paramInt3)).show();
          }
          else if ((paramArrayList != null) && (paramArrayList.size() > 0))
          {
            DialogUtil.a(paramContext, (String)localObject2, str1, str2, new sap(paramQQAppInterface, paramContext, paramStartVideoListener, paramInt3), paramContext.getString(2131429560), new sar((Map)localObject1, paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, paramInt3)).show();
          }
          else
          {
            ((Map)localObject1).put("PstnLevel", "LEVEL2");
            ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
            a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramStartVideoListener, (Map)localObject1);
          }
        }
        else
        {
          DialogUtil.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131428675), str2, new sas(paramQQAppInterface, paramContext, paramStartVideoListener), new sat()).show();
        }
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool2 = false;
    int i = paramSessionInfo.jdField_a_of_type_Int;
    boolean bool1 = bool2;
    if (AIOTopRightButtonConfig.a().a(paramQQAppInterface.getCurrentAccountUin())) {
      if ((i != 0) && (i != 10002) && (i != 1000) && (i != 1004) && (i != 3000) && (i != 1006) && (i != 1021) && (i != 1010) && (i != 1001))
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
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        if (paramString.startsWith(jdField_a_of_type_ArrayOfJavaLangString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void c()
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, uinType[" + paramInt + "], uin[" + paramString + "]");
    AudioHelper.a("ChatActivityUtils", paramBundle, true);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (paramString == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    long l1 = Long.parseLong(paramString);
    int i = UITools.a(paramInt);
    int j = localBundle.getInt("MultiAVType", 0);
    if (i == 2) {
      j = 1;
    }
    for (;;)
    {
      paramBundle = localBundle.getString("jump_from");
      localIntent.putExtras(localBundle);
      Object localObject1;
      int m;
      int k;
      if ((("gvideo".equals(paramBundle)) || ("gvideo_h5".equals(paramBundle))) && (paramInt == 1))
      {
        i = 1;
        if (paramInt == 3000)
        {
          localObject1 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(paramString);
          if (localObject1 == null) {
            break label984;
          }
          m = ((ArrayList)localObject1).size();
          paramBundle = new long[m];
          k = 0;
        }
      }
      else
      {
        while (k < m)
        {
          Object localObject2 = (DiscussionMemberInfo)((ArrayList)localObject1).get(k);
          if (localObject2 != null) {
            paramBundle[k] = Long.valueOf(((DiscussionMemberInfo)localObject2).memberUin).longValue();
          }
          k += 1;
          continue;
          long l2 = paramQQAppInterface.a().a(i, l1);
          paramBundle = "memberNum[" + l2;
          if (l2 > 0L)
          {
            k = paramQQAppInterface.a().b(l1);
            localObject1 = paramBundle + "], srcAVType[" + k;
            if ((j != k) && (paramInt == 1))
            {
              paramBundle = paramQQAppInterface.a().a(l1, j);
              localObject1 = (String)localObject1 + "], VideoRoomInfo[" + paramBundle;
              if ((paramBundle != null) && (paramBundle.jdField_b_of_type_Int == j) && (paramBundle.jdField_a_of_type_Int > 0))
              {
                i = 1;
                paramBundle = (String)localObject1 + "], 1.TYPE_GAUDIO_STATUS_ENTER";
              }
            }
          }
          for (;;)
          {
            QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, " + paramBundle);
            break;
            i = 0;
            paramBundle = (String)localObject1 + "], 2.TYPE_GAUDIO_STATUS_CREATE";
            continue;
            if (paramQQAppInterface.a().a(i, l1))
            {
              i = 2;
              paramBundle = (String)localObject1 + "], 3.TYPE_GAUDIO_STATUS_CHATING";
            }
            else
            {
              i = 1;
              paramBundle = (String)localObject1 + "], 4.TYPE_GAUDIO_STATUS_ENTER";
              continue;
              k = 0;
              localObject1 = paramBundle + "], 5.TYPE_GAUDIO_STATUS_CREATE";
              paramBundle = (Bundle)localObject1;
              i = k;
              if (j == 2)
              {
                localObject2 = paramQQAppInterface.a().a(l1, 2);
                paramBundle = (Bundle)localObject1;
                i = k;
                if (localObject2 != null)
                {
                  paramBundle = (Bundle)localObject1;
                  i = k;
                  if (((AVNotifyCenter.VideoRoomInfo)localObject2).jdField_a_of_type_Int > 0)
                  {
                    i = 1;
                    paramBundle = (String)localObject1 + "], 6.TYPE_GAUDIO_STATUS_CREATE";
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localIntent.putExtra("DiscussUinList", paramBundle);
        do
        {
          localIntent.putExtra("sessionType", 3);
          localIntent.putExtra("uin", paramString);
          localIntent.putExtra("uinType", paramInt);
          localIntent.putExtra("Type", i);
          localIntent.putExtra("GroupId", paramString);
          localIntent.putExtra("MultiAVType", j);
          k = localBundle.getInt("MeetingStasks", -1);
          if (k >= 0) {
            paramQQAppInterface.a().c(k);
          }
          if (j != 2) {
            localIntent.setClass(paramContext, AVActivity.class);
          }
          if ((!localBundle.containsKey("ipPstnEnterType")) || (localBundle.getInt("ipPstnEnterType") != 1) || (!paramQQAppInterface.c())) {
            break;
          }
          QQToast.a(paramContext, 2131428992, 1).b(paramContext.getResources().getDimensionPixelSize(2131558448));
          return;
        } while (paramInt != 1);
        paramBundle = (TroopManager)paramQQAppInterface.getManager(51);
        if ((paramBundle != null) && (paramBundle.a(paramString) == null)) {}
        for (boolean bool = false;; bool = true)
        {
          localIntent.putExtra("troopmember", bool);
          break;
          a(paramQQAppInterface, localIntent);
          GVideoUpdateUtil.a(paramContext, paramString, j, new scl(i, paramInt, paramQQAppInterface, (QCallFacade)paramQQAppInterface.getManager(37), l1, localIntent, l1, "start_group_audio_time" + paramQQAppInterface.getCurrentAccountUin()));
          return;
        }
        label984:
        paramBundle = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */