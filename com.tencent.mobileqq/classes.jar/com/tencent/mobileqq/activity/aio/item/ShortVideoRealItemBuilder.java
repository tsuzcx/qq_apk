package com.tencent.mobileqq.activity.aio.item;

import acex;
import aekt;
import aels;
import aelt;
import aelw;
import aemk;
import aenl;
import aeov;
import aftq;
import afwm;
import afwn;
import afwo;
import afwp;
import afwq;
import afwr;
import afws;
import afwt;
import agem;
import ajlj;
import ajoe;
import ajxt;
import ajxy;
import ajxz;
import alpo;
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
import apgg;
import arum;
import ault;
import awbv;
import awbw;
import awez;
import awwq;
import awwr;
import axld;
import axot;
import axso;
import ayyu;
import ayyw;
import ayyx;
import ayzf;
import ayzo;
import azag;
import azbu;
import azds;
import azey;
import azgr;
import azmj;
import azqe;
import bamw;
import baoj;
import batw;
import baul;
import bdal;
import bdan;
import bdcs;
import bdee;
import bdkz;
import bdlb;
import bhpy;
import bhql;
import bilx;
import biqt;
import birh;
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
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
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
import wta;
import xlh;
import zen;

public class ShortVideoRealItemBuilder
  extends aftq
  implements aelw, aenl, ayyw
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
  private ajxy jdField_a_of_type_Ajxy = new afws(this);
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private Handler b;
  public long c;
  
  static
  {
    baul.b();
    jdField_f_of_type_Boolean = true;
    jdField_c_of_type_Int = 960;
    jdField_d_of_type_Int = 720;
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    jdField_g_of_type_Int = BaseChatItemLayout.jdField_e_of_type_Int;
    jdField_g_of_type_Int = Math.min(aekt.a(320.0F, localResources), jdField_g_of_type_Int);
    jdField_h_of_type_Int = aekt.a(100.0F, localResources);
    i = aekt.a(100.0F, localResources);
    jdField_e_of_type_Int = aekt.a(azds.l, localResources);
    jdField_f_of_type_Int = aekt.a(azds.m, localResources);
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new apgg(-10065297, jdField_e_of_type_Int, jdField_f_of_type_Int);
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
    azag.a();
    h();
  }
  
  public static List<? extends awbv> a(awbw paramawbw, Class<? extends awbv> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramawbw.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("doEncodeNext, curMsg:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null)
      {
        localObject = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.i("ShortVideoRealItemBuilder", 2, localObject + ", seq:" + paramLong + ", contains:" + ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong)));
      }
    }
    else
    {
      ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
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
  
  private void a(afwt paramafwt, View paramView)
  {
    if (a(paramafwt))
    {
      if (paramafwt.b == null)
      {
        paramafwt.b = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramafwt.b.setImageResource(2130838161);
        paramafwt.b.setId(2131364190);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = aekt.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364171);
        localLayoutParams.addRule(0, 2131364171);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramafwt.b, localLayoutParams);
        }
      }
      a(paramafwt, true, this);
      return;
    }
    a(paramafwt, false, null);
  }
  
  private void a(afwt paramafwt, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.md5 == null) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720091, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
    }
    String str;
    do
    {
      for (;;)
      {
        return;
        if (paramMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET) {
          azey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
        }
        ajlj.b("", "0X8006A1C");
        ajoe.a("shortvideo_bubble", null);
        wta.a("story_grp", "aio_msg", 0, 0, new String[] { "", "", "", "" });
        str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        if (bdcs.b(ShortVideoUtils.a(paramMessageForShortVideo, "mp4"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoRealItemBuilder", 2, "onClick, video file not exist");
        }
        if (paramMessageForShortVideo.videoFileStatus == 5002)
        {
          b(paramMessageForShortVideo, paramafwt, 2131719264);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720127, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
        }
        while (!paramMessageForShortVideo.isSend())
        {
          new axot(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1003);
          return;
          a(paramMessageForShortVideo, false);
          a(paramMessageForShortVideo, paramafwt, paramMessageForShortVideo.videoFileProgress, false);
        }
      }
    } while (!bdcs.b(str));
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800561C", "0X800561C", 0, 0, "", "", "", "");
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, paramafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramBoolean, false, true, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "onClick, sdk is not installed");
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698158), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
  }
  
  private void a(afwt paramafwt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramBoolean) {
      if (paramafwt.b != null)
      {
        paramafwt.b.setVisibility(0);
        paramafwt.b.setOnClickListener(paramOnClickListener);
      }
    }
    while (paramafwt.b == null) {
      return;
    }
    paramafwt.b.setVisibility(8);
    paramafwt.b.setOnClickListener(null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, View paramView, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageForReplyText paramMessageForReplyText)
  {
    azmj.b(paramQQAppInterface, "dc00898", "", "", "0X8007429", "0X8007429", 0, 0, "", "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoRealItemBuilder", 2, "enterRichMediaPreview");
    }
    if (MediaPlayerManager.a(paramQQAppInterface).a()) {
      MediaPlayerManager.a(paramQQAppInterface).a(true);
    }
    paramView = zen.a(paramView);
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
        bilx.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agem.a(paramMessageForShortVideo), -1, j);
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
        localBundle.putBoolean(bilx.b, paramBoolean4);
        if ((paramMessageForShortVideo.istroop != 0) || (!bdal.b(paramMessageForShortVideo.senderuin)) || (TextUtils.isEmpty(paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type")))) {
          continue;
        }
        localBundle.putString("babyq_video_type", paramMessageForShortVideo.getExtInfoFromExtStr("guide_video_type"));
        localBundle.putBoolean("extra.ENTER_NEW_GALLERY", true);
        bilx.a(paramContext, localBundle, new AIOImageProviderService(paramView, paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo), agem.a(paramMessageForShortVideo), 13007, j);
        if (!paramMessageForShortVideo.isSend()) {
          new axot(BaseApplication.getContext()).a(paramQQAppInterface, 2001, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString, 1001);
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
  
  private void a(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramMessageForShortVideo.isSend()) {
      new axot(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
    }
    a(paramMessageForShortVideo, alpo.a(2131714432) + paramString2);
    a(paramafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, paramString2, paramString1, paramMessageForShortVideo, paramInt1, paramInt2);
    if ((xlh.a(paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) && (!bdan.a().a(paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video")))
    {
      bdan.a().a(paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_video");
      wta.a("aio_msg", "play_msg_video", 0, 0, new String[] { "", "", "", xlh.a((MessageForShortVideo)paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage) });
    }
    if (!bdcs.b(paramString1))
    {
      a(paramMessageForShortVideo);
      a(paramMessageForShortVideo, "getBubbleView: Video file exist and status finish. Thumb not exist.");
    }
  }
  
  private void a(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramMessageForShortVideo);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
      ajxz localajxz = new ajxz(paramMessageForShortVideo.mThumbFilePath, paramMessageForShortVideo.thumbMD5, null, paramMessageForShortVideo.thumbWidth, paramMessageForShortVideo.thumbHeight);
      localObject = new ajxt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (String)localObject, paramMessageForShortVideo.mediacodecEncode, localajxz, paramMessageForShortVideo);
      ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), localObject);
      ((ajxt)localObject).a(this.jdField_a_of_type_Ajxy);
      ((ajxt)localObject).a(false);
      Utils.executeAsyncTaskOnSerialExcuter((AsyncTask)localObject, new Void[] { (Void)null });
      ThreadManager.getUIHandler().post(new ShortVideoRealItemBuilder.12(this, paramBoolean1, paramafwt, paramMessageForShortVideo, paramBoolean2));
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
  
  private void a(boolean paramBoolean, CropBubbleVideoView paramCropBubbleVideoView, MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (a(paramCropBubbleVideoView, paramString1))
    {
      a(paramMessageForShortVideo, alpo.a(2131714408) + paramString1);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      paramString1 = URLDrawable.getDrawable(new File(paramString1), localURLDrawableOptions);
      paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
      paramafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(paramString1);
    }
    if ((bdcs.b(paramString2)) || ((paramMessageForShortVideo.isSend()) && (paramMessageForShortVideo.md5 == null) && (paramMessageForShortVideo.videoFileStatus == 1004)))
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
        b(paramMessageForShortVideo, paramafwt, 2131719269);
      }
      do
      {
        return;
        if ((!ShortVideoUtils.a()) || (!paramBoolean))
        {
          c(paramMessageForShortVideo, paramafwt);
          return;
        }
      } while (paramMessageForShortVideo.videoFileStatus == 1003);
      if (ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) <= 60) {}
      for (paramInt1 = 1; (paramMessageForShortVideo.busiType == 1) && (paramInt1 != 0); paramInt1 = 0)
      {
        if (paramMessageForShortVideo.progress > 60) {
          paramMessageForShortVideo.progress = 60;
        }
        a(paramMessageForShortVideo, paramafwt, paramMessageForShortVideo.videoFileProgress, paramMessageForShortVideo.progress);
        return;
      }
      a(paramMessageForShortVideo, paramafwt, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    if (paramMessageForShortVideo.videoFileStatus == 2005) {
      c(paramMessageForShortVideo, paramafwt);
    }
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, alpo.a(2131714423));
      b(paramMessageForShortVideo, paramafwt, 2131719264);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForShortVideo, true))
    {
      a(paramMessageForShortVideo, true);
      return;
    }
    if ((paramMessageForShortVideo.videoFileStatus == 2001) || (paramMessageForShortVideo.videoFileStatus == 2002) || (paramMessageForShortVideo.videoFileStatus == 2000))
    {
      a(paramMessageForShortVideo, paramafwt, paramMessageForShortVideo.videoFileProgress, false);
      return;
    }
    c(paramMessageForShortVideo, paramafwt);
  }
  
  private boolean a(afwt paramafwt)
  {
    boolean bool2 = true;
    if ((paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForShortVideo)) {}
    for (MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage;; localMessageForShortVideo = null)
    {
      if (localMessageForShortVideo == null) {
        return false;
      }
      int j;
      int k;
      if ((localMessageForShortVideo.videoFileStatus == 998) || (localMessageForShortVideo.videoFileStatus == 1002) || (localMessageForShortVideo.videoFileStatus == 1001))
      {
        j = 1;
        if ((localMessageForShortVideo.isMultiMsg) || (localMessageForShortVideo.uiOperatorFlag == 2) || (localMessageForShortVideo.busiType != 1) || (!localMessageForShortVideo.isSendFromLocal()) || (paramafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.a())) {
          break label204;
        }
        k = 1;
        label110:
        if (QLog.isColorLevel())
        {
          paramafwt = new StringBuilder().append("shortVideoCancel needShowPauseIcon seq:").append(localMessageForShortVideo.uniseq).append(", videostatus:").append(localMessageForShortVideo.videoFileStatus).append(", iconshow:");
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
  
  private boolean a(afwt paramafwt, MessageForShortVideo paramMessageForShortVideo, int paramInt1, int paramInt2, CropBubbleVideoView paramCropBubbleVideoView)
  {
    if ((TextUtils.isEmpty(paramMessageForShortVideo.md5)) && (paramMessageForShortVideo.videoFileStatus != 1005) && (paramMessageForShortVideo.extraflag != 32768) && (paramMessageForShortVideo.videoFileStatus != 1004))
    {
      Object localObject2;
      Object localObject1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        localObject2 = paramMessageForShortVideo.mThumbFilePath;
        localObject1 = localObject2;
        if (bdcs.b((String)localObject2)) {
          break label119;
        }
        if (!TextUtils.isEmpty(paramMessageForShortVideo.thumbMD5)) {
          break label107;
        }
        paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
        paramCropBubbleVideoView.showCover(baul.a());
        a(paramafwt);
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
            localObject1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
            if (a(paramCropBubbleVideoView, (String)localObject1))
            {
              localObject2 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramInt1;
              ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramInt2;
              localObject1 = URLDrawable.getDrawable(new File((String)localObject1), (URLDrawable.URLDrawableOptions)localObject2);
              paramCropBubbleVideoView.setID(paramMessageForShortVideo.uniseq);
              paramCropBubbleVideoView.showCover((Drawable)localObject1);
              paramafwt = new WeakReference(paramafwt);
              if (paramMessageForShortVideo.busiType == 1)
              {
                if (paramMessageForShortVideo.progressTask == null)
                {
                  paramMessageForShortVideo.progressTask = new ShortVideoRealItemBuilder.1(this, paramMessageForShortVideo, paramafwt);
                  this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.progressTask);
                  this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.progressTask);
                }
                if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq == paramMessageForShortVideo.uniseq) || (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq))))) {
                  break label391;
                }
              }
              for (paramInt1 = 1;; paramInt1 = 0)
              {
                if ((paramMessageForShortVideo.mPreUpload) || (!TextUtils.isEmpty(paramMessageForShortVideo.md5)) || (paramInt1 == 0) || (paramMessageForShortVideo.busiType != 1)) {
                  break label394;
                }
                if (jdField_h_of_type_Boolean) {
                  break label396;
                }
                a(paramMessageForShortVideo, null, false, true);
                return true;
                if (paramMessageForShortVideo.mShowProgressTask == null) {
                  paramMessageForShortVideo.mShowProgressTask = new ShortVideoRealItemBuilder.2(this, paramafwt, paramMessageForShortVideo);
                }
                this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(paramMessageForShortVideo.mShowProgressTask);
                this.jdField_b_of_type_AndroidOsHandler.post(paramMessageForShortVideo.mShowProgressTask);
                break;
              }
            }
          }
        } while (jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramMessageForShortVideo.uniseq)));
        jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramMessageForShortVideo.uniseq), paramMessageForShortVideo);
      } while (!QLog.isColorLevel());
      label391:
      label394:
      label396:
      QLog.i("ShortVideoRealItemBuilder", 2, "messageMap size:" + jdField_a_of_type_JavaUtilMap.size() + ", [" + paramMessageForShortVideo.uniseq + "] added, mEncoding:" + jdField_h_of_type_Boolean);
      return true;
    }
    return false;
  }
  
  private boolean a(MessageForShortVideo paramMessageForShortVideo)
  {
    ault localault = (ault)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(324);
    if (localault != null)
    {
      paramMessageForShortVideo = localault.a(localault.a(paramMessageForShortVideo));
      if ((paramMessageForShortVideo != null) && (QLog.isColorLevel())) {
        QLog.d("ShortVideoRealItemBuilder", 2, "isVideoInMultiSaving = true");
      }
      return paramMessageForShortVideo != null;
    }
    return false;
  }
  
  private void b(afwt paramafwt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if ((paramafwt != null) && (paramafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout != null))
    {
      if (paramBoolean) {
        a(paramafwt, false, null);
      }
      paramafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(paramBoolean, paramOnClickListener);
    }
  }
  
  private boolean b(MessageForShortVideo paramMessageForShortVideo)
  {
    return azqe.a().a(this.jdField_a_of_type_AndroidContentContext, 2, paramMessageForShortVideo.istroop);
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
  
  public aels a(View paramView)
  {
    return null;
  }
  
  public aelt a()
  {
    return new afwt(this);
  }
  
  public afwt a(long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetListView != null) && (paramLong > 0L))
    {
      int j = aekt.a(paramLong, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
      int k = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int n = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      if (j <= -1) {
        break label223;
      }
      Object localObject = aekt.a(this.jdField_a_of_type_ComTencentWidgetListView, j);
      if (localObject != null)
      {
        localObject = aekt.a((View)localObject);
        if ((localObject != null) && ((localObject instanceof afwt))) {
          return (afwt)localObject;
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
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    a(paramChatMessage, paramView, this);
    a((afwt)paramView.getTag(), paramView);
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    afwt localafwt = (afwt)paramaelt;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Resources localResources = localContext.getResources();
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramChatMessage;
    paramaelt = ShortVideoUtils.a(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
    int j = paramaelt[0];
    int k = paramaelt[1];
    boolean bool = localMessageForShortVideo.isSend();
    paramaelt = paramView;
    if (paramView == null)
    {
      paramaelt = new RelativeLayout(localContext);
      paramView = (CropBubbleVideoView)awwq.a(this.jdField_a_of_type_AndroidContentContext, localMessageForShortVideo.uniseq, null, bool);
      paramView.setId(2131362258);
      paramView.setVisibility(0);
      paramView.setContentDescription(alpo.a(2131714456));
      paramaelt.addView(paramView);
      MessageProgressView localMessageProgressView = new MessageProgressView(localContext);
      paramaelt.addView(localMessageProgressView);
      ImageView localImageView = new ImageView(localContext);
      localImageView.setImageResource(2130837945);
      localImageView.setVisibility(8);
      Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131362258);
      ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131362258);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = aekt.a(10.0F, localResources);
      ((RelativeLayout.LayoutParams)localObject1).rightMargin = aekt.a(10.0F, localResources);
      paramaelt.addView(localImageView, (ViewGroup.LayoutParams)localObject1);
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet.add(paramView);
      localObject1 = new LinearLayout(localContext);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setGravity(17);
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      paramaelt.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(localContext);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = aekt.a(70.0F, localResources);
      ((TextView)localObject2).setTextColor(-1);
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((TextView)localObject2).setId(2131364211);
      ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
      paramaelt.setOnClickListener(this);
      super.a(paramaelt, paramaeov);
      localafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView = paramView;
      localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = localMessageProgressView;
      localafwt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject2);
      localafwt.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    }
    paramView = localafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView;
    if (jdField_e_of_type_Boolean) {
      paramView.setContentDescription(alpo.a(2131714418));
    }
    localafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setMiniAioShieldItemTouchListener(this);
    paramView.mIsSend = localMessageForShortVideo.isSend();
    paramView.setTag(Long.valueOf(localMessageForShortVideo.uniseq));
    bdan.a().a(Long.valueOf(localMessageForShortVideo.uniseq), localMessageForShortVideo);
    localafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(15.0F, true);
    localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(true);
    localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setSharpCornerCor(BubbleImageView.a);
    localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setCornerDirection(localMessageForShortVideo.isSend());
    localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramChatMessage.frienduin + paramChatMessage.uniseq);
    if ((localMessageForShortVideo.fileType == 6) || (localMessageForShortVideo.fileType == 17) || (localMessageForShortVideo.fileType == 9) || (localMessageForShortVideo.fileType == 20))
    {
      if ((localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003)) {
        b(localafwt);
      }
    }
    else
    {
      localafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramaeov = localafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getLayoutParams();
      if (paramaeov != null) {
        break label1018;
      }
      paramaeov = new RelativeLayout.LayoutParams(j, k);
      localafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaeov);
      label667:
      paramaeov = localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.getLayoutParams();
      if (paramaeov != null) {
        break label1065;
      }
      paramaeov = new RelativeLayout.LayoutParams(j, k);
      localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramaeov);
      label705:
      if (paramBaseChatItemLayout != null)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage, this);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseChatItemLayout, localafwt, paramChatMessage);
          azey.a(paramaelt, localafwt, paramChatMessage, localContext);
        }
      }
      if (!bdan.a().a(localMessageForShortVideo, "0X8007428"))
      {
        bdan.a().a(localMessageForShortVideo, "0X8007428");
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007428", "0X8007428", 0, 0, "", "", "", "");
      }
      if ((localMessageForShortVideo.CheckIsHotVideo()) && (!bdan.a().a(localMessageForShortVideo, "0X8007EDB")))
      {
        bdan.a().a(localMessageForShortVideo, "0X8007EDB");
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007EDB", "0X8007EDB", 0, 0, "", "", "", "");
      }
      int m = Math.max(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      int n = Math.min(localMessageForShortVideo.thumbWidth, localMessageForShortVideo.thumbHeight);
      if ((!jdField_f_of_type_Boolean) || (m < jdField_c_of_type_Int) || (n < jdField_d_of_type_Int)) {
        break label1127;
      }
      paramChatMessage = (RelativeLayout.LayoutParams)localafwt.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      if (!bool) {
        break label1112;
      }
      paramChatMessage.rightMargin = aekt.a(8.0F + localafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.getTriaWidth(), localResources);
      label979:
      localafwt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (!a(localafwt, localMessageForShortVideo, j, k, paramView)) {
        break label1140;
      }
      return paramaelt;
      localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      break;
      label1018:
      if ((paramaeov.width == j) && (paramaeov.height == k)) {
        break label667;
      }
      paramaeov.width = j;
      paramaeov.height = k;
      localafwt.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setLayoutParams(paramaeov);
      break label667;
      label1065:
      if ((paramaeov.width == j) && (paramaeov.height == k)) {
        break label705;
      }
      paramaeov.width = j;
      paramaeov.height = k;
      localafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setLayoutParams(paramaeov);
      break label705;
      label1112:
      paramChatMessage.rightMargin = aekt.a(8.0F, localResources);
      break label979;
      label1127:
      localafwt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    label1140:
    paramChatMessage = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
    paramBaseChatItemLayout = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    bool = b(localMessageForShortVideo);
    if ((bool) && (bdcs.b(paramBaseChatItemLayout)) && ((!localMessageForShortVideo.isSendFromLocal()) || (localMessageForShortVideo.videoFileStatus == 1003) || (localMessageForShortVideo.videoFileStatus == 2003) || (localMessageForShortVideo.isMultiMsg == true)))
    {
      a(localMessageForShortVideo, localafwt, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaelt;
    }
    if (bdcs.b(paramChatMessage))
    {
      a(bool, paramView, localMessageForShortVideo, localafwt, paramChatMessage, paramBaseChatItemLayout, j, k);
      return paramaelt;
    }
    if (localMessageForShortVideo.videoFileStatus == 5002)
    {
      a(localMessageForShortVideo, alpo.a(2131714449));
      paramView.setID(localMessageForShortVideo.uniseq);
      paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
      b(localMessageForShortVideo, localafwt, 2131719264);
      return paramaelt;
    }
    a(localMessageForShortVideo, alpo.a(2131714470));
    paramView.setID(localMessageForShortVideo.uniseq);
    paramView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    a(localMessageForShortVideo);
    return paramaelt;
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    int m = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramaemk = (afwt)paramaemk;
    b(parambdkz, this.jdField_a_of_type_AndroidContentContext);
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
        if (bdcs.b(str)) {
          if ((paramaemk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c == null) || (paramaemk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() != 0)) {
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
        parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
        k = m;
        if (bdcs.b(paramChatMessage)) {
          k = 1;
        }
      }
      if (k != 0) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      return parambdkz;
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return alpo.a(2131714471);
  }
  
  public String a(MessageForShortVideo paramMessageForShortVideo)
  {
    paramMessageForShortVideo = paramMessageForShortVideo.mVideoFileSourceDir + File.separator + "configure.txt";
    if (!bdcs.b(paramMessageForShortVideo))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoRealItemBuilder", 2, "configure file empty!");
      }
      return null;
    }
    try
    {
      paramMessageForShortVideo = bdcs.b(new File(paramMessageForShortVideo));
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
            MessageForShortVideo localMessageForShortVideo = bdan.a().a(Integer.valueOf(((CropBubbleVideoView)localObject2).getId()));
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
      if (paramInt != 2131365069) {
        break label77;
      }
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo);
      wta.a("story_grp", "press_msg", 0, 0, new String[] { "4", "", "", "" });
    }
    label77:
    do
    {
      do
      {
        return;
        if (paramInt == 2131370842)
        {
          super.d(paramChatMessage);
          wta.a("story_grp", "press_msg", 0, 0, new String[] { "5", "", "", "" });
          return;
        }
        if (paramInt == 2131366750)
        {
          paramInt = awez.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin);
          if (paramInt == 3) {
            paramContext = "1";
          }
          for (;;)
          {
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005624", "0X8005624", 0, 0, paramContext, "", "", "");
            wta.a("story_grp", "press_msg", 0, 0, new String[] { "1", "", "", "" });
            b(localMessageForShortVideo);
            if (!paramChatMessage.isMultiMsg) {
              break;
            }
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 5, 0, "5", "", "", "");
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
        if (paramInt != 2131366015) {
          break;
        }
        biqt.a(localMessageForShortVideo).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage).a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, 0, paramChatMessage.istroop);
        birh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, 5);
        wta.a("story_grp", "press_msg", 0, 0, new String[] { "2", "", "", "" });
      } while (!paramChatMessage.isMultiMsg);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 5, 0, "5", "", "", "");
      return;
      if (paramInt == 2131370799)
      {
        super.a(localMessageForShortVideo);
        wta.a("story_grp", "press_msg", 0, 0, new String[] { "3", "", "", "" });
        return;
      }
      if (paramInt == 2131365029)
      {
        paramContext = new StringBuilder();
        paramContext.append("uniseq:").append(localMessageForShortVideo.uniseq).append("\n");
        Toast.makeText(this.jdField_a_of_type_AndroidContentContext, paramContext.toString(), 1).show();
        return;
      }
      if (paramInt != 2131370902) {
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
    azmj.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 1, 0, "", "", "", "");
    return;
    label664:
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(afwt paramafwt)
  {
    if (!paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      paramafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[hideProgress] set mProgressView gone");
      }
      return;
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new afwq(this, paramafwt));
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = (afwt)aekt.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!localMessageForShortVideo.isSendFromLocal()) {}
    do
    {
      return;
      bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidContentContext, null);
      localbhpy.a(2131690042, 5);
      localbhpy.c(2131690648);
      localbhpy.a(new afwp(this, localMessageForShortVideo, paramView, localbhpy));
      localbhpy.show();
    } while (localMessageForShortVideo.videoFileStatus != 1004);
    ShortVideoUtils.c("0X800A7EF", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, baoj parambaoj, int paramInt1, int paramInt2)
  {
    paramView = aekt.a(paramView);
    if (!(paramView instanceof afwt)) {}
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
                  paramView = (afwt)paramView;
                  localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
                } while (localMessageForShortVideo.uniseq != parambaoj.jdField_b_of_type_Long);
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
                j = aekt.a(paramInt1, (Resources)localObject);
                k = aekt.a(paramInt2, (Resources)localObject);
                if ((parambaoj.jdField_b_of_type_Int != 6) && (parambaoj.jdField_b_of_type_Int != 17) && (parambaoj.jdField_b_of_type_Int != 9) && (parambaoj.jdField_b_of_type_Int != 20)) {
                  break label1335;
                }
                switch (parambaoj.jdField_d_of_type_Int)
                {
                default: 
                  return;
                case 1001: 
                  a(localMessageForShortVideo, "VIDEO STATUS_SEND_START progress " + localMessageForShortVideo.videoFileProgress);
                  if (localMessageForShortVideo.busiType != 1) {
                    a(localMessageForShortVideo, paramView, localMessageForShortVideo.videoFileProgress, true);
                  }
                  paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, this);
                  ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
                  return;
                  paramInt1 = 100;
                  break label96;
                }
              }
              a(paramView, false, null);
              ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              a(localMessageForShortVideo, "VIDEO STATUS_UPLOAD_FINISHED progress " + localMessageForShortVideo.videoFileProgress);
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_FINISHED");
              c(localMessageForShortVideo);
              a(localMessageForShortVideo.mVideoFileSourceDir);
              a(localMessageForShortVideo, paramView, 100, true);
              a(paramView, false, null);
              ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_ERROR");
              c(localMessageForShortVideo);
              b(localMessageForShortVideo, paramView, 2131719269);
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
              return;
              a(localMessageForShortVideo, "VIDEO STATUS_SEND_CANCEL");
              paramView.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
              c(localMessageForShortVideo);
              a(paramView);
              b(localMessageForShortVideo, paramView, 2131719269);
              b(paramView, true, this);
              ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localMessageForShortVideo.uniseq));
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
              parambaoj = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
              a(localMessageForShortVideo, alpo.a(2131714453) + parambaoj);
              if ((ShortVideoUtils.a()) && (bdcs.b(parambaoj)))
              {
                a(localMessageForShortVideo, alpo.a(2131714465) + parambaoj);
                localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
                a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambaoj, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
                if (!localMessageForShortVideo.isSend()) {
                  new axot(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2001, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1002);
                }
              }
              a(localMessageForShortVideo, paramView, 100, true);
            } while (!localMessageForShortVideo.isMultiMsg);
            a(paramView);
            return;
            parambaoj = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
            if ((bdcs.b(parambaoj)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambaoj)))
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
              ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = k;
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
              parambaoj = URLDrawable.getDrawable(new File(parambaoj), (URLDrawable.URLDrawableOptions)localObject);
              paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
              paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(parambaoj);
            }
            c(localMessageForShortVideo, paramView);
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_FILE_UNSAFE");
            b(localMessageForShortVideo, paramView, 2131719263);
            if (localMessageForShortVideo.uiOperatorFlag == 2)
            {
              paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
              QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720101, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
              return;
            }
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720126, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            return;
            a(localMessageForShortVideo, "VIDEO STATUS_RECV_ERROR");
            a(paramView);
            c(localMessageForShortVideo, paramView);
          } while (parambaoj.jdField_g_of_type_Int == -5100528);
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131720128, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_FILE_EXPIRED");
          parambaoj = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          if ((bdcs.b(parambaoj)) && (a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambaoj)))
          {
            a(localMessageForShortVideo, alpo.a(2131714431) + parambaoj);
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
            parambaoj = URLDrawable.getDrawable(new File(parambaoj), (URLDrawable.URLDrawableOptions)localObject);
            paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
            paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(parambaoj);
          }
          b(localMessageForShortVideo, paramView, 2131719264);
          return;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_CANCEL");
          return;
          paramInt1 = localMessageForShortVideo.videoFileProgress;
          a(localMessageForShortVideo, "VIDEO STATUS_RECV_PROCESS " + paramInt1);
          a(localMessageForShortVideo, paramView, paramInt1, true);
          return;
        } while ((parambaoj.jdField_b_of_type_Int != 7) && (parambaoj.jdField_b_of_type_Int != 18) && (parambaoj.jdField_b_of_type_Int != 16));
        switch (parambaoj.jdField_d_of_type_Int)
        {
        default: 
          return;
        case 2001: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_START");
          return;
        case 2003: 
          a(localMessageForShortVideo, "THUMB STATUS_RECV_FINISHED");
          localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
          parambaoj = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
          if ((!bdcs.b(parambaoj)) || (!b(localMessageForShortVideo))) {
            break label1519;
          }
          a(localMessageForShortVideo, alpo.a(2131714425) + (String)localObject);
        }
      } while (!ShortVideoUtils.a());
      a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambaoj, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      return;
      if (!bdcs.b((String)localObject)) {
        break;
      }
    } while (!a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, (String)localObject));
    label1335:
    label1519:
    a(localMessageForShortVideo, alpo.a(2131714413) + (String)localObject);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = j;
    localURLDrawableOptions.mRequestHeight = k;
    localURLDrawableOptions.mLoadingDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mFailedDrawable = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    Object localObject = URLDrawable.getDrawable(new File((String)localObject), localURLDrawableOptions);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover((Drawable)localObject);
    if (!bdcs.b(parambaoj))
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
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
    paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(baul.a());
    return;
    a(localMessageForShortVideo, "THUMB STATUS_FILE_EXPIRED");
    a(localMessageForShortVideo, "THUMB STATUS_RECV_ERROR");
    parambaoj = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
    if (bdcs.b(parambaoj))
    {
      a(localMessageForShortVideo, alpo.a(2131714410) + parambaoj);
      if (ShortVideoUtils.a())
      {
        localObject = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
        a(paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView, parambaoj, (String)localObject, localMessageForShortVideo, paramInt1, paramInt2);
      }
    }
    for (;;)
    {
      a(paramView);
      return;
      paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.setID(localMessageForShortVideo.uniseq);
      paramView.jdField_a_of_type_ComTencentMobileqqVideoplatformViewCropBubbleVideoView.showCover(jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296300);
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.jdField_g_of_type_Int, j, BaseChatItemLayout.jdField_h_of_type_Int);
      return;
    }
    paramView.setPadding(j, BaseChatItemLayout.jdField_g_of_type_Int, BaseChatItemLayout.j, BaseChatItemLayout.jdField_h_of_type_Int);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatItemLayout paramBaseChatItemLayout, afwt paramafwt, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType != LocalMediaInfo.REDBAG_TYPE_GET) {
        break label108;
      }
      if (paramafwt.jdField_e_of_type_Int != LocalMediaInfo.REDBAG_TYPE_GET) {
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
        paramafwt.jdField_e_of_type_Int = LocalMediaInfo.REDBAG_TYPE_GET;
        paramQQAppInterface = new afwm(this, paramQQAppInterface);
        paramafwt = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720104));
        paramafwt.setSpan(new ForegroundColorSpan(-1), 0, paramafwt.length(), 17);
        paramBaseChatItemLayout.setTailMessage(true, paramafwt, paramQQAppInterface, azey.a());
        return;
        if ((!paramMessageRecord.CheckIsDanceVideo()) || (!azbu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
          break;
        }
      } while (paramafwt.jdField_e_of_type_Int == 2);
      paramafwt.jdField_e_of_type_Int = 2;
      boolean bool3 = axld.a();
      boolean bool4 = azgr.g(paramQQAppInterface);
      paramQQAppInterface = new afwn(this, bool3, bool4, paramQQAppInterface);
      paramafwt = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720092));
      paramafwt.setSpan(new ForegroundColorSpan(-1), 0, paramafwt.length(), 17);
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (bool4) {
          bool1 = true;
        }
      }
      paramBaseChatItemLayout.setTailMessage(true, paramafwt, paramQQAppInterface, bool1);
      return;
    } while (paramafwt.jdField_e_of_type_Int == 0);
    paramafwt.jdField_e_of_type_Int = 0;
    paramBaseChatItemLayout.setTailMessage(false, null, null);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (a(paramMessageForShortVideo)) {
      return;
    }
    ayzo localayzo = ayyu.a(2, 2);
    ayyx localayyx = paramMessageForShortVideo.getDownloadInfo(localayzo.jdField_b_of_type_Int);
    localayyx.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localayyx.a(paramMessageForShortVideo.istroop, 1);
    localayyx.jdField_f_of_type_Int = 2;
    localayyx.jdField_g_of_type_Int = 2;
    localayzo.a(localayyx);
    localayzo.a(paramMessageForShortVideo);
    ayyu.a(localayzo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong)
  {
    if ((paramMessageForShortVideo != null) && (!bdan.a().a(paramMessageForShortVideo, "0X8009AA6")))
    {
      bdan.a().a(paramMessageForShortVideo, "0X8009AA6");
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForShortVideo.frienduin, 1, 2, paramMessageForShortVideo.videoFileTime * 1000, paramLong);
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt)
  {
    a(paramMessageForShortVideo, "startUploadVideo：" + paramMessageForShortVideo.toString());
    Object localObject = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    String str = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    if (!bdcs.b((String)localObject))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720133, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!bdcs.b(str))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720134, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
    localObject = ayyu.a(1, 2);
    ((ayzo)localObject).a(ayyu.a(2, paramMessageForShortVideo, (ayzo)localObject));
    ayyu.a((ayzo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(paramMessageForShortVideo, paramafwt, paramMessageForShortVideo.videoFileProgress, true);
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, int paramInt)
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
    a(paramMessageForShortVideo, paramafwt, paramInt, true);
  }
  
  protected void a(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, int paramInt1, int paramInt2)
  {
    if ((ShortVideoUtils.a(paramMessageForShortVideo.videoFileProgress, 10) > 60) || (paramInt2 > 60)) {}
    do
    {
      return;
      paramInt2 = ShortVideoUtils.a(paramInt2, 0);
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt2, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
      paramafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((paramMessageForShortVideo.progressTask != null) && (bdee.d(this.jdField_a_of_type_AndroidContentContext)))
      {
        paramMessageForShortVideo.progress += 3;
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(paramMessageForShortVideo.progressTask, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt1 + ", progress:" + paramInt2);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, int paramInt, boolean paramBoolean)
  {
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(paramInt, paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[setProgress] uinseq:" + paramMessageForShortVideo.uniseq + ", p:" + paramInt);
    }
  }
  
  void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    if (paramMessageForShortVideo.videoFileStatus == 5002)
    {
      a(paramMessageForShortVideo, alpo.a(2131714430));
      return;
    }
    ayzo localayzo = ayyu.a(2, 2);
    ayyx localayyx = paramMessageForShortVideo.getDownloadInfo(localayzo.jdField_b_of_type_Int);
    localayyx.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
    localayyx.a(paramMessageForShortVideo.istroop, 0);
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localayyx.jdField_f_of_type_Int = j;
      localayyx.jdField_g_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoRealItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + localayyx.jdField_e_of_type_Int + ", uniseq:" + paramMessageForShortVideo.uniseq);
      }
      localayzo.a(localayyx);
      localayzo.a(paramMessageForShortVideo);
      ayyu.a(localayzo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      ((VideoPlayParam)localObject).mSceneName = awwr.a(100);
      ((VideoPlayParam)localObject).mIsMute = true;
      ((VideoPlayParam)localObject).mCallback = new afwo(this);
      ((VideoPlayParam)localObject).mIsLocal = true;
      ((VideoPlayParam)localObject).mIsLoop = true;
      ((VideoPlayParam)localObject).mVideoPath = paramString1;
      ((VideoPlayParam)localObject).mFileSize = paramMessageForShortVideo.videoFileSize;
      paramCropBubbleVideoView.setVideoParam((VideoPlayParam)localObject);
      paramString1 = new apgg(-10065297, 100, 100);
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
      if ((paramBaseChatItemLayout instanceof bamw))
      {
        if (((bamw)paramBaseChatItemLayout).c() == 1005L) {}
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
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    paramView = (afwt)aekt.a(paramView);
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (localMessageForShortVideo != null)
    {
      if (!localMessageForShortVideo.isMultiMsg) {
        break label48;
      }
      a(localbdkz, localMessageForShortVideo, paramView);
    }
    for (;;)
    {
      return localbdkz.a();
      label48:
      b(localbdkz, localMessageForShortVideo, paramView);
    }
  }
  
  public void a_(ChatMessage paramChatMessage)
  {
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A5A7", "0X800A5A7", 0, 0, "3", "", "", "");
  }
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    int n = 1;
    int k = 0;
    int j = 0;
    paramChatMessage = (MessageForShortVideo)paramChatMessage;
    paramaemk = (afwt)paramaemk;
    b(parambdkz, this.jdField_a_of_type_AndroidContentContext);
    int m;
    label160:
    int i1;
    if ((!TextUtils.isEmpty(paramChatMessage.md5)) && ((!paramChatMessage.mPreUpload) || (!TextUtils.isEmpty(paramChatMessage.mLocalMd5))))
    {
      String str1 = ShortVideoUtils.a(paramChatMessage.thumbMD5, "jpg");
      String str2 = ShortVideoUtils.a(paramChatMessage, "mp4");
      if (bdcs.b(str1)) {
        if ((paramaemk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c != null) && (paramaemk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.c.getVisibility() == 0))
        {
          m = 1;
          if (m == 0)
          {
            parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
            a(paramChatMessage, parambdkz);
            k = n;
            if (bdcs.b(str2))
            {
              j = 1;
              k = n;
            }
            n = j;
            i1 = k;
            if (m == 0)
            {
              a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatMessage);
              i1 = k;
            }
          }
        }
      }
    }
    for (n = j;; n = k)
    {
      a(parambdkz, paramChatMessage);
      if (n != 0) {
        parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838676);
      }
      if (i1 != 0) {
        b(paramChatMessage, parambdkz);
      }
      super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      super.e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
      return parambdkz;
      k = 0;
      break label160;
      m = 0;
      break;
      i1 = 0;
    }
  }
  
  public void b(afwt paramafwt)
  {
    if (!paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.a(paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramafwt.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)) {
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(8);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoRealItemBuilder", 2, "[disProgress] set mProgressView gone");
      }
      return;
      paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new afwr(this, paramafwt));
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
      if (!TextUtils.isEmpty(paramMessageForShortVideo.templateId))
      {
        localBundle.putString("widgetinfo", paramMessageForShortVideo.templateId);
        localBundle.putString("key_camera_material_name", paramMessageForShortVideo.templateName);
      }
      if (bdcs.b(str2))
      {
        localBundle.putBoolean("k_dataline", true);
        localBundle.putString("forward_extra", str2);
        localBundle.putBoolean("direct_send_if_dataline_forward", true);
        localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      }
      paramMessageForShortVideo = new Intent();
      paramMessageForShortVideo.putExtras(localBundle);
    } while (this.jdField_a_of_type_AndroidContentContext == null);
    arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramMessageForShortVideo, 21);
  }
  
  public void b(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt)
  {
    if (paramMessageForShortVideo == null) {
      return;
    }
    a(paramMessageForShortVideo, "reForwardVideo：" + paramMessageForShortVideo.toString());
    if (!bdcs.b(ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg")))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, 2131720134, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
      paramafwt.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      paramMessageForShortVideo.videoFileStatus = 1005;
      return;
    }
    if (!TextUtils.isEmpty(paramMessageForShortVideo.videoFileName))
    {
      ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageForShortVideo, paramMessageForShortVideo.videoFileName);
      paramafwt = ayyu.a(4, 2);
      paramafwt.a(ayyu.a(2, paramMessageForShortVideo, paramafwt));
      ayyu.a(paramafwt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    a(paramMessageForShortVideo, "ShortVideoRealItemBuilder:reForwardVideo() path is empty");
  }
  
  void b(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt, int paramInt)
  {
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setImageResource(2130849131);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(3);
    if (QLog.isColorLevel()) {
      QLog.w("ShortVideoRealItemBuilder", 2, "[showWarnProgress] set mProgressView visible");
    }
    paramafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramafwt.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
  
  public void c(MessageForShortVideo paramMessageForShortVideo, afwt paramafwt)
  {
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.b(paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(2);
    paramafwt.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    paramafwt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
              if (paramView.getId() != 2131364199) {
                break;
              }
              localObject = (MessageRecord)paramView.getTag();
            } while (localObject == null);
            ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(paramView.getContext(), (MessageRecord)localObject);
            return;
            localObject = (afwt)aekt.a(paramView);
            localMessageForShortVideo = (MessageForShortVideo)((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          } while (paramView.getId() == 2131364213);
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696351, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298914));
            return;
          }
          if (paramView.getId() == 2131364171) {
            a((afwt)localObject, localMessageForShortVideo, false);
          }
          if (paramView.getId() != 2131364190) {
            break;
          }
        } while (((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        if ((!(paramView instanceof ShortVideoUploadProcessor)) || (!((ShortVideoUploadProcessor)paramView).jdField_g_of_type_Boolean)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator BDHSuccess!");
      return;
      localStringBuilder1 = new StringBuilder();
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, ((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      if (!(paramView instanceof ShortVideoUploadProcessor)) {
        break;
      }
      ((ShortVideoUploadProcessor)paramView).c();
      localStringBuilder1.append("\n shortVideoCancel uploadProcess pause!");
      ShortVideoUtils.c("0X800A7EE", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoRealItemBuilder", 2, "shortVideoCancel pauseOperator info:" + localStringBuilder1.toString());
    return;
    ajxt localajxt = (ajxt)ajxt.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq));
    StringBuilder localStringBuilder2 = localStringBuilder1.append("\n shortVideoCancel uniseq:");
    if (localajxt != null)
    {
      paramView = Long.valueOf(localajxt.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      label417:
      paramView = localStringBuilder2.append(paramView).append(", msgUniseq:").append(((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq).append(", encodeFinish:");
      if ((localajxt == null) || (!localajxt.jdField_a_of_type_Boolean)) {
        break label610;
      }
    }
    label610:
    for (boolean bool = true;; bool = false)
    {
      paramView.append(bool);
      if ((localajxt == null) || (localajxt.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq != ((afwt)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) || (!localajxt.a())) {
        break;
      }
      this.jdField_b_of_type_AndroidOsHandler.removeCallbacks(localMessageForShortVideo.progressTask);
      localMessageForShortVideo.progressTask = null;
      localMessageForShortVideo.videoFileStatus = 1004;
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      axso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder
 * JD-Core Version:    0.7.0.1
 */