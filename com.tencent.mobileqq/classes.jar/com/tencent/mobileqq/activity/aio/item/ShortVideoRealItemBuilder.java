package com.tencent.mobileqq.activity.aio.item;

import aanz;
import actj;
import acui;
import acuj;
import acum;
import acva;
import acwb;
import acxj;
import adxd;
import adzy;
import adzz;
import aeaa;
import aeab;
import aeac;
import aead;
import aeae;
import aeaf;
import aehw;
import ahtz;
import ahwu;
import aigj;
import aigo;
import aigp;
import ajya;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
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
import anoz;
import aqbe;
import asuw;
import auko;
import aukp;
import auns;
import avte;
import avwu;
import awap;
import axdq;
import axds;
import axdt;
import axeb;
import axei;
import axfa;
import axgo;
import axim;
import axjs;
import axll;
import axqy;
import axuk;
import aypb;
import ayqo;
import ayvx;
import aywm;
import bbbr;
import bbbt;
import bbdx;
import bbfj;
import bbmf;
import bbmh;
import bbwg;
import bcql;
import bfpc;
import bfpp;
import bgky;
import bgpu;
import bgqi;
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
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.videoplatform.CropBubbleVideoView;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vei;
import vwp;
import xpu;

public class ShortVideoRealItemBuilder
  extends adxd
  implements acum, acwb, axds
{
  protected static ColorDrawable a;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static Map<Long, MessageForShortVideo> jdField_a_of_type_JavaUtilMap;
  public static CopyOnWriteArraySet<CropBubbleVideoView> a;
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
  private aigo jdField_a_of_type_Aigo = new aeae(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    aywm.b();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    jdField_d_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_e_of_type_Int;
    jdField_g_of_type_Int = Math.min(actj.a(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = actj.a(100.0F, localResources);
    i = actj.a(100.0F, localResources);
    jdField_e_of_type_Int = actj.a(axim.l, localResources);
    jdField_f_of_type_Int = actj.a(axim.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new anoz(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
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
    axfa.a();
    h();
  }
  
  public static List<? extends auko> a(aukp paramaukp, Class<? extends auko> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukp.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
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
          break label303;
        }
      }
    }
    label303:
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
  
  private void a(aeaf paramaeaf, View paramView)
  {
    if (a(paramaeaf))
    {
      if (paramaeaf.b == null)
      {
        paramaeaf.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramaeaf.b.setImageResource(2130838105);
        paramaeaf.b.setId(2131364128);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = actj.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364109);
        localLayoutParams.addRule(0, 2131364109);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramaeaf.b, localLayoutParams);
        }
      }
      a(paramaeaf, true, this);
      return;
    }
    a(paramaeaf, false, null);
  }
  
  private void a(aeaf paramaeaf, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719559, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          axjs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        ahtz.b("", "0X8006A1C");
        ahwu.a("shortvideo_bubble", null);
        vei.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        if (bbdx.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramaeaf, 2131718790);
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719595, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new avwu(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramaeaf, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!bbdx.b(str));
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    bcql.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697981), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298865));
  }
  
  private void a(aeaf paramaeaf, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramaeaf.b != null)
      {
        paramaeaf.b.setVisibility(0);
        paramaeaf.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramaeaf.b == null) {
      return;
    }
    paramaeaf.b.setVisibility(8);
    paramaeaf.b.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = xpu.a(paramView);
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
        break label556;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label222:
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
        break label665;
      }
    }
    label665:
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
        label556:
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
        bgky.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aehw.a(paramMessageForShortVideo), -1, j);
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
        localBundle.putBoolean(bgky.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!bbbr.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bgky.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aehw.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new avwu(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ShortVideoUtils.a(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label222;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      aigp localaigp = new aigp(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new aigj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localaigp, paramMessageForShortVideo);
      aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((aigj)localObject).a(this.jdField_a_of_type_Aigo);
      ((aigj)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, paramaeaf, paramMessageForShortVideo, paramBoolean2));
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
  
  private boolean a(aeaf paramaeaf)
  {
    boolean bool2 = true;
    if ((paramaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label204;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramaeaf = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
          if ((j == 0) || (k == 0)) {
            break label209;
          }
          bool1 = true;
          QLog.i("ShortVideoRealItemBuilder", 2, bool1);
        }
        label169:
        if ((j == 0) || (k == 0)) {
          break label215;
        }
      }
      label204:
      label209:
      label215:
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
    asuw localasuw = (asuw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    if (localasuw != null)
    {
      paramMessageForShortVideo = localasuw.a(localasuw.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(aeaf paramaeaf, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramaeaf != null) && (paramaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramaeaf, false, null);
      }
      paramaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return axuk.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
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
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.c();
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
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null) {
          localCropBubbleVideoView.b();
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
        CropBubbleVideoView localCropBubbleVideoView = (CropBubbleVideoView)localIterator.next();
        if (localCropBubbleVideoView != null)
        {
          localCropBubbleVideoView.a(false);
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.remove(localCropBubbleVideoView);
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
  
  public acui a(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
    {
      paramView = (aeaf)((View)paramView.getParent()).getTag();
      if (paramView != null) {
        return paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView;
      }
    }
    return null;
  }
  
  public acuj a()
  {
    return new aeaf(this);
  }
  
  public aeaf a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = actj.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label223;
      }
      Object localObject = actj.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = actj.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof aeaf))) {
          return (aeaf)localObject;
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
      label223:
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "getHolderByMsg() uniseq=" + paramLong + ", posi<= -1");
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    a(paramChatMessage, paramView, this);
    a((aeaf)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    aeaf localaeaf = (aeaf)paramacuj;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramacuj = ShortVideoUtils.a(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramacuj[0];
    int k = paramacuj[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new RelativeLayout(localContext);
      paramView = new CropBubbleVideoView(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362237);
      paramView.setVisibility(0);
      paramView.setContentDescription(ajya.a(2131714084));
      paramacuj.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramacuj.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130837749);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362237);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362237);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = actj.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = actj.a(10.0F, localResources);
      paramacuj.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramacuj.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = actj.a(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364149);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramacuj.setOnClickListener(this);
      super.a(paramacuj, paramacxj);
      localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView = paramView;
      localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localaeaf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localaeaf.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramacxj = localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramacxj.setContentDescription(ajya.a(2131714046));
    }
    localaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramacxj.jdField_a_of_type_Boolean = localMessageForShortVideo.isSend();
    paramacxj.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    bbbt.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForShortVideo.isSend());
    localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9) || (localMessageForShortVideo.fileType == 20))
    {
      if ((localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003)) {
        b(localaeaf);
      }
    }
    else
    {
      localaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView = localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.getLayoutParams();
      if (paramView != null) {
        break label1110;
      }
      paramView = new RelativeLayout.LayoutParams(j, k);
      localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramView);
      label668:
      paramView = localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramView != null) {
        break label1152;
      }
      paramView = new RelativeLayout.LayoutParams(j, k);
      localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
      label702:
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localaeaf, paramChatMessage);
          axjs.a(paramacuj, localaeaf, paramChatMessage, localContext);
        }
      }
      if (!bbbt.a().a(localMessageForShortVideo, "0X8007428"))
      {
        bbbt.a().a(localMessageForShortVideo, "0X8007428");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
      }
      if ((localMessageForShortVideo.CheckIsHotVideo()) && (!bbbt.a().a(localMessageForShortVideo, "0X8007EDB")))
      {
        bbbt.a().a(localMessageForShortVideo, "0X8007EDB");
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
      int m = Math.max(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      int n = Math.min(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      if ((!jdField_f_of_type_Boolean) || (m < jdField_c_of_type_Int) || (n < jdField_d_of_type_Int)) {
        break label1209;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localaeaf.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (!bool) {
        break label1194;
      }
      paramChatMessage.rightMargin = actj.a(8.0F + localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(), localResources);
      label976:
      localaeaf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label985:
      if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) || (localMessageForShortVideo.videoFileStatus == 1005) || (localMessageForShortVideo.extraflag == 32768) || (localMessageForShortVideo.videoFileStatus == 1004)) {
        break label1621;
      }
      if (localMessageForShortVideo.isSendFromLocal())
      {
        paramView = localMessageForShortVideo.mThumbFilePath;
        paramChatMessage = paramView;
        if (bbdx.b(paramView)) {
          break label1234;
        }
        if (!TextUtils.isEmpty(localMessageForShortVideo.thumbMD5)) {
          break label1222;
        }
        paramacxj.setID(localMessageForShortVideo.uniseq);
        paramacxj.a(aywm.a());
        a(localaeaf);
        a(localMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
      }
    }
    label1110:
    label1510:
    label1514:
    label1516:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return paramacuj;
            localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
            break;
            if ((paramView.width == j) && (paramView.height == k)) {
              break label668;
            }
            paramView.width = j;
            paramView.height = k;
            localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setLayoutParams(paramView);
            break label668;
            if ((paramView.width == j) && (paramView.height == k)) {
              break label702;
            }
            paramView.width = j;
            paramView.height = k;
            localaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramView);
            break label702;
            paramChatMessage.rightMargin = actj.a(8.0F, localResources);
            break label976;
            localaeaf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label985;
            paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramacxj, paramChatMessage))
            {
              paramView = URLDrawable.URLDrawableOptions.obtain();
              paramView.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramView.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramView.mRequestWidth = j;
              paramView.mRequestHeight = k;
              paramChatMessage = URLDrawable.getDrawable(new File(paramChatMessage), paramView);
              paramacxj.setID(localMessageForShortVideo.uniseq);
              paramacxj.a(paramChatMessage);
              if (localMessageForShortVideo.busiType == 1)
              {
                if (localMessageForShortVideo.progressTask == null)
                {
                  localMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, localMessageForShortVideo, localaeaf);
                  this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
                  this.jdField_b_of_type_AndroidOsHandler.post(localMessageForShortVideo.progressTask);
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == localMessageForShortVideo.uniseq) || (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(localMessageForShortVideo.uniseq))))) {
                  break label1510;
                }
              }
              for (j = 1;; j = 0)
              {
                if ((localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.md5)) || (j == 0) || (localMessageForShortVideo.busiType != 1)) {
                  break label1514;
                }
                if (jdField_h_of_type_Boolean) {
                  break label1516;
                }
                a(localMessageForShortVideo, null, false, true);
                return paramacuj;
                if (localMessageForShortVideo.mShowProgressTask == null) {
                  localMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, localMessageForShortVideo, localaeaf);
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
      return paramacuj;
      paramView = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if ((!b(localMessageForShortVideo)) || (!bbdx.b(paramChatMessage)) || ((localMessageForShortVideo.isSendFromLocal()) && (localMessageForShortVideo.videoFileStatus != 1003) && (localMessageForShortVideo.videoFileStatus != 2003) && (localMessageForShortVideo.isMultiMsg != true))) {
        break label1909;
      }
      if (!localMessageForShortVideo.isSend()) {
        new avwu(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
      }
      a(localMessageForShortVideo, ajya.a(2131714060) + paramChatMessage);
      a(localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, paramChatMessage, paramView, localMessageForShortVideo, j, k);
      if ((vwp.a(localaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, localaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!bbbt.a().a(localaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
      {
        bbbt.a().a(localaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
        vei.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", vwp.a((MessageForShortVideo)localaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
      }
    } while (bbdx.b(paramView));
    label1152:
    label1194:
    label1209:
    label1222:
    label1234:
    label1621:
    a(localMessageForShortVideo);
    a(localMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    return paramacuj;
    label1909:
    if (bbdx.b(paramView))
    {
      if (a(paramacxj, paramView))
      {
        a(localMessageForShortVideo, ajya.a(2131714036) + paramView);
        paramBaseChatItemLayout = URLDrawable.URLDrawableOptions.obtain();
        paramBaseChatItemLayout.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBaseChatItemLayout.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
        paramBaseChatItemLayout.mRequestHeight = k;
        paramBaseChatItemLayout.mRequestWidth = j;
        paramView = URLDrawable.getDrawable(new File(paramView), paramBaseChatItemLayout);
        paramacxj.setID(localMessageForShortVideo.uniseq);
        localaeaf.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramView);
      }
      if ((bbdx.b(paramChatMessage)) || ((localMessageForShortVideo.isSend()) && (localMessageForShortVideo.md5 == null) && (localMessageForShortVideo.videoFileStatus == 1004)))
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
          b(localMessageForShortVideo, localaeaf, 2131718795);
          return paramacuj;
        }
        if ((!ShortVideoUtils.a()) || (!b(localMessageForShortVideo)))
        {
          c(localMessageForShortVideo, localaeaf);
          return paramacuj;
        }
        if (ShortVideoUtils.a(localMessageForShortVideo.videoFileProgress, 10) <= 60) {}
        for (j = 1; (localMessageForShortVideo.busiType == 1) && (j != 0); j = 0)
        {
          if (localMessageForShortVideo.progress > 60) {
            localMessageForShortVideo.progress = 60;
          }
          a(localMessageForShortVideo, localaeaf, localMessageForShortVideo.videoFileProgress, localMessageForShortVideo.progress);
          return paramacuj;
        }
        a(localMessageForShortVideo, localaeaf, localMessageForShortVideo.videoFileProgress, false);
        return paramacuj;
      }
      if (localMessageForShortVideo.videoFileStatus == 2005) {
        c(localMessageForShortVideo, localaeaf);
      }
      if (localMessageForShortVideo.videoFileStatus == 5002)
      {
        a(localMessageForShortVideo, ajya.a(2131714051));
        b(localMessageForShortVideo, localaeaf, 2131718790);
        return paramacuj;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo, true))
      {
        a(localMessageForShortVideo, true);
        return paramacuj;
      }
      if ((localMessageForShortVideo.videoFileStatus == 2001) || (localMessageForShortVideo.videoFileStatus == 2002) || (localMessageForShortVideo.videoFileStatus == 2000))
      {
        a(localMessageForShortVideo, localaeaf, localMessageForShortVideo.videoFileProgress, false);
        return paramacuj;
      }
      c(localMessageForShortVideo, localaeaf);
      return paramacuj;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, ajya.a(2131714077));
      paramacxj.setID(localMessageForShortVideo.uniseq);
      paramacxj.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localaeaf, 2131718790);
      return paramacuj;
    }
    a(localMessageForShortVideo, ajya.a(2131714098));
    paramacxj.setID(localMessageForShortVideo.uniseq);
    paramacxj.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(localMessageForShortVideo);
    return paramacuj;
  }
  
  public bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    int m = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramacva = (aeaf)paramacva;
    b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
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
        if (bbdx.b(str)) {
          if ((paramacva.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramacva.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
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
        parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
        k = m;
        if (bbdx.b(paramChatMessage)) {
          k = 1;
        }
      }
      if (k != 0) {
        parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      return parambbmf;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131714099);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!bbdx.b(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = bbdx.b(new File(paramMessageForShortVideo));
      if (paramMessageForShortVideo == null) {
        break label97;
      }
      paramMessageForShortVideo = paramMessageForShortVideo.replaceAll("[\\t\\n\\r]", "");
      boolean bool = TextUtils.isEmpty(paramMessageForShortVideo);
      if (bool) {
        break label97;
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
        localObject2 = (CropBubbleVideoView)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          long l = ((CropBubbleVideoView)localObject2).a();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = bbbt.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((CropBubbleVideoView)localObject2).a(false);
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
      if (paramInt != 2131364984) {
        break label77;
      }
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      vei.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131370536)
        {
          super.d(paramChatMessage);
          vei.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131366632)
        {
          paramInt = auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            vei.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            b(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
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
        if (paramInt != 2131365928) {
          break;
        }
        bgpu.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        bgqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        vei.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131370493)
      {
        super.a(localMessageForShortVideo);
        vei.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131364942)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131370597) {
        break label664;
      }
      paramContext = a(localMessageForShortVideo.uniseq);
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoRealItemBuilder", 2, "onMenuItemClicked(), mute_play, holder == null, mr.uniseq = " + localMessageForShortVideo.uniseq);
    return;
    a(paramContext, localMessageForShortVideo, true);
    axqy.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label664:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(aeaf paramaeaf)
  {
    if (!paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new aeac(this, paramaeaf));
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (aeaf)actj.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbfpc.a(2131689995, 5);
      localbfpc.c(2131690596);
      localbfpc.a(new aeab(this, localMessageForShortVideo, paramView, localbfpc));
      localbfpc.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.c("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, ayqo paramayqo, int paramInt1, int paramInt2)
  {
    paramView = actj.a(paramView);
    if (!(paramView instanceof aeaf)) {}
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
                  paramView = (aeaf)paramView;
                  localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                } while (localMessageForShortVideo.uniseq != paramayqo.jdField_b_of_type_Long);
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
                j = actj.a(paramInt1, (Resources)localObject);
                k = actj.a(paramInt2, (Resources)localObject);
                if ((paramayqo.jdField_b_of_type_Int != 6) && (paramayqo.jdField_b_of_type_Int != 17) && (paramayqo.jdField_b_of_type_Int != 9) && (paramayqo.jdField_b_of_type_Int != 20)) {
                  break label1335;
                }
                switch (paramayqo.jdField_d_of_type_Int)
                {
                default: 
                  return;
                case 1001: 
                  a(localMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + localMessageForShortVideo.videoFileProgress);
                  if (localMessageForShortVideo.busiType != 1) {
                    a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
                  }
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                  aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
                  return;
                  paramInt1 = 100;
                  break label96;
                }
              }
              a(paramView, false, null);
              aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              a(localMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + localMessageForShortVideo.videoFileProgress);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
              c(localMessageForShortVideo);
              a(localMessageForShortVideo.mVideoFileSourceDir);
              a(localMessageForShortVideo, paramView, 100, true);
              a(paramView, false, null);
              aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
              c(localMessageForShortVideo);
              b(localMessageForShortVideo, paramView, 2131718795);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
              c(localMessageForShortVideo);
              a(paramView);
              b(localMessageForShortVideo, paramView, 2131718795);
              b(paramView, true, this);
              aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
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
              paramayqo = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
              a(localMessageForShortVideo, ajya.a(2131714081) + paramayqo);
              if ((ShortVideoUtils.a()) && (bbdx.b(paramayqo)))
              {
                a(localMessageForShortVideo, ajya.a(2131714093) + paramayqo);
                localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
                a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, paramayqo, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
                if (!localMessageForShortVideo.isSend()) {
                  new avwu(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                }
              }
              a(localMessageForShortVideo, paramView, 100, true);
            } while (!localMessageForShortVideo.isMultiMsg);
            a(paramView);
            return;
            paramayqo = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
            if ((bbdx.b(paramayqo)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, paramayqo)))
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = k;
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              paramayqo = URLDrawable.getDrawable(new File(paramayqo), (URLDrawable.URLDrawableOptions)localObject);
              paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
              paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramayqo);
            }
            c(localMessageForShortVideo, paramView);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
            b(localMessageForShortVideo, paramView, 2131718789);
            if (localMessageForShortVideo.uiOperatorFlag == 2)
            {
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719569, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
              return;
            }
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719594, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
            a(paramView);
            c(localMessageForShortVideo, paramView);
          } while (paramayqo.jdField_g_of_type_Int == -5100528);
          bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131719596, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          paramayqo = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          if ((bbdx.b(paramayqo)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, paramayqo)))
          {
            a(localMessageForShortVideo, ajya.a(2131714059) + paramayqo);
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            paramayqo = URLDrawable.getDrawable(new File(paramayqo), (URLDrawable.URLDrawableOptions)localObject);
            paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
            paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(paramayqo);
          }
          b(localMessageForShortVideo, paramView, 2131718790);
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForShortVideo.videoFileProgress;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForShortVideo, paramView, paramInt1, true);
          return;
        } while ((paramayqo.jdField_b_of_type_Int != 7) && (paramayqo.jdField_b_of_type_Int != 18) && (paramayqo.jdField_b_of_type_Int != 16));
        switch (paramayqo.jdField_d_of_type_Int)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          paramayqo = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
          if ((!bbdx.b(paramayqo)) || (!b(localMessageForShortVideo))) {
            break label1519;
          }
          a(localMessageForShortVideo, ajya.a(2131714053) + (String)localObject);
        }
      } while (!ShortVideoUtils.a());
      a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, paramayqo, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      return;
      if (!bbdx.b((String)localObject)) {
        break;
      }
    } while (!a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, (String)localObject));
    label1335:
    label1519:
    a(localMessageForShortVideo, ajya.a(2131714041) + (String)localObject);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = k;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    Object localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a((Drawable)localObject);
    if (!bbdx.b(paramayqo))
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
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(aywm.a());
    return;
    a(localMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    paramayqo = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (bbdx.b(paramayqo))
    {
      a(localMessageForShortVideo, ajya.a(2131714038) + paramayqo);
      if (ShortVideoUtils.a())
      {
        localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
        a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView, paramayqo, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
      paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformCropBubbleVideoView.a(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296294);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.jdField_g_of_type_Int, j, BaseChatItemLayout.jdField_h_of_type_Int);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_g_of_type_Int, BaseChatItemLayout.j, BaseChatItemLayout.jdField_h_of_type_Int);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, aeaf paramaeaf, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramaeaf.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
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
        paramaeaf.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new adzy(this, paramQQAppInterface);
        paramaeaf = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719572));
        paramaeaf.setSpan(new ForegroundColorSpan(-1), 0, paramaeaf.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramaeaf, paramQQAppInterface, axjs.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!axgo.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break;
        }
      } while (paramaeaf.jdField_e_of_type_Int == 2);
      paramaeaf.jdField_e_of_type_Int = 2;
      boolean bool3 = avte.a();
      boolean bool4 = axll.g(paramQQAppInterface);
      paramQQAppInterface = new adzz(this, bool3, bool4, paramQQAppInterface);
      paramaeaf = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719560));
      paramaeaf.setSpan(new ForegroundColorSpan(-1), 0, paramaeaf.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramaeaf, paramQQAppInterface, bool1);
      return;
    } while (paramaeaf.jdField_e_of_type_Int == 0);
    paramaeaf.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    axei localaxei = axdq.a(2, 2);
    axdt localaxdt = paramMessageForShortVideo.getDownloadInfo(localaxei.jdField_b_of_type_Int);
    localaxdt.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localaxdt.a(paramMessageForShortVideo.istroop, 1);
    localaxdt.jdField_f_of_type_Int = 2;
    localaxdt.jdField_g_of_type_Int = 2;
    localaxei.a(localaxdt);
    localaxei.a(paramMessageForShortVideo);
    axdq.a(localaxei, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bbbt.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bbbt.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bbdx.b((String)localObject))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719601, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      paramaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!bbdx.b(str))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719602, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      paramaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = axdq.a(1, 2);
    ((axei)localObject).a(axdq.a(2, paramMessageForShortVideo, (axei)localObject));
    axdq.a((axei)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramaeaf, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf, int paramInt)
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
    a(paramMessageForShortVideo, paramaeaf, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.a(paramInt2, 0);
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (bbfj.d(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf, int paramInt, boolean paramBoolean)
  {
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, ajya.a(2131714058));
      return;
    }
    axei localaxei = axdq.a(2, 2);
    axdt localaxdt = paramMessageForShortVideo.getDownloadInfo(localaxei.jdField_b_of_type_Int);
    localaxdt.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localaxdt.a(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localaxdt.jdField_f_of_type_Int = j;
      localaxdt.jdField_g_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localaxdt.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localaxei.a(localaxdt);
      localaxei.a(paramMessageForShortVideo);
      axdq.a(localaxei, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
  }
  
  protected void a(CropBubbleVideoView paramCropBubbleVideoView, String paramString1, String paramString2, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("playShortVideoByPath uniseq=").append(paramMessageForShortVideo.uniseq).append(", videoPath = ");
      if (paramString1 != null)
      {
        localObject = paramString1;
        localStringBuilder = localStringBuilder.append((String)localObject).append(", thumbPath = ");
        if (paramString2 == null) {
          break label206;
        }
        localObject = paramString2;
        label64:
        QLog.d("ShortVideoRealItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new bbwg();
      ((bbwg)localObject).jdField_a_of_type_Int = 100;
      ((bbwg)localObject).c = true;
      ((bbwg)localObject).jdField_a_of_type_Bbwl = new aeaa(this);
      ((bbwg)localObject).b = true;
      ((bbwg)localObject).jdField_a_of_type_Boolean = true;
      ((bbwg)localObject).jdField_a_of_type_JavaLangString = paramString1;
      ((bbwg)localObject).jdField_d_of_type_Long = paramMessageForShortVideo.videoFileSize;
      paramCropBubbleVideoView.setVideoParam((bbwg)localObject);
      paramString1 = new anoz(-10065297, 100, 100);
      if (!TextUtils.isEmpty(paramString2)) {
        break label214;
      }
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    }
    for (;;)
    {
      paramCropBubbleVideoView.a();
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label206:
      localObject = "null";
      break label64;
      label214:
      paramCropBubbleVideoView.setCoverDrawable(URLDrawable.getDrawable(ShortVideoUtils.a(paramString2).toString(), paramInt1, paramInt2, paramString1, paramString1));
    }
  }
  
  void a(String paramString)
  {
    ThreadManager.post(new ShortVideoRealItemBuilder.4(this, paramString), 5, null, false);
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
      if ((paramBaseChatItemLayout instanceof aypb))
      {
        if (((aypb)paramBaseChatItemLayout).c() == 1005L) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
      if (paramChatMessage.videoFileStatus == 1005) {
        return true;
      }
    } while ((paramChatMessage.videoFileProgress == 100) || (paramChatMessage.videoFileStatus == 1003) || (paramChatMessage.videoFileStatus == 2003) || (paramChatMessage.isAllowAutoDown != true));
    return true;
  }
  
  protected boolean a(CropBubbleVideoView paramCropBubbleVideoView, String paramString)
  {
    paramCropBubbleVideoView = paramCropBubbleVideoView.a();
    if (paramCropBubbleVideoView == null) {
      return true;
    }
    return (!(paramCropBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramCropBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    paramView = (aeaf)actj.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbbmf, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbbmf.a();
      label48:
      b(localbbmf, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bbmf b(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    int n = 1;
    int k = 0;
    int j = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramacva = (aeaf)paramacva;
    b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
    int m;
    label160:
    int i1;
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a(paramChatMessage, "mp4");
      if (bbdx.b(str1)) {
        if ((paramacva.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramacva.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
            a(paramChatMessage, parambbmf);
            k = n;
            if (bbdx.b(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(parambbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
              i1 = k;
            }
          }
        }
      }
    }
    for (n = j;; n = k)
    {
      a(parambbmf, paramChatMessage);
      if (n != 0) {
        parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692324), 2130838605);
      }
      if (i1 != 0) {
        b(paramChatMessage, parambbmf);
      }
      super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
      return parambbmf;
      k = 0;
      break label160;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  public void b(aeaf paramaeaf)
  {
    if (!paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramaeaf.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new aead(this, paramaeaf));
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
    aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!bbdx.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      bcql.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131719602, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
      paramaeaf.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramaeaf = axdq.a(4, 2);
      paramaeaf.a(axdq.a(2, paramMessageForShortVideo, paramaeaf));
      axdq.a(paramaeaf, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf, int paramInt)
  {
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130848699);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramaeaf.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, aeaf paramaeaf)
  {
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramaeaf.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramaeaf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
              if (paramView.getId() != 2131364137) {
                break;
              }
              localObject = (MessageRecord)paramView.getTag();
            } while (localObject == null);
            ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
            return;
            localObject = (aeaf)actj.a(paramView);
            localMessageForShortVideo = (MessageForShortVideo)((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          } while (paramView.getId() == 2131364151);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
          {
            bcql.a(this.jdField_a_of_type_AndroidContentContext, 2131696182, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            return;
          }
          if (paramView.getId() == 2131364109) {
            a((aeaf)localObject, localMessageForShortVideo, false);
          }
          if (paramView.getId() != 2131364128) {
            break;
          }
        } while (((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        if ((!(paramView instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)paramView).jdField_g_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
      return;
      localStringBuilder1 = new StringBuilder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!(paramView instanceof ShortVideoUploadProcessor)) {
        break;
      }
      ((ShortVideoUploadProcessor)paramView).c();
      localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
      ShortVideoUtils.c("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
    return;
    aigj localaigj = (aigj)aigj.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
    if (localaigj != null)
    {
      paramView = Long.valueOf(localaigj.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      label417:
      paramView = localStringBuilder2.append(paramView).append(", msgUniseq:").append(((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
      if ((localaigj == null) || (!localaigj.jdField_a_of_type_Boolean)) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      paramView.append(bool);
      if ((localaigj == null) || (localaigj.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != ((aeaf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localaigj.a())) {
        break;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
      localMessageForShortVideo.progressTask = null;
      localMessageForShortVideo.videoFileStatus = 1004;
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      awap.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      i();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
      jdField_h_of_type_Boolean = false;
      break;
      paramView = "-1";
      break label417;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */