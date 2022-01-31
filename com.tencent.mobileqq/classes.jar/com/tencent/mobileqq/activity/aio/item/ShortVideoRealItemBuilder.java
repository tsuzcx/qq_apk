package com.tencent.mobileqq.activity.aio.item;

import aael;
import aciy;
import acjt;
import acju;
import acjx;
import ackl;
import aclm;
import acmv;
import admg;
import adpb;
import adpc;
import adpd;
import adpe;
import adpf;
import adpg;
import adph;
import adpi;
import adwz;
import ahhk;
import ahke;
import ahtt;
import ahty;
import ahtz;
import ajjy;
import akhu;
import amym;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import aphp;
import aryq;
import atmo;
import atmp;
import atps;
import autt;
import auxb;
import avau;
import aweg;
import awei;
import awej;
import awer;
import awey;
import awfq;
import awhg;
import awje;
import awkk;
import awmd;
import awnh;
import awqx;
import awug;
import axou;
import axqf;
import axvo;
import axwd;
import azzz;
import baab;
import bace;
import badq;
import bakh;
import bakj;
import bbmy;
import begr;
import behe;
import bfcq;
import bfhl;
import bfhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.videoplayer.AIOBubbleVideoView;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.widget.ListView;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import urp;
import vjw;
import xgx;

public class ShortVideoRealItemBuilder
  extends admg
  implements acjx, aclm, awei, awnh
{
  protected static ColorDrawable a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static Map<Long, MessageForShortVideo> jdField_a_of_type_JavaUtilMap;
  public static CopyOnWriteArraySet<AIOBubbleVideoView> a;
  public static int c;
  public static int d;
  private static long d;
  protected static int e;
  protected static int f;
  public static boolean f;
  protected static int g;
  private static boolean g;
  protected static int h;
  private static boolean h;
  protected static int i;
  private ahty jdField_a_of_type_Ahty = new adph(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    axwd.b();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    jdField_d_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_e_of_type_Int;
    jdField_g_of_type_Int = Math.min(aciy.a(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = aciy.a(100.0F, localResources);
    i = aciy.a(100.0F, localResources);
    jdField_e_of_type_Int = aciy.a(awje.l, localResources);
    jdField_f_of_type_Int = aciy.a(awje.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new amym(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
  }
  
  public ShortVideoRealItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_c_of_type_Long = 0L;
    if (paramAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentWidgetListView = paramAIOAnimationConatiner.a();
    }
    ShortVideoUtils.a(paramQQAppInterface);
    awfq.a();
    h();
  }
  
  public static List<? extends atmo> a(atmp paramatmp, Class<? extends atmo> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramatmp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(adpi paramadpi, View paramView)
  {
    if (a(paramadpi))
    {
      if (paramadpi.b == null)
      {
        paramadpi.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramadpi.b.setImageResource(2130838098);
        paramadpi.b.setId(2131298571);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aciy.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131298552);
        localLayoutParams.addRule(0, 2131298552);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramadpi.b, localLayoutParams);
        }
      }
      a(paramadpi, true, this);
      return;
    }
    a(paramadpi, false, null);
  }
  
  private void a(adpi paramadpi, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653664, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          awkk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        ahhk.b("", "0X8006A1C");
        ahke.a("shortvideo_bubble", null);
        urp.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        if (bace.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramadpi, 2131652954);
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653700, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new auxb(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramadpi, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!bace.b(str));
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    bbmy.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131632246), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131167766));
  }
  
  private void a(adpi paramadpi, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramadpi.b != null)
      {
        paramadpi.b.setVisibility(0);
        paramadpi.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramadpi.b == null) {
      return;
    }
    paramadpi.b.setVisibility(8);
    paramadpi.b.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    awqx.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).b()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = xgx.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity))) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().f());
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      localBundle.putBoolean("extra.CAN_FORWARD_TO_GROUP_ALBUM", true);
      localBundle.putString("extra.GROUP_UIN", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putString("extra.GROUP_CODE", paramSessionInfo.b);
    }
    if ((paramSessionInfo.jdField_a_of_type_Int == 1) || (paramSessionInfo.jdField_a_of_type_Int == 3000))
    {
      localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 2);
      if (paramMessageForReplyText == null) {
        break label557;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label223:
      paramView = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramView.hasNext())
      {
        paramMessageForReplyText = (ActivityManager.RunningAppProcessInfo)paramView.next();
        if (paramMessageForReplyText.processName.endsWith("mobileqq")) {
          localBundle.putInt("extra.MOBILE_QQ_PROCESS_ID", paramMessageForReplyText.pid);
        }
      }
      paramView = paramMessageForShortVideo.selfuin;
      if (!paramMessageForShortVideo.isMultiMsg) {
        break label666;
      }
    }
    label666:
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        paramMessageForReplyText = paramView;
        if ((localAppRuntime instanceof QQAppInterface)) {
          paramMessageForReplyText = localAppRuntime.getAccount();
        }
        paramView = paramMessageForReplyText;
      }
      catch (Exception paramMessageForReplyText)
      {
        int k;
        label557:
        continue;
        if (!(paramContext instanceof ChatHistoryActivity)) {
          continue;
        }
        int j = 2;
        continue;
        j = k;
        if (!(paramContext instanceof PublicFragmentActivity)) {
          continue;
        }
        j = k;
        if (!(((PublicFragmentActivity)paramContext).a() instanceof ChatHistoryBubbleListForTroopFragment)) {
          continue;
        }
        j = 2;
        continue;
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bfcq.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), adwz.a(paramMessageForShortVideo), -1, j);
        continue;
      }
      localBundle.putInt("forward_source_uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      k = -1;
      if ((paramContext instanceof SplashActivity))
      {
        j = 1;
        localBundle.putBoolean("muate_play", paramBoolean1);
        localBundle.putBoolean("is_one_item", paramBoolean2);
        localBundle.putBoolean("is_ReplyMsg_From_Same_Session", paramBoolean3);
        localBundle.putBoolean(bfcq.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!azzz.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bfcq.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), adwz.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new auxb(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ShortVideoUtils.a(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label223;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      ahtz localahtz = new ahtz(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new ahtt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localahtz, paramMessageForShortVideo);
      ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((ahtt)localObject).a(this.jdField_a_of_type_Ahty);
      ((ahtt)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, paramadpi, paramMessageForShortVideo, paramBoolean2));
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramMessageRecord = "ShortVideoRealItemBuilder" + "[" + paramMessageRecord.uniseq + "]";
      QLog.i("ShortVideoRealItemBuilder", 2, paramMessageRecord + ":content " + paramString);
    }
  }
  
  private boolean a(adpi paramadpi)
  {
    boolean bool2 = true;
    if ((paramadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label205;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramadpi = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((j == 0) || (k == 0)) {
            break label210;
          }
          bool1 = true;
          QLog.i("ShortVideoRealItemBuilder", 2, bool1);
        }
        label169:
        if ((j == 0) || (k == 0)) {
          break label216;
        }
      }
      label205:
      label210:
      label216:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        return bool1;
        j = 0;
        break;
        k = 0;
        break label110;
        bool1 = false;
        break label169;
      }
    }
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    aryq localaryq = (aryq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    if (localaryq != null)
    {
      paramMessageForShortVideo = localaryq.a(localaryq.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask != null)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.progressTask = null;
      }
      jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
      if (jdField_a_of_type_JavaUtilMap.size() != 0)
      {
        localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label308;
        }
      }
    }
    label308:
    for (Object localObject = (MessageForShortVideo)((Map.Entry)((Iterator)localObject).next()).getValue();; localObject = null)
    {
      if (localObject != null)
      {
        ThreadManager.postImmediately(new ShortVideoRealItemBuilder.9(this, (MessageForShortVideo)localObject), null, true);
        jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(((MessageForShortVideo)localObject).uniseq));
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + ((MessageForShortVideo)localObject).uniseq + "] start upload!");
        }
      }
      return;
      localObject = "";
      break;
    }
  }
  
  private void b(adpi paramadpi, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramadpi != null) && (paramadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramadpi, false, null);
      }
      paramadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return awug.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
  }
  
  private void c(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.progressTask != null))
    {
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
      paramMessageForShortVideo.progressTask = null;
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "pauseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null) {
          localAIOBubbleVideoView.a();
        }
      }
    }
  }
  
  public static void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "resumeAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null) {
          localAIOBubbleVideoView.b();
        }
      }
    }
  }
  
  public static void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "releaseAllVideo");
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (localIterator.hasNext())
      {
        AIOBubbleVideoView localAIOBubbleVideoView = (AIOBubbleVideoView)localIterator.next();
        if (localAIOBubbleVideoView != null)
        {
          localAIOBubbleVideoView.a(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localAIOBubbleVideoView);
        }
      }
    }
  }
  
  private void h()
  {
    int k = 720;
    int m = 540;
    Object localObject;
    int j;
    if (!jdField_g_of_type_Boolean)
    {
      localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.ShortVideoHDConfig.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), shortVideoHDConfig=" + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          if (!TextUtils.isEmpty(localObject[0])) {
            jdField_f_of_type_Boolean = localObject[0].equals("1");
          }
          j = k;
          if (TextUtils.isEmpty(localObject[1])) {}
        }
      }
    }
    try
    {
      j = Integer.parseInt(localObject[1]);
      k = m;
      if (!TextUtils.isEmpty(localObject[2])) {}
      try
      {
        k = Integer.parseInt(localObject[2]);
        jdField_c_of_type_Int = Math.max(j, k);
        jdField_d_of_type_Int = Math.min(j, k);
        jdField_g_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "initVideoHDConfig(), sReadHDConfig=" + jdField_g_of_type_Boolean + ", sHDEnable:" + jdField_f_of_type_Boolean + ", sHDMaxLength:" + jdField_c_of_type_Int + ", sHDMinLength:" + jdField_d_of_type_Int);
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          k = m;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        j = k;
      }
    }
  }
  
  private void i()
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
      {
        Object localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).b(false, false);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acjt a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (adpi)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView;
      }
    }
    return null;
  }
  
  public acju a()
  {
    return new adpi(this);
  }
  
  public adpi a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = aciy.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label225;
      }
      Object localObject = aciy.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = aciy.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof adpi))) {
          return (adpi)localObject;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + j + ", view = null");
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi =" + j + ", firstVisblePosi=" + m + ",lastVisblePosi=" + n + ",headerCount=" + k);
      }
    }
    for (;;)
    {
      return null;
      label225:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    a(paramChatMessage, paramView, this);
    a((adpi)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    adpi localadpi = (adpi)paramacju;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramacju = ShortVideoUtils.a(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramacju[0];
    int k = paramacju[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramacju = paramView;
    if (paramView == null)
    {
      paramacju = new RelativeLayout(localContext);
      paramView = new AIOBubbleVideoView(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, bool);
      paramView.setId(2131296697);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajjy.a(2131648285));
      paramacju.addView(paramView);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramacju.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130837739);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131296697);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131296697);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = aciy.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = aciy.a(10.0F, localResources);
      paramacju.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacju.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aciy.a(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131298592);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramacju.setOnClickListener(this);
      super.a(paramacju, paramacmv);
      localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView = paramView;
      localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localadpi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localadpi.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramacmv = localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramacmv.setContentDescription(ajjy.a(2131648247));
    }
    localadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramacmv.jdField_a_of_type_Boolean = localMessageForShortVideo.isSend();
    paramacmv.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    baab.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForShortVideo.isSend());
    localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9) || (localMessageForShortVideo.fileType == 20))
    {
      if ((localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003)) {
        b(localadpi);
      }
    }
    else
    {
      localadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView = localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.getLayoutParams();
      if (paramView != null) {
        break label1099;
      }
      paramView = new RelativeLayout.LayoutParams(j, k);
      localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLayoutParams(paramView);
      label667:
      paramView = localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramView != null) {
        break label1141;
      }
      paramView = new RelativeLayout.LayoutParams(j, k);
      localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      label701:
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localadpi, paramChatMessage);
          awkk.a(paramacju, localadpi, paramChatMessage, localContext);
        }
      }
      if (!baab.a().a(localMessageForShortVideo, "0X8007428"))
      {
        baab.a().a(localMessageForShortVideo, "0X8007428");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
      }
      if ((localMessageForShortVideo.CheckIsHotVideo()) && (!baab.a().a(localMessageForShortVideo, "0X8007EDB")))
      {
        baab.a().a(localMessageForShortVideo, "0X8007EDB");
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
      int m = Math.max(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      int n = Math.min(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      if ((!jdField_f_of_type_Boolean) || (m < jdField_c_of_type_Int) || (n < jdField_d_of_type_Int)) {
        break label1198;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localadpi.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (!bool) {
        break label1183;
      }
      paramChatMessage.rightMargin = aciy.a(8.0F + localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(), localResources);
      label975:
      localadpi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label984:
      if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) || (localMessageForShortVideo.videoFileStatus == 1005) || (localMessageForShortVideo.extraflag == 32768) || (localMessageForShortVideo.videoFileStatus == 1004)) {
        break label1599;
      }
      if (localMessageForShortVideo.isSendFromLocal())
      {
        paramView = localMessageForShortVideo.mThumbFilePath;
        paramChatMessage = paramView;
        if (bace.b(paramView)) {
          break label1223;
        }
        if (!TextUtils.isEmpty(localMessageForShortVideo.thumbMD5)) {
          break label1211;
        }
        paramacmv.a(axwd.a());
        a(localadpi);
        a(localMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
      }
    }
    label1099:
    label1141:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return paramacju;
            localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
            break;
            if ((paramView.width == j) && (paramView.height == k)) {
              break label667;
            }
            paramView.width = j;
            paramView.height = k;
            localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.setLayoutParams(paramView);
            break label667;
            if ((paramView.width == j) && (paramView.height == k)) {
              break label701;
            }
            paramView.width = j;
            paramView.height = k;
            localadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
            break label701;
            paramChatMessage.rightMargin = aciy.a(8.0F, localResources);
            break label975;
            localadpi.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label984;
            paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramacmv, paramChatMessage))
            {
              paramView = URLDrawable.URLDrawableOptions.obtain();
              paramView.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramView.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramView.mRequestWidth = j;
              paramView.mRequestHeight = k;
              paramacmv.a(URLDrawable.getDrawable(new File(paramChatMessage), paramView));
              if (localMessageForShortVideo.busiType == 1)
              {
                if (localMessageForShortVideo.progressTask == null)
                {
                  localMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, localMessageForShortVideo, localadpi);
                  this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
                  this.jdField_b_of_type_AndroidOsHandler.post(localMessageForShortVideo.progressTask);
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == localMessageForShortVideo.uniseq) || (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localMessageForShortVideo.uniseq))))) {
                  break label1487;
                }
              }
              for (j = 1;; j = 0)
              {
                if ((localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.md5)) || (j == 0) || (localMessageForShortVideo.busiType != 1)) {
                  break label1491;
                }
                if (jdField_h_of_type_Boolean) {
                  break label1493;
                }
                a(localMessageForShortVideo, null, false, true);
                return paramacju;
                if (localMessageForShortVideo.mShowProgressTask == null) {
                  localMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, localMessageForShortVideo, localadpi);
                }
                this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
                this.jdField_b_of_type_AndroidOsHandler.post(localMessageForShortVideo.mShowProgressTask);
                break;
              }
            }
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localMessageForShortVideo.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
      } while (!QLog.isColorLevel());
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + localMessageForShortVideo.uniseq + "] added, mEncoding:" + jdField_h_of_type_Boolean);
      return paramacju;
      paramView = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if ((bace.b(paramView)) && (bace.b(paramChatMessage))) {
        a(localadpi);
      }
      if ((!b(localMessageForShortVideo)) || (!bace.b(paramChatMessage)) || ((localMessageForShortVideo.isSendFromLocal()) && (localMessageForShortVideo.videoFileStatus != 1003) && (localMessageForShortVideo.videoFileStatus != 2003) && (localMessageForShortVideo.isMultiMsg != true))) {
        break label1913;
      }
      if (!localMessageForShortVideo.isSend()) {
        new auxb(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      a(localMessageForShortVideo, ajjy.a(2131648261) + paramChatMessage);
      a(localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, paramChatMessage, paramView, localMessageForShortVideo, j, k);
      b(localadpi);
      if ((vjw.a(localadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, localadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!baab.a().a(localadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
      {
        baab.a().a(localadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
        urp.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", vjw.a((MessageForShortVideo)localadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
      }
    } while (bace.b(paramView));
    label1183:
    label1198:
    label1211:
    label1223:
    label1487:
    label1491:
    label1493:
    a(localMessageForShortVideo);
    label1599:
    a(localMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    return paramacju;
    label1913:
    if (bace.b(paramView))
    {
      if (a(paramacmv, paramView))
      {
        a(localMessageForShortVideo, ajjy.a(2131648237) + paramView);
        paramBaseChatItemLayout = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBaseChatItemLayout.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBaseChatItemLayout.mRequestHeight = k;
        paramBaseChatItemLayout.mRequestWidth = j;
        paramView = URLDrawable.getDrawable(new File(paramView), paramBaseChatItemLayout);
        localadpi.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramView);
      }
      if ((bace.b(paramChatMessage)) || ((localMessageForShortVideo.isSend()) && (localMessageForShortVideo.md5 == null) && (localMessageForShortVideo.videoFileStatus == 1004)))
      {
        j = 0;
        if ((localMessageForShortVideo.videoFileStatus == 1005) || (localMessageForShortVideo.extraflag == 32768) || (localMessageForShortVideo.videoFileStatus == 1004)) {
          j = 1;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
        k = j;
        if (localMessageForShortVideo.isSendFromLocal())
        {
          k = j;
          if (localMessageForShortVideo.videoFileProgress < 100)
          {
            k = j;
            if (localMessageForShortVideo.videoFileStatus != 1003)
            {
              k = j;
              if (paramChatMessage == null) {
                k = 1;
              }
            }
          }
        }
        if (k != 0)
        {
          b(localMessageForShortVideo, localadpi, 2131652959);
          return paramacju;
        }
        if ((!ShortVideoUtils.a()) || (!b(localMessageForShortVideo)))
        {
          c(localMessageForShortVideo, localadpi);
          return paramacju;
        }
        if (ShortVideoUtils.a(localMessageForShortVideo.videoFileProgress, 10) <= 60) {}
        for (j = 1; (localMessageForShortVideo.busiType == 1) && (j != 0); j = 0)
        {
          if (localMessageForShortVideo.progress > 60) {
            localMessageForShortVideo.progress = 60;
          }
          a(localMessageForShortVideo, localadpi, localMessageForShortVideo.videoFileProgress, localMessageForShortVideo.progress);
          return paramacju;
        }
        a(localMessageForShortVideo, localadpi, localMessageForShortVideo.videoFileProgress, false);
        return paramacju;
      }
      if (localMessageForShortVideo.videoFileStatus == 2005) {
        c(localMessageForShortVideo, localadpi);
      }
      if (localMessageForShortVideo.videoFileStatus == 5002)
      {
        a(localMessageForShortVideo, ajjy.a(2131648252));
        b(localMessageForShortVideo, localadpi, 2131652954);
        return paramacju;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo, true))
      {
        a(localMessageForShortVideo, true);
        return paramacju;
      }
      if ((localMessageForShortVideo.videoFileStatus == 2001) || (localMessageForShortVideo.videoFileStatus == 2002) || (localMessageForShortVideo.videoFileStatus == 2000))
      {
        a(localMessageForShortVideo, localadpi, localMessageForShortVideo.videoFileProgress, false);
        return paramacju;
      }
      c(localMessageForShortVideo, localadpi);
      return paramacju;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, ajjy.a(2131648278));
      paramacmv.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localadpi, 2131652954);
      return paramacju;
    }
    a(localMessageForShortVideo, ajjy.a(2131648299));
    paramacmv.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(localMessageForShortVideo);
    return paramacju;
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    int m = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramackl = (adpi)paramackl;
    b(parambakh, this.jdField_a_of_type_AndroidContentContext);
    int k = m;
    if (!TextUtils.isEmpty(paramChatMessage.md5)) {
      if (paramChatMessage.mPreUpload)
      {
        k = m;
        if (TextUtils.isEmpty(paramChatMessage.mLocalMd5)) {}
      }
      else
      {
        String str = ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg");
        paramChatMessage = ShortVideoUtils.a(paramChatMessage, "mp4");
        k = m;
        if (bace.b(str)) {
          if ((paramackl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramackl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
            break label185;
          }
        }
      }
    }
    label185:
    for (int j = 1;; j = 0)
    {
      k = m;
      if (j == 0)
      {
        parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
        k = m;
        if (bace.b(paramChatMessage)) {
          k = 1;
        }
      }
      if (k != 0) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      return parambakh;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajjy.a(2131648300);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!bace.b(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = bace.b(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo == null) {
        break label98;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
      boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
      if (bool) {
        break label98;
      }
    }
    catch (Exception paramMessageForShortVideo)
    {
      for (;;)
      {
        paramMessageForShortVideo.printStackTrace();
        paramMessageForShortVideo = null;
      }
    }
    return paramMessageForShortVideo;
  }
  
  public void a()
  {
    super.a();
    Object localObject1 = jdField_a_of_type_JavaUtilMap.values().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageForShortVideo)((Iterator)localObject1).next();
      if (((MessageForShortVideo)localObject2).progressTask != null) {
        ((MessageForShortVideo)localObject2).progressTask = null;
      }
    }
    if (jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet != null)
    {
      localObject1 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AIOBubbleVideoView)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          long l = ((AIOBubbleVideoView)localObject2).a();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = baab.a().a(Integer.valueOf(((AIOBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((AIOBubbleVideoView)localObject2).a(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localObject2);
        }
      }
    }
    jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidContentContext = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((localObject1 != null) && (((MessageForShortVideo)localObject1).progressTask != null)) {
      ((MessageForShortVideo)localObject1).progressTask = null;
    }
    this.jdField_a_of_type_ComTencentWidgetListView = null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForShortVideo localMessageForShortVideo;
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForShortVideo)))
    {
      localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
      if (paramInt != 2131299417) {
        break label77;
      }
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      urp.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131304871)
        {
          super.d(paramChatMessage);
          urp.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131301021)
        {
          paramInt = atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            urp.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            b(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
            return;
            if (paramInt == 2) {
              paramContext = "2";
            } else if (paramInt == 0) {
              paramContext = "3";
            } else {
              paramContext = "4";
            }
          }
        }
        if (paramInt != 2131300328) {
          break;
        }
        bfhl.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bfhz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        urp.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131304829)
      {
        super.a(localMessageForShortVideo);
        urp.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131299379)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131304932) {
        break label652;
      }
      paramContext = a(localMessageForShortVideo.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoRealItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, mr.uniseq = " + localMessageForShortVideo.uniseq);
    return;
    a(paramContext, localMessageForShortVideo, true);
    awqx.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label652:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onStateChange , state =  " + paramInt + ", msgUniseq = " + paramLong);
    }
    if (paramInt == 3)
    {
      paramObject = baab.a().a(Long.valueOf(paramLong));
      if ((paramObject != null) && (!baab.a().a(Long.valueOf(paramLong))))
      {
        ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E51", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObject, this.jdField_a_of_type_AndroidContentContext);
        if (!baab.a().b(Long.valueOf(paramObject.uniseq)))
        {
          baab.a().a(Long.valueOf(paramObject.uniseq));
          ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8008E50", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObject, this.jdField_a_of_type_AndroidContentContext);
        }
        baab.a().a(Long.valueOf(paramLong), true);
      }
    }
    paramObject = a(paramLong);
    if (paramObject == null) {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "holder == null, msgUniseq = " + paramLong);
      }
    }
    label205:
    do
    {
      do
      {
        do
        {
          do
          {
            break label205;
            break label205;
            do
            {
              return;
            } while (paramInt == 4);
            if ((paramInt != 6) && (paramInt != 7)) {
              break;
            }
            this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
            paramObject.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
            a(paramObject);
          } while (paramInt != 7);
          paramObject = baab.a().a(Long.valueOf(paramLong));
        } while (paramObject == null);
        a(paramObject, paramObject.videoFileTime * 1000);
        return;
      } while (paramInt != 3);
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      b(paramObject);
      paramObject = baab.a().a(Long.valueOf(paramLong));
    } while (paramObject == null);
    a(paramObject, 0L);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onLoopBack, id = " + paramLong1);
    }
    a(baab.a().a(Long.valueOf(paramLong1)), paramLong2);
  }
  
  public void a(long paramLong, String paramString) {}
  
  protected void a(adpi paramadpi)
  {
    if (!paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new adpf(this, paramadpi));
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (adpi)aciy.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbegr.a(2131624443, 5);
      localbegr.c(2131625035);
      localbegr.a(new adpd(this, localMessageForShortVideo, paramView, localbegr));
      localbegr.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.c("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, axqf paramaxqf, int paramInt1, int paramInt2)
  {
    paramView = aciy.a(paramView);
    if (!(paramView instanceof adpi)) {}
    MessageForShortVideo localMessageForShortVideo;
    label96:
    int j;
    int k;
    label368:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  paramView = (adpi)paramView;
                  localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                } while (localMessageForShortVideo.uniseq != paramaxqf.jdField_b_of_type_Long);
                this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
                if (localMessageForShortVideo.mShowProgressTask != null) {
                  localMessageForShortVideo.mShowProgressTask = null;
                }
              } while (this.jdField_a_of_type_AndroidContentContext == null);
              localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
              if (localMessageForShortVideo.thumbWidth > 0)
              {
                paramInt1 = localMessageForShortVideo.thumbWidth;
                if (localMessageForShortVideo.thumbHeight <= 0) {
                  break label368;
                }
              }
              for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
              {
                j = aciy.a(paramInt1, (Resources)localObject);
                k = aciy.a(paramInt2, (Resources)localObject);
                if ((paramaxqf.jdField_b_of_type_Int != 6) && (paramaxqf.jdField_b_of_type_Int != 17) && (paramaxqf.jdField_b_of_type_Int != 9) && (paramaxqf.jdField_b_of_type_Int != 20)) {
                  break label1313;
                }
                switch (paramaxqf.jdField_d_of_type_Int)
                {
                default: 
                  return;
                case 1001: 
                  a(localMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + localMessageForShortVideo.videoFileProgress);
                  if (localMessageForShortVideo.busiType != 1) {
                    a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
                  }
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                  ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
                  return;
                  paramInt1 = 100;
                  break label96;
                }
              }
              a(paramView, false, null);
              ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              a(localMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + localMessageForShortVideo.videoFileProgress);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
              c(localMessageForShortVideo);
              a(localMessageForShortVideo.mVideoFileSourceDir);
              a(localMessageForShortVideo, paramView, 100, true);
              a(paramView, false, null);
              ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
              c(localMessageForShortVideo);
              b(localMessageForShortVideo, paramView, 2131652959);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
              c(localMessageForShortVideo);
              a(paramView);
              b(localMessageForShortVideo, paramView, 2131652959);
              b(paramView, true, this);
              ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              paramInt1 = localMessageForShortVideo.videoFileProgress;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
              a(localMessageForShortVideo, paramView, paramInt1);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_RECV_START");
              a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED");
              if (!b(localMessageForShortVideo)) {
                break;
              }
              paramaxqf = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
              a(localMessageForShortVideo, ajjy.a(2131648282) + paramaxqf);
              if ((ShortVideoUtils.a()) && (bace.b(paramaxqf)))
              {
                a(localMessageForShortVideo, ajjy.a(2131648294) + paramaxqf);
                localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
                a(paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, paramaxqf, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
                b(paramView);
                if (!localMessageForShortVideo.isSend()) {
                  new auxb(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                }
              }
              a(localMessageForShortVideo, paramView, 100, true);
            } while (!localMessageForShortVideo.isMultiMsg);
            a(paramView);
            return;
            paramaxqf = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
            if ((bace.b(paramaxqf)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, paramaxqf)))
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = k;
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramaxqf = URLDrawable.getDrawable(new File(paramaxqf), (URLDrawable.URLDrawableOptions)localObject);
              paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramaxqf);
            }
            c(localMessageForShortVideo, paramView);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
            b(localMessageForShortVideo, paramView, 2131652953);
            if (localMessageForShortVideo.uiOperatorFlag == 2)
            {
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653674, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
              return;
            }
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653699, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
            a(paramView);
            c(localMessageForShortVideo, paramView);
          } while (paramaxqf.jdField_g_of_type_Int == -5100528);
          bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131653701, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          paramaxqf = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          if ((bace.b(paramaxqf)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, paramaxqf)))
          {
            a(localMessageForShortVideo, ajjy.a(2131648260) + paramaxqf);
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            paramaxqf = URLDrawable.getDrawable(new File(paramaxqf), (URLDrawable.URLDrawableOptions)localObject);
            paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(paramaxqf);
          }
          b(localMessageForShortVideo, paramView, 2131652954);
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForShortVideo.videoFileProgress;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForShortVideo, paramView, paramInt1, true);
          return;
        } while ((paramaxqf.jdField_b_of_type_Int != 7) && (paramaxqf.jdField_b_of_type_Int != 18) && (paramaxqf.jdField_b_of_type_Int != 16));
        switch (paramaxqf.jdField_d_of_type_Int)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          paramaxqf = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
          if ((!bace.b(paramaxqf)) || (!b(localMessageForShortVideo))) {
            break label1504;
          }
          a(localMessageForShortVideo, ajjy.a(2131648254) + (String)localObject);
        }
      } while (!ShortVideoUtils.a());
      a(paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, paramaxqf, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      b(paramView);
      return;
      if (!bace.b((String)localObject)) {
        break;
      }
    } while (!a(paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, (String)localObject));
    label1313:
    label1504:
    a(localMessageForShortVideo, ajjy.a(2131648242) + (String)localObject);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = k;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    Object localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
    paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a((Drawable)localObject);
    if (!bace.b(paramaxqf))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo, true))
      {
        a(localMessageForShortVideo, true);
        return;
      }
      c(localMessageForShortVideo, paramView);
      return;
    }
    if (ShortVideoUtils.a())
    {
      a(paramView);
      return;
    }
    c(localMessageForShortVideo, paramView);
    return;
    paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(axwd.a());
    return;
    a(localMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    paramaxqf = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (bace.b(paramaxqf))
    {
      a(localMessageForShortVideo, ajjy.a(2131648239) + paramaxqf);
      if (ShortVideoUtils.a())
      {
        localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
        a(paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView, paramaxqf, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
        b(paramView);
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramView.jdField_a_of_type_ComTencentMobileqqShortvideoVideoplayerAIOBubbleVideoView.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165222);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.jdField_g_of_type_Int, j, BaseChatItemLayout.jdField_h_of_type_Int);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_g_of_type_Int, BaseChatItemLayout.j, BaseChatItemLayout.jdField_h_of_type_Int);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, adpi paramadpi, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramadpi.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label40;
      }
    }
    label40:
    label108:
    do
    {
      do
      {
        return;
        paramadpi.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new adpb(this, paramQQAppInterface);
        paramadpi = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131653677));
        paramadpi.setSpan(new ForegroundColorSpan(-1), 0, paramadpi.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramadpi, paramQQAppInterface, awkk.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!awhg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break;
        }
      } while (paramadpi.jdField_e_of_type_Int == 2);
      paramadpi.jdField_e_of_type_Int = 2;
      boolean bool3 = autt.a();
      boolean bool4 = awmd.g(paramQQAppInterface);
      paramQQAppInterface = new adpc(this, bool3, bool4, paramQQAppInterface);
      paramadpi = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131653665));
      paramadpi.setSpan(new ForegroundColorSpan(-1), 0, paramadpi.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramadpi, paramQQAppInterface, bool1);
      return;
    } while (paramadpi.jdField_e_of_type_Int == 0);
    paramadpi.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    awey localawey = aweg.a(2, 2);
    awej localawej = paramMessageForShortVideo.getDownloadInfo(localawey.jdField_b_of_type_Int);
    localawej.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localawej.a(paramMessageForShortVideo.istroop, 1);
    localawej.jdField_f_of_type_Int = 2;
    localawej.jdField_g_of_type_Int = 2;
    localawey.a(localawej);
    localawey.a(paramMessageForShortVideo);
    aweg.a(localawey, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!baab.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      baab.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bace.b((String)localObject))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653706, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      paramadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!bace.b(str))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      paramadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = aweg.a(1, 2);
    ((awey)localObject).a(aweg.a(2, paramMessageForShortVideo, (awey)localObject));
    aweg.a((awey)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramadpi, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi, int paramInt)
  {
    int j = ShortVideoUtils.a(paramInt, 10);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (j < 60) {
        return;
      }
      if (paramMessageForShortVideo.progressTask != null)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        paramMessageForShortVideo.progressTask = null;
        a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS CLOSE_TASK PROCESS:" + j);
      }
    }
    a(paramMessageForShortVideo, paramadpi, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.a(paramInt2, 0);
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (badq.d(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi, int paramInt, boolean paramBoolean)
  {
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    int k = 1;
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, ajjy.a(2131648259));
      return;
    }
    Object localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      j = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (j == 0)) {
        break label104;
      }
    }
    label104:
    for (int j = 1;; j = 0)
    {
      if (j != 0) {
        break label109;
      }
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653216, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      return;
      j = 0;
      break;
    }
    label109:
    localObject = aweg.a(2, 2);
    awej localawej = paramMessageForShortVideo.getDownloadInfo(((awey)localObject).jdField_b_of_type_Int);
    localawej.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localawej.a(paramMessageForShortVideo.istroop, 0);
    j = k;
    if (paramBoolean) {
      j = 2;
    }
    localawej.jdField_f_of_type_Int = j;
    localawej.jdField_g_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localawej.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
    }
    ((awey)localObject).a(localawej);
    ((awey)localObject).a(paramMessageForShortVideo);
    aweg.a((awey)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  protected void a(AIOBubbleVideoView paramAIOBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    String str;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideoByPath uniseq=").append(paramMessageForShortVideo.uniseq).append(", videoPath = ");
      if (paramString1 != null)
      {
        str = paramString1;
        localStringBuilder = localStringBuilder.append(str).append(", thumbPath = ");
        if (paramString2 == null) {
          break label150;
        }
        str = paramString2;
        label64:
        QLog.d("ShortVideoRealItemBuilder", 2, str);
      }
    }
    else
    {
      paramAIOBubbleVideoView.setLogID(paramMessageForShortVideo.uniseq);
      paramAIOBubbleVideoView.setPlayBusiType("bus_type_aio_short_bubble");
      paramMessageForShortVideo = new amym(-10065297, 100, 100);
      if (!TextUtils.isEmpty(paramString2)) {
        break label158;
      }
      paramAIOBubbleVideoView.setCoverDrawable(paramMessageForShortVideo);
    }
    for (;;)
    {
      paramAIOBubbleVideoView.setMute(true);
      paramAIOBubbleVideoView.setVideoPlayerCallback(this);
      paramAIOBubbleVideoView.a(paramString1, true);
      return;
      str = "null";
      break;
      label150:
      str = "null";
      break label64;
      label158:
      paramAIOBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.a(paramString2).toString(), paramInt1, paramInt2, paramMessageForShortVideo, paramMessageForShortVideo));
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new ShortVideoRealItemBuilder.3(this, paramString), 5, null, false);
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (paramChatMessage.isMultiMsg) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!paramChatMessage.isSendFromLocal());
        paramChatMessage = (MessageForShortVideo)paramChatMessage;
        if ((paramChatMessage.md5 == null) && (paramChatMessage.videoFileStatus == 1004)) {
          return true;
        }
      } while ((paramChatMessage.md5 == null) || (paramChatMessage.videoFileStatus == 5002));
      if ((paramChatMessage.busiType == 1) && (paramChatMessage.uiOperatorFlag == 1) && (paramChatMessage.videoFileStatus == 1004)) {
        return true;
      }
      paramBaseChatItemLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramChatMessage.frienduin, paramChatMessage.uniseq);
      if ((paramBaseChatItemLayout instanceof axou))
      {
        if (((axou)paramBaseChatItemLayout).c() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003));
    return true;
  }
  
  protected boolean a(AIOBubbleVideoView paramAIOBubbleVideoView, String paramString)
  {
    paramAIOBubbleVideoView = paramAIOBubbleVideoView.a();
    if (paramAIOBubbleVideoView == null) {
      return true;
    }
    return (!(paramAIOBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramAIOBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = (adpi)aciy.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbakh, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbakh.a();
      label48:
      b(localbakh, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    int n = 1;
    int k = 0;
    int j = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramackl = (adpi)paramackl;
    b(parambakh, this.jdField_a_of_type_AndroidContentContext);
    int m;
    label160:
    int i1;
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a(paramChatMessage, "mp4");
      if (bace.b(str1)) {
        if ((paramackl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramackl.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
            a(paramChatMessage, parambakh);
            k = n;
            if (bace.b(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
              i1 = k;
            }
          }
        }
      }
    }
    for (n = j;; n = k)
    {
      a(parambakh, paramChatMessage);
      if (n != 0) {
        parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626722), 2130838598);
      }
      if (i1 != 0) {
        b(paramChatMessage, parambakh);
      }
      super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
      super.d(parambakh, this.jdField_a_of_type_AndroidContentContext);
      return parambakh;
      k = 0;
      break label160;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  protected void b(adpi paramadpi)
  {
    if (!paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramadpi.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new adpg(this, paramadpi));
    }
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5)) {
      a(paramMessageForShortVideo, "Forward menu clicked, md5 is empty.");
    }
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
      localBundle.putString("forward_thumb", str1);
      localBundle.putString("from_uin", ShortVideoUtils.d(paramMessageForShortVideo));
      localBundle.putInt("from_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      localBundle.putString("from_session_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
      localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
      localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
      localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
      localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
      localBundle.putInt("selection_mode", this.jdField_b_of_type_Int);
      String str2 = ShortVideoUtils.c(paramMessageForShortVideo);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
      }
      localBundle.putString("file_send_path", str2);
      localBundle.putString("thumbfile_send_path", str1);
      localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
      if (!TextUtils.isEmpty(paramMessageForShortVideo.mLocalMd5)) {
        localBundle.putString("file_shortvideo_local_md5", paramMessageForShortVideo.mLocalMd5);
      }
      localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
      localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
      localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
      localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
      localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
      localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
      localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
      localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
      localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
      localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
      localBundle.putLong("from_msg_uniseq", paramMessageForShortVideo.uniseq);
      if (paramMessageForShortVideo.CheckIsHotVideo())
      {
        localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
        localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
        localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
        localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
      }
      if ((paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) && (paramMessageForShortVideo.isSend()))
      {
        localBundle.putInt("param_key_redbag_type", paramMessageForShortVideo.redBagType);
        localBundle.putString("param_key_redbag_video_id", paramMessageForShortVideo.shortVideoId);
      }
      if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId)) {
        localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!bace.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131653707, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
      paramadpi.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramadpi = aweg.a(4, 2);
      paramadpi.a(aweg.a(2, paramMessageForShortVideo, paramadpi));
      aweg.a(paramadpi, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi, int paramInt)
  {
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848457);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramadpi.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  void c(MessageForShortVideo paramMessageForShortVideo, adpi paramadpi)
  {
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramadpi.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramadpi.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    super.d();
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((l - jdField_d_of_type_Long < 500L) && (l > jdField_d_of_type_Long)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoRealItemBuilder", 2, "click too offen, please try again later!");
      }
    }
    Object localObject;
    MessageForShortVideo localMessageForShortVideo;
    StringBuilder localStringBuilder1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              jdField_d_of_type_Long = l;
              localObject = (AppActivity)this.jdField_a_of_type_AndroidContentContext;
              if ((localObject != null) && (Build.VERSION.SDK_INT >= 23) && (!akhu.a((Context)localObject)))
              {
                akhu.a((AppActivity)localObject, 3, new adpe(this, (AppActivity)localObject));
                return;
              }
              if (paramView.getId() != 2131298580) {
                break;
              }
              localObject = (MessageRecord)paramView.getTag();
            } while (localObject == null);
            ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
            return;
            localObject = (adpi)aciy.a(paramView);
            localMessageForShortVideo = (MessageForShortVideo)((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          } while (paramView.getId() == 2131298594);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
          {
            bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131630481, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
            return;
          }
          if (paramView.getId() == 2131298552) {
            a((adpi)localObject, localMessageForShortVideo, false);
          }
          if (paramView.getId() != 2131298571) {
            break;
          }
        } while (((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        if ((!(paramView instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)paramView).jdField_g_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
      return;
      localStringBuilder1 = new StringBuilder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!(paramView instanceof ShortVideoUploadProcessor)) {
        break;
      }
      ((ShortVideoUploadProcessor)paramView).c();
      localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
      ShortVideoUtils.c("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
    return;
    ahtt localahtt = (ahtt)ahtt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
    if (localahtt != null)
    {
      paramView = Long.valueOf(localahtt.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      label464:
      paramView = localStringBuilder2.append(paramView).append(", msgUniseq:").append(((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
      if ((localahtt == null) || (!localahtt.jdField_a_of_type_Boolean)) {
        break label657;
      }
    }
    label657:
    for (boolean bool = true;; bool = false)
    {
      paramView.append(bool);
      if ((localahtt == null) || (localahtt.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != ((adpi)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localahtt.a())) {
        break;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
      localMessageForShortVideo.progressTask = null;
      localMessageForShortVideo.videoFileStatus = 1004;
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      avau.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      i();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
      jdField_h_of_type_Boolean = false;
      break;
      paramView = "-1";
      break label464;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */