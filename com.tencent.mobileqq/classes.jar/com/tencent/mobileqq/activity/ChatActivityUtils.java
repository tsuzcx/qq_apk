package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acnh;
import aczy;
import adlp;
import admp;
import admq;
import admr;
import adms;
import admt;
import admu;
import admv;
import admw;
import admx;
import admy;
import admz;
import adna;
import adnb;
import adnc;
import adnd;
import adne;
import adnf;
import adng;
import adnh;
import adni;
import adnj;
import adnk;
import adnm;
import adnn;
import aftr;
import ahfa;
import ahwv;
import aijq;
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
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import antp;
import anud;
import anvk;
import anvx;
import anxi;
import aocy;
import arxx;
import asqt;
import awtp;
import awyz;
import axpp;
import bapk;
import bcrn;
import bcsc;
import bdla;
import bdnr;
import bdnu;
import bdnv;
import bdoe;
import bgiz;
import bgja;
import bhcc;
import bhch;
import bhdj;
import bheg;
import bhfn;
import bhfy;
import bhgf;
import bhid;
import bhml;
import bhyk;
import bibh;
import bibs;
import bisl;
import bisy;
import bjxa;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
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
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import gb;
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
import llc;
import llq;
import lne;
import mbl;
import mnr;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import msa;
import mss;
import msw;
import mur;
import mvi;
import mvk;
import mzq;
import nty;
import nuz;
import nwu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityUtils
{
  private static bisl jdField_a_of_type_Bisl;
  private static ChatActivityUtils.AddFriendSpan jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan;
  static QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public static Queue<String> a;
  private static ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
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
        break label407;
      }
    }
    label407:
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("isVideo", bool);
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
    //   80: ldc 221
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
    View localView = LayoutInflater.from(paramContext).inflate(2131558661, null);
    localToast.setView(localView);
    localToast.setGravity(55, 0, paramContext.getResources().getDimensionPixelSize(2131299080));
    localToast.setDuration(1);
    ((TextView)localView.findViewById(2131362509)).setText(paramString);
    localView.setOnClickListener(new admv(localToast));
    return localToast;
  }
  
  public static com.tencent.mobileqq.app.BaseActivity a(long paramLong, Context paramContext)
  {
    Object localObject2;
    if ((paramContext instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localObject2 = (com.tencent.mobileqq.app.BaseActivity)paramContext;
      localObject1 = localObject2;
      if (!((com.tencent.mobileqq.app.BaseActivity)localObject2).isFinishing()) {}
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
        QLog.w("ChatActivityUtils", 1, "getBaseActivity, Context[" + paramContext + "], baseActivity[" + localObject2 + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
      }
      return localObject2;
    }
  }
  
  private static MessageRecord a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    MessageRecord localMessageRecord;
    if ((i == -1003) || (i == -1031) || (i == -1032) || (i == -3001) || (acnh.a(paramMessageRecord.istroop) == 1032)) {
      localMessageRecord = null;
    }
    do
    {
      return localMessageRecord;
      localMessageRecord = paramMessageRecord;
    } while (!((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramMessageRecord.frienduin));
    return null;
  }
  
  public static MessageRecord a(List<ChatMessage> paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.curType)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.curType == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int j = paramList.size();
    int i;
    if (paramSessionInfo.curType != 10008)
    {
      i = 1;
      label72:
      j -= 1;
      label78:
      if (j < 0) {
        break label140;
      }
      paramSessionInfo = (MessageRecord)paramList.get(j);
      if (((i != 0) && (paramSessionInfo.isSend())) || (acnh.h(paramSessionInfo.msgtype))) {
        break label131;
      }
    }
    label131:
    label140:
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i = 0;
      break label72;
      j -= 1;
      break label78;
    }
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if ((paramContext instanceof Activity)) {}
    for (paramQQAppInterface = paramContext;; paramQQAppInterface = com.tencent.mobileqq.app.BaseActivity.sTopActivity)
    {
      paramQQAppInterface = (Activity)paramQQAppInterface;
      if ((paramQQAppInterface != null) && (!bhyk.a(paramQQAppInterface, 4, new admy(paramOnClickListener1, paramOnClickListener2), "qav"))) {
        break;
      }
      return PopupDialog.a(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    }
    return null;
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, long paramLong)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    int i;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      i = paramMessageRecord.istroop;
      if ((paramMessageRecord.isSend()) || (bcsc.a(paramMessageRecord.msgtype))) {
        break label499;
      }
      if (1000 != i) {
        break label109;
      }
      a(paramSessionInfo, paramMessageRecord, paramLong);
      paramMessageRecord = localObject2;
      localObject1 = paramMessageRecord;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatActivityUtils", 2, "generateMsgSource, isTroop = " + i);
        localObject1 = paramMessageRecord;
      }
    }
    label106:
    return localObject1;
    label109:
    if (1020 == i)
    {
      paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramMessageRecord.senderuin);
      if (paramQQAppInterface == null) {
        break label604;
      }
      paramQQAppInterface = paramQQAppInterface.name;
    }
    label604:
    for (paramQQAppInterface = String.format(paramContext.getString(2131692576), new Object[] { paramSessionInfo.curFriendNick, paramQQAppInterface });; paramQQAppInterface = null)
    {
      paramMessageRecord = paramQQAppInterface;
      break;
      if (1004 == i)
      {
        paramQQAppInterface = ContactUtils.getNickName(paramQQAppInterface, (String)localObject1, 3000);
        paramQQAppInterface = String.format(paramContext.getString(2131692574), new Object[] { paramSessionInfo.curFriendNick, paramQQAppInterface });
        a(paramSessionInfo, paramMessageRecord, paramLong);
        paramMessageRecord = paramQQAppInterface;
        break;
      }
      paramMessageRecord = localObject2;
      if (1001 == i) {
        break;
      }
      paramMessageRecord = localObject2;
      if (10002 == i) {
        break;
      }
      if (10004 == i)
      {
        paramMessageRecord = String.format(paramContext.getString(2131692577), new Object[] { paramSessionInfo.curFriendNick });
        break;
      }
      paramMessageRecord = localObject2;
      if (1006 == i) {
        break;
      }
      if (1009 == i)
      {
        paramMessageRecord = String.format(paramContext.getString(2131692579), new Object[] { paramSessionInfo.curFriendNick });
        break;
      }
      paramMessageRecord = localObject2;
      if (1005 == i) {
        break;
      }
      if (1021 == i)
      {
        paramMessageRecord = String.format(paramContext.getString(2131692571), new Object[] { paramSessionInfo.curFriendNick });
        break;
      }
      if (1022 == i)
      {
        paramMessageRecord = String.format(paramContext.getString(2131692575), new Object[] { paramSessionInfo.curFriendNick });
        break;
      }
      if (1023 == i)
      {
        paramMessageRecord = String.format(paramContext.getString(2131692578), new Object[] { paramSessionInfo.curFriendNick });
        break;
      }
      if (1010 == i)
      {
        paramMessageRecord = paramQQAppInterface.getNearbyProxy().a(paramSessionInfo.curFriendNick);
        break;
      }
      paramMessageRecord = localObject2;
      if (i != 10010) {
        break;
      }
      paramMessageRecord = String.format(paramContext.getString(2131692570), new Object[] { paramSessionInfo.curFriendNick });
      break;
      label499:
      localObject1 = localObject3;
      if (1006 != i) {
        break label106;
      }
      paramSessionInfo = String.format(paramContext.getString(2131692573), new Object[] { paramSessionInfo.curFriendNick });
      paramQQAppInterface = paramContext.getString(2131692572);
      if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
        jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131166340));
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
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if (paramQQAppInterface == null) {
        return paramContext.getString(2131698276);
      }
      if (TextUtils.isEmpty(paramQQAppInterface.getTroopName())) {
        return paramContext.getString(2131698276);
      }
      paramQQAppInterface = String.format(paramContext.getString(2131698277), new Object[] { paramQQAppInterface.getTroopName() });
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext.getString(2131698276);
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
              paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
              paramMessageRecord = paramQQAppInterface.b(paramQQAppInterface.c(paramMessageRecord.senderuin));
              if (paramMessageRecord == null)
              {
                paramMessageRecord = paramContext.getString(2131698276);
                paramContext = paramMessageRecord;
              }
              else if (TextUtils.isEmpty(paramMessageRecord.getTroopName()))
              {
                paramMessageRecord = paramContext.getString(2131698276);
                paramContext = paramMessageRecord;
              }
              else
              {
                paramMessageRecord = String.format(paramContext.getString(2131698277), new Object[] { paramMessageRecord.getTroopName() });
                paramContext = paramMessageRecord;
              }
            }
            catch (Exception paramMessageRecord)
            {
              paramMessageRecord.printStackTrace();
              paramContext = paramContext.getString(2131698276);
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
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (TextUtils.isEmpty(((HotChatManager)localObject1).a(paramMessageRecord.senderuin))) {
          break;
        }
      }
      break;
    }
    for (paramContext = paramContext.getString(2131698268);; paramContext = null)
    {
      return paramContext;
      return paramContext.getString(2131698265);
      return paramContext.getString(2131698269);
      return paramContext.getString(2131694138);
      return paramContext.getString(2131698270);
      return paramContext.getString(2131698264);
      return paramContext.getString(2131698263);
      return paramContext.getString(2131698274);
      return paramContext.getString(2131698278);
      return paramContext.getString(2131698262);
      return paramContext.getString(2131698266);
      return paramContext.getString(2131698271);
      return paramContext.getString(2131694137);
    }
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (bjxa)paramQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
    if (paramQQAppInterface.b(paramString, false)) {
      return paramQQAppInterface.a(paramContext, paramString);
    }
    return null;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, View paramView, boolean paramBoolean)
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo;
    if ((paramChatMessage instanceof MessageForReplyText)) {
      localSourceMsgInfo = ((MessageForReplyText)paramChatMessage).mSourceMsgInfo;
    }
    for (;;)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1;
      if (localSourceMsgInfo != null)
      {
        String str2 = bhid.a(paramContext, 3, localSourceMsgInfo.mSourceMsgTime * 1000L).toString();
        str1 = "";
        if (!TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName))
        {
          paramContext = localSourceMsgInfo.mAnonymousNickName;
          label82:
          localStringBuilder2.append("“").append(str2).append(" ").append(paramContext).append("\r\n");
          localStringBuilder1.append("     ").append("\r\n");
          if (paramChatMessage.istroop != 0) {
            break label451;
          }
          paramQQAppInterface = paramQQAppInterface.getMessageFacade().queryMsgItemByTime(paramChatMessage.frienduin, 0, localSourceMsgInfo.mSourceMsgTime, localSourceMsgInfo.origUid);
          label158:
          if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
            break label473;
          }
          paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);
          label182:
          if (!(paramQQAppInterface instanceof MessageForLongTextMsg)) {
            break label478;
          }
          localStringBuilder2.append(paramQQAppInterface.msg).append("\r\n");
          localStringBuilder1.append(new QQText(paramQQAppInterface.msg, 13, 32));
          label226:
          MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "doubleClk", paramChatMessage.frienduin, paramChatMessage);
        }
      }
      else
      {
        if (paramBoolean) {
          break label615;
        }
      }
      label451:
      label473:
      label478:
      label615:
      for (paramQQAppInterface = "";; paramQQAppInterface = paramChatMessage.getSummaryMsg())
      {
        localStringBuilder2.append(paramQQAppInterface);
        paramQQAppInterface = localStringBuilder2.toString();
        if ((paramView.getId() != 2131371598) || (!(paramView instanceof ETTextView))) {
          break label623;
        }
        return localStringBuilder1.toString();
        if (!(paramChatMessage instanceof MessageForLongMsg)) {
          break label654;
        }
        localSourceMsgInfo = ((MessageForLongMsg)paramChatMessage).mSourceMsgInfo;
        break;
        if (localSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
        {
          Object localObject = ahfa.a(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, localSourceMsgInfo.mSourceMsgSeq);
          paramContext = str1;
          if (localObject == null) {
            break label82;
          }
          localObject = bgiz.a((MessageRecord)localObject);
          paramContext = str1;
          if (localObject == null) {
            break label82;
          }
          localSourceMsgInfo.mAnonymousNickName = ((bgja)localObject).jdField_c_of_type_JavaLangString;
          paramContext = str1;
          break label82;
        }
        if (paramChatMessage.istroop == 0)
        {
          paramContext = ContactUtils.getFriendShowName(paramQQAppInterface, localSourceMsgInfo.mSourceMsgSenderUin + "");
          break label82;
        }
        paramContext = ContactUtils.getMemberDisplaynameByIstroop(paramQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin, localSourceMsgInfo.mSourceMsgSenderUin + "");
        break label82;
        paramQQAppInterface = paramQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq(paramChatMessage.frienduin, 1, localSourceMsgInfo.mSourceMsgSeq, 0L);
        break label158;
        paramQQAppInterface = null;
        break label182;
        if (localSourceMsgInfo.mSourceSummaryFlag == 1)
        {
          localStringBuilder2.append(localSourceMsgInfo.mSourceMsgText).append("\r\n");
          localStringBuilder1.append(new QQText(localSourceMsgInfo.mSourceMsgText, 13, 32));
          break label226;
        }
        if (paramQQAppInterface != null)
        {
          localStringBuilder2.append(paramQQAppInterface.msg).append("\r\n");
          localStringBuilder1.append(new QQText(paramQQAppInterface.msg, 13, 32));
          break label226;
        }
        localStringBuilder2.append(localSourceMsgInfo.mSourceMsgText).append("\r\n");
        localStringBuilder1.append(new QQText(localSourceMsgInfo.mSourceMsgText, 13, 32));
        break label226;
      }
      label623:
      if ((paramView.getId() == 2131364550) && ((ETTextView)paramView.findViewById(2131371598) != null)) {
        return localStringBuilder1.toString();
      }
      return paramQQAppInterface;
      label654:
      localSourceMsgInfo = null;
    }
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
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    long l = paramQQAppInterface.getAVNotifyCenter().b();
    int i = paramQQAppInterface.getAVNotifyCenter().a();
    int j = paramQQAppInterface.getAVNotifyCenter().b(l);
    QLog.w("ChatActivityUtils", 1, "sendExitBroadcast, finalType[" + paramInt1 + "], finalAvType[" + paramInt2 + "], chattingType[" + i + "], seq[" + paramLong + "]");
    if ((paramInt1 == 1) || (i == 1))
    {
      if ((j != 2) || (paramInt2 == 2)) {
        break label133;
      }
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
    label133:
    while ((j == 2) || (paramInt2 != 2)) {
      return;
    }
    paramQQAppInterface = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
    mur.a(paramQQAppInterface, paramLong);
    paramContext.sendBroadcast(paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_Bisl == null)
        {
          jdField_a_of_type_Bisl = new bisl(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299080));
          jdField_a_of_type_Bisl.c(2131718527);
        }
        jdField_a_of_type_Bisl.show();
        return;
      }
      catch (Exception paramActivity) {}finally
      {
        if ((jdField_a_of_type_Bisl != null) && (!jdField_a_of_type_Bisl.isShowing())) {
          jdField_a_of_type_Bisl = null;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    a(paramActivity, paramSessionInfo, paramString, paramBoolean, false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 3999;
    int j = 0;
    FragmentActivity localFragmentActivity;
    if (paramBoolean2)
    {
      i = 3071;
      j = 11;
      if ((i != 3007) || ((!(paramActivity instanceof SplashActivity)) && (!(paramActivity instanceof ChatActivity)))) {
        break label393;
      }
      localFragmentActivity = (FragmentActivity)paramActivity;
      if (anxi.a(localFragmentActivity.getChatFragment().a(), paramSessionInfo.curFriendUin)) {
        break label459;
      }
      localFragmentActivity.getChatFragment().a().showNearPeopleOperDialog(localFragmentActivity.getString(2131694232));
    }
    label393:
    label459:
    do
    {
      return;
      switch (paramSessionInfo.curType)
      {
      default: 
        break;
      case 1000: 
        i = 3004;
        j = 3;
        break;
      case 1001: 
        i = 3007;
        j = 2;
        break;
      case 1005: 
        i = 3008;
        j = 12;
        break;
      case 1009: 
        i = 3013;
        break;
      case 1006: 
        i = 3006;
        j = 12;
        break;
      case 10004: 
        i = 3043;
        j = 2;
        break;
      case 1004: 
        i = 3005;
        j = 2;
        break;
      case 1021: 
        i = 3003;
        j = 2;
        break;
      case 1023: 
        i = 3008;
        j = 11;
        break;
      case 1010: 
        i = 3019;
        break;
      case 1022: 
        i = 3041;
        j = 11;
        break;
      case 1024: 
        i = 3072;
        j = 1;
        break;
      case 10008: 
        i = 3080;
        j = 3;
        break;
      case 10009: 
        i = 3071;
        j = 5192;
        break;
      case 10010: 
        i = 3076;
        j = 6;
        break;
        if ((i == 3019) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
        {
          localFragmentActivity = (FragmentActivity)paramActivity;
          if (!arxx.a(localFragmentActivity.getChatFragment().a(), paramSessionInfo.curFriendUin))
          {
            localFragmentActivity.getChatFragment().a().showNearPeopleOperDialog(localFragmentActivity.getString(2131694232));
            return;
          }
        }
        if (paramSessionInfo.curType != 1006) {
          break label516;
        }
      }
    } while ((paramSessionInfo.curFriendUin == null) || (paramSessionInfo.curFriendUin.length() <= 0));
    paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 2, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, i, j, paramSessionInfo.curFriendNick, null, null, paramString, null));
    return;
    label516:
    if (paramBoolean1)
    {
      paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, i, j, paramSessionInfo.curFriendNick, null, AddContactsActivity.class.getName(), paramString, null));
      return;
    }
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.curFriendUin, paramSessionInfo.troopUin, i, j, paramSessionInfo.curFriendNick, null, null, paramString, null), 11);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    int m = 0;
    int j = 1;
    Object localObject1;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label49;
      }
    }
    label49:
    for (Object localObject2 = (mqq.app.BaseActivity)paramActivity;; localObject2 = null)
    {
      if ((localObject1 != null) || (localObject2 != null)) {
        break label55;
      }
      return;
      localObject1 = null;
      break;
    }
    label55:
    int i;
    if (localObject1 != null) {
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.CAMERA") != 0)
      {
        i = 1;
        if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          break label145;
        }
      }
    }
    for (;;)
    {
      label84:
      if (paramBoolean) {
        i = m;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0)) {
          localObject1 = anvx.a(2131701069);
        }
        for (;;)
        {
          localObject2 = new admz(paramActivity, paramOnClickListener);
          bhdj.a(paramActivity, null, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2, new adnb(paramOnClickListener));
          return;
          i = 0;
          break;
          label145:
          j = 0;
          break label84;
          if (localObject2 == null) {
            break label228;
          }
          if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.CAMERA") != 0) {}
          for (int k = 1;; k = 0)
          {
            i = k;
            if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
              break;
            }
            j = 0;
            i = k;
            break;
          }
          if (i != 0) {
            localObject1 = anvx.a(2131701047);
          } else {
            localObject1 = anvx.a(2131701054);
          }
        }
      }
      label228:
      i = 1;
    }
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramActivity, 2131718803, 1);
      return;
    }
    b(paramActivity, 2131718805, 1);
  }
  
  public static void a(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131698180));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131165622), paramContext.getResources().getColor(2131165627)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    bhdj.a(paramContext, paramContext.getString(2131698179), localSpannableString, 0, 2131690679, null, null, new admw(paramContext)).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    new bisy(paramContext).a(paramInt, paramContext.getResources().getDimensionPixelSize(2131299080), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131299080));
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = paramQQAppInterface.getMsgHandler().a(bhch.a(paramLong));
    if ((localObject2 != null) && (QLog.isColorLevel())) {
      QLog.d("gameShareOnClick", 2, "<--gameShareOnClick appShareID.bundleid" + ((AppShareID)localObject2).bundleid);
    }
    if ((localObject2 != null) && (((AppShareID)localObject2).bundleid != null) && (bhfn.a(paramContext, ((AppShareID)localObject2).bundleid)))
    {
      long l = bhch.b(paramLong);
      Object localObject1 = paramQQAppInterface.getMsgHandler().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject2).bundleid;
      if (localObject1 == null)
      {
        localObject1 = null;
        bhfn.a(paramContext, (String)localObject2, (String)localObject1);
        if ((paramInt != -3005) && (paramInt != -3004) && ((paramString == null) || (!paramString.startsWith("https://gamecenter.qq.com")))) {
          break label206;
        }
      }
      label206:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(bhch.b(paramLong)), null, null, null);
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
    if ((paramInt == -3005) || (paramInt == -3004) || (str.startsWith("https://gamecenter.qq.com")))
    {
      paramInt = 1;
      if (55901189L != paramLong) {
        break label181;
      }
      paramString = QZoneHelper.UserInfo.getInstance();
      paramString.qzone_uin = paramQQAppInterface.getCurrentAccountUin();
      paramString.nickname = paramQQAppInterface.getCurrentNickname();
      QZoneHelper.forwardToSharedFeedDetail((Activity)paramContext, paramString, str, "mqqChat", -1);
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label333;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(bhch.b(paramLong)), null, null, null);
      return;
      paramInt = 0;
      break;
      label181:
      b(str);
      Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      paramString = nuz.a(str, "from=androidqq");
      if (paramInt != 0)
      {
        localIntent.putExtra("param_force_internal_browser", true);
        paramString = nuz.a(str, "platformId=qq_m");
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
    StatisticCollector.getInstance(BaseApplication.getContext()).reportToAds(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(bhch.b(paramLong)));
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.curFriendUin);
      paramIntent.putExtra("uintype", paramSessionInfo.curType);
      paramIntent.putExtra("uinname", paramSessionInfo.curFriendNick);
      paramIntent.putExtra("troop_uin", paramSessionInfo.troopUin);
      paramIntent.putExtra("phonenum", paramSessionInfo.phoneNum);
    }
  }
  
  private static void a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, long paramLong)
  {
    if ((paramSessionInfo == null) || (paramMessageRecord == null)) {}
    do
    {
      return;
      if ((paramLong == -1L) || (paramMessageRecord.shmsgseq == paramLong))
      {
        QLog.d("ChatActivityUtils", 2, "preMrShMsgSeq = " + paramLong);
        return;
      }
    } while (paramSessionInfo.curType == paramMessageRecord.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "updateSession, type from " + paramSessionInfo.curType + ", to " + paramMessageRecord.istroop);
    }
    paramSessionInfo.curType = paramMessageRecord.istroop;
    paramSessionInfo.troopUin = paramMessageRecord.senderuin;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramActivity, paramInt, paramString1, paramString2, paramBoolean, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (paramQQAppInterface == null) {}
      }
    }
    label339:
    label351:
    while ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      long l;
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
              paramQQAppInterface.changeFriendShieldFlag(l, paramBoolean1);
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
      } while (paramInt == 25);
      awtp localawtp = (awtp)paramQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      String str = paramString1;
      if (localawtp != null)
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
          str = ContactUtils.getUinByPhoneNum(paramQQAppInterface, paramString2);
          paramString1 = str;
          l = Long.parseLong(str);
          paramString1 = str;
          paramString2 = new ArrayList();
          paramString1 = str;
          paramString2.add(Long.valueOf(l));
          if (paramBoolean1)
          {
            paramString1 = str;
            localawtp.b(paramInt, paramString2);
            i = 1;
            if ((paramInt == 1001) || (paramInt == 10002))
            {
              if ((str != null) && (str.length() > 0))
              {
                if (!paramBoolean1) {
                  break label339;
                }
                paramQQAppInterface.getMsgHandler().b(str);
              }
              i = 1;
            }
            if ((paramActivity == null) || (paramActivity.isFinishing())) {
              break;
            }
            if (i == 0) {
              break label351;
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
          localawtp.a(paramInt, paramString2);
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
        paramQQAppInterface.getMsgHandler().a(str);
      }
      if (paramBoolean1)
      {
        b(paramActivity, 2131718803, 1);
        return;
      }
      b(paramActivity, 2131718805, 1);
      return;
    }
    b(paramActivity, 2131694226, 1);
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
      str = bheg.b(paramActivity, (Uri)localObject);
      if (str == null) {
        break label838;
      }
      bheg.a(paramActivity, str);
      if (!FileUtils.isPicFile(str))
      {
        QQToast.a(paramActivity, paramActivity.getString(2131692348), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
        return;
      }
      if (!new File(str).exists())
      {
        QQToast.a(paramActivity, paramActivity.getString(2131694681), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
        return;
      }
    }
    Intent localIntent = new Intent();
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.getAccount();
      Friends localFriends = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e((String)localObject);
      localIntent.putExtra("PhotoConst.MY_UIN", (String)localObject);
      if (localFriends != null) {
        localIntent.putExtra("PhotoConst.MY_NICK", localFriends.name);
      }
      localObject = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if (localObject != null) {
        localIntent.putExtra("showFlashPic", anud.a(paramSessionInfo.curType, (HotChatManager)localObject, paramSessionInfo.troopUin));
      }
    }
    localIntent.putExtra("uin", paramSessionInfo.curFriendUin);
    localIntent.putExtra("uintype", paramSessionInfo.curType);
    localIntent.putExtra("troop_uin", paramSessionInfo.troopUin);
    localIntent.putExtra("uinname", paramSessionInfo.curFriendNick);
    localIntent.putExtra("entrance", paramSessionInfo.entrance);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.topicId);
    localIntent.putExtra("is_anonymous", nty.a().a(paramSessionInfo.curFriendUin));
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
      ((Intent)localObject).putExtra("enter_from", 50);
      if (paramInt2 != -1)
      {
        if (paramInt2 != 8) {
          break label1074;
        }
        if (paramQQAppInterface != null) {
          aftr.a((Intent)localObject, paramSessionInfo, paramQQAppInterface);
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
        PhotoUtils.copyReportInfo(paramIntent, (Intent)localObject);
      }
      paramQQAppInterface = new ArrayList();
      paramQQAppInterface.add(str);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramQQAppInterface);
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject).putExtra("PhotoConst.ALLOW_LOCK", paramBoolean);
      ((Intent)localObject).setClass(paramActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject).addFlags(603979776);
      if (paramInt1 == 0) {
        break label1118;
      }
      paramActivity.startActivityForResult((Intent)localObject, i);
      return;
      label838:
      QQToast.a(paramActivity, paramActivity.getString(2131694681), 0).b(paramActivity.getResources().getDimensionPixelSize(2131299080));
      return;
      if ((paramActivity instanceof SplashActivity))
      {
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.setOpenAIOIntent(localIntent, null);
        label895:
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        if (paramSessionInfo.curType != 9501) {
          break label1034;
        }
        if (!(paramActivity instanceof SplashActivity)) {
          break label1016;
        }
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = AIOUtils.setOpenAIOIntent((Intent)localObject, null);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra(bhcc.h, 82);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        break;
        localObject = localIntent;
        if (!(paramActivity instanceof ChatActivity)) {
          break label895;
        }
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        localObject = localIntent;
        break label895;
        label1016:
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      label1034:
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      break;
      label1074:
      if (paramInt2 == 1)
      {
        if (paramQQAppInterface != null) {
          aftr.a((Intent)localObject, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject).putExtra("FROM_WHERE", "FromCamera");
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      }
    }
    label1118:
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, String paramString5, Map<String, String> paramMap, boolean paramBoolean2)
  {
    int n = aczy.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootVideo");
    Object localObject1 = paramString1;
    Object localObject2;
    if (paramInt == 1011)
    {
      if (!msw.a("random_talk_bg_2.png")) {
        msw.a(paramQQAppInterface);
      }
      localObject1 = paramString1;
      if (paramMap != null)
      {
        localObject1 = (String)paramMap.get("chat_type");
        localObject1 = paramString1;
        if (paramMap != null)
        {
          localObject2 = (String)paramMap.get("encodeuin");
          localObject1 = paramString1;
          if (localObject2 != null)
          {
            localObject1 = paramString1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = a(paramQQAppInterface, (String)localObject2);
              if (localObject1 == null) {
                break label366;
              }
            }
          }
        }
      }
    }
    QLog.w("ChatActivityUtils", 1, "avideo enterVideo called, uinType[" + paramInt + "], peerUin[" + (String)localObject1 + "], name[" + paramString2 + "], phoneNum[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], extraUin[" + paramString4 + "], from[" + paramString5 + "]");
    if ((paramQQAppInterface.isVideoChatting()) && (paramQQAppInterface.getAVNotifyCenter().f() != 1) && (paramQQAppInterface.getAVNotifyCenter().f() != 3000) && (paramQQAppInterface.getAVNotifyCenter().g()) && (paramQQAppInterface.getAVNotifyCenter().f()) && (paramQQAppInterface.getAVNotifyCenter().f() != 1011) && (paramQQAppInterface.getAVNotifyCenter().f() != 21))
    {
      paramQQAppInterface = new Intent(paramContext, VideoInviteActivity.class);
      paramQQAppInterface.addFlags(268435456);
      paramQQAppInterface.putExtra("uinType", paramInt);
      paramQQAppInterface.putExtra("peerUin", (String)localObject1);
      paramQQAppInterface.putExtra("extraUin", paramString4);
      paramQQAppInterface.putExtra("isAudioMode", paramBoolean1);
      paramContext.startActivity(paramQQAppInterface);
    }
    label2695:
    for (;;)
    {
      return;
      label366:
      QLog.e("ChatActivityUtils", 1, "enterVideo Chat AnyOne decode peeruin Err!");
      return;
      label913:
      label1171:
      label2718:
      try
      {
        paramString1 = MediaPlayerManager.a(paramQQAppInterface);
        if (paramString1 != null) {
          paramString1.a(true);
        }
        if (paramInt == 0)
        {
          paramString1 = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e((String)localObject1);
          if (paramString1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatActivityUtils", 2, "enterVideo terminal: " + ContactUtils.getStatusName(paramString1) + ", abilityBits: " + paramString1.abilityBits + ", _eSupportVoice: " + 1);
            }
            if (paramString1.getNetWorkType() != 2)
            {
              bool1 = true;
              if ((paramInt == 1006) || (paramInt == 24) || (paramInt == 25)) {
                if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(paramString3)))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("ChatActivityUtils", 2, "enterVideo uinType: " + paramInt + ", peerUin: " + (String)localObject1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean1 + ", extraUin: " + paramString4);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        label1313:
        for (;;)
        {
          paramString1.printStackTrace();
          continue;
          Object localObject5 = ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
          Object localObject3;
          if (localObject5 != null)
          {
            paramString1 = ((RespondQueryQQBindingStat)localObject5).nationCode;
            localObject3 = ((RespondQueryQQBindingStat)localObject5).mobileNo;
          }
          label809:
          label1337:
          label2749:
          label2772:
          for (;;)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = paramString3;
              localObject4 = paramString3;
            }
            while (((paramInt == 24) || (paramInt == 25)) && ((localObject5 == null) || (((RespondQueryQQBindingStat)localObject5).nationCode.equals("")) || (((RespondQueryQQBindingStat)localObject5).mobileNo.equals(""))))
            {
              QQToast.a(paramContext, 2131695462, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
              return;
              localObject2 = localObject1;
              localObject4 = paramString3;
              if (TextUtils.isEmpty(paramString3))
              {
                localObject4 = localObject1;
                localObject2 = localObject1;
              }
            }
            localObject1 = localObject3;
            localObject3 = paramString1;
            paramString3 = (String)localObject4;
            paramString1 = (String)localObject2;
            localObject2 = localObject3;
            for (;;)
            {
              if (paramInt != 1000) {
                break label2805;
              }
              localObject3 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
              if (localObject3 == null) {
                break label2798;
              }
              localObject3 = ((TroopManager)localObject3).b(paramString4);
              if (localObject3 != null) {
                break label913;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("ChatActivityUtils", 2, "enterVideo can't find troop info!");
              return;
              if (TextUtils.isEmpty(paramString3))
              {
                paramString1 = ((awyz)paramQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a((String)localObject1);
                if (paramString1 != null)
                {
                  paramString3 = paramString1.mobileNo;
                  localObject3 = null;
                  localObject2 = null;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.w("ChatActivityUtils", 2, "enterVideo cannot get phone number");
                }
              }
              localObject3 = null;
              localObject2 = null;
              paramString1 = (String)localObject1;
              localObject1 = localObject3;
            }
            label1129:
            label1132:
            label2798:
            label2805:
            for (Object localObject4 = localObject3;; localObject4 = paramString4)
            {
              localObject3 = paramString4;
              if (paramInt == 9500)
              {
                if (paramMap == null) {
                  break label1064;
                }
                localObject3 = (String)paramMap.get("devSubCode");
              }
              int i;
              for (;;)
              {
                if (paramInt == 1011) {
                  try
                  {
                    paramString4 = (String)paramMap.get("sig");
                    if (QLog.isColorLevel()) {
                      QLog.e("ChatActivityUtils", 2, "sig string=" + paramString4);
                    }
                    localObject5 = paramString4.replace("+", "").split(",");
                    paramString4 = new byte[localObject5.length];
                    i = 0;
                    while (i < localObject5.length)
                    {
                      paramString4[i] = Byte.parseByte(localObject5[i].trim());
                      i += 1;
                      continue;
                      localObject3 = "";
                    }
                  }
                  catch (Exception paramQQAppInterface) {}
                }
              }
              try
              {
                localObject5 = new String(a(paramString2), "UTF-8");
                paramString2 = (String)localObject5;
              }
              catch (Exception localException2)
              {
                AppRuntime.Status localStatus;
                boolean bool2;
                int i1;
                int i2;
                int i3;
                break label1129;
              }
              try
              {
                if (QLog.isColorLevel())
                {
                  QLog.e("ChatActivityUtils", 2, "UTF-8 == " + (String)localObject5);
                  paramString2 = (String)localObject5;
                }
              }
              catch (Exception paramString2)
              {
                paramString2 = localException2;
                break label1129;
                paramString2 = paramString4;
                break label2021;
                paramString2 = paramString4;
                break label2135;
                break label1337;
                m = 0;
                k = -1;
                break label1313;
              }
              int j = 1;
              if (((paramInt == 1025) || (paramInt == 1024)) && (paramString4 != null) && (paramString4.length == 3))
              {
                if (paramBoolean1)
                {
                  paramQQAppInterface = paramContext.getString(2131697994);
                  if (!(paramContext instanceof Activity)) {
                    break label1249;
                  }
                }
                for (;;)
                {
                  bhdj.a(paramContext, 230, null, paramQQAppInterface, null, paramContext.getString(2131694399), new adnd(), null).show();
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
                  return;
                  paramString4 = VideoMsgTools.a(paramQQAppInterface, paramInt, paramString1);
                  j = 0;
                  break label1132;
                  paramQQAppInterface = paramContext.getString(2131697995);
                  break label1171;
                  paramContext = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
                }
              }
              localStatus = paramQQAppInterface.getOnlineStatus();
              bool2 = a(paramQQAppInterface, paramString1);
              localObject5 = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1);
              int k;
              int m;
              if (localObject5 != null)
              {
                k = ContactUtils.getFriendTermType((Friends)localObject5, paramQQAppInterface);
                m = ContactUtils.getFriendStatus(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
                i = ((aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
                if (i == 2)
                {
                  i = 0;
                  i1 = bibh.a(paramQQAppInterface, paramString1, 3, true, null);
                  if ((i1 != 0) && ((paramInt == 0) || (paramInt == 1004) || (paramInt == 1000) || (paramInt == 1003)))
                  {
                    localObject5 = (bhml)paramQQAppInterface.getManager(QQManagerFactory.COLOR_RING_MANAGER);
                    if ((!new File(bhml.a(i1, 3)).exists()) && (bibh.b())) {
                      ((bhml)localObject5).a(i1, 3, false, 0, "colorring");
                    }
                  }
                  i2 = mnr.a(paramQQAppInterface, paramString1, true, true);
                  if (i2 != 0)
                  {
                    i3 = bibh.a();
                    localObject5 = bibh.a(paramQQAppInterface, i2, i3, null);
                    if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!new File((String)localObject5).exists()) && (bibh.b())) {
                      ((bibh)paramQQAppInterface.getManager(QQManagerFactory.VIP_FUNCALL_MANAGER)).a(i2, i3, false, 0);
                    }
                  }
                }
                for (;;)
                {
                  try
                  {
                    for (;;)
                    {
                      localObject5 = (bibs)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FUN_CALL_HANDLER);
                      Bundle localBundle = new Bundle();
                      localBundle.putLong("uin", Long.parseLong(paramString1));
                      localBundle.putString("phone", "");
                      ((bibs)localObject5).a(2, localBundle);
                      localObject5 = new Intent(paramContext, AVActivity.class);
                      ((Intent)localObject5).addFlags(262144);
                      ((Intent)localObject5).addFlags(268435456);
                      ((Intent)localObject5).putExtra("uinType", paramInt);
                      ((Intent)localObject5).putExtra("uin", paramString1);
                      ((Intent)localObject5).putExtra("name", paramString2);
                      ((Intent)localObject5).putExtra("selfNation", (String)localObject2);
                      ((Intent)localObject5).putExtra("selfMobile", (String)localObject1);
                      ((Intent)localObject5).putExtra("toMobile", paramString3);
                      ((Intent)localObject5).putExtra("receive", false);
                      ((Intent)localObject5).putExtra("isAudioMode", paramBoolean1);
                      ((Intent)localObject5).putExtra("istatus", localStatus.getValue());
                      ((Intent)localObject5).putExtra("remoteStatus", m);
                      ((Intent)localObject5).putExtra("extraUin", (String)localObject4);
                      ((Intent)localObject5).putExtra("extraCode", (String)localObject3);
                      ((Intent)localObject5).putExtra("isPeerNetworkWell", bool1);
                      ((Intent)localObject5).putExtra("isFriend", bool2);
                      ((Intent)localObject5).putExtra("senderStartTime", SystemClock.elapsedRealtime());
                      ((Intent)localObject5).putExtra("isSender", true);
                      ((Intent)localObject5).putExtra("colorRingId", i1);
                      ((Intent)localObject5).putExtra("vipType", i);
                      if (!paramBoolean1) {
                        break label2695;
                      }
                      i = 1;
                      ((Intent)localObject5).putExtra("sessionType", i);
                      ((Intent)localObject5).putExtra("hc_code", n);
                      ((Intent)localObject5).putExtra("main_timestamp", System.currentTimeMillis());
                      if (paramMap == null) {
                        break label2779;
                      }
                      paramString2 = (String)paramMap.get("dstClient");
                      localObject1 = (String)paramMap.get("bindId");
                      localObject2 = (String)paramMap.get("bindType");
                      localObject3 = (String)paramMap.get("extraType");
                      if (paramString2 == null) {
                        break label2772;
                      }
                      ((Intent)localObject5).putExtra("dstClient", paramString2);
                      ((Intent)localObject5).putExtra("bindId", (String)localObject1);
                      ((Intent)localObject5).putExtra("bindType", Integer.valueOf((String)localObject2).intValue());
                      ((Intent)localObject5).putExtra("extraType", Integer.valueOf((String)localObject3).intValue());
                      paramString2 = (String)paramMap.get("sig");
                      if (QLog.isColorLevel()) {
                        QLog.e("ChatActivityUtils", 2, "sig string=" + paramString2);
                      }
                      if (paramString2 == null) {
                        break label2772;
                      }
                      try
                      {
                        paramString2 = HexUtil.hexStr2Bytes(paramString2);
                        HexUtil.printHexString("ChatActivityUtils", paramString2);
                        paramString4 = (String)paramMap.get("actid");
                        ((Intent)localObject5).putExtra("actId", paramString4);
                        if (QLog.isColorLevel()) {
                          QLog.e("ChatActivityUtils", 2, "entervideo actid = " + paramString4);
                        }
                        paramString4 = (String)paramMap.get("mp_ext_params");
                        if (QLog.isColorLevel()) {
                          QLog.e("ChatActivityUtils", 2, "entervideo mp_ext_params = " + paramString4);
                        }
                        ((Intent)localObject5).putExtra("mp_ext_params", paramString4);
                        ((Intent)localObject5).putExtra("sig", paramString2);
                        if (paramInt == 1011)
                        {
                          paramString2 = (String)paramMap.get("sex");
                          paramString4 = (String)paramMap.get("headUrl");
                          ((Intent)localObject5).putExtra("headUrl", paramString4 + paramString2 + ".jpg");
                        }
                        if (paramQQAppInterface.getAVNotifyCenter().d(paramString1))
                        {
                          if (paramQQAppInterface.getAVNotifyCenter().b(paramString1) != 1) {
                            break label2718;
                          }
                          ((Intent)localObject5).putExtra("isAudioMode", true);
                          if (!paramBoolean1) {
                            break label2731;
                          }
                          bool1 = false;
                          ((Intent)localObject5).putExtra("startfromVideoEntry", bool1);
                          ((Intent)localObject5).putExtra("sessionType", paramQQAppInterface.getAVNotifyCenter().b(paramString1));
                        }
                        ((Intent)localObject5).putExtra("from", paramString5);
                        ((Intent)localObject5).putExtra("Fromwhere", paramString5);
                        ((Intent)localObject5).putExtra("friendTerminal", k);
                        ((Intent)localObject5).putExtra("isOtherTerminalOnChating", paramQQAppInterface.getAVNotifyCenter().d(paramString1));
                        ((Intent)localObject5).putExtra("otherTerminalChatingRoomId", paramQQAppInterface.getAVNotifyCenter().a(paramString1));
                        ((Intent)localObject5).putExtra("triggerBeauty", paramBoolean2);
                        ((Intent)localObject5).putExtra("isMakingAcall", true);
                        if ("AIOQAVWatchTogether".equals(paramString5))
                        {
                          paramString2 = mzq.a().a(paramInt, paramString1);
                          if (paramString2 != null) {
                            ((Intent)localObject5).putExtra("ChooseFileInfo", paramString2);
                          }
                          mzq.a().a(paramInt, paramString1);
                        }
                        if ((paramString1 != null) || (paramString3 != null))
                        {
                          paramString2 = paramQQAppInterface.getAVNotifyCenter();
                          paramString4 = paramQQAppInterface.getCurrentUin();
                          if (paramString1 == null) {
                            break label2737;
                          }
                          if (!paramBoolean1) {
                            break label2743;
                          }
                          i = 0;
                          paramString2.a(paramString4, paramString1, i, paramInt);
                        }
                        paramString1 = ((Intent)localObject5).getComponent().getClassName();
                        paramString2 = paramContext.getClass().getName();
                        if ((!paramString1.equals("com.tencent.av.ui.AVActivity")) || ((!paramString2.equals("com.tencent.mobileqq.qcall.QCallDetailActivity")) && (!paramString2.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) && (!paramString2.equals("com.tencent.mobileqq.activity.SplashActivity")) && (!paramString2.equals("com.tencent.mobileqq.activity.PublicFragmentActivity")) && (paramInt != 9500) && (paramInt != 1044))) {
                          break label2749;
                        }
                        paramString1 = new Intent(paramContext, AVLoadingDialogActivity.class);
                        paramString1.putExtra("avactivity_intent", (Parcelable)localObject5);
                        paramString1.addFlags(268435456);
                        paramContext.startActivity(paramString1);
                        if ((paramBoolean2) && ((paramContext instanceof Activity))) {
                          ((Activity)paramContext).overridePendingTransition(2130772133, 2130772134);
                        }
                        if ((!paramQQAppInterface.isVideoChatting()) || (j != 0) || (paramInt == 9500) || (!(paramContext instanceof Activity))) {
                          break;
                        }
                        ((Activity)paramContext).overridePendingTransition(2130772146, 0);
                        return;
                      }
                      catch (Exception paramQQAppInterface) {}
                    }
                    if (i != 3) {
                      break label2786;
                    }
                    i = 2;
                  }
                  catch (Exception localException1)
                  {
                    QLog.e("ChatActivityUtils", 1, "VipSetFunCallHandler Error:" + localException1.getMessage());
                    continue;
                    i = 2;
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
                  return;
                  localException1.putExtra("isAudioMode", false);
                  continue;
                  bool1 = true;
                  continue;
                  paramString1 = paramString3;
                  continue;
                  i = 1;
                  continue;
                  paramContext.startActivity(localException1);
                }
              }
              localObject3 = paramString4;
              break label809;
            }
            label1249:
            label2021:
            localObject3 = null;
            label2135:
            label2779:
            label2786:
            paramString1 = null;
          }
          label1064:
          label2731:
          label2737:
          label2743:
          boolean bool1 = false;
        }
      }
    }
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
      localChatMessage = AIOUtils.getMessage(paramView);
    } while ((localChatMessage == null) || (ApolloUtil.a(localChatMessage)));
    Object localObject1 = null;
    boolean bool2 = true;
    boolean bool1;
    if ((localChatMessage instanceof MessageForLongMsg))
    {
      if (!localChatMessage.isShowQIMStyleGroup)
      {
        bool1 = true;
        label124:
        if (localChatMessage.isShowTIMStyleGroup) {
          break label173;
        }
      }
      label173:
      for (bool2 = true;; bool2 = false)
      {
        localObject1 = ((MessageForLongMsg)localChatMessage).msg;
        if (localObject1 != null) {
          break label612;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick() CharSequence null.");
        return;
        bool1 = false;
        break label124;
      }
    }
    if ((localChatMessage instanceof MessageForText)) {
      if (!localChatMessage.isShowQIMStyleGroup)
      {
        bool1 = true;
        label198:
        if (localChatMessage.isShowTIMStyleGroup) {
          break label278;
        }
        bool2 = true;
        label209:
        localObject1 = (MessageForText)localChatMessage;
        if (!(((MessageForText)localObject1).sb instanceof QQText)) {
          break label284;
        }
        localObject1 = ((QQText)((MessageForText)localObject1).sb).mSource;
      }
    }
    for (;;)
    {
      label240:
      if (localChatMessage.msgtype == -2008) {
        if (!localChatMessage.isSend()) {
          break label310;
        }
      }
      label278:
      label284:
      label310:
      for (localObject1 = localContext.getString(2131718418);; localObject1 = localContext.getString(2131718417))
      {
        break;
        bool1 = false;
        break label198;
        bool2 = false;
        break label209;
        if (!(((MessageForText)localObject1).sb instanceof Spannable)) {
          break label1154;
        }
        localObject1 = ((MessageForText)localObject1).sb.toString();
        break label240;
      }
      if ((localChatMessage instanceof MessageForQQStoryComment))
      {
        localObject1 = (MessageForQQStoryComment)localChatMessage;
        localObject1 = "“" + ((MessageForQQStoryComment)localObject1).title + "”\n" + ((MessageForQQStoryComment)localObject1).comment;
        bool1 = true;
        break;
      }
      if (((localChatMessage instanceof MessageForReplyText)) || ((localChatMessage instanceof MessageForLongMsg)))
      {
        localObject1 = a(paramQQAppInterface, localChatMessage, localContext, paramView, true);
        bool1 = true;
        break;
      }
      Object localObject2;
      MessageForReplyText localMessageForReplyText;
      if ((localChatMessage instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localChatMessage;
        localMessageForReplyText = ((MessageForMixedMsg)localObject2).getReplyMessage(paramQQAppInterface);
        localObject1 = "";
        if ((paramView.getId() == 2131371598) && ((paramView instanceof ETTextView)))
        {
          if (localMessageForReplyText != null) {
            localObject1 = a(paramQQAppInterface, localMessageForReplyText, localContext, paramView, false);
          }
          label479:
          bool1 = true;
          break;
        }
        if (paramView.getId() == 2131364550) {
          if (((ETTextView)paramView.findViewById(2131371598) == null) || (localMessageForReplyText == null)) {
            break label1147;
          }
        }
      }
      label612:
      label1147:
      for (localObject1 = a(paramQQAppInterface, localMessageForReplyText, localContext, paramView, false);; localObject1 = "")
      {
        break label479;
        if (localMessageForReplyText != null) {
          localObject1 = a(paramQQAppInterface, localMessageForReplyText, localContext, paramView, false);
        }
        localObject1 = (String)localObject1 + ((MessageForMixedMsg)localObject2).msg;
        break label479;
        if ((localChatMessage instanceof MessageForHiBoom))
        {
          localObject2 = (MessageForHiBoom)localChatMessage;
          if (((MessageForHiBoom)localObject2).mHiBoomMessage != null)
          {
            localObject1 = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
            bool1 = true;
            break;
            localObject2 = new Intent(localContext, TextPreviewActivity.class);
            ((Intent)localObject2).putExtra("peeruin", localChatMessage.frienduin);
            ((Intent)localObject2).putExtra("uin_type", localChatMessage.istroop);
            ((Intent)localObject2).putExtra("content", (String)localObject1);
            ((Intent)localObject2).putExtra("uniseq", localChatMessage.uniseq);
            ((Intent)localObject2).putExtra("bubbleId", localChatMessage.vipBubbleID);
            ((Intent)localObject2).putExtra("bubbleDiyId", localChatMessage.vipBubbleDiyTextId);
            ((Intent)localObject2).putExtra("fontId", localChatMessage.getExtInfoFromExtStr("vip_font_id"));
            ((Intent)localObject2).putExtra("troop_at_info", localChatMessage.getExtInfoFromExtStr(bcrn.i));
            ((Intent)localObject2).putExtra("origin_merge_structing_msg_uniseq", a(localChatMessage, paramActivity));
            ((Intent)localObject2).putExtra("senderUin", localChatMessage.senderuin);
            ((Intent)localObject2).putExtra("sessionType", paramInt);
            ((Intent)localObject2).putExtra("isMultiMsg", localChatMessage.isMultiMsg);
            int i = 0;
            paramActivity = localChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
            paramInt = i;
            if (!TextUtils.isEmpty(paramActivity))
            {
              paramInt = i;
              if (TextUtils.isDigitsOnly(paramActivity)) {
                paramInt = Integer.valueOf(paramActivity).intValue();
              }
            }
            i = paramInt;
            if (paramInt == 0)
            {
              i = paramInt;
              if (gb.a(localChatMessage)) {
                i = 1;
              }
            }
            paramInt = i;
            if (i != 0)
            {
              paramInt = i;
              if (1 == localChatMessage.istroop)
              {
                paramInt = i;
                if (nty.a(localChatMessage)) {
                  paramInt = 0;
                }
              }
            }
            ((Intent)localObject2).putExtra("fontEffectId", paramInt);
            ((Intent)localObject2).putExtra(ahwv.jdField_a_of_type_JavaLangString, bool1);
            ((Intent)localObject2).putExtra(aijq.jdField_a_of_type_JavaLangString, bool2);
            if ((localChatMessage instanceof MessageForHiBoom))
            {
              paramActivity = (MessageForHiBoom)localChatMessage;
              if ((paramActivity.mHiBoomMessage != null) && ((paramView instanceof HiBoomTextView)))
              {
                ((Intent)localObject2).putExtra("HiBoomId", paramActivity.mHiBoomMessage.id);
                VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentUin(), "HighFont", "AioDoubleClick", "", 1, 0, 0, "", "" + paramActivity.mHiBoomMessage.id, "");
              }
            }
            if (localChatMessage.isSend()) {
              paramQQAppInterface = localChatMessage.selfuin;
            }
            for (;;)
            {
              ((Intent)localObject2).putExtra("real_msg_sender_uin", paramQQAppInterface);
              ((Activity)localContext).startActivityForResult((Intent)localObject2, 14001);
              ((Activity)localContext).overridePendingTransition(2130772009, 0);
              VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface, "long_msg", "long_msg_double", "", 1, 0, 0, "", String.valueOf(aocy.a(localChatMessage.vipBubbleID)), "");
              return;
              if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004)) {
                paramQQAppInterface = localChatMessage.frienduin;
              } else {
                paramQQAppInterface = localChatMessage.senderuin;
              }
            }
          }
        }
        bool1 = true;
        break;
      }
      label1154:
      localObject1 = null;
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
    paramInteger = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    int i;
    if (paramInteger != null)
    {
      paramInteger = paramInteger.b(paramString);
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
        bdla.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
        return;
        i = 0;
        break;
      }
      i = 0;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
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
    return (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1020) || (paramInt == 1025) || (paramInt == 1010) || (paramInt == 10008) || (paramInt == 10009) || (paramInt == 10010);
  }
  
  public static boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, adnm paramadnm, adnn paramadnn)
  {
    if (AudioHelper.a(13) == 1)
    {
      QLog.d("ChatActivityUtils", 1, "音视频进程在等待调试器连接(界面会无响应)");
      AudioHelper.c(anvx.a(2131701078));
    }
    if (!paramQQAppInterface.isVideoChatting())
    {
      if ((paramContext instanceof com.tencent.mobileqq.app.BaseActivity)) {
        localObject = (com.tencent.mobileqq.app.BaseActivity)paramContext;
      }
      for (;;)
      {
        bool = paramadnn.jdField_a_of_type_Boolean;
        if (a((Activity)localObject, bool, new admp(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn, (com.tencent.mobileqq.app.BaseActivity)localObject, bool))) {
          break;
        }
        return false;
        localObject = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, Context[" + paramContext + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
      }
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8005757", "0X8005757", 0, 0, "", "", "", "");
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800575B", "0X800575B", 0, 0, "", "", "", "");
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800575F", "0X800575F", 0, 0, "", "", "", "");
      if (paramQQAppInterface.getAVNotifyCenter().a()) {
        return adlp.a(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn).booleanValue();
      }
      Boolean localBoolean;
      if (((paramadnn.jdField_a_of_type_Int == 1006) && (!a(paramQQAppInterface, paramadnn.jdField_a_of_type_JavaLangString))) || (paramadnn.jdField_a_of_type_Int == 1024) || (paramadnn.jdField_a_of_type_Int == 1011))
      {
        localBoolean = adlp.b(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn);
        if (localBoolean != null) {
          return localBoolean.booleanValue();
        }
      }
      if ((paramadnn.jdField_a_of_type_Boolean) && (!llc.a(paramContext))) {
        return adlp.c(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn).booleanValue();
      }
      if (paramadnn.jdField_a_of_type_Int == 1010)
      {
        localBoolean = adlp.d(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn);
        if (localBoolean != null) {
          return localBoolean.booleanValue();
        }
      }
      if ((paramadnn.jdField_a_of_type_Int == 1044) && (((asqt)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a((Context)localObject))) {
        return false;
      }
      if ((paramadnn.jdField_b_of_type_Boolean) && (a(paramQQAppInterface, paramadnn.jdField_a_of_type_Int, paramadnn.jdField_a_of_type_JavaLangString, paramadnn.jdField_c_of_type_JavaLangString)) && (paramadnn.jdField_a_of_type_Int != 1024)) {
        return adlp.e(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn).booleanValue();
      }
      if (!NetworkUtil.isNetSupport(paramContext)) {
        return adlp.f(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn).booleanValue();
      }
      boolean bool = NetworkUtil.isWifiConnected(paramContext);
      if ((paramadnn.jdField_a_of_type_Int == 1024) && (!bool) && (NetworkUtil.getSystemNetwork(paramContext) == 2))
      {
        bdla.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        QQToast.a(paramContext, 2131695185, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
        bdla.b(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
        return false;
      }
      if ((paramadnn.jdField_c_of_type_Boolean) && (!bool) && (!NetworkUtil.isBluetoothSharedNetwork(paramContext))) {
        return adlp.g(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn).booleanValue();
      }
    }
    else
    {
      localObject = adlp.h(paramLong, paramQQAppInterface, paramContext, paramadnm, paramadnn);
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
    }
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramadnn.jdField_a_of_type_Int == 0) && (!((anvk)localObject).b(paramadnn.jdField_a_of_type_JavaLangString)))
    {
      if (AudioHelper.a(16) == 1) {
        AudioHelper.a(anvx.a(2131701053));
      }
    }
    else
    {
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8005766", "0X8005766", 0, 0, "", "", "", "");
      if (paramadnm != null) {
        paramadnm.onBeforeStartActivity();
      }
      a(paramQQAppInterface, paramContext, paramadnn.jdField_a_of_type_Int, paramadnn.jdField_a_of_type_JavaLangString, paramadnn.jdField_b_of_type_JavaLangString, paramadnn.jdField_c_of_type_JavaLangString, paramadnn.jdField_a_of_type_Boolean, paramadnn.jdField_d_of_type_JavaLangString, paramadnn.jdField_e_of_type_JavaLangString, paramadnn.jdField_a_of_type_JavaUtilMap, paramadnn.jdField_e_of_type_Boolean);
      if (paramadnm != null) {
        paramadnm.onAfterStartActivity();
      }
      return true;
    }
    if (paramadnn.jdField_a_of_type_Boolean) {}
    for (int i = 2131695161;; i = 2131695162)
    {
      paramQQAppInterface = paramContext.getString(i);
      PopupDialog.a(paramContext, 230, paramContext.getString(2131695436), paramQQAppInterface, 2131690697, 2131695314, new adna(), null);
      return false;
    }
  }
  
  static boolean a(long paramLong1, QQAppInterface paramQQAppInterface, Context paramContext, adnm paramadnm, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean, String paramString, int paramInt1, long paramLong2, int paramInt2)
  {
    if ((paramBoolean) && (paramQQAppInterface.isVideoChatting()))
    {
      i = paramQQAppInterface.getAVNotifyCenter().b();
      int j = paramQQAppInterface.getAVNotifyCenter().c();
      int k = paramQQAppInterface.getAVNotifyCenter().e();
      if (((j != 1) && (j != 2)) || (((i >= 1) && (i <= 5)) || (k == 1) || (k == 2)))
      {
        QQToast.a(paramContext, 2131695634, 1).b(paramContext.getResources().getDimensionPixelSize(2131299080));
        bhgf.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
        return true;
      }
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
          QLog.w("ChatActivityUtils", 1, "checkMutex, chatingRelationId[" + l2 + "], chatUin[" + l1 + "], discussId[" + paramLong2 + "], seq[" + paramLong1 + "]");
          if ((l1 != paramLong2) || ((paramInt1 != 2) && (paramInt1 != 1))) {
            break label297;
          }
        }
      }
    }
    return false;
    label297:
    String str = paramContext.getString(2131695266);
    int i = mvi.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString + "");
    PopupDialog.a(paramContext, 230, null, str, 2131695168, 2131695180, new adnh(paramLong1, paramQQAppInterface, paramContext, paramInt1, paramInt2, paramOnClickListener, paramString, i), new adni(paramadnm, paramString, i, paramQQAppInterface));
    bdla.b(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", i + "", "", "");
    return true;
  }
  
  public static boolean a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    int i = 0;
    boolean bool1 = true;
    com.tencent.mobileqq.app.BaseActivity localBaseActivity;
    mqq.app.BaseActivity localBaseActivity1;
    boolean bool3;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localBaseActivity = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      i = 1;
      bool1 = localBaseActivity.isFinishing();
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label67;
      }
      localBaseActivity1 = (mqq.app.BaseActivity)paramActivity;
      bool3 = localBaseActivity1.isFinishing();
      i = 2;
    }
    for (;;)
    {
      if ((localBaseActivity != null) || (localBaseActivity1 != null)) {
        break label77;
      }
      return true;
      localBaseActivity = null;
      break;
      label67:
      localBaseActivity1 = null;
      bool3 = bool1;
    }
    label77:
    boolean bool2 = true;
    bool1 = true;
    if (localBaseActivity != null) {
      if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") == 0)
      {
        bool2 = true;
        if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
          break label254;
        }
        bool1 = true;
      }
    }
    boolean bool4;
    for (;;)
    {
      bool4 = VideoController.a(paramActivity);
      if ((QLog.isDevelopLevel()) || (!bool2) || (!bool1) || (bool4)) {
        QLog.w("ChatActivityUtils", 1, "checkQAVPermission, Camera[" + bool2 + "], audio[" + bool1 + "], onlyAudio[" + paramBoolean + "], activityType[" + i + "], isScreenLocked[" + bool4 + "], isFinishing[" + bool3 + "]");
      }
      if (paramBoolean) {
        bool2 = true;
      }
      if ((!bool2) || (!bool1)) {
        break label308;
      }
      return true;
      bool2 = false;
      break;
      label254:
      bool1 = false;
      continue;
      if (localBaseActivity1 != null)
      {
        if (localBaseActivity1.checkSelfPermission("android.permission.CAMERA") == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          if (localBaseActivity1.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label302;
          }
          bool1 = true;
          break;
        }
        label302:
        bool1 = false;
      }
    }
    label308:
    if (bool4)
    {
      paramOnClickListener.onClick(null, -1);
      return false;
    }
    paramActivity = new adnc(paramOnClickListener);
    if ((!bool2) && (!bool1)) {
      if (localBaseActivity != null) {
        localBaseActivity.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      }
    }
    for (;;)
    {
      return false;
      if (localBaseActivity1 != null)
      {
        localBaseActivity1.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        continue;
        if (!bool2)
        {
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else if (!bool1) {
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return false;
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "single friend list: " + paramContext + " curType:" + paramSessionInfo.curType + " curFriendUin:" + paramSessionInfo.curFriendUin);
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
            if ((j == paramSessionInfo.curType) && (paramString.equals(acnh.a(paramSessionInfo.curFriendUin))))
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore true");
              }
              return true;
            }
          }
          i += 1;
        }
        return true;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString2, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, "single friend list: " + (String)localObject + " curType:" + paramInt + " uin:" + paramString1);
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
            break label234;
          }
          int j = localJSONObject.getInt("type");
          String str = localJSONObject.getString("uin");
          if ((j == paramInt) && (str.equals(acnh.a(paramString1)))) {
            break label234;
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
      paramContext.putString(paramString2, ((JSONArray)localObject).toString());
      boolean bool = paramContext.commit();
      return bool;
      label234:
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((1024 == paramInt) && (nwu.a(paramQQAppInterface, paramString))) {
      return false;
    }
    paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + paramInt);
    }
    awtp localawtp = (awtp)paramQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    boolean bool1;
    if (paramInt == 0)
    {
      if (!((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1)) {
        break label264;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + bool1);
      }
      return bool1;
      if ((paramInt == 1001) || (paramInt == 10002) || (paramInt == 10010))
      {
        paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (localawtp == null) {
          break label258;
        }
      }
      label258:
      for (bool1 = localawtp.a(paramString1);; bool1 = false)
      {
        if (!bool1)
        {
          paramQQAppInterface = paramQQAppInterface.e(paramString1);
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
          bool1 = bool3;
          if (localawtp == null) {
            break;
          }
          String str = paramString1;
          if (paramInt == 1006)
          {
            str = paramString1;
            if (paramString1 == null) {
              str = ContactUtils.getUinByPhoneNum(paramQQAppInterface, paramString2);
            }
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          bool1 = localawtp.a(str);
          break;
        }
      }
      label264:
      bool1 = false;
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt1 == 1) && (paramQQAppInterface.getAVNotifyCenter().a(paramInt1, paramLong)) && (paramQQAppInterface.getAVNotifyCenter().h()) && (paramInt2 == 1))
    {
      paramLong = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityUtils", 1, "checkGroupInAnotherChating, seq[" + paramLong + "]");
      }
      long l = paramQQAppInterface.getAVNotifyCenter().b();
      paramInt1 = paramQQAppInterface.getAVNotifyCenter().b(l);
      if (paramInt1 != paramInt3)
      {
        if ((paramInt1 == 10) && (paramInt3 == 2))
        {
          if (paramQQAppInterface.getAVNotifyCenter().c()) {
            QQToast.a(paramContext, 2131695265, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
          }
          for (;;)
          {
            return true;
            QQToast.a(paramContext, 2131695267, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
          }
        }
        if ((paramInt1 == 2) && (paramInt3 == 10))
        {
          if (paramQQAppInterface.getAVNotifyCenter().c()) {
            QQToast.a(paramContext, 2131695268, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
          }
          for (;;)
          {
            return true;
            QQToast.a(paramContext, 2131695264, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
          }
        }
      }
      if (paramInt3 != 2) {
        break label274;
      }
      paramQQAppInterface = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
      mur.a(paramQQAppInterface, paramLong);
      paramContext.sendBroadcast(paramQQAppInterface);
    }
    for (;;)
    {
      return false;
      label274:
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, adnm paramadnm, String paramString5)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramadnm, paramString5, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, adnm paramadnm, String paramString5, Map<String, String> paramMap)
  {
    if (QLog.isDevelopLevel()) {}
    for (Object localObject = new Throwable("打印调用栈");; localObject = null)
    {
      long l = AudioHelper.b();
      QLog.w("ChatActivityUtils", 1, "startVideo, uinType[" + paramInt + "], peerUin[" + paramString1 + "], name[" + paramString2 + "], phoneNum[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], extraUin[" + paramString4 + "], checkShieldMsg[" + paramBoolean2 + "], checkWifi[" + paramBoolean3 + "], from[" + paramString5 + "], seq[" + l + "]", (Throwable)localObject);
      localObject = new adnn();
      ((adnn)localObject).jdField_a_of_type_Int = paramInt;
      ((adnn)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((adnn)localObject).jdField_b_of_type_JavaLangString = paramString2;
      ((adnn)localObject).jdField_c_of_type_JavaLangString = paramString3;
      ((adnn)localObject).jdField_a_of_type_Boolean = paramBoolean1;
      ((adnn)localObject).jdField_d_of_type_JavaLangString = paramString4;
      ((adnn)localObject).jdField_b_of_type_Boolean = paramBoolean2;
      ((adnn)localObject).jdField_c_of_type_Boolean = paramBoolean3;
      ((adnn)localObject).jdField_e_of_type_JavaLangString = paramString5;
      ((adnn)localObject).jdField_a_of_type_JavaUtilMap = paramMap;
      ((adnn)localObject).jdField_d_of_type_Boolean = true;
      ((adnn)localObject).jdField_e_of_type_Boolean = false;
      return a(l, paramQQAppInterface, paramContext, paramadnm, (adnn)localObject);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, adnm paramadnm, Bundle paramBundle)
  {
    long l1 = AudioHelper.b();
    Object localObject = new StringBuilder().append("startGroupAudioEx, uinType[").append(paramInt).append("], uin[").append(paramString).append("], checkWifi[").append(paramBoolean1).append("], checkMutex[").append(paramBoolean2).append("], StartVideoListener[");
    boolean bool1;
    label93:
    StringBuilder localStringBuilder;
    if (paramadnm != null)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append("], extroBundle[");
      if (paramBundle == null) {
        break label179;
      }
      bool1 = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool1).append("], fromWhere[");
      if (paramBundle != null) {
        break label185;
      }
    }
    label179:
    label185:
    for (localObject = "null";; localObject = paramBundle.getString("Fromwhere"))
    {
      QLog.w("ChatActivityUtils", 1, (String)localObject + "], seq[" + l1 + "]");
      AudioHelper.a("ChatActivityUtils.startGroupAudioEx", paramBundle, true);
      if (a(paramQQAppInterface, paramContext, paramadnm, paramInt, paramString)) {
        break label197;
      }
      return true;
      bool1 = false;
      break;
      bool1 = false;
      break label93;
    }
    label197:
    long l2 = Long.valueOf(paramString).longValue();
    int j = mvk.b(paramInt);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      mur.a(paramBundle, l1);
      boolean bool2 = paramBundle.getBoolean("isVideo", false);
      localObject = a(l1, paramContext);
      if (!bool2) {}
      for (bool1 = true; !a((Activity)localObject, bool1, new adnj(l1, paramContext, paramQQAppInterface, paramInt, paramString, paramBoolean2, paramadnm, paramBundle, bool2)); bool1 = false) {
        return true;
      }
      int i = paramBundle.getInt("MultiAVType", 0);
      if (i == 10) {
        bhfy.a("startGroupAudioEx", paramQQAppInterface, paramString);
      }
      if (j == 2) {
        i = 1;
      }
      if (j == 1) {
        paramQQAppInterface.getAVNotifyCenter().a(l1, bool2);
      }
      if (a(paramQQAppInterface, paramContext, j, paramInt, l2, i)) {
        return true;
      }
      if (!paramQQAppInterface.getAVNotifyCenter().a(j, l2, i))
      {
        if (!a(paramQQAppInterface, paramContext, paramadnm, new admq(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramadnm, paramBundle), paramBoolean1, bool2)) {
          return true;
        }
        if (a(l1, paramQQAppInterface, paramContext, paramadnm, new admr(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramadnm, paramBundle), paramBoolean2, paramString, j, l2, i)) {
          return true;
        }
      }
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8005776", "0X8005776", 0, 0, "", "", "", "");
      if (paramadnm != null) {
        paramadnm.onBeforeStartActivity();
      }
      b(paramQQAppInterface, paramContext, paramInt, paramString, paramBundle);
      if (paramadnm != null) {
        paramadnm.onAfterStartActivity();
      }
      paramQQAppInterface.getAVNotifyCenter().b(7, l2, i);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, adnm paramadnm, Map<String, String> paramMap)
  {
    int i;
    if ((paramMap != null) && ("true".equals(paramMap.get("isVideo"))))
    {
      i = 4;
      if (i != 4) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.getAVNotifyCenter().a(paramContext, paramInt, paramString, bool))) {
        break label73;
      }
      return false;
      i = paramQQAppInterface.getAVNotifyCenter().e();
      break;
    }
    label73:
    return a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramBoolean2, paramadnm, a(paramMap));
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, adnm paramadnm, int paramInt, String paramString)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, Activity isDestroyed!");
      return false;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 当前网络不可用");
      QQToast.a(paramContext, 2131694226, 0).b(paramContext.getResources().getDimensionPixelSize(2131299080));
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
      return false;
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
    if (!llq.c())
    {
      QQToast.a(paramContext, 2131695254, 1).b(paramContext.getResources().getDimensionPixelSize(2131299080));
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X8005769", "0X8005769", 0, 0, "", "", "", "");
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800576B", "0X800576B", 0, 0, "", "", llq.e(), "");
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800576C", "0X800576C", 0, 0, "", "", llq.f(), "");
      return false;
    }
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800576A", "0X800576A", 0, 0, "", "", "", "");
    bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800576E", "0X800576E", 0, 0, "", "", "", "");
    if ((paramQQAppInterface.getAVNotifyCenter().a()) && (!paramQQAppInterface.isVideoChatting()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 有系统电话");
      msa.e(true, true);
      paramQQAppInterface = paramContext.getString(2131695457);
      paramString = paramContext.getString(2131695436);
      if ((paramContext instanceof Activity)) {}
      for (;;)
      {
        bhdj.a(paramContext, 230, paramString, paramQQAppInterface, 2131690697, 2131694399, new adne(paramadnm), null).show();
        msa.a();
        return false;
        paramContext = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
      }
    }
    if (!llq.e())
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, old engine");
      if (paramInt == 1011)
      {
        paramString = paramContext.getString(2131695638);
        bhdj.a(paramContext, 230, paramContext.getString(2131695436), paramString, 2131690697, 2131695367, new adnf(paramadnm), null).show();
        bdla.b(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
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
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, adnm paramadnm, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramBoolean1) && (!NetworkUtil.isWifiConnected(BaseApplication.getContext())) && (!NetworkUtil.isBluetoothSharedNetwork(BaseApplication.getContext())) && (VideoController.d(VideoController.jdField_b_of_type_JavaLangString + paramQQAppInterface.getCurrentAccountUin()) <= 0))
    {
      if (!NetworkUtil.isMobileNetWork(BaseApplication.getContext())) {
        break label206;
      }
      localObject1 = paramContext.getString(2131695436);
      localObject2 = paramContext.getString(2131695432);
    }
    for (;;)
    {
      if (NetworkUtil.is3Gor4G(BaseApplication.getContext()))
      {
        localObject2 = paramContext.getString(2131695436);
        if (paramBoolean2) {
          localObject1 = paramContext.getString(2131695433);
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
          localObject1 = paramContext.getString(2131695434);
        }
        else
        {
          a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131695168, 2131695180, paramOnClickListener, new adng(paramadnm));
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
    return a(paramQQAppInterface, paramSessionInfo.curType, paramSessionInfo.curFriendUin);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
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
            break label589;
          }
          str1 = paramJSONObject.getString("picture");
          if (!paramJSONObject.has("title")) {
            break label595;
          }
          str2 = paramJSONObject.getString("title");
          if (!paramJSONObject.has("summary")) {
            break label601;
          }
          str3 = paramJSONObject.getString("summary");
          if (!paramJSONObject.has("brief")) {
            break label607;
          }
          localObject2 = paramJSONObject.getString("brief");
          if (!paramJSONObject.has("layout")) {
            break label613;
          }
          i = paramJSONObject.getInt("layout");
          if (!paramJSONObject.has("source")) {
            break label618;
          }
          str4 = paramJSONObject.getString("source");
          if (i == 6)
          {
            if (!paramJSONObject.has("price")) {
              break label624;
            }
            str5 = paramJSONObject.getString("price");
            if (!paramJSONObject.has("prunit")) {
              break label630;
            }
            str6 = paramJSONObject.getString("prunit");
            if (!paramJSONObject.has("icon")) {
              break label636;
            }
            str7 = paramJSONObject.getString("icon");
            if (!paramJSONObject.has("srcaction")) {
              break label642;
            }
            str8 = paramJSONObject.getString("srcaction");
            if (!paramJSONObject.has("action")) {
              break label648;
            }
            str9 = paramJSONObject.getString("action");
            if (!paramJSONObject.has("a_actionData")) {
              break label654;
            }
            str10 = paramJSONObject.getString("a_actionData");
            if (!paramJSONObject.has("i_actionData")) {
              break label660;
            }
            str11 = paramJSONObject.getString("i_actionData");
            if (!paramJSONObject.has("appid")) {
              break label666;
            }
            paramJSONObject = paramJSONObject.getString("appid");
            localObject2 = new bdnr(StructMsgForGeneralShare.class).c(41).a((String)localObject2).a(7);
            if (TextUtils.isEmpty(paramJSONObject)) {
              break label672;
            }
            l = Long.parseLong(paramJSONObject);
            paramJSONObject = ((bdnr)localObject2).a(l).a(str9, (String)localObject1, null, null, null).a(str4, str7).b(str8, null, null, str10, str11).d((String)localObject1).a();
            localObject1 = bdoe.a(i);
            ((bdnv)localObject1).a(str1, str2, str3, str5, str6, 0);
            paramJSONObject.addItem((bdnu)localObject1);
            return paramJSONObject.getBytes();
          }
          paramJSONObject = paramJSONObject.getString("puin");
          paramJSONObject = new bdnr(StructMsgForGeneralShare.class).c(21).a((String)localObject2).e((String)localObject1).a(str4, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
          localObject1 = bdoe.a(2);
          ((bdnv)localObject1).a(str1, str2, str3);
          paramJSONObject.addItem((bdnu)localObject1);
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
      label589:
      String str1 = null;
      continue;
      label595:
      String str2 = null;
      continue;
      label601:
      String str3 = null;
      continue;
      label607:
      Object localObject2 = null;
      continue;
      label613:
      int i = 2;
      continue;
      label618:
      String str4 = null;
      continue;
      label624:
      String str5 = null;
      continue;
      label630:
      String str6 = null;
      continue;
      label636:
      String str7 = null;
      continue;
      label642:
      String str8 = null;
      continue;
      label648:
      String str9 = null;
      continue;
      label654:
      String str10 = null;
      continue;
      label660:
      String str11 = null;
      continue;
      label666:
      paramJSONObject = "";
      continue;
      label672:
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
  
  public static MessageRecord b(List<ChatMessage> paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.curType)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.curType == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if (acnh.h(paramSessionInfo.msgtype)) {}
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
      paramString2 = Cipher.getInstance("AES/CBC/NoPadding");
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
  
  public static void b()
  {
    if ((jdField_a_of_type_Bisl != null) && (jdField_a_of_type_Bisl.isShowing())) {}
    try
    {
      jdField_a_of_type_Bisl.cancel();
      jdField_a_of_type_Bisl = null;
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
    bhdj.a(paramContext, 230, paramContext.getString(2131698169), paramContext.getString(2131698170), new admx(), null).show();
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new bisy(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131299080), 0, paramInt2);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    DiscussionInfo localDiscussionInfo;
    int i;
    if (paramInt == 3000)
    {
      localDiscussionInfo = ((antp)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramString);
      if (localDiscussionInfo != null) {
        if (localDiscussionInfo.isPSTNConf())
        {
          AudioHelper.b("发起音视频_获取会议id");
          adnk.a("ChatActivityUtils", localDiscussionInfo.uin, new adms(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
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
        bhgf.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin(), new admt(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static boolean b(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramSessionInfo.curType);
      localJSONObject.put("uin", acnh.a(paramSessionInfo.curFriendUin));
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore curFriendUin:" + paramSessionInfo.curFriendUin + "  curType" + paramSessionInfo.curType);
      }
      paramSessionInfo = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "");
      if (!TextUtils.isEmpty(paramSessionInfo)) {}
      for (paramSessionInfo = new JSONArray(paramSessionInfo);; paramSessionInfo = new JSONArray())
      {
        paramSessionInfo.put(localJSONObject);
        paramSessionInfo = paramSessionInfo.toString();
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        paramContext.putString(paramString, paramSessionInfo);
        return paramContext.commit();
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool2 = false;
    int i = paramSessionInfo.curType;
    boolean bool1 = bool2;
    if (mbl.a().a(paramQQAppInterface.getCurrentAccountUin())) {
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
    long l1 = mur.a(paramBundle);
    QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, uinType[" + paramInt + "], uin[" + paramString + "], seq[" + l1 + "]");
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
    l1 = Long.parseLong(paramString);
    int i = mvk.b(paramInt);
    int j = localBundle.getInt("MultiAVType", 0);
    String str2 = localBundle.getString("Fromwhere");
    if (i == 2) {
      j = 1;
    }
    for (;;)
    {
      paramBundle = localBundle.getString("jump_from");
      localIntent.putExtras(localBundle);
      if ((("gvideo".equals(paramBundle)) || ("gvideo_h5".equals(paramBundle))) && (paramInt == 1))
      {
        i = 1;
        if (paramInt == 1)
        {
          paramBundle = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          if ((paramBundle == null) || (paramBundle.b(paramString) != null)) {
            break label893;
          }
        }
      }
      label893:
      for (boolean bool = false;; bool = true)
      {
        localIntent.putExtra("troopmember", bool);
        localIntent.putExtra("sessionType", 3);
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uinType", paramInt);
        localIntent.putExtra("Type", i);
        localIntent.putExtra("GroupId", paramString);
        localIntent.putExtra("MultiAVType", j);
        localIntent.putExtra("Fromwhere", str2);
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityUtils", 2, "createOrEnterGroupAudio, from[" + str2 + "]");
        }
        int k = localBundle.getInt("MeetingStasks", -1);
        if (k >= 0) {
          paramQQAppInterface.getAVNotifyCenter().b(k);
        }
        if (j != 2) {
          localIntent.setClass(paramContext, AVActivity.class);
        }
        mss.a(paramContext, paramString, j, new admu(i, paramInt, paramQQAppInterface, (bapk)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE), l1, localIntent, l1, "start_group_audio_time" + paramQQAppInterface.getCurrentAccountUin()));
        return;
        long l2 = paramQQAppInterface.getAVNotifyCenter().a(i, l1);
        paramBundle = "memberNum[" + l2;
        String str1;
        if (l2 > 0L)
        {
          k = paramQQAppInterface.getAVNotifyCenter().b(l1);
          str1 = paramBundle + "], srcAVType[" + k;
          if ((j != k) && (paramInt == 1))
          {
            paramBundle = paramQQAppInterface.getAVNotifyCenter().a(l1, j);
            str1 = str1 + "], VideoRoomInfo[" + paramBundle;
            if ((paramBundle != null) && (paramBundle.b == j) && (paramBundle.jdField_a_of_type_Int > 0))
            {
              i = 1;
              paramBundle = str1 + "], 1.TYPE_GAUDIO_STATUS_ENTER";
            }
          }
        }
        for (;;)
        {
          QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, " + paramBundle);
          break;
          i = 0;
          paramBundle = str1 + "], 2.TYPE_GAUDIO_STATUS_CREATE";
          continue;
          if (paramQQAppInterface.getAVNotifyCenter().a(i, l1))
          {
            i = 2;
            paramBundle = str1 + "], 3.TYPE_GAUDIO_STATUS_CHATING";
          }
          else
          {
            i = 1;
            paramBundle = str1 + "], 4.TYPE_GAUDIO_STATUS_ENTER";
            continue;
            k = 0;
            str1 = paramBundle + "], 5.TYPE_GAUDIO_STATUS_CREATE";
            paramBundle = str1;
            i = k;
            if (j == 2)
            {
              lne locallne = paramQQAppInterface.getAVNotifyCenter().a(l1, 2);
              paramBundle = str1;
              i = k;
              if (locallne != null)
              {
                paramBundle = str1;
                i = k;
                if (locallne.jdField_a_of_type_Int > 0)
                {
                  i = 1;
                  paramBundle = str1 + "], 6.TYPE_GAUDIO_STATUS_CREATE";
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */