package com.tencent.mobileqq.activity.aio.item;

import abke;
import aean;
import agej;
import aggk;
import aggl;
import aggp;
import aghd;
import agif;
import agjk;
import ahov;
import ahrq;
import ahrr;
import ahrs;
import ahrt;
import ahru;
import ahrv;
import ahrw;
import ahrx;
import aicv;
import alug;
import alxb;
import amgx;
import amhc;
import amhd;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
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
import anzj;
import ascz;
import auxu;
import axqb;
import azqi;
import baph;
import bapi;
import bbgg;
import bbjw;
import bbnr;
import bcwu;
import bcww;
import bcwx;
import bcxf;
import bcxn;
import bcyh;
import bczv;
import bdbt;
import bdcy;
import bdeq;
import bdll;
import bdog;
import berp;
import bete;
import bexk;
import beyb;
import beyq;
import bhjx;
import bhjz;
import bhmi;
import bhnv;
import bhuk;
import bhum;
import blir;
import blji;
import bmgb;
import bmko;
import bmky;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.imcore.message.QQMessageFacade;
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
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.WeakReference;
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
import yup;
import zmw;

public class ShortVideoRealItemBuilder
  extends ahov
  implements aggp, agif, bcww
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
  private amhc jdField_a_of_type_Amhc = new ahrw(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    beyq.a();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    jdField_d_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_f_of_type_Int;
    jdField_g_of_type_Int = Math.min(agej.a(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = agej.a(100.0F, localResources);
    i = agej.a(100.0F, localResources);
    jdField_e_of_type_Int = agej.a(bdbt.l, localResources);
    jdField_f_of_type_Int = agej.a(bdbt.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ascz(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
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
    bcyh.a();
    h();
  }
  
  public static List<? extends Entity> a(EntityManager paramEntityManager, Class<? extends Entity> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramEntityManager.query(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
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
  
  private void a(ahrx paramahrx, View paramView)
  {
    if (a(paramahrx))
    {
      if (paramahrx.b == null)
      {
        paramahrx.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramahrx.b.setImageResource(2130838285);
        paramahrx.b.setId(2131364442);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = agej.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364423);
        localLayoutParams.addRule(0, 2131364423);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramahrx.b, localLayoutParams);
        }
      }
      a(paramahrx, true, this);
      return;
    }
    a(paramahrx, false, null);
  }
  
  private void a(ahrx paramahrx, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718201, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          bdcy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        alug.b("", "0X8006A1C");
        alxb.a("shortvideo_bubble", null);
        yup.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        if (bhmi.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramahrx, 2131717503);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718234, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new bbjw(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!bhmi.b(str));
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697059), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131299011));
  }
  
  private void a(ahrx paramahrx, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramahrx.b != null)
      {
        paramahrx.b.setVisibility(0);
        paramahrx.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramahrx.b == null) {
      return;
    }
    paramahrx.b.setVisibility(8);
    paramahrx.b.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    bdll.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = abke.a(paramView);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_THUMBNAL_BOUND", paramView);
    if ((((paramContext instanceof ChatActivity)) || ((paramContext instanceof SplashActivity))) && (!(paramContext instanceof MultiForwardActivity)) && (!paramSessionInfo.n)) {
      localBundle.putInt("extra.AIO_CURRENT_PANEL_STATE", ((FragmentActivity)paramContext).getChatFragment().a().g());
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
        break label575;
      }
      localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForReplyText.isMultiMsg);
      label230:
      localBundle.putLong("click_video_bubble_time", System.currentTimeMillis());
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
        break label684;
      }
    }
    label684:
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
        label575:
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
        bmgb.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aicv.a(paramMessageForShortVideo), -1, j);
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
        localBundle.putBoolean(bmgb.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!bhjx.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bmgb.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), aicv.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new bbjw(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
        }
        ShortVideoUtils.a(paramQQAppInterface, "0X8008E53", paramSessionInfo, paramMessageForShortVideo, paramContext);
        return;
        localBundle.putInt("extra.EXTRA_FORWARD_TO_QZONE_SRC", 1);
        break;
        localBundle.putBoolean("extra.IS_FROM_MULTI_MSG", paramMessageForShortVideo.isMultiMsg);
        break label230;
      }
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new bbjw(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    a(paramMessageForShortVideo, anzj.a(2131712923) + paramString2);
    a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((zmw.a(paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!bhjz.a().a(paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
    {
      bhjz.a().a(paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
      yup.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", zmw.a((MessageForShortVideo)paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
    }
    if (!bhmi.b(paramString1))
    {
      b(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      amhd localamhd = new amhd(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new amgx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localamhd, paramMessageForShortVideo);
      amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((amgx)localObject).a(this.jdField_a_of_type_Amhc);
      ((amgx)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, paramahrx, paramMessageForShortVideo, paramBoolean2));
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
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    a(paramahrx, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((bhmi.b(paramString2)) || ((paramMessageForShortVideo.isSend()) && (paramMessageForShortVideo.md5 == null) && (paramMessageForShortVideo.videoFileStatus == 1004)))
    {
      paramInt1 = 0;
      if ((paramMessageForShortVideo.videoFileStatus == 1005) || (paramMessageForShortVideo.extraflag == 32768) || (paramMessageForShortVideo.videoFileStatus == 1004)) {
        paramInt1 = 1;
      }
      paramCropBubbleVideoView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.uniseq);
      paramInt2 = paramInt1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        paramInt2 = paramInt1;
        if (paramMessageForShortVideo.videoFileProgress < 100)
        {
          paramInt2 = paramInt1;
          if (paramMessageForShortVideo.videoFileStatus != 1003)
          {
            paramInt2 = paramInt1;
            if (paramCropBubbleVideoView == null) {
              paramInt2 = 1;
            }
          }
        }
      }
      if (paramInt2 != 0) {
        b(paramMessageForShortVideo, paramahrx, 2131717508);
      }
      do
      {
        return;
        if ((!ShortVideoUtils.a()) || (!paramBoolean))
        {
          c(paramMessageForShortVideo, paramahrx);
          return;
        }
      } while (paramMessageForShortVideo.videoFileStatus == 1003);
      if (ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {}
      for (paramInt1 = 1; (paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0); paramInt1 = 0)
      {
        if (paramMessageForShortVideo.progress > 60) {
          paramMessageForShortVideo.progress = 60;
        }
        a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
        return;
      }
      a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if (paramMessageForShortVideo.videoFileStatus == 2005) {
      c(paramMessageForShortVideo, paramahrx);
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, anzj.a(2131712914));
      b(paramMessageForShortVideo, paramahrx, 2131717503);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus == 2001) || (paramMessageForShortVideo.videoFileStatus == 2002) || (paramMessageForShortVideo.videoFileStatus == 2000))
    {
      a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    c(paramMessageForShortVideo, paramahrx);
  }
  
  private boolean a(ahrx paramahrx)
  {
    boolean bool2 = true;
    if ((paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label204;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramahrx = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
  
  private boolean a(ahrx paramahrx, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      String str1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        String str2 = paramMessageForShortVideo.mThumbFilePath;
        str1 = str2;
        if (bhmi.b(str2)) {
          break label119;
        }
        if (!TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5)) {
          break label107;
        }
        paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
        paramCropBubbleVideoView.showCover(beyq.a());
        a(paramahrx);
        a(paramMessageForShortVideo, "getBubbleView():You must get thumb before send video.");
      }
      label107:
      label119:
      do
      {
        do
        {
          for (;;)
          {
            return true;
            str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramCropBubbleVideoView, str1))
            {
              a(paramahrx, str1, paramMessageForShortVideo, paramInt1, paramInt2);
              b(paramahrx, paramMessageForShortVideo);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) || ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != paramMessageForShortVideo.uniseq) && (!jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {}
              for (paramInt1 = 1; (!paramMessageForShortVideo.mPreUpload) && (TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramInt1 != 0) && (paramMessageForShortVideo.busiType == 1); paramInt1 = 0)
              {
                if (jdField_h_of_type_Boolean) {
                  break label239;
                }
                a(paramMessageForShortVideo, null, false, true);
                return true;
              }
            }
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
      } while (!QLog.isColorLevel());
      label239:
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + paramMessageForShortVideo.uniseq + "] added, mEncoding:" + jdField_h_of_type_Boolean);
      return true;
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    axqb localaxqb = (axqb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    if (localaxqb != null)
    {
      paramMessageForShortVideo = localaxqb.a(localaxqb.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(ahrx paramahrx, MessageForShortVideo paramMessageForShortVideo)
  {
    paramahrx = new WeakReference(paramahrx);
    if (paramMessageForShortVideo.busiType == 1)
    {
      if (paramMessageForShortVideo.progressTask == null)
      {
        paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramahrx);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
        this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.progressTask);
      }
      return;
    }
    if (paramMessageForShortVideo.mShowProgressTask == null) {
      paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramahrx, paramMessageForShortVideo);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
    this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.mShowProgressTask);
  }
  
  private void b(ahrx paramahrx, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramahrx != null) && (paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramahrx, false, null);
      }
      paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return bdog.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
  }
  
  private void d(MessageForShortVideo paramMessageForShortVideo)
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
          localCropBubbleVideoView.pause();
        }
      }
    }
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && ((this.jdField_a_of_type_AndroidViewViewGroup instanceof ChatXListView))) {
      return ((ChatXListView)this.jdField_a_of_type_AndroidViewViewGroup).a();
    }
    return true;
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
          localCropBubbleVideoView.resume();
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
          localCropBubbleVideoView.releasePlayer(false);
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
  
  public aggk a(View paramView)
  {
    return null;
  }
  
  public aggl a()
  {
    return new ahrx(this);
  }
  
  public ahrx a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = agej.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label223;
      }
      Object localObject = agej.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = agej.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof ahrx))) {
          return (ahrx)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    a(paramChatMessage, paramView, this);
    a((ahrx)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    ahrx localahrx = (ahrx)paramaggl;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaggl = ShortVideoUtils.a(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramaggl[0];
    int k = paramaggl[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new RelativeLayout(localContext);
      paramView = (CropBubbleVideoView)baph.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362346);
      paramView.setVisibility(0);
      paramView.setContentDescription(anzj.a(2131712947));
      paramaggl.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramaggl.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130838050);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362346);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362346);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = agej.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = agej.a(10.0F, localResources);
      paramaggl.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaggl.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = agej.a(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364464);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramaggl.setOnClickListener(this);
      super.a(paramaggl, paramagjk);
      localahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      localahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localahrx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localahrx.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramView = localahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(anzj.a(2131712909));
    }
    localahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    bhjz.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localahrx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    a(localahrx, localMessageForShortVideo);
    paramagjk = localahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
    if (paramagjk == null)
    {
      paramagjk = new RelativeLayout.LayoutParams(j, k);
      localahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramagjk);
      paramagjk = localahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramagjk != null) {
        break label705;
      }
      paramagjk = new RelativeLayout.LayoutParams(j, k);
      localahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramagjk);
    }
    for (;;)
    {
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if ((!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.n))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localahrx, paramChatMessage);
          bdcy.a(paramaggl, localahrx, paramChatMessage, localContext);
        }
      }
      a(localMessageForShortVideo);
      a(localMessageForShortVideo, localahrx, localResources, bool);
      if (!a(localahrx, localMessageForShortVideo, j, k, paramView)) {
        break label752;
      }
      return paramaggl;
      if ((paramagjk.width == j) && (paramagjk.height == k)) {
        break;
      }
      paramagjk.width = j;
      paramagjk.height = k;
      localahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramagjk);
      break;
      label705:
      if ((paramagjk.width != j) || (paramagjk.height != k))
      {
        paramagjk.width = j;
        paramagjk.height = k;
        localahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramagjk);
      }
    }
    label752:
    paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    bool = b(localMessageForShortVideo);
    if ((bool) && (bhmi.b(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localahrx, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaggl;
    }
    if (bhmi.b(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localahrx, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaggl;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, anzj.a(2131712940));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localahrx, 2131717503);
      return paramaggl;
    }
    a(localMessageForShortVideo, anzj.a(2131712961));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    b(localMessageForShortVideo);
    return paramaggl;
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    int m = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramaghd = (ahrx)paramaghd;
    b(parambhuk, this.jdField_a_of_type_AndroidContentContext);
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
        if (bhmi.b(str)) {
          if ((paramaghd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramaghd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
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
        parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
        k = m;
        if (bhmi.b(paramChatMessage)) {
          k = 1;
        }
      }
      if (k != 0) {
        parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      return parambhuk;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131712962);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!bhmi.b(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = bhmi.b(new File(paramMessageForShortVideo));
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
          long l = ((CropBubbleVideoView)localObject2).getCurPlayingPos();
          if (l > 0L)
          {
            MessageForShortVideo localMessageForShortVideo = bhjz.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
            if (localMessageForShortVideo != null) {
              a(localMessageForShortVideo, l);
            }
          }
          ((CropBubbleVideoView)localObject2).releasePlayer(false);
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
      if (paramInt != 2131365352) {
        break label77;
      }
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      yup.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131371530)
        {
          super.d(paramChatMessage);
          yup.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131367078)
        {
          paramInt = azqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            yup.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            c(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
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
        if (paramInt != 2131366320) {
          break;
        }
        bmko.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        bmky.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        yup.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131371487)
      {
        super.a(localMessageForShortVideo);
        yup.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131365312)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131371594) {
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
    bdll.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label664:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(ahrx paramahrx)
  {
    if (!paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramahrx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ahru(this, paramahrx));
    }
  }
  
  protected void a(ahrx paramahrx, MessageForShortVideo paramMessageForShortVideo)
  {
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(paramMessageForShortVideo.isSend());
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    if ((paramMessageForShortVideo.fileType == 6) || (paramMessageForShortVideo.fileType == 17) || (paramMessageForShortVideo.fileType == 9) || (paramMessageForShortVideo.fileType == 20))
    {
      if ((paramMessageForShortVideo.videoFileStatus == 1003) || (paramMessageForShortVideo.videoFileStatus == 2003)) {
        b(paramahrx);
      }
    }
    else {
      return;
    }
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
  }
  
  public void a(ahrx paramahrx, String paramString, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2)
  {
    if ((bhmi.b(paramString)) && (a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString)))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      paramString = URLDrawable.getDrawable(new File(paramString), localURLDrawableOptions);
      paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString);
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (ahrx)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidContentContext, null);
      localblir.a(2131689933, 5);
      localblir.c(2131690580);
      localblir.a(new ahrt(this, localMessageForShortVideo, paramView, localblir));
      localblir.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.c("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, bete parambete, int paramInt1, int paramInt2)
  {
    paramView = agej.a(paramView);
    if (!(paramView instanceof ahrx)) {}
    MessageForShortVideo localMessageForShortVideo;
    int j;
    int k;
    label188:
    label195:
    do
    {
      do
      {
        do
        {
          return;
          paramView = (ahrx)paramView;
          localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        } while (localMessageForShortVideo.uniseq != parambete.jdField_b_of_type_Long);
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.mShowProgressTask);
        if (localMessageForShortVideo.mShowProgressTask != null) {
          localMessageForShortVideo.mShowProgressTask = null;
        }
      } while (this.jdField_a_of_type_AndroidContentContext == null);
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (localMessageForShortVideo.thumbWidth > 0)
      {
        paramInt1 = localMessageForShortVideo.thumbWidth;
        if (localMessageForShortVideo.thumbHeight <= 0) {
          break label188;
        }
      }
      for (paramInt2 = localMessageForShortVideo.thumbHeight;; paramInt2 = 100)
      {
        j = agej.a(paramInt1, localResources);
        k = agej.a(paramInt2, localResources);
        if ((parambete.jdField_b_of_type_Int != 6) && (parambete.jdField_b_of_type_Int != 17) && (parambete.jdField_b_of_type_Int != 9) && (parambete.jdField_b_of_type_Int != 20)) {
          break label195;
        }
        a(parambete, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
        return;
        paramInt1 = 100;
        break;
      }
    } while ((parambete.jdField_b_of_type_Int != 7) && (parambete.jdField_b_of_type_Int != 18) && (parambete.jdField_b_of_type_Int != 16));
    b(parambete, paramView, localMessageForShortVideo, paramInt1, paramInt2, j, k);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296338);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.k, BaseChatItemLayout.jdField_h_of_type_Int, j, BaseChatItemLayout.i);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_h_of_type_Int, BaseChatItemLayout.k, BaseChatItemLayout.i);
  }
  
  public void a(bete parambete, ahrx paramahrx, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (parambete.jdField_d_of_type_Int)
    {
    default: 
    case 1007: 
    case 1001: 
    case 1003: 
    case 1005: 
    case 1004: 
    case 1002: 
    case 2001: 
    case 2003: 
    case 5001: 
    case 2005: 
      do
      {
        do
        {
          return;
          a(paramahrx, false, null);
          amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          a(paramMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + paramMessageForShortVideo.videoFileProgress);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + paramMessageForShortVideo.videoFileProgress);
          if (paramMessageForShortVideo.busiType != 1) {
            a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, true);
          }
          paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
          amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
          d(paramMessageForShortVideo);
          a(paramMessageForShortVideo.mVideoFileSourceDir);
          a(paramMessageForShortVideo, paramahrx, 100, true);
          a(paramahrx, false, null);
          amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
          d(paramMessageForShortVideo);
          b(paramMessageForShortVideo, paramahrx, 2131717508);
          paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
          paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
          d(paramMessageForShortVideo);
          a(paramahrx);
          b(paramMessageForShortVideo, paramahrx, 2131717508);
          b(paramahrx, true, this);
          amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForShortVideo.uniseq));
          return;
          paramInt1 = paramMessageForShortVideo.videoFileProgress;
          a(paramMessageForShortVideo, "VIDEO STATUS_SEND_PROCESS " + paramInt1);
          a(paramMessageForShortVideo, paramahrx, paramInt1);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_RECV_START");
          a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, true);
          return;
          a(paramMessageForShortVideo, "VIDEO STATUS_RECV_FINISHED , getAIOState() = " + a());
          if ((!b(paramMessageForShortVideo)) || (a() != 4)) {
            break;
          }
          parambete = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
          a(paramMessageForShortVideo, anzj.a(2131712944) + parambete);
          if ((ShortVideoUtils.a()) && (bhmi.b(parambete)))
          {
            a(paramMessageForShortVideo, anzj.a(2131712956) + parambete);
            String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambete, str, paramMessageForShortVideo, paramInt1, paramInt2);
            if (!paramMessageForShortVideo.isSend()) {
              new bbjw(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
            }
          }
          a(paramMessageForShortVideo, paramahrx, 100, true);
        } while (!paramMessageForShortVideo.isMultiMsg);
        a(paramahrx);
        return;
        a(paramahrx, ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
        c(paramMessageForShortVideo, paramahrx);
        return;
        a(paramMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
        b(paramMessageForShortVideo, paramahrx, 2131717502);
        if (paramMessageForShortVideo.uiOperatorFlag == 2)
        {
          paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718209, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          return;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718233, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
        return;
        a(paramMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
        a(paramahrx);
        c(paramMessageForShortVideo, paramahrx);
      } while (parambete.jdField_g_of_type_Int == -5100528);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131718235, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      return;
    case 5002: 
      a(paramMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
      a(paramahrx, ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg"), paramMessageForShortVideo, paramInt3, paramInt4);
      b(paramMessageForShortVideo, paramahrx, 2131717503);
      return;
    case 2004: 
      a(paramMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
      return;
    }
    paramInt1 = paramMessageForShortVideo.videoFileProgress;
    a(paramMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
    a(paramMessageForShortVideo, paramahrx, paramInt1, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, ahrx paramahrx, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramahrx.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
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
        paramahrx.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new ahrq(this, paramQQAppInterface);
        paramahrx = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718212));
        paramahrx.setSpan(new ForegroundColorSpan(-1), 0, paramahrx.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramahrx, paramQQAppInterface, bdcy.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!bczv.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break;
        }
      } while (paramahrx.jdField_e_of_type_Int == 2);
      paramahrx.jdField_e_of_type_Int = 2;
      boolean bool3 = bbgg.a();
      boolean bool4 = bdeq.g(paramQQAppInterface);
      paramQQAppInterface = new ahrr(this, bool3, bool4, paramQQAppInterface);
      paramahrx = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718202));
      paramahrx.setSpan(new ForegroundColorSpan(-1), 0, paramahrx.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramahrx, paramQQAppInterface, bool1);
      return;
    } while (paramahrx.jdField_e_of_type_Int == 0);
    paramahrx.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (!bhjz.a().a(paramMessageForShortVideo, "0X8007428"))
    {
      bhjz.a().a(paramMessageForShortVideo, "0X8007428");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
    }
    if ((paramMessageForShortVideo.CheckIsHotVideo()) && (!bhjz.a().a(paramMessageForShortVideo, "0X8007EDB")))
    {
      bhjz.a().a(paramMessageForShortVideo, "0X8007EDB");
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bhjz.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bhjz.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bhmi.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718240, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!bhmi.b(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = bcwu.a(1, 2);
    ((bcxn)localObject).a(bcwu.a(2, paramMessageForShortVideo, (bcxn)localObject));
    bcwu.a((bcxn)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramahrx, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, int paramInt)
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
    a(paramMessageForShortVideo, paramahrx, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.a(paramInt2, 0);
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramahrx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (bhnv.d(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, int paramInt, boolean paramBoolean)
  {
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahrx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, Resources paramResources, boolean paramBoolean)
  {
    int j = Math.max(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    int k = Math.min(paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
    if ((jdField_f_of_type_Boolean) && (j >= jdField_c_of_type_Int) && (k >= jdField_d_of_type_Int))
    {
      paramMessageForShortVideo = (RelativeLayout.LayoutParams)paramahrx.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramBoolean) {}
      for (paramMessageForShortVideo.rightMargin = agej.a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth() + 8.0F, paramResources);; paramMessageForShortVideo.rightMargin = agej.a(8.0F, paramResources))
      {
        paramahrx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
    }
    paramahrx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, anzj.a(2131712921));
      return;
    }
    bcxn localbcxn = bcwu.a(2, 2);
    bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localbcwx.a(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localbcwx.jdField_f_of_type_Int = j;
      localbcwx.jdField_g_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localbcwx.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localbcxn.a(localbcwx);
      localbcxn.a(paramMessageForShortVideo);
      bcwu.a(localbcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
          break label223;
        }
        localObject = paramString2;
        label64:
        QLog.d("ShortVideoRealItemBuilder", 2, (String)localObject);
      }
    }
    else
    {
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      localObject = new VideoPlayParam();
      ((VideoPlayParam)localObject).mSceneId = 100;
      ((VideoPlayParam)localObject).mSceneName = bapi.a(100);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new ahrs(this);
      ((VideoPlayParam)localObject).mIsLocal = true;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramString1 = new ascz(-10065297, 100, 100);
      if (!TextUtils.isEmpty(paramString2)) {
        break label231;
      }
      paramCropBubbleVideoView.setCoverDrawable(paramString1);
    }
    for (;;)
    {
      if (e()) {
        paramCropBubbleVideoView.play();
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramCropBubbleVideoView);
      return;
      localObject = "null";
      break;
      label223:
      localObject = "null";
      break label64;
      label231:
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
      if ((paramBaseChatItemLayout instanceof berp))
      {
        if (((berp)paramBaseChatItemLayout).c() == 1005L) {}
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
    paramCropBubbleVideoView = paramCropBubbleVideoView.getCoverDrawable();
    if (paramCropBubbleVideoView == null) {
      return true;
    }
    return (!(paramCropBubbleVideoView instanceof URLDrawable)) || (!((URLDrawable)paramCropBubbleVideoView).getURL().getPath().equals(paramString));
  }
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    paramView = (ahrx)agej.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbhuk, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbhuk.a();
      label48:
      b(localbhuk, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    int n = 1;
    int k = 0;
    int j = 0;
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaghd = (ahrx)paramaghd;
    b(parambhuk, this.jdField_a_of_type_AndroidContentContext);
    int m;
    label167:
    int i1;
    if ((!TextUtils.isEmpty(localMessageForShortVideo.md5)) && ((!localMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(localMessageForShortVideo.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      if (bhmi.b(str1)) {
        if ((paramaghd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramaghd.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
            a(localMessageForShortVideo, parambhuk);
            k = n;
            if (bhmi.b(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localMessageForShortVideo);
              i1 = k;
            }
          }
        }
      }
    }
    for (n = j;; n = k)
    {
      a(parambhuk, localMessageForShortVideo);
      if (n != 0) {
        parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131691990), 2130838938);
      }
      super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, paramChatMessage);
      if (i1 != 0) {
        b(localMessageForShortVideo, parambhuk);
      }
      super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
      return parambhuk;
      k = 0;
      break label167;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  public void b(ahrx paramahrx)
  {
    if (!paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new ahrv(this, paramahrx));
    }
  }
  
  public void b(bete parambete, ahrx paramahrx, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str;
    switch (parambete.jdField_d_of_type_Int)
    {
    default: 
    case 2001: 
    case 2003: 
      do
      {
        do
        {
          return;
          a(paramMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
          a(paramMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          parambete = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
          str = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
          if ((!bhmi.b(str)) || (!b(paramMessageForShortVideo))) {
            break;
          }
          a(paramMessageForShortVideo, anzj.a(2131712916) + parambete);
        } while (!ShortVideoUtils.a());
        a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, str, parambete, paramMessageForShortVideo, paramInt1, paramInt2);
        return;
        a(paramahrx, parambete, paramMessageForShortVideo, paramInt3, paramInt4);
        if (!bhmi.b(parambete)) {
          break;
        }
      } while (!a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambete));
      a(paramMessageForShortVideo, anzj.a(2131712904) + parambete);
      if (!bhmi.b(str))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
        {
          a(paramMessageForShortVideo, true);
          return;
        }
        c(paramMessageForShortVideo, paramahrx);
        return;
      }
      if (ShortVideoUtils.a())
      {
        a(paramahrx);
        return;
      }
      c(paramMessageForShortVideo, paramahrx);
      return;
      paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(beyq.a());
      return;
    case 5002: 
      a(paramMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    }
    a(paramMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    parambete = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    if (bhmi.b(parambete))
    {
      a(paramMessageForShortVideo, anzj.a(2131712901) + parambete);
      if (ShortVideoUtils.a())
      {
        str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        a(paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambete, str, paramMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(paramahrx);
      return;
      paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramahrx.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    bcxn localbcxn = bcwu.a(2, 2);
    bcwx localbcwx = paramMessageForShortVideo.getDownloadInfo(localbcxn.jdField_b_of_type_Int);
    localbcwx.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localbcwx.a(paramMessageForShortVideo.istroop, 1);
    localbcwx.jdField_f_of_type_Int = 2;
    localbcwx.jdField_g_of_type_Int = 2;
    localbcxn.a(localbcwx);
    localbcxn.a(paramMessageForShortVideo);
    bcwu.a(localbcxn, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!bhmi.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131718241, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
      paramahrx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramahrx = bcwu.a(4, 2);
      paramahrx.a(bcwu.a(2, paramMessageForShortVideo, paramahrx));
      bcwu.a(paramahrx, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx, int paramInt)
  {
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849764);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramahrx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramahrx.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo)
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
      if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
      {
        localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
        localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
      }
      if (bhmi.b(str2))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", str2);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, ahrx paramahrx)
  {
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramahrx.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramahrx.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      jdField_d_of_type_Long = l;
      Object localObject;
      if (paramView.getId() == 2131364451)
      {
        localObject = (MessageRecord)paramView.getTag();
        if (localObject != null) {
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
        }
      }
      else
      {
        ahrx localahrx = (ahrx)agej.a(paramView);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        if (paramView.getId() != 2131364466) {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695278, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299011));
          }
          else
          {
            if (paramView.getId() == 2131364423) {
              a(localahrx, localMessageForShortVideo, false);
            }
            if (paramView.getId() == 2131364442)
            {
              if (!localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg)
              {
                localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                if (((localObject instanceof bexk)) && (((bexk)localObject).b))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
                  }
                }
                else
                {
                  StringBuilder localStringBuilder1 = new StringBuilder();
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
                  if ((localObject instanceof bexk))
                  {
                    ((bexk)localObject).c();
                    localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
                    ShortVideoUtils.c("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                    if (QLog.isColorLevel()) {
                      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
                    }
                  }
                  else
                  {
                    amgx localamgx = (amgx)amgx.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
                    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
                    if (localamgx != null)
                    {
                      localObject = Long.valueOf(localamgx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                      label439:
                      localObject = localStringBuilder2.append(localObject).append(", msgUniseq:").append(localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
                      if ((localamgx == null) || (!localamgx.jdField_a_of_type_Boolean)) {
                        break label636;
                      }
                    }
                    label636:
                    for (boolean bool = true;; bool = false)
                    {
                      ((StringBuilder)localObject).append(bool);
                      if ((localamgx == null) || (localamgx.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != localahrx.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localamgx.a())) {
                        break;
                      }
                      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
                      localMessageForShortVideo.progressTask = null;
                      localMessageForShortVideo.videoFileStatus = 1004;
                      localMessageForShortVideo.md5 = null;
                      localMessageForShortVideo.serial();
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
                      bbnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
                      i();
                      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = null;
                      jdField_h_of_type_Boolean = false;
                      break;
                      localObject = "-1";
                      break label439;
                    }
                  }
                }
              }
            }
            else {
              super.onClick(paramView);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */